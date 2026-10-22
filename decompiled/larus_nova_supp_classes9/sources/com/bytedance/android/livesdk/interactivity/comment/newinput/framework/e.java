package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ View b;

    public e(ValueAnimator r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        View r4 = this.b;
        Object r0 = this.a.getAnimatedValue();
        if (r0 == null) goto L11;
        a1.n(r4, ((Integer) r0).intValue());
        View r5 = this.b;
        Object r1 = this.a.getAnimatedValue();
        if (r1 == null) goto L9;
        a1.m(r5, ((Integer) r1).intValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
