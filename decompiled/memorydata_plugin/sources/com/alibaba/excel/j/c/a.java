package com.alibaba.excel.j.c;

import com.alibaba.excel.metadata.a.d;
import com.alibaba.excel.metadata.a.h;
import com.alibaba.excel.metadata.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f245b;
    private h c;

    @Override // com.alibaba.excel.metadata.a.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.alibaba.excel.metadata.a.d
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        i r6 = f();
        i r2 = r0.f();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        i r7 = g();
        i r3 = r0.g();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        h r4 = h();
        h r8 = r0.h();
        if (r4 != null) goto L33;
        if (r8 != null) goto L34;
    L35:
        return true;
    L34:
        return false;
    L33:
        if (r4.equals(r8) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    public i f() {
        return this.f244a;
    }

    public i g() {
        return this.f245b;
    }

    public h h() {
        return this.c;
    }

    @Override // com.alibaba.excel.metadata.a.d
    public int hashCode() {
        int r0 = super.hashCode();
        i r1 = f();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        i r6 = g();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        h r9 = h();
        int r10 = (r7 + r8) * 59;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        return r10 + r3;
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
