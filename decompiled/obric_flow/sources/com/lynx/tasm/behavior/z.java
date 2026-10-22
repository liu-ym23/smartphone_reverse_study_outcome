package com.lynx.tasm.behavior;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10818b;

    public /* synthetic */ z(Object r5, int r10) {
        this.f10817a = r10;
        this.f10818b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        switch(this.f10817a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((b0.c) this.f10818b).b(false);
        return;
    L6:
        ((b0) this.f10818b).h();
    }
}
