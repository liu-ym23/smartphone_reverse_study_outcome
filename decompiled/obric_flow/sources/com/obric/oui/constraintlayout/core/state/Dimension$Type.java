package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes3.dex */
public final enum Dimension$Type extends Enum<Dimension$Type> {
    public static final Dimension$Type FIXED = null;
    public static final Dimension$Type MATCH_CONSTRAINT = null;
    public static final Dimension$Type MATCH_PARENT = null;
    public static final Dimension$Type WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Dimension$Type[] f12549a = null;

    static {
        Dimension$Type r5 = new Dimension$Type("FIXED", 0);
        FIXED = r5;
        Dimension$Type r10 = new Dimension$Type("WRAP", 1);
        WRAP = r10;
        Dimension$Type r11 = new Dimension$Type("MATCH_PARENT", 2);
        MATCH_PARENT = r11;
        Dimension$Type r12 = new Dimension$Type("MATCH_CONSTRAINT", 3);
        MATCH_CONSTRAINT = r12;
        f12549a = new Dimension$Type[]{r5, r10, r11, r12};
    }

    public static Dimension$Type valueOf(String r5) {
        return (Dimension$Type) Enum.valueOf(Dimension$Type.class, r5);
    }

    public static Dimension$Type[] values() {
        return (Dimension$Type[]) f12549a.clone();
    }
}
