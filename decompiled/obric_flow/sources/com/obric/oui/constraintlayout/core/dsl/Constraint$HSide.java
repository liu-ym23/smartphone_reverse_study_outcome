package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Constraint$HSide extends Enum<Constraint$HSide> {
    public static final Constraint$HSide END = null;
    public static final Constraint$HSide LEFT = null;
    public static final Constraint$HSide RIGHT = null;
    public static final Constraint$HSide START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$HSide[] f12528a = null;

    static {
        Constraint$HSide r5 = new Constraint$HSide("LEFT", 0);
        LEFT = r5;
        Constraint$HSide r10 = new Constraint$HSide("RIGHT", 1);
        RIGHT = r10;
        Constraint$HSide r11 = new Constraint$HSide("START", 2);
        START = r11;
        Constraint$HSide r12 = new Constraint$HSide("END", 3);
        END = r12;
        f12528a = new Constraint$HSide[]{r5, r10, r11, r12};
    }

    public static Constraint$HSide valueOf(String r5) {
        return (Constraint$HSide) Enum.valueOf(Constraint$HSide.class, r5);
    }

    public static Constraint$HSide[] values() {
        return (Constraint$HSide[]) f12528a.clone();
    }
}
