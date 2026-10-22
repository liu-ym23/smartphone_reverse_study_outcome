package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private StopEngine mEngine;
    private SpringStopEngine mSpringStopEngine;
    private StopLogicEngine mStopLogicEngine;

    public StopLogic() {
        StopLogicEngine r10 = new StopLogicEngine();
        this.mStopLogicEngine = r10;
        this.mEngine = r10;
    }

    public void config(float r10, float r11, float r12, float r13, float r14, float r15) {
        StopLogicEngine r16 = this.mStopLogicEngine;
        this.mEngine = r16;
        r16.config(r10, r11, r12, r13, r14, r15);
    }

    public String debug(String r10, float r11) {
        return this.mEngine.debug(r10, r11);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        return this.mEngine.getInterpolation(r10);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mEngine.getVelocity();
    }

    public float getVelocity(float r10) {
        return this.mEngine.getVelocity(r10);
    }

    public boolean isStopped() {
        return this.mEngine.isStopped();
    }

    public void springConfig(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.mSpringStopEngine != null) goto L5;
        this.mSpringStopEngine = new SpringStopEngine();
    L5:
        SpringStopEngine r10 = this.mSpringStopEngine;
        this.mEngine = r10;
        r10.springConfig(r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
