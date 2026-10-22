package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialElevationScale extends MaterialVisibility<j> {
    private static final float DEFAULT_SCALE = 0.85f;
    private final boolean growing;

    public MaterialElevationScale(boolean r3) {
        super(createPrimaryAnimatorProvider(r3), createSecondaryAnimatorProvider());
        this.growing = r3;
    }

    private static j createPrimaryAnimatorProvider(boolean r1) {
        j r0 = new j(r1);
        r0.a(DEFAULT_SCALE);
        r0.b(DEFAULT_SCALE);
        return r0;
    }

    private static m createSecondaryAnimatorProvider() {
        return new d();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* synthetic */ void addAdditionalAnimatorProvider(m r3) {
        super.addAdditionalAnimatorProvider((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ m getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ m getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isGrowing() {
        return this.growing;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return super.onAppear(r1, r2, r3, r4);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return super.onDisappear(r1, r2, r3, r4);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* synthetic */ boolean removeAdditionalAnimatorProvider(m r3) {
        return super.removeAdditionalAnimatorProvider((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* synthetic */ void setSecondaryAnimatorProvider(m r3) {
        super.setSecondaryAnimatorProvider((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"));
    }
}
