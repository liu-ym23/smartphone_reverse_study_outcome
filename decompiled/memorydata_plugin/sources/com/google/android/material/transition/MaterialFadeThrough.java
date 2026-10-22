package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialFadeThrough extends MaterialVisibility<e> {
    private static final float DEFAULT_START_SCALE = 0.92f;
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;

    static {
        DEFAULT_THEMED_DURATION_ATTR = ZeusTransformUtils.mapRes(R.attr.motionDurationLong1, "attr", "motionDurationLong1");
        DEFAULT_THEMED_EASING_ATTR = ZeusTransformUtils.mapRes(R.attr.motionEasingStandard, "attr", "motionEasingStandard");
    }

    public MaterialFadeThrough() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static e createPrimaryAnimatorProvider() {
        return new e();
    }

    private static m createSecondaryAnimatorProvider() {
        j r0 = new j();
        r0.a(false);
        r0.b(DEFAULT_START_SCALE);
        return r0;
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
    int getDurationThemeAttrResId(boolean r1) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int getEasingThemeAttrResId(boolean r1) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ m getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ m getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
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
