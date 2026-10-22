package com.lynx.tasm.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LogSource extends Enum<LogSource> {
    private static final /* synthetic */ LogSource[] $VALUES = null;
    public static final LogSource JAVA = null;
    public static final LogSource JS = null;
    public static final LogSource JS_EXT = null;
    public static final LogSource Native = null;

    static {
        LogSource r0 = new LogSource("Native", 0);
        Native = r0;
        LogSource r1 = new LogSource("JS", 1);
        JS = r1;
        LogSource r3 = new LogSource("JS_EXT", 2);
        JS_EXT = r3;
        LogSource r5 = new LogSource("JAVA", 3);
        JAVA = r5;
        $VALUES = new LogSource[]{r0, r1, r3, r5};
    }

    public static LogSource[] values() {
        return (LogSource[]) $VALUES.clone();
    }

    public static LogSource valueOf(String r1) {
        return (LogSource) r27.a.a(LogSource.class, r1);
    }

    private LogSource(String r1, int r2) {
        super(r1, r2);
    }
}
