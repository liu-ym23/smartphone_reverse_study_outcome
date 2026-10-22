package com.google.android.material.shape;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
class ShapeableDelegateV33 extends ShapeableDelegate {
    public ShapeableDelegateV33(@NonNull View r5) {
        initMaskOutlineProvider(r5);
    }

    @DoNotInline
    private void initMaskOutlineProvider(View r5) {
        r5.setOutlineProvider(new AnonymousClass1(this));
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public void invalidateClippingMethod(@NonNull View r5) {
        r5.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping() == false) goto L5;
        r5.invalidate();
        return;
    L5:
        r5.invalidateOutline();
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public boolean shouldUseCompatClipping() {
        return this.forceCompatClippingEnabled;
    }
}
