package com.bytedance.android.annie.log;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/log/LogLevel;", "", "DEBUG", "ERROR", "INFO", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final /* synthetic */ LogLevel[] a = null;

    public static LogLevel valueOf(String r1) {
        return (LogLevel) a.a(LogLevel.class, r1);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) a.clone();
    }

    static {
        LogLevel r0 = new LogLevel("DEBUG", 0);
        DEBUG = r0;
        LogLevel r1 = new LogLevel("ERROR", 1);
        ERROR = r1;
        LogLevel r10 = new LogLevel("INFO", 2);
        INFO = r10;
        a = new LogLevel[]{r0, r1, r10};
    }

    public LogLevel(String r1, int r10) {
        super(r1, r10);
    }
}
