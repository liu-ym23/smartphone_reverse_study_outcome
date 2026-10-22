package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: loaded from: classes2.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private static final int DEFAULT_ANIMATION_FADE_DURATION = 100;
    private static final int DEFAULT_ANIMATION_SCALE_DURATION = 150;
    private final int animationFadeDuration;

    @NonNull
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationScaleDuration;

    @NonNull
    private final TimeInterpolator animationScaleInterpolator;

    @Nullable
    private EditText editText;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;
    private final View.OnClickListener onIconClickListener;

    public ClearTextEndIconDelegate(@NonNull EndCompoundLayout r5) {
        super(r5);
        int r10 = 0;
        this.onIconClickListener = new a(this, r10);
        this.onFocusChangeListener = new b(this, r10);
        this.animationFadeDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort3, 100);
        this.animationScaleDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort3, 150);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    public static /* synthetic */ void a(ClearTextEndIconDelegate r5, View r10) {
        r5.lambda$new$0(r10);
    }

    private void animateIcon(boolean r5) {
        if (this.endLayout.isEndIconVisible() != r5) goto L5;
        boolean r10 = true;
    L6:
        if (r5 == true) goto L8;
    L12:
        if (r5 == true) goto L19;
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (r10 == false) goto L20;
        this.iconOutAnim.end();
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (this.iconInAnim.isRunning() == true) goto L12;
        this.iconOutAnim.cancel();
        this.iconInAnim.start();
        if (r10 == false) goto L17;
        this.iconInAnim.end();
        return;
    L17:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static /* synthetic */ void b(ClearTextEndIconDelegate r5, View r10, boolean r11) {
        r5.lambda$new$1(r10, r11);
    }

    public static /* synthetic */ void c(ClearTextEndIconDelegate r5, ValueAnimator r10) {
        r5.lambda$getAlphaAnimator$3(r10);
    }

    public static /* synthetic */ void d(ClearTextEndIconDelegate r5, ValueAnimator r10) {
        r5.lambda$getScaleAnimator$4(r10);
    }

    public static /* synthetic */ void e(ClearTextEndIconDelegate r5) {
        r5.lambda$tearDown$2();
    }

    private ValueAnimator getAlphaAnimator(float... r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(r5);
        r10.setInterpolator(this.animationFadeInterpolator);
        r10.setDuration(this.animationFadeDuration);
        r10.addUpdateListener(new c(this, 0));
        return r10;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        r5.setInterpolator(this.animationScaleInterpolator);
        r5.setDuration(this.animationScaleDuration);
        r5.addUpdateListener(new c(this, 1));
        return r5;
    }

    private void initAnimators() {
        ValueAnimator r5 = getScaleAnimator();
        ValueAnimator r10 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        AnimatorSet r11 = new AnimatorSet();
        this.iconInAnim = r11;
        r11.playTogether(new Animator[]{r5, r10});
        this.iconInAnim.addListener(new AnonymousClass1(this));
        ValueAnimator r12 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        this.iconOutAnim = r12;
        r12.addListener(new AnonymousClass2(this));
    }

    private /* synthetic */ void lambda$getAlphaAnimator$3(ValueAnimator r5) {
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        this.endIconView.setAlpha(r10);
    }

    private /* synthetic */ void lambda$getScaleAnimator$4(ValueAnimator r5) {
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        this.endIconView.setScaleX(r10);
        this.endIconView.setScaleY(r10);
    }

    private /* synthetic */ void lambda$new$0(View r5) {
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        Editable r11 = r10.getText();
        if (r11 == null) goto L8;
        r11.clear();
    L8:
        refreshIconState();
    }

    private /* synthetic */ void lambda$new$1(View r5, boolean r10) {
        animateIcon(shouldBeVisible());
    }

    private /* synthetic */ void lambda$tearDown$2() {
        animateIcon(true);
    }

    private boolean shouldBeVisible() {
        EditText r5 = this.editText;
        if (r5 != null) goto L5;
    L11:
        return false;
    L5:
        if (r5.hasFocus() == true) goto L9;
        if (this.endIconView.hasFocus() == false) goto L11;
    L9:
        if (this.editText.getText().length() <= 0) goto L11;
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void afterEditTextChanged(@NonNull Editable r5) {
        if (this.endLayout.getSuffixText() == null) goto L5;
        return;
    L5:
        animateIcon(shouldBeVisible());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public int getIconContentDescriptionResId() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public int getIconDrawableResId() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(@Nullable EditText r5) {
        this.editText = r5;
        this.textInputLayout.setEndIconVisible(shouldBeVisible());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean r5) {
        if (this.endLayout.getSuffixText() != null) goto L5;
        return;
    L5:
        animateIcon(r5);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void setUp() {
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void tearDown() {
        EditText r5 = this.editText;
        if (r5 == null) goto L6;
        r5.post(new d(this, 0));
        return;
    }
}
