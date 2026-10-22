package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyCycle extends MotionKey {
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

    public MotionKeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mWavePhase = 0.0f;
        this.mProgress = Float.NaN;
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
        this.mCustom = new HashMap();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> r25) {
        Iterator<String> r10 = r25.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        String r11 = r10.next();
        if (r11.startsWith("CUSTOM") == true) goto L7;
        float r23 = getValue(r11);
        if (Float.isNaN(r23) == true) goto L4;
        KeyCycleOscillator r15 = r25.get(r11);
        if (r15 == null) goto L4;
        r15.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r23);
        goto L4
    L7:
        String r12 = r11.substring(7);
        CustomVariable r14 = this.mCustom.get(r12);
        if (r14 == null) goto L4;
        if (r14.getType() != 901) goto L4;
        KeyCycleOscillator r13 = r25.get(r11);
        if (r13 == null) goto L4;
        r13.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r14.getValueToInterpolate(), r14);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    public void dump() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.mWaveShape + ", mWavePeriod=" + this.mWavePeriod + ", mWaveOffset=" + this.mWaveOffset + ", mWavePhase=" + this.mWavePhase + ", mRotation=" + this.mRotation + '}');
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r10) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r10.add("rotationZ");
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
        r10.add("pathRotate");
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
        if (this.mCustom.size() <= 0) goto L41;
        Iterator<String> r11 = this.mCustom.keySet().iterator();
    L39:
        if (r11.hasNext() == false) goto L43;
        r10.add("CUSTOM," + r11.next());
        goto L39
    L43:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        r10.hashCode();
        switch(r10.hashCode()) {
            case -1581616630: goto L86;
            case -1310311125: goto L82;
            case -1249320806: goto L78;
            case -1249320805: goto L74;
            case -1249320804: goto L70;
            case -1225497657: goto L66;
            case -1225497656: goto L62;
            case -1225497655: goto L58;
            case -1019779949: goto L54;
            case -1001078227: goto L50;
            case -991726143: goto L46;
            case -987906986: goto L42;
            case -987906985: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case 92909918: goto L26;
            case 106629499: goto L22;
            case 579057826: goto L18;
            case 803192288: goto L14;
            case 1532805160: goto L10;
            case 1941332754: goto L6;
            default: goto L4;
        };
    L4:
        byte r11 = -1;
    L89:
        switch(r11) {
            case 0: goto L131;
            case 1: goto L129;
            case 2: goto L127;
            case 3: goto L125;
            case 4: goto L123;
            case 5: goto L121;
            case 6: goto L119;
            case 7: goto L117;
            case 8: goto L115;
            case 9: goto L113;
            case 10: goto L111;
            case 11: goto L109;
            case 12: goto L107;
            case 13: goto L105;
            case 14: goto L103;
            case 15: goto L101;
            case 16: goto L99;
            case 17: goto L97;
            case 18: goto L95;
            case 19: goto L93;
            case 20: goto L91;
            default: goto L90;
        };
    L90:
        return -1;
    L91:
        return TypedValues.CycleType.TYPE_VISIBILITY;
    L93:
        return TypedValues.CycleType.TYPE_WAVE_SHAPE;
    L95:
        return TypedValues.CycleType.TYPE_PATH_ROTATE;
    L97:
        return 401;
    L99:
        return TypedValues.CycleType.TYPE_WAVE_PHASE;
    L101:
        return 403;
    L103:
        return 312;
    L105:
        return 311;
    L107:
        return 314;
    L109:
        return 313;
    L111:
        return TypedValues.CycleType.TYPE_WAVE_PERIOD;
    L113:
        return 315;
    L115:
        return TypedValues.CycleType.TYPE_WAVE_OFFSET;
    L117:
        return 306;
    L119:
        return 305;
    L121:
        return 304;
    L123:
        return 310;
    L125:
        return 309;
    L127:
        return 308;
    L129:
        return TypedValues.CycleType.TYPE_EASING;
    L131:
        return TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE;
    L6:
        if (r10.equals("visibility") == false) goto L133;
        r11 = 20;
        goto L89
    L133:
        r11 = -1;
        goto L89
    L10:
        if (r10.equals("waveShape") == false) goto L134;
        r11 = 19;
        goto L89
    L134:
        r11 = -1;
        goto L89
    L14:
        if (r10.equals("pathRotate") == false) goto L135;
        r11 = 18;
        goto L89
    L135:
        r11 = -1;
        goto L89
    L18:
        if (r10.equals("curveFit") == false) goto L136;
        r11 = 17;
        goto L89
    L136:
        r11 = -1;
        goto L89
    L22:
        if (r10.equals(TypedValues.CycleType.S_WAVE_PHASE) == false) goto L137;
        r11 = 16;
        goto L89
    L137:
        r11 = -1;
        goto L89
    L26:
        if (r10.equals("alpha") == false) goto L138;
        r11 = 15;
        goto L89
    L138:
        r11 = -1;
        goto L89
    L30:
        if (r10.equals("scaleY") == false) goto L139;
        r11 = 14;
        goto L89
    L139:
        r11 = -1;
        goto L89
    L34:
        if (r10.equals("scaleX") == false) goto L140;
        r11 = 13;
        goto L89
    L140:
        r11 = -1;
        goto L89
    L38:
        if (r10.equals("pivotY") == false) goto L141;
        r11 = 12;
        goto L89
    L141:
        r11 = -1;
        goto L89
    L42:
        if (r10.equals("pivotX") == false) goto L142;
        r11 = 11;
        goto L89
    L142:
        r11 = -1;
        goto L89
    L46:
        if (r10.equals(TypedValues.CycleType.S_WAVE_PERIOD) == false) goto L143;
        r11 = 10;
        goto L89
    L143:
        r11 = -1;
        goto L89
    L50:
        if (r10.equals("progress") == false) goto L144;
        r11 = 9;
        goto L89
    L144:
        r11 = -1;
        goto L89
    L54:
        if (r10.equals(TypedValues.CycleType.S_WAVE_OFFSET) == false) goto L145;
        r11 = 8;
        goto L89
    L145:
        r11 = -1;
        goto L89
    L58:
        if (r10.equals("translationZ") == false) goto L146;
        r11 = 7;
        goto L89
    L146:
        r11 = -1;
        goto L89
    L62:
        if (r10.equals("translationY") == false) goto L147;
        r11 = 6;
        goto L89
    L147:
        r11 = -1;
        goto L89
    L66:
        if (r10.equals("translationX") == false) goto L148;
        r11 = 5;
        goto L89
    L148:
        r11 = -1;
        goto L89
    L70:
        if (r10.equals("rotationZ") == false) goto L149;
        r11 = 4;
        goto L89
    L149:
        r11 = -1;
        goto L89
    L74:
        if (r10.equals("rotationY") == false) goto L150;
        r11 = 3;
        goto L89
    L150:
        r11 = -1;
        goto L89
    L78:
        if (r10.equals("rotationX") == false) goto L151;
        r11 = 2;
        goto L89
    L151:
        r11 = -1;
        goto L89
    L82:
        if (r10.equals("easing") == false) goto L152;
        r11 = 1;
        goto L89
    L152:
        r11 = -1;
        goto L89
    L86:
        if (r10.equals(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE) == false) goto L153;
        r11 = 0;
        goto L89
    L153:
        r11 = -1;
        goto L89
    }

    public float getValue(String r10) {
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1249320804: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1225497655: goto L38;
            case -1019779949: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -4379043: goto L18;
            case 92909918: goto L14;
            case 106629499: goto L10;
            case 803192288: goto L6;
            default: goto L61;
        };
    L61:
        switch(r11) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L62;
        };
    L62:
        return Float.NaN;
    L65:
        return this.mTransitionPathRotate;
    L67:
        return this.mWavePhase;
    L69:
        return this.mAlpha;
    L71:
        return this.mElevation;
    L73:
        return this.mScaleY;
    L75:
        return this.mScaleX;
    L77:
        return this.mProgress;
    L79:
        return this.mWaveOffset;
    L81:
        return this.mTranslationZ;
    L83:
        return this.mTranslationY;
    L85:
        return this.mTranslationX;
    L87:
        return this.mRotation;
    L89:
        return this.mRotationY;
    L91:
        return this.mRotationX;
    L6:
        if (r10.equals("pathRotate") == false) goto L61;
        r11 = 13;
        goto L61
    L10:
        if (r10.equals(TypedValues.CycleType.S_WAVE_PHASE) == false) goto L61;
        r11 = 12;
        goto L61
    L14:
        if (r10.equals("alpha") == false) goto L61;
        r11 = 11;
        goto L61
    L18:
        if (r10.equals("elevation") == false) goto L61;
        r11 = 10;
        goto L61
    L22:
        if (r10.equals("scaleY") == false) goto L61;
        r11 = 9;
        goto L61
    L26:
        if (r10.equals("scaleX") == false) goto L61;
        r11 = 8;
        goto L61
    L30:
        if (r10.equals("progress") == false) goto L61;
        r11 = 7;
        goto L61
    L34:
        if (r10.equals(TypedValues.CycleType.S_WAVE_OFFSET) == false) goto L61;
        r11 = 6;
        goto L61
    L38:
        if (r10.equals("translationZ") == false) goto L61;
        r11 = 5;
        goto L61
    L42:
        if (r10.equals("translationY") == false) goto L61;
        r11 = 4;
        goto L61
    L46:
        if (r10.equals("translationX") == false) goto L61;
        r11 = 3;
        goto L61
    L50:
        if (r10.equals("rotationZ") == false) goto L61;
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

    public void printAttributes() {
        HashSet<String> r10 = new HashSet();
        getAttributeNames(r10);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.mWaveShape + ", Period=" + this.mWavePeriod + ", Offset=" + this.mWaveOffset + ", Phase=" + this.mWavePhase + '}');
        int r11 = 0;
        String[] r12 = (String[]) r10.toArray(new String[0]);
    L4:
        if (r11 >= r12.length) goto L6;
        TypedValues.AttributesType.getId(r12[r11]);
        Utils.log(r12[r11] + ":" + getValue(r12[r11]));
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        if (r10 != 315) goto L5;
        this.mProgress = r11;
        return true;
    L5:
        if (r10 != 403) goto L7;
        this.mAlpha = r11;
        return true;
    L7:
        if (r10 == 416) goto L24;
        switch(r10) {
            case 304: goto L23;
            case 305: goto L22;
            case 306: goto L21;
            case 307: goto L20;
            case 308: goto L19;
            case 309: goto L18;
            case 310: goto L17;
            case 311: goto L16;
            case 312: goto L15;
            default: goto L9;
        };
    L9:
        switch(r10) {
            case 423: goto L14;
            case 424: goto L13;
            case 425: goto L12;
            default: goto L11;
        };
    L12:
        this.mWavePhase = r11;
        return true;
    L13:
        this.mWaveOffset = r11;
        return true;
    L14:
        this.mWavePeriod = r11;
        return true;
    L11:
        return super.setValue(r10, r11);
    L15:
        this.mScaleY = r11;
        return true;
    L16:
        this.mScaleX = r11;
        return true;
    L17:
        this.mRotation = r11;
        return true;
    L18:
        this.mRotationY = r11;
        return true;
    L19:
        this.mRotationX = r11;
        return true;
    L20:
        this.mElevation = r11;
        return true;
    L21:
        this.mTranslationZ = r11;
        return true;
    L22:
        this.mTranslationY = r11;
        return true;
    L23:
        this.mTranslationX = r11;
        return true;
    L24:
        this.mTransitionPathRotate = r11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 401) goto L5;
        this.mCurveFit = r11;
        return true;
    L5:
        if (r10 != 421) goto L7;
        this.mWaveShape = r11;
        return true;
    L7:
        if (setValue(r10, r11) == false) goto L10;
        return true;
    L10:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 420) goto L5;
        this.mTransitionEasing = r11;
        return true;
    L5:
        if (r10 != 422) goto L7;
        this.mCustomWaveShape = r11;
        return true;
    L7:
        return super.setValue(r10, r11);
    }
}
