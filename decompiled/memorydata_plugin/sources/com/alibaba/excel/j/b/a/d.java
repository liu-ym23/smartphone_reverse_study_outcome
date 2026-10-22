package com.alibaba.excel.j.b.a;

import com.alibaba.excel.enums.HolderEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    private c g;
    private Integer h;
    private com.alibaba.excel.j.b.c i;

    public c E() {
        return this.g;
    }

    public Integer F() {
        return this.h;
    }

    public com.alibaba.excel.j.b.c G() {
        return this.i;
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r6 = F();
        Integer r2 = r0.F();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        c r7 = E();
        c r3 = r0.E();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        com.alibaba.excel.j.b.c r4 = G();
        com.alibaba.excel.j.b.c r8 = r0.G();
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

    @Override // com.alibaba.excel.metadata.l
    public HolderEnum h() {
        return HolderEnum.TABLE;
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = F();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        c r6 = E();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        com.alibaba.excel.j.b.c r9 = G();
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
