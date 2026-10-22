package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
    }

    private int distanceToCenter(View r1, OrientationHelper r2) {
        return (r2.getDecoratedStart(r1) + (r2.getDecoratedMeasurement(r1) / 2)) - (r2.getStartAfterPadding() + (r2.getTotalSpace() / 2));
    }

    private View findCenterView(RecyclerView.LayoutManager r8, OrientationHelper r9) {
        int r7 = r8.getChildCount();
        View r0 = null;
        if (r7 != 0) goto L5;
        return null;
    L5:
        int r1 = r9.getStartAfterPadding() + (r9.getTotalSpace() / 2);
        int r2 = Integer.MAX_VALUE;
        int r3 = 0;
    L6:
        if (r3 >= r7) goto L11;
        View r4 = r8.getChildAt(r3);
        int r5 = Math.abs((r9.getDecoratedStart(r4) + (r9.getDecoratedMeasurement(r4) / 2)) - r1);
        if (r5 >= r2) goto L10;
        r0 = r4;
        r2 = r5;
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return r0;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.mHorizontalHelper;
        if (r0 != null) goto L5;
    L6:
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(r2);
    L8:
        return this.mHorizontalHelper;
    L5:
        if (r0.mLayoutManager == r2) goto L8;
        goto L6
    }

    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L7;
        return getVerticalHelper(r2);
    L7:
        if (r2.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return getHorizontalHelper(r2);
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.mVerticalHelper;
        if (r0 != null) goto L5;
    L6:
        this.mVerticalHelper = OrientationHelper.createVerticalHelper(r2);
    L8:
        return this.mVerticalHelper;
    L5:
        if (r0.mLayoutManager == r2) goto L8;
        goto L6
    }

    private boolean isForwardFling(RecyclerView.LayoutManager r2, int r3, int r4) {
        if (r2.canScrollHorizontally() == false) goto L8;
        if (r3 <= 0) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r4 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isReverseLayout(RecyclerView.LayoutManager r4) {
        int r3 = r4.getItemCount();
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.SmoothScroller.ScrollVectorProvider.class) == false) goto L12;
        PointF r5 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) ZeusTransformUtils.preCheckCast(r4, RecyclerView.SmoothScroller.ScrollVectorProvider.class, "com.obric.memorydata.plugin")).computeScrollVectorForPosition(r3 - 1);
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.x < 0.0f) goto L11;
        if (r5.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        int[] r0 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L5;
        r0[0] = distanceToCenter(r6, getHorizontalHelper(r5));
    L7:
        if (r5.canScrollVertically() == false) goto L9;
        r0[1] = distanceToCenter(r6, getVerticalHelper(r5));
    L10:
        return r0;
    L9:
        r0[1] = 0;
        goto L10
    L5:
        r0[0] = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.SmoothScroller.ScrollVectorProvider.class) == true) goto L6;
        return null;
    L6:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mRecyclerView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(this, r0);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L8;
        OrientationHelper r0 = getVerticalHelper(r2);
    L6:
        return findCenterView(r2, r0);
    L8:
        if (r2.canScrollHorizontally() == false) goto L10;
        r0 = getHorizontalHelper(r2);
        goto L6
    L10:
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r12, int r13, int r14) {
        int r0 = r12.getItemCount();
        if (r0 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r2 = getOrientationHelper(r12);
        if (r2 != null) goto L8;
        return -1;
    L8:
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MAX_VALUE;
        int r5 = r12.getChildCount();
        int r6 = 0;
        View r7 = null;
        View r8 = null;
    L9:
        if (r6 >= r5) goto L21;
        View r9 = r12.getChildAt(r6);
        if (r9 == null) goto L20;
        int r10 = distanceToCenter(r9, r2);
        if (r10 > 0) goto L17;
        if (r10 <= r3) goto L17;
        r8 = r9;
        r3 = r10;
    L17:
        if (r10 < 0) goto L20;
        if (r10 >= r4) goto L20;
        r7 = r9;
        r4 = r10;
    L20:
        r6 = r6 + 1;
        goto L9
    L21:
        boolean r15 = isForwardFling(r12, r13, r14);
        if (r15 == false) goto L26;
        if (r7 == null) goto L26;
        return r12.getPosition(r7);
    L26:
        if (r15 == true) goto L30;
        if (r8 == null) goto L30;
        return r12.getPosition(r8);
    L30:
        if (r15 == false) goto L32;
        r7 = r8;
    L32:
        if (r7 != null) goto L34;
        return -1;
    L34:
        int r16 = r12.getPosition(r7);
        if (isReverseLayout(r12) != r15) goto L37;
        int r11 = -1;
    L38:
        int r17 = r16 + r11;
        if (r17 < 0) goto L43;
        if (r17 >= r0) goto L43;
        return r17;
    L43:
        return -1;
    L37:
        r11 = 1;
        goto L38
    }
}
