package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[] mValues;

    public static class AlphaSet extends SplineSet {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setAlpha(get(r10));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String r5, SparseArray<ConstraintAttribute> r10) {
            this.mAttributeName = r5.split(",")[1];
            this.mConstraintAttributeList = r10;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int r5, float r10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            this.mCurveFit.getPos(r10, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r5, this.mTempValues);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int r12) {
            int r5 = this.mConstraintAttributeList.size();
            int r10 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] r11 = new double[r5];
            this.mTempValues = new float[r10];
            double[][] r13 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r10});
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L9;
            int r15 = this.mConstraintAttributeList.keyAt(r14);
            ConstraintAttribute r16 = this.mConstraintAttributeList.valueAt(r14);
            r11[r14] = ((double) r15) * 0.01d;
            r16.getValuesToInterpolate(this.mTempValues);
            int r17 = 0;
        L5:
            float[] r18 = this.mTempValues;
            if (r17 >= r18.length) goto L8;
            r13[r14][r17] = r18[r17];
            r17 = r17 + 1;
            goto L5
        L8:
            r14 = r14 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r11, r13);
        }

        public void setPoint(int r5, ConstraintAttribute r10) {
            this.mConstraintAttributeList.append(r5, r10);
        }
    }

    public static class ElevationSet extends SplineSet {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setElevation(get(r10));
        }
    }

    public static class PathRotate extends SplineSet {
        public PathRotate() {
        }

        public void setPathRotate(View r5, float r10, double r11, double r12) {
            r5.setRotation(get(r10) + ((float) Math.toDegrees(Math.atan2(r12, r11))));
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
        }
    }

    public static class PivotXset extends SplineSet {
        public PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setPivotX(get(r10));
        }
    }

    public static class PivotYset extends SplineSet {
        public PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setPivotY(get(r10));
        }
    }

    public static class ProgressSet extends SplineSet {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
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
            Log.e(SplineSet.TAG, "unable to setProgress", e);
            return;
        L14:
            e = move-exception;
            Log.e(SplineSet.TAG, "unable to setProgress", e);
            return;
        L26:
            return;
        L10:
            this.mNoMethod = true;
            r5 = null;
            goto L11
        }
    }

    public static class RotationSet extends SplineSet {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setRotation(get(r10));
        }
    }

    public static class RotationXset extends SplineSet {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setRotationX(get(r10));
        }
    }

    public static class RotationYset extends SplineSet {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setRotationY(get(r10));
        }
    }

    public static class ScaleXset extends SplineSet {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setScaleX(get(r10));
        }
    }

    public static class ScaleYset extends SplineSet {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setScaleY(get(r10));
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] r10, float[] r11, int r12, int r13) {
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

        private static void swap(int[] r5, float[] r10, int r11, int r12) {
            int r13 = r5[r11];
            r5[r11] = r5[r12];
            r5[r12] = r13;
            float r14 = r10[r11];
            r10[r11] = r10[r12];
            r10[r12] = r14;
        }
    }

    public static class TranslationXset extends SplineSet {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setTranslationX(get(r10));
        }
    }

    public static class TranslationYset extends SplineSet {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setTranslationY(get(r10));
        }
    }

    public static class TranslationZset extends SplineSet {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r5, float r10) {
            r5.setTranslationZ(get(r10));
        }
    }

    public SplineSet() {
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public static SplineSet makeCustomSpline(String r5, SparseArray<ConstraintAttribute> r10) {
        return new CustomSet(r5, r10);
    }

    public static SplineSet makeSpline(String r5) {
        r5.getClass();
        byte r10 = -1;
        switch(r5.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r10) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new AlphaSet();
    L75:
        return new AlphaSet();
    L77:
        return new PathRotate();
    L79:
        return new ElevationSet();
    L81:
        return new RotationSet();
    L83:
        return new PivotYset();
    L85:
        return new PivotXset();
    L87:
        return new AlphaSet();
    L89:
        return new ScaleYset();
    L91:
        return new ScaleXset();
    L93:
        return new ProgressSet();
    L95:
        return new TranslationZset();
    L97:
        return new TranslationYset();
    L99:
        return new TranslationXset();
    L101:
        return new RotationYset();
    L103:
        return new RotationXset();
    L6:
        if (r5.equals("waveOffset") == false) goto L69;
        r10 = 15;
        goto L69
    L10:
        if (r5.equals("alpha") == false) goto L69;
        r10 = 14;
        goto L69
    L14:
        if (r5.equals("transitionPathRotate") == false) goto L69;
        r10 = 13;
        goto L69
    L18:
        if (r5.equals("elevation") == false) goto L69;
        r10 = 12;
        goto L69
    L22:
        if (r5.equals("rotation") == false) goto L69;
        r10 = 11;
        goto L69
    L26:
        if (r5.equals("transformPivotY") == false) goto L69;
        r10 = 10;
        goto L69
    L30:
        if (r5.equals("transformPivotX") == false) goto L69;
        r10 = 9;
        goto L69
    L34:
        if (r5.equals("waveVariesBy") == false) goto L69;
        r10 = 8;
        goto L69
    L38:
        if (r5.equals("scaleY") == false) goto L69;
        r10 = 7;
        goto L69
    L42:
        if (r5.equals("scaleX") == false) goto L69;
        r10 = 6;
        goto L69
    L46:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L69;
        r10 = 5;
        goto L69
    L50:
        if (r5.equals("translationZ") == false) goto L69;
        r10 = 4;
        goto L69
    L54:
        if (r5.equals("translationY") == false) goto L69;
        r10 = 3;
        goto L69
    L58:
        if (r5.equals("translationX") == false) goto L69;
        r10 = 2;
        goto L69
    L62:
        if (r5.equals("rotationY") == false) goto L69;
        r10 = 1;
        goto L69
    L66:
        if (r5.equals("rotationX") == false) goto L69;
        r10 = 0;
        goto L69
    }

    public float get(float r5) {
        return (float) this.mCurveFit.getPos(r5, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float r5) {
        return (float) this.mCurveFit.getSlope(r5, 0);
    }

    public void setPoint(int r5, float r10) {
        int[] r11 = this.mTimePoints;
        if (r11.length >= (this.count + 1)) goto L5;
        this.mTimePoints = Arrays.copyOf(r11, r11.length * 2);
        float[] r12 = this.mValues;
        this.mValues = Arrays.copyOf(r12, r12.length * 2);
    L5:
        int[] r13 = this.mTimePoints;
        int r14 = this.count;
        r13[r14] = r5;
        this.mValues[r14] = r10;
        this.count = r14 + 1;
    }

    public abstract void setProperty(View r5, float r10);

    public void setType(String r5) {
        this.mType = r5;
    }

    public void setup(int r10) {
        int r5 = this.count;
        if (r5 != 0) goto L5;
        return;
    L5:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r5 - 1);
        int r11 = 1;
        int r12 = 1;
    L7:
        if (r11 >= this.count) goto L12;
        int[] r13 = this.mTimePoints;
        if (r13[r11 - 1] == r13[r11]) goto L11;
        r12 = r12 + 1;
    L11:
        r11 = r11 + 1;
        goto L7
    L12:
        double[] r14 = new double[r12];
        double[][] r15 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r12, 1});
        int r16 = 0;
        int r17 = 0;
    L14:
        if (r16 >= this.count) goto L21;
        if (r16 <= 0) goto L19;
        int[] r18 = this.mTimePoints;
        if (r18[r16] != r18[r16 - 1]) goto L19;
    L20:
        r16 = r16 + 1;
    L19:
        r14[r17] = ((double) this.mTimePoints[r16]) * 0.01d;
        r15[r17][0] = this.mValues[r16];
        r17 = r17 + 1;
        goto L20
    L21:
        this.mCurveFit = CurveFit.get(r10, r14, r15);
    }

    public String toString() {
        String r5 = this.mType;
        DecimalFormat r10 = new DecimalFormat("##.##");
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L6;
        StringBuilder r12 = j0.w(r5, "[");
        r12.append(this.mTimePoints[r11]);
        r12.append(" , ");
        r12.append(r10.format(this.mValues[r11]));
        r12.append("] ");
        r5 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }
}
