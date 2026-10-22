package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {
    private static final String TAG = "ViewOscillator";

    static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setAlpha(get(r2));
        }
    }

    static class CustomSet extends ViewOscillator {
        protected ConstraintAttribute mCustom;
        float[] value;

        CustomSet() {
            this.value = new float[1];
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setCustom(Object r3) {
            this.mCustom = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r3, ConstraintAttribute.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r3, float r4) {
            this.value[0] = get(r4);
            CustomSupport.setInterpolatedValue(this.mCustom, r3, this.value);
        }
    }

    static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r3, float r4) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3.setElevation(get(r4));
            return;
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        public PathRotateSet() {
        }

        public void setPathRotate(View r1, float r2, double r3, double r5) {
            r1.setRotation(get(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
        }
    }

    static class ProgressSet extends ViewOscillator {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r10, float r11) {
            if (ZeusTransformUtils.instanceOf(r10, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r10, MotionLayout.class, "com.obric.memorydata.plugin")).setProgress(get(r11));
            return;
        L6:
            if (this.mNoMethod == false) goto L8;
            return;
        L8:
            Method r2 = null;
            r2 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r2 == null) goto L23;
            r2.invoke(r10, new Object[]{Float.valueOf(get(r11))});     // Catch: Throwable -> L15
            return;
        L15:
            e = move-exception;
            Log.e(ViewOscillator.TAG, "unable to setProgress", e);
            return;
        L23:
            return;
        L11:
            this.mNoMethod = true;
            goto L12
        }
    }

    static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotation(get(r2));
        }
    }

    static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotationX(get(r2));
        }
    }

    static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setRotationY(get(r2));
        }
    }

    static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setScaleX(get(r2));
        }
    }

    static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setScaleY(get(r2));
        }
    }

    static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setTranslationX(get(r2));
        }
    }

    static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r1, float r2) {
            r1.setTranslationY(get(r2));
        }
    }

    static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void setProperty(View r3, float r4) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3.setTranslationZ(get(r4));
            return;
        }
    }

    public ViewOscillator() {
    }

    public static ViewOscillator makeSpline(String r2) {
        if (r2.startsWith("CUSTOM") == true) goto L5;
        r2.hashCode();
        byte r0 = -1;
        switch(r2.hashCode()) {
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
        switch(r0) {
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
        if (r2.equals("waveOffset") == false) goto L65;
        r0 = 13;
        goto L65
    L14:
        if (r2.equals("alpha") == false) goto L65;
        r0 = 12;
        goto L65
    L18:
        if (r2.equals("transitionPathRotate") == false) goto L65;
        r0 = 11;
        goto L65
    L22:
        if (r2.equals("elevation") == false) goto L65;
        r0 = 10;
        goto L65
    L26:
        if (r2.equals(Key.ROTATION) == false) goto L65;
        r0 = 9;
        goto L65
    L30:
        if (r2.equals(Key.WAVE_VARIES_BY) == false) goto L65;
        r0 = 8;
        goto L65
    L34:
        if (r2.equals("scaleY") == false) goto L65;
        r0 = 7;
        goto L65
    L38:
        if (r2.equals("scaleX") == false) goto L65;
        r0 = 6;
        goto L65
    L42:
        if (r2.equals("progress") == false) goto L65;
        r0 = 5;
        goto L65
    L46:
        if (r2.equals("translationZ") == false) goto L65;
        r0 = 4;
        goto L65
    L50:
        if (r2.equals("translationY") == false) goto L65;
        r0 = 3;
        goto L65
    L54:
        if (r2.equals("translationX") == false) goto L65;
        r0 = 2;
        goto L65
    L58:
        if (r2.equals("rotationY") == false) goto L65;
        r0 = 1;
        goto L65
    L62:
        if (r2.equals("rotationX") == false) goto L65;
        r0 = 0;
        goto L65
    L5:
        return new CustomSet();
    }

    public abstract void setProperty(View r1, float r2);
}
