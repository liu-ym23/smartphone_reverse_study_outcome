package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ i a;

    public g(j r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ViewGroup.LayoutParams r0 = this.a.c.getLayoutParams();
        if (r0 == null) goto L11;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L9;
        r1.bottomMargin = ((Integer) r3).intValue();
        this.a.c().requestLayout();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
