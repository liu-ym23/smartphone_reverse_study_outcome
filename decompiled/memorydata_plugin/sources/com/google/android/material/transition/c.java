package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f4243b;
    final boolean c;

    private c(int r1, int r2, boolean r3) {
        this.f4242a = r1;
        this.f4243b = r2;
        this.c = r3;
    }

    static c a(int r2, int r3) {
        return new c(r2, r3, false);
    }

    static c b(int r2, int r3) {
        return new c(r2, r3, true);
    }
}
