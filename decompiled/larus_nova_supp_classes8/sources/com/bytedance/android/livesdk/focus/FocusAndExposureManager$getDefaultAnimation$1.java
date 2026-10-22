package com.bytedance.android.livesdk.focus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FocusAndExposureManager$getDefaultAnimation$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ b a;

    public FocusAndExposureManager$getDefaultAnimation$1(b r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        UtilityKotlinExtentionsKt.s(0, false, false, new FocusAndExposureManager$getDefaultAnimation$1$onAnimationEnd$1(this), 7);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.g = true;
    }
}
