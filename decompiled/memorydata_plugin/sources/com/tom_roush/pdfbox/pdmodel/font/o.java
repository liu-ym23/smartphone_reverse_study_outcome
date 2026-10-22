package com.tom_roush.pdfbox.pdmodel.font;

/* JADX INFO: loaded from: classes6.dex */
public final class o implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16246a;

    o(com.tom_roush.pdfbox.a.d r1) {
        this.f16246a = r1;
    }

    public String a() {
        return this.f16246a.g(com.tom_roush.pdfbox.a.i.gR);
    }

    public String b() {
        return this.f16246a.g(com.tom_roush.pdfbox.a.i.fN);
    }

    public int c() {
        return this.f16246a.i(com.tom_roush.pdfbox.a.i.hU);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.f16246a;
    }

    public String toString() {
        return a() + "-" + b() + "-" + c();
    }
}
