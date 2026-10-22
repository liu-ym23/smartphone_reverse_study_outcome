package androidx.dynamicanimation.animation;

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
        public float getAcceleration(float r1, float r2) {
            return r2 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float r1, float r2) {
            if (Math.abs(r2) >= this.mVelocityThreshold) goto L5;
            return true;
        L5:
            return false;
        }

        void setFrictionScalar(float r2) {
            this.mFriction = r2 * DEFAULT_FRICTION;
        }

        void setValueThreshold(float r2) {
            this.mVelocityThreshold = r2 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float r6, float r7, long r8) {
            float r9 = r8;
            this.mMassState.mVelocity = (float) (((double) r7) * Math.exp((r9 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState r0 = this.mMassState;
            float r1 = this.mFriction;
            r0.mValue = (float) (((double) (r6 - (r7 / r1))) + (((double) (r7 / r1)) * Math.exp((r1 * r9) / 1000.0f)));
            if (isAtEquilibrium(this.mMassState.mValue, this.mMassState.mVelocity) == false) goto L6;
            this.mMassState.mVelocity = 0.0f;
        L6:
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder r1) {
        super(r1);
        DragForce r2 = new DragForce();
        this.mFlingForce = r2;
        r2.setValueThreshold(getValueThreshold());
    }

    public <K> FlingAnimation(K r1, FloatPropertyCompat<K> r2) {
        super(r1, r2);
        DragForce r3 = new DragForce();
        this.mFlingForce = r3;
        r3.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float r1, float r2) {
        return this.mFlingForce.getAcceleration(r1, r2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float r2, float r3) {
        if (r2 < this.mMaxValue) goto L5;
    L10:
        return true;
    L5:
        if (r2 <= this.mMinValue) goto L10;
        if (this.mFlingForce.isAtEquilibrium(r2, r3) == true) goto L10;
        return false;
    }

    public FlingAnimation setFriction(float r2) {
        if (r2 <= 0.0f) goto L7;
        this.mFlingForce.setFrictionScalar(r2);
        return this;
    L7:
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMaxValue(float r1) {
        return setMaxValue(r1);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float r1) {
        super.setMaxValue(r1);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setMinValue(float r1) {
        return setMinValue(r1);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float r1) {
        super.setMinValue(r1);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ DynamicAnimation setStartVelocity(float r1) {
        return setStartVelocity(r1);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float r1) {
        super.setStartVelocity(r1);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float r1) {
        this.mFlingForce.setValueThreshold(r1);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long r4) {
        DynamicAnimation.MassState r5 = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, r4);
        this.mValue = r5.mValue;
        this.mVelocity = r5.mVelocity;
        if (this.mValue >= this.mMinValue) goto L8;
        float r6 = this.mMinValue;
    L5:
        this.mValue = r6;
        return true;
    L8:
        if (this.mValue <= this.mMaxValue) goto L11;
        r6 = this.mMaxValue;
        goto L5
    L11:
        if (isAtEquilibrium(this.mValue, this.mVelocity) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
