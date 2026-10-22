package z29;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final double a;
    public final double b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final a f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r4 = 1231;
        if (this.c == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r2 + r5) * 31;
        if (this.d == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L14;
        r4 = 1237;
    L14:
        int r9 = (r8 + r4) * 31;
        a r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L19:
        return r9 + r11;
    L17:
        r11 = r10.hashCode();
        goto L19
    L9:
        r7 = 1237;
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public final String toString() {
        return "NormalizedMembershipQuotaUsage(usedPercent=" + this.a + ", barPercent=" + this.b + ", lessThanOnePercent=" + this.c + ", exhausted=" + this.d + ", unlimited=" + this.e + ", absoluteUsage=" + this.f + ')';
    }

    public d(double r1, double r3, boolean r5, boolean r6, boolean r7, a r8) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
