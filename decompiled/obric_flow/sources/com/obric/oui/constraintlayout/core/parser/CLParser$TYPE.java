package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes3.dex */
final enum CLParser$TYPE extends Enum<CLParser$TYPE> {
    public static final CLParser$TYPE ARRAY = null;
    public static final CLParser$TYPE KEY = null;
    public static final CLParser$TYPE NUMBER = null;
    public static final CLParser$TYPE OBJECT = null;
    public static final CLParser$TYPE STRING = null;
    public static final CLParser$TYPE TOKEN = null;
    public static final CLParser$TYPE UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CLParser$TYPE[] f12546a = null;

    static {
        CLParser$TYPE r5 = new CLParser$TYPE("UNKNOWN", 0);
        UNKNOWN = r5;
        CLParser$TYPE r10 = new CLParser$TYPE("OBJECT", 1);
        OBJECT = r10;
        CLParser$TYPE r11 = new CLParser$TYPE("ARRAY", 2);
        ARRAY = r11;
        CLParser$TYPE r12 = new CLParser$TYPE("NUMBER", 3);
        NUMBER = r12;
        CLParser$TYPE r13 = new CLParser$TYPE("STRING", 4);
        STRING = r13;
        CLParser$TYPE r14 = new CLParser$TYPE("KEY", 5);
        KEY = r14;
        CLParser$TYPE r15 = new CLParser$TYPE("TOKEN", 6);
        TOKEN = r15;
        f12546a = new CLParser$TYPE[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public static CLParser$TYPE valueOf(String r5) {
        return (CLParser$TYPE) Enum.valueOf(CLParser$TYPE.class, r5);
    }

    public static CLParser$TYPE[] values() {
        return (CLParser$TYPE[]) f12546a.clone();
    }
}
