package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View r5, MaterialShapeDrawable r10, ScrollView r11) {
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new AnonymousClass1(this);
        this.shapedView = r5;
        this.materialShapeDrawable = r10;
        this.containingScrollView = r11;
    }

    public void setContainingScrollView(ScrollView r5) {
        this.containingScrollView = r5;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable r5) {
        this.materialShapeDrawable = r5;
    }

    public void startListeningForScrollChanges(@NonNull ViewTreeObserver r5) {
        r5.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(@NonNull ViewTreeObserver r5) {
        r5.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView r5 = this.containingScrollView;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getChildCount() == 0) goto L18;
        this.containingScrollView.getLocationInWindow(this.scrollLocation);
        this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
        int r10 = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
        int r11 = this.shapedView.getHeight();
        int r12 = this.containingScrollView.getHeight();
        if (r10 >= 0) goto L10;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (r10 / r11) + 1.0f)));
        this.shapedView.invalidate();
        return;
    L10:
        int r13 = r10 + r11;
        if (r13 <= r12) goto L14;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r13 - r12) / r11))));
        this.shapedView.invalidate();
        return;
    L14:
        if (this.materialShapeDrawable.getInterpolation() == 1.0f) goto L21;
        this.materialShapeDrawable.setInterpolation(1.0f);
        this.shapedView.invalidate();
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
