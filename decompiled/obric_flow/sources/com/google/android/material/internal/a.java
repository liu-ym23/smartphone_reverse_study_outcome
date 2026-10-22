package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements MultiViewUpdateListener.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8554a;

    public /* synthetic */ a(int r5) {
        this.f8554a = r5;
    }

    @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
    public final void onAnimationUpdate(ValueAnimator r5, View r10) {
        switch(this.f8554a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        MultiViewUpdateListener.c(r5, r10);
        return;
    L6:
        MultiViewUpdateListener.b(r5, r10);
        return;
    L8:
        MultiViewUpdateListener.a(r5, r10);
        return;
    L10:
        MultiViewUpdateListener.d(r5, r10);
    }
}
