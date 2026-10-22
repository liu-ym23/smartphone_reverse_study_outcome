package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ Function1 b;

    public b(Function1 r1) {
        this.b = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == true) goto L6;
        this.b.invoke(r2);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = false;
    }
}
