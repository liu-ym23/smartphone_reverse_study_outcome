package com.larus.bmhome.chat.component.list.pipeline;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "", "<init>", "(Ljava/lang/String;I)V", "FOR_EACH", "PICK_FIRST", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PipelineTaskType extends Enum<PipelineTaskType> {
    public static final PipelineTaskType FOR_EACH = null;
    public static final PipelineTaskType PICK_FIRST = null;
    public static final /* synthetic */ PipelineTaskType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PipelineTaskType> getEntries() {
        return b;
    }

    static {
        PipelineTaskType r0 = new PipelineTaskType("FOR_EACH", 0);
        FOR_EACH = r0;
        PipelineTaskType r1 = new PipelineTaskType("PICK_FIRST", 1);
        PICK_FIRST = r1;
        PipelineTaskType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PipelineTaskType[] values() {
        return (PipelineTaskType[]) a.clone();
    }

    public static PipelineTaskType valueOf(String r1) {
        return (PipelineTaskType) a.a(PipelineTaskType.class, r1);
    }

    public PipelineTaskType(String r1, int r2) {
        super(r1, r2);
    }
}
