package com.alibaba.excel.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface a extends c {
    @Override // com.alibaba.excel.h.b.c
    default void a(Exception r1, com.alibaba.excel.e.a r2) {
        com.alibaba.excel.e.a r0 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }
}
