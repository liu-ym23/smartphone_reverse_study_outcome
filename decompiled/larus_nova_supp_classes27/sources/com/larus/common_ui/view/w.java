package com.larus.common_ui.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SuggestedActionBar a;

    public /* synthetic */ w(SuggestedActionBar r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        SuggestedActionBar r0 = this.a;
        int r1 = SuggestedActionBar.t;
        Intrinsics.checkNotNullParameter(r4, "va");
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L7;
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r2.height = ((Integer) r5).intValue();
        r0.setLayoutParams(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
