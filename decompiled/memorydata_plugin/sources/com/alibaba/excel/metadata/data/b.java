package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b extends ClientAnchorData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f274b;

    public b() {
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r0 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        String r6 = f();
        String r2 = r0.f();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        g r4 = g();
        g r7 = r0.g();
        if (r4 != null) goto L26;
        if (r7 != null) goto L27;
    L28:
        return true;
    L27:
        return false;
    L26:
        if (r4.equals(r7) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    public String f() {
        return this.f273a;
    }

    public g g() {
        return this.f274b;
    }

    @Override // com.alibaba.excel.metadata.data.ClientAnchorData, com.alibaba.excel.metadata.data.c
    public int hashCode() {
        int r0 = super.hashCode();
        String r1 = f();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        g r5 = g();
        int r6 = (r2 + r4) * 59;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
