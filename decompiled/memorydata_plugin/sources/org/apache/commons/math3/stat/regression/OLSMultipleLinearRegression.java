package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private QRDecomposition qr;
    private final double threshold;

    public OLSMultipleLinearRegression() {
        this(0.0d);
    }

    public OLSMultipleLinearRegression(double r2) {
        this.qr = null;
        this.threshold = r2;
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public RealVector calculateBeta() {
        return this.qr.getSolver().solve(getY());
    }

    public void newSampleData(double[] r1, double[][] r2) {
        validateSampleData(r2, r1);
        newYSampleData(r1);
        newXSampleData(r2);
    }

    @Override // org.apache.commons.math3.stat.regression.AbstractMultipleLinearRegression
    public void newXSampleData(double[][] r4) {
        super.newXSampleData(r4);
        this.qr = new QRDecomposition(getX(), this.threshold);
    }
}
