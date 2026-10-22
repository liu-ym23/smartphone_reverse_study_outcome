package com.tom_roush.fontbox.c;

/* JADX INFO: loaded from: classes6.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f15951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char f15952b;
    private final int c;

    a(char r1, char r2, int r3) {
        this.f15951a = r1;
        this.f15952b = r2;
        this.c = r3;
    }

    public int a(char r3) {
        char r0 = this.f15951a;
        if (r0 <= r3) goto L5;
        return -1;
    L5:
        if (r3 <= this.f15952b) goto L7;
        return -1;
    L7:
        return this.c + (r3 - r0);
    }

    public boolean a(char r3, char r4, int r5) {
        char r0 = this.f15952b;
        if (r3 == (r0 + 1)) goto L5;
        return false;
    L5:
        if (r5 != (((this.c + r0) - this.f15951a) + 1)) goto L10;
        this.f15952b = r4;
        return true;
    L10:
        return false;
    }
}
