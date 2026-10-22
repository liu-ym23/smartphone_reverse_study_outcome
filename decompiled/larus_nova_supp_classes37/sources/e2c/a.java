package e2c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a g = null;
    public final int[] a;
    public final int[] b;
    public final b c;
    public final int d;
    public final int e;
    public final int f;

    static {
        new a(4201, 4096, 1);
        new a(1033, 1024, 1);
        new a(67, 64, 1);
        new a(19, 16, 1);
        g = new a(285, 256, 0);
        new a(301, 256, 1);
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.e) + ',' + this.d + ')';
    }

    public final int a(int r3, int r4) {
        if (r3 == 0) goto L7;
        if (r4 == 0) goto L9;
        int[] r0 = this.a;
        int[] r1 = this.b;
        return r0[(r1[r3] + r1[r4]) % (this.d - 1)];
    L9:
        return 0;
    L7:
        return 0;
    }

    public a(int r5, int r6, int r7) {
        this.e = r5;
        this.d = r6;
        this.f = r7;
        this.a = new int[r6];
        this.b = new int[r6];
        int r1 = 0;
        int r2 = 1;
    L3:
        if (r1 >= r6) goto L8;
        this.a[r1] = r2;
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
        this.b[this.a[r8]] = r8;
        r8 = r8 + 1;
        goto L10
    L12:
        this.c = new b(this, new int[]{0});
        new b(this, new int[]{1});
    }
}
