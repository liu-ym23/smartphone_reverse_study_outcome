package org.apache.commons.math3.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CentralPivotingStrategy implements Serializable, PivotingStrategyInterface {
    private static final long serialVersionUID = 20140713;

    public CentralPivotingStrategy() {
    }

    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] r1, int r2, int r3) {
        int r4 = r3 - r2;
        MathArrays.verifyValues(r1, r2, r4);
        return r2 + (r4 / 2);
    }
}
