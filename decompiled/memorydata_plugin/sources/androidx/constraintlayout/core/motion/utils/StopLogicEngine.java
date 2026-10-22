package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards;
    private boolean mDone;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    public StopLogicEngine() {
        this.mBackwards = false;
        this.mDone = false;
    }

    private float calcY(float r6) {
        this.mDone = false;
        float r0 = this.mStage1Duration;
        if (r6 > r0) goto L6;
        float r1 = this.mStage1Velocity;
        return (r1 * r6) + ((((this.mStage2Velocity - r1) * r6) * r6) / (r0 * 2.0f));
    L6:
        int r2 = this.mNumberOfStages;
        if (r2 == 1) goto L9;
        float r7 = r6 - r0;
        float r3 = this.mStage2Duration;
        if (r7 >= r3) goto L15;
        float r4 = this.mStage1EndPosition;
        float r5 = this.mStage2Velocity;
        return (r4 + (r5 * r7)) + ((((this.mStage3Velocity - r5) * r7) * r7) / (r3 * 2.0f));
    L15:
        if (r2 == 2) goto L17;
        float r8 = r7 - r3;
        float r9 = this.mStage3Duration;
        if (r8 > r9) goto L22;
        float r10 = this.mStage2EndPosition;
        float r11 = this.mStage3Velocity;
        return (r10 + (r11 * r8)) - (((r11 * r8) * r8) / (r9 * 2.0f));
    L22:
        this.mDone = true;
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    L9:
        return this.mStage1EndPosition;
    }

    private void setup(float r9, float r10, float r11, float r12, float r13) {
        this.mDone = false;
        if (r9 != 0.0f) goto L5;
        r9 = 1.0E-4f;
    L5:
        this.mStage1Velocity = r9;
        float r1 = r9 / r11;
        float r2 = (r1 * r9) / 2.0f;
        if (r9 >= 0.0f) goto L14;
        float r14 = (float) Math.sqrt((r10 - ((((-r9) / r11) * r9) / 2.0f)) * r11);
        if (r14 >= r12) goto L11;
        this.mType = "backward accelerate, decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = r14;
        this.mStage3Velocity = 0.0f;
        float r15 = (r14 - r9) / r11;
        this.mStage1Duration = r15;
        this.mStage2Duration = r14 / r11;
        this.mStage1EndPosition = ((r9 + r14) * r15) / 2.0f;
        this.mStage2EndPosition = r10;
        this.mStage3EndPosition = r10;
        return;
    L11:
        this.mType = "backward accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = r12;
        this.mStage3Velocity = r12;
        float r16 = (r12 - r9) / r11;
        this.mStage1Duration = r16;
        float r17 = r12 / r11;
        this.mStage3Duration = r17;
        float r18 = ((r9 + r12) * r16) / 2.0f;
        float r19 = (r17 * r12) / 2.0f;
        this.mStage2Duration = ((r10 - r18) - r19) / r12;
        this.mStage1EndPosition = r18;
        this.mStage2EndPosition = r10 - r19;
        this.mStage3EndPosition = r10;
        return;
    L14:
        if (r2 < r10) goto L17;
        this.mType = "hard stop";
        this.mNumberOfStages = 1;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = 0.0f;
        this.mStage1EndPosition = r10;
        this.mStage1Duration = (2.0f * r10) / r9;
        return;
    L17:
        float r3 = r10 - r2;
        float r4 = r3 / r9;
        if ((r4 + r1) >= r13) goto L21;
        this.mType = "cruse decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = r9;
        this.mStage3Velocity = 0.0f;
        this.mStage1EndPosition = r3;
        this.mStage2EndPosition = r10;
        this.mStage1Duration = r4;
        this.mStage2Duration = r1;
        return;
    L21:
        float r110 = (float) Math.sqrt((r11 * r10) + ((r9 * r9) / 2.0f));
        float r5 = (r110 - r9) / r11;
        this.mStage1Duration = r5;
        float r6 = r110 / r11;
        this.mStage2Duration = r6;
        if (r110 >= r12) goto L25;
        this.mType = "accelerate decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = r110;
        this.mStage3Velocity = 0.0f;
        this.mStage1Duration = r5;
        this.mStage2Duration = r6;
        this.mStage1EndPosition = ((r9 + r110) * r5) / 2.0f;
        this.mStage2EndPosition = r10;
        return;
    L25:
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r9;
        this.mStage2Velocity = r12;
        this.mStage3Velocity = r12;
        float r111 = (r12 - r9) / r11;
        this.mStage1Duration = r111;
        float r112 = r12 / r11;
        this.mStage3Duration = r112;
        float r20 = ((r9 + r12) * r111) / 2.0f;
        float r113 = (r112 * r12) / 2.0f;
        this.mStage2Duration = ((r10 - r20) - r113) / r12;
        this.mStage1EndPosition = r20;
        this.mStage2EndPosition = r10 - r113;
        this.mStage3EndPosition = r10;
    }

    public void config(float r7, float r8, float r9, float r10, float r11, float r12) {
        boolean r2 = false;
        this.mDone = false;
        this.mStartPosition = r7;
        if (r7 <= r8) goto L5;
        r2 = true;
    L5:
        this.mBackwards = r2;
        if (r2 == false) goto L8;
        float r3 = r7 - r8;
        float r1 = -r9;
    L9:
        setup(r1, r3, r11, r12, r10);
        return;
    L8:
        r3 = r8 - r7;
        r1 = r9;
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r9, float r10) {
        StringBuilder r0 = new StringBuilder().append(r9 + " ===== " + this.mType + "\n").append(r9);
        if (this.mBackwards == false) goto L5;
        String r2 = "backwards";
    L6:
        String r1 = r0.append(r2).append(" time = ").append(r10).append("  stages ").append(this.mNumberOfStages).append("\n").toString() + r9 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages <= 1) goto L10;
        r1 = r1 + r9 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
    L10:
        if (this.mNumberOfStages <= 2) goto L12;
        r1 = r1 + r9 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
    L12:
        float r3 = this.mStage1Duration;
        if (r10 > r3) goto L17;
        StringBuilder r8 = new StringBuilder().append(r1).append(r9);
        String r11 = "stage 0\n";
    L16:
        return r8.append(r11).toString();
    L17:
        int r4 = this.mNumberOfStages;
        if (r4 != 1) goto L20;
        r8 = new StringBuilder().append(r1).append(r9);
        r11 = "end stage 0\n";
        goto L16
    L20:
        float r12 = r10 - r3;
        float r5 = this.mStage2Duration;
        if (r12 >= r5) goto L23;
        r8 = new StringBuilder().append(r1).append(r9);
        r11 = " stage 1\n";
        goto L16
    L23:
        if (r4 != 2) goto L26;
        r8 = new StringBuilder().append(r1).append(r9);
        r11 = "end stage 1\n";
        goto L16
    L26:
        if ((r12 - r5) >= this.mStage3Duration) goto L28;
        r8 = new StringBuilder().append(r1).append(r9);
        r11 = " stage 2\n";
        goto L16
    L28:
        r8 = new StringBuilder().append(r1).append(r9);
        r11 = " end stage 2\n";
        goto L16
    L5:
        r2 = "forward ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r2) {
        float r0 = calcY(r2);
        this.mLastPosition = r2;
        boolean r3 = this.mBackwards;
        float r1 = this.mStartPosition;
        if (r3 == false) goto L6;
        return r1 - r0;
    L6:
        return r1 + r0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        if (this.mBackwards == false) goto L6;
        return -getVelocity(this.mLastPosition);
    L6:
        return getVelocity(this.mLastPosition);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r4) {
        float r0 = this.mStage1Duration;
        if (r4 > r0) goto L7;
        float r1 = this.mStage1Velocity;
        float r3 = this.mStage2Velocity;
    L6:
        return r1 + (((r3 - r1) * r4) / r0);
    L7:
        int r2 = this.mNumberOfStages;
        if (r2 != 1) goto L11;
        return 0.0f;
    L11:
        r4 = r4 - r0;
        r0 = this.mStage2Duration;
        if (r4 >= r0) goto L15;
        r1 = this.mStage2Velocity;
        r3 = this.mStage3Velocity;
        goto L6
    L15:
        if (r2 == 2) goto L17;
        float r5 = r4 - r0;
        float r6 = this.mStage3Duration;
        if (r5 >= r6) goto L23;
        float r7 = this.mStage3Velocity;
        return r7 - ((r5 * r7) / r6);
    L23:
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        if (getVelocity() < EPSILON) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.mStage3EndPosition - this.mLastPosition) >= EPSILON) goto L7;
        return true;
    }
}
