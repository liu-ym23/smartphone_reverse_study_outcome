package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public final Double a;
    public final Double b;
    public final Float c;
    public final Float d;
    public final Double e;
    public final Float f;
    public final Float g;
    public final String h;

    public n() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof n) == true) goto L8;
        return false;
    L8:
        n r11 = (n) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Double r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Double r12 = this.b;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        Float r15 = this.c;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Float r18 = this.d;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Double r21 = this.e;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        Float r24 = this.f;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        Float r27 = this.g;
        if (r27 != null) goto L29;
        int r28 = 0;
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.h;
        if (r30 == null) goto L35;
        r1 = r30.hashCode();
    L35:
        return r29 + r1;
    L29:
        r28 = r27.hashCode();
        goto L30
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocationUpdateResult(latitude=" + this.a + ", longitude=" + this.b + ", speed=" + this.c + ", accuracy=" + this.d + ", altitude=" + this.e + ", verticalAccuracy=" + this.f + ", horizontalAccuracy=" + this.g + ", city=" + this.h + ')';
    }

    public n(Double r1, Double r10, Float r11, Float r12, Double r13, Float r14, Float r15, String r16) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }
}
