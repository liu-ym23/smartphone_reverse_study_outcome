package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/actionbar/model/AgentMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MOA", "CHAT", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum AgentMode extends Enum<AgentMode> {
    public static final AgentMode CHAT = null;
    public static final AgentMode MOA = null;
    public static final AgentMode UNKNOWN = null;
    public static final /* synthetic */ AgentMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AgentMode> getEntries() {
        return b;
    }

    static {
        AgentMode r0 = new AgentMode("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        AgentMode r1 = new AgentMode("MOA", 1, 1);
        MOA = r1;
        AgentMode r3 = new AgentMode("CHAT", 2, 2);
        CHAT = r3;
        AgentMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AgentMode[] values() {
        return (AgentMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AgentMode valueOf(String r1) {
        return (AgentMode) r27.a.a(AgentMode.class, r1);
    }

    public AgentMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
