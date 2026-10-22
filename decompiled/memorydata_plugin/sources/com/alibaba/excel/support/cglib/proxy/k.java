package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final aa f455b = null;
    private static final ag c = null;

    static {
        f454a = new k();
        f455b = ai.d("com.alibaba.excel.support.cglib.proxy.FixedValue");
        c = ai.c("Object loadObject()");
    }

    k() {
    }

    @Override // com.alibaba.excel.support.cglib.proxy.d
    public void a(com.alibaba.excel.support.cglib.core.d r4, d.a r5, List r6) {
        d.a r3 = (d.a) ZeusTransformUtils.wrapperContextForParams(r5, d.a.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        w r8 = (w) ZeusTransformUtils.preCheckCast(r7.next(), w.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.cglib.core.g r1 = r3.a(r4, r8);
        r3.a(r1, r3.b(r8));
        r1.a(f455b, c);
        r1.k(r1.e());
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
