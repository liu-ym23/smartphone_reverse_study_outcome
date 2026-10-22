package com.larksuite.component.universe_design.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ UDTabLayout.c a;
    public final /* synthetic */ int b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.e = 0.0f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        UDTabLayout.c r3 = this.a;
        r3.d = this.b;
    }

    public e(UDTabLayout.c r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
