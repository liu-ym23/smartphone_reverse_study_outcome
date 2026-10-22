package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ExpandableWidgetHelper {
    private boolean expanded;

    @IdRes
    private int expandedComponentIdHint;

    @NonNull
    private final View widget;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(ExpandableWidget r5) {
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = (View) r5;
    }

    private void dispatchExpandedStateChanged() {
        ViewParent r5 = this.widget.getParent();
        if ((r5 instanceof CoordinatorLayout) == false) goto L6;
        ((CoordinatorLayout) r5).dispatchDependentViewsChanged(this.widget);
        return;
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(@NonNull Bundle r5) {
        this.expanded = r5.getBoolean("expanded", false);
        this.expandedComponentIdHint = r5.getInt("expandedComponentIdHint", 0);
        if (this.expanded == false) goto L6;
        dispatchExpandedStateChanged();
        return;
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle r5 = new Bundle();
        r5.putBoolean("expanded", this.expanded);
        r5.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return r5;
    }

    public boolean setExpanded(boolean r5) {
        if (this.expanded == r5) goto L6;
        this.expanded = r5;
        dispatchExpandedStateChanged();
        return true;
    L6:
        return false;
    }

    public void setExpandedComponentIdHint(@IdRes int r5) {
        this.expandedComponentIdHint = r5;
    }
}
