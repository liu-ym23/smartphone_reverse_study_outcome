package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Constraint$VSide extends Enum<Constraint$VSide> {
    public static final Constraint$VSide BASELINE = null;
    public static final Constraint$VSide BOTTOM = null;
    public static final Constraint$VSide TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Constraint$VSide[] f12530a = null;

    static {
        Constraint$VSide r5 = new Constraint$VSide("TOP", 0);
        TOP = r5;
        Constraint$VSide r10 = new Constraint$VSide("BOTTOM", 1);
        BOTTOM = r10;
        Constraint$VSide r11 = new Constraint$VSide("BASELINE", 2);
        BASELINE = r11;
        f12530a = new Constraint$VSide[]{r5, r10, r11};
    }

    public static Constraint$VSide valueOf(String r5) {
        return (Constraint$VSide) Enum.valueOf(Constraint$VSide.class, r5);
    }

    public static Constraint$VSide[] values() {
        return (Constraint$VSide[]) f12530a.clone();
    }
}
