package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.common.combinedtext.a$a, reason: collision with other inner class name */
    public static final class C0154a extends AnimatorListenerAdapter {
        public final /* synthetic */ e a;

        public C0154a(e r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            e r3 = this.a;
            if (r3 == null) goto L6;
            r3.b();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            e r3 = this.a;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }
    }

    static {
    }

    @JvmStatic
    public static final Animator a(View r4, e r5) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r4, "scaleX", new float[]{1.35f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r4, "scaleY", new float[]{1.35f, 1.0f});
        AnimatorSet r2 = new AnimatorSet();
        r2.playTogether(new Animator[]{r1, r6});
        r2.setDuration(200);
        r2.addListener(new C0154a(r5));
        return r2;
    }

    public static Animator b(DisplayTextView r3, j r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(80);
        r0.addUpdateListener(new b(r3));
        r0.addListener(new c(r4));
        return r0;
    }
}
