package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.j.b.b.b f283b;
    private List<Object> c;

    public g() {
    }

    public String a() {
        return this.f282a;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, g.class);
    }

    public com.alibaba.excel.j.b.b.b b() {
        return this.f283b;
    }

    public List<Object> c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        String r0 = a();
        String r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        com.alibaba.excel.j.b.b.b r1 = b();
        com.alibaba.excel.j.b.b.b r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        List<Object> r4 = c();
        List<Object> r7 = r6.c();
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
        String r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        com.alibaba.excel.j.b.b.b r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        List<Object> r6 = c();
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
