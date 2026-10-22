package com.ss.android.lark.log;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel ASSERT = null;
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel VERBOSE = null;
    public static final LogLevel WARN = null;
    public static final /* synthetic */ LogLevel[] a = null;
    private int value;

    static {
        LogLevel r0 = new LogLevel("VERBOSE", 0, 2);
        VERBOSE = r0;
        LogLevel r1 = new LogLevel("DEBUG", 1, 3);
        DEBUG = r1;
        LogLevel r4 = new LogLevel("INFO", 2, 4);
        INFO = r4;
        LogLevel r7 = new LogLevel("WARN", 3, 5);
        WARN = r7;
        LogLevel r9 = new LogLevel("ERROR", 4, 6);
        ERROR = r9;
        LogLevel r11 = new LogLevel("ASSERT", 5, 7);
        ASSERT = r11;
        a = new LogLevel[]{r0, r1, r4, r7, r9, r11};
    }

    public static LogLevel[] values() {
        return (LogLevel[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static LogLevel forNumber(int r0) {
        switch(r0) {
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return VERBOSE;
    L6:
        return ASSERT;
    L8:
        return ERROR;
    L10:
        return WARN;
    L12:
        return INFO;
    L14:
        return DEBUG;
    L16:
        return VERBOSE;
    }

    public static LogLevel valueOf(String r1) {
        return (LogLevel) a.a(LogLevel.class, r1);
    }

    public static LogLevel valueOf(int r0) {
        return forNumber(r0);
    }

    public LogLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
