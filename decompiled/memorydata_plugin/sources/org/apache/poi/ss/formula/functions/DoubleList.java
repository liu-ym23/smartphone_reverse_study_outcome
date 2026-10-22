package org.apache.poi.ss.formula.functions;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
final class DoubleList {
    static final double[] EMPTY_DOUBLE_ARRAY = null;
    private double[] _array;
    private int _count;

    static {
        EMPTY_DOUBLE_ARRAY = new double[0];
    }

    public DoubleList() {
        this._array = new double[8];
        this._count = 0;
    }

    private void ensureCapacity(int r3) {
        double[] r0 = this._array;
        if (r3 <= r0.length) goto L6;
        this._array = Arrays.copyOf(r0, (r3 * 3) / 2);
        return;
    }

    public void add(double r3) {
        ensureCapacity(this._count + 1);
        double[] r0 = this._array;
        int r1 = this._count;
        r0[r1] = r3;
        this._count = r1 + 1;
    }

    public double[] toArray() {
        int r0 = this._count;
        if (r0 >= 1) goto L6;
        return EMPTY_DOUBLE_ARRAY;
    L6:
        return Arrays.copyOf(this._array, r0);
    }
}
