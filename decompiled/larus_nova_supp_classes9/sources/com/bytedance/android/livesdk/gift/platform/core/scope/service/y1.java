package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y1 {
    public float a;
    public long b;
    public double c;
    public long d;
    public float e;
    public float f;
    public long g;
    public float h;
    public float i;
    public long j;
    public float k;
    public float l;
    public long m;
    public float n;

    public y1() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof y1) == false) goto L34;
        y1 r7 = (y1) r6;
        if (Float.compare(this.a, r7.a) == 0) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Double.compare(this.c, r7.c) == 0) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r7.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r7.f) == 0) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (Float.compare(this.h, r7.h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r7.i) == 0) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (Float.compare(this.k, r7.k) == 0) goto L28;
        return false;
    L28:
        if (Float.compare(this.l, r7.l) == 0) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (Float.compare(this.n, r7.n) == 0) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        int r0 = Float.floatToIntBits(this.a) * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = Double.doubleToLongBits(this.c);
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        int r6 = (((((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31;
        long r7 = this.g;
        int r8 = (((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31;
        long r9 = this.j;
        int r10 = (((((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + Float.floatToIntBits(this.k)) * 31) + Float.floatToIntBits(this.l)) * 31;
        long r11 = this.m;
        return ((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + Float.floatToIntBits(this.n);
    }

    public final String toString() {
        return "GiftPanelPerformanceData(fps=" + this.a + ", monitorDuration=" + this.b + ", stallUIRate=" + this.c + ", stallUICount=" + this.d + ", stallUIDuration=" + this.e + ", minorDropRate=" + this.f + ", minorDropCount=" + this.g + ", minorDropDuration=" + this.h + ", mediumDropRate=" + this.i + ", mediumDropCount=" + this.j + ", mediumDropDuration=" + this.k + ", criticalDropRate=" + this.l + ", criticalDropCount=" + this.m + ", criticalDropDuration=" + this.n + ")";
    }

    public y1(int r5) {
        this.a = -1.0f;
        this.b = -1;
        this.c = -1.0d;
        this.d = -1;
        this.e = -1.0f;
        this.f = -1.0f;
        this.g = -1;
        this.h = -1.0f;
        this.i = -1.0f;
        this.j = -1;
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = -1;
        this.n = -1.0f;
    }
}
