package com.alibaba.excel.g;

import com.alibaba.excel.h.b.c;
import com.alibaba.excel.i.d;
import com.alibaba.excel.metadata.data.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements c<T> {
    public a() {
    }

    @Override // com.alibaba.excel.h.b.c
    public void a(Map<Integer, f<?>> r3, com.alibaba.excel.e.a r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r6 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        b(d.a(r5, r6), r6);
    }

    public void b(Map<Integer, String> r2, com.alibaba.excel.e.a r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r4 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }
}
