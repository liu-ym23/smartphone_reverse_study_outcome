package org.bouncycastle.pqc.legacy.math.linearalgebra;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Matrix {
    protected int numColumns;
    protected int numRows;

    public Matrix() {
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public int getNumRows() {
        return this.numRows;
    }
}
