package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public final enum State$Helper extends Enum<State$Helper> {
    public static final State$Helper ALIGN_HORIZONTALLY = null;
    public static final State$Helper ALIGN_VERTICALLY = null;
    public static final State$Helper BARRIER = null;
    public static final State$Helper COLUMN = null;
    public static final State$Helper FLOW = null;
    public static final State$Helper GRID = null;
    public static final State$Helper HORIZONTAL_CHAIN = null;
    public static final State$Helper HORIZONTAL_FLOW = null;
    public static final State$Helper LAYER = null;
    public static final State$Helper ROW = null;
    public static final State$Helper VERTICAL_CHAIN = null;
    public static final State$Helper VERTICAL_FLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Helper[] f12553a = null;

    static {
        State$Helper r5 = new State$Helper("HORIZONTAL_CHAIN", 0);
        HORIZONTAL_CHAIN = r5;
        State$Helper r10 = new State$Helper("VERTICAL_CHAIN", 1);
        VERTICAL_CHAIN = r10;
        State$Helper r11 = new State$Helper("ALIGN_HORIZONTALLY", 2);
        ALIGN_HORIZONTALLY = r11;
        State$Helper r12 = new State$Helper("ALIGN_VERTICALLY", 3);
        ALIGN_VERTICALLY = r12;
        State$Helper r13 = new State$Helper("BARRIER", 4);
        BARRIER = r13;
        State$Helper r14 = new State$Helper("LAYER", 5);
        LAYER = r14;
        State$Helper r15 = new State$Helper("HORIZONTAL_FLOW", 6);
        HORIZONTAL_FLOW = r15;
        State$Helper r16 = new State$Helper("VERTICAL_FLOW", 7);
        VERTICAL_FLOW = r16;
        State$Helper r17 = new State$Helper("GRID", 8);
        GRID = r17;
        State$Helper r18 = new State$Helper("ROW", 9);
        ROW = r18;
        State$Helper r19 = new State$Helper("COLUMN", 10);
        COLUMN = r19;
        State$Helper r110 = new State$Helper("FLOW", 11);
        FLOW = r110;
        f12553a = new State$Helper[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
    }

    public static State$Helper valueOf(String r5) {
        return (State$Helper) Enum.valueOf(State$Helper.class, r5);
    }

    public static State$Helper[] values() {
        return (State$Helper[]) f12553a.clone();
    }
}
