package com.bytedance.android.live.core.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final void a(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.addListener(new f(r2));
    }

    public static final void b(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnStart");
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.addListener(new g(r2));
    }

    public static final AnimatorSet c(View r4, float... r5) {
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r5, "values");
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(r4, LiveDegradeFpsAnimator.SCALE_X, Arrays.copyOf(r5, r5.length)), ObjectAnimator.ofFloat(r4, LiveDegradeFpsAnimator.SCALE_Y, Arrays.copyOf(r5, r5.length))});
        return r0;
    }
}
