package com.alibaba.excel.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements k {
    public b() {
    }

    @Override // com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, String r2) {
        com.alibaba.excel.e.c.b r0 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, String r2, Attributes r3) {
        com.alibaba.excel.e.c.b r0 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        Attributes r4 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r3, Attributes.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, char[] r2, int r3, int r4) {
        com.alibaba.excel.e.c.b r0 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.a.c.a.k
    public boolean a(com.alibaba.excel.e.c.b r2) {
        com.alibaba.excel.e.c.b r1 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        return true;
    }
}
