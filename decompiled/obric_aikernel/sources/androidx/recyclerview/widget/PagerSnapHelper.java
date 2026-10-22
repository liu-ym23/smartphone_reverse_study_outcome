package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager r10, @NonNull View r11, OrientationHelper r12) {
        return (r12.getDecoratedStart(r11) + (r12.getDecoratedMeasurement(r11) / 2)) - (r12.getStartAfterPadding() + (r12.getTotalSpace() / 2));
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

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r10) {
        if (r10.canScrollVertically() == false) goto L7;
        return getVerticalHelper(r10);
    L7:
        if (r10.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return getHorizontalHelper(r10);
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

    private boolean isForwardFling(RecyclerView.LayoutManager r10, int r11, int r12) {
        if (r10.canScrollHorizontally() == false) goto L8;
        if (r11 <= 0) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r12 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager r10) {
        int r11 = r10.getItemCount();
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r12 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r10).computeScrollVectorForPosition(r11 - 1);
        if (r12 != null) goto L7;
        return false;
    L7:
        if (r12.x < 0.0f) goto L11;
        if (r12.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
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
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r10) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r11 = this.mRecyclerView.getContext();
        return new AnonymousClass1(this, r11);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
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

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r12, int r13, int r14) {
        int r10 = r12.getItemCount();
        if (r10 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r11 = getOrientationHelper(r12);
        if (r11 != null) goto L8;
        return -1;
    L8:
        int r15 = Integer.MIN_VALUE;
        int r16 = Integer.MAX_VALUE;
        int r17 = r12.getChildCount();
        int r18 = 0;
        View r19 = null;
        View r20 = null;
    L9:
        if (r18 >= r17) goto L21;
        View r21 = r12.getChildAt(r18);
        if (r21 == null) goto L20;
        int r110 = distanceToCenter(r12, r21, r11);
        if (r110 > 0) goto L17;
        if (r110 <= r15) goto L17;
        r20 = r21;
        r15 = r110;
    L17:
        if (r110 < 0) goto L20;
        if (r110 >= r16) goto L20;
        r19 = r21;
        r16 = r110;
    L20:
        r18 = r18 + 1;
        goto L9
    L21:
        boolean r111 = isForwardFling(r12, r13, r14);
        if (r111 == false) goto L26;
        if (r19 == null) goto L26;
        return r12.getPosition(r19);
    L26:
        if (r111 == true) goto L30;
        if (r20 == null) goto L30;
        return r12.getPosition(r20);
    L30:
        if (r111 == false) goto L32;
        r19 = r20;
    L32:
        if (r19 != null) goto L34;
        return -1;
    L34:
        int r112 = r12.getPosition(r19);
        if (isReverseLayout(r12) != r111) goto L37;
        int r113 = -1;
    L38:
        int r114 = r112 + r113;
        if (r114 < 0) goto L43;
        if (r114 >= r10) goto L43;
        return r114;
    L43:
        return -1;
    L37:
        r113 = 1;
        goto L38
    }
}
