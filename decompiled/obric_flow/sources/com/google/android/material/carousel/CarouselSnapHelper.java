package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: classes2.dex */
public class CarouselSnapHelper extends SnapHelper {
    private static final float HORIZONTAL_SNAP_SPEED = 100.0f;
    private static final float VERTICAL_SNAP_SPEED = 50.0f;
    private final boolean disableFling;
    private RecyclerView recyclerView;

    public CarouselSnapHelper() {
        this(true);
    }

    public static /* synthetic */ RecyclerView access$000(CarouselSnapHelper r5) {
        return r5.recyclerView;
    }

    public static /* synthetic */ int[] access$100(CarouselSnapHelper r5, RecyclerView.LayoutManager r10, View r11, boolean r12) {
        return r5.calculateDistanceToSnap(r10, r11, r12);
    }

    private int[] calculateDistanceToSnap(@NonNull RecyclerView.LayoutManager r5, @NonNull View r10, boolean r11) {
        if ((r5 instanceof CarouselLayoutManager) == false) goto L5;
        int r12 = distanceToFirstFocalKeyline(r10, (CarouselLayoutManager) r5, r11);
        if (r5.canScrollHorizontally() == false) goto L11;
        return new int[]{r12, 0};
    L11:
        if (r5.canScrollVertically() == false) goto L15;
        return new int[]{0, r12};
    L15:
        return new int[]{0, 0};
    L5:
        return new int[]{0, 0};
    }

    private int distanceToFirstFocalKeyline(@NonNull View r5, CarouselLayoutManager r10, boolean r11) {
        return r10.getOffsetToScrollToPositionForSnap(r10.getPosition(r5), r11);
    }

    @Nullable
    private View findViewNearestFirstKeyline(RecyclerView.LayoutManager r10) {
        int r11 = r10.getChildCount();
        View r5 = null;
        if (r11 != 0) goto L5;
    L13:
        return r5;
    L5:
        if ((r10 instanceof CarouselLayoutManager) == false) goto L13;
        CarouselLayoutManager r12 = (CarouselLayoutManager) r10;
        int r13 = Integer.MAX_VALUE;
        int r14 = 0;
    L8:
        if (r14 >= r11) goto L13;
        View r15 = r10.getChildAt(r14);
        int r16 = Math.abs(r12.getOffsetToScrollToPositionForSnap(r10.getPosition(r15), false));
        if (r16 >= r13) goto L12;
        r5 = r15;
        r13 = r16;
    L12:
        r14 = r14 + 1;
        goto L8
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
    public void attachToRecyclerView(@Nullable RecyclerView r5) {
        super.attachToRecyclerView(r5);
        this.recyclerView = r5;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r5, @NonNull View r10) {
        return calculateDistanceToSnap(r5, r10, false);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull final RecyclerView.LayoutManager r5) {
        if ((r5 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L5;
        final Context r10 = this.recyclerView.getContext();
        return new AnonymousClass1(this, r10, r5);
    L5:
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager r5) {
        return findViewNearestFirstKeyline(r5);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r12, int r13, int r14) {
        if (this.disableFling == true) goto L5;
        return -1;
    L5:
        int r5 = r12.getItemCount();
        if (r5 != 0) goto L8;
        return -1;
    L8:
        int r10 = r12.getChildCount();
        View r11 = null;
        int r15 = 0;
        int r16 = Integer.MAX_VALUE;
        int r17 = Integer.MIN_VALUE;
        View r18 = null;
    L9:
        if (r15 >= r10) goto L21;
        View r19 = r12.getChildAt(r15);
        if (r19 == null) goto L20;
        int r110 = distanceToFirstFocalKeyline(r19, (CarouselLayoutManager) r12, false);
        if (r110 > 0) goto L17;
        if (r110 <= r17) goto L17;
        r18 = r19;
        r17 = r110;
    L17:
        if (r110 < 0) goto L20;
        if (r110 >= r16) goto L20;
        r11 = r19;
        r16 = r110;
    L20:
        r15 = r15 + 1;
        goto L9
    L21:
        boolean r111 = isForwardFling(r12, r13, r14);
        if (r111 == false) goto L26;
        if (r11 == null) goto L26;
        return r12.getPosition(r11);
    L26:
        if (r111 == true) goto L30;
        if (r18 == null) goto L30;
        return r12.getPosition(r18);
    L30:
        if (r111 == false) goto L32;
        r11 = r18;
    L32:
        if (r11 != null) goto L34;
        return -1;
    L34:
        int r112 = r12.getPosition(r11);
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

    public CarouselSnapHelper(boolean r5) {
        this.disableFling = r5;
    }
}
