package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy;
    ArrayList<WavePoint> mWavePoints;
    private int mWaveShape;

    public static class AlphaSet extends KeyCycleOscillator {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setAlpha(get(r10));
        }
    }

    public static class CustomSet extends KeyCycleOscillator {
        float[] value;

        public CustomSet() {
            this.value = new float[1];
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            this.value[0] = get(r10);
            this.mCustom.setInterpolatedValue(r5, this.value);
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int r5, int r10, int r11) {
            this.mOscillator = new Oscillator();
            this.mCustomConstraints = new HashMap();
            this.mWaveShape = r5;
            this.mVariesBy = r10;
            this.mOscillator.setType(r5);
            this.mValues = new float[r11];
            this.mPosition = new double[r11];
            this.mPeriod = new float[r11];
            this.mOffset = new float[r11];
            this.mScale = new float[r11];
        }

        private ConstraintAttribute get(String r5, ConstraintAttribute.AttributeType r10) {
            if (this.mCustomConstraints.containsKey(r5) == false) goto L9;
            ConstraintAttribute r11 = this.mCustomConstraints.get(r5);
            if (r11.getType() != r10) goto L8;
            return r11;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r11.getType().name());
        L9:
            ConstraintAttribute r12 = new ConstraintAttribute(r5, r10);
            this.mCustomConstraints.put(r5, r12);
            return r12;
        }

        public double getSlope(float r10) {
            CurveFit r5 = this.mCurveFit;
            if (r5 == null) goto L5;
            double r11 = r10;
            r5.getSlope(r11, this.mSplineSlopeCache);
            this.mCurveFit.getPos(r11, this.mSplineValueCache);
        L6:
            double r12 = r10;
            double r13 = this.mOscillator.getValue(r12);
            double r14 = this.mOscillator.getSlope(r12);
            double[] r15 = this.mSplineSlopeCache;
            return (r14 * this.mSplineValueCache[1]) + ((r13 * r15[1]) + r15[0]);
        L5:
            double[] r16 = this.mSplineSlopeCache;
            r16[0] = 0.0d;
            r16[1] = 0.0d;
            goto L6
        }

        public double getValues(float r10) {
            CurveFit r5 = this.mCurveFit;
            if (r5 == null) goto L5;
            r5.getPos(r10, this.mSplineValueCache);
        L7:
            return (this.mOscillator.getValue(r10) * this.mSplineValueCache[1]) + this.mSplineValueCache[0];
        L5:
            double[] r11 = this.mSplineValueCache;
            r11[0] = this.mOffset[0];
            r11[1] = this.mValues[0];
            goto L7
        }

        public void setPoint(int r10, int r11, float r12, float r13, float r14) {
            this.mPosition[r10] = ((double) r11) / 100.0d;
            this.mPeriod[r10] = r12;
            this.mOffset[r10] = r13;
            this.mValues[r10] = r14;
        }

        public void setup(float r10) {
            this.mPathLength = r10;
            double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.mPosition.length, 2});
            float[] r5 = this.mValues;
            this.mSplineValueCache = new double[r5.length + 1];
            this.mSplineSlopeCache = new double[r5.length + 1];
            if (this.mPosition[0] <= 0.0d) goto L5;
            this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
        L5:
            double[] r12 = this.mPosition;
            int r13 = r12.length - 1;
            if (r12[r13] >= 1.0d) goto L8;
            this.mOscillator.addPoint(1.0d, this.mPeriod[r13]);
        L8:
            int r14 = 0;
        L10:
            if (r14 >= r11.length) goto L16;
            r11[r14][0] = this.mOffset[r14];
            int r15 = 0;
        L12:
            float[] r16 = this.mValues;
            if (r15 >= r16.length) goto L15;
            r11[r15][1] = r16[r15];
            r15 = r15 + 1;
            goto L12
        L15:
            this.mOscillator.addPoint(this.mPosition[r14], this.mPeriod[r14]);
            r14 = r14 + 1;
            goto L10
        L16:
            this.mOscillator.normalize();
            double[] r17 = this.mPosition;
            if (r17.length <= 1) goto L19;
            this.mCurveFit = CurveFit.get(0, r17, r11);
            return;
        L19:
            this.mCurveFit = null;
        }
    }

    public static class ElevationSet extends KeyCycleOscillator {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setElevation(get(r10));
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] r5, float[] r10, int r11, int r12) {
            int r13 = r5[r12];
            int r14 = r11;
        L3:
            if (r11 >= r12) goto L8;
            if (r5[r11] > r13) goto L7;
            swap(r5, r10, r14, r11);
            r14 = r14 + 1;
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            swap(r5, r10, r14, r12);
            return r14;
        }

        public static void sort(int[] r10, float[] r11, int r12, int r13) {
            int[] r5 = new int[r10.length + 10];
            r5[0] = r13;
            r5[1] = r12;
            int r14 = 2;
        L3:
            if (r14 <= 0) goto L8;
            int r15 = r5[r14 - 1];
            int r16 = r14 - 2;
            int r17 = r5[r16];
            if (r15 < r17) goto L6;
            r14 = r16;
            goto L3
        L6:
            int r18 = partition(r10, r11, r15, r17);
            r5[r16] = r18 - 1;
            r5[r14 - 1] = r15;
            int r19 = r14 + 1;
            r5[r14] = r17;
            r14 = r14 + 2;
            r5[r19] = r18 + 1;
            goto L3
        }

        private static void swap(int[] r5, float[] r10, int r11, int r12) {
            int r13 = r5[r11];
            r5[r11] = r5[r12];
            r5[r12] = r13;
            float r14 = r10[r11];
            r10[r11] = r10[r12];
            r10[r12] = r14;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] r5, float[] r10, float[] r11, int r12, int r13) {
            int r14 = r5[r13];
            int r15 = r12;
        L3:
            if (r12 >= r13) goto L8;
            if (r5[r12] > r14) goto L7;
            swap(r5, r10, r11, r15, r12);
            r15 = r15 + 1;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            swap(r5, r10, r11, r15, r13);
            return r15;
        }

        public static void sort(int[] r10, float[] r11, float[] r12, int r13, int r14) {
            int[] r5 = new int[r10.length + 10];
            r5[0] = r14;
            r5[1] = r13;
            int r15 = 2;
        L3:
            if (r15 <= 0) goto L8;
            int r16 = r5[r15 - 1];
            int r17 = r15 - 2;
            int r18 = r5[r17];
            if (r16 < r18) goto L6;
            r15 = r17;
            goto L3
        L6:
            int r19 = partition(r10, r11, r12, r16, r18);
            r5[r17] = r19 - 1;
            r5[r15 - 1] = r16;
            int r20 = r15 + 1;
            r5[r15] = r18;
            r15 = r15 + 2;
            r5[r20] = r19 + 1;
            goto L3
        }

        private static void swap(int[] r5, float[] r10, float[] r11, int r12, int r13) {
            int r14 = r5[r12];
            r5[r12] = r5[r13];
            r5[r13] = r14;
            float r15 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r15;
            float r16 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r16;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        public PathRotateSet() {
        }

        public void setPathRotate(View r5, float r10, double r11, double r12) {
            r5.setRotation(get(r10) + ((float) Math.toDegrees(Math.atan2(r12, r11))));
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
        }
    }

    public static class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r10, float r11) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(get(r11));
            return;
        L6:
            if (this.mNoMethod == false) goto L21;
            return;
        L21:
            Method r5 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L10
        L11:
            if (r5 == null) goto L26;
            r5.invoke(r10, new Object[]{Float.valueOf(get(r11))});     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16
        L28:
            return;
        L16:
            e = move-exception;
            Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e);
            return;
        L14:
            e = move-exception;
            Log.e(KeyCycleOscillator.TAG, "unable to setProgress", e);
            return;
        L26:
            return;
        L10:
            this.mNoMethod = true;
            r5 = null;
            goto L11
        }
    }

    public static class RotationSet extends KeyCycleOscillator {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setRotation(get(r10));
        }
    }

    public static class RotationXset extends KeyCycleOscillator {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setRotationX(get(r10));
        }
    }

    public static class RotationYset extends KeyCycleOscillator {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setRotationY(get(r10));
        }
    }

    public static class ScaleXset extends KeyCycleOscillator {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setScaleX(get(r10));
        }
    }

    public static class ScaleYset extends KeyCycleOscillator {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setScaleY(get(r10));
        }
    }

    public static class TranslationXset extends KeyCycleOscillator {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setTranslationX(get(r10));
        }
    }

    public static class TranslationYset extends KeyCycleOscillator {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setTranslationY(get(r10));
        }
    }

    public static class TranslationZset extends KeyCycleOscillator {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r5, float r10) {
            r5.setTranslationZ(get(r10));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int r5, float r10, float r11, float r12) {
            this.mPosition = r5;
            this.mValue = r12;
            this.mOffset = r11;
            this.mPeriod = r10;
        }
    }

    public KeyCycleOscillator() {
        this.mWaveShape = 0;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList();
    }

    public static KeyCycleOscillator makeSpline(String r5) {
        if (r5.startsWith("CUSTOM") == true) goto L5;
        byte r10 = -1;
        switch(r5.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r10) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L69:
        return new AlphaSet();
    L71:
        return new AlphaSet();
    L73:
        return new PathRotateSet();
    L75:
        return new ElevationSet();
    L77:
        return new RotationSet();
    L79:
        return new AlphaSet();
    L81:
        return new ScaleYset();
    L83:
        return new ScaleXset();
    L85:
        return new ProgressSet();
    L87:
        return new TranslationZset();
    L89:
        return new TranslationYset();
    L91:
        return new TranslationXset();
    L93:
        return new RotationYset();
    L95:
        return new RotationXset();
    L10:
        if (r5.equals("waveOffset") == false) goto L65;
        r10 = 13;
        goto L65
    L14:
        if (r5.equals("alpha") == false) goto L65;
        r10 = 12;
        goto L65
    L18:
        if (r5.equals("transitionPathRotate") == false) goto L65;
        r10 = 11;
        goto L65
    L22:
        if (r5.equals("elevation") == false) goto L65;
        r10 = 10;
        goto L65
    L26:
        if (r5.equals("rotation") == false) goto L65;
        r10 = 9;
        goto L65
    L30:
        if (r5.equals("waveVariesBy") == false) goto L65;
        r10 = 8;
        goto L65
    L34:
        if (r5.equals("scaleY") == false) goto L65;
        r10 = 7;
        goto L65
    L38:
        if (r5.equals("scaleX") == false) goto L65;
        r10 = 6;
        goto L65
    L42:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L65;
        r10 = 5;
        goto L65
    L46:
        if (r5.equals("translationZ") == false) goto L65;
        r10 = 4;
        goto L65
    L50:
        if (r5.equals("translationY") == false) goto L65;
        r10 = 3;
        goto L65
    L54:
        if (r5.equals("translationX") == false) goto L65;
        r10 = 2;
        goto L65
    L58:
        if (r5.equals("rotationY") == false) goto L65;
        r10 = 1;
        goto L65
    L62:
        if (r5.equals("rotationX") == false) goto L65;
        r10 = 0;
        goto L65
    L5:
        return new CustomSet();
    }

    public float get(float r5) {
        return (float) this.mCycleOscillator.getValues(r5);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float r5) {
        return (float) this.mCycleOscillator.getSlope(r5);
    }

    public void setPoint(int r5, int r10, int r11, float r12, float r13, float r14, ConstraintAttribute r15) {
        this.mWavePoints.add(new WavePoint(r5, r12, r13, r14));
        if (r11 == (-1)) goto L5;
        this.mVariesBy = r11;
    L5:
        this.mWaveShape = r10;
        this.mCustom = r15;
    }

    public abstract void setProperty(View r5, float r10);

    public void setType(String r5) {
        this.mType = r5;
    }

    @TargetApi(19)
    public void setup(float r15) {
        int r5 = this.mWavePoints.size();
        if (r5 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.mWavePoints, new AnonymousClass1(this));
        double[] r10 = new double[r5];
        double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, 2});
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, r5);
        Iterator<WavePoint> r12 = this.mWavePoints.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L9;
        WavePoint r14 = r12.next();
        float r16 = r14.mPeriod;
        r10[r13] = ((double) r16) * 0.01d;
        double[] r17 = r11[r13];
        float r18 = r14.mValue;
        r17[0] = r18;
        float r19 = r14.mOffset;
        r17[1] = r19;
        this.mCycleOscillator.setPoint(r13, r14.mPosition, r16, r19, r18);
        r13 = r13 + 1;
        goto L7
    L9:
        this.mCycleOscillator.setup(r15);
        this.mCurveFit = CurveFit.get(0, r10, r11);
    }

    public String toString() {
        String r5 = this.mType;
        DecimalFormat r10 = new DecimalFormat("##.##");
        Iterator<WavePoint> r11 = this.mWavePoints.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        WavePoint r12 = r11.next();
        StringBuilder r13 = j0.w(r5, "[");
        r13.append(r12.mPosition);
        r13.append(" , ");
        r13.append(r10.format(r12.mValue));
        r13.append("] ");
        r5 = r13.toString();
        goto L4
    L6:
        return r5;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setPoint(int r5, int r10, int r11, float r12, float r13, float r14) {
        this.mWavePoints.add(new WavePoint(r5, r12, r13, r14));
        if (r11 == (-1)) goto L5;
        this.mVariesBy = r11;
    L5:
        this.mWaveShape = r10;
    }
}
