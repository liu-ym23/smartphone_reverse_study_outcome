package n6a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final a c = null;
    public static final a d = null;
    public static final a e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a[] h = null;
    public final int a;
    public final boolean b;

    static {
        a r0 = new a(0, false);
        c = r0;
        a r2 = new a(1, true);
        a r4 = new a(2, false);
        d = r4;
        a r6 = new a(3, true);
        a r8 = new a(4, false);
        e = r8;
        a r10 = new a(5, true);
        a r12 = new a(6, false);
        f = r12;
        a r14 = new a(7, true);
        a r15 = new a(8, false);
        a r13 = new a(9, true);
        g = r13;
        h = new a[]{r0, r2, r4, r6, r8, r10, r12, r14, r15, r13, new a(10, false), new a(10, true)};
    }

    public final a b() {
        if (this.b == false) goto L9;
        a r0 = h[this.a - 1];
        if (r0.b == true) goto L8;
        return r0;
    L8:
        return c;
    L9:
        return this;
    }

    public final boolean a(a r3) {
        int r0 = this.a;
        int r4 = r3.a;
        if (r0 >= r4) goto L5;
    L11:
        return true;
    L5:
        if (this.b == true) goto L7;
    L8:
        if (r0 == r4) goto L11;
    L10:
        return false;
    L7:
        if (g != this) goto L10;
        goto L8
    }

    public a(int r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
