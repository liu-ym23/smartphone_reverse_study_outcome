package com.obric.oui.orecyclerview.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13910a;

    public s0(RecyclerView r5) {
        this.f13910a = r5;
    }

    public final void a() {
        boolean r5 = RecyclerView.B0;
        RecyclerView r10 = this.f13910a;
        if (r5 == true) goto L5;
    L9:
        r10.f13766z = true;
        r10.requestLayout();
        return;
    L5:
        if (r10.s == false) goto L9;
        if (r10.f13753r == false) goto L9;
        ViewCompat.postOnAnimation(r10, r10.f13735h);
    }
}
