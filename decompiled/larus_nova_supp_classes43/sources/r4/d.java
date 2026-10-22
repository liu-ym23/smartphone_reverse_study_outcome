package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final double a;
    public final double b;
    public final String c;
    public final Float d;
    public final Float e;
    public final Boolean f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Double.compare(this.a, r11.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r11.b) == 0) goto L15;
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
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = Double.doubleToLongBits(this.b);
        int r11 = (r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.c;
        int r13 = 0;
        if (r12 != null) goto L5;
        int r14 = 0;
    L6:
        int r15 = (r11 + r14) * 31;
        Float r16 = this.d;
        if (r16 != null) goto L9;
        int r17 = 0;
    L10:
        int r18 = (r15 + r17) * 31;
        Float r19 = this.e;
        if (r19 != null) goto L13;
        int r20 = 0;
    L14:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.f;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        return r21 + r13;
    L13:
        r20 = r19.hashCode();
        goto L14
    L9:
        r17 = r16.hashCode();
        goto L10
    L5:
        r14 = r12.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetLocationResult(latitude=" + this.a + ", longitude=" + this.b + ", timestamp=" + this.c + ", speed=" + this.d + ", accuracy=" + this.e + ", isLightLocation=" + this.f + ')';
    }

    public d(double r1, double r10, String r11, Float r12, Float r13, Boolean r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
