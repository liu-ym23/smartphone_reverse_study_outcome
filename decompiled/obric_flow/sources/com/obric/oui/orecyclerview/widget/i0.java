package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f13832a;

    public i0(k0 r5) {
        this.f13832a = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final View getChildAt(int r5) {
        return this.f13832a.q(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getChildEnd(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13832a.getClass();
        return (r5.getRight() + ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.right) + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getChildStart(View r5) {
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        this.f13832a.getClass();
        return (r5.getLeft() - ((RecyclerView.LayoutParams) r5.getLayoutParams()).f13769b.left) - ((ViewGroup.MarginLayoutParams) r10).leftMargin;
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getParentEnd() {
        k0 r5 = this.f13832a;
        return r5.f13844k - r5.z();
    }

    @Override // com.obric.oui.orecyclerview.widget.b1
    public final int getParentStart() {
        return this.f13832a.y();
    }
}
