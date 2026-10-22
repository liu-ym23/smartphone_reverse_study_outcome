package com.bytedance.android.ec.core.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.invoke(r10);
    }
}
