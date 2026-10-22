package com.alibaba.excel.metadata.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f249b;

    public b(String r1, Boolean r2) {
        this.f248a = r1;
        this.f249b = r2;
    }

    public static b a(com.alibaba.excel.b.a.a r2) {
        com.alibaba.excel.b.a.a r3 = (com.alibaba.excel.b.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.b.a.a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new b(r3.a(), Boolean.valueOf(com.alibaba.excel.i.b.a(r3.b().getBooleanValue())));
    }

    public String a() {
        return this.f248a;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    public Boolean b() {
        return this.f249b;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Boolean r0 = b();
        Boolean r2 = r6.b();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        String r4 = a();
        String r7 = r6.a();
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
        Boolean r0 = b();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        String r3 = a();
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
