package com.ss.android.lark.location_ui.picklocation;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LocationView a;

    public n(LocationView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r1) {
        this.a.mIvLocationIcon.invalidate();
    }
}
