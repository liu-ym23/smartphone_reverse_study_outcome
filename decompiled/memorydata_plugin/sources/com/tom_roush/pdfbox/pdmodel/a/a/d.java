package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16145a = "MCR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16146b;

    public d() {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16146b = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, f16145a);
    }

    public d(com.tom_roush.pdfbox.a.d r1) {
        this.f16146b = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16146b;
    }

    public void a(int r2) {
        a().a(com.tom_roush.pdfbox.a.i.eU, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.g r2) {
        a().a(com.tom_roush.pdfbox.a.i.gp, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.g b() {
        com.tom_roush.pdfbox.a.d r2 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(a().a(com.tom_roush.pdfbox.a.i.gp), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.g(r2);
    }

    public int c() {
        return a().i(com.tom_roush.pdfbox.a.i.eU);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public String toString() {
        return "mcid=" + c();
    }
}
