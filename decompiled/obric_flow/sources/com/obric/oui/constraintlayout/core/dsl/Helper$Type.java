package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Helper$Type extends Enum<Helper$Type> {
    public static final Helper$Type BARRIER = null;
    public static final Helper$Type HORIZONTAL_CHAIN = null;
    public static final Helper$Type HORIZONTAL_GUIDELINE = null;
    public static final Helper$Type VERTICAL_CHAIN = null;
    public static final Helper$Type VERTICAL_GUIDELINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Helper$Type[] f12531a = null;

    static {
        Helper$Type r5 = new Helper$Type("VERTICAL_GUIDELINE", 0);
        VERTICAL_GUIDELINE = r5;
        Helper$Type r10 = new Helper$Type("HORIZONTAL_GUIDELINE", 1);
        HORIZONTAL_GUIDELINE = r10;
        Helper$Type r11 = new Helper$Type("VERTICAL_CHAIN", 2);
        VERTICAL_CHAIN = r11;
        Helper$Type r12 = new Helper$Type("HORIZONTAL_CHAIN", 3);
        HORIZONTAL_CHAIN = r12;
        Helper$Type r13 = new Helper$Type("BARRIER", 4);
        BARRIER = r13;
        f12531a = new Helper$Type[]{r5, r10, r11, r12, r13};
    }

    public static Helper$Type valueOf(String r5) {
        return (Helper$Type) Enum.valueOf(Helper$Type.class, r5);
    }

    public static Helper$Type[] values() {
        return (Helper$Type[]) f12531a.clone();
    }
}
