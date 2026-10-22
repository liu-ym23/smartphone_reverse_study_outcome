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

    private float calcY(float r10) {
        this.mDone = false;
        float r11 = this.mStage1Duration;
        if (r10 > r11) goto L6;
        float r12 = this.mStage1Velocity;
        return (r12 * r10) + ((((this.mStage2Velocity - r12) * r10) * r10) / (r11 * 2.0f));
    L6:
        int r13 = this.mNumberOfStages;
        if (r13 == 1) goto L9;
        float r14 = r10 - r11;
        float r15 = this.mStage2Duration;
        if (r14 >= r15) goto L15;
        float r16 = this.mStage1EndPosition;
        float r17 = this.mStage2Velocity;
        return (r16 + (r17 * r14)) + ((((this.mStage3Velocity - r17) * r14) * r14) / (r15 * 2.0f));
    L15:
        if (r13 == 2) goto L17;
        float r18 = r14 - r15;
        float r19 = this.mStage3Duration;
        if (r18 > r19) goto L22;
        float r20 = this.mStage2EndPosition;
        float r21 = this.mStage3Velocity;
        return (r20 + (r21 * r18)) - (((r21 * r18) * r18) / (r19 * 2.0f));
    L22:
        this.mDone = true;
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    L9:
        return this.mStage1EndPosition;
    }

    private void setup(float r10, float r11, float r12, float r13, float r14) {
        this.mDone = false;
        if (r10 != 0.0f) goto L5;
        r10 = 1.0E-4f;
    L5:
        this.mStage1Velocity = r10;
        float r15 = r10 / r12;
        float r16 = (r15 * r10) / 2.0f;
        if (r10 >= 0.0f) goto L14;
        float r17 = (float) Math.sqrt((r11 - ((((-r10) / r12) * r10) / 2.0f)) * r12);
        if (r17 >= r13) goto L11;
        this.mType = "backward accelerate, decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r17;
        this.mStage3Velocity = 0.0f;
        float r18 = (r17 - r10) / r12;
        this.mStage1Duration = r18;
        this.mStage2Duration = r17 / r12;
        this.mStage1EndPosition = ((r10 + r17) * r18) / 2.0f;
        this.mStage2EndPosition = r11;
        this.mStage3EndPosition = r11;
        return;
    L11:
        this.mType = "backward accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r13;
        this.mStage3Velocity = r13;
        float r19 = (r13 - r10) / r12;
        this.mStage1Duration = r19;
        float r110 = r13 / r12;
        this.mStage3Duration = r110;
        float r20 = ((r10 + r13) * r19) / 2.0f;
        float r111 = (r110 * r13) / 2.0f;
        this.mStage2Duration = ((r11 - r20) - r111) / r13;
        this.mStage1EndPosition = r20;
        this.mStage2EndPosition = r11 - r111;
        this.mStage3EndPosition = r11;
        return;
    L14:
        if (r16 < r11) goto L17;
        this.mType = "hard stop";
        this.mNumberOfStages = 1;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = 0.0f;
        this.mStage1EndPosition = r11;
        this.mStage1Duration = (2.0f * r11) / r10;
        return;
    L17:
        float r21 = r11 - r16;
        float r22 = r21 / r10;
        if ((r22 + r15) >= r14) goto L21;
        this.mType = "cruse decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r10;
        this.mStage3Velocity = 0.0f;
        this.mStage1EndPosition = r21;
        this.mStage2EndPosition = r11;
        this.mStage1Duration = r22;
        this.mStage2Duration = r15;
        return;
    L21:
        float r112 = (float) Math.sqrt((r12 * r11) + ((r10 * r10) / 2.0f));
        float r23 = (r112 - r10) / r12;
        this.mStage1Duration = r23;
        float r24 = r112 / r12;
        this.mStage2Duration = r24;
        if (r112 >= r13) goto L25;
        this.mType = "accelerate decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r112;
        this.mStage3Velocity = 0.0f;
        this.mStage1Duration = r23;
        this.mStage2Duration = r24;
        this.mStage1EndPosition = ((r10 + r112) * r23) / 2.0f;
        this.mStage2EndPosition = r11;
        return;
    L25:
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r13;
        this.mStage3Velocity = r13;
        float r113 = (r13 - r10) / r12;
        this.mStage1Duration = r113;
        float r114 = r13 / r12;
        this.mStage3Duration = r114;
        float r25 = ((r10 + r13) * r113) / 2.0f;
        float r115 = (r114 * r13) / 2.0f;
        this.mStage2Duration = ((r11 - r25) - r115) / r13;
        this.mStage1EndPosition = r25;
        this.mStage2EndPosition = r11 - r115;
        this.mStage3EndPosition = r11;
    }

    public void config(float r10, float r11, float r12, float r13, float r14, float r15) {
        boolean r16 = false;
        this.mDone = false;
        this.mStartPosition = r10;
        if (r10 <= r11) goto L5;
        r16 = true;
    L5:
        this.mBackwards = r16;
        if (r16 == false) goto L8;
        float r17 = r10 - r11;
        float r18 = -r12;
    L9:
        setup(r18, r17, r14, r15, r13);
        return;
    L8:
        r17 = r11 - r10;
        r18 = r12;
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        String r12 = r10 + " ===== " + this.mType + "\n";
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        r13.append(r10);
        if (this.mBackwards == false) goto L5;
        String r14 = "backwards";
    L6:
        r13.append(r14);
        r13.append(" time = ");
        r13.append(r11);
        r13.append("  stages ");
        r13.append(this.mNumberOfStages);
        r13.append("\n");
        String r15 = r13.toString() + r10 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages <= 1) goto L10;
        r15 = r15 + r10 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
    L10:
        if (this.mNumberOfStages <= 2) goto L12;
        r15 = r15 + r10 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
    L12:
        float r16 = this.mStage1Duration;
        if (r11 > r16) goto L17;
        StringBuilder r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        String r18 = "stage 0\n";
    L15:
        r17.append(r18);
        return r17.toString();
    L17:
        int r19 = this.mNumberOfStages;
        if (r19 != 1) goto L20;
        r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        r18 = "end stage 0\n";
        goto L15
    L20:
        float r110 = r11 - r16;
        float r20 = this.mStage2Duration;
        if (r110 >= r20) goto L23;
        r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        r18 = " stage 1\n";
        goto L15
    L23:
        if (r19 != 2) goto L26;
        r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        r18 = "end stage 1\n";
        goto L15
    L26:
        if ((r110 - r20) >= this.mStage3Duration) goto L28;
        r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        r18 = " stage 2\n";
        goto L15
    L28:
        r17 = new StringBuilder();
        r17.append(r15);
        r17.append(r10);
        r18 = " end stage 2\n";
        goto L15
    L5:
        r14 = "forward ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        float r11 = calcY(r10);
        this.mLastPosition = r10;
        boolean r12 = this.mBackwards;
        float r13 = this.mStartPosition;
        if (r12 == false) goto L6;
        return r13 - r11;
    L6:
        return r13 + r11;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        if (this.mBackwards == false) goto L6;
        return -getVelocity(this.mLastPosition);
    L6:
        return getVelocity(this.mLastPosition);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        float r11 = this.mStage1Duration;
        if (r10 > r11) goto L7;
        float r12 = this.mStage1Velocity;
        float r13 = this.mStage2Velocity;
    L6:
        return r12 + (((r13 - r12) * r10) / r11);
    L7:
        int r14 = this.mNumberOfStages;
        if (r14 != 1) goto L11;
        return 0.0f;
    L11:
        r10 = r10 - r11;
        r11 = this.mStage2Duration;
        if (r10 >= r11) goto L15;
        r12 = this.mStage2Velocity;
        r13 = this.mStage3Velocity;
        goto L6
    L15:
        if (r14 == 2) goto L17;
        float r15 = r10 - r11;
        float r16 = this.mStage3Duration;
        if (r15 >= r16) goto L23;
        float r17 = this.mStage3Velocity;
        return r17 - ((r15 * r17) / r16);
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
