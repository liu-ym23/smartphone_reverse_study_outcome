package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5073b = null;
    public static final a c = null;
    public static final a d = null;
    public static final a e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    private final int[] i;
    private final int[] j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    static {
        f5072a = new a(4201, 4096, 1);
        f5073b = new a(1033, 1024, 1);
        a r0 = new a(67, 64, 1);
        c = r0;
        d = new a(19, 16, 1);
        e = new a(285, 256, 0);
        a r1 = new a(301, 256, 1);
        f = r1;
        g = r1;
        h = r0;
    }

    public a(int r5, int r6, int r7) {
        this.n = r5;
        this.m = r6;
        this.o = r7;
        this.i = new int[r6];
        this.j = new int[r6];
        int r1 = 0;
        int r2 = 1;
    L3:
        if (r1 >= r6) goto L8;
        this.i[r1] = r2;
        r2 = r2 * 2;
        if (r2 < r6) goto L7;
        r2 = (r2 ^ r5) & (r6 - 1);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        int r8 = 0;
    L10:
        if (r8 >= (r6 - 1)) goto L12;
        this.j[this.i[r8]] = r8;
        r8 = r8 + 1;
        goto L10
    L12:
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    static int b(int r0, int r1) {
        return r0 ^ r1;
    }

    int a(int r1) {
        return this.i[r1];
    }

    b a() {
        return this.k;
    }

    b a(int r2, int r3) {
        if (r2 < 0) goto L9;
        if (r3 == 0) goto L5;
        int[] r4 = new int[r2 + 1];
        r4[0] = r3;
        return new b(this, r4);
    L5:
        return this.k;
    L9:
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.o;
    }

    int b(int r1) {
        if (r1 == 0) goto L6;
        return this.j[r1];
    L6:
        throw new IllegalArgumentException();
    }

    int c(int r3) {
        if (r3 == 0) goto L6;
        return this.i[(this.m - this.j[r3]) - 1];
    L6:
        throw new ArithmeticException();
    }

    int c(int r3, int r4) {
        if (r3 == 0) goto L7;
        if (r4 == 0) goto L9;
        int[] r0 = this.i;
        int[] r1 = this.j;
        return r0[(r1[r3] + r1[r4]) % (this.m - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
