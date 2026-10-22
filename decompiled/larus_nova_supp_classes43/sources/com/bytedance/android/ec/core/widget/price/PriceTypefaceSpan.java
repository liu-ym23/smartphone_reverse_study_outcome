package com.bytedance.android.ec.core.widget.price;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
class PriceTypefaceSpan extends TypefaceSpan {
    public final Typeface a;
    public final boolean b;

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r10) {
        a(r10, this.a, this.b);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r10) {
        a(r10, this.a, this.b);
    }

    public PriceTypefaceSpan(Typeface r10, boolean r11) {
        super("");
        this.a = r10;
        this.b = r11;
    }

    public static void a(Paint r10, Typeface r11, boolean r12) {
        Typeface r0 = r10.getTypeface();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r13 = r1 & (~r11.getStyle());
        if ((r13 & 1) == 0) goto L11;
        if (r12 == false) goto L11;
        r10.setFakeBoldText(true);
    L11:
        if ((r13 & 2) == 0) goto L13;
        r10.setTextSkewX(-0.25f);
    L13:
        r10.getShader();
        r10.setTypeface(r11);
        return;
    L5:
        r1 = r0.getStyle();
        goto L6
    }
}
