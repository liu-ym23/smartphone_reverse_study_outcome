package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class ChebyshevDistance implements DistanceMeasure {
    private static final long serialVersionUID = -4694868171115238296L;

    public ChebyshevDistance() {
    }

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] r1, double[] r2) {
        return MathArrays.distanceInf(r1, r2);
    }
}
