package org.apache.commons.math3.ml.distance;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public interface DistanceMeasure extends Serializable {
    double compute(double[] r1, double[] r2);
}
