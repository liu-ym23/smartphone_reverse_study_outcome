package com.larus.dora.impl.onboarding;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v {
    public static ValueAnimator a(final float r3, final long r4, final Function1 r6, Function0 r7) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{r3, 0.0f});
        r0.setInterpolator(new LinearInterpolator());
        r0.setDuration(r4);
        r0.addUpdateListener(new t(r4, r3, r6));
        r0.addListener(new u(null, r7));
        return r0;
    }
}
