package com.larksuite.framework.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewTransitionContainer<View> a;

    public e(ViewTransitionContainer<View> r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        ViewTransitionContainer<View> r5 = this.a;
        r5.b = null;
        r5.c.set(0.0f, 0.0f);
        r5.d = null;
        r5.invalidate();
    }
}
