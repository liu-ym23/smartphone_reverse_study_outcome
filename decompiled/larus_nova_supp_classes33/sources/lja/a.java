package lja;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends d {
    public final String c;

    public a() {
        this.c = "BasicRoundCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.c;
    }

    @Override // lja.d
    public final Path a(float r1, float r2, float r3, float r4, float r5) {
        return d.b(r1, r2, r3, r4, r5);
    }

    @Override // lja.d
    public final void d(Canvas r9, Paint r10, float r11, float r12, float r13, float r14, float r15) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        Intrinsics.checkNotNullParameter(r10, "paint");
        r9.drawRoundRect(r11, r12, r13, r14, r15, r15, r10);
    }
}
