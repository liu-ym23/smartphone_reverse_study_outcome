package com.tom_roush.pdfbox.pdmodel.encryption;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tom_roush.pdfbox.a.d f16197a;

    public d() {
        this.f16197a = null;
        this.f16197a = new com.tom_roush.pdfbox.a.d();
    }

    public d(com.tom_roush.pdfbox.a.d r2) {
        this.f16197a = null;
        this.f16197a = r2;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16197a;
    }

    public int b() {
        return this.f16197a.b(com.tom_roush.pdfbox.a.i.ew, 40);
    }

    public com.tom_roush.pdfbox.a.i c() {
        return (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(this.f16197a.a(com.tom_roush.pdfbox.a.i.aA), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
    }

    public boolean d() {
        com.tom_roush.pdfbox.a.b r2 = a().a(com.tom_roush.pdfbox.a.i.cE);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.c.class) == true) goto L5;
        return true;
    L5:
        return ((com.tom_roush.pdfbox.a.c) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.c.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
