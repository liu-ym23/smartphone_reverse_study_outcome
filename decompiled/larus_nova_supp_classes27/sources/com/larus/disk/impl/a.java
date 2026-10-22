package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final long j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
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
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
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
        int r12 = 1231;
        if (this.g == false) goto L5;
        int r13 = 1231;
    L6:
        int r14 = (r11 + r13) * 31;
        if (this.h == false) goto L9;
        int r15 = 1231;
    L10:
        int r16 = (r14 + r15) * 31;
        if (this.i == true) goto L14;
        r12 = 1237;
    L14:
        int r17 = (r16 + r12) * 31;
        long r18 = this.j;
        return r17 + ((int) (r18 ^ (r18 >>> 32)));
    L9:
        r15 = 1237;
        goto L10
    L5:
        r13 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppDiskClearModel(beforeAppUsedSize=" + this.a + ", beforeAppCacheSize=" + this.b + ", afterAppUsedSize=" + this.c + ", afterAppCacheSize=" + this.d + ", totalHandlerSize=" + this.e + ", totalCleanSize=" + this.f + ", isLowDisk=" + this.g + ", isManual=" + this.h + ", isCustomBizClean=" + this.i + ", timeCost=" + this.j + ')';
    }

    public a(double r4, double r6, double r8, double r10, double r12, double r14, boolean r16, boolean r17, boolean r18, long r110) {
        this.a = r4;
        this.b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r110;
    }
}
