package com.larus.canvas.feature.component.instruction.factory;

import android.animation.Animator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ InstructionTabWidgetFactory a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public c(InstructionTabWidgetFactory r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r4 = this.a.c;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r4 = null;
    L5:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L10;
        r0.height = -2;
        r4.setLayoutParams(r0);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
