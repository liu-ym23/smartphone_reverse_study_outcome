package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

    private float getFloatValue(int r10) {
        if (r10 == 100) goto L36;
        switch(r10) {
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
    public void addValues(HashMap<String, SplineSet> r10) {
        Iterator<String> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L116;
        String r12 = r11.next();
        SplineSet r13 = r10.get(r12);
        if (r13 == null) goto L4;
        byte r14 = 7;
        if (r12.startsWith("CUSTOM") == true) goto L10;
        switch(r12.hashCode()) {
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
        r14 = -1;
    L71:
        switch(r14) {
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
        int r15 = this.mFramePosition;
        float r16 = this.mTransitionPathRotate;
    L79:
        r13.setPoint(r15, r16);
        goto L4
    L77:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mAlpha;
        goto L79
    L81:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mElevation;
        goto L79
    L84:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleY;
        goto L79
    L87:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mScaleX;
        goto L79
    L90:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mPivotY;
        goto L79
    L93:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mPivotX;
        goto L79
    L96:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mProgress;
        goto L79
    L99:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationZ;
        goto L79
    L102:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationY;
        goto L79
    L105:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mTranslationX;
        goto L79
    L108:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotation;
        goto L79
    L111:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationY;
        goto L79
    L114:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r15 = this.mFramePosition;
        r16 = this.mRotationX;
        goto L79
    L72:
        System.err.println("not supported by KeyAttributes " + r12);
        goto L4
    L17:
        if (r12.equals("pathRotate") == false) goto L171;
        r14 = 13;
        goto L71
    L171:
        r14 = -1;
        goto L71
    L21:
        if (r12.equals("alpha") == false) goto L172;
        r14 = 12;
        goto L71
    L172:
        r14 = -1;
        goto L71
    L25:
        if (r12.equals("elevation") == false) goto L173;
        r14 = 11;
        goto L71
    L173:
        r14 = -1;
        goto L71
    L29:
        if (r12.equals("scaleY") == false) goto L174;
        r14 = 10;
        goto L71
    L174:
        r14 = -1;
        goto L71
    L33:
        if (r12.equals("scaleX") == false) goto L175;
        r14 = 9;
        goto L71
    L175:
        r14 = -1;
        goto L71
    L37:
        if (r12.equals("pivotY") == false) goto L176;
        r14 = 8;
        goto L71
    L176:
        r14 = -1;
        goto L71
    L41:
        if (r12.equals("pivotX") == true) goto L71;
        r14 = -1;
        goto L71
    L44:
        if (r12.equals("progress") == false) goto L178;
        r14 = 6;
        goto L71
    L178:
        r14 = -1;
        goto L71
    L48:
        if (r12.equals("translationZ") == false) goto L179;
        r14 = 5;
        goto L71
    L179:
        r14 = -1;
        goto L71
    L52:
        if (r12.equals("translationY") == false) goto L180;
        r14 = 4;
        goto L71
    L180:
        r14 = -1;
        goto L71
    L56:
        if (r12.equals("translationX") == false) goto L181;
        r14 = 3;
        goto L71
    L181:
        r14 = -1;
        goto L71
    L60:
        if (r12.equals("rotationZ") == false) goto L182;
        r14 = 2;
        goto L71
    L182:
        r14 = -1;
        goto L71
    L64:
        if (r12.equals("rotationY") == false) goto L183;
        r14 = 1;
        goto L71
    L183:
        r14 = -1;
        goto L71
    L68:
        if (r12.equals("rotationX") == false) goto L184;
        r14 = 0;
        goto L71
    L184:
        r14 = -1;
        goto L71
    L10:
        CustomVariable r17 = this.mCustom.get(r12.substring(7));
        if (r17 == null) goto L4;
        ((SplineSet.CustomSpline) r13).setPoint(this.mFramePosition, r17);
        goto L4
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
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r10.add("pivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r10.add("pivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r10.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r10.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r10.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r10.add("pathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r10.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r10.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r10.add("progress");
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r11 = this.mCustom.keySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L52;
        r10.add("CUSTOM," + r11.next());
        goto L48
    L52:
        return;
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        return TypedValues.AttributesType.getId(r10);
    }

    public void printAttributes() {
        HashSet<String> r10 = new HashSet();
        getAttributeNames(r10);
        System.out.println(" ------------- " + this.mFramePosition + " -------------");
        int r11 = 0;
        String[] r12 = (String[]) r10.toArray(new String[0]);
    L4:
        if (r11 >= r12.length) goto L6;
        int r13 = TypedValues.AttributesType.getId(r12[r11]);
        System.out.println(r12[r11] + ":" + getFloatValue(r13));
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> r10) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r10.put("alpha", Integer.valueOf(this.mCurveFit));
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r10.put("elevation", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r10.put("rotationZ", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r10.put("rotationX", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r10.put("rotationY", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r10.put("pivotX", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r10.put("pivotY", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r10.put("translationX", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r10.put("translationY", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r10.put("translationZ", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r10.put("pathRotate", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r10.put("scaleX", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r10.put("scaleY", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r10.put("progress", Integer.valueOf(this.mCurveFit));
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r11 = this.mCustom.keySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L52;
        r10.put("CUSTOM," + r11.next(), Integer.valueOf(this.mCurveFit));
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        if (r10 == 100) goto L20;
        switch(r10) {
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
        this.mProgress = r11;
        return true;
    L8:
        this.mPivotY = r11;
        return true;
    L9:
        this.mPivotX = r11;
        return true;
    L10:
        this.mScaleY = r11;
        return true;
    L11:
        this.mScaleX = r11;
        return true;
    L12:
        this.mRotation = r11;
        return true;
    L13:
        this.mRotationY = r11;
        return true;
    L14:
        this.mRotationX = r11;
        return true;
    L15:
        this.mElevation = r11;
        return true;
    L16:
        this.mTranslationZ = r11;
        return true;
    L17:
        this.mTranslationY = r11;
        return true;
    L18:
        this.mTranslationX = r11;
        return true;
    L19:
        this.mAlpha = r11;
        return true;
    L6:
        return super.setValue(r10, r11);
    L20:
        this.mTransitionPathRotate = r11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 100) goto L5;
        this.mFramePosition = r11;
        return true;
    L5:
        if (r10 != 301) goto L7;
        this.mCurveFit = r11;
        return true;
    L7:
        if (r10 != 302) goto L9;
        this.mVisibility = r11;
        return true;
    L9:
        if (setValue(r10, r11) == false) goto L11;
        return true;
    L11:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 101) goto L5;
        this.mTargetString = r11;
        return true;
    L5:
        if (r10 != 317) goto L7;
        this.mTransitionEasing = r11;
        return true;
    L7:
        return super.setValue(r10, r11);
    }
}
