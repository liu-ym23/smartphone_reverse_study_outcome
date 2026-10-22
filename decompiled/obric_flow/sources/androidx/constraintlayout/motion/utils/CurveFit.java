package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        public Constant(double r5, double[] r10) {
            this.mTime = r5;
            this.mValue = r10;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double r5, double[] r10) {
            double[] r11 = this.mValue;
            System.arraycopy(r11, 0, r10, 0, r11.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double r5, int r10) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double r5, float[] r10) {
            int r11 = 0;
        L3:
            double[] r12 = this.mValue;
            if (r11 >= r12.length) goto L6;
            r10[r11] = (float) r12[r11];
            r11 = r11 + 1;
            goto L3
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double r5, double[] r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.mValue.length) goto L6;
            r10[r11] = 0.0d;
            r11 = r11 + 1;
            goto L4
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double r5, int r10) {
            return this.mValue[r10];
        }
    }

    public CurveFit() {
    }

    public static CurveFit get(int r5, double[] r10, double[][] r11) {
        if (r10.length != 1) goto L5;
        r5 = 2;
    L5:
        if (r5 == 0) goto L12;
        if (r5 == 2) goto L10;
        return new LinearCurveFit(r10, r11);
    L10:
        return new Constant(r10[0], r11[0]);
    L12:
        return new MonotonicCurveFit(r10, r11);
    }

    public static CurveFit getArc(int[] r5, double[] r10, double[][] r11) {
        return new ArcCurveFit(r5, r10, r11);
    }

    public abstract double getPos(double r5, int r10);

    public abstract void getPos(double r5, double[] r10);

    public abstract void getPos(double r5, float[] r10);

    public abstract double getSlope(double r5, int r10);

    public abstract void getSlope(double r5, double[] r10);

    public abstract double[] getTimePoints();
}
