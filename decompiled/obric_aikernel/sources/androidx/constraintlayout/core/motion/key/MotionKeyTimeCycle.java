package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
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

    public MotionKeyTimeCycle() {
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
        this.mCustom = new HashMap();
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r11) {
        Iterator<String> r10 = r11.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L102;
        String r12 = r10.next();
        TimeCycleSplineSet r13 = r11.get(r12);
        if (r13 == null) goto L4;
        byte r14 = 7;
        if (r12.startsWith("CUSTOM") == true) goto L10;
        switch(r12.hashCode()) {
            case -1249320806: goto L60;
            case -1249320805: goto L56;
            case -1249320804: goto L52;
            case -1225497657: goto L48;
            case -1225497656: goto L44;
            case -1225497655: goto L40;
            case -1001078227: goto L36;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
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
            case 10: goto L69;
            case 11: goto L66;
            default: goto L64;
        };
    L66:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        int r15 = this.mFramePosition;
        float r16 = this.mTransitionPathRotate;
    L71:
        r13.setPoint(r15, r16, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L69:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mAlpha;
        goto L71
    L73:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
    L86:
        r15 = this.mFramePosition;
        r16 = this.mTranslationZ;
        goto L71
    L76:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleY;
        goto L71
    L79:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleX;
        goto L71
    L82:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mProgress;
        goto L71
    L85:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
    L88:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationY;
        goto L71
    L91:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationX;
        goto L71
    L94:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotation;
        goto L71
    L97:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationY;
        goto L71
    L100:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationX;
        goto L71
    L64:
        Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + r12 + "\"");
        goto L4
    L17:
        if (r12.equals("pathRotate") == false) goto L151;
        r14 = 11;
        goto L63
    L151:
        r14 = -1;
        goto L63
    L21:
        if (r12.equals("alpha") == false) goto L152;
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
        if (r12.equals("scaleY") == false) goto L154;
        r14 = 8;
        goto L63
    L154:
        r14 = -1;
        goto L63
    L33:
        if (r12.equals("scaleX") == true) goto L63;
        r14 = -1;
        goto L63
    L36:
        if (r12.equals("progress") == false) goto L156;
        r14 = 6;
        goto L63
    L156:
        r14 = -1;
        goto L63
    L40:
        if (r12.equals("translationZ") == false) goto L157;
        r14 = 5;
        goto L63
    L157:
        r14 = -1;
        goto L63
    L44:
        if (r12.equals("translationY") == false) goto L158;
        r14 = 4;
        goto L63
    L158:
        r14 = -1;
        goto L63
    L48:
        if (r12.equals("translationX") == false) goto L159;
        r14 = 3;
        goto L63
    L159:
        r14 = -1;
        goto L63
    L52:
        if (r12.equals("rotationZ") == false) goto L160;
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
        CustomVariable r17 = this.mCustom.get(r12.substring(7));
        if (r17 == null) goto L4;
        ((TimeCycleSplineSet.CustomVarSet) r13).setPoint(this.mFramePosition, r17, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r10) {
        return copy(r10);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey r10) {
        super.copy(r10);
        MotionKeyTimeCycle r11 = (MotionKeyTimeCycle) r10;
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
        return TypedValues.CycleType.getId(r10);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        if (r10 != 315) goto L5;
        this.mProgress = toFloat(Float.valueOf(r11));
        return true;
    L5:
        if (r10 != 401) goto L7;
        this.mCurveFit = toInt(Float.valueOf(r11));
        return true;
    L7:
        if (r10 != 403) goto L9;
        this.mAlpha = r11;
        return true;
    L9:
        if (r10 != 416) goto L11;
        this.mTransitionPathRotate = toFloat(Float.valueOf(r11));
        return true;
    L11:
        if (r10 != 423) goto L13;
        this.mWavePeriod = toFloat(Float.valueOf(r11));
        return true;
    L13:
        if (r10 == 424) goto L26;
        switch(r10) {
            case 304: goto L25;
            case 305: goto L24;
            case 306: goto L23;
            case 307: goto L22;
            case 308: goto L21;
            case 309: goto L20;
            case 310: goto L19;
            case 311: goto L18;
            case 312: goto L17;
            default: goto L16;
        };
    L17:
        this.mScaleY = toFloat(Float.valueOf(r11));
        return true;
    L18:
        this.mScaleX = toFloat(Float.valueOf(r11));
        return true;
    L19:
        this.mRotation = toFloat(Float.valueOf(r11));
        return true;
    L20:
        this.mRotationY = toFloat(Float.valueOf(r11));
        return true;
    L21:
        this.mRotationX = toFloat(Float.valueOf(r11));
        return true;
    L22:
        this.mElevation = toFloat(Float.valueOf(r11));
        return true;
    L23:
        this.mTranslationZ = toFloat(Float.valueOf(r11));
        return true;
    L24:
        this.mTranslationY = toFloat(Float.valueOf(r11));
        return true;
    L25:
        this.mTranslationX = toFloat(Float.valueOf(r11));
        return true;
    L16:
        return super.setValue(r10, r11);
    L26:
        this.mWaveOffset = toFloat(Float.valueOf(r11));
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 100) goto L5;
        this.mFramePosition = r11;
        return true;
    L5:
        if (r10 != 421) goto L7;
        this.mWaveShape = r11;
        return true;
    L7:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 420) goto L5;
        this.mTransitionEasing = r11;
        return true;
    L5:
        if (r10 != 421) goto L7;
        this.mWaveShape = 7;
        this.mCustomWaveShape = r11;
        return true;
    L7:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, boolean r11) {
        return super.setValue(r10, r11);
    }
}
