package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes3.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.airbnb.lottie.parser.moshi.c f14855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14856b;

    public ViewOffsetBehavior() {
        this.f14856b = 0;
    }

    public void layoutChild(CoordinatorLayout r5, View r10, int r11) {
        r5.onLayoutChild(r10, r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r5, View r10, int r11) {
        layoutChild(r5, r10, r11);
        if (this.f14855a != null) goto L5;
        com.airbnb.lottie.parser.moshi.c r12 = new com.airbnb.lottie.parser.moshi.c();
        r12.d = r10;
        this.f14855a = r12;
    L5:
        com.airbnb.lottie.parser.moshi.c r13 = this.f14855a;
        View r14 = (View) r13.d;
        r13.f1313a = r14.getTop();
        r13.f1314b = r14.getLeft();
        this.f14855a.f();
        int r15 = this.f14856b;
        if (r15 == 0) goto L13;
        com.airbnb.lottie.parser.moshi.c r16 = this.f14855a;
        if (r16.f1315c == r15) goto L10;
        r16.f1315c = r15;
        r16.f();
    L10:
        this.f14856b = 0;
        return true;
    L13:
        return true;
    }

    public ViewOffsetBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f14856b = 0;
    }
}
