package com.larus.bmhome.chat.markdown.vlm;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/FlowVLMContainerViewType;", "", "<init>", "(Ljava/lang/String;I)V", "NoContent", "SingleItem", "MultipleItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum FlowVLMContainerViewType extends Enum<FlowVLMContainerViewType> {
    public static final FlowVLMContainerViewType MultipleItem = null;
    public static final FlowVLMContainerViewType NoContent = null;
    public static final FlowVLMContainerViewType SingleItem = null;
    public static final /* synthetic */ FlowVLMContainerViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowVLMContainerViewType> getEntries() {
        return b;
    }

    static {
        FlowVLMContainerViewType r0 = new FlowVLMContainerViewType("NoContent", 0);
        NoContent = r0;
        FlowVLMContainerViewType r1 = new FlowVLMContainerViewType("SingleItem", 1);
        SingleItem = r1;
        FlowVLMContainerViewType r3 = new FlowVLMContainerViewType("MultipleItem", 2);
        MultipleItem = r3;
        FlowVLMContainerViewType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FlowVLMContainerViewType[] values() {
        return (FlowVLMContainerViewType[]) a.clone();
    }

    public static FlowVLMContainerViewType valueOf(String r1) {
        return (FlowVLMContainerViewType) a.a(FlowVLMContainerViewType.class, r1);
    }

    public FlowVLMContainerViewType(String r1, int r2) {
        super(r1, r2);
    }
}
