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
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        public LayoutPrefetchRegistryImpl() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r10, int r11) {
            if (r10 < 0) goto L15;
            if (r11 < 0) goto L13;
            int r5 = this.mCount;
            int r12 = r5 * 2;
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
            int[] r16 = new int[r5 * 4];
            this.mPrefetchArray = r16;
            System.arraycopy(r13, 0, r16, 0, r13.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void clearPrefetchPositions() {
            int[] r5 = this.mPrefetchArray;
            if (r5 == null) goto L5;
            Arrays.fill(r5, -1);
        L5:
            this.mCount = 0;
        }

        public void collectPrefetchPositionsFromView(RecyclerView r5, boolean r10) {
            this.mCount = 0;
            int[] r11 = this.mPrefetchArray;
            if (r11 == null) goto L5;
            Arrays.fill(r11, -1);
        L5:
            RecyclerView.LayoutManager r12 = r5.mLayout;
            if (r5.mAdapter == null) goto L21;
            if (r12 != null) goto L9;
            return;
        L9:
            if (r12.isItemPrefetchEnabled() == false) goto L23;
            if (r10 == false) goto L15;
            if (r5.mAdapterHelper.hasPendingUpdates() == true) goto L17;
            r12.collectInitialPrefetchPositions(r5.mAdapter.getItemCount(), this);
        L17:
            int r13 = this.mCount;
            if (r13 <= r12.mPrefetchMaxCountObserved) goto L24;
            r12.mPrefetchMaxCountObserved = r13;
            r12.mPrefetchMaxObservedInInitialPrefetch = r10;
            r5.mRecycler.updateViewCacheSize();
            return;
        L24:
            return;
        L15:
            if (r5.hasPendingAdapterUpdates() == true) goto L17;
            r12.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, r5.mState, this);
            goto L17
        L23:
            return;
        }

        public boolean lastPrefetchIncludedPosition(int r5) {
            if (this.mPrefetchArray == null) goto L11;
            int r10 = this.mCount * 2;
            int r11 = 0;
        L5:
            if (r11 >= r10) goto L11;
            if (this.mPrefetchArray[r11] == r5) goto L8;
            r11 = r11 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        public void setPrefetchVector(int r5, int r10) {
            this.mPrefetchDx = r5;
            this.mPrefetchDy = r10;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        public Task() {
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

    public GapWorker() {
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    private void buildTaskList() {
        int r5 = this.mRecyclerViews.size();
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r10 >= r5) goto L8;
        RecyclerView r12 = this.mRecyclerViews.get(r10);
        if (r12.getWindowVisibility() != 0) goto L7;
        r12.mPrefetchRegistry.collectPrefetchPositionsFromView(r12, false);
        r11 = r11 + r12.mPrefetchRegistry.mCount;
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        this.mTasks.ensureCapacity(r11);
        int r13 = 0;
        int r14 = 0;
    L9:
        if (r13 >= r5) goto L26;
        RecyclerView r15 = this.mRecyclerViews.get(r13);
        if (r15.getWindowVisibility() != 0) goto L25;
        LayoutPrefetchRegistryImpl r16 = r15.mPrefetchRegistry;
        int r17 = Math.abs(r16.mPrefetchDy) + Math.abs(r16.mPrefetchDx);
        int r18 = 0;
    L15:
        if (r18 >= (r16.mCount * 2)) goto L25;
        if (r14 < this.mTasks.size()) goto L19;
        Task r19 = new Task();
        this.mTasks.add(r19);
    L20:
        int[] r20 = r16.mPrefetchArray;
        int r110 = r20[r18 + 1];
        if (r110 > r17) goto L23;
        boolean r111 = true;
    L24:
        r19.immediate = r111;
        r19.viewVelocity = r17;
        r19.distanceToItem = r110;
        r19.view = r15;
        r19.position = r20[r18];
        r14 = r14 + 1;
        r18 = r18 + 2;
        goto L15
    L23:
        r111 = false;
        goto L24
    L19:
        r19 = this.mTasks.get(r14);
    L25:
        r13 = r13 + 1;
        goto L9
    L26:
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task r5, long r10) {
        if (r5.immediate == false) goto L5;
        long r11 = Long.MAX_VALUE;
    L6:
        RecyclerView.ViewHolder r12 = prefetchPositionWithDeadline(r5.view, r5.position, r11);
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.mNestedRecyclerView != null) goto L11;
        return;
    L11:
        if (r12.isBound() == true) goto L13;
        return;
    L13:
        if (r12.isInvalid() == true) goto L19;
        prefetchInnerRecyclerViewWithDeadline(r12.mNestedRecyclerView.get(), r10);
        return;
    L19:
        return;
    L5:
        r11 = r10;
        goto L6
    }

    private void flushTasksWithDeadline(long r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mTasks.size()) goto L9;
        Task r11 = this.mTasks.get(r10);
        if (r11.view == null) goto L12;
        flushTaskWithDeadline(r11, r5);
        r11.clear();
        r10 = r10 + 1;
        goto L4
    L12:
        return;
    }

    public static boolean isPrefetchPositionAttached(RecyclerView r5, int r10) {
        int r11 = r5.mChildHelper.getUnfilteredChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        RecyclerView.ViewHolder r13 = RecyclerView.getChildViewHolderInt(r5.mChildHelper.getUnfilteredChildAt(r12));
        if (r13.mPosition != r10) goto L10;
        if (r13.isInvalid() == true) goto L10;
        return true;
    L10:
        r12 = r12 + 1;
        goto L3
    L11:
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView r5, long r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        LayoutPrefetchRegistryImpl r11 = r5.mPrefetchRegistry;
        r11.collectPrefetchPositionsFromView(r5, true);
        if (r11.mCount != 0) goto L22;
        return;
    L22:
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L16
        r5.mState.prepareForNestedPrefetch(r5.mAdapter);     // Catch: Throwable -> L16
        int r12 = 0;
    L13:
        if (r12 >= (r11.mCount * 2)) goto L18;
        prefetchPositionWithDeadline(r5, r11.mPrefetchArray[r12], r10);     // Catch: Throwable -> L16
        r12 = r12 + 2;
        goto L13
    L18:
        TraceCompat.endSection();
        return;
    L16:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L7:
        if (r5.mChildHelper.getUnfilteredChildCount() == 0) goto L9;
        r5.removeAndRecycleViews();
        goto L9
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView r5, int r10, long r11) {
        if (isPrefetchPositionAttached(r5, r10) == false) goto L6;
        return null;
    L6:
        RecyclerView.Recycler r12 = r5.mRecycler;
        r5.onEnterLayoutOrScroll();     // Catch: Throwable -> L14
        RecyclerView.ViewHolder r13 = r12.tryGetViewHolderForPositionByDeadline(r10, false, r11);     // Catch: Throwable -> L14
        if (r13 != null) goto L10;
    L17:
        r5.onExitLayoutOrScroll(false);
        return r13;
    L10:
        if (r13.isBound() == true) goto L12;
    L16:
        r12.addViewHolderToRecycledViewPool(r13, false);     // Catch: Throwable -> L14
        goto L17
    L12:
        if (r13.isInvalid() == true) goto L16;
        r12.recycleView(r13.itemView);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r5.onExitLayoutOrScroll(false);
        throw th;
    }

    public void add(RecyclerView r5) {
        if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
    L9:
        this.mRecyclerViews.add(r5);
        return;
    L5:
        if (this.mRecyclerViews.contains(r5) == false) goto L9;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    public void postFromTraversal(RecyclerView r5, int r10, int r11) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L14:
        r5.mPrefetchRegistry.setPrefetchVector(r10, r11);
        return;
    L5:
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
        if (this.mRecyclerViews.contains(r5) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.mPostTimeNs != 0) goto L14;
        this.mPostTimeNs = r5.getNanoTime();
        r5.post(this);
        goto L14
    }

    public void prefetch(long r5) {
        buildTaskList();
        flushTasksWithDeadline(r5);
    }

    public void remove(RecyclerView r5) {
        boolean r10 = this.mRecyclerViews.remove(r5);
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L8;
        if (r10 == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("RecyclerView removal failed!");
    }

    @Override // java.lang.Runnable
    public void run() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L12
        if (this.mRecyclerViews.isEmpty() == false) goto L7;
    L5:
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r5 = this.mRecyclerViews.size();     // Catch: Throwable -> L12
        int r10 = 0;
        long r11 = 0;
    L8:
        if (r10 >= r5) goto L16;
        RecyclerView r12 = this.mRecyclerViews.get(r10);     // Catch: Throwable -> L12
        if (r12.getWindowVisibility() != 0) goto L14;
        r11 = Math.max(r12.getDrawingTime(), r11);     // Catch: Throwable -> L12
    L14:
        r10 = r10 + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        if (r11 == 0) goto L5;
        prefetch(TimeUnit.MILLISECONDS.toNanos(r11) + this.mFrameIntervalNs);     // Catch: Throwable -> L12
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L12:
        th = move-exception;
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        throw th;
    }
}
