package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.KeyEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f13102c;

    public /* synthetic */ c(KeyEvent.Callback r5, int r10, int r11) {
        this.f13100a = r11;
        this.f13102c = r5;
        this.f13101b = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r5) {
        switch(this.f13100a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onAnimationCancel(r5);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
        d r10 = (d) this.f13102c;
        r10.f13111m = null;
        r10.f13110l = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f13100a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = this.f13101b;
        gs.i r11 = (gs.i) this.f13102c;
        r11.f17186j = r10;
        r11.f17187k = 0.0f;
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "animation");
        int r12 = this.f13101b;
        Integer r13 = Integer.valueOf(r12);
        d r14 = (d) this.f13102c;
        r14.f13113o = r13;
        r14.f13112n = Integer.valueOf(r12);
        r14.f13111m = null;
        r14.f13110l = null;
    }
}
