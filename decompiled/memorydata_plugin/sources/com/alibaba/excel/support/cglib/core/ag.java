package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f375b;

    public ag(String r1, com.alibaba.excel.support.asm.aa r2, com.alibaba.excel.support.asm.aa[] r3) {
        this(r1, com.alibaba.excel.support.asm.aa.a(r2, r3));
    }

    public ag(String r2, String r3) {
        if (r2.indexOf(40) >= 0) goto L7;
        this.f374a = r2;
        this.f375b = r3;
        return;
    L7:
        throw new IllegalArgumentException("Name '" + r2 + "' is invalid");
    }

    public String a() {
        return this.f374a;
    }

    public String b() {
        return this.f375b;
    }

    public com.alibaba.excel.support.asm.aa c() {
        return com.alibaba.excel.support.asm.aa.d(this.f375b);
    }

    public com.alibaba.excel.support.asm.aa[] d() {
        return com.alibaba.excel.support.asm.aa.c(this.f375b);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ag.class) == true) goto L8;
        return false;
    L8:
        ag r5 = (ag) ZeusTransformUtils.preCheckCast(r4, ag.class, "com.obric.memorydata.plugin");
        if (this.f374a.equals(r5.f374a) == true) goto L11;
        return false;
    L11:
        if (this.f375b.equals(r5.f375b) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        int r0 = this.f374a.hashCode();
        return this.f375b.hashCode() ^ r0;
    }

    public String toString() {
        return this.f374a + this.f375b;
    }
}
