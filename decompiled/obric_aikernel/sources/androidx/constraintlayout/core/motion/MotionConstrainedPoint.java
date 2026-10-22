package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
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

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f235y;

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

    private boolean diff(float r10, float r11) {
        if (Float.isNaN(r10) == true) goto L13;
        if (Float.isNaN(r11) == true) goto L13;
        if (Math.abs(r10 - r11) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r10) == Float.isNaN(r11)) goto L16;
        return true;
    L16:
        return false;
    }

    public void addValues(HashMap<String, SplineSet> r10, int r11) {
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L126;
        String r13 = r12.next();
        SplineSet r14 = r10.get(r13);
        r13.hashCode();
        byte r15 = -1;
        switch(r13.hashCode()) {
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
        float r16 = 1.0f;
        float r17 = 0.0f;
        switch(r15) {
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
        r17 = this.mPathRotate;
    L117:
        r14.setPoint(r11, r17);
        goto L4
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r16 = this.alpha;
    L80:
        r14.setPoint(r11, r16);
        goto L4
    L82:
        if (Float.isNaN(this.scaleY) == true) goto L80;
        r16 = this.scaleY;
        goto L80
    L86:
        if (Float.isNaN(this.scaleX) == true) goto L80;
        r16 = this.scaleX;
        goto L80
    L90:
        if (Float.isNaN(this.mPivotY) == true) goto L117;
        r17 = this.mPivotY;
        goto L117
    L94:
        if (Float.isNaN(this.mPivotX) == true) goto L117;
        r17 = this.mPivotX;
        goto L117
    L98:
        if (Float.isNaN(this.mProgress) == true) goto L117;
        r17 = this.mProgress;
        goto L117
    L102:
        if (Float.isNaN(this.translationZ) == true) goto L117;
        r17 = this.translationZ;
        goto L117
    L106:
        if (Float.isNaN(this.translationY) == true) goto L117;
        r17 = this.translationY;
        goto L117
    L110:
        if (Float.isNaN(this.translationX) == true) goto L117;
        r17 = this.translationX;
        goto L117
    L114:
        if (Float.isNaN(this.rotation) == true) goto L117;
        r17 = this.rotation;
        goto L117
    L119:
        if (Float.isNaN(this.rotationY) == true) goto L117;
        r17 = this.rotationY;
        goto L117
    L123:
        if (Float.isNaN(this.rotationX) == true) goto L117;
        r17 = this.rotationX;
        goto L117
    L63:
        if (r13.startsWith("CUSTOM") == false) goto L71;
        String r18 = r13.split(",")[1];
        if (this.mCustomVariable.containsKey(r18) == false) goto L4;
        CustomVariable r19 = this.mCustomVariable.get(r18);
        if ((r14 instanceof SplineSet.CustomSpline) == true) goto L68;
        String r20 = r13 + " ViewSpline not a CustomSet frame = " + r11 + ", value" + r19.getValueToInterpolate() + r14;
    L70:
        Utils.loge("MotionPaths", r20);
        goto L4
    L68:
        ((SplineSet.CustomSpline) r14).setPoint(r11, r19);
        goto L4
    L71:
        r20 = "UNKNOWN spline " + r13;
        goto L70
    L9:
        if (r13.equals("pathRotate") == false) goto L60;
        r15 = 12;
        goto L60
    L13:
        if (r13.equals("alpha") == false) goto L60;
        r15 = 11;
        goto L60
    L17:
        if (r13.equals("scaleY") == false) goto L60;
        r15 = 10;
        goto L60
    L21:
        if (r13.equals("scaleX") == false) goto L60;
        r15 = 9;
        goto L60
    L25:
        if (r13.equals("pivotY") == false) goto L60;
        r15 = 8;
        goto L60
    L29:
        if (r13.equals("pivotX") == false) goto L60;
        r15 = 7;
        goto L60
    L33:
        if (r13.equals("progress") == false) goto L60;
        r15 = 6;
        goto L60
    L37:
        if (r13.equals("translationZ") == false) goto L60;
        r15 = 5;
        goto L60
    L41:
        if (r13.equals("translationY") == false) goto L60;
        r15 = 4;
        goto L60
    L45:
        if (r13.equals("translationX") == false) goto L60;
        r15 = 3;
        goto L60
    L49:
        if (r13.equals("rotationZ") == false) goto L60;
        r15 = 2;
        goto L60
    L53:
        if (r13.equals("rotationY") == false) goto L60;
        r15 = 1;
        goto L60
    L57:
        if (r13.equals("rotationX") == false) goto L60;
        r15 = 0;
        goto L60
    }

    public void applyParameters(MotionWidget r10) {
        this.visibility = r10.getVisibility();
        if (r10.getVisibility() == 4) goto L5;
        float r11 = 0.0f;
    L6:
        this.alpha = r11;
        this.applyElevation = false;
        this.rotation = r10.getRotationZ();
        this.rotationX = r10.getRotationX();
        this.rotationY = r10.getRotationY();
        this.scaleX = r10.getScaleX();
        this.scaleY = r10.getScaleY();
        this.mPivotX = r10.getPivotX();
        this.mPivotY = r10.getPivotY();
        this.translationX = r10.getTranslationX();
        this.translationY = r10.getTranslationY();
        this.translationZ = r10.getTranslationZ();
        Iterator<String> r12 = r10.getCustomAttributeNames().iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        String r13 = r12.next();
        CustomVariable r14 = r10.getCustomAttribute(r13);
        if (r14 == null) goto L8;
        if (r14.isContinuous() == false) goto L8;
        this.mCustomVariable.put(r13, r14);
        goto L8
    L14:
        return;
    L5:
        r11 = r10.getAlpha();
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r10) {
        return Float.compare(this.position, r10.position);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r10) {
        return compareTo2(r10);
    }

    void different(MotionConstrainedPoint r10, HashSet<String> r11) {
        if (diff(this.alpha, r10.alpha) == false) goto L6;
        r11.add("alpha");
    L6:
        if (diff(this.elevation, r10.elevation) == false) goto L8;
        r11.add("translationZ");
    L8:
        int r12 = this.visibility;
        int r13 = r10.visibility;
        if (r12 == r13) goto L17;
        if (this.mVisibilityMode != 0) goto L17;
        if (r12 == 4) goto L15;
        if (r13 != 4) goto L17;
    L15:
        r11.add("alpha");
    L17:
        if (diff(this.rotation, r10.rotation) == false) goto L20;
        r11.add("rotationZ");
    L20:
        if (Float.isNaN(this.mPathRotate) == true) goto L22;
    L23:
        r11.add("pathRotate");
    L25:
        if (Float.isNaN(this.mProgress) == true) goto L27;
    L28:
        r11.add("progress");
    L30:
        if (diff(this.rotationX, r10.rotationX) == false) goto L33;
        r11.add("rotationX");
    L33:
        if (diff(this.rotationY, r10.rotationY) == false) goto L36;
        r11.add("rotationY");
    L36:
        if (diff(this.mPivotX, r10.mPivotX) == false) goto L39;
        r11.add("pivotX");
    L39:
        if (diff(this.mPivotY, r10.mPivotY) == false) goto L42;
        r11.add("pivotY");
    L42:
        if (diff(this.scaleX, r10.scaleX) == false) goto L45;
        r11.add("scaleX");
    L45:
        if (diff(this.scaleY, r10.scaleY) == false) goto L48;
        r11.add("scaleY");
    L48:
        if (diff(this.translationX, r10.translationX) == false) goto L51;
        r11.add("translationX");
    L51:
        if (diff(this.translationY, r10.translationY) == false) goto L54;
        r11.add("translationY");
    L54:
        if (diff(this.translationZ, r10.translationZ) == false) goto L57;
        r11.add("translationZ");
    L57:
        if (diff(this.elevation, r10.elevation) == false) goto L60;
        r11.add("elevation");
        return;
    L60:
        return;
    L27:
        if (Float.isNaN(r10.mProgress) == true) goto L30;
    L22:
        if (Float.isNaN(r10.mPathRotate) == true) goto L25;
        goto L23
    }

    void different(MotionConstrainedPoint r10, boolean[] r11, String[] r12) {
        r11[0] = r11[0] | diff(this.position, r10.position);
        r11[1] = r11[1] | diff(this.f234x, r10.f234x);
        r11[2] = r11[2] | diff(this.f235y, r10.f235y);
        r11[3] = r11[3] | diff(this.width, r10.width);
        boolean r13 = r11[4];
        r11[4] = diff(this.height, r10.height) | r13;
    }

    void fillStandard(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.position, this.f234x, this.f235y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r14 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        if (r11[r12] >= 18) goto L8;
        r10[r14] = r13[r11[r12]];
        r14 = r14 + 1;
    L8:
        r12 = r12 + 1;
        goto L4
    }

    int getCustomData(String r10, double[] r11, int r12) {
        CustomVariable r13 = this.mCustomVariable.get(r10);
        if (r13.numberOfInterpolatedValues() != 1) goto L6;
        r11[r12] = r13.getValueToInterpolate();
        return 1;
    L6:
        int r14 = r13.numberOfInterpolatedValues();
        float[] r15 = new float[r14];
        r13.getValuesToInterpolate(r15);
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r11[r12] = r15[r16];
        r16 = r16 + 1;
        r12 = r12 + 1;
        goto L7
    L9:
        return r14;
    }

    int getCustomDataCount(String r10) {
        return this.mCustomVariable.get(r10).numberOfInterpolatedValues();
    }

    boolean hasCustomData(String r10) {
        return this.mCustomVariable.containsKey(r10);
    }

    void setBounds(float r10, float r11, float r12, float r13) {
        this.f234x = r10;
        this.f235y = r11;
        this.width = r12;
        this.height = r13;
    }

    public void setState(MotionWidget r10) {
        setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        applyParameters(r10);
    }

    public void setState(Rect r10, MotionWidget r11, int r12, float r13) {
        setBounds(r10.left, r10.top, r10.width(), r10.height());
        applyParameters(r11);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (r12 != 1) goto L5;
        float r14 = r13 - 90.0f;
    L9:
        this.rotation = r14;
        return;
    L5:
        if (r12 != 2) goto L11;
        r14 = r13 + 90.0f;
        goto L9
    }
}
