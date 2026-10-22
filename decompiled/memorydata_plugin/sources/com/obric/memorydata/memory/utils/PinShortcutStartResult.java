package com.obric.memorydata.memory.utils;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutStartResult;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED_NEW", "ALREADY_PENDING", RawObservationEntity.STATE_FAILED, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinShortcutStartResult extends Enum<PinShortcutStartResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinShortcutStartResult[] $VALUES = null;
    public static final PinShortcutStartResult ALREADY_PENDING = null;
    public static final PinShortcutStartResult FAILED = null;
    public static final PinShortcutStartResult STARTED_NEW = null;

    private static final /* synthetic */ PinShortcutStartResult[] $values() {
        return new PinShortcutStartResult[]{STARTED_NEW, ALREADY_PENDING, FAILED};
    }

    static {
        STARTED_NEW = new PinShortcutStartResult("STARTED_NEW", 0);
        ALREADY_PENDING = new PinShortcutStartResult("ALREADY_PENDING", 1);
        FAILED = new PinShortcutStartResult(RawObservationEntity.STATE_FAILED, 2);
        PinShortcutStartResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinShortcutStartResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinShortcutStartResult> getEntries() {
        return $ENTRIES;
    }

    public static PinShortcutStartResult valueOf(String r2) {
        return (PinShortcutStartResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinShortcutStartResult.class, r2), PinShortcutStartResult.class, "com.obric.memorydata.plugin");
    }

    public static PinShortcutStartResult[] values() {
        return (PinShortcutStartResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinShortcutStartResult[].class, "com.obric.memorydata.plugin");
    }
}
