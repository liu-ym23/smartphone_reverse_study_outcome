package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public e(View r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        float r4 = ((Float) r3).floatValue();
        this.a.setRotation(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
