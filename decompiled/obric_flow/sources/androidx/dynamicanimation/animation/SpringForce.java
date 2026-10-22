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

    private void init() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mFinalPosition == Double.MAX_VALUE) goto L18;
        double r5 = this.mDampingRatio;
        if (r5 <= 1.0d) goto L11;
        double r10 = this.mNaturalFreq;
        double r11 = (-r5) * r10;
        this.mGammaPlus = (Math.sqrt((r5 * r5) - 1.0d) * r10) + r11;
        double r12 = this.mDampingRatio;
        double r13 = this.mNaturalFreq;
        this.mGammaMinus = ((-r12) * r13) - (Math.sqrt((r12 * r12) - 1.0d) * r13);
    L15:
        this.mInitialized = true;
        return;
    L11:
        if (r5 < 0.0d) goto L15;
        if (r5 >= 1.0d) goto L15;
        double r14 = this.mNaturalFreq;
        this.mDampedFreq = Math.sqrt(1.0d - (r5 * r5)) * r14;
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float r10, float r11) {
        float r12 = r10 - getFinalPosition();
        double r5 = this.mNaturalFreq;
        double r13 = r5 * r5;
        double r14 = (r5 * 2.0d) * this.mDampingRatio;
        return (float) (((-r13) * ((double) r12)) - (r14 * ((double) r11)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double r5 = this.mNaturalFreq;
        return (float) (r5 * r5);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float r5, float r10) {
        if (Math.abs(r10) < this.mVelocityThreshold) goto L5;
        return false;
    L5:
        if (Math.abs(r5 - getFinalPosition()) >= this.mValueThreshold) goto L10;
        return true;
    L10:
        return false;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float r5) {
        if (r5 < 0.0f) goto L7;
        this.mDampingRatio = r5;
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float r5) {
        this.mFinalPosition = r5;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float r5) {
        if (r5 <= 0.0f) goto L7;
        this.mNaturalFreq = Math.sqrt(r5);
        this.mInitialized = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void setValueThreshold(double r5) {
        double r10 = Math.abs(r5);
        this.mValueThreshold = r10;
        this.mVelocityThreshold = r10 * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation.MassState updateValues(double r17, double r19, long r21) {
        init();
        double r5 = r21 / 1000.0d;
        double r10 = r17 - this.mFinalPosition;
        double r11 = this.mDampingRatio;
        if (r11 <= 1.0d) goto L6;
        double r12 = this.mGammaMinus;
        double r13 = this.mGammaPlus;
        double r14 = r10 - (((r12 * r10) - r19) / (r12 - r13));
        double r15 = ((r10 * r12) - r19) / (r12 - r13);
        double r16 = (Math.pow(2.718281828459045d, this.mGammaPlus * r5) * r15) + (Math.pow(2.718281828459045d, r12 * r5) * r14);
        double r18 = this.mGammaMinus;
        double r20 = Math.pow(2.718281828459045d, r18 * r5) * (r14 * r18);
        double r22 = this.mGammaPlus;
        double r23 = (Math.pow(2.718281828459045d, r22 * r5) * (r15 * r22)) + r20;
    L9:
        DynamicAnimation.MassState r24 = this.mMassState;
        r24.mValue = (float) (r16 + this.mFinalPosition);
        r24.mVelocity = (float) r23;
        return r24;
    L6:
        if (r11 != 1.0d) goto L8;
        double r25 = this.mNaturalFreq;
        double r26 = (r25 * r10) + r19;
        double r110 = (r26 * r5) + r10;
        double r27 = Math.pow(2.718281828459045d, (-r25) * r5) * r110;
        double r28 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * r5) * r110;
        double r111 = this.mNaturalFreq;
        r23 = (Math.pow(2.718281828459045d, (-r111) * r5) * r26) + (r28 * (-r111));
        r16 = r27;
        goto L9
    L8:
        double r29 = 1.0d / this.mDampedFreq;
        double r112 = this.mNaturalFreq;
        double r113 = (((r11 * r112) * r10) + r19) * r29;
        double r114 = ((Math.sin(this.mDampedFreq * r5) * r113) + (Math.cos(this.mDampedFreq * r5) * r10)) * Math.pow(2.718281828459045d, ((-r11) * r112) * r5);
        double r30 = this.mNaturalFreq;
        double r115 = this.mDampingRatio;
        double r31 = ((-r30) * r114) * r115;
        double r32 = Math.pow(2.718281828459045d, ((-r115) * r30) * r5);
        double r33 = this.mDampedFreq;
        double r34 = Math.sin(r33 * r5) * ((-r33) * r10);
        double r35 = this.mDampedFreq;
        r23 = (((Math.cos(r35 * r5) * (r113 * r35)) + r34) * r32) + r31;
        r16 = r114;
        goto L9
    }

    public SpringForce(float r5) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = r5;
    }
}
