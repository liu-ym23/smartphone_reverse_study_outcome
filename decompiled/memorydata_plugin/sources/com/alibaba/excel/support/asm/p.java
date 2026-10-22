package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final q f326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final q f327b;
    final q c;
    final int d;
    final String e;
    p f;

    p(p r7, q r8, q r9) {
        this(r8, r9, r7.c, r7.d, r7.e);
        this.f = r7.f;
    }

    p(q r1, q r2, q r3, int r4, String r5) {
        this.f326a = r1;
        this.f327b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    static int a(p r1) {
        int r0 = 0;
    L3:
        if (r1 == null) goto L5;
        r0 = r0 + 1;
        r1 = r1.f;
        goto L3
    L5:
        return r0;
    }

    static p a(p r4, q r5, q r6) {
        if (r4 != null) goto L5;
        return null;
    L5:
        r4.f = a(r4.f, r5, r6);
        int r0 = r4.f326a.c;
        int r1 = r4.f327b.c;
        int r2 = r5.c;
        if (r6 != null) goto L8;
        int r3 = Integer.MAX_VALUE;
    L9:
        if (r2 >= r1) goto L23;
        if (r3 <= r0) goto L23;
        if (r2 > r0) goto L18;
        if (r3 < r1) goto L17;
        return r4.f;
    L17:
        return new p(r4, r6, r4.f327b);
    L18:
        if (r3 >= r1) goto L20;
        r4.f = new p(r4, r6, r4.f327b);
        return new p(r4, r4.f326a, r5);
    L20:
        return new p(r4, r4.f326a, r5);
    L23:
        return r4;
    L8:
        r3 = r6.c;
        goto L9
    }

    static void a(p r2, d r3) {
        r3.b(a(r2));
    L3:
        if (r2 == null) goto L5;
        r3.b(r2.f326a.c).b(r2.f327b.c).b(r2.c.c).b(r2.d);
        r2 = r2.f;
        goto L3
    }

    static int b(p r0) {
        return (a(r0) * 8) + 2;
    }
}
