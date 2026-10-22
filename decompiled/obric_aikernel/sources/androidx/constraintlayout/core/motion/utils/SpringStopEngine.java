package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private int mBoundaryMode;
    double mDamping;
    private boolean mInitialized;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    public SpringStopEngine() {
        this.mDamping = 0.5d;
        this.mInitialized = false;
        this.mBoundaryMode = 0;
    }

    private void compute(double r25) {
        double r10 = this.mStiffness;
        double r11 = this.mDamping;
        int r12 = (int) ((9.0d / ((Math.sqrt(r10 / ((double) this.mMass)) * r25) * 4.0d)) + 1.0d);
        double r13 = r25 / ((double) r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L17;
        float r15 = this.mPos;
        double r16 = this.mTargetPos;
        double r17 = -r10;
        double r18 = r17 * (((double) r15) - r16);
        float r19 = this.mV;
        double r110 = r10;
        double r111 = r18 - (((double) r19) * r11);
        float r20 = this.mMass;
        double r112 = r11;
        double r113 = r111 / ((double) r20);
        double r21 = ((double) r19) + ((r113 * r13) / 2.0d);
        double r114 = ((((-((((double) r15) + ((r13 * r21) / 2.0d)) - r16)) * r110) - (r21 * r112)) / ((double) r20)) * r13;
        double r22 = ((double) r19) + (r114 / 2.0d);
        float r23 = (float) (((double) r19) + r114);
        this.mV = r23;
        float r24 = (float) (((double) r15) + (r22 * r13));
        this.mPos = r24;
        int r26 = this.mBoundaryMode;
        if (r26 <= 0) goto L16;
        if (r24 < 0.0f) goto L9;
    L11:
        float r27 = this.mPos;
        if (r27 <= 1.0f) goto L16;
        if ((r26 & 2) != 2) goto L16;
        this.mPos = 2.0f - r27;
        this.mV = -this.mV;
        goto L16
    L9:
        if ((r26 & 1) != 1) goto L11;
        this.mPos = -r24;
        this.mV = -r23;
    L16:
        r14 = r14 + 1;
        r10 = r110;
        r11 = r112;
        goto L3
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        return null;
    }

    public float getAcceleration() {
        double r10 = this.mStiffness;
        double r11 = this.mDamping;
        double r12 = -r10;
        return ((float) ((r12 * (((double) this.mPos) - this.mTargetPos)) - (r11 * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        compute(r10 - this.mLastTime);
        this.mLastTime = r10;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        return this.mV;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double r10 = ((double) this.mPos) - this.mTargetPos;
        double r11 = this.mStiffness;
        double r12 = this.mV;
        if (Math.sqrt((((r12 * r12) * ((double) this.mMass)) + ((r11 * r10) * r10)) / r11) > this.mStopThreshold) goto L5;
        return true;
    L5:
        return false;
    }

    void log(String r10) {
        StackTraceElement r11 = new Throwable().getStackTrace()[1];
        String r12 = ".(" + r11.getFileName() + ":" + r11.getLineNumber() + ") " + r11.getMethodName() + "() ";
        System.out.println(r12 + r10);
    }

    public void springConfig(float r10, float r11, float r12, float r13, float r14, float r15, float r16, int r17) {
        this.mTargetPos = r11;
        this.mDamping = r15;
        this.mInitialized = false;
        this.mPos = r10;
        this.mLastVelocity = r12;
        this.mStiffness = r14;
        this.mMass = r13;
        this.mStopThreshold = r16;
        this.mBoundaryMode = r17;
        this.mLastTime = 0.0f;
    }
}
