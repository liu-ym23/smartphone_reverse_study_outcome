package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    public LinearSnapHelper() {
    }

    private float computeDistancePerChild(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r12 = r10.getChildCount();
        if (r12 != 0) goto L5;
        return 1.0f;
    L5:
        int r13 = 0;
        View r14 = null;
        int r15 = Integer.MIN_VALUE;
        int r16 = Integer.MAX_VALUE;
        View r17 = null;
    L6:
        if (r13 >= r12) goto L15;
        View r18 = r10.getChildAt(r13);
        int r19 = r10.getPosition(r18);
        if (r19 == (-1)) goto L14;
        if (r19 >= r16) goto L12;
        r14 = r18;
        r16 = r19;
    L12:
        if (r19 <= r15) goto L14;
        r17 = r18;
        r15 = r19;
    L14:
        r13 = r13 + 1;
        goto L6
    L15:
        if (r14 == null) goto L23;
        if (r17 == null) goto L23;
        int r110 = Math.max(r11.getDecoratedEnd(r14), r11.getDecoratedEnd(r17)) - Math.min(r11.getDecoratedStart(r14), r11.getDecoratedStart(r17));
        if (r110 != 0) goto L22;
        return 1.0f;
    L22:
        return (r110 * 1.0f) / ((r15 - r16) + 1);
    L23:
        return 1.0f;
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager r10, @NonNull View r11, OrientationHelper r12) {
        return (r12.getDecoratedStart(r11) + (r12.getDecoratedMeasurement(r11) / 2)) - (r12.getStartAfterPadding() + (r12.getTotalSpace() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r10, OrientationHelper r11, int r12, int r13) {
        int[] r14 = calculateScrollDistance(r12, r13);
        float r15 = computeDistancePerChild(r10, r11);
        if (r15 > 0.0f) goto L6;
        return 0;
    L6:
        if (Math.abs(r14[0]) <= Math.abs(r14[1])) goto L8;
        int r16 = r14[0];
    L10:
        return Math.round(r16 / r15);
    L8:
        r16 = r14[1];
        goto L10
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r12 = r10.getChildCount();
        View r13 = null;
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r14 = r11.getStartAfterPadding() + (r11.getTotalSpace() / 2);
        int r15 = Integer.MAX_VALUE;
        int r16 = 0;
    L6:
        if (r16 >= r12) goto L11;
        View r17 = r10.getChildAt(r16);
        int r18 = Math.abs((r11.getDecoratedStart(r17) + (r11.getDecoratedMeasurement(r17) / 2)) - r14);
        if (r18 >= r15) goto L10;
        r13 = r17;
        r15 = r18;
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        return r13;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.mHorizontalHelper;
        if (r11 != null) goto L5;
    L6:
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(r10);
    L8:
        return this.mHorizontalHelper;
    L5:
        if (r11.mLayoutManager == r10) goto L8;
        goto L6
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager r10) {
        OrientationHelper r11 = this.mVerticalHelper;
        if (r11 != null) goto L5;
    L6:
        this.mVerticalHelper = OrientationHelper.createVerticalHelper(r10);
    L8:
        return this.mVerticalHelper;
    L5:
        if (r11.mLayoutManager == r10) goto L8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r10, @NonNull View r11) {
        int[] r12 = new int[2];
        if (r10.canScrollHorizontally() == false) goto L5;
        r12[0] = distanceToCenter(r10, r11, getHorizontalHelper(r10));
    L7:
        if (r10.canScrollVertically() == false) goto L9;
        r12[1] = distanceToCenter(r10, r11, getVerticalHelper(r10));
    L10:
        return r12;
    L9:
        r12[1] = 0;
        goto L10
    L5:
        r12[0] = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r10) {
        if (r10.canScrollVertically() == false) goto L8;
        OrientationHelper r11 = getVerticalHelper(r10);
    L6:
        return findCenterView(r10, r11);
    L8:
        if (r10.canScrollHorizontally() == false) goto L10;
        r11 = getHorizontalHelper(r10);
        goto L6
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r10, int r11, int r12) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r13 = r10.getItemCount();
        if (r13 != 0) goto L8;
        return -1;
    L8:
        View r14 = findSnapView(r10);
        if (r14 != null) goto L11;
        return -1;
    L11:
        int r15 = r10.getPosition(r14);
        if (r15 != (-1)) goto L14;
        return -1;
    L14:
        int r16 = r13 - 1;
        PointF r17 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r16);
        if (r17 != null) goto L17;
        return -1;
    L17:
        int r18 = 0;
        if (r10.canScrollHorizontally() == false) goto L22;
        int r19 = estimateNextPositionDiffForFling(r10, getHorizontalHelper(r10), r11, 0);
        if (r17.x >= 0.0f) goto L24;
        r19 = -r19;
    L24:
        if (r10.canScrollVertically() == false) goto L28;
        int r20 = estimateNextPositionDiffForFling(r10, getVerticalHelper(r10), 0, r12);
        if (r17.y >= 0.0f) goto L30;
        r20 = -r20;
    L30:
        if (r10.canScrollVertically() == false) goto L32;
        r19 = r20;
    L32:
        if (r19 != 0) goto L34;
        return -1;
    L34:
        int r21 = r15 + r19;
        if (r21 < 0) goto L38;
        r18 = r21;
    L38:
        if (r18 < r13) goto L41;
        return r16;
    L41:
        return r18;
    L28:
        r20 = 0;
        goto L30
    L22:
        r19 = 0;
        goto L24
    }
}
