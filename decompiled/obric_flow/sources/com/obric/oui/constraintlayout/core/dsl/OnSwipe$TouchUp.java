package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum OnSwipe$TouchUp extends Enum<OnSwipe$TouchUp> {
    public static final OnSwipe$TouchUp AUTOCOMPLETE = null;
    public static final OnSwipe$TouchUp DECELERATE = null;
    public static final OnSwipe$TouchUp DECELERATE_COMPLETE = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_END = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_START = null;
    public static final OnSwipe$TouchUp STOP = null;
    public static final OnSwipe$TouchUp TO_END = null;
    public static final OnSwipe$TouchUp TO_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$TouchUp[] f12544a = null;

    static {
        OnSwipe$TouchUp r5 = new OnSwipe$TouchUp("AUTOCOMPLETE", 0);
        AUTOCOMPLETE = r5;
        OnSwipe$TouchUp r10 = new OnSwipe$TouchUp("TO_START", 1);
        TO_START = r10;
        OnSwipe$TouchUp r11 = new OnSwipe$TouchUp("NEVER_COMPLETE_END", 2);
        NEVER_COMPLETE_END = r11;
        OnSwipe$TouchUp r12 = new OnSwipe$TouchUp("TO_END", 3);
        TO_END = r12;
        OnSwipe$TouchUp r13 = new OnSwipe$TouchUp("STOP", 4);
        STOP = r13;
        OnSwipe$TouchUp r14 = new OnSwipe$TouchUp("DECELERATE", 5);
        DECELERATE = r14;
        OnSwipe$TouchUp r15 = new OnSwipe$TouchUp("DECELERATE_COMPLETE", 6);
        DECELERATE_COMPLETE = r15;
        OnSwipe$TouchUp r16 = new OnSwipe$TouchUp("NEVER_COMPLETE_START", 7);
        NEVER_COMPLETE_START = r16;
        f12544a = new OnSwipe$TouchUp[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static OnSwipe$TouchUp valueOf(String r5) {
        return (OnSwipe$TouchUp) Enum.valueOf(OnSwipe$TouchUp.class, r5);
    }

    public static OnSwipe$TouchUp[] values() {
        return (OnSwipe$TouchUp[]) f12544a.clone();
    }
}
