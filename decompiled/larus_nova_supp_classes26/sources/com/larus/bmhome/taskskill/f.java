package com.larus.bmhome.taskskill;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends ReplacementSpan {
    public final int a;
    public final Drawable b;

    public f(Drawable r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.a = r4;
        r2.setBounds(0, 0, r3, r3);
        this.b = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return this.b.getBounds().width() + (this.a * 2);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        int r10 = r1.save();
        r1.translate(r5 + this.a, ((r8 + r6) - this.b.getBounds().height()) / 2);     // Catch: Throwable -> L6
        this.b.draw(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r10);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r10);
        throw th;
    }
}
