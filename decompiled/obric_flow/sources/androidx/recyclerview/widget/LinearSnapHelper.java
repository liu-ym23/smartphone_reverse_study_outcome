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
        View r5 = null;
        int r13 = 0;
        int r14 = Integer.MIN_VALUE;
        int r15 = Integer.MAX_VALUE;
        View r16 = null;
    L6:
        if (r13 >= r12) goto L15;
        View r17 = r10.getChildAt(r13);
        int r18 = r10.getPosition(r17);
        if (r18 == (-1)) goto L14;
        if (r18 >= r15) goto L12;
        r5 = r17;
        r15 = r18;
    L12:
        if (r18 <= r14) goto L14;
        r16 = r17;
        r14 = r18;
    L14:
        r13 = r13 + 1;
        goto L6
    L15:
        if (r5 == null) goto L23;
        if (r16 == null) goto L23;
        int r19 = Math.max(r11.getDecoratedEnd(r5), r11.getDecoratedEnd(r16)) - Math.min(r11.getDecoratedStart(r5), r11.getDecoratedStart(r16));
        if (r19 != 0) goto L22;
        return 1.0f;
    L22:
        return (r19 * 1.0f) / ((r14 - r15) + 1);
    L23:
        return 1.0f;
    }

    private int distanceToCenter(@NonNull View r5, OrientationHelper r10) {
        int r11 = r10.getDecoratedStart(r5);
        int r12 = (r10.getDecoratedMeasurement(r5) / 2) + r11;
        int r13 = r10.getStartAfterPadding();
        return r12 - ((r10.getTotalSpace() / 2) + r13);
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r5, OrientationHelper r10, int r11, int r12) {
        int[] r13 = calculateScrollDistance(r11, r12);
        float r14 = computeDistancePerChild(r5, r10);
        if (r14 > 0.0f) goto L6;
        return 0;
    L6:
        if (Math.abs(r13[0]) <= Math.abs(r13[1])) goto L8;
        int r15 = r13[0];
    L10:
        return Math.round(r15 / r14);
    L8:
        r15 = r13[1];
        goto L10
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r12 = r10.getChildCount();
        View r5 = null;
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r13 = r11.getStartAfterPadding();
        int r14 = (r11.getTotalSpace() / 2) + r13;
        int r15 = Integer.MAX_VALUE;
        int r16 = 0;
    L6:
        if (r16 >= r12) goto L11;
        View r17 = r10.getChildAt(r16);
        int r18 = r11.getDecoratedStart(r17);
        int r19 = Math.abs(((r11.getDecoratedMeasurement(r17) / 2) + r18) - r14);
        if (r19 >= r15) goto L10;
        r5 = r17;
        r15 = r19;
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        return r5;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager r5) {
        OrientationHelper r10 = this.mHorizontalHelper;
        if (r10 != null) goto L5;
    L6:
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(r5);
    L8:
        return this.mHorizontalHelper;
    L5:
        if (r10.mLayoutManager == r5) goto L8;
        goto L6
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager r5) {
        OrientationHelper r10 = this.mVerticalHelper;
        if (r10 != null) goto L5;
    L6:
        this.mVerticalHelper = OrientationHelper.createVerticalHelper(r5);
    L8:
        return this.mVerticalHelper;
    L5:
        if (r10.mLayoutManager == r5) goto L8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r5, @NonNull View r10) {
        int[] r11 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L5;
        r11[0] = distanceToCenter(r10, getHorizontalHelper(r5));
    L7:
        if (r5.canScrollVertically() == false) goto L9;
        r11[1] = distanceToCenter(r10, getVerticalHelper(r5));
    L10:
        return r11;
    L9:
        r11[1] = 0;
        goto L10
    L5:
        r11[0] = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r5) {
        if (r5.canScrollVertically() == false) goto L7;
        return findCenterView(r5, getVerticalHelper(r5));
    L7:
        if (r5.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return findCenterView(r5, getHorizontalHelper(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r10, int r11, int r12) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r5 = r10.getItemCount();
        if (r5 != 0) goto L8;
        return -1;
    L8:
        View r13 = findSnapView(r10);
        if (r13 != null) goto L11;
        return -1;
    L11:
        int r14 = r10.getPosition(r13);
        if (r14 != (-1)) goto L14;
        return -1;
    L14:
        int r15 = r5 - 1;
        PointF r16 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r15);
        if (r16 != null) goto L17;
        return -1;
    L17:
        int r17 = 0;
        if (r10.canScrollHorizontally() == false) goto L22;
        int r18 = estimateNextPositionDiffForFling(r10, getHorizontalHelper(r10), r11, 0);
        if (r16.x >= 0.0f) goto L24;
        r18 = -r18;
    L24:
        if (r10.canScrollVertically() == false) goto L28;
        int r19 = estimateNextPositionDiffForFling(r10, getVerticalHelper(r10), 0, r12);
        if (r16.y >= 0.0f) goto L30;
        r19 = -r19;
    L30:
        if (r10.canScrollVertically() == false) goto L32;
        r18 = r19;
    L32:
        if (r18 != 0) goto L34;
        return -1;
    L34:
        int r20 = r14 + r18;
        if (r20 < 0) goto L38;
        r17 = r20;
    L38:
        if (r17 < r5) goto L41;
        return r15;
    L41:
        return r17;
    L28:
        r19 = 0;
        goto L30
    L22:
        r18 = 0;
        goto L24
    }
}
