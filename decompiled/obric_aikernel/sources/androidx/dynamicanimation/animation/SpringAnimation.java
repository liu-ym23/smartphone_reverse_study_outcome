package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder r10) {
        super(r10);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r10, FloatPropertyCompat<K> r11) {
        super(r10, r11);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K r10, FloatPropertyCompat<K> r11, float r12) {
        super(r10, r11);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(r12);
    }

    private void sanityCheck() {
        SpringForce r10 = this.mSpring;
        if (r10 == null) goto L14;
        double r11 = r10.getFinalPosition();
        if (r11 > this.mMaxValue) goto L12;
        if (r11 < this.mMinValue) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float r10) {
        if (isRunning() == false) goto L6;
        this.mPendingPosition = r10;
        return;
    L6:
        if (this.mSpring != null) goto L8;
        this.mSpring = new SpringForce(r10);
    L8:
        this.mSpring.setFinalPosition(r10);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float r10, float r11) {
        return this.mSpring.getAcceleration(r10, r11);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float r10, float r11) {
        return this.mSpring.isAtEquilibrium(r10, r11);
    }

    public SpringAnimation setSpring(SpringForce r10) {
        this.mSpring = r10;
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float r10) {
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
        float r10 = this.mPendingPosition;
        if (r10 == Float.MAX_VALUE) goto L7;
        this.mSpring.setFinalPosition(r10);
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
        DynamicAnimation.MassState r11 = this.mSpring.updateValues(this.mValue, this.mVelocity, r18);
        this.mSpring.setFinalPosition(this.mPendingPosition);
        this.mPendingPosition = Float.MAX_VALUE;
        SpringForce r13 = this.mSpring;
        double r14 = r11.mValue;
        double r16 = r11.mVelocity;
    L13:
        DynamicAnimation.MassState r12 = r13.updateValues(r14, r16, r18);
        this.mValue = r12.mValue;
        this.mVelocity = r12.mVelocity;
        float r15 = Math.max(this.mValue, this.mMinValue);
        this.mValue = r15;
        float r17 = Math.min(r15, this.mMaxValue);
        this.mValue = r17;
        if (isAtEquilibrium(r17, this.mVelocity) == false) goto L17;
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
