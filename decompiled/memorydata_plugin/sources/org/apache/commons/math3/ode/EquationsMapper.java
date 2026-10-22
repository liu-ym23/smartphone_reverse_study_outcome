package org.apache.commons.math3.ode;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class EquationsMapper implements Serializable {
    private static final long serialVersionUID = 20110925;
    private final int dimension;
    private final int firstIndex;

    public EquationsMapper(int r1, int r2) {
        this.firstIndex = r1;
        this.dimension = r2;
    }

    public void extractEquationData(double[] r3, double[] r4) {
        int r0 = r4.length;
        int r1 = this.dimension;
        if (r0 != r1) goto L7;
        System.arraycopy(r3, this.firstIndex, r4, 0, r1);
        return;
    L7:
        throw new DimensionMismatchException(r4.length, this.dimension);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public void insertEquationData(double[] r3, double[] r4) {
        int r0 = r3.length;
        int r1 = this.dimension;
        if (r0 != r1) goto L7;
        System.arraycopy(r3, 0, r4, this.firstIndex, r1);
        return;
    L7:
        throw new DimensionMismatchException(r3.length, this.dimension);
    }
}
