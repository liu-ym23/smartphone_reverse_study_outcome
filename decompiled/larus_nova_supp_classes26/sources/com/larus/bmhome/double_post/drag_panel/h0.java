package com.larus.bmhome.double_post.drag_panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h0 extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ChatAwemeFeedContainer b;
    public final /* synthetic */ ValueAnimator c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.c.removeAllListeners();
        ChatAwemeFeedContainer r3 = this.b;
        int r0 = ChatAwemeFeedContainer.l;
        r3.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == false) goto L6;
        ChatAwemeFeedContainer r3 = this.b;
        int r0 = ChatAwemeFeedContainer.l;
        r3.getClass();
        return;
    }

    public h0(boolean r1, ChatAwemeFeedContainer r2, ValueAnimator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
