package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b extends ImageSpan implements e90.a {
    public final int a;
    public final Drawable b;
    public final int c;
    public final int d;
    public final float e;

    public static final class a {
    }

    static {
    }

    public int a() {
        return 3;
    }

    public boolean b() {
        return this instanceof c;
    }

    public String getDesc() {
        return " ";
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        return this.b;
    }

    public int getType() {
        return this.a;
    }

    public b(Drawable r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "spanDrawable");
        super(r2);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = 1.0f;
        this.a = 1;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        Intrinsics.checkNotNullParameter(r3, "paint");
        Drawable r8 = this.b;
        float r9 = this.e;
        if (r9 <= 0) goto L5;
        r8.setBounds(0, 0, (int) (this.c * r9), (int) (this.d * r9));
    L6:
        Rect r10 = r8.getBounds();
        if (r7 == null) goto L10;
        Paint.FontMetricsInt r11 = r3.getFontMetricsInt();
        int r13 = r11.bottom - r11.top;
        int r14 = (r10.bottom - r10.top) / 2;
        int r15 = r13 / 4;
        int r0 = r14 - r15;
        int r16 = -(r14 + r15);
        r7.ascent = r16;
        r7.top = r16;
        r7.bottom = r0;
        r7.descent = r0;
    L10:
        return (r10.right + 0) + 0;
    L5:
        r8.setBounds(0, 0, this.c, this.d);
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        float r10 = 0;
        float r11 = r5 + r10;
        Drawable r13 = this.b;
        float r14 = this.e;
        if (r14 <= r10) goto L5;
        r13.setBounds(0, 0, (int) (this.c * r14), (int) (this.d * r14));
    L6:
        r1.save();
        Paint.FontMetricsInt r15 = r9.getFontMetricsInt();
        r1.translate(r11, (int) (((((r15.descent + r7) + (r7 + r15.ascent)) / 2) - (r13.getBounds().bottom / 2)) + 0.5f));
        r13.draw(r1);
        r1.restore();
        return;
    L5:
        r13.setBounds(0, 0, this.c, this.d);
        goto L6
    }
}
