package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    interface Callback {
        RecyclerView.ViewHolder findViewHolder(int r10);

        void markViewHoldersUpdated(int r10, int r11, Object r12);

        void offsetPositionsForAdd(int r10, int r11);

        void offsetPositionsForMove(int r10, int r11);

        void offsetPositionsForRemovingInvisible(int r10, int r11);

        void offsetPositionsForRemovingLaidOutOrNewView(int r10, int r11);

        void onDispatchFirstPass(UpdateOp r10);

        void onDispatchSecondPass(UpdateOp r10);
    }

    static class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        UpdateOp(int r10, int r11, int r12, Object r13) {
            this.cmd = r10;
            this.positionStart = r11;
            this.itemCount = r12;
            this.payload = r13;
        }

        String cmdToString() {
            int r10 = this.cmd;
            if (r10 != 1) goto L5;
            return "add";
        L5:
            if (r10 != 2) goto L7;
            return "rm";
        L7:
            if (r10 != 4) goto L9;
            return "up";
        L9:
            if (r10 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L37:
            return false;
        L8:
            if (getClass() != r10.getClass()) goto L37;
            UpdateOp r11 = (UpdateOp) r10;
            int r12 = this.cmd;
            if (r12 == r11.cmd) goto L14;
            return false;
        L14:
            if (r12 != 8) goto L23;
            if (Math.abs(this.itemCount - this.positionStart) != 1) goto L23;
            if (this.itemCount != r11.positionStart) goto L23;
            if (this.positionStart != r11.itemCount) goto L23;
            return true;
        L23:
            if (this.itemCount == r11.itemCount) goto L26;
            return false;
        L26:
            if (this.positionStart == r11.positionStart) goto L28;
            return false;
        L28:
            Object r13 = this.payload;
            if (r13 == null) goto L34;
            if (r13.equals(r11.payload) == true) goto L36;
            return false;
        L36:
            return true;
        L34:
            if (r11.payload == null) goto L36;
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    AdapterHelper(Callback r10) {
        this(r10, false);
    }

    AdapterHelper(Callback r10, boolean r11) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = r10;
        this.mDisableRecycler = r11;
        this.mOpReorderer = new OpReorderer(this);
    }

    private void applyAdd(UpdateOp r10) {
        postponeAndUpdateViewHolders(r10);
    }

    private void applyMove(UpdateOp r10) {
        postponeAndUpdateViewHolders(r10);
    }

    private void applyRemove(UpdateOp r11) {
        int r10 = r11.positionStart;
        int r12 = r11.itemCount + r10;
        byte r13 = -1;
        int r14 = r10;
        int r15 = 0;
    L4:
        if (r14 >= r12) goto L23;
        if (this.mCallback.findViewHolder(r14) == null) goto L8;
    L14:
        if (r13 != 0) goto L16;
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, r10, r15, null));
        boolean r16 = true;
    L17:
        byte r17 = 1;
    L18:
        if (r16 == false) goto L20;
        r14 = r14 - r15;
        r12 = r12 - r15;
        r15 = 1;
    L21:
        r14 = r14 + 1;
        r13 = r17;
        goto L4
    L20:
        r15 = r15 + 1;
        goto L21
    L16:
        r16 = false;
        goto L17
    L8:
        if (canFindInPreLayout(r14) == true) goto L14;
        if (r13 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(2, r10, r15, null));
        r16 = true;
    L13:
        r17 = 0;
        goto L18
    L12:
        r16 = false;
        goto L13
    L23:
        if (r15 == r11.itemCount) goto L25;
        recycleUpdateOp(r11);
        r11 = obtainUpdateOp(2, r10, r15, null);
    L25:
        if (r13 != 0) goto L27;
        dispatchAndUpdateViewHolders(r11);
        return;
    L27:
        postponeAndUpdateViewHolders(r11);
    }

    private void applyUpdate(UpdateOp r10) {
        int r11 = r10.positionStart;
        int r12 = r10.itemCount + r11;
        int r13 = 0;
        byte r14 = -1;
        int r15 = r11;
    L4:
        if (r11 >= r12) goto L18;
        if (this.mCallback.findViewHolder(r11) == null) goto L8;
    L13:
        if (r14 != 0) goto L15;
        dispatchAndUpdateViewHolders(obtainUpdateOp(4, r15, r13, r10.payload));
        r15 = r11;
        r13 = 0;
    L15:
        r14 = 1;
    L16:
        r13 = r13 + 1;
        r11 = r11 + 1;
        goto L4
    L8:
        if (canFindInPreLayout(r11) == true) goto L13;
        if (r14 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(4, r15, r13, r10.payload));
        r15 = r11;
        r13 = 0;
    L12:
        r14 = 0;
        goto L16
    L18:
        if (r13 == r10.itemCount) goto L20;
        Object r16 = r10.payload;
        recycleUpdateOp(r10);
        r10 = obtainUpdateOp(4, r15, r13, r16);
    L20:
        if (r14 != 0) goto L22;
        dispatchAndUpdateViewHolders(r10);
        return;
    L22:
        postponeAndUpdateViewHolders(r10);
    }

    private boolean canFindInPreLayout(int r10) {
        int r11 = this.mPostponedList.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        UpdateOp r13 = this.mPostponedList.get(r12);
        int r14 = r13.cmd;
        if (r14 == 8) goto L7;
        if (r14 != 1) goto L16;
        int r15 = r13.positionStart;
        int r16 = r13.itemCount + r15;
    L11:
        if (r15 >= r16) goto L16;
        if (findPositionOffset(r15, r12 + 1) == r10) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return true;
    L16:
        r12 = r12 + 1;
        goto L3
    L7:
        if (findPositionOffset(r13.itemCount, r12 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp r13) {
        int r10 = r13.cmd;
        if (r10 == 1) goto L37;
        if (r10 == 8) goto L37;
        int r11 = updatePositionWithPostponed(r13.positionStart, r10);
        int r12 = r13.positionStart;
        int r14 = r13.cmd;
        if (r14 == 2) goto L12;
        if (r14 != 4) goto L11;
        int r15 = 1;
    L13:
        int r16 = 1;
        int r17 = 1;
    L15:
        if (r16 >= r13.itemCount) goto L32;
        int r18 = updatePositionWithPostponed(r13.positionStart + (r15 * r16), r13.cmd);
        int r19 = r13.cmd;
        if (r19 == 2) goto L23;
        if (r19 == 4) goto L21;
    L19:
        boolean r110 = false;
    L25:
        if (r110 == false) goto L27;
        r17 = r17 + 1;
    L31:
        r16 = r16 + 1;
        goto L15
    L27:
        UpdateOp r20 = obtainUpdateOp(r19, r11, r17, r13.payload);
        dispatchFirstPassAndUpdateViewHolders(r20, r12);
        recycleUpdateOp(r20);
        if (r13.cmd != 4) goto L30;
        r12 = r12 + r17;
    L30:
        r17 = 1;
        r11 = r18;
        goto L31
    L21:
        if (r18 != (r11 + 1)) goto L19;
    L22:
        r110 = true;
        goto L25
    L23:
        if (r18 != r11) goto L19;
    L32:
        Object r21 = r13.payload;
        recycleUpdateOp(r13);
        if (r17 <= 0) goto L41;
        UpdateOp r111 = obtainUpdateOp(r13.cmd, r11, r17, r21);
        dispatchFirstPassAndUpdateViewHolders(r111, r12);
        recycleUpdateOp(r111);
        return;
    L41:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r13);
    L12:
        r15 = 0;
    L37:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void postponeAndUpdateViewHolders(UpdateOp r10) {
        this.mPostponedList.add(r10);
        int r11 = r10.cmd;
        if (r11 != 1) goto L5;
        this.mCallback.offsetPositionsForAdd(r10.positionStart, r10.itemCount);
        return;
    L5:
        if (r11 != 2) goto L7;
        this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(r10.positionStart, r10.itemCount);
        return;
    L7:
        if (r11 != 4) goto L9;
        this.mCallback.markViewHoldersUpdated(r10.positionStart, r10.itemCount, r10.payload);
        return;
    L9:
        if (r11 != 8) goto L12;
        this.mCallback.offsetPositionsForMove(r10.positionStart, r10.itemCount);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r10);
    }

    private int updatePositionWithPostponed(int r10, int r11) {
        int r12 = this.mPostponedList.size() - 1;
    L4:
        if (r12 < 0) goto L44;
        UpdateOp r13 = this.mPostponedList.get(r12);
        int r14 = r13.cmd;
        if (r14 != 8) goto L32;
        int r15 = r13.positionStart;
        int r16 = r13.itemCount;
        if (r15 >= r16) goto L10;
        int r17 = r15;
        int r18 = r16;
    L11:
        if (r10 < r17) goto L26;
        if (r10 > r18) goto L26;
        if (r17 != r15) goto L20;
        if (r11 != 1) goto L17;
        int r19 = r16 + 1;
    L16:
        r13.itemCount = r19;
    L19:
        r10 = r10 + 1;
    L43:
        r12 = r12 - 1;
        goto L4
    L17:
        if (r11 != 2) goto L19;
        r19 = r16 - 1;
        goto L16
    L20:
        if (r11 != 1) goto L23;
        int r20 = r15 + 1;
    L22:
        r13.positionStart = r20;
    L25:
        r10 = r10 - 1;
        goto L43
    L23:
        if (r11 != 2) goto L25;
        r20 = r15 - 1;
    L26:
        if (r10 >= r15) goto L43;
        if (r11 != 1) goto L30;
        r13.positionStart = r15 + 1;
        int r21 = r16 + 1;
    L29:
        r13.itemCount = r21;
        goto L43
    L30:
        if (r11 != 2) goto L43;
        r13.positionStart = r15 - 1;
        r21 = r16 - 1;
        goto L29
    L10:
        r18 = r15;
        r17 = r16;
        goto L11
    L32:
        int r22 = r13.positionStart;
        if (r22 > r10) goto L38;
        if (r14 != 1) goto L36;
        r10 = r10 - r13.itemCount;
        goto L43
    L36:
        if (r14 != 2) goto L43;
        r10 = r10 + r13.itemCount;
        goto L43
    L38:
        if (r11 != 1) goto L41;
        int r23 = r22 + 1;
    L40:
        r13.positionStart = r23;
        goto L43
    L41:
        if (r11 != 2) goto L43;
        r23 = r22 - 1;
        goto L40
    L44:
        int r110 = this.mPostponedList.size() - 1;
    L45:
        if (r110 < 0) goto L56;
        UpdateOp r24 = this.mPostponedList.get(r110);
        if (r24.cmd != 8) goto L53;
        int r25 = r24.itemCount;
        if (r25 == r24.positionStart) goto L54;
        if (r25 < 0) goto L54;
    L55:
        r110 = r110 - 1;
    L54:
        this.mPostponedList.remove(r110);
        recycleUpdateOp(r24);
        goto L55
    L53:
        if (r24.itemCount > 0) goto L55;
    L56:
        return r10;
    }

    AdapterHelper addUpdateOp(UpdateOp... r10) {
        Collections.addAll(this.mPendingUpdates, r10);
        return this;
    }

    public int applyPendingUpdatesToPosition(int r10) {
        int r11 = this.mPendingUpdates.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L30;
        UpdateOp r13 = this.mPendingUpdates.get(r12);
        int r14 = r13.cmd;
        if (r14 == 1) goto L27;
        if (r14 != 2) goto L9;
        int r15 = r13.positionStart;
        if (r15 > r10) goto L29;
        int r16 = r13.itemCount;
        if ((r15 + r16) > r10) goto L23;
        r10 = r10 - r16;
        goto L29
    L23:
        return -1;
    L29:
        r12 = r12 + 1;
        goto L3
    L9:
        if (r14 != 8) goto L29;
        int r17 = r13.positionStart;
        if (r17 != r10) goto L14;
        r10 = r13.itemCount;
        goto L29
    L14:
        if (r17 >= r10) goto L17;
        r10 = r10 - 1;
    L17:
        if (r13.itemCount > r10) goto L29;
        r10 = r10 + 1;
        goto L29
    L27:
        if (r13.positionStart > r10) goto L29;
        r10 = r10 + r13.itemCount;
        goto L29
    L30:
        return r10;
    }

    void consumePostponedUpdates() {
        int r10 = this.mPostponedList.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mCallback.onDispatchSecondPass(this.mPostponedList.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int r10 = this.mPendingUpdates.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        UpdateOp r12 = this.mPendingUpdates.get(r11);
        int r13 = r12.cmd;
        if (r13 != 1) goto L7;
        this.mCallback.onDispatchSecondPass(r12);
        this.mCallback.offsetPositionsForAdd(r12.positionStart, r12.itemCount);
    L17:
        Runnable r14 = this.mOnItemProcessedCallback;
        if (r14 == null) goto L20;
        r14.run();
    L20:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        this.mCallback.onDispatchSecondPass(r12);
        this.mCallback.offsetPositionsForRemovingInvisible(r12.positionStart, r12.itemCount);
        goto L17
    L9:
        if (r13 != 4) goto L11;
        this.mCallback.onDispatchSecondPass(r12);
        this.mCallback.markViewHoldersUpdated(r12.positionStart, r12.itemCount, r12.payload);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        this.mCallback.onDispatchSecondPass(r12);
        this.mCallback.offsetPositionsForMove(r12.positionStart, r12.itemCount);
        goto L17
    L21:
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp r10, int r11) {
        this.mCallback.onDispatchFirstPass(r10);
        int r12 = r10.cmd;
        if (r12 != 2) goto L5;
        this.mCallback.offsetPositionsForRemovingInvisible(r11, r10.itemCount);
        return;
    L5:
        if (r12 != 4) goto L8;
        this.mCallback.markViewHoldersUpdated(r11, r10.itemCount, r10.payload);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    int findPositionOffset(int r10) {
        return findPositionOffset(r10, 0);
    }

    int findPositionOffset(int r10, int r11) {
        int r12 = this.mPostponedList.size();
    L3:
        if (r11 >= r12) goto L27;
        UpdateOp r13 = this.mPostponedList.get(r11);
        int r14 = r13.cmd;
        if (r14 != 8) goto L14;
        int r15 = r13.positionStart;
        if (r15 != r10) goto L9;
        r10 = r13.itemCount;
    L26:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r15 >= r10) goto L12;
        r10 = r10 - 1;
    L12:
        if (r13.itemCount > r10) goto L26;
        r10 = r10 + 1;
        goto L26
    L14:
        int r16 = r13.positionStart;
        if (r16 > r10) goto L26;
        if (r14 != 2) goto L24;
        int r17 = r13.itemCount;
        if (r10 < (r16 + r17)) goto L20;
        r10 = r10 - r17;
        goto L26
    L20:
        return -1;
    L24:
        if (r14 != 1) goto L26;
        r10 = r10 + r13.itemCount;
        goto L26
    L27:
        return r10;
    }

    boolean hasAnyUpdateTypes(int r10) {
        if ((this.mExistingUpdateTypes & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasUpdates() {
        if (this.mPostponedList.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingUpdates.isEmpty() == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int r10, int r11, int r12, Object r13) {
        UpdateOp r14 = this.mUpdateOpPool.acquire();
        if (r14 == null) goto L7;
        r14.cmd = r10;
        r14.positionStart = r11;
        r14.itemCount = r12;
        r14.payload = r13;
        return r14;
    L7:
        return new UpdateOp(r10, r11, r12, r13);
    }

    boolean onItemRangeChanged(int r10, int r11, Object r12) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(4, r10, r11, r12));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean onItemRangeInserted(int r10, int r11) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(1, r10, r11, null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean onItemRangeMoved(int r10, int r11, int r12) {
        if (r10 != r11) goto L6;
        return false;
    L6:
        if (r12 != 1) goto L12;
        this.mPendingUpdates.add(obtainUpdateOp(8, r10, r11, null));
        this.mExistingUpdateTypes |= 8;
        if (this.mPendingUpdates.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    boolean onItemRangeRemoved(int r10, int r11) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(2, r10, r11, null));
        this.mExistingUpdateTypes |= 2;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int r10 = this.mPendingUpdates.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        UpdateOp r12 = this.mPendingUpdates.get(r11);
        int r13 = r12.cmd;
        if (r13 != 1) goto L7;
        applyAdd(r12);
    L17:
        Runnable r14 = this.mOnItemProcessedCallback;
        if (r14 == null) goto L20;
        r14.run();
    L20:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        applyRemove(r12);
        goto L17
    L9:
        if (r13 != 4) goto L11;
        applyUpdate(r12);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        applyMove(r12);
        goto L17
    L21:
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp r10) {
        if (this.mDisableRecycler == true) goto L6;
        r10.payload = null;
        this.mUpdateOpPool.release(r10);
        return;
    }

    void recycleUpdateOpsAndClearList(List<UpdateOp> r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        recycleUpdateOp(r10.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        r10.clear();
    }

    void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }
}
