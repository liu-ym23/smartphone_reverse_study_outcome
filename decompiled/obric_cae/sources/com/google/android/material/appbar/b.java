package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import k0.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f4319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f4321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f4323e;

    public b(AppBarLayout.BaseBehavior r8, CoordinatorLayout r10, AppBarLayout r11, View r12, int r13) {
        this.f4323e = r8;
        this.f4319a = r10;
        this.f4320b = r11;
        this.f4321c = r12;
        this.f4322d = r13;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        this.f4323e.K(this.f4319a, this.f4320b, this.f4321c, this.f4322d, new int[]{0, 0});
        return true;
    }
}
