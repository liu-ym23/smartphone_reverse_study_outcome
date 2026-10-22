package androidx.constraintlayout.motion.widget;

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
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
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
    private int mWaveVariesBy;

    public static class Loader {
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
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mAttrMap = r5;
            r5.append(R.styleable.KeyCycle_motionTarget, 1);
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
        }

        private Loader() {
        }

        public static /* synthetic */ void access$000(KeyCycle r5, TypedArray r10) {
            read(r5, r10);
        }

        private static void read(KeyCycle r5, TypedArray r10) {
            int r11 = r10.getIndexCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L39;
            int r13 = r10.getIndex(r12);
            switch(mAttrMap.get(r13)) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(r13) + "   " + mAttrMap.get(r13));
        L38:
            r12 = r12 + 1;
            goto L3
        L7:
            KeyCycle.access$1802(r5, r10.getFloat(r13, KeyCycle.access$1800(r5)));
            goto L38
        L8:
            KeyCycle.access$1702(r5, r10.getDimension(r13, KeyCycle.access$1700(r5)));
            goto L38
        L9:
            KeyCycle.access$1602(r5, r10.getDimension(r13, KeyCycle.access$1600(r5)));
            goto L38
        L10:
            KeyCycle.access$1502(r5, r10.getDimension(r13, KeyCycle.access$1500(r5)));
            goto L38
        L11:
            KeyCycle.access$1402(r5, r10.getFloat(r13, KeyCycle.access$1400(r5)));
            goto L38
        L12:
            KeyCycle.access$1302(r5, r10.getFloat(r13, KeyCycle.access$1300(r5)));
            goto L38
        L13:
            KeyCycle.access$1202(r5, r10.getFloat(r13, KeyCycle.access$1200(r5)));
            goto L38
        L14:
            KeyCycle.access$1102(r5, r10.getFloat(r13, KeyCycle.access$1100(r5)));
            goto L38
        L15:
            KeyCycle.access$1002(r5, r10.getFloat(r13, KeyCycle.access$1000(r5)));
            goto L38
        L16:
            KeyCycle.access$902(r5, r10.getFloat(r13, KeyCycle.access$900(r5)));
            goto L38
        L17:
            KeyCycle.access$802(r5, r10.getDimension(r13, KeyCycle.access$800(r5)));
            goto L38
        L18:
            KeyCycle.access$702(r5, r10.getFloat(r13, KeyCycle.access$700(r5)));
            goto L38
        L19:
            KeyCycle.access$602(r5, r10.getInt(r13, KeyCycle.access$600(r5)));
            goto L38
        L24:
            KeyCycle.access$402(r5, r10.getFloat(r13, KeyCycle.access$400(r5)));
            goto L38
        L25:
            KeyCycle.access$302(r5, r10.getInt(r13, KeyCycle.access$300(r5)));
            goto L38
        L26:
            KeyCycle.access$202(r5, r10.getInteger(r13, KeyCycle.access$200(r5)));
            goto L38
        L27:
            KeyCycle.access$102(r5, r10.getString(r13));
            goto L38
        L28:
            r5.mFramePosition = r10.getInt(r13, r5.mFramePosition);
            goto L38
        L21:
            if (r10.peekValue(r13).type != 5) goto L23;
            KeyCycle.access$502(r5, r10.getDimension(r13, KeyCycle.access$500(r5)));
            goto L38
        L23:
            KeyCycle.access$502(r5, r10.getFloat(r13, KeyCycle.access$500(r5)));
            goto L38
        L30:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L35;
            int r14 = r10.getResourceId(r13, r5.mTargetId);
            r5.mTargetId = r14;
            if (r14 != (-1)) goto L38;
            r5.mTargetString = r10.getString(r13);
            goto L38
        L35:
            if (r10.peekValue(r13).type != 3) goto L37;
            r5.mTargetString = r10.getString(r13);
            goto L38
        L37:
            r5.mTargetId = r10.getResourceId(r13, r5.mTargetId);
            goto L38
        }
    }

    public KeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
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

    public static /* synthetic */ float access$1000(KeyCycle r5) {
        return r5.mRotationX;
    }

    public static /* synthetic */ float access$1002(KeyCycle r5, float r10) {
        r5.mRotationX = r10;
        return r10;
    }

    public static /* synthetic */ String access$102(KeyCycle r5, String r10) {
        r5.mTransitionEasing = r10;
        return r10;
    }

    public static /* synthetic */ float access$1100(KeyCycle r5) {
        return r5.mRotationY;
    }

    public static /* synthetic */ float access$1102(KeyCycle r5, float r10) {
        r5.mRotationY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1200(KeyCycle r5) {
        return r5.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyCycle r5, float r10) {
        r5.mTransitionPathRotate = r10;
        return r10;
    }

    public static /* synthetic */ float access$1300(KeyCycle r5) {
        return r5.mScaleX;
    }

    public static /* synthetic */ float access$1302(KeyCycle r5, float r10) {
        r5.mScaleX = r10;
        return r10;
    }

    public static /* synthetic */ float access$1400(KeyCycle r5) {
        return r5.mScaleY;
    }

    public static /* synthetic */ float access$1402(KeyCycle r5, float r10) {
        r5.mScaleY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1500(KeyCycle r5) {
        return r5.mTranslationX;
    }

    public static /* synthetic */ float access$1502(KeyCycle r5, float r10) {
        r5.mTranslationX = r10;
        return r10;
    }

    public static /* synthetic */ float access$1600(KeyCycle r5) {
        return r5.mTranslationY;
    }

    public static /* synthetic */ float access$1602(KeyCycle r5, float r10) {
        r5.mTranslationY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1700(KeyCycle r5) {
        return r5.mTranslationZ;
    }

    public static /* synthetic */ float access$1702(KeyCycle r5, float r10) {
        r5.mTranslationZ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1800(KeyCycle r5) {
        return r5.mProgress;
    }

    public static /* synthetic */ float access$1802(KeyCycle r5, float r10) {
        r5.mProgress = r10;
        return r10;
    }

    public static /* synthetic */ int access$200(KeyCycle r5) {
        return r5.mCurveFit;
    }

    public static /* synthetic */ int access$202(KeyCycle r5, int r10) {
        r5.mCurveFit = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(KeyCycle r5) {
        return r5.mWaveShape;
    }

    public static /* synthetic */ int access$302(KeyCycle r5, int r10) {
        r5.mWaveShape = r10;
        return r10;
    }

    public static /* synthetic */ float access$400(KeyCycle r5) {
        return r5.mWavePeriod;
    }

    public static /* synthetic */ float access$402(KeyCycle r5, float r10) {
        r5.mWavePeriod = r10;
        return r10;
    }

    public static /* synthetic */ float access$500(KeyCycle r5) {
        return r5.mWaveOffset;
    }

    public static /* synthetic */ float access$502(KeyCycle r5, float r10) {
        r5.mWaveOffset = r10;
        return r10;
    }

    public static /* synthetic */ int access$600(KeyCycle r5) {
        return r5.mWaveVariesBy;
    }

    public static /* synthetic */ int access$602(KeyCycle r5, int r10) {
        r5.mWaveVariesBy = r10;
        return r10;
    }

    public static /* synthetic */ float access$700(KeyCycle r5) {
        return r5.mAlpha;
    }

    public static /* synthetic */ float access$702(KeyCycle r5, float r10) {
        r5.mAlpha = r10;
        return r10;
    }

    public static /* synthetic */ float access$800(KeyCycle r5) {
        return r5.mElevation;
    }

    public static /* synthetic */ float access$802(KeyCycle r5, float r10) {
        r5.mElevation = r10;
        return r10;
    }

    public static /* synthetic */ float access$900(KeyCycle r5) {
        return r5.mRotation;
    }

    public static /* synthetic */ float access$902(KeyCycle r5, float r10) {
        r5.mRotation = r10;
        return r10;
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> r21) {
        Iterator<String> r5 = r21.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        String r10 = r5.next();
        if (r10.startsWith("CUSTOM") == true) goto L7;
        float r19 = getValue(r10);
        if (Float.isNaN(r19) == true) goto L4;
        r21.get(r10).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, r19);
        goto L4
    L7:
        String r11 = r10.substring(7);
        ConstraintAttribute r12 = this.mCustomConstraints.get(r11);
        if (r12 == null) goto L4;
        if (r12.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        r21.get(r10).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, r12.getValueToInterpolate(), r12);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r10) {
        Debug.logStack("KeyCycle", "add " + r10.size() + " values", 2);
        Iterator<String> r5 = r10.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L75;
        String r11 = r5.next();
        SplineSet r12 = r10.get(r11);
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1249320806: goto L57;
            case -1249320805: goto L53;
            case -1225497657: goto L49;
            case -1225497656: goto L45;
            case -1225497655: goto L41;
            case -1001078227: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -40300674: goto L25;
            case -4379043: goto L21;
            case 37232917: goto L17;
            case 92909918: goto L13;
            case 156108012: goto L9;
            default: goto L60;
        };
    L60:
        switch(r13) {
            case 0: goto L74;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L70;
            case 5: goto L69;
            case 6: goto L68;
            case 7: goto L67;
            case 8: goto L66;
            case 9: goto L65;
            case 10: goto L64;
            case 11: goto L63;
            case 12: goto L62;
            default: goto L61;
        };
    L62:
        r12.setPoint(this.mFramePosition, this.mWaveOffset);
        goto L4
    L63:
        r12.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L64:
        r12.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L65:
        r12.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L66:
        r12.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L67:
        r12.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L68:
        r12.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L69:
        r12.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L70:
        r12.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L71:
        r12.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L72:
        r12.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L73:
        r12.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L74:
        r12.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L61:
        Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  ".concat(r11));
        goto L4
    L9:
        if (r11.equals("waveOffset") == false) goto L60;
        r13 = 12;
        goto L60
    L13:
        if (r11.equals("alpha") == false) goto L60;
        r13 = 11;
        goto L60
    L17:
        if (r11.equals("transitionPathRotate") == false) goto L60;
        r13 = 10;
        goto L60
    L21:
        if (r11.equals("elevation") == false) goto L60;
        r13 = 9;
        goto L60
    L25:
        if (r11.equals("rotation") == false) goto L60;
        r13 = 8;
        goto L60
    L29:
        if (r11.equals("scaleY") == false) goto L60;
        r13 = 7;
        goto L60
    L33:
        if (r11.equals("scaleX") == false) goto L60;
        r13 = 6;
        goto L60
    L37:
        if (r11.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L60;
        r13 = 5;
        goto L60
    L41:
        if (r11.equals("translationZ") == false) goto L60;
        r13 = 4;
        goto L60
    L45:
        if (r11.equals("translationY") == false) goto L60;
        r13 = 3;
        goto L60
    L49:
        if (r11.equals("translationX") == false) goto L60;
        r13 = 2;
        goto L60
    L53:
        if (r11.equals("rotationY") == false) goto L60;
        r13 = 1;
        goto L60
    L57:
        if (r11.equals("rotationX") == false) goto L60;
        r13 = 0;
        goto L60
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r5.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r5.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r5.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r5.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r5.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r5.add("translationZ");
    L36:
        if (this.mCustomConstraints.size() <= 0) goto L41;
        Iterator<String> r10 = this.mCustomConstraints.keySet().iterator();
    L39:
        if (r10.hasNext() == false) goto L43;
        r5.add("CUSTOM," + r10.next());
        goto L39
    L43:
        return;
    }

    public float getValue(String r5) {
        r5.getClass();
        byte r10 = -1;
        switch(r5.hashCode()) {
            case -1249320806: goto L54;
            case -1249320805: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1225497655: goto L38;
            case -1001078227: goto L34;
            case -908189618: goto L30;
            case -908189617: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L57;
        };
    L57:
        switch(r10) {
            case 0: goto L85;
            case 1: goto L83;
            case 2: goto L81;
            case 3: goto L79;
            case 4: goto L77;
            case 5: goto L75;
            case 6: goto L73;
            case 7: goto L71;
            case 8: goto L69;
            case 9: goto L67;
            case 10: goto L65;
            case 11: goto L63;
            case 12: goto L61;
            default: goto L58;
        };
    L58:
        Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  ".concat(r5));
        return Float.NaN;
    L61:
        return this.mWaveOffset;
    L63:
        return this.mAlpha;
    L65:
        return this.mTransitionPathRotate;
    L67:
        return this.mElevation;
    L69:
        return this.mRotation;
    L71:
        return this.mScaleY;
    L73:
        return this.mScaleX;
    L75:
        return this.mProgress;
    L77:
        return this.mTranslationZ;
    L79:
        return this.mTranslationY;
    L81:
        return this.mTranslationX;
    L83:
        return this.mRotationY;
    L85:
        return this.mRotationX;
    L6:
        if (r5.equals("waveOffset") == false) goto L57;
        r10 = 12;
        goto L57
    L10:
        if (r5.equals("alpha") == false) goto L57;
        r10 = 11;
        goto L57
    L14:
        if (r5.equals("transitionPathRotate") == false) goto L57;
        r10 = 10;
        goto L57
    L18:
        if (r5.equals("elevation") == false) goto L57;
        r10 = 9;
        goto L57
    L22:
        if (r5.equals("rotation") == false) goto L57;
        r10 = 8;
        goto L57
    L26:
        if (r5.equals("scaleY") == false) goto L57;
        r10 = 7;
        goto L57
    L30:
        if (r5.equals("scaleX") == false) goto L57;
        r10 = 6;
        goto L57
    L34:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L57;
        r10 = 5;
        goto L57
    L38:
        if (r5.equals("translationZ") == false) goto L57;
        r10 = 4;
        goto L57
    L42:
        if (r5.equals("translationY") == false) goto L57;
        r10 = 3;
        goto L57
    L46:
        if (r5.equals("translationX") == false) goto L57;
        r10 = 2;
        goto L57
    L50:
        if (r5.equals("rotationY") == false) goto L57;
        r10 = 1;
        goto L57
    L54:
        if (r5.equals("rotationX") == false) goto L57;
        r10 = 0;
        goto L57
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r5, AttributeSet r10) {
        Loader.access$000(this, r5.obtainStyledAttributes(r10, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r5, Object r10) {
        r5.getClass();
        byte r11 = -1;
        switch(r5.hashCode()) {
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -40300674: goto L34;
            case -4379043: goto L30;
            case 37232917: goto L26;
            case 92909918: goto L22;
            case 156108012: goto L18;
            case 184161818: goto L14;
            case 579057826: goto L10;
            case 1317633238: goto L6;
            default: goto L69;
        };
    L69:
        switch(r11) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            default: goto L103;
        };
    L71:
        this.mTranslationZ = toFloat(r10);
        return;
    L72:
        this.mCurveFit = toInt(r10);
        return;
    L73:
        this.mWavePeriod = toFloat(r10);
        return;
    L74:
        this.mWaveOffset = toFloat(r10);
        return;
    L75:
        this.mAlpha = toFloat(r10);
        return;
    L76:
        this.mTransitionPathRotate = toFloat(r10);
        return;
    L77:
        this.mElevation = toFloat(r10);
        return;
    L78:
        this.mRotation = toFloat(r10);
        return;
    L79:
        this.mScaleY = toFloat(r10);
        return;
    L80:
        this.mScaleX = toFloat(r10);
        return;
    L81:
        this.mProgress = toFloat(r10);
        return;
    L82:
        this.mTranslationY = toFloat(r10);
        return;
    L83:
        this.mTranslationX = toFloat(r10);
        return;
    L84:
        this.mRotationY = toFloat(r10);
        return;
    L85:
        this.mRotationX = toFloat(r10);
        return;
    L86:
        this.mTransitionEasing = r10.toString();
        return;
    L103:
        return;
    L6:
        if (r5.equals("mTranslationZ") == false) goto L69;
        r11 = 15;
        goto L69
    L10:
        if (r5.equals("curveFit") == false) goto L69;
        r11 = 14;
        goto L69
    L14:
        if (r5.equals("wavePeriod") == false) goto L69;
        r11 = 13;
        goto L69
    L18:
        if (r5.equals("waveOffset") == false) goto L69;
        r11 = 12;
        goto L69
    L22:
        if (r5.equals("alpha") == false) goto L69;
        r11 = 11;
        goto L69
    L26:
        if (r5.equals("transitionPathRotate") == false) goto L69;
        r11 = 10;
        goto L69
    L30:
        if (r5.equals("elevation") == false) goto L69;
        r11 = 9;
        goto L69
    L34:
        if (r5.equals("rotation") == false) goto L69;
        r11 = 8;
        goto L69
    L38:
        if (r5.equals("scaleY") == false) goto L69;
        r11 = 7;
        goto L69
    L42:
        if (r5.equals("scaleX") == false) goto L69;
        r11 = 6;
        goto L69
    L46:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L69;
        r11 = 5;
        goto L69
    L50:
        if (r5.equals("translationY") == false) goto L69;
        r11 = 4;
        goto L69
    L54:
        if (r5.equals("translationX") == false) goto L69;
        r11 = 3;
        goto L69
    L58:
        if (r5.equals("rotationY") == false) goto L69;
        r11 = 2;
        goto L69
    L62:
        if (r5.equals("rotationX") == false) goto L69;
        r11 = 1;
        goto L69
    L66:
        if (r5.equals("transitionEasing") == false) goto L69;
        r11 = 0;
        goto L69
    }
}
