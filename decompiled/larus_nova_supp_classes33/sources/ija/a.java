package ija;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f);
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.c + ", b=" + this.d + ", c=" + this.e + ", d=" + this.f + ')';
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof a) == false) goto L13;
        a r4 = (a) r3;
        if (this.c != r4.c) goto L13;
        if (this.d != r4.d) goto L13;
        if (this.e != r4.e) goto L13;
        if (this.f != r4.f) goto L13;
        return true;
    L13:
        return false;
    }

    public a(float r26, float r27, float r28, float r29) {
        this.c = r26;
        this.d = r27;
        this.e = r28;
        this.f = r29;
        float[] r3 = new float[5];
        int r4 = b.a;
        Intrinsics.checkNotNullParameter(r3, "roots");
        float r5 = (r27 - 0.0f) * 3.0f;
        float r7 = (r29 - r27) * 3.0f;
        float r9 = (1.0f - r29) * 3.0f;
        double r10 = r5;
        double r12 = r7;
        double r14 = r9;
        double r18 = r12 * 2.0d;
        double r20 = (r10 - r18) + r14;
        int r6 = 0;
        if (r20 == 0.0d) goto L13;
        double r15 = -Math.sqrt((r12 * r12) - (r14 * r10));
        double r11 = (-r10) + r12;
        int r13 = b.b((float) ((-(r15 + r11)) / r20), r3, 0) + 0;
        int r16 = b.b((float) ((r15 - r11) / r20), r3, 0 + r13) + r13;
        if (r16 <= 1) goto L16;
        float r17 = r3[0];
        float r19 = r3[1];
        if (r17 <= r19) goto L10;
        r3[0] = r19;
        r3[1] = r17;
        goto L16
    L10:
        if (r17 != r19) goto L16;
        r16 = r16 - 1;
    L16:
        float r110 = (r7 - r5) * 2.0f;
        int r111 = r16 + b.b((-r110) / (((r9 - r7) * 2.0f) - r110), r3, 0 + r16);
        float r8 = Math.min(0.0f, 1.0f);
        float r21 = Math.max(0.0f, 1.0f);
    L17:
        if (r6 >= r111) goto L19;
        float r112 = r3[r6];
        float r113 = (((((((((r27 - r29) * 3.0f) + 1.0f) - 0.0f) * r112) + (((r29 - (r27 * 2.0f)) + 0.0f) * 3.0f)) * r112) + r5) * r112) + 0.0f;
        r8 = Math.min(r8, r113);
        r21 = Math.max(r21, r113);
        r6 = r6 + 1;
        goto L17
    L19:
        jja.a r1 = new jja.a(r8, r21);
        this.a = Float.intBitsToFloat((int) (r1.a >> 32));
        this.b = Float.intBitsToFloat((int) (r1.a & 4294967295L));
        return;
    L13:
        if (r12 == r14) goto L15;
        r16 = b.b((float) ((r18 - r14) / (r18 - (r14 * 2.0d))), r3, 0) + 0;
        goto L16
    L15:
        r16 = 0;
        goto L16
    }
}
