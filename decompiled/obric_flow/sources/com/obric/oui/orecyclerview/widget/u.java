package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends v {
    @Override // com.obric.oui.orecyclerview.widget.v
    public final int a(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13920a.getClass();
        return (r5.getBottom() + ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.bottom) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int b(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13920a.getClass();
        return (k0.u(r5) + ((ViewGroup.MarginLayoutParams) r10).topMargin) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int c(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13920a.getClass();
        return (k0.v(r5) + ((ViewGroup.MarginLayoutParams) r10).leftMargin) + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int d(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13920a.getClass();
        return (r5.getTop() - ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.top) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int e() {
        return this.f13920a.f13845l;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int f() {
        s r5 = this.f13920a;
        return r5.f13845l - r5.x();
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int g() {
        return this.f13920a.x();
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int h() {
        return this.f13920a.f13843j;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int i() {
        return this.f13920a.A();
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int j() {
        s r5 = this.f13920a;
        return (r5.f13845l - r5.A()) - r5.x();
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int l(View r5) {
        s r10 = this.f13920a;
        Rect r11 = this.f13922c;
        r10.C(r5, r11);
        return r11.bottom;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final int m(View r5) {
        s r10 = this.f13920a;
        Rect r11 = this.f13922c;
        r10.C(r5, r11);
        return r11.top;
    }

    @Override // com.obric.oui.orecyclerview.widget.v
    public final void n(int r5) {
        RecyclerView r10 = this.f13920a.f13839b;
        if (r10 == null) goto L7;
        int r11 = r10.e.o();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10.e.n(r12).offsetTopAndBottom(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }
}
