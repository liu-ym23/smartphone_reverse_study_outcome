package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class l implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f391a = null;

    static {
        f391a = new l();
    }

    public l() {
    }

    public k a() {
        return new k(2);
    }

    @Override // com.alibaba.excel.support.cglib.core.q
    public byte[] a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        k r0 = a();
        b(r4).a(r0);
        return a(r0.b());
    }

    public byte[] a(byte[] r1) {
        return r1;
    }

    public e b(e r2) {
        return (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    }
}
