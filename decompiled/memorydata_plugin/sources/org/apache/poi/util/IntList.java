package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class IntList {
    private int[] _array;
    private int _limit;

    public IntList() {
        this(128);
    }

    public IntList(int r1) {
        this._array = new int[r1];
        this._limit = 0;
    }

    private void growArray(int r4) {
        int[] r0 = this._array;
        if (r4 != r0.length) goto L5;
        r4 = r4 + 1;
    L5:
        int[] r5 = new int[r4];
        System.arraycopy(r0, 0, r5, 0, this._limit);
        this._array = r5;
    }

    public boolean add(int r4) {
        int r0 = this._limit;
        if (r0 != this._array.length) goto L5;
        growArray(r0 * 2);
    L5:
        int[] r1 = this._array;
        int r2 = this._limit;
        this._limit = r2 + 1;
        r1[r2] = r4;
        return true;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, IntList.class) == true) goto L8;
        return false;
    L8:
        IntList r7 = (IntList) ZeusTransformUtils.preCheckCast(r6, IntList.class, "com.obric.memorydata.plugin");
        if (r7._limit == this._limit) goto L11;
        return false;
    L11:
        int r0 = 0;
    L13:
        if (r0 >= this._limit) goto L18;
        if (r7._array[r0] != this._array[r0]) goto L16;
        r0 = r0 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public int hashCode() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this._limit) goto L6;
        r1 = (r1 * 31) + this._array[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public int size() {
        return this._limit;
    }

    public int[] toArray() {
        int r0 = this._limit;
        int[] r1 = new int[r0];
        System.arraycopy(this._array, 0, r1, 0, r0);
        return r1;
    }
}
