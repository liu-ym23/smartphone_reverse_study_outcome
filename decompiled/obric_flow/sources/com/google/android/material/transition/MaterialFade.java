package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;

    @AttrRes
    private static final int DEFAULT_THEMED_INCOMING_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_INCOMING_EASING_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_OUTGOING_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_OUTGOING_EASING_ATTR = 0;

    static {
        DEFAULT_THEMED_INCOMING_DURATION_ATTR = R.attr.motionDurationMedium4;
        DEFAULT_THEMED_OUTGOING_DURATION_ATTR = R.attr.motionDurationShort3;
        DEFAULT_THEMED_INCOMING_EASING_ATTR = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        DEFAULT_THEMED_OUTGOING_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    }

    public MaterialFade() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static FadeProvider createPrimaryAnimatorProvider() {
        FadeProvider r5 = new FadeProvider();
        r5.setIncomingEndThreshold(DEFAULT_FADE_END_THRESHOLD_ENTER);
        return r5;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider r5 = new ScaleProvider();
        r5.setScaleOnDisappear(false);
        r5.setIncomingStartScale(DEFAULT_START_SCALE);
        return r5;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r5) {
        super.addAdditionalAnimatorProvider(r5);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    public TimeInterpolator getDefaultEasingInterpolator(boolean r5) {
        return AnimationUtils.LINEAR_INTERPOLATOR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getDurationThemeAttrResId(boolean r5) {
        if (r5 == false) goto L5;
        return DEFAULT_THEMED_INCOMING_DURATION_ATTR;
    L5:
        return DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    public int getEasingThemeAttrResId(boolean r5) {
        if (r5 == false) goto L5;
        return DEFAULT_THEMED_INCOMING_EASING_ATTR;
    L5:
        return DEFAULT_THEMED_OUTGOING_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Transition
    public /* bridge */ /* synthetic */ boolean isSeekingSupported() {
        return super.isSeekingSupported();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup r5, View r10, TransitionValues r11, TransitionValues r12) {
        return super.onAppear(r5, r10, r11, r12);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup r5, View r10, TransitionValues r11, TransitionValues r12) {
        return super.onDisappear(r5, r10, r11, r12);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider r5) {
        return super.removeAdditionalAnimatorProvider(r5);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider r5) {
        super.setSecondaryAnimatorProvider(r5);
    }
}
