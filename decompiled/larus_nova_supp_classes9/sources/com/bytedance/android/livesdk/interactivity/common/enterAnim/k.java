package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends AnimatorListenerAdapter {
    public final /* synthetic */ WindScreenRebirthAnimTrayView a;

    public k(WindScreenRebirthAnimTrayView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.f.setVisibility(0);
    }
}
