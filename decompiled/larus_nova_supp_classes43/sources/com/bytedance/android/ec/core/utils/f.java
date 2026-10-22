package com.bytedance.android.ec.core.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final void a(Animator r1, Function1 r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r1.addListener(new c(r10));
    }

    public static final void b(ViewPropertyAnimator r1, Function1 r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r1.setListener(new d(r10));
    }

    public static final AnimatorSet c(View r10, float... r11) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "values");
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(r10, "scaleX", Arrays.copyOf(r11, r11.length)), ObjectAnimator.ofFloat(r10, "scaleY", Arrays.copyOf(r11, r11.length))});
        return r0;
    }
}
