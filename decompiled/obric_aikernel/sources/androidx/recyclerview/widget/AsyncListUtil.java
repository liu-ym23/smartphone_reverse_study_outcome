package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration;
    int mItemCount;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange;
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        public DataCallback() {
        }

        @WorkerThread
        public abstract void fillData(@NonNull T[] r10, int r11, int r12);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] r10, int r11) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public ViewCallback() {
        }

        @UiThread
        public void extendRangeInto(@NonNull int[] r10, @NonNull int[] r11, int r12) {
            int r13 = (r10[1] - r10[0]) + 1;
            int r14 = r13 / 2;
            int r15 = r10[0];
            if (r12 != 1) goto L5;
            int r16 = r13;
        L6:
            r11[0] = r15 - r16;
            int r17 = r10[1];
            if (r12 == 2) goto L10;
            r13 = r14;
        L10:
            r11[1] = r17 + r13;
            return;
        L5:
            r16 = r14;
            goto L6
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] r10);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int r10);
    }

    public AsyncListUtil(@NonNull Class<T> r10, int r11, @NonNull DataCallback<T> r12, @NonNull ViewCallback r13) {
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        ThreadUtil.MainThreadCallback<T> r14 = (ThreadUtil.MainThreadCallback<T>) new AnonymousClass1(this);
        this.mMainThreadCallback = r14;
        ThreadUtil.BackgroundCallback<T> r15 = (ThreadUtil.BackgroundCallback<T>) new AnonymousClass2(this);
        this.mBackgroundCallback = r15;
        this.mTClass = r10;
        this.mTileSize = r11;
        this.mDataCallback = r12;
        this.mViewCallback = r13;
        this.mTileList = new TileList(r11);
        MessageThreadUtil r16 = new MessageThreadUtil();
        this.mMainThreadProxy = r16.getMainThreadProxy(r14);
        this.mBackgroundProxy = r16.getBackgroundProxy(r15);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration == this.mDisplayedGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public T getItem(int r10) {
        if (r10 < 0) goto L12;
        if (r10 >= this.mItemCount) goto L12;
        T r11 = this.mTileList.getItemAt(r10);
        if (r11 == null) goto L8;
    L10:
        return r11;
    L8:
        if (isRefreshPending() == true) goto L10;
        this.mMissingPositions.put(r10, 0);
    L12:
        throw new IndexOutOfBoundsException(r10 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void log(String r10, Object... r11) {
        Log.d(TAG, "[MAIN] " + String.format(r10, r11));
    }

    public void onRangeChanged() {
        if (isRefreshPending() == false) goto L5;
        return;
    L5:
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> r10 = this.mBackgroundProxy;
        int r11 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = r11;
        r10.refresh(r11);
    }

    void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] r10 = this.mTmpRange;
        if (r10[0] <= r10[1]) goto L5;
        return;
    L5:
        if (r10[0] >= 0) goto L8;
        return;
    L8:
        if (r10[1] < this.mItemCount) goto L11;
        return;
    L11:
        if (this.mAllowScrollHints == true) goto L13;
    L12:
        this.mScrollHint = 0;
    L24:
        int[] r11 = this.mPrevRange;
        r11[0] = r10[0];
        r11[1] = r10[1];
        this.mViewCallback.extendRangeInto(r10, this.mTmpRangeExtended, this.mScrollHint);
        int[] r12 = this.mTmpRangeExtended;
        r12[0] = Math.min(this.mTmpRange[0], Math.max(r12[0], 0));
        int[] r13 = this.mTmpRangeExtended;
        r13[1] = Math.max(this.mTmpRange[1], Math.min(r13[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> r14 = this.mBackgroundProxy;
        int[] r15 = this.mTmpRange;
        int r16 = r15[0];
        int r17 = r15[1];
        int[] r18 = this.mTmpRangeExtended;
        r14.updateRange(r16, r17, r18[0], r18[1], this.mScrollHint);
        return;
    L13:
        int r19 = r10[0];
        int[] r20 = this.mPrevRange;
        if (r19 > r20[1]) goto L12;
        if (r20[0] > r10[1]) goto L12;
        if (r10[0] >= r20[0]) goto L22;
        this.mScrollHint = 1;
        goto L24
    L22:
        if (r10[0] <= r20[0]) goto L24;
        this.mScrollHint = 2;
        goto L24
    }
}
