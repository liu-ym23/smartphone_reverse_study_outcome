package com.larus.bmhome.chat.layout.holder.answeraction;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/answeraction/RegenInstructionEnum;", "", "type", "", "instruction", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getInstruction", "()Ljava/lang/String;", "REGEN_DEFAULT", "REGEN_SHORTER", "REGEN_LONGER", "REGEN_MORE_CASUAL", "REGEN_DEEP_THINK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RegenInstructionEnum extends Enum<RegenInstructionEnum> {
    public static final RegenInstructionEnum REGEN_DEEP_THINK = null;
    public static final RegenInstructionEnum REGEN_DEFAULT = null;
    public static final RegenInstructionEnum REGEN_LONGER = null;
    public static final RegenInstructionEnum REGEN_MORE_CASUAL = null;
    public static final RegenInstructionEnum REGEN_SHORTER = null;
    public static final /* synthetic */ RegenInstructionEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String instruction;
    private final int type;

    public static EnumEntries<RegenInstructionEnum> getEntries() {
        return b;
    }

    static {
        RegenInstructionEnum r0 = new RegenInstructionEnum("REGEN_DEFAULT", 0, 0, "default");
        REGEN_DEFAULT = r0;
        RegenInstructionEnum r1 = new RegenInstructionEnum("REGEN_SHORTER", 1, 1, "Shorter");
        REGEN_SHORTER = r1;
        RegenInstructionEnum r2 = new RegenInstructionEnum("REGEN_LONGER", 2, 2, "Longer");
        REGEN_LONGER = r2;
        RegenInstructionEnum r4 = new RegenInstructionEnum("REGEN_MORE_CASUAL", 3, 3, "More_casual");
        REGEN_MORE_CASUAL = r4;
        RegenInstructionEnum r6 = new RegenInstructionEnum("REGEN_DEEP_THINK", 4, 4, "DeepThink");
        REGEN_DEEP_THINK = r6;
        RegenInstructionEnum[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static RegenInstructionEnum[] values() {
        return (RegenInstructionEnum[]) a.clone();
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final int getType() {
        return this.type;
    }

    public static RegenInstructionEnum valueOf(String r1) {
        return (RegenInstructionEnum) r27.a.a(RegenInstructionEnum.class, r1);
    }

    public RegenInstructionEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.instruction = r4;
    }
}
