package com.ss.android.lark.inline.ai.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ InlineAIDragView a;

    public i(InlineAIDragView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        Log.i("InlineAIDragView", "showAnim end");
        InlineAIDragView r5 = this.a;
        r5.N = null;
        r5.b.postDelayed(r5.Y, 100);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Log.i("InlineAIDragView", "showAnim start");
    }
}
