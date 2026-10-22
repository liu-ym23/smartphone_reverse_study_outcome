package com.bytedance.android.live.revenue.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final void a(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnComplete");
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.addListener(new b(r2));
    }

    public static final void b(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.addListener(new c(r2));
    }

    public static final AnimatorSet c(View r4, float... r5) {
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r5, "values");
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(r4, "scaleX", Arrays.copyOf(r5, r5.length)), ObjectAnimator.ofFloat(r4, "scaleY", Arrays.copyOf(r5, r5.length))});
        return r0;
    }
}
