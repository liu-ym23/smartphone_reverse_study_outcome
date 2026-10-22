package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7742g;

    public a(View r10) {
        this.f7741f = true;
        this.f7742g = true;
        this.f7736a = r10;
    }

    void a() {
        View r10 = this.f7736a;
        ViewCompat.offsetTopAndBottom(r10, this.f7739d - (r10.getTop() - this.f7737b));
        View r11 = this.f7736a;
        ViewCompat.offsetLeftAndRight(r11, this.f7740e - (r11.getLeft() - this.f7738c));
    }

    public int b() {
        return this.f7740e;
    }

    public int c() {
        return this.f7739d;
    }

    public boolean d() {
        return this.f7742g;
    }

    public boolean e() {
        return this.f7741f;
    }

    void f() {
        this.f7737b = this.f7736a.getTop();
        this.f7738c = this.f7736a.getLeft();
    }

    public void g(boolean r10) {
        this.f7742g = r10;
    }

    public boolean h(int r10) {
        if (this.f7742g == true) goto L5;
        return false;
    L5:
        if (this.f7740e == r10) goto L10;
        this.f7740e = r10;
        a();
        return true;
    L10:
        return false;
    }

    public boolean i(int r10) {
        if (this.f7741f == true) goto L5;
        return false;
    L5:
        if (this.f7739d == r10) goto L10;
        this.f7739d = r10;
        a();
        return true;
    L10:
        return false;
    }

    public void j(boolean r10) {
        this.f7741f = r10;
    }
}
