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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.k;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
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
    private final com.google.android.material.card.a cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private a onCheckedChangeListener;

    public interface a {
        void a(MaterialCardView r1, boolean r2);
    }

    static {
        CHECKABLE_STATE_SET = new int[]{R.attr.state_checkable};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DRAGGED_STATE_SET = new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.state_dragged, "attr", "state_dragged")};
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.Widget_MaterialComponents_CardView, "style", "Widget_MaterialComponents_CardView");
    }

    public MaterialCardView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialCardView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.materialCardViewStyle, "attr", "materialCardViewStyle"));
    }

    public MaterialCardView(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r13, r11, r0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13, r11);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray r14 = k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13, com.obric.memorydata.plugin.R.styleable.MaterialCardView, r11, r0, new int[0]);
        com.google.android.material.card.a r1 = new com.google.android.material.card.a(this, r13, r11, r0);
        this.cardViewHelper = r1;
        r1.b(super.getCardBackgroundColor());
        r1.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        r1.a(r14);
        r14.recycle();
    }

    static /* synthetic */ float access$001(MaterialCardView r0) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        this.cardViewHelper.v();
        return;
    }

    private RectF getBoundsAsRectF() {
        RectF r0 = new RectF();
        r0.set(this.cardViewHelper.e().getBounds());
        return r0;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.f();
    }

    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.g();
    }

    float getCardViewRadius() {
        return access$001(this);
    }

    public Drawable getCheckedIcon() {
        return this.cardViewHelper.s();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.x();
    }

    public int getCheckedIconMargin() {
        return this.cardViewHelper.u();
    }

    public int getCheckedIconSize() {
        return this.cardViewHelper.t();
    }

    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.h().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.h().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.h().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.h().top;
    }

    public float getProgress() {
        return this.cardViewHelper.k();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.j();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.r();
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        return this.cardViewHelper.w();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.b();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.c();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.d();
    }

    public boolean isCheckable() {
        com.google.android.material.card.a r0 = this.cardViewHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.p() == false) goto L7;
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
        h.a(this, this.cardViewHelper.e());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 3);
        if (isCheckable() == false) goto L6;
        mergeDrawableStates(r3, CHECKABLE_STATE_SET);
    L6:
        if (isChecked() == false) goto L9;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
    L9:
        if (isDragged() == false) goto L11;
        mergeDrawableStates(r3, DRAGGED_STATE_SET);
    L11:
        return r3;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        r2.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        r2.setCheckable(isCheckable());
        r2.setClickable(isClickable());
        r2.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.cardViewHelper.a(getMeasuredWidth(), getMeasuredHeight());
    }

    void setAncestorContentPadding(int r1, int r2, int r3, int r4) {
        super.setContentPadding(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        setBackgroundDrawable(r1);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        if (this.isParentCardViewDoneInitializing == true) goto L5;
        return;
    L5:
        if (this.cardViewHelper.a() == true) goto L7;
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
        this.cardViewHelper.a(true);
    L7:
        super.setBackgroundDrawable(r3);
    }

    void setBackgroundInternal(Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int r1) {
        this.cardViewHelper.b(ColorStateList.valueOf(r1));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList r1) {
        this.cardViewHelper.b(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float r1) {
        super.setCardElevation(r1);
        this.cardViewHelper.l();
    }

    public void setCardForegroundColor(ColorStateList r1) {
        this.cardViewHelper.c(r1);
    }

    public void setCheckable(boolean r1) {
        this.cardViewHelper.b(r1);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.checked == r2) goto L6;
        toggle();
        return;
    }

    public void setCheckedIcon(Drawable r1) {
        this.cardViewHelper.a(r1);
    }

    public void setCheckedIconGravity(int r2) {
        if (this.cardViewHelper.x() == r2) goto L6;
        this.cardViewHelper.d(r2);
        return;
    }

    public void setCheckedIconMargin(int r1) {
        this.cardViewHelper.c(r1);
    }

    public void setCheckedIconMarginResource(int r3) {
        if (r3 == (-1)) goto L6;
        this.cardViewHelper.c(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3));
        return;
    }

    public void setCheckedIconResource(int r4) {
        this.cardViewHelper.a(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setCheckedIconSize(int r1) {
        this.cardViewHelper.b(r1);
    }

    public void setCheckedIconSizeResource(int r3) {
        if (r3 == 0) goto L5;
        this.cardViewHelper.b(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3));
        return;
    }

    public void setCheckedIconTint(ColorStateList r1) {
        this.cardViewHelper.e(r1);
    }

    @Override // android.view.View
    public void setClickable(boolean r1) {
        super.setClickable(r1);
        com.google.android.material.card.a r0 = this.cardViewHelper;
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int r1, int r2, int r3, int r4) {
        this.cardViewHelper.a(r1, r2, r3, r4);
    }

    public void setDragged(boolean r2) {
        if (this.dragged == r2) goto L6;
        this.dragged = r2;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
        return;
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float r1) {
        super.setMaxCardElevation(r1);
        this.cardViewHelper.m();
    }

    public void setOnCheckedChangeListener(a r3) {
        this.onCheckedChangeListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean r1) {
        super.setPreventCornerOverlap(r1);
        this.cardViewHelper.m();
        this.cardViewHelper.o();
    }

    public void setProgress(float r1) {
        this.cardViewHelper.b(r1);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r1) {
        super.setRadius(r1);
        this.cardViewHelper.a(r1);
    }

    public void setRippleColor(ColorStateList r1) {
        this.cardViewHelper.d(r1);
    }

    public void setRippleColorResource(int r4) {
        this.cardViewHelper.d(AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        setClipToOutline(r3.a(getBoundsAsRectF()));
    L5:
        this.cardViewHelper.a(r3);
    }

    public void setStrokeColor(int r1) {
        setStrokeColor(ColorStateList.valueOf(r1));
    }

    public void setStrokeColor(ColorStateList r2) {
        this.cardViewHelper.a(r2);
        invalidate();
    }

    public void setStrokeWidth(int r2) {
        this.cardViewHelper.a(r2);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean r1) {
        super.setUseCompatPadding(r1);
        this.cardViewHelper.m();
        this.cardViewHelper.o();
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
        this.cardViewHelper.c(this.checked);
        a r0 = this.onCheckedChangeListener;
        if (r0 == null) goto L12;
        r0.a(this, this.checked);
        return;
    L12:
        return;
    }
}
