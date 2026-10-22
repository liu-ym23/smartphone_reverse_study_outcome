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

    public static class InfoRecord {
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

        public static void drainCache() {
        L3:
            if (sPool.acquire() != null) goto L3;
        }

        public static InfoRecord obtain() {
            InfoRecord r5 = sPool.acquire();
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new InfoRecord();
        }

        public static void recycle(InfoRecord r5) {
            r5.flags = 0;
            r5.preInfo = null;
            r5.postInfo = null;
            sPool.release(r5);
        }
    }

    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder r5, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r10, RecyclerView.ItemAnimator.ItemHolderInfo r11);

        void processDisappeared(RecyclerView.ViewHolder r5, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r10, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r11);

        void processPersistent(RecyclerView.ViewHolder r5, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11);

        void unused(RecyclerView.ViewHolder r5);
    }

    public ViewInfoStore() {
        this.mLayoutHolderMap = new SimpleArrayMap();
        this.mOldChangedHolders = new LongSparseArray();
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder r5, int r10) {
        int r11 = this.mLayoutHolderMap.indexOfKey(r5);
        if (r11 >= 0) goto L5;
        return null;
    L5:
        InfoRecord r12 = this.mLayoutHolderMap.valueAt(r11);
        if (r12 == null) goto L21;
        int r13 = r12.flags;
        if ((r13 & r10) == 0) goto L21;
        int r14 = (~r10) & r13;
        r12.flags = r14;
        if (r10 != 4) goto L13;
        RecyclerView.ItemAnimator.ItemHolderInfo r15 = r12.preInfo;
    L16:
        if ((r14 & 12) != 0) goto L18;
        this.mLayoutHolderMap.removeAt(r11);
        InfoRecord.recycle(r12);
    L18:
        return r15;
    L13:
        if (r10 != 8) goto L20;
        r15 = r12.postInfo;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder r5, RecyclerView.ItemAnimator.ItemHolderInfo r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r5);
        if (r11 != null) goto L5;
        r11 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r5, r11);
    L5:
        r11.flags |= 2;
        r11.preInfo = r10;
    }

    public void addToDisappearedInLayout(RecyclerView.ViewHolder r5) {
        InfoRecord r10 = this.mLayoutHolderMap.get(r5);
        if (r10 != null) goto L5;
        r10 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r5, r10);
    L5:
        r10.flags |= 1;
    }

    public void addToOldChangeHolders(long r5, RecyclerView.ViewHolder r10) {
        this.mOldChangedHolders.put(r5, r10);
    }

    public void addToPostLayout(RecyclerView.ViewHolder r5, RecyclerView.ItemAnimator.ItemHolderInfo r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r5);
        if (r11 != null) goto L5;
        r11 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r5, r11);
    L5:
        r11.postInfo = r10;
        r11.flags |= 8;
    }

    public void addToPreLayout(RecyclerView.ViewHolder r5, RecyclerView.ItemAnimator.ItemHolderInfo r10) {
        InfoRecord r11 = this.mLayoutHolderMap.get(r5);
        if (r11 != null) goto L5;
        r11 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r5, r11);
    L5:
        r11.preInfo = r10;
        r11.flags |= 4;
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    public RecyclerView.ViewHolder getFromOldChangeHolders(long r5) {
        return this.mOldChangedHolders.get(r5);
    }

    public boolean isDisappearing(RecyclerView.ViewHolder r5) {
        InfoRecord r10 = this.mLayoutHolderMap.get(r5);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r10.flags & 1) == 0) goto L7;
        return true;
    }

    public boolean isInPreLayout(RecyclerView.ViewHolder r5) {
        InfoRecord r10 = this.mLayoutHolderMap.get(r5);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r10.flags & 4) == 0) goto L7;
        return true;
    }

    public void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder r5) {
        removeFromDisappearedInLayout(r5);
    }

    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder r5) {
        return popFromLayoutStep(r5, 8);
    }

    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder r5) {
        return popFromLayoutStep(r5, 4);
    }

    public void process(ProcessCallback r10) {
        int r5 = this.mLayoutHolderMap.size() - 1;
    L3:
        if (r5 < 0) goto L26;
        RecyclerView.ViewHolder r11 = this.mLayoutHolderMap.keyAt(r5);
        InfoRecord r12 = this.mLayoutHolderMap.removeAt(r5);
        int r13 = r12.flags;
        if ((r13 & 3) != 3) goto L8;
        r10.unused(r11);
    L25:
        InfoRecord.recycle(r12);
        r5 = r5 - 1;
        goto L3
    L8:
        if ((r13 & 1) == 0) goto L14;
        RecyclerView.ItemAnimator.ItemHolderInfo r14 = r12.preInfo;
        if (r14 != null) goto L12;
        r10.unused(r11);
        goto L25
    L12:
        r10.processDisappeared(r11, r14, r12.postInfo);
        goto L25
    L14:
        if ((r13 & 14) != 14) goto L17;
        r10.processAppeared(r11, r12.preInfo, r12.postInfo);
        goto L25
    L17:
        if ((r13 & 12) != 12) goto L20;
        r10.processPersistent(r11, r12.preInfo, r12.postInfo);
        goto L25
    L20:
        if ((r13 & 4) == 0) goto L23;
        r10.processDisappeared(r11, r12.preInfo, null);
        goto L25
    L23:
        if ((r13 & 8) == 0) goto L25;
        r10.processAppeared(r11, r12.preInfo, r12.postInfo);
        goto L25
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder r5) {
        InfoRecord r10 = this.mLayoutHolderMap.get(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.flags &= -2;
    }

    public void removeViewHolder(RecyclerView.ViewHolder r5) {
        int r10 = this.mOldChangedHolders.size() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (r5 == this.mOldChangedHolders.valueAt(r10)) goto L6;
        r10 = r10 - 1;
        goto L3
    L6:
        this.mOldChangedHolders.removeAt(r10);
    L8:
        InfoRecord r11 = this.mLayoutHolderMap.remove(r5);
        if (r11 == null) goto L14;
        InfoRecord.recycle(r11);
        return;
    }
}
