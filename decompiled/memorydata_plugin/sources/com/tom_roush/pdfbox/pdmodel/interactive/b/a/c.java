package com.tom_roush.pdfbox.pdmodel.interactive.b.a;

import com.tom_roush.pdfbox.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tom_roush.pdfbox.a.a f16292a;

    public c() {
        this.f16292a = new com.tom_roush.pdfbox.a.a();
    }

    public c(com.tom_roush.pdfbox.a.a r1) {
        this.f16292a = r1;
    }

    public com.tom_roush.pdfbox.pdmodel.g a() {
        if (this.f16292a.b() <= 0) goto L7;
        com.tom_roush.pdfbox.a.b r3 = this.f16292a.a(0);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == false) goto L7;
        return new com.tom_roush.pdfbox.pdmodel.g((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L7:
        return null;
    }

    public int b() {
        if (this.f16292a.b() <= 0) goto L7;
        com.tom_roush.pdfbox.a.b r2 = this.f16292a.a(0);
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L7;
        return ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.memorydata.plugin")).c();
    L7:
        return -1;
    }

    public com.tom_roush.pdfbox.a.a c() {
        return this.f16292a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return c();
    }
}
