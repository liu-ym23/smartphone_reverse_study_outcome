package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f4396b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4399o;

    public e(BottomAppBar r8, ActionMenuView r10, int r11, boolean r12) {
        this.f4399o = r8;
        this.f4396b = r10;
        this.f4397m = r11;
        this.f4398n = r12;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        this.f4395a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        if (this.f4395a == true) goto L12;
        BottomAppBar r10 = this.f4399o;
        int r11 = r10.f4375n0;
        if (r11 == 0) goto L7;
        boolean r12 = true;
    L8:
        if (r11 == 0) goto L10;
        r10.f4375n0 = 0;
        r10.getMenu().clear();
        r10.k(r11);
    L10:
        r10.B(this.f4396b, this.f4397m, this.f4398n, r12);
        return;
    L7:
        r12 = false;
        goto L8
    }
}
