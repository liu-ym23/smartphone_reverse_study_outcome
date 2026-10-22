package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements LineBackgroundSpan {
    public final float a;
    public final float b;
    public final float c;
    public final Paint d;
    public final RectF e;

    public q(int r1, float r2, float r3, float r4) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        Paint r5 = new Paint(1);
        r5.setColor(r1);
        r5.setStyle(Paint.Style.FILL);
        this.d = r5;
        this.e = new RectF();
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r8, "text");
        if ((r8 instanceof Spanned) == false) goto L5;
        Spanned r12 = (Spanned) r8;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        int r13 = Math.max(r12.getSpanStart(this), r9);
        int r14 = Math.min(r12.getSpanEnd(this), r10);
        if (r13 < r14) goto L11;
        return;
    L11:
        if (r13 <= r9) goto L13;
        float r15 = r2.measureText(r8, r9, r13);
    L14:
        float r16 = r3 + r15;
        float r17 = r16 - this.a;
        float r18 = (r16 + r2.measureText(r8, r13, r14)) + this.a;
        RectF r19 = this.e;
        float r20 = r5;
        float r21 = this.b;
        r19.set(r17, r20 - r21, r18, r7 + r21);
        RectF r22 = this.e;
        float r23 = this.c;
        r1.drawRoundRect(r22, r23, r23, this.d);
        return;
    L13:
        r15 = 0.0f;
        goto L14
    L5:
        r12 = null;
        goto L6
    }
}
