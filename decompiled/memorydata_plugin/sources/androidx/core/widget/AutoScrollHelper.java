package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
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

        private float getValueAt(long r9) {
            long r0 = this.mStartTime;
            if (r9 >= r0) goto L5;
            return 0.0f;
        L5:
            long r4 = this.mStopTime;
            if (r4 < 0) goto L13;
            if (r9 < r4) goto L13;
            float r1 = this.mStopValue;
            return (1.0f - r1) + (r1 * AutoScrollHelper.constrain((r9 - r4) / this.mEffectiveRampDown, 0.0f, 1.0f));
        L13:
            return AutoScrollHelper.constrain((r9 - r0) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }

        private float interpolateValue(float r2) {
            return (((-4.0f) * r2) * r2) + (r2 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) goto L7;
            long r0 = AnimationUtils.currentAnimationTimeMillis();
            float r2 = interpolateValue(getValueAt(r0));
            long r3 = r0 - this.mDeltaTime;
            this.mDeltaTime = r0;
            float r1 = r3 * r2;
            this.mDeltaX = (int) (this.mTargetVelocityX * r1);
            this.mDeltaY = (int) (r1 * this.mTargetVelocityY);
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
            float r1 = this.mTargetVelocityX;
            return (int) (r1 / Math.abs(r1));
        }

        public int getVerticalDirection() {
            float r1 = this.mTargetVelocityY;
            return (int) (r1 / Math.abs(r1));
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
            long r0 = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (r0 - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(r0);
            this.mStopTime = r0;
        }

        public void setRampDownDuration(int r1) {
            this.mRampDownDuration = r1;
        }

        public void setRampUpDuration(int r1) {
            this.mRampUpDuration = r1;
        }

        public void setTargetVelocity(float r1, float r2) {
            this.mTargetVelocityX = r1;
            this.mTargetVelocityY = r2;
        }

        public void start() {
            long r0 = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = r0;
            this.mStopTime = -1;
            this.mDeltaTime = r0;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper this$0;

        ScrollAnimationRunnable(AutoScrollHelper r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.mAnimating == true) goto L6;
            return;
        L6:
            if (this.this$0.mNeedsReset == false) goto L8;
            this.this$0.mNeedsReset = false;
            this.this$0.mScroller.start();
        L8:
            ClampedScroller r0 = this.this$0.mScroller;
            if (r0.isFinished() == false) goto L11;
        L18:
            this.this$0.mAnimating = false;
            return;
        L11:
            if (this.this$0.shouldAnimate() == false) goto L18;
            if (this.this$0.mNeedsCancel == false) goto L16;
            this.this$0.mNeedsCancel = false;
            this.this$0.cancelTargetTouch();
        L16:
            r0.computeScrollDelta();
            int r1 = r0.getDeltaX();
            int r2 = r0.getDeltaY();
            this.this$0.scrollTargetBy(r1, r2);
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
        }
    }

    static {
        DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public AutoScrollHelper(View r4) {
        this.mScroller = new ClampedScroller();
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0.0f, 0.0f};
        this.mMaximumEdges = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mRelativeVelocity = new float[]{0.0f, 0.0f};
        this.mMinimumVelocity = new float[]{0.0f, 0.0f};
        this.mMaximumVelocity = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mTarget = r4;
        DisplayMetrics r5 = Resources.getSystem().getDisplayMetrics();
        int r0 = (int) ((r5.density * 1575.0f) + 0.5f);
        int r6 = (int) ((r5.density * 315.0f) + 0.5f);
        float r1 = r0;
        setMaximumVelocity(r1, r1);
        float r7 = r6;
        setMinimumVelocity(r7, r7);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int r3, float r4, float r5, float r6) {
        float r7 = getEdgeValue(this.mRelativeEdges[r3], r5, this.mMaximumEdges[r3], r4);
        if (r7 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r8 = this.mRelativeVelocity[r3];
        float r1 = this.mMinimumVelocity[r3];
        float r2 = this.mMaximumVelocity[r3];
        float r9 = r8 * r6;
        if (r7 <= 0.0f) goto L10;
        return constrain(r7 * r9, r1, r2);
    L10:
        return -constrain((-r7) * r9, r1, r2);
    }

    static float constrain(float r1, float r2, float r3) {
        if (r1 <= r3) goto L6;
        return r3;
    L6:
        if (r1 >= r2) goto L8;
        return r2;
    L8:
        return r1;
    }

    static int constrain(int r0, int r1, int r2) {
        if (r0 <= r2) goto L4;
        return r2;
    L4:
        if (r0 >= r1) goto L6;
        return r1;
    L6:
        return r0;
    }

    private float constrainEdgeValue(float r6, float r7) {
        if (r7 != 0.0f) goto L5;
        return 0.0f;
    L5:
        int r1 = this.mEdgeType;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L12;
    L25:
        return 0.0f;
    L12:
        if (r6 >= 0.0f) goto L25;
        return r6 / (-r7);
    L16:
        if (r6 >= r7) goto L25;
        if (r6 < 0.0f) goto L22;
        return 1.0f - (r6 / r7);
    L22:
        if (this.mAnimating == false) goto L25;
        if (r1 != 1) goto L25;
        return 1.0f;
    }

    private float getEdgeValue(float r2, float r3, float r4, float r5) {
        float r6 = constrain(r2 * r3, 0.0f, r4);
        float r7 = constrainEdgeValue(r5, r6);
        float r8 = constrainEdgeValue(r3 - r5, r6) - r7;
        if (r8 >= 0.0f) goto L6;
        float r1 = -this.mEdgeInterpolator.getInterpolation(-r8);
    L9:
        return constrain(r1, -1.0f, 1.0f);
    L6:
        if (r8 <= 0.0f) goto L10;
        r1 = this.mEdgeInterpolator.getInterpolation(r8);
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
        int r1 = this.mActivationDelay;
        if (r1 <= 0) goto L10;
        ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, r1);
    L11:
        this.mAlreadyDelayed = true;
        return;
    L10:
        this.mRunnable.run();
        goto L11
    }

    public abstract boolean canTargetScrollHorizontally(int r1);

    public abstract boolean canTargetScrollVertically(int r1);

    void cancelTargetTouch() {
        long r2 = SystemClock.uptimeMillis();
        MotionEvent r0 = MotionEvent.obtain(r2, r2, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(r0);
        r0.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r6, MotionEvent r7) {
        if (this.mEnabled == true) goto L5;
        return false;
    L5:
        int r0 = r7.getActionMasked();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L9;
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
        if (r0 != 2) goto L11;
    L15:
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, r7.getX(), r6.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, r7.getY(), r6.getHeight(), this.mTarget.getHeight()));
        if (this.mAnimating == true) goto L21;
        if (shouldAnimate() == false) goto L21;
        startAnimating();
        goto L21
    L11:
        if (r0 == 3) goto L13;
    L14:
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        goto L15
    }

    public abstract void scrollTargetBy(int r1, int r2);

    public AutoScrollHelper setActivationDelay(int r1) {
        this.mActivationDelay = r1;
        return this;
    }

    public AutoScrollHelper setEdgeType(int r1) {
        this.mEdgeType = r1;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean r2) {
        if (this.mEnabled == false) goto L6;
        if (r2 == true) goto L6;
        requestStop();
    L6:
        this.mEnabled = r2;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean r1) {
        this.mExclusive = r1;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float r3, float r4) {
        float[] r0 = this.mMaximumEdges;
        r0[0] = r3;
        r0[1] = r4;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float r4, float r5) {
        float[] r0 = this.mMaximumVelocity;
        r0[0] = r4 / 1000.0f;
        r0[1] = r5 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float r4, float r5) {
        float[] r0 = this.mMinimumVelocity;
        r0[0] = r4 / 1000.0f;
        r0[1] = r5 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int r2) {
        this.mScroller.setRampDownDuration(r2);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int r2) {
        this.mScroller.setRampUpDuration(r2);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float r3, float r4) {
        float[] r0 = this.mRelativeEdges;
        r0[0] = r3;
        r0[1] = r4;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float r4, float r5) {
        float[] r0 = this.mRelativeVelocity;
        r0[0] = r4 / 1000.0f;
        r0[1] = r5 / 1000.0f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller r0 = this.mScroller;
        int r1 = r0.getVerticalDirection();
        int r2 = r0.getHorizontalDirection();
        if (r1 != 0) goto L5;
    L6:
        if (r2 != 0) goto L8;
    L10:
        return false;
    L8:
        if (canTargetScrollHorizontally(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (canTargetScrollVertically(r1) == true) goto L9;
        goto L6
    }
}
