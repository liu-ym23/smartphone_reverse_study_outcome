package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;
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
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
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
            InfoRecord r0 = (InfoRecord) ZeusTransformUtils.preCheckCast(sPool.acquire(), InfoRecord.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new InfoRecord();
        }

        static void recycle(InfoRecord r1) {
            r1.flags = 0;
            r1.preInfo = null;
            r1.postInfo = null;
            sPool.release(r1);
        }
    }

    interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder r1, RecyclerView.ItemAnimator.ItemHolderInfo r2, RecyclerView.ItemAnimator.ItemHolderInfo r3);

        void processDisappeared(RecyclerView.ViewHolder r1, RecyclerView.ItemAnimator.ItemHolderInfo r2, RecyclerView.ItemAnimator.ItemHolderInfo r3);

        void processPersistent(RecyclerView.ViewHolder r1, RecyclerView.ItemAnimator.ItemHolderInfo r2, RecyclerView.ItemAnimator.ItemHolderInfo r3);

        void unused(RecyclerView.ViewHolder r1);
    }

    ViewInfoStore() {
        this.mLayoutHolderMap = new SimpleArrayMap();
        this.mOldChangedHolders = new LongSparseArray();
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder r5, int r6) {
        int r7 = this.mLayoutHolderMap.indexOfKey(r5);
        if (r7 >= 0) goto L5;
        return null;
    L5:
        InfoRecord r1 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.valueAt(r7), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L21:
        return null;
    L8:
        if ((r1.flags & r6) == 0) goto L21;
        r1.flags &= ~r6;
        if (r6 != 4) goto L13;
        RecyclerView.ItemAnimator.ItemHolderInfo r8 = r1.preInfo;
    L16:
        if ((r1.flags & 12) != 0) goto L18;
        this.mLayoutHolderMap.removeAt(r7);
        InfoRecord.recycle(r1);
    L18:
        return r8;
    L13:
        if (r6 != 8) goto L20;
        r8 = r1.postInfo;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    }

    void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder r4, RecyclerView.ItemAnimator.ItemHolderInfo r5) {
        InfoRecord r0 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r4), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r4, r0);
    L5:
        r0.flags |= 2;
        r0.preInfo = r5;
    }

    void addToDisappearedInLayout(RecyclerView.ViewHolder r4) {
        InfoRecord r0 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r4), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r4, r0);
    L5:
        r0.flags |= 1;
    }

    void addToOldChangeHolders(long r1, RecyclerView.ViewHolder r3) {
        this.mOldChangedHolders.put(r1, r3);
    }

    void addToPostLayout(RecyclerView.ViewHolder r4, RecyclerView.ItemAnimator.ItemHolderInfo r5) {
        InfoRecord r0 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r4), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r4, r0);
    L5:
        r0.postInfo = r5;
        r0.flags |= 8;
    }

    void addToPreLayout(RecyclerView.ViewHolder r4, RecyclerView.ItemAnimator.ItemHolderInfo r5) {
        InfoRecord r0 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r4), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r4, r0);
    L5:
        r0.preInfo = r5;
        r0.flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    RecyclerView.ViewHolder getFromOldChangeHolders(long r1) {
        return (RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(this.mOldChangedHolders.get(r1), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin");
    }

    boolean isDisappearing(RecyclerView.ViewHolder r2) {
        InfoRecord r1 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r2), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.flags & 1) == 0) goto L7;
        return true;
    }

    boolean isInPreLayout(RecyclerView.ViewHolder r2) {
        InfoRecord r1 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r2), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.flags & 4) == 0) goto L7;
        return true;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder r1) {
        removeFromDisappearedInLayout(r1);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder r2) {
        return popFromLayoutStep(r2, 8);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder r2) {
        return popFromLayoutStep(r2, 4);
    }

    void process(ProcessCallback r7) {
        ProcessCallback r8 = (ProcessCallback) ZeusTransformUtils.wrapperContextForParams(r7, ProcessCallback.class, "com.obric.memorydata.plugin");
        int r0 = this.mLayoutHolderMap.size() - 1;
    L3:
        if (r0 < 0) goto L28;
        RecyclerView.ViewHolder r2 = (RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.keyAt(r0), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin");
        InfoRecord r3 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.removeAt(r0), InfoRecord.class, "com.obric.memorydata.plugin");
        if ((r3.flags & 3) != 3) goto L8;
    L6:
        r8.unused(r2);
    L27:
        InfoRecord.recycle(r3);
        r0 = r0 - 1;
        goto L3
    L8:
        if ((r3.flags & 1) == 0) goto L15;
        if (r3.preInfo == null) goto L6;
        RecyclerView.ItemAnimator.ItemHolderInfo r4 = r3.preInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo r5 = r3.postInfo;
    L13:
        r8.processDisappeared(r2, r4, r5);
        goto L27
    L15:
        if ((r3.flags & 14) != 14) goto L18;
    L16:
        r8.processAppeared(r2, r3.preInfo, r3.postInfo);
        goto L27
    L18:
        if ((r3.flags & 12) != 12) goto L21;
        r8.processPersistent(r2, r3.preInfo, r3.postInfo);
        goto L27
    L21:
        if ((r3.flags & 4) == 0) goto L24;
        r4 = r3.preInfo;
        r5 = null;
        goto L13
    L24:
        if ((r3.flags & 8) != 0) goto L16;
        int r6 = r3.flags;
        goto L27
    }

    void removeFromDisappearedInLayout(RecyclerView.ViewHolder r2) {
        InfoRecord r1 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.get(r2), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        r1.flags &= -2;
    }

    void removeViewHolder(RecyclerView.ViewHolder r3) {
        int r0 = this.mOldChangedHolders.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3 == this.mOldChangedHolders.valueAt(r0)) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        this.mOldChangedHolders.removeAt(r0);
    L8:
        InfoRecord r2 = (InfoRecord) ZeusTransformUtils.preCheckCast(this.mLayoutHolderMap.remove(r3), InfoRecord.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        InfoRecord.recycle(r2);
        return;
    }
}
