package com.lynx.debugrouter.log;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LogSource extends Enum<LogSource> {
    private static final /* synthetic */ LogSource[] $VALUES = null;
    public static final LogSource JAVA = null;
    public static final LogSource Native = null;

    static {
        LogSource r0 = new LogSource("Native", 0);
        Native = r0;
        LogSource r1 = new LogSource("JAVA", 1);
        JAVA = r1;
        $VALUES = new LogSource[]{r0, r1};
    }

    public static LogSource[] values() {
        return (LogSource[]) $VALUES.clone();
    }

    public static LogSource valueOf(String r1) {
        return (LogSource) a.a(LogSource.class, r1);
    }

    private LogSource(String r1, int r2) {
        super(r1, r2);
    }
}
