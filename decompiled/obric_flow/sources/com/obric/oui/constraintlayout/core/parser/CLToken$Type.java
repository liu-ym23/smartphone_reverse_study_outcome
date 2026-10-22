package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes3.dex */
final enum CLToken$Type extends Enum<CLToken$Type> {
    public static final CLToken$Type FALSE = null;
    public static final CLToken$Type NULL = null;
    public static final CLToken$Type TRUE = null;
    public static final CLToken$Type UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CLToken$Type[] f12547a = null;

    static {
        CLToken$Type r5 = new CLToken$Type("UNKNOWN", 0);
        UNKNOWN = r5;
        CLToken$Type r10 = new CLToken$Type("TRUE", 1);
        TRUE = r10;
        CLToken$Type r11 = new CLToken$Type("FALSE", 2);
        FALSE = r11;
        CLToken$Type r12 = new CLToken$Type("NULL", 3);
        NULL = r12;
        f12547a = new CLToken$Type[]{r5, r10, r11, r12};
    }

    public static CLToken$Type valueOf(String r5) {
        return (CLToken$Type) Enum.valueOf(CLToken$Type.class, r5);
    }

    public static CLToken$Type[] values() {
        return (CLToken$Type[]) f12547a.clone();
    }
}
