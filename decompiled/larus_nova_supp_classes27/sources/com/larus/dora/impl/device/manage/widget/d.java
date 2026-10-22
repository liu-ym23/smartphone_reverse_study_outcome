package com.larus.dora.impl.device.manage.widget;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements Animator.AnimatorListener {
    public d() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeFinishAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeFinishAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeFinishAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeFinishAnimator onAnimationStart");
    }
}
