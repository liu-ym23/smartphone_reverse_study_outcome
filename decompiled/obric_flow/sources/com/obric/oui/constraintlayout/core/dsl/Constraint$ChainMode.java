package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Constraint$ChainMode extends Enum<Constraint$ChainMode> {
    public static final Constraint$ChainMode PACKED = null;
    public static final Constraint$ChainMode SPREAD = null;
    public static final Constraint$ChainMode SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$ChainMode[] f12527a = null;

    static {
        Constraint$ChainMode r5 = new Constraint$ChainMode("SPREAD", 0);
        SPREAD = r5;
        Constraint$ChainMode r10 = new Constraint$ChainMode("SPREAD_INSIDE", 1);
        SPREAD_INSIDE = r10;
        Constraint$ChainMode r11 = new Constraint$ChainMode("PACKED", 2);
        PACKED = r11;
        f12527a = new Constraint$ChainMode[]{r5, r10, r11};
    }

    public static Constraint$ChainMode valueOf(String r5) {
        return (Constraint$ChainMode) Enum.valueOf(Constraint$ChainMode.class, r5);
    }

    public static Constraint$ChainMode[] values() {
        return (Constraint$ChainMode[]) f12527a.clone();
    }
}
