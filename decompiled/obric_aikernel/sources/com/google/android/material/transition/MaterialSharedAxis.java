package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.transition.TransitionValues;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialSharedAxis extends MaterialVisibility<m> {

    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    static {
        DEFAULT_THEMED_DURATION_ATTR = q5.b.motionDurationLong1;
        DEFAULT_THEMED_EASING_ATTR = q5.b.motionEasingStandard;
    }

    public MaterialSharedAxis(int r10, boolean r11) {
        super(createPrimaryAnimatorProvider(r10, r11), createSecondaryAnimatorProvider());
        this.axis = r10;
        this.forward = r11;
    }

    private static m createPrimaryAnimatorProvider(int r10, boolean r11) {
        if (r10 == 0) goto L18;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L10;
        return new j(r11);
    L10:
        throw new IllegalArgumentException("Invalid axis: " + r10);
    L12:
        if (r11 == false) goto L14;
        int r12 = 80;
    L16:
        return new k(r12);
    L14:
        r12 = 48;
        goto L16
    L18:
        if (r11 == false) goto L20;
        int r13 = GravityCompat.END;
    L22:
        return new k(r13);
    L20:
        r13 = GravityCompat.START;
        goto L22
    }

    private static m createSecondaryAnimatorProvider() {
        return new e();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull m r10) {
        super.addAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    int getDurationThemeAttrResId(boolean r10) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    int getEasingThemeAttrResId(boolean r10) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    public /* bridge */ /* synthetic */ m getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ m getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return super.onAppear(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup r10, View r11, TransitionValues r12, TransitionValues r13) {
        return super.onDisappear(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull m r10) {
        return super.removeAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable m r10) {
        super.setSecondaryAnimatorProvider(r10);
    }
}
