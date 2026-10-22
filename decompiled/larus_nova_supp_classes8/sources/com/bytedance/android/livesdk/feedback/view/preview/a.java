package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ FeedbackLikeView a;

    public a(FeedbackLikeView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2);
        this.a.setClickable(false);
        this.a.a.setBackground(s1.m(2131250999));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2, r3);
        this.a.setClickable(true);
    }
}
