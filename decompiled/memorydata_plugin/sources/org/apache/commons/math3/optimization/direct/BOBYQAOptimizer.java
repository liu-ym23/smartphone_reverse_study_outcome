package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BOBYQAOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<Object> {
    private Array2DRowRealMatrix bMatrix;
    private ArrayRealVector currentBest;
    private ArrayRealVector lagrangeValuesAtNewPoint;
    private final int numberOfInterpolationPoints;
    private Array2DRowRealMatrix zMatrix;

    private static class PathIsExploredException extends RuntimeException {
        private static final String PATH_IS_EXPLORED = "If this exception is thrown, just remove it from the code";
        private static final long serialVersionUID = 745350979634801853L;

        PathIsExploredException() {
            super("If this exception is thrown, just remove it from the code " + BOBYQAOptimizer.access$000(3));
        }
    }

    static /* synthetic */ String access$000(int r0) {
        return caller(r0);
    }

    private static String caller(int r2) {
        StackTraceElement r3 = new Throwable().getStackTrace()[r2];
        return r3.getMethodName() + " (at line " + r3.getLineNumber() + ")";
    }

    private static void printMethod() {
    }

    private void update(double r28, double r30, int r32) {
        int r1 = r32;
        printMethod();
        int r2 = this.currentBest.getDimension();
        int r3 = this.numberOfInterpolationPoints;
        int r5 = 1;
        int r4 = (r3 - r2) - 1;
        ArrayRealVector r6 = new ArrayRealVector(r3 + r2);
        int r9 = 0;
        int r10 = 0;
        double r11 = 0.0d;
    L3:
        if (r10 >= r3) goto L8;
        int r13 = 0;
    L5:
        if (r13 >= r4) goto L7;
        r11 = FastMath.max(r11, FastMath.abs(this.zMatrix.getEntry(r10, r13)));
        r13 = r13 + 1;
        goto L5
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        double r12 = r11 * 1.0E-20d;
    L9:
        if (r5 >= r4) goto L16;
        if (FastMath.abs(this.zMatrix.getEntry(r1, r5)) <= r12) goto L15;
        double r14 = this.zMatrix.getEntry(r1, 0);
        double r15 = this.zMatrix.getEntry(r1, r5);
        double r16 = FastMath.sqrt((r14 * r14) + (r15 * r15));
        double r17 = this.zMatrix.getEntry(r1, 0) / r16;
        double r18 = this.zMatrix.getEntry(r1, r5) / r16;
        int r19 = 0;
    L13:
        if (r19 >= r3) goto L15;
        double r110 = (this.zMatrix.getEntry(r19, 0) * r17) + (this.zMatrix.getEntry(r19, r5) * r18);
        Array2DRowRealMatrix r7 = this.zMatrix;
        r7.setEntry(r19, r5, (r7.getEntry(r19, r5) * r17) - (this.zMatrix.getEntry(r19, 0) * r18));
        this.zMatrix.setEntry(r19, 0, r110);
        r19 = r19 + 1;
        r12 = r12;
    L15:
        this.zMatrix.setEntry(r1, r5, 0.0d);
        r5 = r5 + 1;
        r12 = r12;
        goto L9
    L16:
        int r8 = 0;
    L17:
        if (r8 >= r3) goto L19;
        r6.setEntry(r8, this.zMatrix.getEntry(r1, 0) * this.zMatrix.getEntry(r8, 0));
        r8 = r8 + 1;
        goto L17
    L19:
        double r20 = r6.getEntry(r1);
        double r21 = this.lagrangeValuesAtNewPoint.getEntry(r1);
        ArrayRealVector r111 = this.lagrangeValuesAtNewPoint;
        r111.setEntry(r1, r111.getEntry(r1) - 1.0d);
        double r112 = FastMath.sqrt(r30);
        double r113 = r21 / r112;
        double r114 = this.zMatrix.getEntry(r1, 0) / r112;
        int r115 = 0;
    L20:
        if (r115 >= r3) goto L22;
        Array2DRowRealMatrix r116 = this.zMatrix;
        double r22 = r113;
        double r117 = (r116.getEntry(r115, r9) * r113) - (this.lagrangeValuesAtNewPoint.getEntry(r115) * r114);
        r9 = 0;
        r116.setEntry(r115, 0, r117);
        r115 = r115 + 1;
        r113 = r22;
        goto L20
    L22:
        int r118 = r9;
    L23:
        if (r118 >= r2) goto L33;
        int r119 = r3 + r118;
        r6.setEntry(r119, this.bMatrix.getEntry(r1, r118));
        double r120 = ((this.lagrangeValuesAtNewPoint.getEntry(r119) * r20) - (r6.getEntry(r119) * r21)) / r30;
        int r121 = r118;
        double r23 = (((-r28) * r6.getEntry(r119)) - (this.lagrangeValuesAtNewPoint.getEntry(r119) * r21)) / r30;
        int r24 = 0;
    L25:
        int r122 = r2;
        if (r24 > r119) goto L32;
        Array2DRowRealMatrix r25 = this.bMatrix;
        double r123 = r20;
        int r26 = r121;
        ArrayRealVector r124 = r6;
        r25.setEntry(r24, r26, (r25.getEntry(r24, r26) + (this.lagrangeValuesAtNewPoint.getEntry(r24) * r120)) + (r6.getEntry(r24) * r23));
        if (r24 < r3) goto L31;
        Array2DRowRealMatrix r27 = this.bMatrix;
        r27.setEntry(r119, r24 - r3, r27.getEntry(r24, r26));
    L31:
        r24 = r24 + 1;
        r6 = r124;
        r2 = r122;
        r21 = r21;
        r121 = r26;
        r20 = r123;
        goto L25
    L32:
        r118 = r121 + 1;
        r1 = r32;
        r20 = r20;
        goto L23
    }
}
