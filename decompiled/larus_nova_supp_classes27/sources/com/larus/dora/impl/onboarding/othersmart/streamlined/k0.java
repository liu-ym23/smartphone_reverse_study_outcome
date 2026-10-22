package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0 extends AnimatorListenerAdapter {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ float b;
    public final /* synthetic */ DoraHStreamlinedWakeupFragment c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ImageView r4 = this.a;
        r4.setTranslationX(this.b - r4.getLeft());
        this.c.C = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ImageView r4 = this.a;
        r4.setTranslationX(this.b - r4.getLeft());
        this.c.C = null;
    }

    public k0(ImageView r1, float r2, DoraHStreamlinedWakeupFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
