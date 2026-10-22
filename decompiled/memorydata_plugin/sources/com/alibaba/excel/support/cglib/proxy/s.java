package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class s implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f465a = null;

    static {
        f465a = new s();
    }

    s() {
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r3, d.a r4, List r5) {
        d.a r2 = (d.a) ZeusTransformUtils.wrapperContextForParams(r4, d.a.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        w r7 = (w) ZeusTransformUtils.preCheckCast(r6.next(), w.class, "com.obric.memorydata.plugin");
        if (ai.g(r7.b()) == true) goto L11;
        if (ai.c(r2.a(r7)) == false) goto L4;
        if (ai.d(r7.b()) == false) goto L4;
    L11:
        com.alibaba.excel.support.cglib.core.g r1 = com.alibaba.excel.support.cglib.core.o.a(r3, r7);
        r1.u();
        r2.a(r1, r7);
        r1.w();
        r1.g();
        goto L4
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.g r1, d.a r2, List r3) {
        d.a r0 = (d.a) ZeusTransformUtils.wrapperContextForParams(r2, d.a.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }
}
