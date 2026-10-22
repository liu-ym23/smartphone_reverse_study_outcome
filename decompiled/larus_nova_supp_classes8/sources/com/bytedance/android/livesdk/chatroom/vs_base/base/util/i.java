package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ g a;

    public i(g r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L11;
        float r5 = ((Float) r4).floatValue();
        wr1.b r0 = this.a.c;
        if (r0 == null) goto L12;
        LiveBlurAnimView r1 = r0.getView();
        if (r1 == null) goto L13;
        r1.setAlpha(1.0f - r5);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
