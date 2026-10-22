package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FitButton extends AppCompatButton {
    public Paint a;
    public float b;
    public final float c;

    public FitButton(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FitButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = 6.0f;
        TextPaint r3 = new TextPaint();
        this.a = r3;
        r3.set(getPaint());
        this.b = getTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r4, int r5) {
        if (r5 <= 0) goto L14;
        int r6 = (r5 - getPaddingLeft()) - getPaddingRight();
        float r0 = this.b;
        this.a.setTextSize(r0);
    L5:
        if (this.a.measureText(r4) <= r6) goto L10;
        r0 = r0 - 1.0f;
        float r1 = this.c;
        if (r0 <= r1) goto L8;
        this.a.setTextSize(r0);
        goto L5
    L8:
        r0 = r1;
    L10:
        setTextSize(0, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.Button*/.setText(r1, r2);
        a(r1.toString(), getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r1 == r3) goto L5;
        a(getText().toString(), r1);
        return;
    }
}
