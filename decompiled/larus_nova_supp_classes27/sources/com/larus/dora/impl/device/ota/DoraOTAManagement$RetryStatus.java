package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/ota/DoraOTAManagement$RetryStatus;", "", "<init>", "(Ljava/lang/String;I)V", "TransferRetry", "PackageRetry", "NotNeedRetry", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraOTAManagement$RetryStatus extends Enum<DoraOTAManagement$RetryStatus> {
    public static final DoraOTAManagement$RetryStatus NotNeedRetry = null;
    public static final DoraOTAManagement$RetryStatus PackageRetry = null;
    public static final DoraOTAManagement$RetryStatus TransferRetry = null;
    public static final /* synthetic */ DoraOTAManagement$RetryStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraOTAManagement$RetryStatus> getEntries() {
        return b;
    }

    static {
        DoraOTAManagement$RetryStatus r0 = new DoraOTAManagement$RetryStatus("TransferRetry", 0);
        TransferRetry = r0;
        DoraOTAManagement$RetryStatus r1 = new DoraOTAManagement$RetryStatus("PackageRetry", 1);
        PackageRetry = r1;
        DoraOTAManagement$RetryStatus r3 = new DoraOTAManagement$RetryStatus("NotNeedRetry", 2);
        NotNeedRetry = r3;
        DoraOTAManagement$RetryStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraOTAManagement$RetryStatus[] values() {
        return (DoraOTAManagement$RetryStatus[]) a.clone();
    }

    public static DoraOTAManagement$RetryStatus valueOf(String r1) {
        return (DoraOTAManagement$RetryStatus) r27.a.a(DoraOTAManagement$RetryStatus.class, r1);
    }

    public DoraOTAManagement$RetryStatus(String r1, int r2) {
        super(r1, r2);
    }
}
