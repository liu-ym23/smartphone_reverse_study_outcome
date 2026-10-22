package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f2984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2990g;

    public a(View r10) {
        this.f2989f = true;
        this.f2990g = true;
        this.f2984a = r10;
    }

    void a() {
        View r10 = this.f2984a;
        ViewCompat.offsetTopAndBottom(r10, this.f2987d - (r10.getTop() - this.f2985b));
        View r11 = this.f2984a;
        ViewCompat.offsetLeftAndRight(r11, this.f2988e - (r11.getLeft() - this.f2986c));
    }

    public int b() {
        return this.f2985b;
    }

    public int c() {
        return this.f2988e;
    }

    public int d() {
        return this.f2987d;
    }

    public boolean e() {
        return this.f2990g;
    }

    public boolean f() {
        return this.f2989f;
    }

    void g() {
        this.f2985b = this.f2984a.getTop();
        this.f2986c = this.f2984a.getLeft();
    }

    public void h(boolean r10) {
        this.f2990g = r10;
    }

    public boolean i(int r10) {
        if (this.f2990g == true) goto L5;
        return false;
    L5:
        if (this.f2988e == r10) goto L10;
        this.f2988e = r10;
        a();
        return true;
    L10:
        return false;
    }

    public boolean j(int r10) {
        if (this.f2989f == true) goto L5;
        return false;
    L5:
        if (this.f2987d == r10) goto L10;
        this.f2987d = r10;
        a();
        return true;
    L10:
        return false;
    }

    public void k(boolean r10) {
        this.f2989f = r10;
    }
}
