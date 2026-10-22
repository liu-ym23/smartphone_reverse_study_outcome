package com.bytedance.android.live.revenue.platform.alog.api;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.foundation.SendALogRequest.ALogLevel")
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/live/revenue/platform/alog/api/IDynamicHostALogService$Level", "", "Lcom/bytedance/android/live/revenue/platform/alog/api/IDynamicHostALogService$Level;", "", "index", "I", "getIndex", "()I", "DEBUG", "INFO", "WARN", "ERROR", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IDynamicHostALogService$Level extends Enum<IDynamicHostALogService$Level> {
    public static final IDynamicHostALogService$Level DEBUG = null;
    public static final IDynamicHostALogService$Level ERROR = null;
    public static final IDynamicHostALogService$Level INFO = null;
    public static final IDynamicHostALogService$Level WARN = null;
    public static final /* synthetic */ IDynamicHostALogService$Level[] a = null;
    private final int index;

    static {
        IDynamicHostALogService$Level r2 = new IDynamicHostALogService$Level("DEBUG", 0, 2);
        DEBUG = r2;
        IDynamicHostALogService$Level r3 = new IDynamicHostALogService$Level("INFO", 1, 3);
        INFO = r3;
        IDynamicHostALogService$Level r4 = new IDynamicHostALogService$Level("WARN", 2, 4);
        WARN = r4;
        IDynamicHostALogService$Level r0 = new IDynamicHostALogService$Level("ERROR", 3, 5);
        ERROR = r0;
        a = new IDynamicHostALogService$Level[]{r2, r3, r4, r0};
    }

    public static IDynamicHostALogService$Level valueOf(String r1) {
        return (IDynamicHostALogService$Level) a.a(IDynamicHostALogService$Level.class, r1);
    }

    public static IDynamicHostALogService$Level[] values() {
        return (IDynamicHostALogService$Level[]) a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public IDynamicHostALogService$Level(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = r3;
    }
}
