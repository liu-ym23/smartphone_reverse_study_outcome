package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Constraint$Behaviour extends Enum<Constraint$Behaviour> {
    public static final Constraint$Behaviour PERCENT = null;
    public static final Constraint$Behaviour RATIO = null;
    public static final Constraint$Behaviour RESOLVED = null;
    public static final Constraint$Behaviour SPREAD = null;
    public static final Constraint$Behaviour WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$Behaviour[] f12526a = null;

    static {
        Constraint$Behaviour r5 = new Constraint$Behaviour("SPREAD", 0);
        SPREAD = r5;
        Constraint$Behaviour r10 = new Constraint$Behaviour("WRAP", 1);
        WRAP = r10;
        Constraint$Behaviour r11 = new Constraint$Behaviour("PERCENT", 2);
        PERCENT = r11;
        Constraint$Behaviour r12 = new Constraint$Behaviour("RATIO", 3);
        RATIO = r12;
        Constraint$Behaviour r13 = new Constraint$Behaviour("RESOLVED", 4);
        RESOLVED = r13;
        f12526a = new Constraint$Behaviour[]{r5, r10, r11, r12, r13};
    }

    public static Constraint$Behaviour valueOf(String r5) {
        return (Constraint$Behaviour) Enum.valueOf(Constraint$Behaviour.class, r5);
    }

    public static Constraint$Behaviour[] values() {
        return (Constraint$Behaviour[]) f12526a.clone();
    }
}
