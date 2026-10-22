package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {

    @Nullable
    private StateListAnimator stateListAnimator;

    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        public AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel r5) {
            super(r5);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(FloatingActionButton r5, ShadowViewDelegate r10) {
        super(r5, r10);
    }

    @NonNull
    private StateListAnimator createDefaultStateListAnimator(float r10, float r11, float r12) {
        StateListAnimator r5 = new StateListAnimator();
        r5.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(r10, r12));
        r5.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        r5.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        r5.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(r10, r11));
        AnimatorSet r13 = new AnimatorSet();
        ArrayList r14 = new ArrayList();
        r14.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r10}).setDuration(0));
        r14.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r13.playSequentially((Animator[]) r14.toArray(new Animator[0]));
        r13.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        r5.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, r13);
        r5.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        return r5;
    }

    @NonNull
    private Animator createElevationAnimator(float r10, float r11) {
        AnimatorSet r5 = new AnimatorSet();
        r5.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r10}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{r11}).setDuration(100));
        r5.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return r5;
    }

    @NonNull
    public BorderDrawable createBorderDrawable(int r10, ColorStateList r11) {
        Context r5 = this.view.getContext();
        BorderDrawable r12 = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        r12.setGradientColors(ContextCompat.getColor(r5, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(r5, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(r5, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(r5, R.color.design_fab_stroke_end_outer_color));
        r12.setBorderWidth(r10);
        r12.setBorderTint(r11);
        return r12;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @NonNull
    public MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void getPadding(@NonNull Rect r5) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L6;
        super.getPadding(r5);
        return;
    L6:
        if (shouldExpandBoundsForA11y() == true) goto L8;
        int r10 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
        r5.set(r10, r10, r10, r10);
        return;
    L8:
        r5.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void initializeBackgroundDrawable(ColorStateList r5, @Nullable PorterDuff.Mode r10, ColorStateList r11, int r12) {
        MaterialShapeDrawable r13 = createShapeDrawable();
        this.shapeDrawable = r13;
        r13.setTintList(r5);
        if (r10 == null) goto L5;
        this.shapeDrawable.setTintMode(r10);
    L5:
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (r12 <= 0) goto L8;
        this.borderDrawable = createBorderDrawable(r12, r5);
        Drawable r14 = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
    L9:
        RippleDrawable r15 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r11), r14, null);
        this.rippleDrawable = r15;
        this.contentBackground = r15;
        return;
    L8:
        this.borderDrawable = null;
        r14 = this.shapeDrawable;
        goto L9
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onDrawableStateChanged(int[] r5) {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onElevationsChanged(float r5, float r10, float r11) {
        if (this.view.getStateListAnimator() != this.stateListAnimator) goto L6;
        StateListAnimator r12 = createDefaultStateListAnimator(r5, r10, r11);
        this.stateListAnimator = r12;
        this.view.setStateListAnimator(r12);
    L6:
        if (shouldAddPadding() == false) goto L9;
        updatePadding();
        return;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void setRippleColor(@Nullable ColorStateList r5) {
        Drawable r10 = this.rippleDrawable;
        if ((r10 instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) r10).setColor(RippleUtils.sanitizeRippleDrawableColor(r5));
        return;
    L5:
        super.setRippleColor(r5);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean shouldAddPadding() {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (shouldExpandBoundsForA11y() == false) goto L8;
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void updateFromViewRotation() {
    }
}
