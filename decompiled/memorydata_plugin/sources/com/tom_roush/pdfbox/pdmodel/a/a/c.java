package com.tom_roush.pdfbox.pdmodel.a.a;

/* JADX INFO: loaded from: classes6.dex */
public class c implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16144a;

    public c() {
        this.f16144a = new com.tom_roush.pdfbox.a.d();
    }

    public c(com.tom_roush.pdfbox.a.d r1) {
        this.f16144a = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16144a;
    }

    public void a(boolean r2) {
        this.f16144a.a("Marked", r2);
    }

    public void b(boolean r2) {
        this.f16144a.a(j.f16153a, r2);
    }

    public boolean b() {
        return this.f16144a.b("Marked", false);
    }

    public void c(boolean r2) {
        this.f16144a.a("Suspects", false);
    }

    public boolean c() {
        return this.f16144a.b(j.f16153a, false);
    }

    public boolean d() {
        return this.f16144a.b("Suspects", false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
