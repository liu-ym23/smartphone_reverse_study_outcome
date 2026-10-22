package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final ClampedScroller mScroller;
    final View mTarget;

    private static class ClampedScroller {
        private long mDeltaTime;
        private int mDeltaX;
        private int mDeltaY;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime;
        private long mStopTime;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        ClampedScroller() {
            this.mStartTime = Long.MIN_VALUE;
            this.mStopTime = -1;
            this.mDeltaTime = 0;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }

        private float getValueAt(long r10) {
            long r11 = this.mStartTime;
            if (r10 >= r11) goto L5;
            return 0.0f;
        L5:
            long r12 = this.mStopTime;
            if (r12 < 0) goto L13;
            if (r10 < r12) goto L13;
            float r13 = this.mStopValue;
            return (1.0f - r13) + (r13 * AutoScrollHelper.constrain((r10 - r12) / this.mEffectiveRampDown, 0.0f, 1.0f));
        L13:
            return AutoScrollHelper.constrain((r10 - r11) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }

        private float interpolateValue(float r10) {
            return (((-4.0f) * r10) * r10) + (r10 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) goto L7;
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            float r11 = interpolateValue(getValueAt(r10));
            long r12 = r10 - this.mDeltaTime;
            this.mDeltaTime = r10;
            float r13 = r12 * r11;
            this.mDeltaX = (int) (this.mTargetVelocityX * r13);
            this.mDeltaY = (int) (r13 * this.mTargetVelocityY);
            return;
        L7:
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float r10 = this.mTargetVelocityX;
            return (int) (r10 / Math.abs(r10));
        }

        public int getVerticalDirection() {
            float r10 = this.mTargetVelocityY;
            return (int) (r10 / Math.abs(r10));
        }

        public boolean isFinished() {
            if (this.mStopTime > 0) goto L5;
        L7:
            return false;
        L5:
            if (AnimationUtils.currentAnimationTimeMillis() <= (this.mStopTime + ((long) this.mEffectiveRampDown))) goto L7;
            return true;
        }

        public void requestStop() {
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (r10 - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(r10);
            this.mStopTime = r10;
        }

        public void setRampDownDuration(int r10) {
            this.mRampDownDuration = r10;
        }

        public void setRampUpDuration(int r10) {
            this.mRampUpDuration = r10;
        }

        public void setTargetVelocity(float r10, float r11) {
            this.mTargetVelocityX = r10;
            this.mTargetVelocityY = r11;
        }

        public void start() {
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = r10;
            this.mStopTime = -1;
            this.mDeltaTime = r10;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper this$0;

        ScrollAnimationRunnable(AutoScrollHelper r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper r10 = this.this$0;
            if (r10.mAnimating == true) goto L6;
            return;
        L6:
            if (r10.mNeedsReset == false) goto L8;
            r10.mNeedsReset = false;
            r10.mScroller.start();
        L8:
            ClampedScroller r11 = this.this$0.mScroller;
            if (r11.isFinished() == false) goto L11;
        L18:
            this.this$0.mAnimating = false;
            return;
        L11:
            if (this.this$0.shouldAnimate() == false) goto L18;
            AutoScrollHelper r12 = this.this$0;
            if (r12.mNeedsCancel == false) goto L16;
            r12.mNeedsCancel = false;
            r12.cancelTargetTouch();
        L16:
            r11.computeScrollDelta();
            int r13 = r11.getDeltaX();
            int r14 = r11.getDeltaY();
            this.this$0.scrollTargetBy(r13, r14);
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
        }
    }

    static {
        DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public AutoScrollHelper(@NonNull View r10) {
        this.mScroller = new ClampedScroller();
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0.0f, 0.0f};
        this.mMaximumEdges = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mRelativeVelocity = new float[]{0.0f, 0.0f};
        this.mMinimumVelocity = new float[]{0.0f, 0.0f};
        this.mMaximumVelocity = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mTarget = r10;
        float r11 = Resources.getSystem().getDisplayMetrics().density;
        float r12 = (int) ((1575.0f * r11) + 0.5f);
        setMaximumVelocity(r12, r12);
        float r13 = (int) ((r11 * 315.0f) + 0.5f);
        setMinimumVelocity(r13, r13);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int r10, float r11, float r12, float r13) {
        float r14 = getEdgeValue(this.mRelativeEdges[r10], r12, this.mMaximumEdges[r10], r11);
        if (r14 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r15 = this.mRelativeVelocity[r10];
        float r16 = this.mMinimumVelocity[r10];
        float r17 = this.mMaximumVelocity[r10];
        float r18 = r15 * r13;
        if (r14 <= 0.0f) goto L10;
        return constrain(r14 * r18, r16, r17);
    L10:
        return -constrain((-r14) * r18, r16, r17);
    }

    static float constrain(float r10, float r11, float r12) {
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        return r10;
    }

    static int constrain(int r10, int r11, int r12) {
        if (r10 <= r12) goto L4;
        return r12;
    L4:
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        return r10;
    }

    private float constrainEdgeValue(float r10, float r11) {
        if (r11 != 0.0f) goto L5;
        return 0.0f;
    L5:
        int r12 = this.mEdgeType;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L16;
        if (r12 == 2) goto L12;
    L25:
        return 0.0f;
    L12:
        if (r10 >= 0.0f) goto L25;
        return r10 / (-r11);
    L16:
        if (r10 >= r11) goto L25;
        if (r10 < 0.0f) goto L22;
        return 1.0f - (r10 / r11);
    L22:
        if (this.mAnimating == false) goto L25;
        if (r12 != 1) goto L25;
        return 1.0f;
    }

    private float getEdgeValue(float r10, float r11, float r12, float r13) {
        float r14 = constrain(r10 * r11, 0.0f, r12);
        float r15 = constrainEdgeValue(r13, r14);
        float r16 = constrainEdgeValue(r11 - r13, r14) - r15;
        if (r16 >= 0.0f) goto L6;
        float r17 = -this.mEdgeInterpolator.getInterpolation(-r16);
    L9:
        return constrain(r17, -1.0f, 1.0f);
    L6:
        if (r16 <= 0.0f) goto L10;
        r17 = this.mEdgeInterpolator.getInterpolation(r16);
        goto L9
    L10:
        return 0.0f;
    }

    private void requestStop() {
        if (this.mNeedsReset == false) goto L5;
        this.mAnimating = false;
        return;
    L5:
        this.mScroller.requestStop();
    }

    private void startAnimating() {
        if (this.mRunnable != null) goto L5;
        this.mRunnable = new ScrollAnimationRunnable(this);
    L5:
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed == true) goto L10;
        int r10 = this.mActivationDelay;
        if (r10 <= 0) goto L10;
        ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, r10);
    L11:
        this.mAlreadyDelayed = true;
        return;
    L10:
        this.mRunnable.run();
        goto L11
    }

    public abstract boolean canTargetScrollHorizontally(int r10);

    public abstract boolean canTargetScrollVertically(int r10);

    void cancelTargetTouch() {
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(r11);
        r11.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        if (this.mEnabled == true) goto L5;
        return false;
    L5:
        int r12 = r11.getActionMasked();
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L9;
    L13:
        requestStop();
    L21:
        if (this.mExclusive == true) goto L23;
        return false;
    L23:
        if (this.mAnimating == true) goto L25;
        return false;
    L25:
        return true;
    L9:
        if (r12 != 2) goto L11;
    L15:
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, r11.getX(), r10.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, r11.getY(), r10.getHeight(), this.mTarget.getHeight()));
        if (this.mAnimating == true) goto L21;
        if (shouldAnimate() == false) goto L21;
        startAnimating();
        goto L21
    L11:
        if (r12 == 3) goto L13;
    L14:
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        goto L15
    }

    public abstract void scrollTargetBy(int r10, int r11);

    @NonNull
    public AutoScrollHelper setActivationDelay(int r10) {
        this.mActivationDelay = r10;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int r10) {
        this.mEdgeType = r10;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean r10) {
        if (this.mEnabled == false) goto L6;
        if (r10 == true) goto L6;
        requestStop();
    L6:
        this.mEnabled = r10;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean r10) {
        this.mExclusive = r10;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float r10, float r11) {
        float[] r12 = this.mMaximumEdges;
        r12[0] = r10;
        r12[1] = r11;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float r10, float r11) {
        float[] r12 = this.mMaximumVelocity;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float r10, float r11) {
        float[] r12 = this.mMinimumVelocity;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int r10) {
        this.mScroller.setRampDownDuration(r10);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int r10) {
        this.mScroller.setRampUpDuration(r10);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float r10, float r11) {
        float[] r12 = this.mRelativeEdges;
        r12[0] = r10;
        r12[1] = r11;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float r10, float r11) {
        float[] r12 = this.mRelativeVelocity;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller r10 = this.mScroller;
        int r11 = r10.getVerticalDirection();
        int r12 = r10.getHorizontalDirection();
        if (r11 != 0) goto L5;
    L6:
        if (r12 != 0) goto L8;
    L10:
        return false;
    L8:
        if (canTargetScrollHorizontally(r12) == false) goto L10;
    L9:
        return true;
    L5:
        if (canTargetScrollVertically(r11) == true) goto L9;
        goto L6
    }
}
