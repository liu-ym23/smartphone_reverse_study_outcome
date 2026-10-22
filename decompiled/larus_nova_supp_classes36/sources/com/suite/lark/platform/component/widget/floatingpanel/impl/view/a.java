package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ FloatingBannerContainer a;

    public a(FloatingBannerContainer r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        FloatingBannerContainer.a r3 = this.a.getOnBannerMovedOutListener();
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
