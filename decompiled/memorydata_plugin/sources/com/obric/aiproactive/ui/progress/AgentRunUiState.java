package com.obric.aiproactive.ui.progress;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETED", "RUNNING", "PENDING", "CANCELLED", RawObservationEntity.STATE_FAILED, "UNKNOWN", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AgentRunUiState extends Enum<AgentRunUiState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AgentRunUiState[] $VALUES = null;
    public static final AgentRunUiState CANCELLED = null;
    public static final AgentRunUiState COMPLETED = null;
    public static final AgentRunUiState FAILED = null;
    public static final AgentRunUiState PENDING = null;
    public static final AgentRunUiState RUNNING = null;
    public static final AgentRunUiState UNKNOWN = null;

    private static final /* synthetic */ AgentRunUiState[] $values() {
        return new AgentRunUiState[]{COMPLETED, RUNNING, PENDING, CANCELLED, FAILED, UNKNOWN};
    }

    static {
        COMPLETED = new AgentRunUiState("COMPLETED", 0);
        RUNNING = new AgentRunUiState("RUNNING", 1);
        PENDING = new AgentRunUiState("PENDING", 2);
        CANCELLED = new AgentRunUiState("CANCELLED", 3);
        FAILED = new AgentRunUiState(RawObservationEntity.STATE_FAILED, 4);
        UNKNOWN = new AgentRunUiState("UNKNOWN", 5);
        AgentRunUiState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AgentRunUiState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AgentRunUiState> getEntries() {
        return $ENTRIES;
    }

    public static AgentRunUiState valueOf(String r2) {
        return (AgentRunUiState) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgentRunUiState.class, r2), AgentRunUiState.class, "com.obric.memorydata.plugin");
    }

    public static AgentRunUiState[] values() {
        return (AgentRunUiState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgentRunUiState[].class, "com.obric.memorydata.plugin");
    }
}
