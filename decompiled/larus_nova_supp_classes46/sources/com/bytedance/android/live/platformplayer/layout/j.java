package com.bytedance.android.live.platformplayer.layout;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ l.a a;

    public j(l.a r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        float r5 = ((Float) r4).floatValue();
        this.a.a.c.setAlpha(1.0f - r5);
        this.a.a.b.setAlpha(r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
