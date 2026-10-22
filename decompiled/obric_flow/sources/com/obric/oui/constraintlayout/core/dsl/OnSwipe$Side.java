package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum OnSwipe$Side extends Enum<OnSwipe$Side> {
    public static final OnSwipe$Side BOTTOM = null;
    public static final OnSwipe$Side END = null;
    public static final OnSwipe$Side LEFT = null;
    public static final OnSwipe$Side MIDDLE = null;
    public static final OnSwipe$Side RIGHT = null;
    public static final OnSwipe$Side START = null;
    public static final OnSwipe$Side TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Side[] f12543a = null;

    static {
        OnSwipe$Side r5 = new OnSwipe$Side("TOP", 0);
        TOP = r5;
        OnSwipe$Side r10 = new OnSwipe$Side("LEFT", 1);
        LEFT = r10;
        OnSwipe$Side r11 = new OnSwipe$Side("RIGHT", 2);
        RIGHT = r11;
        OnSwipe$Side r12 = new OnSwipe$Side("BOTTOM", 3);
        BOTTOM = r12;
        OnSwipe$Side r13 = new OnSwipe$Side("MIDDLE", 4);
        MIDDLE = r13;
        OnSwipe$Side r14 = new OnSwipe$Side("START", 5);
        START = r14;
        OnSwipe$Side r15 = new OnSwipe$Side("END", 6);
        END = r15;
        f12543a = new OnSwipe$Side[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static OnSwipe$Side valueOf(String r5) {
        return (OnSwipe$Side) Enum.valueOf(OnSwipe$Side.class, r5);
    }

    public static OnSwipe$Side[] values() {
        return (OnSwipe$Side[]) f12543a.clone();
    }
}
