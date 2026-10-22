package com.obric.aiproactive.impl.livecard;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ScheduleResult;", "", "<init>", "(Ljava/lang/String;I)V", "SCHEDULED", "DISMISSED_IMMEDIATELY", RawObservationEntity.STATE_FAILED, "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ScheduleResult extends Enum<ScheduleResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScheduleResult[] $VALUES = null;
    public static final ScheduleResult DISMISSED_IMMEDIATELY = null;
    public static final ScheduleResult FAILED = null;
    public static final ScheduleResult SCHEDULED = null;

    private static final /* synthetic */ ScheduleResult[] $values() {
        return new ScheduleResult[]{SCHEDULED, DISMISSED_IMMEDIATELY, FAILED};
    }

    static {
        SCHEDULED = new ScheduleResult("SCHEDULED", 0);
        DISMISSED_IMMEDIATELY = new ScheduleResult("DISMISSED_IMMEDIATELY", 1);
        FAILED = new ScheduleResult(RawObservationEntity.STATE_FAILED, 2);
        ScheduleResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ScheduleResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ScheduleResult> getEntries() {
        return $ENTRIES;
    }

    public static ScheduleResult valueOf(String r2) {
        return (ScheduleResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScheduleResult.class, r2), ScheduleResult.class, "com.obric.memorydata.plugin");
    }

    public static ScheduleResult[] values() {
        return (ScheduleResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScheduleResult[].class, "com.obric.memorydata.plugin");
    }
}
