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
import androidx.core.widget.NestedScrollView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    TouchResponse(Context r5, MotionLayout r6, XmlPullParser r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.memorydata.plugin");
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
        this.mMotionLayout = r6;
        fillFromAttributeList(r8, Xml.asAttributeSet(r9));
    }

    public TouchResponse(MotionLayout r6, OnSwipe r7) {
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
        this.mMotionLayout = r6;
        this.mTouchAnchorId = r7.getTouchAnchorId();
        int r8 = r7.getTouchAnchorSide();
        this.mTouchAnchorSide = r8;
        if (r8 == (-1)) goto L5;
        float[][] r1 = TOUCH_SIDES;
        this.mTouchAnchorX = r1[r8][0];
        this.mTouchAnchorY = r1[r8][1];
    L5:
        int r9 = r7.getDragDirection();
        this.mTouchSide = r9;
        float[][] r2 = TOUCH_DIRECTION;
        if (r9 >= r2.length) goto L8;
        this.mTouchDirectionX = r2[r9][0];
        this.mTouchDirectionY = r2[r9][1];
    L9:
        this.mMaxVelocity = r7.getMaxVelocity();
        this.mMaxAcceleration = r7.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = r7.getMoveWhenScrollAtTop();
        this.mDragScale = r7.getDragScale();
        this.mDragThreshold = r7.getDragThreshold();
        this.mTouchRegionId = r7.getTouchRegionId();
        this.mOnTouchUp = r7.getOnTouchUp();
        this.mFlags = r7.getNestedScrollFlags();
        this.mLimitBoundsTo = r7.getLimitBoundsTo();
        this.mRotationCenterId = r7.getRotationCenterId();
        this.mSpringBoundary = r7.getSpringBoundary();
        this.mSpringDamping = r7.getSpringDamping();
        this.mSpringMass = r7.getSpringMass();
        this.mSpringStiffness = r7.getSpringStiffness();
        this.mSpringStopThreshold = r7.getSpringStopThreshold();
        this.mAutoCompleteMode = r7.getAutoCompleteMode();
        return;
    L8:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L9
    }

    private void fill(TypedArray r9) {
        int r0 = r9.getIndexCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L65;
        int r3 = r9.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchAnchorId, "styleable", "OnSwipe_touchAnchorId")) goto L8;
        this.mTouchAnchorId = r9.getResourceId(r3, this.mTouchAnchorId);
    L64:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchAnchorSide, "styleable", "OnSwipe_touchAnchorSide")) goto L11;
        int r4 = r9.getInt(r3, this.mTouchAnchorSide);
        this.mTouchAnchorSide = r4;
        float[][] r5 = TOUCH_SIDES;
        this.mTouchAnchorX = r5[r4][0];
        this.mTouchAnchorY = r5[r4][1];
        goto L64
    L11:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragDirection, "styleable", "OnSwipe_dragDirection")) goto L17;
        int r6 = r9.getInt(r3, this.mTouchSide);
        this.mTouchSide = r6;
        float[][] r7 = TOUCH_DIRECTION;
        if (r6 >= r7.length) goto L15;
        this.mTouchDirectionX = r7[r6][0];
        this.mTouchDirectionY = r7[r6][1];
        goto L64
    L15:
        this.mTouchDirectionY = Float.NaN;
        this.mTouchDirectionX = Float.NaN;
        this.mIsRotateMode = true;
        goto L64
    L17:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_maxVelocity, "styleable", "OnSwipe_maxVelocity")) goto L20;
        this.mMaxVelocity = r9.getFloat(r3, this.mMaxVelocity);
        goto L64
    L20:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_maxAcceleration, "styleable", "OnSwipe_maxAcceleration")) goto L23;
        this.mMaxAcceleration = r9.getFloat(r3, this.mMaxAcceleration);
        goto L64
    L23:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_moveWhenScrollAtTop, "styleable", "OnSwipe_moveWhenScrollAtTop")) goto L26;
        this.mMoveWhenScrollAtTop = r9.getBoolean(r3, this.mMoveWhenScrollAtTop);
        goto L64
    L26:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragScale, "styleable", "OnSwipe_dragScale")) goto L29;
        this.mDragScale = r9.getFloat(r3, this.mDragScale);
        goto L64
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragThreshold, "styleable", "OnSwipe_dragThreshold")) goto L32;
        this.mDragThreshold = r9.getFloat(r3, this.mDragThreshold);
        goto L64
    L32:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchRegionId, "styleable", "OnSwipe_touchRegionId")) goto L35;
        this.mTouchRegionId = r9.getResourceId(r3, this.mTouchRegionId);
        goto L64
    L35:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_onTouchUp, "styleable", "OnSwipe_onTouchUp")) goto L38;
        this.mOnTouchUp = r9.getInt(r3, this.mOnTouchUp);
        goto L64
    L38:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_nestedScrollFlags, "styleable", "OnSwipe_nestedScrollFlags")) goto L41;
        this.mFlags = r9.getInteger(r3, 0);
        goto L64
    L41:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_limitBoundsTo, "styleable", "OnSwipe_limitBoundsTo")) goto L44;
        this.mLimitBoundsTo = r9.getResourceId(r3, 0);
        goto L64
    L44:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_rotationCenterId, "styleable", "OnSwipe_rotationCenterId")) goto L47;
        this.mRotationCenterId = r9.getResourceId(r3, this.mRotationCenterId);
        goto L64
    L47:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springDamping, "styleable", "OnSwipe_springDamping")) goto L50;
        this.mSpringDamping = r9.getFloat(r3, this.mSpringDamping);
        goto L64
    L50:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springMass, "styleable", "OnSwipe_springMass")) goto L53;
        this.mSpringMass = r9.getFloat(r3, this.mSpringMass);
        goto L64
    L53:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springStiffness, "styleable", "OnSwipe_springStiffness")) goto L56;
        this.mSpringStiffness = r9.getFloat(r3, this.mSpringStiffness);
        goto L64
    L56:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springStopThreshold, "styleable", "OnSwipe_springStopThreshold")) goto L59;
        this.mSpringStopThreshold = r9.getFloat(r3, this.mSpringStopThreshold);
        goto L64
    L59:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springBoundary, "styleable", "OnSwipe_springBoundary")) goto L62;
        this.mSpringBoundary = r9.getInt(r3, this.mSpringBoundary);
        goto L64
    L62:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_autoCompleteMode, "styleable", "OnSwipe_autoCompleteMode")) goto L64;
        this.mAutoCompleteMode = r9.getInt(r3, this.mAutoCompleteMode);
        goto L64
    }

    private void fillFromAttributeList(Context r3, AttributeSet r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OnSwipe);
        fill(r5);
        r5.recycle();
    }

    float dot(float r2, float r3) {
        return (r2 * this.mTouchDirectionX) + (r3 * this.mTouchDirectionY);
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

    RectF getLimitBoundsTo(ViewGroup r3, RectF r4) {
        int r2 = this.mLimitBoundsTo;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r5 = r3.findViewById(r2);
        if (r5 != null) goto L8;
        return null;
    L8:
        r4.set(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
        return r4;
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

    float getProgressDirection(float r8, float r9) {
        float r3 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r0 = this.mTouchDirectionX;
        if (r0 == 0.0f) goto L8;
        float[] r7 = this.mAnchorDpDt;
        if (r7[0] != 0.0f) goto L13;
        r7[0] = 1.0E-7f;
    L13:
        return (r8 * r0) / r7[0];
    L8:
        float[] r10 = this.mAnchorDpDt;
        if (r10[1] != 0.0f) goto L12;
        r10[1] = 1.0E-7f;
    L12:
        return (r9 * this.mTouchDirectionY) / r10[1];
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

    RectF getTouchRegion(ViewGroup r3, RectF r4) {
        int r2 = this.mTouchRegionId;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r5 = r3.findViewById(r2);
        if (r5 != null) goto L8;
        return null;
    L8:
        r4.set(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
        return r4;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    boolean isDragStarted() {
        return this.mDragStarted;
    }

    void processTouchEvent(MotionEvent r21, MotionLayout.MotionTracker r22, int r23, MotionScene r24) {
        MotionLayout.MotionTracker r2 = (MotionLayout.MotionTracker) ZeusTransformUtils.wrapperContextForParams(r22, MotionLayout.MotionTracker.class, "com.obric.memorydata.plugin");
        if (this.mIsRotateMode == false) goto L6;
        processTouchRotateEvent(r21, r2, r23, r24);
        return;
    L6:
        r2.addMovement(r21);
        int r3 = r21.getAction();
        if (r3 != 0) goto L9;
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        this.mDragStarted = false;
        return;
    L9:
        if (r3 != 1) goto L11;
        this.mDragStarted = false;
        r2.computeCurrentVelocity(1000);
        float r1 = r2.getXVelocity();
        float r4 = r2.getYVelocity();
        float r5 = this.mMotionLayout.getProgress();
        int r13 = this.mTouchAnchorId;
        if (r13 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r13, r5, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L59:
        float r6 = this.mTouchDirectionX;
        float[] r7 = this.mAnchorDpDt;
        float r8 = r7[0];
        float r9 = r7[1];
        if (r6 == 0.0f) goto L62;
        float r10 = r1 / r7[0];
    L64:
        if (Float.isNaN(r10) == true) goto L66;
        float r11 = (r10 / 3.0f) + r5;
    L68:
        if (r11 == 0.0f) goto L94;
        if (r11 == 1.0f) goto L94;
        int r12 = this.mOnTouchUp;
        if (r12 == 3) goto L94;
        if (r11 >= 0.5d) goto L76;
        float r14 = 0.0f;
    L77:
        if (r12 != 6) goto L83;
        if ((r5 + r10) >= 0.0f) goto L81;
        r10 = Math.abs(r10);
    L81:
        r14 = 1.0f;
    L83:
        if (this.mOnTouchUp == 7) goto L85;
    L88:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r14, r10);
        if (0.0f < r5) goto L91;
    L97:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L91:
        if (1.0f <= r5) goto L97;
        return;
    L85:
        if ((r5 + r10) <= 1.0f) goto L87;
        r10 = -Math.abs(r10);
    L87:
        r14 = 0.0f;
        goto L88
    L76:
        r14 = 1.0f;
    L94:
        if (0.0f >= r11) goto L97;
        if (1.0f <= r11) goto L97;
        return;
    L66:
        r11 = r5;
        goto L68
    L62:
        r10 = r4 / r7[1];
        goto L64
    L58:
        float r15 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r16 = this.mAnchorDpDt;
        r16[1] = this.mTouchDirectionY * r15;
        r16[0] = r15 * this.mTouchDirectionX;
        goto L59
    L11:
        if (r3 != 2) goto L105;
        float r17 = r21.getRawY() - this.mLastTouchY;
        float r18 = r21.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionX * r18) + (this.mTouchDirectionY * r17)) <= this.mDragThreshold) goto L16;
    L17:
        float r19 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L20;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r19);
    L20:
        int r110 = this.mTouchAnchorId;
        if (r110 == (-1)) goto L23;
        this.mMotionLayout.getAnchorDpDt(r110, r19, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L24:
        float r20 = this.mTouchDirectionX;
        float[] r25 = this.mAnchorDpDt;
        if (Math.abs(((r20 * r25[0]) + (this.mTouchDirectionY * r25[1])) * this.mDragScale) >= 0.01d) goto L28;
        float[] r26 = this.mAnchorDpDt;
        r26[0] = 0.01f;
        r26[1] = 0.01f;
    L28:
        if (this.mTouchDirectionX == 0.0f) goto L30;
        float r111 = r18 / this.mAnchorDpDt[0];
    L31:
        float r27 = Math.max(Math.min(r19 + r111, 1.0f), 0.0f);
        if (this.mOnTouchUp != 6) goto L35;
        r27 = Math.max(r27, 0.01f);
    L35:
        if (this.mOnTouchUp != 7) goto L37;
        r27 = Math.min(r27, 0.99f);
    L37:
        float r28 = this.mMotionLayout.getProgress();
        if (r27 != r28) goto L40;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L54:
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        return;
    L40:
        if (r28 != 0.0f) goto L42;
    L43:
        MotionLayout r29 = this.mMotionLayout;
        if (r28 != 0.0f) goto L46;
        boolean r30 = true;
    L47:
        r29.endTrigger(r30);
    L48:
        this.mMotionLayout.setProgress(r27);
        r2.computeCurrentVelocity(1000);
        float r31 = r2.getXVelocity();
        float r32 = r2.getYVelocity();
        if (this.mTouchDirectionX == 0.0f) goto L51;
        float r33 = r31 / this.mAnchorDpDt[0];
    L52:
        this.mMotionLayout.mLastVelocity = r33;
        goto L54
    L51:
        r33 = r32 / this.mAnchorDpDt[1];
        goto L52
    L46:
        r30 = false;
        goto L47
    L42:
        if (r28 != 1.0f) goto L48;
    L30:
        r111 = r17 / this.mAnchorDpDt[1];
        goto L31
    L23:
        float r34 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r35 = this.mAnchorDpDt;
        r35[1] = this.mTouchDirectionY * r34;
        r35[0] = r34 * this.mTouchDirectionX;
        goto L24
    L16:
        if (this.mDragStarted == true) goto L17;
        return;
    }

    void processTouchRotateEvent(MotionEvent r21, MotionLayout.MotionTracker r22, int r23, MotionScene r24) {
        MotionLayout.MotionTracker r1 = (MotionLayout.MotionTracker) ZeusTransformUtils.wrapperContextForParams(r22, MotionLayout.MotionTracker.class, "com.obric.memorydata.plugin");
        r1.addMovement(r21);
        int r3 = r21.getAction();
        boolean r4 = false;
        if (r3 != 0) goto L5;
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        this.mDragStarted = false;
        return;
    L5:
        if (r3 != 1) goto L7;
        this.mDragStarted = false;
        r1.computeCurrentVelocity(16);
        float r6 = r1.getXVelocity();
        float r2 = r1.getYVelocity();
        float r7 = this.mMotionLayout.getProgress();
        float r8 = this.mMotionLayout.getWidth() / 2.0f;
        float r11 = this.mMotionLayout.getHeight() / 2.0f;
        int r12 = this.mRotationCenterId;
        if (r12 == (-1)) goto L52;
        View r9 = this.mMotionLayout.findViewById(r12);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r5 = this.mTempLoc[0] + ((r9.getLeft() + r9.getRight()) / 2.0f);
        int r13 = this.mTempLoc[1];
    L51:
        r11 = r13 + ((r9.getTop() + r9.getBottom()) / 2.0f);
        r8 = r5;
    L55:
        float r10 = r21.getRawX() - r8;
        float r14 = r21.getRawY() - r11;
        double r15 = Math.toDegrees(Math.atan2(r14, r10));
        int r16 = this.mTouchAnchorId;
        if (r16 == (-1)) goto L58;
        this.mMotionLayout.getAnchorDpDt(r16, r7, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r17 = this.mAnchorDpDt;
        r17[1] = (float) Math.toDegrees(r17[1]);
    L59:
        float r18 = ((float) (Math.toDegrees(Math.atan2(r2 + r14, r6 + r10)) - r15)) * 62.5f;
        if (Float.isNaN(r18) == true) goto L62;
        float r19 = (((r18 * 3.0f) * this.mDragScale) / this.mAnchorDpDt[1]) + r7;
    L64:
        if (r19 == 0.0f) goto L91;
        if (r19 == 1.0f) goto L91;
        int r20 = this.mOnTouchUp;
        if (r20 == 3) goto L91;
        float r25 = (r18 * this.mDragScale) / this.mAnchorDpDt[1];
        if (r19 >= 0.5d) goto L72;
        float r26 = 0.0f;
    L74:
        if (r20 != 6) goto L80;
        if ((r7 + r25) >= 0.0f) goto L78;
        r25 = Math.abs(r25);
    L78:
        r26 = 1.0f;
    L80:
        if (this.mOnTouchUp == 7) goto L82;
    L85:
        this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, r26, r25 * 3.0f);
        if (0.0f < r7) goto L88;
    L94:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L88:
        if (1.0f <= r7) goto L94;
        return;
    L82:
        if ((r7 + r25) <= 1.0f) goto L84;
        r25 = -Math.abs(r25);
    L84:
        r26 = 0.0f;
        goto L85
    L72:
        r26 = 1.0f;
    L91:
        if (0.0f >= r19) goto L94;
        if (1.0f <= r19) goto L94;
        return;
    L62:
        r19 = r7;
        goto L64
    L58:
        this.mAnchorDpDt[1] = 360.0f;
        goto L59
    L52:
        int r110 = this.mTouchAnchorId;
        if (r110 == (-1)) goto L55;
        r9 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r110).getAnimateRelativeTo());
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r5 = this.mTempLoc[0] + ((r9.getLeft() + r9.getRight()) / 2.0f);
        r13 = this.mTempLoc[1];
        goto L51
    L7:
        if (r3 != 2) goto L102;
        r21.getRawY();
        r21.getRawX();
        float r27 = this.mMotionLayout.getWidth() / 2.0f;
        float r111 = this.mMotionLayout.getHeight() / 2.0f;
        int r112 = this.mRotationCenterId;
        if (r112 == (-1)) goto L12;
        View r28 = this.mMotionLayout.findViewById(r112);
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        float r113 = this.mTempLoc[0] + ((r28.getLeft() + r28.getRight()) / 2.0f);
        r111 = ((r28.getTop() + r28.getBottom()) / 2.0f) + this.mTempLoc[1];
        r27 = r113;
    L18:
        float r29 = r21.getRawX() - r27;
        float r114 = r21.getRawY() - r111;
        double r30 = Math.atan2(r21.getRawY() - r111, r21.getRawX() - r27);
        float r31 = (float) (((r30 - Math.atan2(this.mLastTouchY - r111, this.mLastTouchX - r27)) * 180.0d) / 3.141592653589793d);
        if (r31 <= 330.0f) goto L22;
        r31 = r31 - 360.0f;
    L25:
        if (Math.abs(r31) <= 0.01d) goto L27;
    L28:
        float r32 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L31;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r32);
    L31:
        int r115 = this.mTouchAnchorId;
        if (r115 == (-1)) goto L34;
        this.mMotionLayout.getAnchorDpDt(r115, r32, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float[] r33 = this.mAnchorDpDt;
        r33[1] = (float) Math.toDegrees(r33[1]);
    L35:
        float r34 = Math.max(Math.min(r32 + ((r31 * this.mDragScale) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        float r35 = this.mMotionLayout.getProgress();
        if (r34 != r35) goto L38;
        this.mMotionLayout.mLastVelocity = 0.0f;
    L47:
        this.mLastTouchX = r21.getRawX();
        this.mLastTouchY = r21.getRawY();
        return;
    L38:
        if (r35 != 0.0f) goto L40;
    L41:
        MotionLayout r36 = this.mMotionLayout;
        if (r35 != 0.0f) goto L44;
        r4 = true;
    L44:
        r36.endTrigger(r4);
    L45:
        this.mMotionLayout.setProgress(r34);
        r1.computeCurrentVelocity(1000);
        float r37 = r1.getXVelocity();
        double r38 = r1.getYVelocity();
        double r39 = r37;
        float r40 = (float) ((Math.hypot(r38, r39) * Math.sin(Math.atan2(r38, r39) - r30)) / Math.hypot(r29, r114));
        this.mMotionLayout.mLastVelocity = (float) Math.toDegrees(r40);
        goto L47
    L40:
        if (r35 != 1.0f) goto L45;
    L34:
        this.mAnchorDpDt[1] = 360.0f;
        goto L35
    L27:
        if (this.mDragStarted == true) goto L28;
        return;
    L22:
        if (r31 >= (-330.0f)) goto L25;
        r31 = r31 + 360.0f;
        goto L25
    L12:
        int r116 = this.mTouchAnchorId;
        if (r116 == (-1)) goto L18;
        View r117 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(r116).getAnimateRelativeTo());
        if (r117 != null) goto L17;
        Log.e(TAG, "could not find view to animate to");
        goto L18
    L17:
        this.mMotionLayout.getLocationOnScreen(this.mTempLoc);
        r27 = this.mTempLoc[0] + ((r117.getLeft() + r117.getRight()) / 2.0f);
        r111 = this.mTempLoc[1] + ((r117.getTop() + r117.getBottom()) / 2.0f);
        goto L18
    }

    void scrollMove(float r9, float r10) {
        float r0 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L5;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r0);
    L5:
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r0, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r1 = this.mTouchDirectionX;
        float[] r2 = this.mAnchorDpDt;
        if (Math.abs((r1 * r2[0]) + (this.mTouchDirectionY * r2[1])) >= 0.01d) goto L8;
        float[] r3 = this.mAnchorDpDt;
        r3[0] = 0.01f;
        r3[1] = 0.01f;
    L8:
        float r4 = this.mTouchDirectionX;
        if (r4 == 0.0f) goto L11;
        float r11 = (r9 * r4) / this.mAnchorDpDt[0];
    L12:
        float r12 = Math.max(Math.min(r0 + r11, 1.0f), 0.0f);
        if (r12 == this.mMotionLayout.getProgress()) goto L16;
        this.mMotionLayout.setProgress(r12);
        return;
    L16:
        return;
    L11:
        r11 = (r10 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        goto L12
    }

    void scrollUp(float r9, float r10) {
        boolean r0 = false;
        this.mDragStarted = false;
        float r1 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r1, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r2 = this.mTouchDirectionX;
        float[] r3 = this.mAnchorDpDt;
        float r4 = r3[0];
        float r5 = this.mTouchDirectionY;
        float r6 = r3[1];
        float r7 = 0.0f;
        if (r2 == 0.0f) goto L5;
        float r11 = (r9 * r2) / r3[0];
    L7:
        if (Float.isNaN(r11) == true) goto L10;
        r1 = r1 + (r11 / 3.0f);
    L10:
        if (r1 != 0.0f) goto L12;
        return;
    L12:
        if (r1 == 1.0f) goto L14;
        boolean r8 = true;
    L15:
        int r12 = this.mOnTouchUp;
        if (r12 == 3) goto L19;
        r0 = true;
    L19:
        if ((r0 & r8) == false) goto L27;
        MotionLayout r13 = this.mMotionLayout;
        if (r1 < 0.5d) goto L24;
        r7 = 1.0f;
    L24:
        r13.touchAnimateTo(r12, r7, r11);
        return;
    L27:
        return;
    L14:
        r8 = false;
        goto L15
    L5:
        r11 = (r10 * r5) / r3[1];
        goto L7
    }

    public void setAnchorId(int r1) {
        this.mTouchAnchorId = r1;
    }

    void setAutoCompleteMode(int r1) {
        this.mAutoCompleteMode = r1;
    }

    void setDown(float r1, float r2) {
        this.mLastTouchX = r1;
        this.mLastTouchY = r2;
    }

    public void setMaxAcceleration(float r1) {
        this.mMaxAcceleration = r1;
    }

    public void setMaxVelocity(float r1) {
        this.mMaxVelocity = r1;
    }

    public void setRTL(boolean r8) {
        if (r8 == false) goto L5;
        float[][] r9 = TOUCH_DIRECTION;
        r9[4] = r9[3];
        r9[5] = r9[2];
        float[][] r10 = TOUCH_SIDES;
        r10[5] = r10[2];
        r10[6] = r10[1];
    L6:
        float[][] r11 = TOUCH_SIDES;
        int r0 = this.mTouchAnchorSide;
        this.mTouchAnchorX = r11[r0][0];
        this.mTouchAnchorY = r11[r0][1];
        int r12 = this.mTouchSide;
        float[][] r1 = TOUCH_DIRECTION;
        if (r12 < r1.length) goto L9;
        return;
    L9:
        this.mTouchDirectionX = r1[r12][0];
        this.mTouchDirectionY = r1[r12][1];
        return;
    L5:
        float[][] r13 = TOUCH_DIRECTION;
        r13[4] = r13[2];
        r13[5] = r13[3];
        float[][] r14 = TOUCH_SIDES;
        r14[5] = r14[1];
        r14[6] = r14[2];
        goto L6
    }

    public void setTouchAnchorLocation(float r1, float r2) {
        this.mTouchAnchorX = r1;
        this.mTouchAnchorY = r2;
    }

    public void setTouchUpMode(int r1) {
        this.mOnTouchUp = r1;
    }

    void setUpTouchEvent(float r1, float r2) {
        this.mLastTouchX = r1;
        this.mLastTouchY = r2;
        this.mDragStarted = false;
    }

    void setupTouch() {
        int r0 = this.mTouchAnchorId;
        if (r0 == (-1)) goto L7;
        View r1 = this.mMotionLayout.findViewById(r0);
        if (r1 != null) goto L9;
        Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mMotionLayout.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mTouchAnchorId));
    L9:
        if (ZeusTransformUtils.instanceOf(r1, NestedScrollView.class) == false) goto L12;
        NestedScrollView r2 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r1, NestedScrollView.class, "com.obric.memorydata.plugin");
        r2.setOnTouchListener(new AnonymousClass1(this));
        r2.setOnScrollChangeListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX) == false) goto L6;
        return Key.ROTATION;
    L6:
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
