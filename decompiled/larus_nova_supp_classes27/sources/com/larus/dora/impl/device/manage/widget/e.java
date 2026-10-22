package com.larus.dora.impl.device.manage.widget;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements Animator.AnimatorListener {
    public e() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "fakeRefreshingAnimator onAnimationStart");
    }
}
