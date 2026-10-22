package com.alibaba.excel.h.a;

import com.alibaba.excel.h.a.a;
import com.alibaba.excel.h.c.a;
import com.alibaba.excel.i.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a, C extends com.alibaba.excel.h.c.a> extends com.alibaba.excel.metadata.c<T, C> {
    public a() {
    }

    public T a(com.alibaba.excel.h.b.c<?> r4) {
        com.alibaba.excel.h.b.c<?> r5 = (com.alibaba.excel.h.b.c) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin");
        if (((com.alibaba.excel.h.c.a) ZeusTransformUtils.preCheckCast(b(), com.alibaba.excel.h.c.a.class, "com.obric.memorydata.plugin")).j() != null) goto L5;
        ((com.alibaba.excel.h.c.a) ZeusTransformUtils.preCheckCast(b(), com.alibaba.excel.h.c.a.class, "com.obric.memorydata.plugin")).c(i.a());
    L5:
        ((com.alibaba.excel.h.c.a) ZeusTransformUtils.preCheckCast(b(), com.alibaba.excel.h.c.a.class, "com.obric.memorydata.plugin")).j().add(r5);
        return (T) ZeusTransformUtils.preCheckCast(a(), a.class, "com.obric.memorydata.plugin");
    }
}
