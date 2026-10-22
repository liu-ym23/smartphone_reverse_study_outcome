package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 implements Animator.AnimatorListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ FrameLayout b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        com.larus.utils.e1.x(this.b);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a == false) goto L6;
        com.larus.utils.e1.o(this.b);
        return;
    }

    public m0(boolean r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
