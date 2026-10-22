package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f4137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f4138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f4139c;

    private c(int r10, int r11, boolean r12) {
        this.f4137a = r10;
        this.f4138b = r11;
        this.f4139c = r12;
    }

    static c a(int r10, int r11) {
        return new c(r10, r11, true);
    }

    static c b(int r10, int r11) {
        return new c(r10, r11, false);
    }
}
