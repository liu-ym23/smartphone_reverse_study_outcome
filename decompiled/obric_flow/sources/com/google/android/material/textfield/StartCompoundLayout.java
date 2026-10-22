package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;

    @Nullable
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private int startIconMinSize;
    private View.OnLongClickListener startIconOnLongClickListener;

    @NonNull
    private ImageView.ScaleType startIconScaleType;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    public StartCompoundLayout(TextInputLayout r5, TintTypedArray r10) {
        super(r5.getContext());
        this.textInputLayout = r5;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton r11 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, this, false);
        this.startIconView = r11;
        IconHelper.setCompatRippleBackgroundIfNeeded(r11);
        AppCompatTextView r12 = new AppCompatTextView(getContext());
        this.prefixTextView = r12;
        initStartIconView(r10);
        initPrefixTextView(r10);
        addView(r11);
        addView(r12);
    }

    private void initPrefixTextView(TintTypedArray r5) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(R.id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.prefixTextView, 1);
        setPrefixTextAppearance(r5.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        if (r5.hasValue(R.styleable.TextInputLayout_prefixTextColor) == false) goto L5;
        setPrefixTextColor(r5.getColorStateList(R.styleable.TextInputLayout_prefixTextColor));
    L5:
        setPrefixText(r5.getText(R.styleable.TextInputLayout_prefixText));
    }

    private void initStartIconView(TintTypedArray r5) {
        if (MaterialResources.isFontScaleAtLeast1_3(getContext()) == false) goto L5;
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams(), 0);
    L5:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (r5.hasValue(R.styleable.TextInputLayout_startIconTint) == false) goto L9;
        this.startIconTintList = MaterialResources.getColorStateList(getContext(), r5, R.styleable.TextInputLayout_startIconTint);
    L9:
        if (r5.hasValue(R.styleable.TextInputLayout_startIconTintMode) == false) goto L12;
        this.startIconTintMode = ViewUtils.parseTintMode(r5.getInt(R.styleable.TextInputLayout_startIconTintMode, -1), null);
    L12:
        if (r5.hasValue(R.styleable.TextInputLayout_startIconDrawable) == false) goto L17;
        setStartIconDrawable(r5.getDrawable(R.styleable.TextInputLayout_startIconDrawable));
        if (r5.hasValue(R.styleable.TextInputLayout_startIconContentDescription) == false) goto L16;
        setStartIconContentDescription(r5.getText(R.styleable.TextInputLayout_startIconContentDescription));
    L16:
        setStartIconCheckable(r5.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
    L17:
        setStartIconMinSize(r5.getDimensionPixelSize(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        if (r5.hasValue(R.styleable.TextInputLayout_startIconScaleType) == false) goto L21;
        setStartIconScaleType(IconHelper.convertScaleType(r5.getInt(R.styleable.TextInputLayout_startIconScaleType, -1)));
        return;
    }

    private void updateVisibility() {
        int r5 = 8;
        if (this.prefixText != null) goto L5;
    L7:
        int r10 = 8;
    L9:
        if (this.startIconView.getVisibility() == 0) goto L11;
        if (r10 == 0) goto L11;
    L12:
        setVisibility(r5);
        this.prefixTextView.setVisibility(r10);
        this.textInputLayout.updateDummyDrawables();
        return;
    L11:
        r5 = 0;
        goto L12
    L5:
        if (this.hintExpanded == true) goto L7;
        r10 = 0;
        goto L9
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    public int getPrefixTextStartOffset() {
        if (isStartIconVisible() == false) goto L5;
        int r5 = this.startIconView.getMeasuredWidth();
        int r10 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams()) + r5;
    L6:
        int r11 = ViewCompat.getPaddingStart(this);
        return (ViewCompat.getPaddingStart(this.prefixTextView) + r11) + r10;
    L5:
        r10 = 0;
        goto L6
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.startIconMinSize;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.startIconScaleType;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void onHintStateChanged(boolean r5) {
        this.hintExpanded = r5;
        updateVisibility();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        updatePrefixTextViewPadding();
    }

    public void refreshStartIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    public void setPrefixText(@Nullable CharSequence r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        CharSequence r10 = null;
    L6:
        this.prefixText = r10;
        this.prefixTextView.setText(r5);
        updateVisibility();
        return;
    L5:
        r10 = r5;
        goto L6
    }

    public void setPrefixTextAppearance(@StyleRes int r5) {
        TextViewCompat.setTextAppearance(this.prefixTextView, r5);
    }

    public void setPrefixTextColor(@NonNull ColorStateList r5) {
        this.prefixTextView.setTextColor(r5);
    }

    public void setStartIconCheckable(boolean r5) {
        this.startIconView.setCheckable(r5);
    }

    public void setStartIconContentDescription(@Nullable CharSequence r5) {
        if (getStartIconContentDescription() == r5) goto L6;
        this.startIconView.setContentDescription(r5);
        return;
    }

    public void setStartIconDrawable(@Nullable Drawable r5) {
        this.startIconView.setImageDrawable(r5);
        if (r5 == null) goto L5;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    public void setStartIconMinSize(@Px int r5) {
        if (r5 < 0) goto L8;
        if (r5 == this.startIconMinSize) goto L9;
        this.startIconMinSize = r5;
        IconHelper.setIconMinSize(this.startIconView, r5);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener r5) {
        IconHelper.setIconOnClickListener(this.startIconView, r5, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener r5) {
        this.startIconOnLongClickListener = r5;
        IconHelper.setIconOnLongClickListener(this.startIconView, r5);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType r5) {
        this.startIconScaleType = r5;
        IconHelper.setIconScaleType(this.startIconView, r5);
    }

    public void setStartIconTintList(@Nullable ColorStateList r5) {
        if (this.startIconTintList == r5) goto L6;
        this.startIconTintList = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, r5, this.startIconTintMode);
        return;
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode r5) {
        if (this.startIconTintMode == r5) goto L6;
        this.startIconTintMode = r5;
        IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, r5);
        return;
    }

    public void setStartIconVisible(boolean r5) {
        if (isStartIconVisible() == r5) goto L10;
        CheckableImageButton r10 = this.startIconView;
        if (r5 == false) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        updatePrefixTextViewPadding();
        updateVisibility();
        return;
    L7:
        r11 = 8;
        goto L8
    }

    public void setupAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat r5) {
        if (this.prefixTextView.getVisibility() != 0) goto L5;
        r5.setLabelFor(this.prefixTextView);
        r5.setTraversalAfter(this.prefixTextView);
        return;
    L5:
        r5.setTraversalAfter(this.startIconView);
    }

    public void updatePrefixTextViewPadding() {
        EditText r5 = this.textInputLayout.editText;
        if (r5 != null) goto L6;
        return;
    L6:
        if (isStartIconVisible() == false) goto L8;
        int r10 = 0;
    L9:
        ViewCompat.setPaddingRelative(this.prefixTextView, r10, r5.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), r5.getCompoundPaddingBottom());
        return;
    L8:
        r10 = ViewCompat.getPaddingStart(r5);
        goto L9
    }
}
