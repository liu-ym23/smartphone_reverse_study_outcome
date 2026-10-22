package com.google.android.material.textfield;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class EndCompoundLayout extends LinearLayout {

    @Nullable
    private final AccessibilityManager accessibilityManager;
    private EditText editText;
    private final TextWatcher editTextWatcher;
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> endIconChangedListeners;
    private final EndIconDelegates endIconDelegates;

    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMinSize;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;

    @NonNull
    private ImageView.ScaleType endIconScaleType;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;

    @NonNull
    private final CheckableImageButton endIconView;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;

    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean hintExpanded;
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;

    @Nullable
    private CharSequence suffixText;

    @NonNull
    private final TextView suffixTextView;
    final TextInputLayout textInputLayout;

    @Nullable
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    public static class EndIconDelegates {
        private final int customEndIconDrawableId;
        private final SparseArray<EndIconDelegate> delegates;
        private final EndCompoundLayout endLayout;
        private final int passwordIconDrawableId;

        public EndIconDelegates(EndCompoundLayout r5, TintTypedArray r10) {
            this.delegates = new SparseArray();
            this.endLayout = r5;
            this.customEndIconDrawableId = r10.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.passwordIconDrawableId = r10.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        public static /* synthetic */ int access$500(EndIconDelegates r5) {
            return r5.customEndIconDrawableId;
        }

        private EndIconDelegate create(int r5) {
            if (r5 == (-1)) goto L22;
            if (r5 == 0) goto L20;
            if (r5 == 1) goto L18;
            if (r5 == 2) goto L16;
            if (r5 != 3) goto L14;
            return new DropdownMenuEndIconDelegate(this.endLayout);
        L14:
            throw new IllegalArgumentException(j0.g(r5, "Invalid end icon mode: "));
        L16:
            return new ClearTextEndIconDelegate(this.endLayout);
        L18:
            return new PasswordToggleEndIconDelegate(this.endLayout, this.passwordIconDrawableId);
        L20:
            return new NoEndIconDelegate(this.endLayout);
        L22:
            return new CustomEndIconDelegate(this.endLayout);
        }

        public EndIconDelegate get(int r5) {
            EndIconDelegate r10 = this.delegates.get(r5);
            if (r10 != null) goto L6;
            EndIconDelegate r11 = create(r5);
            this.delegates.append(r5, r11);
            return r11;
        L6:
            return r10;
        }
    }

    public EndCompoundLayout(TextInputLayout r10, TintTypedArray r11) {
        super(r10.getContext());
        this.endIconMode = 0;
        this.endIconChangedListeners = new LinkedHashSet();
        this.editTextWatcher = new AnonymousClass1(this);
        TextInputLayout.OnEditTextAttachedListener r5 = new AnonymousClass2(this);
        this.onEditTextAttachedListener = r5;
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.textInputLayout = r10;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout r12 = new FrameLayout(getContext());
        this.endIconFrame = r12;
        r12.setVisibility(8);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater r13 = LayoutInflater.from(getContext());
        CheckableImageButton r14 = createIconView(this, r13, R.id.text_input_error_icon);
        this.errorIconView = r14;
        CheckableImageButton r15 = createIconView(r12, r13, R.id.text_input_end_icon);
        this.endIconView = r15;
        this.endIconDelegates = new EndIconDelegates(this, r11);
        AppCompatTextView r16 = new AppCompatTextView(getContext());
        this.suffixTextView = r16;
        initErrorIconView(r11);
        initEndIconView(r11);
        initSuffixTextView(r11);
        r12.addView(r15);
        addView(r16);
        addView(r12);
        addView(r14);
        r10.addOnEditTextAttachedListener(r5);
        addOnAttachStateChangeListener(new AnonymousClass3(this));
    }

    public static /* synthetic */ EditText access$000(EndCompoundLayout r5) {
        return r5.editText;
    }

    public static /* synthetic */ EditText access$002(EndCompoundLayout r5, EditText r10) {
        r5.editText = r10;
        return r10;
    }

    public static /* synthetic */ TextWatcher access$100(EndCompoundLayout r5) {
        return r5.editTextWatcher;
    }

    public static /* synthetic */ void access$200(EndCompoundLayout r5, EndIconDelegate r10) {
        r5.setOnFocusChangeListenersIfNeeded(r10);
    }

    public static /* synthetic */ void access$300(EndCompoundLayout r5) {
        r5.addTouchExplorationStateChangeListenerIfNeeded();
    }

    public static /* synthetic */ void access$400(EndCompoundLayout r5) {
        r5.removeTouchExplorationStateChangeListenerIfNeeded();
    }

    private void addTouchExplorationStateChangeListenerIfNeeded() {
        if (this.touchExplorationStateChangeListener != null) goto L5;
        return;
    L5:
        if (this.accessibilityManager != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        return;
    }

    private CheckableImageButton createIconView(ViewGroup r5, LayoutInflater r10, @IdRes int r11) {
        CheckableImageButton r12 = (CheckableImageButton) r10.inflate(R.layout.design_text_input_end_icon, r5, false);
        r12.setId(r11);
        IconHelper.setCompatRippleBackgroundIfNeeded(r12);
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L5;
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) r12.getLayoutParams(), 0);
    L5:
        return r12;
    }

    private void dispatchOnEndIconChanged(int r5) {
        Iterator<TextInputLayout.OnEndIconChangedListener> r10 = this.endIconChangedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onEndIconChanged(this.textInputLayout, r5);
        goto L4
    }

    private int getIconResId(EndIconDelegate r5) {
        int r10 = EndIconDelegates.access$500(this.endIconDelegates);
        if (r10 == 0) goto L5;
        return r10;
    L5:
        return r5.getIconDrawableResId();
    }

    private void initEndIconView(TintTypedArray r10) {
        if (r10.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == true) goto L11;
        if (r10.hasValue(R.styleable.TextInputLayout_endIconTint) == false) goto L8;
        this.endIconTintList = MaterialResources.getColorStateList(getContext(), r10, R.styleable.TextInputLayout_endIconTint);
    L8:
        if (r10.hasValue(R.styleable.TextInputLayout_endIconTintMode) == false) goto L11;
        this.endIconTintMode = ViewUtils.parseTintMode(r10.getInt(R.styleable.TextInputLayout_endIconTintMode, -1), null);
    L11:
        if (r10.hasValue(R.styleable.TextInputLayout_endIconMode) == false) goto L17;
        setEndIconMode(r10.getInt(R.styleable.TextInputLayout_endIconMode, 0));
        if (r10.hasValue(R.styleable.TextInputLayout_endIconContentDescription) == false) goto L15;
        setEndIconContentDescription(r10.getText(R.styleable.TextInputLayout_endIconContentDescription));
    L15:
        setEndIconCheckable(r10.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
    L25:
        setEndIconMinSize(r10.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        if (r10.hasValue(R.styleable.TextInputLayout_endIconScaleType) == false) goto L29;
        setEndIconScaleType(IconHelper.convertScaleType(r10.getInt(R.styleable.TextInputLayout_endIconScaleType, -1)));
        return;
    L29:
        return;
    L17:
        if (r10.hasValue(R.styleable.TextInputLayout_passwordToggleEnabled) == false) goto L25;
        if (r10.hasValue(R.styleable.TextInputLayout_passwordToggleTint) == false) goto L22;
        this.endIconTintList = MaterialResources.getColorStateList(getContext(), r10, R.styleable.TextInputLayout_passwordToggleTint);
    L22:
        if (r10.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode) == false) goto L24;
        this.endIconTintMode = ViewUtils.parseTintMode(r10.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
    L24:
        setEndIconMode(r10.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
        setEndIconContentDescription(r10.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        goto L25
    }

    private void initErrorIconView(TintTypedArray r5) {
        if (r5.hasValue(R.styleable.TextInputLayout_errorIconTint) == false) goto L6;
        this.errorIconTintList = MaterialResources.getColorStateList(getContext(), r5, R.styleable.TextInputLayout_errorIconTint);
    L6:
        if (r5.hasValue(R.styleable.TextInputLayout_errorIconTintMode) == false) goto L9;
        this.errorIconTintMode = ViewUtils.parseTintMode(r5.getInt(R.styleable.TextInputLayout_errorIconTintMode, -1), null);
    L9:
        if (r5.hasValue(R.styleable.TextInputLayout_errorIconDrawable) == false) goto L11;
        setErrorIconDrawable(r5.getDrawable(R.styleable.TextInputLayout_errorIconDrawable));
    L11:
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
    }

    private void initSuffixTextView(TintTypedArray r5) {
        this.suffixTextView.setVisibility(8);
        this.suffixTextView.setId(R.id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        setSuffixTextAppearance(r5.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        if (r5.hasValue(R.styleable.TextInputLayout_suffixTextColor) == false) goto L5;
        setSuffixTextColor(r5.getColorStateList(R.styleable.TextInputLayout_suffixTextColor));
    L5:
        setSuffixText(r5.getText(R.styleable.TextInputLayout_suffixText));
    }

    private void removeTouchExplorationStateChangeListenerIfNeeded() {
        AccessibilityManagerCompat.TouchExplorationStateChangeListener r5 = this.touchExplorationStateChangeListener;
        if (r5 == null) goto L8;
        AccessibilityManager r10 = this.accessibilityManager;
        if (r10 == null) goto L9;
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(r10, r5);
        return;
    L9:
        return;
    }

    private void setOnFocusChangeListenersIfNeeded(EndIconDelegate r5) {
        if (this.editText != null) goto L6;
        return;
    L6:
        if (r5.getOnEditTextFocusChangeListener() == null) goto L9;
        this.editText.setOnFocusChangeListener(r5.getOnEditTextFocusChangeListener());
    L9:
        if (r5.getOnIconViewFocusChangeListener() == null) goto L12;
        this.endIconView.setOnFocusChangeListener(r5.getOnIconViewFocusChangeListener());
        return;
    }

    private void setUpDelegate(@NonNull EndIconDelegate r5) {
        r5.setUp();
        this.touchExplorationStateChangeListener = r5.getTouchExplorationStateChangeListener();
        addTouchExplorationStateChangeListenerIfNeeded();
    }

    private void tearDownDelegate(@NonNull EndIconDelegate r5) {
        removeTouchExplorationStateChangeListenerIfNeeded();
        this.touchExplorationStateChangeListener = null;
        r5.tearDown();
    }

    private void tintEndIconOnError(boolean r5) {
        if (r5 == true) goto L4;
    L6:
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        return;
    L4:
        if (getEndIconDrawable() == null) goto L6;
        Drawable r10 = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(r10, this.textInputLayout.getErrorCurrentTextColors());
        this.endIconView.setImageDrawable(r10);
    }

    private void updateEndLayoutVisibility() {
        FrameLayout r5 = this.endIconFrame;
        int r10 = 8;
        if (this.endIconView.getVisibility() == 0) goto L5;
    L7:
        int r11 = 8;
    L8:
        r5.setVisibility(r11);
        if (this.suffixText != null) goto L11;
    L13:
        char r12 = '\b';
    L15:
        if (isEndIconVisible() == false) goto L17;
    L19:
        r10 = 0;
    L20:
        setVisibility(r10);
        return;
    L17:
        if (isErrorIconVisible() == true) goto L19;
        if (r12 != 0) goto L20;
    L11:
        if (this.hintExpanded == true) goto L13;
        r12 = 0;
        goto L15
    L5:
        if (isErrorIconVisible() == true) goto L7;
        r11 = 0;
        goto L8
    }

    private void updateErrorIconVisibility() {
        int r5 = 0;
        if (getErrorIconDrawable() != null) goto L5;
    L9:
        boolean r10 = false;
    L10:
        CheckableImageButton r11 = this.errorIconView;
        if (r10 == true) goto L14;
        r5 = 8;
    L14:
        r11.setVisibility(r5);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (hasEndIcon() == true) goto L18;
        this.textInputLayout.updateDummyDrawables();
        return;
    L18:
        return;
    L5:
        if (this.textInputLayout.isErrorEnabled() == false) goto L9;
        if (this.textInputLayout.shouldShowError() == false) goto L9;
        r10 = true;
        goto L10
    }

    private void updateSuffixTextVisibility() {
        int r5 = this.suffixTextView.getVisibility();
        boolean r10 = false;
        if (this.suffixText != null) goto L5;
    L7:
        int r11 = 8;
    L8:
        if (r5 == r11) goto L13;
        EndIconDelegate r12 = getEndIconDelegate();
        if (r11 != 0) goto L12;
        r10 = true;
    L12:
        r12.onSuffixVisibilityChanged(r10);
    L13:
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(r11);
        this.textInputLayout.updateDummyDrawables();
        return;
    L5:
        if (this.hintExpanded == true) goto L7;
        r11 = 0;
        goto L8
    }

    public void addOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener r5) {
        this.endIconChangedListeners.add(r5);
    }

    public void checkEndIcon() {
        this.endIconView.performClick();
        this.endIconView.jumpDrawablesToCurrentState();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @Nullable
    public CheckableImageButton getCurrentEndIconView() {
        if (isErrorIconVisible() == false) goto L7;
        return this.errorIconView;
    L7:
        if (hasEndIcon() == true) goto L9;
        return null;
    L9:
        if (isEndIconVisible() == true) goto L11;
        return null;
    L11:
        return this.endIconView;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public EndIconDelegate getEndIconDelegate() {
        return this.endIconDelegates.get(this.endIconMode);
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.endIconMinSize;
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.endIconScaleType;
    }

    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public int getSuffixTextEndOffset() {
        if (isEndIconVisible() == false) goto L5;
    L8:
        int r5 = this.endIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams());
    L9:
        int r10 = ViewCompat.getPaddingEnd(this);
        return (ViewCompat.getPaddingEnd(this.suffixTextView) + r10) + r5;
    L5:
        if (isErrorIconVisible() == true) goto L8;
        r5 = 0;
        goto L9
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    public boolean hasEndIcon() {
        if (this.endIconMode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconChecked() {
        if (hasEndIcon() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.isChecked() == false) goto L7;
        return true;
    }

    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.endIconView.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void onHintStateChanged(boolean r5) {
        this.hintExpanded = r5;
        updateSuffixTextVisibility();
    }

    public void onTextInputBoxStateUpdated() {
        updateErrorIconVisibility();
        refreshErrorIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError() == false) goto L6;
        tintEndIconOnError(this.textInputLayout.shouldShowError());
        return;
    }

    public void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.errorIconView, this.errorIconTintList);
    }

    public void refreshIconState(boolean r5) {
        EndIconDelegate r10 = getEndIconDelegate();
        boolean r11 = true;
        if (r10.isIconCheckable() == false) goto L7;
        boolean r12 = this.endIconView.isChecked();
        if (r12 == r10.isIconChecked()) goto L7;
        this.endIconView.setChecked(!r12);
        boolean r13 = true;
    L9:
        if (r10.isIconActivable() == false) goto L13;
        boolean r14 = this.endIconView.isActivated();
        if (r14 == r10.isIconActivated()) goto L13;
        setEndIconActivated(!r14);
    L14:
        if (r5 == true) goto L16;
        if (r11 == true) goto L16;
        return;
    L16:
        refreshEndIconDrawableState();
        return;
    L13:
        r11 = r13;
    L7:
        r13 = false;
        goto L9
    }

    public void removeOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener r5) {
        this.endIconChangedListeners.remove(r5);
    }

    public void setEndIconActivated(boolean r5) {
        this.endIconView.setActivated(r5);
    }

    public void setEndIconCheckable(boolean r5) {
        this.endIconView.setCheckable(r5);
    }

    public void setEndIconContentDescription(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getResources().getText(r5);
    L5:
        setEndIconContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setEndIconDrawable(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setEndIconDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setEndIconMinSize(@Px int r5) {
        if (r5 < 0) goto L8;
        if (r5 == this.endIconMinSize) goto L9;
        this.endIconMinSize = r5;
        IconHelper.setIconMinSize(this.endIconView, r5);
        IconHelper.setIconMinSize(this.errorIconView, r5);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public void setEndIconMode(int r5) {
        if (this.endIconMode != r5) goto L5;
        return;
    L5:
        tearDownDelegate(getEndIconDelegate());
        int r10 = this.endIconMode;
        this.endIconMode = r5;
        dispatchOnEndIconChanged(r10);
        if (r5 == 0) goto L8;
        boolean r11 = true;
    L9:
        setEndIconVisible(r11);
        EndIconDelegate r12 = getEndIconDelegate();
        setEndIconDrawable(getIconResId(r12));
        setEndIconContentDescription(r12.getIconContentDescriptionResId());
        setEndIconCheckable(r12.isIconCheckable());
        if (r12.isBoxBackgroundModeSupported(this.textInputLayout.getBoxBackgroundMode()) == false) goto L17;
        setUpDelegate(r12);
        setEndIconOnClickListener(r12.getOnIconClickListener());
        EditText r13 = this.editText;
        if (r13 == null) goto L14;
        r12.onEditTextAttached(r13);
        setOnFocusChangeListenersIfNeeded(r12);
    L14:
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshIconState(true);
        return;
    L17:
        throw new IllegalStateException("The current box background mode " + this.textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + r5);
    L8:
        r11 = false;
        goto L9
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener r5) {
        IconHelper.setIconOnClickListener(this.endIconView, r5, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.endIconOnLongClickListener = r5;
        IconHelper.setIconOnLongClickListener(this.endIconView, r5);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType r5) {
        this.endIconScaleType = r5;
        IconHelper.setIconScaleType(this.endIconView, r5);
        IconHelper.setIconScaleType(this.errorIconView, r5);
    }

    public void setEndIconTintList(@Nullable ColorStateList r5) {
        if (this.endIconTintList == r5) goto L6;
        this.endIconTintList = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, r5, this.endIconTintMode);
        return;
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.endIconTintMode == r5) goto L6;
        this.endIconTintMode = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, r5);
        return;
    }

    public void setEndIconVisible(boolean r5) {
        if (isEndIconVisible() == r5) goto L10;
        CheckableImageButton r10 = this.endIconView;
        if (r5 == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        this.textInputLayout.updateDummyDrawables();
        return;
    L7:
        r11 = 8;
        goto L8
    }

    public void setErrorIconDrawable(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setErrorIconDrawable(r10);
        refreshErrorIconDrawableState();
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener r5) {
        IconHelper.setIconOnClickListener(this.errorIconView, r5, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.errorIconOnLongClickListener = r5;
        IconHelper.setIconOnLongClickListener(this.errorIconView, r5);
    }

    public void setErrorIconTintList(@Nullable ColorStateList r5) {
        if (this.errorIconTintList == r5) goto L6;
        this.errorIconTintList = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, r5, this.errorIconTintMode);
        return;
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.errorIconTintMode == r5) goto L6;
        this.errorIconTintMode = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, r5);
        return;
    }

    public void setPasswordVisibilityToggleContentDescription(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getResources().getText(r5);
    L5:
        setPasswordVisibilityToggleContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setPasswordVisibilityToggleDrawable(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setPasswordVisibilityToggleDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setPasswordVisibilityToggleEnabled(boolean r5) {
        if (r5 == true) goto L4;
    L6:
        if (r5 == true) goto L10;
        setEndIconMode(0);
        return;
    L10:
        return;
    L4:
        if (this.endIconMode == 1) goto L6;
        setEndIconMode(1);
    }

    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList r5) {
        this.endIconTintList = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, r5, this.endIconTintMode);
    }

    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode r5) {
        this.endIconTintMode = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, r5);
    }

    public void setSuffixText(@Nullable CharSequence r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        CharSequence r10 = null;
    L6:
        this.suffixText = r10;
        this.suffixTextView.setText(r5);
        updateSuffixTextVisibility();
        return;
    L5:
        r10 = r5;
        goto L6
    }

    public void setSuffixTextAppearance(@StyleRes int r5) {
        TextViewCompat.setTextAppearance(this.suffixTextView, r5);
    }

    public void setSuffixTextColor(@NonNull ColorStateList r5) {
        this.suffixTextView.setTextColor(r5);
    }

    public void togglePasswordVisibilityToggle(boolean r5) {
        if (this.endIconMode != 1) goto L8;
        this.endIconView.performClick();
        if (r5 == false) goto L9;
        this.endIconView.jumpDrawablesToCurrentState();
        return;
    L9:
        return;
    }

    public void updateSuffixTextViewPadding() {
        if (this.textInputLayout.editText != null) goto L6;
        return;
    L6:
        if (isEndIconVisible() == false) goto L8;
    L11:
        int r5 = 0;
    L12:
        ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.textInputLayout.editText.getPaddingTop(), r5, this.textInputLayout.editText.getPaddingBottom());
        return;
    L8:
        if (isErrorIconVisible() == true) goto L11;
        r5 = ViewCompat.getPaddingEnd(this.textInputLayout.editText);
        goto L12
    }

    public void setEndIconContentDescription(@Nullable CharSequence r5) {
        if (getEndIconContentDescription() == r5) goto L6;
        this.endIconView.setContentDescription(r5);
        return;
    }

    public void setEndIconDrawable(@Nullable Drawable r5) {
        this.endIconView.setImageDrawable(r5);
        if (r5 == null) goto L6;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshEndIconDrawableState();
        return;
    }

    public void setErrorIconDrawable(@Nullable Drawable r5) {
        this.errorIconView.setImageDrawable(r5);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence r5) {
        this.endIconView.setContentDescription(r5);
    }

    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable r5) {
        this.endIconView.setImageDrawable(r5);
    }
}
