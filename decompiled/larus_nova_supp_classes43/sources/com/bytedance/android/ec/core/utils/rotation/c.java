package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        e r11 = this.a;
        View r0 = this.b;
        r11.getClass();
        e.h(r0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.b.setVisibility(0);
    }

    public c(e r1, View r10) {
        this.a = r1;
        this.b = r10;
    }
}
