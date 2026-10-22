package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.PathInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k extends AnimatorListenerAdapter {
    public final /* synthetic */ RoundedIconTextView a;
    public final /* synthetic */ float b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        RoundedIconTextView r4 = this.a;
        float r0 = this.b;
        PathInterpolator r1 = RoundedIconTextView.F;
        r4.b(r0);
    }

    public k(RoundedIconTextView r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
