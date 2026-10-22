package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setAlpha(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties;

        public CustomSet(String r10, SparseArray<ConstraintAttribute> r11) {
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r10, float r11, float r12, int r13, float r14) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int r10, ConstraintAttribute r11, float r12, int r13, float r14) {
            this.mConstraintAttributeList.append(r10, r11);
            this.mWaveProperties.append(r10, new float[]{r12, r14});
            this.mWaveShape = Math.max(this.mWaveShape, r13);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r10 = this.mTempValues;
            float r11 = r10[r10.length - 2];
            float r12 = r10[r10.length - 1];
            long r13 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r14 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r14;
            if (Float.isNaN(r14) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r15 = (float) ((((double) this.last_cycle) + ((r13 * 1.0E-9d) * ((double) r11))) % 1.0d);
            this.last_cycle = r15;
            this.last_time = r19;
            float r16 = calcWave(r15);
            this.mContinue = false;
            int r20 = 0;
        L8:
            float[] r22 = this.mCache;
            if (r20 >= r22.length) goto L15;
            boolean r23 = this.mContinue;
            float[] r24 = this.mTempValues;
            if (r24[r20] == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.mContinue = r23 | r110;
            r22[r20] = (r24[r20] * r16) + r12;
            r20 = r20 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), r17, this.mCache);
            if (r11 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int r15) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r12 = new double[r10];
            int r13 = r11 + 2;
            this.mTempValues = new float[r13];
            this.mCache = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r13});
            int r16 = 0;
        L3:
            if (r16 >= r10) goto L9;
            int r17 = this.mConstraintAttributeList.keyAt(r16);
            ConstraintAttribute r18 = this.mConstraintAttributeList.valueAt(r16);
            float[] r19 = this.mWaveProperties.valueAt(r16);
            r12[r16] = ((double) r17) * 0.01d;
            r18.getValuesToInterpolate(this.mTempValues);
            int r20 = 0;
        L5:
            float[] r21 = this.mTempValues;
            if (r20 >= r21.length) goto L8;
            r14[r16][r20] = r21[r20];
            r20 = r20 + 1;
            goto L5
        L8:
            r14[r16][r11] = r19[0];
            r14[r16][r11 + 1] = r19[1];
            r16 = r16 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r15, r12, r14);
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r10.setElevation(get(r11, r12, r10, r13));
        L6:
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public PathRotate() {
        }

        public boolean setPathRotate(View r10, KeyCache r11, float r12, long r13, double r14, double r15) {
            r10.setRotation(get(r12, r13, r10, r11) + ((float) Math.toDegrees(Math.atan2(r15, r14))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r14, float r15, long r16, KeyCache r18) {
            if ((r14 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r14).setProgress(get(r15, r16, r14, r18));
        L19:
            return this.mContinue;
        L6:
            if (this.mNoMethod == false) goto L8;
            return false;
        L8:
            Method r10 = null;
            r10 = r14.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            Method r11 = r10;
            if (r11 == null) goto L19;
            r11.invoke(r14, new Object[]{Float.valueOf(get(r15, r16, r14, r18))});     // Catch: Throwable -> L16
        L16:
            e = move-exception;
            Log.e(ViewTimeCycle.TAG, "unable to setProgress", e);
        L11:
            this.mNoMethod = true;
            goto L12
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotation(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotationX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotationY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setScaleX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setScaleY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setTranslationX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setTranslationY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r10.setTranslationZ(get(r11, r12, r10, r13));
        L6:
            return this.mContinue;
        }
    }

    public ViewTimeCycle() {
    }

    public static ViewTimeCycle makeCustomSpline(String r10, SparseArray<ConstraintAttribute> r11) {
        return new CustomSet(r10, r11);
    }

    public static ViewTimeCycle makeSpline(String r10, long r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L50;
            case -1249320805: goto L46;
            case -1225497657: goto L42;
            case -1225497656: goto L38;
            case -1225497655: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -40300674: goto L18;
            case -4379043: goto L14;
            case 37232917: goto L10;
            case 92909918: goto L6;
            default: goto L53;
        };
    L53:
        switch(r12) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        return null;
    L56:
        ViewTimeCycle r13 = new AlphaSet();
    L68:
        r13.setStartTime(r11);
        return r13;
    L57:
        r13 = new PathRotate();
        goto L68
    L58:
        r13 = new ElevationSet();
        goto L68
    L59:
        r13 = new RotationSet();
        goto L68
    L60:
        r13 = new ScaleYset();
        goto L68
    L61:
        r13 = new ScaleXset();
        goto L68
    L62:
        r13 = new ProgressSet();
        goto L68
    L63:
        r13 = new TranslationZset();
        goto L68
    L64:
        r13 = new TranslationYset();
        goto L68
    L65:
        r13 = new TranslationXset();
        goto L68
    L66:
        r13 = new RotationYset();
        goto L68
    L67:
        r13 = new RotationXset();
        goto L68
    L6:
        if (r10.equals("alpha") == false) goto L53;
        r12 = 11;
        goto L53
    L10:
        if (r10.equals("transitionPathRotate") == false) goto L53;
        r12 = 10;
        goto L53
    L14:
        if (r10.equals("elevation") == false) goto L53;
        r12 = 9;
        goto L53
    L18:
        if (r10.equals(Key.ROTATION) == false) goto L53;
        r12 = 8;
        goto L53
    L22:
        if (r10.equals("scaleY") == false) goto L53;
        r12 = 7;
        goto L53
    L26:
        if (r10.equals("scaleX") == false) goto L53;
        r12 = 6;
        goto L53
    L30:
        if (r10.equals("progress") == false) goto L53;
        r12 = 5;
        goto L53
    L34:
        if (r10.equals("translationZ") == false) goto L53;
        r12 = 4;
        goto L53
    L38:
        if (r10.equals("translationY") == false) goto L53;
        r12 = 3;
        goto L53
    L42:
        if (r10.equals("translationX") == false) goto L53;
        r12 = 2;
        goto L53
    L46:
        if (r10.equals("rotationY") == false) goto L53;
        r12 = 1;
        goto L53
    L50:
        if (r10.equals("rotationX") == false) goto L53;
        r12 = 0;
        goto L53
    }

    public float get(float r19, long r20, View r22, KeyCache r23) {
        this.mCurveFit.getPos(r19, this.mCache);
        float[] r10 = this.mCache;
        float r11 = r10[1];
        if (r11 != 0.0f) goto L7;
        this.mContinue = false;
        return r10[2];
    L7:
        if (Float.isNaN(this.last_cycle) == false) goto L11;
        float r12 = r23.getFloatValue(r22, this.mType, 0);
        this.last_cycle = r12;
        if (Float.isNaN(r12) == false) goto L11;
        this.last_cycle = 0.0f;
    L11:
        float r13 = (float) ((((double) this.last_cycle) + (((r20 - this.last_time) * 1.0E-9d) * ((double) r11))) % 1.0d);
        this.last_cycle = r13;
        r23.setFloatValue(r22, this.mType, 0, r13);
        this.last_time = r20;
        float r14 = this.mCache[0];
        float r15 = (calcWave(this.last_cycle) * r14) + this.mCache[2];
        if (r14 != 0.0f) goto L16;
        if (r11 != 0.0f) goto L16;
        boolean r16 = false;
    L17:
        this.mContinue = r16;
        return r15;
    L16:
        r16 = true;
        goto L17
    }

    public abstract boolean setProperty(View r10, float r11, long r12, KeyCache r13);
}
