package com.lynx.tasm.animation.keyframe;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxKeyframeAnimator$LynxKFAnimatorState extends Enum<LynxKeyframeAnimator$LynxKFAnimatorState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxKFAnimatorState f10078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxKFAnimatorState f10079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxKeyframeAnimator$LynxKFAnimatorState f10080c = null;
    public static final LynxKeyframeAnimator$LynxKFAnimatorState d = null;
    public static final LynxKeyframeAnimator$LynxKFAnimatorState e = null;
    public static final /* synthetic */ LynxKeyframeAnimator$LynxKFAnimatorState[] f = null;

    static {
        LynxKeyframeAnimator$LynxKFAnimatorState r5 = new LynxKeyframeAnimator$LynxKFAnimatorState("IDLE", 0);
        f10078a = r5;
        LynxKeyframeAnimator$LynxKFAnimatorState r10 = new LynxKeyframeAnimator$LynxKFAnimatorState("RUNNING", 1);
        f10079b = r10;
        LynxKeyframeAnimator$LynxKFAnimatorState r11 = new LynxKeyframeAnimator$LynxKFAnimatorState("PAUSED", 2);
        f10080c = r11;
        LynxKeyframeAnimator$LynxKFAnimatorState r12 = new LynxKeyframeAnimator$LynxKFAnimatorState("CANCELED", 3);
        d = r12;
        LynxKeyframeAnimator$LynxKFAnimatorState r13 = new LynxKeyframeAnimator$LynxKFAnimatorState("DESTROYED", 4);
        e = r13;
        f = new LynxKeyframeAnimator$LynxKFAnimatorState[]{r5, r10, r11, r12, r13};
    }

    public LynxKeyframeAnimator$LynxKFAnimatorState(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxKeyframeAnimator$LynxKFAnimatorState valueOf(String r5) {
        return (LynxKeyframeAnimator$LynxKFAnimatorState) Enum.valueOf(LynxKeyframeAnimator$LynxKFAnimatorState.class, r5);
    }

    public static LynxKeyframeAnimator$LynxKFAnimatorState[] values() {
        return (LynxKeyframeAnimator$LynxKFAnimatorState[]) f.clone();
    }
}
