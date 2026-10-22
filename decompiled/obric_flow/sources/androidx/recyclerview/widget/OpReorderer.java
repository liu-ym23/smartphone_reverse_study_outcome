package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r5, int r10, int r11, Object r12);

        void recycleUpdateOp(AdapterHelper.UpdateOp r5);
    }

    public OpReorderer(Callback r5) {
        this.mCallback = r5;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> r5) {
        int r10 = r5.size() - 1;
        boolean r11 = false;
    L3:
        if (r10 < 0) goto L10;
        if (r5.get(r10).cmd != 8) goto L8;
        if (r11 == false) goto L9;
        return r10;
    L9:
        r10 = r10 - 1;
        goto L3
    L8:
        r11 = true;
        goto L9
    L10:
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r5, int r10, AdapterHelper.UpdateOp r11, int r12, AdapterHelper.UpdateOp r13) {
        int r14 = r11.itemCount;
        int r15 = r13.positionStart;
        if (r14 >= r15) goto L5;
        int r16 = -1;
    L6:
        int r17 = r11.positionStart;
        if (r17 >= r15) goto L9;
        r16 = r16 + 1;
    L9:
        if (r15 > r17) goto L11;
        r11.positionStart = r17 + r13.itemCount;
    L11:
        int r18 = r13.positionStart;
        if (r18 > r14) goto L14;
        r11.itemCount = r14 + r13.itemCount;
    L14:
        r13.positionStart = r18 + r16;
        r5.set(r10, r13);
        r5.set(r12, r11);
        return;
    L5:
        r16 = 0;
        goto L6
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> r10, int r11, int r12) {
        AdapterHelper.UpdateOp r5 = r10.get(r11);
        AdapterHelper.UpdateOp r13 = r10.get(r12);
        int r14 = r13.cmd;
        if (r14 != 1) goto L5;
        swapMoveAdd(r10, r11, r5, r12, r13);
        return;
    L5:
        if (r14 != 2) goto L7;
        swapMoveRemove(r10, r11, r5, r12, r13);
        return;
    L7:
        if (r14 != 4) goto L15;
        swapMoveUpdate(r10, r11, r5, r12, r13);
        return;
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> r5) {
    L2:
        int r10 = getLastMoveOutOfOrder(r5);
        if (r10 == (-1)) goto L5;
        swapMoveOp(r5, r10, r10 + 1);
        goto L2
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r5 = r12.positionStart;
        int r15 = r12.itemCount;
        boolean r16 = false;
        if (r5 >= r15) goto L11;
        if (r14.positionStart == r5) goto L7;
    L9:
        boolean r17 = false;
    L16:
        int r18 = r14.positionStart;
        if (r15 >= r18) goto L19;
        r14.positionStart = r18 - 1;
    L25:
        int r19 = r12.positionStart;
        int r20 = r14.positionStart;
        AdapterHelper.UpdateOp r21 = null;
        if (r19 > r20) goto L28;
        r14.positionStart = r20 + 1;
    L31:
        if (r16 == false) goto L34;
        r10.set(r11, r14);
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r12);
        return;
    L34:
        if (r17 == false) goto L48;
        if (r21 == null) goto L42;
        int r22 = r12.positionStart;
        if (r22 <= r21.positionStart) goto L39;
        r12.positionStart = r22 - r21.itemCount;
    L39:
        int r23 = r12.itemCount;
        if (r23 <= r21.positionStart) goto L42;
        r12.itemCount = r23 - r21.itemCount;
    L42:
        int r24 = r12.positionStart;
        if (r24 <= r14.positionStart) goto L45;
        r12.positionStart = r24 - r14.itemCount;
    L45:
        int r25 = r12.itemCount;
        if (r25 <= r14.positionStart) goto L61;
        r12.itemCount = r25 - r14.itemCount;
    L61:
        r10.set(r11, r14);
        if (r12.positionStart == r12.itemCount) goto L64;
        r10.set(r13, r12);
    L65:
        if (r21 == null) goto L69;
        r10.add(r11, r21);
        return;
    L69:
        return;
    L64:
        r10.remove(r13);
        goto L65
    L48:
        if (r21 == null) goto L55;
        int r26 = r12.positionStart;
        if (r26 < r21.positionStart) goto L52;
        r12.positionStart = r26 - r21.itemCount;
    L52:
        int r27 = r12.itemCount;
        if (r27 < r21.positionStart) goto L55;
        r12.itemCount = r27 - r21.itemCount;
    L55:
        int r28 = r12.positionStart;
        if (r28 < r14.positionStart) goto L58;
        r12.positionStart = r28 - r14.itemCount;
    L58:
        int r29 = r12.itemCount;
        if (r29 < r14.positionStart) goto L61;
        r12.itemCount = r29 - r14.itemCount;
        goto L61
    L28:
        int r30 = r14.itemCount;
        if (r19 >= (r20 + r30)) goto L31;
        r21 = this.mCallback.obtainUpdateOp(2, r19 + 1, (r20 + r30) - r19, null);
        r14.itemCount = r12.positionStart - r14.positionStart;
        goto L31
    L19:
        int r31 = r14.itemCount;
        if (r15 >= (r18 + r31)) goto L25;
        r14.itemCount = r31 - 1;
        r12.cmd = 2;
        r12.itemCount = 1;
        if (r14.itemCount != 0) goto L68;
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r14);
        return;
    L68:
        return;
    L7:
        if (r14.itemCount != (r15 - r5)) goto L9;
        r17 = false;
        r16 = true;
        goto L16
    L11:
        if (r14.positionStart == (r15 + 1)) goto L13;
    L15:
        r17 = true;
        goto L16
    L13:
        if (r14.itemCount != (r5 - r15)) goto L15;
        r17 = true;
        r16 = true;
        goto L16
    }

    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r5 = r12.itemCount;
        int r15 = r14.positionStart;
        AdapterHelper.UpdateOp r16 = null;
        if (r5 >= r15) goto L5;
        r14.positionStart = r15 - 1;
    L8:
        AdapterHelper.UpdateOp r17 = null;
    L9:
        int r18 = r12.positionStart;
        int r19 = r14.positionStart;
        if (r18 > r19) goto L12;
        r14.positionStart = r19 + 1;
    L15:
        r10.set(r13, r12);
        if (r14.itemCount <= 0) goto L18;
        r10.set(r11, r14);
    L19:
        if (r17 == null) goto L21;
        r10.add(r11, r17);
    L21:
        if (r16 == null) goto L24;
        r10.add(r11, r16);
        return;
    L24:
        return;
    L18:
        r10.remove(r11);
        this.mCallback.recycleUpdateOp(r14);
        goto L19
    L12:
        int r20 = r14.itemCount;
        if (r18 >= (r19 + r20)) goto L15;
        int r21 = (r19 + r20) - r18;
        r16 = this.mCallback.obtainUpdateOp(4, r18 + 1, r21, r14.payload);
        r14.itemCount -= r21;
        goto L15
    L5:
        int r22 = r14.itemCount;
        if (r5 >= (r15 + r22)) goto L8;
        r14.itemCount = r22 - 1;
        r17 = this.mCallback.obtainUpdateOp(4, r12.positionStart, 1, r14.payload);
        goto L9
    }
}
