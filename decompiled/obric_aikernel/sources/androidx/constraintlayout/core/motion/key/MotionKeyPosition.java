package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int r10 = MotionKey.UNSET;
        this.mCurveFit = r10;
        this.mTransitionEasing = null;
        this.mPathMotionArc = r10;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = 0.0f;
        if (Float.isNaN(this.mPercentX) == false) goto L5;
        float r17 = 0.0f;
    L7:
        if (Float.isNaN(this.mAltPercentY) == false) goto L9;
        float r18 = 0.0f;
    L11:
        if (Float.isNaN(this.mPercentY) == false) goto L13;
        float r19 = 0.0f;
    L15:
        if (Float.isNaN(this.mAltPercentX) == true) goto L18;
        r16 = this.mAltPercentX;
    L18:
        this.mCalculatedPositionX = (int) ((r10 + (r17 * r14)) + (r16 * r15));
        this.mCalculatedPositionY = (int) ((r11 + (r14 * r18)) + (r15 * r19));
        return;
    L13:
        r19 = this.mPercentY;
        goto L15
    L9:
        r18 = this.mAltPercentY;
        goto L11
    L5:
        r17 = this.mPercentX;
        goto L7
    }

    private void calcPathPosition(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = this.mPercentX;
        float r17 = r10 + (r14 * r16);
        float r18 = this.mPercentY;
        this.mCalculatedPositionX = r17 + ((-r15) * r18);
        this.mCalculatedPositionY = (r11 + (r15 * r16)) + (r14 * r18);
    }

    private void calcScreenPosition(int r10, int r11) {
        float r12 = this.mPercentX;
        float r13 = 0;
        this.mCalculatedPositionX = ((r10 - 0) * r12) + r13;
        this.mCalculatedPositionY = ((r11 - 0) * r12) + r13;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r10) {
    }

    void calcPosition(int r10, int r11, float r12, float r13, float r14, float r15) {
        int r16 = this.mPositionType;
        if (r16 != 1) goto L5;
        calcPathPosition(r12, r13, r14, r15);
        return;
    L5:
        if (r16 == 2) goto L8;
        calcCartesianPosition(r12, r13, r14, r15);
        return;
    L8:
        calcScreenPosition(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey r10) {
        super.copy(r10);
        MotionKeyPosition r11 = (MotionKeyPosition) r10;
        this.mTransitionEasing = r11.mTransitionEasing;
        this.mPathMotionArc = r11.mPathMotionArc;
        this.mDrawPath = r11.mDrawPath;
        this.mPercentWidth = r11.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = r11.mPercentX;
        this.mPercentY = r11.mPercentY;
        this.mAltPercentX = r11.mAltPercentX;
        this.mAltPercentY = r11.mAltPercentY;
        this.mCalculatedPositionX = r11.mCalculatedPositionX;
        this.mCalculatedPositionY = r11.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r10) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        return TypedValues.PositionType.getId(r10);
    }

    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int r10, int r11, FloatRect r12, FloatRect r13, float r14, float r15) {
        calcPosition(r10, r11, r12.centerX(), r12.centerY(), r13.centerX(), r13.centerY());
        if (Math.abs(r14 - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r15 - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    public void positionAttributes(MotionWidget r10, FloatRect r11, FloatRect r12, float r13, float r14, String[] r15, float[] r16) {
        int r17 = this.mPositionType;
        if (r17 != 1) goto L5;
        positionPathAttributes(r11, r12, r13, r14, r15, r16);
        return;
    L5:
        if (r17 == 2) goto L8;
        positionCartAttributes(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        positionScreenAttributes(r10, r11, r12, r13, r14, r15, r16);
    }

    void positionCartAttributes(FloatRect r10, FloatRect r11, float r12, float r13, String[] r14, float[] r15) {
        float r16 = r10.centerX();
        float r17 = r10.centerY();
        float r18 = r11.centerX();
        float r19 = r18 - r16;
        float r20 = r11.centerY() - r17;
        if (r14[0] == null) goto L8;
        float r21 = (r12 - r16) / r19;
        if ("percentX".equals(r14[0]) == false) goto L7;
        r15[0] = r21;
        r15[1] = (r13 - r17) / r20;
        return;
    L7:
        r15[1] = r21;
        r15[0] = (r13 - r17) / r20;
        return;
    L8:
        r14[0] = "percentX";
        r15[0] = (r12 - r16) / r19;
        r14[1] = "percentY";
        r15[1] = (r13 - r17) / r20;
    }

    void positionPathAttributes(FloatRect r10, FloatRect r11, float r12, float r13, String[] r14, float[] r15) {
        float r16 = r10.centerX();
        float r17 = r10.centerY();
        float r18 = r11.centerX() - r16;
        float r19 = r11.centerY() - r17;
        float r20 = (float) Math.hypot(r18, r19);
        if (r20 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        r15[0] = 0.0f;
        r15[1] = 0.0f;
        return;
    L6:
        float r21 = r18 / r20;
        float r22 = r19 / r20;
        float r110 = r13 - r17;
        float r23 = r12 - r16;
        float r24 = ((r21 * r110) - (r23 * r22)) / r20;
        float r25 = ((r21 * r23) + (r22 * r110)) / r20;
        if (r14[0] != null) goto L9;
        r14[0] = "percentX";
        r14[1] = "percentY";
        r15[0] = r25;
        r15[1] = r24;
        return;
    L9:
        if ("percentX".equals(r14[0]) == false) goto L13;
        r15[0] = r25;
        r15[1] = r24;
        return;
    }

    void positionScreenAttributes(MotionWidget r10, FloatRect r11, FloatRect r12, float r13, float r14, String[] r15, float[] r16) {
        r11.centerX();
        r11.centerY();
        r12.centerX();
        r12.centerY();
        MotionWidget r17 = r10.getParent();
        int r18 = r17.getWidth();
        int r19 = r17.getHeight();
        if (r15[0] == null) goto L8;
        float r20 = r13 / r18;
        if ("percentX".equals(r15[0]) == false) goto L7;
        r16[0] = r20;
        r16[1] = r14 / r19;
        return;
    L7:
        r16[1] = r20;
        r16[0] = r14 / r19;
        return;
    L8:
        r15[0] = "percentX";
        r16[0] = r13 / r18;
        r15[1] = "percentY";
        r16[1] = r14 / r19;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        switch(r10) {
            case 503: goto L9;
            case 504: goto L8;
            case 505: goto L7;
            case 506: goto L6;
            case 507: goto L5;
            default: goto L4;
        };
    L5:
        this.mPercentY = r11;
        return true;
    L6:
        this.mPercentX = r11;
        return true;
    L7:
        this.mPercentWidth = r11;
    L8:
        this.mPercentHeight = r11;
        return true;
    L9:
        this.mPercentWidth = r11;
        return true;
    L4:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 100) goto L5;
        this.mFramePosition = r11;
        return true;
    L5:
        if (r10 != 508) goto L7;
        this.mCurveFit = r11;
        return true;
    L7:
        if (r10 != 510) goto L9;
        this.mPositionType = r11;
        return true;
    L9:
        return super.setValue(r10, r11);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (r10 != 501) goto L5;
        this.mTransitionEasing = r11.toString();
        return true;
    L5:
        return super.setValue(r10, r11);
    }
}
