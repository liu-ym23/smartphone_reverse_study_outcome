package com.google.android.material.shape;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class ShapeableDelegateV14 extends ShapeableDelegate {
    public ShapeableDelegateV14() {
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public void invalidateClippingMethod(@NonNull View r5) {
        if (this.shapeAppearanceModel != null) goto L5;
        return;
    L5:
        if (this.maskBounds.isEmpty() == false) goto L8;
        return;
    L8:
        if (shouldUseCompatClipping() == false) goto L12;
        r5.invalidate();
        return;
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public boolean shouldUseCompatClipping() {
        return true;
    }
}
