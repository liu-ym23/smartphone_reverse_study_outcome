package com.larus.avlink.env.diary;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/env/diary/TopPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "verticalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "distanceToStart", "helper", "findStartView", "getVerticalHelper", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TopPagerSnapHelper extends PagerSnapHelper {
    public OrientationHelper a;
    public RecyclerView b;

    public TopPagerSnapHelper() {
    }

    public final void attachToRecyclerView(RecyclerView r1) {
        this.b = r1;
        super/*androidx.recyclerview.widget.SnapHelper*/.attachToRecyclerView(r1);
    }

    public final RecyclerView.SmoothScroller createScroller(final RecyclerView.LayoutManager r3) {
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        if ((r3 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return null;
    L5:
        RecyclerView r0 = this.b;
        if (r0 != null) goto L8;
        return null;
    L8:
        final Context r1 = r0.getContext();
        return new AnonymousClass1(this, r3, r1);
    }

    public final View findSnapView(RecyclerView.LayoutManager r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        if (r2.canScrollVertically() == false) goto L7;
        return a(r2, getVerticalHelper(r2));
    L7:
        return super.findSnapView(r2);
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r3) {
        OrientationHelper r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        OrientationHelper r4 = OrientationHelper.createVerticalHelper(r3);
        this.a = r4;
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        if (Intrinsics.areEqual(r0.getLayoutManager(), r3) == false) goto L8;
        return r0;
    }

    public final View a(RecyclerView.LayoutManager r8, OrientationHelper r9) {
        int r0 = r8.getChildCount();
        View r1 = null;
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        View r3 = r8.getChildAt(0);
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L19;
        View r5 = r8.getChildAt(r0 - 1);
        if (r5 == null) goto L19;
        if (r8.getPosition(r5) != (r8.getItemCount() - 1)) goto L19;
        if (r9.getDecoratedEnd(r5) > r9.getEndAfterPadding()) goto L19;
        return r5;
    L19:
        int r6 = Integer.MAX_VALUE;
    L20:
        if (r2 >= r0) goto L28;
        View r7 = r8.getChildAt(r2);
        if (r7 == null) goto L27;
        int r10 = Math.abs(r9.getDecoratedStart(r7) - r9.getStartAfterPadding());
        if (r10 >= r6) goto L27;
        r1 = r7;
        r6 = r10;
    L27:
        r2 = r2 + 1;
        goto L20
    L28:
        return r1;
    L8:
        if (r8.getPosition(r3) != 0) goto L10;
        r4 = true;
        goto L11
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        int[] r0 = new int[2];
        if (r5.canScrollVertically() == false) goto L5;
        OrientationHelper r7 = getVerticalHelper(r5);
        r0[1] = r7.getDecoratedStart(r6) - r7.getStartAfterPadding();
    L6:
        r0[0] = 0;
        return r0;
    L5:
        r0[1] = 0;
        goto L6
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        int r6 = r3.getItemCount();
        if (r6 != 0) goto L5;
        return -1;
    L5:
        View r1 = a(r3, getVerticalHelper(r3));
        if (r1 != null) goto L8;
        return -1;
    L8:
        int r7 = r3.getPosition(r1);
        if (r7 != (-1)) goto L11;
        return -1;
    L11:
        if (r5 <= 0) goto L13;
        r7 = r7 + 1;
    L15:
        if (r7 >= 0) goto L17;
        r7 = 0;
    L17:
        if (r7 >= r6) goto L19;
        return r7;
    L19:
        return r6 - 1;
    L13:
        if (r5 >= 0) goto L15;
        r7 = r7 - 1;
        goto L15
    }
}
