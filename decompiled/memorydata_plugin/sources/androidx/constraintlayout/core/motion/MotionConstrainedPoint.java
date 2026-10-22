package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names;
    private float alpha;
    private boolean applyElevation;
    private float elevation;
    private float height;
    private int mAnimateRelativeTo;
    LinkedHashMap<String, CustomVariable> mCustomVariable;
    private int mDrawPath;
    private Easing mKeyFrameEasing;
    int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    int mVisibilityMode;
    private float position;
    private float rotation;
    private float rotationX;
    public float rotationY;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private float translationZ;
    int visibility;
    private float width;
    private float x;
    private float y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionConstrainedPoint() {
        this.alpha = 1.0f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mAnimateRelativeTo = -1;
        this.mCustomVariable = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    public void addValues(HashMap<String, SplineSet> r9, int r10) {
        Iterator<String> r0 = r9.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L126;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        SplineSet r2 = (SplineSet) ZeusTransformUtils.preCheckCast(r9.get(r1), SplineSet.class, "com.obric.memorydata.plugin");
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L57;
            case -1249320805: goto L53;
            case -1249320804: goto L49;
            case -1225497657: goto L45;
            case -1225497656: goto L41;
            case -1225497655: goto L37;
            case -1001078227: goto L33;
            case -987906986: goto L29;
            case -987906985: goto L25;
            case -908189618: goto L21;
            case -908189617: goto L17;
            case 92909918: goto L13;
            case 803192288: goto L9;
            default: goto L60;
        };
    L60:
        float r5 = 1.0f;
        float r7 = 0.0f;
        switch(r4) {
            case 0: goto L123;
            case 1: goto L119;
            case 2: goto L114;
            case 3: goto L110;
            case 4: goto L106;
            case 5: goto L102;
            case 6: goto L98;
            case 7: goto L94;
            case 8: goto L90;
            case 9: goto L86;
            case 10: goto L82;
            case 11: goto L77;
            case 12: goto L73;
            default: goto L63;
        };
    L73:
        if (Float.isNaN(this.mPathRotate) == true) goto L117;
        r7 = this.mPathRotate;
    L117:
        r2.setPoint(r10, r7);
        goto L4
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r5 = this.alpha;
    L80:
        r2.setPoint(r10, r5);
        goto L4
    L82:
        if (Float.isNaN(this.scaleY) == true) goto L80;
        r5 = this.scaleY;
        goto L80
    L86:
        if (Float.isNaN(this.scaleX) == true) goto L80;
        r5 = this.scaleX;
        goto L80
    L90:
        if (Float.isNaN(this.mPivotY) == true) goto L117;
        r7 = this.mPivotY;
        goto L117
    L94:
        if (Float.isNaN(this.mPivotX) == true) goto L117;
        r7 = this.mPivotX;
        goto L117
    L98:
        if (Float.isNaN(this.mProgress) == true) goto L117;
        r7 = this.mProgress;
        goto L117
    L102:
        if (Float.isNaN(this.translationZ) == true) goto L117;
        r7 = this.translationZ;
        goto L117
    L106:
        if (Float.isNaN(this.translationY) == true) goto L117;
        r7 = this.translationY;
        goto L117
    L110:
        if (Float.isNaN(this.translationX) == true) goto L117;
        r7 = this.translationX;
        goto L117
    L114:
        if (Float.isNaN(this.rotation) == true) goto L117;
        r7 = this.rotation;
        goto L117
    L119:
        if (Float.isNaN(this.rotationY) == true) goto L117;
        r7 = this.rotationY;
        goto L117
    L123:
        if (Float.isNaN(this.rotationX) == true) goto L117;
        r7 = this.rotationX;
        goto L117
    L63:
        if (r1.startsWith("CUSTOM") == false) goto L71;
        String r6 = r1.split(",")[1];
        if (this.mCustomVariable.containsKey(r6) == false) goto L4;
        CustomVariable r8 = (CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustomVariable.get(r6), CustomVariable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, SplineSet.CustomSpline.class) == true) goto L68;
        StringBuilder r3 = new StringBuilder().append(r1).append(" ViewSpline not a CustomSet frame = ").append(r10).append(", value").append(r8.getValueToInterpolate()).append(r2);
    L70:
        Utils.loge("MotionPaths", r3.toString());
        goto L4
    L68:
        ((SplineSet.CustomSpline) ZeusTransformUtils.preCheckCast(r2, SplineSet.CustomSpline.class, "com.obric.memorydata.plugin")).setPoint(r10, r8);
        goto L4
    L71:
        r3 = new StringBuilder().append("UNKNOWN spline ").append(r1);
        goto L70
    L9:
        if (r1.equals("pathRotate") == false) goto L60;
        r4 = 12;
        goto L60
    L13:
        if (r1.equals("alpha") == false) goto L60;
        r4 = 11;
        goto L60
    L17:
        if (r1.equals("scaleY") == false) goto L60;
        r4 = 10;
        goto L60
    L21:
        if (r1.equals("scaleX") == false) goto L60;
        r4 = 9;
        goto L60
    L25:
        if (r1.equals("pivotY") == false) goto L60;
        r4 = 8;
        goto L60
    L29:
        if (r1.equals("pivotX") == false) goto L60;
        r4 = 7;
        goto L60
    L33:
        if (r1.equals("progress") == false) goto L60;
        r4 = 6;
        goto L60
    L37:
        if (r1.equals("translationZ") == false) goto L60;
        r4 = 5;
        goto L60
    L41:
        if (r1.equals("translationY") == false) goto L60;
        r4 = 4;
        goto L60
    L45:
        if (r1.equals("translationX") == false) goto L60;
        r4 = 3;
        goto L60
    L49:
        if (r1.equals("rotationZ") == false) goto L60;
        r4 = 2;
        goto L60
    L53:
        if (r1.equals("rotationY") == false) goto L60;
        r4 = 1;
        goto L60
    L57:
        if (r1.equals("rotationX") == false) goto L60;
        r4 = 0;
        goto L60
    }

    public void applyParameters(MotionWidget r5) {
        this.visibility = r5.getVisibility();
        if (r5.getVisibility() == 4) goto L5;
        float r0 = 0.0f;
    L6:
        this.alpha = r0;
        this.applyElevation = false;
        this.rotation = r5.getRotationZ();
        this.rotationX = r5.getRotationX();
        this.rotationY = r5.getRotationY();
        this.scaleX = r5.getScaleX();
        this.scaleY = r5.getScaleY();
        this.mPivotX = r5.getPivotX();
        this.mPivotY = r5.getPivotY();
        this.translationX = r5.getTranslationX();
        this.translationY = r5.getTranslationY();
        this.translationZ = r5.getTranslationZ();
        Iterator<String> r1 = r5.getCustomAttributeNames().iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        CustomVariable r3 = r5.getCustomAttribute(r2);
        if (r3 == null) goto L8;
        if (r3.isContinuous() == false) goto L8;
        this.mCustomVariable.put(r2, r3);
        goto L8
    L14:
        return;
    L5:
        r0 = r5.getAlpha();
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r1) {
        return Float.compare(this.position, r1.position);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionConstrainedPoint r3) {
        return compareTo2((MotionConstrainedPoint) ZeusTransformUtils.preCheckCast(r3, MotionConstrainedPoint.class, "com.obric.memorydata.plugin"));
    }

    void different(MotionConstrainedPoint r6, HashSet<String> r7) {
        if (diff(this.alpha, r6.alpha) == false) goto L6;
        r7.add("alpha");
    L6:
        if (diff(this.elevation, r6.elevation) == false) goto L8;
        r7.add("translationZ");
    L8:
        int r0 = this.visibility;
        int r3 = r6.visibility;
        if (r0 == r3) goto L17;
        if (this.mVisibilityMode != 0) goto L17;
        if (r0 == 4) goto L15;
        if (r3 != 4) goto L17;
    L15:
        r7.add("alpha");
    L17:
        if (diff(this.rotation, r6.rotation) == false) goto L20;
        r7.add("rotationZ");
    L20:
        if (Float.isNaN(this.mPathRotate) == true) goto L22;
    L23:
        r7.add("pathRotate");
    L25:
        if (Float.isNaN(this.mProgress) == true) goto L27;
    L28:
        r7.add("progress");
    L30:
        if (diff(this.rotationX, r6.rotationX) == false) goto L33;
        r7.add("rotationX");
    L33:
        if (diff(this.rotationY, r6.rotationY) == false) goto L36;
        r7.add("rotationY");
    L36:
        if (diff(this.mPivotX, r6.mPivotX) == false) goto L39;
        r7.add("pivotX");
    L39:
        if (diff(this.mPivotY, r6.mPivotY) == false) goto L42;
        r7.add("pivotY");
    L42:
        if (diff(this.scaleX, r6.scaleX) == false) goto L45;
        r7.add("scaleX");
    L45:
        if (diff(this.scaleY, r6.scaleY) == false) goto L48;
        r7.add("scaleY");
    L48:
        if (diff(this.translationX, r6.translationX) == false) goto L51;
        r7.add("translationX");
    L51:
        if (diff(this.translationY, r6.translationY) == false) goto L54;
        r7.add("translationY");
    L54:
        if (diff(this.translationZ, r6.translationZ) == false) goto L57;
        r7.add("translationZ");
    L57:
        if (diff(this.elevation, r6.elevation) == false) goto L60;
        r7.add("elevation");
        return;
    L60:
        return;
    L27:
        if (Float.isNaN(r6.mProgress) == true) goto L30;
    L22:
        if (Float.isNaN(r6.mPathRotate) == true) goto L25;
        goto L23
    }

    void different(MotionConstrainedPoint r4, boolean[] r5, String[] r6) {
        r5[0] = r5[0] | diff(this.position, r4.position);
        r5[1] = r5[1] | diff(this.x, r4.x);
        r5[2] = r5[2] | diff(this.y, r4.y);
        r5[3] = r5[3] | diff(this.width, r4.width);
        boolean r0 = r5[4];
        r5[4] = diff(this.height, r4.height) | r0;
    }

    void fillStandard(double[] r7, int[] r8) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r6 = 0;
    L4:
        if (r3 >= r8.length) goto L9;
        if (r8[r3] >= 18) goto L8;
        r7[r6] = r1[r8[r3]];
        r6 = r6 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    int getCustomData(String r5, double[] r6, int r7) {
        CustomVariable r4 = (CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustomVariable.get(r5), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r4.numberOfInterpolatedValues() != 1) goto L6;
        r6[r7] = r4.getValueToInterpolate();
        return 1;
    L6:
        int r8 = r4.numberOfInterpolatedValues();
        float[] r0 = new float[r8];
        r4.getValuesToInterpolate(r0);
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L9;
        r6[r7] = r0[r9];
        r9 = r9 + 1;
        r7 = r7 + 1;
        goto L7
    L9:
        return r8;
    }

    int getCustomDataCount(String r2) {
        return ((CustomVariable) ZeusTransformUtils.preCheckCast(this.mCustomVariable.get(r2), CustomVariable.class, "com.obric.memorydata.plugin")).numberOfInterpolatedValues();
    }

    boolean hasCustomData(String r1) {
        return this.mCustomVariable.containsKey(r1);
    }

    void setBounds(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }

    public void setState(MotionWidget r5) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r5);
    }

    public void setState(Rect r4, MotionWidget r5, int r6, float r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (r6 != 1) goto L5;
        float r8 = r7 - 90.0f;
    L9:
        this.rotation = r8;
        return;
    L5:
        if (r6 != 2) goto L11;
        r8 = r7 + 90.0f;
        goto L9
    }
}
