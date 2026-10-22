package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder r1) {
        super(r1);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r1, FloatPropertyCompat<K> r2) {
        super(r1, r2);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r1, FloatPropertyCompat<K> r2, float r3) {
        super(r1, r2);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(r3);
    }

    private void sanityCheck() {
        SpringForce r0 = this.mSpring;
        if (r0 == null) goto L14;
        double r1 = r0.getFinalPosition();
        if (r1 > this.mMaxValue) goto L12;
        if (r1 < this.mMinValue) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float r2) {
        if (isRunning() == false) goto L6;
        this.mPendingPosition = r2;
        return;
    L6:
        if (this.mSpring != null) goto L8;
        this.mSpring = new SpringForce(r2);
    L8:
        this.mSpring.setFinalPosition(r2);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float r1, float r2) {
        return this.mSpring.getAcceleration(r1, r2);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float r1, float r2) {
        return this.mSpring.isAtEquilibrium(r1, r2);
    }

    public SpringAnimation setSpring(SpringForce r1) {
        this.mSpring = r1;
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float r1) {
    }

    public void skipToEnd() {
        if (canSkipToEnd() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.mRunning == false) goto L14;
        this.mEndRequested = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold(getValueThreshold());
        super.start();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long r21) {
        if (this.mEndRequested == false) goto L10;
        float r1 = this.mPendingPosition;
        if (r1 == Float.MAX_VALUE) goto L7;
        this.mSpring.setFinalPosition(r1);
        this.mPendingPosition = Float.MAX_VALUE;
    L7:
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        this.mEndRequested = false;
        return true;
    L10:
        if (this.mPendingPosition == Float.MAX_VALUE) goto L12;
        this.mSpring.getFinalPosition();
        long r18 = r21 / 2;
        DynamicAnimation.MassState r2 = this.mSpring.updateValues(this.mValue, this.mVelocity, r18);
        this.mSpring.setFinalPosition(this.mPendingPosition);
        this.mPendingPosition = Float.MAX_VALUE;
        SpringForce r13 = this.mSpring;
        double r14 = r2.mValue;
        double r16 = r2.mVelocity;
    L13:
        DynamicAnimation.MassState r3 = r13.updateValues(r14, r16, r18);
        this.mValue = r3.mValue;
        this.mVelocity = r3.mVelocity;
        this.mValue = Math.max(this.mValue, this.mMinValue);
        this.mValue = Math.min(this.mValue, this.mMaxValue);
        if (isAtEquilibrium(this.mValue, this.mVelocity) == false) goto L17;
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    L17:
        return false;
    L12:
        r13 = this.mSpring;
        r14 = this.mValue;
        r16 = this.mVelocity;
        r18 = r21;
        goto L13
    }
}
