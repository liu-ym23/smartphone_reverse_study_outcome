package com.larus.bmhome.chat.component.bottom.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p7 extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ CoreInputComponent$b c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a == true) goto L9;
        CoreInputComponent r4 = this.b;
        if (r4.G != this.c) goto L10;
        r4.h4();
        return;
    L10:
        return;
    }

    public p7(CoreInputComponent r1, CoreInputComponent$b r2) {
        this.b = r1;
        this.c = r2;
    }
}
