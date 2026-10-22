package com.bytedance.android.livesdk.interactivity.like.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u32.h;
import u32.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 4, 3})
final class HeartAnimationControllerImpl$hideProgressAnimatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ h.a $initializer;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.controller.c this$0;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 a;

        public a(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            com.bytedance.android.livesdk.interactivity.like.controller.c r0 = this.a.this$0;
            int r1 = com.bytedance.android.livesdk.interactivity.like.controller.c.b;
            r0.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L5;
            ((Float) r4).floatValue();
            throw null;
        L5:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 a;

        public b(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            com.bytedance.android.livesdk.interactivity.like.controller.c r3 = this.a.this$0;
            int r0 = com.bytedance.android.livesdk.interactivity.like.controller.c.b;
            r3.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            throw null;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 a;

        public c(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            this.a.getClass();
            throw null;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 a;

        public d(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.getClass();
            throw null;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ HeartAnimationControllerImpl$hideProgressAnimatorSet$2 a;

        public e(HeartAnimationControllerImpl$hideProgressAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.this$0.a = State.CLEAR;
            DiggContext.Companion.getClass();
            DiggContext r0 = DiggContext.a.a(null);
            if (r0 == null) goto L7;
            n<o> r1 = r0.getThankAnimationController();
            if (r1 == null) goto L7;
            o r2 = (o) r1.getValue();
        L9:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.like.controller.e) == true) goto L11;
            r2 = null;
        L11:
            com.bytedance.android.livesdk.interactivity.like.controller.e r4 = (com.bytedance.android.livesdk.interactivity.like.controller.e) r2;
            if (r4 == null) goto L15;
            r4.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("thankTextView");
            throw null;
        L15:
            this.a.this$0.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("heartView");
            throw null;
        L7:
            r2 = null;
            goto L9
        }
    }

    public HeartAnimationControllerImpl$hideProgressAnimatorSet$2(com.bytedance.android.livesdk.interactivity.like.controller.c r1, h.a r2) {
        this.this$0 = r1;
        super(0);
    }

    public final AnimatorSet invoke() {
        AnimatorSet r0 = new AnimatorSet();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        int r4 = com.bytedance.android.livesdk.interactivity.like.controller.c.b;
        r3.setDuration(200);
        r3.addUpdateListener(new a(this));
        r3.addListener(new b(this));
        Unit r6 = Unit.INSTANCE;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(200);
        r1.addUpdateListener(new c(this));
        r1.addListener(new d(this));
        r0.playSequentially(new Animator[]{r3, r1});
        r0.addListener(new e(this));
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m698invoke() {
        return invoke();
    }
}
