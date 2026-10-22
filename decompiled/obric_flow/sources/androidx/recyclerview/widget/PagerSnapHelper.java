package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
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

    private int distanceToCenter(@NonNull View r5, OrientationHelper r10) {
        int r11 = r10.getDecoratedStart(r5);
        int r12 = (r10.getDecoratedMeasurement(r5) / 2) + r11;
        int r13 = r10.getStartAfterPadding();
        return r12 - ((r10.getTotalSpace() / 2) + r13);
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

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r5) {
        if (r5.canScrollVertically() == false) goto L7;
        return getVerticalHelper(r5);
    L7:
        if (r5.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return getHorizontalHelper(r5);
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

    private boolean isForwardFling(RecyclerView.LayoutManager r5, int r10, int r11) {
        if (r5.canScrollHorizontally() == false) goto L7;
        if (r10 > 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r11 > 0) goto L9;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager r5) {
        int r10 = r5.getItemCount();
        if ((r5 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r11 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r5).computeScrollVectorForPosition(r10 - 1);
        if (r11 != null) goto L7;
        return false;
    L7:
        if (r11.x < 0.0f) goto L11;
        if (r11.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
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
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager r5) {
        if ((r5 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r10 = this.mRecyclerView.getContext();
        return new AnonymousClass1(this, r10);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    @SuppressLint({"UnknownNullness"})
    public View findSnapView(RecyclerView.LayoutManager r5) {
        if (r5.canScrollVertically() == false) goto L7;
        return findCenterView(r5, getVerticalHelper(r5));
    L7:
        if (r5.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return findCenterView(r5, getHorizontalHelper(r5));
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(RecyclerView.LayoutManager r12, int r13, int r14) {
        int r5 = r12.getItemCount();
        if (r5 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r10 = getOrientationHelper(r12);
        if (r10 != null) goto L8;
        return -1;
    L8:
        int r11 = r12.getChildCount();
        View r15 = null;
        int r16 = 0;
        int r17 = Integer.MAX_VALUE;
        int r18 = Integer.MIN_VALUE;
        View r19 = null;
    L9:
        if (r16 >= r11) goto L21;
        View r20 = r12.getChildAt(r16);
        if (r20 == null) goto L20;
        int r110 = distanceToCenter(r20, r10);
        if (r110 > 0) goto L17;
        if (r110 <= r18) goto L17;
        r19 = r20;
        r18 = r110;
    L17:
        if (r110 < 0) goto L20;
        if (r110 >= r17) goto L20;
        r15 = r20;
        r17 = r110;
    L20:
        r16 = r16 + 1;
        goto L9
    L21:
        boolean r111 = isForwardFling(r12, r13, r14);
        if (r111 == false) goto L26;
        if (r15 == null) goto L26;
        return r12.getPosition(r15);
    L26:
        if (r111 == true) goto L30;
        if (r19 == null) goto L30;
        return r12.getPosition(r19);
    L30:
        if (r111 == false) goto L32;
        r15 = r19;
    L32:
        if (r15 != null) goto L34;
        return -1;
    L34:
        int r112 = r12.getPosition(r15);
        if (isReverseLayout(r12) != r111) goto L37;
        int r113 = -1;
    L38:
        int r114 = r112 + r113;
        if (r114 < 0) goto L43;
        if (r114 >= r5) goto L43;
        return r114;
    L43:
        return -1;
    L37:
        r113 = 1;
        goto L38
    }
}
