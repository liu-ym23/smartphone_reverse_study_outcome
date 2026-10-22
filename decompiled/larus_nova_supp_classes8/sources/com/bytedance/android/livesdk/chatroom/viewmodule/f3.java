package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f3 implements Animator.AnimatorListener {
    public final /* synthetic */ TopRightBannerWidget a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public f3(TopRightBannerWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ImageView r3 = this.a.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAnimateView");
    L5:
        r3.setVisibility(8);
        LinearLayout r4 = this.a.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("staticContainer");
    L8:
        r4.setVisibility(0);
    }
}
