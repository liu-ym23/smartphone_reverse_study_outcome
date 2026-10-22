package com.alibaba.excel.a.c.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class i extends b {
    public i() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r2, String r3, Attributes r4) {
        com.alibaba.excel.e.a r1 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        String r5 = ((Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin")).getValue("ref");
        if (o.a(r5) == false) goto L5;
        return;
    L5:
        com.alibaba.excel.metadata.f r6 = new com.alibaba.excel.metadata.f(CellExtraTypeEnum.MERGE, null, r5);
        r1.b().a(r6);
        r1.e().a(r1);
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public boolean a(com.alibaba.excel.e.c.b r2) {
        return ((com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin")).a().B().contains(CellExtraTypeEnum.MERGE);
    }
}
