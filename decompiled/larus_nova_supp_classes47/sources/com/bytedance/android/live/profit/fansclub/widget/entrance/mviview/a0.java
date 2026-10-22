package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TipMVIView a;

    public a0(TipMVIView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ViewGroup r0 = (ViewGroup) this.a.i.getValue();
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        a1.p(r0, (int) ((Float) r3).floatValue());
        ((ViewGroup) this.a.i.getValue()).requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
