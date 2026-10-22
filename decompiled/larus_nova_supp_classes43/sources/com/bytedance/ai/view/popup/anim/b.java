package com.bytedance.ai.view.popup.anim;

import android.animation.Animator;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ AnimController b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L5;
        r11.invoke();
    L5:
        this.b.a(AnimController.AnimProcessType.DONE, true, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L5;
        r11.invoke();
    L5:
        this.b.a(AnimController.AnimProcessType.DONE, true, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.setVisibility(0);
        this.b.a(AnimController.AnimProcessType.DOING, true, AnimationStyle.ZOOM.getValue());
    }

    public b(View r1, AnimController r10, Function0<Unit> r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
