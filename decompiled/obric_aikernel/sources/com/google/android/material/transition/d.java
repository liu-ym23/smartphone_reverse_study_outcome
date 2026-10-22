package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4140a;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4141c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f4142g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f4143h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f4144i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f4145j;

        a(View r10, float r11, float r12, float r13, float r14) {
            this.f4141c = r10;
            this.f4142g = r11;
            this.f4143h = r12;
            this.f4144i = r13;
            this.f4145j = r14;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f4141c.setAlpha(l.k(this.f4142g, this.f4143h, this.f4144i, this.f4145j, r11));
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4146c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f4147g;

        b(View r10, float r11) {
            this.f4146c = r10;
            this.f4147g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4146c.setAlpha(this.f4147g);
        }
    }

    public d() {
        this.f4140a = 1.0f;
    }

    private static Animator c(View r10, float r11, float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14, float r15) {
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.addUpdateListener(new a(r10, r11, r12, r13, r14));
        r16.addListener(new b(r10, r15));
        return r16;
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator a(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L5;
        float r12 = 1.0f;
    L6:
        float r13 = r12;
        return c(r11, 0.0f, r13, 0.0f, this.f4140a, r13);
    L5:
        r12 = r11.getAlpha();
        goto L6
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator b(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L5;
        float r12 = 1.0f;
    L6:
        float r13 = r12;
        return c(r11, r13, 0.0f, 0.0f, 1.0f, r13);
    L5:
        r12 = r11.getAlpha();
        goto L6
    }

    public void d(float r10) {
        this.f4140a = r10;
    }
}
