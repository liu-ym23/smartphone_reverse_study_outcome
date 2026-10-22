package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
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
    private int mAnimateRelativeTo;
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
    private float f257x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f258y;

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
        this.attributes = new LinkedHashMap();
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

    public void addValues(HashMap<String, ViewSpline> r10, int r11) {
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L134;
        String r13 = r12.next();
        ViewSpline r14 = r10.get(r13);
        r13.hashCode();
        byte r15 = -1;
        switch(r13.hashCode()) {
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
        float r16 = 1.0f;
        float r17 = 0.0f;
        switch(r15) {
            case 0: goto L131;
            case 1: goto L127;
            case 2: goto L123;
            case 3: goto L119;
            case 4: goto L115;
            case 5: goto L111;
            case 6: goto L107;
            case 7: goto L103;
            case 8: goto L99;
            case 9: goto L95;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L82;
            case 13: goto L77;
            default: goto L67;
        };
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r16 = this.alpha;
    L80:
        r14.setPoint(r11, r16);
        goto L4
    L82:
        if (Float.isNaN(this.mPathRotate) == true) goto L89;
        r17 = this.mPathRotate;
    L89:
        r14.setPoint(r11, r17);
        goto L4
    L86:
        if (Float.isNaN(this.elevation) == true) goto L89;
        r17 = this.elevation;
        goto L89
    L91:
        if (Float.isNaN(this.rotation) == true) goto L89;
        r17 = this.rotation;
        goto L89
    L95:
        if (Float.isNaN(this.mPivotY) == true) goto L89;
        r17 = this.mPivotY;
        goto L89
    L99:
        if (Float.isNaN(this.mPivotX) == true) goto L89;
        r17 = this.mPivotX;
        goto L89
    L103:
        if (Float.isNaN(this.scaleY) == true) goto L80;
        r16 = this.scaleY;
        goto L80
    L107:
        if (Float.isNaN(this.scaleX) == true) goto L80;
        r16 = this.scaleX;
        goto L80
    L111:
        if (Float.isNaN(this.mProgress) == true) goto L89;
        r17 = this.mProgress;
        goto L89
    L115:
        if (Float.isNaN(this.translationZ) == true) goto L89;
        r17 = this.translationZ;
        goto L89
    L119:
        if (Float.isNaN(this.translationY) == true) goto L89;
        r17 = this.translationY;
        goto L89
    L123:
        if (Float.isNaN(this.translationX) == true) goto L89;
        r17 = this.translationX;
        goto L89
    L127:
        if (Float.isNaN(this.rotationY) == true) goto L89;
        r17 = this.rotationY;
        goto L89
    L131:
        if (Float.isNaN(this.rotationX) == true) goto L89;
        r17 = this.rotationX;
        goto L89
    L67:
        if (r13.startsWith("CUSTOM") == false) goto L75;
        String r18 = r13.split(",")[1];
        if (this.attributes.containsKey(r18) == false) goto L4;
        ConstraintAttribute r19 = this.attributes.get(r18);
        if ((r14 instanceof ViewSpline.CustomSet) == true) goto L72;
        String r20 = r13 + " ViewSpline not a CustomSet frame = " + r11 + ", value" + r19.getValueToInterpolate() + r14;
    L74:
        Log.e("MotionPaths", r20);
        goto L4
    L72:
        ((ViewSpline.CustomSet) r14).setPoint(r11, r19);
        goto L4
    L75:
        r20 = "UNKNOWN spline " + r13;
        goto L74
    L9:
        if (r13.equals("alpha") == false) goto L64;
        r15 = 13;
        goto L64
    L13:
        if (r13.equals("transitionPathRotate") == false) goto L64;
        r15 = 12;
        goto L64
    L17:
        if (r13.equals("elevation") == false) goto L64;
        r15 = 11;
        goto L64
    L21:
        if (r13.equals(Key.ROTATION) == false) goto L64;
        r15 = 10;
        goto L64
    L25:
        if (r13.equals(Key.PIVOT_Y) == false) goto L64;
        r15 = 9;
        goto L64
    L29:
        if (r13.equals(Key.PIVOT_X) == false) goto L64;
        r15 = 8;
        goto L64
    L33:
        if (r13.equals("scaleY") == false) goto L64;
        r15 = 7;
        goto L64
    L37:
        if (r13.equals("scaleX") == false) goto L64;
        r15 = 6;
        goto L64
    L41:
        if (r13.equals("progress") == false) goto L64;
        r15 = 5;
        goto L64
    L45:
        if (r13.equals("translationZ") == false) goto L64;
        r15 = 4;
        goto L64
    L49:
        if (r13.equals("translationY") == false) goto L64;
        r15 = 3;
        goto L64
    L53:
        if (r13.equals("translationX") == false) goto L64;
        r15 = 2;
        goto L64
    L57:
        if (r13.equals("rotationY") == false) goto L64;
        r15 = 1;
        goto L64
    L61:
        if (r13.equals("rotationX") == false) goto L64;
        r15 = 0;
        goto L64
    }

    public void applyParameters(View r10) {
        this.visibility = r10.getVisibility();
        if (r10.getVisibility() == 0) goto L5;
        float r11 = 0.0f;
    L6:
        this.alpha = r11;
        this.applyElevation = false;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L9;
        this.elevation = r10.getElevation();
    L9:
        this.rotation = r10.getRotation();
        this.rotationX = r10.getRotationX();
        this.rotationY = r10.getRotationY();
        this.scaleX = r10.getScaleX();
        this.scaleY = r10.getScaleY();
        this.mPivotX = r10.getPivotX();
        this.mPivotY = r10.getPivotY();
        this.translationX = r10.getTranslationX();
        this.translationY = r10.getTranslationY();
        if (r12 < 21) goto L13;
        this.translationZ = r10.getTranslationZ();
        return;
    L13:
        return;
    L5:
        r11 = r10.getAlpha();
        goto L6
    }

    public void applyParameters(ConstraintSet.Constraint r10) {
        ConstraintSet.PropertySet r11 = r10.propertySet;
        int r12 = r11.mVisibilityMode;
        this.mVisibilityMode = r12;
        int r13 = r11.visibility;
        this.visibility = r13;
        if (r13 == 0) goto L6;
        if (r12 != 0) goto L6;
        float r14 = 0.0f;
    L7:
        this.alpha = r14;
        ConstraintSet.Transform r15 = r10.transform;
        this.applyElevation = r15.applyElevation;
        this.elevation = r15.elevation;
        this.rotation = r15.rotation;
        this.rotationX = r15.rotationX;
        this.rotationY = r15.rotationY;
        this.scaleX = r15.scaleX;
        this.scaleY = r15.scaleY;
        this.mPivotX = r15.transformPivotX;
        this.mPivotY = r15.transformPivotY;
        this.translationX = r15.translationX;
        this.translationY = r15.translationY;
        this.translationZ = r15.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(r10.motion.mTransitionEasing);
        ConstraintSet.Motion r16 = r10.motion;
        this.mPathRotate = r16.mPathRotate;
        this.mDrawPath = r16.mDrawPath;
        this.mAnimateRelativeTo = r16.mAnimateRelativeTo;
        this.mProgress = r10.propertySet.mProgress;
        Iterator<String> r17 = r10.mCustomConstraints.keySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L13;
        String r18 = r17.next();
        ConstraintAttribute r19 = r10.mCustomConstraints.get(r18);
        if (r19.isContinuous() == false) goto L9;
        this.attributes.put(r18, r19);
        goto L9
    L13:
        return;
    L6:
        r14 = r11.alpha;
        goto L7
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
        r11.add("elevation");
    L8:
        int r12 = this.visibility;
        int r13 = r10.visibility;
        if (r12 == r13) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r12 == 0) goto L14;
        if (r13 != 0) goto L16;
    L14:
        r11.add("alpha");
    L16:
        if (diff(this.rotation, r10.rotation) == false) goto L19;
        r11.add(Key.ROTATION);
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        r11.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        r11.add("progress");
    L29:
        if (diff(this.rotationX, r10.rotationX) == false) goto L32;
        r11.add("rotationX");
    L32:
        if (diff(this.rotationY, r10.rotationY) == false) goto L35;
        r11.add("rotationY");
    L35:
        if (diff(this.mPivotX, r10.mPivotX) == false) goto L38;
        r11.add(Key.PIVOT_X);
    L38:
        if (diff(this.mPivotY, r10.mPivotY) == false) goto L41;
        r11.add(Key.PIVOT_Y);
    L41:
        if (diff(this.scaleX, r10.scaleX) == false) goto L44;
        r11.add("scaleX");
    L44:
        if (diff(this.scaleY, r10.scaleY) == false) goto L47;
        r11.add("scaleY");
    L47:
        if (diff(this.translationX, r10.translationX) == false) goto L50;
        r11.add("translationX");
    L50:
        if (diff(this.translationY, r10.translationY) == false) goto L53;
        r11.add("translationY");
    L53:
        if (diff(this.translationZ, r10.translationZ) == false) goto L56;
        r11.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r10.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(r10.mPathRotate) == true) goto L24;
        goto L22
    }

    void different(MotionConstrainedPoint r10, boolean[] r11, String[] r12) {
        r11[0] = r11[0] | diff(this.position, r10.position);
        r11[1] = r11[1] | diff(this.f257x, r10.f257x);
        r11[2] = r11[2] | diff(this.f258y, r10.f258y);
        r11[3] = r11[3] | diff(this.width, r10.width);
        boolean r13 = r11[4];
        r11[4] = diff(this.height, r10.height) | r13;
    }

    void fillStandard(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.position, this.f257x, this.f258y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
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
        ConstraintAttribute r13 = this.attributes.get(r10);
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
        return this.attributes.get(r10).numberOfInterpolatedValues();
    }

    boolean hasCustomData(String r10) {
        return this.attributes.containsKey(r10);
    }

    void setBounds(float r10, float r11, float r12, float r13) {
        this.f257x = r10;
        this.f258y = r11;
        this.width = r12;
        this.height = r13;
    }

    public void setState(Rect r10, View r11, int r12, float r13) {
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

    public void setState(Rect r10, ConstraintSet r11, int r12, int r13) {
        setBounds(r10.left, r10.top, r10.width(), r10.height());
        applyParameters(r11.getParameters(r13));
        float r14 = 90.0f;
        if (r12 != 1) goto L5;
    L14:
        float r15 = this.rotation;
    L15:
        this.rotation = r15 - r14;
        return;
    L5:
        if (r12 != 2) goto L7;
    L11:
        r15 = this.rotation + 90.0f;
        this.rotation = r15;
        if (r15 <= 180.0f) goto L17;
        r14 = 360.0f;
        goto L15
    L17:
        return;
    L7:
        if (r12 == 3) goto L14;
        if (r12 == 4) goto L11;
    }

    public void setState(View r10) {
        setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        applyParameters(r10);
    }
}
