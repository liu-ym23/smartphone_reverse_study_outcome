package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportStatus;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PENDING", "UPLOADING", "SUCCESS", RawObservationEntity.STATE_FAILED, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryTraceReportStatus extends Enum<MemoryTraceReportStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryTraceReportStatus[] $VALUES = null;
    public static final MemoryTraceReportStatus FAILED = null;
    public static final MemoryTraceReportStatus PENDING = null;
    public static final MemoryTraceReportStatus SUCCESS = null;
    public static final MemoryTraceReportStatus UPLOADING = null;
    private final String key;

    private static final /* synthetic */ MemoryTraceReportStatus[] $values() {
        return new MemoryTraceReportStatus[]{PENDING, UPLOADING, SUCCESS, FAILED};
    }

    static {
        PENDING = new MemoryTraceReportStatus("PENDING", 0, "pending");
        UPLOADING = new MemoryTraceReportStatus("UPLOADING", 1, "uploading");
        SUCCESS = new MemoryTraceReportStatus("SUCCESS", 2, "success");
        FAILED = new MemoryTraceReportStatus(RawObservationEntity.STATE_FAILED, 3, "failed");
        MemoryTraceReportStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryTraceReportStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }

    public static EnumEntries<MemoryTraceReportStatus> getEntries() {
        return $ENTRIES;
    }

    public static MemoryTraceReportStatus valueOf(String r2) {
        return (MemoryTraceReportStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryTraceReportStatus.class, r2), MemoryTraceReportStatus.class, "com.obric.memorydata.plugin");
    }

    public static MemoryTraceReportStatus[] values() {
        return (MemoryTraceReportStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryTraceReportStatus[].class, "com.obric.memorydata.plugin");
    }

    public final String getKey() {
        return this.key;
    }
}
