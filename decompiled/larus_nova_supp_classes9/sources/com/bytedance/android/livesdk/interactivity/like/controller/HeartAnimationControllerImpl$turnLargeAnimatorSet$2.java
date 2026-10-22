package com.bytedance.android.livesdk.interactivity.like.controller;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 4, 3})
final class HeartAnimationControllerImpl$turnLargeAnimatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ c this$0;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ HeartAnimationControllerImpl$turnLargeAnimatorSet$2 a;

        public a(HeartAnimationControllerImpl$turnLargeAnimatorSet$2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            c r0 = this.a.this$0;
            int r1 = c.b;
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

    public HeartAnimationControllerImpl$turnLargeAnimatorSet$2(c r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnimatorSet invoke() {
        new AnimatorSet();
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        int r1 = c.b;
        r0.setDuration(150);
        r0.addUpdateListener(new a(this));
        Unit r2 = Unit.INSTANCE;
        this.this$0.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("loveTextView");
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m701invoke() {
        return invoke();
    }
}
