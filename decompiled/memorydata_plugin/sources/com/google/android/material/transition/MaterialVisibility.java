package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.transition.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class MaterialVisibility<P extends m> extends Visibility {
    private final List<m> additionalAnimatorProviders;
    private final P primaryAnimatorProvider;
    private m secondaryAnimatorProvider;

    public MaterialVisibility(P r3, m r4) {
        P r5 = (P) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        this.additionalAnimatorProviders = new ArrayList();
        this.primaryAnimatorProvider = r5;
        this.secondaryAnimatorProvider = r6;
    }

    private static void addAnimatorIfNeeded(List<Animator> r2, m r3, ViewGroup r4, View r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        if (r6 == false) goto L7;
        Animator r9 = r8.a(r4, r5);
    L8:
        if (r9 == null) goto L11;
        r7.add(r9);
        return;
    L11:
        return;
    L7:
        r9 = r8.b(r4, r5);
        goto L8
    }

    private Animator createAnimator(ViewGroup r7, View r8, boolean r9) {
        AnimatorSet r0 = new AnimatorSet();
        ArrayList r1 = new ArrayList();
        addAnimatorIfNeeded(r1, this.primaryAnimatorProvider, r7, r8, r9);
        addAnimatorIfNeeded(r1, this.secondaryAnimatorProvider, r7, r8, r9);
        Iterator<m> r2 = this.additionalAnimatorProviders.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        addAnimatorIfNeeded(r1, (m) ZeusTransformUtils.preCheckCast(r2.next(), m.class, "com.obric.memorydata.plugin"), r7, r8, r9);
        goto L4
    L6:
        maybeApplyThemeValues((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9);
        com.google.android.material.a.b.a(r0, r1);
        return r0;
    }

    private void maybeApplyThemeValues(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        l.a(this, r5, getDurationThemeAttrResId(r4));
        l.a(this, r5, getEasingThemeAttrResId(r4), getDefaultEasingInterpolator(r4));
    }

    public void addAdditionalAnimatorProvider(m r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.additionalAnimatorProviders.add(r4);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    TimeInterpolator getDefaultEasingInterpolator(boolean r1) {
        return com.google.android.material.a.a.f3742b;
    }

    int getDurationThemeAttrResId(boolean r1) {
        return 0;
    }

    int getEasingThemeAttrResId(boolean r1) {
        return 0;
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public m getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return createAnimator(r1, r2, false);
    }

    public boolean removeAdditionalAnimatorProvider(m r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        return this.additionalAnimatorProviders.remove(r4);
    }

    public void setSecondaryAnimatorProvider(m r3) {
        this.secondaryAnimatorProvider = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
    }
}
