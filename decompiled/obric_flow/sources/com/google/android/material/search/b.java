package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8564b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f8563a = r10;
        this.f8564b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        int r10 = this.f8563a;
        Object r11 = this.f8564b;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        SearchViewAnimationHelper.e((FadeThroughDrawable) r11, r5);
        return;
    L6:
        SearchViewAnimationHelper.c((DrawerArrowDrawable) r11, r5);
        return;
    L8:
        SearchBarAnimationHelper.a(r5, (View) r11);
    }
}
