package com.alibaba.excel.h.c;

import com.alibaba.excel.metadata.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.alibaba.excel.h.b.c<?>> f178b;

    public a() {
        this.f178b = new ArrayList();
    }

    public void a(Integer r1) {
        this.f177a = r1;
    }

    @Override // com.alibaba.excel.metadata.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    public void c(List<com.alibaba.excel.h.b.c<?>> r3) {
        this.f178b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.metadata.d
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
        Integer r6 = i();
        Integer r2 = r0.i();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        List<com.alibaba.excel.h.b.c<?>> r4 = j();
        List<com.alibaba.excel.h.b.c<?>> r7 = r0.j();
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

    @Override // com.alibaba.excel.metadata.d
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = i();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        List<com.alibaba.excel.h.b.c<?>> r5 = j();
        int r6 = (r2 + r4) * 59;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r1.hashCode();
        goto L6
    }

    public Integer i() {
        return this.f177a;
    }

    public List<com.alibaba.excel.h.b.c<?>> j() {
        return this.f178b;
    }
}
