package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftComboProgressBar a;

    public n(GiftComboProgressBar r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        GiftComboProgressBar r0 = this.a;
        Object r1 = r4.getAnimatedValue();
        if (r1 == null) goto L13;
        r0.w = ((Float) r1).floatValue();
        GiftComboProgressBar r2 = this.a;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L11;
        r2.s = ((Float) r5).floatValue();
        GiftComboProgressBar r6 = this.a;
        if (r6.w != 1.0f) goto L14;
        r6.x.setValue(Boolean.TRUE);
        return;
    L14:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
