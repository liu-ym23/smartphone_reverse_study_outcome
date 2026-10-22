package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final double a;
    public final double b;
    public final String c;
    public final String d;
    public final int e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
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
        if (this.e == r11.e) goto L23;
        return false;
    L23:
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
        String r16 = this.d;
        if (r16 == null) goto L11;
        r13 = r16.hashCode();
    L11:
        return ((r15 + r13) * 31) + this.e;
    L5:
        r14 = r12.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenLocationRequest(latitude=" + this.a + ", longitude=" + this.b + ", name=" + this.c + ", address=" + this.d + ", scale=" + this.e + ')';
    }

    public o(double r1, double r10, String r11, String r12, int r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
