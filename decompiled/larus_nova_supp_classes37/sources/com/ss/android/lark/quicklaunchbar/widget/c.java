package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ QuickLaunchBar a;

    public c(QuickLaunchBar r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        ViewGroup.LayoutParams r0 = this.a.d.a.getLayoutParams();
        if (r0 == null) goto L5;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r0.height = ((Integer) r4).intValue();
    L5:
        this.a.requestLayout();
    }
}
