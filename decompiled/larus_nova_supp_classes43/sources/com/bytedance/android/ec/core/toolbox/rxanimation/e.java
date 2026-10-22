package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ Function0 a;

    public e(Function0 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        super.onAnimationEnd(r10);
        this.a.invoke();
    }
}
