package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.base.SmoothInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 50.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final SmoothInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;

    @SuppressLint({"UnknownNullness"})
    protected PointF mTargetVector;

    @SuppressLint({"UnknownNullness"})
    public LinearSmoothScroller(Context r5) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new SmoothInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = r5.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int r5, int r10) {
        int r11 = r5 - r10;
        if ((r5 * r11) > 0) goto L6;
        return 0;
    L6:
        return r11;
    }

    private float getSpeedPerPixel() {
        if (this.mHasCalculatedMillisPerPixel == true) goto L6;
        this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
        this.mHasCalculatedMillisPerPixel = true;
    L6:
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int r5, int r10, int r11, int r12, int r13) {
        if (r13 == (-1)) goto L20;
        if (r13 != 0) goto L6;
        int r14 = r11 - r5;
        if (r14 <= 0) goto L14;
        return r14;
    L14:
        int r15 = r12 - r10;
        if (r15 >= 0) goto L17;
        return r15;
    L17:
        return 0;
    L6:
        if (r13 != 1) goto L10;
        return r12 - r10;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r11 - r5;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDxToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r5 = getLayoutManager();
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.canScrollHorizontally() == false) goto L11;
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r5.getDecoratedLeft(r11) - ((ViewGroup.MarginLayoutParams) r10).leftMargin, r5.getDecoratedRight(r11) + ((ViewGroup.MarginLayoutParams) r10).rightMargin, r5.getPaddingLeft(), r5.getWidth() - r5.getPaddingRight(), r12);
    L11:
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDyToMakeVisible(View r11, int r12) {
        RecyclerView.LayoutManager r5 = getLayoutManager();
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.canScrollVertically() == false) goto L11;
        RecyclerView.LayoutParams r10 = (RecyclerView.LayoutParams) r11.getLayoutParams();
        return calculateDtToFit(r5.getDecoratedTop(r11) - ((ViewGroup.MarginLayoutParams) r10).topMargin, r5.getDecoratedBottom(r11) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin, r5.getPaddingTop(), r5.getHeight() - r5.getPaddingBottom(), r12);
    L11:
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public float calculateSpeedPerPixel(DisplayMetrics r5) {
        return 50.0f / r5.densityDpi;
    }

    public int calculateTimeForDeceleration(int r5) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(r5)) / 0.2d);
    }

    public int calculateTimeForScrolling(int r5) {
        return (int) Math.ceil(Math.abs(r5) * getSpeedPerPixel());
    }

    public int getHorizontalSnapPreference() {
        PointF r5 = this.mTargetVector;
        if (r5 == null) goto L11;
        float r10 = r5.x;
        if (r10 == 0.0f) goto L11;
        if (r10 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF r5 = this.mTargetVector;
        if (r5 == null) goto L11;
        float r10 = r5.y;
        if (r10 == 0.0f) goto L11;
        if (r10 <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    L11:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onSeekTargetStep(int r5, int r10, RecyclerView.State r11, RecyclerView.SmoothScroller.Action r12) {
        if (getChildCount() != 0) goto L6;
        stop();
        return;
    L6:
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, r5);
        int r13 = clampApplyScroll(this.mInterimTargetDy, r10);
        this.mInterimTargetDy = r13;
        if (this.mInterimTargetDx != 0) goto L11;
        if (r13 != 0) goto L12;
        updateActionForInterimTarget(r12);
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onTargetFound(View r5, RecyclerView.State r10, RecyclerView.SmoothScroller.Action r11) {
        int r12 = calculateDxToMakeVisible(r5, getHorizontalSnapPreference());
        int r13 = calculateDyToMakeVisible(r5, getVerticalSnapPreference());
        int r14 = calculateTimeForDeceleration((int) Math.sqrt((r13 * r13) + (r12 * r12)));
        if (r14 <= 0) goto L6;
        r11.update(-r12, -r13, r14, this.mDecelerateInterpolator);
        return;
    }

    @SuppressLint({"UnknownNullness"})
    public void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action r5) {
        PointF r10 = computeScrollVectorForPosition(getTargetPosition());
        if (r10 != null) goto L5;
    L11:
        r5.jumpTo(getTargetPosition());
        stop();
        return;
    L5:
        if (r10.x == 0.0f) goto L7;
    L9:
        normalize(r10);
        this.mTargetVector = r10;
        this.mInterimTargetDx = (int) (r10.x * 10000.0f);
        this.mInterimTargetDy = (int) (r10.y * 10000.0f);
        r5.update((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
        return;
    L7:
        if (r10.y != 0.0f) goto L9;
        goto L9
    }
}
