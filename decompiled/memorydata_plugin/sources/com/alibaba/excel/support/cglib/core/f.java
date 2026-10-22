package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public f() {
    }

    public abstract com.alibaba.excel.support.asm.aa a();

    public abstract int b();

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, f.class) == true) goto L9;
        return false;
    L9:
        return getType().equals(((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin")).getType());
    }

    public abstract com.alibaba.excel.support.asm.aa getType();

    public int hashCode() {
        return getType().hashCode();
    }

    public String toString() {
        return getType().b();
    }
}
