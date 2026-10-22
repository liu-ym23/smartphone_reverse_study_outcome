package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class UnCheckRadioButton extends AppCompatRadioButton {
    /* JADX WARN: Multi-variable type inference failed */
    public final void toggle() {
        setChecked(!isChecked());
    }

    public UnCheckRadioButton(Context r1) {
        super(r1);
    }

    public UnCheckRadioButton(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public UnCheckRadioButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
