package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Px
    private int f4179b;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4180c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f4181g;

        a(View r10, float r11) {
            this.f4180c = r10;
            this.f4181g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4180c.setTranslationX(this.f4181g);
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4182c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f4183g;

        b(View r10, float r11) {
            this.f4182c = r10;
            this.f4183g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f4182c.setTranslationY(this.f4183g);
        }
    }

    public k(int r10) {
        this.f4179b = -1;
        this.f4178a = r10;
    }

    private static Animator c(View r10, View r11, int r12, @Px int r13) {
        float r14 = r11.getTranslationX();
        float r15 = r11.getTranslationY();
        if (r12 == 3) goto L35;
        if (r12 == 5) goto L33;
        if (r12 == 48) goto L31;
        if (r12 == 80) goto L29;
        if (r12 == 8388611) goto L23;
        if (r12 != 8388613) goto L21;
        if (h(r10) == false) goto L17;
        float r16 = r14 - r13;
    L19:
        return e(r11, r16, r14, r14);
    L17:
        r16 = r13 + r14;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r12);
    L23:
        if (h(r10) == false) goto L25;
        float r17 = r13 + r14;
    L27:
        return e(r11, r17, r14, r14);
    L25:
        r17 = r14 - r13;
        goto L27
    L29:
        return f(r11, r13 + r15, r15, r15);
    L31:
        return f(r11, r15 - r13, r15, r15);
    L33:
        return e(r11, r14 - r13, r14, r14);
    L35:
        return e(r11, r13 + r14, r14, r14);
    }

    private static Animator d(View r10, View r11, int r12, @Px int r13) {
        float r14 = r11.getTranslationX();
        float r15 = r11.getTranslationY();
        if (r12 == 3) goto L35;
        if (r12 == 5) goto L33;
        if (r12 == 48) goto L31;
        if (r12 == 80) goto L29;
        if (r12 == 8388611) goto L23;
        if (r12 != 8388613) goto L21;
        if (h(r10) == false) goto L17;
        float r16 = r13 + r14;
    L19:
        return e(r11, r14, r16, r14);
    L17:
        r16 = r14 - r13;
        goto L19
    L21:
        throw new IllegalArgumentException("Invalid slide direction: " + r12);
    L23:
        if (h(r10) == false) goto L25;
        float r17 = r14 - r13;
    L27:
        return e(r11, r14, r17, r14);
    L25:
        r17 = r13 + r14;
        goto L27
    L29:
        return f(r11, r15, r15 - r13, r15);
    L31:
        return f(r11, r15, r13 + r15, r15);
    L33:
        return e(r11, r14, r13 + r14, r14);
    L35:
        return e(r11, r14, r14 - r13, r14);
    }

    private static Animator e(View r10, float r11, float r12, float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r11, r12})});
        r14.addListener(new a(r10, r13));
        return r14;
    }

    private static Animator f(View r10, float r11, float r12, float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(r10, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r11, r12})});
        r14.addListener(new b(r10, r13));
        return r14;
    }

    private int g(Context r10) {
        int r11 = this.f4179b;
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        return r10.getResources().getDimensionPixelSize(q5.d.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean h(View r10) {
        if (ViewCompat.getLayoutDirection(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator a(@NonNull ViewGroup r10, @NonNull View r11) {
        return c(r10, r11, this.f4178a, g(r11.getContext()));
    }

    @Override // com.google.android.material.transition.m
    @Nullable
    public Animator b(@NonNull ViewGroup r10, @NonNull View r11) {
        return d(r10, r11, this.f4178a, g(r11.getContext()));
    }
}
