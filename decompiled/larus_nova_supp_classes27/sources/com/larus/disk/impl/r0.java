package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0 {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public final double g;
    public final double h;
    public final double i;
    public final double j;
    public final boolean k;
    public final boolean l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r9 = (r0) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r9.c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r9.d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.e, r9.e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f, r9.f) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.h, r9.h) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.i, r9.i) == 0) goto L36;
        return false;
    L36:
        if (Double.compare(this.j, r9.j) == 0) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = Double.doubleToLongBits(this.c);
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = Double.doubleToLongBits(this.d);
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = Double.doubleToLongBits(this.e);
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = Double.doubleToLongBits(this.f);
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = Double.doubleToLongBits(this.g);
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = Double.doubleToLongBits(this.h);
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = Double.doubleToLongBits(this.i);
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = Double.doubleToLongBits(this.j);
        int r20 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        int r21 = 1231;
        if (this.k == false) goto L5;
        int r22 = 1231;
    L6:
        int r23 = (r20 + r22) * 31;
        if (this.l == true) goto L11;
        r21 = 1237;
    L11:
        return r23 + r21;
    L5:
        r22 = 1237;
        goto L6
    }

    public final String toString() {
        return "PhoneAndAppDiskInfo(availableInternalSize=" + this.a + ", totalInternalSize=" + this.b + ", availableExternalSize=" + this.c + ", totalExternalSize=" + this.d + ", totalDataSize=" + this.e + ", totalCacheSize=" + this.f + ", internalCacheSize=" + this.g + ", externalCacheSize=" + this.h + ", bizFileCacheSize=" + this.i + ", totalAppCacheSize=" + this.j + ", isAvailableExternal=" + this.k + ", isLowDisk=" + this.l + ')';
    }

    public r0(double r4, double r6, double r8, double r10, double r12, double r14, double r16, double r18, double r20, double r22, boolean r24, boolean r25) {
        this.a = r4;
        this.b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r18;
        this.i = r20;
        this.j = r22;
        this.k = r24;
        this.l = r25;
    }
}
