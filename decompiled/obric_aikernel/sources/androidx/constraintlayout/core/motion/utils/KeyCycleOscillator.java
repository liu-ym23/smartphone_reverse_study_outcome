package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy;
    ArrayList<WavePoint> mWavePoints;
    private int mWaveShape;
    private String mWaveString;

    private static class CoreSpline extends KeyCycleOscillator {
        String type;
        int typeId;

        public CoreSpline(String r10) {
            this.type = r10;
            this.typeId = TypedValues.CycleType.getId(r10);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget r10, float r11) {
            r10.setValue(this.typeId, get(r11));
        }
    }

    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        CurveFit mCurveFit;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        float[] mPhase;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int r10, String r11, int r12, int r13) {
            Oscillator r14 = new Oscillator();
            this.mOscillator = r14;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = r10;
            this.mVariesBy = r12;
            r14.setType(r10, r11);
            this.mValues = new float[r13];
            this.mPosition = new double[r13];
            this.mPeriod = new float[r13];
            this.mOffset = new float[r13];
            this.mPhase = new float[r13];
            this.mScale = new float[r13];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float r14) {
            CurveFit r10 = this.mCurveFit;
            if (r10 == null) goto L5;
            double r11 = r14;
            r10.getSlope(r11, this.mSplineSlopeCache);
            this.mCurveFit.getPos(r11, this.mSplineValueCache);
        L6:
            double r12 = r14;
            double r13 = this.mOscillator.getValue(r12, this.mSplineValueCache[1]);
            double r15 = this.mOscillator.getSlope(r12, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] r16 = this.mSplineSlopeCache;
            return (r16[0] + (r13 * r16[2])) + (r15 * this.mSplineValueCache[2]);
        L5:
            double[] r17 = this.mSplineSlopeCache;
            r17[0] = 0.0d;
            r17[1] = 0.0d;
            r17[2] = 0.0d;
            goto L6
        }

        public double getValues(float r10) {
            CurveFit r11 = this.mCurveFit;
            if (r11 == null) goto L5;
            r11.getPos(r10, this.mSplineValueCache);
        L6:
            double[] r12 = this.mSplineValueCache;
            return r12[0] + (this.mOscillator.getValue(r10, r12[1]) * this.mSplineValueCache[2]);
        L5:
            double[] r13 = this.mSplineValueCache;
            r13[0] = this.mOffset[0];
            r13[1] = this.mPhase[0];
            r13[2] = this.mValues[0];
            goto L6
        }

        public void setPoint(int r10, int r11, float r12, float r13, float r14, float r15) {
            this.mPosition[r10] = ((double) r11) / 100.0d;
            this.mPeriod[r10] = r12;
            this.mOffset[r10] = r13;
            this.mPhase[r10] = r14;
            this.mValues[r10] = r15;
        }

        public void setup(float r10) {
            this.mPathLength = r10;
            double[][] r11 = (double[][]) Array.newInstance(double.class, new int[]{this.mPosition.length, 3});
            float[] r12 = this.mValues;
            this.mSplineValueCache = new double[r12.length + 2];
            this.mSplineSlopeCache = new double[r12.length + 2];
            if (this.mPosition[0] <= 0.0d) goto L5;
            this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
        L5:
            double[] r13 = this.mPosition;
            int r14 = r13.length - 1;
            if (r13[r14] >= 1.0d) goto L8;
            this.mOscillator.addPoint(1.0d, this.mPeriod[r14]);
        L8:
            int r15 = 0;
        L10:
            if (r15 >= r11.length) goto L12;
            r11[r15][0] = this.mOffset[r15];
            r11[r15][1] = this.mPhase[r15];
            r11[r15][2] = this.mValues[r15];
            this.mOscillator.addPoint(this.mPosition[r15], this.mPeriod[r15]);
            r15 = r15 + 1;
            goto L10
        L12:
            this.mOscillator.normalize();
            double[] r16 = this.mPosition;
            if (r16.length <= 1) goto L15;
            CurveFit r17 = CurveFit.get(0, r16, r11);
        L16:
            this.mCurveFit = r17;
            return;
        L15:
            r17 = null;
            goto L16
        }
    }

    private static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] r10, float[] r11, int r12, int r13) {
            int r14 = r10[r13];
            int r15 = r12;
        L3:
            if (r12 >= r13) goto L8;
            if (r10[r12] > r14) goto L7;
            swap(r10, r11, r15, r12);
            r15 = r15 + 1;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            swap(r10, r11, r15, r13);
            return r15;
        }

        static void sort(int[] r10, float[] r11, int r12, int r13) {
            int[] r14 = new int[r10.length + 10];
            r14[0] = r13;
            r14[1] = r12;
            int r15 = 2;
        L3:
            if (r15 <= 0) goto L7;
            int r16 = r15 - 1;
            int r17 = r14[r16];
            r15 = r16 - 1;
            int r18 = r14[r15];
            if (r17 >= r18) goto L3;
            int r19 = partition(r10, r11, r17, r18);
            int r20 = r15 + 1;
            r14[r15] = r19 - 1;
            int r21 = r20 + 1;
            r14[r20] = r17;
            int r22 = r21 + 1;
            r14[r21] = r18;
            r15 = r22 + 1;
            r14[r22] = r19 + 1;
            goto L3
        }

        private static void swap(int[] r10, float[] r11, int r12, int r13) {
            int r14 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r14;
            float r15 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r15;
        }
    }

    private static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] r10, float[] r11, float[] r12, int r13, int r14) {
            int r15 = r10[r14];
            int r16 = r13;
        L3:
            if (r13 >= r14) goto L8;
            if (r10[r13] > r15) goto L7;
            swap(r10, r11, r12, r16, r13);
            r16 = r16 + 1;
        L7:
            r13 = r13 + 1;
            goto L3
        L8:
            swap(r10, r11, r12, r16, r14);
            return r16;
        }

        static void sort(int[] r10, float[] r11, float[] r12, int r13, int r14) {
            int[] r15 = new int[r10.length + 10];
            r15[0] = r14;
            r15[1] = r13;
            int r16 = 2;
        L3:
            if (r16 <= 0) goto L7;
            int r17 = r16 - 1;
            int r18 = r15[r17];
            r16 = r17 - 1;
            int r19 = r15[r16];
            if (r18 >= r19) goto L3;
            int r20 = partition(r10, r11, r12, r18, r19);
            int r21 = r16 + 1;
            r15[r16] = r20 - 1;
            int r22 = r21 + 1;
            r15[r21] = r18;
            int r23 = r22 + 1;
            r15[r22] = r19;
            r16 = r23 + 1;
            r15[r23] = r20 + 1;
            goto L3
        }

        private static void swap(int[] r10, float[] r11, float[] r12, int r13, int r14) {
            int r15 = r10[r13];
            r10[r13] = r10[r14];
            r10[r14] = r15;
            float r16 = r11[r13];
            r11[r13] = r11[r14];
            r11[r14] = r16;
            float r17 = r12[r13];
            r12[r13] = r12[r14];
            r12[r14] = r17;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String type;
        int typeId;

        public PathRotateSet(String r10) {
            this.type = r10;
            this.typeId = TypedValues.CycleType.getId(r10);
        }

        public void setPathRotate(MotionWidget r10, float r11, double r12, double r13) {
            r10.setRotationZ(get(r11) + ((float) Math.toDegrees(Math.atan2(r13, r12))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget r10, float r11) {
            r10.setValue(this.typeId, get(r11));
        }
    }

    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int r10, float r11, float r12, float r13, float r14) {
            this.mPosition = r10;
            this.mValue = r14;
            this.mOffset = r12;
            this.mPeriod = r11;
            this.mPhase = r13;
        }
    }

    public KeyCycleOscillator() {
        this.mWaveShape = 0;
        this.mWaveString = null;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList();
    }

    public static KeyCycleOscillator makeWidgetCycle(String r10) {
        if (r10.equals("pathRotate") == false) goto L7;
        return new PathRotateSet(r10);
    L7:
        return new CoreSpline(r10);
    }

    public float get(float r10) {
        return (float) this.mCycleOscillator.getValues(r10);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float r10) {
        return (float) this.mCycleOscillator.getSlope(r10);
    }

    protected void setCustom(Object r10) {
    }

    public void setPoint(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.mWavePoints.add(new WavePoint(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.mVariesBy = r14;
    L5:
        this.mWaveShape = r12;
        this.mWaveString = r13;
    }

    public void setPoint(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.mWavePoints.add(new WavePoint(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.mVariesBy = r14;
    L5:
        this.mWaveShape = r12;
        setCustom(r19);
        this.mWaveString = r13;
    }

    public void setProperty(MotionWidget r10, float r11) {
    }

    public void setType(String r10) {
        this.mType = r10;
    }

    public void setup(float r16) {
        int r10 = this.mWavePoints.size();
        if (r10 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.mWavePoints, new AnonymousClass1(this));
        double[] r11 = new double[r10];
        char r12 = 0;
        double[][] r13 = (double[][]) Array.newInstance(double.class, new int[]{r10, 3});
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, r10);
        Iterator<WavePoint> r14 = this.mWavePoints.iterator();
        int r15 = 0;
    L7:
        if (r14.hasNext() == false) goto L9;
        WavePoint r17 = r14.next();
        float r18 = r17.mPeriod;
        r11[r15] = ((double) r18) * 0.01d;
        double[] r19 = r13[r15];
        float r110 = r17.mValue;
        r19[r12] = r110;
        double[] r20 = r13[r15];
        float r111 = r17.mOffset;
        r20[1] = r111;
        double[] r21 = r13[r15];
        float r112 = r17.mPhase;
        r21[2] = r112;
        this.mCycleOscillator.setPoint(r15, r17.mPosition, r18, r111, r112, r110);
        r15 = r15 + 1;
        r12 = 0;
        goto L7
    L9:
        this.mCycleOscillator.setup(r16);
        this.mCurveFit = CurveFit.get(0, r11, r13);
    }

    public String toString() {
        String r10 = this.mType;
        DecimalFormat r11 = new DecimalFormat("##.##");
        Iterator<WavePoint> r12 = this.mWavePoints.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        WavePoint r13 = r12.next();
        r10 = r10 + "[" + r13.mPosition + " , " + r11.format(r13.mValue) + "] ";
        goto L4
    L6:
        return r10;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
