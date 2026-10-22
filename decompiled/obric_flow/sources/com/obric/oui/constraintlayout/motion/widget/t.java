package com.obric.oui.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12896a = null;

    static {
        int[] r5 = new int[MotionLayout.TransitionState.values().length];
        f12896a = r5;
        r5[MotionLayout.TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f12896a[MotionLayout.TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f12896a[MotionLayout.TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f12896a[MotionLayout.TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
