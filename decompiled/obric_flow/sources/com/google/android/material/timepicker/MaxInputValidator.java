package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes2.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int r5) {
        this.max = r5;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r5, int r10, int r11, Spanned r12, int r13, int r14) {
        StringBuilder r15 = new StringBuilder(r12);     // Catch: NumberFormatException -> L8
        r15.replace(r13, r14, r5.subSequence(r10, r11).toString());     // Catch: NumberFormatException -> L8
        if (Integer.parseInt(r15.toString()) > this.max) goto L6;
        return null;
    L6:
        return "";
    L11:
        return "";
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int r5) {
        this.max = r5;
    }
}
