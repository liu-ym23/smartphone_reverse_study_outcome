package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    static final int FLAG_SUPPORT_SCROLL_UP = 4;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = null;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = null;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private int mAutoCompleteMode;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    boolean mIsRotateMode;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    float mRotateCenterX;
    float mRotateCenterY;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int[] mTempLoc;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;

    static {
        TOUCH_SIDES = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        TOUCH_DIRECTION = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    TouchResponse(Context r10, MotionLayout r11, XmlPullParser r12) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = r11;
        fillFromAttributeList(r10, Xml.asAttributeSet(r12));
    }

    public TouchResponse(MotionLayout r10, OnSwipe r11) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = r10;
        this.mTouchAnchorId = r11.getTouchAnchorId();
        int r12 = r11.getTouchAnchorSide();
        this.mTouchAnchorSide = r12;
        if (r12 == (-1)) goto L5;
        float[][] r13 = TOUCH_SIDES;
        this.mTouchAnchorX = r13[r12][0];
        this.mTouchAnchorY = r13[r12][1];
    L5:
        int r14 = r11.getDragDirection();
        this.mTouchSide = r14;
        float[][] r15 = TOUCH_DIRECTION;
        if (r14 >= r15.length) goto L8;
        this.mTouchDirectionX = r15[r14][0];
        this.mTouchDirectionY = r15[r14][1];
    L9:
        this.mMaxVelocity = r11.getMaxVelocity();
        this.mMaxAcceleration = r11.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = r11.getMoveWhenScrollAtTop();
        this.mDragScale = r11.getDragScale();
        this.mDragThreshold = r11.getDragThreshold();
        this.mTouchRegionId = r11.getTouchRegionId();
        this.mOnTouchUp = r11.getOnTouchUp();
        this.mFlags = r11.getNestedScrollFlags();
        this.mLimitBoundsTo = r11.getLimitBoundsTo();
        this.mRotationCenterId = r11.getRotationCenterId();
        this.mSpringBoundary = r11.getSpringBoundary();
        this.mSpringDamping = r11.getSpringDamping();
        this.mSpringMass = r11.getSpringMass();
        this.mSpringStiffness = r11.getSpringStiffness();
        this.mSpringStopThreshold = r11.getSpringStopThreshold();
        this.mAutoCompleteMode = r11.getAutoCompleteMode();
        return;
    L8:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L9
    }

    private void fill(TypedArray r10) {
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L65;
        int r13 = r10.getIndex(r12);
        if (r13 != R.styleable.OnSwipe_touchAnchorId) goto L8;
        this.mTouchAnchorId = r10.getResourceId(r13, this.mTouchAnchorId);
    L64:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r13 != R.styleable.OnSwipe_touchAnchorSide) goto L11;
        int r14 = r10.getInt(r13, this.mTouchAnchorSide);
        this.mTouchAnchorSide = r14;
        float[][] r15 = TOUCH_SIDES;
        this.mTouchAnchorX = r15[r14][0];
        this.mTouchAnchorY = r15[r14][1];
        goto L64
    L11:
        if (r13 != R.styleable.OnSwipe_dragDirection) goto L17;
        int r16 = r10.getInt(r13, this.mTouchSide);
        this.mTouchSide = r16;
        float[][] r17 = TOUCH_DIRECTION;
        if (r16 >= r17.length) goto L15;
        this.mTouchDirectionX = r17[r16][0];
        this.mTouchDirectionY = r17[r16][1];
        goto L64
    L15:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L64
    L17:
        if (r13 != R.styleable.OnSwipe_maxVelocity) goto L20;
        this.mMaxVelocity = r10.getFloat(r13, this.mMaxVelocity);
        goto L64
    L20:
        if (r13 != R.styleable.OnSwipe_maxAcceleration) goto L23;
        this.mMaxAcceleration = r10.getFloat(r13, this.mMaxAcceleration);
        goto L64
    L23:
        if (r13 != R.styleable.OnSwipe_moveWhenScrollAtTop) goto L26;
        this.mMoveWhenScrollAtTop = r10.getBoolean(r13, this.mMoveWhenScrollAtTop);
        goto L64
    L26:
        if (r13 != R.styleable.OnSwipe_dragScale) goto L29;
        this.mDragScale = r10.getFloat(r13, this.mDragScale);
        goto L64
    L29:
        if (r13 != R.styleable.OnSwipe_dragThreshold) goto L32;
        this.mDragThreshold = r10.getFloat(r13, this.mDragThreshold);
        goto L64
    L32:
        if (r13 != R.styleable.OnSwipe_touchRegionId) goto L35;
        this.mTouchRegionId = r10.getResourceId(r13, this.mTouchRegionId);
        goto L64
    L35:
        if (r13 != R.styleable.OnSwipe_onTouchUp) goto L38;
        this.mOnTouchUp = r10.getInt(r13, this.mOnTouchUp);
        goto L64
    L38:
        if (r13 != R.styleable.OnSwipe_nestedScrollFlags) goto L41;
        this.mFlags = r10.getInteger(r13, 0);
        goto L64
    L41:
        if (r13 != R.styleable.OnSwipe_limitBoundsTo) goto L44;
        this.mLimitBoundsTo = r10.getResourceId(r13, 0);
        goto L64
    L44:
        if (r13 != R.styleable.OnSwipe_rotationCenterId) goto L47;
        this.mRotationCenterId = r10.getResourceId(r13, this.mRotationCenterId);
        goto L64
    L47:
        if (r13 != R.styleable.OnSwipe_springDamping) goto L50;
        this.mSpringDamping = r10.getFloat(r13, this.mSpringDamping);
        goto L64
    L50:
        if (r13 != R.styleable.OnSwipe_springMass) goto L53;
        this.mSpringMass = r10.getFloat(r13, this.mSpringMass);
        goto L64
    L53:
        if (r13 != R.styleable.OnSwipe_springStiffness) goto L56;
        this.mSpringStiffness = r10.getFloat(r13, this.mSpringStiffness);
        goto L64
    L56:
        if (r13 != R.styleable.OnSwipe_springStopThreshold) goto L59;
        this.mSpringStopThreshold = r10.getFloat(r13, this.mSpringStopThreshold);
        goto L64
    L59:
        if (r13 != R.styleable.OnSwipe_springBoundary) goto L62;
        this.mSpringBoundary = r10.getInt(r13, this.mSpringBoundary);
        goto L64
    L62:
        if (r13 != R.styleable.OnSwipe_autoCompleteMode) goto L64;
        this.mAutoCompleteMode = r10.getInt(r13, this.mAutoCompleteMode);
        goto L64
    }

    private void fillFromAttributeList(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.OnSwipe);
        fill(r12);
        r12.recycle();
    }

    float dot(float r10, float r11) {
        return (r10 * this.mTouchDirectionX) + (r11 * this.mTouchDirectionY);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public int getFlags() {
        return this.mFlags;
    }

    RectF getLimitBoundsTo(ViewGroup r10, RectF r11) {
        int r12 = this.mLimitBoundsTo;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        View r13 = r10.findViewById(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        r11.set(r13.getLeft(), r13.getTop(), r13.getRight(), r13.getBottom());
        return r11;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    float getProgressDirection(float r10, float r11) {
        float r12 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r12, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r13 = this.mTouchDirectionX;
        if (r13 == 0.0f) goto L8;
        float[] r14 = this.mAnchorDpDt;
        if (r14[0] != 0.0f) goto L13;
        r14[0] = 1.0E-7f;
    L13:
        return (r10 * r13) / r14[0];
    L8:
        float[] r15 = this.mAnchorDpDt;
        if (r15[1] != 0.0f) goto L12;
        r15[1] = 1.0E-7f;
    L12:
        return (r11 * this.mTouchDirectionY) / r15[1];
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    RectF getTouchRegion(ViewGroup r10, RectF r11) {
        int r12 = this.mTouchRegionId;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        View r13 = r10.findViewById(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        r11.set(r13.getLeft(), r13.getTop(), r13.getRight(), r13.getBottom());
        return r11;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    boolean isDragStarted() {
        return this.mDragStarted;
    }

    void processTouchEvent(MotionEvent r21, MotionLayout.MotionTracker r22, int r23, MotionScene r24) {
        if (this.mIsRotateMode == false) goto L6;
        processTouchRotateEvent(r21, r22, r23, r24);
        return;
    L6:
        r22.addMovement(r21);
        int r10 = r21.getAction();
        if (r10 != 0) goto L9;
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        this.mDragStarted = false;
        return;
    L9:
        if (r10 != 1) goto L11;
        this.mDragStarted = false;
        r22.computeCurrentVelocity(1000);
        float r11 = r22.getXVelocity();
        float r12 = r22.getYVelocity();
        float r13 = this.mMotionLayout.getProgress();
        int r14 = this.mTouchAnchorId;
        if (r14 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r14, r13, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L59:
        float r15 = this.mTouchDirectionX;
        float[] r16 = this.mAnchorDpDt;
        float r17 = r16[0];
        float r18 = r16[1];
        if (r15 == 0.0f) goto L62;
        float r19 = r11 / r16[0];
    L64:
        if (Float.isNaN(r19) == true) goto L66;
        float r20 = (r19 / 3.0f) + r13;
    L68:
        if (r20 == 0.0f) goto L94;
        if (r20 == 1.0f) goto L94;
        int r25 = this.mOnTouchUp;
        if (r25 == 3) goto L94;
        if (r20 >= 0.5d) goto L76;
        float r26 = 0.0f;
    L77:
        if (r25 != 6) goto L83;
        if ((r13 + r19) >= 0.0f) goto L81;
        r19 = Math.abs(r19);
    L81:
        r26 = 1.0f;
    L83:
        if (this.mOnTouchUp == 7) goto L85;
    L88:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r26, r19);
        if (0.0f < r13) goto L91;
    L97:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L91:
        if (1.0f <= r13) goto L97;
        return;
    L85:
        if ((r13 + r19) <= 1.0f) goto L87;
        r19 = -Math.abs(r19);
    L87:
        r26 = 0.0f;
        goto L88
    L76:
        r26 = 1.0f;
    L94:
        if (0.0f >= r20) goto L97;
        if (1.0f <= r20) goto L97;
        return;
    L66:
        r20 = r13;
        goto L68
    L62:
        r19 = r12 / r16[1];
        goto L64
    L58:
        float r27 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r28 = this.mAnchorDpDt;
        r28[1] = this.mTouchDirectionY * r27;
        r28[0] = r27 * this.mTouchDirectionX;
        goto L59
    L11:
        if (r10 != 2) goto L105;
        float r29 = r21.getRawY() - this.mLastTouchY;
        float r110 = r21.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionX * r110) + (this.mTouchDirectionY * r29)) <= this.mDragThreshold) goto L16;
    L17:
        float r111 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L20;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r111);
    L20:
        int r112 = this.mTouchAnchorId;
        if (r112 == (-1)) goto L23;
        this.mMotionLayout.getAnchorDpDt(r112, r111, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L24:
        float r30 = this.mTouchDirectionX;
        float[] r31 = this.mAnchorDpDt;
        if (Math.abs(((r30 * r31[0]) + (this.mTouchDirectionY * r31[1])) * this.mDragScale) >= 0.01d) goto L28;
        float[] r32 = this.mAnchorDpDt;
        r32[0] = 0.01f;
        r32[1] = 0.01f;
    L28:
        if (this.mTouchDirectionX == 0.0f) goto L30;
        float r113 = r110 / this.mAnchorDpDt[0];
    L31:
        float r33 = Math.max(Math.min(r111 + r113, 1.0f), 0.0f);
        if (this.mOnTouchUp != 6) goto L35;
        r33 = Math.max(r33, 0.01f);
    L35:
        if (this.mOnTouchUp != 7) goto L37;
        r33 = Math.min(r33, 0.99f);
    L37:
        float r34 = this.mMotionLayout.getProgress();
        if (r33 != r34) goto L40;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L54:
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        return;
    L40:
        if (r34 != 0.0f) goto L42;
    L43:
        MotionLayout r35 = this.mMotionLayout;
        if (r34 != 0.0f) goto L46;
        boolean r36 = true;
    L47:
        r35.endTrigger(r36);
    L48:
        this.mMotionLayout.setProgress(r33);
        r22.computeCurrentVelocity(1000);
        float r37 = r22.getXVelocity();
        float r38 = r22.getYVelocity();
        if (this.mTouchDirectionX == 0.0f) goto L51;
        float r39 = r37 / this.mAnchorDpDt[0];
    L52:
        this.mMotionLayout.mLastVelocity = r39;
        goto L54
    L51:
        r39 = r38 / this.mAnchorDpDt[1];
        goto L52
    L46:
        r36 = false;
        goto L47
    L42:
        if (r34 != 1.0f) goto L48;
    L30:
        r113 = r29 / this.mAnchorDpDt[1];
        goto L31
    L23:
        float r40 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r41 = this.mAnchorDpDt;
        r41[1] = this.mTouchDirectionY * r40;
        r41[0] = r40 * this.mTouchDirectionX;
        goto L24
    L16:
        if (this.mDragStarted == true) goto L17;
        return;
    }

    void processTouchRotateEvent(MotionEvent r24, MotionLayout.MotionTracker r25, int r26, MotionScene r27) {
        r25.addMovement(r24);
        int r10 = r24.getAction();
        boolean r11 = false;
        if (r10 != 0) goto L5;
        this.mLastTouchX = r24.getRawX();
        this.mLastTouchY = r24.getRawY();
        this.mDragStarted = false;
        return;
    L5:
        if (r10 != 1) goto L7;
        this.mDragStarted = false;
        r25.computeCurrentVelocity(16);
        float r12 = r25.getXVelocity();
        float r13 = r25.getYVelocity();
        float r14 = this.mMotionLayout.getProgress();
        float r15 = this.mMotionLayout.getWidth() / 2.0f;
        float r16 = this.mMotionLayout.getHeight() / 2.0f;
        int r17 = this.mRotationCenterId;
        if (r17 == (-1)) goto L52;
        View r18 = this.mMotionLayout.findViewById(r17);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r19 = this.mTempLoc[0] + ((r18.getLeft() + r18.getRight()) / 2.0f);
        int r110 = this.mTempLoc[1];
    L51:
        r16 = r110 + ((r18.getTop() + r18.getBottom()) / 2.0f);
        r15 = r19;
    L55:
        float r20 = r24.getRawX() - r15;
        float r21 = r24.getRawY() - r16;
        double r22 = Math.toDegrees(Math.atan2(r21, r20));
        int r111 = this.mTouchAnchorId;
        if (r111 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r111, r14, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r23 = this.mAnchorDpDt;
        r23[1] = (float) Math.toDegrees(r23[1]);
    L59:
        float r28 = ((float) (Math.toDegrees(Math.atan2(r13 + r21, r12 + r20)) - r22)) * 62.5f;
        if (Float.isNaN(r28) == true) goto L62;
        float r29 = (((r28 * 3.0f) * this.mDragScale) / this.mAnchorDpDt[1]) + r14;
    L64:
        if (r29 == 0.0f) goto L91;
        if (r29 == 1.0f) goto L91;
        int r30 = this.mOnTouchUp;
        if (r30 == 3) goto L91;
        float r31 = (r28 * this.mDragScale) / this.mAnchorDpDt[1];
        if (r29 >= 0.5d) goto L72;
        float r32 = 0.0f;
    L74:
        if (r30 != 6) goto L80;
        if ((r14 + r31) >= 0.0f) goto L78;
        r31 = Math.abs(r31);
    L78:
        r32 = 1.0f;
    L80:
        if (this.mOnTouchUp == 7) goto L82;
    L85:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r32, r31 * 3.0f);
        if (0.0f < r14) goto L88;
    L94:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L88:
        if (1.0f <= r14) goto L94;
        return;
    L82:
        if ((r14 + r31) <= 1.0f) goto L84;
        r31 = -Math.abs(r31);
    L84:
        r32 = 0.0f;
        goto L85
    L72:
        r32 = 1.0f;
    L91:
        if (0.0f >= r29) goto L94;
        if (1.0f <= r29) goto L94;
        return;
    L62:
        r29 = r14;
        goto L64
    L58:
        this.mAnchorDpDt[1] = 360.0f;
        goto L59
    L52:
        int r112 = this.mTouchAnchorId;
        if (r112 == (-1)) goto L55;
        r18 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r112).getAnimateRelativeTo());
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r19 = this.mTempLoc[0] + ((r18.getLeft() + r18.getRight()) / 2.0f);
        r110 = this.mTempLoc[1];
        goto L51
    L7:
        if (r10 != 2) goto L102;
        r24.getRawY();
        r24.getRawX();
        float r33 = this.mMotionLayout.getWidth() / 2.0f;
        float r113 = this.mMotionLayout.getHeight() / 2.0f;
        int r114 = this.mRotationCenterId;
        if (r114 == (-1)) goto L12;
        View r34 = this.mMotionLayout.findViewById(r114);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r115 = this.mTempLoc[0] + ((r34.getLeft() + r34.getRight()) / 2.0f);
        r113 = ((r34.getTop() + r34.getBottom()) / 2.0f) + this.mTempLoc[1];
        r33 = r115;
    L18:
        float r35 = r24.getRawX() - r33;
        float r116 = r24.getRawY() - r113;
        double r36 = Math.atan2(r24.getRawY() - r113, r24.getRawX() - r33);
        float r37 = (float) (((r36 - Math.atan2(this.mLastTouchY - r113, this.mLastTouchX - r33)) * 180.0d) / 3.141592653589793d);
        if (r37 <= 330.0f) goto L22;
        r37 = r37 - 360.0f;
    L25:
        if (Math.abs(r37) <= 0.01d) goto L27;
    L28:
        float r38 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L31;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r38);
    L31:
        int r117 = this.mTouchAnchorId;
        if (r117 == (-1)) goto L34;
        this.mMotionLayout.getAnchorDpDt(r117, r38, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r39 = this.mAnchorDpDt;
        r39[1] = (float) Math.toDegrees(r39[1]);
    L35:
        float r40 = Math.max(Math.min(r38 + ((r37 * this.mDragScale) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        float r41 = this.mMotionLayout.getProgress();
        if (r40 != r41) goto L38;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L47:
        this.mLastTouchX = r24.getRawX();
        this.mLastTouchY = r24.getRawY();
        return;
    L38:
        if (r41 != 0.0f) goto L40;
    L41:
        MotionLayout r42 = this.mMotionLayout;
        if (r41 != 0.0f) goto L44;
        r11 = true;
    L44:
        r42.endTrigger(r11);
    L45:
        this.mMotionLayout.setProgress(r40);
        r25.computeCurrentVelocity(1000);
        float r43 = r25.getXVelocity();
        double r44 = r25.getYVelocity();
        double r45 = r43;
        float r46 = (float) ((Math.hypot(r44, r45) * Math.sin(Math.atan2(r44, r45) - r36)) / Math.hypot(r35, r116));
        this.mMotionLayout.mLastVelocity = (float) Math.toDegrees(r46);
        goto L47
    L40:
        if (r41 != 1.0f) goto L45;
    L34:
        this.mAnchorDpDt[1] = 360.0f;
        goto L35
    L27:
        if (this.mDragStarted == true) goto L28;
        return;
    L22:
        if (r37 >= (-330.0f)) goto L25;
        r37 = r37 + 360.0f;
        goto L25
    L12:
        int r118 = this.mTouchAnchorId;
        if (r118 == (-1)) goto L18;
        View r119 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r118).getAnimateRelativeTo());
        if (r119 != null) goto L17;
        Log.e(TAG, "could not find view to animate to");
        goto L18
    L17:
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r33 = this.mTempLoc[0] + ((r119.getLeft() + r119.getRight()) / 2.0f);
        r113 = this.mTempLoc[1] + ((r119.getTop() + r119.getBottom()) / 2.0f);
        goto L18
    }

    void scrollMove(float r10, float r11) {
        float r12 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L5;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r12);
    L5:
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r12, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r13 = this.mTouchDirectionX;
        float[] r14 = this.mAnchorDpDt;
        if (Math.abs((r13 * r14[0]) + (this.mTouchDirectionY * r14[1])) >= 0.01d) goto L8;
        float[] r15 = this.mAnchorDpDt;
        r15[0] = 0.01f;
        r15[1] = 0.01f;
    L8:
        float r16 = this.mTouchDirectionX;
        if (r16 == 0.0f) goto L11;
        float r17 = (r10 * r16) / this.mAnchorDpDt[0];
    L12:
        float r18 = Math.max(Math.min(r12 + r17, 1.0f), 0.0f);
        if (r18 == this.mMotionLayout.getProgress()) goto L16;
        this.mMotionLayout.setProgress(r18);
        return;
    L16:
        return;
    L11:
        r17 = (r11 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        goto L12
    }

    void scrollUp(float r10, float r11) {
        boolean r12 = false;
        this.mDragStarted = false;
        float r13 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r13, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r14 = this.mTouchDirectionX;
        float[] r15 = this.mAnchorDpDt;
        float r16 = r15[0];
        float r17 = this.mTouchDirectionY;
        float r18 = r15[1];
        float r19 = 0.0f;
        if (r14 == 0.0f) goto L5;
        float r20 = (r10 * r14) / r15[0];
    L7:
        if (Float.isNaN(r20) == true) goto L10;
        r13 = r13 + (r20 / 3.0f);
    L10:
        if (r13 != 0.0f) goto L12;
        return;
    L12:
        if (r13 == 1.0f) goto L14;
        boolean r21 = true;
    L15:
        int r22 = this.mOnTouchUp;
        if (r22 == 3) goto L19;
        r12 = true;
    L19:
        if ((r12 & r21) == false) goto L27;
        MotionLayout r23 = this.mMotionLayout;
        if (r13 < 0.5d) goto L24;
        r19 = 1.0f;
    L24:
        r23.touchAnimateTo(r22, r19, r20);
        return;
    L27:
        return;
    L14:
        r21 = false;
        goto L15
    L5:
        r20 = (r11 * r17) / r15[1];
        goto L7
    }

    public void setAnchorId(int r10) {
        this.mTouchAnchorId = r10;
    }

    void setAutoCompleteMode(int r10) {
        this.mAutoCompleteMode = r10;
    }

    void setDown(float r10, float r11) {
        this.mLastTouchX = r10;
        this.mLastTouchY = r11;
    }

    public void setMaxAcceleration(float r10) {
        this.mMaxAcceleration = r10;
    }

    public void setMaxVelocity(float r10) {
        this.mMaxVelocity = r10;
    }

    public void setRTL(boolean r10) {
        if (r10 == false) goto L5;
        float[][] r11 = TOUCH_DIRECTION;
        r11[4] = r11[3];
        r11[5] = r11[2];
        float[][] r12 = TOUCH_SIDES;
        r12[5] = r12[2];
        r12[6] = r12[1];
    L6:
        float[][] r13 = TOUCH_SIDES;
        int r14 = this.mTouchAnchorSide;
        this.mTouchAnchorX = r13[r14][0];
        this.mTouchAnchorY = r13[r14][1];
        int r15 = this.mTouchSide;
        float[][] r16 = TOUCH_DIRECTION;
        if (r15 < r16.length) goto L9;
        return;
    L9:
        this.mTouchDirectionX = r16[r15][0];
        this.mTouchDirectionY = r16[r15][1];
        return;
    L5:
        float[][] r17 = TOUCH_DIRECTION;
        r17[4] = r17[2];
        r17[5] = r17[3];
        float[][] r18 = TOUCH_SIDES;
        r18[5] = r18[1];
        r18[6] = r18[2];
        goto L6
    }

    public void setTouchAnchorLocation(float r10, float r11) {
        this.mTouchAnchorX = r10;
        this.mTouchAnchorY = r11;
    }

    public void setTouchUpMode(int r10) {
        this.mOnTouchUp = r10;
    }

    void setUpTouchEvent(float r10, float r11) {
        this.mLastTouchX = r10;
        this.mLastTouchY = r11;
        this.mDragStarted = false;
    }

    void setupTouch() {
        int r10 = this.mTouchAnchorId;
        if (r10 == (-1)) goto L7;
        View r11 = this.mMotionLayout.findViewById(r10);
        if (r11 != null) goto L9;
        Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
    L9:
        if ((r11 instanceof NestedScrollView) == false) goto L12;
        NestedScrollView r12 = (NestedScrollView) r11;
        r12.setOnTouchListener(new AnonymousClass1(this));
        r12.setOnScrollChangeListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r11 = null;
        goto L9
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX) == false) goto L6;
        return Key.ROTATION;
    L6:
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
