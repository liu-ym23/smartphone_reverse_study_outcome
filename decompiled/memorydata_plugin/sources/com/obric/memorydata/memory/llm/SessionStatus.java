package com.obric.memorydata.memory.llm;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/llm/SessionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INITIALIZED", "STREAMING", "COMPLETED", RawObservationEntity.STATE_FAILED, "ILLEGAL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SessionStatus extends Enum<SessionStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SessionStatus[] $VALUES = null;
    public static final SessionStatus COMPLETED = null;
    public static final SessionStatus FAILED = null;
    public static final SessionStatus ILLEGAL = null;
    public static final SessionStatus INITIALIZED = null;
    public static final SessionStatus STREAMING = null;

    private static final /* synthetic */ SessionStatus[] $values() {
        return new SessionStatus[]{INITIALIZED, STREAMING, COMPLETED, FAILED, ILLEGAL};
    }

    static {
        INITIALIZED = new SessionStatus("INITIALIZED", 0);
        STREAMING = new SessionStatus("STREAMING", 1);
        COMPLETED = new SessionStatus("COMPLETED", 2);
        FAILED = new SessionStatus(RawObservationEntity.STATE_FAILED, 3);
        ILLEGAL = new SessionStatus("ILLEGAL", 4);
        SessionStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SessionStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SessionStatus> getEntries() {
        return $ENTRIES;
    }

    public static SessionStatus valueOf(String r2) {
        return (SessionStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(SessionStatus.class, r2), SessionStatus.class, "com.obric.memorydata.plugin");
    }

    public static SessionStatus[] values() {
        return (SessionStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SessionStatus[].class, "com.obric.memorydata.plugin");
    }
}
