package com.google.android.material.shape;

import android.graphics.RectF;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(22)
class ShapeableDelegateV22 extends ShapeableDelegate {
    private boolean canUseViewOutline;
    private float cornerRadius;

    public ShapeableDelegateV22(@NonNull View r5) {
        this.canUseViewOutline = false;
        this.cornerRadius = 0.0f;
        initMaskOutlineProvider(r5);
    }

    public static /* synthetic */ float access$000(ShapeableDelegateV22 r5) {
        return r5.cornerRadius;
    }

    private float getDefaultCornerRadius() {
        ShapeAppearanceModel r5 = this.shapeAppearanceModel;
        if (r5 == null) goto L9;
        RectF r10 = this.maskBounds;
        if (r10 != null) goto L8;
        return 0.0f;
    L8:
        return r5.topRightCornerSize.getCornerSize(r10);
    L9:
        return 0.0f;
    }

    @DoNotInline
    private void initMaskOutlineProvider(View r5) {
        r5.setOutlineProvider(new AnonymousClass1(this));
    }

    private boolean isShapeRoundRect() {
        if (this.maskBounds.isEmpty() == true) goto L9;
        ShapeAppearanceModel r5 = this.shapeAppearanceModel;
        if (r5 != null) goto L8;
        return false;
    L8:
        return r5.isRoundRect(this.maskBounds);
    L9:
        return false;
    }

    private boolean offsetZeroCornerEdgeBoundsIfPossible() {
        if (this.maskBounds.isEmpty() == true) goto L42;
        ShapeAppearanceModel r5 = this.shapeAppearanceModel;
        if (r5 == null) goto L42;
        if (this.offsetZeroCornerEdgeBoundsEnabled == false) goto L42;
        if (r5.isRoundRect(this.maskBounds) == true) goto L42;
        if (shapeUsesAllRoundedCornerTreatments(this.shapeAppearanceModel) == false) goto L42;
        float r10 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.maskBounds);
        float r11 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.maskBounds);
        float r12 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.maskBounds);
        float r13 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.maskBounds);
        if (r10 == 0.0f) goto L16;
    L20:
        if (r10 != 0.0f) goto L27;
        if (r11 != 0.0f) goto L27;
        if (r12 != r13) goto L27;
        RectF r14 = this.maskBounds;
        r14.set(r14.left, r14.top - r12, r14.right, r14.bottom);
        this.cornerRadius = r12;
        return true;
    L27:
        if (r11 != 0.0f) goto L34;
        if (r13 != 0.0f) goto L34;
        if (r10 != r12) goto L34;
        RectF r15 = this.maskBounds;
        r15.set(r15.left, r15.top, r15.right + r10, r15.bottom);
        this.cornerRadius = r10;
        return true;
    L34:
        if (r12 != 0.0f) goto L42;
        if (r13 != 0.0f) goto L42;
        if (r10 != r11) goto L42;
        RectF r16 = this.maskBounds;
        r16.set(r16.left, r16.top, r16.right, r16.bottom + r10);
        this.cornerRadius = r10;
        return true;
    L16:
        if (r12 != 0.0f) goto L20;
        if (r11 != r13) goto L20;
        RectF r17 = this.maskBounds;
        r17.set(r17.left - r11, r17.top, r17.right, r17.bottom);
        this.cornerRadius = r11;
        return true;
    L42:
        return false;
    }

    private static boolean shapeUsesAllRoundedCornerTreatments(ShapeAppearanceModel r5) {
        if ((r5.getTopLeftCorner() instanceof RoundedCornerTreatment) == true) goto L5;
    L11:
        return false;
    L5:
        if ((r5.getTopRightCorner() instanceof RoundedCornerTreatment) == false) goto L11;
        if ((r5.getBottomLeftCorner() instanceof RoundedCornerTreatment) == false) goto L11;
        if ((r5.getBottomRightCorner() instanceof RoundedCornerTreatment) == false) goto L11;
        return true;
    }

    @VisibleForTesting
    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public void invalidateClippingMethod(@NonNull View r5) {
        this.cornerRadius = getDefaultCornerRadius();
        if (isShapeRoundRect() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        this.canUseViewOutline = r10;
        r5.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping() == false) goto L12;
        r5.invalidate();
        return;
    L12:
        r5.invalidateOutline();
        return;
    L5:
        if (offsetZeroCornerEdgeBoundsIfPossible() == true) goto L8;
        r10 = false;
        goto L9
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public boolean shouldUseCompatClipping() {
        if (this.canUseViewOutline == true) goto L5;
    L8:
        return true;
    L5:
        if (this.forceCompatClippingEnabled == true) goto L8;
        return false;
    }
}
