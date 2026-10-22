package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;

    @VisibleForTesting
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;

    @VisibleForTesting
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders;

    static class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static Pools.Pool<InfoRecord> sPool;
        int flags;

        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;

        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        static {
            sPool = new Pools.SimplePool(20);
        }

        private InfoRecord() {
        }

        static void drainCache() {
        L3:
            if (sPool.acquire() != null) goto L3;
        }

        static InfoRecord obtain() {
            InfoRecord r10 = sPool.acquire();
            if (r10 == null) goto L5;
            return r10;
        L5:
            return new InfoRecord();
        }

        static void recycle(InfoRecord r10) {
            r10.flags = 0;
            r10.preInfo = null;
            r10.postInfo = null;
            sPool.release(r10);
        }
    }

    interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder r10, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r11, RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void processDisappeared(RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void processPersistent(RecyclerView.ViewHolder r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r12);

        void unused(RecyclerView.ViewHolder r10);
    }

    ViewInfoStore() {
        this.mLayoutHolderMap = new SimpleArrayMap();
        this.mOldChangedHolders = new LongSparseArray();
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder r10, int r11) {
        int r12 = this.mLayoutHolderMap.indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        InfoRecord r13 = this.mLayoutHolderMap.valueAt(r12);
        if (r13 == null) goto L21;
        int r14 = r13.flags;
        if ((r14 & r11) == 0) goto L21;
        int r15 = (~r11) & r14;
        r13.flags = r15;
        if (r11 != 4) goto L13;
        RecyclerView.ItemAnimator.ItemHolderInfo r16 = r13.preInfo;
    L16:
        if ((r15 & 12) != 0) goto L18;
        this.mLayoutHolderMap.removeAt(r12);
        InfoRecord.recycle(r13);
    L18:
        return r16;
    L13:
        if (r11 != 8) goto L20;
        r16 = r13.postInfo;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        InfoRecord r12 = this.mLayoutHolderMap.get(r10);
        if (r12 != null) goto L5;
        r12 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r10, r12);
    L5:
        r12.flags |= 2;
        r12.preInfo = r11;
    }

    void addToDisappearedInLayout(RecyclerView.ViewHolder r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r10);
        if (r11 != null) goto L5;
        r11 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r10, r11);
    L5:
        r11.flags |= 1;
    }

    void addToOldChangeHolders(long r10, RecyclerView.ViewHolder r11) {
        this.mOldChangedHolders.put(r10, r11);
    }

    void addToPostLayout(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        InfoRecord r12 = this.mLayoutHolderMap.get(r10);
        if (r12 != null) goto L5;
        r12 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r10, r12);
    L5:
        r12.postInfo = r11;
        r12.flags |= 8;
    }

    void addToPreLayout(RecyclerView.ViewHolder r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        InfoRecord r12 = this.mLayoutHolderMap.get(r10);
        if (r12 != null) goto L5;
        r12 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r10, r12);
    L5:
        r12.preInfo = r11;
        r12.flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    RecyclerView.ViewHolder getFromOldChangeHolders(long r10) {
        return this.mOldChangedHolders.get(r10);
    }

    boolean isDisappearing(RecyclerView.ViewHolder r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r11.flags & 1) == 0) goto L7;
        return true;
    }

    boolean isInPreLayout(RecyclerView.ViewHolder r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r11.flags & 4) == 0) goto L7;
        return true;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder r10) {
        removeFromDisappearedInLayout(r10);
    }

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder r10) {
        return popFromLayoutStep(r10, 8);
    }

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder r10) {
        return popFromLayoutStep(r10, 4);
    }

    void process(ProcessCallback r10) {
        int r11 = this.mLayoutHolderMap.size() - 1;
    L3:
        if (r11 < 0) goto L27;
        RecyclerView.ViewHolder r12 = this.mLayoutHolderMap.keyAt(r11);
        InfoRecord r13 = this.mLayoutHolderMap.removeAt(r11);
        int r14 = r13.flags;
        if ((r14 & 3) != 3) goto L8;
    L6:
        r10.unused(r12);
    L26:
        InfoRecord.recycle(r13);
        r11 = r11 - 1;
        goto L3
    L8:
        if ((r14 & 1) == 0) goto L15;
        RecyclerView.ItemAnimator.ItemHolderInfo r15 = r13.preInfo;
        if (r15 == null) goto L6;
        RecyclerView.ItemAnimator.ItemHolderInfo r16 = r13.postInfo;
    L13:
        r10.processDisappeared(r12, r15, r16);
        goto L26
    L15:
        if ((r14 & 14) != 14) goto L18;
    L16:
        r10.processAppeared(r12, r13.preInfo, r13.postInfo);
        goto L26
    L18:
        if ((r14 & 12) != 12) goto L21;
        r10.processPersistent(r12, r13.preInfo, r13.postInfo);
        goto L26
    L21:
        if ((r14 & 4) == 0) goto L24;
        r15 = r13.preInfo;
        r16 = null;
        goto L13
    L24:
        if ((r14 & 8) == 0) goto L26;
    }

    void removeFromDisappearedInLayout(RecyclerView.ViewHolder r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.flags &= -2;
    }

    void removeViewHolder(RecyclerView.ViewHolder r10) {
        int r11 = this.mOldChangedHolders.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10 == this.mOldChangedHolders.valueAt(r11)) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        this.mOldChangedHolders.removeAt(r11);
    L8:
        InfoRecord r12 = this.mLayoutHolderMap.remove(r10);
        if (r12 == null) goto L14;
        InfoRecord.recycle(r12);
        return;
    }
}
