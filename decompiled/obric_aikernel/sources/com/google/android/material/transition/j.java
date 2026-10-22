package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f4171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f4172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4174f;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4175c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f4176g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f4177h;

        a(View r10, float r11, float r12) {
            this.f4175c = r10;
            this.f4176g = r11;
            this.f4177h = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4175c.setScaleX(this.f4176g);
            this.f4175c.setScaleY(this.f4177h);
        }
    }

    public j() {
        this(true);
    }

    public j(boolean r10) {
        this.f4169a = 1.0f;
        this.f4170b = 1.1f;
        this.f4171c = 0.8f;
        this.f4172d = 1.0f;
        this.f4174f = true;
        this.f4173e = r10;
    }

    private static Animator c(View r10, float r11, float r12) {
        float r13 = r10.getScaleX();
        float r14 = r10.getScaleY();
        ObjectAnimator r15 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r13 * r11, r13 * r12}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r11 * r14, r12 * r14})});
        r15.addListener(new a(r10, r13, r14));
        return r15;
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator a(@NonNull ViewGroup r10, @NonNull View r11) {
        if (this.f4173e == false) goto L7;
        float r12 = this.f4171c;
        float r13 = this.f4172d;
    L6:
        return c(r11, r12, r13);
    L7:
        r12 = this.f4170b;
        r13 = this.f4169a;
        goto L6
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator b(@NonNull ViewGroup r10, @NonNull View r11) {
        if (this.f4174f == true) goto L7;
        return null;
    L7:
        if (this.f4173e == false) goto L11;
        float r12 = this.f4169a;
        float r13 = this.f4170b;
    L10:
        return c(r11, r12, r13);
    L11:
        r12 = this.f4172d;
        r13 = this.f4171c;
        goto L10
    }

    public void d(float r10) {
        this.f4171c = r10;
    }

    public void e(float r10) {
        this.f4170b = r10;
    }

    public void f(boolean r10) {
        this.f4174f = r10;
    }
}
