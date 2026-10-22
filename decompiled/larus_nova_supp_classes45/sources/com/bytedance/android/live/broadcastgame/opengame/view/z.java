package com.bytedance.android.live.broadcastgame.opengame.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z {

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.invoke();
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function0 b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setVisibility(8);
            this.b.invoke();
        }

        public b(View r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ void b(View r4) {
        a(r4, 250, 0.0f, RewardMsgContainerKt$fadeIn$1.INSTANCE);
    }

    public static /* synthetic */ void d(View r4) {
        c(r4, 250, 0.0f, RewardMsgContainerKt$fadeOut$1.INSTANCE);
    }

    public static final void e(View r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "inView");
        Intrinsics.checkNotNullParameter(r4, "endAction");
        if (r3.getHeight() != 0) goto L6;
        ALogger.i("RewardMsgContainer", "view的高度为0");
        return;
    L6:
        r3.clearAnimation();
        r3.setAlpha(0.0f);
        r3.setVisibility(0);
        float r0 = r3.getHeight() / 4;
        r3.setTranslationY(-r0);
        r3.animate().alpha(1.0f).translationYBy(r0).setDuration(250).setListener(new a0(r3, r4));
    }

    public static final void f(View r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "outView");
        Intrinsics.checkNotNullParameter(r4, "endAction");
        if (r3.getHeight() != 0) goto L6;
        ALogger.i("RewardMsgContainer", "view的高度为0");
        return;
    L6:
        float r0 = r3.getHeight() / 4;
        r3.clearAnimation();
        r3.animate().alpha(0.0f).translationYBy(r0).setDuration(250).setListener(new b0(r3, r4));
    }

    public static final void a(View r1, long r2, float r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "inView");
        Intrinsics.checkNotNullParameter(r5, "endAction");
        r1.setAlpha(r4);
        r1.setVisibility(0);
        r1.clearAnimation();
        r1.animate().alpha(1.0f).setDuration(r2).setListener(new a(r5));
    }

    public static final void c(View r1, long r2, float r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "outView");
        Intrinsics.checkNotNullParameter(r5, "endAction");
        r1.clearAnimation();
        r1.animate().alpha(r4).setDuration(r2).setListener(new b(r1, r5));
    }
}
