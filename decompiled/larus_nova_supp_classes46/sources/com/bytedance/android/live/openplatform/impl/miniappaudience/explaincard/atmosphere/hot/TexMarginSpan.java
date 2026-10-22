package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class TexMarginSpan extends ReplacementSpan {
    public final Lazy a;

    public TexMarginSpan() {
        this.a = LazyKt.lazy(TexMarginSpan$fontMetrics$2.INSTANCE);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return (int) r1.measureText(r2, r3, r4);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        r9.getFontMetrics((Paint.FontMetrics) this.a.getValue());
        if (r2 == null) goto L8;
        CharSequence r10 = r2.subSequence(r3, r4);
        if (r10 == null) goto L8;
        String r11 = r10.toString();
        if (r11 == null) goto L8;
    L9:
        r1.drawText(r11, r5, r7 - (((Paint.FontMetrics) this.a.getValue()).descent / 2), r9);
        return;
    L8:
        r11 = "";
        goto L9
    }
}
