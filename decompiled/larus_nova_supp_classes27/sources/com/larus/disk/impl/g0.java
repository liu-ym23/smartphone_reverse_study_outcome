package com.larus.disk.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 {
    public final String a;
    public final t0 b;
    public final y c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final String o;
    public final int p;
    public final int q;
    public final boolean r;
    public final boolean s;
    public final int t;
    public final float u;
    public final String v;
    public final long w;
    public final int x;
    public final a0 y;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r9 = (g0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
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
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L69;
        return false;
    L69:
        if (Float.compare(this.u, r9.u) == 0) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
        return false;
    L75:
        if (this.w == r9.w) goto L78;
        return false;
    L78:
        if (this.x == r9.x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        t0 r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        y r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        long r6 = this.d;
        int r7 = (((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.g;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = this.h;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.i;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.j;
        int r20 = (((((((((((((((r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o.hashCode()) * 31) + this.p) * 31) + this.q) * 31;
        int r21 = 1231;
        if (this.r == false) goto L13;
        int r22 = 1231;
    L14:
        int r23 = (r20 + r22) * 31;
        if (this.s == true) goto L18;
        r21 = 1237;
    L18:
        int r24 = (((((((r23 + r21) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31) + this.v.hashCode()) * 31;
        long r25 = this.w;
        return ((((r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31) + this.x) * 31) + this.y.hashCode();
    L13:
        r22 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiskStorageSnapshot(snapshotId=" + this.a + ", systemStorage=" + this.b + ", deviceStorage=" + this.c + ", externalTotalBytes=" + this.d + ", externalAvailableBytes=" + this.e + ", sandboxStorageBytes=" + this.f + ", rootCacheStorageBytes=" + this.g + ", registeredUsageBytes=" + this.h + ", registeredAutoCleanableBytes=" + this.i + ", registeredManualCleanableBytes=" + this.j + ", registeredHandlerCount=" + this.k + ", registeredHandlerExpectedCount=" + this.l + ", registeredHandlerFailureCount=" + this.m + ", registeredCandidateFailureCount=" + this.n + ", registeredCollectionStatus=" + this.o + ", businessGroupCount=" + this.p + ", bizGroupCount=" + this.q + ", isExternalStorageAvailable=" + this.r + ", isLowDisk=" + this.s + ", cleanType=" + this.t + ", scanSampleRate=" + this.u + ", samplingStrategy=" + this.v + ", scanIntervalMs=" + this.w + ", fileTypeScanDepth=" + this.x + ", fileTypeSummary=" + this.y + ')';
    }

    public g0(String r9, t0 r10, y r11, long r12, long r14, long r16, long r18, long r20, long r22, long r24, int r26, int r27, int r28, int r210, String r30, int r31, int r32, boolean r33, boolean r34, int r35, float r36, long r37, int r310, a0 r40) {
        Intrinsics.checkNotNullParameter(r9, "snapshotId");
        Intrinsics.checkNotNullParameter(r30, "registeredCollectionStatus");
        Intrinsics.checkNotNullParameter("stable_install_bucket", "samplingStrategy");
        Intrinsics.checkNotNullParameter(r40, "fileTypeSummary");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r14;
        this.f = r16;
        this.g = r18;
        this.h = r20;
        this.i = r22;
        this.j = r24;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r210;
        this.o = r30;
        this.p = r31;
        this.q = r32;
        this.r = r33;
        this.s = r34;
        this.t = r35;
        this.u = r36;
        this.v = "stable_install_bucket";
        this.w = r37;
        this.x = r310;
        this.y = r40;
    }
}
