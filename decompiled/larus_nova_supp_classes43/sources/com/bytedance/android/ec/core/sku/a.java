package com.bytedance.android.ec.core.sku;

import android.animation.Animator;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ CommonMarqueeView a;
    public final /* synthetic */ int b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        CommonMarqueeView r11 = this.a;
        r11.h = this.b;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        CommonMarqueeView r11 = this.a;
        Function1<? super View, Unit> r0 = r11.f;
        if (r0 == null) goto L6;
        Unit r12 = (Unit) r0.invoke(r11.getChildAt(r11.h));
        return;
    }

    public a(CommonMarqueeView r1, int r10) {
        this.a = r1;
        this.b = r10;
    }
}
