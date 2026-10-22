package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r12) {
        Iterator<String> r0 = r12.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L102;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        TimeCycleSplineSet r4 = (TimeCycleSplineSet) ZeusTransformUtils.preCheckCast(r12.get(r1), TimeCycleSplineSet.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        byte r5 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
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
        r5 = -1;
    L63:
        switch(r5) {
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
        int r6 = this.mFramePosition;
        float r7 = this.mTransitionPathRotate;
    L71:
        r4.setPoint(r6, r7, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L69:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mAlpha;
        goto L71
    L73:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
    L86:
        r6 = this.mFramePosition;
        r7 = this.mTranslationZ;
        goto L71
    L76:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mScaleY;
        goto L71
    L79:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mScaleX;
        goto L71
    L82:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mProgress;
        goto L71
    L85:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
    L88:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mTranslationY;
        goto L71
    L91:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mTranslationX;
        goto L71
    L94:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mRotation;
        goto L71
    L97:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mRotationY;
        goto L71
    L100:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r6 = this.mFramePosition;
        r7 = this.mRotationX;
        goto L71
    L64:
        Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + r1 + "\"");
        goto L4
    L17:
        if (r1.equals("pathRotate") == false) goto L151;
        r5 = 11;
        goto L63
    L151:
        r5 = -1;
        goto L63
    L21:
        if (r1.equals("alpha") == false) goto L152;
        r5 = 10;
        goto L63
    L152:
        r5 = -1;
        goto L63
    L25:
        if (r1.equals("elevation") == false) goto L153;
        r5 = 9;
        goto L63
    L153:
        r5 = -1;
        goto L63
    L29:
        if (r1.equals("scaleY") == false) goto L154;
        r5 = 8;
        goto L63
    L154:
        r5 = -1;
        goto L63
    L33:
        if (r1.equals("scaleX") == true) goto L63;
        r5 = -1;
        goto L63
    L36:
        if (r1.equals("progress") == false) goto L156;
        r5 = 6;
        goto L63
    L156:
        r5 = -1;
        goto L63
    L40:
        if (r1.equals("translationZ") == false) goto L157;
        r5 = 5;
        goto L63
    L157:
        r5 = -1;
        goto L63
    L44:
        if (r1.equals("translationY") == false) goto L158;
        r5 = 4;
        goto L63
    L158:
        r5 = -1;
        goto L63
    L48:
        if (r1.equals("translationX") == false) goto L159;
        r5 = 3;
        goto L63
    L159:
        r5 = -1;
        goto L63
    L52:
        if (r1.equals("rotationZ") == false) goto L160;
        r5 = 2;
        goto L63
    L160:
        r5 = -1;
        goto L63
    L56:
        if (r1.equals("rotationY") == false) goto L161;
        r5 = 1;
        goto L63
    L161:
        r5 = -1;
        goto L63
    L60:
        if (r1.equals("rotationX") == false) goto L162;
        r5 = 0;
        goto L63
    L162:
        r5 = -1;
        goto L63
    L10:
        CustomVariable r8 = (CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustom.get(r1.substring(7)), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L4;
        ((TimeCycleSplineSet.CustomVarSet) ZeusTransformUtils.preCheckCast(r4, TimeCycleSplineSet.CustomVarSet.class, "com.obric.memorydata.plugin")).setPoint(this.mFramePosition, r8, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo36clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r1) {
        return copy(r1);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey r3) {
        super.copy(r3);
        MotionKeyTimeCycle r4 = (MotionKeyTimeCycle) ZeusTransformUtils.preCheckCast(r3, MotionKeyTimeCycle.class, "com.obric.memorydata.plugin");
        this.mTransitionEasing = r4.mTransitionEasing;
        this.mCurveFit = r4.mCurveFit;
        this.mWaveShape = r4.mWaveShape;
        this.mWavePeriod = r4.mWavePeriod;
        this.mWaveOffset = r4.mWaveOffset;
        this.mProgress = r4.mProgress;
        this.mAlpha = r4.mAlpha;
        this.mElevation = r4.mElevation;
        this.mRotation = r4.mRotation;
        this.mTransitionPathRotate = r4.mTransitionPathRotate;
        this.mRotationX = r4.mRotationX;
        this.mRotationY = r4.mRotationY;
        this.mScaleX = r4.mScaleX;
        this.mScaleY = r4.mScaleY;
        this.mTranslationX = r4.mTranslationX;
        this.mTranslationY = r4.mTranslationY;
        this.mTranslationZ = r4.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.add("rotationZ");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r4.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r4.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r4.add("pathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r4.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r4.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r4.add("translationZ");
    L36:
        if (this.mCustom.size() <= 0) goto L41;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        r4.add("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L39
    L43:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.CycleType.getId(r1);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 315) goto L5;
        this.mProgress = toFloat(Float.valueOf(r3));
        return true;
    L5:
        if (r2 != 401) goto L7;
        this.mCurveFit = toInt(Float.valueOf(r3));
        return true;
    L7:
        if (r2 != 403) goto L9;
        this.mAlpha = r3;
        return true;
    L9:
        if (r2 != 416) goto L11;
        this.mTransitionPathRotate = toFloat(Float.valueOf(r3));
        return true;
    L11:
        if (r2 != 423) goto L13;
        this.mWavePeriod = toFloat(Float.valueOf(r3));
        return true;
    L13:
        if (r2 == 424) goto L26;
        switch(r2) {
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
        this.mScaleY = toFloat(Float.valueOf(r3));
        return true;
    L18:
        this.mScaleX = toFloat(Float.valueOf(r3));
        return true;
    L19:
        this.mRotation = toFloat(Float.valueOf(r3));
        return true;
    L20:
        this.mRotationY = toFloat(Float.valueOf(r3));
        return true;
    L21:
        this.mRotationX = toFloat(Float.valueOf(r3));
        return true;
    L22:
        this.mElevation = toFloat(Float.valueOf(r3));
        return true;
    L23:
        this.mTranslationZ = toFloat(Float.valueOf(r3));
        return true;
    L24:
        this.mTranslationY = toFloat(Float.valueOf(r3));
        return true;
    L25:
        this.mTranslationX = toFloat(Float.valueOf(r3));
        return true;
    L16:
        return super.setValue(r2, r3);
    L26:
        this.mWaveOffset = toFloat(Float.valueOf(r3));
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 420) goto L5;
        this.mTransitionEasing = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = 7;
        this.mCustomWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return super.setValue(r1, r2);
    }
}
