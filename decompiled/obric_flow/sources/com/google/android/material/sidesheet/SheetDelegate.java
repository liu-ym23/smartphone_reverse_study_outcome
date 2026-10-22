package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
abstract class SheetDelegate {
    public SheetDelegate() {
    }

    public abstract int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams r5);

    public abstract float calculateSlideOffset(int r5);

    public abstract int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams r5);

    public abstract int getExpandedOffset();

    public abstract int getHiddenOffset();

    public abstract int getMaxViewPositionHorizontal();

    public abstract int getMinViewPositionHorizontal();

    public abstract <V extends View> int getOuterEdge(@NonNull V r5);

    public abstract int getParentInnerEdge(@NonNull CoordinatorLayout r5);

    public abstract int getSheetEdge();

    public abstract boolean isExpandingOutwards(float r5);

    public abstract boolean isReleasedCloseToInnerEdge(@NonNull View r5);

    public abstract boolean isSwipeSignificant(float r5, float r10);

    public abstract boolean shouldHide(@NonNull View r5, float r10);

    public abstract void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams r5, int r10);

    public abstract void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams r5, int r10, int r11);
}
