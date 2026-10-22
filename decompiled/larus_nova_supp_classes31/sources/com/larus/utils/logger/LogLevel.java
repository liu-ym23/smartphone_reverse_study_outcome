package com.larus.utils.logger;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/utils/logger/LogLevel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEBUG", "INFO", "WARN", "ERROR", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARN = null;
    public static final /* synthetic */ LogLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<LogLevel> getEntries() {
        return b;
    }

    static {
        LogLevel r0 = new LogLevel("DEBUG", 0, "D");
        DEBUG = r0;
        LogLevel r1 = new LogLevel("INFO", 1, "I");
        INFO = r1;
        LogLevel r2 = new LogLevel("WARN", 2, "W");
        WARN = r2;
        LogLevel r4 = new LogLevel("ERROR", 3, "E");
        ERROR = r4;
        LogLevel[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LogLevel valueOf(String r1) {
        return (LogLevel) a.a(LogLevel.class, r1);
    }

    public LogLevel(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
