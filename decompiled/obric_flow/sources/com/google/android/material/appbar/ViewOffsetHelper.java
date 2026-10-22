package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetHelper {
    private boolean horizontalOffsetEnabled;
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private boolean verticalOffsetEnabled;
    private final View view;

    public ViewOffsetHelper(View r5) {
        this.verticalOffsetEnabled = true;
        this.horizontalOffsetEnabled = true;
        this.view = r5;
    }

    public void applyOffsets() {
        View r5 = this.view;
        ViewCompat.offsetTopAndBottom(r5, this.offsetTop - (r5.getTop() - this.layoutTop));
        View r10 = this.view;
        ViewCompat.offsetLeftAndRight(r10, this.offsetLeft - (r10.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean r5) {
        this.horizontalOffsetEnabled = r5;
    }

    public boolean setLeftAndRightOffset(int r5) {
        if (this.horizontalOffsetEnabled == true) goto L5;
        return false;
    L5:
        if (this.offsetLeft == r5) goto L10;
        this.offsetLeft = r5;
        applyOffsets();
        return true;
    L10:
        return false;
    }

    public boolean setTopAndBottomOffset(int r5) {
        if (this.verticalOffsetEnabled == true) goto L5;
        return false;
    L5:
        if (this.offsetTop == r5) goto L10;
        this.offsetTop = r5;
        applyOffsets();
        return true;
    L10:
        return false;
    }

    public void setVerticalOffsetEnabled(boolean r5) {
        this.verticalOffsetEnabled = r5;
    }
}
