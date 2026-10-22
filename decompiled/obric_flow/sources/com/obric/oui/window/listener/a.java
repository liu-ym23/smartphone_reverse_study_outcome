package com.obric.oui.window.listener;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observer f14906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NextLiveData f14907c;

    public a(NextLiveData r5, int r10, Observer r11) {
        this.f14907c = r5;
        this.f14905a = r10;
        this.f14906b = r11;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r5) {
        int r10 = this.f14907c.f14900a;
        if (this.f14905a < r10) goto L5;
        return;
    L5:
        this.f14906b.onChanged(r5);
    }
}
