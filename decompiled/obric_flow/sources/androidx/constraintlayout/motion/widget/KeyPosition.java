package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
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

    public static class Loader {
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
            SparseIntArray r5 = new SparseIntArray();
            mAttrMap = r5;
            r5.append(R.styleable.KeyPosition_motionTarget, 1);
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

        public static /* synthetic */ void access$000(KeyPosition r5, TypedArray r10) {
            read(r5, r10);
        }

        private static void read(KeyPosition r10, TypedArray r11) {
            int r5 = r11.getIndexCount();
            int r12 = 0;
        L4:
            if (r12 >= r5) goto L33;
            int r13 = r11.getIndex(r12);
            switch(mAttrMap.get(r13)) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r13) + "   " + mAttrMap.get(r13));
        L31:
            r12 = r12 + 1;
            goto L4
        L8:
            r10.mPercentHeight = r11.getFloat(r13, r10.mPercentHeight);
            goto L31
        L9:
            r10.mPercentWidth = r11.getFloat(r13, r10.mPercentWidth);
            goto L31
        L10:
            r10.mPathMotionArc = r11.getInt(r13, r10.mPathMotionArc);
            goto L31
        L11:
            r10.mPositionType = r11.getInt(r13, r10.mPositionType);
            goto L31
        L12:
            float r14 = r11.getFloat(r13, r10.mPercentHeight);
            r10.mPercentWidth = r14;
            r10.mPercentHeight = r14;
            goto L31
        L13:
            r10.mPercentY = r11.getFloat(r13, r10.mPercentY);
            goto L31
        L14:
            r10.mPercentX = r11.getFloat(r13, r10.mPercentX);
            goto L31
        L15:
            r10.mDrawPath = r11.getInt(r13, r10.mDrawPath);
            goto L31
        L16:
            r10.mCurveFit = r11.getInteger(r13, r10.mCurveFit);
            goto L31
        L21:
            r10.mFramePosition = r11.getInt(r13, r10.mFramePosition);
            goto L31
        L18:
            if (r11.peekValue(r13).type != 3) goto L20;
            r10.mTransitionEasing = r11.getString(r13);
            goto L31
        L20:
            r10.mTransitionEasing = Easing.NAMED_EASING[r11.getInteger(r13, 0)];
            goto L31
        L23:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L28;
            int r15 = r11.getResourceId(r13, r10.mTargetId);
            r10.mTargetId = r15;
            if (r15 != (-1)) goto L31;
            r10.mTargetString = r11.getString(r13);
            goto L31
        L28:
            if (r11.peekValue(r13).type != 3) goto L30;
            r10.mTargetString = r11.getString(r13);
            goto L31
        L30:
            r10.mTargetId = r11.getResourceId(r13, r10.mTargetId);
            goto L31
        L33:
            if (r10.mFramePosition != (-1)) goto L54;
            Log.e("KeyPosition", "no frame position");
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
        float r5 = 0.0f;
        if (Float.isNaN(this.mPercentX) == false) goto L5;
        float r16 = 0.0f;
    L7:
        if (Float.isNaN(this.mAltPercentY) == false) goto L9;
        float r17 = 0.0f;
    L11:
        if (Float.isNaN(this.mPercentY) == false) goto L13;
        float r18 = 0.0f;
    L15:
        if (Float.isNaN(this.mAltPercentX) == true) goto L18;
        r5 = this.mAltPercentX;
    L18:
        this.mCalculatedPositionX = (int) ((r5 * r15) + ((r16 * r14) + r10));
        this.mCalculatedPositionY = (int) ((r15 * r18) + ((r14 * r17) + r11));
        return;
    L13:
        r18 = this.mPercentY;
        goto L15
    L9:
        r17 = this.mAltPercentY;
        goto L11
    L5:
        r16 = this.mPercentX;
        goto L7
    }

    private void calcPathPosition(float r5, float r10, float r11, float r12) {
        float r13 = r11 - r5;
        float r14 = r12 - r10;
        float r15 = this.mPercentX;
        float r16 = (r13 * r15) + r5;
        float r17 = this.mPercentY;
        this.mCalculatedPositionX = ((-r14) * r17) + r16;
        float r18 = r13 * r17;
        this.mCalculatedPositionY = r18 + ((r14 * r15) + r10);
    }

    private void calcScreenPosition(int r5, int r10) {
        float r11 = this.mPercentX;
        float r12 = 0;
        this.mCalculatedPositionX = (r5 * r11) + r12;
        this.mCalculatedPositionY = (r10 * r11) + r12;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r5) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int r5, int r10, float r11, float r12, float r13, float r14) {
        int r15 = this.mPositionType;
        if (r15 != 1) goto L5;
        calcPathPosition(r11, r12, r13, r14);
        return;
    L5:
        if (r15 == 2) goto L8;
        calcCartesianPosition(r11, r12, r13, r14);
        return;
    L8:
        calcScreenPosition(r5, r10);
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
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
    public void load(Context r5, AttributeSet r10) {
        Loader.access$000(this, r5.obtainStyledAttributes(r10, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16) {
        int r5 = this.mPositionType;
        if (r5 != 1) goto L5;
        positionPathAttributes(r11, r12, r13, r14, r15, r16);
        return;
    L5:
        if (r5 == 2) goto L8;
        positionCartAttributes(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        positionScreenAttributes(r10, r11, r12, r13, r14, r15, r16);
    }

    public void positionCartAttributes(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
        float r5 = r10.centerX();
        float r16 = r10.centerY();
        float r17 = r11.centerX();
        float r18 = r17 - r5;
        float r19 = r11.centerY() - r16;
        String r20 = r14[0];
        if (r20 != null) goto L5;
        r14[0] = PERCENT_X;
        r15[0] = (r12 - r5) / r18;
        r14[1] = PERCENT_Y;
        r15[1] = (r13 - r16) / r19;
        return;
    L5:
        if (PERCENT_X.equals(r20) == false) goto L7;
        r15[0] = (r12 - r5) / r18;
        r15[1] = (r13 - r16) / r19;
        return;
    L7:
        r15[1] = (r12 - r5) / r18;
        r15[0] = (r13 - r16) / r19;
    }

    public void positionPathAttributes(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
        float r16 = r10.centerX();
        float r17 = r10.centerY();
        float r5 = r11.centerX() - r16;
        float r18 = r11.centerY() - r17;
        float r19 = (float) Math.hypot(r5, r18);
        if (r19 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        r15[0] = 0.0f;
        r15[1] = 0.0f;
        return;
    L6:
        float r20 = r5 / r19;
        float r21 = r18 / r19;
        float r110 = r13 - r17;
        float r22 = r12 - r16;
        float r23 = ((r20 * r110) - (r22 * r21)) / r19;
        float r24 = ((r21 * r110) + (r20 * r22)) / r19;
        String r25 = r14[0];
        if (r25 != null) goto L9;
        r14[0] = PERCENT_X;
        r14[1] = PERCENT_Y;
        r15[0] = r24;
        r15[1] = r23;
        return;
    L9:
        if (PERCENT_X.equals(r25) == false) goto L13;
        r15[0] = r24;
        r15[1] = r23;
        return;
    }

    public void positionScreenAttributes(View r5, RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
        r10.centerX();
        r10.centerY();
        r11.centerX();
        r11.centerY();
        ViewGroup r16 = (ViewGroup) r5.getParent();
        int r17 = r16.getWidth();
        int r18 = r16.getHeight();
        String r19 = r14[0];
        if (r19 != null) goto L5;
        r14[0] = PERCENT_X;
        r15[0] = r12 / r17;
        r14[1] = PERCENT_Y;
        r15[1] = r13 / r18;
        return;
    L5:
        if (PERCENT_X.equals(r19) == false) goto L7;
        r15[0] = r12 / r17;
        r15[1] = r13 / r18;
        return;
    L7:
        r15[1] = r12 / r17;
        r15[0] = r13 / r18;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r5, Object r10) {
        r5.getClass();
        byte r11 = -1;
        switch(r5.hashCode()) {
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
        switch(r11) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.mPercentY = toFloat(r10);
        return;
    L36:
        this.mPercentX = toFloat(r10);
        return;
    L37:
        float r12 = toFloat(r10);
        this.mPercentWidth = r12;
        this.mPercentHeight = r12;
        return;
    L38:
        this.mDrawPath = toInt(r10);
        return;
    L39:
        this.mPercentHeight = toFloat(r10);
        return;
    L40:
        this.mPercentWidth = toFloat(r10);
        return;
    L41:
        this.mTransitionEasing = r10.toString();
        return;
    L49:
        return;
    L6:
        if (r5.equals(PERCENT_Y) == false) goto L33;
        r11 = 6;
        goto L33
    L10:
        if (r5.equals(PERCENT_X) == false) goto L33;
        r11 = 5;
        goto L33
    L14:
        if (r5.equals("sizePercent") == false) goto L33;
        r11 = 4;
        goto L33
    L18:
        if (r5.equals("drawPath") == false) goto L33;
        r11 = 3;
        goto L33
    L22:
        if (r5.equals("percentHeight") == false) goto L33;
        r11 = 2;
        goto L33
    L26:
        if (r5.equals("percentWidth") == false) goto L33;
        r11 = 1;
        goto L33
    L30:
        if (r5.equals("transitionEasing") == false) goto L33;
        r11 = 0;
        goto L33
    }
}
