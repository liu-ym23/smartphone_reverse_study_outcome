package com.larus.bmhome.chat.block.base.config;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/ToolBlockInitStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Fold", "Default", "Expand", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ToolBlockInitStatus extends Enum<ToolBlockInitStatus> {
    public static final ToolBlockInitStatus Default = null;
    public static final ToolBlockInitStatus Expand = null;
    public static final ToolBlockInitStatus Fold = null;
    public static final /* synthetic */ ToolBlockInitStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ToolBlockInitStatus> getEntries() {
        return b;
    }

    static {
        ToolBlockInitStatus r0 = new ToolBlockInitStatus("Fold", 0);
        Fold = r0;
        ToolBlockInitStatus r1 = new ToolBlockInitStatus("Default", 1);
        Default = r1;
        ToolBlockInitStatus r3 = new ToolBlockInitStatus("Expand", 2);
        Expand = r3;
        ToolBlockInitStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ToolBlockInitStatus[] values() {
        return (ToolBlockInitStatus[]) a.clone();
    }

    public static ToolBlockInitStatus valueOf(String r1) {
        return (ToolBlockInitStatus) a.a(ToolBlockInitStatus.class, r1);
    }

    public ToolBlockInitStatus(String r1, int r2) {
        super(r1, r2);
    }
}
