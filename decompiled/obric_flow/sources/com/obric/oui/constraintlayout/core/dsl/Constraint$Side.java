package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Constraint$Side extends Enum<Constraint$Side> {
    public static final Constraint$Side BASELINE = null;
    public static final Constraint$Side BOTTOM = null;
    public static final Constraint$Side END = null;
    public static final Constraint$Side LEFT = null;
    public static final Constraint$Side RIGHT = null;
    public static final Constraint$Side START = null;
    public static final Constraint$Side TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$Side[] f12529a = null;

    static {
        Constraint$Side r5 = new Constraint$Side("LEFT", 0);
        LEFT = r5;
        Constraint$Side r10 = new Constraint$Side("RIGHT", 1);
        RIGHT = r10;
        Constraint$Side r11 = new Constraint$Side("TOP", 2);
        TOP = r11;
        Constraint$Side r12 = new Constraint$Side("BOTTOM", 3);
        BOTTOM = r12;
        Constraint$Side r13 = new Constraint$Side("START", 4);
        START = r13;
        Constraint$Side r14 = new Constraint$Side("END", 5);
        END = r14;
        Constraint$Side r15 = new Constraint$Side("BASELINE", 6);
        BASELINE = r15;
        f12529a = new Constraint$Side[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static Constraint$Side valueOf(String r5) {
        return (Constraint$Side) Enum.valueOf(Constraint$Side.class, r5);
    }

    public static Constraint$Side[] values() {
        return (Constraint$Side[]) f12529a.clone();
    }
}
