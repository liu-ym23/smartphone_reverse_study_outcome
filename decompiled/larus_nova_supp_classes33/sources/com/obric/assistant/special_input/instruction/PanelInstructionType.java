package com.obric.assistant.special_input.instruction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/special_input/instruction/PanelInstructionType;", "", "trackValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackValue", "()Ljava/lang/String;", "SHORTCUT_SHORT", "SHORTCUT", "RECOMMEND_MEMORY", "RECOMMEND_OPERATION", "RECOMMEND_LOCAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelInstructionType extends Enum<PanelInstructionType> {
    public static final PanelInstructionType RECOMMEND_LOCAL = null;
    public static final PanelInstructionType RECOMMEND_MEMORY = null;
    public static final PanelInstructionType RECOMMEND_OPERATION = null;
    public static final PanelInstructionType SHORTCUT = null;
    public static final PanelInstructionType SHORTCUT_SHORT = null;
    public static final /* synthetic */ PanelInstructionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String trackValue;

    public static EnumEntries<PanelInstructionType> getEntries() {
        return b;
    }

    static {
        PanelInstructionType r0 = new PanelInstructionType("SHORTCUT_SHORT", 0, "shortcut_short");
        SHORTCUT_SHORT = r0;
        PanelInstructionType r1 = new PanelInstructionType("SHORTCUT", 1, "shortcut");
        SHORTCUT = r1;
        PanelInstructionType r2 = new PanelInstructionType("RECOMMEND_MEMORY", 2, "recommend_memory");
        RECOMMEND_MEMORY = r2;
        PanelInstructionType r4 = new PanelInstructionType("RECOMMEND_OPERATION", 3, "recommend_operation");
        RECOMMEND_OPERATION = r4;
        PanelInstructionType r6 = new PanelInstructionType("RECOMMEND_LOCAL", 4, "recommend_local");
        RECOMMEND_LOCAL = r6;
        PanelInstructionType[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static PanelInstructionType[] values() {
        return (PanelInstructionType[]) a.clone();
    }

    public final String getTrackValue() {
        return this.trackValue;
    }

    public static PanelInstructionType valueOf(String r1) {
        return (PanelInstructionType) r27.a.a(PanelInstructionType.class, r1);
    }

    public PanelInstructionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.trackValue = r3;
    }
}
