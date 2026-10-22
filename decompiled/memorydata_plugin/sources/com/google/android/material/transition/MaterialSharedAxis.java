package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.transition.TransitionValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialSharedAxis extends MaterialVisibility<m> {
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    static {
        DEFAULT_THEMED_DURATION_ATTR = ZeusTransformUtils.mapRes(R.attr.motionDurationLong1, "attr", "motionDurationLong1");
        DEFAULT_THEMED_EASING_ATTR = ZeusTransformUtils.mapRes(R.attr.motionEasingStandard, "attr", "motionEasingStandard");
    }

    public MaterialSharedAxis(int r3, boolean r4) {
        super(createPrimaryAnimatorProvider(r3, r4), createSecondaryAnimatorProvider());
        this.axis = r3;
        this.forward = r4;
    }

    private static m createPrimaryAnimatorProvider(int r2, boolean r3) {
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L10;
        return new j(r3);
    L10:
        throw new IllegalArgumentException("Invalid axis: " + r2);
    L12:
        if (r3 == false) goto L14;
        int r4 = 80;
    L16:
        return new k(r4);
    L14:
        r4 = 48;
        goto L16
    L18:
        if (r3 == false) goto L20;
        int r5 = GravityCompat.END;
    L22:
        return new k(r5);
    L20:
        r5 = GravityCompat.START;
        goto L22
    }

    private static m createSecondaryAnimatorProvider() {
        return new e();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* synthetic */ void addAdditionalAnimatorProvider(m r3) {
        super.addAdditionalAnimatorProvider((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
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

    public boolean isForward() {
        return this.forward;
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
