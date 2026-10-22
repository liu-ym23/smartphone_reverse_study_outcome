package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f13836a;

    public j0(k0 r5) {
        this.f13836a = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final View getChildAt(int r5) {
        return this.f13836a.q(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getChildEnd(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13836a.getClass();
        return (r5.getBottom() + ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.bottom) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getChildStart(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13836a.getClass();
        return (r5.getTop() - ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.top) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getParentEnd() {
        k0 r5 = this.f13836a;
        return r5.f13845l - r5.x();
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getParentStart() {
        return this.f13836a.A();
    }
}
