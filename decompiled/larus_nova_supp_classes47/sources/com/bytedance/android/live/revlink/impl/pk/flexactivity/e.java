package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends ReplacementSpan {
    public final int a;
    public final int b;

    public e(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return (int) (r1.measureText(r2, r3, r4) + 14);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r13, CharSequence r14, int r15, int r16, float r17, int r18, int r19, int r20, Paint r22) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r14, "text");
        Intrinsics.checkNotNullParameter(r22, "paint");
        int r9 = r22.getColor();
        r22.setColor(this.a);
        r13.drawRoundRect(new RectF(r17 + 3, r18 + 1, r17 + ((int) (r22.measureText(r14, r15, r16) + 8)), r20 - 1), 2.0f, 2.0f, r22);
        r22.setColor(this.b);
        r13.drawText(r14, r15, r16, r17 + 7, r19, r22);
        r22.setColor(r9);
    }
}
