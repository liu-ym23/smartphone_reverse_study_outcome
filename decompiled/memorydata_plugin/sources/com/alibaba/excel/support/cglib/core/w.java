package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public w() {
    }

    public abstract f a();

    public abstract int b();

    public abstract ag c();

    public abstract com.alibaba.excel.support.asm.aa[] d();

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, w.class) == true) goto L9;
        return false;
    L9:
        return c().equals(((w) ZeusTransformUtils.preCheckCast(r4, w.class, "com.obric.memorydata.plugin")).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
