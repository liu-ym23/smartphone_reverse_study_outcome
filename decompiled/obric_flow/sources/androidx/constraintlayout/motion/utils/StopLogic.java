package androidx.constraintlayout.motion.utils;

import ai.j0;
import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards;
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

    public StopLogic() {
        this.mBackwards = false;
    }

    private float calcY(float r10) {
        float r5 = this.mStage1Duration;
        if (r10 > r5) goto L6;
        float r11 = this.mStage1Velocity;
        float r12 = (((this.mStage2Velocity - r11) * r10) * r10) / (r5 * 2.0f);
        return r12 + (r11 * r10);
    L6:
        int r13 = this.mNumberOfStages;
        if (r13 == 1) goto L9;
        float r14 = r10 - r5;
        float r15 = this.mStage2Duration;
        if (r14 >= r15) goto L15;
        float r16 = this.mStage1EndPosition;
        float r17 = this.mStage2Velocity;
        float r18 = (((this.mStage3Velocity - r17) * r14) * r14) / (r15 * 2.0f);
        return r18 + ((r17 * r14) + r16);
    L15:
        if (r13 == 2) goto L17;
        float r19 = r14 - r15;
        float r20 = this.mStage3Duration;
        if (r19 >= r20) goto L23;
        float r21 = this.mStage2EndPosition;
        float r22 = this.mStage3Velocity;
        return ((r22 * r19) + r21) - (((r22 * r19) * r19) / (r20 * 2.0f));
    L23:
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    L9:
        return this.mStage1EndPosition;
    }

    private void setup(float r10, float r11, float r12, float r13, float r14) {
        if (r10 != 0.0f) goto L5;
        r10 = 1.0E-4f;
    L5:
        this.mStage1Velocity = r10;
        float r5 = r10 / r12;
        float r15 = (r5 * r10) / 2.0f;
        if (r10 >= 0.0f) goto L14;
        float r16 = (float) Math.sqrt((r11 - ((((-r10) / r12) * r10) / 2.0f)) * r12);
        if (r16 >= r13) goto L11;
        this.mType = "backward accelerate, decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r16;
        this.mStage3Velocity = 0.0f;
        float r17 = (r16 - r10) / r12;
        this.mStage1Duration = r17;
        this.mStage2Duration = r16 / r12;
        this.mStage1EndPosition = ((r10 + r16) * r17) / 2.0f;
        this.mStage2EndPosition = r11;
        this.mStage3EndPosition = r11;
        return;
    L11:
        this.mType = "backward accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r13;
        this.mStage3Velocity = r13;
        float r18 = (r13 - r10) / r12;
        this.mStage1Duration = r18;
        float r19 = r13 / r12;
        this.mStage3Duration = r19;
        float r20 = ((r10 + r13) * r18) / 2.0f;
        float r110 = (r19 * r13) / 2.0f;
        this.mStage2Duration = ((r11 - r20) - r110) / r13;
        this.mStage1EndPosition = r20;
        this.mStage2EndPosition = r11 - r110;
        this.mStage3EndPosition = r11;
        return;
    L14:
        if (r15 < r11) goto L17;
        this.mType = "hard stop";
        this.mNumberOfStages = 1;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = 0.0f;
        this.mStage1EndPosition = r11;
        this.mStage1Duration = (2.0f * r11) / r10;
        return;
    L17:
        float r21 = r11 - r15;
        float r22 = r21 / r10;
        if ((r22 + r5) >= r14) goto L21;
        this.mType = "cruse decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r10;
        this.mStage3Velocity = 0.0f;
        this.mStage1EndPosition = r21;
        this.mStage2EndPosition = r11;
        this.mStage1Duration = r22;
        this.mStage2Duration = r5;
        return;
    L21:
        float r111 = (float) Math.sqrt(((r10 * r10) / 2.0f) + (r12 * r11));
        float r23 = (r111 - r10) / r12;
        this.mStage1Duration = r23;
        float r24 = r111 / r12;
        this.mStage2Duration = r24;
        if (r111 >= r13) goto L25;
        this.mType = "accelerate decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r111;
        this.mStage3Velocity = 0.0f;
        this.mStage1Duration = r23;
        this.mStage2Duration = r24;
        this.mStage1EndPosition = ((r10 + r111) * r23) / 2.0f;
        this.mStage2EndPosition = r11;
        return;
    L25:
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r10;
        this.mStage2Velocity = r13;
        this.mStage3Velocity = r13;
        float r112 = (r13 - r10) / r12;
        this.mStage1Duration = r112;
        float r113 = r13 / r12;
        this.mStage3Duration = r113;
        float r25 = ((r10 + r13) * r112) / 2.0f;
        float r114 = (r113 * r13) / 2.0f;
        this.mStage2Duration = ((r11 - r25) - r114) / r13;
        this.mStage1EndPosition = r25;
        this.mStage2EndPosition = r11 - r114;
        this.mStage3EndPosition = r11;
    }

    public void config(float r10, float r11, float r12, float r13, float r14, float r15) {
        this.mStartPosition = r10;
        if (r10 <= r11) goto L5;
        boolean r5 = true;
    L6:
        this.mBackwards = r5;
        if (r5 == false) goto L9;
        setup(-r12, r10 - r11, r14, r15, r13);
        return;
    L9:
        setup(r12, r11 - r10, r14, r15, r13);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public void debug(String r10, String r11, float r12) {
        StringBuilder r5 = j0.w(r11, " ===== ");
        r5.append(this.mType);
        Log.v(r10, r5.toString());
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        if (this.mBackwards == false) goto L5;
        String r14 = "backwards";
    L6:
        r13.append(r14);
        r13.append(" time = ");
        r13.append(r12);
        r13.append("  stages ");
        r13.append(this.mNumberOfStages);
        Log.v(r10, r13.toString());
        Log.v(r10, r11 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition);
        if (this.mNumberOfStages <= 1) goto L10;
        StringBuilder r15 = j0.w(r11, " dur ");
        r15.append(this.mStage2Duration);
        r15.append(" vel ");
        r15.append(this.mStage2Velocity);
        r15.append(" pos ");
        r15.append(this.mStage2EndPosition);
        Log.v(r10, r15.toString());
    L10:
        if (this.mNumberOfStages <= 2) goto L12;
        StringBuilder r16 = j0.w(r11, " dur ");
        r16.append(this.mStage3Duration);
        r16.append(" vel ");
        r16.append(this.mStage3Velocity);
        r16.append(" pos ");
        r16.append(this.mStage3EndPosition);
        Log.v(r10, r16.toString());
    L12:
        float r17 = this.mStage1Duration;
        if (r12 > r17) goto L16;
        Log.v(r10, r11 + "stage 0");
        return;
    L16:
        int r18 = this.mNumberOfStages;
        if (r18 != 1) goto L20;
        Log.v(r10, r11 + "end stage 0");
        return;
    L20:
        float r19 = r12 - r17;
        float r20 = this.mStage2Duration;
        if (r19 >= r20) goto L24;
        Log.v(r10, r11 + " stage 1");
        return;
    L24:
        if (r18 != 2) goto L28;
        Log.v(r10, r11 + "end stage 1");
        return;
    L28:
        if ((r19 - r20) >= this.mStage3Duration) goto L31;
        Log.v(r10, r11 + " stage 2");
        return;
    L31:
        Log.v(r10, r11 + " end stage 2");
        return;
    L5:
        r14 = "forward ";
        goto L6
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        float r10 = calcY(r5);
        this.mLastPosition = r5;
        boolean r11 = this.mBackwards;
        float r12 = this.mStartPosition;
        if (r11 == false) goto L6;
        return r12 - r10;
    L6:
        return r12 + r10;
    }

    public float getVelocity(float r5) {
        float r10 = this.mStage1Duration;
        if (r5 > r10) goto L6;
        float r11 = this.mStage1Velocity;
        return (((this.mStage2Velocity - r11) * r5) / r10) + r11;
    L6:
        int r12 = this.mNumberOfStages;
        if (r12 != 1) goto L10;
        return 0.0f;
    L10:
        float r13 = r5 - r10;
        float r14 = this.mStage2Duration;
        if (r13 >= r14) goto L15;
        float r15 = this.mStage2Velocity;
        return (((this.mStage3Velocity - r15) * r13) / r14) + r15;
    L15:
        if (r12 == 2) goto L17;
        float r16 = r13 - r14;
        float r17 = this.mStage3Duration;
        if (r16 >= r17) goto L23;
        float r18 = this.mStage3Velocity;
        return r18 - ((r16 * r18) / r17);
    L23:
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        if (this.mBackwards == false) goto L6;
        return -getVelocity(this.mLastPosition);
    L6:
        return getVelocity(this.mLastPosition);
    }
}
