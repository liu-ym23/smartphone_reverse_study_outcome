package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        public int getSpanIndex(int r1, int r2) {
            return r1 % r2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r1) {
            return 1;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r1) {
            super(r1);
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

        static int findFirstKeyLessThan(SparseIntArray r4, int r5) {
            int r0 = r4.size() - 1;
            int r1 = 0;
        L3:
            if (r1 > r0) goto L8;
            int r2 = (r1 + r0) >>> 1;
            if (r4.keyAt(r2) < r5) goto L6;
            r0 = r2 - 1;
            goto L3
        L6:
            r1 = r2 + 1;
            goto L3
        L8:
            int r3 = r1 - 1;
            if (r3 >= 0) goto L11;
            return -1;
        L11:
            if (r3 < r4.size()) goto L13;
            return -1;
        L13:
            return r4.keyAt(r3);
        }

        int getCachedSpanGroupIndex(int r3, int r4) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r0 = this.mSpanGroupIndexCache.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = getSpanGroupIndex(r3, r4);
            this.mSpanGroupIndexCache.put(r3, r5);
            return r5;
        L5:
            return getSpanGroupIndex(r3, r4);
        }

        int getCachedSpanIndex(int r3, int r4) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r0 = this.mSpanIndexCache.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = getSpanIndex(r3, r4);
            this.mSpanIndexCache.put(r3, r5);
            return r5;
        L5:
            return getSpanIndex(r3, r4);
        }

        public int getSpanGroupIndex(int r7, int r8) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r0 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r7);
            if (r0 == (-1)) goto L9;
            int r2 = this.mSpanGroupIndexCache.get(r0);
            int r3 = r0 + 1;
            int r4 = getCachedSpanIndex(r0, r8) + getSpanSize(r0);
            if (r4 != r8) goto L10;
            r2 = r2 + 1;
            r4 = 0;
        L10:
            int r1 = getSpanSize(r7);
        L11:
            if (r3 >= r7) goto L19;
            int r5 = getSpanSize(r3);
            r4 = r4 + r5;
            if (r4 != r8) goto L15;
            r2 = r2 + 1;
            r4 = 0;
        L17:
            r3 = r3 + 1;
            goto L11
        L15:
            if (r4 <= r8) goto L17;
            r2 = r2 + 1;
            r4 = r5;
            goto L17
        L19:
            if ((r4 + r1) > r8) goto L21;
            return r2;
        L21:
            return r2 + 1;
        L9:
            r2 = 0;
            r3 = 0;
            r4 = 0;
            goto L10
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r6, int r7) {
            int r0 = getSpanSize(r6);
            if (r0 != r7) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r2 = findFirstKeyLessThan(this.mSpanIndexCache, r6);
            if (r2 < 0) goto L10;
            int r3 = this.mSpanIndexCache.get(r2) + getSpanSize(r2);
        L17:
            r2 = r2 + 1;
        L11:
            if (r2 >= r6) goto L19;
            int r4 = getSpanSize(r2);
            r3 = r3 + r4;
            if (r3 != r7) goto L15;
            r3 = 0;
            goto L17
        L15:
            if (r3 <= r7) goto L17;
            r3 = r4;
            goto L17
        L19:
            if ((r0 + r3) > r7) goto L21;
            return r3;
        L21:
            return 0;
        L10:
            r2 = 0;
            r3 = 0;
            goto L11
        }

        public abstract int getSpanSize(int r1);

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

        public void setSpanGroupIndexCacheEnabled(boolean r2) {
            if (r2 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r2;
        }

        public void setSpanIndexCacheEnabled(boolean r2) {
            if (r2 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r2;
        }
    }

    public GridLayoutManager(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r4);
    }

    public GridLayoutManager(Context r3, int r4, int r5, boolean r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r5, r6);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r4);
    }

    public GridLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8, r5, r6);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(getProperties(r7, r8, r5, r6).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler r7, RecyclerView.State r8, int r9, boolean r10) {
        int r0 = 0;
        int r1 = -1;
        if (r10 == false) goto L5;
        int r11 = 1;
        r1 = r9;
        int r12 = 0;
    L6:
        if (r12 == r1) goto L8;
        View r2 = this.mSet[r12];
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r3.mSpanSize = getSpanSize(r7, r8, getPosition(r2));
        r3.mSpanIndex = r0;
        r0 = r0 + r3.mSpanSize;
        r12 = r12 + r11;
        goto L6
    L8:
        return;
    L5:
        r12 = r9 - 1;
        r11 = -1;
        goto L6
    }

    private void cachePreLayoutSpanMapping() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r3 = r2.getViewLayoutPosition();
        this.mPreLayoutSpanSizeCache.put(r3, r2.getSpanSize());
        this.mPreLayoutSpanIndexCache.put(r3, r2.getSpanIndex());
        r1 = r1 + 1;
        goto L3
    }

    private void calculateItemBorders(int r3) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, r3);
    }

    static int[] calculateItemBorders(int[] r5, int r6, int r7) {
        int r0 = 1;
        if (r5 != null) goto L5;
    L8:
        r5 = new int[r6 + 1];
    L9:
        int r1 = 0;
        r5[0] = 0;
        int r2 = r7 / r6;
        int r8 = r7 % r6;
        int r3 = 0;
    L10:
        if (r0 > r6) goto L18;
        r1 = r1 + r8;
        if (r1 > 0) goto L14;
    L16:
        int r4 = r2;
    L17:
        r3 = r3 + r4;
        r5[r0] = r3;
        r0 = r0 + 1;
        goto L10
    L14:
        if ((r6 - r1) >= r8) goto L16;
        r4 = r2 + 1;
        r1 = r1 - r6;
        goto L17
    L18:
        return r5;
    L5:
        if (r5.length != (r6 + 1)) goto L8;
        if (r5[r5.length - 1] == r7) goto L9;
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
        boolean r0 = isSmoothScrollbarEnabled();
        View r2 = findFirstVisibleChildClosestToStart(!r0, true);
        View r4 = findFirstVisibleChildClosestToEnd(!r0, true);
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r5 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r2), this.mSpanCount);
        int r6 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r4), this.mSpanCount);
        int r7 = Math.min(r5, r6);
        int r8 = Math.max(r5, r6);
        int r11 = this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r12 = Math.max(0, (r11 - r8) - 1);
    L15:
        if (r0 == true) goto L18;
        return r12;
    L18:
        return Math.round((r12 * (Math.abs(this.mOrientationHelper.getDecoratedEnd(r4) - this.mOrientationHelper.getDecoratedStart(r2)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r4), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r2), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(r2)));
    L14:
        r12 = Math.max(0, r7);
        goto L15
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r7.getItemCount() == 0) goto L17;
        ensureLayoutState();
        View r0 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r3 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r0 == null) goto L17;
        if (r3 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r1 = this.mOrientationHelper.getDecoratedEnd(r3) - this.mOrientationHelper.getDecoratedStart(r0);
        int r2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r0), this.mSpanCount);
        int r4 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r3), this.mSpanCount);
        return (int) ((r1 / ((r4 - r2) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(r7.getItemCount() - 1, this.mSpanCount) + 1));
    L14:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r7.getItemCount() - 1, this.mSpanCount) + 1;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler r5, RecyclerView.State r6, LinearLayoutManager.AnchorInfo r7, int r8) {
        if (r8 != 1) goto L5;
        boolean r9 = true;
    L6:
        int r1 = getSpanIndex(r5, r6, r7.mPosition);
        if (r9 == false) goto L12;
    L8:
        if (r1 <= 0) goto L23;
        if (r7.mPosition <= 0) goto L24;
        r7.mPosition--;
        r1 = getSpanIndex(r5, r6, r7.mPosition);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r10 = r6.getItemCount() - 1;
        int r0 = r7.mPosition;
    L13:
        if (r0 >= r10) goto L17;
        int r2 = r0 + 1;
        int r3 = getSpanIndex(r5, r6, r2);
        if (r3 <= r1) goto L17;
        r0 = r2;
        r1 = r3;
    L17:
        r7.mPosition = r0;
        return;
    L5:
        r9 = false;
        goto L6
    }

    private void ensureViewSet() {
        View[] r0 = this.mSet;
        if (r0 != null) goto L5;
    L6:
        this.mSet = new View[this.mSpanCount];
        return;
    L5:
        if (r0.length != this.mSpanCount) goto L6;
    }

    private int getSpanGroupIndex(RecyclerView.Recycler r1, RecyclerView.State r2, int r3) {
        if (r2.isPreLayout() == false) goto L5;
        int r4 = r1.convertPreLayoutPositionToPostLayout(r3);
        if (r4 != (-1)) goto L11;
        Log.w(TAG, "Cannot find span size for pre layout position. " + r3);
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r4, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r3, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler r2, RecyclerView.State r3, int r4) {
        if (r3.isPreLayout() == false) goto L5;
        int r5 = this.mPreLayoutSpanIndexCache.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.convertPreLayoutPositionToPostLayout(r4);
        if (r6 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 0;
    L14:
        return this.mSpanSizeLookup.getCachedSpanIndex(r6, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r4, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r2, RecyclerView.State r3, int r4) {
        if (r3.isPreLayout() == false) goto L5;
        int r5 = this.mPreLayoutSpanSizeCache.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.convertPreLayoutPositionToPostLayout(r4);
        if (r6 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 1;
    L14:
        return this.mSpanSizeLookup.getSpanSize(r6);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r4);
    }

    private void guessMeasurement(float r2, int r3) {
        calculateItemBorders(Math.max(Math.round(r2 * this.mSpanCount), r3));
    }

    private void measureChild(View r9, int r10, boolean r11) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        Rect r1 = r0.mDecorInsets;
        int r2 = ((r1.top + r1.bottom) + r0.topMargin) + r0.bottomMargin;
        int r3 = ((r1.left + r1.right) + r0.leftMargin) + r0.rightMargin;
        int r4 = getSpaceForSpanRange(r0.mSpanIndex, r0.mSpanSize);
        if (this.mOrientation != 1) goto L5;
        int r12 = getChildMeasureSpec(r4, r10, r3, r0.width, false);
        int r5 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), r2, r0.height, true);
    L6:
        measureChildWithDecorationsAndMargin(r9, r12, r5, r11);
        return;
    L5:
        int r13 = getChildMeasureSpec(r4, r10, r2, r0.height, false);
        int r6 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), r3, r0.width, true);
        r5 = r13;
        r12 = r6;
        goto L6
    }

    private void measureChildWithDecorationsAndMargin(View r4, int r5, int r6, boolean r7) {
        RecyclerView.LayoutParams r0 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L5;
        boolean r3 = shouldReMeasureChild(r4, r5, r6, r0);
    L6:
        if (r3 == false) goto L9;
        r4.measure(r5, r6);
        return;
    L9:
        return;
    L5:
        r3 = shouldMeasureChild(r4, r5, r6, r0);
        goto L6
    }

    private void updateMeasurements() {
        if (getOrientation() != 1) goto L5;
        int r0 = getWidth() - getPaddingRight();
        int r1 = getPaddingLeft();
    L6:
        calculateItemBorders(r0 - r1);
        return;
    L5:
        r0 = getHeight() - getPaddingBottom();
        r1 = getPaddingTop();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State r6, LinearLayoutManager.LayoutState r7, RecyclerView.LayoutManager.LayoutPrefetchRegistry r8) {
        RecyclerView.LayoutManager.LayoutPrefetchRegistry r9 = (RecyclerView.LayoutManager.LayoutPrefetchRegistry) ZeusTransformUtils.wrapperContextForParams(r8, RecyclerView.LayoutManager.LayoutPrefetchRegistry.class, "com.obric.memorydata.plugin");
        int r0 = this.mSpanCount;
        int r2 = 0;
    L4:
        if (r2 >= this.mSpanCount) goto L9;
        if (r7.hasMore(r6) == false) goto L13;
        if (r0 <= 0) goto L14;
        int r3 = r7.mCurrentPosition;
        r9.addPosition(r3, Math.max(0, r7.mScrollingOffset));
        r0 = r0 - this.mSpanSizeLookup.getSpanSize(r3);
        r7.mCurrentPosition += r7.mItemDirection;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r2);
    L7:
        return super.computeHorizontalScrollOffset(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r2);
    L7:
        return super.computeHorizontalScrollRange(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r2);
    L7:
        return super.computeVerticalScrollOffset(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r2);
    L7:
        return super.computeVerticalScrollRange(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13, boolean r14) {
        int r15 = getChildCount();
        int r0 = -1;
        int r1 = 1;
        if (r14 == false) goto L5;
        int r16 = getChildCount() - 1;
        r1 = -1;
    L6:
        int r17 = r12.getItemCount();
        ensureLayoutState();
        int r2 = this.mOrientationHelper.getStartAfterPadding();
        int r3 = this.mOrientationHelper.getEndAfterPadding();
        View r4 = null;
        View r5 = null;
    L7:
        if (r16 == r0) goto L27;
        View r6 = getChildAt(r16);
        int r7 = getPosition(r6);
        if (r7 < 0) goto L26;
        if (r7 >= r17) goto L26;
        if (getSpanIndex(r11, r12, r7) != 0) goto L26;
        if (((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin")).isItemRemoved() == false) goto L19;
        if (r5 != null) goto L26;
        r5 = r6;
        goto L26
    L19:
        if (this.mOrientationHelper.getDecoratedStart(r6) < r3) goto L21;
    L24:
        if (r4 != null) goto L26;
        r4 = r6;
        goto L26
    L21:
        if (this.mOrientationHelper.getDecoratedEnd(r6) < r2) goto L24;
        return r6;
    L26:
        r16 = r16 + r1;
        goto L7
    L27:
        if (r4 == null) goto L30;
        return r4;
    L30:
        return r5;
    L5:
        r0 = r15;
        r16 = 0;
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
    public RecyclerView.LayoutParams generateLayoutParams(Context r2, AttributeSet r3) {
        return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L7:
        return new LayoutParams(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        if (r4.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r3, r4, r4.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        if (r4.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r3, r4, r4.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int r3, int r4) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r2 = this.mCachedBorders;
        return r2[r4 + r3] - r2[r3];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r0 = this.mCachedBorders;
        int r5 = this.mSpanCount;
        return r0[r5 - r3] - r0[(r5 - r3) - r4];
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
    /* JADX WARN: Type inference failed for: r5v22 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.Recycler r19, RecyclerView.State r20, LinearLayoutManager.LayoutState r21, LinearLayoutManager.LayoutChunkResult r22) {
        int r3 = this.mOrientationHelper.getModeInOther();
        ?? r5 = 0;
        if (r3 == 1073741824) goto L5;
        boolean r9 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r10 = this.mCachedBorders[this.mSpanCount];
    L10:
        if (r9 == false) goto L13;
        updateMeasurements();
    L13:
        if (r21.mItemDirection != 1) goto L15;
        boolean r11 = true;
    L16:
        int r12 = this.mSpanCount;
        if (r11 == true) goto L19;
        r12 = getSpanIndex(r19, r20, r21.mCurrentPosition) + getSpanSize(r19, r20, r21.mCurrentPosition);
    L19:
        int r13 = 0;
    L21:
        if (r13 >= this.mSpanCount) goto L36;
        if (r21.hasMore(r20) == false) goto L36;
        if (r12 <= 0) goto L36;
        int r14 = r21.mCurrentPosition;
        int r15 = getSpanSize(r19, r20, r14);
        if (r15 > this.mSpanCount) goto L35;
        r12 = r12 - r15;
        if (r12 < 0) goto L36;
        View r4 = r21.next(r19);
        if (r4 == null) goto L36;
        this.mSet[r13] = r4;
        r13 = r13 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r14 + " requires " + r15 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L36:
        if (r13 != 0) goto L39;
        r22.mFinished = true;
        return;
    L39:
        float r6 = 0.0f;
        assignSpans(r19, r20, r13, r11);
        int r0 = 0;
        int r1 = 0;
    L41:
        if (r0 >= r13) goto L57;
        View r16 = this.mSet[r0];
        if (r21.mScrapList != null) goto L47;
        if (r11 == false) goto L46;
        addView(r16);
    L50:
        calculateItemDecorationsForChild(r16, this.mDecorInsets);
        measureChild(r16, r3, r5);
        int r17 = this.mOrientationHelper.getDecoratedMeasurement(r16);
        if (r17 <= r1) goto L53;
        r1 = r17;
    L53:
        float r18 = (this.mOrientationHelper.getDecoratedMeasurementInOther(r16) * 1.0f) / ((LayoutParams) ZeusTransformUtils.preCheckCast(r16.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).mSpanSize;
        if (r18 <= r6) goto L56;
        r6 = r18;
    L56:
        r0 = r0 + 1;
        r5 = 0;
        goto L41
    L46:
        addView(r16, r5);
        goto L50
    L47:
        if (r11 == false) goto L49;
        addDisappearingView(r16);
        goto L50
    L49:
        addDisappearingView(r16, r5);
        goto L50
    L57:
        if (r9 == false) goto L64;
        guessMeasurement(r6, r10);
        int r2 = 0;
        r1 = 0;
    L59:
        if (r2 >= r13) goto L64;
        View r7 = this.mSet[r2];
        measureChild(r7, 1073741824, true);
        int r8 = this.mOrientationHelper.getDecoratedMeasurement(r7);
        if (r8 <= r1) goto L63;
        r1 = r8;
    L63:
        r2 = r2 + 1;
    L64:
        int r23 = 0;
    L65:
        if (r23 >= r13) goto L75;
        View r24 = this.mSet[r23];
        if (this.mOrientationHelper.getDecoratedMeasurement(r24) == r1) goto L74;
        LayoutParams r25 = (LayoutParams) ZeusTransformUtils.preCheckCast(r24.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        Rect r26 = r25.mDecorInsets;
        int r27 = ((r26.top + r26.bottom) + r25.topMargin) + r25.bottomMargin;
        int r110 = ((r26.left + r26.right) + r25.leftMargin) + r25.rightMargin;
        int r28 = getSpaceForSpanRange(r25.mSpanIndex, r25.mSpanSize);
        if (this.mOrientation != 1) goto L71;
        int r29 = getChildMeasureSpec(r28, 1073741824, r110, r25.width, false);
        int r30 = View.MeasureSpec.makeMeasureSpec(r1 - r27, 1073741824);
    L72:
        measureChildWithDecorationsAndMargin(r24, r29, r30, true);
        goto L74
    L71:
        int r111 = View.MeasureSpec.makeMeasureSpec(r1 - r110, 1073741824);
        r30 = getChildMeasureSpec(r28, 1073741824, r27, r25.height, false);
        r29 = r111;
    L74:
        r23 = r23 + 1;
        goto L65
    L75:
        int r112 = 0;
        r22.mConsumed = r1;
        if (this.mOrientation != 1) goto L83;
        if (r21.mLayoutDirection != (-1)) goto L80;
        int r31 = r21.mOffset;
        int r32 = r31 - r1;
    L81:
        int r33 = 0;
        int r34 = 0;
    L86:
        if (r112 >= r13) goto L101;
        View r35 = this.mSet[r112];
        LayoutParams r113 = (LayoutParams) ZeusTransformUtils.preCheckCast(r35.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.mOrientation == 1) goto L90;
        int r36 = getPaddingTop() + this.mCachedBorders[r113.mSpanIndex];
        int r114 = r36;
        int r115 = r33;
        int r116 = r34;
        r31 = this.mOrientationHelper.getDecoratedMeasurementInOther(r35) + r36;
    L95:
        layoutDecoratedWithMargins(r35, r116, r114, r115, r31);
        if (r113.isItemRemoved() == false) goto L98;
    L99:
        r22.mIgnoreConsumed = true;
    L100:
        r22.mFocusable |= r35.hasFocusable();
        r112 = r112 + 1;
        r31 = r31;
        r33 = r115;
        r34 = r116;
        r32 = r114;
        goto L86
    L98:
        if (r113.isItemChanged() == false) goto L100;
    L90:
        if (isLayoutRTL() == false) goto L92;
        int r37 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - r113.mSpanIndex];
        r115 = r37;
        r116 = r37 - this.mOrientationHelper.getDecoratedMeasurementInOther(r35);
    L93:
        r114 = r32;
        goto L95
    L92:
        int r38 = getPaddingLeft() + this.mCachedBorders[r113.mSpanIndex];
        r116 = r38;
        r115 = this.mOrientationHelper.getDecoratedMeasurementInOther(r35) + r38;
        goto L93
    L101:
        Arrays.fill(this.mSet, null);
        return;
    L80:
        int r39 = r21.mOffset;
        r32 = r39;
        r31 = r1 + r39;
        goto L81
    L83:
        if (r21.mLayoutDirection != (-1)) goto L85;
        int r40 = r21.mOffset;
        r34 = r40 - r1;
        r32 = 0;
        r33 = r40;
        r31 = 0;
        goto L86
    L85:
        int r41 = r21.mOffset;
        r33 = r1 + r41;
        r34 = r41;
        r31 = 0;
        r32 = 0;
        goto L86
    L15:
        r11 = false;
        goto L16
    L9:
        r10 = 0;
        goto L10
    L5:
        r9 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.Recycler r2, RecyclerView.State r3, LinearLayoutManager.AnchorInfo r4, int r5) {
        super.onAnchorReady(r2, r3, r4, r5);
        updateMeasurements();
        if (r3.getItemCount() > 0) goto L5;
    L7:
        ensureViewSet();
        return;
    L5:
        if (r3.isPreLayout() == true) goto L7;
        ensureAnchorIsInCorrectSpan(r2, r3, r4, r5);
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r24, int r25, RecyclerView.Recycler r26, RecyclerView.State r27) {
        RecyclerView.Recycler r1 = r26;
        RecyclerView.State r2 = r27;
        View r3 = findContainingItemView(r24);
        View r4 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r7 = "com.obric.memorydata.plugin";
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r6 = r5.mSpanIndex;
        int r8 = r5.mSpanIndex + r5.mSpanSize;
        if (super.onFocusSearchFailed(r24, r25, r26, r27) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r25) != 1) goto L11;
        boolean r9 = true;
    L13:
        if (r9 == this.mShouldReverseLayout) goto L15;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        int r11 = getChildCount() - 1;
        int r12 = -1;
        int r13 = -1;
    L21:
        if (this.mOrientation == 1) goto L23;
    L25:
        boolean r14 = false;
    L26:
        int r15 = getSpanGroupIndex(r1, r2, r11);
        int r16 = -1;
        int r17 = -1;
        int r18 = r13;
        int r19 = 0;
        int r110 = 0;
        int r111 = r11;
        View r20 = null;
    L27:
        if (r111 == r12) goto L81;
        int r112 = r12;
        int r113 = getSpanGroupIndex(r1, r2, r111);
        View r21 = getChildAt(r111);
        if (r21 == r3) goto L81;
        if (r21.hasFocusable() == false) goto L37;
        if (r113 == r15) goto L37;
        if (r4 != null) goto L81;
        View r114 = r3;
        View r22 = r20;
        String r23 = r7;
        int r28 = r16;
        int r29 = r17;
    L78:
        int r30 = r28;
    L79:
        r20 = r22;
    L80:
        r111 = r111 + r18;
        r1 = r26;
        r16 = r30;
        r17 = r29;
        r12 = r112;
        r3 = r114;
        r7 = r23;
        r2 = r27;
    L37:
        LayoutParams r31 = (LayoutParams) ZeusTransformUtils.preCheckCast(r21.getLayoutParams(), LayoutParams.class, r7);
        int r115 = r31.mSpanIndex;
        r114 = r3;
        r23 = r7;
        int r32 = r31.mSpanIndex + r31.mSpanSize;
        if (r21.hasFocusable() == false) goto L43;
        if (r115 != r6) goto L43;
        if (r32 != r8) goto L43;
        return r21;
    L43:
        if (r21.hasFocusable() == false) goto L46;
        if (r4 != null) goto L46;
    L48:
        r22 = r20;
        r28 = r16;
        r29 = r17;
        boolean r33 = true;
    L73:
        if (r33 == false) goto L78;
        boolean r34 = r21.hasFocusable();
        r30 = r31.mSpanIndex;
        int r35 = Math.min(r32, r8);
        if (r34 == false) goto L77;
        r19 = r35 - Math.max(r115, r6);
        r4 = r21;
        goto L79
    L77:
        r110 = r35 - Math.max(r115, r6);
        r20 = r21;
        r29 = r30;
        r30 = r28;
    L46:
        if (r21.hasFocusable() == true) goto L49;
        if (r20 == null) goto L48;
    L49:
        int r36 = Math.min(r32, r8) - Math.max(r115, r6);
        if (r21.hasFocusable() == false) goto L59;
        if (r36 > r19) goto L48;
        if (r36 != r19) goto L71;
        if (r115 <= r16) goto L56;
        boolean r37 = true;
    L57:
        if (r14 != r37) goto L71;
    L56:
        r37 = false;
    L71:
        r22 = r20;
        r28 = r16;
        r29 = r17;
    L72:
        r33 = false;
        goto L73
    L59:
        if (r4 != null) goto L71;
        r22 = r20;
        r28 = r16;
        boolean r38 = false;
        if (isViewPartiallyVisible(r21, false, true) == false) goto L70;
        if (r36 <= r110) goto L64;
        r33 = true;
        r29 = r17;
        goto L73
    L64:
        if (r36 != r110) goto L70;
        r29 = r17;
        if (r115 <= r29) goto L68;
        r38 = true;
    L68:
        if (r14 != r38) goto L72;
        r33 = true;
    L70:
        r29 = r17;
    L81:
        View r210 = r20;
        if (r4 == null) goto L85;
        return r4;
    L85:
        return r210;
    L23:
        if (isLayoutRTL() == false) goto L25;
        r14 = true;
        goto L26
    L19:
        r12 = getChildCount();
        r13 = 1;
        r11 = 0;
        goto L21
    L15:
        r10 = false;
        goto L17
    L11:
        r9 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r1, RecyclerView.State r2, AccessibilityNodeInfoCompat r3) {
        super.onInitializeAccessibilityNodeInfo(r1, r2, r3);
        r3.setClassName(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r8, RecyclerView.State r9, View r10, AccessibilityNodeInfoCompat r11) {
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, LayoutParams.class) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r10, r11);
        return;
    L6:
        LayoutParams r12 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0, LayoutParams.class, "com.obric.memorydata.plugin");
        int r13 = getSpanGroupIndex(r8, r9, r12.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        int r1 = r12.getSpanIndex();
        int r2 = r12.getSpanSize();
        int r4 = 1;
        boolean r5 = false;
        boolean r6 = false;
        int r3 = r13;
    L10:
        r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r1, r2, r3, r4, r5, r6));
        return;
    L9:
        r2 = 1;
        r3 = r12.getSpanIndex();
        r4 = r12.getSpanSize();
        r5 = false;
        r6 = false;
        r1 = r13;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r1, int r2, int r3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r1) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r1, int r2, int r3, int r4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r1, int r2, int r3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r1, int r2, int r3, Object r4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        if (r3.isPreLayout() == false) goto L5;
        cachePreLayoutSpanMapping();
    L5:
        super.onLayoutChildren(r2, r3);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r5, int r6, int r7) {
        if (this.mCachedBorders != null) goto L5;
        super.setMeasuredDimension(r5, r6, r7);
    L5:
        int r0 = getPaddingLeft() + getPaddingRight();
        int r1 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L8;
        int r8 = chooseSize(r7, r5.height() + r1, getMinimumHeight());
        int[] r9 = this.mCachedBorders;
        int r10 = chooseSize(r6, r9[r9.length - 1] + r0, getMinimumWidth());
    L9:
        setMeasuredDimension(r10, r8);
        return;
    L8:
        r10 = chooseSize(r6, r5.width() + r0, getMinimumWidth());
        int[] r11 = this.mCachedBorders;
        r8 = chooseSize(r7, r11[r11.length - 1] + r1, getMinimumHeight());
        goto L9
    }

    public void setSpanCount(int r3) {
        if (r3 != this.mSpanCount) goto L5;
        return;
    L5:
        this.mPendingSpanCountChange = true;
        if (r3 < 1) goto L10;
        this.mSpanCount = r3;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r3);
    }

    public void setSpanSizeLookup(SpanSizeLookup r1) {
        this.mSpanSizeLookup = r1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r1) {
        if (r1 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean r1) {
        this.mUsingSpansToEstimateScrollBarDimensions = r1;
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
