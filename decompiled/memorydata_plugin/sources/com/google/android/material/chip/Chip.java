package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.android.material.a.h;
import com.google.android.material.internal.g;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.resources.d;
import com.google.android.material.resources.f;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.google.android.material.theme.a.a;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.a, g<Chip>, p {
    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final int DEF_STYLE_RES = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.RadioButton";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";
    private CharSequence accessibilityClassName;
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final f fontCallback;
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    private int minTouchTargetSize;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    private g.a<Chip> onCheckedChangeListenerInternal;
    private View.OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final ChipTouchHelper touchHelper;
    private boolean touchHelperEnabled;

    private class ChipTouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ Chip this$0;

        ChipTouchHelper(Chip r1, Chip r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float r2, float r3) {
            if (Chip.access$300(this.this$0) == true) goto L5;
        L7:
            return 0;
        L5:
            if (Chip.access$400(this.this$0).contains(r2, r3) == false) goto L7;
            return 1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r4.add(0);
            if (Chip.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.this$0.isCloseIconVisible() == true) goto L7;
            return;
        L7:
            if (Chip.access$500(this.this$0) == null) goto L12;
            r4.add(1);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int r1, int r2, Bundle r3) {
            if (r2 != 16) goto L11;
            if (r1 != 0) goto L8;
            return this.this$0.performClick();
        L8:
            if (r1 == 1) goto L10;
            return false;
        L10:
            return this.this$0.performCloseIconClick();
        L11:
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat r3) {
            r3.setCheckable(this.this$0.isCheckable());
            r3.setClickable(this.this$0.isClickable());
            r3.setClassName(this.this$0.getAccessibilityClassName());
            CharSequence r2 = this.this$0.getText();
            if (Build.VERSION.SDK_INT < 23) goto L5;
            r3.setText(r2);
            return;
        L5:
            r3.setContentDescription(r2);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int r7, AccessibilityNodeInfoCompat r8) {
            CharSequence r0 = "";
            if (r7 != 1) goto L12;
            CharSequence r9 = this.this$0.getCloseIconContentDescription();
            if (r9 == null) goto L7;
        L6:
            r8.setContentDescription(r9);
            r8.setBoundsInParent(Chip.access$700(this.this$0));
            r8.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            r8.setEnabled(this.this$0.isEnabled());
            return;
        L7:
            CharSequence r10 = this.this$0.getText();
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int r3 = ZeusTransformUtils.mapRes(R.string.mtrl_chip_close_icon_content_description, TypedValues.Custom.S_STRING, "mtrl_chip_close_icon_content_description");
            Object[] r1 = new Object[1];
            if (TextUtils.isEmpty(r10) == true) goto L10;
            r0 = r10;
        L10:
            r1[0] = r0;
            r9 = r2.getString(r3, r1).trim();
            goto L6
        L12:
            r8.setContentDescription("");
            r8.setBoundsInParent(Chip.access$800());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int r2, boolean r3) {
            if (r2 != 1) goto L6;
            Chip.access$602(this.this$0, r3);
            this.this$0.refreshDrawableState();
            return;
        }
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Chip_Action, "style", "Widget_MaterialComponents_Chip_Action");
        EMPTY_BOUNDS = new Rect();
        SELECTED_STATE = new int[]{android.R.attr.state_selected};
        CHECKABLE_STATE_SET = new int[]{android.R.attr.state_checkable};
    }

    public Chip(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public Chip(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.chipStyle, "attr", "chipStyle"));
    }

    public Chip(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new AnonymousClass1(this);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        validateAttributes(r3);
        ChipDrawable r14 = ChipDrawable.createFromAttributes(r13, r3, r11, r6);
        initMinTouchTarget(r13, r3, r11);
        setChipDrawable(r14);
        r14.setElevation(ViewCompat.getElevation(this));
        TypedArray r15 = k.a(r13, r3, R.styleable.Chip, r11, r6, new int[0]);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        setTextColor(c.a(r13, r15, ZeusTransformUtils.mapRes(R.styleable.Chip_android_textColor, "styleable", "Chip_android_textColor")));
    L5:
        boolean r16 = r15.hasValue(ZeusTransformUtils.mapRes(R.styleable.Chip_shapeAppearance, "styleable", "Chip_shapeAppearance"));
        r15.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        updateAccessibilityDelegate();
        if (r16 == true) goto L8;
        initOutlineProvider();
    L8:
        setChecked(this.deferredCheckedValue);
        setText(r14.getText());
        setEllipsize(r14.getEllipsize());
        updateTextPaintDrawState();
        if (this.chipDrawable.shouldDrawText() == true) goto L11;
        setLines(1);
        setHorizontallyScrolling(true);
    L11:
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize() == false) goto L14;
        setMinHeight(this.minTouchTargetSize);
    L14:
        this.lastLayoutDirection = ViewCompat.getLayoutDirection(this);
        super.setOnCheckedChangeListener(new AnonymousClass2(this));
    }

    static /* synthetic */ ChipDrawable access$000(Chip r0) {
        return r0.chipDrawable;
    }

    static /* synthetic */ g.a access$100(Chip r0) {
        return r0.onCheckedChangeListenerInternal;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$200(Chip r0) {
        return r0.onCheckedChangeListener;
    }

    static /* synthetic */ boolean access$300(Chip r0) {
        return r0.hasCloseIcon();
    }

    static /* synthetic */ RectF access$400(Chip r0) {
        return r0.getCloseIconTouchBounds();
    }

    static /* synthetic */ View.OnClickListener access$500(Chip r0) {
        return r0.onCloseIconClickListener;
    }

    static /* synthetic */ boolean access$602(Chip r0, boolean r1) {
        r0.closeIconFocused = r1;
        return r1;
    }

    static /* synthetic */ Rect access$700(Chip r0) {
        return r0.getCloseIconTouchBoundsInt();
    }

    static /* synthetic */ Rect access$800() {
        return EMPTY_BOUNDS;
    }

    private void applyChipDrawable(ChipDrawable r1) {
        r1.setDelegate(this);
    }

    private int[] createCloseIconDrawableState() {
        int r1 = 0;
        if (isEnabled() == false) goto L5;
        int r0 = 1;
    L7:
        if (this.closeIconFocused == false) goto L10;
        r0 = r0 + 1;
    L10:
        if (this.closeIconHovered == false) goto L13;
        r0 = r0 + 1;
    L13:
        if (this.closeIconPressed == false) goto L16;
        r0 = r0 + 1;
    L16:
        if (isChecked() == false) goto L18;
        r0 = r0 + 1;
    L18:
        int[] r2 = new int[r0];
        if (isEnabled() == false) goto L22;
        r2[0] = 16842910;
        r1 = 1;
    L22:
        if (this.closeIconFocused == false) goto L25;
        r2[r1] = 16842908;
        r1 = r1 + 1;
    L25:
        if (this.closeIconHovered == false) goto L28;
        r2[r1] = 16843623;
        r1 = r1 + 1;
    L28:
        if (this.closeIconPressed == false) goto L31;
        r2[r1] = 16842919;
        r1 = r1 + 1;
    L31:
        if (isChecked() == false) goto L33;
        r2[r1] = 16842913;
    L33:
        return r2;
    L5:
        r0 = 0;
        goto L7
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable) goto L5;
        return;
    L5:
        if (this.chipDrawable.getCallback() != null) goto L9;
        this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        return;
    }

    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon() == false) goto L8;
        if (this.onCloseIconClickListener == null) goto L8;
        this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    L8:
        return this.rectF;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF r0 = getCloseIconTouchBounds();
        this.rect.set((int) r0.left, (int) r0.top, (int) r0.right, (int) r0.bottom);
        return this.rect;
    }

    private d getTextAppearance() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextAppearance();
    }

    private boolean hasCloseIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getCloseIcon() == null) goto L7;
        return true;
    }

    private void initMinTouchTarget(Context r9, AttributeSet r10, int r11) {
        TypedArray r12 = k.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Chip, r11, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Chip_ensureMinTouchTargetSize, "styleable", "Chip_ensureMinTouchTargetSize"), false);
        this.minTouchTargetSize = (int) Math.ceil(r12.getDimension(ZeusTransformUtils.mapRes(R.styleable.Chip_chipMinTouchTargetSize, "styleable", "Chip_chipMinTouchTargetSize"), (float) Math.ceil(r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 48))));
        r12.recycle();
    }

    private void initOutlineProvider() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        setOutlineProvider(new AnonymousClass3(this));
        return;
    }

    private void insetChipBackgroundDrawable(int r8, int r9, int r10, int r11) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, r8, r9, r10, r11);
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable == null) goto L6;
        this.insetBackgroundDrawable = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        updateBackgroundDrawable();
        return;
    }

    private void setCloseIconHovered(boolean r2) {
        if (this.closeIconHovered == r2) goto L6;
        this.closeIconHovered = r2;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r2) {
        if (this.closeIconPressed == r2) goto L6;
        this.closeIconPressed = r2;
        refreshDrawableState();
        return;
    }

    private void unapplyChipDrawable(ChipDrawable r1) {
        if (r1 == null) goto L5;
        r1.setDelegate(null);
        return;
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() == true) goto L5;
    L9:
        ViewCompat.setAccessibilityDelegate(this, null);
        boolean r0 = false;
    L10:
        this.touchHelperEnabled = r0;
        return;
    L5:
        if (isCloseIconVisible() == false) goto L9;
        if (this.onCloseIconClickListener == null) goto L9;
        ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
        r0 = true;
        goto L10
    }

    private void updateBackgroundDrawable() {
        if (com.google.android.material.ripple.a.f4033a == false) goto L5;
        updateFrameworkRippleBackground();
        return;
    L5:
        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(com.google.android.material.ripple.a.b(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        if (TextUtils.isEmpty(getText()) == true) goto L12;
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L13;
        int r1 = (int) ((r0.getChipEndPadding() + this.chipDrawable.getTextEndPadding()) + this.chipDrawable.calculateCloseIconWidth());
        int r2 = (int) ((this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding()) + this.chipDrawable.calculateChipIconWidth());
        if (this.insetBackgroundDrawable == null) goto L10;
        Rect r3 = new Rect();
        this.insetBackgroundDrawable.getPadding(r3);
        r2 = r2 + r3.left;
        r1 = r1 + r3.right;
    L10:
        ViewCompat.setPaddingRelative(this, r2, getPaddingTop(), r1, getPaddingBottom());
        return;
    L13:
        return;
    }

    private void updateTextPaintDrawState() {
        TextPaint r0 = getPaint();
        ChipDrawable r1 = this.chipDrawable;
        if (r1 == null) goto L5;
        r0.drawableState = r1.getState();
    L5:
        d r2 = getTextAppearance();
        if (r2 == null) goto L9;
        r2.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0, this.fontCallback);
        return;
    }

    private void validateAttributes(AttributeSet r4) {
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.getAttributeValue(NAMESPACE_ANDROID, TraceCons.METRIC_BACKGROUND) == null) goto L9;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    L9:
        if (r3.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) goto L37;
        if (r3.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) goto L35;
        if (r3.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) goto L33;
        if (r3.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) goto L31;
        if (r3.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) == false) goto L29;
        if (r3.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1) goto L29;
        if (r3.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1) goto L29;
        if (r3.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) goto L29;
        if (r3.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) == 8388627) goto L38;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L38:
        return;
    L29:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L31:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L33:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L35:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L37:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent r2) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchHoverEvent(r2);
    L7:
        if (this.touchHelper.dispatchHoverEvent(r2) == false) goto L9;
    L12:
        return true;
    L9:
        if (super.dispatchHoverEvent(r2) == true) goto L12;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r3) {
        if (this.touchHelperEnabled == true) goto L7;
        return super.dispatchKeyEvent(r3);
    L7:
        if (this.touchHelper.dispatchKeyEvent(r3) == false) goto L13;
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) goto L13;
        return true;
    L13:
        return super.dispatchKeyEvent(r3);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r0.isCloseIconStateful() == false) goto L7;
        r1 = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
        goto L8
    }

    public boolean ensureAccessibleTouchTarget(int r6) {
        this.minTouchTargetSize = r6;
        int r1 = 0;
        if (shouldEnsureMinTouchTargetSize() == false) goto L5;
        int r0 = Math.max(0, r6 - this.chipDrawable.getIntrinsicHeight());
        int r2 = Math.max(0, r6 - this.chipDrawable.getIntrinsicWidth());
        if (r2 > 0) goto L17;
        if (r0 > 0) goto L17;
        if (this.insetBackgroundDrawable == null) goto L15;
        removeBackgroundInset();
    L16:
        return false;
    L15:
        updateBackgroundDrawable();
    L17:
        if (r2 <= 0) goto L19;
        int r3 = r2 / 2;
    L20:
        if (r0 <= 0) goto L23;
        r1 = r0 / 2;
    L23:
        if (this.insetBackgroundDrawable == null) goto L35;
        Rect r4 = new Rect();
        this.insetBackgroundDrawable.getPadding(r4);
        if (r4.top != r1) goto L35;
        if (r4.bottom != r1) goto L35;
        if (r4.left != r3) goto L35;
        if (r4.right != r3) goto L35;
        updateBackgroundDrawable();
        return true;
    L35:
        if (Build.VERSION.SDK_INT >= 16) goto L37;
        setMinHeight(r6);
    L43:
        setMinWidth(r6);
    L44:
        insetChipBackgroundDrawable(r3, r1, r3, r1);
        updateBackgroundDrawable();
        return true;
    L37:
        if (getMinHeight() == r6) goto L40;
        setMinHeight(r6);
    L40:
        if (getMinWidth() == r6) goto L44;
    L19:
        r3 = 0;
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
    public CharSequence getAccessibilityClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName) == true) goto L7;
        return this.accessibilityClassName;
    L7:
        if (isCheckable() == false) goto L17;
        ViewParent r2 = getParent();
        if (ZeusTransformUtils.instanceOf(r2, ChipGroup.class) == true) goto L11;
        return COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L11:
        if (((ChipGroup) ZeusTransformUtils.preCheckCast(r2, ChipGroup.class, "com.obric.memorydata.plugin")).b() == false) goto L22;
        return RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L22:
        return COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME;
    L17:
        if (isClickable() == false) goto L20;
        return BUTTON_ACCESSIBILITY_CLASS_NAME;
    L20:
        return GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable r0 = this.insetBackgroundDrawable;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.chipDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIcon();
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCheckedIconTint();
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipBackgroundColor();
    }

    public float getChipCornerRadius() {
        ChipDrawable r1 = this.chipDrawable;
        if (r1 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r1.getChipCornerRadius());
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipEndPadding();
    }

    public Drawable getChipIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIcon();
    }

    public float getChipIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipIconSize();
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipIconTint();
    }

    public float getChipMinHeight() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipMinHeight();
    }

    public float getChipStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStartPadding();
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChipStrokeColor();
    }

    public float getChipStrokeWidth() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getChipStrokeWidth();
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIcon();
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconContentDescription();
    }

    public float getCloseIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconEndPadding();
    }

    public float getCloseIconSize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconSize();
    }

    public float getCloseIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getCloseIconStartPadding();
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCloseIconTint();
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEllipsize();
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r3) {
        if (this.touchHelperEnabled == true) goto L5;
    L9:
        super.getFocusedRect(r3);
        return;
    L5:
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() != 1) goto L7;
    L8:
        r3.set(getCloseIconTouchBoundsInt());
        return;
    L7:
        if (this.touchHelper.getAccessibilityFocusedVirtualViewId() != 1) goto L9;
        goto L8
    }

    public h getHideMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHideMotionSpec();
    }

    public float getIconEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconEndPadding();
    }

    public float getIconStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getIconStartPadding();
    }

    public ColorStateList getRippleColor() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRippleColor();
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    public h getShowMotionSpec() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowMotionSpec();
    }

    public float getTextEndPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextEndPadding();
    }

    public float getTextStartPadding() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getTextStartPadding();
    }

    public boolean isCheckable() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCheckable() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCheckedIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isChipIconVisible() == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCloseIconVisible() == false) goto L7;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.a(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.a
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        if (Build.VERSION.SDK_INT < 21) goto L6;
        invalidateOutline();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 2);
        if (isChecked() == false) goto L6;
        mergeDrawableStates(r3, SELECTED_STATE);
    L6:
        if (isCheckable() == false) goto L8;
        mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L8:
        return r3;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean r2, int r3, Rect r4) {
        super.onFocusChanged(r2, r3, r4);
        if (this.touchHelperEnabled == false) goto L6;
        this.touchHelper.onFocusChanged(r2, r3, r4);
        return;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r4) {
        int r0 = r4.getActionMasked();
        if (r0 != 7) goto L5;
        boolean r1 = getCloseIconTouchBounds().contains(r4.getX(), r4.getY());
    L9:
        setCloseIconHovered(r1);
    L11:
        return super.onHoverEvent(r4);
    L5:
        if (r0 != 10) goto L11;
        r1 = false;
        goto L9
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r9) {
        super.onInitializeAccessibilityNodeInfo(r9);
        r9.setClassName(getAccessibilityClassName());
        r9.setCheckable(isCheckable());
        r9.setClickable(isClickable());
        if (ZeusTransformUtils.instanceOf(getParent(), ChipGroup.class) == false) goto L10;
        ChipGroup r0 = (ChipGroup) ZeusTransformUtils.preCheckCast(getParent(), ChipGroup.class, "com.obric.memorydata.plugin");
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.wrap(r9);
        if (r0.a() == false) goto L7;
        int r1 = r0.a(this);
    L8:
        int r2 = r0.b(this);
        r10.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r2, 1, r1, 1, false, isChecked()));
        return;
    L7:
        r1 = -1;
        goto L8
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent r2, int r3) {
        if (getCloseIconTouchBounds().contains(r2.getX(), r2.getY()) == true) goto L5;
        return null;
    L5:
        if (isEnabled() == true) goto L7;
        return null;
    L7:
        return PointerIcon.getSystemIcon((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (this.lastLayoutDirection == r2) goto L6;
        this.lastLayoutDirection = r2;
        updatePaddingInternal();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        boolean r1 = getCloseIconTouchBounds().contains(r6.getX(), r6.getY());
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L22;
    L17:
        boolean r2 = false;
    L18:
        setCloseIconPressed(false);
    L23:
        if (r2 == true) goto L27;
        if (super.onTouchEvent(r6) == true) goto L27;
        return false;
    L27:
        return true;
    L22:
        r2 = false;
        goto L23
    L11:
        if (this.closeIconPressed == false) goto L22;
        if (r1 == true) goto L21;
        setCloseIconPressed(false);
    L21:
        r2 = true;
        goto L23
    L15:
        if (this.closeIconPressed == false) goto L17;
        performCloseIconClick();
        r2 = true;
        goto L18
    L19:
        if (r1 == false) goto L22;
        setCloseIconPressed(true);
        goto L21
    }

    public boolean performCloseIconClick() {
        boolean r0 = false;
        playSoundEffect(0);
        View.OnClickListener r1 = this.onCloseIconClickListener;
        if (r1 == null) goto L6;
        r1.onClick(this);
        r0 = true;
    L6:
        if (this.touchHelperEnabled == false) goto L8;
        this.touchHelper.sendEventForVirtualView(1, 1);
    L8:
        return r0;
    }

    public void setAccessibilityClassName(CharSequence r3) {
        this.accessibilityClassName = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setBackground(Drawable r2) {
        if (r2 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackground(r2);
        return;
    L5:
        if (r2 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        Log.w(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        if (r2 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackgroundDrawable(r2);
        return;
    L5:
        if (r2 == this.ripple) goto L7;
        Log.w(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int r1) {
        Log.w(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r1) {
        Log.w(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r1) {
        Log.w(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckable(r1);
        return;
    }

    public void setCheckableResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckableResource(r1);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L6;
        this.deferredCheckedValue = r2;
        return;
    L6:
        if (r0.isCheckable() == false) goto L10;
        super.setChecked(r2);
        return;
    }

    public void setCheckedIcon(Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIcon(r1);
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r1) {
        setCheckedIconVisible(r1);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int r1) {
        setCheckedIconVisible(r1);
    }

    public void setCheckedIconResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconResource(r1);
        return;
    }

    public void setCheckedIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTint(r1);
        return;
    }

    public void setCheckedIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconTintResource(r1);
        return;
    }

    public void setCheckedIconVisible(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconVisible(r1);
        return;
    }

    public void setCheckedIconVisible(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCheckedIconVisible(r1);
        return;
    }

    public void setChipBackgroundColor(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColor(r1);
        return;
    }

    public void setChipBackgroundColorResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipBackgroundColorResource(r1);
        return;
    }

    @Deprecated
    public void setChipCornerRadius(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadius(r1);
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipCornerRadiusResource(r1);
        return;
    }

    public void setChipDrawable(ChipDrawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == r2) goto L6;
        unapplyChipDrawable(r0);
        this.chipDrawable = r2;
        r2.setShouldDrawText(false);
        applyChipDrawable(this.chipDrawable);
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        return;
    }

    public void setChipEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPadding(r1);
        return;
    }

    public void setChipEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipEndPaddingResource(r1);
        return;
    }

    public void setChipIcon(Drawable r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIcon(r1);
        return;
    }

    @Deprecated
    public void setChipIconEnabled(boolean r1) {
        setChipIconVisible(r1);
    }

    @Deprecated
    public void setChipIconEnabledResource(int r1) {
        setChipIconVisible(r1);
    }

    public void setChipIconResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconResource(r1);
        return;
    }

    public void setChipIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSize(r1);
        return;
    }

    public void setChipIconSizeResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconSizeResource(r1);
        return;
    }

    public void setChipIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTint(r1);
        return;
    }

    public void setChipIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconTintResource(r1);
        return;
    }

    public void setChipIconVisible(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconVisible(r1);
        return;
    }

    public void setChipIconVisible(boolean r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipIconVisible(r1);
        return;
    }

    public void setChipMinHeight(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeight(r1);
        return;
    }

    public void setChipMinHeightResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipMinHeightResource(r1);
        return;
    }

    public void setChipStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPadding(r1);
        return;
    }

    public void setChipStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStartPaddingResource(r1);
        return;
    }

    public void setChipStrokeColor(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColor(r1);
        return;
    }

    public void setChipStrokeColorResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeColorResource(r1);
        return;
    }

    public void setChipStrokeWidth(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidth(r1);
        return;
    }

    public void setChipStrokeWidthResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setChipStrokeWidthResource(r1);
        return;
    }

    @Deprecated
    public void setChipText(CharSequence r3) {
        setText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public void setChipTextResource(int r2) {
        setText(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2));
    }

    public void setCloseIcon(Drawable r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIcon(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        ChipDrawable r2 = this.chipDrawable;
        if (r2 == null) goto L6;
        r2.setCloseIconContentDescription(r4);
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r1) {
        setCloseIconVisible(r1);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int r1) {
        setCloseIconVisible(r1);
    }

    public void setCloseIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPadding(r1);
        return;
    }

    public void setCloseIconEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconEndPaddingResource(r1);
        return;
    }

    public void setCloseIconResource(int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconResource(r2);
    L5:
        updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSize(r1);
        return;
    }

    public void setCloseIconSizeResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconSizeResource(r1);
        return;
    }

    public void setCloseIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPadding(r1);
        return;
    }

    public void setCloseIconStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconStartPaddingResource(r1);
        return;
    }

    public void setCloseIconTint(ColorStateList r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTint(r1);
        return;
    }

    public void setCloseIconTintResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setCloseIconTintResource(r1);
        return;
    }

    public void setCloseIconVisible(int r2) {
        setCloseIconVisible(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getBoolean(r2));
    }

    public void setCloseIconVisible(boolean r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setCloseIconVisible(r2);
    L5:
        updateAccessibilityDelegate();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawables(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r3 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r3 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 != null) goto L9;
        if (r3 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r2) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (r2 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r2);
        ChipDrawable r1 = this.chipDrawable;
        if (r1 == null) goto L13;
        r1.setEllipsize(r2);
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean r1) {
        this.ensureMinTouchTargetSize = r1;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    @Override // android.widget.TextView
    public void setGravity(int r2) {
        if (r2 == 8388627) goto L5;
        Log.w(TAG, "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r2);
    }

    public void setHideMotionSpec(h r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpec(r1);
        return;
    }

    public void setHideMotionSpecResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setHideMotionSpecResource(r1);
        return;
    }

    public void setIconEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPadding(r1);
        return;
    }

    public void setIconEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconEndPaddingResource(r1);
        return;
    }

    public void setIconStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPadding(r1);
        return;
    }

    public void setIconStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setIconStartPaddingResource(r1);
        return;
    }

    @Override // com.google.android.material.internal.g
    public void setInternalOnCheckedChangeListener(g.a<Chip> r3) {
        this.onCheckedChangeListenerInternal = (g.a) ZeusTransformUtils.wrapperContextForParams(r3, g.a.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setLayoutDirection(int r3) {
        if (this.chipDrawable != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L9;
        super.setLayoutDirection(r3);
        return;
    }

    @Override // android.widget.TextView
    public void setLines(int r2) {
        if (r2 > 1) goto L7;
        super.setLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r2) {
        if (r2 > 1) goto L7;
        super.setMaxLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r1) {
        super.setMaxWidth(r1);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setMaxWidth(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r2) {
        if (r2 > 1) goto L7;
        super.setMinLines(r2);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r3) {
        this.onCheckedChangeListener = (CompoundButton.OnCheckedChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, CompoundButton.OnCheckedChangeListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnCloseIconClickListener(View.OnClickListener r3) {
        this.onCloseIconClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        updateAccessibilityDelegate();
    }

    public void setRippleColor(ColorStateList r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setRippleColor(r2);
    L6:
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    }

    public void setRippleColorResource(int r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L8;
        r0.setRippleColorResource(r2);
        if (this.chipDrawable.getUseCompatRipple() == true) goto L9;
        updateFrameworkRippleBackground();
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r1) {
        this.chipDrawable.setShapeAppearanceModel(r1);
    }

    public void setShowMotionSpec(h r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpec(r1);
        return;
    }

    public void setShowMotionSpecResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setShowMotionSpecResource(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r1) {
        if (r1 == false) goto L6;
        super.setSingleLine(r1);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        ChipDrawable r0 = this.chipDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        if (r0.shouldDrawText() == false) goto L10;
        CharSequence r1 = null;
    L11:
        super.setText(r1, r4);
        ChipDrawable r2 = this.chipDrawable;
        if (r2 == null) goto L15;
        r2.setText(r5);
        return;
    L15:
        return;
    L10:
        r1 = r5;
        goto L11
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r2) {
        super.setTextAppearance(r2);
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearanceResource(r2);
    L5:
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        super.setTextAppearance((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        ChipDrawable r5 = this.chipDrawable;
        if (r5 == null) goto L5;
        r5.setTextAppearanceResource(r4);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearance(d r2) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L5;
        r0.setTextAppearance(r2);
    L5:
        updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int r4) {
        setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public void setTextEndPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPadding(r1);
        return;
    }

    public void setTextEndPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextEndPaddingResource(r1);
        return;
    }

    public void setTextStartPadding(float r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPadding(r1);
        return;
    }

    public void setTextStartPaddingResource(int r1) {
        ChipDrawable r0 = this.chipDrawable;
        if (r0 == null) goto L6;
        r0.setTextStartPaddingResource(r1);
        return;
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }
}
