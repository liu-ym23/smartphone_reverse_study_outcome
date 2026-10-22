package com.obric.oui.pullrefresh;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements bs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f14246a;

    public b(View r5) {
        this.f14246a = r5;
    }

    @Override // bs.b
    public final void a(OPullRefreshLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "layout");
    }

    @Override // bs.b
    public final void b(OPullRefreshLayout r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "layout");
    }

    @Override // bs.b
    public final void c(OPullRefreshLayout r5, RefreshState r10, RefreshState r11) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        Intrinsics.checkNotNullParameter(r10, "oldState");
        Intrinsics.checkNotNullParameter(r11, "newState");
    }

    @Override // bs.b
    public final View getView() {
        return this.f14246a;
    }
}
