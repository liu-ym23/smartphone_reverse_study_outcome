package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class EuclideanDistance implements DistanceMeasure {
    private static final long serialVersionUID = 1717556319784040040L;

    public EuclideanDistance() {
    }

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] r1, double[] r2) {
        return MathArrays.distance(r1, r2);
    }
}
