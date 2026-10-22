package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r1, int r2, int r3, Object r4);

        void recycleUpdateOp(AdapterHelper.UpdateOp r1);
    }

    OpReorderer(Callback r3) {
        this.mCallback = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r7 = r5.size() - 1;
        boolean r2 = false;
    L3:
        if (r7 < 0) goto L10;
        if (((AdapterHelper.UpdateOp) ZeusTransformUtils.preCheckCast(r5.get(r7), AdapterHelper.UpdateOp.class, "com.obric.memorydata.plugin")).cmd != 8) goto L8;
        if (r2 == false) goto L9;
        return r7;
    L9:
        r7 = r7 - 1;
        goto L3
    L8:
        r2 = true;
        goto L9
    L10:
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r3, int r4, AdapterHelper.UpdateOp r5, int r6, AdapterHelper.UpdateOp r7) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5.itemCount >= r7.positionStart) goto L5;
        int r8 = -1;
    L7:
        if (r5.positionStart >= r7.positionStart) goto L10;
        r8 = r8 + 1;
    L10:
        if (r7.positionStart > r5.positionStart) goto L13;
        r5.positionStart += r7.itemCount;
    L13:
        if (r7.positionStart > r5.itemCount) goto L15;
        r5.itemCount += r7.itemCount;
    L15:
        r7.positionStart += r8;
        r2.set(r4, r7);
        r2.set(r6, r5);
        return;
    L5:
        r8 = 0;
        goto L7
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> r9, int r10, int r11) {
        List<AdapterHelper.UpdateOp> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        AdapterHelper.UpdateOp r5 = (AdapterHelper.UpdateOp) ZeusTransformUtils.preCheckCast(r3.get(r10), AdapterHelper.UpdateOp.class, "com.obric.memorydata.plugin");
        AdapterHelper.UpdateOp r7 = (AdapterHelper.UpdateOp) ZeusTransformUtils.preCheckCast(r3.get(r11), AdapterHelper.UpdateOp.class, "com.obric.memorydata.plugin");
        int r12 = r7.cmd;
        if (r12 != 1) goto L5;
        swapMoveAdd(r3, r10, r5, r11, r7);
        return;
    L5:
        if (r12 != 2) goto L7;
        swapMoveRemove(r3, r10, r5, r11, r7);
        return;
    L7:
        if (r12 != 4) goto L15;
        swapMoveUpdate(r3, r10, r5, r11, r7);
        return;
    }

    void reorderOps(List<AdapterHelper.UpdateOp> r3) {
        List<AdapterHelper.UpdateOp> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    L3:
        int r0 = getLastMoveOutOfOrder(r4);
        if (r0 == (-1)) goto L6;
        swapMoveOp(r4, r0, r0 + 1);
        goto L3
    }

    void swapMoveRemove(List<AdapterHelper.UpdateOp> r9, int r10, AdapterHelper.UpdateOp r11, int r12, AdapterHelper.UpdateOp r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r11.positionStart >= r11.itemCount) goto L11;
        if (r13.positionStart == r11.positionStart) goto L7;
    L9:
        boolean r0 = false;
    L17:
        if (r11.itemCount >= r13.positionStart) goto L20;
        r13.positionStart--;
    L25:
        AdapterHelper.UpdateOp r6 = null;
        if (r11.positionStart > r13.positionStart) goto L29;
        r13.positionStart++;
    L31:
        if (r2 == false) goto L34;
        r14.set(r10, r13);
        r14.remove(r12);
        this.mCallback.recycleUpdateOp(r11);
        return;
    L34:
        if (r0 == false) goto L48;
        if (r6 == null) goto L43;
        if (r11.positionStart <= r6.positionStart) goto L40;
        r11.positionStart -= r6.itemCount;
    L40:
        if (r11.itemCount <= r6.positionStart) goto L43;
        r11.itemCount -= r6.itemCount;
    L43:
        if (r11.positionStart <= r13.positionStart) goto L46;
        r11.positionStart -= r13.itemCount;
    L46:
        if (r11.itemCount > r13.positionStart) goto L60;
    L61:
        r14.set(r10, r13);
        if (r11.positionStart == r11.itemCount) goto L64;
        r14.set(r12, r11);
    L65:
        if (r6 == null) goto L69;
        r14.add(r10, r6);
        return;
    L69:
        return;
    L64:
        r14.remove(r12);
    L60:
        r11.itemCount -= r13.itemCount;
        goto L61
    L48:
        if (r6 == null) goto L56;
        if (r11.positionStart < r6.positionStart) goto L53;
        r11.positionStart -= r6.itemCount;
    L53:
        if (r11.itemCount < r6.positionStart) goto L56;
        r11.itemCount -= r6.itemCount;
    L56:
        if (r11.positionStart < r13.positionStart) goto L59;
        r11.positionStart -= r13.itemCount;
    L59:
        if (r11.itemCount < r13.positionStart) goto L61;
    L29:
        if (r11.positionStart >= (r13.positionStart + r13.itemCount)) goto L31;
        r6 = this.mCallback.obtainUpdateOp(2, r11.positionStart + 1, (r13.positionStart + r13.itemCount) - r11.positionStart, null);
        r13.itemCount = r11.positionStart - r13.positionStart;
        goto L31
    L20:
        if (r11.itemCount >= (r13.positionStart + r13.itemCount)) goto L25;
        r13.itemCount--;
        r11.cmd = 2;
        r11.itemCount = 1;
        if (r13.itemCount != 0) goto L68;
        r14.remove(r12);
        this.mCallback.recycleUpdateOp(r13);
        return;
    L68:
        return;
    L7:
        if (r13.itemCount != (r11.itemCount - r11.positionStart)) goto L9;
        r0 = false;
        r2 = true;
        goto L17
    L11:
        if (r13.positionStart == (r11.itemCount + 1)) goto L13;
    L15:
        r0 = true;
        goto L17
    L13:
        if (r13.itemCount != (r11.positionStart - r11.itemCount)) goto L15;
        r0 = true;
        r2 = true;
        goto L17
    }

    void swapMoveUpdate(List<AdapterHelper.UpdateOp> r8, int r9, AdapterHelper.UpdateOp r10, int r11, AdapterHelper.UpdateOp r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        AdapterHelper.UpdateOp r3 = null;
        if (r10.itemCount >= r12.positionStart) goto L6;
        r12.positionStart--;
    L8:
        AdapterHelper.UpdateOp r0 = null;
    L10:
        if (r10.positionStart > r12.positionStart) goto L13;
        r12.positionStart++;
    L15:
        r13.set(r11, r10);
        if (r12.itemCount <= 0) goto L18;
        r13.set(r9, r12);
    L19:
        if (r0 == null) goto L21;
        r13.add(r9, r0);
    L21:
        if (r3 == null) goto L24;
        r13.add(r9, r3);
        return;
    L24:
        return;
    L18:
        r13.remove(r9);
        this.mCallback.recycleUpdateOp(r12);
        goto L19
    L13:
        if (r10.positionStart >= (r12.positionStart + r12.itemCount)) goto L15;
        int r1 = (r12.positionStart + r12.itemCount) - r10.positionStart;
        r3 = this.mCallback.obtainUpdateOp(4, r10.positionStart + 1, r1, r12.payload);
        r12.itemCount -= r1;
        goto L15
    L6:
        if (r10.itemCount >= (r12.positionStart + r12.itemCount)) goto L8;
        r12.itemCount--;
        r0 = this.mCallback.obtainUpdateOp(4, r10.positionStart, 1, r12.payload);
        goto L10
    }
}
