package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftMVIPanelView a;

    public v(GiftMVIPanelView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Float) == true) goto L5;
        r3 = null;
    L5:
        Float r4 = (Float) r3;
        if (r4 == null) goto L16;
        float r5 = r4.floatValue();
        View r0 = this.a.u;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L12;
        r1.height = (int) r5;
    L12:
        View r6 = this.a.u;
        if (r6 == null) goto L17;
        r6.requestLayout();
        return;
    L17:
        return;
    }
}
