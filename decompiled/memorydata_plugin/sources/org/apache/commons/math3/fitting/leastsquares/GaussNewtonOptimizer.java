package org.apache.commons.math3.fitting.leastsquares;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class GaussNewtonOptimizer {
    private final Decomposition decomposition;

    /* JADX INFO: renamed from: org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum Decomposition extends Enum<Decomposition> {
        private static final /* synthetic */ Decomposition[] $VALUES = null;
        public static final Decomposition CHOLESKY = null;
        public static final Decomposition LU = null;
        public static final Decomposition QR = null;
        public static final Decomposition SVD = null;

        static {
            final String r1 = "LU";
            final int r2 = 0;
            Decomposition r0 = new AnonymousClass1(r1, r2);
            LU = r0;
            final String r3 = "QR";
            final int r4 = 1;
            Decomposition r5 = new AnonymousClass2(r3, r4);
            QR = r5;
            final String r6 = "CHOLESKY";
            final int r7 = 2;
            Decomposition r8 = new AnonymousClass3(r6, r7);
            CHOLESKY = r8;
            final String r9 = "SVD";
            final int r10 = 3;
            Decomposition r11 = new AnonymousClass4(r9, r10);
            SVD = r11;
            $VALUES = new Decomposition[]{r0, r5, r8, r11};
        }

        private Decomposition(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Decomposition(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Decomposition valueOf(String r2) {
            return (Decomposition) ZeusTransformUtils.preCheckCast(Enum.valueOf(Decomposition.class, r2), Decomposition.class, "com.obric.memorydata.plugin");
        }

        public static Decomposition[] values() {
            return (Decomposition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Decomposition[].class, "com.obric.memorydata.plugin");
        }

        public abstract RealVector solve(RealMatrix r1, RealVector r2);
    }

    static /* synthetic */ Pair access$100(RealMatrix r2, RealVector r3) {
        return computeNormalMatrix((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r2, RealMatrix.class, "com.obric.memorydata.plugin"), r3);
    }

    private static Pair<RealMatrix, RealVector> computeNormalMatrix(RealMatrix r14, RealVector r15) {
        RealMatrix r16 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r14, RealMatrix.class, "com.obric.memorydata.plugin");
        int r0 = r16.getRowDimension();
        int r1 = r16.getColumnDimension();
        RealMatrix r2 = MatrixUtils.createRealMatrix(r1, r1);
        ArrayRealVector r3 = new ArrayRealVector(r1);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L14;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L7;
        r3.setEntry(r6, r3.getEntry(r6) + (r15.getEntry(r5) * r16.getEntry(r5, r6)));
        r6 = r6 + 1;
        goto L5
    L7:
        int r7 = 0;
    L8:
        if (r7 >= r1) goto L13;
        int r8 = r7;
    L10:
        if (r8 >= r1) goto L12;
        r2.setEntry(r7, r8, r2.getEntry(r7, r8) + (r16.getEntry(r5, r7) * r16.getEntry(r5, r8)));
        r8 = r8 + 1;
        goto L10
    L12:
        r7 = r7 + 1;
        goto L8
    L13:
        r5 = r5 + 1;
        goto L3
    L14:
        int r17 = 0;
    L15:
        if (r17 >= r1) goto L21;
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L19;
        r2.setEntry(r17, r18, r2.getEntry(r18, r17));
        r18 = r18 + 1;
        goto L17
    L19:
        r17 = r17 + 1;
        goto L15
    L21:
        return new Pair(r2, r3);
    }

    public String toString() {
        return "GaussNewtonOptimizer{decomposition=" + this.decomposition + '}';
    }
}
