package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f340b;
    final String c;
    final String d;
    final String e;
    final long f;
    int g;

    y(int r1, int r2, String r3, String r4, String r5, long r6) {
        this.f339a = r1;
        this.f340b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    int a() {
        if (this.g != 0) goto L6;
        this.g = aa.f(this.e);
    L6:
        return this.g;
    }
}
