package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FitTextView extends LiveTextView {
    public Paint c;
    public float d;
    public final float e;

    public FitTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FitTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = 6.0f;
        TextPaint r3 = new TextPaint();
        this.c = r3;
        r3.set(getPaint());
        this.d = getTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.TextView*/.setText(r1, r2);
        y(r1.toString(), getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r4, int r5) {
        if (r5 <= 0) goto L14;
        int r6 = (r5 - getPaddingLeft()) - getPaddingRight();
        float r0 = this.d;
        this.c.setTextSize(r0);
    L5:
        if (this.c.measureText(r4) <= r6) goto L10;
        r0 = r0 - 1.0f;
        float r1 = this.e;
        if (r0 <= r1) goto L8;
        this.c.setTextSize(r0);
        goto L5
    L8:
        r0 = r1;
    L10:
        setTextSize(0, r0);
        return;
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r1 == r3) goto L5;
        y(getText().toString(), r1);
        return;
    }
}
