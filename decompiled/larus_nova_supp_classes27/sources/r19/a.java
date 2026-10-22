package r19;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends ReplacementSpan {
    public final float a;
    public final float b;

    public a(float r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return MathKt.roundToInt((r1.measureText(r2, r3, r4) + this.a) + this.b);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r9, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r17, "paint");
        float r6 = (r9.getHeight() / 2.0f) - ((r17.descent() + r17.ascent()) / 2.0f);
        float r5 = r13 + this.a;
        if (r10 != null) goto L5;
        CharSequence r2 = "";
    L6:
        r9.drawText(r2, r11, r12, r5, r6, r17);
        return;
    L5:
        r2 = r10;
        goto L6
    }
}
