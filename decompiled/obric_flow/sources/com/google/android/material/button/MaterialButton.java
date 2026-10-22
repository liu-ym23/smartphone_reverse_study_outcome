package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";

    @Nullable
    private String accessibilityClassName;
    private boolean broadcasting;
    private boolean checked;

    @Nullable
    private Drawable icon;
    private int iconGravity;

    @Px
    private int iconLeft;

    @Px
    private int iconPadding;

    @Px
    private int iconSize;

    @Nullable
    private ColorStateList iconTint;

    @Nullable
    private PorterDuff.Mode iconTintMode;

    @Px
    private int iconTop;

    @NonNull
    private final MaterialButtonHelper materialButtonHelper;

    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;

    @Nullable
    private OnPressedChangeListener onPressedChangeListenerInternal;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<MaterialButton> {
        private int mIconPaddingId;
        private boolean mPropertiesMapped;

        public InspectionCompanion() {
            this.mPropertiesMapped = false;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(@NonNull PropertyMapper r5) {
            this.mIconPaddingId = r5.mapInt("iconPadding", R.attr.iconPadding);
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public /* bridge */ /* synthetic */ void readProperties(@NonNull MaterialButton r5, @NonNull PropertyReader r10) {
            readProperties2(r5, r10);
        }

        /* JADX INFO: renamed from: readProperties, reason: avoid collision after fix types in other method */
        public void readProperties2(@NonNull MaterialButton r5, @NonNull PropertyReader r10) {
            if (this.mPropertiesMapped == false) goto L7;
            r10.readInt(this.mIconPaddingId, r5.getIconPadding());
            return;
        L7:
            throw new android.view.inspector.InspectionCompanion.UninitializedPropertyMapException();
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton r5, boolean r10);
    }

    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton r5, boolean r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        private void readFromParcel(@NonNull Parcel r5) {
            boolean r10 = true;
            if (r5.readInt() == 1) goto L6;
            r10 = false;
        L6:
            this.checked = r10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r10 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r5);
        }
    }

    static {
        CHECKABLE_STATE_SET = new int[]{android.R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{android.R.attr.state_checked};
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Button;
    }

    public MaterialButton(@NonNull Context r5) {
        this(r5, null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int r5 = getTextAlignment();
        if (r5 == 1) goto L17;
        if (r5 == 6) goto L15;
        if (r5 == 3) goto L15;
        if (r5 == 4) goto L13;
        return Layout.Alignment.ALIGN_NORMAL;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int r5 = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r5 == 1) goto L13;
        if (r5 == 5) goto L11;
        if (r5 == 8388613) goto L11;
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) goto L5;
        TextPaint r5 = getPaint();
        String r10 = getText().toString();
        if (getTransformationMethod() == null) goto L9;
        r10 = getTransformationMethod().getTransformation(r10, this).toString();
    L9:
        Rect r11 = new Rect();
        r5.getTextBounds(r10, 0, r10.length(), r11);
        return Math.min(r11.height(), getLayout().getHeight());
    L5:
        return getLayout().getHeight();
    }

    private int getTextLayoutWidth() {
        int r5 = getLineCount();
        float r10 = 0.0f;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L6;
        r10 = Math.max(r10, getLayout().getLineWidth(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return (int) Math.ceil(r10);
    }

    private boolean isIconEnd() {
        int r5 = this.iconGravity;
        if (r5 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 4) goto L8;
        return false;
    }

    private boolean isIconStart() {
        int r5 = this.iconGravity;
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isIconTop() {
        int r5 = this.iconGravity;
        if (r5 != 16) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 32) goto L8;
        return false;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper r5 = this.materialButtonHelper;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isBackgroundOverwritten() == true) goto L7;
        return true;
    }

    private void resetIconDrawable() {
        if (isIconStart() == false) goto L6;
        TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
        return;
    L6:
        if (isIconEnd() == false) goto L9;
        TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
        return;
    L9:
        if (isIconTop() == false) goto L14;
        TextViewCompat.setCompoundDrawablesRelative(this, null, this.icon, null, null);
        return;
    }

    private void updateIcon(boolean r10) {
        Drawable r5 = this.icon;
        if (r5 == null) goto L16;
        Drawable r11 = DrawableCompat.wrap(r5).mutate();
        this.icon = r11;
        DrawableCompat.setTintList(r11, this.iconTint);
        PorterDuff.Mode r12 = this.iconTintMode;
        if (r12 == null) goto L7;
        DrawableCompat.setTintMode(this.icon, r12);
    L7:
        int r13 = this.iconSize;
        if (r13 != 0) goto L11;
        r13 = this.icon.getIntrinsicWidth();
    L11:
        int r14 = this.iconSize;
        if (r14 != 0) goto L15;
        r14 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r15 = this.icon;
        int r16 = this.iconLeft;
        int r17 = this.iconTop;
        r15.setBounds(r16, r17, r13 + r16, r14 + r17);
        this.icon.setVisible(true, r10);
    L16:
        if (r10 == false) goto L19;
        resetIconDrawable();
        return;
    L19:
        Drawable[] r18 = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable r19 = r18[0];
        Drawable r20 = r18[1];
        Drawable r21 = r18[2];
        if (isIconStart() == false) goto L24;
        if (r19 == this.icon) goto L24;
    L31:
        resetIconDrawable();
        return;
    L24:
        if (isIconEnd() == false) goto L28;
        if (r21 != this.icon) goto L31;
    L28:
        if (isIconTop() == true) goto L30;
        return;
    L30:
        if (r20 != this.icon) goto L31;
    }

    private void updateIconPosition(int r10, int r11) {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() != null) goto L8;
        return;
    L8:
        if (isIconStart() == false) goto L10;
    L24:
        this.iconTop = 0;
        Layout.Alignment r12 = getActualTextAlignment();
        int r5 = this.iconGravity;
        boolean r13 = true;
        if (r5 != 1) goto L27;
    L52:
        this.iconLeft = 0;
        updateIcon(false);
        return;
    L27:
        if (r5 == 3) goto L52;
        if (r5 != 2) goto L32;
        if (r12 == Layout.Alignment.ALIGN_NORMAL) goto L52;
    L32:
        if (r5 == 4) goto L34;
    L36:
        int r14 = this.iconSize;
        if (r14 != 0) goto L39;
        r14 = this.icon.getIntrinsicWidth();
    L39:
        int r15 = ((((r10 - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - r14) - this.iconPadding) - ViewCompat.getPaddingStart(this);
        if (r12 != Layout.Alignment.ALIGN_CENTER) goto L42;
        r15 = r15 / 2;
    L42:
        boolean r16 = isLayoutRTL();
        if (this.iconGravity == 4) goto L46;
        r13 = false;
    L46:
        if (r16 == r13) goto L49;
        r15 = -r15;
    L49:
        if (this.iconLeft == r15) goto L57;
        this.iconLeft = r15;
        updateIcon(false);
        return;
    L57:
        return;
    L34:
        if (r12 != Layout.Alignment.ALIGN_OPPOSITE) goto L36;
    L10:
        if (isIconEnd() == true) goto L24;
        if (isIconTop() == false) goto L54;
        this.iconLeft = 0;
        if (this.iconGravity != 16) goto L18;
        this.iconTop = 0;
        updateIcon(false);
        return;
    L18:
        int r17 = this.iconSize;
        if (r17 != 0) goto L21;
        r17 = this.icon.getIntrinsicHeight();
    L21:
        int r18 = Math.max(0, (((((r11 - getTextHeight()) - getPaddingTop()) - r17) - this.iconPadding) - getPaddingBottom()) / 2);
        if (this.iconTop == r18) goto L55;
        this.iconTop = r18;
        updateIcon(false);
        return;
    L55:
        return;
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener r5) {
        this.onCheckedChangeListeners.add(r5);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @NonNull
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName) == true) goto L7;
        return this.accessibilityClassName;
    L7:
        if (isCheckable() == false) goto L9;
        Class r5 = CompoundButton.class;
    L11:
        return r5.getName();
    L9:
        r5 = Button.class;
        goto L11
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getCornerRadius();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getShapeAppearanceModel();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.getStrokeColor();
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.getStrokeWidth();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintList();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        MaterialButtonHelper r5 = this.materialButtonHelper;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isCheckable() == false) goto L7;
        return true;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 2);
        if (isCheckable() == false) goto L6;
        View.mergeDrawableStates(r10, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r10, CHECKED_STATE_SET);
    L8:
        return r10;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(getA11yClassName());
        r5.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(getA11yClassName());
        r5.setCheckable(isCheckable());
        r5.setChecked(isChecked());
        r5.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setChecked(r10.checked);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.checked = this.checked;
        return r5;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        super.onTextChanged(r5, r10, r11, r12);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.materialButtonHelper.isToggleCheckedStateOnClick() == false) goto L6;
        toggle();
    L6:
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon == null) goto L8;
        int[] r5 = getDrawableState();
        if (this.icon.setState(r5) == false) goto L9;
        invalidate();
        return;
    L9:
        return;
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener r5) {
        this.onCheckedChangeListeners.remove(r5);
    }

    public void setA11yClassName(@Nullable String r5) {
        this.accessibilityClassName = r5;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable r5) {
        setBackgroundDrawable(r5);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r5) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setBackgroundColor(r5);
        return;
    L5:
        super.setBackgroundColor(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable r5) {
        if (isUsingOriginalBackground() == true) goto L5;
        super.setBackgroundDrawable(r5);
        return;
    L5:
        if (r5 == getBackground()) goto L7;
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(r5);
        return;
    L7:
        getBackground().setState(r5.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setBackgroundDrawable(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r5) {
        setSupportBackgroundTintList(r5);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        setSupportBackgroundTintMode(r5);
    }

    public void setCheckable(boolean r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCheckable(r5);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.checked == r5) goto L23;
        this.checked = r5;
        refreshDrawableState();
        if ((getParent() instanceof MaterialButtonToggleGroup) == false) goto L12;
        ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
    L12:
        if (this.broadcasting == false) goto L14;
        return;
    L14:
        this.broadcasting = true;
        Iterator<OnCheckedChangeListener> r10 = this.onCheckedChangeListeners.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        r10.next().onCheckedChanged(this, this.checked);
        goto L16
    L18:
        this.broadcasting = false;
        return;
    }

    public void setCornerRadius(@Px int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setCornerRadius(r5);
        return;
    }

    public void setCornerRadiusResource(@DimenRes int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r5));
        return;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.getMaterialShapeDrawable().setElevation(r5);
        return;
    }

    public void setIcon(@Nullable Drawable r5) {
        if (this.icon == r5) goto L6;
        this.icon = r5;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconGravity(int r5) {
        if (this.iconGravity == r5) goto L6;
        this.iconGravity = r5;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconPadding(@Px int r5) {
        if (this.iconPadding == r5) goto L6;
        this.iconPadding = r5;
        setCompoundDrawablePadding(r5);
        return;
    }

    public void setIconResource(@DrawableRes int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setIcon(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setIconSize(@Px int r5) {
        if (r5 < 0) goto L8;
        if (this.iconSize == r5) goto L9;
        this.iconSize = r5;
        updateIcon(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList r5) {
        if (this.iconTint == r5) goto L6;
        this.iconTint = r5;
        updateIcon(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r5) {
        if (this.iconTintMode == r5) goto L6;
        this.iconTintMode = r5;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(@ColorRes int r5) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r5));
    }

    public void setInsetBottom(@Dimension int r5) {
        this.materialButtonHelper.setInsetBottom(r5);
    }

    public void setInsetTop(@Dimension int r5) {
        this.materialButtonHelper.setInsetTop(r5);
    }

    public void setInternalBackground(Drawable r5) {
        super.setBackgroundDrawable(r5);
    }

    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener r5) {
        this.onPressedChangeListenerInternal = r5;
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        OnPressedChangeListener r10 = this.onPressedChangeListenerInternal;
        if (r10 == null) goto L5;
        r10.onPressedChanged(this, r5);
    L5:
        super.setPressed(r5);
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setRippleColor(r5);
        return;
    }

    public void setRippleColorResource(@ColorRes int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList(getContext(), r5));
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.setShapeAppearanceModel(r5);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setShouldDrawSurfaceColorStroke(r5);
        return;
    }

    public void setStrokeColor(@Nullable ColorStateList r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeColor(r5);
        return;
    }

    public void setStrokeColorResource(@ColorRes int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r5));
        return;
    }

    public void setStrokeWidth(@Px int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.setStrokeWidth(r5);
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r5) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r5));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r5) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintList(r5);
        return;
    L5:
        super.setSupportBackgroundTintList(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.setSupportBackgroundTintMode(r5);
        return;
    L5:
        super.setSupportBackgroundTintMode(r5);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int r5) {
        super.setTextAlignment(r5);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean r5) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(r5);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public MaterialButton(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean r14 = false;
        this.checked = false;
        this.broadcasting = false;
        Context r15 = getContext();
        TypedArray r5 = ThemeEnforcement.obtainStyledAttributes(r15, r11, R.styleable.MaterialButton, r12, r13, new int[0]);
        this.iconPadding = r5.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(r5.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), r5, R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), r5, R.styleable.MaterialButton_icon);
        this.iconGravity = r5.getInteger(R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = r5.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper r16 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(r15, r11, r12, r13).build());
        this.materialButtonHelper = r16;
        r16.loadFromAttributes(r5);
        r5.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        if (this.icon == null) goto L5;
        r14 = true;
    L5:
        updateIcon(r14);
    }
}
