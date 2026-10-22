package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum OnSwipe$Boundary extends Enum<OnSwipe$Boundary> {
    public static final OnSwipe$Boundary BOUNCE_BOTH = null;
    public static final OnSwipe$Boundary BOUNCE_END = null;
    public static final OnSwipe$Boundary BOUNCE_START = null;
    public static final OnSwipe$Boundary OVERSHOOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Boundary[] f12540a = null;

    static {
        OnSwipe$Boundary r5 = new OnSwipe$Boundary("OVERSHOOT", 0);
        OVERSHOOT = r5;
        OnSwipe$Boundary r10 = new OnSwipe$Boundary("BOUNCE_START", 1);
        BOUNCE_START = r10;
        OnSwipe$Boundary r11 = new OnSwipe$Boundary("BOUNCE_END", 2);
        BOUNCE_END = r11;
        OnSwipe$Boundary r12 = new OnSwipe$Boundary("BOUNCE_BOTH", 3);
        BOUNCE_BOTH = r12;
        f12540a = new OnSwipe$Boundary[]{r5, r10, r11, r12};
    }

    public static OnSwipe$Boundary valueOf(String r5) {
        return (OnSwipe$Boundary) Enum.valueOf(OnSwipe$Boundary.class, r5);
    }

    public static OnSwipe$Boundary[] values() {
        return (OnSwipe$Boundary[]) f12540a.clone();
    }
}
