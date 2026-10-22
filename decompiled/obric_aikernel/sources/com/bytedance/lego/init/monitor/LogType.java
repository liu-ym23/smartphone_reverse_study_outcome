package com.bytedance.lego.init.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/lego/init/monitor/LogType;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_COS_TIME", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final enum LogType extends Enum<LogType> {
    private static final /* synthetic */ LogType[] $VALUES = null;
    public static final LogType INVALID_COS_TIME = null;

    static {
        LogType r10 = new LogType("INVALID_COS_TIME", 0);
        INVALID_COS_TIME = r10;
        $VALUES = new LogType[]{r10};
    }

    protected LogType(String r10, int r11) {
        super(r10, r11);
    }

    public static LogType valueOf(String r10) {
        return (LogType) Enum.valueOf(LogType.class, r10);
    }

    public static LogType[] values() {
        return (LogType[]) $VALUES.clone();
    }
}
