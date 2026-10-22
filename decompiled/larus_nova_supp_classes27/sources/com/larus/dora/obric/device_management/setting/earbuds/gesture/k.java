package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.animation.Animator;
import com.larus.dora.impl.device.settings.gesture.widget.DoraGestureGuidanceMaskView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements Animator.AnimatorListener {
    public final /* synthetic */ DoraGestureGuidanceMaskView a;

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

    public k(DoraGestureGuidanceMaskView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setVisibility(8);
    }
}
