package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L9;
        float r5 = ((Float) r4).floatValue();
        wr1.b r0 = this.a.c;
        if (r0 == null) goto L10;
        r0.b(1.0f - r5);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
