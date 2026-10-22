package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders;
    private final P primaryAnimatorProvider;

    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    public MaterialVisibility(P r5, @Nullable VisibilityAnimatorProvider r10) {
        this.additionalAnimatorProviders = new ArrayList();
        this.primaryAnimatorProvider = r5;
        this.secondaryAnimatorProvider = r10;
    }

    private static void addAnimatorIfNeeded(List<Animator> r5, @Nullable VisibilityAnimatorProvider r10, ViewGroup r11, View r12, boolean r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r13 == false) goto L6;
        Animator r14 = r10.createAppear(r11, r12);
    L7:
        if (r14 == null) goto L10;
        r5.add(r14);
        return;
    L10:
        return;
    L6:
        r14 = r10.createDisappear(r11, r12);
        goto L7
    }

    private Animator createAnimator(@NonNull ViewGroup r5, @NonNull View r10, boolean r11) {
        AnimatorSet r12 = new AnimatorSet();
        ArrayList r13 = new ArrayList();
        addAnimatorIfNeeded(r13, this.primaryAnimatorProvider, r5, r10, r11);
        addAnimatorIfNeeded(r13, this.secondaryAnimatorProvider, r5, r10, r11);
        Iterator<VisibilityAnimatorProvider> r14 = this.additionalAnimatorProviders.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        addAnimatorIfNeeded(r13, r14.next(), r5, r10, r11);
        goto L4
    L6:
        maybeApplyThemeValues(r5.getContext(), r11);
        AnimatorSetCompat.playTogether(r12, r13);
        return r12;
    }

    private void maybeApplyThemeValues(@NonNull Context r5, boolean r10) {
        TransitionUtils.maybeApplyThemeDuration(this, r5, getDurationThemeAttrResId(r10));
        TransitionUtils.maybeApplyThemeInterpolator(this, r5, getEasingThemeAttrResId(r10), getDefaultEasingInterpolator(r10));
    }

    public void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r5) {
        this.additionalAnimatorProviders.add(r5);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @NonNull
    public TimeInterpolator getDefaultEasingInterpolator(boolean r5) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    @AttrRes
    public int getDurationThemeAttrResId(boolean r5) {
        return 0;
    }

    @AttrRes
    public int getEasingThemeAttrResId(boolean r5) {
        return 0;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup r5, View r10, TransitionValues r11, TransitionValues r12) {
        return createAnimator(r5, r10, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup r5, View r10, TransitionValues r11, TransitionValues r12) {
        return createAnimator(r5, r10, false);
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r5) {
        return this.additionalAnimatorProviders.remove(r5);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider r5) {
        this.secondaryAnimatorProvider = r5;
    }
}
