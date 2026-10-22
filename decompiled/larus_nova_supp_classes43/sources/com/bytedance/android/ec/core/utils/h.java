package com.bytedance.android.ec.core.utils;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class h implements Animator.AnimatorListener {
    public h() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }
}
