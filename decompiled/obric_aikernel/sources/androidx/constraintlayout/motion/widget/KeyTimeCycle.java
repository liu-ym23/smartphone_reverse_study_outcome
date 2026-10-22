package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyTimeCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";
    private float mAlpha;
    private int mCurveFit;
    private String mCustomWaveShape;
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

    private static class Loader {
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
            SparseIntArray r10 = new SparseIntArray();
            mAttrMap = r10;
            r10.append(R.styleable.KeyTimeCycle_android_alpha, 1);
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

        public static void read(KeyTimeCycle r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L45;
            int r14 = r11.getIndex(r13);
            switch(mAttrMap.get(r14)) {
                case 1: goto L43;
                case 2: goto L42;
                case 3: goto L6;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L39;
                case 7: goto L38;
                case 8: goto L37;
                case 9: goto L36;
                case 10: goto L28;
                case 11: goto L6;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L20;
                case 18: goto L18;
                case 19: goto L14;
                case 20: goto L12;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(r14) + "   " + mAttrMap.get(r14));
        L44:
            r13 = r13 + 1;
            goto L3
        L12:
            KeyTimeCycle.access$602(r10, r11.getFloat(r14, KeyTimeCycle.access$600(r10)));
            goto L44
        L18:
            KeyTimeCycle.access$1702(r10, r11.getFloat(r14, KeyTimeCycle.access$1700(r10)));
            goto L44
        L22:
            KeyTimeCycle.access$1502(r10, r11.getDimension(r14, KeyTimeCycle.access$1500(r10)));
            goto L44
        L23:
            KeyTimeCycle.access$1402(r10, r11.getDimension(r14, KeyTimeCycle.access$1400(r10)));
            goto L44
        L24:
            KeyTimeCycle.access$1202(r10, r11.getFloat(r14, KeyTimeCycle.access$1200(r10)));
            goto L44
        L25:
            KeyTimeCycle.access$302(r10, r11.getInteger(r14, KeyTimeCycle.access$300(r10)));
            goto L44
        L26:
            r10.mFramePosition = r11.getInt(r14, r10.mFramePosition);
            goto L44
        L36:
            KeyTimeCycle.access$1102(r10, r11.getString(r14));
            goto L44
        L37:
            KeyTimeCycle.access$1302(r10, r11.getFloat(r14, KeyTimeCycle.access$1300(r10)));
            goto L44
        L38:
            KeyTimeCycle.access$802(r10, r11.getFloat(r14, KeyTimeCycle.access$800(r10)));
            goto L44
        L39:
            KeyTimeCycle.access$1002(r10, r11.getFloat(r14, KeyTimeCycle.access$1000(r10)));
            goto L44
        L40:
            KeyTimeCycle.access$902(r10, r11.getFloat(r14, KeyTimeCycle.access$900(r10)));
            goto L44
        L41:
            KeyTimeCycle.access$202(r10, r11.getFloat(r14, KeyTimeCycle.access$200(r10)));
            goto L44
        L42:
            KeyTimeCycle.access$102(r10, r11.getDimension(r14, KeyTimeCycle.access$100(r10)));
            goto L44
        L43:
            KeyTimeCycle.access$002(r10, r11.getFloat(r14, KeyTimeCycle.access$000(r10)));
            goto L44
        L8:
            if (r11.peekValue(r14).type != 5) goto L10;
            float r15 = r11.getDimension(r14, KeyTimeCycle.access$700(r10));
        L11:
            KeyTimeCycle.access$702(r10, r15);
            goto L44
        L10:
            r15 = r11.getFloat(r14, KeyTimeCycle.access$700(r10));
            goto L11
        L14:
            if (r11.peekValue(r14).type != 3) goto L16;
            KeyTimeCycle.access$402(r10, r11.getString(r14));
            int r16 = 7;
        L17:
            KeyTimeCycle.access$502(r10, r16);
            goto L44
        L16:
            r16 = r11.getInt(r14, KeyTimeCycle.access$500(r10));
            goto L17
        L20:
            if (Build.VERSION.SDK_INT < 21) goto L44;
            KeyTimeCycle.access$1602(r10, r11.getDimension(r14, KeyTimeCycle.access$1600(r10)));
            goto L44
        L28:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L33;
            int r17 = r11.getResourceId(r14, r10.mTargetId);
            r10.mTargetId = r17;
            if (r17 != (-1)) goto L44;
        L34:
            r10.mTargetString = r11.getString(r14);
            goto L44
        L33:
            if (r11.peekValue(r14).type == 3) goto L34;
            r10.mTargetId = r11.getResourceId(r14, r10.mTargetId);
            goto L44
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
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$000(KeyTimeCycle r10) {
        return r10.mAlpha;
    }

    static /* synthetic */ float access$002(KeyTimeCycle r10, float r11) {
        r10.mAlpha = r11;
        return r11;
    }

    static /* synthetic */ float access$100(KeyTimeCycle r10) {
        return r10.mElevation;
    }

    static /* synthetic */ float access$1000(KeyTimeCycle r10) {
        return r10.mRotationY;
    }

    static /* synthetic */ float access$1002(KeyTimeCycle r10, float r11) {
        r10.mRotationY = r11;
        return r11;
    }

    static /* synthetic */ float access$102(KeyTimeCycle r10, float r11) {
        r10.mElevation = r11;
        return r11;
    }

    static /* synthetic */ String access$1102(KeyTimeCycle r10, String r11) {
        r10.mTransitionEasing = r11;
        return r11;
    }

    static /* synthetic */ float access$1200(KeyTimeCycle r10) {
        return r10.mScaleY;
    }

    static /* synthetic */ float access$1202(KeyTimeCycle r10, float r11) {
        r10.mScaleY = r11;
        return r11;
    }

    static /* synthetic */ float access$1300(KeyTimeCycle r10) {
        return r10.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1302(KeyTimeCycle r10, float r11) {
        r10.mTransitionPathRotate = r11;
        return r11;
    }

    static /* synthetic */ float access$1400(KeyTimeCycle r10) {
        return r10.mTranslationX;
    }

    static /* synthetic */ float access$1402(KeyTimeCycle r10, float r11) {
        r10.mTranslationX = r11;
        return r11;
    }

    static /* synthetic */ float access$1500(KeyTimeCycle r10) {
        return r10.mTranslationY;
    }

    static /* synthetic */ float access$1502(KeyTimeCycle r10, float r11) {
        r10.mTranslationY = r11;
        return r11;
    }

    static /* synthetic */ float access$1600(KeyTimeCycle r10) {
        return r10.mTranslationZ;
    }

    static /* synthetic */ float access$1602(KeyTimeCycle r10, float r11) {
        r10.mTranslationZ = r11;
        return r11;
    }

    static /* synthetic */ float access$1700(KeyTimeCycle r10) {
        return r10.mProgress;
    }

    static /* synthetic */ float access$1702(KeyTimeCycle r10, float r11) {
        r10.mProgress = r11;
        return r11;
    }

    static /* synthetic */ float access$200(KeyTimeCycle r10) {
        return r10.mRotation;
    }

    static /* synthetic */ float access$202(KeyTimeCycle r10, float r11) {
        r10.mRotation = r11;
        return r11;
    }

    static /* synthetic */ int access$300(KeyTimeCycle r10) {
        return r10.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyTimeCycle r10, int r11) {
        r10.mCurveFit = r11;
        return r11;
    }

    static /* synthetic */ String access$402(KeyTimeCycle r10, String r11) {
        r10.mCustomWaveShape = r11;
        return r11;
    }

    static /* synthetic */ int access$500(KeyTimeCycle r10) {
        return r10.mWaveShape;
    }

    static /* synthetic */ int access$502(KeyTimeCycle r10, int r11) {
        r10.mWaveShape = r11;
        return r11;
    }

    static /* synthetic */ float access$600(KeyTimeCycle r10) {
        return r10.mWavePeriod;
    }

    static /* synthetic */ float access$602(KeyTimeCycle r10, float r11) {
        r10.mWavePeriod = r11;
        return r11;
    }

    static /* synthetic */ float access$700(KeyTimeCycle r10) {
        return r10.mWaveOffset;
    }

    static /* synthetic */ float access$702(KeyTimeCycle r10, float r11) {
        r10.mWaveOffset = r11;
        return r11;
    }

    static /* synthetic */ float access$800(KeyTimeCycle r10) {
        return r10.mScaleX;
    }

    static /* synthetic */ float access$802(KeyTimeCycle r10, float r11) {
        r10.mScaleX = r11;
        return r11;
    }

    static /* synthetic */ float access$900(KeyTimeCycle r10) {
        return r10.mRotationX;
    }

    static /* synthetic */ float access$902(KeyTimeCycle r10, float r11) {
        r10.mRotationX = r11;
        return r11;
    }

    public void addTimeValues(HashMap<String, ViewTimeCycle> r11) {
        Iterator<String> r10 = r11.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L102;
        String r12 = r10.next();
        ViewTimeCycle r13 = r11.get(r12);
        if (r13 == null) goto L4;
        byte r14 = 7;
        if (r12.startsWith("CUSTOM") == true) goto L10;
        switch(r12.hashCode()) {
            case -1249320806: goto L60;
            case -1249320805: goto L56;
            case -1225497657: goto L52;
            case -1225497656: goto L48;
            case -1225497655: goto L44;
            case -1001078227: goto L40;
            case -908189618: goto L36;
            case -908189617: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L15;
        };
    L15:
        r14 = -1;
    L63:
        switch(r14) {
            case 0: goto L100;
            case 1: goto L97;
            case 2: goto L94;
            case 3: goto L91;
            case 4: goto L88;
            case 5: goto L85;
            case 6: goto L82;
            case 7: goto L79;
            case 8: goto L76;
            case 9: goto L73;
            case 10: goto L70;
            case 11: goto L66;
            default: goto L64;
        };
    L66:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        int r15 = this.mFramePosition;
        float r16 = this.mAlpha;
    L68:
        r13.setPoint(r15, r16, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L70:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTransitionPathRotate;
        goto L68
    L73:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mElevation;
        goto L68
    L76:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotation;
        goto L68
    L79:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleY;
        goto L68
    L82:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleX;
        goto L68
    L85:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mProgress;
        goto L68
    L88:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationZ;
        goto L68
    L91:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationY;
        goto L68
    L94:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationX;
        goto L68
    L97:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationY;
        goto L68
    L100:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationX;
        goto L68
    L64:
        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + r12 + "\"");
        goto L4
    L17:
        if (r12.equals("alpha") == false) goto L151;
        r14 = 11;
        goto L63
    L151:
        r14 = -1;
        goto L63
    L21:
        if (r12.equals("transitionPathRotate") == false) goto L152;
        r14 = 10;
        goto L63
    L152:
        r14 = -1;
        goto L63
    L25:
        if (r12.equals("elevation") == false) goto L153;
        r14 = 9;
        goto L63
    L153:
        r14 = -1;
        goto L63
    L29:
        if (r12.equals(Key.ROTATION) == false) goto L154;
        r14 = 8;
        goto L63
    L154:
        r14 = -1;
        goto L63
    L33:
        if (r12.equals("scaleY") == true) goto L63;
        r14 = -1;
        goto L63
    L36:
        if (r12.equals("scaleX") == false) goto L156;
        r14 = 6;
        goto L63
    L156:
        r14 = -1;
        goto L63
    L40:
        if (r12.equals("progress") == false) goto L157;
        r14 = 5;
        goto L63
    L157:
        r14 = -1;
        goto L63
    L44:
        if (r12.equals("translationZ") == false) goto L158;
        r14 = 4;
        goto L63
    L158:
        r14 = -1;
        goto L63
    L48:
        if (r12.equals("translationY") == false) goto L159;
        r14 = 3;
        goto L63
    L159:
        r14 = -1;
        goto L63
    L52:
        if (r12.equals("translationX") == false) goto L160;
        r14 = 2;
        goto L63
    L160:
        r14 = -1;
        goto L63
    L56:
        if (r12.equals("rotationY") == false) goto L161;
        r14 = 1;
        goto L63
    L161:
        r14 = -1;
        goto L63
    L60:
        if (r12.equals("rotationX") == false) goto L162;
        r14 = 0;
        goto L63
    L162:
        r14 = -1;
        goto L63
    L10:
        ConstraintAttribute r17 = this.mCustomConstraints.get(r12.substring(7));
        if (r17 == null) goto L4;
        ((ViewTimeCycle.CustomSet) r13).setPoint(this.mFramePosition, r17, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r10) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyTimeCycle().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo4clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r10) {
        super.copy(r10);
        KeyTimeCycle r11 = (KeyTimeCycle) r10;
        this.mTransitionEasing = r11.mTransitionEasing;
        this.mCurveFit = r11.mCurveFit;
        this.mWaveShape = r11.mWaveShape;
        this.mWavePeriod = r11.mWavePeriod;
        this.mWaveOffset = r11.mWaveOffset;
        this.mProgress = r11.mProgress;
        this.mAlpha = r11.mAlpha;
        this.mElevation = r11.mElevation;
        this.mRotation = r11.mRotation;
        this.mTransitionPathRotate = r11.mTransitionPathRotate;
        this.mRotationX = r11.mRotationX;
        this.mRotationY = r11.mRotationY;
        this.mScaleX = r11.mScaleX;
        this.mScaleY = r11.mScaleY;
        this.mTranslationX = r11.mTranslationX;
        this.mTranslationY = r11.mTranslationY;
        this.mTranslationZ = r11.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r10) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r10.add(Key.ROTATION);
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r10.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r10.add("rotationY");
    L18:
        if (Float.isNaN(this.mTranslationX) == true) goto L21;
        r10.add("translationX");
    L21:
        if (Float.isNaN(this.mTranslationY) == true) goto L24;
        r10.add("translationY");
    L24:
        if (Float.isNaN(this.mTranslationZ) == true) goto L27;
        r10.add("translationZ");
    L27:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L30;
        r10.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.mScaleX) == true) goto L33;
        r10.add("scaleX");
    L33:
        if (Float.isNaN(this.mScaleY) == true) goto L36;
        r10.add("scaleY");
    L36:
        if (Float.isNaN(this.mProgress) == true) goto L39;
        r10.add("progress");
    L39:
        if (this.mCustomConstraints.size() <= 0) goto L44;
        Iterator<String> r11 = this.mCustomConstraints.keySet().iterator();
    L42:
        if (r11.hasNext() == false) goto L46;
        r10.add("CUSTOM," + r11.next());
        goto L42
    L46:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r10, AttributeSet r11) {
        Loader.read(this, r10.obtainStyledAttributes(r11, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> r10) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        r10.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        r10.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        r10.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        r10.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        r10.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mTranslationX) == true) goto L24;
        r10.put("translationX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationY) == true) goto L27;
        r10.put("translationY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationZ) == true) goto L30;
        r10.put("translationZ", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L33;
        r10.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mScaleX) == true) goto L36;
        r10.put("scaleX", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r10.put("scaleY", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mProgress) == true) goto L42;
        r10.put("progress", Integer.valueOf(this.mCurveFit));
    L42:
        if (this.mCustomConstraints.size() <= 0) goto L47;
        Iterator<String> r11 = this.mCustomConstraints.keySet().iterator();
    L45:
        if (r11.hasNext() == false) goto L49;
        r10.put("CUSTOM," + r11.next(), Integer.valueOf(this.mCurveFit));
        goto L45
    L49:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -40300674: goto L34;
            case -4379043: goto L30;
            case 37232917: goto L26;
            case 92909918: goto L22;
            case 156108012: goto L18;
            case 184161818: goto L14;
            case 579057826: goto L10;
            case 1532805160: goto L6;
            default: goto L73;
        };
    L73:
        switch(r12) {
            case 0: goto L94;
            case 1: goto L93;
            case 2: goto L92;
            case 3: goto L91;
            case 4: goto L90;
            case 5: goto L89;
            case 6: goto L88;
            case 7: goto L87;
            case 8: goto L86;
            case 9: goto L85;
            case 10: goto L84;
            case 11: goto L83;
            case 12: goto L82;
            case 13: goto L81;
            case 14: goto L80;
            case 15: goto L79;
            case 16: goto L76;
            default: goto L113;
        };
    L79:
        this.mCurveFit = toInt(r11);
        return;
    L80:
        this.mWavePeriod = toFloat(r11);
        return;
    L81:
        this.mWaveOffset = toFloat(r11);
        return;
    L82:
        this.mAlpha = toFloat(r11);
        return;
    L83:
        this.mTransitionPathRotate = toFloat(r11);
        return;
    L84:
        this.mElevation = toFloat(r11);
        return;
    L85:
        this.mRotation = toFloat(r11);
        return;
    L86:
        this.mScaleY = toFloat(r11);
        return;
    L87:
        this.mScaleX = toFloat(r11);
        return;
    L88:
        this.mTranslationZ = toFloat(r11);
        return;
    L89:
        this.mTranslationY = toFloat(r11);
        return;
    L90:
        this.mTranslationX = toFloat(r11);
        return;
    L91:
        this.mRotationY = toFloat(r11);
        return;
    L92:
        this.mRotationX = toFloat(r11);
        return;
    L93:
        this.mTransitionEasing = r11.toString();
        return;
    L94:
        this.mProgress = toFloat(r11);
        return;
    L113:
        return;
    L76:
        if ((r11 instanceof Integer) == false) goto L78;
        this.mWaveShape = toInt(r11);
        return;
    L78:
        this.mWaveShape = 7;
        this.mCustomWaveShape = r11.toString();
        return;
    L6:
        if (r10.equals("waveShape") == false) goto L73;
        r12 = 16;
        goto L73
    L10:
        if (r10.equals("curveFit") == false) goto L73;
        r12 = 15;
        goto L73
    L14:
        if (r10.equals("wavePeriod") == false) goto L73;
        r12 = 14;
        goto L73
    L18:
        if (r10.equals("waveOffset") == false) goto L73;
        r12 = 13;
        goto L73
    L22:
        if (r10.equals("alpha") == false) goto L73;
        r12 = 12;
        goto L73
    L26:
        if (r10.equals("transitionPathRotate") == false) goto L73;
        r12 = 11;
        goto L73
    L30:
        if (r10.equals("elevation") == false) goto L73;
        r12 = 10;
        goto L73
    L34:
        if (r10.equals(Key.ROTATION) == false) goto L73;
        r12 = 9;
        goto L73
    L38:
        if (r10.equals("scaleY") == false) goto L73;
        r12 = 8;
        goto L73
    L42:
        if (r10.equals("scaleX") == false) goto L73;
        r12 = 7;
        goto L73
    L46:
        if (r10.equals("translationZ") == false) goto L73;
        r12 = 6;
        goto L73
    L50:
        if (r10.equals("translationY") == false) goto L73;
        r12 = 5;
        goto L73
    L54:
        if (r10.equals("translationX") == false) goto L73;
        r12 = 4;
        goto L73
    L58:
        if (r10.equals("rotationY") == false) goto L73;
        r12 = 3;
        goto L73
    L62:
        if (r10.equals("rotationX") == false) goto L73;
        r12 = 2;
        goto L73
    L66:
        if (r10.equals("transitionEasing") == false) goto L73;
        r12 = 1;
        goto L73
    L70:
        if (r10.equals(Key.MOTIONPROGRESS) == false) goto L73;
        r12 = 0;
        goto L73
    }
}
