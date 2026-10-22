package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.canvas.CanvasCompat;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ShapeableDelegate {
    boolean forceCompatClippingEnabled;
    RectF maskBounds;
    boolean offsetZeroCornerEdgeBoundsEnabled;

    @Nullable
    ShapeAppearanceModel shapeAppearanceModel;
    final Path shapePath;

    public ShapeableDelegate() {
        this.forceCompatClippingEnabled = false;
        this.offsetZeroCornerEdgeBoundsEnabled = false;
        this.maskBounds = new RectF();
        this.shapePath = new Path();
    }

    @NonNull
    public static ShapeableDelegate create(@NonNull View r5) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return new ShapeableDelegateV33(r5);
    L7:
        return new ShapeableDelegateV22(r5);
    }

    private boolean isMaskBoundsValid() {
        RectF r5 = this.maskBounds;
        if (r5.left <= r5.right) goto L5;
    L7:
        return false;
    L5:
        if (r5.top > r5.bottom) goto L7;
        return true;
    }

    private void updateShapePath() {
        if (isMaskBoundsValid() == true) goto L5;
        return;
    L5:
        if (this.shapeAppearanceModel == null) goto L9;
        ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
        return;
    }

    public abstract void invalidateClippingMethod(@NonNull View r5);

    public boolean isForceCompatClippingEnabled() {
        return this.forceCompatClippingEnabled;
    }

    public void maybeClip(@NonNull Canvas r5, @NonNull CanvasCompat.CanvasOperation r10) {
        if (shouldUseCompatClipping() == true) goto L5;
    L7:
        r10.run(r5);
        return;
    L5:
        if (this.shapePath.isEmpty() == true) goto L7;
        r5.save();
        r5.clipPath(this.shapePath);
        r10.run(r5);
        r5.restore();
    }

    public void onMaskChanged(@NonNull View r5, @NonNull RectF r10) {
        this.maskBounds = r10;
        updateShapePath();
        invalidateClippingMethod(r5);
    }

    public void onShapeAppearanceChanged(@NonNull View r5, @NonNull ShapeAppearanceModel r10) {
        this.shapeAppearanceModel = r10;
        updateShapePath();
        invalidateClippingMethod(r5);
    }

    public void setForceCompatClippingEnabled(@NonNull View r5, boolean r10) {
        if (r10 == this.forceCompatClippingEnabled) goto L6;
        this.forceCompatClippingEnabled = r10;
        invalidateClippingMethod(r5);
        return;
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(@NonNull View r5, boolean r10) {
        this.offsetZeroCornerEdgeBoundsEnabled = r10;
        invalidateClippingMethod(r5);
    }

    public abstract boolean shouldUseCompatClipping();
}
