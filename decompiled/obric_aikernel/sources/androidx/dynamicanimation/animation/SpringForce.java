package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float r10) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = r10;
    }

    private void init() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mFinalPosition == Double.MAX_VALUE) goto L18;
        double r10 = this.mDampingRatio;
        if (r10 <= 1.0d) goto L11;
        double r11 = this.mNaturalFreq;
        this.mGammaPlus = ((-r10) * r11) + (r11 * Math.sqrt((r10 * r10) - 1.0d));
        double r12 = this.mDampingRatio;
        double r13 = this.mNaturalFreq;
        this.mGammaMinus = ((-r12) * r13) - (r13 * Math.sqrt((r12 * r12) - 1.0d));
    L15:
        this.mInitialized = true;
        return;
    L11:
        if (r10 < 0.0d) goto L15;
        if (r10 >= 1.0d) goto L15;
        this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (r10 * r10));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float r10, float r11) {
        float r12 = r10 - getFinalPosition();
        double r13 = this.mNaturalFreq;
        double r14 = r13 * r13;
        double r15 = (r13 * 2.0d) * this.mDampingRatio;
        return (float) (((-r14) * ((double) r12)) - (r15 * ((double) r11)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double r10 = this.mNaturalFreq;
        return (float) (r10 * r10);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float r10, float r11) {
        if (Math.abs(r11) < this.mVelocityThreshold) goto L5;
        return false;
    L5:
        if (Math.abs(r10 - getFinalPosition()) >= this.mValueThreshold) goto L10;
        return true;
    L10:
        return false;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float r10) {
        if (r10 < 0.0f) goto L7;
        this.mDampingRatio = r10;
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float r10) {
        this.mFinalPosition = r10;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float r10) {
        if (r10 <= 0.0f) goto L7;
        this.mNaturalFreq = Math.sqrt(r10);
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void setValueThreshold(double r10) {
        double r11 = Math.abs(r10);
        this.mValueThreshold = r11;
        this.mVelocityThreshold = r11 * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    DynamicAnimation.MassState updateValues(double r17, double r19, long r21) {
        init();
        double r10 = r21 / 1000.0d;
        double r11 = r17 - this.mFinalPosition;
        double r12 = this.mDampingRatio;
        if (r12 <= 1.0d) goto L6;
        double r13 = this.mGammaMinus;
        double r14 = this.mGammaPlus;
        double r15 = r11 - (((r13 * r11) - r19) / (r13 - r14));
        double r16 = ((r11 * r13) - r19) / (r13 - r14);
        double r18 = (Math.pow(2.718281828459045d, r13 * r10) * r15) + (Math.pow(2.718281828459045d, this.mGammaPlus * r10) * r16);
        double r110 = this.mGammaMinus;
        double r20 = (r15 * r110) * Math.pow(2.718281828459045d, r110 * r10);
        double r111 = this.mGammaPlus;
        double r22 = r20 + ((r16 * r111) * Math.pow(2.718281828459045d, r111 * r10));
    L9:
        DynamicAnimation.MassState r23 = this.mMassState;
        r23.mValue = (float) (r18 + this.mFinalPosition);
        r23.mVelocity = (float) r22;
        return r23;
    L6:
        if (r12 != 1.0d) goto L8;
        double r24 = this.mNaturalFreq;
        double r25 = r19 + (r24 * r11);
        double r26 = r11 + (r25 * r10);
        r18 = Math.pow(2.718281828459045d, (-r24) * r10) * r26;
        double r27 = r26 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * r10);
        double r112 = this.mNaturalFreq;
        r22 = (r25 * Math.pow(2.718281828459045d, (-r112) * r10)) + (r27 * (-r112));
        goto L9
    L8:
        double r28 = 1.0d / this.mDampedFreq;
        double r113 = this.mNaturalFreq;
        double r29 = r28 * (((r12 * r113) * r11) + r19);
        double r30 = Math.pow(2.718281828459045d, ((-r12) * r113) * r10) * ((Math.cos(this.mDampedFreq * r10) * r11) + (Math.sin(this.mDampedFreq * r10) * r29));
        double r114 = this.mNaturalFreq;
        double r115 = this.mDampingRatio;
        double r116 = ((-r114) * r30) * r115;
        double r31 = Math.pow(2.718281828459045d, ((-r115) * r114) * r10);
        double r117 = this.mDampedFreq;
        double r32 = ((-r117) * r11) * Math.sin(r117 * r10);
        double r33 = this.mDampedFreq;
        r22 = r116 + (r31 * (r32 + ((r29 * r33) * Math.cos(r33 * r10))));
        r18 = r30;
        goto L9
    }
}
