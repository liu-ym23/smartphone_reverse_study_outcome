package com.obric.assistant.window;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g4 extends AnimatorListenerAdapter {
    public final /* synthetic */ ObricWindowExtraViewComponent a;

    public g4(ObricWindowExtraViewComponent r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.K = null;
    }
}
