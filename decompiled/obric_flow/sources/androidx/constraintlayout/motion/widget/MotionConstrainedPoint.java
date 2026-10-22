package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
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
    LinkedHashMap<String, ConstraintAttribute> attributes;
    private float elevation;
    private float height;
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
    private float f432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f433y;

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
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float r5, float r10) {
        if (Float.isNaN(r5) == true) goto L12;
        if (Float.isNaN(r10) == true) goto L12;
        if (Math.abs(r5 - r10) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r5) != Float.isNaN(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    public void addValues(HashMap<String, SplineSet> r10, int r11) {
        Iterator<String> r5 = r10.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L145;
        String r12 = r5.next();
        SplineSet r13 = r10.get(r12);
        r12.getClass();
        float r14 = 1.0f;
        float r15 = 0.0f;
        byte r16 = -1;
        switch(r12.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -760884510: goto L29;
            case -760884509: goto L25;
            case -40300674: goto L21;
            case -4379043: goto L17;
            case 37232917: goto L13;
            case 92909918: goto L9;
            default: goto L64;
        };
    L64:
        switch(r16) {
            case 0: goto L141;
            case 1: goto L136;
            case 2: goto L131;
            case 3: goto L126;
            case 4: goto L121;
            case 5: goto L116;
            case 6: goto L111;
            case 7: goto L106;
            case 8: goto L101;
            case 9: goto L96;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L81;
            case 13: goto L76;
            default: goto L66;
        };
    L76:
        if (Float.isNaN(this.alpha) == true) goto L79;
        r14 = this.alpha;
    L79:
        r13.setPoint(r11, r14);
        goto L4
    L81:
        if (Float.isNaN(this.mPathRotate) == true) goto L84;
        r15 = this.mPathRotate;
    L84:
        r13.setPoint(r11, r15);
        goto L4
    L86:
        if (Float.isNaN(this.elevation) == true) goto L89;
        r15 = this.elevation;
    L89:
        r13.setPoint(r11, r15);
        goto L4
    L91:
        if (Float.isNaN(this.rotation) == true) goto L94;
        r15 = this.rotation;
    L94:
        r13.setPoint(r11, r15);
        goto L4
    L96:
        if (Float.isNaN(this.mPivotY) == true) goto L99;
        r15 = this.mPivotY;
    L99:
        r13.setPoint(r11, r15);
        goto L4
    L101:
        if (Float.isNaN(this.mPivotX) == true) goto L104;
        r15 = this.mPivotX;
    L104:
        r13.setPoint(r11, r15);
        goto L4
    L106:
        if (Float.isNaN(this.scaleY) == true) goto L109;
        r14 = this.scaleY;
    L109:
        r13.setPoint(r11, r14);
        goto L4
    L111:
        if (Float.isNaN(this.scaleX) == true) goto L114;
        r14 = this.scaleX;
    L114:
        r13.setPoint(r11, r14);
        goto L4
    L116:
        if (Float.isNaN(this.mProgress) == true) goto L119;
        r15 = this.mProgress;
    L119:
        r13.setPoint(r11, r15);
        goto L4
    L121:
        if (Float.isNaN(this.translationZ) == true) goto L124;
        r15 = this.translationZ;
    L124:
        r13.setPoint(r11, r15);
        goto L4
    L126:
        if (Float.isNaN(this.translationY) == true) goto L129;
        r15 = this.translationY;
    L129:
        r13.setPoint(r11, r15);
        goto L4
    L131:
        if (Float.isNaN(this.translationX) == true) goto L134;
        r15 = this.translationX;
    L134:
        r13.setPoint(r11, r15);
        goto L4
    L136:
        if (Float.isNaN(this.rotationY) == true) goto L139;
        r15 = this.rotationY;
    L139:
        r13.setPoint(r11, r15);
        goto L4
    L141:
        if (Float.isNaN(this.rotationX) == true) goto L144;
        r15 = this.rotationX;
    L144:
        r13.setPoint(r11, r15);
        goto L4
    L66:
        if (r12.startsWith("CUSTOM") == true) goto L67;
        Log.e("MotionPaths", "UNKNOWN spline ".concat(r12));
        goto L4
    L67:
        String r17 = r12.split(",")[1];
        if (this.attributes.containsKey(r17) == true) goto L69;
        Log.e("MotionPaths", "UNKNOWN customName " + r17);
        goto L4
    L69:
        ConstraintAttribute r18 = this.attributes.get(r17);
        if ((r13 instanceof SplineSet.CustomSet) == true) goto L71;
        Log.e("MotionPaths", r12 + " splineSet not a CustomSet frame = " + r11 + ", value" + r18.getValueToInterpolate() + r13);
        goto L4
    L71:
        ((SplineSet.CustomSet) r13).setPoint(r11, r18);
        goto L4
    L9:
        if (r12.equals("alpha") == false) goto L64;
        r16 = 13;
        goto L64
    L13:
        if (r12.equals("transitionPathRotate") == false) goto L64;
        r16 = 12;
        goto L64
    L17:
        if (r12.equals("elevation") == false) goto L64;
        r16 = 11;
        goto L64
    L21:
        if (r12.equals("rotation") == false) goto L64;
        r16 = 10;
        goto L64
    L25:
        if (r12.equals("transformPivotY") == false) goto L64;
        r16 = 9;
        goto L64
    L29:
        if (r12.equals("transformPivotX") == false) goto L64;
        r16 = 8;
        goto L64
    L33:
        if (r12.equals("scaleY") == false) goto L64;
        r16 = 7;
        goto L64
    L37:
        if (r12.equals("scaleX") == false) goto L64;
        r16 = 6;
        goto L64
    L41:
        if (r12.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L64;
        r16 = 5;
        goto L64
    L45:
        if (r12.equals("translationZ") == false) goto L64;
        r16 = 4;
        goto L64
    L49:
        if (r12.equals("translationY") == false) goto L64;
        r16 = 3;
        goto L64
    L53:
        if (r12.equals("translationX") == false) goto L64;
        r16 = 2;
        goto L64
    L57:
        if (r12.equals("rotationY") == false) goto L64;
        r16 = 1;
        goto L64
    L61:
        if (r12.equals("rotationX") == false) goto L64;
        r16 = 0;
        goto L64
    }

    public void applyParameters(View r5) {
        this.visibility = r5.getVisibility();
        if (r5.getVisibility() == 0) goto L5;
        float r10 = 0.0f;
    L6:
        this.alpha = r10;
        this.applyElevation = false;
        this.elevation = r5.getElevation();
        this.rotation = r5.getRotation();
        this.rotationX = r5.getRotationX();
        this.rotationY = r5.getRotationY();
        this.scaleX = r5.getScaleX();
        this.scaleY = r5.getScaleY();
        this.mPivotX = r5.getPivotX();
        this.mPivotY = r5.getPivotY();
        this.translationX = r5.getTranslationX();
        this.translationY = r5.getTranslationY();
        this.translationZ = r5.getTranslationZ();
        return;
    L5:
        r10 = r5.getAlpha();
        goto L6
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r5) {
        return compareTo2(r5);
    }

    public void different(MotionConstrainedPoint r5, HashSet<String> r10) {
        if (diff(this.alpha, r5.alpha) == false) goto L6;
        r10.add("alpha");
    L6:
        if (diff(this.elevation, r5.elevation) == false) goto L8;
        r10.add("elevation");
    L8:
        int r11 = this.visibility;
        int r12 = r5.visibility;
        if (r11 == r12) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r11 == 0) goto L14;
        if (r12 != 0) goto L16;
    L14:
        r10.add("alpha");
    L16:
        if (diff(this.rotation, r5.rotation) == false) goto L19;
        r10.add("rotation");
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        r10.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        r10.add(NotificationCompat.CATEGORY_PROGRESS);
    L29:
        if (diff(this.rotationX, r5.rotationX) == false) goto L32;
        r10.add("rotationX");
    L32:
        if (diff(this.rotationY, r5.rotationY) == false) goto L35;
        r10.add("rotationY");
    L35:
        if (diff(this.mPivotX, r5.mPivotX) == false) goto L38;
        r10.add("transformPivotX");
    L38:
        if (diff(this.mPivotY, r5.mPivotY) == false) goto L41;
        r10.add("transformPivotY");
    L41:
        if (diff(this.scaleX, r5.scaleX) == false) goto L44;
        r10.add("scaleX");
    L44:
        if (diff(this.scaleY, r5.scaleY) == false) goto L47;
        r10.add("scaleY");
    L47:
        if (diff(this.translationX, r5.translationX) == false) goto L50;
        r10.add("translationX");
    L50:
        if (diff(this.translationY, r5.translationY) == false) goto L53;
        r10.add("translationY");
    L53:
        if (diff(this.translationZ, r5.translationZ) == false) goto L56;
        r10.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r5.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(r5.mPathRotate) == true) goto L24;
        goto L22
    }

    public void fillStandard(double[] r21, int[] r22) {
        int r19 = 0;
        float[] r5 = {this.position, this.f432x, this.f433y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r10 = 0;
    L4:
        if (r10 >= r22.length) goto L9;
        int r11 = r22[r10];
        if (r11 >= 18) goto L8;
        r21[r19] = r5[r11];
        r19 = r19 + 1;
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public int getCustomData(String r5, double[] r10, int r11) {
        ConstraintAttribute r12 = this.attributes.get(r5);
        if (r12.noOfInterpValues() != 1) goto L6;
        r10[r11] = r12.getValueToInterpolate();
        return 1;
    L6:
        int r13 = r12.noOfInterpValues();
        float[] r14 = new float[r13];
        r12.getValuesToInterpolate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        r10[r11] = r14[r15];
        r15 = r15 + 1;
        r11 = r11 + 1;
        goto L7
    L9:
        return r13;
    }

    public int getCustomDataCount(String r5) {
        return this.attributes.get(r5).noOfInterpValues();
    }

    public boolean hasCustomData(String r5) {
        return this.attributes.containsKey(r5);
    }

    public void setBounds(float r5, float r10, float r11, float r12) {
        this.f432x = r5;
        this.f433y = r10;
        this.width = r11;
        this.height = r12;
    }

    public void setState(View r5) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r5);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r5) {
        return Float.compare(this.position, r5.position);
    }

    public void setState(ConstraintWidget r5, ConstraintSet r10, int r11) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r10.getParameters(r11));
    }

    public void applyParameters(ConstraintSet.Constraint r10) {
        ConstraintSet.PropertySet r5 = r10.propertySet;
        int r11 = r5.mVisibilityMode;
        this.mVisibilityMode = r11;
        int r12 = r5.visibility;
        this.visibility = r12;
        if (r12 == 0) goto L6;
        if (r11 != 0) goto L6;
        float r13 = 0.0f;
    L7:
        this.alpha = r13;
        ConstraintSet.Transform r14 = r10.transform;
        this.applyElevation = r14.applyElevation;
        this.elevation = r14.elevation;
        this.rotation = r14.rotation;
        this.rotationX = r14.rotationX;
        this.rotationY = r14.rotationY;
        this.scaleX = r14.scaleX;
        this.scaleY = r14.scaleY;
        this.mPivotX = r14.transformPivotX;
        this.mPivotY = r14.transformPivotY;
        this.translationX = r14.translationX;
        this.translationY = r14.translationY;
        this.translationZ = r14.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(r10.motion.mTransitionEasing);
        ConstraintSet.Motion r15 = r10.motion;
        this.mPathRotate = r15.mPathRotate;
        this.mDrawPath = r15.mDrawPath;
        this.mProgress = r10.propertySet.mProgress;
        Iterator<String> r16 = r10.mCustomConstraints.keySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L13;
        String r17 = r16.next();
        ConstraintAttribute r18 = r10.mCustomConstraints.get(r17);
        if (r18.getType() == ConstraintAttribute.AttributeType.STRING_TYPE) goto L9;
        this.attributes.put(r17, r18);
        goto L9
    L13:
        return;
    L6:
        r13 = r5.alpha;
        goto L7
    }

    public void different(MotionConstrainedPoint r5, boolean[] r10, String[] r11) {
        r10[0] = r10[0] | diff(this.position, r5.position);
        r10[1] = r10[1] | diff(this.f432x, r5.f432x);
        r10[2] = r10[2] | diff(this.f433y, r5.f433y);
        r10[3] = r10[3] | diff(this.width, r5.width);
        boolean r12 = r10[4];
        r10[4] = diff(this.height, r5.height) | r12;
    }
}
