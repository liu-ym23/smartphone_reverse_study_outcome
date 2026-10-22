package androidx.recyclerview.widget;

import ai.j0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public DefaultSpanSizeLookup() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int r5, int r10) {
            return r5 % r10;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r5) {
            return 1;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r5) {
            super(r5);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices;
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanGroupIndexCache;
        final SparseIntArray mSpanIndexCache;

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        public static int findFirstKeyLessThan(SparseIntArray r5, int r10) {
            int r11 = r5.size() - 1;
            int r12 = 0;
        L3:
            if (r12 > r11) goto L8;
            int r13 = (r12 + r11) >>> 1;
            if (r5.keyAt(r13) < r10) goto L6;
            r11 = r13 - 1;
            goto L3
        L6:
            r12 = r13 + 1;
            goto L3
        L8:
            int r14 = r12 - 1;
            if (r14 >= 0) goto L11;
            return -1;
        L11:
            if (r14 < r5.size()) goto L13;
            return -1;
        L13:
            return r5.keyAt(r14);
        }

        public int getCachedSpanGroupIndex(int r5, int r10) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r11 = this.mSpanGroupIndexCache.get(r5, -1);
            if (r11 == (-1)) goto L9;
            return r11;
        L9:
            int r12 = getSpanGroupIndex(r5, r10);
            this.mSpanGroupIndexCache.put(r5, r12);
            return r12;
        L5:
            return getSpanGroupIndex(r5, r10);
        }

        public int getCachedSpanIndex(int r5, int r10) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r11 = this.mSpanIndexCache.get(r5, -1);
            if (r11 == (-1)) goto L9;
            return r11;
        L9:
            int r12 = getSpanIndex(r5, r10);
            this.mSpanIndexCache.put(r5, r12);
            return r12;
        L5:
            return getSpanIndex(r5, r10);
        }

        public int getSpanGroupIndex(int r10, int r11) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r5 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r10);
            if (r5 == (-1)) goto L9;
            int r12 = this.mSpanGroupIndexCache.get(r5);
            int r13 = r5 + 1;
            int r14 = getSpanSize(r5) + getCachedSpanIndex(r5, r11);
            if (r14 != r11) goto L10;
            r12 = r12 + 1;
            r14 = 0;
        L10:
            int r15 = getSpanSize(r10);
        L11:
            if (r13 >= r10) goto L19;
            int r16 = getSpanSize(r13);
            r14 = r14 + r16;
            if (r14 != r11) goto L15;
            r12 = r12 + 1;
            r14 = 0;
        L17:
            r13 = r13 + 1;
            goto L11
        L15:
            if (r14 <= r11) goto L17;
            r12 = r12 + 1;
            r14 = r16;
            goto L17
        L19:
            if ((r14 + r15) > r11) goto L21;
            return r12;
        L21:
            return r12 + 1;
        L9:
            r14 = 0;
            r12 = 0;
            r13 = 0;
            goto L10
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r10, int r11) {
            int r5 = getSpanSize(r10);
            if (r5 != r11) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r12 = findFirstKeyLessThan(this.mSpanIndexCache, r10);
            if (r12 < 0) goto L10;
            int r13 = getSpanSize(r12) + this.mSpanIndexCache.get(r12);
        L17:
            r12 = r12 + 1;
        L11:
            if (r12 >= r10) goto L19;
            int r14 = getSpanSize(r12);
            r13 = r13 + r14;
            if (r13 != r11) goto L15;
            r13 = 0;
            goto L17
        L15:
            if (r13 <= r11) goto L17;
            r13 = r14;
            goto L17
        L19:
            if ((r5 + r13) > r11) goto L21;
            return r13;
        L21:
            return 0;
        L10:
            r12 = 0;
            r13 = 0;
            goto L11
        }

        public abstract int getSpanSize(int r5);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean r5) {
            if (r5 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r5;
        }

        public void setSpanIndexCacheEnabled(boolean r5) {
            if (r5 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r5;
        }
    }

    public GridLayoutManager(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(r5, r10, r11, r12).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler r5, RecyclerView.State r10, int r11, boolean r12) {
        int r13 = 0;
        if (r12 == false) goto L5;
        int r14 = 1;
        int r15 = r11;
        int r16 = 0;
    L6:
        if (r16 == r15) goto L8;
        View r17 = this.mSet[r16];
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        int r19 = getSpanSize(r5, r10, getPosition(r17));
        r18.mSpanSize = r19;
        r18.mSpanIndex = r13;
        r13 = r13 + r19;
        r16 = r16 + r14;
        goto L6
    L8:
        return;
    L5:
        r16 = r11 - 1;
        r15 = -1;
        r14 = -1;
        goto L6
    }

    private void cachePreLayoutSpanMapping() {
        int r5 = getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        LayoutParams r11 = (LayoutParams) getChildAt(r10).getLayoutParams();
        int r12 = r11.getViewLayoutPosition();
        this.mPreLayoutSpanSizeCache.put(r12, r11.getSpanSize());
        this.mPreLayoutSpanIndexCache.put(r12, r11.getSpanIndex());
        r10 = r10 + 1;
        goto L3
    }

    private void calculateItemBorders(int r5) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, r5);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L19:
        return 0;
    L5:
        if (r10.getItemCount() == 0) goto L19;
        ensureLayoutState();
        boolean r5 = isSmoothScrollbarEnabled();
        View r11 = findFirstVisibleChildClosestToStart(!r5, true);
        View r12 = findFirstVisibleChildClosestToEnd(!r5, true);
        if (r11 == null) goto L19;
        if (r12 == null) goto L19;
        int r13 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r11), this.mSpanCount);
        int r14 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r12), this.mSpanCount);
        int r15 = Math.min(r13, r14);
        int r16 = Math.max(r13, r14);
        int r17 = this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r18 = Math.max(0, (r17 - r16) - 1);
    L15:
        if (r5 == true) goto L18;
        return r18;
    L18:
        return Math.round((r18 * (Math.abs(this.mOrientationHelper.getDecoratedEnd(r12) - this.mOrientationHelper.getDecoratedStart(r11)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r12), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r11), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(r11)));
    L14:
        r18 = Math.max(0, r15);
        goto L15
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r10.getItemCount() == 0) goto L17;
        ensureLayoutState();
        View r5 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r11 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r5 == null) goto L17;
        if (r11 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r12 = this.mOrientationHelper.getDecoratedEnd(r11) - this.mOrientationHelper.getDecoratedStart(r5);
        int r13 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r5), this.mSpanCount);
        int r14 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r11), this.mSpanCount);
        return (int) ((r12 / ((r14 - r13) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1));
    L14:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler r5, RecyclerView.State r10, LinearLayoutManager.AnchorInfo r11, int r12) {
        if (r12 != 1) goto L5;
        boolean r13 = true;
    L6:
        int r14 = getSpanIndex(r5, r10, r11.mPosition);
        if (r13 == false) goto L12;
    L8:
        if (r14 <= 0) goto L23;
        int r15 = r11.mPosition;
        if (r15 <= 0) goto L24;
        int r16 = r15 - 1;
        r11.mPosition = r16;
        r14 = getSpanIndex(r5, r10, r16);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r17 = r10.getItemCount() - 1;
        int r18 = r11.mPosition;
    L13:
        if (r18 >= r17) goto L17;
        int r19 = r18 + 1;
        int r20 = getSpanIndex(r5, r10, r19);
        if (r20 <= r14) goto L17;
        r18 = r19;
        r14 = r20;
    L17:
        r11.mPosition = r18;
        return;
    L5:
        r13 = false;
        goto L6
    }

    private void ensureViewSet() {
        View[] r5 = this.mSet;
        if (r5 != null) goto L5;
    L6:
        this.mSet = new View[this.mSpanCount];
        return;
    L5:
        if (r5.length != this.mSpanCount) goto L6;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler r5, RecyclerView.State r10, int r11) {
        if (r10.isPreLayout() == false) goto L5;
        int r12 = r5.convertPreLayoutPositionToPostLayout(r11);
        if (r12 != (-1)) goto L11;
        Log.w(TAG, "Cannot find span size for pre layout position. " + r11);
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r12, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r11, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler r5, RecyclerView.State r10, int r11) {
        if (r10.isPreLayout() == false) goto L5;
        int r12 = this.mPreLayoutSpanIndexCache.get(r11, -1);
        if (r12 == (-1)) goto L9;
        return r12;
    L9:
        int r13 = r5.convertPreLayoutPositionToPostLayout(r11);
        if (r13 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r11);
        return 0;
    L14:
        return this.mSpanSizeLookup.getCachedSpanIndex(r13, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r11, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r5, RecyclerView.State r10, int r11) {
        if (r10.isPreLayout() == false) goto L5;
        int r12 = this.mPreLayoutSpanSizeCache.get(r11, -1);
        if (r12 == (-1)) goto L9;
        return r12;
    L9:
        int r13 = r5.convertPreLayoutPositionToPostLayout(r11);
        if (r13 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r11);
        return 1;
    L14:
        return this.mSpanSizeLookup.getSpanSize(r13);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r11);
    }

    private void guessMeasurement(float r5, int r10) {
        calculateItemBorders(Math.max(Math.round(r5 * this.mSpanCount), r10));
    }

    private void measureChild(View r10, int r11, boolean r12) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        Rect r13 = r5.mDecorInsets;
        int r14 = ((r13.top + r13.bottom) + ((ViewGroup.MarginLayoutParams) r5).topMargin) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin;
        int r15 = ((r13.left + r13.right) + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin;
        int r16 = getSpaceForSpanRange(r5.mSpanIndex, r5.mSpanSize);
        if (this.mOrientation != 1) goto L5;
        int r17 = RecyclerView.LayoutManager.getChildMeasureSpec(r16, r11, r15, ((ViewGroup.MarginLayoutParams) r5).width, false);
        int r18 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), r14, ((ViewGroup.MarginLayoutParams) r5).height, true);
    L6:
        measureChildWithDecorationsAndMargin(r10, r17, r18, r12);
        return;
    L5:
        int r19 = RecyclerView.LayoutManager.getChildMeasureSpec(r16, r11, r14, ((ViewGroup.MarginLayoutParams) r5).height, false);
        int r20 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), r15, ((ViewGroup.MarginLayoutParams) r5).width, true);
        r18 = r19;
        r17 = r20;
        goto L6
    }

    private void measureChildWithDecorationsAndMargin(View r5, int r10, int r11, boolean r12) {
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r5.getLayoutParams();
        if (r12 == false) goto L5;
        boolean r14 = shouldReMeasureChild(r5, r10, r11, r13);
    L6:
        if (r14 == false) goto L9;
        r5.measure(r10, r11);
        return;
    L9:
        return;
    L5:
        r14 = shouldMeasureChild(r5, r10, r11, r13);
        goto L6
    }

    private void updateMeasurements() {
        if (getOrientation() != 1) goto L6;
        int r5 = getWidth() - getPaddingRight();
        int r10 = getPaddingLeft();
    L7:
        calculateItemBorders(r5 - r10);
        return;
    L6:
        r5 = getHeight() - getPaddingBottom();
        r10 = getPaddingTop();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r10, LinearLayoutManager.LayoutState r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r5 = this.mSpanCount;
        int r13 = 0;
    L4:
        if (r13 >= this.mSpanCount) goto L9;
        if (r11.hasMore(r10) == false) goto L13;
        if (r5 <= 0) goto L14;
        int r14 = r11.mCurrentPosition;
        r12.addPosition(r14, Math.max(0, r11.mScrollingOffset));
        r5 = r5 - this.mSpanSizeLookup.getSpanSize(r14);
        r11.mCurrentPosition += r11.mItemDirection;
        r13 = r13 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r5) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r5);
    L7:
        return super.computeHorizontalScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r5) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r5);
    L7:
        return super.computeHorizontalScrollRange(r5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r5) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r5);
    L7:
        return super.computeVerticalScrollOffset(r5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r5) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r5);
    L7:
        return super.computeVerticalScrollRange(r5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12, boolean r13) {
        int r14 = getChildCount();
        int r5 = 1;
        if (r13 == false) goto L5;
        int r15 = getChildCount() - 1;
        int r16 = -1;
        r5 = -1;
    L6:
        int r17 = r11.getItemCount();
        ensureLayoutState();
        int r18 = this.mOrientationHelper.getStartAfterPadding();
        int r19 = this.mOrientationHelper.getEndAfterPadding();
        View r20 = null;
        View r21 = null;
    L7:
        if (r15 == r16) goto L27;
        View r22 = getChildAt(r15);
        int r23 = getPosition(r22);
        if (r23 < 0) goto L26;
        if (r23 >= r17) goto L26;
        if (getSpanIndex(r10, r11, r23) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r22.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r21 != null) goto L26;
        r21 = r22;
        goto L26
    L19:
        if (this.mOrientationHelper.getDecoratedStart(r22) < r19) goto L21;
    L24:
        if (r20 != null) goto L26;
        r20 = r22;
        goto L26
    L21:
        if (this.mOrientationHelper.getDecoratedEnd(r22) < r18) goto L24;
        return r22;
    L26:
        r15 = r15 + r5;
        goto L7
    L27:
        if (r20 == null) goto L30;
        return r20;
    L30:
        return r21;
    L5:
        r16 = r14;
        r15 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r5, AttributeSet r10) {
        return new LayoutParams(r5, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r5, RecyclerView.State r10) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        if (r10.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r5, r10, r10.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r5, RecyclerView.State r10) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        if (r10.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r5, r10, r10.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int r5, int r10) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r11 = this.mCachedBorders;
        return r11[r10 + r5] - r11[r5];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r12 = this.mCachedBorders;
        int r13 = this.mSpanCount;
        return r12[r13 - r5] - r12[(r13 - r5) - r10];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.Recycler r18, RecyclerView.State r19, LinearLayoutManager.LayoutState r20, LinearLayoutManager.LayoutChunkResult r21) {
        int r5 = this.mOrientationHelper.getModeInOther();
        if (r5 == 1073741824) goto L5;
        boolean r10 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r11 = this.mCachedBorders[this.mSpanCount];
    L10:
        if (r10 == false) goto L13;
        updateMeasurements();
    L13:
        if (r20.mItemDirection != 1) goto L15;
        boolean r12 = true;
    L16:
        int r13 = this.mSpanCount;
        if (r12 == true) goto L19;
        r13 = getSpanIndex(r18, r19, r20.mCurrentPosition) + getSpanSize(r18, r19, r20.mCurrentPosition);
    L19:
        int r14 = 0;
    L21:
        if (r14 >= this.mSpanCount) goto L36;
        if (r20.hasMore(r19) == false) goto L36;
        if (r13 <= 0) goto L36;
        int r15 = r20.mCurrentPosition;
        int r16 = getSpanSize(r18, r19, r15);
        if (r16 > this.mSpanCount) goto L35;
        r13 = r13 - r16;
        if (r13 < 0) goto L36;
        View r17 = r20.next(r18);
        if (r17 == null) goto L36;
        this.mSet[r14] = r17;
        r14 = r14 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException(a.s(j0.v("Item at position ", r15, r16, " requires ", " spans but GridLayoutManager has only "), this.mSpanCount, " spans."));
    L36:
        if (r14 != 0) goto L39;
        r21.mFinished = true;
        return;
    L39:
        assignSpans(r18, r19, r14, r12);
        float r22 = 0.0f;
        int r23 = 0;
        int r24 = 0;
    L40:
        if (r23 >= r14) goto L56;
        View r110 = this.mSet[r23];
        if (r20.mScrapList != null) goto L46;
        if (r12 == false) goto L45;
        addView(r110);
    L49:
        calculateItemDecorationsForChild(r110, this.mDecorInsets);
        measureChild(r110, r5, false);
        int r111 = this.mOrientationHelper.getDecoratedMeasurement(r110);
        if (r111 <= r24) goto L52;
        r24 = r111;
    L52:
        float r112 = (this.mOrientationHelper.getDecoratedMeasurementInOther(r110) * 1.0f) / ((LayoutParams) r110.getLayoutParams()).mSpanSize;
        if (r112 <= r22) goto L55;
        r22 = r112;
    L55:
        r23 = r23 + 1;
        goto L40
    L45:
        addView(r110, 0);
        goto L49
    L46:
        if (r12 == false) goto L48;
        addDisappearingView(r110);
        goto L49
    L48:
        addDisappearingView(r110, 0);
        goto L49
    L56:
        if (r10 == false) goto L63;
        guessMeasurement(r22, r11);
        int r25 = 0;
        r24 = 0;
    L58:
        if (r25 >= r14) goto L63;
        View r26 = this.mSet[r25];
        measureChild(r26, BasicMeasure.EXACTLY, true);
        int r27 = this.mOrientationHelper.getDecoratedMeasurement(r26);
        if (r27 <= r24) goto L62;
        r24 = r27;
    L62:
        r25 = r25 + 1;
    L63:
        int r28 = 0;
    L64:
        if (r28 >= r14) goto L74;
        View r29 = this.mSet[r28];
        if (this.mOrientationHelper.getDecoratedMeasurement(r29) == r24) goto L73;
        LayoutParams r30 = (LayoutParams) r29.getLayoutParams();
        Rect r31 = r30.mDecorInsets;
        int r113 = ((r31.top + r31.bottom) + ((ViewGroup.MarginLayoutParams) r30).topMargin) + ((ViewGroup.MarginLayoutParams) r30).bottomMargin;
        int r114 = ((r31.left + r31.right) + ((ViewGroup.MarginLayoutParams) r30).leftMargin) + ((ViewGroup.MarginLayoutParams) r30).rightMargin;
        int r32 = getSpaceForSpanRange(r30.mSpanIndex, r30.mSpanSize);
        if (this.mOrientation != 1) goto L70;
        int r33 = RecyclerView.LayoutManager.getChildMeasureSpec(r32, BasicMeasure.EXACTLY, r114, ((ViewGroup.MarginLayoutParams) r30).width, false);
        int r34 = View.MeasureSpec.makeMeasureSpec(r24 - r113, BasicMeasure.EXACTLY);
    L71:
        measureChildWithDecorationsAndMargin(r29, r33, r34, true);
        goto L73
    L70:
        int r115 = View.MeasureSpec.makeMeasureSpec(r24 - r114, BasicMeasure.EXACTLY);
        r34 = RecyclerView.LayoutManager.getChildMeasureSpec(r32, BasicMeasure.EXACTLY, r113, ((ViewGroup.MarginLayoutParams) r30).height, false);
        r33 = r115;
    L73:
        r28 = r28 + 1;
        goto L64
    L74:
        r21.mConsumed = r24;
        if (this.mOrientation != 1) goto L82;
        if (r20.mLayoutDirection != (-1)) goto L80;
        int r35 = r20.mOffset;
        int r36 = r35 - r24;
    L79:
        int r37 = r36;
        int r38 = 0;
        int r39 = 0;
    L86:
        int r40 = 0;
    L87:
        if (r40 >= r14) goto L102;
        View r116 = this.mSet[r40];
        LayoutParams r117 = (LayoutParams) r116.getLayoutParams();
        if (this.mOrientation == 1) goto L91;
        int r41 = getPaddingTop() + this.mCachedBorders[r117.mSpanIndex];
        int r118 = r41;
        int r119 = r38;
        int r120 = r39;
        r35 = this.mOrientationHelper.getDecoratedMeasurementInOther(r116) + r41;
    L96:
        layoutDecoratedWithMargins(r116, r120, r118, r119, r35);
        if (r117.isItemRemoved() == false) goto L99;
    L100:
        r21.mIgnoreConsumed = true;
    L101:
        r21.mFocusable |= r116.hasFocusable();
        r40 = r40 + 1;
        r35 = r35;
        r38 = r119;
        r39 = r120;
        r37 = r118;
        goto L87
    L99:
        if (r117.isItemChanged() == false) goto L101;
    L91:
        if (isLayoutRTL() == false) goto L94;
        int r42 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - r117.mSpanIndex];
        r119 = r42;
        r120 = r42 - this.mOrientationHelper.getDecoratedMeasurementInOther(r116);
    L93:
        r118 = r37;
        goto L96
    L94:
        int r43 = getPaddingLeft() + this.mCachedBorders[r117.mSpanIndex];
        r120 = r43;
        r119 = this.mOrientationHelper.getDecoratedMeasurementInOther(r116) + r43;
        goto L93
    L102:
        Arrays.fill(this.mSet, null);
        return;
    L80:
        r36 = r20.mOffset;
        r35 = r36 + r24;
        goto L79
    L82:
        if (r20.mLayoutDirection != (-1)) goto L85;
        int r44 = r20.mOffset;
        int r45 = r44 - r24;
    L84:
        r39 = r45;
        r37 = 0;
        r38 = r44;
        r35 = 0;
        goto L86
    L85:
        r45 = r20.mOffset;
        r44 = r45 + r24;
        goto L84
    L15:
        r12 = false;
        goto L16
    L9:
        r11 = 0;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler r5, RecyclerView.State r10, LinearLayoutManager.AnchorInfo r11, int r12) {
        super.onAnchorReady(r5, r10, r11, r12);
        updateMeasurements();
        if (r10.getItemCount() > 0) goto L5;
    L7:
        ensureViewSet();
        return;
    L5:
        if (r10.isPreLayout() == true) goto L7;
        ensureAnchorIsInCorrectSpan(r5, r10, r11, r12);
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r24, int r25, RecyclerView.Recycler r26, RecyclerView.State r27) {
        RecyclerView.Recycler r5 = r26;
        RecyclerView.State r10 = r27;
        View r11 = findContainingItemView(r24);
        View r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        LayoutParams r13 = (LayoutParams) r11.getLayoutParams();
        int r14 = r13.mSpanIndex;
        int r15 = r13.mSpanSize + r14;
        if (super.onFocusSearchFailed(r24, r25, r26, r27) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r25) != 1) goto L11;
        boolean r16 = true;
    L13:
        if (r16 == this.mShouldReverseLayout) goto L15;
        int r17 = getChildCount() - 1;
        int r18 = -1;
        int r19 = -1;
    L17:
        if (this.mOrientation == 1) goto L19;
    L21:
        boolean r110 = false;
    L22:
        int r111 = getSpanGroupIndex(r5, r10, r17);
        int r112 = -1;
        int r113 = -1;
        int r20 = 0;
        int r114 = 0;
        int r115 = r17;
        View r21 = null;
    L23:
        if (r115 == r18) goto L26;
        int r22 = getSpanGroupIndex(r5, r10, r115);
        View r23 = getChildAt(r115);
        if (r23 == r11) goto L26;
        if (r23.hasFocusable() == false) goto L35;
        if (r22 == r111) goto L35;
        if (r12 != null) goto L26;
        View r116 = r11;
        View r28 = r21;
    L33:
        int r117 = r20;
        int r29 = r18;
    L34:
        int r30 = r113;
        int r31 = r114;
    L75:
        r113 = r30;
        r114 = r31;
        r20 = r117;
        r21 = r28;
    L76:
        r115 = r115 + r19;
        r5 = r26;
        r10 = r27;
        r11 = r116;
        r18 = r29;
    L35:
        LayoutParams r32 = (LayoutParams) r23.getLayoutParams();
        int r33 = r32.mSpanIndex;
        r116 = r11;
        int r34 = r32.mSpanSize + r33;
        if (r23.hasFocusable() == false) goto L41;
        if (r33 != r14) goto L41;
        if (r34 != r15) goto L41;
        return r23;
    L41:
        if (r23.hasFocusable() == false) goto L44;
        if (r12 != null) goto L44;
    L46:
        r28 = r21;
    L47:
        r117 = r20;
        r29 = r18;
        r30 = r113;
        r31 = r114;
    L71:
        if (r23.hasFocusable() == false) goto L73;
        r112 = r32.mSpanIndex;
        r113 = r30;
        r114 = r31;
        r21 = r28;
        r12 = r23;
        r20 = Math.min(r34, r15) - Math.max(r33, r14);
        goto L76
    L73:
        int r35 = r32.mSpanIndex;
        r114 = Math.min(r34, r15) - Math.max(r33, r14);
        r113 = r35;
        r20 = r117;
        r21 = r23;
    L44:
        if (r23.hasFocusable() == true) goto L48;
        if (r21 == null) goto L46;
    L48:
        r28 = r21;
        int r36 = Math.min(r34, r15) - Math.max(r33, r14);
        if (r23.hasFocusable() == false) goto L58;
        if (r36 > r20) goto L47;
        if (r36 != r20) goto L33;
        if (r33 <= r112) goto L55;
        boolean r37 = true;
    L56:
        if (r110 != r37) goto L33;
    L55:
        r37 = false;
        goto L56
    L58:
        if (r12 != null) goto L33;
        r117 = r20;
        r29 = r18;
        boolean r118 = true;
        if (isViewPartiallyVisible(r23, false, true) == false) goto L34;
        r31 = r114;
        if (r36 <= r31) goto L64;
        r30 = r113;
        goto L71
    L64:
        if (r36 != r31) goto L74;
        r30 = r113;
        if (r33 > r30) goto L69;
        r118 = false;
    L69:
        if (r110 != r118) goto L75;
    L74:
        r30 = r113;
    L26:
        View r210 = r21;
        if (r12 == null) goto L80;
        return r12;
    L80:
        return r210;
    L19:
        if (isLayoutRTL() == false) goto L21;
        r110 = true;
        goto L22
    L15:
        r18 = getChildCount();
        r19 = 1;
        r17 = 0;
        goto L17
    L11:
        r16 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler r5, @NonNull RecyclerView.State r10, @NonNull AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r5, r10, r11);
        r11.setClassName(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r10, RecyclerView.State r11, View r12, AccessibilityNodeInfoCompat r13) {
        ViewGroup.LayoutParams r5 = r12.getLayoutParams();
        if ((r5 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r12, r13);
        return;
    L6:
        LayoutParams r14 = (LayoutParams) r5;
        int r15 = getSpanGroupIndex(r10, r11, r14.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        r13.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r14.getSpanIndex(), r14.getSpanSize(), r15, 1, false, false));
        return;
    L9:
        r13.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r15, 1, r14.getSpanIndex(), r14.getSpanSize(), false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r5, int r10, int r11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r5) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r5, int r10, int r11, int r12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r5, int r10, int r11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r5, int r10, int r11, Object r12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r5, RecyclerView.State r10) {
        if (r10.isPreLayout() == false) goto L5;
        cachePreLayoutSpanMapping();
    L5:
        super.onLayoutChildren(r5, r10);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r5) {
        super.onLayoutCompleted(r5);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r5, RecyclerView.Recycler r10, RecyclerView.State r11) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r5, int r10, int r11) {
        if (this.mCachedBorders != null) goto L5;
        super.setMeasuredDimension(r5, r10, r11);
    L5:
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight() + r12;
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom() + r14;
        if (this.mOrientation != 1) goto L8;
        int r16 = RecyclerView.LayoutManager.chooseSize(r11, r5.height() + r15, getMinimumHeight());
        int[] r17 = this.mCachedBorders;
        int r18 = RecyclerView.LayoutManager.chooseSize(r10, r17[r17.length - 1] + r13, getMinimumWidth());
    L9:
        setMeasuredDimension(r18, r16);
        return;
    L8:
        r18 = RecyclerView.LayoutManager.chooseSize(r10, r5.width() + r13, getMinimumWidth());
        int[] r19 = this.mCachedBorders;
        r16 = RecyclerView.LayoutManager.chooseSize(r11, r19[r19.length - 1] + r15, getMinimumHeight());
        goto L9
    }

    public void setSpanCount(int r5) {
        if (r5 != this.mSpanCount) goto L5;
        return;
    L5:
        this.mPendingSpanCountChange = true;
        if (r5 < 1) goto L10;
        this.mSpanCount = r5;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException(j0.g(r5, "Span count should be at least 1. Provided "));
    }

    public void setSpanSizeLookup(SpanSizeLookup r5) {
        this.mSpanSizeLookup = r5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r5) {
        if (r5 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean r5) {
        this.mUsingSpansToEstimateScrollBarDimensions = r5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingSpanCountChange == true) goto L7;
        return true;
    }

    public static int[] calculateItemBorders(int[] r5, int r10, int r11) {
        int r12 = 1;
        if (r5 != null) goto L5;
    L8:
        r5 = new int[r10 + 1];
    L9:
        int r13 = 0;
        r5[0] = 0;
        int r14 = r11 / r10;
        int r15 = r11 % r10;
        int r16 = 0;
    L10:
        if (r12 > r10) goto L18;
        r13 = r13 + r15;
        if (r13 > 0) goto L14;
    L16:
        int r17 = r14;
    L17:
        r16 = r16 + r17;
        r5[r12] = r16;
        r12 = r12 + 1;
        goto L10
    L14:
        if ((r10 - r13) >= r15) goto L16;
        r17 = r14 + 1;
        r13 = r13 - r10;
        goto L17
    L18:
        return r5;
    L5:
        if (r5.length != (r10 + 1)) goto L8;
        if (r5[r5.length - 1] == r11) goto L9;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L7:
        return new LayoutParams(r5);
    }

    public GridLayoutManager(Context r5, int r10) {
        super(r5);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r10);
    }

    public GridLayoutManager(Context r5, int r10, int r11, boolean r12) {
        super(r5, r11, r12);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r10);
    }
}
