package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/CompositeBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CompositeTopBox", "CompositeMiddleBox", "CompositeBottomBox", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CompositeBoxType extends Enum<CompositeBoxType> {
    public static final CompositeBoxType CompositeBottomBox = null;
    public static final CompositeBoxType CompositeMiddleBox = null;
    public static final CompositeBoxType CompositeTopBox = null;
    public static final /* synthetic */ CompositeBoxType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CompositeBoxType> getEntries() {
        return b;
    }

    static {
        CompositeBoxType r0 = new CompositeBoxType("CompositeTopBox", 0);
        CompositeTopBox = r0;
        CompositeBoxType r1 = new CompositeBoxType("CompositeMiddleBox", 1);
        CompositeMiddleBox = r1;
        CompositeBoxType r3 = new CompositeBoxType("CompositeBottomBox", 2);
        CompositeBottomBox = r3;
        CompositeBoxType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CompositeBoxType[] values() {
        return (CompositeBoxType[]) a.clone();
    }

    public static CompositeBoxType valueOf(String r1) {
        return (CompositeBoxType) r27.a.a(CompositeBoxType.class, r1);
    }

    public CompositeBoxType(String r1, int r2) {
        super(r1, r2);
    }
}
