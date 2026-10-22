package com.bytedance.android.livesdk.gift.fastgift.di;

import android.animation.Animator;
import android.animation.AnimatorSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends o12.b {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ AnimatorSet b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Ref.IntRef r4 = this.a;
        int r0 = r4.element;
        if (r0 >= 4) goto L6;
        r4.element = r0 + 1;
        this.b.start();
        return;
    }

    public a(Ref.IntRef r1, AnimatorSet r2) {
        this.a = r1;
        this.b = r2;
    }
}
