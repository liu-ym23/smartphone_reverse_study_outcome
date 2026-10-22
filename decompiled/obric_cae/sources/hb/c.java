package hb;

import com.qualcomm.qti.qesdk.QesdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f8021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f8022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f8024d;

    public c() {
        this.f8021a = 0.4f;
        this.f8022b = 0.0f;
        this.f8023c = 0.2f;
        this.f8024d = 1.0f;
        float[] r8 = new float[5];
        int r10 = d.f8025a;
        double r11 = 0.0f;
        double r12 = 3.0f;
        double r13 = 0.0f;
        double r14 = r12 * 2.0d;
        double r15 = (r11 - r14) + r13;
        int r16 = 0;
        if (r15 == 0.0d) goto L13;
        double r17 = -Math.sqrt((r12 * r12) - (r13 * r11));
        double r18 = (-r11) + r12;
        int r19 = d.a((float) ((-(r17 + r18)) / r15), r8, 0) + 0;
        int r20 = d.a((float) ((r17 - r18) / r15), r8, r19 + 0) + r19;
        if (r20 <= 1) goto L16;
        float r21 = r8[0];
        float r22 = r8[1];
        if (r21 <= r22) goto L10;
        r8[0] = r22;
        r8[1] = r21;
        goto L16
    L10:
        if (r21 != r22) goto L16;
        r20 = r20 - 1;
    L16:
        int r23 = d.a(0.5f, r8, 0 + r20) + r20;
        float r24 = Math.min(0.0f, 1.0f);
        float r25 = Math.max(0.0f, 1.0f);
    L17:
        if (r16 >= r23) goto L19;
        float r26 = r8[r16];
        float r27 = ((((((-2.0f) * r26) + 3.0f) * r26) + 0.0f) * r26) + 0.0f;
        r24 = Math.min(r24, r27);
        r25 = Math.max(r25, r27);
        r16 = r16 + 1;
        goto L17
    L19:
        long r28 = new ib.a(r24, r25).f8302a;
        Float.intBitsToFloat((int) (r28 >> 32));
        Float.intBitsToFloat((int) (r28 & QesdkUtils.LIMITS.UINT_32_UPPER));
        return;
    L13:
        if (r12 == r13) goto L15;
        r20 = d.a((float) ((r14 - r13) / (r14 - (r13 * 2.0d))), r8, 0) + 0;
        goto L16
    L15:
        r20 = 0;
        goto L16
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof c) == false) goto L13;
        c r10 = (c) r8;
        float r11 = r10.f8021a;
        if (this.f8021a != r11) goto L13;
        if (this.f8022b != r10.f8022b) goto L13;
        if (this.f8023c != r10.f8023c) goto L13;
        if (this.f8024d != r10.f8024d) goto L13;
        return true;
    L13:
        return false;
    }

    public final int hashCode() {
        int r8 = Float.hashCode(this.f8021a) * 31;
        int r10 = (Float.hashCode(this.f8022b) + r8) * 31;
        int r11 = (Float.hashCode(this.f8023c) + r10) * 31;
        return Float.hashCode(this.f8024d) + r11;
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.f8021a + ", b=" + this.f8022b + ", c=" + this.f8023c + ", d=" + this.f8024d + ')';
    }
}
