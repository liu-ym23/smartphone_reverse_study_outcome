package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends d {
    public final ReactionFlowLayout.e e;
    public volatile Drawable f;
    public final int g;
    public final int h;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ c a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.e.a();
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ View b;

        public b(c r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            Intrinsics.checkNotNullParameter(r8, "it");
            float r0 = this.a.h;
            Object r1 = r8.getAnimatedValue();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
            float r2 = r0 * ((Float) r1).floatValue();
            float r3 = this.a.g;
            Object r9 = r8.getAnimatedValue();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Float");
            float r4 = r3 * ((Float) r9).floatValue();
            c r10 = this.a;
            int r5 = r10.h;
            float r6 = 2;
            int r7 = r10.g;
            r10.f.setBounds((int) ((r5 - r2) / r6), (int) ((r7 - r4) / r6), (int) ((r5 + r2) / r6), (int) ((r7 + r4) / r6));
            this.b.invalidate();
        }
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
    public final Drawable b() {
        return this.f;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d
    public final void c(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.75f, 1.0f});
        r0.setInterpolator(new AccelerateDecelerateInterpolator());
        r0.setDuration(220);
        r0.addUpdateListener(new b(this, r4));
        Intrinsics.checkNotNull(r0);
        r0.addListener(new a(this));
        r0.start();
    }

    public c(ReactionFlowLayout.e r3, Drawable r4) {
        Intrinsics.checkNotNullParameter(r3, "extendIconClickListener");
        Intrinsics.checkNotNullParameter(r4, "drawable");
        super(2);
        this.e = r3;
        this.f = r4;
        int r5 = ReactionTextView.o;
        int r6 = ReactionTextView.p;
        this.g = r6;
        if (this.f.getIntrinsicHeight() <= 0) goto L5;
        this.h = (this.f.getIntrinsicWidth() * r6) / this.f.getIntrinsicHeight();
    L5:
        this.f.setBounds(0, 0, this.h, r6);
    }
}
