package com.alibaba.excel.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public c() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, String r2) {
        com.alibaba.excel.h.c.a.c.a r0 = ((com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin")).g();
        com.alibaba.excel.metadata.data.e r3 = new com.alibaba.excel.metadata.data.e();
        r3.a(r0.A().toString());
        r0.v().a(r3);
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r1, String r2, Attributes r3) {
        com.alibaba.excel.e.c.b r0 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r1, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        Attributes r4 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r3, Attributes.class, "com.obric.memorydata.plugin");
        r0.g().b(new StringBuilder());
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r2, char[] r3, int r4, int r5) {
        ((com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin")).g().A().append(r3, r4, r5);
    }
}
