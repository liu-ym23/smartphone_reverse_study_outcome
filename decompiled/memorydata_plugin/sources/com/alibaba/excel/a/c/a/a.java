package com.alibaba.excel.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends b {
    public a() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r2, char[] r3, int r4, int r5) {
        ((com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin")).g().z().append(r3, r4, r5);
    }
}
