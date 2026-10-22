package com.bytedance.android.ec.core.toolbox.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends ReplacementSpan {
    public final Paint a;
    public final int b;

    public b(int r1, int r10) {
        this.b = r1;
        Paint r11 = new Paint();
        r11.setColor(r10);
        r11.setStyle(Paint.Style.FILL);
        Unit r12 = Unit.INSTANCE;
        this.a = r11;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return this.b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r18, "paint");
        r10.drawRect(r14, r15, r14 + this.b, r17, this.a);
    }
}
