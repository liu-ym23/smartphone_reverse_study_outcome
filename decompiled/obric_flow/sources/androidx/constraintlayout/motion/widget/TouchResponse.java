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
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
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
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
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

    public TouchResponse(Context r5, MotionLayout r10, XmlPullParser r11) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mMotionLayout = r10;
        fillFromAttributeList(r5, Xml.asAttributeSet(r11));
    }

    private void fill(TypedArray r10) {
        int r5 = r10.getIndexCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L41;
        int r12 = r10.getIndex(r11);
        if (r12 != R.styleable.OnSwipe_touchAnchorId) goto L8;
        this.mTouchAnchorId = r10.getResourceId(r12, this.mTouchAnchorId);
    L40:
        r11 = r11 + 1;
        goto L3
    L8:
        if (r12 != R.styleable.OnSwipe_touchAnchorSide) goto L11;
        int r13 = r10.getInt(r12, this.mTouchAnchorSide);
        this.mTouchAnchorSide = r13;
        float[] r14 = TOUCH_SIDES[r13];
        this.mTouchAnchorX = r14[0];
        this.mTouchAnchorY = r14[1];
        goto L40
    L11:
        if (r12 != R.styleable.OnSwipe_dragDirection) goto L14;
        int r15 = r10.getInt(r12, this.mTouchSide);
        this.mTouchSide = r15;
        float[] r16 = TOUCH_DIRECTION[r15];
        this.mTouchDirectionX = r16[0];
        this.mTouchDirectionY = r16[1];
        goto L40
    L14:
        if (r12 != R.styleable.OnSwipe_maxVelocity) goto L17;
        this.mMaxVelocity = r10.getFloat(r12, this.mMaxVelocity);
        goto L40
    L17:
        if (r12 != R.styleable.OnSwipe_maxAcceleration) goto L20;
        this.mMaxAcceleration = r10.getFloat(r12, this.mMaxAcceleration);
        goto L40
    L20:
        if (r12 != R.styleable.OnSwipe_moveWhenScrollAtTop) goto L23;
        this.mMoveWhenScrollAtTop = r10.getBoolean(r12, this.mMoveWhenScrollAtTop);
        goto L40
    L23:
        if (r12 != R.styleable.OnSwipe_dragScale) goto L26;
        this.mDragScale = r10.getFloat(r12, this.mDragScale);
        goto L40
    L26:
        if (r12 != R.styleable.OnSwipe_dragThreshold) goto L29;
        this.mDragThreshold = r10.getFloat(r12, this.mDragThreshold);
        goto L40
    L29:
        if (r12 != R.styleable.OnSwipe_touchRegionId) goto L32;
        this.mTouchRegionId = r10.getResourceId(r12, this.mTouchRegionId);
        goto L40
    L32:
        if (r12 != R.styleable.OnSwipe_onTouchUp) goto L35;
        this.mOnTouchUp = r10.getInt(r12, this.mOnTouchUp);
        goto L40
    L35:
        if (r12 != R.styleable.OnSwipe_nestedScrollFlags) goto L38;
        this.mFlags = r10.getInteger(r12, 0);
        goto L40
    L38:
        if (r12 != R.styleable.OnSwipe_limitBoundsTo) goto L40;
        this.mLimitBoundsTo = r10.getResourceId(r12, 0);
        goto L40
    }

    private void fillFromAttributeList(Context r5, AttributeSet r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.OnSwipe);
        fill(r11);
        r11.recycle();
    }

    public float dot(float r5, float r10) {
        float r11 = r5 * this.mTouchDirectionX;
        return (r10 * this.mTouchDirectionY) + r11;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public RectF getLimitBoundsTo(ViewGroup r5, RectF r10) {
        int r11 = this.mLimitBoundsTo;
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        View r12 = r5.findViewById(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        r10.set(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom());
        return r10;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public float getProgressDirection(float r10, float r11) {
        float r5 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r5, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r12 = this.mTouchDirectionX;
        if (r12 == 0.0f) goto L8;
        float[] r13 = this.mAnchorDpDt;
        if (r13[0] != 0.0f) goto L13;
        r13[0] = 1.0E-7f;
    L13:
        return (r10 * r12) / r13[0];
    L8:
        float[] r14 = this.mAnchorDpDt;
        if (r14[1] != 0.0f) goto L12;
        r14[1] = 1.0E-7f;
    L12:
        return (r11 * this.mTouchDirectionY) / r14[1];
    }

    public RectF getTouchRegion(ViewGroup r5, RectF r10) {
        int r11 = this.mTouchRegionId;
        if (r11 != (-1)) goto L5;
        return null;
    L5:
        View r12 = r5.findViewById(r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        r10.set(r12.getLeft(), r12.getTop(), r12.getRight(), r12.getBottom());
        return r10;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public void processTouchEvent(MotionEvent r19, MotionLayout.MotionTracker r20, int r21, MotionScene r22) {
        r20.addMovement(r19);
        int r5 = r19.getAction();
        if (r5 != 0) goto L5;
        this.mLastTouchX = r19.getRawX();
        this.mLastTouchY = r19.getRawY();
        this.mDragStarted = false;
        return;
    L5:
        if (r5 != 1) goto L7;
        this.mDragStarted = false;
        r20.computeCurrentVelocity(1000);
        float r10 = r20.getXVelocity();
        float r11 = r20.getYVelocity();
        float r12 = this.mMotionLayout.getProgress();
        int r13 = this.mTouchAnchorId;
        if (r13 == (-1)) goto L39;
        this.mMotionLayout.getAnchorDpDt(r13, r12, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L40:
        float r14 = this.mTouchDirectionX;
        float[] r15 = this.mAnchorDpDt;
        float r16 = r15[0];
        float r17 = r15[1];
        if (r14 == 0.0f) goto L43;
        float r18 = r10 / r16;
    L45:
        if (Float.isNaN(r18) == true) goto L47;
        float r23 = (r18 / 3.0f) + r12;
    L49:
        if (r23 == 0.0f) goto L64;
        if (r23 == 1.0f) goto L64;
        int r24 = this.mOnTouchUp;
        if (r24 == 3) goto L64;
        MotionLayout r25 = this.mMotionLayout;
        if (r23 >= 0.5d) goto L57;
        float r26 = 0.0f;
    L58:
        r25.touchAnimateTo(r24, r26, r18);
        if (0.0f < r12) goto L61;
    L62:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L61:
        if (1.0f <= r12) goto L62;
        return;
    L57:
        r26 = 1.0f;
    L64:
        if (0.0f < r23) goto L66;
    L67:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L66:
        if (1.0f <= r23) goto L67;
        return;
    L47:
        r23 = r12;
        goto L49
    L43:
        r18 = r11 / r17;
        goto L45
    L39:
        float r27 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r28 = this.mAnchorDpDt;
        r28[1] = this.mTouchDirectionY * r27;
        r28[0] = r27 * this.mTouchDirectionX;
        goto L40
    L7:
        if (r5 != 2) goto L76;
        float r29 = r19.getRawY() - this.mLastTouchY;
        float r110 = r19.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionY * r29) + (this.mTouchDirectionX * r110)) <= this.mDragThreshold) goto L12;
    L13:
        float r111 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L16;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r111);
    L16:
        int r112 = this.mTouchAnchorId;
        if (r112 == (-1)) goto L19;
        this.mMotionLayout.getAnchorDpDt(r112, r111, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L20:
        float r30 = this.mTouchDirectionX;
        float[] r113 = this.mAnchorDpDt;
        if (Math.abs(((this.mTouchDirectionY * r113[1]) + (r30 * r113[0])) * this.mDragScale) >= 0.01d) goto L24;
        float[] r31 = this.mAnchorDpDt;
        r31[0] = 0.01f;
        r31[1] = 0.01f;
    L24:
        if (this.mTouchDirectionX == 0.0f) goto L26;
        float r114 = r110 / this.mAnchorDpDt[0];
    L27:
        float r32 = Math.max(Math.min(r111 + r114, 1.0f), 0.0f);
        if (r32 == this.mMotionLayout.getProgress()) goto L34;
        this.mMotionLayout.setProgress(r32);
        r20.computeCurrentVelocity(1000);
        float r33 = r20.getXVelocity();
        float r34 = r20.getYVelocity();
        if (this.mTouchDirectionX == 0.0f) goto L32;
        float r35 = r33 / this.mAnchorDpDt[0];
    L33:
        this.mMotionLayout.mLastVelocity = r35;
    L35:
        this.mLastTouchX = r19.getRawX();
        this.mLastTouchY = r19.getRawY();
        return;
    L32:
        r35 = r34 / this.mAnchorDpDt[1];
        goto L33
    L34:
        this.mMotionLayout.mLastVelocity = 0.0f;
        goto L35
    L26:
        r114 = r29 / this.mAnchorDpDt[1];
        goto L27
    L19:
        float r36 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r115 = this.mAnchorDpDt;
        r115[1] = this.mTouchDirectionY * r36;
        r115[0] = r36 * this.mTouchDirectionX;
        goto L20
    L12:
        if (this.mDragStarted == true) goto L13;
        return;
    }

    public void scrollMove(float r10, float r11) {
        float r5 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L5;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r5);
    L5:
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r5, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r12 = this.mTouchDirectionX;
        float[] r13 = this.mAnchorDpDt;
        if (Math.abs((this.mTouchDirectionY * r13[1]) + (r12 * r13[0])) >= 0.01d) goto L8;
        float[] r14 = this.mAnchorDpDt;
        r14[0] = 0.01f;
        r14[1] = 0.01f;
    L8:
        float r15 = this.mTouchDirectionX;
        if (r15 == 0.0f) goto L11;
        float r16 = (r10 * r15) / this.mAnchorDpDt[0];
    L12:
        float r17 = Math.max(Math.min(r5 + r16, 1.0f), 0.0f);
        if (r17 == this.mMotionLayout.getProgress()) goto L16;
        this.mMotionLayout.setProgress(r17);
        return;
    L16:
        return;
    L11:
        r16 = (r11 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        goto L12
    }

    public void scrollUp(float r10, float r11) {
        boolean r5 = false;
        this.mDragStarted = false;
        float r12 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r12, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r13 = this.mTouchDirectionX;
        float[] r14 = this.mAnchorDpDt;
        float r15 = r14[0];
        float r16 = this.mTouchDirectionY;
        float r17 = r14[1];
        float r18 = 0.0f;
        if (r13 == 0.0f) goto L5;
        float r19 = (r10 * r13) / r15;
    L7:
        if (Float.isNaN(r19) == true) goto L10;
        r12 = r12 + (r19 / 3.0f);
    L10:
        if (r12 != 0.0f) goto L12;
        return;
    L12:
        if (r12 == 1.0f) goto L14;
        boolean r20 = true;
    L15:
        int r21 = this.mOnTouchUp;
        if (r21 == 3) goto L19;
        r5 = true;
    L19:
        if ((r5 & r20) == false) goto L27;
        MotionLayout r22 = this.mMotionLayout;
        if (r12 < 0.5d) goto L24;
        r18 = 1.0f;
    L24:
        r22.touchAnimateTo(r21, r18, r19);
        return;
    L27:
        return;
    L14:
        r20 = false;
        goto L15
    L5:
        r19 = (r11 * r16) / r17;
        goto L7
    }

    public void setAnchorId(int r5) {
        this.mTouchAnchorId = r5;
    }

    public void setDown(float r5, float r10) {
        this.mLastTouchX = r5;
        this.mLastTouchY = r10;
    }

    public void setMaxAcceleration(float r5) {
        this.mMaxAcceleration = r5;
    }

    public void setMaxVelocity(float r5) {
        this.mMaxVelocity = r5;
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
        float[] r13 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = r13[0];
        this.mTouchAnchorY = r13[1];
        float[] r14 = TOUCH_DIRECTION[this.mTouchSide];
        this.mTouchDirectionX = r14[0];
        this.mTouchDirectionY = r14[1];
        return;
    L5:
        float[][] r15 = TOUCH_DIRECTION;
        r15[4] = r15[2];
        r15[5] = r15[3];
        float[][] r16 = TOUCH_SIDES;
        r16[5] = r16[1];
        r16[6] = r16[2];
        goto L6
    }

    public void setTouchAnchorLocation(float r5, float r10) {
        this.mTouchAnchorX = r5;
        this.mTouchAnchorY = r10;
    }

    public void setUpTouchEvent(float r5, float r10) {
        this.mLastTouchX = r5;
        this.mLastTouchY = r10;
        this.mDragStarted = false;
    }

    public void setupTouch() {
        int r5 = this.mTouchAnchorId;
        if (r5 == (-1)) goto L7;
        View r10 = this.mMotionLayout.findViewById(r5);
        if (r10 != null) goto L9;
        Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
    L9:
        if ((r10 instanceof NestedScrollView) == false) goto L12;
        NestedScrollView r11 = (NestedScrollView) r10;
        r11.setOnTouchListener(new AnonymousClass1(this));
        r11.setOnScrollChangeListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r10 = null;
        goto L9
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
