package com.bytedance.ai.view.popup.anim;

import android.animation.Animator;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Animator.AnimatorListener {
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
        this.b.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L6;
        r11.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.b.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L6;
        r11.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.setVisibility(0);
        this.b.a(AnimController.AnimProcessType.DOING, false, AnimationStyle.ZOOM.getValue());
    }

    public c(View r1, AnimController r10, com.bytedance.ai.view.popup.a r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
