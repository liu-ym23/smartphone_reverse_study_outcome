package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyAttributes extends MotionKey {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
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
    private int mVisibility;

    public MotionKeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = 0;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustom = new HashMap();
    }

    private float getFloatValue(int r2) {
        if (r2 == 100) goto L36;
        switch(r2) {
            case 303: goto L34;
            case 304: goto L32;
            case 305: goto L30;
            case 306: goto L28;
            case 307: goto L26;
            case 308: goto L24;
            case 309: goto L22;
            case 310: goto L20;
            case 311: goto L18;
            case 312: goto L16;
            case 313: goto L14;
            case 314: goto L12;
            case 315: goto L10;
            case 316: goto L8;
            default: goto L5;
        };
    L5:
        return Float.NaN;
    L8:
        return this.mTransitionPathRotate;
    L10:
        return this.mProgress;
    L12:
        return this.mPivotY;
    L14:
        return this.mPivotX;
    L16:
        return this.mScaleY;
    L18:
        return this.mScaleX;
    L20:
        return this.mRotation;
    L22:
        return this.mRotationY;
    L24:
        return this.mRotationX;
    L26:
        return this.mElevation;
    L28:
        return this.mTranslationZ;
    L30:
        return this.mTranslationY;
    L32:
        return this.mTranslationX;
    L34:
        return this.mAlpha;
    L36:
        return this.mFramePosition;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r7) {
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L116;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        SplineSet r2 = (SplineSet) ZeusTransformUtils.preCheckCast(r7.get(r1), SplineSet.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        byte r5 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L68;
            case -1249320805: goto L64;
            case -1249320804: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -987906986: goto L41;
            case -987906985: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
            default: goto L15;
        };
    L15:
        r5 = -1;
    L71:
        switch(r5) {
            case 0: goto L114;
            case 1: goto L111;
            case 2: goto L108;
            case 3: goto L105;
            case 4: goto L102;
            case 5: goto L99;
            case 6: goto L96;
            case 7: goto L93;
            case 8: goto L90;
            case 9: goto L87;
            case 10: goto L84;
            case 11: goto L81;
            case 12: goto L77;
            case 13: goto L74;
            default: goto L72;
        };
    L74:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        int r3 = this.mFramePosition;
        float r4 = this.mTransitionPathRotate;
    L79:
        r2.setPoint(r3, r4);
        goto L4
    L77:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mAlpha;
        goto L79
    L81:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mElevation;
        goto L79
    L84:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mScaleY;
        goto L79
    L87:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mScaleX;
        goto L79
    L90:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mPivotY;
        goto L79
    L93:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mPivotX;
        goto L79
    L96:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mProgress;
        goto L79
    L99:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mTranslationZ;
        goto L79
    L102:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mTranslationY;
        goto L79
    L105:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mTranslationX;
        goto L79
    L108:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mRotation;
        goto L79
    L111:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mRotationY;
        goto L79
    L114:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3 = this.mFramePosition;
        r4 = this.mRotationX;
        goto L79
    L72:
        System.err.println("not supported by KeyAttributes " + r1);
        goto L4
    L17:
        if (r1.equals("pathRotate") == false) goto L171;
        r5 = 13;
        goto L71
    L171:
        r5 = -1;
        goto L71
    L21:
        if (r1.equals("alpha") == false) goto L172;
        r5 = 12;
        goto L71
    L172:
        r5 = -1;
        goto L71
    L25:
        if (r1.equals("elevation") == false) goto L173;
        r5 = 11;
        goto L71
    L173:
        r5 = -1;
        goto L71
    L29:
        if (r1.equals("scaleY") == false) goto L174;
        r5 = 10;
        goto L71
    L174:
        r5 = -1;
        goto L71
    L33:
        if (r1.equals("scaleX") == false) goto L175;
        r5 = 9;
        goto L71
    L175:
        r5 = -1;
        goto L71
    L37:
        if (r1.equals("pivotY") == false) goto L176;
        r5 = 8;
        goto L71
    L176:
        r5 = -1;
        goto L71
    L41:
        if (r1.equals("pivotX") == true) goto L71;
        r5 = -1;
        goto L71
    L44:
        if (r1.equals("progress") == false) goto L178;
        r5 = 6;
        goto L71
    L178:
        r5 = -1;
        goto L71
    L48:
        if (r1.equals("translationZ") == false) goto L179;
        r5 = 5;
        goto L71
    L179:
        r5 = -1;
        goto L71
    L52:
        if (r1.equals("translationY") == false) goto L180;
        r5 = 4;
        goto L71
    L180:
        r5 = -1;
        goto L71
    L56:
        if (r1.equals("translationX") == false) goto L181;
        r5 = 3;
        goto L71
    L181:
        r5 = -1;
        goto L71
    L60:
        if (r1.equals("rotationZ") == false) goto L182;
        r5 = 2;
        goto L71
    L182:
        r5 = -1;
        goto L71
    L64:
        if (r1.equals("rotationY") == false) goto L183;
        r5 = 1;
        goto L71
    L183:
        r5 = -1;
        goto L71
    L68:
        if (r1.equals("rotationX") == false) goto L184;
        r5 = 0;
        goto L71
    L184:
        r5 = -1;
        goto L71
    L10:
        CustomVariable r6 = (CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustom.get(r1.substring(7)), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L4;
        ((SplineSet.CustomSpline) ZeusTransformUtils.preCheckCast(r2, SplineSet.CustomSpline.class, "com.obric.memorydata.plugin")).setPoint(this.mFramePosition, r6);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo36clone() {
        return clone();
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
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r4.add("pivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r4.add("pivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r4.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r4.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r4.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r4.add("pathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r4.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r4.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r4.add("progress");
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
    L48:
        if (r3.hasNext() == false) goto L52;
        r4.add("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L48
    L52:
        return;
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.AttributesType.getId(r1);
    }

    public void printAttributes() {
        HashSet<String> r0 = new HashSet();
        getAttributeNames(r0);
        System.out.println(" ------------- " + this.mFramePosition + " -------------");
        int r1 = 0;
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L4:
        if (r1 >= r2.length) goto L6;
        System.out.println(r2[r1] + ParameterizedMessage.ERROR_MSG_SEPARATOR + getFloatValue(TypedValues.AttributesType.getId(r2[r1])));
        r1 = r1 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> r5) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r5.put("alpha", Integer.valueOf(this.mCurveFit));
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r5.put("elevation", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r5.put("rotationZ", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r5.put("rotationX", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r5.put("rotationY", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r5.put("pivotX", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r5.put("pivotY", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r5.put("translationX", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r5.put("translationY", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r5.put("translationZ", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r5.put("pathRotate", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r5.put("scaleX", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r5.put("scaleY", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r5.put("progress", Integer.valueOf(this.mCurveFit));
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r0 = this.mCustom.keySet().iterator();
    L48:
        if (r0.hasNext() == false) goto L52;
        r5.put("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")), Integer.valueOf(this.mCurveFit));
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 == 100) goto L20;
        switch(r2) {
            case 303: goto L19;
            case 304: goto L18;
            case 305: goto L17;
            case 306: goto L16;
            case 307: goto L15;
            case 308: goto L14;
            case 309: goto L13;
            case 310: goto L12;
            case 311: goto L11;
            case 312: goto L10;
            case 313: goto L9;
            case 314: goto L8;
            case 315: goto L7;
            case 316: goto L20;
            default: goto L6;
        };
    L7:
        this.mProgress = r3;
        return true;
    L8:
        this.mPivotY = r3;
        return true;
    L9:
        this.mPivotX = r3;
        return true;
    L10:
        this.mScaleY = r3;
        return true;
    L11:
        this.mScaleX = r3;
        return true;
    L12:
        this.mRotation = r3;
        return true;
    L13:
        this.mRotationY = r3;
        return true;
    L14:
        this.mRotationX = r3;
        return true;
    L15:
        this.mElevation = r3;
        return true;
    L16:
        this.mTranslationZ = r3;
        return true;
    L17:
        this.mTranslationY = r3;
        return true;
    L18:
        this.mTranslationX = r3;
        return true;
    L19:
        this.mAlpha = r3;
        return true;
    L6:
        return super.setValue(r2, r3);
    L20:
        this.mTransitionPathRotate = r3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 301) goto L7;
        this.mCurveFit = r3;
        return true;
    L7:
        if (r2 != 302) goto L9;
        this.mVisibility = r3;
        return true;
    L9:
        if (setValue(r2, r3) == false) goto L11;
        return true;
    L11:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 101) goto L5;
        this.mTargetString = r3;
        return true;
    L5:
        if (r2 != 317) goto L7;
        this.mTransitionEasing = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }
}
