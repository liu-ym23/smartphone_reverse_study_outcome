package com.bytedance.android.live.liveinteract.revenue.common.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/common/view/ScrollToTopSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScrollToTopSnapHelper extends LinearSnapHelper {
    public OrientationHelper a;
    public OrientationHelper b;

    public ScrollToTopSnapHelper() {
    }

    public final View findSnapView(RecyclerView.LayoutManager r8) {
        Intrinsics.checkNotNullParameter(r8, "layoutManager");
        if ((r8 instanceof LinearLayoutManager) == false) goto L34;
        if (r8.canScrollVertically() == false) goto L7;
        OrientationHelper r0 = getVerticalHelper(r8);
    L9:
        if ((r8 instanceof LinearLayoutManager) == false) goto L37;
        LinearLayoutManager r1 = (LinearLayoutManager) r8;
        int r5 = 0;
        if (r1.findLastCompletelyVisibleItemPosition() != (r8.getItemCount() - 1)) goto L13;
        boolean r2 = true;
    L14:
        int r3 = r1.findFirstVisibleItemPosition();
        if (r2 == false) goto L17;
    L31:
        return null;
    L17:
        if (r3 == (-1)) goto L31;
        View r4 = r8.findViewByPosition(r3);
        if (r0 == null) goto L22;
        int r6 = r0.getDecoratedEnd(r4);
    L23:
        if (r0 == null) goto L26;
        r5 = r0.getDecoratedMeasurement(r4);
    L26:
        if (r6 < (r5 / 2)) goto L29;
        if (r6 <= 0) goto L29;
        return r4;
    L29:
        if (r2 == true) goto L31;
        return r8.findViewByPosition(r3 + 1);
    L22:
        r6 = 0;
        goto L23
    L13:
        r2 = false;
        goto L14
    L37:
        return super.findSnapView(r8);
    L7:
        r0 = getHorizontalHelper(r8);
        goto L9
    L34:
        return super.findSnapView(r8);
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.b;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
    L8:
        if ((!Intrinsics.areEqual(r1, r2)) == true) goto L9;
    L11:
        return this.b;
    L6:
        r1 = null;
    L9:
        this.b = OrientationHelper.createHorizontalHelper(r2);
        goto L11
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.a;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
    L8:
        if ((!Intrinsics.areEqual(r1, r2)) == true) goto L9;
    L11:
        return this.a;
    L6:
        r1 = null;
    L9:
        this.a = OrientationHelper.createVerticalHelper(r2);
        goto L11
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        int[] r0 = {0, 0};
        int r2 = 0;
        if (r5.canScrollHorizontally() == false) goto L10;
        OrientationHelper r1 = getHorizontalHelper(r5);
        if (r1 == null) goto L7;
        int r3 = r1.getDecoratedStart(r6) - r1.getStartAfterPadding();
    L8:
        r0[0] = r3;
        goto L10
    L7:
        r3 = 0;
    L10:
        if (r5.canScrollVertically() == false) goto L15;
        OrientationHelper r7 = getVerticalHelper(r5);
        if (r7 == null) goto L14;
        r2 = r7.getDecoratedStart(r6) - r7.getStartAfterPadding();
    L14:
        r0[1] = r2;
    L15:
        return r0;
    }
}
