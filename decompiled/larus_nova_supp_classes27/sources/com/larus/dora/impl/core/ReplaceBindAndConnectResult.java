package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/core/ReplaceBindAndConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_REPLACE_BIND_NETWORK_ERROR", "SERVER_REPLACE_BIND_FAILED", "SERVER_REPLACE_BIND_UNKNOWN", "CONNECT_FAILED", "CONNECT_TIMEOUT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplaceBindAndConnectResult extends Enum<ReplaceBindAndConnectResult> {
    public static final ReplaceBindAndConnectResult CONNECT_FAILED = null;
    public static final ReplaceBindAndConnectResult CONNECT_TIMEOUT = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_FAILED = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_NETWORK_ERROR = null;
    public static final ReplaceBindAndConnectResult SERVER_REPLACE_BIND_UNKNOWN = null;
    public static final ReplaceBindAndConnectResult SUCCESS = null;
    public static final /* synthetic */ ReplaceBindAndConnectResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReplaceBindAndConnectResult> getEntries() {
        return b;
    }

    static {
        ReplaceBindAndConnectResult r0 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_NETWORK_ERROR", 0);
        SERVER_REPLACE_BIND_NETWORK_ERROR = r0;
        ReplaceBindAndConnectResult r1 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_FAILED", 1);
        SERVER_REPLACE_BIND_FAILED = r1;
        ReplaceBindAndConnectResult r3 = new ReplaceBindAndConnectResult("SERVER_REPLACE_BIND_UNKNOWN", 2);
        SERVER_REPLACE_BIND_UNKNOWN = r3;
        ReplaceBindAndConnectResult r5 = new ReplaceBindAndConnectResult("CONNECT_FAILED", 3);
        CONNECT_FAILED = r5;
        ReplaceBindAndConnectResult r7 = new ReplaceBindAndConnectResult("CONNECT_TIMEOUT", 4);
        CONNECT_TIMEOUT = r7;
        ReplaceBindAndConnectResult r9 = new ReplaceBindAndConnectResult("SUCCESS", 5);
        SUCCESS = r9;
        ReplaceBindAndConnectResult[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ReplaceBindAndConnectResult[] values() {
        return (ReplaceBindAndConnectResult[]) a.clone();
    }

    public static ReplaceBindAndConnectResult valueOf(String r1) {
        return (ReplaceBindAndConnectResult) r27.a.a(ReplaceBindAndConnectResult.class, r1);
    }

    public ReplaceBindAndConnectResult(String r1, int r2) {
        super(r1, r2);
    }
}
