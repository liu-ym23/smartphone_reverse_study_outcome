package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mAttrMap = r5;
            r5.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
            mAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            mAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
        }

        public static void read(KeyTimeCycle r5, TypedArray r10) {
            int r11 = r10.getIndexCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L38;
            int r13 = r10.getIndex(r12);
            switch(mAttrMap.get(r13)) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L6;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L21;
                case 11: goto L6;
                case 12: goto L19;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L12;
                case 20: goto L11;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(r13) + "   " + mAttrMap.get(r13));
        L37:
            r12 = r12 + 1;
            goto L3
        L11:
            KeyTimeCycle.access$502(r5, r10.getFloat(r13, KeyTimeCycle.access$500(r5)));
            goto L37
        L12:
            KeyTimeCycle.access$402(r5, r10.getInt(r13, KeyTimeCycle.access$400(r5)));
            goto L37
        L13:
            KeyTimeCycle.access$1602(r5, r10.getFloat(r13, KeyTimeCycle.access$1600(r5)));
            goto L37
        L14:
            KeyTimeCycle.access$1502(r5, r10.getDimension(r13, KeyTimeCycle.access$1500(r5)));
            goto L37
        L15:
            KeyTimeCycle.access$1402(r5, r10.getDimension(r13, KeyTimeCycle.access$1400(r5)));
            goto L37
        L16:
            KeyTimeCycle.access$1302(r5, r10.getDimension(r13, KeyTimeCycle.access$1300(r5)));
            goto L37
        L17:
            KeyTimeCycle.access$1102(r5, r10.getFloat(r13, KeyTimeCycle.access$1100(r5)));
            goto L37
        L18:
            KeyTimeCycle.access$302(r5, r10.getInteger(r13, KeyTimeCycle.access$300(r5)));
            goto L37
        L19:
            r5.mFramePosition = r10.getInt(r13, r5.mFramePosition);
            goto L37
        L29:
            KeyTimeCycle.access$1002(r5, r10.getString(r13));
            goto L37
        L30:
            KeyTimeCycle.access$1202(r5, r10.getFloat(r13, KeyTimeCycle.access$1200(r5)));
            goto L37
        L31:
            KeyTimeCycle.access$702(r5, r10.getFloat(r13, KeyTimeCycle.access$700(r5)));
            goto L37
        L32:
            KeyTimeCycle.access$902(r5, r10.getFloat(r13, KeyTimeCycle.access$900(r5)));
            goto L37
        L33:
            KeyTimeCycle.access$802(r5, r10.getFloat(r13, KeyTimeCycle.access$800(r5)));
            goto L37
        L34:
            KeyTimeCycle.access$202(r5, r10.getFloat(r13, KeyTimeCycle.access$200(r5)));
            goto L37
        L35:
            KeyTimeCycle.access$102(r5, r10.getDimension(r13, KeyTimeCycle.access$100(r5)));
            goto L37
        L36:
            KeyTimeCycle.access$002(r5, r10.getFloat(r13, KeyTimeCycle.access$000(r5)));
            goto L37
        L8:
            if (r10.peekValue(r13).type != 5) goto L10;
            KeyTimeCycle.access$602(r5, r10.getDimension(r13, KeyTimeCycle.access$600(r5)));
            goto L37
        L10:
            KeyTimeCycle.access$602(r5, r10.getFloat(r13, KeyTimeCycle.access$600(r5)));
            goto L37
        L21:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L26;
            int r14 = r10.getResourceId(r13, r5.mTargetId);
            r5.mTargetId = r14;
            if (r14 != (-1)) goto L37;
            r5.mTargetString = r10.getString(r13);
            goto L37
        L26:
            if (r10.peekValue(r13).type != 3) goto L28;
            r5.mTargetString = r10.getString(r13);
            goto L37
        L28:
            r5.mTargetId = r10.getResourceId(r13, r5.mTargetId);
            goto L37
        }
    }

    public KeyTimeCycle() {
        this.mCurveFit = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWaveShape = 0;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyTimeCycle r5) {
        return r5.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyTimeCycle r5, float r10) {
        r5.mAlpha = r10;
        return r10;
    }

    public static /* synthetic */ float access$100(KeyTimeCycle r5) {
        return r5.mElevation;
    }

    public static /* synthetic */ String access$1002(KeyTimeCycle r5, String r10) {
        r5.mTransitionEasing = r10;
        return r10;
    }

    public static /* synthetic */ float access$102(KeyTimeCycle r5, float r10) {
        r5.mElevation = r10;
        return r10;
    }

    public static /* synthetic */ float access$1100(KeyTimeCycle r5) {
        return r5.mScaleY;
    }

    public static /* synthetic */ float access$1102(KeyTimeCycle r5, float r10) {
        r5.mScaleY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1200(KeyTimeCycle r5) {
        return r5.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyTimeCycle r5, float r10) {
        r5.mTransitionPathRotate = r10;
        return r10;
    }

    public static /* synthetic */ float access$1300(KeyTimeCycle r5) {
        return r5.mTranslationX;
    }

    public static /* synthetic */ float access$1302(KeyTimeCycle r5, float r10) {
        r5.mTranslationX = r10;
        return r10;
    }

    public static /* synthetic */ float access$1400(KeyTimeCycle r5) {
        return r5.mTranslationY;
    }

    public static /* synthetic */ float access$1402(KeyTimeCycle r5, float r10) {
        r5.mTranslationY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1500(KeyTimeCycle r5) {
        return r5.mTranslationZ;
    }

    public static /* synthetic */ float access$1502(KeyTimeCycle r5, float r10) {
        r5.mTranslationZ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1600(KeyTimeCycle r5) {
        return r5.mProgress;
    }

    public static /* synthetic */ float access$1602(KeyTimeCycle r5, float r10) {
        r5.mProgress = r10;
        return r10;
    }

    public static /* synthetic */ float access$200(KeyTimeCycle r5) {
        return r5.mRotation;
    }

    public static /* synthetic */ float access$202(KeyTimeCycle r5, float r10) {
        r5.mRotation = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(KeyTimeCycle r5) {
        return r5.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyTimeCycle r5, int r10) {
        r5.mCurveFit = r10;
        return r10;
    }

    public static /* synthetic */ int access$400(KeyTimeCycle r5) {
        return r5.mWaveShape;
    }

    public static /* synthetic */ int access$402(KeyTimeCycle r5, int r10) {
        r5.mWaveShape = r10;
        return r10;
    }

    public static /* synthetic */ float access$500(KeyTimeCycle r5) {
        return r5.mWavePeriod;
    }

    public static /* synthetic */ float access$502(KeyTimeCycle r5, float r10) {
        r5.mWavePeriod = r10;
        return r10;
    }

    public static /* synthetic */ float access$600(KeyTimeCycle r5) {
        return r5.mWaveOffset;
    }

    public static /* synthetic */ float access$602(KeyTimeCycle r5, float r10) {
        r5.mWaveOffset = r10;
        return r10;
    }

    public static /* synthetic */ float access$700(KeyTimeCycle r5) {
        return r5.mScaleX;
    }

    public static /* synthetic */ float access$702(KeyTimeCycle r5, float r10) {
        r5.mScaleX = r10;
        return r10;
    }

    public static /* synthetic */ float access$800(KeyTimeCycle r5) {
        return r5.mRotationX;
    }

    public static /* synthetic */ float access$802(KeyTimeCycle r5, float r10) {
        r5.mRotationX = r10;
        return r10;
    }

    public static /* synthetic */ float access$900(KeyTimeCycle r5) {
        return r5.mRotationY;
    }

    public static /* synthetic */ float access$902(KeyTimeCycle r5, float r10) {
        r5.mRotationY = r10;
        return r10;
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r12) {
        Iterator<String> r5 = r12.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L99;
        String r10 = r5.next();
        TimeCycleSplineSet r11 = r12.get(r10);
        if (r10.startsWith("CUSTOM") == true) goto L7;
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            default: goto L61;
        };
    L61:
        switch(r13) {
            case 0: goto L97;
            case 1: goto L94;
            case 2: goto L91;
            case 3: goto L88;
            case 4: goto L85;
            case 5: goto L82;
            case 6: goto L79;
            case 7: goto L76;
            case 8: goto L73;
            case 9: goto L70;
            case 10: goto L67;
            case 11: goto L64;
            default: goto L62;
        };
    L64:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L67:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L70:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L73:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L76:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L79:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L82:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L85:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L88:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L91:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L94:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L97:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r11.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L62:
        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + r10 + "\"");
        goto L4
    L14:
        if (r10.equals("alpha") == false) goto L61;
        r13 = 11;
        goto L61
    L18:
        if (r10.equals("transitionPathRotate") == false) goto L61;
        r13 = 10;
        goto L61
    L22:
        if (r10.equals("elevation") == false) goto L61;
        r13 = 9;
        goto L61
    L26:
        if (r10.equals("rotation") == false) goto L61;
        r13 = 8;
        goto L61
    L30:
        if (r10.equals("scaleY") == false) goto L61;
        r13 = 7;
        goto L61
    L34:
        if (r10.equals("scaleX") == false) goto L61;
        r13 = 6;
        goto L61
    L38:
        if (r10.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L61;
        r13 = 5;
        goto L61
    L42:
        if (r10.equals("translationZ") == false) goto L61;
        r13 = 4;
        goto L61
    L46:
        if (r10.equals("translationY") == false) goto L61;
        r13 = 3;
        goto L61
    L50:
        if (r10.equals("translationX") == false) goto L61;
        r13 = 2;
        goto L61
    L54:
        if (r10.equals("rotationY") == false) goto L61;
        r13 = 1;
        goto L61
    L58:
        if (r10.equals("rotationX") == false) goto L61;
        r13 = 0;
        goto L61
    L7:
        ConstraintAttribute r14 = this.mCustomConstraints.get(r10.substring(7));
        if (r14 == null) goto L4;
        ((TimeCycleSplineSet.CustomSet) r11).setPoint(this.mFramePosition, r14, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r5) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r5) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r5.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r5.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r5.add("rotation");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r5.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r5.add("rotationY");
    L18:
        if (Float.isNaN(this.mTranslationX) == true) goto L21;
        r5.add("translationX");
    L21:
        if (Float.isNaN(this.mTranslationY) == true) goto L24;
        r5.add("translationY");
    L24:
        if (Float.isNaN(this.mTranslationZ) == true) goto L27;
        r5.add("translationZ");
    L27:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L30;
        r5.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.mScaleX) == true) goto L33;
        r5.add("scaleX");
    L33:
        if (Float.isNaN(this.mScaleY) == true) goto L36;
        r5.add("scaleY");
    L36:
        if (Float.isNaN(this.mProgress) == true) goto L39;
        r5.add(NotificationCompat.CATEGORY_PROGRESS);
    L39:
        if (this.mCustomConstraints.size() <= 0) goto L44;
        Iterator<String> r10 = this.mCustomConstraints.keySet().iterator();
    L42:
        if (r10.hasNext() == false) goto L46;
        r5.add("CUSTOM," + r10.next());
        goto L42
    L46:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r5, AttributeSet r10) {
        Loader.read(this, r5.obtainStyledAttributes(r10, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> r5) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        r5.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        r5.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        r5.put("rotation", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mTranslationX) == true) goto L24;
        r5.put("translationX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationY) == true) goto L27;
        r5.put("translationY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationZ) == true) goto L30;
        r5.put("translationZ", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L33;
        r5.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mScaleX) == true) goto L36;
        r5.put("scaleX", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r5.put("scaleY", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mProgress) == true) goto L42;
        r5.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.mCurveFit));
    L42:
        if (this.mCustomConstraints.size() <= 0) goto L47;
        Iterator<String> r10 = this.mCustomConstraints.keySet().iterator();
    L45:
        if (r10.hasNext() == false) goto L49;
        r5.put(j0.C("CUSTOM,", r10.next()), Integer.valueOf(this.mCurveFit));
        goto L45
    L49:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r5, Object r10) {
        r5.getClass();
        byte r11 = -1;
        switch(r5.hashCode()) {
            case -1812823328: goto L58;
            case -1249320806: goto L54;
            case -1249320805: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1317633238: goto L6;
            default: goto L61;
        };
    L61:
        switch(r11) {
            case 0: goto L76;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            case 6: goto L70;
            case 7: goto L69;
            case 8: goto L68;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L65;
            case 12: goto L64;
            case 13: goto L63;
            default: goto L91;
        };
    L63:
        this.mTranslationZ = toFloat(r10);
        return;
    L64:
        this.mCurveFit = toInt(r10);
        return;
    L65:
        this.mAlpha = toFloat(r10);
        return;
    L66:
        this.mTransitionPathRotate = toFloat(r10);
        return;
    L67:
        this.mElevation = toFloat(r10);
        return;
    L68:
        this.mRotation = toFloat(r10);
        return;
    L69:
        this.mScaleY = toFloat(r10);
        return;
    L70:
        this.mScaleX = toFloat(r10);
        return;
    L71:
        this.mProgress = toFloat(r10);
        return;
    L72:
        this.mTranslationY = toFloat(r10);
        return;
    L73:
        this.mTranslationX = toFloat(r10);
        return;
    L74:
        this.mRotationY = toFloat(r10);
        return;
    L75:
        this.mRotationX = toFloat(r10);
        return;
    L76:
        this.mTransitionEasing = r10.toString();
        return;
    L91:
        return;
    L6:
        if (r5.equals("mTranslationZ") == false) goto L61;
        r11 = 13;
        goto L61
    L10:
        if (r5.equals("curveFit") == false) goto L61;
        r11 = 12;
        goto L61
    L14:
        if (r5.equals("alpha") == false) goto L61;
        r11 = 11;
        goto L61
    L18:
        if (r5.equals("transitionPathRotate") == false) goto L61;
        r11 = 10;
        goto L61
    L22:
        if (r5.equals("elevation") == false) goto L61;
        r11 = 9;
        goto L61
    L26:
        if (r5.equals("rotation") == false) goto L61;
        r11 = 8;
        goto L61
    L30:
        if (r5.equals("scaleY") == false) goto L61;
        r11 = 7;
        goto L61
    L34:
        if (r5.equals("scaleX") == false) goto L61;
        r11 = 6;
        goto L61
    L38:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L61;
        r11 = 5;
        goto L61
    L42:
        if (r5.equals("translationY") == false) goto L61;
        r11 = 4;
        goto L61
    L46:
        if (r5.equals("translationX") == false) goto L61;
        r11 = 3;
        goto L61
    L50:
        if (r5.equals("rotationY") == false) goto L61;
        r11 = 2;
        goto L61
    L54:
        if (r5.equals("rotationX") == false) goto L61;
        r11 = 1;
        goto L61
    L58:
        if (r5.equals("transitionEasing") == false) goto L61;
        r11 = 0;
        goto L61
    }
}
