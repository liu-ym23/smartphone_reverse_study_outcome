package com.larus.bmhome.taskskill.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends ReplacementSpan {
    public final Drawable a;

    /* JADX INFO: renamed from: com.larus.bmhome.taskskill.view.a$a, reason: collision with other inner class name */
    public static final class C0037a {
    }

    static {
    }

    public a(Drawable r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        r2.setBounds(0, 0, r3, r3);
        this.a = r2;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        return this.a.getBounds().width();
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        int r10 = r1.save();
        r1.translate(r5, ((r8 + r6) - this.a.getBounds().height()) / 2.0f);     // Catch: Throwable -> L6
        this.a.draw(r1);     // Catch: Throwable -> L6
        r1.restoreToCount(r10);
        return;
    L6:
        th = move-exception;
        r1.restoreToCount(r10);
        throw th;
    }
}
