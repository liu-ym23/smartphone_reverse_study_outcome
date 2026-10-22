package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = null;
    static Comparator<Task> sTaskComparator;
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews;
    private ArrayList<Task> mTasks;

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r10, int r11) {
            if (r10 < 0) goto L15;
            if (r11 < 0) goto L13;
            int r12 = this.mCount * 2;
            int[] r13 = this.mPrefetchArray;
            if (r13 != null) goto L8;
            int[] r14 = new int[4];
            this.mPrefetchArray = r14;
            Arrays.fill(r14, -1);
        L10:
            int[] r15 = this.mPrefetchArray;
            r15[r12] = r10;
            r15[r12 + 1] = r11;
            this.mCount++;
            return;
        L8:
            if (r12 < r13.length) goto L10;
            int[] r16 = new int[r12 * 2];
            this.mPrefetchArray = r16;
            System.arraycopy(r13, 0, r16, 0, r13.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        void clearPrefetchPositions() {
            int[] r10 = this.mPrefetchArray;
            if (r10 == null) goto L5;
            Arrays.fill(r10, -1);
        L5:
            this.mCount = 0;
        }

        void collectPrefetchPositionsFromView(RecyclerView r10, boolean r11) {
            this.mCount = 0;
            int[] r12 = this.mPrefetchArray;
            if (r12 == null) goto L5;
            Arrays.fill(r12, -1);
        L5:
            RecyclerView.LayoutManager r13 = r10.mLayout;
            if (r10.mAdapter == null) goto L21;
            if (r13 != null) goto L9;
            return;
        L9:
            if (r13.isItemPrefetchEnabled() == false) goto L23;
            if (r11 == false) goto L15;
            if (r10.mAdapterHelper.hasPendingUpdates() == true) goto L17;
            r13.collectInitialPrefetchPositions(r10.mAdapter.getItemCount(), this);
        L17:
            int r14 = this.mCount;
            if (r14 <= r13.mPrefetchMaxCountObserved) goto L24;
            r13.mPrefetchMaxCountObserved = r14;
            r13.mPrefetchMaxObservedInInitialPrefetch = r11;
            r10.mRecycler.updateViewCacheSize();
            return;
        L24:
            return;
        L15:
            if (r10.hasPendingAdapterUpdates() == true) goto L17;
            r13.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, r10.mState, this);
            goto L17
        L23:
            return;
        }

        boolean lastPrefetchIncludedPosition(int r10) {
            if (this.mPrefetchArray == null) goto L11;
            int r11 = this.mCount * 2;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L11;
            if (this.mPrefetchArray[r12] == r10) goto L8;
            r12 = r12 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        void setPrefetchVector(int r10, int r11) {
            this.mPrefetchDx = r10;
            this.mPrefetchDy = r11;
        }
    }

    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    static {
        sGapWorker = new ThreadLocal();
        sTaskComparator = new AnonymousClass1();
    }

    GapWorker() {
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    private void buildTaskList() {
        int r10 = this.mRecyclerViews.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RecyclerView r13 = this.mRecyclerViews.get(r11);
        if (r13.getWindowVisibility() != 0) goto L7;
        r13.mPrefetchRegistry.collectPrefetchPositionsFromView(r13, false);
        r12 = r12 + r13.mPrefetchRegistry.mCount;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.mTasks.ensureCapacity(r12);
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r14 >= r10) goto L26;
        RecyclerView r16 = this.mRecyclerViews.get(r14);
        if (r16.getWindowVisibility() != 0) goto L25;
        LayoutPrefetchRegistryImpl r17 = r16.mPrefetchRegistry;
        int r18 = Math.abs(r17.mPrefetchDx) + Math.abs(r17.mPrefetchDy);
        int r19 = 0;
    L15:
        if (r19 >= (r17.mCount * 2)) goto L25;
        if (r15 < this.mTasks.size()) goto L19;
        Task r20 = new Task();
        this.mTasks.add(r20);
    L20:
        int[] r21 = r17.mPrefetchArray;
        int r110 = r21[r19 + 1];
        if (r110 > r18) goto L23;
        boolean r111 = true;
    L24:
        r20.immediate = r111;
        r20.viewVelocity = r18;
        r20.distanceToItem = r110;
        r20.view = r16;
        r20.position = r21[r19];
        r15 = r15 + 1;
        r19 = r19 + 2;
        goto L15
    L23:
        r111 = false;
        goto L24
    L19:
        r20 = this.mTasks.get(r15);
    L25:
        r14 = r14 + 1;
        goto L9
    L26:
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task r10, long r11) {
        if (r10.immediate == false) goto L5;
        long r12 = Long.MAX_VALUE;
    L6:
        RecyclerView.ViewHolder r13 = prefetchPositionWithDeadline(r10.view, r10.position, r12);
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.mNestedRecyclerView != null) goto L11;
        return;
    L11:
        if (r13.isBound() == true) goto L13;
        return;
    L13:
        if (r13.isInvalid() == true) goto L19;
        prefetchInnerRecyclerViewWithDeadline(r13.mNestedRecyclerView.get(), r11);
        return;
    L19:
        return;
    L5:
        r12 = r11;
        goto L6
    }

    private void flushTasksWithDeadline(long r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mTasks.size()) goto L9;
        Task r12 = this.mTasks.get(r11);
        if (r12.view == null) goto L12;
        flushTaskWithDeadline(r12, r10);
        r12.clear();
        r11 = r11 + 1;
        goto L4
    L12:
        return;
    }

    static boolean isPrefetchPositionAttached(RecyclerView r10, int r11) {
        int r12 = r10.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        RecyclerView.ViewHolder r14 = RecyclerView.getChildViewHolderInt(r10.mChildHelper.getUnfilteredChildAt(r13));
        if (r14.mPosition != r11) goto L10;
        if (r14.isInvalid() == true) goto L10;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        LayoutPrefetchRegistryImpl r12 = r10.mPrefetchRegistry;
        r12.collectPrefetchPositionsFromView(r10, true);
        if (r12.mCount != 0) goto L21;
        return;
    L21:
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L17
        r10.mState.prepareForNestedPrefetch(r10.mAdapter);     // Catch: Throwable -> L17
        int r13 = 0;
    L13:
        if (r13 >= (r12.mCount * 2)) goto L16;
        prefetchPositionWithDeadline(r10, r12.mPrefetchArray[r13], r11);     // Catch: Throwable -> L17
        r13 = r13 + 2;
        goto L13
    L16:
        TraceCompat.endSection();
        return;
    L17:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L7:
        if (r10.mChildHelper.getUnfilteredChildCount() == 0) goto L9;
        r10.removeAndRecycleViews();
        goto L9
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView r10, int r11, long r12) {
        if (isPrefetchPositionAttached(r10, r11) == false) goto L6;
        return null;
    L6:
        RecyclerView.Recycler r13 = r10.mRecycler;
        r10.onEnterLayoutOrScroll();     // Catch: Throwable -> L17
        RecyclerView.ViewHolder r14 = r13.tryGetViewHolderForPositionByDeadline(r11, false, r12);     // Catch: Throwable -> L17
        if (r14 != null) goto L10;
    L15:
        r10.onExitLayoutOrScroll(false);
        return r14;
    L10:
        if (r14.isBound() == true) goto L12;
    L14:
        r13.addViewHolderToRecycledViewPool(r14, false);     // Catch: Throwable -> L17
        goto L15
    L12:
        if (r14.isInvalid() == true) goto L14;
        r13.recycleView(r14.itemView);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r10.onExitLayoutOrScroll(false);
        throw th;
    }

    public void add(RecyclerView r10) {
        this.mRecyclerViews.add(r10);
    }

    void postFromTraversal(RecyclerView r10, int r11, int r12) {
        if (r10.isAttachedToWindow() == true) goto L5;
    L7:
        r10.mPrefetchRegistry.setPrefetchVector(r11, r12);
        return;
    L5:
        if (this.mPostTimeNs != 0) goto L7;
        this.mPostTimeNs = r10.getNanoTime();
        r10.post(this);
        goto L7
    }

    void prefetch(long r10) {
        buildTaskList();
        flushTasksWithDeadline(r10);
    }

    public void remove(RecyclerView r10) {
        this.mRecyclerViews.remove(r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L19
        if (this.mRecyclerViews.isEmpty() == false) goto L7;
    L5:
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r10 = this.mRecyclerViews.size();     // Catch: Throwable -> L19
        int r11 = 0;
        long r12 = 0;
    L8:
        if (r11 >= r10) goto L14;
        RecyclerView r13 = this.mRecyclerViews.get(r11);     // Catch: Throwable -> L19
        if (r13.getWindowVisibility() != 0) goto L12;
        r12 = Math.max(r13.getDrawingTime(), r12);     // Catch: Throwable -> L19
    L12:
        r11 = r11 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r12 == 0) goto L5;
        prefetch(TimeUnit.MILLISECONDS.toNanos(r12) + this.mFrameIntervalNs);     // Catch: Throwable -> L19
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L19:
        th = move-exception;
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        throw th;
    }
}
