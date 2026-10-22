package com.google.android.material.appbar;

import android.view.View;
import k0.j;

/* JADX INFO: loaded from: classes.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4325b;

    public c(AppBarLayout r8, boolean r10) {
        this.f4324a = r8;
        this.f4325b = r10;
    }

    @Override // k0.j
    public final boolean a(View r8) {
        this.f4324a.setExpanded(this.f4325b);
        return true;
    }
}
