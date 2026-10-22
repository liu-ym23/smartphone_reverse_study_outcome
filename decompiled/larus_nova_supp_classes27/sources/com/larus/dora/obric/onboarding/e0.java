package com.larus.dora.obric.onboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0 extends AnimatorListenerAdapter {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ ObricDoraGOnboardingTopicView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (this.a.element == true) goto L6;
        ObricDoraGOnboardingTopicView r5 = this.b;
        int r0 = this.c;
        boolean r1 = this.d;
        Typeface r2 = ObricDoraGOnboardingTopicView.F;
        r5.f(r0, r1);
        return;
    }

    public e0(Ref.BooleanRef r1, ObricDoraGOnboardingTopicView r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
