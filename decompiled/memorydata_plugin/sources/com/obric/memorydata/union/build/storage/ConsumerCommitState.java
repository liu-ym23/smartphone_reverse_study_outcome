package com.obric.memorydata.union.build.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/union/build/storage/ConsumerCommitState;", "", "<init>", "(Ljava/lang/String;I)V", "APPLY", "ALREADY_COMMITTED", "CURSOR_CHANGED", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ConsumerCommitState extends Enum<ConsumerCommitState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConsumerCommitState[] $VALUES = null;
    public static final ConsumerCommitState ALREADY_COMMITTED = null;
    public static final ConsumerCommitState APPLY = null;
    public static final ConsumerCommitState CURSOR_CHANGED = null;

    private static final /* synthetic */ ConsumerCommitState[] $values() {
        return new ConsumerCommitState[]{APPLY, ALREADY_COMMITTED, CURSOR_CHANGED};
    }

    static {
        APPLY = new ConsumerCommitState("APPLY", 0);
        ALREADY_COMMITTED = new ConsumerCommitState("ALREADY_COMMITTED", 1);
        CURSOR_CHANGED = new ConsumerCommitState("CURSOR_CHANGED", 2);
        ConsumerCommitState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ConsumerCommitState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ConsumerCommitState> getEntries() {
        return $ENTRIES;
    }

    public static ConsumerCommitState valueOf(String r2) {
        return (ConsumerCommitState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConsumerCommitState.class, r2), ConsumerCommitState.class, "com.obric.memorydata.plugin");
    }

    public static ConsumerCommitState[] values() {
        return (ConsumerCommitState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConsumerCommitState[].class, "com.obric.memorydata.plugin");
    }
}
