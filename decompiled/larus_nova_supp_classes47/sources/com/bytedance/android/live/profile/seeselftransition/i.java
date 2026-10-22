package com.bytedance.android.live.profile.seeselftransition;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ b b;

    public i(b r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        long r0 = r9.getCurrentPlayTime();
        Object r4 = null;
        if (0 > r0) goto L14;
        if (200 < r0) goto L14;
        Object r2 = r9.getAnimatedValue("beforeIconScale");
        if ((r2 instanceof Float) == true) goto L10;
        r2 = null;
    L10:
        Float r3 = (Float) r2;
        if (r3 == null) goto L14;
        this.a.setDressIconScale(r3.floatValue());
    L14:
        if (200 <= r0) goto L17;
    L24:
        if (200 <= r0) goto L27;
        return;
    L27:
        if (1200 < r0) goto L36;
        Object r10 = r9.getAnimatedValue("dialogMark");
        if ((r10 instanceof Float) == false) goto L32;
        r4 = r10;
    L32:
        Float r5 = (Float) r4;
        if (r5 == null) goto L37;
        float r12 = r5.floatValue();
        this.a.es(r12);
        this.b.es(r12 + 220.0f);
        return;
    L37:
        return;
    L36:
        return;
    L17:
        if (900 < r0) goto L24;
        Object r6 = r9.getAnimatedValue("currentIconScale");
        if ((r6 instanceof Float) == true) goto L21;
        r6 = null;
    L21:
        Float r7 = (Float) r6;
        if (r7 == null) goto L24;
        this.b.setDressIconScale(r7.floatValue());
        goto L24
    }
}
