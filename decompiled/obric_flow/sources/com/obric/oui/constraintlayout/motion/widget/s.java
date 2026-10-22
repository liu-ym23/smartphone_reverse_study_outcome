package com.obric.oui.constraintlayout.motion.widget;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12895b;

    public /* synthetic */ s(int r5, View r10) {
        this.f12894a = r5;
        this.f12895b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f12894a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((MotionLayout) this.f12895b).f12684u0.a();
        return;
    L6:
        this.f12895b.setNestedScrollingEnabled(true);
    }
}
