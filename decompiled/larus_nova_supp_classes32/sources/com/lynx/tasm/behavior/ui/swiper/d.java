package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ XSwiperUI a;

    public d(XSwiperUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        XSwiperUI r6 = this.a;
        r6.u = true;
        if (r6.n == false) goto L6;
        r6.C.removeCallbacks(r6.E);
        XSwiperUI r7 = this.a;
        r7.C.postDelayed(r7.E, r7.q);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r4) {
        XSwiperUI r5 = this.a;
        if (r5.y == true) goto L5;
    L13:
        XSwiperUI r6 = this.a;
        r6.u = false;
        r6.C.removeCallbacks(r6.E);
        return;
    L5:
        if (((SwiperView) XSwiperUI.M(r5)).a.j == false) goto L13;
        ViewPager r7 = ((SwiperView) XSwiperUI.N(this.a)).a;
        if (r7.g1 != Integer.MIN_VALUE) goto L9;
    L12:
        r7.g1 = Integer.MIN_VALUE;
        goto L13
    L9:
        if (r7.m() == false) goto L11;
        r7.scrollTo(r7.i.getCurrX(), r7.g1);
        goto L12
    L11:
        r7.scrollTo(r7.g1, r7.i.getCurrY());
        goto L12
    }
}
