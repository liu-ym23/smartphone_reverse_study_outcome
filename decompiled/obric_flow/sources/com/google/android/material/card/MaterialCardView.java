package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = null;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DRAGGED_STATE_SET = null;
    private static final String LOG_TAG = "MaterialCardView";

    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView r5, boolean r10);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DRAGGED_STATE_SET = new int[]{com.google.android.material.R.attr.state_dragged};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CardView;
    }

    public MaterialCardView(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ float access$001(MaterialCardView r5) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        this.cardViewHelper.forceRippleRedraw();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF r5 = new RectF();
        r5.set(this.cardViewHelper.getBackground().getBounds());
        return r5;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    public float getCardViewRadius() {
        return access$001(this);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.getCheckedIconGravity();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.getCheckedIconMargin();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.getCheckedIconSize();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper r5 = this.cardViewHelper;
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

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.cardViewHelper.updateClickable();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 3);
        if (isCheckable() == false) goto L6;
        View.mergeDrawableStates(r10, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L9;
        View.mergeDrawableStates(r10, CHECKED_STATE_SET);
    L9:
        if (isDragged() == false) goto L11;
        View.mergeDrawableStates(r10, DRAGGED_STATE_SET);
    L11:
        return r10;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(ACCESSIBILITY_CLASS_NAME);
        r5.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(ACCESSIBILITY_CLASS_NAME);
        r5.setCheckable(isCheckable());
        r5.setClickable(isClickable());
        r5.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        this.cardViewHelper.recalculateCheckedIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAncestorContentPadding(int r5, int r10, int r11, int r12) {
        super.setContentPadding(r5, r10, r11, r12);
    }

    @Override // android.view.View
    public void setBackground(Drawable r5) {
        setBackgroundDrawable(r5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        if (this.isParentCardViewDoneInitializing == true) goto L5;
        return;
    L5:
        if (this.cardViewHelper.isBackgroundOverwritten() == true) goto L7;
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
        this.cardViewHelper.setBackgroundOverwritten(true);
    L7:
        super.setBackgroundDrawable(r5);
    }

    public void setBackgroundInternal(Drawable r5) {
        super.setBackgroundDrawable(r5);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int r5) {
        this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(r5));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r5) {
        super.setCardElevation(r5);
        this.cardViewHelper.updateElevation();
    }

    public void setCardForegroundColor(@Nullable ColorStateList r5) {
        this.cardViewHelper.setCardForegroundColor(r5);
    }

    public void setCheckable(boolean r5) {
        this.cardViewHelper.setCheckable(r5);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        if (this.checked == r5) goto L6;
        toggle();
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r5) {
        this.cardViewHelper.setCheckedIcon(r5);
    }

    public void setCheckedIconGravity(int r5) {
        if (this.cardViewHelper.getCheckedIconGravity() == r5) goto L6;
        this.cardViewHelper.setCheckedIconGravity(r5);
        return;
    }

    public void setCheckedIconMargin(@Dimension int r5) {
        this.cardViewHelper.setCheckedIconMargin(r5);
    }

    public void setCheckedIconMarginResource(@DimenRes int r5) {
        if (r5 == (-1)) goto L6;
        this.cardViewHelper.setCheckedIconMargin(getResources().getDimensionPixelSize(r5));
        return;
    }

    public void setCheckedIconResource(@DrawableRes int r5) {
        this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setCheckedIconSize(@Dimension int r5) {
        this.cardViewHelper.setCheckedIconSize(r5);
    }

    public void setCheckedIconSizeResource(@DimenRes int r5) {
        if (r5 == 0) goto L5;
        this.cardViewHelper.setCheckedIconSize(getResources().getDimensionPixelSize(r5));
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r5) {
        this.cardViewHelper.setCheckedIconTint(r5);
    }

    @Override // android.view.View
    public void setClickable(boolean r5) {
        super.setClickable(r5);
        MaterialCardViewHelper r10 = this.cardViewHelper;
        if (r10 == null) goto L6;
        r10.updateClickable();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int r5, int r10, int r11, int r12) {
        this.cardViewHelper.setUserContentPadding(r5, r10, r11, r12);
    }

    public void setDragged(boolean r5) {
        if (this.dragged == r5) goto L6;
        this.dragged = r5;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r5) {
        super.setMaxCardElevation(r5);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener r5) {
        this.onCheckedChangeListener = r5;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r5) {
        super.setPreventCornerOverlap(r5);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.cardViewHelper.setProgress(r5);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r5) {
        super.setRadius(r5);
        this.cardViewHelper.setCornerRadius(r5);
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        this.cardViewHelper.setRippleColor(r5);
    }

    public void setRippleColorResource(@ColorRes int r5) {
        this.cardViewHelper.setRippleColor(AppCompatResources.getColorStateList(getContext(), r5));
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        setClipToOutline(r5.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(r5);
    }

    public void setStrokeColor(@ColorInt int r5) {
        setStrokeColor(ColorStateList.valueOf(r5));
    }

    public void setStrokeWidth(@Dimension int r5) {
        this.cardViewHelper.setStrokeWidth(r5);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r5) {
        super.setUseCompatPadding(r5);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() == true) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L11;
        this.checked = !this.checked;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        this.cardViewHelper.setChecked(this.checked, true);
        OnCheckedChangeListener r5 = this.onCheckedChangeListener;
        if (r5 == null) goto L12;
        r5.onCheckedChanged(this, this.checked);
        return;
    L12:
        return;
    }

    public MaterialCardView(Context r5, AttributeSet r10) {
        this(r5, r10, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList r5) {
        this.cardViewHelper.setCardBackgroundColor(r5);
    }

    public void setStrokeColor(ColorStateList r5) {
        this.cardViewHelper.setStrokeColor(r5);
        invalidate();
    }

    public MaterialCardView(Context r10, AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(getContext(), r11, com.google.android.material.R.styleable.MaterialCardView, r12, r13, new int[0]);
        MaterialCardViewHelper r5 = new MaterialCardViewHelper(this, r11, r12, r13);
        this.cardViewHelper = r5;
        r5.setCardBackgroundColor(super.getCardBackgroundColor());
        r5.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        r5.loadFromAttributes(r14);
        r14.recycle();
    }
}
