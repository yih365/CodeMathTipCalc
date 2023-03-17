package com.example.codemathtipcalc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcButton = findViewById<Button>(R.id.calculateButton)
        val costText = findViewById<EditText>(R.id.costText)
        val percentSpinner = findViewById<Spinner>(R.id.percentSpinner)
        val totalText = findViewById<TextView>(R.id.totalText)

        calcButton.setOnClickListener{
            val tipPercentString = percentSpinner.selectedItem.toString()
            val tipPercent = tipPercentString.substring(0,tipPercentString.length-1).toFloat()
            val costA = costText.text.toString()
            if (costA.count{it=='.'} <= 1) {
                val cost = costA.toFloat()
                val total = cost*((100+tipPercent)/100)
                totalText.text = total.toString()
            }
            Toast.makeText(this, "Invalid input for cost", Toast.LENGTH_SHORT).show()
        }

        percentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                totalText.text = ""
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                totalText.text = ""
            }
        }

        costText.doAfterTextChanged {
            totalText.text = ""
        }
    }
}