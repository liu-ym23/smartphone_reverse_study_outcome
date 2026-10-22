package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public final enum State$Constraint extends Enum<State$Constraint> {
    public static final State$Constraint BASELINE_TO_BASELINE = null;
    public static final State$Constraint BASELINE_TO_BOTTOM = null;
    public static final State$Constraint BASELINE_TO_TOP = null;
    public static final State$Constraint BOTTOM_TO_BASELINE = null;
    public static final State$Constraint BOTTOM_TO_BOTTOM = null;
    public static final State$Constraint BOTTOM_TO_TOP = null;
    public static final State$Constraint CENTER_HORIZONTALLY = null;
    public static final State$Constraint CENTER_VERTICALLY = null;
    public static final State$Constraint CIRCULAR_CONSTRAINT = null;
    public static final State$Constraint END_TO_END = null;
    public static final State$Constraint END_TO_START = null;
    public static final State$Constraint LEFT_TO_LEFT = null;
    public static final State$Constraint LEFT_TO_RIGHT = null;
    public static final State$Constraint RIGHT_TO_LEFT = null;
    public static final State$Constraint RIGHT_TO_RIGHT = null;
    public static final State$Constraint START_TO_END = null;
    public static final State$Constraint START_TO_START = null;
    public static final State$Constraint TOP_TO_BASELINE = null;
    public static final State$Constraint TOP_TO_BOTTOM = null;
    public static final State$Constraint TOP_TO_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Constraint[] f12551a = null;

    static {
        State$Constraint r5 = new State$Constraint("LEFT_TO_LEFT", 0);
        LEFT_TO_LEFT = r5;
        State$Constraint r10 = new State$Constraint("LEFT_TO_RIGHT", 1);
        LEFT_TO_RIGHT = r10;
        State$Constraint r11 = new State$Constraint("RIGHT_TO_LEFT", 2);
        RIGHT_TO_LEFT = r11;
        State$Constraint r12 = new State$Constraint("RIGHT_TO_RIGHT", 3);
        RIGHT_TO_RIGHT = r12;
        State$Constraint r13 = new State$Constraint("START_TO_START", 4);
        START_TO_START = r13;
        State$Constraint r14 = new State$Constraint("START_TO_END", 5);
        START_TO_END = r14;
        State$Constraint r15 = new State$Constraint("END_TO_START", 6);
        END_TO_START = r15;
        State$Constraint r16 = new State$Constraint("END_TO_END", 7);
        END_TO_END = r16;
        State$Constraint r17 = new State$Constraint("TOP_TO_TOP", 8);
        TOP_TO_TOP = r17;
        State$Constraint r18 = new State$Constraint("TOP_TO_BOTTOM", 9);
        TOP_TO_BOTTOM = r18;
        State$Constraint r19 = new State$Constraint("TOP_TO_BASELINE", 10);
        TOP_TO_BASELINE = r19;
        State$Constraint r110 = new State$Constraint("BOTTOM_TO_TOP", 11);
        BOTTOM_TO_TOP = r110;
        State$Constraint r111 = new State$Constraint("BOTTOM_TO_BOTTOM", 12);
        BOTTOM_TO_BOTTOM = r111;
        State$Constraint r112 = new State$Constraint("BOTTOM_TO_BASELINE", 13);
        BOTTOM_TO_BASELINE = r112;
        State$Constraint r113 = new State$Constraint("BASELINE_TO_BASELINE", 14);
        BASELINE_TO_BASELINE = r113;
        State$Constraint r114 = new State$Constraint("BASELINE_TO_TOP", 15);
        BASELINE_TO_TOP = r114;
        State$Constraint r115 = new State$Constraint("BASELINE_TO_BOTTOM", 16);
        BASELINE_TO_BOTTOM = r115;
        State$Constraint r116 = new State$Constraint("CENTER_HORIZONTALLY", 17);
        CENTER_HORIZONTALLY = r116;
        State$Constraint r117 = new State$Constraint("CENTER_VERTICALLY", 18);
        CENTER_VERTICALLY = r117;
        State$Constraint r118 = new State$Constraint("CIRCULAR_CONSTRAINT", 19);
        CIRCULAR_CONSTRAINT = r118;
        f12551a = new State$Constraint[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public static State$Constraint valueOf(String r5) {
        return (State$Constraint) Enum.valueOf(State$Constraint.class, r5);
    }

    public static State$Constraint[] values() {
        return (State$Constraint[]) f12551a.clone();
    }
}
