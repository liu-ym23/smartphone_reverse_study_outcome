package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f13876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13878c;
    public boolean d;
    public boolean e;

    public final void a() {
        if (this.d == false) goto L5;
        int r5 = this.f13876a.f();
    L6:
        this.f13878c = r5;
        return;
    L5:
        r5 = this.f13876a.i();
        goto L6
    }

    public final void b(View r5, int r10) {
        if (this.d == false) goto L5;
        int r11 = this.f13876a.a(r5);
        this.f13878c = this.f13876a.k() + r11;
    L6:
        this.f13877b = r10;
        return;
    L5:
        this.f13878c = this.f13876a.d(r5);
        goto L6
    }

    public final void c(View r5, int r10) {
        int r11 = this.f13876a.k();
        if (r11 < 0) goto L6;
        b(r5, r10);
        return;
    L6:
        this.f13877b = r10;
        if (this.d == false) goto L13;
        int r12 = (this.f13876a.f() - r11) - this.f13876a.a(r5);
        this.f13878c = this.f13876a.f() - r12;
        if (r12 <= 0) goto L19;
        int r13 = this.f13878c - this.f13876a.b(r5);
        int r14 = this.f13876a.i();
        int r15 = r13 - (Math.min(this.f13876a.d(r5) - r14, 0) + r14);
        if (r15 >= 0) goto L20;
        this.f13878c = Math.min(r12, -r15) + this.f13878c;
        return;
    L20:
        return;
    L19:
        return;
    L13:
        int r16 = this.f13876a.d(r5);
        int r17 = r16 - this.f13876a.i();
        this.f13878c = r16;
        if (r17 <= 0) goto L22;
        int r18 = (this.f13876a.f() - Math.min(0, (this.f13876a.f() - r11) - this.f13876a.a(r5))) - (this.f13876a.b(r5) + r16);
        if (r18 >= 0) goto L23;
        this.f13878c -= Math.min(r17, -r18);
        return;
    L23:
        return;
    }

    public final void d() {
        this.f13877b = -1;
        this.f13878c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AnchorInfo{mPosition=");
        r5.append(this.f13877b);
        r5.append(", mCoordinate=");
        r5.append(this.f13878c);
        r5.append(", mLayoutFromEnd=");
        r5.append(this.d);
        r5.append(", mValid=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.e, '}');
    }
}
