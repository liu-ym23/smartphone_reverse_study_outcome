package org.apache.commons.math3.optim.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public class LinearObjectiveFunction implements Serializable {
    private static final long serialVersionUID = -4531815507568396090L;
    private final transient RealVector coefficients;
    private final double constantTerm;

    public LinearObjectiveFunction(RealVector r1, double r2) {
        this.coefficients = r1;
        this.constantTerm = r2;
    }

    public LinearObjectiveFunction(double[] r2, double r3) {
        this(new ArrayRealVector(r2), r3);
    }

    private void readObject(ObjectInputStream r2) {
        r2.defaultReadObject();
        MatrixUtils.deserializeRealVector(this, "coefficients", r2);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        MatrixUtils.serializeRealVector(this.coefficients, r1);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, LinearObjectiveFunction.class) == false) goto L14;
        LinearObjectiveFunction r10 = (LinearObjectiveFunction) ZeusTransformUtils.preCheckCast(r9, LinearObjectiveFunction.class, "com.obric.memorydata.plugin");
        if (this.constantTerm != r10.constantTerm) goto L13;
        if (this.coefficients.equals(r10.coefficients) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public double getConstantTerm() {
        return this.constantTerm;
    }

    public int hashCode() {
        int r0 = Double.valueOf(this.constantTerm).hashCode();
        return this.coefficients.hashCode() ^ r0;
    }

    public double value(RealVector r3) {
        return this.coefficients.dotProduct(r3) + this.constantTerm;
    }

    public double value(double[] r3) {
        return value(new ArrayRealVector(r3, false));
    }
}
