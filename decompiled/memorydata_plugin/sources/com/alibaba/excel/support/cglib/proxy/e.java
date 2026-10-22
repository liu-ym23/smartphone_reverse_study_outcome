package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class e {
    private static final e[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f436b;
    private aa c;

    static {
        d = new e[]{new e(r.class, s.f465a), new e(p.class, q.f460a), new e(l.class, m.f456a), new e(n.class, o.f458a), new e(f.class, g.f437a), new e(j.class, k.f454a), new e(t.class, g.f438b)};
    }

    private e(Class r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.f435a = r3;
        this.f436b = r5;
        this.c = aa.getType(r3);
    }

    private static aa a(b r2, boolean r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        return a(r4.getClass(), r3);
    L7:
        throw new IllegalStateException("Callback is null");
    }

    private static aa a(Class r5, boolean r6) {
        Class r0 = null;
        int r2 = 0;
        aa r1 = null;
    L3:
        e[] r3 = d;
        if (r2 >= r3.length) goto L14;
        e r4 = r3[r2];
        if (r4.f435a.isAssignableFrom(r5) == false) goto L13;
        if (r0 != null) goto L12;
        r0 = r4.f435a;
        r1 = r4.c;
        if (r6 == true) goto L13;
    L12:
        throw new IllegalStateException("Callback implements both " + r0 + " and " + r4.f435a);
    L13:
        r2 = r2 + 1;
    L14:
        if (r0 == null) goto L17;
        return r1;
    L17:
        throw new IllegalStateException("Unknown callback type " + r5);
    }

    private static d a(aa r3) {
        int r0 = 0;
    L3:
        e[] r1 = d;
        if (r0 >= r1.length) goto L11;
        e r2 = r1[r0];
        if (r2.c.equals(r3) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return r2.f436b;
    L11:
        throw new IllegalStateException("Unknown callback type " + r3);
    }

    public static aa[] a(b[] r1) {
        return a(r1, true);
    }

    public static aa[] a(b[] r4, boolean r5) {
        int r0 = r4.length;
        aa[] r1 = new aa[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r4[r2], r5);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static aa[] a(Class[] r1) {
        return a(r1, true);
    }

    public static aa[] a(Class[] r4, boolean r5) {
        int r0 = r4.length;
        aa[] r1 = new aa[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r4[r2], r5);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static d[] a(aa[] r4) {
        int r0 = r4.length;
        d[] r1 = new d[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }
}
