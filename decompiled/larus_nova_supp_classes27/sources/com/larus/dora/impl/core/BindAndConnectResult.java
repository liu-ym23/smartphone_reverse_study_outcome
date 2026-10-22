package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/core/BindAndConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_BIND_NETWORK_ERROR", "SERVER_BIND_FAILED", "SERVER_BIND_NEED_UNBIND", "SERVER_BIND_UNKNOWN", "CONNECT_FAILED", "CONNECT_TIMEOUT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BindAndConnectResult extends Enum<BindAndConnectResult> {
    public static final BindAndConnectResult CONNECT_FAILED = null;
    public static final BindAndConnectResult CONNECT_TIMEOUT = null;
    public static final BindAndConnectResult SERVER_BIND_FAILED = null;
    public static final BindAndConnectResult SERVER_BIND_NEED_UNBIND = null;
    public static final BindAndConnectResult SERVER_BIND_NETWORK_ERROR = null;
    public static final BindAndConnectResult SERVER_BIND_UNKNOWN = null;
    public static final BindAndConnectResult SUCCESS = null;
    public static final /* synthetic */ BindAndConnectResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BindAndConnectResult> getEntries() {
        return b;
    }

    static {
        BindAndConnectResult r0 = new BindAndConnectResult("SERVER_BIND_NETWORK_ERROR", 0);
        SERVER_BIND_NETWORK_ERROR = r0;
        BindAndConnectResult r1 = new BindAndConnectResult("SERVER_BIND_FAILED", 1);
        SERVER_BIND_FAILED = r1;
        BindAndConnectResult r3 = new BindAndConnectResult("SERVER_BIND_NEED_UNBIND", 2);
        SERVER_BIND_NEED_UNBIND = r3;
        BindAndConnectResult r5 = new BindAndConnectResult("SERVER_BIND_UNKNOWN", 3);
        SERVER_BIND_UNKNOWN = r5;
        BindAndConnectResult r7 = new BindAndConnectResult("CONNECT_FAILED", 4);
        CONNECT_FAILED = r7;
        BindAndConnectResult r9 = new BindAndConnectResult("CONNECT_TIMEOUT", 5);
        CONNECT_TIMEOUT = r9;
        BindAndConnectResult r11 = new BindAndConnectResult("SUCCESS", 6);
        SUCCESS = r11;
        BindAndConnectResult[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static BindAndConnectResult[] values() {
        return (BindAndConnectResult[]) a.clone();
    }

    public static BindAndConnectResult valueOf(String r1) {
        return (BindAndConnectResult) r27.a.a(BindAndConnectResult.class, r1);
    }

    public BindAndConnectResult(String r1, int r2) {
        super(r1, r2);
    }
}
