package com.larus.disk.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 {
    public final String a;
    public final String b;
    public String c;
    public String d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final double h;
    public final int i;
    public long j;
    public boolean k;
    public final long l;
    public final long m;
    public final long n;
    public final String o;
    public final int p;
    public final long q;
    public final int r;
    public final long s;
    public final long t;
    public final int u;

    public m0() {
        this(null, null, null, null, false, false, 0, 0.0d, 0, 0, false, 2097151);
    }

    public final String toString() {
        return "FileScanInfo(path=" + this.a + ", originPath=" + this.b + ", biz=" + this.c + ", business=" + this.d + ", isInternal=" + this.e + ", isDirectory=" + this.f + ", fileSize=" + this.g + ", reportFileSize=" + this.h + ", childFileCount=" + this.i + ", bizFileThreshold=" + this.j + ", isOverThreshold=" + this.k + ", accessKnownBytes=" + this.l + ", accessed7dBytes=" + this.m + ", accessed30dBytes=" + this.n + ", accessSource=" + this.o + ", accessTrackedFileCount=" + this.p + ", accessUpdateFailureCount=" + this.q + ", accessObservationDays=" + this.r + ", accessHookSuccessCount=" + this.s + ", accessHookFailureCount=" + this.t + ", accessHookLastErrorCode=" + this.u + ')';
    }

    public /* synthetic */ m0(String r37, String r38, String r310, String r40, boolean r41, boolean r42, long r43, double r45, int r47, long r48, boolean r50, int r51) {
        if ((r51 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r51 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r51 & 4) == 0) goto L13;
        String r6 = "unknown";
    L15:
        if ((r51 & 8) == 0) goto L17;
        String r7 = "unknown";
    L18:
        boolean r2 = false;
        if ((r51 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r51 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r51 & 64) == 0) goto L29;
        long r12 = 0;
    L31:
        if ((r51 & 128) == 0) goto L33;
        double r14 = 0.0d;
    L35:
        if ((r51 & 256) == 0) goto L37;
        int r1 = 0;
    L39:
        if ((r51 & 512) == 0) goto L41;
        long r18 = -1;
    L43:
        if ((r51 & 1024) != 0) goto L47;
        r2 = r50;
    L47:
        if ((r51 & 2048) == 0) goto L49;
        long r20 = -1;
    L51:
        if ((r51 & 4096) == 0) goto L53;
        long r22 = -1;
    L55:
        if ((r51 & 8192) == 0) goto L57;
        long r24 = -1;
    L58:
        this(r4, r5, r6, r7, r8, r9, r12, r14, r1, r18, r2, r20, r22, r24, null, 0, 0, 0, 0, 0, 0);
        return;
    L57:
        r24 = 0;
        goto L58
    L53:
        r22 = 0;
        goto L55
    L49:
        r20 = 0;
        goto L51
    L41:
        r18 = r48;
        goto L43
    L37:
        r1 = r47;
        goto L39
    L33:
        r14 = r45;
        goto L35
    L29:
        r12 = r43;
        goto L31
    L25:
        r9 = r42;
        goto L27
    L21:
        r8 = r41;
        goto L23
    L17:
        r7 = r40;
        goto L18
    L13:
        r6 = r310;
        goto L15
    L9:
        r5 = r38;
        goto L11
    L5:
        r4 = r37;
        goto L7
    }

    public m0(String r4, String r5, String r6, String r7, boolean r8, boolean r9, long r10, double r12, int r14, long r15, boolean r17, long r18, long r20, long r22, String r24, int r25, long r26, int r28, long r210, long r31, int r33) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r12;
        this.i = r14;
        this.j = r15;
        this.k = r17;
        this.l = r18;
        this.m = r20;
        this.n = r22;
        this.o = r24;
        this.p = r25;
        this.q = r26;
        this.r = r28;
        this.s = r210;
        this.t = r31;
        this.u = r33;
    }
}
