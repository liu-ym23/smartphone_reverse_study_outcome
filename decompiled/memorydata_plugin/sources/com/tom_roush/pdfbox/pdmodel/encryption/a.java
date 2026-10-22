package com.tom_roush.pdfbox.pdmodel.encryption;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16196b;

    public a() {
        this.f16196b = false;
        this.f16195a = -4;
    }

    public a(int r2) {
        this.f16196b = false;
        this.f16195a = r2;
    }

    public a(byte[] r3) {
        this.f16196b = false;
        this.f16195a = 0;
        int r0 = 0 | (r3[0] & 255);
        this.f16195a = r0;
        int r1 = r0 << 8;
        this.f16195a = r1;
        int r2 = r1 | (r3[1] & 255);
        this.f16195a = r2;
        int r4 = r2 << 8;
        this.f16195a = r4;
        int r5 = r4 | (r3[2] & 255);
        this.f16195a = r5;
        int r6 = r5 << 8;
        this.f16195a = r6;
        this.f16195a = (r3[3] & 255) | r6;
    }

    public static a a() {
        a r0 = new a();
        r0.g(true);
        r0.c(true);
        r0.f(true);
        r0.e(true);
        r0.b(true);
        r0.d(true);
        r0.a(true);
        r0.h(true);
        return r0;
    }

    private boolean a(int r3, boolean r4) {
        int r0 = this.f16195a;
        if (r4 == false) goto L5;
        int r5 = (1 << (r3 - 1)) | r0;
    L6:
        this.f16195a = r5;
        if (((1 << (r3 - 1)) & r5) != 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        r5 = (~(1 << (r3 - 1))) & r0;
        goto L6
    }

    public void a(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(3, r2);
        return;
    }

    public void b() {
        this.f16196b = true;
    }

    public void b(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(4, r2);
        return;
    }

    public void c(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(5, r2);
        return;
    }

    public void d(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(6, r2);
        return;
    }

    public void e(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(9, r2);
        return;
    }

    public void f(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(10, r2);
        return;
    }

    public void g(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(11, r2);
        return;
    }

    public void h(boolean r2) {
        if (this.f16196b == true) goto L6;
        a(12, r2);
        return;
    }
}
