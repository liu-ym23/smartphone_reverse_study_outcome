package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ah;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.u;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class q implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Class[] f461b = null;
    private static final aa c = null;
    private static final aa d = null;
    private static final aa e = null;
    private static final aa f = null;
    private static final aa g = null;
    private static final ag h = null;
    private static final ag i = null;
    private static final ag j = null;
    private static final ag k = null;
    private static final ag l = null;
    private static final ag m = null;
    private static final ag n = null;
    private static final ah o = null;
    private static final ag p = null;

    static {
        f460a = new q();
        f461b = new Class[]{ag.class};
        c = ai.d("AbstractMethodError");
        aa r1 = ai.d("java.lang.reflect.Method");
        d = r1;
        e = ai.d("com.alibaba.excel.support.cglib.core.ReflectUtils");
        aa r2 = ai.d("com.alibaba.excel.support.cglib.proxy.MethodProxy");
        f = r2;
        g = ai.d("com.alibaba.excel.support.cglib.proxy.MethodInterceptor");
        h = ai.c("java.lang.reflect.Method[] getDeclaredMethods()");
        i = ai.c("Class getDeclaringClass()");
        j = ai.c("java.lang.reflect.Method[] findMethods(String[], java.lang.reflect.Method[])");
        k = new ag("create", r2, new aa[]{com.alibaba.excel.support.cglib.core.i.p, com.alibaba.excel.support.cglib.core.i.p, com.alibaba.excel.support.cglib.core.i.A, com.alibaba.excel.support.cglib.core.i.A, com.alibaba.excel.support.cglib.core.i.A});
        l = new ag("intercept", com.alibaba.excel.support.cglib.core.i.o, new aa[]{com.alibaba.excel.support.cglib.core.i.o, r1, com.alibaba.excel.support.cglib.core.i.l, r2});
        m = new ag("CGLIB$findMethodProxy", r2, new aa[]{com.alibaba.excel.support.cglib.core.i.I});
        n = ai.c("String toString()");
        o = new AnonymousClass1();
        p = ai.e("String, String");
    }

    q() {
    }

    private String a(ag r1) {
        return r1.a() + "$Method";
    }

    private static void a(com.alibaba.excel.support.cglib.core.g r2, w r3, d.a r4) {
        d.a r5 = (d.a) ZeusTransformUtils.wrapperContextForParams(r4, d.a.class, "com.obric.memorydata.plugin");
        if (ai.e(r3.b()) == false) goto L5;
        r2.a(c, r3.toString() + " is abstract");
        return;
    L5:
        r2.u();
        r5.a(r2, r3);
    }

    private String b(ag r1) {
        return r1.a() + "$Proxy";
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r12, d.a r13, List r14) {
        d.a r15 = (d.a) ZeusTransformUtils.wrapperContextForParams(r13, d.a.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L10;
        w r2 = (w) ZeusTransformUtils.preCheckCast(r17.next(), w.class, "com.obric.memorydata.plugin");
        ag r3 = r2.c();
        ag r4 = r15.c(r2);
        String r5 = a(r4);
        String r6 = b(r4);
        r0.put(r3.toString(), r6);
        r12.a(26, r5, d, null);
        r12.a(26, r6, f, null);
        r12.a(26, "CGLIB$emptyArgs", com.alibaba.excel.support.cglib.core.i.l, null);
        com.alibaba.excel.support.cglib.core.g r7 = r12.a(16, r4, r2.d());
        a(r7, r2, r15);
        r7.w();
        r7.g();
        com.alibaba.excel.support.cglib.core.g r8 = r15.a(r12, r2);
        com.alibaba.excel.support.asm.q r9 = r8.D();
        r15.a(r8, r15.b(r2));
        r8.k();
        r8.c(r9);
        r8.u();
        r8.b(r5);
        if (r3.d().length != 0) goto L8;
        r8.b("CGLIB$emptyArgs");
    L9:
        r8.b(r6);
        r8.a(g, l);
        r8.k(r3.c());
        r8.w();
        r8.e(r9);
        a(r8, r2, r15);
        r8.w();
        r8.g();
        goto L4
    L8:
        r8.I();
        goto L9
    L10:
        a(r12, r0);
    }

    public void a(com.alibaba.excel.support.cglib.core.d r5, Map r6) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        final com.alibaba.excel.support.cglib.core.g r8 = r5.a(9, m, null);
        r8.c(0);
        r8.b(com.alibaba.excel.support.cglib.core.i.o, n);
        com.alibaba.excel.support.cglib.core.aa r2 = new AnonymousClass2(this, r8, r7);
        com.alibaba.excel.support.cglib.core.o.a(r8, (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r7.keySet().toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin"), 1, r2);
        r8.g();
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.g r12, d.a r13, List r14) {
        d.a r15 = (d.a) ZeusTransformUtils.wrapperContextForParams(r13, d.a.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        r12.b(0);
        r12.s();
        r12.c("CGLIB$emptyArgs");
        u r2 = r12.E();
        u r3 = r12.E();
        com.alibaba.excel.support.cglib.core.o.a(r12);
        r12.a(r2);
        Map r17 = com.alibaba.excel.support.cglib.core.h.a(r16, o);
        Iterator r4 = r17.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        com.alibaba.excel.support.cglib.core.f r5 = (com.alibaba.excel.support.cglib.core.f) ZeusTransformUtils.preCheckCast(r4.next(), com.alibaba.excel.support.cglib.core.f.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r17.get(r5), List.class, "com.obric.memorydata.plugin");
        r12.b(r6.size() * 2);
        r12.b(com.alibaba.excel.support.cglib.core.i.A);
        int r7 = 0;
    L7:
        if (r7 >= r6.size()) goto L9;
        ag r8 = ((w) ZeusTransformUtils.preCheckCast(r6.get(r7), w.class, "com.obric.memorydata.plugin")).c();
        r12.k();
        int r9 = r7 * 2;
        r12.b(r9);
        r12.a(r8.a());
        r12.B();
        r12.k();
        r12.b(r9 + 1);
        r12.a(r8.b());
        r12.B();
        r7 = r7 + 1;
        goto L7
    L9:
        com.alibaba.excel.support.cglib.core.o.a(r12, r5.getType());
        r12.k();
        r12.a(r3);
        r12.b(com.alibaba.excel.support.cglib.core.i.p, h);
        r12.c(e, j);
        int r10 = 0;
    L11:
        if (r10 >= r6.size()) goto L13;
        w r11 = (w) ZeusTransformUtils.preCheckCast(r6.get(r10), w.class, "com.obric.memorydata.plugin");
        ag r18 = r11.c();
        ag r19 = r15.c(r11);
        r12.k();
        r12.b(r10);
        r12.a(d);
        r12.c(a(r19));
        r12.b(r3);
        r12.b(r2);
        r12.a(r18.b());
        r12.a(r18.a());
        r12.a(r19.a());
        r12.c(f, k);
        r12.c(b(r19));
        r10 = r10 + 1;
        goto L11
    L13:
        r12.i();
        goto L4
    }
}
