package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/core/OnlyLocalUnbindAndResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SPP_DISCONNECT_FAILED", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyLocalUnbindAndResetResult extends Enum<OnlyLocalUnbindAndResetResult> {
    public static final OnlyLocalUnbindAndResetResult SPP_DISCONNECT_FAILED = null;
    public static final OnlyLocalUnbindAndResetResult SUCCESS = null;
    public static final /* synthetic */ OnlyLocalUnbindAndResetResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OnlyLocalUnbindAndResetResult> getEntries() {
        return b;
    }

    static {
        OnlyLocalUnbindAndResetResult r0 = new OnlyLocalUnbindAndResetResult("SPP_DISCONNECT_FAILED", 0);
        SPP_DISCONNECT_FAILED = r0;
        OnlyLocalUnbindAndResetResult r1 = new OnlyLocalUnbindAndResetResult("SUCCESS", 1);
        SUCCESS = r1;
        OnlyLocalUnbindAndResetResult[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OnlyLocalUnbindAndResetResult[] values() {
        return (OnlyLocalUnbindAndResetResult[]) a.clone();
    }

    public static OnlyLocalUnbindAndResetResult valueOf(String r1) {
        return (OnlyLocalUnbindAndResetResult) r27.a.a(OnlyLocalUnbindAndResetResult.class, r1);
    }

    public OnlyLocalUnbindAndResetResult(String r1, int r2) {
        super(r1, r2);
    }
}
