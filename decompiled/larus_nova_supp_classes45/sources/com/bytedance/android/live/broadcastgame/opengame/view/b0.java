package com.bytedance.android.live.broadcastgame.opengame.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setVisibility(8);
        this.b.invoke();
    }

    public b0(View r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
