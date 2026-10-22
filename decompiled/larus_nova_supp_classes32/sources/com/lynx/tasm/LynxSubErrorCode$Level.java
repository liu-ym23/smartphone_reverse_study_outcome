package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
final enum LynxSubErrorCode$Level extends Enum<LynxSubErrorCode$Level> {
    public static final LynxSubErrorCode$Level ERROR = null;
    public static final LynxSubErrorCode$Level FATAL = null;
    public static final LynxSubErrorCode$Level UNDECIDED = null;
    public static final LynxSubErrorCode$Level WARN = null;
    public static final /* synthetic */ LynxSubErrorCode$Level[] a = null;
    public final String value;

    static {
        LynxSubErrorCode$Level r0 = new LynxSubErrorCode$Level("FATAL", 0, "fatal");
        FATAL = r0;
        LynxSubErrorCode$Level r1 = new LynxSubErrorCode$Level("ERROR", 1, "error");
        ERROR = r1;
        LynxSubErrorCode$Level r2 = new LynxSubErrorCode$Level("WARN", 2, LynxError.LEVEL_WARN);
        WARN = r2;
        LynxSubErrorCode$Level r4 = new LynxSubErrorCode$Level("UNDECIDED", 3, "undecided");
        UNDECIDED = r4;
        a = new LynxSubErrorCode$Level[]{r0, r1, r2, r4};
    }

    public static LynxSubErrorCode$Level[] values() {
        return (LynxSubErrorCode$Level[]) a.clone();
    }

    public static LynxSubErrorCode$Level valueOf(String r1) {
        return (LynxSubErrorCode$Level) r27.a.a(LynxSubErrorCode$Level.class, r1);
    }

    public LynxSubErrorCode$Level(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
