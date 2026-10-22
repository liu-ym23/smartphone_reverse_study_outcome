package com.bytedance.android.ec.core.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class TexMarginSpan extends ReplacementSpan {
    public final Lazy a;

    public TexMarginSpan() {
        this.a = LazyKt.lazy(TexMarginSpan$fontMetrices$2.INSTANCE);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return (int) r1.measureText(r10, r11, r12);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r17, "paint");
        r17.getFontMetrics((Paint.FontMetrics) this.a.getValue());
        if (r10 == null) goto L8;
        CharSequence r18 = r10.subSequence(r11, r12);
        if (r18 == null) goto L8;
        String r19 = r18.toString();
        if (r19 == null) goto L8;
    L9:
        r1.drawText(r19, r13, r15 - (((Paint.FontMetrics) this.a.getValue()).descent / 2), r17);
        return;
    L8:
        r19 = "";
        goto L9
    }
}
