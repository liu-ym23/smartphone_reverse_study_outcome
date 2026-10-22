package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX;
    float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    int mDrawPath;
    int mPathMotionArc;
    float mPercentHeight;
    float mPercentWidth;
    float mPercentX;
    float mPercentY;
    int mPositionType;
    String mTransitionEasing;

    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray r10 = new SparseIntArray();
            mAttrMap = r10;
            r10.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyPosition r10, TypedArray r11) {
            read(r10, r11);
        }

        private static void read(KeyPosition r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L4:
            if (r13 >= r12) goto L35;
            int r14 = r11.getIndex(r13);
            switch(mAttrMap.get(r14)) {
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            Log.e(TypedValues.PositionType.NAME, "unused attribute 0x" + Integer.toHexString(r14) + "   " + mAttrMap.get(r14));
        L33:
            r13 = r13 + 1;
            goto L4
        L8:
            float r15 = r11.getFloat(r14, r10.mPercentHeight);
        L13:
            r10.mPercentHeight = r15;
            goto L33
        L9:
            r10.mPercentWidth = r11.getFloat(r14, r10.mPercentWidth);
            goto L33
        L10:
            r10.mPathMotionArc = r11.getInt(r14, r10.mPathMotionArc);
            goto L33
        L11:
            r10.mPositionType = r11.getInt(r14, r10.mPositionType);
            goto L33
        L12:
            r15 = r11.getFloat(r14, r10.mPercentHeight);
            r10.mPercentWidth = r15;
            goto L13
        L14:
            r10.mPercentY = r11.getFloat(r14, r10.mPercentY);
            goto L33
        L15:
            r10.mPercentX = r11.getFloat(r14, r10.mPercentX);
            goto L33
        L16:
            r10.mDrawPath = r11.getInt(r14, r10.mDrawPath);
            goto L33
        L17:
            r10.mCurveFit = r11.getInteger(r14, r10.mCurveFit);
            goto L33
        L23:
            r10.mFramePosition = r11.getInt(r14, r10.mFramePosition);
            goto L33
        L19:
            if (r11.peekValue(r14).type != 3) goto L21;
            String r16 = r11.getString(r14);
        L22:
            r10.mTransitionEasing = r16;
            goto L33
        L21:
            r16 = Easing.NAMED_EASING[r11.getInteger(r14, 0)];
            goto L22
        L25:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L30;
            int r17 = r11.getResourceId(r14, r10.mTargetId);
            r10.mTargetId = r17;
            if (r17 != (-1)) goto L33;
        L31:
            r10.mTargetString = r11.getString(r14);
            goto L33
        L30:
            if (r11.peekValue(r14).type == 3) goto L31;
            r10.mTargetId = r11.getResourceId(r14, r10.mTargetId);
            goto L33
        L35:
            if (r10.mFramePosition != (-1)) goto L53;
            Log.e(TypedValues.PositionType.NAME, "no frame position");
            return;
        }
    }

    public KeyPosition() {
        this.mTransitionEasing = null;
        this.mPathMotionArc = Key.UNSET;
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

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
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

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo4clone() {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key r10) {
        super.copy(r10);
        KeyPosition r11 = (KeyPosition) r10;
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

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int r10, int r11, RectF r12, RectF r13, float r14, float r15) {
        calcPosition(r10, r11, r12.centerX(), r12.centerY(), r13.centerX(), r13.centerY());
        if (Math.abs(r14 - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r15 - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r10, AttributeSet r11) {
        Loader.access$000(this, r10.obtainStyledAttributes(r11, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16) {
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

    void positionCartAttributes(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
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

    void positionPathAttributes(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
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

    void positionScreenAttributes(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16) {
        r11.centerX();
        r11.centerY();
        r12.centerX();
        r12.centerY();
        ViewGroup r17 = (ViewGroup) r10.getParent();
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

    public void setType(int r10) {
        this.mPositionType = r10;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r12) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.mPercentY = toFloat(r11);
        return;
    L36:
        this.mPercentX = toFloat(r11);
        return;
    L37:
        float r13 = toFloat(r11);
        this.mPercentWidth = r13;
    L40:
        this.mPercentHeight = r13;
        return;
    L38:
        this.mDrawPath = toInt(r11);
        return;
    L39:
        r13 = toFloat(r11);
        goto L40
    L41:
        this.mPercentWidth = toFloat(r11);
        return;
    L42:
        this.mTransitionEasing = r11.toString();
        return;
    L49:
        return;
    L6:
        if (r10.equals("percentY") == false) goto L33;
        r12 = 6;
        goto L33
    L10:
        if (r10.equals("percentX") == false) goto L33;
        r12 = 5;
        goto L33
    L14:
        if (r10.equals("sizePercent") == false) goto L33;
        r12 = 4;
        goto L33
    L18:
        if (r10.equals("drawPath") == false) goto L33;
        r12 = 3;
        goto L33
    L22:
        if (r10.equals("percentHeight") == false) goto L33;
        r12 = 2;
        goto L33
    L26:
        if (r10.equals("percentWidth") == false) goto L33;
        r12 = 1;
        goto L33
    L30:
        if (r10.equals("transitionEasing") == false) goto L33;
        r12 = 0;
        goto L33
    }
}
