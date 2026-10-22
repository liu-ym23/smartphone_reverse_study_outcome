package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: loaded from: classes2.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 67;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 50;

    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean IS_LOLLIPOP = false;

    @Nullable
    private AccessibilityManager accessibilityManager;
    private final int animationFadeInDuration;

    @NonNull
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;

    @Nullable
    private AutoCompleteTextView autoCompleteTextView;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;
    private boolean editTextHasFocus;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private boolean isEndIconChecked;
    private final View.OnFocusChangeListener onEditTextFocusChangeListener;
    private final View.OnClickListener onIconClickListener;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    static {
        IS_LOLLIPOP = true;
    }

    public DropdownMenuEndIconDelegate(@NonNull EndCompoundLayout r5) {
        super(r5);
        int r10 = 1;
        this.onIconClickListener = new a(this, r10);
        this.onEditTextFocusChangeListener = new b(this, r10);
        this.touchExplorationStateChangeListener = new g(this);
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
        this.animationFadeInDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort3, 67);
        this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(r5.getContext(), R.attr.motionDurationShort3, 50);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(r5.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    public static /* synthetic */ void a(DropdownMenuEndIconDelegate r5) {
        r5.lambda$afterEditTextChanged$3();
    }

    public static /* synthetic */ ValueAnimator access$000(DropdownMenuEndIconDelegate r5) {
        return r5.fadeInAnim;
    }

    public static /* synthetic */ void b(DropdownMenuEndIconDelegate r5, boolean r10) {
        r5.lambda$new$2(r10);
    }

    public static /* synthetic */ void c(DropdownMenuEndIconDelegate r5, ValueAnimator r10) {
        r5.lambda$getAlphaAnimator$6(r10);
    }

    @NonNull
    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText r5) {
        if ((r5 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r5;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static /* synthetic */ void d(DropdownMenuEndIconDelegate r5, View r10, boolean r11) {
        r5.lambda$new$1(r10, r11);
    }

    public static /* synthetic */ boolean e(DropdownMenuEndIconDelegate r5, View r10, MotionEvent r11) {
        return r5.lambda$setUpDropdownShowHideBehavior$4(r10, r11);
    }

    public static /* synthetic */ void f(DropdownMenuEndIconDelegate r5) {
        r5.lambda$setUpDropdownShowHideBehavior$5();
    }

    public static /* synthetic */ void g(DropdownMenuEndIconDelegate r5, View r10) {
        r5.lambda$new$0(r10);
    }

    private ValueAnimator getAlphaAnimator(int r5, float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(this.animationFadeInterpolator);
        r11.setDuration(r5);
        r11.addUpdateListener(new c(this, 2));
        return r11;
    }

    private void initAnimators() {
        this.fadeInAnim = getAlphaAnimator(this.animationFadeInDuration, new float[]{0.0f, 1.0f});
        ValueAnimator r5 = getAlphaAnimator(this.animationFadeOutDuration, new float[]{1.0f, 0.0f});
        this.fadeOutAnim = r5;
        r5.addListener(new AnonymousClass1(this));
    }

    private boolean isDropdownPopupActive() {
        long r5 = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        if (r5 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r5 > 300) goto L8;
        return false;
    }

    private /* synthetic */ void lambda$afterEditTextChanged$3() {
        boolean r5 = this.autoCompleteTextView.isPopupShowing();
        setEndIconChecked(r5);
        this.dropdownPopupDirty = r5;
    }

    private /* synthetic */ void lambda$getAlphaAnimator$6(ValueAnimator r5) {
        float r10 = ((Float) r5.getAnimatedValue()).floatValue();
        this.endIconView.setAlpha(r10);
    }

    private /* synthetic */ void lambda$new$0(View r5) {
        showHideDropdown();
    }

    private /* synthetic */ void lambda$new$1(View r5, boolean r10) {
        this.editTextHasFocus = r10;
        refreshIconState();
        if (r10 == true) goto L6;
        setEndIconChecked(false);
        this.dropdownPopupDirty = false;
        return;
    }

    private /* synthetic */ void lambda$new$2(boolean r5) {
        AutoCompleteTextView r10 = this.autoCompleteTextView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (EditTextUtils.isEditable(r10) == true) goto L13;
        CheckableImageButton r11 = this.endIconView;
        if (r5 == false) goto L9;
        int r12 = 2;
    L10:
        ViewCompat.setImportantForAccessibility(r11, r12);
        return;
    L9:
        r12 = 1;
        goto L10
    }

    private /* synthetic */ boolean lambda$setUpDropdownShowHideBehavior$4(View r5, MotionEvent r10) {
        if (r10.getAction() == 1) goto L5;
    L8:
        return false;
    L5:
        if (isDropdownPopupActive() == false) goto L7;
        this.dropdownPopupDirty = false;
    L7:
        showHideDropdown();
        updateDropdownPopupDirty();
        goto L8
    }

    private /* synthetic */ void lambda$setUpDropdownShowHideBehavior$5() {
        updateDropdownPopupDirty();
        setEndIconChecked(false);
    }

    private void setEndIconChecked(boolean r5) {
        if (this.isEndIconChecked == r5) goto L6;
        this.isEndIconChecked = r5;
        this.fadeInAnim.cancel();
        this.fadeOutAnim.start();
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpDropdownShowHideBehavior() {
        this.autoCompleteTextView.setOnTouchListener(new e(this));
        if (IS_LOLLIPOP == false) goto L5;
        this.autoCompleteTextView.setOnDismissListener(new f(this));
    L5:
        this.autoCompleteTextView.setThreshold(0);
    }

    private void showHideDropdown() {
        if (this.autoCompleteTextView != null) goto L6;
        return;
    L6:
        if (isDropdownPopupActive() == false) goto L9;
        this.dropdownPopupDirty = false;
    L9:
        if (this.dropdownPopupDirty == false) goto L11;
        this.dropdownPopupDirty = false;
        return;
    L11:
        if (IS_LOLLIPOP == false) goto L13;
        setEndIconChecked(!this.isEndIconChecked);
    L15:
        if (this.isEndIconChecked == false) goto L17;
        this.autoCompleteTextView.requestFocus();
        this.autoCompleteTextView.showDropDown();
        return;
    L17:
        this.autoCompleteTextView.dismissDropDown();
        return;
    L13:
        this.isEndIconChecked = !this.isEndIconChecked;
        refreshIconState();
        goto L15
    }

    private void updateDropdownPopupDirty() {
        this.dropdownPopupDirty = true;
        this.dropdownPopupActivatedAt = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void afterEditTextChanged(Editable r5) {
        if (this.accessibilityManager.isTouchExplorationEnabled() == true) goto L5;
    L9:
        this.autoCompleteTextView.post(new d(this, 1));
        return;
    L5:
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == false) goto L9;
        if (this.endIconView.hasFocus() == true) goto L9;
        this.autoCompleteTextView.dismissDropDown();
        goto L9
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public int getIconContentDescriptionResId() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public int getIconDrawableResId() {
        if (IS_LOLLIPOP == false) goto L6;
        return R.drawable.mtrl_dropdown_arrow;
    L6:
        return R.drawable.mtrl_ic_arrow_drop_down;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onEditTextFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return this.touchExplorationStateChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isBoxBackgroundModeSupported(int r5) {
        if (r5 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconActivable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconActivated() {
        return this.editTextHasFocus;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconCheckable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconChecked() {
        return this.isEndIconChecked;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(@Nullable EditText r5) {
        this.autoCompleteTextView = castAutoCompleteTextViewOrThrow(r5);
        setUpDropdownShowHideBehavior();
        this.textInputLayout.setErrorIconDrawable(null);
        if (EditTextUtils.isEditable(r5) == false) goto L5;
    L7:
        this.textInputLayout.setEndIconVisible(true);
        return;
    L5:
        if (this.accessibilityManager.isTouchExplorationEnabled() == false) goto L7;
        ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        goto L7
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onInitializeAccessibilityNodeInfo(View r5, @NonNull AccessibilityNodeInfoCompat r10) {
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == true) goto L6;
        r10.setClassName(Spinner.class.getName());
    L6:
        if (r10.isShowingHintText() == false) goto L9;
        r10.setHintText(null);
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @SuppressLint({"WrongConstant"})
    public void onPopulateAccessibilityEvent(View r5, @NonNull AccessibilityEvent r10) {
        if (this.accessibilityManager.isEnabled() == true) goto L5;
        return;
    L5:
        if (EditTextUtils.isEditable(this.autoCompleteTextView) == false) goto L8;
        return;
    L8:
        if (r10.getEventType() == 32768) goto L12;
        if (r10.getEventType() == 8) goto L12;
    L16:
        boolean r11 = false;
    L18:
        if (r10.getEventType() == 1) goto L20;
        if (r11 == true) goto L20;
        return;
    L20:
        showHideDropdown();
        updateDropdownPopupDirty();
        return;
    L12:
        if (this.isEndIconChecked == false) goto L16;
        if (this.autoCompleteTextView.isPopupShowing() == true) goto L16;
        r11 = true;
        goto L18
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void setUp() {
        initAnimators();
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean shouldTintIconOnError() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @SuppressLint({"ClickableViewAccessibility"})
    public void tearDown() {
        AutoCompleteTextView r5 = this.autoCompleteTextView;
        if (r5 == null) goto L8;
        r5.setOnTouchListener(null);
        if (IS_LOLLIPOP == false) goto L9;
        this.autoCompleteTextView.setOnDismissListener(null);
        return;
    L9:
        return;
    }
}
