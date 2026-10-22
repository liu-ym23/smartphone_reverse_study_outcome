package com.alibaba.excel.h.c.a;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.i.i;
import com.alibaba.excel.metadata.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.alibaba.excel.metadata.b implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.h.c.b.a f180b;
    private List<com.alibaba.excel.h.b.c<?>> c;

    public a() {
    }

    public a(com.alibaba.excel.h.c.a r5, a r6) {
        super(r5, r6);
        if (r5.g() != null) goto L6;
        if (r6 == null) goto L8;
        j r0 = f();
        Boolean r1 = r6.f().d();
    L7:
        r0.c(r1);
    L8:
        this.f180b = new com.alibaba.excel.h.c.b.a(this, e(), d());
        if (r5.i() != null) goto L17;
        if (r6 == null) goto L12;
        Integer r2 = r6.k();
    L18:
        this.f179a = r2;
        if (r6 != null) goto L21;
        ArrayList r3 = i.a();
    L22:
        this.c = r3;
        if (HolderEnum.WORKBOOK.equals(h()) == false) goto L30;
        Boolean r4 = ((com.alibaba.excel.h.c.c) ZeusTransformUtils.preCheckCast(r5, com.alibaba.excel.h.c.c.class, "com.obric.memorydata.plugin")).w();
        if (r4 != null) goto L27;
    L28:
        this.c.add(new com.alibaba.excel.h.b.b());
        goto L30
    L27:
        if (r4.booleanValue() == true) goto L28;
    L30:
        if (r5.j() != null) goto L32;
    L34:
        if (r6 != null) goto L36;
        a(com.alibaba.excel.f.d.a());
    L38:
        if (r5.c() != null) goto L40;
        return;
    L40:
        if (r5.c().isEmpty() == true) goto L47;
        Iterator<com.alibaba.excel.f.b<?>> r7 = r5.c().iterator();
    L43:
        if (r7.hasNext() == false) goto L48;
        com.alibaba.excel.f.b<?> r8 = (com.alibaba.excel.f.b) ZeusTransformUtils.preCheckCast(r7.next(), com.alibaba.excel.f.b.class, "com.obric.memorydata.plugin");
        g().put(com.alibaba.excel.f.c.a(r8.a(), r8.b()), r8);
        goto L43
    L48:
        return;
    L47:
        return;
    L36:
        a(new HashMap(r6.g()));
        goto L38
    L32:
        if (r5.j().isEmpty() == true) goto L34;
        this.c.addAll(r5.j());
        goto L34
    L21:
        r3 = i.a(r6.m());
        goto L22
    L12:
        if (this.f180b.a() == false) goto L14;
        int r9 = this.f180b.d();
    L15:
        r2 = Integer.valueOf(r9);
        goto L18
    L14:
        r9 = 1;
        goto L15
    L17:
        r2 = r5.i();
        goto L18
    L6:
        r0 = f();
        r1 = r5.g();
        goto L7
    }

    @Override // com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.alibaba.excel.metadata.b
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
        Integer r6 = k();
        Integer r2 = r0.k();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        com.alibaba.excel.h.c.b.a r7 = l();
        com.alibaba.excel.h.c.b.a r3 = r0.l();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        List<com.alibaba.excel.h.b.c<?>> r4 = m();
        List<com.alibaba.excel.h.b.c<?>> r8 = r0.m();
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

    @Override // com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = k();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        com.alibaba.excel.h.c.b.a r6 = l();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        List<com.alibaba.excel.h.b.c<?>> r9 = m();
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

    @Override // com.alibaba.excel.h.c.a.b
    public List<com.alibaba.excel.h.b.c<?>> i() {
        return m();
    }

    @Override // com.alibaba.excel.h.c.a.b
    public com.alibaba.excel.h.c.b.a j() {
        return l();
    }

    public Integer k() {
        return this.f179a;
    }

    public com.alibaba.excel.h.c.b.a l() {
        return this.f180b;
    }

    public List<com.alibaba.excel.h.b.c<?>> m() {
        return this.c;
    }
}
