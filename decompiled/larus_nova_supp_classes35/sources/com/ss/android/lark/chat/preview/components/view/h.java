package com.ss.android.lark.chat.preview.components.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends ReplacementSpan {
    public final Paint a;
    public final Drawable b;

    public h(g r2) {
        this.a = new Paint();
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        this.a.set(r2);
        if (r6 == null) goto L6;
        this.a.getFontMetricsInt(r6);
        Rect r7 = this.b.getBounds();
        int r8 = r6.descent - r6.ascent;
        int r9 = ((int) 0.0f) / 2;
        int r10 = r6.top;
        r6.ascent = Math.min(r10, ((r8 - r7.bottom) / 2) + r10) - r9;
        int r11 = r6.bottom;
        int r12 = Math.max(r11, ((r7.bottom - r8) / 2) + r11) + r9;
        r6.descent = r12;
        r6.top = r6.ascent;
        r6.bottom = r12;
    L6:
        return this.b.getBounds().right;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        r1.save();
        r1.translate(r5, ((r8 - this.b.getBounds().bottom) + r6) / 2);
        this.b.draw(r1);
        r1.restore();
    }
}
