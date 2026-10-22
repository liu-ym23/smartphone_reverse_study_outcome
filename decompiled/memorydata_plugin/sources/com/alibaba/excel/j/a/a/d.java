package com.alibaba.excel.j.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.j.a.d f226b;

    public d a() {
        return this.f225a;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    public com.alibaba.excel.j.a.d b() {
        return this.f226b;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        d r0 = a();
        d r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        com.alibaba.excel.j.a.d r4 = b();
        com.alibaba.excel.j.a.d r7 = r6.b();
        if (r4 != null) goto L23;
        if (r7 != null) goto L24;
    L25:
        return true;
    L24:
        return false;
    L23:
        if (r4.equals(r7) == true) goto L25;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public int hashCode() {
        d r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        com.alibaba.excel.j.a.d r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r4 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
