package com.alibaba.excel.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f241a;

    public c() {
    }

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r0 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r4 = s();
        Integer r6 = r0.s();
        if (r4 != null) goto L19;
        if (r6 != null) goto L20;
    L21:
        return true;
    L20:
        return false;
    L19:
        if (r4.equals(r6) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = s();
        int r2 = r0 * 59;
        if (r1 != null) goto L5;
        int r3 = 43;
    L7:
        return r2 + r3;
    L5:
        r3 = r1.hashCode();
        goto L7
    }

    public Integer s() {
        return this.f241a;
    }
}
