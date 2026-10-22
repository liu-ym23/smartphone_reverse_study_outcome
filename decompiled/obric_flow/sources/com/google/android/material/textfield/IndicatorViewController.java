package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class IndicatorViewController {
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    static final int COUNTER_INDEX = 2;
    private static final int DEFAULT_CAPTION_FADE_ANIMATION_DURATION = 167;
    private static final int DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION = 217;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;

    @Nullable
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private final int captionFadeInAnimationDuration;

    @NonNull
    private final TimeInterpolator captionFadeInAnimationInterpolator;
    private final int captionFadeOutAnimationDuration;

    @NonNull
    private final TimeInterpolator captionFadeOutAnimationInterpolator;
    private int captionToShow;
    private final int captionTranslationYAnimationDuration;

    @NonNull
    private final TimeInterpolator captionTranslationYAnimationInterpolator;
    private final float captionTranslationYPx;
    private final Context context;
    private boolean errorEnabled;

    @Nullable
    private CharSequence errorText;
    private int errorTextAppearance;

    @Nullable
    private TextView errorView;
    private int errorViewAccessibilityLiveRegion;

    @Nullable
    private CharSequence errorViewContentDescription;

    @Nullable
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;

    @Nullable
    private TextView helperTextView;

    @Nullable
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;

    @NonNull
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(@NonNull TextInputLayout r5) {
        Context r10 = r5.getContext();
        this.context = r10;
        this.textInputView = r5;
        this.captionTranslationYPx = r10.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.captionTranslationYAnimationDuration = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationShort4, 217);
        this.captionFadeInAnimationDuration = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationMedium4, DEFAULT_CAPTION_FADE_ANIMATION_DURATION);
        this.captionFadeOutAnimationDuration = MotionUtils.resolveThemeDuration(r10, R.attr.motionDurationShort4, DEFAULT_CAPTION_FADE_ANIMATION_DURATION);
        this.captionTranslationYAnimationInterpolator = MotionUtils.resolveThemeInterpolator(r10, R.attr.motionEasingEmphasizedDecelerateInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        int r11 = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        TimeInterpolator r12 = AnimationUtils.LINEAR_INTERPOLATOR;
        this.captionFadeInAnimationInterpolator = MotionUtils.resolveThemeInterpolator(r10, r11, r12);
        this.captionFadeOutAnimationInterpolator = MotionUtils.resolveThemeInterpolator(r10, R.attr.motionEasingLinearInterpolator, r12);
    }

    public static /* synthetic */ int access$002(IndicatorViewController r5, int r10) {
        r5.captionDisplayed = r10;
        return r10;
    }

    public static /* synthetic */ Animator access$102(IndicatorViewController r5, Animator r10) {
        r5.captionAnimator = r10;
        return r10;
    }

    public static /* synthetic */ TextView access$200(IndicatorViewController r5) {
        return r5.errorView;
    }

    public static /* synthetic */ TextInputLayout access$300(IndicatorViewController r5) {
        return r5.textInputView;
    }

    private boolean canAdjustIndicatorPadding() {
        if (this.indicatorArea != null) goto L5;
    L7:
        return false;
    L5:
        if (this.textInputView.getEditText() == null) goto L7;
        return true;
    }

    private void createCaptionAnimators(@NonNull List<Animator> r5, boolean r10, @Nullable TextView r11, int r12, int r13, int r14) {
        if (r11 == null) goto L19;
        if (r10 == false) goto L23;
        if (r12 == r14) goto L7;
        if (r12 == r13) goto L7;
        return;
    L7:
        if (r14 != r12) goto L9;
        boolean r15 = true;
    L10:
        ObjectAnimator r16 = createCaptionOpacityAnimator(r11, r15);
        if (r12 != r14) goto L14;
        if (r13 == 0) goto L14;
        r16.setStartDelay(this.captionFadeOutAnimationDuration);
    L14:
        r5.add(r16);
        if (r14 != r12) goto L21;
        if (r13 == 0) goto L22;
        ObjectAnimator r17 = createCaptionTranslationYAnimator(r11);
        r17.setStartDelay(this.captionFadeOutAnimationDuration);
        r5.add(r17);
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r15 = false;
        goto L10
    L23:
        return;
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView r5, boolean r10) {
        if (r10 == false) goto L4;
        float r11 = 1.0f;
    L5:
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r5, View.ALPHA, new float[]{r11});
        if (r10 == false) goto L9;
        int r13 = this.captionFadeInAnimationDuration;
    L10:
        r12.setDuration(r13);
        if (r10 == false) goto L13;
        TimeInterpolator r14 = this.captionFadeInAnimationInterpolator;
    L14:
        r12.setInterpolator(r14);
        return r12;
    L13:
        r14 = this.captionFadeOutAnimationInterpolator;
        goto L14
    L9:
        r13 = this.captionFadeOutAnimationDuration;
        goto L10
    L4:
        r11 = 0.0f;
        goto L5
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView r5) {
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r5, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        r10.setDuration(this.captionTranslationYAnimationDuration);
        r10.setInterpolator(this.captionTranslationYAnimationInterpolator);
        return r10;
    }

    @Nullable
    private TextView getCaptionViewFromDisplayState(int r5) {
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L9;
        return null;
    L9:
        return this.helperTextView;
    L11:
        return this.errorView;
    }

    private int getIndicatorPadding(boolean r5, @DimenRes int r10, int r11) {
        if (r5 == true) goto L4;
        return r11;
    L4:
        return this.context.getResources().getDimensionPixelSize(r10);
    }

    private boolean isCaptionStateError(int r5) {
        if (r5 == 1) goto L5;
    L9:
        return false;
    L5:
        if (this.errorView == null) goto L9;
        if (TextUtils.isEmpty(this.errorText) == true) goto L9;
        return true;
    }

    private boolean isCaptionStateHelperText(int r5) {
        if (r5 == 2) goto L5;
    L9:
        return false;
    L5:
        if (this.helperTextView == null) goto L9;
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        return true;
    }

    private void setCaptionViewVisibilities(int r5, int r10) {
        if (r5 != r10) goto L4;
        return;
    L4:
        if (r10 == 0) goto L8;
        TextView r11 = getCaptionViewFromDisplayState(r10);
        if (r11 == null) goto L8;
        r11.setVisibility(0);
        r11.setAlpha(1.0f);
    L8:
        if (r5 == 0) goto L14;
        TextView r12 = getCaptionViewFromDisplayState(r5);
        if (r12 == null) goto L14;
        r12.setVisibility(4);
        if (r5 != 1) goto L14;
        r12.setText(null);
    L14:
        this.captionDisplayed = r10;
    }

    private void setTextViewTypeface(@Nullable TextView r5, Typeface r10) {
        if (r5 == null) goto L5;
        r5.setTypeface(r10);
        return;
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup r5, int r10) {
        if (r10 != 0) goto L5;
        r5.setVisibility(8);
        return;
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView r5, @NonNull CharSequence r10) {
        if (ViewCompat.isLaidOut(this.textInputView) == true) goto L5;
    L12:
        return false;
    L5:
        if (this.textInputView.isEnabled() == false) goto L12;
        if (this.captionToShow != this.captionDisplayed) goto L11;
        if (r5 == null) goto L11;
        if (TextUtils.equals(r5.getText(), r10) == true) goto L12;
    L11:
        return true;
    }

    private void updateCaptionViewsVisibility(final int r14, final int r15, boolean r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        if (r16 == false) goto L7;
        AnimatorSet r11 = new AnimatorSet();
        this.captionAnimator = r11;
        ArrayList r12 = new ArrayList();
        createCaptionAnimators(r12, this.helperTextEnabled, this.helperTextView, 2, r14, r15);
        createCaptionAnimators(r12, this.errorEnabled, this.errorView, 1, r14, r15);
        AnimatorSetCompat.playTogether(r11, r12);
        final TextView r5 = getCaptionViewFromDisplayState(r14);
        final TextView r10 = getCaptionViewFromDisplayState(r15);
        r11.addListener(new AnonymousClass1(this, r15, r5, r14, r10));
        r11.start();
    L8:
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(r16);
        this.textInputView.updateTextInputBoxState();
        return;
    L7:
        setCaptionViewVisibilities(r14, r15);
        goto L8
    }

    public void addIndicator(TextView r10, int r11) {
        if (this.indicatorArea != null) goto L10;
        if (this.captionArea != null) goto L10;
        LinearLayout r5 = new LinearLayout(this.context);
        this.indicatorArea = r5;
        r5.setOrientation(0);
        this.textInputView.addView(this.indicatorArea, -1, -2);
        this.captionArea = new FrameLayout(this.context);
        this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (this.textInputView.getEditText() == null) goto L10;
        adjustIndicatorPadding();
    L10:
        if (isCaptionView(r11) == false) goto L12;
        this.captionArea.setVisibility(0);
        this.captionArea.addView(r10);
    L13:
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
        return;
    L12:
        this.indicatorArea.addView(r10, new LinearLayout.LayoutParams(-2, -2));
        goto L13
    }

    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding() == false) goto L6;
        EditText r5 = this.textInputView.getEditText();
        boolean r10 = MaterialResources.isFontScaleAtLeast1_3(this.context);
        ViewCompat.setPaddingRelative(this.indicatorArea, getIndicatorPadding(r10, R.dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(r5)), getIndicatorPadding(r10, R.dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), getIndicatorPadding(r10, R.dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(r5)), 0);
        return;
    }

    public void cancelCaptionAnimator() {
        Animator r5 = this.captionAnimator;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.errorViewAccessibilityLiveRegion;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    @Nullable
    public CharSequence getErrorText() {
        return this.errorText;
    }

    @ColorInt
    public int getErrorViewCurrentTextColor() {
        TextView r5 = this.errorView;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.getCurrentTextColor();
    }

    @Nullable
    public ColorStateList getErrorViewTextColors() {
        TextView r5 = this.errorView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getTextColors();
    }

    public CharSequence getHelperText() {
        return this.helperText;
    }

    @Nullable
    public View getHelperTextView() {
        return this.helperTextView;
    }

    @Nullable
    public ColorStateList getHelperTextViewColors() {
        TextView r5 = this.helperTextView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getTextColors();
    }

    @ColorInt
    public int getHelperTextViewCurrentTextColor() {
        TextView r5 = this.helperTextView;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.getCurrentTextColor();
    }

    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) goto L5;
    L10:
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
        return;
    L5:
        if (this.helperTextEnabled == true) goto L7;
    L9:
        this.captionToShow = 0;
        goto L10
    L7:
        if (TextUtils.isEmpty(this.helperText) == true) goto L9;
        this.captionToShow = 2;
        goto L10
    }

    public void hideHelperText() {
        cancelCaptionAnimator();
        int r5 = this.captionDisplayed;
        if (r5 != 2) goto L5;
        this.captionToShow = 0;
    L5:
        updateCaptionViewsVisibility(r5, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, ""));
    }

    public boolean isCaptionView(int r5) {
        if (r5 == 0) goto L8;
        if (r5 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    public void removeIndicator(TextView r5, int r10) {
        if (this.indicatorArea != null) goto L6;
        return;
    L6:
        if (isCaptionView(r10) == false) goto L10;
        FrameLayout r11 = this.captionArea;
        if (r11 == null) goto L10;
        r11.removeView(r5);
    L11:
        int r12 = this.indicatorsAdded - 1;
        this.indicatorsAdded = r12;
        setViewGroupGoneIfEmpty(this.indicatorArea, r12);
        return;
    L10:
        this.indicatorArea.removeView(r5);
        goto L11
    }

    public void setErrorAccessibilityLiveRegion(int r5) {
        this.errorViewAccessibilityLiveRegion = r5;
        TextView r10 = this.errorView;
        if (r10 == null) goto L6;
        ViewCompat.setAccessibilityLiveRegion(r10, r5);
        return;
    }

    public void setErrorContentDescription(@Nullable CharSequence r5) {
        this.errorViewContentDescription = r5;
        TextView r10 = this.errorView;
        if (r10 == null) goto L6;
        r10.setContentDescription(r5);
        return;
    }

    public void setErrorEnabled(boolean r5) {
        if (this.errorEnabled != r5) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r5 == false) goto L11;
        AppCompatTextView r10 = new AppCompatTextView(this.context);
        this.errorView = r10;
        r10.setId(R.id.textinput_error);
        this.errorView.setTextAlignment(5);
        Typeface r11 = this.typeface;
        if (r11 == null) goto L10;
        this.errorView.setTypeface(r11);
    L10:
        setErrorTextAppearance(this.errorTextAppearance);
        setErrorViewTextColor(this.errorViewTextColor);
        setErrorContentDescription(this.errorViewContentDescription);
        setErrorAccessibilityLiveRegion(this.errorViewAccessibilityLiveRegion);
        this.errorView.setVisibility(4);
        addIndicator(this.errorView, 0);
    L12:
        this.errorEnabled = r5;
        return;
    L11:
        hideError();
        removeIndicator(this.errorView, 0);
        this.errorView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setErrorTextAppearance(@StyleRes int r5) {
        this.errorTextAppearance = r5;
        TextView r10 = this.errorView;
        if (r10 == null) goto L6;
        this.textInputView.setTextAppearanceCompatWithErrorFallback(r10, r5);
        return;
    }

    public void setErrorViewTextColor(@Nullable ColorStateList r5) {
        this.errorViewTextColor = r5;
        TextView r10 = this.errorView;
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.setTextColor(r5);
        return;
    L8:
        return;
    }

    public void setHelperTextAppearance(@StyleRes int r5) {
        this.helperTextTextAppearance = r5;
        TextView r10 = this.helperTextView;
        if (r10 == null) goto L6;
        TextViewCompat.setTextAppearance(r10, r5);
        return;
    }

    public void setHelperTextEnabled(boolean r5) {
        if (this.helperTextEnabled != r5) goto L5;
        return;
    L5:
        cancelCaptionAnimator();
        if (r5 == false) goto L11;
        AppCompatTextView r10 = new AppCompatTextView(this.context);
        this.helperTextView = r10;
        r10.setId(R.id.textinput_helper_text);
        this.helperTextView.setTextAlignment(5);
        Typeface r11 = this.typeface;
        if (r11 == null) goto L10;
        this.helperTextView.setTypeface(r11);
    L10:
        this.helperTextView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
        setHelperTextAppearance(this.helperTextTextAppearance);
        setHelperTextViewTextColor(this.helperTextViewTextColor);
        addIndicator(this.helperTextView, 1);
        this.helperTextView.setAccessibilityDelegate(new AnonymousClass2(this));
    L12:
        this.helperTextEnabled = r5;
        return;
    L11:
        hideHelperText();
        removeIndicator(this.helperTextView, 1);
        this.helperTextView = null;
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateTextInputBoxState();
        goto L12
    }

    public void setHelperTextViewTextColor(@Nullable ColorStateList r5) {
        this.helperTextViewTextColor = r5;
        TextView r10 = this.helperTextView;
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.setTextColor(r5);
        return;
    L8:
        return;
    }

    public void setTypefaces(Typeface r5) {
        if (r5 == this.typeface) goto L6;
        this.typeface = r5;
        setTextViewTypeface(this.errorView, r5);
        setTextViewTypeface(this.helperTextView, r5);
        return;
    }

    public void showError(CharSequence r5) {
        cancelCaptionAnimator();
        this.errorText = r5;
        this.errorView.setText(r5);
        int r10 = this.captionDisplayed;
        if (r10 == 1) goto L5;
        this.captionToShow = 1;
    L5:
        updateCaptionViewsVisibility(r10, this.captionToShow, shouldAnimateCaptionView(this.errorView, r5));
    }

    public void showHelper(CharSequence r5) {
        cancelCaptionAnimator();
        this.helperText = r5;
        this.helperTextView.setText(r5);
        int r10 = this.captionDisplayed;
        if (r10 == 2) goto L5;
        this.captionToShow = 2;
    L5:
        updateCaptionViewsVisibility(r10, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, r5));
    }
}
