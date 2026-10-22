package com.larus.dora.impl.device.settings.gesture;

import android.animation.Animator;
import com.larus.dora.impl.device.settings.gesture.widget.DoraGestureGuidanceMaskView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 implements Animator.AnimatorListener {
    public final /* synthetic */ GestureSettingsFragment a;

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

    public b0(GestureSettingsFragment r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        DoraGestureGuidanceMaskView r3 = this.a.k;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
