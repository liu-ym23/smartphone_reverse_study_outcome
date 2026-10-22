package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
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
    private float mWavePhase;
    private int mWaveShape;
    private int mWaveVariesBy;

    private static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r10 = new SparseIntArray();
            mAttrMap = r10;
            r10.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyCycle r10, TypedArray r11) {
            read(r10, r11);
        }

        private static void read(KeyCycle r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L47;
            int r14 = r11.getIndex(r13);
            switch(mAttrMap.get(r14)) {
                case 1: goto L38;
                case 2: goto L36;
                case 3: goto L35;
                case 4: goto L34;
                case 5: goto L30;
                case 6: goto L28;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L10;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L6:
            Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(r14) + "   " + mAttrMap.get(r14));
        L46:
            r13 = r13 + 1;
            goto L3
        L7:
            KeyCycle.access$2002(r10, r11.getFloat(r14, KeyCycle.access$2000(r10)) / 360.0f);
            goto L46
        L8:
            KeyCycle.access$1902(r10, r11.getFloat(r14, KeyCycle.access$1900(r10)));
            goto L46
        L12:
            KeyCycle.access$1702(r10, r11.getDimension(r14, KeyCycle.access$1700(r10)));
            goto L46
        L13:
            KeyCycle.access$1602(r10, r11.getDimension(r14, KeyCycle.access$1600(r10)));
            goto L46
        L14:
            KeyCycle.access$1502(r10, r11.getFloat(r14, KeyCycle.access$1500(r10)));
            goto L46
        L15:
            KeyCycle.access$1402(r10, r11.getFloat(r14, KeyCycle.access$1400(r10)));
            goto L46
        L16:
            KeyCycle.access$1302(r10, r11.getFloat(r14, KeyCycle.access$1300(r10)));
            goto L46
        L17:
            KeyCycle.access$1202(r10, r11.getFloat(r14, KeyCycle.access$1200(r10)));
            goto L46
        L18:
            KeyCycle.access$1102(r10, r11.getFloat(r14, KeyCycle.access$1100(r10)));
            goto L46
        L19:
            KeyCycle.access$1002(r10, r11.getFloat(r14, KeyCycle.access$1000(r10)));
            goto L46
        L20:
            KeyCycle.access$902(r10, r11.getDimension(r14, KeyCycle.access$900(r10)));
            goto L46
        L21:
            KeyCycle.access$802(r10, r11.getFloat(r14, KeyCycle.access$800(r10)));
            goto L46
        L22:
            KeyCycle.access$702(r10, r11.getInt(r14, KeyCycle.access$700(r10)));
            goto L46
        L28:
            KeyCycle.access$502(r10, r11.getFloat(r14, KeyCycle.access$500(r10)));
            goto L46
        L34:
            KeyCycle.access$202(r10, r11.getInteger(r14, KeyCycle.access$200(r10)));
            goto L46
        L35:
            KeyCycle.access$102(r10, r11.getString(r14));
            goto L46
        L36:
            r10.mFramePosition = r11.getInt(r14, r10.mFramePosition);
            goto L46
        L10:
            if (Build.VERSION.SDK_INT < 21) goto L46;
            KeyCycle.access$1802(r10, r11.getDimension(r14, KeyCycle.access$1800(r10)));
            goto L46
        L24:
            if (r11.peekValue(r14).type != 5) goto L26;
            float r15 = r11.getDimension(r14, KeyCycle.access$600(r10));
        L27:
            KeyCycle.access$602(r10, r15);
            goto L46
        L26:
            r15 = r11.getFloat(r14, KeyCycle.access$600(r10));
            goto L27
        L30:
            if (r11.peekValue(r14).type != 3) goto L32;
            KeyCycle.access$302(r10, r11.getString(r14));
            int r16 = 7;
        L33:
            KeyCycle.access$402(r10, r16);
            goto L46
        L32:
            r16 = r11.getInt(r14, KeyCycle.access$400(r10));
            goto L33
        L38:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L43;
            int r17 = r11.getResourceId(r14, r10.mTargetId);
            r10.mTargetId = r17;
            if (r17 != (-1)) goto L46;
        L44:
            r10.mTargetString = r11.getString(r14);
            goto L46
        L43:
            if (r11.peekValue(r14).type == 3) goto L44;
            r10.mTargetId = r11.getResourceId(r14, r10.mTargetId);
            goto L46
        }
    }

    public KeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mWavePhase = 0.0f;
        this.mProgress = Float.NaN;
        this.mWaveVariesBy = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$1000(KeyCycle r10) {
        return r10.mRotation;
    }

    static /* synthetic */ float access$1002(KeyCycle r10, float r11) {
        r10.mRotation = r11;
        return r11;
    }

    static /* synthetic */ String access$102(KeyCycle r10, String r11) {
        r10.mTransitionEasing = r11;
        return r11;
    }

    static /* synthetic */ float access$1100(KeyCycle r10) {
        return r10.mRotationX;
    }

    static /* synthetic */ float access$1102(KeyCycle r10, float r11) {
        r10.mRotationX = r11;
        return r11;
    }

    static /* synthetic */ float access$1200(KeyCycle r10) {
        return r10.mRotationY;
    }

    static /* synthetic */ float access$1202(KeyCycle r10, float r11) {
        r10.mRotationY = r11;
        return r11;
    }

    static /* synthetic */ float access$1300(KeyCycle r10) {
        return r10.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1302(KeyCycle r10, float r11) {
        r10.mTransitionPathRotate = r11;
        return r11;
    }

    static /* synthetic */ float access$1400(KeyCycle r10) {
        return r10.mScaleX;
    }

    static /* synthetic */ float access$1402(KeyCycle r10, float r11) {
        r10.mScaleX = r11;
        return r11;
    }

    static /* synthetic */ float access$1500(KeyCycle r10) {
        return r10.mScaleY;
    }

    static /* synthetic */ float access$1502(KeyCycle r10, float r11) {
        r10.mScaleY = r11;
        return r11;
    }

    static /* synthetic */ float access$1600(KeyCycle r10) {
        return r10.mTranslationX;
    }

    static /* synthetic */ float access$1602(KeyCycle r10, float r11) {
        r10.mTranslationX = r11;
        return r11;
    }

    static /* synthetic */ float access$1700(KeyCycle r10) {
        return r10.mTranslationY;
    }

    static /* synthetic */ float access$1702(KeyCycle r10, float r11) {
        r10.mTranslationY = r11;
        return r11;
    }

    static /* synthetic */ float access$1800(KeyCycle r10) {
        return r10.mTranslationZ;
    }

    static /* synthetic */ float access$1802(KeyCycle r10, float r11) {
        r10.mTranslationZ = r11;
        return r11;
    }

    static /* synthetic */ float access$1900(KeyCycle r10) {
        return r10.mProgress;
    }

    static /* synthetic */ float access$1902(KeyCycle r10, float r11) {
        r10.mProgress = r11;
        return r11;
    }

    static /* synthetic */ int access$200(KeyCycle r10) {
        return r10.mCurveFit;
    }

    static /* synthetic */ float access$2000(KeyCycle r10) {
        return r10.mWavePhase;
    }

    static /* synthetic */ float access$2002(KeyCycle r10, float r11) {
        r10.mWavePhase = r11;
        return r11;
    }

    static /* synthetic */ int access$202(KeyCycle r10, int r11) {
        r10.mCurveFit = r11;
        return r11;
    }

    static /* synthetic */ String access$302(KeyCycle r10, String r11) {
        r10.mCustomWaveShape = r11;
        return r11;
    }

    static /* synthetic */ int access$400(KeyCycle r10) {
        return r10.mWaveShape;
    }

    static /* synthetic */ int access$402(KeyCycle r10, int r11) {
        r10.mWaveShape = r11;
        return r11;
    }

    static /* synthetic */ float access$500(KeyCycle r10) {
        return r10.mWavePeriod;
    }

    static /* synthetic */ float access$502(KeyCycle r10, float r11) {
        r10.mWavePeriod = r11;
        return r11;
    }

    static /* synthetic */ float access$600(KeyCycle r10) {
        return r10.mWaveOffset;
    }

    static /* synthetic */ float access$602(KeyCycle r10, float r11) {
        r10.mWaveOffset = r11;
        return r11;
    }

    static /* synthetic */ int access$700(KeyCycle r10) {
        return r10.mWaveVariesBy;
    }

    static /* synthetic */ int access$702(KeyCycle r10, int r11) {
        r10.mWaveVariesBy = r11;
        return r11;
    }

    static /* synthetic */ float access$800(KeyCycle r10) {
        return r10.mAlpha;
    }

    static /* synthetic */ float access$802(KeyCycle r10, float r11) {
        r10.mAlpha = r11;
        return r11;
    }

    static /* synthetic */ float access$900(KeyCycle r10) {
        return r10.mElevation;
    }

    static /* synthetic */ float access$902(KeyCycle r10, float r11) {
        r10.mElevation = r11;
        return r11;
    }

    public void addCycleValues(HashMap<String, ViewOscillator> r25) {
        Iterator<String> r10 = r25.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        String r11 = r10.next();
        if (r11.startsWith("CUSTOM") == true) goto L7;
        float r23 = getValue(r11);
        if (Float.isNaN(r23) == true) goto L4;
        ViewOscillator r15 = r25.get(r11);
        if (r15 == null) goto L4;
        r15.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r23);
        goto L4
    L7:
        String r12 = r11.substring(7);
        ConstraintAttribute r14 = this.mCustomConstraints.get(r12);
        if (r14 == null) goto L4;
        if (r14.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        ViewOscillator r13 = r25.get(r11);
        if (r13 == null) goto L4;
        r13.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r14.getValueToInterpolate(), r14);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r10) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + r10.size() + " values", 2);
        Iterator<String> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L86;
        String r12 = r11.next();
        ViewSpline r13 = r10.get(r12);
        if (r13 == null) goto L4;
        r12.hashCode();
        byte r14 = -1;
        switch(r12.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -40300674: goto L32;
            case -4379043: goto L28;
            case 37232917: goto L24;
            case 92909918: goto L20;
            case 156108012: goto L16;
            case 1530034690: goto L12;
            default: goto L67;
        };
    L67:
        switch(r14) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L72;
            case 13: goto L71;
            default: goto L69;
        };
    L71:
        int r15 = this.mFramePosition;
        float r16 = this.mWavePhase;
    L74:
        r13.setPoint(r15, r16);
        goto L4
    L72:
        r15 = this.mFramePosition;
        r16 = this.mWaveOffset;
        goto L74
    L73:
        r15 = this.mFramePosition;
        r16 = this.mAlpha;
        goto L74
    L75:
        r15 = this.mFramePosition;
        r16 = this.mTransitionPathRotate;
        goto L74
    L76:
        r15 = this.mFramePosition;
        r16 = this.mElevation;
        goto L74
    L77:
        r15 = this.mFramePosition;
        r16 = this.mRotation;
        goto L74
    L78:
        r15 = this.mFramePosition;
        r16 = this.mScaleY;
        goto L74
    L79:
        r15 = this.mFramePosition;
        r16 = this.mScaleX;
        goto L74
    L80:
        r15 = this.mFramePosition;
        r16 = this.mProgress;
        goto L74
    L81:
        r15 = this.mFramePosition;
        r16 = this.mTranslationZ;
        goto L74
    L82:
        r15 = this.mFramePosition;
        r16 = this.mTranslationY;
        goto L74
    L83:
        r15 = this.mFramePosition;
        r16 = this.mTranslationX;
        goto L74
    L84:
        r15 = this.mFramePosition;
        r16 = this.mRotationY;
        goto L74
    L85:
        r15 = this.mFramePosition;
        r16 = this.mRotationX;
        goto L74
    L69:
        if (r12.startsWith("CUSTOM") == true) goto L4;
        Log.v("WARNING KeyCycle", "  UNKNOWN  " + r12);
        goto L4
    L12:
        if (r12.equals("wavePhase") == false) goto L67;
        r14 = 13;
        goto L67
    L16:
        if (r12.equals("waveOffset") == false) goto L67;
        r14 = 12;
        goto L67
    L20:
        if (r12.equals("alpha") == false) goto L67;
        r14 = 11;
        goto L67
    L24:
        if (r12.equals("transitionPathRotate") == false) goto L67;
        r14 = 10;
        goto L67
    L28:
        if (r12.equals("elevation") == false) goto L67;
        r14 = 9;
        goto L67
    L32:
        if (r12.equals(Key.ROTATION) == false) goto L67;
        r14 = 8;
        goto L67
    L36:
        if (r12.equals("scaleY") == false) goto L67;
        r14 = 7;
        goto L67
    L40:
        if (r12.equals("scaleX") == false) goto L67;
        r14 = 6;
        goto L67
    L44:
        if (r12.equals("progress") == false) goto L67;
        r14 = 5;
        goto L67
    L48:
        if (r12.equals("translationZ") == false) goto L67;
        r14 = 4;
        goto L67
    L52:
        if (r12.equals("translationY") == false) goto L67;
        r14 = 3;
        goto L67
    L56:
        if (r12.equals("translationX") == false) goto L67;
        r14 = 2;
        goto L67
    L60:
        if (r12.equals("rotationY") == false) goto L67;
        r14 = 1;
        goto L67
    L64:
        if (r12.equals("rotationX") == false) goto L67;
        r14 = 0;
        goto L67
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyCycle().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo4clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r10) {
        super.copy(r10);
        KeyCycle r11 = (KeyCycle) r10;
        this.mTransitionEasing = r11.mTransitionEasing;
        this.mCurveFit = r11.mCurveFit;
        this.mWaveShape = r11.mWaveShape;
        this.mCustomWaveShape = r11.mCustomWaveShape;
        this.mWavePeriod = r11.mWavePeriod;
        this.mWaveOffset = r11.mWaveOffset;
        this.mWavePhase = r11.mWavePhase;
        this.mProgress = r11.mProgress;
        this.mWaveVariesBy = r11.mWaveVariesBy;
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r10.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r10.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r10.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r10.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r10.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r10.add("translationZ");
    L36:
        if (this.mCustomConstraints.size() <= 0) goto L41;
        Iterator<String> r11 = this.mCustomConstraints.keySet().iterator();
    L39:
        if (r11.hasNext() == false) goto L43;
        r10.add("CUSTOM," + r11.next());
        goto L39
    L43:
        return;
    }

    public float getValue(String r10) {
        r10.hashCode();
        byte r11 = -1;
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
            case 156108012: goto L10;
            case 1530034690: goto L6;
            default: goto L61;
        };
    L61:
        switch(r11) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L88;
            case 4: goto L86;
            case 5: goto L84;
            case 6: goto L82;
            case 7: goto L80;
            case 8: goto L78;
            case 9: goto L76;
            case 10: goto L74;
            case 11: goto L72;
            case 12: goto L70;
            case 13: goto L68;
            default: goto L63;
        };
    L63:
        if (r10.startsWith("CUSTOM") == true) goto L95;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  " + r10);
        return Float.NaN;
    L95:
        return Float.NaN;
    L68:
        return this.mWavePhase;
    L70:
        return this.mWaveOffset;
    L72:
        return this.mAlpha;
    L74:
        return this.mTransitionPathRotate;
    L76:
        return this.mElevation;
    L78:
        return this.mRotation;
    L80:
        return this.mScaleY;
    L82:
        return this.mScaleX;
    L84:
        return this.mProgress;
    L86:
        return this.mTranslationZ;
    L88:
        return this.mTranslationY;
    L90:
        return this.mTranslationX;
    L92:
        return this.mRotationY;
    L94:
        return this.mRotationX;
    L6:
        if (r10.equals("wavePhase") == false) goto L61;
        r11 = 13;
        goto L61
    L10:
        if (r10.equals("waveOffset") == false) goto L61;
        r11 = 12;
        goto L61
    L14:
        if (r10.equals("alpha") == false) goto L61;
        r11 = 11;
        goto L61
    L18:
        if (r10.equals("transitionPathRotate") == false) goto L61;
        r11 = 10;
        goto L61
    L22:
        if (r10.equals("elevation") == false) goto L61;
        r11 = 9;
        goto L61
    L26:
        if (r10.equals(Key.ROTATION) == false) goto L61;
        r11 = 8;
        goto L61
    L30:
        if (r10.equals("scaleY") == false) goto L61;
        r11 = 7;
        goto L61
    L34:
        if (r10.equals("scaleX") == false) goto L61;
        r11 = 6;
        goto L61
    L38:
        if (r10.equals("progress") == false) goto L61;
        r11 = 5;
        goto L61
    L42:
        if (r10.equals("translationZ") == false) goto L61;
        r11 = 4;
        goto L61
    L46:
        if (r10.equals("translationY") == false) goto L61;
        r11 = 3;
        goto L61
    L50:
        if (r10.equals("translationX") == false) goto L61;
        r11 = 2;
        goto L61
    L54:
        if (r10.equals("rotationY") == false) goto L61;
        r11 = 1;
        goto L61
    L58:
        if (r10.equals("rotationX") == false) goto L61;
        r11 = 0;
        goto L61
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r10, AttributeSet r11) {
        Loader.access$000(this, r10.obtainStyledAttributes(r11, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1913008125: goto L74;
            case -1812823328: goto L70;
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -908189618: goto L46;
            case -908189617: goto L42;
            case -40300674: goto L38;
            case -4379043: goto L34;
            case 37232917: goto L30;
            case 92909918: goto L26;
            case 156108012: goto L22;
            case 184161818: goto L18;
            case 579057826: goto L14;
            case 1530034690: goto L10;
            case 1532805160: goto L6;
            default: goto L77;
        };
    L77:
        switch(r12) {
            case 0: goto L99;
            case 1: goto L98;
            case 2: goto L97;
            case 3: goto L96;
            case 4: goto L95;
            case 5: goto L94;
            case 6: goto L93;
            case 7: goto L92;
            case 8: goto L91;
            case 9: goto L90;
            case 10: goto L89;
            case 11: goto L88;
            case 12: goto L87;
            case 13: goto L86;
            case 14: goto L85;
            case 15: goto L84;
            case 16: goto L83;
            case 17: goto L80;
            default: goto L119;
        };
    L83:
        this.mWavePhase = toFloat(r11);
        return;
    L84:
        this.mCurveFit = toInt(r11);
        return;
    L85:
        this.mWavePeriod = toFloat(r11);
        return;
    L86:
        this.mWaveOffset = toFloat(r11);
        return;
    L87:
        this.mAlpha = toFloat(r11);
        return;
    L88:
        this.mTransitionPathRotate = toFloat(r11);
        return;
    L89:
        this.mElevation = toFloat(r11);
        return;
    L90:
        this.mRotation = toFloat(r11);
        return;
    L91:
        this.mScaleY = toFloat(r11);
        return;
    L92:
        this.mScaleX = toFloat(r11);
        return;
    L93:
        this.mTranslationZ = toFloat(r11);
        return;
    L94:
        this.mTranslationY = toFloat(r11);
        return;
    L95:
        this.mTranslationX = toFloat(r11);
        return;
    L96:
        this.mRotationY = toFloat(r11);
        return;
    L97:
        this.mRotationX = toFloat(r11);
        return;
    L98:
        this.mTransitionEasing = r11.toString();
        return;
    L99:
        this.mProgress = toFloat(r11);
        return;
    L119:
        return;
    L80:
        if ((r11 instanceof Integer) == false) goto L82;
        this.mWaveShape = toInt(r11);
        return;
    L82:
        this.mWaveShape = 7;
        this.mCustomWaveShape = r11.toString();
        return;
    L6:
        if (r10.equals("waveShape") == false) goto L77;
        r12 = 17;
        goto L77
    L10:
        if (r10.equals("wavePhase") == false) goto L77;
        r12 = 16;
        goto L77
    L14:
        if (r10.equals("curveFit") == false) goto L77;
        r12 = 15;
        goto L77
    L18:
        if (r10.equals("wavePeriod") == false) goto L77;
        r12 = 14;
        goto L77
    L22:
        if (r10.equals("waveOffset") == false) goto L77;
        r12 = 13;
        goto L77
    L26:
        if (r10.equals("alpha") == false) goto L77;
        r12 = 12;
        goto L77
    L30:
        if (r10.equals("transitionPathRotate") == false) goto L77;
        r12 = 11;
        goto L77
    L34:
        if (r10.equals("elevation") == false) goto L77;
        r12 = 10;
        goto L77
    L38:
        if (r10.equals(Key.ROTATION) == false) goto L77;
        r12 = 9;
        goto L77
    L42:
        if (r10.equals("scaleY") == false) goto L77;
        r12 = 8;
        goto L77
    L46:
        if (r10.equals("scaleX") == false) goto L77;
        r12 = 7;
        goto L77
    L50:
        if (r10.equals("translationZ") == false) goto L77;
        r12 = 6;
        goto L77
    L54:
        if (r10.equals("translationY") == false) goto L77;
        r12 = 5;
        goto L77
    L58:
        if (r10.equals("translationX") == false) goto L77;
        r12 = 4;
        goto L77
    L62:
        if (r10.equals("rotationY") == false) goto L77;
        r12 = 3;
        goto L77
    L66:
        if (r10.equals("rotationX") == false) goto L77;
        r12 = 2;
        goto L77
    L70:
        if (r10.equals("transitionEasing") == false) goto L77;
        r12 = 1;
        goto L77
    L74:
        if (r10.equals(Key.MOTIONPROGRESS) == false) goto L77;
        r12 = 0;
        goto L77
    }
}
