package com.larus.common_ui.photoviewer.circular;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010!\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/common_ui/photoviewer/circular/CircularLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "isLooperEnabled", "", "()Z", "setLooperEnabled", "(Z)V", "pendingScrollPosition", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollHorizontally", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "scrollToPosition", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "scrollHorizontallyBy", "dx", "fill", "x", "recycleHideView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircularLayoutManager extends RecyclerView.LayoutManager {
    public final boolean canScrollHorizontally() {
        return true;
    }

    public final Context getContext() {
        return null;
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final void scrollToPosition(int r1) {
        requestLayout();
    }

    public final void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r10, "recycler");
        Intrinsics.checkNotNullParameter(r11, "state");
        if (getItemCount() > 0) goto L5;
        return;
    L5:
        if (r11.isPreLayout() == true) goto L15;
        detachAndScrapAttachedViews(r10);
        int r12 = getItemCount();
        int r1 = 0;
        int r4 = 0;
    L8:
        if (r1 >= r12) goto L16;
        View r3 = r10.getViewForPosition(r1);
        addView(r3);
        measureChildWithMargins(r3, 0, 0);
        int r2 = getDecoratedMeasuredWidth(r3);
        int r8 = r4 + r2;
        layoutDecorated(r3, r4, 0, r8, getDecoratedMeasuredHeight(r3));
        if (r8 > getWidth()) goto L17;
        r1 = r1 + 1;
        r4 = r8;
        goto L8
    L17:
        return;
    L16:
        return;
    }

    public final int scrollHorizontallyBy(int r9, RecyclerView.Recycler r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r10, "recycler");
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r10, "recycler");
        Intrinsics.checkNotNullParameter(r11, "state");
        int r12 = 0;
        if (r9 <= 0) goto L16;
        View r1 = getChildAt(getChildCount() - 1);
        if (r1 == null) goto L18;
        int r2 = getPosition(r1);
        if (r1.getRight() < getWidth()) goto L10;
    L27:
        int r0 = r9;
    L28:
        if (r0 != 0) goto L30;
        return 0;
    L30:
        offsetChildrenHorizontal(-r0);
        int r3 = getChildCount();
    L31:
        if (r12 >= r3) goto L43;
        View r4 = getChildAt(r12);
        if (r4 == null) goto L42;
        if (r9 <= 0) goto L40;
        if (r4.getRight() >= 0) goto L42;
        removeAndRecycleView(r4, r10);
        goto L42
    L40:
        if (r4.getLeft() <= getWidth()) goto L42;
        removeAndRecycleView(r4, r10);
    L42:
        r12 = r12 + 1;
        goto L31
    L43:
        return r0;
    L10:
        if (r2 != (getItemCount() - 1)) goto L12;
        View r5 = null;
        r0 = 0;
    L13:
        if (r5 == null) goto L28;
        addView(r5);
        measureChildWithMargins(r5, 0, 0);
        int r6 = getDecoratedMeasuredWidth(r5);
        layoutDecorated(r5, r1.getRight(), 0, r1.getRight() + r6, getDecoratedMeasuredHeight(r5));
        goto L28
    L12:
        r5 = r10.getViewForPosition(r2 + 1);
        r0 = r9;
    L18:
        r0 = 0;
        goto L28
    L16:
        View r7 = getChildAt(0);
        if (r7 == null) goto L18;
        int r8 = getPosition(r7);
        if (r7.getLeft() < 0) goto L27;
        if (r8 != 0) goto L23;
        View r13 = null;
        r0 = 0;
    L24:
        if (r13 == null) goto L18;
        addView(r13, 0);
        measureChildWithMargins(r13, 0, 0);
        int r14 = getDecoratedMeasuredWidth(r13);
        layoutDecorated(r13, r7.getLeft() - r14, 0, r7.getLeft(), getDecoratedMeasuredHeight(r13));
        goto L28
    L23:
        r13 = r10.getViewForPosition(r8 - 1);
        r0 = r9;
        goto L24
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        LinearSmoothScroller r4 = new LinearSmoothScroller(r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
