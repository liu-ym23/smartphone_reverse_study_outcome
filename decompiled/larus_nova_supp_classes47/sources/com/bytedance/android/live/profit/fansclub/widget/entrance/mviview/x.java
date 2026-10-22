package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TipMVIView a;

    public x(TipMVIView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        TextView r0 = (TextView) this.a.j.getValue();
        Object r1 = r4.getAnimatedValue();
        if (r1 == null) goto L11;
        r0.setAlpha(((Float) r1).floatValue());
        TextView r2 = this.a.p();
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L9;
        r2.setAlpha(((Float) r5).floatValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
