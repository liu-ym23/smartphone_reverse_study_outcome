package com.bytedance.android.live.openplatform.impl.base.utils.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ReplacementSpan {
    public final Paint a;
    public final int b;

    public a(int r1, int r2) {
        this.b = r1;
        Paint r3 = new Paint();
        r3.setColor(r2);
        r3.setStyle(Paint.Style.FILL);
        Unit r4 = Unit.INSTANCE;
        this.a = r3;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return this.b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r7, CharSequence r8, int r9, int r10, float r11, int r12, int r13, int r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r15, "paint");
        r7.drawRect(r11, r12, r11 + this.b, r14, this.a);
    }
}
