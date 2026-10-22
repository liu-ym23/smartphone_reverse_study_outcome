package com.obric.memorydata.datatransport.manager;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", "EXPORTING", "ZIPPING", "ENCRYPTING", "SUCCESS", RawObservationEntity.STATE_FAILED, "INTERRUPTED", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DataExportPhase extends Enum<DataExportPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DataExportPhase[] $VALUES = null;
    public static final DataExportPhase ENCRYPTING = null;
    public static final DataExportPhase EXPORTING = null;
    public static final DataExportPhase FAILED = null;
    public static final DataExportPhase IDLE = null;
    public static final DataExportPhase INTERRUPTED = null;
    public static final DataExportPhase PREPARING = null;
    public static final DataExportPhase SUCCESS = null;
    public static final DataExportPhase ZIPPING = null;

    private static final /* synthetic */ DataExportPhase[] $values() {
        return new DataExportPhase[]{IDLE, PREPARING, EXPORTING, ZIPPING, ENCRYPTING, SUCCESS, FAILED, INTERRUPTED};
    }

    static {
        IDLE = new DataExportPhase("IDLE", 0);
        PREPARING = new DataExportPhase("PREPARING", 1);
        EXPORTING = new DataExportPhase("EXPORTING", 2);
        ZIPPING = new DataExportPhase("ZIPPING", 3);
        ENCRYPTING = new DataExportPhase("ENCRYPTING", 4);
        SUCCESS = new DataExportPhase("SUCCESS", 5);
        FAILED = new DataExportPhase(RawObservationEntity.STATE_FAILED, 6);
        INTERRUPTED = new DataExportPhase("INTERRUPTED", 7);
        DataExportPhase[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private DataExportPhase(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<DataExportPhase> getEntries() {
        return $ENTRIES;
    }

    public static DataExportPhase valueOf(String r2) {
        return (DataExportPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataExportPhase.class, r2), DataExportPhase.class, "com.obric.memorydata.plugin");
    }

    public static DataExportPhase[] values() {
        return (DataExportPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataExportPhase[].class, "com.obric.memorydata.plugin");
    }
}
