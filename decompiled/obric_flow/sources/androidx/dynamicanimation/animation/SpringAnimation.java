package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder r5) {
        super(r5);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    private void sanityCheck() {
        SpringForce r5 = this.mSpring;
        if (r5 == null) goto L14;
        double r10 = r5.getFinalPosition();
        if (r10 > this.mMaxValue) goto L12;
        if (r10 < this.mMinValue) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float r5) {
        if (isRunning() == false) goto L6;
        this.mPendingPosition = r5;
        return;
    L6:
        if (this.mSpring != null) goto L8;
        this.mSpring = new SpringForce(r5);
    L8:
        this.mSpring.setFinalPosition(r5);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float r5, float r10) {
        return this.mSpring.getAcceleration(r5, r10);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float r5, float r10) {
        return this.mSpring.isAtEquilibrium(r5, r10);
    }

    public SpringAnimation setSpring(SpringForce r5) {
        this.mSpring = r5;
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float r5) {
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
    public boolean updateValueAndVelocity(long r21) {
        if (this.mEndRequested == false) goto L10;
        float r5 = this.mPendingPosition;
        if (r5 == Float.MAX_VALUE) goto L7;
        this.mSpring.setFinalPosition(r5);
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
        DynamicAnimation.MassState r10 = this.mSpring.updateValues(this.mValue, this.mVelocity, r18);
        this.mSpring.setFinalPosition(this.mPendingPosition);
        this.mPendingPosition = Float.MAX_VALUE;
        DynamicAnimation.MassState r11 = this.mSpring.updateValues(r10.mValue, r10.mVelocity, r18);
        this.mValue = r11.mValue;
        this.mVelocity = r11.mVelocity;
    L13:
        float r12 = Math.max(this.mValue, this.mMinValue);
        this.mValue = r12;
        float r13 = Math.min(r12, this.mMaxValue);
        this.mValue = r13;
        if (isAtEquilibrium(r13, this.mVelocity) == false) goto L17;
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    L17:
        return false;
    L12:
        DynamicAnimation.MassState r14 = this.mSpring.updateValues(this.mValue, this.mVelocity, r21);
        this.mValue = r14.mValue;
        this.mVelocity = r14.mVelocity;
        goto L13
    }

    public <K> SpringAnimation(K r5, FloatPropertyCompat<K> r10) {
        super(r5, r10);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r5, FloatPropertyCompat<K> r10, float r11) {
        super(r5, r10);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(r11);
    }
}
