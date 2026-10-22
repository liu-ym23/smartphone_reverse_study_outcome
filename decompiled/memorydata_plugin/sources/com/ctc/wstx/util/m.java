package com.ctc.wstx.util;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private char[] f3709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3710b;
    private String c;

    public m(int r3) {
        int r4 = r3 << 4;
        if (r4 >= 60) goto L5;
        r4 = 60;
    L7:
        this.f3709a = new char[r4];
        return;
    L5:
        if (r4 <= 120) goto L7;
        r4 = 120;
        goto L7
    }

    private void c(int r6) {
        char[] r0 = this.f3709a;
        int r1 = r0.length;
        int r2 = r1 >> 1;
        int r3 = this.f3710b;
        int r7 = r6 - (r1 - r3);
        if (r2 >= r7) goto L5;
        r2 = r7;
    L5:
        char[] r8 = new char[r1 + r2];
        this.f3709a = r8;
        System.arraycopy(r0, 0, r8, 0, r3);
    }

    public void a() {
        this.f3710b = 0;
        this.c = null;
    }

    public void a(int r1) {
        this.f3710b = r1;
    }

    public String b() {
        if (this.c != null) goto L6;
        this.c = new String(this.f3709a, 0, this.f3710b);
    L6:
        return this.c;
    }

    public char[] b(int r2) {
        this.f3710b = this.f3709a.length;
        c(r2);
        return this.f3709a;
    }

    public char[] c() {
        return this.f3709a;
    }

    public int d() {
        return this.f3710b;
    }

    public String toString() {
        return new String(this.f3709a, 0, this.f3710b);
    }
}
