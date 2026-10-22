package pob;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends ReplacementSpan {
    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        if (r5 == null) goto L6;
        Math.abs(r5.bottom - r5.top);
        throw null;
    L6:
        throw null;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        r1.save();
        int r10 = (r8 - r6) / 2;
        throw null;
    }
}
