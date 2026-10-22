package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction;
        private final DynamicAnimation.MassState mMassState;
        private float mVelocityThreshold;

        public DragForce() {
            this.mFriction = DEFAULT_FRICTION;
            this.mMassState = new DynamicAnimation.MassState();
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float r5, float r10) {
            return r10 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float r5, float r10) {
            if (Math.abs(r10) >= this.mVelocityThreshold) goto L5;
            return true;
        L5:
            return false;
        }

        public void setFrictionScalar(float r5) {
            this.mFriction = r5 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float r5) {
            this.mVelocityThreshold = r5 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float r10, float r11, long r12) {
            float r13 = r12;
            this.mMassState.mVelocity = (float) (Math.exp((r13 / 1000.0f) * this.mFriction) * ((double) r11));
            DynamicAnimation.MassState r5 = this.mMassState;
            float r14 = this.mFriction;
            r5.mValue = (float) ((Math.exp((r14 * r13) / 1000.0f) * (r11 / r14)) + (r10 - (r11 / r14)));
            DynamicAnimation.MassState r15 = this.mMassState;
            if (isAtEquilibrium(r15.mValue, r15.mVelocity) == false) goto L6;
            this.mMassState.mVelocity = 0.0f;
        L6:
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder r5) {
        super(r5);
        DragForce r10 = new DragForce();
        this.mFlingForce = r10;
        r10.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float r5, float r10) {
        return this.mFlingForce.getAcceleration(r5, r10);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float r5, float r10) {
        if (r5 < this.mMaxValue) goto L5;
    L10:
        return true;
    L5:
        if (r5 <= this.mMinValue) goto L10;
        if (this.mFlingForce.isAtEquilibrium(r5, r10) == true) goto L10;
        return false;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float r5) {
        if (r5 <= 0.0f) goto L7;
        this.mFlingForce.setFrictionScalar(r5);
        return this;
    L7:
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMaxValue(float r5) {
        return setMaxValue(r5);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMinValue(float r5) {
        return setMinValue(r5);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setStartVelocity(float r5) {
        return setStartVelocity(r5);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float r5) {
        this.mFlingForce.setValueThreshold(r5);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long r5) {
        DynamicAnimation.MassState r10 = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, r5);
        float r11 = r10.mValue;
        this.mValue = r11;
        float r12 = r10.mVelocity;
        this.mVelocity = r12;
        float r13 = this.mMinValue;
        if (r11 >= r13) goto L6;
        this.mValue = r13;
        return true;
    L6:
        float r14 = this.mMaxValue;
        if (r11 <= r14) goto L11;
        this.mValue = r14;
        return true;
    L11:
        if (isAtEquilibrium(r11, r12) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float r5) {
        super.setMaxValue(r5);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float r5) {
        super.setMinValue(r5);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float r5) {
        super.setStartVelocity(r5);
        return this;
    }

    public <K> FlingAnimation(K r5, FloatPropertyCompat<K> r10) {
        super(r5, r10);
        DragForce r11 = new DragForce();
        this.mFlingForce = r11;
        r11.setValueThreshold(getValueThreshold());
    }
}
