package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/core/OnlyConnectResult;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECT_FAILED", "CONNECT_TIMEOUT", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyConnectResult extends Enum<OnlyConnectResult> {
    public static final OnlyConnectResult CONNECT_FAILED = null;
    public static final OnlyConnectResult CONNECT_TIMEOUT = null;
    public static final OnlyConnectResult SUCCESS = null;
    public static final /* synthetic */ OnlyConnectResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OnlyConnectResult> getEntries() {
        return b;
    }

    static {
        OnlyConnectResult r0 = new OnlyConnectResult("CONNECT_FAILED", 0);
        CONNECT_FAILED = r0;
        OnlyConnectResult r1 = new OnlyConnectResult("CONNECT_TIMEOUT", 1);
        CONNECT_TIMEOUT = r1;
        OnlyConnectResult r3 = new OnlyConnectResult("SUCCESS", 2);
        SUCCESS = r3;
        OnlyConnectResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static OnlyConnectResult[] values() {
        return (OnlyConnectResult[]) a.clone();
    }

    public static OnlyConnectResult valueOf(String r1) {
        return (OnlyConnectResult) r27.a.a(OnlyConnectResult.class, r1);
    }

    public OnlyConnectResult(String r1, int r2) {
        super(r1, r2);
    }
}
