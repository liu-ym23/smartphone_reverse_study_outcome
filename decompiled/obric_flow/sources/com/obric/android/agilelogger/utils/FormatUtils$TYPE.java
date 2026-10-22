package com.obric.android.agilelogger.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum FormatUtils$TYPE extends Enum<FormatUtils$TYPE> {
    public static final FormatUtils$TYPE BORDER = null;
    public static final FormatUtils$TYPE BUNDLE = null;
    public static final FormatUtils$TYPE INTENT = null;
    public static final FormatUtils$TYPE JSON = null;
    public static final FormatUtils$TYPE MSG = null;
    public static final FormatUtils$TYPE STACKTRACE = null;
    public static final FormatUtils$TYPE STACKTRACE_STR = null;
    public static final FormatUtils$TYPE THREAD = null;
    public static final FormatUtils$TYPE THROWABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatUtils$TYPE[] f11220a = null;

    static {
        FormatUtils$TYPE r5 = new FormatUtils$TYPE("MSG", 0);
        MSG = r5;
        FormatUtils$TYPE r10 = new FormatUtils$TYPE("JSON", 1);
        JSON = r10;
        FormatUtils$TYPE r11 = new FormatUtils$TYPE("BUNDLE", 2);
        BUNDLE = r11;
        FormatUtils$TYPE r12 = new FormatUtils$TYPE("INTENT", 3);
        INTENT = r12;
        FormatUtils$TYPE r13 = new FormatUtils$TYPE("THROWABLE", 4);
        THROWABLE = r13;
        FormatUtils$TYPE r14 = new FormatUtils$TYPE("BORDER", 5);
        BORDER = r14;
        FormatUtils$TYPE r15 = new FormatUtils$TYPE("STACKTRACE", 6);
        STACKTRACE = r15;
        FormatUtils$TYPE r16 = new FormatUtils$TYPE("THREAD", 7);
        THREAD = r16;
        FormatUtils$TYPE r17 = new FormatUtils$TYPE("STACKTRACE_STR", 8);
        STACKTRACE_STR = r17;
        f11220a = new FormatUtils$TYPE[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public static FormatUtils$TYPE valueOf(String r5) {
        return (FormatUtils$TYPE) Enum.valueOf(FormatUtils$TYPE.class, r5);
    }

    public static FormatUtils$TYPE[] values() {
        return (FormatUtils$TYPE[]) f11220a.clone();
    }
}
