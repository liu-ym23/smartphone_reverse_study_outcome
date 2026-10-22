package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final aa f457b = null;
    private static final aa c = null;
    private static final aa d = null;
    private static final ag e = null;

    static {
        f456a = new m();
        f457b = ai.d("com.alibaba.excel.support.cglib.proxy.InvocationHandler");
        c = ai.d("com.alibaba.excel.support.cglib.proxy.UndeclaredThrowableException");
        d = ai.d("java.lang.reflect.Method");
        e = ai.c("Object invoke(Object, java.lang.reflect.Method, Object[])");
    }

    m() {
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r7, d.a r8, List r9) {
        d.a r6 = (d.a) ZeusTransformUtils.wrapperContextForParams(r8, d.a.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        w r11 = (w) ZeusTransformUtils.preCheckCast(r10.next(), w.class, "com.obric.memorydata.plugin");
        ag r1 = r6.c(r11);
        r7.a(26, r1.a(), d, null);
        com.alibaba.excel.support.cglib.core.g r2 = r6.a(r7, r11);
        com.alibaba.excel.support.cglib.core.c r3 = r2.h();
        r6.a(r2, r6.b(r11));
        r2.u();
        r2.b(r1.a());
        r2.I();
        r2.a(f457b, e);
        r2.i(r11.c().c());
        r2.w();
        r3.a();
        com.alibaba.excel.support.cglib.core.o.a(r2, r3, r11.d(), c);
        r2.g();
        goto L4
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.g r3, d.a r4, List r5) {
        d.a r2 = (d.a) ZeusTransformUtils.wrapperContextForParams(r4, d.a.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        w r7 = (w) ZeusTransformUtils.preCheckCast(r6.next(), w.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.cglib.core.o.a(r3, r7);
        r3.c(r2.c(r7).a());
        goto L4
    }
}
