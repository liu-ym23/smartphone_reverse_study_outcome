package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum OnSwipe$Mode extends Enum<OnSwipe$Mode> {
    public static final OnSwipe$Mode SPRING = null;
    public static final OnSwipe$Mode VELOCITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Mode[] f12542a = null;

    static {
        OnSwipe$Mode r5 = new OnSwipe$Mode("VELOCITY", 0);
        VELOCITY = r5;
        OnSwipe$Mode r10 = new OnSwipe$Mode("SPRING", 1);
        SPRING = r10;
        f12542a = new OnSwipe$Mode[]{r5, r10};
    }

    public static OnSwipe$Mode valueOf(String r5) {
        return (OnSwipe$Mode) Enum.valueOf(OnSwipe$Mode.class, r5);
    }

    public static OnSwipe$Mode[] values() {
        return (OnSwipe$Mode[]) f12542a.clone();
    }
}
