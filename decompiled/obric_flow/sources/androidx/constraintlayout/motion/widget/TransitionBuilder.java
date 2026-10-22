package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public TransitionBuilder() {
    }

    public static MotionScene.Transition buildTransition(MotionScene r5, int r10, int r11, ConstraintSet r12, int r13, ConstraintSet r14) {
        MotionScene.Transition r15 = new MotionScene.Transition(r10, r5, r11, r13);
        updateConstraintSetInMotionScene(r5, r15, r12, r14);
        return r15;
    }

    private static void updateConstraintSetInMotionScene(MotionScene r5, MotionScene.Transition r10, ConstraintSet r11, ConstraintSet r12) {
        int r13 = r10.getStartConstraintSetId();
        int r14 = r10.getEndConstraintSetId();
        r5.setConstraintSet(r13, r11);
        r5.setConstraintSet(r14, r12);
    }

    public static void validate(MotionLayout r5) {
        MotionScene r10 = r5.mScene;
        if (r10 == null) goto L16;
        if (r10.validateLayout(r5) == false) goto L14;
        if (r10.mCurrentTransition == null) goto L12;
        if (r10.getDefinedTransitions().isEmpty() == true) goto L12;
        return;
    L12:
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
    L14:
        throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    L16:
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}
