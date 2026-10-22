package com.obric.oui.swipeaction;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSwipeLayout f14619a;

    public e(OSwipeLayout r5) {
        this.f14619a = r5;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        OSwipeLayout.o(this.f14619a);
        return true;
    }
}
