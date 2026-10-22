package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.core.view.inputmethod.a;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

/* JADX INFO: loaded from: classes2.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private static final int NOT_SET = -1;
    private final RectF maskRect;
    private float maskXPercentage;

    @Nullable
    private OnMaskChangedListener onMaskChangedListener;

    @Nullable
    private Boolean savedForceCompatClippingEnabled;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;
    private final ShapeableDelegate shapeableDelegate;

    public MaskableFrameLayout(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ CornerSize a(CornerSize r5) {
        return lambda$setShapeAppearanceModel$0(r5);
    }

    public static /* synthetic */ void b(MaskableFrameLayout r5, Canvas r10) {
        r5.lambda$dispatchDraw$1(r10);
    }

    private /* synthetic */ void lambda$dispatchDraw$1(Canvas r5) {
        super.dispatchDraw(r5);
    }

    private static /* synthetic */ CornerSize lambda$setShapeAppearanceModel$0(CornerSize r5) {
        if ((r5 instanceof AbsoluteCornerSize) == true) goto L5;
        return r5;
    L5:
        return ClampedCornerSize.createFromCornerSize((AbsoluteCornerSize) r5);
    }

    private void onMaskChanged() {
        this.shapeableDelegate.onMaskChanged(this, this.maskRect);
        OnMaskChangedListener r5 = this.onMaskChangedListener;
        if (r5 == null) goto L6;
        r5.onMaskChanged(this.maskRect);
        return;
    }

    private void updateMaskRectForMaskXPercentage() {
        if (this.maskXPercentage == (-1.0f)) goto L6;
        float r5 = AnimationUtils.lerp(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.maskXPercentage);
        setMaskRectF(new RectF(r5, 0.0f, getWidth() - r5, getHeight()));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        this.shapeableDelegate.maybeClip(r5, new a(this, 4));
    }

    @Override // android.view.View
    public void getFocusedRect(Rect r5) {
        RectF r10 = this.maskRect;
        r5.set((int) r10.left, (int) r10.top, (int) r10.right, (int) r10.bottom);
    }

    @Override // com.google.android.material.carousel.Maskable
    @NonNull
    public RectF getMaskRectF() {
        return this.maskRect;
    }

    @Override // com.google.android.material.carousel.Maskable
    @Deprecated
    public float getMaskXPercentage() {
        return this.maskXPercentage;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean r5 = this.savedForceCompatClippingEnabled;
        if (r5 == null) goto L6;
        this.shapeableDelegate.setForceCompatClippingEnabled(this, r5.booleanValue());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.savedForceCompatClippingEnabled = Boolean.valueOf(this.shapeableDelegate.isForceCompatClippingEnabled());
        this.shapeableDelegate.setForceCompatClippingEnabled(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (this.maskXPercentage == (-1.0f)) goto L6;
        updateMaskRectForMaskXPercentage();
        return;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r5) {
        if (this.maskRect.isEmpty() == true) goto L11;
        if (r5.getAction() != 0) goto L11;
        float r10 = r5.getX();
        float r11 = r5.getY();
        if (this.maskRect.contains(r10, r11) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setForceCompatClipping(boolean r5) {
        this.shapeableDelegate.setForceCompatClippingEnabled(this, r5);
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskRectF(@NonNull RectF r5) {
        this.maskRect.set(r5);
        onMaskChanged();
    }

    @Override // com.google.android.material.carousel.Maskable
    @Deprecated
    public void setMaskXPercentage(float r5) {
        float r10 = MathUtils.clamp(r5, 0.0f, 1.0f);
        if (this.maskXPercentage == r10) goto L6;
        this.maskXPercentage = r10;
        updateMaskRectForMaskXPercentage();
        return;
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setOnMaskChangedListener(@Nullable OnMaskChangedListener r5) {
        this.onMaskChangedListener = r5;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        ShapeAppearanceModel r10 = r5.withTransformedCornerSizes(new com.bytedance.ai.resource.core.net.a(3));
        this.shapeAppearanceModel = r10;
        this.shapeableDelegate.onShapeAppearanceChanged(this, r10);
    }

    public MaskableFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public MaskableFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.maskXPercentage = -1.0f;
        this.maskRect = new RectF();
        this.shapeableDelegate = ShapeableDelegate.create(this);
        this.savedForceCompatClippingEnabled = null;
        setShapeAppearanceModel(ShapeAppearanceModel.builder(r5, r10, r11, 0, 0).build());
    }
}
