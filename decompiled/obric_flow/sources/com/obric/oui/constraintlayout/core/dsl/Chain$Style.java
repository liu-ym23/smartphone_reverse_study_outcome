package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum Chain$Style extends Enum<Chain$Style> {
    public static final Chain$Style PACKED = null;
    public static final Chain$Style SPREAD = null;
    public static final Chain$Style SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Chain$Style[] f12525a = null;

    static {
        Chain$Style r5 = new Chain$Style("PACKED", 0);
        PACKED = r5;
        Chain$Style r10 = new Chain$Style("SPREAD", 1);
        SPREAD = r10;
        Chain$Style r11 = new Chain$Style("SPREAD_INSIDE", 2);
        SPREAD_INSIDE = r11;
        f12525a = new Chain$Style[]{r5, r10, r11};
    }

    public static Chain$Style valueOf(String r5) {
        return (Chain$Style) Enum.valueOf(Chain$Style.class, r5);
    }

    public static Chain$Style[] values() {
        return (Chain$Style[]) f12525a.clone();
    }
}
