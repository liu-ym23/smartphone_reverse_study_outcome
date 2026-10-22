package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.transition.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class MaterialVisibility<P extends m> extends Visibility {
    private final List<m> additionalAnimatorProviders;
    private final P primaryAnimatorProvider;

    @Nullable
    private m secondaryAnimatorProvider;

    protected MaterialVisibility(P r10, @Nullable m r11) {
        this.additionalAnimatorProviders = new ArrayList();
        this.primaryAnimatorProvider = r10;
        this.secondaryAnimatorProvider = r11;
    }

    private static void addAnimatorIfNeeded(List<Animator> r10, @Nullable m r11, ViewGroup r12, View r13, boolean r14) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r14 == false) goto L6;
        Animator r15 = r11.a(r12, r13);
    L7:
        if (r15 == null) goto L10;
        r10.add(r15);
        return;
    L10:
        return;
    L6:
        r15 = r11.b(r12, r13);
        goto L7
    }

    private Animator createAnimator(@NonNull ViewGroup r10, @NonNull View r11, boolean r12) {
        AnimatorSet r13 = new AnimatorSet();
        ArrayList r14 = new ArrayList();
        addAnimatorIfNeeded(r14, this.primaryAnimatorProvider, r10, r11, r12);
        addAnimatorIfNeeded(r14, this.secondaryAnimatorProvider, r10, r11, r12);
        Iterator<m> r15 = this.additionalAnimatorProviders.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        addAnimatorIfNeeded(r14, r15.next(), r10, r11, r12);
        goto L4
    L6:
        maybeApplyThemeValues(r10.getContext(), r12);
        r5.b.a(r13, r14);
        return r13;
    }

    private void maybeApplyThemeValues(@NonNull Context r10, boolean r11) {
        l.o(this, r10, getDurationThemeAttrResId(r11));
        l.p(this, r10, getEasingThemeAttrResId(r11), getDefaultEasingInterpolator(r11));
    }

    public void addAdditionalAnimatorProvider(@NonNull m r10) {
        this.additionalAnimatorProviders.add(r10);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @NonNull
    TimeInterpolator getDefaultEasingInterpolator(boolean r10) {
        return r5.a.f12674b;
    }

    @AttrRes
    int getDurationThemeAttrResId(boolean r10) {
        return 0;
    }

    @AttrRes
    int getEasingThemeAttrResId(boolean r10) {
        return 0;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public m getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return createAnimator(r10, r11, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return createAnimator(r10, r11, false);
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull m r10) {
        return this.additionalAnimatorProviders.remove(r10);
    }

    public void setSecondaryAnimatorProvider(@Nullable m r10) {
        this.secondaryAnimatorProvider = r10;
    }
}
