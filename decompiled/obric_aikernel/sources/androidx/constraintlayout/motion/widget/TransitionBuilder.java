package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
    }

    public static MotionScene.Transition buildTransition(MotionScene r10, int r11, int r12, ConstraintSet r13, int r14, ConstraintSet r15) {
        MotionScene.Transition r16 = new MotionScene.Transition(r11, r10, r12, r14);
        updateConstraintSetInMotionScene(r10, r16, r13, r15);
        return r16;
    }

    private static void updateConstraintSetInMotionScene(MotionScene r10, MotionScene.Transition r11, ConstraintSet r12, ConstraintSet r13) {
        int r14 = r11.getStartConstraintSetId();
        int r15 = r11.getEndConstraintSetId();
        r10.setConstraintSet(r14, r12);
        r10.setConstraintSet(r15, r13);
    }

    public static void validate(MotionLayout r10) {
        MotionScene r11 = r10.mScene;
        if (r11 == null) goto L16;
        if (r11.validateLayout(r10) == false) goto L14;
        if (r11.mCurrentTransition == null) goto L12;
        if (r11.getDefinedTransitions().isEmpty() == true) goto L12;
        return;
    L12:
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
    L14:
        throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    L16:
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}
