package com.alibaba.excel.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.c.c f141a;

    public a(com.alibaba.excel.c.c r3) {
        this.f141a = (com.alibaba.excel.c.c) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.c.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.c.a.b
    public com.alibaba.excel.c.c a(PackagePart r1) {
        return this.f141a;
    }
}
