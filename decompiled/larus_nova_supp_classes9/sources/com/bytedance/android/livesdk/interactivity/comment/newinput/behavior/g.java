package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ TextView b;

    public g(ValueAnimator r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        TextView r3 = this.b;
        if (r3 == null) goto L9;
        Object r0 = this.a.getAnimatedValue();
        if (r0 == null) goto L8;
        r3.setRotation(((Float) r0).floatValue());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
