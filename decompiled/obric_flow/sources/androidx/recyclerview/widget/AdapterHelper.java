package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AdapterHelper implements OpReorderer.Callback {
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

    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int r5);

        void markViewHoldersUpdated(int r5, int r10, Object r11);

        void offsetPositionsForAdd(int r5, int r10);

        void offsetPositionsForMove(int r5, int r10);

        void offsetPositionsForRemovingInvisible(int r5, int r10);

        void offsetPositionsForRemovingLaidOutOrNewView(int r5, int r10);

        void onDispatchFirstPass(UpdateOp r5);

        void onDispatchSecondPass(UpdateOp r5);
    }

    public static final class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        public UpdateOp(int r5, int r10, int r11, Object r12) {
            this.cmd = r5;
            this.positionStart = r10;
            this.itemCount = r11;
            this.payload = r12;
        }

        public String cmdToString() {
            int r5 = this.cmd;
            if (r5 != 1) goto L5;
            return "add";
        L5:
            if (r5 != 2) goto L7;
            return "rm";
        L7:
            if (r5 != 4) goto L9;
            return "up";
        L9:
            if (r5 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UpdateOp) == true) goto L8;
            return false;
        L8:
            UpdateOp r10 = (UpdateOp) r5;
            int r11 = this.cmd;
            if (r11 == r10.cmd) goto L12;
            return false;
        L12:
            if (r11 != 8) goto L21;
            if (Math.abs(this.itemCount - this.positionStart) != 1) goto L21;
            if (this.itemCount != r10.positionStart) goto L21;
            if (this.positionStart != r10.itemCount) goto L21;
            return true;
        L21:
            if (this.itemCount == r10.itemCount) goto L24;
            return false;
        L24:
            if (this.positionStart == r10.positionStart) goto L26;
            return false;
        L26:
            Object r12 = this.payload;
            if (r12 == null) goto L32;
            if (r12.equals(r10.payload) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r10.payload == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    public AdapterHelper(Callback r5) {
        this(r5, false);
    }

    private void applyAdd(UpdateOp r5) {
        postponeAndUpdateViewHolders(r5);
    }

    private void applyMove(UpdateOp r5) {
        postponeAndUpdateViewHolders(r5);
    }

    private void applyRemove(UpdateOp r11) {
        int r5 = r11.positionStart;
        int r10 = r11.itemCount + r5;
        byte r12 = -1;
        int r13 = r5;
        int r14 = 0;
    L4:
        if (r13 >= r10) goto L23;
        if (this.mCallback.findViewHolder(r13) == null) goto L8;
    L14:
        if (r12 != 0) goto L16;
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, r5, r14, null));
        boolean r15 = true;
    L17:
        byte r16 = 1;
    L18:
        if (r15 == false) goto L20;
        r13 = r13 - r14;
        r10 = r10 - r14;
        r14 = 1;
    L21:
        r13 = r13 + 1;
        r12 = r16;
        goto L4
    L20:
        r14 = r14 + 1;
        goto L21
    L16:
        r15 = false;
        goto L17
    L8:
        if (canFindInPreLayout(r13) == true) goto L14;
        if (r12 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(2, r5, r14, null));
        r15 = true;
    L13:
        r16 = 0;
        goto L18
    L12:
        r15 = false;
        goto L13
    L23:
        if (r14 == r11.itemCount) goto L25;
        recycleUpdateOp(r11);
        r11 = obtainUpdateOp(2, r5, r14, null);
    L25:
        if (r12 != 0) goto L27;
        dispatchAndUpdateViewHolders(r11);
        return;
    L27:
        postponeAndUpdateViewHolders(r11);
    }

    private void applyUpdate(UpdateOp r10) {
        int r5 = r10.positionStart;
        int r11 = r10.itemCount + r5;
        int r12 = 0;
        byte r13 = -1;
        int r14 = r5;
    L4:
        if (r5 >= r11) goto L18;
        if (this.mCallback.findViewHolder(r5) == null) goto L8;
    L13:
        if (r13 != 0) goto L15;
        dispatchAndUpdateViewHolders(obtainUpdateOp(4, r14, r12, r10.payload));
        r14 = r5;
        r12 = 0;
    L15:
        r13 = 1;
    L16:
        r12 = r12 + 1;
        r5 = r5 + 1;
        goto L4
    L8:
        if (canFindInPreLayout(r5) == true) goto L13;
        if (r13 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(4, r14, r12, r10.payload));
        r14 = r5;
        r12 = 0;
    L12:
        r13 = 0;
        goto L16
    L18:
        if (r12 == r10.itemCount) goto L20;
        Object r15 = r10.payload;
        recycleUpdateOp(r10);
        r10 = obtainUpdateOp(4, r14, r12, r15);
    L20:
        if (r13 != 0) goto L22;
        dispatchAndUpdateViewHolders(r10);
        return;
    L22:
        postponeAndUpdateViewHolders(r10);
    }

    private boolean canFindInPreLayout(int r10) {
        int r5 = this.mPostponedList.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L17;
        UpdateOp r12 = this.mPostponedList.get(r11);
        int r13 = r12.cmd;
        if (r13 == 8) goto L7;
        if (r13 != 1) goto L16;
        int r14 = r12.positionStart;
        int r15 = r12.itemCount + r14;
    L11:
        if (r14 >= r15) goto L16;
        if (findPositionOffset(r14, r11 + 1) == r10) goto L14;
        r14 = r14 + 1;
        goto L11
    L14:
        return true;
    L16:
        r11 = r11 + 1;
        goto L3
    L7:
        if (findPositionOffset(r12.itemCount, r11 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp r12) {
        int r5 = r12.cmd;
        if (r5 == 1) goto L35;
        if (r5 == 8) goto L35;
        int r10 = updatePositionWithPostponed(r12.positionStart, r5);
        int r11 = r12.positionStart;
        int r13 = r12.cmd;
        if (r13 == 2) goto L12;
        if (r13 != 4) goto L11;
        int r14 = 1;
    L13:
        int r15 = 1;
        int r16 = 1;
    L15:
        if (r15 >= r12.itemCount) goto L30;
        int r17 = updatePositionWithPostponed((r14 * r15) + r12.positionStart, r12.cmd);
        int r18 = r12.cmd;
        if (r18 == 2) goto L23;
        if (r18 == 4) goto L21;
    L25:
        UpdateOp r19 = obtainUpdateOp(r18, r10, r16, r12.payload);
        dispatchFirstPassAndUpdateViewHolders(r19, r11);
        recycleUpdateOp(r19);
        if (r12.cmd != 4) goto L28;
        r11 = r11 + r16;
    L28:
        r16 = 1;
        r10 = r17;
    L29:
        r15 = r15 + 1;
        goto L15
    L21:
        if (r17 != (r10 + 1)) goto L25;
    L24:
        r16 = r16 + 1;
        goto L29
    L23:
        if (r17 != r10) goto L25;
    L30:
        Object r20 = r12.payload;
        recycleUpdateOp(r12);
        if (r16 <= 0) goto L39;
        UpdateOp r110 = obtainUpdateOp(r12.cmd, r10, r16, r20);
        dispatchFirstPassAndUpdateViewHolders(r110, r11);
        recycleUpdateOp(r110);
        return;
    L39:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r12);
    L12:
        r14 = 0;
    L35:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void postponeAndUpdateViewHolders(UpdateOp r5) {
        this.mPostponedList.add(r5);
        int r10 = r5.cmd;
        if (r10 != 1) goto L5;
        this.mCallback.offsetPositionsForAdd(r5.positionStart, r5.itemCount);
        return;
    L5:
        if (r10 != 2) goto L7;
        this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(r5.positionStart, r5.itemCount);
        return;
    L7:
        if (r10 != 4) goto L9;
        this.mCallback.markViewHoldersUpdated(r5.positionStart, r5.itemCount, r5.payload);
        return;
    L9:
        if (r10 != 8) goto L12;
        this.mCallback.offsetPositionsForMove(r5.positionStart, r5.itemCount);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r5);
    }

    private int updatePositionWithPostponed(int r10, int r11) {
        int r5 = this.mPostponedList.size() - 1;
    L4:
        if (r5 < 0) goto L40;
        UpdateOp r12 = this.mPostponedList.get(r5);
        int r13 = r12.cmd;
        if (r13 != 8) goto L29;
        int r14 = r12.positionStart;
        int r15 = r12.itemCount;
        if (r14 >= r15) goto L10;
        int r16 = r14;
        int r17 = r15;
    L11:
        if (r10 < r16) goto L24;
        if (r10 > r17) goto L24;
        if (r16 != r14) goto L19;
        if (r11 != 1) goto L16;
        r12.itemCount = r15 + 1;
    L18:
        r10 = r10 + 1;
    L39:
        r5 = r5 - 1;
        goto L4
    L16:
        if (r11 != 2) goto L18;
        r12.itemCount = r15 - 1;
        goto L18
    L19:
        if (r11 != 1) goto L21;
        r12.positionStart = r14 + 1;
    L23:
        r10 = r10 - 1;
        goto L39
    L21:
        if (r11 != 2) goto L23;
        r12.positionStart = r14 - 1;
    L24:
        if (r10 >= r14) goto L39;
        if (r11 != 1) goto L27;
        r12.positionStart = r14 + 1;
        r12.itemCount = r15 + 1;
        goto L39
    L27:
        if (r11 != 2) goto L39;
        r12.positionStart = r14 - 1;
        r12.itemCount = r15 - 1;
        goto L39
    L10:
        r17 = r14;
        r16 = r15;
        goto L11
    L29:
        int r18 = r12.positionStart;
        if (r18 > r10) goto L35;
        if (r13 != 1) goto L33;
        r10 = r10 - r12.itemCount;
        goto L39
    L33:
        if (r13 != 2) goto L39;
        r10 = r10 + r12.itemCount;
        goto L39
    L35:
        if (r11 != 1) goto L37;
        r12.positionStart = r18 + 1;
        goto L39
    L37:
        if (r11 != 2) goto L39;
        r12.positionStart = r18 - 1;
        goto L39
    L40:
        int r19 = this.mPostponedList.size() - 1;
    L41:
        if (r19 < 0) goto L52;
        UpdateOp r20 = this.mPostponedList.get(r19);
        if (r20.cmd != 8) goto L49;
        int r21 = r20.itemCount;
        if (r21 == r20.positionStart) goto L47;
        if (r21 < 0) goto L47;
    L51:
        r19 = r19 - 1;
    L47:
        this.mPostponedList.remove(r19);
        recycleUpdateOp(r20);
        goto L51
    L49:
        if (r20.itemCount > 0) goto L51;
        this.mPostponedList.remove(r19);
        recycleUpdateOp(r20);
        goto L51
    L52:
        return r10;
    }

    public AdapterHelper addUpdateOp(UpdateOp... r5) {
        Collections.addAll(this.mPendingUpdates, r5);
        return this;
    }

    public int applyPendingUpdatesToPosition(int r10) {
        int r5 = this.mPendingUpdates.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L30;
        UpdateOp r12 = this.mPendingUpdates.get(r11);
        int r13 = r12.cmd;
        if (r13 == 1) goto L27;
        if (r13 != 2) goto L9;
        int r14 = r12.positionStart;
        if (r14 > r10) goto L29;
        int r15 = r12.itemCount;
        if ((r14 + r15) > r10) goto L23;
        r10 = r10 - r15;
        goto L29
    L23:
        return -1;
    L29:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r13 != 8) goto L29;
        int r16 = r12.positionStart;
        if (r16 != r10) goto L14;
        r10 = r12.itemCount;
        goto L29
    L14:
        if (r16 >= r10) goto L17;
        r10 = r10 - 1;
    L17:
        if (r12.itemCount > r10) goto L29;
        r10 = r10 + 1;
        goto L29
    L27:
        if (r12.positionStart > r10) goto L29;
        r10 = r10 + r12.itemCount;
        goto L29
    L30:
        return r10;
    }

    public void consumePostponedUpdates() {
        int r5 = this.mPostponedList.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.mCallback.onDispatchSecondPass(this.mPostponedList.get(r10));
        r10 = r10 + 1;
        goto L3
    L5:
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int r5 = this.mPendingUpdates.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L21;
        UpdateOp r11 = this.mPendingUpdates.get(r10);
        int r12 = r11.cmd;
        if (r12 != 1) goto L7;
        this.mCallback.onDispatchSecondPass(r11);
        this.mCallback.offsetPositionsForAdd(r11.positionStart, r11.itemCount);
    L17:
        Runnable r13 = this.mOnItemProcessedCallback;
        if (r13 == null) goto L20;
        r13.run();
    L20:
        r10 = r10 + 1;
        goto L3
    L7:
        if (r12 != 2) goto L9;
        this.mCallback.onDispatchSecondPass(r11);
        this.mCallback.offsetPositionsForRemovingInvisible(r11.positionStart, r11.itemCount);
        goto L17
    L9:
        if (r12 != 4) goto L11;
        this.mCallback.onDispatchSecondPass(r11);
        this.mCallback.markViewHoldersUpdated(r11.positionStart, r11.itemCount, r11.payload);
        goto L17
    L11:
        if (r12 != 8) goto L17;
        this.mCallback.onDispatchSecondPass(r11);
        this.mCallback.offsetPositionsForMove(r11.positionStart, r11.itemCount);
        goto L17
    L21:
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp r5, int r10) {
        this.mCallback.onDispatchFirstPass(r5);
        int r11 = r5.cmd;
        if (r11 != 2) goto L5;
        this.mCallback.offsetPositionsForRemovingInvisible(r10, r5.itemCount);
        return;
    L5:
        if (r11 != 4) goto L8;
        this.mCallback.markViewHoldersUpdated(r10, r5.itemCount, r5.payload);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public int findPositionOffset(int r5) {
        return findPositionOffset(r5, 0);
    }

    public boolean hasAnyUpdateTypes(int r5) {
        if ((this.mExistingUpdateTypes & r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUpdates() {
        if (this.mPostponedList.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingUpdates.isEmpty() == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int r5, int r10, int r11, Object r12) {
        UpdateOp r13 = this.mUpdateOpPool.acquire();
        if (r13 == null) goto L7;
        r13.cmd = r5;
        r13.positionStart = r10;
        r13.itemCount = r11;
        r13.payload = r12;
        return r13;
    L7:
        return new UpdateOp(r5, r10, r11, r12);
    }

    public boolean onItemRangeChanged(int r5, int r10, Object r11) {
        if (r10 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(4, r5, r10, r11));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean onItemRangeInserted(int r5, int r10) {
        if (r10 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(1, r5, r10, null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean onItemRangeMoved(int r5, int r10, int r11) {
        if (r5 != r10) goto L6;
        return false;
    L6:
        if (r11 != 1) goto L12;
        this.mPendingUpdates.add(obtainUpdateOp(8, r5, r10, null));
        this.mExistingUpdateTypes |= 8;
        if (this.mPendingUpdates.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean onItemRangeRemoved(int r10, int r11) {
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

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int r5 = this.mPendingUpdates.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L21;
        UpdateOp r11 = this.mPendingUpdates.get(r10);
        int r12 = r11.cmd;
        if (r12 != 1) goto L7;
        applyAdd(r11);
    L17:
        Runnable r13 = this.mOnItemProcessedCallback;
        if (r13 == null) goto L20;
        r13.run();
    L20:
        r10 = r10 + 1;
        goto L3
    L7:
        if (r12 != 2) goto L9;
        applyRemove(r11);
        goto L17
    L9:
        if (r12 != 4) goto L11;
        applyUpdate(r11);
        goto L17
    L11:
        if (r12 != 8) goto L17;
        applyMove(r11);
        goto L17
    L21:
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp r5) {
        if (this.mDisableRecycler == true) goto L6;
        r5.payload = null;
        this.mUpdateOpPool.release(r5);
        return;
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        recycleUpdateOp(r5.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        r5.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback r5, boolean r10) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = r5;
        this.mDisableRecycler = r10;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int r10, int r11) {
        int r5 = this.mPostponedList.size();
    L3:
        if (r11 >= r5) goto L27;
        UpdateOp r12 = this.mPostponedList.get(r11);
        int r13 = r12.cmd;
        if (r13 != 8) goto L14;
        int r14 = r12.positionStart;
        if (r14 != r10) goto L9;
        r10 = r12.itemCount;
    L26:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r14 >= r10) goto L12;
        r10 = r10 - 1;
    L12:
        if (r12.itemCount > r10) goto L26;
        r10 = r10 + 1;
        goto L26
    L14:
        int r15 = r12.positionStart;
        if (r15 > r10) goto L26;
        if (r13 != 2) goto L24;
        int r16 = r12.itemCount;
        if (r10 < (r15 + r16)) goto L20;
        r10 = r10 - r16;
        goto L26
    L20:
        return -1;
    L24:
        if (r13 != 1) goto L26;
        r10 = r10 + r12.itemCount;
        goto L26
    L27:
        return r10;
    }
}
