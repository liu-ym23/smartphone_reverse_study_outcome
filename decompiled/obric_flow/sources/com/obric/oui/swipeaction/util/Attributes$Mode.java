package com.obric.oui.swipeaction.util;

/* JADX INFO: loaded from: classes3.dex */
public final enum Attributes$Mode extends Enum<Attributes$Mode> {
    public static final Attributes$Mode Multiple = null;
    public static final Attributes$Mode Single = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Attributes$Mode[] f14637a = null;

    static {
        Attributes$Mode r5 = new Attributes$Mode("Single", 0);
        Single = r5;
        Attributes$Mode r10 = new Attributes$Mode("Multiple", 1);
        Multiple = r10;
        f14637a = new Attributes$Mode[]{r5, r10};
    }

    public static Attributes$Mode valueOf(String r5) {
        return (Attributes$Mode) Enum.valueOf(Attributes$Mode.class, r5);
    }

    public static Attributes$Mode[] values() {
        return (Attributes$Mode[]) f14637a.clone();
    }
}
