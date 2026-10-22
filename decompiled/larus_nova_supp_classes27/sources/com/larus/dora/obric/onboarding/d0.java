package com.larus.dora.obric.onboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 extends AnimatorListenerAdapter {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ ObricDoraGOnboardingTopicView b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a.element == true) goto L6;
        ObricDoraGOnboardingTopicView r3 = this.b;
        r3.t = null;
        ObricDoraGOnboardingTopicView.b(r3);
        this.b.p();
        this.b.d();
        this.b.n = false;
        return;
    }

    public d0(Ref.BooleanRef r1, ObricDoraGOnboardingTopicView r2) {
        this.a = r1;
        this.b = r2;
    }
}
