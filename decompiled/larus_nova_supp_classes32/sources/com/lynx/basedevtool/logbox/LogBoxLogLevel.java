package com.lynx.basedevtool.logbox;

import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LogBoxLogLevel extends Enum<LogBoxLogLevel> {
    public static final LogBoxLogLevel Error = null;
    public static final LogBoxLogLevel Info = null;
    public static final LogBoxLogLevel Warn = null;
    public static final /* synthetic */ LogBoxLogLevel[] a = null;
    public final String value;

    static {
        LogBoxLogLevel r0 = new LogBoxLogLevel("Info", 0, "info");
        Info = r0;
        LogBoxLogLevel r1 = new LogBoxLogLevel("Warn", 1, LynxError.LEVEL_WARN);
        Warn = r1;
        LogBoxLogLevel r2 = new LogBoxLogLevel("Error", 2, "error");
        Error = r2;
        a = new LogBoxLogLevel[]{r0, r1, r2};
    }

    public static LogBoxLogLevel[] values() {
        return (LogBoxLogLevel[]) a.clone();
    }

    public static LogBoxLogLevel valueOf(String r1) {
        return (LogBoxLogLevel) r27.a.a(LogBoxLogLevel.class, r1);
    }

    public LogBoxLogLevel(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
