package com.tom_roush.pdfbox.pdmodel.a.a;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends com.tom_roush.pdfbox.pdmodel.common.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f16143a;

    public a() {
    }

    public a(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public static a a(com.tom_roush.pdfbox.a.d r2) {
        String r0 = r2.g(com.tom_roush.pdfbox.a.i.ft);
        if (j.f16153a.equals(r0) == false) goto L7;
        return new j(r2);
    L7:
        if (com.tom_roush.pdfbox.pdmodel.a.d.e.f16168a.equals(r0) == false) goto L11;
        return new com.tom_roush.pdfbox.pdmodel.a.d.e(r2);
    L11:
        if (com.tom_roush.pdfbox.pdmodel.a.d.f.f16170a.equals(r0) == false) goto L15;
        return new com.tom_roush.pdfbox.pdmodel.a.d.f(r2);
    L15:
        if ("Table".equals(r0) == false) goto L19;
        return new com.tom_roush.pdfbox.pdmodel.a.d.h(r2);
    L19:
        if (com.tom_roush.pdfbox.pdmodel.a.d.d.h.equals(r0) == false) goto L23;
        return new com.tom_roush.pdfbox.pdmodel.a.d.d(r2);
    L23:
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.f16162a.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.f16163b.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.c.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.d.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.e.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.f.equals(r0) == true) goto L40;
        if (com.tom_roush.pdfbox.pdmodel.a.d.b.g.equals(r0) == true) goto L40;
        return new b(r2);
    L40:
        return new com.tom_roush.pdfbox.pdmodel.a.d.b(r2);
    }

    public static String a(float[] r3) {
        StringBuilder r0 = new StringBuilder("[");
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r0.append(r3[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.append(']').toString();
    }

    public static String a(Object[] r3) {
        StringBuilder r0 = new StringBuilder("[");
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r0.append(r3[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.append(']').toString();
    }

    private boolean b(com.tom_roush.pdfbox.a.b r1, com.tom_roush.pdfbox.a.b r2) {
        if (r1 != null) goto L9;
        if (r2 != null) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true ^ r1.equals(r2);
    }

    private g f() {
        return this.f16143a;
    }

    public void a(com.tom_roush.pdfbox.a.b r1, com.tom_roush.pdfbox.a.b r2) {
        if (b(r1, r2) == false) goto L6;
        d();
        return;
    }

    public void a(g r1) {
        this.f16143a = r1;
    }

    public void a(String r2) {
        a().a(com.tom_roush.pdfbox.a.i.ft, r2);
    }

    public String b() {
        return a().g(com.tom_roush.pdfbox.a.i.ft);
    }

    public boolean c() {
        if (a().a() == 1) goto L5;
    L7:
        return false;
    L5:
        if (b() == null) goto L7;
        return true;
    }

    public void d() {
        if (f() == null) goto L6;
        f().c(this);
        return;
    }

    public String toString() {
        return "O=" + b();
    }
}
