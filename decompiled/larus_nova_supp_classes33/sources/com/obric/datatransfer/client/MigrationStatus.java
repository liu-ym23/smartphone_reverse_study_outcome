package com.obric.datatransfer.client;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/datatransfer/client/MigrationStatus;", "", "IDLE", "IN_PROCESS", "FINISHED", "datatransfer_release"}, k = 1, mv = {1, 8, 0})
public final enum MigrationStatus extends Enum<MigrationStatus> {
    public static final MigrationStatus FINISHED = null;
    public static final MigrationStatus IDLE = null;
    public static final MigrationStatus IN_PROCESS = null;
    public static final /* synthetic */ MigrationStatus[] a = null;

    public static MigrationStatus valueOf(String r1) {
        return (MigrationStatus) r27.a.a(MigrationStatus.class, r1);
    }

    public static MigrationStatus[] values() {
        return (MigrationStatus[]) a.clone();
    }

    static {
        MigrationStatus r0 = new MigrationStatus("IDLE", 0);
        IDLE = r0;
        MigrationStatus r1 = new MigrationStatus("IN_PROCESS", 1);
        IN_PROCESS = r1;
        MigrationStatus r3 = new MigrationStatus("FINISHED", 2);
        FINISHED = r3;
        a = new MigrationStatus[]{r0, r1, r3};
    }

    public MigrationStatus(String r1, int r2) {
        super(r1, r2);
    }
}
