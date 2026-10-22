package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class k extends com.tom_roush.pdfbox.pdmodel.common.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f16154a;

    public k(com.tom_roush.pdfbox.a.d r1, j r2) {
        super(r1);
        this.f16154a = r2;
    }

    public k(j r1) {
        this.f16154a = r1;
    }

    private void a(Object r1, Object r2) {
        if (b(r1, r2) == false) goto L6;
        this.f16154a.c(this);
        return;
    }

    private boolean b(Object r1, Object r2) {
        if (r1 != null) goto L9;
        if (r2 != null) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true ^ r1.equals(r2);
    }

    public void a(com.tom_roush.pdfbox.a.b r2) {
        a(c(), r2);
        a().a(com.tom_roush.pdfbox.a.i.iM, r2);
    }

    public void a(String r2) {
        a(b(), r2);
        a().a(com.tom_roush.pdfbox.a.i.fg, r2);
    }

    public void a(boolean r3) {
        a(Boolean.valueOf(f()), Boolean.valueOf(r3));
        a().a(com.tom_roush.pdfbox.a.i.dy, r3);
    }

    public String b() {
        return a().g(com.tom_roush.pdfbox.a.i.fg);
    }

    public void b(String r2) {
        a(d(), r2);
        a().b(com.tom_roush.pdfbox.a.i.cL, r2);
    }

    public com.tom_roush.pdfbox.a.b c() {
        return a().a(com.tom_roush.pdfbox.a.i.iM);
    }

    public String d() {
        return a().h(com.tom_roush.pdfbox.a.i.cL);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.e
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (super.equals(r5) == true) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        j r4 = this.f16154a;
        if (r4 != null) goto L17;
        if (r6.f16154a == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r4.equals(r6.f16154a) == true) goto L19;
        return false;
    }

    public boolean f() {
        return a().b(com.tom_roush.pdfbox.a.i.dy, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.e
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        j r1 = this.f16154a;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Name=" + b() + ", Value=" + c() + ", FormattedValue=" + d() + ", Hidden=" + f();
    }
}
