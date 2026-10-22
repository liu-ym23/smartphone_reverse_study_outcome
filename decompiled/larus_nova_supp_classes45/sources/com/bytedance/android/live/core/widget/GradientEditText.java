package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class GradientEditText extends LiveEditText {
    /* JADX WARN: Multi-variable type inference failed */
    private float getMaxLineRight() {
        Layout r0 = getLayout();
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r0.getLineCount()) goto L9;
        r1 = Math.max(r1, r0.getLineRight(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public GradientEditText(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r1) {
        super/*android.widget.EditText*/.onDraw(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int r3) {
        getPaint().setShader(null);
        super/*android.widget.EditText*/.setTextColor(r3);
    }

    public GradientEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        new Matrix();
        c(r2);
    }

    public GradientEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        new Matrix();
    }
}
