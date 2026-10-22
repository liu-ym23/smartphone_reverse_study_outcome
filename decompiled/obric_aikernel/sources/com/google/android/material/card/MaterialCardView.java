package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
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
import com.google.android.material.shape.h;
import com.google.android.material.shape.p;
import q5.b;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, p {
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
    private final com.google.android.material.card.a cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private a onCheckedChangeListener;

    public interface a {
        void a(MaterialCardView r10, boolean r11);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DRAGGED_STATE_SET = new int[]{b.state_dragged};
        DEF_STYLE_RES = k.Widget_MaterialComponents_CardView;
    }

    public MaterialCardView(Context r10) {
        this(r10, null);
    }

    public MaterialCardView(Context r10, AttributeSet r11) {
        this(r10, r11, b.materialCardViewStyle);
    }

    public MaterialCardView(Context r10, AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray r14 = com.google.android.material.internal.k.h(getContext(), r11, l.MaterialCardView, r12, r13, new int[0]);
        com.google.android.material.card.a r15 = new com.google.android.material.card.a(this, r11, r12, r13);
        this.cardViewHelper = r15;
        r15.J(super.getCardBackgroundColor());
        r15.Y(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        r15.G(r14);
        r14.recycle();
    }

    static /* synthetic */ float access$001(MaterialCardView r10) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        this.cardViewHelper.i();
        return;
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF r10 = new RectF();
        r10.set(this.cardViewHelper.j().getBounds());
        return r10;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.k();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.l();
    }

    float getCardViewRadius() {
        return access$001(this);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.m();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.n();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.o();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.p();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.A().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.s();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.v();
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public com.google.android.material.shape.l getShapeAppearanceModel() {
        return this.cardViewHelper.w();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.x();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.y();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.z();
    }

    public boolean isCheckable() {
        com.google.android.material.card.a r10 = this.cardViewHelper;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.D() == false) goto L7;
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.cardViewHelper.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 3);
        if (isCheckable() == false) goto L6;
        FrameLayout.mergeDrawableStates(r11, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L9;
        FrameLayout.mergeDrawableStates(r11, CHECKED_STATE_SET);
    L9:
        if (isDragged() == false) goto L11;
        FrameLayout.mergeDrawableStates(r11, DRAGGED_STATE_SET);
    L11:
        return r11;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        r10.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(ACCESSIBILITY_CLASS_NAME);
        r10.setCheckable(isCheckable());
        r10.setClickable(isClickable());
        r10.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.cardViewHelper.H(getMeasuredWidth(), getMeasuredHeight());
    }

    void setAncestorContentPadding(int r10, int r11, int r12, int r13) {
        super.setContentPadding(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public void setBackground(Drawable r10) {
        setBackgroundDrawable(r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r10) {
        if (this.isParentCardViewDoneInitializing == true) goto L5;
        return;
    L5:
        if (this.cardViewHelper.C() == true) goto L7;
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
        this.cardViewHelper.I(true);
    L7:
        super.setBackgroundDrawable(r10);
    }

    void setBackgroundInternal(Drawable r10) {
        super.setBackgroundDrawable(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int r10) {
        this.cardViewHelper.J(ColorStateList.valueOf(r10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.J(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r10) {
        super.setCardElevation(r10);
        this.cardViewHelper.d0();
    }

    public void setCardForegroundColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.K(r10);
    }

    public void setCheckable(boolean r10) {
        this.cardViewHelper.L(r10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.checked == r10) goto L6;
        toggle();
        return;
    }

    public void setCheckedIcon(@Nullable Drawable r10) {
        this.cardViewHelper.N(r10);
    }

    public void setCheckedIconGravity(int r10) {
        if (this.cardViewHelper.n() == r10) goto L6;
        this.cardViewHelper.O(r10);
        return;
    }

    public void setCheckedIconMargin(@Dimension int r10) {
        this.cardViewHelper.P(r10);
    }

    public void setCheckedIconMarginResource(@DimenRes int r10) {
        if (r10 == (-1)) goto L6;
        this.cardViewHelper.P(getResources().getDimensionPixelSize(r10));
        return;
    }

    public void setCheckedIconResource(@DrawableRes int r10) {
        this.cardViewHelper.N(AppCompatResources.getDrawable(getContext(), r10));
    }

    public void setCheckedIconSize(@Dimension int r10) {
        this.cardViewHelper.Q(r10);
    }

    public void setCheckedIconSizeResource(@DimenRes int r10) {
        if (r10 == 0) goto L5;
        this.cardViewHelper.Q(getResources().getDimensionPixelSize(r10));
        return;
    }

    public void setCheckedIconTint(@Nullable ColorStateList r10) {
        this.cardViewHelper.R(r10);
    }

    @Override // android.view.View
    public void setClickable(boolean r10) {
        super.setClickable(r10);
        com.google.android.material.card.a r11 = this.cardViewHelper;
        if (r11 == null) goto L6;
        r11.b0();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int r10, int r11, int r12, int r13) {
        this.cardViewHelper.Y(r10, r11, r12, r13);
    }

    public void setDragged(boolean r10) {
        if (this.dragged == r10) goto L6;
        this.dragged = r10;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r10) {
        super.setMaxCardElevation(r10);
        this.cardViewHelper.f0();
    }

    public void setOnCheckedChangeListener(@Nullable a r10) {
        this.onCheckedChangeListener = r10;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r10) {
        super.setPreventCornerOverlap(r10);
        this.cardViewHelper.f0();
        this.cardViewHelper.c0();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.cardViewHelper.T(r10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r10) {
        super.setRadius(r10);
        this.cardViewHelper.S(r10);
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        this.cardViewHelper.U(r10);
    }

    public void setRippleColorResource(@ColorRes int r10) {
        this.cardViewHelper.U(AppCompatResources.getColorStateList(getContext(), r10));
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull com.google.android.material.shape.l r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        setClipToOutline(r10.u(getBoundsAsRectF()));
    L5:
        this.cardViewHelper.V(r10);
    }

    public void setStrokeColor(@ColorInt int r10) {
        setStrokeColor(ColorStateList.valueOf(r10));
    }

    public void setStrokeColor(ColorStateList r10) {
        this.cardViewHelper.W(r10);
        invalidate();
    }

    public void setStrokeWidth(@Dimension int r10) {
        this.cardViewHelper.X(r10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r10) {
        super.setUseCompatPadding(r10);
        this.cardViewHelper.f0();
        this.cardViewHelper.c0();
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
        this.cardViewHelper.M(this.checked);
        a r10 = this.onCheckedChangeListener;
        if (r10 == null) goto L12;
        r10.a(this, this.checked);
        return;
    L12:
        return;
    }
}
