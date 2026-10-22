package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/core/UnbindAndResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER_UNBIND_NETWORK_ERROR", "SERVER_UNBIND_FAILED", "SERVER_UNBIND_UNKNOWN", "SPP_DISCONNECT_FAILED", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UnbindAndResetResult extends Enum<UnbindAndResetResult> {
    public static final UnbindAndResetResult SERVER_UNBIND_FAILED = null;
    public static final UnbindAndResetResult SERVER_UNBIND_NETWORK_ERROR = null;
    public static final UnbindAndResetResult SERVER_UNBIND_UNKNOWN = null;
    public static final UnbindAndResetResult SPP_DISCONNECT_FAILED = null;
    public static final UnbindAndResetResult SUCCESS = null;
    public static final /* synthetic */ UnbindAndResetResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UnbindAndResetResult> getEntries() {
        return b;
    }

    static {
        UnbindAndResetResult r0 = new UnbindAndResetResult("SERVER_UNBIND_NETWORK_ERROR", 0);
        SERVER_UNBIND_NETWORK_ERROR = r0;
        UnbindAndResetResult r1 = new UnbindAndResetResult("SERVER_UNBIND_FAILED", 1);
        SERVER_UNBIND_FAILED = r1;
        UnbindAndResetResult r3 = new UnbindAndResetResult("SERVER_UNBIND_UNKNOWN", 2);
        SERVER_UNBIND_UNKNOWN = r3;
        UnbindAndResetResult r5 = new UnbindAndResetResult("SPP_DISCONNECT_FAILED", 3);
        SPP_DISCONNECT_FAILED = r5;
        UnbindAndResetResult r7 = new UnbindAndResetResult("SUCCESS", 4);
        SUCCESS = r7;
        UnbindAndResetResult[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static UnbindAndResetResult[] values() {
        return (UnbindAndResetResult[]) a.clone();
    }

    public static UnbindAndResetResult valueOf(String r1) {
        return (UnbindAndResetResult) r27.a.a(UnbindAndResetResult.class, r1);
    }

    public UnbindAndResetResult(String r1, int r2) {
        super(r1, r2);
    }
}
