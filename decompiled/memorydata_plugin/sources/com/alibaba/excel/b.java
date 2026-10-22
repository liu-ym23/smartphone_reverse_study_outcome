package com.alibaba.excel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static com.alibaba.excel.h.a.b a(InputStream r1) {
        return a(r1, null, null);
    }

    public static com.alibaba.excel.h.a.b a(InputStream r2, com.alibaba.excel.h.b.c r3) {
        return a(r2, null, (com.alibaba.excel.h.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin"));
    }

    public static com.alibaba.excel.h.a.b a(InputStream r2, Class r3, com.alibaba.excel.h.b.c r4) {
        com.alibaba.excel.h.b.c<?> r5 = (com.alibaba.excel.h.b.c) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.h.b.c.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.a.b r0 = new com.alibaba.excel.h.a.b();
        r0.a(r2);
        if (r3 == null) goto L5;
        r0.a(r3);
    L5:
        if (r5 == null) goto L7;
        r0.a(r5);
    L7:
        return r0;
    }
}
