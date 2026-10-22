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
        public abstract void fillData(@NonNull T[] r5, int r10, int r11);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] r5, int r10) {
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
            int r5 = r10[1];
            int r13 = r10[0];
            int r14 = (r5 - r13) + 1;
            int r15 = r14 / 2;
            if (r12 != 1) goto L5;
            int r16 = r14;
        L6:
            r11[0] = r13 - r16;
            if (r12 == 2) goto L10;
            r14 = r15;
        L10:
            r11[1] = r5 + r14;
            return;
        L5:
            r16 = r15;
            goto L6
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] r5);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int r5);
    }

    public AsyncListUtil(@NonNull Class<T> r5, int r10, @NonNull DataCallback<T> r11, @NonNull ViewCallback r12) {
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        ThreadUtil.MainThreadCallback<T> r13 = new AnonymousClass1(this);
        this.mMainThreadCallback = r13;
        ThreadUtil.BackgroundCallback<T> r14 = new AnonymousClass2(this);
        this.mBackgroundCallback = r14;
        this.mTClass = r5;
        this.mTileSize = r10;
        this.mDataCallback = r11;
        this.mViewCallback = r12;
        this.mTileList = new TileList(r10);
        MessageThreadUtil r15 = new MessageThreadUtil();
        this.mMainThreadProxy = r15.getMainThreadProxy(r13);
        this.mBackgroundProxy = r15.getBackgroundProxy(r14);
        refresh();
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration == this.mDisplayedGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public T getItem(int r5) {
        if (r5 < 0) goto L12;
        if (r5 >= this.mItemCount) goto L12;
        T r10 = this.mTileList.getItemAt(r5);
        if (r10 == null) goto L8;
    L10:
        return r10;
    L8:
        if (isRefreshPending() == true) goto L10;
        this.mMissingPositions.put(r5, 0);
    L12:
        throw new IndexOutOfBoundsException(r5 + " is not within 0 and " + this.mItemCount);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String r5, Object... r10) {
        Log.d(TAG, "[MAIN] ".concat(String.format(r5, r10)));
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
        ThreadUtil.BackgroundCallback<T> r5 = this.mBackgroundProxy;
        int r10 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = r10;
        r5.refresh(r10);
    }

    public void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] r5 = this.mTmpRange;
        int r10 = r5[0];
        int r11 = r5[1];
        if (r10 > r11) goto L24;
        if (r10 >= 0) goto L7;
        return;
    L7:
        if (r11 < this.mItemCount) goto L10;
        return;
    L10:
        if (this.mAllowScrollHints == true) goto L12;
        this.mScrollHint = 0;
    L22:
        int[] r12 = this.mPrevRange;
        r12[0] = r10;
        r12[1] = r11;
        this.mViewCallback.extendRangeInto(r5, this.mTmpRangeExtended, this.mScrollHint);
        int[] r13 = this.mTmpRangeExtended;
        r13[0] = Math.min(this.mTmpRange[0], Math.max(r13[0], 0));
        int[] r14 = this.mTmpRangeExtended;
        r14[1] = Math.max(this.mTmpRange[1], Math.min(r14[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> r15 = this.mBackgroundProxy;
        int[] r16 = this.mTmpRange;
        int r17 = r16[0];
        int r18 = r16[1];
        int[] r19 = this.mTmpRangeExtended;
        r15.updateRange(r17, r18, r19[0], r19[1], this.mScrollHint);
        return;
    L12:
        int[] r20 = this.mPrevRange;
        if (r10 > r20[1]) goto L21;
        int r21 = r20[0];
        if (r21 > r11) goto L21;
        if (r10 >= r21) goto L19;
        this.mScrollHint = 1;
        goto L22
    L19:
        if (r10 <= r21) goto L22;
        this.mScrollHint = 2;
    L21:
        this.mScrollHint = 0;
        goto L22
    }
}
