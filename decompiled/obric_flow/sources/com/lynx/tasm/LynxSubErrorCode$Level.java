package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
final enum LynxSubErrorCode$Level extends Enum<LynxSubErrorCode$Level> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxSubErrorCode$Level f10012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxSubErrorCode$Level f10013c = null;
    public static final LynxSubErrorCode$Level d = null;
    public static final LynxSubErrorCode$Level e = null;
    public static final /* synthetic */ LynxSubErrorCode$Level[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10014a;

    static {
        LynxSubErrorCode$Level r5 = new LynxSubErrorCode$Level("FATAL", 0, "fatal");
        f10012b = r5;
        LynxSubErrorCode$Level r10 = new LynxSubErrorCode$Level("ERROR", 1, "error");
        f10013c = r10;
        LynxSubErrorCode$Level r11 = new LynxSubErrorCode$Level("WARN", 2, "warn");
        d = r11;
        LynxSubErrorCode$Level r12 = new LynxSubErrorCode$Level("UNDECIDED", 3, "undecided");
        e = r12;
        f = new LynxSubErrorCode$Level[]{r5, r10, r11, r12};
    }

    public LynxSubErrorCode$Level(String r5, int r10, String r11) {
        super(r5, r10);
        this.f10014a = r11;
    }

    public static LynxSubErrorCode$Level valueOf(String r5) {
        return (LynxSubErrorCode$Level) Enum.valueOf(LynxSubErrorCode$Level.class, r5);
    }

    public static LynxSubErrorCode$Level[] values() {
        return (LynxSubErrorCode$Level[]) f.clone();
    }
}
