package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum OnSwipe$Drag extends Enum<OnSwipe$Drag> {
    public static final OnSwipe$Drag ANTICLOCKWISE = null;
    public static final OnSwipe$Drag CLOCKWISE = null;
    public static final OnSwipe$Drag DOWN = null;
    public static final OnSwipe$Drag END = null;
    public static final OnSwipe$Drag LEFT = null;
    public static final OnSwipe$Drag RIGHT = null;
    public static final OnSwipe$Drag START = null;
    public static final OnSwipe$Drag UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Drag[] f12541a = null;

    static {
        OnSwipe$Drag r5 = new OnSwipe$Drag("UP", 0);
        UP = r5;
        OnSwipe$Drag r10 = new OnSwipe$Drag("DOWN", 1);
        DOWN = r10;
        OnSwipe$Drag r11 = new OnSwipe$Drag("LEFT", 2);
        LEFT = r11;
        OnSwipe$Drag r12 = new OnSwipe$Drag("RIGHT", 3);
        RIGHT = r12;
        OnSwipe$Drag r13 = new OnSwipe$Drag("START", 4);
        START = r13;
        OnSwipe$Drag r14 = new OnSwipe$Drag("END", 5);
        END = r14;
        OnSwipe$Drag r15 = new OnSwipe$Drag("CLOCKWISE", 6);
        CLOCKWISE = r15;
        OnSwipe$Drag r16 = new OnSwipe$Drag("ANTICLOCKWISE", 7);
        ANTICLOCKWISE = r16;
        f12541a = new OnSwipe$Drag[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static OnSwipe$Drag valueOf(String r5) {
        return (OnSwipe$Drag) Enum.valueOf(OnSwipe$Drag.class, r5);
    }

    public static OnSwipe$Drag[] values() {
        return (OnSwipe$Drag[]) f12541a.clone();
    }
}
