package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent r10);

        void setIsLongpressEnabled(boolean r10);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = 0;
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = 0;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase this$0;

            GestureHandler(GestureDetectorCompatImplBase r10) {
                this.this$0 = r10;
            }

            GestureHandler(GestureDetectorCompatImplBase r10, Handler r11) {
                this.this$0 = r10;
                super(r11.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                int r11 = r10.what;
                if (r11 != 1) goto L5;
                GestureDetectorCompatImplBase r12 = this.this$0;
                r12.mListener.onShowPress(r12.mCurrentDownEvent);
                return;
            L5:
                if (r11 != 2) goto L7;
                this.this$0.dispatchLongPress();
                return;
            L7:
                if (r11 != 3) goto L15;
                GestureDetectorCompatImplBase r13 = this.this$0;
                GestureDetector.OnDoubleTapListener r14 = r13.mDoubleTapListener;
                if (r14 != null) goto L11;
                return;
            L11:
                if (r13.mStillDown == true) goto L13;
                r14.onSingleTapConfirmed(r13.mCurrentDownEvent);
                return;
            L13:
                r13.mDeferConfirmSingleTap = true;
                return;
            L15:
                throw new RuntimeException("Unknown message " + r10);
            }
        }

        static {
            TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        GestureDetectorCompatImplBase(Context r10, GestureDetector.OnGestureListener r11, Handler r12) {
            if (r12 == null) goto L5;
            this.mHandler = new GestureHandler(this, r12);
        L6:
            this.mListener = r11;
            if ((r11 instanceof GestureDetector.OnDoubleTapListener) == false) goto L9;
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) r11);
        L9:
            init(r10);
            return;
        L5:
            this.mHandler = new GestureHandler(this);
            goto L6
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress == false) goto L6;
            this.mInLongPress = false;
            return;
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress == false) goto L6;
            this.mInLongPress = false;
            return;
        }

        private void init(Context r10) {
            if (r10 == null) goto L10;
            if (this.mListener == null) goto L8;
            this.mIsLongpressEnabled = true;
            ViewConfiguration r11 = ViewConfiguration.get(r10);
            int r12 = r11.getScaledTouchSlop();
            int r13 = r11.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = r11.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = r11.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = r12 * r12;
            this.mDoubleTapSlopSquare = r13 * r13;
            return;
        L8:
            throw new IllegalArgumentException("OnGestureListener must not be null");
        L10:
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean isConsideredDoubleTap(MotionEvent r10, MotionEvent r11, MotionEvent r12) {
            if (this.mAlwaysInBiggerTapRegion == true) goto L6;
            return false;
        L6:
            if ((r12.getEventTime() - r11.getEventTime()) <= DOUBLE_TAP_TIMEOUT) goto L8;
            return false;
        L8:
            int r13 = ((int) r10.getX()) - ((int) r12.getX());
            int r14 = ((int) r10.getY()) - ((int) r12.getY());
            if (((r13 * r13) + (r14 * r14)) >= this.mDoubleTapSlopSquare) goto L12;
            return true;
        L12:
            return false;
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent r13) {
            int r10 = r13.getAction();
            if (this.mVelocityTracker != null) goto L5;
            this.mVelocityTracker = VelocityTracker.obtain();
        L5:
            this.mVelocityTracker.addMovement(r13);
            int r11 = r10 & 255;
            if (r11 != 6) goto L8;
            boolean r12 = true;
        L9:
            if (r12 == false) goto L11;
            int r14 = r13.getActionIndex();
        L12:
            int r15 = r13.getPointerCount();
            int r16 = 0;
            float r17 = 0.0f;
            float r18 = 0.0f;
        L13:
            if (r16 >= r15) goto L18;
            if (r14 == r16) goto L17;
            r17 = r17 + r13.getX(r16);
            r18 = r18 + r13.getY(r16);
        L17:
            r16 = r16 + 1;
            goto L13
        L18:
            if (r12 == false) goto L20;
            int r19 = r15 - 1;
        L21:
            float r20 = r19;
            float r21 = r17 / r20;
            float r110 = r18 / r20;
            if (r11 == 0) goto L91;
            if (r11 == 1) goto L61;
            if (r11 == 2) goto L42;
            if (r11 != 3) goto L28;
            cancel();
            return false;
        L28:
            if (r11 == 5) goto L39;
            if (r11 != 6) goto L127;
            this.mLastFocusX = r21;
            this.mDownFocusX = r21;
            this.mLastFocusY = r110;
            this.mDownFocusY = r110;
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            int r22 = r13.getActionIndex();
            int r23 = r13.getPointerId(r22);
            float r24 = this.mVelocityTracker.getXVelocity(r23);
            float r25 = this.mVelocityTracker.getYVelocity(r23);
            int r26 = 0;
        L32:
            if (r26 >= r15) goto L129;
            if (r26 == r22) goto L38;
            int r27 = r13.getPointerId(r26);
            if (((this.mVelocityTracker.getXVelocity(r27) * r24) + (this.mVelocityTracker.getYVelocity(r27) * r25)) >= 0.0f) goto L38;
            this.mVelocityTracker.clear();
            return false;
        L38:
            r26 = r26 + 1;
            goto L32
        L129:
            return false;
        L127:
            return false;
        L39:
            this.mLastFocusX = r21;
            this.mDownFocusX = r21;
            this.mLastFocusY = r110;
            this.mDownFocusY = r110;
            cancelTaps();
            return false;
        L42:
            if (this.mInLongPress == true) goto L128;
            float r28 = this.mLastFocusX - r21;
            float r29 = this.mLastFocusY - r110;
            if (this.mIsDoubleTapping == false) goto L48;
            return false | this.mDoubleTapListener.onDoubleTapEvent(r13);
        L48:
            if (this.mAlwaysInTapRegion == false) goto L57;
            int r30 = (int) (r21 - this.mDownFocusX);
            int r31 = (int) (r110 - this.mDownFocusY);
            int r32 = (r30 * r30) + (r31 * r31);
            if (r32 <= this.mTouchSlopSquare) goto L52;
            boolean r111 = this.mListener.onScroll(this.mCurrentDownEvent, r13, r28, r29);
            this.mLastFocusX = r21;
            this.mLastFocusY = r110;
            this.mAlwaysInTapRegion = false;
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        L54:
            if (r32 <= this.mTouchSlopSquare) goto L126;
            this.mAlwaysInBiggerTapRegion = false;
        L126:
            return r111;
        L52:
            r111 = false;
            goto L54
        L57:
            if (Math.abs(r28) < 1.0f) goto L59;
        L60:
            boolean r33 = this.mListener.onScroll(this.mCurrentDownEvent, r13, r28, r29);
            this.mLastFocusX = r21;
            this.mLastFocusY = r110;
            return r33;
        L59:
            if (Math.abs(r29) >= 1.0f) goto L60;
            return false;
        L128:
            return false;
        L61:
            this.mStillDown = false;
            MotionEvent r34 = MotionEvent.obtain(r13);
            if (this.mIsDoubleTapping == false) goto L65;
            r111 = this.mDoubleTapListener.onDoubleTapEvent(r13) | false;
        L82:
            MotionEvent r35 = this.mPreviousUpEvent;
            if (r35 == null) goto L85;
            r35.recycle();
        L85:
            this.mPreviousUpEvent = r34;
            VelocityTracker r36 = this.mVelocityTracker;
            if (r36 == null) goto L88;
            r36.recycle();
            this.mVelocityTracker = null;
        L88:
            this.mIsDoubleTapping = false;
            this.mDeferConfirmSingleTap = false;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            goto L126
        L65:
            if (this.mInLongPress == false) goto L68;
            this.mHandler.removeMessages(3);
            this.mInLongPress = false;
        L80:
            r111 = false;
            goto L82
        L68:
            if (this.mAlwaysInTapRegion == false) goto L75;
            boolean r37 = this.mListener.onSingleTapUp(r13);
            if (this.mDeferConfirmSingleTap == false) goto L74;
            GestureDetector.OnDoubleTapListener r38 = this.mDoubleTapListener;
            if (r38 == null) goto L74;
            r38.onSingleTapConfirmed(r13);
        L74:
            r111 = r37;
            goto L82
        L75:
            VelocityTracker r39 = this.mVelocityTracker;
            int r40 = r13.getPointerId(0);
            r39.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            float r41 = r39.getYVelocity(r40);
            float r42 = r39.getXVelocity(r40);
            if (Math.abs(r41) <= this.mMinimumFlingVelocity) goto L78;
        L81:
            r111 = this.mListener.onFling(this.mCurrentDownEvent, r13, r42, r41);
            goto L82
        L78:
            if (Math.abs(r42) <= this.mMinimumFlingVelocity) goto L80;
        L91:
            if (this.mDoubleTapListener == null) goto L104;
            boolean r43 = this.mHandler.hasMessages(3);
            if (r43 == false) goto L95;
            this.mHandler.removeMessages(3);
        L95:
            MotionEvent r44 = this.mCurrentDownEvent;
            if (r44 == null) goto L103;
            MotionEvent r45 = this.mPreviousUpEvent;
            if (r45 == null) goto L103;
            if (r43 == false) goto L103;
            if (isConsideredDoubleTap(r44, r45, r13) == false) goto L103;
            this.mIsDoubleTapping = true;
            boolean r46 = (this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false) | this.mDoubleTapListener.onDoubleTapEvent(r13);
        L105:
            this.mLastFocusX = r21;
            this.mDownFocusX = r21;
            this.mLastFocusY = r110;
            this.mDownFocusY = r110;
            MotionEvent r47 = this.mCurrentDownEvent;
            if (r47 == null) goto L108;
            r47.recycle();
        L108:
            this.mCurrentDownEvent = MotionEvent.obtain(r13);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mIsLongpressEnabled == false) goto L111;
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) ViewConfiguration.getLongPressTimeout()));
        L111:
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
            return r46 | this.mListener.onDown(r13);
        L103:
            this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        L104:
            r46 = false;
            goto L105
        L20:
            r19 = r15;
            goto L21
        L11:
            r14 = -1;
            goto L12
        L8:
            r12 = false;
            goto L9
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean r10) {
            this.mIsLongpressEnabled = r10;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10) {
            this.mDoubleTapListener = r10;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context r10, GestureDetector.OnGestureListener r11, Handler r12) {
            this.mDetector = new GestureDetector(r10, r11, r12);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent r10) {
            return this.mDetector.onTouchEvent(r10);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean r10) {
            this.mDetector.setIsLongpressEnabled(r10);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener r10) {
            this.mDetector.setOnDoubleTapListener(r10);
        }
    }

    public GestureDetectorCompat(@NonNull Context r10, @NonNull GestureDetector.OnGestureListener r11) {
        this(r10, r11, null);
    }

    public GestureDetectorCompat(@NonNull Context r10, @NonNull GestureDetector.OnGestureListener r11, @Nullable Handler r12) {
        if (Build.VERSION.SDK_INT <= 17) goto L5;
        GestureDetectorCompatImpl r13 = new GestureDetectorCompatImplJellybeanMr2(r10, r11, r12);
    L6:
        this.mImpl = r13;
        return;
    L5:
        r13 = new GestureDetectorCompatImplBase(r10, r11, r12);
        goto L6
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        return this.mImpl.onTouchEvent(r10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setIsLongpressEnabled(boolean r10) {
        this.mImpl.setIsLongpressEnabled(r10);
    }

    public void setOnDoubleTapListener(@Nullable GestureDetector.OnDoubleTapListener r10) {
        this.mImpl.setOnDoubleTapListener(r10);
    }
}
