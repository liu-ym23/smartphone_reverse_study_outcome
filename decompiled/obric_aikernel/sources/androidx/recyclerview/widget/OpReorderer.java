package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r10, int r11, int r12, Object r13);

        void recycleUpdateOp(AdapterHelper.UpdateOp r10);
    }

    OpReorderer(Callback r10) {
        this.mCallback = r10;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> r10) {
        int r11 = r10.size() - 1;
        boolean r12 = false;
    L3:
        if (r11 < 0) goto L10;
        if (r10.get(r11).cmd != 8) goto L8;
        if (r12 == false) goto L9;
        return r11;
    L9:
        r11 = r11 - 1;
        goto L3
    L8:
        r12 = true;
        goto L9
    L10:
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r15 = r12.itemCount;
        int r16 = r14.positionStart;
        if (r15 >= r16) goto L5;
        int r17 = -1;
    L6:
        int r18 = r12.positionStart;
        if (r18 >= r16) goto L9;
        r17 = r17 + 1;
    L9:
        if (r16 > r18) goto L11;
        r12.positionStart = r18 + r14.itemCount;
    L11:
        int r19 = r14.positionStart;
        if (r19 > r15) goto L14;
        r12.itemCount = r15 + r14.itemCount;
    L14:
        r14.positionStart = r19 + r17;
        r10.set(r11, r14);
        r10.set(r13, r12);
        return;
    L5:
        r17 = 0;
        goto L6
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> r10, int r11, int r12) {
        AdapterHelper.UpdateOp r13 = r10.get(r11);
        AdapterHelper.UpdateOp r14 = r10.get(r12);
        int r15 = r14.cmd;
        if (r15 != 1) goto L5;
        swapMoveAdd(r10, r11, r13, r12, r14);
        return;
    L5:
        if (r15 != 2) goto L7;
        swapMoveRemove(r10, r11, r13, r12, r14);
        return;
    L7:
        if (r15 != 4) goto L15;
        swapMoveUpdate(r10, r11, r13, r12, r14);
        return;
    }

    void reorderOps(List<AdapterHelper.UpdateOp> r10) {
    L2:
        int r11 = getLastMoveOutOfOrder(r10);
        if (r11 == (-1)) goto L5;
        swapMoveOp(r10, r11, r11 + 1);
        goto L2
    }

    void swapMoveRemove(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r15 = r12.positionStart;
        int r16 = r12.itemCount;
        boolean r17 = false;
        int r18 = r14.positionStart;
        if (r15 >= r16) goto L10;
        if (r18 == r15) goto L6;
    L8:
        boolean r19 = false;
    L15:
        int r20 = r14.positionStart;
        if (r16 >= r20) goto L18;
        r14.positionStart = r20 - 1;
    L24:
        int r21 = r12.positionStart;
        int r22 = r14.positionStart;
        AdapterHelper.UpdateOp r23 = null;
        if (r21 > r22) goto L27;
        r14.positionStart = r22 + 1;
    L30:
        if (r17 == false) goto L33;
        r10.set(r11, r14);
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r12);
        return;
    L33:
        if (r19 == false) goto L47;
        if (r23 == null) goto L41;
        int r24 = r12.positionStart;
        if (r24 <= r23.positionStart) goto L38;
        r12.positionStart = r24 - r23.itemCount;
    L38:
        int r25 = r12.itemCount;
        if (r25 <= r23.positionStart) goto L41;
        r12.itemCount = r25 - r23.itemCount;
    L41:
        int r26 = r12.positionStart;
        if (r26 <= r14.positionStart) goto L44;
        r12.positionStart = r26 - r14.itemCount;
    L44:
        int r27 = r12.itemCount;
        if (r27 > r14.positionStart) goto L59;
    L60:
        r10.set(r11, r14);
        if (r12.positionStart == r12.itemCount) goto L63;
        r10.set(r13, r12);
    L64:
        if (r23 == null) goto L68;
        r10.add(r11, r23);
        return;
    L68:
        return;
    L63:
        r10.remove(r13);
    L59:
        r12.itemCount = r27 - r14.itemCount;
        goto L60
    L47:
        if (r23 == null) goto L54;
        int r28 = r12.positionStart;
        if (r28 < r23.positionStart) goto L51;
        r12.positionStart = r28 - r23.itemCount;
    L51:
        int r29 = r12.itemCount;
        if (r29 < r23.positionStart) goto L54;
        r12.itemCount = r29 - r23.itemCount;
    L54:
        int r30 = r12.positionStart;
        if (r30 < r14.positionStart) goto L57;
        r12.positionStart = r30 - r14.itemCount;
    L57:
        r27 = r12.itemCount;
        if (r27 < r14.positionStart) goto L60;
    L27:
        int r31 = r14.itemCount;
        if (r21 >= (r22 + r31)) goto L30;
        r23 = this.mCallback.obtainUpdateOp(2, r21 + 1, (r22 + r31) - r21, null);
        r14.itemCount = r12.positionStart - r14.positionStart;
        goto L30
    L18:
        int r32 = r14.itemCount;
        if (r16 >= (r20 + r32)) goto L24;
        r14.itemCount = r32 - 1;
        r12.cmd = 2;
        r12.itemCount = 1;
        if (r14.itemCount != 0) goto L67;
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r14);
        return;
    L67:
        return;
    L6:
        if (r14.itemCount != (r16 - r15)) goto L8;
        r19 = false;
        r17 = true;
        goto L15
    L10:
        if (r18 == (r16 + 1)) goto L12;
    L14:
        r19 = true;
        goto L15
    L12:
        if (r14.itemCount != (r15 - r16)) goto L14;
        r19 = true;
        r17 = true;
        goto L15
    }

    void swapMoveUpdate(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r15 = r12.itemCount;
        int r16 = r14.positionStart;
        AdapterHelper.UpdateOp r17 = null;
        if (r15 >= r16) goto L5;
        r14.positionStart = r16 - 1;
    L8:
        AdapterHelper.UpdateOp r18 = null;
    L9:
        int r19 = r12.positionStart;
        int r20 = r14.positionStart;
        if (r19 > r20) goto L12;
        r14.positionStart = r20 + 1;
    L15:
        r10.set(r13, r12);
        if (r14.itemCount <= 0) goto L18;
        r10.set(r11, r14);
    L19:
        if (r18 == null) goto L21;
        r10.add(r11, r18);
    L21:
        if (r17 == null) goto L24;
        r10.add(r11, r17);
        return;
    L24:
        return;
    L18:
        r10.remove(r11);
        this.mCallback.recycleUpdateOp(r14);
        goto L19
    L12:
        int r21 = r14.itemCount;
        if (r19 >= (r20 + r21)) goto L15;
        int r22 = (r20 + r21) - r19;
        r17 = this.mCallback.obtainUpdateOp(4, r19 + 1, r22, r14.payload);
        r14.itemCount -= r22;
        goto L15
    L5:
        int r23 = r14.itemCount;
        if (r15 >= (r16 + r23)) goto L8;
        r14.itemCount = r23 - 1;
        r18 = this.mCallback.obtainUpdateOp(4, r12.positionStart, 1, r14.payload);
        goto L9
    }
}
