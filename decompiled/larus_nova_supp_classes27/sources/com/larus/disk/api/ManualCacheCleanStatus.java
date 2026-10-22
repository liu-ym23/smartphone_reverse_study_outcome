package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/disk/api/ManualCacheCleanStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PARTIAL", "TASK_RUNNING", "DISABLED", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualCacheCleanStatus extends Enum<ManualCacheCleanStatus> {
    public static final ManualCacheCleanStatus DISABLED = null;
    public static final ManualCacheCleanStatus FAILED = null;
    public static final ManualCacheCleanStatus PARTIAL = null;
    public static final ManualCacheCleanStatus SUCCESS = null;
    public static final ManualCacheCleanStatus TASK_RUNNING = null;
    public static final /* synthetic */ ManualCacheCleanStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ManualCacheCleanStatus> getEntries() {
        return b;
    }

    static {
        ManualCacheCleanStatus r0 = new ManualCacheCleanStatus("SUCCESS", 0);
        SUCCESS = r0;
        ManualCacheCleanStatus r1 = new ManualCacheCleanStatus("PARTIAL", 1);
        PARTIAL = r1;
        ManualCacheCleanStatus r3 = new ManualCacheCleanStatus("TASK_RUNNING", 2);
        TASK_RUNNING = r3;
        ManualCacheCleanStatus r5 = new ManualCacheCleanStatus("DISABLED", 3);
        DISABLED = r5;
        ManualCacheCleanStatus r7 = new ManualCacheCleanStatus("FAILED", 4);
        FAILED = r7;
        ManualCacheCleanStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ManualCacheCleanStatus[] values() {
        return (ManualCacheCleanStatus[]) a.clone();
    }

    public static ManualCacheCleanStatus valueOf(String r1) {
        return (ManualCacheCleanStatus) a.a(ManualCacheCleanStatus.class, r1);
    }

    public ManualCacheCleanStatus(String r1, int r2) {
        super(r1, r2);
    }
}
