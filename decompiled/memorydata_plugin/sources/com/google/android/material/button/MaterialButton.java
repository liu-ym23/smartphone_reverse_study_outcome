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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
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
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private int iconTop;
    private final com.google.android.material.button.a materialButtonHelper;
    private final LinkedHashSet<a> onCheckedChangeListeners;
    private b onPressedChangeListenerInternal;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            getClass().getClassLoader();
        L5:
            readFromParcel(r1);
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        private void readFromParcel(Parcel r2) {
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.checked = r0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.checked ? 1 : 0);
        }
    }

    public interface a {
        void a(MaterialButton r1, boolean r2);
    }

    interface b {
        void a(MaterialButton r1, boolean r2);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.Widget_MaterialComponents_Button, "style", "Widget_MaterialComponents_Button");
    }

    public MaterialButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.materialButtonStyle, "attr", "materialButtonStyle"));
    }

    public MaterialButton(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r14, r12, r0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r14, r12);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean r15 = false;
        this.checked = false;
        this.broadcasting = false;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r2 = k.a(r8, r14, com.obric.memorydata.plugin.R.styleable.MaterialButton, r12, r0, new int[0]);
        this.iconPadding = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_iconPadding, "styleable", "MaterialButton_iconPadding"), 0);
        this.iconTintMode = r.a(r2.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_iconTintMode, "styleable", "MaterialButton_iconTintMode"), -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_iconTint, "styleable", "MaterialButton_iconTint"));
        this.icon = c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_icon, "styleable", "MaterialButton_icon"));
        this.iconGravity = r2.getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_iconGravity, "styleable", "MaterialButton_iconGravity"), 1);
        this.iconSize = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialButton_iconSize, "styleable", "MaterialButton_iconSize"), 0);
        com.google.android.material.button.a r16 = new com.google.android.material.button.a(this, l.a(r8, r14, r12, r0).a());
        this.materialButtonHelper = r16;
        r16.a(r2);
        r2.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        if (this.icon == null) goto L5;
        r15 = true;
    L5:
        updateIcon(r15);
    }

    private String getA11yClassName() {
        if (isCheckable() == false) goto L5;
        Class r0 = CompoundButton.class;
    L7:
        return r0.getName();
    L5:
        r0 = Button.class;
        goto L7
    }

    private Layout.Alignment getActualTextAlignment() {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        int r0 = getTextAlignment();
        if (r0 == 1) goto L21;
        if (r0 == 6) goto L19;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
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
        int r1 = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r1 == 1) goto L13;
        if (r1 == 5) goto L11;
        if (r1 == 8388613) goto L11;
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L13:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint r0 = getPaint();
        String r1 = getText().toString();
        if (getTransformationMethod() == null) goto L5;
        r1 = getTransformationMethod().getTransformation(r1, this).toString();
    L5:
        Rect r2 = new Rect();
        r0.getTextBounds(r1, 0, r1.length(), r2);
        return Math.min(r2.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint r0 = getPaint();
        String r1 = getText().toString();
        if (getTransformationMethod() == null) goto L6;
        r1 = getTransformationMethod().getTransformation(r1, this).toString();
    L6:
        return Math.min((int) r0.measureText(r1), getLayout().getEllipsizedWidth());
    }

    private boolean isIconEnd() {
        int r1 = this.iconGravity;
        if (r1 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 4) goto L8;
        return false;
    }

    private boolean isIconStart() {
        int r2 = this.iconGravity;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isIconTop() {
        int r1 = this.iconGravity;
        if (r1 != 16) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 32) goto L8;
        return false;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isUsingOriginalBackground() {
        com.google.android.material.button.a r0 = this.materialButtonHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() == true) goto L7;
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

    private void updateIcon(boolean r7) {
        Drawable r0 = this.icon;
        boolean r1 = true;
        if (r0 == null) goto L16;
        Drawable r2 = DrawableCompat.wrap(r0).mutate();
        this.icon = r2;
        DrawableCompat.setTintList(r2, this.iconTint);
        PorterDuff.Mode r3 = this.iconTintMode;
        if (r3 == null) goto L7;
        DrawableCompat.setTintMode(this.icon, r3);
    L7:
        int r4 = this.iconSize;
        if (r4 != 0) goto L11;
        r4 = this.icon.getIntrinsicWidth();
    L11:
        int r5 = this.iconSize;
        if (r5 != 0) goto L15;
        r5 = this.icon.getIntrinsicHeight();
    L15:
        Drawable r6 = this.icon;
        int r8 = this.iconLeft;
        int r9 = this.iconTop;
        r6.setBounds(r8, r9, r4 + r8, r5 + r9);
        this.icon.setVisible(true, r7);
    L16:
        if (r7 == false) goto L19;
        resetIconDrawable();
        return;
    L19:
        Drawable[] r10 = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable r11 = r10[0];
        Drawable r12 = r10[1];
        Drawable r13 = r10[2];
        if (isIconStart() == false) goto L24;
        if (r11 == this.icon) goto L24;
    L33:
        if (r1 == false) goto L36;
        resetIconDrawable();
        return;
    L36:
        return;
    L24:
        if (isIconEnd() == false) goto L28;
        if (r13 != this.icon) goto L33;
    L28:
        if (isIconTop() == true) goto L30;
    L32:
        r1 = false;
        goto L33
    L30:
        if (r12 == this.icon) goto L32;
        goto L32
    }

    private void updateIconPosition(int r6, int r7) {
        if (this.icon != null) goto L5;
        return;
    L5:
        if (getLayout() != null) goto L8;
        return;
    L8:
        if (isIconStart() == false) goto L10;
    L26:
        this.iconTop = 0;
        Layout.Alignment r8 = getActualTextAlignment();
        int r0 = this.iconGravity;
        boolean r3 = true;
        if (r0 != 1) goto L29;
    L54:
        this.iconLeft = 0;
    L17:
        updateIcon(false);
        return;
    L29:
        if (r0 == 3) goto L54;
        if (r0 != 2) goto L34;
        if (r8 == Layout.Alignment.ALIGN_NORMAL) goto L54;
    L34:
        if (this.iconGravity == 4) goto L36;
    L38:
        int r1 = this.iconSize;
        if (r1 != 0) goto L41;
        r1 = this.icon.getIntrinsicWidth();
    L41:
        int r9 = ((((r6 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - r1) - this.iconPadding) - ViewCompat.getPaddingStart(this);
        if (r8 != Layout.Alignment.ALIGN_CENTER) goto L44;
        r9 = r9 / 2;
    L44:
        boolean r10 = isLayoutRTL();
        if (this.iconGravity == 4) goto L48;
        r3 = false;
    L48:
        if (r10 == r3) goto L51;
        r9 = -r9;
    L51:
        if (this.iconLeft == r9) goto L58;
        this.iconLeft = r9;
    L25:
        updateIcon(false);
        return;
    L58:
        return;
    L36:
        if (r8 != Layout.Alignment.ALIGN_OPPOSITE) goto L38;
    L10:
        if (isIconEnd() == true) goto L26;
        if (isIconTop() == false) goto L53;
        this.iconLeft = 0;
        if (this.iconGravity != 16) goto L19;
        this.iconTop = 0;
        goto L17
    L19:
        int r11 = this.iconSize;
        if (r11 != 0) goto L22;
        r11 = this.icon.getIntrinsicHeight();
    L22:
        int r12 = (((((r7 - getTextHeight()) - getPaddingTop()) - r11) - this.iconPadding) - getPaddingBottom()) / 2;
        if (this.iconTop == r12) goto L56;
        this.iconTop = r12;
        goto L25
    L56:
        return;
    }

    public void addOnCheckedChangeListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.onCheckedChangeListeners.add(r4);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.h();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.m();
    }

    public int getInsetTop() {
        return this.materialButtonHelper.n();
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.e();
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.l();
    L7:
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground() == true) goto L7;
        return null;
    L7:
        return this.materialButtonHelper.f();
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground() == true) goto L7;
        return 0;
    L7:
        return this.materialButtonHelper.g();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.c();
    L7:
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground() == false) goto L7;
        return this.materialButtonHelper.d();
    L7:
        return super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        com.google.android.material.button.a r0 = this.materialButtonHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.j() == false) goto L7;
        return true;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground() == false) goto L6;
        h.a(this, this.materialButtonHelper.i());
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isCheckable() == false) goto L6;
        mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L8;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
    L8:
        return r3;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(getA11yClassName());
        r2.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(getA11yClassName());
        r2.setCheckable(isCheckable());
        r2.setChecked(isChecked());
        r2.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        if (Build.VERSION.SDK_INT != 21) goto L7;
        com.google.android.material.button.a r7 = this.materialButtonHelper;
        if (r7 == null) goto L7;
        r7.a(r6 - r4, r5 - r3);
    L7:
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        setChecked(r5.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.checked = this.checked;
        return r1;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        super.onTextChanged((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5, r6);
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
        int[] r0 = getDrawableState();
        if (this.icon.setState(r0) == false) goto L9;
        invalidate();
        return;
    L9:
        return;
    }

    public void removeOnCheckedChangeListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.onCheckedChangeListeners.remove(r4);
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        setBackgroundDrawable(r1);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.a(r2);
        return;
    L5:
        super.setBackgroundColor(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        if (isUsingOriginalBackground() == true) goto L5;
    L8:
        super.setBackgroundDrawable(r3);
        return;
    L5:
        if (r3 == getBackground()) goto L7;
        Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.materialButtonHelper.a();
        goto L8
    L7:
        getBackground().setState(r3.getState());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setBackgroundDrawable(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r1) {
        setSupportBackgroundTintList(r1);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r1) {
        setSupportBackgroundTintMode(r1);
    }

    public void setCheckable(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.b(r2);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r4) {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == true) goto L7;
        return;
    L7:
        if (this.checked == r4) goto L23;
        this.checked = r4;
        refreshDrawableState();
        if (ZeusTransformUtils.instanceOf(getParent(), MaterialButtonToggleGroup.class) == false) goto L12;
        ((MaterialButtonToggleGroup) ZeusTransformUtils.preCheckCast(getParent(), MaterialButtonToggleGroup.class, "com.obric.memorydata.plugin")).a(this, this.checked);
    L12:
        if (this.broadcasting == false) goto L14;
        return;
    L14:
        this.broadcasting = true;
        Iterator<a> r5 = this.onCheckedChangeListeners.iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        ((a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin")).a(this, this.checked);
        goto L16
    L18:
        this.broadcasting = false;
        return;
    }

    public void setCornerRadius(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.c(r2);
        return;
    }

    public void setCornerRadiusResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setCornerRadius(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
        return;
    }

    @Override // android.view.View
    public void setElevation(float r2) {
        super.setElevation(r2);
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.i().setElevation(r2);
        return;
    }

    public void setIcon(Drawable r2) {
        if (this.icon == r2) goto L6;
        this.icon = r2;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconGravity(int r2) {
        if (this.iconGravity == r2) goto L6;
        this.iconGravity = r2;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        return;
    }

    public void setIconPadding(int r2) {
        if (this.iconPadding == r2) goto L6;
        this.iconPadding = r2;
        setCompoundDrawablePadding(r2);
        return;
    }

    public void setIconResource(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setIcon(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setIconSize(int r2) {
        if (r2 < 0) goto L8;
        if (this.iconSize == r2) goto L9;
        this.iconSize = r2;
        updateIcon(true);
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList r2) {
        if (this.iconTint == r2) goto L6;
        this.iconTint = r2;
        updateIcon(false);
        return;
    }

    public void setIconTintMode(PorterDuff.Mode r2) {
        if (this.iconTintMode == r2) goto L6;
        this.iconTintMode = r2;
        updateIcon(false);
        return;
    }

    public void setIconTintResource(int r4) {
        setIconTint(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setInsetBottom(int r1) {
        this.materialButtonHelper.d(r1);
    }

    public void setInsetTop(int r1) {
        this.materialButtonHelper.e(r1);
    }

    void setInternalBackground(Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    void setOnPressedChangeListenerInternal(b r3) {
        this.onPressedChangeListenerInternal = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        b r0 = this.onPressedChangeListenerInternal;
        if (r0 == null) goto L5;
        r0.a(this, r2);
    L5:
        super.setPressed(r2);
    }

    public void setRippleColor(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.b(r2);
        return;
    }

    public void setRippleColorResource(int r4) {
        if (isUsingOriginalBackground() == false) goto L6;
        setRippleColor(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
        return;
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r2) {
        if (isUsingOriginalBackground() == false) goto L7;
        this.materialButtonHelper.a(r2);
        return;
    L7:
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    void setShouldDrawSurfaceColorStroke(boolean r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.a(r2);
        return;
    }

    public void setStrokeColor(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.c(r2);
        return;
    }

    public void setStrokeColorResource(int r4) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeColor(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
        return;
    }

    public void setStrokeWidth(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        this.materialButtonHelper.b(r2);
        return;
    }

    public void setStrokeWidthResource(int r2) {
        if (isUsingOriginalBackground() == false) goto L6;
        setStrokeWidth(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.a(r2);
        return;
    L5:
        super.setSupportBackgroundTintList(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        if (isUsingOriginalBackground() == false) goto L5;
        this.materialButtonHelper.a(r2);
        return;
    L5:
        super.setSupportBackgroundTintMode(r2);
    }

    @Override // android.view.View
    public void setTextAlignment(int r2) {
        super.setTextAlignment(r2);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }
}
