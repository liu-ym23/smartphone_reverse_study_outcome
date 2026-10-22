package com.larus.bmhome.double_post.drag_panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 extends AnimatorListenerAdapter {
    public final /* synthetic */ ChatAwemeNestedContainer a;

    public k0(ChatAwemeNestedContainer r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.j = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a.getScrollY() <= 0) goto L5;
        this.a.scrollTo(0, 0);
    L5:
        this.a.j = null;
    }
}
