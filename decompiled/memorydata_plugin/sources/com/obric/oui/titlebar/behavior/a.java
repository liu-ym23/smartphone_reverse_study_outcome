package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes5.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f14782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14783b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;

    public a(View r2) {
        this.f = true;
        this.g = true;
        this.f14782a = r2;
    }

    void a() {
        this.f14783b = this.f14782a.getTop();
        this.c = this.f14782a.getLeft();
    }

    public void a(boolean r1) {
        this.f = r1;
    }

    public boolean a(int r2) {
        if (this.f == true) goto L5;
        return false;
    L5:
        if (this.d == r2) goto L10;
        this.d = r2;
        b();
        return true;
    L10:
        return false;
    }

    void b() {
        View r0 = this.f14782a;
        ViewCompat.offsetTopAndBottom(r0, this.d - (r0.getTop() - this.f14783b));
        View r1 = this.f14782a;
        ViewCompat.offsetLeftAndRight(r1, this.e - (r1.getLeft() - this.c));
    }

    public void b(boolean r1) {
        this.g = r1;
    }

    public boolean b(int r2) {
        if (this.g == true) goto L5;
        return false;
    L5:
        if (this.e == r2) goto L10;
        this.e = r2;
        b();
        return true;
    L10:
        return false;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}
