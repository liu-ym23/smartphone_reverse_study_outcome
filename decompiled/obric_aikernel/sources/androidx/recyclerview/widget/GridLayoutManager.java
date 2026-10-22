package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
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
        public int getSpanIndex(int r10, int r11) {
            return r10 % r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r10) {
            return 1;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r10) {
            super(r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
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

        static int findFirstKeyLessThan(SparseIntArray r10, int r11) {
            int r12 = r10.size() - 1;
            int r13 = 0;
        L3:
            if (r13 > r12) goto L8;
            int r14 = (r13 + r12) >>> 1;
            if (r10.keyAt(r14) < r11) goto L6;
            r12 = r14 - 1;
            goto L3
        L6:
            r13 = r14 + 1;
            goto L3
        L8:
            int r15 = r13 - 1;
            if (r15 >= 0) goto L11;
            return -1;
        L11:
            if (r15 < r10.size()) goto L13;
            return -1;
        L13:
            return r10.keyAt(r15);
        }

        int getCachedSpanGroupIndex(int r10, int r11) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r12 = this.mSpanGroupIndexCache.get(r10, -1);
            if (r12 == (-1)) goto L9;
            return r12;
        L9:
            int r13 = getSpanGroupIndex(r10, r11);
            this.mSpanGroupIndexCache.put(r10, r13);
            return r13;
        L5:
            return getSpanGroupIndex(r10, r11);
        }

        int getCachedSpanIndex(int r10, int r11) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r12 = this.mSpanIndexCache.get(r10, -1);
            if (r12 == (-1)) goto L9;
            return r12;
        L9:
            int r13 = getSpanIndex(r10, r11);
            this.mSpanIndexCache.put(r10, r13);
            return r13;
        L5:
            return getSpanIndex(r10, r11);
        }

        public int getSpanGroupIndex(int r10, int r11) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r12 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r10);
            if (r12 == (-1)) goto L9;
            int r13 = this.mSpanGroupIndexCache.get(r12);
            int r14 = r12 + 1;
            int r15 = getCachedSpanIndex(r12, r11) + getSpanSize(r12);
            if (r15 != r11) goto L10;
            r13 = r13 + 1;
            r15 = 0;
        L10:
            int r16 = getSpanSize(r10);
        L11:
            if (r14 >= r10) goto L19;
            int r17 = getSpanSize(r14);
            r15 = r15 + r17;
            if (r15 != r11) goto L15;
            r13 = r13 + 1;
            r15 = 0;
        L17:
            r14 = r14 + 1;
            goto L11
        L15:
            if (r15 <= r11) goto L17;
            r13 = r13 + 1;
            r15 = r17;
            goto L17
        L19:
            if ((r15 + r16) > r11) goto L21;
            return r13;
        L21:
            return r13 + 1;
        L9:
            r13 = 0;
            r14 = 0;
            r15 = 0;
            goto L10
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r10, int r11) {
            int r12 = getSpanSize(r10);
            if (r12 != r11) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r13 = findFirstKeyLessThan(this.mSpanIndexCache, r10);
            if (r13 < 0) goto L10;
            int r14 = this.mSpanIndexCache.get(r13) + getSpanSize(r13);
        L17:
            r13 = r13 + 1;
        L11:
            if (r13 >= r10) goto L19;
            int r15 = getSpanSize(r13);
            r14 = r14 + r15;
            if (r14 != r11) goto L15;
            r14 = 0;
            goto L17
        L15:
            if (r14 <= r11) goto L17;
            r14 = r15;
            goto L17
        L19:
            if ((r12 + r14) > r11) goto L21;
            return r14;
        L21:
            return 0;
        L10:
            r13 = 0;
            r14 = 0;
            goto L11
        }

        public abstract int getSpanSize(int r10);

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

        public void setSpanGroupIndexCacheEnabled(boolean r10) {
            if (r10 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r10;
        }

        public void setSpanIndexCacheEnabled(boolean r10) {
            if (r10 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r10;
        }
    }

    public GridLayoutManager(Context r10, int r11) {
        super(r10);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r11);
    }

    public GridLayoutManager(Context r10, int r11, int r12, boolean r13) {
        super(r10, r12, r13);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r11);
    }

    public GridLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, boolean r13) {
        int r14 = 0;
        int r15 = -1;
        if (r13 == false) goto L5;
        int r16 = 1;
        r15 = r12;
        int r17 = 0;
    L6:
        if (r17 == r15) goto L8;
        View r18 = this.mSet[r17];
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        int r20 = getSpanSize(r10, r11, getPosition(r18));
        r19.mSpanSize = r20;
        r19.mSpanIndex = r14;
        r14 = r14 + r20;
        r17 = r17 + r16;
        goto L6
    L8:
        return;
    L5:
        r17 = r12 - 1;
        r16 = -1;
        goto L6
    }

    private void cachePreLayoutSpanMapping() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        LayoutParams r12 = (LayoutParams) getChildAt(r11).getLayoutParams();
        int r13 = r12.getViewLayoutPosition();
        this.mPreLayoutSpanSizeCache.put(r13, r12.getSpanSize());
        this.mPreLayoutSpanIndexCache.put(r13, r12.getSpanIndex());
        r11 = r11 + 1;
        goto L3
    }

    private void calculateItemBorders(int r10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, r10);
    }

    static int[] calculateItemBorders(int[] r10, int r11, int r12) {
        int r13 = 1;
        if (r10 != null) goto L5;
    L8:
        r10 = new int[r11 + 1];
    L9:
        int r14 = 0;
        r10[0] = 0;
        int r15 = r12 / r11;
        int r16 = r12 % r11;
        int r17 = 0;
    L10:
        if (r13 > r11) goto L18;
        r14 = r14 + r16;
        if (r14 > 0) goto L14;
    L16:
        int r18 = r15;
    L17:
        r17 = r17 + r18;
        r10[r13] = r17;
        r13 = r13 + 1;
        goto L10
    L14:
        if ((r11 - r14) >= r16) goto L16;
        r18 = r15 + 1;
        r14 = r14 - r11;
        goto L17
    L18:
        return r10;
    L5:
        if (r10.length != (r11 + 1)) goto L8;
        if (r10[r10.length - 1] == r12) goto L9;
        goto L8
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
        boolean r11 = isSmoothScrollbarEnabled();
        View r12 = findFirstVisibleChildClosestToStart(!r11, true);
        View r13 = findFirstVisibleChildClosestToEnd(!r11, true);
        if (r12 == null) goto L19;
        if (r13 == null) goto L19;
        int r14 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r12), this.mSpanCount);
        int r15 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r13), this.mSpanCount);
        int r16 = Math.min(r14, r15);
        int r17 = Math.max(r14, r15);
        int r18 = this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r19 = Math.max(0, (r18 - r17) - 1);
    L15:
        if (r11 == true) goto L18;
        return r19;
    L18:
        return Math.round((r19 * (Math.abs(this.mOrientationHelper.getDecoratedEnd(r13) - this.mOrientationHelper.getDecoratedStart(r12)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r13), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r12), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(r12)));
    L14:
        r19 = Math.max(0, r16);
        goto L15
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r10.getItemCount() == 0) goto L17;
        ensureLayoutState();
        View r11 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r12 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r11 == null) goto L17;
        if (r12 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r13 = this.mOrientationHelper.getDecoratedEnd(r12) - this.mOrientationHelper.getDecoratedStart(r11);
        int r14 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r11), this.mSpanCount);
        int r15 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r12), this.mSpanCount);
        return (int) ((r13 / ((r15 - r14) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1));
    L14:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler r10, RecyclerView.State r11, LinearLayoutManager.AnchorInfo r12, int r13) {
        if (r13 != 1) goto L5;
        boolean r14 = true;
    L6:
        int r15 = getSpanIndex(r10, r11, r12.mPosition);
        if (r14 == false) goto L12;
    L8:
        if (r15 <= 0) goto L23;
        int r16 = r12.mPosition;
        if (r16 <= 0) goto L24;
        int r17 = r16 - 1;
        r12.mPosition = r17;
        r15 = getSpanIndex(r10, r11, r17);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r18 = r11.getItemCount() - 1;
        int r19 = r12.mPosition;
    L13:
        if (r19 >= r18) goto L17;
        int r20 = r19 + 1;
        int r21 = getSpanIndex(r10, r11, r20);
        if (r21 <= r15) goto L17;
        r19 = r20;
        r15 = r21;
    L17:
        r12.mPosition = r19;
        return;
    L5:
        r14 = false;
        goto L6
    }

    private void ensureViewSet() {
        View[] r10 = this.mSet;
        if (r10 != null) goto L5;
    L6:
        this.mSet = new View[this.mSpanCount];
        return;
    L5:
        if (r10.length != this.mSpanCount) goto L6;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.isPreLayout() == false) goto L5;
        int r13 = r10.convertPreLayoutPositionToPostLayout(r12);
        if (r13 != (-1)) goto L11;
        Log.w(TAG, "Cannot find span size for pre layout position. " + r12);
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r13, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r12, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.isPreLayout() == false) goto L5;
        int r13 = this.mPreLayoutSpanIndexCache.get(r12, -1);
        if (r13 == (-1)) goto L9;
        return r13;
    L9:
        int r14 = r10.convertPreLayoutPositionToPostLayout(r12);
        if (r14 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r12);
        return 0;
    L14:
        return this.mSpanSizeLookup.getCachedSpanIndex(r14, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r12, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.isPreLayout() == false) goto L5;
        int r13 = this.mPreLayoutSpanSizeCache.get(r12, -1);
        if (r13 == (-1)) goto L9;
        return r13;
    L9:
        int r14 = r10.convertPreLayoutPositionToPostLayout(r12);
        if (r14 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r12);
        return 1;
    L14:
        return this.mSpanSizeLookup.getSpanSize(r14);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r12);
    }

    private void guessMeasurement(float r10, int r11) {
        calculateItemBorders(Math.max(Math.round(r10 * this.mSpanCount), r11));
    }

    private void measureChild(View r10, int r11, boolean r12) {
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        Rect r14 = r13.mDecorInsets;
        int r15 = ((r14.top + r14.bottom) + ((ViewGroup.MarginLayoutParams) r13).topMargin) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin;
        int r16 = ((r14.left + r14.right) + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
        int r17 = getSpaceForSpanRange(r13.mSpanIndex, r13.mSpanSize);
        if (this.mOrientation != 1) goto L5;
        int r18 = RecyclerView.LayoutManager.getChildMeasureSpec(r17, r11, r16, ((ViewGroup.MarginLayoutParams) r13).width, false);
        int r19 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), r15, ((ViewGroup.MarginLayoutParams) r13).height, true);
    L6:
        measureChildWithDecorationsAndMargin(r10, r18, r19, r12);
        return;
    L5:
        int r110 = RecyclerView.LayoutManager.getChildMeasureSpec(r17, r11, r15, ((ViewGroup.MarginLayoutParams) r13).height, false);
        int r20 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), r16, ((ViewGroup.MarginLayoutParams) r13).width, true);
        r19 = r110;
        r18 = r20;
        goto L6
    }

    private void measureChildWithDecorationsAndMargin(View r10, int r11, int r12, boolean r13) {
        RecyclerView.LayoutParams r14 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        if (r13 == false) goto L5;
        boolean r15 = shouldReMeasureChild(r10, r11, r12, r14);
    L6:
        if (r15 == false) goto L9;
        r10.measure(r11, r12);
        return;
    L9:
        return;
    L5:
        r15 = shouldMeasureChild(r10, r11, r12, r14);
        goto L6
    }

    private void updateMeasurements() {
        if (getOrientation() != 1) goto L5;
        int r10 = getWidth() - getPaddingRight();
        int r11 = getPaddingLeft();
    L6:
        calculateItemBorders(r10 - r11);
        return;
    L5:
        r10 = getHeight() - getPaddingBottom();
        r11 = getPaddingTop();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State r10, LinearLayoutManager.LayoutState r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r13 = this.mSpanCount;
        int r14 = 0;
    L4:
        if (r14 >= this.mSpanCount) goto L9;
        if (r11.hasMore(r10) == false) goto L13;
        if (r13 <= 0) goto L14;
        int r15 = r11.mCurrentPosition;
        r12.addPosition(r15, Math.max(0, r11.mScrollingOffset));
        r13 = r13 - this.mSpanSizeLookup.getSpanSize(r15);
        r11.mCurrentPosition += r11.mItemDirection;
        r14 = r14 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r10) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r10);
    L7:
        return super.computeHorizontalScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r10) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r10);
    L7:
        return super.computeHorizontalScrollRange(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r10) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r10);
    L7:
        return super.computeVerticalScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r10) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r10);
    L7:
        return super.computeVerticalScrollRange(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14) {
        ensureLayoutState();
        int r15 = this.mOrientationHelper.getStartAfterPadding();
        int r16 = this.mOrientationHelper.getEndAfterPadding();
        if (r13 <= r12) goto L5;
        int r17 = 1;
    L6:
        View r18 = null;
        View r19 = null;
    L7:
        if (r12 == r13) goto L27;
        View r20 = getChildAt(r12);
        int r21 = getPosition(r20);
        if (r21 < 0) goto L26;
        if (r21 >= r14) goto L26;
        if (getSpanIndex(r10, r11, r21) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r20.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r19 != null) goto L26;
        r19 = r20;
        goto L26
    L19:
        if (this.mOrientationHelper.getDecoratedStart(r20) < r16) goto L21;
    L24:
        if (r18 != null) goto L26;
        r18 = r20;
        goto L26
    L21:
        if (this.mOrientationHelper.getDecoratedEnd(r20) < r15) goto L24;
        return r20;
    L26:
        r12 = r12 + r17;
        goto L7
    L27:
        if (r18 == null) goto L30;
        return r18;
    L30:
        return r19;
    L5:
        r17 = -1;
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
    public RecyclerView.LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
        return new LayoutParams(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L7:
        return new LayoutParams(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        if (r11.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r10, r11, r11.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        if (r11.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r10, r11, r11.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int r10, int r11) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r12 = this.mCachedBorders;
        return r12[r11 + r10] - r12[r10];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r13 = this.mCachedBorders;
        int r14 = this.mSpanCount;
        return r13[r14 - r10] - r13[(r14 - r10) - r11];
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.Recycler r18, RecyclerView.State r19, LinearLayoutManager.LayoutState r20, LinearLayoutManager.LayoutChunkResult r21) {
        int r10 = this.mOrientationHelper.getModeInOther();
        ?? r11 = 0;
        if (r10 == 1073741824) goto L5;
        boolean r12 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r13 = this.mCachedBorders[this.mSpanCount];
    L10:
        if (r12 == false) goto L13;
        updateMeasurements();
    L13:
        if (r20.mItemDirection != 1) goto L15;
        boolean r14 = true;
    L16:
        int r15 = this.mSpanCount;
        if (r14 == true) goto L19;
        r15 = getSpanIndex(r18, r19, r20.mCurrentPosition) + getSpanSize(r18, r19, r20.mCurrentPosition);
    L19:
        int r16 = 0;
    L21:
        if (r16 >= this.mSpanCount) goto L36;
        if (r20.hasMore(r19) == false) goto L36;
        if (r15 <= 0) goto L36;
        int r17 = r20.mCurrentPosition;
        int r110 = getSpanSize(r18, r19, r17);
        if (r110 > this.mSpanCount) goto L35;
        r15 = r15 - r110;
        if (r15 < 0) goto L36;
        View r22 = r20.next(r18);
        if (r22 == null) goto L36;
        this.mSet[r16] = r22;
        r16 = r16 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r17 + " requires " + r110 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L36:
        if (r16 != 0) goto L39;
        r21.mFinished = true;
        return;
    L39:
        float r23 = 0.0f;
        assignSpans(r18, r19, r16, r14);
        int r24 = 0;
        int r25 = 0;
    L40:
        if (r24 >= r16) goto L56;
        View r111 = this.mSet[r24];
        if (r20.mScrapList != null) goto L46;
        if (r14 == false) goto L45;
        addView(r111);
    L49:
        calculateItemDecorationsForChild(r111, this.mDecorInsets);
        measureChild(r111, r10, r11);
        int r112 = this.mOrientationHelper.getDecoratedMeasurement(r111);
        if (r112 <= r25) goto L52;
        r25 = r112;
    L52:
        float r26 = (this.mOrientationHelper.getDecoratedMeasurementInOther(r111) * 1.0f) / ((LayoutParams) r111.getLayoutParams()).mSpanSize;
        if (r26 <= r23) goto L55;
        r23 = r26;
    L55:
        r24 = r24 + 1;
        r11 = 0;
        goto L40
    L45:
        addView(r111, r11);
        goto L49
    L46:
        if (r14 == false) goto L48;
        addDisappearingView(r111);
        goto L49
    L48:
        addDisappearingView(r111, r11);
        goto L49
    L56:
        if (r12 == false) goto L63;
        guessMeasurement(r23, r13);
        int r27 = 0;
        r25 = 0;
    L58:
        if (r27 >= r16) goto L63;
        View r28 = this.mSet[r27];
        measureChild(r28, 1073741824, true);
        int r29 = this.mOrientationHelper.getDecoratedMeasurement(r28);
        if (r29 <= r25) goto L62;
        r25 = r29;
    L62:
        r27 = r27 + 1;
    L63:
        int r30 = 0;
    L64:
        if (r30 >= r16) goto L74;
        View r31 = this.mSet[r30];
        if (this.mOrientationHelper.getDecoratedMeasurement(r31) == r25) goto L73;
        LayoutParams r32 = (LayoutParams) r31.getLayoutParams();
        Rect r33 = r32.mDecorInsets;
        int r34 = ((r33.top + r33.bottom) + ((ViewGroup.MarginLayoutParams) r32).topMargin) + ((ViewGroup.MarginLayoutParams) r32).bottomMargin;
        int r113 = ((r33.left + r33.right) + ((ViewGroup.MarginLayoutParams) r32).leftMargin) + ((ViewGroup.MarginLayoutParams) r32).rightMargin;
        int r35 = getSpaceForSpanRange(r32.mSpanIndex, r32.mSpanSize);
        if (this.mOrientation != 1) goto L70;
        int r36 = RecyclerView.LayoutManager.getChildMeasureSpec(r35, 1073741824, r113, ((ViewGroup.MarginLayoutParams) r32).width, false);
        int r37 = View.MeasureSpec.makeMeasureSpec(r25 - r34, 1073741824);
    L71:
        measureChildWithDecorationsAndMargin(r31, r36, r37, true);
        goto L73
    L70:
        int r114 = View.MeasureSpec.makeMeasureSpec(r25 - r113, 1073741824);
        r37 = RecyclerView.LayoutManager.getChildMeasureSpec(r35, 1073741824, r34, ((ViewGroup.MarginLayoutParams) r32).height, false);
        r36 = r114;
    L73:
        r30 = r30 + 1;
        goto L64
    L74:
        int r115 = 0;
        r21.mConsumed = r25;
        if (this.mOrientation != 1) goto L82;
        if (r20.mLayoutDirection != (-1)) goto L79;
        int r38 = r20.mOffset;
        int r39 = r38 - r25;
    L80:
        int r40 = 0;
        int r41 = 0;
    L85:
        if (r115 >= r16) goto L100;
        View r42 = this.mSet[r115];
        LayoutParams r116 = (LayoutParams) r42.getLayoutParams();
        if (this.mOrientation == 1) goto L89;
        int r43 = getPaddingTop() + this.mCachedBorders[r116.mSpanIndex];
        int r117 = r43;
        int r118 = r40;
        int r119 = this.mOrientationHelper.getDecoratedMeasurementInOther(r42) + r43;
    L93:
        int r120 = r41;
    L94:
        layoutDecoratedWithMargins(r42, r120, r117, r118, r119);
        if (r116.isItemRemoved() == false) goto L97;
    L98:
        r21.mIgnoreConsumed = true;
    L99:
        r21.mFocusable |= r42.hasFocusable();
        r115 = r115 + 1;
        r38 = r119;
        r40 = r118;
        r39 = r117;
        r41 = r120;
        goto L85
    L97:
        if (r116.isItemChanged() == false) goto L99;
    L89:
        if (isLayoutRTL() == false) goto L91;
        int r44 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - r116.mSpanIndex];
        r41 = r44 - this.mOrientationHelper.getDecoratedMeasurementInOther(r42);
        r119 = r38;
        r118 = r44;
        r117 = r39;
        goto L93
    L91:
        int r45 = getPaddingLeft() + this.mCachedBorders[r116.mSpanIndex];
        r119 = r38;
        r120 = r45;
        r117 = r39;
        r118 = this.mOrientationHelper.getDecoratedMeasurementInOther(r42) + r45;
        goto L94
    L100:
        Arrays.fill(this.mSet, null);
        return;
    L79:
        int r46 = r20.mOffset;
        r39 = r46;
        r38 = r25 + r46;
        goto L80
    L82:
        if (r20.mLayoutDirection != (-1)) goto L84;
        int r47 = r20.mOffset;
        r41 = r47 - r25;
        r39 = 0;
        r40 = r47;
        r38 = 0;
        goto L85
    L84:
        int r48 = r20.mOffset;
        r40 = r25 + r48;
        r41 = r48;
        r38 = 0;
        r39 = 0;
        goto L85
    L15:
        r14 = false;
        goto L16
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.Recycler r10, RecyclerView.State r11, LinearLayoutManager.AnchorInfo r12, int r13) {
        super.onAnchorReady(r10, r11, r12, r13);
        updateMeasurements();
        if (r11.getItemCount() > 0) goto L5;
    L7:
        ensureViewSet();
        return;
    L5:
        if (r11.isPreLayout() == true) goto L7;
        ensureAnchorIsInCorrectSpan(r10, r11, r12, r13);
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r24, int r25, RecyclerView.Recycler r26, RecyclerView.State r27) {
        RecyclerView.Recycler r10 = r26;
        RecyclerView.State r11 = r27;
        View r12 = findContainingItemView(r24);
        View r13 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        LayoutParams r14 = (LayoutParams) r12.getLayoutParams();
        int r15 = r14.mSpanIndex;
        int r16 = r14.mSpanSize + r15;
        if (super.onFocusSearchFailed(r24, r25, r26, r27) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r25) != 1) goto L11;
        boolean r17 = true;
    L13:
        if (r17 == this.mShouldReverseLayout) goto L15;
        boolean r18 = true;
    L17:
        if (r18 == false) goto L19;
        int r19 = getChildCount() - 1;
        int r110 = -1;
        int r111 = -1;
    L21:
        if (this.mOrientation == 1) goto L23;
    L25:
        boolean r112 = false;
    L26:
        int r113 = getSpanGroupIndex(r10, r11, r19);
        int r114 = -1;
        int r115 = -1;
        int r20 = 0;
        int r116 = 0;
        int r117 = r19;
        View r21 = null;
    L27:
        if (r117 == r110) goto L85;
        int r22 = getSpanGroupIndex(r10, r11, r117);
        View r23 = getChildAt(r117);
        if (r23 == r12) goto L85;
        if (r23.hasFocusable() == false) goto L37;
        if (r22 == r113) goto L37;
        if (r13 != null) goto L85;
        View r118 = r12;
        View r28 = r21;
        int r119 = r20;
        int r29 = r110;
        int r30 = r115;
        int r31 = r116;
    L83:
        r115 = r30;
        r116 = r31;
        r20 = r119;
        r21 = r28;
    L84:
        r117 = r117 + r111;
        r10 = r26;
        r11 = r27;
        r12 = r118;
        r110 = r29;
    L37:
        LayoutParams r32 = (LayoutParams) r23.getLayoutParams();
        int r33 = r32.mSpanIndex;
        r118 = r12;
        int r34 = r32.mSpanSize + r33;
        if (r23.hasFocusable() == false) goto L43;
        if (r33 != r15) goto L43;
        if (r34 != r16) goto L43;
        return r23;
    L43:
        if (r23.hasFocusable() == false) goto L46;
        if (r13 != null) goto L46;
    L48:
        r28 = r21;
    L49:
        r119 = r20;
        r29 = r110;
        r30 = r115;
        r31 = r116;
    L50:
        boolean r120 = true;
    L78:
        if (r120 == false) goto L83;
        if (r23.hasFocusable() == false) goto L82;
        r114 = r32.mSpanIndex;
        r115 = r30;
        r116 = r31;
        r21 = r28;
        r13 = r23;
        r20 = Math.min(r34, r16) - Math.max(r33, r15);
        goto L84
    L82:
        int r35 = r32.mSpanIndex;
        r116 = Math.min(r34, r16) - Math.max(r33, r15);
        r115 = r35;
        r20 = r119;
        r21 = r23;
    L46:
        if (r23.hasFocusable() == true) goto L51;
        if (r21 == null) goto L48;
    L51:
        r28 = r21;
        int r36 = Math.min(r34, r16) - Math.max(r33, r15);
        if (r23.hasFocusable() == false) goto L61;
        if (r36 > r20) goto L49;
        if (r36 != r20) goto L75;
        if (r33 <= r114) goto L58;
        boolean r37 = true;
    L59:
        if (r112 != r37) goto L75;
    L58:
        r37 = false;
    L75:
        r119 = r20;
        r29 = r110;
    L76:
        r30 = r115;
        r31 = r116;
    L77:
        r120 = false;
        goto L78
    L61:
        if (r13 != null) goto L75;
        r119 = r20;
        r29 = r110;
        r120 = true;
        if (isViewPartiallyVisible(r23, false, true) == false) goto L76;
        r31 = r116;
        if (r36 <= r31) goto L67;
        r30 = r115;
        goto L78
    L67:
        if (r36 != r31) goto L74;
        r30 = r115;
        if (r33 > r30) goto L72;
        r120 = false;
    L72:
        if (r112 != r120) goto L77;
    L74:
        r30 = r115;
    L85:
        View r210 = r21;
        if (r13 == null) goto L89;
        return r13;
    L89:
        return r210;
    L23:
        if (isLayoutRTL() == false) goto L25;
        r112 = true;
        goto L26
    L19:
        r110 = getChildCount();
        r111 = 1;
        r19 = 0;
        goto L21
    L15:
        r18 = false;
        goto L17
    L11:
        r17 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r10, RecyclerView.State r11, View r12, AccessibilityNodeInfoCompat r13) {
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r12, r13);
        return;
    L6:
        LayoutParams r15 = (LayoutParams) r14;
        int r16 = getSpanGroupIndex(r10, r11, r15.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        int r17 = r15.getSpanIndex();
        int r18 = r15.getSpanSize();
        int r19 = 1;
        boolean r20 = false;
        boolean r21 = false;
        int r22 = r16;
    L10:
        r13.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r17, r18, r22, r19, r20, r21));
        return;
    L9:
        r18 = 1;
        r22 = r15.getSpanIndex();
        r19 = r15.getSpanSize();
        r20 = false;
        r21 = false;
        r17 = r16;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r10, int r11, int r12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r10) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r10, int r11, int r12, int r13) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r10, int r11, int r12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r10, int r11, int r12, Object r13) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (r11.isPreLayout() == false) goto L5;
        cachePreLayoutSpanMapping();
    L5:
        super.onLayoutChildren(r10, r11);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r10, int r11, int r12) {
        if (this.mCachedBorders != null) goto L5;
        super.setMeasuredDimension(r10, r11, r12);
    L5:
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L8;
        int r15 = RecyclerView.LayoutManager.chooseSize(r12, r10.height() + r14, getMinimumHeight());
        int[] r16 = this.mCachedBorders;
        int r17 = RecyclerView.LayoutManager.chooseSize(r11, r16[r16.length - 1] + r13, getMinimumWidth());
    L9:
        setMeasuredDimension(r17, r15);
        return;
    L8:
        r17 = RecyclerView.LayoutManager.chooseSize(r11, r10.width() + r13, getMinimumWidth());
        int[] r18 = this.mCachedBorders;
        r15 = RecyclerView.LayoutManager.chooseSize(r12, r18[r18.length - 1] + r14, getMinimumHeight());
        goto L9
    }

    public void setSpanCount(int r10) {
        if (r10 != this.mSpanCount) goto L5;
        return;
    L5:
        this.mPendingSpanCountChange = true;
        if (r10 < 1) goto L10;
        this.mSpanCount = r10;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r10);
    }

    public void setSpanSizeLookup(SpanSizeLookup r10) {
        this.mSpanSizeLookup = r10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r10) {
        if (r10 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean r10) {
        this.mUsingSpansToEstimateScrollBarDimensions = r10;
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
}
