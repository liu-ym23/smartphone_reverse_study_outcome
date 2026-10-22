package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ GiftComboProgressBar b;

    public p(ValueAnimator r1, GiftComboProgressBar r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        GiftComboProgressBar r0 = this.b;
        Object r6 = r5.getAnimatedValue();
        if (r6 == null) goto L16;
        r0.g = ((Float) r6).floatValue();
        if (this.b.getCountDownTime() <= 4000) goto L13;
        float r7 = this.a.getDuration();
        GiftComboProgressBar r1 = this.b;
        if ((r7 * r1.g) < (r1.getCountDownTime() - 4000)) goto L13;
        Pair r8 = (Pair) this.b.getShowCountDown().getValue();
        if (r8 == null) goto L13;
        if (((Boolean) r8.getFirst()).booleanValue() == true) goto L13;
        this.b.getShowCountDown().setValue(new Pair(Boolean.TRUE, Boolean.valueOf(this.b.i)));
    L13:
        this.b.invalidate();
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
