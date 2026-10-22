package com.alibaba.excel.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.metadata.data.f<T> f159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.metadata.a.c f160b;
    private com.alibaba.excel.e.a c;

    public f(com.alibaba.excel.metadata.data.f<T> r3, com.alibaba.excel.metadata.a.c r4, com.alibaba.excel.e.a r5) {
        com.alibaba.excel.e.a r6 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        this.f159a = r3;
        this.f160b = r4;
        this.c = r6;
    }

    public com.alibaba.excel.metadata.data.f<T> a() {
        return this.f159a;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, f.class);
    }

    public com.alibaba.excel.metadata.a.c b() {
        return this.f160b;
    }

    public com.alibaba.excel.e.a c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        com.alibaba.excel.metadata.data.f<T> r0 = a();
        com.alibaba.excel.metadata.data.f<T> r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        com.alibaba.excel.metadata.a.c r1 = b();
        com.alibaba.excel.metadata.a.c r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        com.alibaba.excel.e.a r4 = c();
        com.alibaba.excel.e.a r7 = r6.c();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        return true;
    L31:
        return false;
    L30:
        if (r4.equals(r7) == true) goto L32;
    L24:
        return false;
    L23:
        if (r1.equals(r3) == true) goto L25;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public int hashCode() {
        com.alibaba.excel.metadata.data.f<T> r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        com.alibaba.excel.metadata.a.c r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        com.alibaba.excel.e.a r6 = c();
        int r7 = (r4 + r5) * 59;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r7 + r1;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
