package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public final enum State$Direction extends Enum<State$Direction> {
    public static final State$Direction BOTTOM = null;
    public static final State$Direction END = null;
    public static final State$Direction LEFT = null;
    public static final State$Direction RIGHT = null;
    public static final State$Direction START = null;
    public static final State$Direction TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Direction[] f12552a = null;

    static {
        State$Direction r5 = new State$Direction("LEFT", 0);
        LEFT = r5;
        State$Direction r10 = new State$Direction("RIGHT", 1);
        RIGHT = r10;
        State$Direction r11 = new State$Direction("START", 2);
        START = r11;
        State$Direction r12 = new State$Direction("END", 3);
        END = r12;
        State$Direction r13 = new State$Direction("TOP", 4);
        TOP = r13;
        State$Direction r14 = new State$Direction("BOTTOM", 5);
        BOTTOM = r14;
        f12552a = new State$Direction[]{r5, r10, r11, r12, r13, r14};
    }

    public static State$Direction valueOf(String r5) {
        return (State$Direction) Enum.valueOf(State$Direction.class, r5);
    }

    public static State$Direction[] values() {
        return (State$Direction[]) f12552a.clone();
    }
}
