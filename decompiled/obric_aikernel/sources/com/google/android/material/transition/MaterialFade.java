package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialFade extends MaterialVisibility<d> {
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;

    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_INCOMING_DURATION_ATTR = 0;

    @AttrRes
    private static final int DEFAULT_THEMED_OUTGOING_DURATION_ATTR = 0;

    static {
        DEFAULT_THEMED_INCOMING_DURATION_ATTR = q5.b.motionDurationShort2;
        DEFAULT_THEMED_OUTGOING_DURATION_ATTR = q5.b.motionDurationShort1;
        DEFAULT_THEMED_EASING_ATTR = q5.b.motionEasingLinear;
    }

    public MaterialFade() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static d createPrimaryAnimatorProvider() {
        d r10 = new d();
        r10.d(DEFAULT_FADE_END_THRESHOLD_ENTER);
        return r10;
    }

    private static m createSecondaryAnimatorProvider() {
        j r10 = new j();
        r10.f(false);
        r10.d(DEFAULT_START_SCALE);
        return r10;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull m r10) {
        super.addAdditionalAnimatorProvider(r10);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @NonNull
    TimeInterpolator getDefaultEasingInterpolator(boolean r10) {
        return r5.a.f12673a;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    @AttrRes
    int getDurationThemeAttrResId(boolean r10) {
        if (r10 == false) goto L5;
        return DEFAULT_THEMED_INCOMING_DURATION_ATTR;
    L5:
        return DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
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
