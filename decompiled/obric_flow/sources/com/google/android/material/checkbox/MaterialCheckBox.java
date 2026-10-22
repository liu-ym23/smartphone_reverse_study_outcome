package com.google.android.material.checkbox;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[][] CHECKBOX_STATES = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] ERROR_STATE_SET = null;

    @SuppressLint({"DiscouragedApi"})
    private static final int FRAMEWORK_BUTTON_DRAWABLE_RES_ID = 0;
    private static final int[] INDETERMINATE_STATE_SET = null;
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;
    private boolean broadcasting;

    @Nullable
    private Drawable buttonDrawable;

    @Nullable
    private Drawable buttonIconDrawable;

    @Nullable
    ColorStateList buttonIconTintList;

    @NonNull
    private PorterDuff.Mode buttonIconTintMode;

    @Nullable
    ColorStateList buttonTintList;
    private boolean centerIfNoTextEnabled;
    private int checkedState;
    private int[] currentStateChecked;

    @Nullable
    private CharSequence customStateDescription;

    @Nullable
    private CharSequence errorAccessibilityLabel;
    private boolean errorShown;

    @Nullable
    private ColorStateList materialThemeColorsTintList;

    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    @NonNull
    private final LinkedHashSet<OnCheckedStateChangedListener> onCheckedStateChangedListeners;

    @NonNull
    private final LinkedHashSet<OnErrorChangedListener> onErrorChangedListeners;

    @Nullable
    private final AnimatedVectorDrawableCompat transitionToUnchecked;
    private final Animatable2Compat.AnimationCallback transitionToUncheckedCallback;
    private boolean useMaterialThemeColors;
    private boolean usingMaterialButtonDrawable;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(@NonNull MaterialCheckBox r5, int r10);
    }

    public interface OnErrorChangedListener {
        void onErrorChanged(@NonNull MaterialCheckBox r5, boolean r10);
    }

    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int checkedState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public /* synthetic */ SavedState(Parcel r5, AnonymousClass1 r10) {
            this(r5);
        }

        @NonNull
        private String getCheckedStateString() {
            int r5 = this.checkedState;
            if (r5 != 1) goto L5;
            return "checked";
        L5:
            if (r5 == 2) goto L8;
            return "unchecked";
        L8:
            return "indeterminate";
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("MaterialCheckBox.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" CheckedState=");
            return j0.q(r5, getCheckedStateString(), "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeValue(Integer.valueOf(this.checkedState));
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        private SavedState(Parcel r5) {
            super(r5);
            this.checkedState = ((Integer) r5.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
        INDETERMINATE_STATE_SET = new int[]{R.attr.state_indeterminate};
        int r5 = R.attr.state_error;
        ERROR_STATE_SET = new int[]{r5};
        CHECKBOX_STATES = new int[][]{new int[]{android.R.attr.state_enabled, r5}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        FRAMEWORK_BUTTON_DRAWABLE_RES_ID = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ int[] access$000(MaterialCheckBox r5) {
        return r5.currentStateChecked;
    }

    @NonNull
    private String getButtonStateDescription() {
        int r5 = this.checkedState;
        if (r5 == 1) goto L5;
        if (r5 != 0) goto L10;
        return getResources().getString(R.string.mtrl_checkbox_state_description_unchecked);
    L10:
        return getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    L5:
        return getResources().getString(R.string.mtrl_checkbox_state_description_checked);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int[][] r5 = CHECKBOX_STATES;
        int[] r10 = new int[r5.length];
        int r11 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r12 = MaterialColors.getColor(this, R.attr.colorError);
        int r13 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r14 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        r10[0] = MaterialColors.layer(r13, r12, 1.0f);
        r10[1] = MaterialColors.layer(r13, r11, 1.0f);
        r10[2] = MaterialColors.layer(r13, r14, 0.54f);
        r10[3] = MaterialColors.layer(r13, r14, 0.38f);
        r10[4] = MaterialColors.layer(r13, r14, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r5, r10);
    L6:
        return this.materialThemeColorsTintList;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList r5 = this.buttonTintList;
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (super.getButtonTintList() == null) goto L10;
        return super.getButtonTintList();
    L10:
        return getSupportButtonTintList();
    }

    private boolean isButtonDrawableLegacy(TintTypedArray r5) {
        int r10 = r5.getResourceId(R.styleable.MaterialCheckBox_android_button, 0);
        int r11 = r5.getResourceId(R.styleable.MaterialCheckBox_buttonCompat, 0);
        if (r10 != FRAMEWORK_BUTTON_DRAWABLE_RES_ID) goto L7;
        if (r11 != 0) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    private /* synthetic */ void lambda$new$0() {
        this.buttonIconDrawable.jumpToCurrentState();
    }

    private void refreshButtonDrawable() {
        this.buttonDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonDrawable, this.buttonTintList, CompoundButtonCompat.getButtonTintMode(this));
        this.buttonIconDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonIconDrawable, this.buttonIconTintList, this.buttonIconTintMode);
        setUpDefaultButtonDrawableAnimationIfNeeded();
        updateButtonTints();
        super.setButtonDrawable(DrawableUtils.compositeTwoLayeredDrawable(this.buttonDrawable, this.buttonIconDrawable));
        refreshDrawableState();
    }

    private void setDefaultStateDescription() {
        if (this.customStateDescription != null) goto L6;
        super.setStateDescription(getButtonStateDescription());
        return;
    }

    private void setUpDefaultButtonDrawableAnimationIfNeeded() {
        if (this.usingMaterialButtonDrawable == true) goto L5;
        return;
    L5:
        AnimatedVectorDrawableCompat r5 = this.transitionToUnchecked;
        if (r5 == null) goto L8;
        r5.unregisterAnimationCallback(this.transitionToUncheckedCallback);
        this.transitionToUnchecked.registerAnimationCallback(this.transitionToUncheckedCallback);
    L8:
        Drawable r10 = this.buttonDrawable;
        if ((r10 instanceof AnimatedStateListDrawable) == false) goto L14;
        AnimatedVectorDrawableCompat r11 = this.transitionToUnchecked;
        if (r11 == null) goto L15;
        ((AnimatedStateListDrawable) r10).addTransition(R.id.checked, R.id.unchecked, r11, false);
        ((AnimatedStateListDrawable) this.buttonDrawable).addTransition(R.id.indeterminate, R.id.unchecked, this.transitionToUnchecked, false);
        return;
    L15:
        return;
    }

    private void updateButtonTints() {
        Drawable r5 = this.buttonDrawable;
        if (r5 == null) goto L7;
        ColorStateList r10 = this.buttonTintList;
        if (r10 == null) goto L7;
        DrawableCompat.setTintList(r5, r10);
    L7:
        Drawable r11 = this.buttonIconDrawable;
        if (r11 == null) goto L13;
        ColorStateList r12 = this.buttonIconTintList;
        if (r12 == null) goto L14;
        DrawableCompat.setTintList(r11, r12);
        return;
    L14:
        return;
    }

    private void updateIconTintIfNeeded() {
    }

    public void addOnCheckedStateChangedListener(@NonNull OnCheckedStateChangedListener r5) {
        this.onCheckedStateChangedListeners.add(r5);
    }

    public void addOnErrorChangedListener(@NonNull OnErrorChangedListener r5) {
        this.onErrorChangedListeners.add(r5);
    }

    public void clearOnCheckedStateChangedListeners() {
        this.onCheckedStateChangedListeners.clear();
    }

    public void clearOnErrorChangedListeners() {
        this.onErrorChangedListeners.clear();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.buttonDrawable;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.buttonIconDrawable;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.buttonIconTintList;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.buttonIconTintMode;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.buttonTintList;
    }

    public int getCheckedState() {
        return this.checkedState;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.errorAccessibilityLabel;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.centerIfNoTextEnabled;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        if (this.checkedState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isErrorShown() {
        return this.errorShown;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (this.buttonTintList == null) goto L7;
        return;
    L7:
        if (this.buttonIconTintList != null) goto L12;
        setUseMaterialThemeColors(true);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 2);
        if (getCheckedState() != 2) goto L6;
        View.mergeDrawableStates(r10, INDETERMINATE_STATE_SET);
    L6:
        if (isErrorShown() == false) goto L8;
        View.mergeDrawableStates(r10, ERROR_STATE_SET);
    L8:
        this.currentStateChecked = DrawableUtils.getCheckedState(r10);
        updateIconTintIfNeeded();
        return r10;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        if (this.centerIfNoTextEnabled == true) goto L5;
    L16:
        super.onDraw(r10);
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == false) goto L16;
        Drawable r5 = CompoundButtonCompat.getButtonDrawable(this);
        if (r5 == null) goto L16;
        if (ViewUtils.isLayoutRtl(this) == false) goto L11;
        int r11 = -1;
    L12:
        int r12 = ((getWidth() - r5.getIntrinsicWidth()) / 2) * r11;
        int r13 = r10.save();
        r10.translate(r12, 0.0f);
        super.onDraw(r10);
        r10.restoreToCount(r13);
        if (getBackground() == null) goto L18;
        Rect r14 = r5.getBounds();
        DrawableCompat.setHotspotBounds(getBackground(), r14.left + r12, r14.top, r14.right + r12, r14.bottom);
        return;
    L18:
        return;
    L11:
        r11 = 1;
        goto L12
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        if (r5 != null) goto L6;
        return;
    L6:
        if (isErrorShown() == false) goto L9;
        r5.setText(r5.getText() + ", " + this.errorAccessibilityLabel);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setCheckedState(r10.checkedState);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.checkedState = getCheckedState();
        return r5;
    }

    public void removeOnCheckedStateChangedListener(@NonNull OnCheckedStateChangedListener r5) {
        this.onCheckedStateChangedListeners.remove(r5);
    }

    public void removeOnErrorChangedListener(@NonNull OnErrorChangedListener r5) {
        this.onErrorChangedListeners.remove(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int r5) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setButtonIconDrawable(@Nullable Drawable r5) {
        this.buttonIconDrawable = r5;
        refreshButtonDrawable();
    }

    public void setButtonIconDrawableResource(@DrawableRes int r5) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setButtonIconTintList(@Nullable ColorStateList r5) {
        if (this.buttonIconTintList != r5) goto L5;
        return;
    L5:
        this.buttonIconTintList = r5;
        refreshButtonDrawable();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode r5) {
        if (this.buttonIconTintMode != r5) goto L5;
        return;
    L5:
        this.buttonIconTintMode = r5;
        refreshButtonDrawable();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList r5) {
        if (this.buttonTintList != r5) goto L5;
        return;
    L5:
        this.buttonTintList = r5;
        refreshButtonDrawable();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode r5) {
        setSupportButtonTintMode(r5);
        refreshButtonDrawable();
    }

    public void setCenterIfNoTextEnabled(boolean r5) {
        this.centerIfNoTextEnabled = r5;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        setCheckedState(r5 ? 1 : 0);
    }

    public void setCheckedState(int r5) {
        if (this.checkedState == r5) goto L28;
        this.checkedState = r5;
        if (r5 != 1) goto L7;
        boolean r10 = true;
    L8:
        super.setChecked(r10);
        refreshDrawableState();
        setDefaultStateDescription();
        if (this.broadcasting == false) goto L11;
        return;
    L11:
        this.broadcasting = true;
        LinkedHashSet<OnCheckedStateChangedListener> r11 = this.onCheckedStateChangedListeners;
        if (r11 == null) goto L18;
        Iterator<OnCheckedStateChangedListener> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L18;
        r12.next().onCheckedStateChangedListener(this, this.checkedState);
    L18:
        if (this.checkedState == 2) goto L22;
        CompoundButton.OnCheckedChangeListener r13 = this.onCheckedChangeListener;
        if (r13 == null) goto L22;
        r13.onCheckedChanged(this, isChecked());
    L22:
        AutofillManager r14 = (AutofillManager) getContext().getSystemService(AutofillManager.class);
        if (r14 == null) goto L25;
        r14.notifyValueChanged(this);
    L25:
        this.broadcasting = false;
        return;
    L7:
        r10 = false;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        updateIconTintIfNeeded();
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence r5) {
        this.errorAccessibilityLabel = r5;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getResources().getText(r5);
    L5:
        setErrorAccessibilityLabel(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setErrorShown(boolean r5) {
        if (this.errorShown != r5) goto L5;
        return;
    L5:
        this.errorShown = r5;
        refreshDrawableState();
        Iterator<OnErrorChangedListener> r10 = this.onErrorChangedListeners.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().onErrorChanged(this, this.errorShown);
        goto L7
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener r5) {
        this.onCheckedChangeListener = r5;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence r5) {
        this.customStateDescription = r5;
        if (r5 != null) goto L5;
        setDefaultStateDescription();
        return;
    L5:
        super.setStateDescription(r5);
    }

    public void setUseMaterialThemeColors(boolean r5) {
        this.useMaterialThemeColors = r5;
        if (r5 == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        return;
    L5:
        CompoundButtonCompat.setButtonTintList(this, null);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.checkboxStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable r5) {
        this.buttonDrawable = r5;
        this.usingMaterialButtonDrawable = false;
        refreshButtonDrawable();
    }

    public MaterialCheckBox(Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.onErrorChangedListeners = new LinkedHashSet();
        this.onCheckedStateChangedListeners = new LinkedHashSet();
        this.transitionToUnchecked = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.transitionToUncheckedCallback = new AnonymousClass1(this);
        Context r13 = getContext();
        this.buttonDrawable = CompoundButtonCompat.getButtonDrawable(this);
        this.buttonTintList = getSuperButtonTintList();
        setSupportButtonTintList(null);
        TintTypedArray r14 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r11, R.styleable.MaterialCheckBox, r12, r5, new int[0]);
        this.buttonIconDrawable = r14.getDrawable(R.styleable.MaterialCheckBox_buttonIcon);
        if (this.buttonDrawable != null) goto L5;
    L11:
        this.buttonIconTintList = MaterialResources.getColorStateList(r13, r14, R.styleable.MaterialCheckBox_buttonIconTint);
        this.buttonIconTintMode = ViewUtils.parseTintMode(r14.getInt(R.styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.useMaterialThemeColors = r14.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.centerIfNoTextEnabled = r14.getBoolean(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.errorShown = r14.getBoolean(R.styleable.MaterialCheckBox_errorShown, false);
        this.errorAccessibilityLabel = r14.getText(R.styleable.MaterialCheckBox_errorAccessibilityLabel);
        if (r14.hasValue(R.styleable.MaterialCheckBox_checkedState) == false) goto L14;
        setCheckedState(r14.getInt(R.styleable.MaterialCheckBox_checkedState, 0));
    L14:
        r14.recycle();
        refreshButtonDrawable();
        return;
    L5:
        if (ThemeEnforcement.isMaterial3Theme(r13) == false) goto L11;
        if (isButtonDrawableLegacy(r14) == false) goto L11;
        super.setButtonDrawable(null);
        this.buttonDrawable = AppCompatResources.getDrawable(r13, R.drawable.mtrl_checkbox_button);
        this.usingMaterialButtonDrawable = true;
        if (this.buttonIconDrawable != null) goto L11;
        this.buttonIconDrawable = AppCompatResources.getDrawable(r13, R.drawable.mtrl_checkbox_button_icon);
        goto L11
    }
}
