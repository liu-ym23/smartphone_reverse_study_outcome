package com.alibaba.excel.h.c.a.a;

import com.alibaba.excel.h.c.a.d;
import com.alibaba.excel.h.c.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    public a(com.alibaba.excel.h.c.b r1, e r2) {
        super(r1, r2);
    }

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L9;
        return false;
    L9:
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        return super.hashCode();
    }
}
