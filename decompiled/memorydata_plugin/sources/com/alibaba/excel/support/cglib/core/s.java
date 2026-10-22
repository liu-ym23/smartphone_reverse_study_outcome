package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f424b = null;
    public static final r c = null;

    @Deprecated
    public static final j d = null;
    private static final ag e = null;
    private static final ag f = null;
    private static final ag g = null;
    private static final ag h = null;
    private static final ag i = null;
    private static final ag j = null;
    private static final com.alibaba.excel.support.asm.aa k = null;
    private static final ag l = null;
    private static final int[] m = null;

    public static class a extends com.alibaba.excel.support.cglib.core.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.alibaba.excel.support.cglib.core.a.b f425a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Class[] f426b = null;
        private Class c;
        private com.alibaba.excel.support.cglib.core.a.a d;
        private int e;
        private int f;

        static {
            f425a = new com.alibaba.excel.support.cglib.core.a.b(s.class.getName());
            f426b = new Class[]{j.class, p.class};
        }

        public a() {
            super(f425a);
            this.d = new com.alibaba.excel.support.cglib.core.a.a(f426b);
        }

        private String a(int r2) {
            return "FIELD_" + r2;
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public ClassLoader a() {
            return this.c.getClassLoader();
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public Object a(Class r1) {
            return ae.b(r1);
        }

        @Override // com.alibaba.excel.support.cglib.core.e
        public void a(com.alibaba.excel.support.asm.f r15) {
            d r7 = new d(r15);
            Method r16 = ae.c(this.c);
            if (r16.getReturnType().equals(Object.class) == false) goto L41;
            com.alibaba.excel.support.asm.aa[] r8 = ai.a(r16.getParameterTypes());
            int r10 = 0;
            r7.a(52, 1, d(), s.d(), new com.alibaba.excel.support.asm.aa[]{com.alibaba.excel.support.asm.aa.getType(this.c)}, "<generated>");
            o.a(r7);
            o.a(r7, ae.b(r16));
            g r17 = r7.a(1, ai.b(r8), null);
            r17.u();
            r17.y();
            r17.u();
            List r1 = d(p.class);
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r8.length) goto L16;
            com.alibaba.excel.support.asm.aa r4 = r8[r2];
            Iterator r5 = r1.iterator();
            com.alibaba.excel.support.asm.aa r6 = r4;
        L9:
            if (r5.hasNext() == false) goto L11;
            r6 = ((p) ZeusTransformUtils.preCheckCast(r5.next(), p.class, "com.obric.memorydata.plugin")).a(r2, r6);
            goto L9
        L11:
            r3 = r3 + r6.hashCode();
            r7.a(18, a(r2), r6, null);
            r17.k();
            r17.c(r2);
            Iterator r9 = r1.iterator();
        L13:
            if (r9.hasNext() == false) goto L15;
            ((p) ZeusTransformUtils.preCheckCast(r9.next(), p.class, "com.obric.memorydata.plugin")).a(r17, r2, r4);
            goto L13
        L15:
            r17.c(a(r2));
            r2 = r2 + 1;
            goto L6
        L16:
            r17.w();
            r17.g();
            g r18 = r7.a(1, s.e(), null);
            int r11 = this.e;
            if (r11 != 0) goto L20;
            r11 = s.f()[Math.abs(r3) % s.f().length];
        L20:
            int r12 = this.f;
            if (r12 != 0) goto L24;
            r12 = s.f()[Math.abs(r3 * 13) % s.f().length];
        L24:
            r18.b(r11);
            int r13 = 0;
        L26:
            if (r13 >= r8.length) goto L28;
            r18.u();
            r18.b(a(r13));
            o.a(r18, r8[r13], r12, this.d);
            r13 = r13 + 1;
            goto L26
        L28:
            r18.w();
            r18.g();
            g r19 = r7.a(1, s.g(), null);
            com.alibaba.excel.support.asm.q r14 = r19.D();
            r19.c(0);
            r19.G();
            r19.c(153, r14);
            int r20 = 0;
        L30:
            if (r20 >= r8.length) goto L32;
            r19.u();
            r19.b(a(r20));
            r19.c(0);
            r19.F();
            r19.b(a(r20));
            o.a(r19, r8[r20], r14, this.d);
            r20 = r20 + 1;
            goto L30
        L32:
            r19.b(1);
            r19.w();
            r19.e(r14);
            r19.b(0);
            r19.w();
            r19.g();
            g r110 = r7.a(1, s.h(), null);
            r110.d(i.E);
            r110.k();
            r110.c(i.E);
        L34:
            if (r10 >= r8.length) goto L38;
            if (r10 <= 0) goto L37;
            r110.a(", ");
            r110.b(i.E, s.i());
        L37:
            r110.u();
            r110.b(a(r10));
            o.a(r110, r8[r10], o.f396a, this.d);
            r10 = r10 + 1;
            goto L34
        L38:
            r110.b(i.E, s.h());
            r110.w();
            r110.g();
            r7.h();
            return;
        L41:
            throw new IllegalArgumentException("newInstance method must return Object");
        }

        public void a(t r3) {
            t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.d.a(r4);
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public Object b(Object r1) {
            return r1;
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public ProtectionDomain b() {
            return ae.a(this.c);
        }

        public s c() {
            a(this.c.getName());
            return (s) ZeusTransformUtils.preCheckCast(super.d(this.c.getName()), s.class, "com.obric.memorydata.plugin");
        }

        public <T> List<T> d(Class<T> r1) {
            return this.d.a(r1);
        }

        public void e(Class r1) {
            this.c = r1;
        }
    }

    static {
        e = ai.c("String getName()");
        f = ai.c("Class getClass()");
        g = ai.c("int hashCode()");
        h = ai.c("boolean equals(Object)");
        i = ai.c("String toString()");
        j = ai.c("StringBuffer append(String)");
        k = ai.d("com.alibaba.excel.support.cglib.core.KeyFactory");
        l = ai.c("int getSort()");
        m = new int[]{11, 73, 179, 331, 521, 787, 1213, 1823, 2609, 3691, 5189, 7247, 10037, 13931, 19289, 26627, 36683, 50441, 69403, 95401, 131129, 180179, 247501, 340057, 467063, 641371, 880603, 1209107, 1660097, 2279161, 3129011, 4295723, 5897291, 8095873, 11114263, 15257791, 20946017, 28754629, 39474179, 54189869, 74391461, 102123817, 140194277, 192456917, 264202273, 362693231, 497900099, 683510293, 938313161, 1288102441, 1768288259};
        f423a = new AnonymousClass1();
        f424b = new AnonymousClass2();
        c = new AnonymousClass3();
        d = new AnonymousClass4();
    }

    public s() {
    }

    static /* synthetic */ ag a() {
        return e;
    }

    public static s a(Class r1) {
        return a(r1, null);
    }

    public static s a(Class r2, j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        return a(r2.getClassLoader(), r2, r4);
    }

    public static s a(Class r2, t r3, List<t> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return a(r2.getClassLoader(), r2, r5, r6);
    }

    public static s a(ClassLoader r2, Class r3, j r4) {
        return a(r2, r3, (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin"), Collections.emptyList());
    }

    public static s a(ClassLoader r2, Class r3, t r4, List<t> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a r0 = new a();
        r0.e(r3);
        r0.c(r3);
        if (r6 == null) goto L5;
        r0.a(r6);
    L5:
        if (r7 != null) goto L7;
    L12:
        r0.a(r2);
        return r0.c();
    L7:
        if (r7.isEmpty() == true) goto L12;
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r0.a((t) ZeusTransformUtils.preCheckCast(r8.next(), t.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    static /* synthetic */ ag b() {
        return l;
    }

    static /* synthetic */ ag c() {
        return f;
    }

    static /* synthetic */ com.alibaba.excel.support.asm.aa d() {
        return k;
    }

    static /* synthetic */ ag e() {
        return g;
    }

    static /* synthetic */ int[] f() {
        return m;
    }

    static /* synthetic */ ag g() {
        return h;
    }

    static /* synthetic */ ag h() {
        return i;
    }

    static /* synthetic */ ag i() {
        return j;
    }
}
