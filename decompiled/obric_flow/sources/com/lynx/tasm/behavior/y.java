package com.lynx.tasm.behavior;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10814b;

    public /* synthetic */ y(Object r5, int r10) {
        this.f10813a = r10;
        this.f10814b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        switch(this.f10813a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((b0.c) this.f10814b).b(false);
        return;
    L6:
        ((b0) this.f10814b).h();
    }
}
