package com.tom_roush.pdfbox.pdmodel.interactive.action;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements com.tom_roush.pdfbox.pdmodel.common.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tom_roush.pdfbox.a.d f16289a;

    public a() {
        this.f16289a = new com.tom_roush.pdfbox.a.d();
        a("Action");
    }

    public a(com.tom_roush.pdfbox.a.d r1) {
        this.f16289a = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16289a;
    }

    public final void a(String r2) {
        this.f16289a.a(com.tom_roush.pdfbox.a.i.iz, r2);
    }

    public void b(String r2) {
        this.f16289a.a(com.tom_roush.pdfbox.a.i.he, r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public String getType() {
        return this.f16289a.g(com.tom_roush.pdfbox.a.i.iz);
    }
}
