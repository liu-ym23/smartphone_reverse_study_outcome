package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ag f397b = null;
    private static final ag c = null;
    private static final ag d = null;
    private static final ag e = null;
    private static final ag f = null;
    private static final ag g = null;
    private static final ag h = null;
    private static final ag i = null;
    private static final ag j = null;
    private static final ag k = null;
    private static final ag l = null;
    private static final ag m = null;
    private static final ag n = null;
    private static final ag o = null;
    private static final ag p = null;
    private static final ag q = null;
    private static final ag r = null;
    private static final ag s = null;
    private static final ag t = null;
    private static final ag u = null;
    private static final ag v = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f422b;
        private String c;

        public a(String r1, String r2, String r3) {
            this.f421a = r1;
            this.f422b = r2;
            this.c = r3;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f422b;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f421a;
        }

        static /* synthetic */ String c(a r0) {
            return r0.c;
        }
    }

    private interface b {
        com.alibaba.excel.support.asm.aa[] a(w r1);
    }

    static {
        f397b = ai.e("");
        c = ai.e("Throwable");
        d = ai.c("String getName()");
        e = ai.c("int hashCode()");
        f = ai.c("boolean equals(Object)");
        g = ai.c("int length()");
        h = ai.c("char charAt(int)");
        i = ai.c("Class forName(String)");
        j = ai.c("long doubleToLongBits(double)");
        k = ai.c("int floatToIntBits(float)");
        l = ai.c("String toString()");
        m = ai.c("StringBuffer append(String)");
        n = ai.c("StringBuffer append(int)");
        o = ai.c("StringBuffer append(double)");
        p = ai.c("StringBuffer append(float)");
        q = ai.c("StringBuffer append(char)");
        r = ai.c("StringBuffer append(long)");
        s = ai.c("StringBuffer append(boolean)");
        t = ai.c("int length()");
        u = ai.c("void setLength(int)");
        v = ai.c("java.lang.reflect.Method getDeclaredMethod(String, Class[])");
        f396a = new a("{", ", ", "}");
    }

    static /* synthetic */ ag a() {
        return f;
    }

    public static g a(d r1, w r2) {
        return a(r1, r2, r2.b());
    }

    public static g a(d r1, w r2, int r3) {
        return r1.a(r3, r2.c(), r2.d());
    }

    private static Class a(Class r1) {
        if (r1.equals(com.alibaba.excel.support.asm.aa.class) == false) goto L6;
        return Class.class;
    L6:
        return r1;
    }

    public static void a(d r3) {
        g r4 = r3.a(1, f397b, null);
        r4.u();
        r4.y();
        r4.w();
        r4.g();
    }

    public static void a(d r2, ag r3) {
        g r4 = r2.a(1, r3, null);
        r4.z();
        r4.k();
        r4.v();
        r4.d(ai.b(r3.d()));
        r4.w();
        r4.g();
    }

    public static void a(g r1) {
        b(r1, r1.f().f());
    }

    private static void a(g r2, int r3) {
        r2.k();
        r2.k();
        r2.b(i.E, t);
        r2.b(r3);
        r2.a(100, com.alibaba.excel.support.asm.aa.f);
        r2.b(i.E, u);
    }

    public static void a(g r2, com.alibaba.excel.support.asm.aa r3) {
        if (ai.f(r3) == true) goto L5;
        b(r2, r3);
        return;
    L5:
        if (r3 == com.alibaba.excel.support.asm.aa.f300a) goto L8;
        r2.a(ai.c(r3), "TYPE", i.p);
        return;
    L8:
        throw new IllegalArgumentException("cannot load void type");
    }

    public static void a(g r1, com.alibaba.excel.support.asm.aa r2, int r3, com.alibaba.excel.support.cglib.core.a.a r4) {
        if (ai.d(r2) == false) goto L5;
        b(r1, r2, r3, r4);
        return;
    L5:
        r1.a(com.alibaba.excel.support.asm.aa.f, r2);
        r1.b(r3);
        r1.a(104, com.alibaba.excel.support.asm.aa.f);
        r1.a(r2, com.alibaba.excel.support.asm.aa.f);
        if (ai.f(r2) == false) goto L8;
        c(r1, r2);
    L9:
        r1.a(96, com.alibaba.excel.support.asm.aa.f);
        return;
    L8:
        a(r1, r2, r4);
        goto L9
    }

    public static void a(final g r1, com.alibaba.excel.support.asm.aa r2, final com.alibaba.excel.support.asm.q r3, final com.alibaba.excel.support.cglib.core.a.a r4) {
        new AnonymousClass15(r1, r3, r4).a(r2);
    }

    static /* synthetic */ void a(g r2, com.alibaba.excel.support.asm.aa r3, com.alibaba.excel.support.asm.q r4, com.alibaba.excel.support.cglib.core.a.a r5, ac r6) {
        b(r2, r3, r4, r5, (ac) ZeusTransformUtils.wrapperContextForParams(r6, ac.class, "com.obric.memorydata.plugin"));
    }

    private static void a(g r7, com.alibaba.excel.support.asm.aa r8, com.alibaba.excel.support.cglib.core.a.a r9) {
        com.alibaba.excel.support.asm.q r0 = r7.D();
        com.alibaba.excel.support.asm.q r1 = r7.D();
        r7.k();
        r7.c(r0);
        Iterator r2 = r9.a(r.class).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (((r) ZeusTransformUtils.preCheckCast(r2.next(), r.class, "com.obric.memorydata.plugin")).a(r7, r8) == false) goto L4;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L15;
        Iterator r10 = r9.a(j.class).iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        ((j) ZeusTransformUtils.preCheckCast(r10.next(), j.class, "com.obric.memorydata.plugin")).a(r7, r8);
        goto L12
    L14:
        r7.b(i.o, e);
    L15:
        r7.b(r1);
        r7.e(r0);
        r7.i();
        r7.b(0);
        r7.e(r1);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public static void a(g r5, com.alibaba.excel.support.asm.aa r6, ac r7) {
        ac r8 = (ac) ZeusTransformUtils.wrapperContextForParams(r7, ac.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.asm.aa r9 = ai.e(r6);
        u r0 = r5.E();
        u r1 = r5.e(com.alibaba.excel.support.asm.aa.f);
        com.alibaba.excel.support.asm.q r2 = r5.D();
        com.alibaba.excel.support.asm.q r3 = r5.D();
        r5.a(r0);
        r5.b(0);
        r5.a(r1);
        r5.b(r3);
        r5.e(r2);
        r5.b(r0);
        r5.b(r1);
        r5.a(r9);
        r8.a(r9);
        r5.a(r1, 1);
        r5.e(r3);
        r5.b(r1);
        r5.b(r0);
        r5.t();
        r5.d(155, r2);
    }

    public static void a(final g r1, com.alibaba.excel.support.asm.aa r2, final a r3, final com.alibaba.excel.support.cglib.core.a.a r4) {
        if (r3 != null) goto L5;
        r3 = f396a;
    L5:
        b(r1, r2, r3, r4, new AnonymousClass16(r1, r3, r4));
    }

    static /* synthetic */ void a(g r2, com.alibaba.excel.support.asm.aa r3, a r4, com.alibaba.excel.support.cglib.core.a.a r5, ac r6) {
        b(r2, r3, r4, r5, (ac) ZeusTransformUtils.wrapperContextForParams(r6, ac.class, "com.obric.memorydata.plugin"));
    }

    private static void a(g r3, com.alibaba.excel.support.asm.q r4, com.alibaba.excel.support.asm.q r5) {
        r3.l();
        com.alibaba.excel.support.asm.q r0 = r3.D();
        com.alibaba.excel.support.asm.q r1 = r3.D();
        com.alibaba.excel.support.asm.q r2 = r3.D();
        r3.d(r0);
        r3.d(r1);
        r3.j();
        r3.b(r5);
        r3.e(r0);
        r3.c(r1);
        r3.b(r2);
        r3.e(r1);
        r3.j();
        r3.b(r4);
        r3.e(r2);
    }

    public static void a(g r5, c r6, com.alibaba.excel.support.asm.aa[] r7, com.alibaba.excel.support.asm.aa r8) {
        if (r7 != null) goto L4;
        Set r0 = Collections.EMPTY_SET;
    L6:
        if (r0.contains(i.B) == false) goto L8;
        return;
    L8:
        int r1 = 0;
        boolean r2 = true;
        if (r7 == null) goto L11;
        boolean r3 = true;
    L13:
        if (r0.contains(i.F) == true) goto L16;
        r5.a(r6, i.F);
        r3 = true;
    L16:
        if (r0.contains(i.G) == true) goto L18;
        r5.a(r6, i.G);
    L19:
        if (r7 != null) goto L21;
    L23:
        if (r2 == false) goto L25;
        r5.C();
    L25:
        r5.a(r6, i.B);
        r5.d(r8);
        r5.m();
        r5.q();
        r5.d(r8, c);
        r5.C();
        return;
    L21:
        if (r1 >= r7.length) goto L23;
        r5.a(r6, r7[r1]);
        r1 = r1 + 1;
        goto L21
    L18:
        r2 = r3;
        goto L19
    L11:
        r3 = false;
        goto L13
    L4:
        r0 = new HashSet(Arrays.asList(r7));
        goto L6
    }

    public static void a(g r1, w r2) {
        a(r1, r2.a().getType());
        r1.a(r2.c().a());
        a(r1, r2.c().d());
        r1.b(i.p, v);
    }

    public static void a(g r2, Object r3) {
        if (r3 != null) goto L5;
        r2.r();
        return;
    L5:
        if (r3.getClass().isArray() == false) goto L8;
        a(r2, (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L11;
        r2.a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, com.alibaba.excel.support.asm.aa.class) == false) goto L15;
        com.alibaba.excel.support.asm.aa r4 = (com.alibaba.excel.support.asm.aa) ZeusTransformUtils.preCheckCast(r3, com.alibaba.excel.support.asm.aa.class, "com.obric.memorydata.plugin");
    L13:
        a(r2, r4);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L18;
        r4 = com.alibaba.excel.support.asm.aa.getType((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin"));
        goto L13
    L18:
        if (ZeusTransformUtils.instanceOf(r3, BigInteger.class) == false) goto L22;
        r2.d(i.C);
        r2.k();
        r2.a(r3.toString());
        com.alibaba.excel.support.asm.aa r5 = i.C;
    L20:
        r2.c(r5);
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r3, BigDecimal.class) == false) goto L26;
        r2.d(i.D);
        r2.k();
        r2.a(r3.toString());
        r5 = i.D;
        goto L20
    L26:
        throw new IllegalArgumentException("unknown type: " + r3.getClass());
    }

    public static void a(g r2, List r3, aa r4) {
        a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin"), false);
    }

    static /* synthetic */ void a(g r8, List r9, aa r10, com.alibaba.excel.support.asm.q r11, com.alibaba.excel.support.asm.q r12, int r13) {
        b(r8, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r10, aa.class, "com.obric.memorydata.plugin"), r11, r12, r13);
    }

    static /* synthetic */ void a(g r8, List r9, aa r10, b r11, com.alibaba.excel.support.asm.q r12, com.alibaba.excel.support.asm.q r13) {
        b(r8, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r10, aa.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r11, b.class, "com.obric.memorydata.plugin"), r12, r13);
    }

    static /* synthetic */ void a(g r9, List r10, aa r11, b r12, com.alibaba.excel.support.asm.q r13, com.alibaba.excel.support.asm.q r14, BitSet r15) {
        b(r9, (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r11, aa.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r12, b.class, "com.obric.memorydata.plugin"), r13, r14, r15);
    }

    private static void a(final g r11, List r12, aa r13, boolean r14) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        final aa r15 = (aa) ZeusTransformUtils.wrapperContextForParams(r13, aa.class, "com.obric.memorydata.plugin");
        final HashMap r16 = new HashMap();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        final b r8 = new AnonymousClass2(r16);     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        final com.alibaba.excel.support.asm.q r17 = r11.D();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        final com.alibaba.excel.support.asm.q r0 = r11.D();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        if (r14 == false) goto L6;
        r11.q();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        final Map r6 = h.a(r3, new AnonymousClass3());     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        a(r11, (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r6.keySet().toArray(new String[r6.size()]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin"), 1, new AnonymousClass4(r11, r6, r15, r8, r17, r0));     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
    L7:
        r11.e(r17);     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        r11.i();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        r15.a();     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        r11.e(r0);     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
        return;
    L6:
        b(r11, r3, r15, r8, r17, r0);     // Catch: Exception -> L9 Error -> L12 RuntimeException -> L14
    L12:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    public static void a(g r2, Object[] r3) {
        r2.b(r3.length);
        r2.b(com.alibaba.excel.support.asm.aa.getType(a(r3.getClass().getComponentType())));
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r2.k();
        r2.b(r0);
        a(r2, r3[r0]);
        r2.B();
        r0 = r0 + 1;
        goto L4
    }

    public static void a(g r2, String[] r3, int r4, aa r5) {
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r5, aa.class, "com.obric.memorydata.plugin");
        if (r4 != 0) goto L5;
        a(r2, r3, r6);     // Catch: Exception -> L14 Error -> L17 RuntimeException -> L19
        return;
    L5:
        if (r4 != 1) goto L7;
        a(r2, r3, r6, false);     // Catch: Exception -> L14 Error -> L17 RuntimeException -> L19
        return;
    L7:
        if (r4 != 2) goto L10;
        a(r2, r3, r6, true);     // Catch: Exception -> L14 Error -> L17 RuntimeException -> L19
        return;
    L10:
        throw new IllegalArgumentException("unknown switch style " + r4);     // Catch: Exception -> L14 Error -> L17 RuntimeException -> L19
    L17:
        e = move-exception;
        throw e;
    L19:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    private static void a(final g r9, String[] r10, aa r11) {
        final aa r12 = (aa) ZeusTransformUtils.wrapperContextForParams(r11, aa.class, "com.obric.memorydata.plugin");
        final com.alibaba.excel.support.asm.q r6 = r9.D();
        final com.alibaba.excel.support.asm.q r7 = r9.D();
        final Map r1 = h.a(Arrays.asList(r10), new AnonymousClass1());
        r9.k();
        r9.b(i.A, g);
        r9.a(a(r1), new AnonymousClass9(r1, r9, r12, r6, r7));
        r9.e(r6);
        r9.i();
        r12.a();
        r9.e(r7);
    }

    private static void a(final g r10, String[] r11, aa r12, final boolean r13) {
        final aa r14 = (aa) ZeusTransformUtils.wrapperContextForParams(r12, aa.class, "com.obric.memorydata.plugin");
        final Map r1 = h.a(Arrays.asList(r11), new AnonymousClass12());
        final com.alibaba.excel.support.asm.q r15 = r10.D();
        final com.alibaba.excel.support.asm.q r7 = r10.D();
        r10.k();
        r10.b(i.o, e);
        r10.a(a(r1), new AnonymousClass13(r1, r13, r10, r14, r7, r15));
        r10.e(r15);
        r14.a();
        r10.e(r7);
    }

    static int[] a(Map r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        int[] r0 = new int[r7.size()];
        Iterator r8 = r7.keySet().iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r0[r2] = ((Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r2 = r2 + 1;
        goto L4
    L6:
        Arrays.sort(r0);
        return r0;
    }

    static /* synthetic */ ag b() {
        return m;
    }

    private static void b(g r2) {
        r2.l();
        r2.b(32);
        r2.a(124, com.alibaba.excel.support.asm.aa.h);
        r2.a(130, com.alibaba.excel.support.asm.aa.h);
        r2.b(com.alibaba.excel.support.asm.aa.h, com.alibaba.excel.support.asm.aa.f);
    }

    private static void b(g r5, com.alibaba.excel.support.asm.aa r6) {
        if (r5.d() == false) goto L5;
        r5.a(ai.g(r6));
        r5.c(i.p, i);
        return;
    L5:
        d r0 = r5.f();
        String r7 = ai.g(r6);
        String r1 = "CGLIB$load_class$" + ai.f(r7);
        if (r0.d(r1) == true) goto L8;
        r0.a(26, r1, i.p, null);
        g r2 = r0.c();
        r2.a(r7);
        r2.c(i.p, i);
        r2.b(r0.f(), r1, i.p);
    L8:
        r5.b(r1);
    }

    private static void b(final g r3, com.alibaba.excel.support.asm.aa r4, final int r5, final com.alibaba.excel.support.cglib.core.a.a r6) {
        com.alibaba.excel.support.asm.q r0 = r3.D();
        com.alibaba.excel.support.asm.q r1 = r3.D();
        r3.k();
        r3.c(r0);
        a(r3, r4, new AnonymousClass14(r3, r5, r6));
        r3.b(r1);
        r3.e(r0);
        r3.i();
        r3.e(r1);
    }

    private static void b(g r5, com.alibaba.excel.support.asm.aa r6, com.alibaba.excel.support.asm.q r7, com.alibaba.excel.support.cglib.core.a.a r8, ac r9) {
        ac r10 = (ac) ZeusTransformUtils.wrapperContextForParams(r9, ac.class, "com.obric.memorydata.plugin");
        if (ai.f(r6) == false) goto L5;
        r5.a(r6, 154, r7);
        return;
    L5:
        com.alibaba.excel.support.asm.q r0 = r5.D();
        a(r5, r7, r0);
        if (ai.d(r6) == false) goto L8;
        com.alibaba.excel.support.asm.q r11 = r5.D();
        r5.l();
        r5.t();
        r5.q();
        r5.t();
        r5.d(153, r11);
        r5.j();
        r5.b(r7);
        r5.e(r11);
        b(r5, r6, r10);
    L19:
        r5.e(r0);
        return;
    L8:
        List r12 = r8.a(j.class);
        if (r12.isEmpty() == true) goto L18;
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        ((j) ZeusTransformUtils.preCheckCast(r13.next(), j.class, "com.obric.memorydata.plugin")).a(r5, r6);
        goto L12
    L14:
        r5.q();
        Iterator r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        ((j) ZeusTransformUtils.preCheckCast(r14.next(), j.class, "com.obric.memorydata.plugin")).a(r5, r6);
    L18:
        r5.b(i.o, f);
        r5.c(153, r7);
        goto L19
    }

    public static void b(g r6, com.alibaba.excel.support.asm.aa r7, ac r8) {
        ac r9 = (ac) ZeusTransformUtils.wrapperContextForParams(r8, ac.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.asm.aa r10 = ai.e(r7);
        u r0 = r6.E();
        u r1 = r6.E();
        u r2 = r6.e(com.alibaba.excel.support.asm.aa.f);
        com.alibaba.excel.support.asm.q r3 = r6.D();
        com.alibaba.excel.support.asm.q r4 = r6.D();
        r6.a(r0);
        r6.a(r1);
        r6.b(0);
        r6.a(r2);
        r6.b(r4);
        r6.e(r3);
        r6.b(r0);
        r6.b(r2);
        r6.a(r10);
        r6.b(r1);
        r6.b(r2);
        r6.a(r10);
        r9.a(r10);
        r6.a(r2, 1);
        r6.e(r4);
        r6.b(r2);
        r6.b(r0);
        r6.t();
        r6.d(155, r3);
    }

    private static void b(g r4, com.alibaba.excel.support.asm.aa r5, a r6, com.alibaba.excel.support.cglib.core.a.a r7, ac r8) {
        ac r9 = (ac) ZeusTransformUtils.wrapperContextForParams(r8, ac.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.asm.q r0 = r4.D();
        com.alibaba.excel.support.asm.q r2 = r4.D();
        if (ai.f(r5) == true) goto L5;
        boolean r3 = ai.d(r5);
        r4.k();
        r4.c(r0);
        if (r3 == false) goto L29;
        r4.q();
        if (r6 != null) goto L18;
    L22:
        a(r4, r5, r9);
        a(r4, 2);
        if (r6 != null) goto L25;
    L36:
        r4.b(r2);
        r4.e(r0);
        r4.i();
        r4.a("null");
        r4.b(i.E, m);
        r4.e(r2);
        return;
    L25:
        if (a.c(r6) == null) goto L36;
        if ("".equals(a.c(r6)) == true) goto L36;
        r4.a(a.c(r6));
    L34:
        com.alibaba.excel.support.asm.aa r10 = i.E;
        ag r11 = m;
    L35:
        r4.b(r10, r11);
        goto L36
    L18:
        if (a.b(r6) == null) goto L22;
        if ("".equals(a.b(r6)) == true) goto L22;
        r4.a(a.b(r6));
        r4.b(i.E, m);
        r4.q();
        goto L22
    L29:
        Iterator r12 = r7.a(j.class).iterator();
    L31:
        if (r12.hasNext() == false) goto L33;
        ((j) ZeusTransformUtils.preCheckCast(r12.next(), j.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L31
    L33:
        r4.b(i.o, l);
        goto L34
    L5:
        switch(r5.e()) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L36;
        };
    L7:
        r10 = i.E;
        r11 = o;
        goto L35
    L8:
        r10 = i.E;
        r11 = r;
        goto L35
    L9:
        r10 = i.E;
        r11 = p;
        goto L35
    L10:
        r10 = i.E;
        r11 = n;
        goto L35
    L11:
        r10 = i.E;
        r11 = q;
        goto L35
    L12:
        r10 = i.E;
        r11 = s;
        goto L35
    }

    private static void b(final g r10, List r11, aa r12, final com.alibaba.excel.support.asm.q r13, final com.alibaba.excel.support.asm.q r14, final int r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        final aa r7 = (aa) ZeusTransformUtils.wrapperContextForParams(r12, aa.class, "com.obric.memorydata.plugin");
        final int r5 = ((String) ZeusTransformUtils.preCheckCast(r16.get(0), String.class, "com.obric.memorydata.plugin")).length();
        final Map r3 = h.a(r16, new AnonymousClass10(r15));
        r10.k();
        r10.b(r15);
        r10.b(i.A, h);
        r10.a(a(r3), new AnonymousClass11(r3, r15, r5, r10, r7, r14, r13));
    }

    private static void b(final g r9, List r10, aa r11, b r12, final com.alibaba.excel.support.asm.q r13, final com.alibaba.excel.support.asm.q r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        final aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r11, aa.class, "com.obric.memorydata.plugin");
        final b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r12, b.class, "com.obric.memorydata.plugin");
        final Map r3 = h.a(r15, new AnonymousClass5(r6));
        r9.k();
        r9.t();
        r9.a(a(r3), new AnonymousClass6(r3, r9, r5, r6, r13, r14));
    }

    private static void b(final g r16, List r17, aa r18, b r19, final com.alibaba.excel.support.asm.q r20, final com.alibaba.excel.support.asm.q r21, final BitSet r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        final aa r3 = (aa) ZeusTransformUtils.wrapperContextForParams(r18, aa.class, "com.obric.memorydata.plugin");
        final b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r19, b.class, "com.obric.memorydata.plugin");
        final int r6 = 0;
        if (r0.size() != 1) goto L13;
        w r1 = (w) ZeusTransformUtils.preCheckCast(r0.get(0), w.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.asm.aa[] r2 = r4.a(r1);
    L6:
        if (r6 >= r2.length) goto L12;
        if (r22 != null) goto L9;
    L10:
        r16.k();
        r16.d(r6);
        r16.b(i.p, d);
        r16.a(ai.g(r2[r6]));
        r16.b(i.o, f);
        r16.c(153, r20);
    L11:
        r6 = r6 + 1;
        goto L6
    L9:
        if (r22.get(r6) == true) goto L11;
    L12:
        r16.i();
        r3.a(r1, r21);
        return;
    L13:
        com.alibaba.excel.support.asm.aa[] r5 = r4.a((w) ZeusTransformUtils.preCheckCast(r0.get(0), w.class, "com.obric.memorydata.plugin"));
        Map r11 = null;
        int r12 = -1;
    L15:
        if (r6 >= r5.length) goto L22;
        Map r13 = h.a(r0, new AnonymousClass7(r4, r6));
        if (r11 != null) goto L19;
    L20:
        r12 = r6;
        r11 = r13;
    L21:
        r6 = r6 + 1;
        goto L15
    L19:
        if (r13.size() <= r11.size()) goto L21;
    L22:
        if (r11 != null) goto L24;
    L27:
        r16.b(r20);
        return;
    L24:
        if (r11.size() == 1) goto L27;
        r22.set(r12);
        r16.k();
        r16.d(r12);
        r16.b(i.p, d);
        String[] r14 = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r11.keySet().toArray(new String[r11.size()]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
        final Map r7 = r11;
        a(r16, r14, 1, new AnonymousClass8(r16, r7, r3, r4, r20, r21, r22));
    }

    private static void c(g r1, com.alibaba.excel.support.asm.aa r2) {
        int r3 = r2.e();
        if (r3 != 1) goto L5;
        r1.b(1);
        r1.a(130, com.alibaba.excel.support.asm.aa.f);
        return;
    L5:
        if (r3 != 6) goto L7;
        r1.c(i.u, k);
        return;
    L7:
        if (r3 != 7) goto L9;
    L12:
        b(r1);
        return;
    L9:
        if (r3 != 8) goto L18;
        r1.c(i.t, j);
        goto L12
    }
}
