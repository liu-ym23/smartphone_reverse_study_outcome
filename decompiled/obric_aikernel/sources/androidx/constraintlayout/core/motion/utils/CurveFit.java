package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        Constant(double r10, double[] r11) {
            this.mTime = r10;
            this.mValue = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getPos(double r10, int r11) {
            return this.mValue[r11];
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double r10, double[] r11) {
            double[] r12 = this.mValue;
            System.arraycopy(r12, 0, r11, 0, r12.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double r10, float[] r11) {
            int r12 = 0;
        L3:
            double[] r13 = this.mValue;
            if (r12 >= r13.length) goto L6;
            r11[r12] = (float) r13[r12];
            r12 = r12 + 1;
            goto L3
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getSlope(double r10, int r11) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getSlope(double r10, double[] r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.mValue.length) goto L6;
            r11[r12] = 0.0d;
            r12 = r12 + 1;
            goto L4
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }
    }

    public CurveFit() {
    }

    public static CurveFit get(int r10, double[] r11, double[][] r12) {
        if (r11.length != 1) goto L5;
        r10 = 2;
    L5:
        if (r10 == 0) goto L12;
        if (r10 == 2) goto L10;
        return new LinearCurveFit(r11, r12);
    L10:
        return new Constant(r11[0], r12[0]);
    L12:
        return new MonotonicCurveFit(r11, r12);
    }

    public static CurveFit getArc(int[] r10, double[] r11, double[][] r12) {
        return new ArcCurveFit(r10, r11, r12);
    }

    public abstract double getPos(double r10, int r11);

    public abstract void getPos(double r10, double[] r11);

    public abstract void getPos(double r10, float[] r11);

    public abstract double getSlope(double r10, int r11);

    public abstract void getSlope(double r10, double[] r11);

    public abstract double[] getTimePoints();
}
