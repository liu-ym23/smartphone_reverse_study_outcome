package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setAlpha(get(r11));
        }
    }

    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String r10, SparseArray<ConstraintAttribute> r11) {
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r10, float r11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int r10, ConstraintAttribute r11) {
            this.mConstraintAttributeList.append(r10, r11);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            this.mCurveFit.getPos(r11, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), r10, this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int r12) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r13 = new double[r10];
            this.mTempValues = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r11});
            int r15 = 0;
        L3:
            if (r15 >= r10) goto L9;
            int r16 = this.mConstraintAttributeList.keyAt(r15);
            ConstraintAttribute r17 = this.mConstraintAttributeList.valueAt(r15);
            r13[r15] = ((double) r16) * 0.01d;
            r17.getValuesToInterpolate(this.mTempValues);
            int r18 = 0;
        L5:
            float[] r19 = this.mTempValues;
            if (r18 >= r19.length) goto L8;
            r14[r15][r18] = r19[r18];
            r18 = r18 + 1;
            goto L5
        L8:
            r15 = r15 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r13, r14);
        }
    }

    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r10.setElevation(get(r11));
            return;
        }
    }

    public static class PathRotate extends ViewSpline {
        public PathRotate() {
        }

        public void setPathRotate(View r10, float r11, double r12, double r13) {
            r10.setRotation(get(r11) + ((float) Math.toDegrees(Math.atan2(r13, r12))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
        }
    }

    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setPivotX(get(r11));
        }
    }

    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setPivotY(get(r11));
        }
    }

    static class ProgressSet extends ViewSpline {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(get(r11));
            return;
        L6:
            if (this.mNoMethod == false) goto L8;
            return;
        L8:
            Method r12 = null;
            r12 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r12 == null) goto L23;
            r12.invoke(r10, new Object[]{Float.valueOf(get(r11))});     // Catch: Throwable -> L15
            return;
        L15:
            e = move-exception;
            Log.e(ViewSpline.TAG, "unable to setProgress", e);
            return;
        L23:
            return;
        L11:
            this.mNoMethod = true;
            goto L12
        }
    }

    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setRotation(get(r11));
        }
    }

    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setRotationX(get(r11));
        }
    }

    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setRotationY(get(r11));
        }
    }

    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setScaleX(get(r11));
        }
    }

    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setScaleY(get(r11));
        }
    }

    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setTranslationX(get(r11));
        }
    }

    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            r10.setTranslationY(get(r11));
        }
    }

    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View r10, float r11) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r10.setTranslationZ(get(r11));
            return;
        }
    }

    public ViewSpline() {
    }

    public static ViewSpline makeCustomSpline(String r10, SparseArray<ConstraintAttribute> r11) {
        return new CustomSet(r10, r11);
    }

    public static ViewSpline makeSpline(String r10) {
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
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
        switch(r11) {
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
        if (r10.equals("waveOffset") == false) goto L69;
        r11 = 15;
        goto L69
    L10:
        if (r10.equals("alpha") == false) goto L69;
        r11 = 14;
        goto L69
    L14:
        if (r10.equals("transitionPathRotate") == false) goto L69;
        r11 = 13;
        goto L69
    L18:
        if (r10.equals("elevation") == false) goto L69;
        r11 = 12;
        goto L69
    L22:
        if (r10.equals(Key.ROTATION) == false) goto L69;
        r11 = 11;
        goto L69
    L26:
        if (r10.equals(Key.PIVOT_Y) == false) goto L69;
        r11 = 10;
        goto L69
    L30:
        if (r10.equals(Key.PIVOT_X) == false) goto L69;
        r11 = 9;
        goto L69
    L34:
        if (r10.equals(Key.WAVE_VARIES_BY) == false) goto L69;
        r11 = 8;
        goto L69
    L38:
        if (r10.equals("scaleY") == false) goto L69;
        r11 = 7;
        goto L69
    L42:
        if (r10.equals("scaleX") == false) goto L69;
        r11 = 6;
        goto L69
    L46:
        if (r10.equals("progress") == false) goto L69;
        r11 = 5;
        goto L69
    L50:
        if (r10.equals("translationZ") == false) goto L69;
        r11 = 4;
        goto L69
    L54:
        if (r10.equals("translationY") == false) goto L69;
        r11 = 3;
        goto L69
    L58:
        if (r10.equals("translationX") == false) goto L69;
        r11 = 2;
        goto L69
    L62:
        if (r10.equals("rotationY") == false) goto L69;
        r11 = 1;
        goto L69
    L66:
        if (r10.equals("rotationX") == false) goto L69;
        r11 = 0;
        goto L69
    }

    public abstract void setProperty(View r10, float r11);
}
