package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final int DEF_STYLE_RES = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.RadioButton";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";

    @Nullable
    private CharSequence accessibilityClassName;

    @Nullable
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;

    @Nullable
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;

    @Dimension(unit = 1)
    private int minTouchTargetSize;

    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    @Nullable
    private MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListenerInternal;

    @Nullable
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;

    @Nullable
    private RippleDrawable ripple;

    @NonNull
    private final ChipTouchHelper touchHelper;
    private boolean touchHelperEnabled;

    public class ChipTouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ Chip this$0;

        public ChipTouchHelper(Chip r5, Chip r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r5, float r10) {
            if (Chip.access$100(this.this$0) == true) goto L5;
        L7:
            return 0;
        L5:
            if (Chip.access$200(this.this$0).contains(r5, r10) == false) goto L7;
            return 1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> r5) {
            r5.add(0);
            if (Chip.access$100(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.this$0.isCloseIconVisible() == true) goto L7;
            return;
        L7:
            if (Chip.access$300(this.this$0) == null) goto L12;
            r5.add(1);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r5, int r10, Bundle r11) {
            if (r10 != 16) goto L11;
            if (r5 != 0) goto L8;
            return this.this$0.performClick();
        L8:
            if (r5 == 1) goto L10;
            return false;
        L10:
            return this.this$0.performCloseIconClick();
        L11:
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r5) {
            r5.setCheckable(this.this$0.isCheckable());
            r5.setClickable(this.this$0.isClickable());
            r5.setClassName(this.this$0.getAccessibilityClassName());
            r5.setText(this.this$0.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r5, @NonNull AccessibilityNodeInfoCompat r10) {
            CharSequence r11 = "";
            if (r5 != 1) goto L12;
            CharSequence r12 = this.this$0.getCloseIconContentDescription();
            if (r12 == null) goto L7;
            r10.setContentDescription(r12);
        L11:
            r10.setBoundsInParent(Chip.access$500(this.this$0));
            r10.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            r10.setEnabled(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r13 = this.this$0.getText();
            Context r14 = this.this$0.getContext();
            int r15 = R.string.mtrl_chip_close_icon_content_description;
            if (TextUtils.isEmpty(r13) == true) goto L10;
            r11 = r13;
        L10:
            r10.setContentDescription(r14.getString(r15, new Object[]{r11}).trim());
            goto L11
        L12:
            r10.setContentDescription("");
            r10.setBoundsInParent(Chip.access$600());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int r5, boolean r10) {
            if (r5 != 1) goto L6;
            Chip.access$402(this.this$0, r10);
            this.this$0.refreshDrawableState();
            return;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Chip_Action;
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{android.R.attr.state_selected};
        CHECKABLE_STATE_SET = new int[]{android.R.attr.state_checkable};
    }

    public Chip(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(Chip r5, CompoundButton r10, boolean r11) {
        r5.lambda$new$0(r10, r11);
    }

    public static /* synthetic */ ChipDrawable access$000(Chip r5) {
        return r5.chipDrawable;
    }

    public static /* synthetic */ boolean access$100(Chip r5) {
        return r5.hasCloseIcon();
    }

    public static /* synthetic */ RectF access$200(Chip r5) {
        return r5.getCloseIconTouchBounds();
    }

    public static /* synthetic */ View.OnClickListener access$300(Chip r5) {
        return r5.onCloseIconClickListener;
    }

    public static /* synthetic */ boolean access$402(Chip r5, boolean r10) {
        r5.closeIconFocused = r10;
        return r10;
    }

    public static /* synthetic */ Rect access$500(Chip r5) {
        return r5.getCloseIconTouchBoundsInt();
    }

    public static /* synthetic */ Rect access$600() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(@NonNull ChipDrawable r5) {
        r5.setDelegate(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @NonNull
    private int[] createCloseIconDrawableState() {
        ?? r5 = isEnabled();
        int r10 = r5;
        if (this.closeIconFocused == false) goto L5;
        r10 = r5 + 1;
    L5:
        int r11 = r10;
        if (this.closeIconHovered == false) goto L8;
        r11 = r10 + 1;
    L8:
        int r12 = r11;
        if (this.closeIconPressed == false) goto L11;
        r12 = r11 + 1;
    L11:
        int r13 = r12;
        if (isChecked() == false) goto L14;
        r13 = r12 + 1;
    L14:
        int[] r14 = new int[r13];
        int r15 = 0;
        if (isEnabled() == false) goto L18;
        r14[0] = 16842910;
        r15 = 1;
    L18:
        if (this.closeIconFocused == false) goto L21;
        r14[r15] = 16842908;
        r15 = r15 + 1;
    L21:
        if (this.closeIconHovered == false) goto L24;
        r14[r15] = 16843623;
        r15 = r15 + 1;
    L24:
        if (this.closeIconPressed == false) goto L27;
        r14[r15] = 16842919;
        r15 = r15 + 1;
    L27:
        if (isChecked() == false) goto L29;
        r14[r15] = 16842913;
    L29:
        return r14;
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable) goto L5;
        return;
    L5:
        if (this.chipDrawable.getCallback() != null) goto L9;
        this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        return;
    }

    @NonNull
    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L8;
        if (this.onCloseIconClickListener == null) goto L8;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L8:
        return this.rectF;
    }

    @NonNull
    private Rect getCloseIconTouchBoundsInt() {
        RectF r5 = getCloseIconTouchBounds();
        this.rect.set((int) r5.left, (int) r5.top, (int) r5.right, (int) r5.bottom);
        return this.rect;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getTextAppearance();
    }

    private boolean hasCloseIcon() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.getCloseIcon() == null) goto L7;
        return true;
    }

    private void initMinTouchTarget(Context r10, @Nullable AttributeSet r11, int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.Chip, r12, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = r13.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) Math.ceil(r13.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        r13.recycle();
    }

    private void initOutlineProvider() {
        setOutlineProvider(new AnonymousClass2(this));
    }

    private void insetChipBackgroundDrawable(int r10, int r11, int r12, int r13) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, r10, r11, r12, r13);
    }

    private /* synthetic */ void lambda$new$0(CompoundButton r5, boolean r10) {
        MaterialCheckable.OnCheckedChangeListener<Chip> r11 = this.onCheckedChangeListenerInternal;
        if (r11 == null) goto L5;
        r11.onCheckedChanged(this, r10);
    L5:
        CompoundButton.OnCheckedChangeListener r12 = this.onCheckedChangeListener;
        if (r12 == null) goto L9;
        r12.onCheckedChanged(r5, r10);
        return;
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable == null) goto L6;
        this.insetBackgroundDrawable = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        updateBackgroundDrawable();
        return;
    }

    private void setCloseIconHovered(boolean r5) {
        if (this.closeIconHovered == r5) goto L6;
        this.closeIconHovered = r5;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r5) {
        if (this.closeIconPressed == r5) goto L6;
        this.closeIconPressed = r5;
        refreshDrawableState();
        return;
    }

    private void unapplyChipDrawable(@Nullable ChipDrawable r5) {
        if (r5 == null) goto L5;
        r5.setDelegate(null);
        return;
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() == true) goto L5;
    L9:
        ViewCompat.setAccessibilityDelegate(this, null);
        this.touchHelperEnabled = false;
        return;
    L5:
        if (isCloseIconVisible() == false) goto L9;
        if (this.onCloseIconClickListener == null) goto L9;
        ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
        this.touchHelperEnabled = true;
    }

    private void updateBackgroundDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE == false) goto L5;
        updateFrameworkRippleBackground();
        return;
    L5:
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        if (TextUtils.isEmpty(getText()) == true) goto L12;
        ChipDrawable r5 = this.chipDrawable;
        if (r5 == null) goto L13;
        float r10 = r5.getChipEndPadding();
        float r11 = this.chipDrawable.getTextEndPadding() + r10;
        int r12 = (int) (this.chipDrawable.calculateCloseIconWidth() + r11);
        float r13 = this.chipDrawable.getChipStartPadding();
        float r14 = this.chipDrawable.getTextStartPadding() + r13;
        int r15 = (int) (this.chipDrawable.calculateChipIconWidth() + r14);
        if (this.insetBackgroundDrawable == null) goto L10;
        Rect r16 = new Rect();
        this.insetBackgroundDrawable.getPadding(r16);
        r15 = r15 + r16.left;
        r12 = r12 + r16.right;
    L10:
        ViewCompat.setPaddingRelative(this, r15, getPaddingTop(), r12, getPaddingBottom());
        return;
    L13:
        return;
    }

    private void updateTextPaintDrawState() {
        TextPaint r5 = getPaint();
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r5.drawableState = r10.getState();
    L5:
        TextAppearance r11 = getTextAppearance();
        if (r11 == null) goto L9;
        r11.updateDrawState(getContext(), r5, this.fontCallback);
        return;
    }

    private void validateAttributes(@Nullable AttributeSet r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getAttributeValue(NAMESPACE_ANDROID, "background") == null) goto L8;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    L8:
        if (r5.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) goto L36;
        if (r5.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) goto L34;
        if (r5.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) goto L32;
        if (r5.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) goto L30;
        if (r5.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) == false) goto L28;
        if (r5.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1) goto L28;
        if (r5.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) goto L28;
        if (r5.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) goto L28;
        if (r5.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) == 8388627) goto L37;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L37:
        return;
    L28:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L30:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L32:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L34:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L36:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r5) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchHoverEvent(r5);
    L7:
        if (this.touchHelper.dispatchHoverEvent(r5) == false) goto L9;
    L12:
        return true;
    L9:
        if (super.dispatchHoverEvent(r5) == true) goto L12;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r5) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchKeyEvent(r5);
    L7:
        if (this.touchHelper.dispatchKeyEvent(r5) == false) goto L13;
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) goto L13;
        return true;
    L13:
        return super.dispatchKeyEvent(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r5.isCloseIconStateful() == false) goto L7;
        r10 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        goto L8
    }

    public boolean ensureAccessibleTouchTarget(@Dimension int r10) {
        this.minTouchTargetSize = r10;
        int r5 = 0;
        if (shouldEnsureMinTouchTargetSize() == false) goto L5;
        int r11 = Math.max(0, r10 - this.chipDrawable.getIntrinsicHeight());
        int r12 = Math.max(0, r10 - this.chipDrawable.getIntrinsicWidth());
        if (r12 > 0) goto L17;
        if (r11 > 0) goto L17;
        if (this.insetBackgroundDrawable == null) goto L15;
        removeBackgroundInset();
    L16:
        return false;
    L15:
        updateBackgroundDrawable();
    L17:
        if (r12 <= 0) goto L19;
        int r13 = r12 / 2;
    L20:
        if (r11 <= 0) goto L23;
        r5 = r11 / 2;
    L23:
        if (this.insetBackgroundDrawable == null) goto L35;
        Rect r14 = new Rect();
        this.insetBackgroundDrawable.getPadding(r14);
        if (r14.top != r5) goto L35;
        if (r14.bottom != r5) goto L35;
        if (r14.left != r13) goto L35;
        if (r14.right != r13) goto L35;
        updateBackgroundDrawable();
        return true;
    L35:
        if (getMinHeight() == r10) goto L38;
        setMinHeight(r10);
    L38:
        if (getMinWidth() == r10) goto L40;
        setMinWidth(r10);
    L40:
        insetChipBackgroundDrawable(r13, r5, r13, r5);
        updateBackgroundDrawable();
        return true;
    L19:
        r13 = 0;
        goto L20
    L5:
        if (this.insetBackgroundDrawable == null) goto L7;
        removeBackgroundInset();
    L8:
        return false;
    L7:
        updateBackgroundDrawable();
        goto L8
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName) == true) goto L7;
        return this.accessibilityClassName;
    L7:
        if (isCheckable() == false) goto L16;
        ViewParent r5 = getParent();
        if ((r5 instanceof ChipGroup) == true) goto L11;
    L14:
        return BUTTON_ACCESSIBILITY_CLASS_NAME;
    L11:
        if (((ChipGroup) r5).isSingleSelection() == false) goto L14;
        return RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L16:
        if (isClickable() == false) goto L18;
        return BUTTON_ACCESSIBILITY_CLASS_NAME;
    L18:
        return GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME;
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable r5 = this.insetBackgroundDrawable;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return this.chipDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCheckedIcon();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCheckedIconTint();
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getChipBackgroundColor();
    }

    public float getChipCornerRadius() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r5.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getChipEndPadding();
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getChipIcon();
    }

    public float getChipIconSize() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getChipIconSize();
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getChipIconTint();
    }

    public float getChipMinHeight() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getChipMinHeight();
    }

    public float getChipStartPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getChipStartPadding();
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getChipStrokeColor();
    }

    public float getChipStrokeWidth() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getChipStrokeWidth();
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCloseIcon();
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCloseIconContentDescription();
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getCloseIconEndPadding();
    }

    public float getCloseIconSize() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getCloseIconSize();
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getCloseIconStartPadding();
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getCloseIconTint();
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getEllipsize();
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect r5) {
        if (this.touchHelperEnabled == true) goto L5;
    L9:
        super.getFocusedRect(r5);
        return;
    L5:
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) goto L7;
    L8:
        r5.set(getCloseIconTouchBoundsInt());
        return;
    L7:
        if (this.touchHelper.getAccessibilityFocusedVirtualViewId() != 1) goto L9;
        goto L8
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getHideMotionSpec();
    }

    public float getIconEndPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getIconEndPadding();
    }

    public float getIconStartPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getIconStartPadding();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getShowMotionSpec();
    }

    public float getTextEndPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getTextEndPadding();
    }

    public float getTextStartPadding() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.getTextStartPadding();
    }

    public boolean isCheckable() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isCheckable() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isCheckedIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isChipIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable r5 = this.chipDrawable;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isCloseIconVisible() == false) goto L7;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 2);
        if (isChecked() == false) goto L6;
        View.mergeDrawableStates(r10, SELECTED_STATE);
    L6:
        if (isCheckable() == false) goto L8;
        View.mergeDrawableStates(r10, CHECKABLE_STATE_SET);
    L8:
        return r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean r5, int r10, Rect r11) {
        super.onFocusChanged(r5, r10, r11);
        if (this.touchHelperEnabled == false) goto L6;
        this.touchHelper.onFocusChanged(r5, r10, r11);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r5) {
        int r10 = r5.getActionMasked();
        if (r10 != 7) goto L5;
        setCloseIconHovered(getCloseIconTouchBounds().contains(r5.getX(), r5.getY()));
    L10:
        return super.onHoverEvent(r5);
    L5:
        if (r10 != 10) goto L10;
        setCloseIconHovered(false);
        goto L10
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(getAccessibilityClassName());
        r10.setCheckable(isCheckable());
        r10.setClickable(isClickable());
        if ((getParent() instanceof ChipGroup) == false) goto L11;
        ChipGroup r5 = (ChipGroup) getParent();
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
        if (r5.isSingleLine() == false) goto L8;
        int r12 = r5.getIndexOfChip(this);
    L7:
        int r13 = r12;
        r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r5.getRowIndex(this), 1, r13, 1, false, isChecked()));
        return;
    L8:
        r12 = -1;
        goto L7
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent r5, int r10) {
        if (getCloseIconTouchBounds().contains(r5.getX(), r5.getY()) == false) goto L9;
        if (isEnabled() == false) goto L9;
        return PointerIcon.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND);
    L9:
        return super.onResolvePointerIcon(r5, r10);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int r5) {
        super.onRtlPropertiesChanged(r5);
        if (this.lastLayoutDirection == r5) goto L6;
        this.lastLayoutDirection = r5;
        updatePaddingInternal();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        int r5 = r10.getActionMasked();
        boolean r11 = getCloseIconTouchBounds().contains(r10.getX(), r10.getY());
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L11;
        if (r5 != 3) goto L22;
    L18:
        boolean r12 = false;
    L19:
        setCloseIconPressed(false);
    L23:
        if (r12 == false) goto L25;
        return true;
    L25:
        if (super.onTouchEvent(r10) == false) goto L28;
        return true;
    L28:
        return false;
    L22:
        r12 = false;
        goto L23
    L11:
        if (this.closeIconPressed == false) goto L22;
        if (r11 == true) goto L14;
        setCloseIconPressed(false);
    L14:
        r12 = true;
        goto L23
    L16:
        if (this.closeIconPressed == false) goto L18;
        performCloseIconClick();
        r12 = true;
        goto L19
    L20:
        if (r11 == false) goto L22;
        setCloseIconPressed(true);
        goto L14
    }

    @CallSuper
    public boolean performCloseIconClick() {
        boolean r5 = false;
        playSoundEffect(0);
        View.OnClickListener r10 = this.onCloseIconClickListener;
        if (r10 == null) goto L6;
        r10.onClick(this);
        r5 = true;
    L6:
        if (this.touchHelperEnabled == false) goto L8;
        this.touchHelper.sendEventForVirtualView(1, 1);
    L8:
        return r5;
    }

    public void setAccessibilityClassName(@Nullable CharSequence r5) {
        this.accessibilityClassName = r5;
    }

    @Override // android.view.View
    public void setBackground(Drawable r5) {
        if (r5 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackground(r5);
        return;
    L5:
        if (r5 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        if (r5 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackgroundDrawable(r5);
        return;
    L5:
        if (r5 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r5) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList r5) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckable(r5);
        return;
    }

    public void setCheckableResource(@BoolRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckableResource(r5);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 != null) goto L6;
        this.deferredCheckedValue = r5;
        return;
    L6:
        if (r10.isCheckable() == false) goto L10;
        super.setChecked(r5);
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIcon(r5);
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r5) {
        setCheckedIconVisible(r5);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int r5) {
        setCheckedIconVisible(r5);
    }

    public void setCheckedIconResource(@DrawableRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIconResource(r5);
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIconTint(r5);
        return;
    }

    public void setCheckedIconTintResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIconTintResource(r5);
        return;
    }

    public void setCheckedIconVisible(@BoolRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIconVisible(r5);
        return;
    }

    public void setChipBackgroundColor(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipBackgroundColor(r5);
        return;
    }

    public void setChipBackgroundColorResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipBackgroundColorResource(r5);
        return;
    }

    @Deprecated
    public void setChipCornerRadius(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipCornerRadius(r5);
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipCornerRadiusResource(r5);
        return;
    }

    public void setChipDrawable(@NonNull ChipDrawable r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == r5) goto L6;
        unapplyChipDrawable(r10);
        this.chipDrawable = r5;
        r5.setShouldDrawText(false);
        applyChipDrawable(this.chipDrawable);
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        return;
    }

    public void setChipEndPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipEndPadding(r5);
        return;
    }

    public void setChipEndPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipEndPaddingResource(r5);
        return;
    }

    public void setChipIcon(@Nullable Drawable r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIcon(r5);
        return;
    }

    @Deprecated
    public void setChipIconEnabled(boolean r5) {
        setChipIconVisible(r5);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int r5) {
        setChipIconVisible(r5);
    }

    public void setChipIconResource(@DrawableRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconResource(r5);
        return;
    }

    public void setChipIconSize(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconSize(r5);
        return;
    }

    public void setChipIconSizeResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconSizeResource(r5);
        return;
    }

    public void setChipIconTint(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconTint(r5);
        return;
    }

    public void setChipIconTintResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconTintResource(r5);
        return;
    }

    public void setChipIconVisible(@BoolRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconVisible(r5);
        return;
    }

    public void setChipMinHeight(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipMinHeight(r5);
        return;
    }

    public void setChipMinHeightResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipMinHeightResource(r5);
        return;
    }

    public void setChipStartPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStartPadding(r5);
        return;
    }

    public void setChipStartPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStartPaddingResource(r5);
        return;
    }

    public void setChipStrokeColor(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStrokeColor(r5);
        return;
    }

    public void setChipStrokeColorResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStrokeColorResource(r5);
        return;
    }

    public void setChipStrokeWidth(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStrokeWidth(r5);
        return;
    }

    public void setChipStrokeWidthResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipStrokeWidthResource(r5);
        return;
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence r5) {
        setText(r5);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int r5) {
        setText(getResources().getString(r5));
    }

    public void setCloseIcon(@Nullable Drawable r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r10.setCloseIcon(r5);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconContentDescription(r5);
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r5) {
        setCloseIconVisible(r5);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int r5) {
        setCloseIconVisible(r5);
    }

    public void setCloseIconEndPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconEndPadding(r5);
        return;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconEndPaddingResource(r5);
        return;
    }

    public void setCloseIconResource(@DrawableRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r10.setCloseIconResource(r5);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconSize(r5);
        return;
    }

    public void setCloseIconSizeResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconSizeResource(r5);
        return;
    }

    public void setCloseIconStartPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconStartPadding(r5);
        return;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconStartPaddingResource(r5);
        return;
    }

    public void setCloseIconTint(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconTint(r5);
        return;
    }

    public void setCloseIconTintResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCloseIconTintResource(r5);
        return;
    }

    public void setCloseIconVisible(@BoolRes int r5) {
        setCloseIconVisible(getResources().getBoolean(r5));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        if (r5 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawables(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        if (r5 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesRelative(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r5, int r10, int r11, int r12) {
        if (r5 != 0) goto L9;
        if (r11 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r5, int r10, int r11, int r12) {
        if (r5 != 0) goto L9;
        if (r11 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setElevation(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r5) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (r5 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r5);
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L13;
        r10.setEllipsize(r5);
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean r5) {
        this.ensureMinTouchTargetSize = r5;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int r5) {
        if (r5 == 8388627) goto L5;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r5);
    }

    public void setHideMotionSpec(@Nullable MotionSpec r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setHideMotionSpec(r5);
        return;
    }

    public void setHideMotionSpecResource(@AnimatorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setHideMotionSpecResource(r5);
        return;
    }

    public void setIconEndPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setIconEndPadding(r5);
        return;
    }

    public void setIconEndPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setIconEndPaddingResource(r5);
        return;
    }

    public void setIconStartPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setIconStartPadding(r5);
        return;
    }

    public void setIconStartPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setIconStartPaddingResource(r5);
        return;
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable MaterialCheckable.OnCheckedChangeListener<Chip> r5) {
        this.onCheckedChangeListenerInternal = r5;
    }

    @Override // android.view.View
    public void setLayoutDirection(int r5) {
        if (this.chipDrawable != null) goto L5;
        return;
    L5:
        super.setLayoutDirection(r5);
    }

    @Override // android.widget.TextView
    public void setLines(int r5) {
        if (r5 > 1) goto L7;
        super.setLines(r5);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r5) {
        if (r5 > 1) goto L7;
        super.setMaxLines(r5);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int r5) {
        super.setMaxWidth(r5);
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setMaxWidth(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r5) {
        if (r5 > 1) goto L7;
        super.setMinLines(r5);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener r5) {
        this.onCheckedChangeListener = r5;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r5) {
        this.onCloseIconClickListener = r5;
        updateAccessibilityDelegate();
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setRippleColor(r5);
    L6:
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    }

    public void setRippleColorResource(@ColorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L8;
        r10.setRippleColorResource(r5);
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        this.chipDrawable.setShapeAppearanceModel(r5);
    }

    public void setShowMotionSpec(@Nullable MotionSpec r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setShowMotionSpec(r5);
        return;
    }

    public void setShowMotionSpecResource(@AnimatorRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setShowMotionSpecResource(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r5) {
        if (r5 == false) goto L6;
        super.setSingleLine(r5);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r5, TextView.BufferType r10) {
        ChipDrawable r11 = this.chipDrawable;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        if (r11.shouldDrawText() == false) goto L10;
        CharSequence r12 = null;
    L11:
        super.setText(r12, r10);
        ChipDrawable r13 = this.chipDrawable;
        if (r13 == null) goto L15;
        r13.setText(r5);
        return;
    L15:
        return;
    L10:
        r12 = r5;
        goto L11
    }

    public void setTextAppearance(@Nullable TextAppearance r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r10.setTextAppearance(r5);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(@StyleRes int r5) {
        setTextAppearance(getContext(), r5);
    }

    public void setTextEndPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setTextEndPadding(r5);
        return;
    }

    public void setTextEndPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setTextEndPaddingResource(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r5, float r10) {
        super.setTextSize(r5, r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setTextSize(TypedValue.applyDimension(r5, r10, getResources().getDisplayMetrics()));
    L5:
        updateTextPaintDrawState();
    }

    public void setTextStartPadding(float r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setTextStartPadding(r5);
        return;
    }

    public void setTextStartPaddingResource(@DimenRes int r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setTextStartPaddingResource(r5);
        return;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public Chip(Context r5, AttributeSet r10) {
        this(r5, r10, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r10.setCloseIconVisible(r5);
    L5:
        updateAccessibilityDelegate();
    }

    public Chip(Context r10, AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        Context r13 = getContext();
        validateAttributes(r11);
        ChipDrawable r14 = ChipDrawable.createFromAttributes(r13, r11, r12, r5);
        initMinTouchTarget(r13, r11, r12);
        setChipDrawable(r14);
        r14.setElevation(ViewCompat.getElevation(this));
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.Chip, r12, r5, new int[0]);
        boolean r16 = r15.hasValue(R.styleable.Chip_shapeAppearance);
        r15.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (r16 == true) goto L5;
        initOutlineProvider();
    L5:
        setChecked(this.deferredCheckedValue);
        setText(r14.getText());
        setEllipsize(r14.getEllipsize());
        updateTextPaintDrawState();
        if (this.chipDrawable.shouldDrawText() == true) goto L8;
        setLines(1);
        setHorizontallyScrolling(true);
    L8:
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize() == false) goto L11;
        setMinHeight(this.minTouchTargetSize);
    L11:
        this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
        super.setOnCheckedChangeListener(new a(0, this));
    }

    public void setCheckedIconVisible(boolean r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setCheckedIconVisible(r5);
        return;
    }

    public void setChipIconVisible(boolean r5) {
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L6;
        r10.setChipIconVisible(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        if (r5 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12) {
        if (r5 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r5, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r5, int r10) {
        super.setTextAppearance(r5, r10);
        ChipDrawable r11 = this.chipDrawable;
        if (r11 == null) goto L5;
        r11.setTextAppearanceResource(r10);
    L5:
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r5) {
        super.setTextAppearance(r5);
        ChipDrawable r10 = this.chipDrawable;
        if (r10 == null) goto L5;
        r10.setTextAppearanceResource(r5);
    L5:
        updateTextPaintDrawState();
    }
}
