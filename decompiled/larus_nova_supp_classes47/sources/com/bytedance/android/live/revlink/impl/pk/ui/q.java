package com.bytedance.android.live.revlink.impl.pk.ui;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PkRandomView a;

    public q(PkRandomView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        TextView r0 = (TextView) this.a.c.findViewById(2131364840);
        Object r2 = r5.getAnimatedValue();
        if (r2 == null) goto L11;
        r0.setScaleX(((Float) r2).floatValue());
        TextView r1 = (TextView) this.a.c.findViewById(2131364840);
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L9;
        r1.setScaleY(((Float) r6).floatValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
