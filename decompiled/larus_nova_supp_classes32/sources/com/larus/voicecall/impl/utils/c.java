package com.larus.voicecall.impl.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import com.bytedance.common.utility.UIUtils;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final int a = 0;

    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ View a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(View r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            this.a.setVisibility(4);
        }
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ View a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            this.a.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.utils.c$c, reason: collision with other inner class name */
    public static final class AnimationAnimationListenerC0024c implements Animation.AnimationListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            if (this.b == true) goto L6;
            this.a.setVisibility(8);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            this.a.setVisibility(0);
        }

        public AnimationAnimationListenerC0024c(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            if (this.b == true) goto L6;
            this.a.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.setVisibility(0);
        }

        public d(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = (int) UIUtils.dip2Px(AppHost.a.getApplication(), 111.0f);
    }

    public static final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r10.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ScaleAnimation r1 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.2f, 1, 0.8f);
        r1.setDuration(200);
        int r2 = a;
        r1.initialize(r2, r2, r2, r2);
        r1.setAnimationListener(new a(r10));
        r10.startAnimation(r1);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "target");
        ScaleAnimation r0 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.2f, 1, 0.8f);
        r0.setDuration(200);
        int r1 = a;
        r0.initialize(r1, r1, r1, r1);
        r0.setAnimationListener(new b(r10));
        r10.startAnimation(r0);
    }

    public static /* synthetic */ void d(View r2, boolean r3) {
        c(r2, r3, 200);
    }

    public static final void c(View r5, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "target");
        float r0 = 0.0f;
        if (r6 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r6 == false) goto L9;
        r0 = 1.0f;
    L9:
        if (r7 > 0) goto L16;
        r5.setAlpha(r0);
        if (r6 == false) goto L13;
        int r8 = 0;
    L14:
        r5.setVisibility(r8);
        return;
    L13:
        r8 = 8;
        goto L14
    L16:
        AlphaAnimation r1 = new AlphaAnimation(r2, r0);
        r1.setDuration(r7);
        r1.setAnimationListener(new AnimationAnimationListenerC0024c(r5, r6));
        r5.startAnimation(r1);
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }

    public static void e(VoiceCallContentLayout r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r3, r4});
        r5.setDuration(300);
        r5.start();
    }

    public static final void f(final View r6, boolean r7, long r8, final Function1<? super Float, Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "target");
        Intrinsics.checkNotNullParameter(r10, "onAlphaChange");
        float r0 = 1.0f;
        if (r7 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r7 == true) goto L9;
        r0 = 0.0f;
    L9:
        int r1 = 0;
        if (r8 > 0) goto L17;
        r6.setAlpha(r0);
        if (r7 == true) goto L15;
        r1 = 8;
    L15:
        r6.setVisibility(r1);
        return;
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{r2, r0});
        r3.setInterpolator(new LinearInterpolator());
        r3.addUpdateListener(new com.larus.voicecall.impl.utils.a(r10, r6));
        r3.addListener(new d(r6, r7));
        r3.setDuration(r8);
        r3.start();
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }
}
