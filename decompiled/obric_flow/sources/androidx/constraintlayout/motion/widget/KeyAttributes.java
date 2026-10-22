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
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
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
    private boolean mVisibility;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
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
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mAttrMap = r5;
            r5.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes r5, TypedArray r10) {
            int r11 = r10.getIndexCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L34;
            int r13 = r10.getIndex(r12);
            switch(mAttrMap.get(r13)) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L6;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L17;
                case 11: goto L6;
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
            Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(r13) + "   " + mAttrMap.get(r13));
        L33:
            r12 = r12 + 1;
            goto L3
        L7:
            KeyAttributes.access$802(r5, r10.getDimension(r13, KeyAttributes.access$800(r5)));
            goto L33
        L8:
            KeyAttributes.access$702(r5, r10.getDimension(r13, KeyAttributes.access$700(r5)));
            goto L33
        L9:
            KeyAttributes.access$1502(r5, r10.getFloat(r13, KeyAttributes.access$1500(r5)));
            goto L33
        L10:
            KeyAttributes.access$1402(r5, r10.getDimension(r13, KeyAttributes.access$1400(r5)));
            goto L33
        L11:
            KeyAttributes.access$1302(r5, r10.getDimension(r13, KeyAttributes.access$1300(r5)));
            goto L33
        L12:
            KeyAttributes.access$1202(r5, r10.getDimension(r13, KeyAttributes.access$1200(r5)));
            goto L33
        L13:
            KeyAttributes.access$1002(r5, r10.getFloat(r13, KeyAttributes.access$1000(r5)));
            goto L33
        L14:
            KeyAttributes.access$302(r5, r10.getInteger(r13, KeyAttributes.access$300(r5)));
            goto L33
        L15:
            r5.mFramePosition = r10.getInt(r13, r5.mFramePosition);
            goto L33
        L25:
            KeyAttributes.access$902(r5, r10.getString(r13));
            goto L33
        L26:
            KeyAttributes.access$1102(r5, r10.getFloat(r13, KeyAttributes.access$1100(r5)));
            goto L33
        L27:
            KeyAttributes.access$402(r5, r10.getFloat(r13, KeyAttributes.access$400(r5)));
            goto L33
        L28:
            KeyAttributes.access$602(r5, r10.getFloat(r13, KeyAttributes.access$600(r5)));
            goto L33
        L29:
            KeyAttributes.access$502(r5, r10.getFloat(r13, KeyAttributes.access$500(r5)));
            goto L33
        L30:
            KeyAttributes.access$202(r5, r10.getFloat(r13, KeyAttributes.access$200(r5)));
            goto L33
        L31:
            KeyAttributes.access$102(r5, r10.getDimension(r13, KeyAttributes.access$100(r5)));
            goto L33
        L32:
            KeyAttributes.access$002(r5, r10.getFloat(r13, KeyAttributes.access$000(r5)));
            goto L33
        L17:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L22;
            int r14 = r10.getResourceId(r13, r5.mTargetId);
            r5.mTargetId = r14;
            if (r14 != (-1)) goto L33;
            r5.mTargetString = r10.getString(r13);
            goto L33
        L22:
            if (r10.peekValue(r13).type != 3) goto L24;
            r5.mTargetString = r10.getString(r13);
            goto L33
        L24:
            r5.mTargetId = r10.getResourceId(r13, r5.mTargetId);
            goto L33
        }
    }

    public KeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = false;
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
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyAttributes r5) {
        return r5.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyAttributes r5, float r10) {
        r5.mAlpha = r10;
        return r10;
    }

    public static /* synthetic */ float access$100(KeyAttributes r5) {
        return r5.mElevation;
    }

    public static /* synthetic */ float access$1000(KeyAttributes r5) {
        return r5.mScaleY;
    }

    public static /* synthetic */ float access$1002(KeyAttributes r5, float r10) {
        r5.mScaleY = r10;
        return r10;
    }

    public static /* synthetic */ float access$102(KeyAttributes r5, float r10) {
        r5.mElevation = r10;
        return r10;
    }

    public static /* synthetic */ float access$1100(KeyAttributes r5) {
        return r5.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1102(KeyAttributes r5, float r10) {
        r5.mTransitionPathRotate = r10;
        return r10;
    }

    public static /* synthetic */ float access$1200(KeyAttributes r5) {
        return r5.mTranslationX;
    }

    public static /* synthetic */ float access$1202(KeyAttributes r5, float r10) {
        r5.mTranslationX = r10;
        return r10;
    }

    public static /* synthetic */ float access$1300(KeyAttributes r5) {
        return r5.mTranslationY;
    }

    public static /* synthetic */ float access$1302(KeyAttributes r5, float r10) {
        r5.mTranslationY = r10;
        return r10;
    }

    public static /* synthetic */ float access$1400(KeyAttributes r5) {
        return r5.mTranslationZ;
    }

    public static /* synthetic */ float access$1402(KeyAttributes r5, float r10) {
        r5.mTranslationZ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1500(KeyAttributes r5) {
        return r5.mProgress;
    }

    public static /* synthetic */ float access$1502(KeyAttributes r5, float r10) {
        r5.mProgress = r10;
        return r10;
    }

    public static /* synthetic */ float access$200(KeyAttributes r5) {
        return r5.mRotation;
    }

    public static /* synthetic */ float access$202(KeyAttributes r5, float r10) {
        r5.mRotation = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(KeyAttributes r5) {
        return r5.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyAttributes r5, int r10) {
        r5.mCurveFit = r10;
        return r10;
    }

    public static /* synthetic */ float access$400(KeyAttributes r5) {
        return r5.mScaleX;
    }

    public static /* synthetic */ float access$402(KeyAttributes r5, float r10) {
        r5.mScaleX = r10;
        return r10;
    }

    public static /* synthetic */ float access$500(KeyAttributes r5) {
        return r5.mRotationX;
    }

    public static /* synthetic */ float access$502(KeyAttributes r5, float r10) {
        r5.mRotationX = r10;
        return r10;
    }

    public static /* synthetic */ float access$600(KeyAttributes r5) {
        return r5.mRotationY;
    }

    public static /* synthetic */ float access$602(KeyAttributes r5, float r10) {
        r5.mRotationY = r10;
        return r10;
    }

    public static /* synthetic */ float access$700(KeyAttributes r5) {
        return r5.mPivotX;
    }

    public static /* synthetic */ float access$702(KeyAttributes r5, float r10) {
        r5.mPivotX = r10;
        return r10;
    }

    public static /* synthetic */ float access$800(KeyAttributes r5) {
        return r5.mPivotY;
    }

    public static /* synthetic */ float access$802(KeyAttributes r5, float r10) {
        r5.mPivotY = r10;
        return r10;
    }

    public static /* synthetic */ String access$902(KeyAttributes r5, String r10) {
        r5.mTransitionEasing = r10;
        return r10;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r10) {
        Iterator<String> r5 = r10.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L113;
        String r11 = r5.next();
        SplineSet r12 = r10.get(r11);
        if (r11.startsWith("CUSTOM") == true) goto L7;
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            default: goto L69;
        };
    L69:
        switch(r13) {
            case 0: goto L111;
            case 1: goto L108;
            case 2: goto L105;
            case 3: goto L102;
            case 4: goto L99;
            case 5: goto L96;
            case 6: goto L93;
            case 7: goto L90;
            case 8: goto L87;
            case 9: goto L84;
            case 10: goto L81;
            case 11: goto L78;
            case 12: goto L75;
            case 13: goto L72;
            default: goto L70;
        };
    L72:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L75:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L78:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L81:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L84:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L87:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L90:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L93:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L96:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L99:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L102:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L105:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L108:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L111:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r12.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L70:
        Log.v("KeyAttributes", "UNKNOWN addValues \"" + r11 + "\"");
        goto L4
    L14:
        if (r11.equals("alpha") == false) goto L69;
        r13 = 13;
        goto L69
    L18:
        if (r11.equals("transitionPathRotate") == false) goto L69;
        r13 = 12;
        goto L69
    L22:
        if (r11.equals("elevation") == false) goto L69;
        r13 = 11;
        goto L69
    L26:
        if (r11.equals("rotation") == false) goto L69;
        r13 = 10;
        goto L69
    L30:
        if (r11.equals("transformPivotY") == false) goto L69;
        r13 = 9;
        goto L69
    L34:
        if (r11.equals("transformPivotX") == false) goto L69;
        r13 = 8;
        goto L69
    L38:
        if (r11.equals("scaleY") == false) goto L69;
        r13 = 7;
        goto L69
    L42:
        if (r11.equals("scaleX") == false) goto L69;
        r13 = 6;
        goto L69
    L46:
        if (r11.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L69;
        r13 = 5;
        goto L69
    L50:
        if (r11.equals("translationZ") == false) goto L69;
        r13 = 4;
        goto L69
    L54:
        if (r11.equals("translationY") == false) goto L69;
        r13 = 3;
        goto L69
    L58:
        if (r11.equals("translationX") == false) goto L69;
        r13 = 2;
        goto L69
    L62:
        if (r11.equals("rotationY") == false) goto L69;
        r13 = 1;
        goto L69
    L66:
        if (r11.equals("rotationX") == false) goto L69;
        r13 = 0;
        goto L69
    L7:
        ConstraintAttribute r14 = this.mCustomConstraints.get(r11.substring(7));
        if (r14 == null) goto L4;
        ((SplineSet.CustomSet) r12).setPoint(this.mFramePosition, r14);
        goto L4
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
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r5.add("transformPivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r5.add("transformPivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r5.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r5.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r5.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r5.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r5.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r5.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r5.add(NotificationCompat.CATEGORY_PROGRESS);
    L45:
        if (this.mCustomConstraints.size() <= 0) goto L50;
        Iterator<String> r10 = this.mCustomConstraints.keySet().iterator();
    L48:
        if (r10.hasNext() == false) goto L52;
        r5.add("CUSTOM," + r10.next());
        goto L48
    L52:
        return;
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r5, AttributeSet r10) {
        Loader.read(this, r5.obtainStyledAttributes(r10, R.styleable.KeyAttribute));
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
        if (Float.isNaN(this.mPivotX) == true) goto L24;
        r5.put("transformPivotX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mPivotY) == true) goto L27;
        r5.put("transformPivotY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r5.put("translationX", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r5.put("translationY", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r5.put("translationZ", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L39;
        r5.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleX) == true) goto L42;
        r5.put("scaleX", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mScaleY) == true) goto L45;
        r5.put("scaleY", Integer.valueOf(this.mCurveFit));
    L45:
        if (Float.isNaN(this.mProgress) == true) goto L48;
        r5.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.mCurveFit));
    L48:
        if (this.mCustomConstraints.size() <= 0) goto L53;
        Iterator<String> r10 = this.mCustomConstraints.keySet().iterator();
    L51:
        if (r10.hasNext() == false) goto L55;
        r5.put(j0.C("CUSTOM,", r10.next()), Integer.valueOf(this.mCurveFit));
        goto L51
    L55:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r5, Object r10) {
        r5.getClass();
        byte r11 = -1;
        switch(r5.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -987906986: goto L46;
            case -987906985: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -40300674: goto L30;
            case -4379043: goto L26;
            case 37232917: goto L22;
            case 92909918: goto L18;
            case 579057826: goto L14;
            case 1317633238: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r11) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L82;
            case 10: goto L81;
            case 11: goto L80;
            case 12: goto L79;
            case 13: goto L78;
            case 14: goto L77;
            case 15: goto L76;
            case 16: goto L75;
            default: goto L109;
        };
    L75:
        this.mVisibility = toBoolean(r10);
        return;
    L76:
        this.mTranslationZ = toFloat(r10);
        return;
    L77:
        this.mCurveFit = toInt(r10);
        return;
    L78:
        this.mAlpha = toFloat(r10);
        return;
    L79:
        this.mTransitionPathRotate = toFloat(r10);
        return;
    L80:
        this.mElevation = toFloat(r10);
        return;
    L81:
        this.mRotation = toFloat(r10);
        return;
    L82:
        this.mScaleY = toFloat(r10);
        return;
    L83:
        this.mScaleX = toFloat(r10);
        return;
    L84:
        this.mPivotY = toFloat(r10);
        return;
    L85:
        this.mPivotX = toFloat(r10);
        return;
    L86:
        this.mTranslationY = toFloat(r10);
        return;
    L87:
        this.mTranslationX = toFloat(r10);
        return;
    L88:
        this.mRotationY = toFloat(r10);
        return;
    L89:
        this.mRotationX = toFloat(r10);
        return;
    L90:
        this.mTransitionEasing = r10.toString();
        return;
    L91:
        this.mProgress = toFloat(r10);
        return;
    L109:
        return;
    L6:
        if (r5.equals("visibility") == false) goto L73;
        r11 = 16;
        goto L73
    L10:
        if (r5.equals("mTranslationZ") == false) goto L73;
        r11 = 15;
        goto L73
    L14:
        if (r5.equals("curveFit") == false) goto L73;
        r11 = 14;
        goto L73
    L18:
        if (r5.equals("alpha") == false) goto L73;
        r11 = 13;
        goto L73
    L22:
        if (r5.equals("transitionPathRotate") == false) goto L73;
        r11 = 12;
        goto L73
    L26:
        if (r5.equals("elevation") == false) goto L73;
        r11 = 11;
        goto L73
    L30:
        if (r5.equals("rotation") == false) goto L73;
        r11 = 10;
        goto L73
    L34:
        if (r5.equals("scaleY") == false) goto L73;
        r11 = 9;
        goto L73
    L38:
        if (r5.equals("scaleX") == false) goto L73;
        r11 = 8;
        goto L73
    L42:
        if (r5.equals("pivotY") == false) goto L73;
        r11 = 7;
        goto L73
    L46:
        if (r5.equals("pivotX") == false) goto L73;
        r11 = 6;
        goto L73
    L50:
        if (r5.equals("translationY") == false) goto L73;
        r11 = 5;
        goto L73
    L54:
        if (r5.equals("translationX") == false) goto L73;
        r11 = 4;
        goto L73
    L58:
        if (r5.equals("rotationY") == false) goto L73;
        r11 = 3;
        goto L73
    L62:
        if (r5.equals("rotationX") == false) goto L73;
        r11 = 2;
        goto L73
    L66:
        if (r5.equals("transitionEasing") == false) goto L73;
        r11 = 1;
        goto L73
    L70:
        if (r5.equals("motionProgress") == false) goto L73;
        r11 = 0;
        goto L73
    }
}
