package org.apache.commons.math3.stat.regression;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultipleLinearRegression {
    private boolean noIntercept;
    private RealMatrix xMatrix;
    private RealVector yVector;

    public AbstractMultipleLinearRegression() {
        this.noIntercept = false;
    }

    public abstract RealVector calculateBeta();

    public double[] estimateRegressionParameters() {
        return calculateBeta().toArray();
    }

    public RealMatrix getX() {
        return this.xMatrix;
    }

    public RealVector getY() {
        return this.yVector;
    }

    public void newXSampleData(double[][] r9) {
        if (r9 == null) goto L21;
        if (r9.length == 0) goto L19;
        if (this.noIntercept == false) goto L8;
        this.xMatrix = new Array2DRowRealMatrix(r9, true);
        return;
    L8:
        int r2 = r9[0].length;
        double[][] r3 = (double[][]) Array.newInstance(double.class, new int[]{r9.length, r2 + 1});
        int r4 = 0;
    L10:
        if (r4 >= r9.length) goto L16;
        if (r9[r4].length != r2) goto L15;
        r3[r4][0] = 1.0d;
        System.arraycopy(r9[r4], 0, r3[r4], 1, r2);
        r4 = r4 + 1;
        goto L10
    L15:
        throw new DimensionMismatchException(r9[r4].length, r2);
    L16:
        this.xMatrix = new Array2DRowRealMatrix(r3, false);
        return;
    L19:
        throw new NoDataException();
    L21:
        throw new NullArgumentException();
    }

    public void newYSampleData(double[] r2) {
        if (r2 == null) goto L10;
        if (r2.length == 0) goto L8;
        this.yVector = new ArrayRealVector(r2);
        return;
    L8:
        throw new NoDataException();
    L10:
        throw new NullArgumentException();
    }

    public void setNoIntercept(boolean r1) {
        this.noIntercept = r1;
    }

    public void validateSampleData(double[][] r5, double[] r6) {
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        if (r5.length != r6.length) goto L16;
        if (r5.length == 0) goto L14;
        if ((r5[0].length + 1) > r5.length) goto L12;
        return;
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Integer.valueOf(r5.length), Integer.valueOf(r5[0].length)});
    L14:
        throw new NoDataException();
    L16:
        throw new DimensionMismatchException(r6.length, r5.length);
    L18:
        throw new NullArgumentException();
    }
}
