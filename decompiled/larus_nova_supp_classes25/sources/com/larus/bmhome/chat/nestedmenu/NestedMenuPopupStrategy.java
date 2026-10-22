package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuPopupStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "ALIGN_TOP", "DROP_DOWN", "AUTO_DROP_DOWN_OR_ALIGN_TOP", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NestedMenuPopupStrategy extends Enum<NestedMenuPopupStrategy> {
    public static final NestedMenuPopupStrategy ALIGN_TOP = null;
    public static final NestedMenuPopupStrategy AUTO_DROP_DOWN_OR_ALIGN_TOP = null;
    public static final NestedMenuPopupStrategy DROP_DOWN = null;
    public static final /* synthetic */ NestedMenuPopupStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NestedMenuPopupStrategy> getEntries() {
        return b;
    }

    static {
        NestedMenuPopupStrategy r0 = new NestedMenuPopupStrategy("ALIGN_TOP", 0);
        ALIGN_TOP = r0;
        NestedMenuPopupStrategy r1 = new NestedMenuPopupStrategy("DROP_DOWN", 1);
        DROP_DOWN = r1;
        NestedMenuPopupStrategy r3 = new NestedMenuPopupStrategy("AUTO_DROP_DOWN_OR_ALIGN_TOP", 2);
        AUTO_DROP_DOWN_OR_ALIGN_TOP = r3;
        NestedMenuPopupStrategy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static NestedMenuPopupStrategy[] values() {
        return (NestedMenuPopupStrategy[]) a.clone();
    }

    public static NestedMenuPopupStrategy valueOf(String r1) {
        return (NestedMenuPopupStrategy) r27.a.a(NestedMenuPopupStrategy.class, r1);
    }

    public NestedMenuPopupStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
