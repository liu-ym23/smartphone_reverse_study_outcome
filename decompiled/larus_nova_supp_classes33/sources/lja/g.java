package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g extends d {
    public final float c;
    public final String d;
    public final float e;

    public /* synthetic */ g() {
        this(0.375f);
    }

    @Override // lja.d
    public String getType() {
        return this.d;
    }

    public g(float r1) {
        this.e = r1;
        this.c = 1.175f;
        this.d = "QuadraticSmoothCornerImpl";
    }

    @Override // lja.d
    public final boolean c(float r2, float r3) {
        if (r2 >= (this.e * r3)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // lja.d
    public final Path a(float r5, float r6, float r7, float r8, float r9) {
        float r0 = Math.min(r7 - r5, r8 - r6);
        if (r9 == 0.0f) goto L10;
        if (r9 >= (this.e * r0)) goto L10;
        float r10 = Math.min(r0 / 2.0f, r9 * this.c);
        float r1 = r6 + r10;
        float r2 = r8 - r10;
        float r3 = r7 - r10;
        float r11 = r10 + r5;
        Path r4 = new Path();
        r4.moveTo(r7, r1);
        r4.lineTo(r7, r2);
        r4.quadTo(r7, r8, r3, r8);
        r4.lineTo(r11, r8);
        r4.quadTo(r5, r8, r5, r2);
        r4.lineTo(r5, r1);
        r4.quadTo(r5, r6, r11, r6);
        r4.lineTo(r3, r6);
        r4.quadTo(r7, r6, r7, r1);
        r4.close();
        return r4;
    L10:
        return d.b(r5, r6, r7, r8, r9);
    }
}
