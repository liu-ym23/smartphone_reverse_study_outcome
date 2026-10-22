package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends ImageSpan {
    public int a;

    public a(Context r10, Bitmap r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "b");
        super(r10, r11, -1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        Intrinsics.checkNotNullParameter(r10, "text");
        Rect r14 = getDrawable().getBounds();
        if (r13 == null) goto L6;
        int r15 = -r14.bottom;
        r13.ascent = r15;
        r13.descent = 0;
        r13.top = r15;
        r13.bottom = 0;
    L6:
        return r14.right + this.a;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r17, "paint");
        Drawable r18 = getDrawable();
        r1.save();
        int r19 = r16 - r18.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment != 1) goto L5;
        int r20 = r19 - r17.getFontMetricsInt().descent;
    L6:
        r1.translate(r13, r20);
        r18.draw(r1);
        r1.restore();
        return;
    L5:
        Paint.FontMetricsInt r21 = r17.getFontMetricsInt();
        r20 = ((((r21.descent + r15) + r15) + r21.ascent) / 2) - (r18.getBounds().bottom / 2);
        goto L6
    }
}
