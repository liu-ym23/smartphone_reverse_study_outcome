package com.bytedance.android.live.broadcastgame.opengame;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/LogLevel;", "", "INFO", "DEBUG", "WARNING", "ERROR", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARNING = null;
    public static final /* synthetic */ LogLevel[] a = null;

    static {
        LogLevel r1 = new LogLevel("INFO", 0);
        INFO = r1;
        LogLevel r2 = new LogLevel("DEBUG", 1);
        DEBUG = r2;
        LogLevel r3 = new LogLevel("WARNING", 2);
        WARNING = r3;
        LogLevel r4 = new LogLevel("ERROR", 3);
        ERROR = r4;
        a = new LogLevel[]{r1, r2, r3, r4};
    }

    public static LogLevel valueOf(String r1) {
        return (LogLevel) r27.a.a(LogLevel.class, r1);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) a.clone();
    }

    public LogLevel(String r1, int r2) {
        super(r1, r2);
    }
}
