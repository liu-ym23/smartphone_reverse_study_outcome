package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftComboProgressBar a;

    public o(GiftComboProgressBar r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        GiftComboProgressBar r0 = this.a;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L12;
        r0.g = ((Float) r5).floatValue();
        Pair r6 = (Pair) this.a.getShowCountDown().getValue();
        if (r6 != null) goto L7;
    L8:
        this.a.getShowCountDown().setValue(new Pair(Boolean.FALSE, Boolean.valueOf(this.a.i)));
    L9:
        this.a.invalidate();
        return;
    L7:
        if (((Boolean) r6.getFirst()).booleanValue() == false) goto L9;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
