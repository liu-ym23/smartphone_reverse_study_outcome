package com.obric.aiproactive.ui.progress;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunStatusAction;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "STOP", "COMPLETED", RawObservationEntity.STATE_FAILED, "STOPPED", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AgentRunStatusAction extends Enum<AgentRunStatusAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AgentRunStatusAction[] $VALUES = null;
    public static final AgentRunStatusAction COMPLETED = null;
    public static final AgentRunStatusAction FAILED = null;
    public static final AgentRunStatusAction HIDDEN = null;
    public static final AgentRunStatusAction STOP = null;
    public static final AgentRunStatusAction STOPPED = null;

    private static final /* synthetic */ AgentRunStatusAction[] $values() {
        return new AgentRunStatusAction[]{HIDDEN, STOP, COMPLETED, FAILED, STOPPED};
    }

    static {
        HIDDEN = new AgentRunStatusAction("HIDDEN", 0);
        STOP = new AgentRunStatusAction("STOP", 1);
        COMPLETED = new AgentRunStatusAction("COMPLETED", 2);
        FAILED = new AgentRunStatusAction(RawObservationEntity.STATE_FAILED, 3);
        STOPPED = new AgentRunStatusAction("STOPPED", 4);
        AgentRunStatusAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AgentRunStatusAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AgentRunStatusAction> getEntries() {
        return $ENTRIES;
    }

    public static AgentRunStatusAction valueOf(String r2) {
        return (AgentRunStatusAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgentRunStatusAction.class, r2), AgentRunStatusAction.class, "com.obric.memorydata.plugin");
    }

    public static AgentRunStatusAction[] values() {
        return (AgentRunStatusAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgentRunStatusAction[].class, "com.obric.memorydata.plugin");
    }
}
