package com.ss.android.lark.chameleonv2.lkapi.log;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/log/LogLevel;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "INFO", "WARN", "ERROR", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARN = null;
    public static final /* synthetic */ LogLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LogLevel> getEntries() {
        return b;
    }

    static {
        LogLevel r0 = new LogLevel("INFO", 0);
        INFO = r0;
        LogLevel r1 = new LogLevel("WARN", 1);
        WARN = r1;
        LogLevel r3 = new LogLevel("ERROR", 2);
        ERROR = r3;
        LogLevel[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) a.clone();
    }

    public static LogLevel valueOf(String r1) {
        return (LogLevel) a.a(LogLevel.class, r1);
    }

    public LogLevel(String r1, int r2) {
        super(r1, r2);
    }
}
