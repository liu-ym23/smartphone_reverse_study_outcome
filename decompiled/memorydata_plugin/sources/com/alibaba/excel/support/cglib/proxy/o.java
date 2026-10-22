package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ag f459b = null;
    private static final aa c = null;

    static {
        f458a = new o();
        f459b = ai.c("Object loadObject()");
        c = ai.d("com.alibaba.excel.support.cglib.proxy.LazyLoader");
    }

    o() {
    }

    private ag a(int r3) {
        return new ag("CGLIB$LOAD_PRIVATE_" + r3, com.alibaba.excel.support.cglib.core.i.o, com.alibaba.excel.support.cglib.core.i.j);
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r7, d.a r8, List r9) {
        d.a r10 = (d.a) ZeusTransformUtils.wrapperContextForParams(r8, d.a.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        w r2 = (w) ZeusTransformUtils.preCheckCast(r12.next(), w.class, "com.obric.memorydata.plugin");
        if (ai.c(r2.b()) == true) goto L4;
        int r3 = r10.b(r2);
        r0.add(new Integer(r3));
        com.alibaba.excel.support.cglib.core.g r4 = r10.a(r7, r2);
        r4.u();
        r4.k();
        r4.b(a(r3));
        r4.f(r2.a().getType());
        r4.v();
        r4.a(r2);
        r4.w();
        r4.g();
        goto L4
    L9:
        Iterator r13 = r0.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r13.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        String r5 = "CGLIB$LAZY_LOADER_" + r1;
        r7.a(2, r5, com.alibaba.excel.support.cglib.core.i.o, null);
        com.alibaba.excel.support.cglib.core.g r6 = r7.a(50, a(r1), null);
        r6.u();
        r6.b(r5);
        r6.k();
        com.alibaba.excel.support.asm.q r14 = r6.D();
        r6.d(r14);
        r6.i();
        r6.u();
        r10.a(r6, r1);
        r6.a(c, f459b);
        r6.m();
        r6.c(r5);
        r6.e(r14);
        r6.w();
        r6.g();
        goto L11
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.g r1, d.a r2, List r3) {
        d.a r0 = (d.a) ZeusTransformUtils.wrapperContextForParams(r2, d.a.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
