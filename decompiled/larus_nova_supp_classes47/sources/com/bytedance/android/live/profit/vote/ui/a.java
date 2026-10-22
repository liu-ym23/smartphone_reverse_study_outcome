package com.bytedance.android.live.profit.vote.ui;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VoteIconModel.d a;

    public a(VoteIconModel.d r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "anim");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        this.a.b.setGuidelinePercent(r4);
        this.a.s = r4;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
