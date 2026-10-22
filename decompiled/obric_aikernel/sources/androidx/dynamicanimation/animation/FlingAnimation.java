package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction;
        private final DynamicAnimation.MassState mMassState;
        private float mVelocityThreshold;

        DragForce() {
            this.mFriction = DEFAULT_FRICTION;
            this.mMassState = new DynamicAnimation.MassState();
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float r10, float r11) {
            return r11 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float r10, float r11) {
            if (Math.abs(r11) >= this.mVelocityThreshold) goto L5;
            return true;
        L5:
            return false;
        }

        void setFrictionScalar(float r10) {
            this.mFriction = r10 * DEFAULT_FRICTION;
        }

        void setValueThreshold(float r10) {
            this.mVelocityThreshold = r10 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float r10, float r11, long r12) {
            float r13 = r12;
            this.mMassState.mVelocity = (float) (((double) r11) * Math.exp((r13 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState r14 = this.mMassState;
            float r15 = this.mFriction;
            r14.mValue = (float) (((double) (r10 - (r11 / r15))) + (((double) (r11 / r15)) * Math.exp((r15 * r13) / 1000.0f)));
            DynamicAnimation.MassState r16 = this.mMassState;
            if (isAtEquilibrium(r16.mValue, r16.mVelocity) == false) goto L6;
            this.mMassState.mVelocity = 0.0f;
        L6:
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder r10) {
        super(r10);
        DragForce r11 = new DragForce();
        this.mFlingForce = r11;
        r11.setValueThreshold(getValueThreshold());
    }

    public <K> FlingAnimation(K r10, FloatPropertyCompat<K> r11) {
        super(r10, r11);
        DragForce r12 = new DragForce();
        this.mFlingForce = r12;
        r12.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float r10, float r11) {
        return this.mFlingForce.getAcceleration(r10, r11);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float r10, float r11) {
        if (r10 < this.mMaxValue) goto L5;
    L10:
        return true;
    L5:
        if (r10 <= this.mMinValue) goto L10;
        if (this.mFlingForce.isAtEquilibrium(r10, r11) == true) goto L10;
        return false;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float r10) {
        if (r10 <= 0.0f) goto L7;
        this.mFlingForce.setFrictionScalar(r10);
        return this;
    L7:
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMaxValue(float r10) {
        return setMaxValue(r10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float r10) {
        super.setMaxValue(r10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMinValue(float r10) {
        return setMinValue(r10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float r10) {
        super.setMinValue(r10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setStartVelocity(float r10) {
        return setStartVelocity(r10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float r10) {
        super.setStartVelocity(r10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float r10) {
        this.mFlingForce.setValueThreshold(r10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long r10) {
        DynamicAnimation.MassState r11 = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, r10);
        float r12 = r11.mValue;
        this.mValue = r12;
        float r13 = r11.mVelocity;
        this.mVelocity = r13;
        float r14 = this.mMinValue;
        if (r12 >= r14) goto L6;
        this.mValue = r14;
        return true;
    L6:
        float r15 = this.mMaxValue;
        if (r12 <= r15) goto L11;
        this.mValue = r15;
        return true;
    L11:
        if (isAtEquilibrium(r12, r13) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
