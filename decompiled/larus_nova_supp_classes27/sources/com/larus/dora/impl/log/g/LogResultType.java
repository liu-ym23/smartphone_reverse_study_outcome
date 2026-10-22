package com.larus.dora.impl.log.g;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/log/g/LogResultType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "SUCCESS", "TIMEOUT", FlowDoraWifiScene.OTA, "QUERY", "DEVICE_DISCONNECT", "GET_G_LOG_DATA_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogResultType extends Enum<LogResultType> {
    public static final LogResultType DEVICE_DISCONNECT = null;
    public static final LogResultType GET_G_LOG_DATA_TIMEOUT = null;
    public static final LogResultType OTA = null;
    public static final LogResultType QUERY = null;
    public static final LogResultType SUCCESS = null;
    public static final LogResultType TIMEOUT = null;
    public static final /* synthetic */ LogResultType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int id;

    public static EnumEntries<LogResultType> getEntries() {
        return b;
    }

    static {
        LogResultType r0 = new LogResultType("SUCCESS", 0, 0);
        SUCCESS = r0;
        LogResultType r1 = new LogResultType("TIMEOUT", 1, 1);
        TIMEOUT = r1;
        LogResultType r3 = new LogResultType(FlowDoraWifiScene.OTA, 2, 2);
        OTA = r3;
        LogResultType r5 = new LogResultType("QUERY", 3, 3);
        QUERY = r5;
        LogResultType r7 = new LogResultType("DEVICE_DISCONNECT", 4, 4);
        DEVICE_DISCONNECT = r7;
        LogResultType r9 = new LogResultType("GET_G_LOG_DATA_TIMEOUT", 5, 5);
        GET_G_LOG_DATA_TIMEOUT = r9;
        LogResultType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static LogResultType[] values() {
        return (LogResultType[]) a.clone();
    }

    public final int getId() {
        return this.id;
    }

    public static LogResultType valueOf(String r1) {
        return (LogResultType) r27.a.a(LogResultType.class, r1);
    }

    public LogResultType(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
