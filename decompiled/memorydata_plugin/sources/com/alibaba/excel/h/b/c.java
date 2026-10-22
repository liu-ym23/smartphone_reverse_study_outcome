package com.alibaba.excel.h.b;

import com.alibaba.excel.metadata.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c<T> {
    void a(com.alibaba.excel.e.a r1);

    default void a(f r1, com.alibaba.excel.e.a r2) {
        com.alibaba.excel.e.a r0 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }

    default void a(Exception r2, com.alibaba.excel.e.a r3) {
        com.alibaba.excel.e.a r1 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        throw r2;
    }

    void a(T r1, com.alibaba.excel.e.a r2);

    default void a(Map<Integer, com.alibaba.excel.metadata.data.f<?>> r2, com.alibaba.excel.e.a r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.e.a r4 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
    }

    default boolean b(com.alibaba.excel.e.a r2) {
        com.alibaba.excel.e.a r1 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        return true;
    }
}
