package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/core/OnlyBindResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_BIND_NETWORK_ERROR", "SERVER_BIND_FAILED", "SERVER_BIND_NEED_UNBIND", "SERVER_BIND_UNKNOWN", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyBindResult extends Enum<OnlyBindResult> {
    public static final OnlyBindResult SERVER_BIND_FAILED = null;
    public static final OnlyBindResult SERVER_BIND_NEED_UNBIND = null;
    public static final OnlyBindResult SERVER_BIND_NETWORK_ERROR = null;
    public static final OnlyBindResult SERVER_BIND_UNKNOWN = null;
    public static final OnlyBindResult SUCCESS = null;
    public static final /* synthetic */ OnlyBindResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OnlyBindResult> getEntries() {
        return b;
    }

    static {
        OnlyBindResult r0 = new OnlyBindResult("SERVER_BIND_NETWORK_ERROR", 0);
        SERVER_BIND_NETWORK_ERROR = r0;
        OnlyBindResult r1 = new OnlyBindResult("SERVER_BIND_FAILED", 1);
        SERVER_BIND_FAILED = r1;
        OnlyBindResult r3 = new OnlyBindResult("SERVER_BIND_NEED_UNBIND", 2);
        SERVER_BIND_NEED_UNBIND = r3;
        OnlyBindResult r5 = new OnlyBindResult("SERVER_BIND_UNKNOWN", 3);
        SERVER_BIND_UNKNOWN = r5;
        OnlyBindResult r7 = new OnlyBindResult("SUCCESS", 4);
        SUCCESS = r7;
        OnlyBindResult[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OnlyBindResult[] values() {
        return (OnlyBindResult[]) a.clone();
    }

    public static OnlyBindResult valueOf(String r1) {
        return (OnlyBindResult) r27.a.a(OnlyBindResult.class, r1);
    }

    public OnlyBindResult(String r1, int r2) {
        super(r1, r2);
    }
}
