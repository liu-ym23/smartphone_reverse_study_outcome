package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f438b = null;
    private static final aa c = null;
    private static final aa d = null;
    private static final ag e = null;
    private static final ag f = null;
    private boolean g;

    static {
        f437a = new g(false);
        f438b = new g(true);
        c = ai.d("com.alibaba.excel.support.cglib.proxy.Dispatcher");
        d = ai.d("com.alibaba.excel.support.cglib.proxy.ProxyRefDispatcher");
        e = ai.c("Object loadObject()");
        f = ai.c("Object loadObject(Object)");
    }

    private g(boolean r1) {
        this.g = r1;
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r6, d.a r7, List r8) {
        d.a r9 = (d.a) ZeusTransformUtils.wrapperContextForParams(r7, d.a.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        w r0 = (w) ZeusTransformUtils.preCheckCast(r10.next(), w.class, "com.obric.memorydata.plugin");
        if (ai.c(r0.b()) == true) goto L4;
        com.alibaba.excel.support.cglib.core.g r2 = r9.a(r6, r0);
        r9.a(r2, r9.b(r0));
        if (this.g == false) goto L10;
        r2.u();
        aa r3 = d;
        ag r4 = f;
    L11:
        r2.a(r3, r4);
        r2.f(r0.a().getType());
        r2.v();
        r2.a(r0);
        r2.w();
        r2.g();
        goto L4
    L10:
        r3 = c;
        r4 = e;
        goto L11
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.g r1, d.a r2, List r3) {
        d.a r0 = (d.a) ZeusTransformUtils.wrapperContextForParams(r2, d.a.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
