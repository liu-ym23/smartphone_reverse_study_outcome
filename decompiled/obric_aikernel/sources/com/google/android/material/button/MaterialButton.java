package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
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
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.c;
import com.google.android.material.shape.h;
import com.google.android.material.shape.p;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, p {
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
    private final com.google.android.material.button.a materialButtonHelper;

    @NonNull
    private final LinkedHashSet<a> onCheckedChangeListeners;

    @Nullable
    private b onPressedChangeListenerInternal;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @NonNull
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r10);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private void readFromParcel(@NonNull Parcel r10) {
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.checked = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.checked ? 1 : 0);
        }
    }

    public interface a {
        void a(MaterialButton r10, boolean r11);
    }

    interface b {
        void a(MaterialButton r10, boolean r11);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DEF_STYLE_RES = k.Widget_MaterialComponents_Button;
    }

    public MaterialButton(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean r14 = false;
        this.checked = false;
        this.broadcasting = false;
        Context r15 = getContext();
        TypedArray r16 = com.google.android.material.internal.k.h(r15, r11, l.MaterialButton, r12, r13, new int[0]);
        this.iconPadding = r16.getDimensionPixelSize(l.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.j(r16.getInt(l.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = c.a(getContext(), r16, l.MaterialButton_iconTint);
        this.icon = c.e(getContext(), r16, l.MaterialButton_icon);
        this.iconGravity = r16.getInteger(l.MaterialButton_iconGravity, 1);
        this.iconSize = r16.getDimensionPixelSize(l.MaterialButton_iconSize, 0);
        com.google.android.material.button.a r17 = new com.google.android.material.button.a(this, com.google.android.material.shape.l.e(r15, r11, r12, r13).m());
        this.materialButtonHelper = r17;
        r17.q(r16);
        r16.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        if (this.icon == null) goto L5;
        r14 = true;
    L5:
        updateIcon(r14);
    }

    @NonNull
    private String getA11yClassName() {
        if (isCheckable() == false) goto L5;
        Class r10 = CompoundButton.class;
    L7:
        return r10.getName();
    L5:
        r10 = Button.class;
        goto L7
    }

    private Layout.Alignment getActualTextAlignment() {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        int r10 = getTextAlignment();
        if (r10 == 1) goto L21;
        if (r10 == 6) goto L19;
        if (r10 == 3) goto L19;
        if (r10 == 4) goto L17;
        return Layout.Alignment.ALIGN_NORMAL;
    L17:
        return Layout.Alignment.ALIGN_CENTER;
    L19:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L21:
        return getGravityTextAlignment();
    L5:
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int r10 = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r10 == 1) goto L13;
        if (r10 == 5) goto L11;
        if (r10 == 8388613) goto L11;
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint r10 = getPaint();
        String r11 = getText().toString();
        if (getTransformationMethod() == null) goto L5;
        r11 = getTransformationMethod().getTransformation(r11, this).toString();
    L5:
        Rect r12 = new Rect();
        r10.getTextBounds(r11, 0, r11.length(), r12);
        return Math.min(r12.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint r10 = getPaint();
        String r11 = getText().toString();
        if (getTransformationMethod() == null) goto L6;
        r11 = getTransformationMethod().getTransformation(r11, this).toString();
    L6:
        return Math.min((int) r10.measureText(r11), getLayout().getEllipsizedWidth());
    }

    private boolean isIconEnd() {
        int r10 = this.iconGravity;
        if (r10 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 4) goto L8;
        return false;
    }

    private boolean isIconStart() {
        int r10 = this.iconGravity;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isIconTop() {
        int r10 = this.iconGravity;
        if (r10 != 16) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 32) goto L8;
        return false;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isUsingOriginalBackground() {
        com.google.android.material.button.a r10 = this.materialButtonHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.o() == true) goto L7;
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
        Drawable r11 = this.icon;
        boolean r12 = true;
        if (r11 == null) goto L16;
        Drawable r13 = DrawableCompat.wrap(r11).mutate();
        this.icon = r13;
        DrawableCompat.setTintList(r13, this.iconTint);
        PorterDuff.Mode r14 = this.iconTintMode;
        if (r14 == null) goto L7;
        DrawableCompat.setTintMode(this.icon, r14);
    L7:
        int r15 = this.iconSize;
        if (r15 != 0) goto L11;
        r15 = this.icon.getIntrinsicWidth();
    L11:
        int r16 = this.iconSize;
        if (r16 != 0) goto L15;
        r16 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r17 = this.icon;
        int r18 = this.iconLeft;
        int r19 = this.iconTop;
        r17.setBounds(r18, r19, r15 + r18, r16 + r19);
        this.icon.setVisible(true, r10);
    L16:
        if (r10 == false) goto L19;
        resetIconDrawable();
        return;
    L19:
        Drawable[] r20 = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable r21 = r20[0];
        Drawable r22 = r20[1];
        Drawable r23 = r20[2];
        if (isIconStart() == false) goto L24;
        if (r21 == this.icon) goto L24;
    L33:
        if (r12 == false) goto L36;
        resetIconDrawable();
        return;
    L36:
        return;
    L24:
        if (isIconEnd() == false) goto L28;
        if (r23 != this.icon) goto L33;
    L28:
        if (isIconTop() == true) goto L30;
    L32:
        r12 = false;
        goto L33
    L30:
        if (r22 == this.icon) goto L32;
        goto L32
    }

    private void updateIconPosition(int r10, int r11) {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() != null) goto L8;
        return;
    L8:
        if (isIconStart() == false) goto L10;
    L26:
        this.iconTop = 0;
        Layout.Alignment r12 = getActualTextAlignment();
        int r13 = this.iconGravity;
        boolean r14 = true;
        if (r13 != 1) goto L29;
    L54:
        this.iconLeft = 0;
    L17:
        updateIcon(false);
        return;
    L29:
        if (r13 == 3) goto L54;
        if (r13 != 2) goto L34;
        if (r12 == Layout.Alignment.ALIGN_NORMAL) goto L54;
    L34:
        if (r13 == 4) goto L36;
    L38:
        int r15 = this.iconSize;
        if (r15 != 0) goto L41;
        r15 = this.icon.getIntrinsicWidth();
    L41:
        int r16 = ((((r10 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - r15) - this.iconPadding) - ViewCompat.getPaddingStart(this);
        if (r12 != Layout.Alignment.ALIGN_CENTER) goto L44;
        r16 = r16 / 2;
    L44:
        boolean r17 = isLayoutRTL();
        if (this.iconGravity == 4) goto L48;
        r14 = false;
    L48:
        if (r17 == r14) goto L51;
        r16 = -r16;
    L51:
        if (this.iconLeft == r16) goto L58;
        this.iconLeft = r16;
    L25:
        updateIcon(false);
        return;
    L58:
        return;
    L36:
        if (r12 != Layout.Alignment.ALIGN_OPPOSITE) goto L38;
    L10:
        if (isIconEnd() == true) goto L26;
        if (isIconTop() == false) goto L53;
        this.iconLeft = 0;
        if (this.iconGravity != 16) goto L19;
        this.iconTop = 0;
        goto L17
    L19:
        int r18 = this.iconSize;
        if (r18 != 0) goto L22;
        r18 = this.icon.getIntrinsicHeight();
    L22:
        int r19 = (((((r11 - getTextHeight()) - getPaddingTop()) - r18) - this.iconPadding) - getPaddingBottom()) / 2;
        if (this.iconTop == r19) goto L56;
        this.iconTop = r19;
        goto L25
    L56:
        return;
    }

    public void addOnCheckedChangeListener(@NonNull a r10) {
        this.onCheckedChangeListeners.add(r10);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
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
        return this.materialButtonHelper.b();
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
        return this.materialButtonHelper.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.h();
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public com.google.android.material.shape.l getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.i();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.j();
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.k();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.l();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.m();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        com.google.android.material.button.a r10 = this.materialButtonHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.p() == false) goto L7;
        return true;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        h.f(this, this.materialButtonHelper.f());
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 2);
        if (isCheckable() == false) goto L6;
        Button.mergeDrawableStates(r11, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        Button.mergeDrawableStates(r11, CHECKED_STATE_SET);
    L8:
        return r11;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(getA11yClassName());
        r10.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(getA11yClassName());
        r10.setCheckable(isCheckable());
        r10.setChecked(isChecked());
        r10.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (Build.VERSION.SDK_INT != 21) goto L7;
        com.google.android.material.button.a r15 = this.materialButtonHelper;
        if (r15 == null) goto L7;
        r15.H(r14 - r12, r13 - r11);
    L7:
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setChecked(r11.checked);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.checked = this.checked;
        return r10;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        super.onTextChanged(r10, r11, r12, r13);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon == null) goto L8;
        int[] r10 = getDrawableState();
        if (this.icon.setState(r10) == false) goto L9;
        invalidate();
        return;
    L9:
        return;
    }

    public void removeOnCheckedChangeListener(@NonNull a r10) {
        this.onCheckedChangeListeners.remove(r10);
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable r10) {
        setBackgroundDrawable(r10);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.r(r10);
        return;
    L5:
        super.setBackgroundColor(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable r10) {
        if (isUsingOriginalBackground() == true) goto L5;
    L8:
        super.setBackgroundDrawable(r10);
        return;
    L5:
        if (r10 == getBackground()) goto L7;
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.materialButtonHelper.s();
        goto L8
    L7:
        getBackground().setState(r10.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setBackgroundDrawable(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r10) {
        setSupportBackgroundTintList(r10);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        setSupportBackgroundTintMode(r10);
    }

    public void setCheckable(boolean r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.t(r10);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.checked == r10) goto L23;
        this.checked = r10;
        refreshDrawableState();
        if ((getParent() instanceof MaterialButtonToggleGroup) == false) goto L12;
        ((MaterialButtonToggleGroup) getParent()).n(this, this.checked);
    L12:
        if (this.broadcasting == false) goto L14;
        return;
    L14:
        this.broadcasting = true;
        Iterator<a> r11 = this.onCheckedChangeListeners.iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        r11.next().a(this, this.checked);
        goto L16
    L18:
        this.broadcasting = false;
        return;
    }

    public void setCornerRadius(@Px int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.u(r10);
        return;
    }

    public void setCornerRadiusResource(@DimenRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(getResources().getDimensionPixelSize(r10));
        return;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r10) {
        super.setElevation(r10);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.f().setElevation(r10);
        return;
    }

    public void setIcon(@Nullable Drawable r10) {
        if (this.icon == r10) goto L6;
        this.icon = r10;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconGravity(int r10) {
        if (this.iconGravity == r10) goto L6;
        this.iconGravity = r10;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconPadding(@Px int r10) {
        if (this.iconPadding == r10) goto L6;
        this.iconPadding = r10;
        setCompoundDrawablePadding(r10);
        return;
    }

    public void setIconResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setIconSize(@Px int r10) {
        if (r10 < 0) goto L8;
        if (this.iconSize == r10) goto L9;
        this.iconSize = r10;
        updateIcon(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList r10) {
        if (this.iconTint == r10) goto L6;
        this.iconTint = r10;
        updateIcon(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r10) {
        if (this.iconTintMode == r10) goto L6;
        this.iconTintMode = r10;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(@ColorRes int r10) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), r10));
    }

    public void setInsetBottom(@Dimension int r10) {
        this.materialButtonHelper.v(r10);
    }

    public void setInsetTop(@Dimension int r10) {
        this.materialButtonHelper.w(r10);
    }

    void setInternalBackground(Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    void setOnPressedChangeListenerInternal(@Nullable b r10) {
        this.onPressedChangeListenerInternal = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        b r11 = this.onPressedChangeListenerInternal;
        if (r11 == null) goto L5;
        r11.a(this, r10);
    L5:
        super.setPressed(r10);
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.x(r10);
        return;
    }

    public void setRippleColorResource(@ColorRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList(getContext(), r10));
        return;
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull com.google.android.material.shape.l r10) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.y(r10);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    void setShouldDrawSurfaceColorStroke(boolean r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.z(r10);
        return;
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.A(r10);
        return;
    }

    public void setStrokeColorResource(@ColorRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r10));
        return;
    }

    public void setStrokeWidth(@Px int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.B(r10);
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r10) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(getResources().getDimensionPixelSize(r10));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.C(r10);
        return;
    L5:
        super.setSupportBackgroundTintList(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.D(r10);
        return;
    L5:
        super.setSupportBackgroundTintMode(r10);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int r10) {
        super.setTextAlignment(r10);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }
}
