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

        public int clampViewPositionHorizontal(@NonNull View r10, int r11, int r12) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View r10, int r11, int r12) {
            return 0;
        }

        public int getOrderedChildIndex(int r10) {
            return r10;
        }

        public int getViewHorizontalDragRange(@NonNull View r10) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View r10) {
            return 0;
        }

        public void onEdgeDragStarted(int r10, int r11) {
        }

        public boolean onEdgeLock(int r10) {
            return false;
        }

        public void onEdgeTouched(int r10, int r11) {
        }

        public void onViewCaptured(@NonNull View r10, int r11) {
        }

        public void onViewDragStateChanged(int r10) {
        }

        public void onViewPositionChanged(@NonNull View r10, int r11, int r12, @Px int r13, @Px int r14) {
        }

        public void onViewReleased(@NonNull View r10, float r11, float r12) {
        }

        public abstract boolean tryCaptureView(@NonNull View r10, int r11);
    }

    static {
        sInterpolator = new AnonymousClass1();
    }

    private ViewDragHelper(@NonNull Context r10, @NonNull ViewGroup r11, @NonNull Callback r12) {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new AnonymousClass2(this);
        if (r11 == null) goto L10;
        if (r12 == null) goto L8;
        this.mParentView = r11;
        this.mCallback = r12;
        ViewConfiguration r13 = ViewConfiguration.get(r10);
        int r14 = (int) ((r10.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = r14;
        this.mEdgeSize = r14;
        this.mTouchSlop = r13.getScaledTouchSlop();
        this.mMaxVelocity = r13.getScaledMaximumFlingVelocity();
        this.mMinVelocity = r13.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(r10, sInterpolator);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float r10, float r11, int r12, int r13) {
        float r14 = Math.abs(r10);
        float r15 = Math.abs(r11);
        if ((this.mInitialEdgesTouched[r12] & r13) == r13) goto L5;
        return false;
    L5:
        if ((this.mTrackingEdges & r13) != 0) goto L7;
        return false;
    L7:
        if ((this.mEdgeDragsLocked[r12] & r13) != r13) goto L9;
        return false;
    L9:
        if ((this.mEdgeDragsInProgress[r12] & r13) == r13) goto L30;
        int r16 = this.mTouchSlop;
        if (r14 > r16) goto L16;
        if (r15 > r16) goto L16;
        return false;
    L16:
        if (r14 >= (r15 * 0.5f)) goto L22;
        if (this.mCallback.onEdgeLock(r13) == false) goto L22;
        int[] r17 = this.mEdgeDragsLocked;
        r17[r12] = r17[r12] | r13;
        return false;
    L22:
        if ((this.mEdgeDragsInProgress[r12] & r13) == 0) goto L24;
        return false;
    L24:
        if (r14 <= this.mTouchSlop) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private boolean checkTouchSlop(View r10, float r11, float r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.mCallback.getViewHorizontalDragRange(r10) <= 0) goto L8;
        boolean r13 = true;
    L10:
        if (this.mCallback.getViewVerticalDragRange(r10) <= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r13 == false) goto L19;
        if (r14 == false) goto L19;
        float r15 = (r11 * r11) + (r12 * r12);
        int r16 = this.mTouchSlop;
        if (r15 > (r16 * r16)) goto L18;
        return false;
    L18:
        return true;
    L19:
        if (r13 == true) goto L21;
        if (r14 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r12) > this.mTouchSlop) goto L28;
        return false;
    L28:
        return true;
    L21:
        if (Math.abs(r11) > this.mTouchSlop) goto L23;
        return false;
    L23:
        return true;
    L12:
        r14 = false;
        goto L13
    L8:
        r13 = false;
        goto L10
    }

    private float clampMag(float r10, float r11, float r12) {
        float r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0.0f;
    L6:
        if (r13 > r12) goto L8;
        return r10;
    L8:
        if (r10 <= 0.0f) goto L11;
        return r12;
    L11:
        return -r12;
    }

    private int clampMag(int r10, int r11, int r12) {
        int r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0;
    L6:
        if (r13 <= r12) goto L11;
        if (r10 <= 0) goto L10;
        return r12;
    L10:
        return -r12;
    L11:
        return r10;
    }

    private void clearMotionHistory() {
        float[] r10 = this.mInitialMotionX;
        if (r10 != null) goto L5;
        return;
    L5:
        Arrays.fill(r10, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int r10) {
        if (this.mInitialMotionX != null) goto L5;
        return;
    L5:
        if (isPointerDown(r10) == false) goto L10;
        this.mInitialMotionX[r10] = 0.0f;
        this.mInitialMotionY[r10] = 0.0f;
        this.mLastMotionX[r10] = 0.0f;
        this.mLastMotionY[r10] = 0.0f;
        this.mInitialEdgesTouched[r10] = 0;
        this.mEdgeDragsInProgress[r10] = 0;
        this.mEdgeDragsLocked[r10] = 0;
        int r11 = this.mPointersDown;
        this.mPointersDown = (~(1 << r10)) & r11;
        return;
    }

    private int computeAxisDuration(int r10, int r11, int r12) {
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r13 = this.mParentView.getWidth();
        float r14 = r13 / 2;
        float r15 = r14 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(r10) / r13)) * r14);
        int r16 = Math.abs(r11);
        if (r16 <= 0) goto L8;
        int r17 = Math.round(Math.abs(r15 / r16) * 1000.0f) * 4;
    L10:
        return Math.min(r17, 600);
    L8:
        r17 = (int) (((Math.abs(r10) / r12) + 1.0f) * 256.0f);
        goto L10
    }

    private int computeSettleDuration(View r10, int r11, int r12, int r13, int r14) {
        int r15 = clampMag(r13, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r16 = clampMag(r14, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r17 = Math.abs(r11);
        int r18 = Math.abs(r12);
        int r19 = Math.abs(r15);
        int r20 = Math.abs(r16);
        int r21 = r19 + r20;
        int r22 = r17 + r18;
        if (r15 == 0) goto L5;
        float r23 = r19;
        float r24 = r21;
    L6:
        float r25 = r23 / r24;
        if (r16 == 0) goto L9;
        float r26 = r20;
        float r27 = r21;
    L10:
        float r28 = r26 / r27;
        return (int) ((computeAxisDuration(r11, r15, this.mCallback.getViewHorizontalDragRange(r10)) * r25) + (computeAxisDuration(r12, r16, this.mCallback.getViewVerticalDragRange(r10)) * r28));
    L9:
        r26 = r18;
        r27 = r22;
        goto L10
    L5:
        r23 = r17;
        r24 = r22;
        goto L6
    }

    public static ViewDragHelper create(@NonNull ViewGroup r10, float r11, @NonNull Callback r12) {
        ViewDragHelper r13 = create(r10, r12);
        r13.mTouchSlop = (int) (r13.mTouchSlop * (1.0f / r11));
        return r13;
    }

    public static ViewDragHelper create(@NonNull ViewGroup r10, @NonNull Callback r11) {
        return new ViewDragHelper(r10.getContext(), r10, r11);
    }

    private void dispatchViewReleased(float r10, float r11) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, r10, r11);
        this.mReleaseInProgress = false;
        if (this.mDragState != 1) goto L6;
        setDragState(0);
        return;
    }

    private float distanceInfluenceForSnapDuration(float r10) {
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int r11, int r12, int r13, int r14) {
        int r10 = this.mCapturedView.getLeft();
        int r15 = this.mCapturedView.getTop();
        if (r13 == 0) goto L5;
        r11 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, r11, r13);
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r11 - r10);
    L5:
        int r16 = r11;
        if (r14 == 0) goto L8;
        r12 = this.mCallback.clampViewPositionVertical(this.mCapturedView, r12, r14);
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r12 - r15);
    L8:
        int r17 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        Callback r18 = this.mCallback;
        View r19 = this.mCapturedView;
        r18.onViewPositionChanged(r19, r16, r17, r16 - r10, r17 - r15);
    }

    private void ensureMotionHistorySizeForId(int r10) {
        float[] r11 = this.mInitialMotionX;
        if (r11 != null) goto L5;
    L6:
        int r12 = r10 + 1;
        float[] r13 = new float[r12];
        float[] r14 = new float[r12];
        float[] r15 = new float[r12];
        float[] r16 = new float[r12];
        int[] r17 = new int[r12];
        int[] r18 = new int[r12];
        int[] r19 = new int[r12];
        if (r11 == null) goto L9;
        System.arraycopy(r11, 0, r13, 0, r11.length);
        float[] r20 = this.mInitialMotionY;
        System.arraycopy(r20, 0, r14, 0, r20.length);
        float[] r21 = this.mLastMotionX;
        System.arraycopy(r21, 0, r15, 0, r21.length);
        float[] r22 = this.mLastMotionY;
        System.arraycopy(r22, 0, r16, 0, r22.length);
        int[] r23 = this.mInitialEdgesTouched;
        System.arraycopy(r23, 0, r17, 0, r23.length);
        int[] r24 = this.mEdgeDragsInProgress;
        System.arraycopy(r24, 0, r18, 0, r24.length);
        int[] r25 = this.mEdgeDragsLocked;
        System.arraycopy(r25, 0, r19, 0, r25.length);
    L9:
        this.mInitialMotionX = r13;
        this.mInitialMotionY = r14;
        this.mLastMotionX = r15;
        this.mLastMotionY = r16;
        this.mInitialEdgesTouched = r17;
        this.mEdgeDragsInProgress = r18;
        this.mEdgeDragsLocked = r19;
        return;
    L5:
        if (r11.length <= r10) goto L6;
    }

    private boolean forceSettleCapturedViewAt(int r11, int r12, int r13, int r14) {
        int r10 = this.mCapturedView.getLeft();
        int r15 = this.mCapturedView.getTop();
        int r16 = r11 - r10;
        int r17 = r12 - r15;
        if (r16 != 0) goto L7;
        if (r17 != 0) goto L7;
        this.mScroller.abortAnimation();
        setDragState(0);
        return false;
    L7:
        int r18 = computeSettleDuration(this.mCapturedView, r16, r17, r13, r14);
        this.mScroller.startScroll(r10, r15, r16, r17, r18);
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int r10, int r11) {
        if (r10 >= (this.mParentView.getLeft() + this.mEdgeSize)) goto L5;
        int r12 = 1;
    L7:
        if (r11 >= (this.mParentView.getTop() + this.mEdgeSize)) goto L10;
        r12 = r12 | 4;
    L10:
        if (r10 <= (this.mParentView.getRight() - this.mEdgeSize)) goto L13;
        r12 = r12 | 2;
    L13:
        if (r11 > (this.mParentView.getBottom() - this.mEdgeSize)) goto L15;
        return r12;
    L15:
        return r12 | 8;
    L5:
        r12 = 0;
        goto L7
    }

    private boolean isValidPointerForActionMove(int r10) {
        if (isPointerDown(r10) == true) goto L6;
        Log.e(TAG, "Ignoring pointerId=" + r10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
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
    private void reportNewEdgeDrags(float r10, float r11, int r12) {
        boolean r13 = checkNewEdgeDrag(r10, r11, r12, 1);
        ?? r14 = r13;
        if (checkNewEdgeDrag(r11, r10, r12, 4) == false) goto L5;
        r14 = (r13 ? 1 : 0) | 4;
    L5:
        ?? r15 = r14;
        if (checkNewEdgeDrag(r10, r11, r12, 2) == false) goto L8;
        r15 = (r14 == true ? 1 : 0) | 2;
    L8:
        ?? r16 = r15;
        if (checkNewEdgeDrag(r11, r10, r12, 8) == false) goto L11;
        r16 = (r15 == true ? 1 : 0) | 8;
    L11:
        if (r16 == 0) goto L14;
        int[] r17 = this.mEdgeDragsInProgress;
        r17[r12] = (r17[r12] | r16) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r16, r12);
        return;
    }

    private void saveInitialMotion(float r10, float r11, int r12) {
        ensureMotionHistorySizeForId(r12);
        float[] r13 = this.mInitialMotionX;
        this.mLastMotionX[r12] = r10;
        r13[r12] = r10;
        float[] r14 = this.mInitialMotionY;
        this.mLastMotionY[r12] = r11;
        r14[r12] = r11;
        this.mInitialEdgesTouched[r12] = getEdgesTouched((int) r10, (int) r11);
        this.mPointersDown |= 1 << r12;
    }

    private void saveLastMotion(MotionEvent r10) {
        int r11 = r10.getPointerCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = r10.getPointerId(r12);
        if (isValidPointerForActionMove(r13) == false) goto L8;
        float r14 = r10.getX(r12);
        float r15 = r10.getY(r12);
        this.mLastMotionX[r13] = r14;
        this.mLastMotionY[r13] = r15;
    L8:
        r12 = r12 + 1;
        goto L3
    }

    public void abort() {
        cancel();
        if (this.mDragState != 2) goto L5;
        int r10 = this.mScroller.getCurrX();
        int r11 = this.mScroller.getCurrY();
        this.mScroller.abortAnimation();
        int r12 = this.mScroller.getCurrX();
        int r13 = this.mScroller.getCurrY();
        this.mCallback.onViewPositionChanged(this.mCapturedView, r12, r13, r12 - r10, r13 - r11);
    L5:
        setDragState(0);
    }

    protected boolean canScroll(@NonNull View r14, boolean r15, int r16, int r17, int r18, int r19) {
        if ((r14 instanceof ViewGroup) == false) goto L18;
        ViewGroup r10 = (ViewGroup) r14;
        int r11 = r14.getScrollX();
        int r12 = r14.getScrollY();
        int r13 = r10.getChildCount() - 1;
    L5:
        if (r13 < 0) goto L18;
        View r20 = r10.getChildAt(r13);
        int r21 = r18 + r11;
        if (r21 < r20.getLeft()) goto L17;
        if (r21 >= r20.getRight()) goto L17;
        int r22 = r19 + r12;
        if (r22 < r20.getTop()) goto L17;
        if (r22 >= r20.getBottom()) goto L17;
        if (canScroll(r20, true, r16, r17, r21 - r20.getLeft(), r22 - r20.getTop()) == false) goto L17;
        return true;
    L17:
        r13 = r13 - 1;
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
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L6;
        r10.recycle();
        this.mVelocityTracker = null;
        return;
    }

    public void captureChildView(@NonNull View r10, int r11) {
        if (r10.getParent() != this.mParentView) goto L7;
        this.mCapturedView = r10;
        this.mActivePointerId = r11;
        this.mCallback.onViewCaptured(r10, r11);
        setDragState(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean checkTouchSlop(int r10) {
        int r11 = this.mInitialMotionX.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (checkTouchSlop(r10, r12) == true) goto L6;
        r12 = r12 + 1;
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
        boolean r12 = true;
    L10:
        if ((r10 & 2) != 2) goto L12;
        boolean r13 = true;
    L13:
        float r14 = this.mLastMotionX[r11] - this.mInitialMotionX[r11];
        float r15 = this.mLastMotionY[r11] - this.mInitialMotionY[r11];
        if (r12 == false) goto L20;
        if (r13 == false) goto L20;
        float r16 = (r14 * r14) + (r15 * r15);
        int r17 = this.mTouchSlop;
        if (r16 > (r17 * r17)) goto L19;
        return false;
    L19:
        return true;
    L20:
        if (r12 == true) goto L22;
        if (r13 == true) goto L27;
        return false;
    L27:
        if (Math.abs(r15) > this.mTouchSlop) goto L29;
        return false;
    L29:
        return true;
    L22:
        if (Math.abs(r14) > this.mTouchSlop) goto L24;
        return false;
    L24:
        return true;
    L12:
        r13 = false;
        goto L13
    L8:
        r12 = false;
        goto L10
    }

    public boolean continueSettling(boolean r12) {
        if (this.mDragState != 2) goto L23;
        boolean r10 = this.mScroller.computeScrollOffset();
        int r11 = this.mScroller.getCurrX();
        int r13 = this.mScroller.getCurrY();
        int r14 = r11 - this.mCapturedView.getLeft();
        int r15 = r13 - this.mCapturedView.getTop();
        if (r14 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r14);
    L7:
        if (r15 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r15);
    L9:
        if (r14 != 0) goto L11;
        if (r15 != 0) goto L11;
    L12:
        if (r10 == true) goto L14;
    L18:
        if (r10 == true) goto L23;
        if (r12 == false) goto L21;
        this.mParentView.post(this.mSetIdleRunnable);
        goto L23
    L21:
        setDragState(0);
        goto L23
    L14:
        if (r11 != this.mScroller.getFinalX()) goto L18;
        if (r13 != this.mScroller.getFinalY()) goto L18;
        this.mScroller.abortAnimation();
        r10 = false;
    L11:
        this.mCallback.onViewPositionChanged(this.mCapturedView, r11, r13, r14, r15);
    L23:
        if (this.mDragState != 2) goto L26;
        return true;
    L26:
        return false;
    }

    @Nullable
    public View findTopChildUnder(int r10, int r11) {
        int r12 = this.mParentView.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(r12));
        if (r10 < r13.getLeft()) goto L13;
        if (r10 >= r13.getRight()) goto L13;
        if (r11 < r13.getTop()) goto L13;
        if (r11 >= r13.getBottom()) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
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

    public boolean isCapturedViewUnder(int r10, int r11) {
        return isViewUnder(this.mCapturedView, r10, r11);
    }

    public boolean isEdgeTouched(int r10) {
        int r11 = this.mInitialEdgesTouched.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (isEdgeTouched(r10, r12) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isEdgeTouched(int r10, int r11) {
        if (isPointerDown(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mInitialEdgesTouched[r11] & r10) == 0) goto L7;
        return true;
    }

    public boolean isPointerDown(int r10) {
        if ((this.mPointersDown & (1 << r10)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isViewUnder(@Nullable View r10, int r11, int r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11 >= r10.getLeft()) goto L8;
        return false;
    L8:
        if (r11 < r10.getRight()) goto L10;
        return false;
    L10:
        if (r12 >= r10.getTop()) goto L12;
        return false;
    L12:
        if (r12 >= r10.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public void processTouchEvent(@NonNull MotionEvent r10) {
        int r11 = r10.getActionMasked();
        int r12 = r10.getActionIndex();
        if (r11 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r10);
        int r13 = 0;
        if (r11 != 0) goto L11;
        float r14 = r10.getX();
        float r15 = r10.getY();
        int r16 = r10.getPointerId(0);
        View r17 = findTopChildUnder((int) r14, (int) r15);
        saveInitialMotion(r14, r15, r16);
        tryCaptureViewForDrag(r17, r16);
        int r18 = this.mInitialEdgesTouched[r16];
        int r19 = this.mTrackingEdges;
        if ((r18 & r19) == 0) goto L99;
        this.mCallback.onEdgeTouched(r18 & r19, r16);
        return;
    L99:
        return;
    L11:
        if (r11 == 1) goto L74;
        if (r11 == 2) goto L53;
        if (r11 == 3) goto L50;
        if (r11 != 5) goto L19;
        int r20 = r10.getPointerId(r12);
        float r21 = r10.getX(r12);
        float r110 = r10.getY(r12);
        saveInitialMotion(r21, r110, r20);
        if (this.mDragState != 0) goto L47;
        tryCaptureViewForDrag(findTopChildUnder((int) r21, (int) r110), r20);
        int r111 = this.mInitialEdgesTouched[r20];
        int r22 = this.mTrackingEdges;
        if ((r111 & r22) == 0) goto L93;
        this.mCallback.onEdgeTouched(r111 & r22, r20);
        return;
    L93:
        return;
    L47:
        if (isCapturedViewUnder((int) r21, (int) r110) == false) goto L95;
        tryCaptureViewForDrag(this.mCapturedView, r20);
        return;
    L95:
        return;
    L19:
        if (r11 != 6) goto L100;
        int r23 = r10.getPointerId(r12);
        if (this.mDragState == 1) goto L24;
    L40:
        clearMotionHistory(r23);
        return;
    L24:
        if (r23 != this.mActivePointerId) goto L40;
        int r24 = r10.getPointerCount();
    L27:
        if (r13 >= r24) goto L37;
        int r25 = r10.getPointerId(r13);
        if (r25 == this.mActivePointerId) goto L36;
        View r26 = findTopChildUnder((int) r10.getX(r13), (int) r10.getY(r13));
        View r27 = this.mCapturedView;
        if (r26 != r27) goto L36;
        if (tryCaptureViewForDrag(r27, r25) == false) goto L36;
        int r112 = this.mActivePointerId;
    L38:
        if (r112 != (-1)) goto L40;
        releaseViewForPointerUp();
    L36:
        r13 = r13 + 1;
        goto L27
    L37:
        r112 = -1;
        goto L38
    L100:
        return;
    L50:
        if (this.mDragState != 1) goto L76;
        dispatchViewReleased(0.0f, 0.0f);
    L76:
        cancel();
        return;
    L53:
        if (this.mDragState == 1) goto L55;
        int r28 = r10.getPointerCount();
    L60:
        if (r13 >= r28) goto L58;
        int r29 = r10.getPointerId(r13);
        if (isValidPointerForActionMove(r29) == false) goto L72;
        float r30 = r10.getX(r13);
        float r31 = r10.getY(r13);
        float r32 = r30 - this.mInitialMotionX[r29];
        float r33 = r31 - this.mInitialMotionY[r29];
        reportNewEdgeDrags(r32, r33, r29);
        if (this.mDragState == 1) goto L58;
        View r34 = findTopChildUnder((int) r30, (int) r31);
        if (checkTouchSlop(r34, r32, r33) == false) goto L72;
        if (tryCaptureViewForDrag(r34, r29) == true) goto L58;
    L72:
        r13 = r13 + 1;
    L58:
        saveLastMotion(r10);
        return;
    L55:
        if (isValidPointerForActionMove(this.mActivePointerId) == false) goto L101;
        int r35 = r10.findPointerIndex(this.mActivePointerId);
        float r36 = r10.getX(r35);
        float r37 = r10.getY(r35);
        float[] r38 = this.mLastMotionX;
        int r39 = this.mActivePointerId;
        int r40 = (int) (r36 - r38[r39]);
        int r41 = (int) (r37 - this.mLastMotionY[r39]);
        dragTo(this.mCapturedView.getLeft() + r40, this.mCapturedView.getTop() + r41, r40, r41);
        goto L58
    L101:
        return;
    L74:
        if (this.mDragState != 1) goto L76;
        releaseViewForPointerUp();
        goto L76
    }

    void setDragState(int r10) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState == r10) goto L8;
        this.mDragState = r10;
        this.mCallback.onViewDragStateChanged(r10);
        if (this.mDragState != 0) goto L9;
        this.mCapturedView = null;
        return;
    L9:
        return;
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int r10) {
        this.mEdgeSize = r10;
    }

    public void setEdgeTrackingEnabled(int r10) {
        this.mTrackingEdges = r10;
    }

    public void setMinVelocity(float r10) {
        this.mMinVelocity = r10;
    }

    public boolean settleCapturedViewAt(int r10, int r11) {
        if (this.mReleaseInProgress == false) goto L7;
        return forceSettleCapturedViewAt(r10, r11, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent r17) {
        int r10 = r17.getActionMasked();
        int r11 = r17.getActionIndex();
        if (r10 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r17);
        if (r10 == 0) goto L64;
        if (r10 == 1) goto L63;
        if (r10 == 2) goto L30;
        if (r10 == 3) goto L63;
        if (r10 != 5) goto L17;
        int r12 = r17.getPointerId(r11);
        float r13 = r17.getX(r11);
        float r14 = r17.getY(r11);
        saveInitialMotion(r13, r14, r12);
        int r15 = this.mDragState;
        if (r15 != 0) goto L25;
        int r16 = this.mInitialEdgesTouched[r12];
        int r18 = this.mTrackingEdges;
        if ((r16 & r18) != 0) goto L24;
    L18:
        boolean r19 = false;
    L73:
        if (this.mDragState == 1) goto L75;
        return r19;
    L75:
        return true;
    L24:
        this.mCallback.onEdgeTouched(r16 & r18, r12);
        goto L18
    L25:
        if (r15 != 2) goto L18;
        View r20 = findTopChildUnder((int) r13, (int) r14);
        if (r20 != this.mCapturedView) goto L18;
        tryCaptureViewForDrag(r20, r12);
        goto L18
    L17:
        if (r10 != 6) goto L18;
        clearMotionHistory(r17.getPointerId(r11));
        goto L18
    L30:
        if (this.mInitialMotionX == null) goto L18;
        if (this.mInitialMotionY == null) goto L18;
        int r21 = r17.getPointerCount();
        int r22 = 0;
    L35:
        if (r22 >= r21) goto L62;
        int r23 = r17.getPointerId(r22);
        if (isValidPointerForActionMove(r23) == false) goto L61;
        float r24 = r17.getX(r22);
        float r25 = r17.getY(r22);
        float r26 = r24 - this.mInitialMotionX[r23];
        float r110 = r25 - this.mInitialMotionY[r23];
        View r27 = findTopChildUnder((int) r24, (int) r25);
        if (r27 != null) goto L42;
    L44:
        boolean r28 = false;
    L45:
        if (r28 == false) goto L54;
        int r111 = r27.getLeft();
        int r112 = (int) r26;
        int r113 = this.mCallback.clampViewPositionHorizontal(r27, r111 + r112, r112);
        int r114 = r27.getTop();
        int r115 = (int) r110;
        int r29 = this.mCallback.clampViewPositionVertical(r27, r114 + r115, r115);
        int r116 = this.mCallback.getViewHorizontalDragRange(r27);
        int r117 = this.mCallback.getViewVerticalDragRange(r27);
        if (r116 == 0) goto L50;
        if (r116 <= 0) goto L54;
        if (r113 != r111) goto L54;
    L50:
        if (r117 == 0) goto L62;
        if (r117 <= 0) goto L54;
        if (r29 == r114) goto L62;
    L54:
        reportNewEdgeDrags(r26, r110, r23);
        if (this.mDragState == 1) goto L62;
        if (r28 == false) goto L61;
        if (tryCaptureViewForDrag(r27, r23) == false) goto L61;
    L42:
        if (checkTouchSlop(r27, r26, r110) == false) goto L44;
        r28 = true;
    L61:
        r22 = r22 + 1;
    L62:
        saveLastMotion(r17);
    L63:
        cancel();
        goto L18
    L64:
        float r30 = r17.getX();
        float r31 = r17.getY();
        r19 = false;
        int r32 = r17.getPointerId(0);
        saveInitialMotion(r30, r31, r32);
        View r33 = findTopChildUnder((int) r30, (int) r31);
        if (r33 == this.mCapturedView) goto L67;
    L69:
        int r34 = this.mInitialEdgesTouched[r32];
        int r35 = this.mTrackingEdges;
        if ((r34 & r35) == 0) goto L73;
        this.mCallback.onEdgeTouched(r34 & r35, r32);
        goto L73
    L67:
        if (this.mDragState != 2) goto L69;
        tryCaptureViewForDrag(r33, r32);
        goto L69
    }

    public boolean smoothSlideViewTo(@NonNull View r10, int r11, int r12) {
        this.mCapturedView = r10;
        this.mActivePointerId = -1;
        boolean r13 = forceSettleCapturedViewAt(r11, r12, 0, 0);
        if (r13 == false) goto L5;
    L9:
        return r13;
    L5:
        if (this.mDragState != 0) goto L9;
        if (this.mCapturedView == null) goto L9;
        this.mCapturedView = null;
        goto L9
    }

    boolean tryCaptureViewForDrag(View r10, int r11) {
        if (r10 == this.mCapturedView) goto L5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (this.mCallback.tryCaptureView(r10, r11) == false) goto L14;
        this.mActivePointerId = r11;
        captureChildView(r10, r11);
        return true;
    L14:
        return false;
    L5:
        if (this.mActivePointerId != r11) goto L7;
        return true;
    }
}
