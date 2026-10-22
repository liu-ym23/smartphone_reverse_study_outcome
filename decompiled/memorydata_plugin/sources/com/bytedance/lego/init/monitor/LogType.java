package com.bytedance.lego.init.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lego/init/monitor/LogType;", "", "(Ljava/lang/String;I)V", "INVALID_COS_TIME", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final enum LogType extends Enum<LogType> {
    private static final /* synthetic */ LogType[] $VALUES = null;
    public static final LogType INVALID_COS_TIME = null;

    static {
        LogType r1 = new LogType("INVALID_COS_TIME", 0);
        INVALID_COS_TIME = r1;
        $VALUES = new LogType[]{r1};
    }

    public LogType(String r1, int r2) {
        super(r1, r2);
    }

    public static LogType valueOf(String r2) {
        return (LogType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LogType.class, r2), LogType.class, "com.obric.memorydata.plugin");
    }

    public static LogType[] values() {
        return (LogType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LogType[].class, "com.obric.memorydata.plugin");
    }
}
