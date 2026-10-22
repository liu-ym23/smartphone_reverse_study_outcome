package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = null;
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public Callback() {
        }

        public int clampViewPositionHorizontal(@NonNull View r5, int r10, int r11) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View r5, int r10, int r11) {
            return 0;
        }

        public int getOrderedChildIndex(int r5) {
            return r5;
        }

        public int getViewHorizontalDragRange(@NonNull View r5) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View r5) {
            return 0;
        }

        public void onEdgeDragStarted(int r5, int r10) {
        }

        public boolean onEdgeLock(int r5) {
            return false;
        }

        public void onEdgeTouched(int r5, int r10) {
        }

        public void onViewCaptured(@NonNull View r5, int r10) {
        }

        public void onViewDragStateChanged(int r5) {
        }

        public void onViewPositionChanged(@NonNull View r5, int r10, int r11, @Px int r12, @Px int r13) {
        }

        public void onViewReleased(@NonNull View r5, float r10, float r11) {
        }

        public abstract boolean tryCaptureView(@NonNull View r5, int r10);
    }

    static {
        sInterpolator = new AnonymousClass1();
    }

    private ViewDragHelper(@NonNull Context r5, @NonNull ViewGroup r10, @NonNull Callback r11) {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new AnonymousClass2(this);
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.mParentView = r10;
        this.mCallback = r11;
        ViewConfiguration r12 = ViewConfiguration.get(r5);
        int r13 = (int) ((r5.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = r13;
        this.mEdgeSize = r13;
        this.mTouchSlop = r12.getScaledTouchSlop();
        this.mMaxVelocity = r12.getScaledMaximumFlingVelocity();
        this.mMinVelocity = r12.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(r5, sInterpolator);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float r5, float r10, int r11, int r12) {
        float r13 = Math.abs(r5);
        float r14 = Math.abs(r10);
        if ((this.mInitialEdgesTouched[r11] & r12) == r12) goto L5;
        return false;
    L5:
        if ((this.mTrackingEdges & r12) != 0) goto L7;
        return false;
    L7:
        if ((this.mEdgeDragsLocked[r11] & r12) != r12) goto L9;
        return false;
    L9:
        if ((this.mEdgeDragsInProgress[r11] & r12) == r12) goto L30;
        int r15 = this.mTouchSlop;
        if (r13 > r15) goto L16;
        if (r14 > r15) goto L16;
        return false;
    L16:
        if (r13 >= (r14 * 0.5f)) goto L22;
        if (this.mCallback.onEdgeLock(r12) == false) goto L22;
        int[] r16 = this.mEdgeDragsLocked;
        r16[r11] = r16[r11] | r12;
        return false;
    L22:
        if ((this.mEdgeDragsInProgress[r11] & r12) == 0) goto L24;
        return false;
    L24:
        if (r13 <= this.mTouchSlop) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private boolean checkTouchSlop(View r5, float r10, float r11) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.mCallback.getViewHorizontalDragRange(r5) <= 0) goto L8;
        boolean r12 = true;
    L10:
        if (this.mCallback.getViewVerticalDragRange(r5) <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r12 == false) goto L19;
        if (r13 == false) goto L19;
        float r14 = (r11 * r11) + (r10 * r10);
        int r15 = this.mTouchSlop;
        if (r14 > (r15 * r15)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r12 == true) goto L21;
        if (r13 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r11) > this.mTouchSlop) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r10) > this.mTouchSlop) goto L23;
        return false;
    L23:
        return true;
    L12:
        r13 = false;
        goto L13
    L8:
        r12 = false;
        goto L10
    }

    private int clampMag(int r5, int r10, int r11) {
        int r12 = Math.abs(r5);
        if (r12 >= r10) goto L6;
        return 0;
    L6:
        if (r12 <= r11) goto L11;
        if (r5 <= 0) goto L10;
        return r11;
    L10:
        return -r11;
    L11:
        return r5;
    }

    private void clearMotionHistory() {
        float[] r5 = this.mInitialMotionX;
        if (r5 != null) goto L5;
        return;
    L5:
        Arrays.fill(r5, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int r5, int r10, int r11) {
        if (r5 != 0) goto L5;
        return 0;
    L5:
        int r12 = this.mParentView.getWidth();
        float r13 = r12 / 2;
        float r14 = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(r5) / r12)) * r13) + r13;
        int r15 = Math.abs(r10);
        if (r15 <= 0) goto L8;
        int r16 = Math.round(Math.abs(r14 / r15) * 1000.0f) * 4;
    L10:
        return Math.min(r16, MAX_SETTLE_DURATION);
    L8:
        r16 = (int) (((Math.abs(r5) / r11) + 1.0f) * 256.0f);
        goto L10
    }

    private int computeSettleDuration(View r10, int r11, int r12, int r13, int r14) {
        int r15 = clampMag(r13, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r16 = clampMag(r14, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r5 = Math.abs(r11);
        int r17 = Math.abs(r12);
        int r18 = Math.abs(r15);
        int r19 = Math.abs(r16);
        int r20 = r18 + r19;
        int r21 = r5 + r17;
        if (r15 == 0) goto L6;
        float r22 = r18;
        float r23 = r20;
    L5:
        float r24 = r22 / r23;
        if (r16 == 0) goto L10;
        float r25 = r19;
        float r26 = r20;
    L9:
        float r27 = r25 / r26;
        int r28 = computeAxisDuration(r11, r15, this.mCallback.getViewHorizontalDragRange(r10));
        return (int) ((computeAxisDuration(r12, r16, this.mCallback.getViewVerticalDragRange(r10)) * r27) + (r28 * r24));
    L10:
        r25 = r17;
        r26 = r21;
        goto L9
    L6:
        r22 = r5;
        r23 = r21;
        goto L5
    }

    public static ViewDragHelper create(@NonNull ViewGroup r5, @NonNull Callback r10) {
        return new ViewDragHelper(r5.getContext(), r5, r10);
    }

    private void dispatchViewReleased(float r5, float r10) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, r5, r10);
        this.mReleaseInProgress = false;
        if (this.mDragState != 1) goto L6;
        setDragState(0);
        return;
    }

    private float distanceInfluenceForSnapDuration(float r5) {
        return (float) Math.sin((r5 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int r11, int r12, int r13, int r14) {
        int r5 = this.mCapturedView.getLeft();
        int r10 = this.mCapturedView.getTop();
        if (r13 == 0) goto L5;
        r11 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, r11, r13);
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r11 - r5);
    L5:
        int r15 = r11;
        if (r14 == 0) goto L8;
        r12 = this.mCallback.clampViewPositionVertical(this.mCapturedView, r12, r14);
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r12 - r10);
    L8:
        int r16 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        Callback r17 = this.mCallback;
        View r18 = this.mCapturedView;
        r17.onViewPositionChanged(r18, r15, r16, r15 - r5, r16 - r10);
    }

    private void ensureMotionHistorySizeForId(int r10) {
        float[] r5 = this.mInitialMotionX;
        if (r5 != null) goto L5;
    L6:
        int r11 = r10 + 1;
        float[] r12 = new float[r11];
        float[] r13 = new float[r11];
        float[] r14 = new float[r11];
        float[] r15 = new float[r11];
        int[] r16 = new int[r11];
        int[] r17 = new int[r11];
        int[] r18 = new int[r11];
        if (r5 == null) goto L9;
        System.arraycopy(r5, 0, r12, 0, r5.length);
        float[] r19 = this.mInitialMotionY;
        System.arraycopy(r19, 0, r13, 0, r19.length);
        float[] r20 = this.mLastMotionX;
        System.arraycopy(r20, 0, r14, 0, r20.length);
        float[] r21 = this.mLastMotionY;
        System.arraycopy(r21, 0, r15, 0, r21.length);
        int[] r22 = this.mInitialEdgesTouched;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        int[] r23 = this.mEdgeDragsInProgress;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        int[] r24 = this.mEdgeDragsLocked;
        System.arraycopy(r24, 0, r18, 0, r24.length);
    L9:
        this.mInitialMotionX = r12;
        this.mInitialMotionY = r13;
        this.mLastMotionX = r14;
        this.mLastMotionY = r15;
        this.mInitialEdgesTouched = r16;
        this.mEdgeDragsInProgress = r17;
        this.mEdgeDragsLocked = r18;
        return;
    L5:
        if (r5.length <= r10) goto L6;
    }

    private boolean forceSettleCapturedViewAt(int r11, int r12, int r13, int r14) {
        int r5 = this.mCapturedView.getLeft();
        int r10 = this.mCapturedView.getTop();
        int r15 = r11 - r5;
        int r16 = r12 - r10;
        if (r15 != 0) goto L7;
        if (r16 != 0) goto L7;
        this.mScroller.abortAnimation();
        setDragState(0);
        return false;
    L7:
        int r17 = computeSettleDuration(this.mCapturedView, r15, r16, r13, r14);
        this.mScroller.startScroll(r5, r10, r15, r16, r17);
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int r5, int r10) {
        if (r5 >= (this.mParentView.getLeft() + this.mEdgeSize)) goto L5;
        int r11 = 1;
    L7:
        if (r10 >= (this.mParentView.getTop() + this.mEdgeSize)) goto L10;
        r11 = r11 | 4;
    L10:
        if (r5 <= (this.mParentView.getRight() - this.mEdgeSize)) goto L13;
        r11 = r11 | 2;
    L13:
        if (r10 > (this.mParentView.getBottom() - this.mEdgeSize)) goto L15;
        return r11;
    L15:
        return r11 | 8;
    L5:
        r11 = 0;
        goto L7
    }

    private boolean isValidPointerForActionMove(int r5) {
        if (isPointerDown(r5) == true) goto L6;
        Log.e(TAG, "Ignoring pointerId=" + r5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    L6:
        return true;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void reportNewEdgeDrags(float r5, float r10, int r11) {
        boolean r12 = checkNewEdgeDrag(r5, r10, r11, 1);
        ?? r13 = r12;
        if (checkNewEdgeDrag(r10, r5, r11, 4) == false) goto L5;
        r13 = (r12 ? 1 : 0) | 4;
    L5:
        ?? r14 = r13;
        if (checkNewEdgeDrag(r5, r10, r11, 2) == false) goto L8;
        r14 = (r13 == true ? 1 : 0) | 2;
    L8:
        ?? r15 = r14;
        if (checkNewEdgeDrag(r10, r5, r11, 8) == false) goto L11;
        r15 = (r14 == true ? 1 : 0) | 8;
    L11:
        if (r15 == 0) goto L14;
        int[] r16 = this.mEdgeDragsInProgress;
        r16[r11] = (r16[r11] | r15) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r15, r11);
        return;
    }

    private void saveInitialMotion(float r5, float r10, int r11) {
        ensureMotionHistorySizeForId(r11);
        float[] r12 = this.mInitialMotionX;
        this.mLastMotionX[r11] = r5;
        r12[r11] = r5;
        float[] r13 = this.mInitialMotionY;
        this.mLastMotionY[r11] = r10;
        r13[r11] = r10;
        this.mInitialEdgesTouched[r11] = getEdgesTouched((int) r5, (int) r10);
        this.mPointersDown |= 1 << r11;
    }

    private void saveLastMotion(MotionEvent r10) {
        int r5 = r10.getPointerCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L9;
        int r12 = r10.getPointerId(r11);
        if (isValidPointerForActionMove(r12) == false) goto L8;
        float r13 = r10.getX(r11);
        float r14 = r10.getY(r11);
        this.mLastMotionX[r12] = r13;
        this.mLastMotionY[r12] = r14;
    L8:
        r11 = r11 + 1;
        goto L3
    }

    public void abort() {
        cancel();
        if (this.mDragState != 2) goto L5;
        int r5 = this.mScroller.getCurrX();
        int r10 = this.mScroller.getCurrY();
        this.mScroller.abortAnimation();
        int r11 = this.mScroller.getCurrX();
        int r12 = this.mScroller.getCurrY();
        this.mCallback.onViewPositionChanged(this.mCapturedView, r11, r12, r11 - r5, r12 - r10);
    L5:
        setDragState(0);
    }

    public boolean canScroll(@NonNull View r14, boolean r15, int r16, int r17, int r18, int r19) {
        if ((r14 instanceof ViewGroup) == false) goto L18;
        ViewGroup r5 = (ViewGroup) r14;
        int r10 = r14.getScrollX();
        int r11 = r14.getScrollY();
        int r12 = r5.getChildCount() - 1;
    L5:
        if (r12 < 0) goto L18;
        View r13 = r5.getChildAt(r12);
        int r20 = r18 + r10;
        if (r20 < r13.getLeft()) goto L17;
        if (r20 >= r13.getRight()) goto L17;
        int r21 = r19 + r11;
        if (r21 < r13.getTop()) goto L17;
        if (r21 >= r13.getBottom()) goto L17;
        if (canScroll(r13, true, r16, r17, r20 - r13.getLeft(), r21 - r13.getTop()) == false) goto L17;
        return true;
    L17:
        r12 = r12 - 1;
    L18:
        if (r15 == true) goto L20;
    L24:
        return false;
    L20:
        if (r14.canScrollHorizontally(-r16) == false) goto L22;
        return true;
    L22:
        if (r14.canScrollVertically(-r17) == false) goto L24;
        return true;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L6;
        r5.recycle();
        this.mVelocityTracker = null;
        return;
    }

    public void captureChildView(@NonNull View r5, int r10) {
        if (r5.getParent() != this.mParentView) goto L7;
        this.mCapturedView = r5;
        this.mActivePointerId = r10;
        this.mCallback.onViewCaptured(r5, r10);
        setDragState(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean r12) {
        if (this.mDragState != 2) goto L23;
        boolean r5 = this.mScroller.computeScrollOffset();
        int r10 = this.mScroller.getCurrX();
        int r11 = this.mScroller.getCurrY();
        int r13 = r10 - this.mCapturedView.getLeft();
        int r14 = r11 - this.mCapturedView.getTop();
        if (r13 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r13);
    L7:
        if (r14 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r14);
    L9:
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
    L12:
        if (r5 == true) goto L14;
    L18:
        if (r5 == true) goto L23;
        if (r12 == false) goto L21;
        this.mParentView.post(this.mSetIdleRunnable);
        goto L23
    L21:
        setDragState(0);
        goto L23
    L14:
        if (r10 != this.mScroller.getFinalX()) goto L18;
        if (r11 != this.mScroller.getFinalY()) goto L18;
        this.mScroller.abortAnimation();
        r5 = false;
    L11:
        this.mCallback.onViewPositionChanged(this.mCapturedView, r10, r11, r13, r14);
    L23:
        if (this.mDragState != 2) goto L26;
        return true;
    L26:
        return false;
    }

    @Nullable
    public View findTopChildUnder(int r5, int r10) {
        int r11 = this.mParentView.getChildCount() - 1;
    L3:
        if (r11 < 0) goto L14;
        View r12 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(r11));
        if (r5 < r12.getLeft()) goto L13;
        if (r5 >= r12.getRight()) goto L13;
        if (r10 < r12.getTop()) goto L13;
        if (r10 >= r12.getBottom()) goto L13;
        return r12;
    L13:
        r11 = r11 - 1;
        goto L3
    L14:
        return null;
    }

    public void flingCapturedView(int r11, int r12, int r13, int r14) {
        if (this.mReleaseInProgress == false) goto L7;
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), r11, r13, r12, r14);
        setDragState(2);
        return;
    L7:
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int r5, int r10) {
        return isViewUnder(this.mCapturedView, r5, r10);
    }

    public boolean isEdgeTouched(int r5) {
        int r10 = this.mInitialEdgesTouched.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (isEdgeTouched(r5, r11) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isPointerDown(int r5) {
        if ((this.mPointersDown & (1 << r5)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isViewUnder(@Nullable View r5, int r10, int r11) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r10 >= r5.getLeft()) goto L8;
        return false;
    L8:
        if (r10 < r5.getRight()) goto L10;
        return false;
    L10:
        if (r11 >= r5.getTop()) goto L12;
        return false;
    L12:
        if (r11 >= r5.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent r10) {
        int r5 = r10.getActionMasked();
        int r11 = r10.getActionIndex();
        if (r5 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r10);
        int r12 = 0;
        if (r5 != 0) goto L11;
        float r13 = r10.getX();
        float r14 = r10.getY();
        int r15 = r10.getPointerId(0);
        View r16 = findTopChildUnder((int) r13, (int) r14);
        saveInitialMotion(r13, r14, r15);
        tryCaptureViewForDrag(r16, r15);
        int r17 = this.mInitialEdgesTouched[r15];
        int r18 = this.mTrackingEdges;
        if ((r17 & r18) == 0) goto L102;
        this.mCallback.onEdgeTouched(r17 & r18, r15);
        return;
    L102:
        return;
    L11:
        if (r5 == 1) goto L75;
        if (r5 == 2) goto L54;
        if (r5 == 3) goto L50;
        if (r5 != 5) goto L19;
        int r19 = r10.getPointerId(r11);
        float r20 = r10.getX(r11);
        float r110 = r10.getY(r11);
        saveInitialMotion(r20, r110, r19);
        if (this.mDragState != 0) goto L47;
        tryCaptureViewForDrag(findTopChildUnder((int) r20, (int) r110), r19);
        int r111 = this.mInitialEdgesTouched[r19];
        int r21 = this.mTrackingEdges;
        if ((r111 & r21) == 0) goto L94;
        this.mCallback.onEdgeTouched(r111 & r21, r19);
        return;
    L94:
        return;
    L47:
        if (isCapturedViewUnder((int) r20, (int) r110) == false) goto L96;
        tryCaptureViewForDrag(this.mCapturedView, r19);
        return;
    L96:
        return;
    L19:
        if (r5 != 6) goto L103;
        int r22 = r10.getPointerId(r11);
        if (this.mDragState == 1) goto L24;
    L40:
        clearMotionHistory(r22);
        return;
    L24:
        if (r22 != this.mActivePointerId) goto L40;
        int r23 = r10.getPointerCount();
    L27:
        if (r12 >= r23) goto L37;
        int r24 = r10.getPointerId(r12);
        if (r24 == this.mActivePointerId) goto L36;
        View r25 = findTopChildUnder((int) r10.getX(r12), (int) r10.getY(r12));
        View r26 = this.mCapturedView;
        if (r25 != r26) goto L36;
        if (tryCaptureViewForDrag(r26, r24) == false) goto L36;
        int r112 = this.mActivePointerId;
    L38:
        if (r112 != (-1)) goto L40;
        releaseViewForPointerUp();
    L36:
        r12 = r12 + 1;
        goto L27
    L37:
        r112 = -1;
        goto L38
    L103:
        return;
    L50:
        if (this.mDragState != 1) goto L52;
        dispatchViewReleased(0.0f, 0.0f);
    L52:
        cancel();
        return;
    L54:
        if (this.mDragState == 1) goto L56;
        int r27 = r10.getPointerCount();
    L60:
        if (r12 >= r27) goto L73;
        int r28 = r10.getPointerId(r12);
        if (isValidPointerForActionMove(r28) == false) goto L72;
        float r29 = r10.getX(r12);
        float r30 = r10.getY(r12);
        float r31 = r29 - this.mInitialMotionX[r28];
        float r32 = r30 - this.mInitialMotionY[r28];
        reportNewEdgeDrags(r31, r32, r28);
        if (this.mDragState == 1) goto L73;
        View r33 = findTopChildUnder((int) r29, (int) r30);
        if (checkTouchSlop(r33, r31, r32) == false) goto L72;
        if (tryCaptureViewForDrag(r33, r28) == true) goto L73;
    L72:
        r12 = r12 + 1;
    L73:
        saveLastMotion(r10);
        return;
    L56:
        if (isValidPointerForActionMove(this.mActivePointerId) == false) goto L104;
        int r34 = r10.findPointerIndex(this.mActivePointerId);
        float r35 = r10.getX(r34);
        float r36 = r10.getY(r34);
        float[] r37 = this.mLastMotionX;
        int r38 = this.mActivePointerId;
        int r39 = (int) (r35 - r37[r38]);
        int r40 = (int) (r36 - this.mLastMotionY[r38]);
        dragTo(this.mCapturedView.getLeft() + r39, this.mCapturedView.getTop() + r40, r39, r40);
        saveLastMotion(r10);
        return;
    L104:
        return;
    L75:
        if (this.mDragState != 1) goto L77;
        releaseViewForPointerUp();
    L77:
        cancel();
    }

    public void setDragState(int r5) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState == r5) goto L8;
        this.mDragState = r5;
        this.mCallback.onViewDragStateChanged(r5);
        if (this.mDragState != 0) goto L9;
        this.mCapturedView = null;
        return;
    L9:
        return;
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int r5) {
        this.mEdgeSize = r5;
    }

    public void setEdgeTrackingEnabled(int r5) {
        this.mTrackingEdges = r5;
    }

    public void setMinVelocity(float r5) {
        this.mMinVelocity = r5;
    }

    public boolean settleCapturedViewAt(int r5, int r10) {
        if (this.mReleaseInProgress == false) goto L7;
        return forceSettleCapturedViewAt(r5, r10, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent r17) {
        int r5 = r17.getActionMasked();
        int r10 = r17.getActionIndex();
        if (r5 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r17);
        if (r5 == 0) goto L64;
        if (r5 == 1) goto L63;
        if (r5 == 2) goto L30;
        if (r5 == 3) goto L63;
        if (r5 != 5) goto L17;
        int r11 = r17.getPointerId(r10);
        float r12 = r17.getX(r10);
        float r13 = r17.getY(r10);
        saveInitialMotion(r12, r13, r11);
        int r14 = this.mDragState;
        if (r14 != 0) goto L25;
        int r15 = this.mInitialEdgesTouched[r11];
        int r16 = this.mTrackingEdges;
        if ((r15 & r16) != 0) goto L24;
    L18:
        boolean r18 = false;
    L73:
        if (this.mDragState == 1) goto L75;
        return r18;
    L75:
        return true;
    L24:
        this.mCallback.onEdgeTouched(r15 & r16, r11);
        goto L18
    L25:
        if (r14 != 2) goto L18;
        View r19 = findTopChildUnder((int) r12, (int) r13);
        if (r19 != this.mCapturedView) goto L18;
        tryCaptureViewForDrag(r19, r11);
        goto L18
    L17:
        if (r5 != 6) goto L18;
        clearMotionHistory(r17.getPointerId(r10));
        goto L18
    L30:
        if (this.mInitialMotionX == null) goto L18;
        if (this.mInitialMotionY == null) goto L18;
        int r20 = r17.getPointerCount();
        int r21 = 0;
    L35:
        if (r21 >= r20) goto L62;
        int r22 = r17.getPointerId(r21);
        if (isValidPointerForActionMove(r22) == false) goto L61;
        float r23 = r17.getX(r21);
        float r24 = r17.getY(r21);
        float r25 = r23 - this.mInitialMotionX[r22];
        float r110 = r24 - this.mInitialMotionY[r22];
        View r26 = findTopChildUnder((int) r23, (int) r24);
        if (r26 != null) goto L42;
    L44:
        boolean r27 = false;
    L45:
        if (r27 == false) goto L54;
        int r111 = r26.getLeft();
        int r112 = (int) r25;
        int r113 = this.mCallback.clampViewPositionHorizontal(r26, r111 + r112, r112);
        int r114 = r26.getTop();
        int r115 = (int) r110;
        int r28 = this.mCallback.clampViewPositionVertical(r26, r114 + r115, r115);
        int r116 = this.mCallback.getViewHorizontalDragRange(r26);
        int r117 = this.mCallback.getViewVerticalDragRange(r26);
        if (r116 == 0) goto L50;
        if (r116 <= 0) goto L54;
        if (r113 != r111) goto L54;
    L50:
        if (r117 == 0) goto L62;
        if (r117 <= 0) goto L54;
        if (r28 == r114) goto L62;
    L54:
        reportNewEdgeDrags(r25, r110, r22);
        if (this.mDragState == 1) goto L62;
        if (r27 == false) goto L61;
        if (tryCaptureViewForDrag(r26, r22) == false) goto L61;
    L42:
        if (checkTouchSlop(r26, r25, r110) == false) goto L44;
        r27 = true;
    L61:
        r21 = r21 + 1;
    L62:
        saveLastMotion(r17);
    L63:
        cancel();
        goto L18
    L64:
        float r29 = r17.getX();
        float r30 = r17.getY();
        r18 = false;
        int r31 = r17.getPointerId(0);
        saveInitialMotion(r29, r30, r31);
        View r32 = findTopChildUnder((int) r29, (int) r30);
        if (r32 == this.mCapturedView) goto L67;
    L69:
        int r33 = this.mInitialEdgesTouched[r31];
        int r34 = this.mTrackingEdges;
        if ((r33 & r34) == 0) goto L73;
        this.mCallback.onEdgeTouched(r33 & r34, r31);
        goto L73
    L67:
        if (this.mDragState != 2) goto L69;
        tryCaptureViewForDrag(r32, r31);
        goto L69
    }

    public boolean smoothSlideViewTo(@NonNull View r5, int r10, int r11) {
        this.mCapturedView = r5;
        this.mActivePointerId = -1;
        boolean r12 = forceSettleCapturedViewAt(r10, r11, 0, 0);
        if (r12 == false) goto L5;
    L9:
        return r12;
    L5:
        if (this.mDragState != 0) goto L9;
        if (this.mCapturedView == null) goto L9;
        this.mCapturedView = null;
        goto L9
    }

    public boolean tryCaptureViewForDrag(View r5, int r10) {
        if (r5 == this.mCapturedView) goto L5;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (this.mCallback.tryCaptureView(r5, r10) == false) goto L14;
        this.mActivePointerId = r10;
        captureChildView(r5, r10);
        return true;
    L14:
        return false;
    L5:
        if (this.mActivePointerId != r10) goto L7;
        return true;
    }

    private float clampMag(float r5, float r10, float r11) {
        float r12 = Math.abs(r5);
        if (r12 >= r10) goto L6;
        return 0.0f;
    L6:
        if (r12 > r11) goto L8;
        return r5;
    L8:
        if (r5 <= 0.0f) goto L11;
        return r11;
    L11:
        return -r11;
    }

    public static ViewDragHelper create(@NonNull ViewGroup r5, float r10, @NonNull Callback r11) {
        ViewDragHelper r12 = create(r5, r11);
        r12.mTouchSlop = (int) ((1.0f / r10) * r12.mTouchSlop);
        return r12;
    }

    public boolean isEdgeTouched(int r5, int r10) {
        if (isPointerDown(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mInitialEdgesTouched[r10] & r5) == 0) goto L7;
        return true;
    }

    public boolean checkTouchSlop(int r5) {
        int r10 = this.mInitialMotionX.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (checkTouchSlop(r5, r11) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean checkTouchSlop(int r10, int r11) {
        if (isPointerDown(r11) == true) goto L6;
        return false;
    L6:
        if ((r10 & 1) != 1) goto L8;
        boolean r5 = true;
    L10:
        if ((r10 & 2) != 2) goto L12;
        boolean r12 = true;
    L13:
        float r13 = this.mLastMotionX[r11] - this.mInitialMotionX[r11];
        float r14 = this.mLastMotionY[r11] - this.mInitialMotionY[r11];
        if (r5 == false) goto L20;
        if (r12 == false) goto L20;
        float r15 = (r14 * r14) + (r13 * r13);
        int r16 = this.mTouchSlop;
        if (r15 > (r16 * r16)) goto L19;
        return false;
    L19:
        return true;
    L20:
        if (r5 == true) goto L22;
        if (r12 == true) goto L27;
        return false;
    L27:
        if (Math.abs(r14) > this.mTouchSlop) goto L29;
        return false;
    L29:
        return true;
    L22:
        if (Math.abs(r13) > this.mTouchSlop) goto L24;
        return false;
    L24:
        return true;
    L12:
        r12 = false;
        goto L13
    L8:
        r5 = false;
        goto L10
    }

    private void clearMotionHistory(int r5) {
        if (this.mInitialMotionX != null) goto L5;
        return;
    L5:
        if (isPointerDown(r5) == false) goto L10;
        this.mInitialMotionX[r5] = 0.0f;
        this.mInitialMotionY[r5] = 0.0f;
        this.mLastMotionX[r5] = 0.0f;
        this.mLastMotionY[r5] = 0.0f;
        this.mInitialEdgesTouched[r5] = 0;
        this.mEdgeDragsInProgress[r5] = 0;
        this.mEdgeDragsLocked[r5] = 0;
        int r10 = this.mPointersDown;
        this.mPointersDown = (~(1 << r5)) & r10;
        return;
    }
}
