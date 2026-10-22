package com.larus.canvas.feature.component.instruction.factory;

import android.animation.Animator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements Animator.AnimatorListener {
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

    public d(InstructionTabWidgetFactory r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r4 = this.a.c;
        ViewGroup r0 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r4 = null;
    L5:
        r4.removeAllViews();
        ViewGroup r5 = this.a.c;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
    L9:
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        if (r6 == null) goto L14;
        r6.height = -2;
        r0.setLayoutParams(r6);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r0 = r5;
        goto L9
    }
}
