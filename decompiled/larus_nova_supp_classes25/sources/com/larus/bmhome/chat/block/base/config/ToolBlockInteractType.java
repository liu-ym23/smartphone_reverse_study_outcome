package com.larus.bmhome.chat.block.base.config;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/ToolBlockInteractType;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "DisableHeaderInteract", "OpenFloatingPage", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ToolBlockInteractType extends Enum<ToolBlockInteractType> {
    public static final ToolBlockInteractType Default = null;
    public static final ToolBlockInteractType DisableHeaderInteract = null;
    public static final ToolBlockInteractType OpenFloatingPage = null;
    public static final /* synthetic */ ToolBlockInteractType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ToolBlockInteractType> getEntries() {
        return b;
    }

    static {
        ToolBlockInteractType r0 = new ToolBlockInteractType("Default", 0);
        Default = r0;
        ToolBlockInteractType r1 = new ToolBlockInteractType("DisableHeaderInteract", 1);
        DisableHeaderInteract = r1;
        ToolBlockInteractType r3 = new ToolBlockInteractType("OpenFloatingPage", 2);
        OpenFloatingPage = r3;
        ToolBlockInteractType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ToolBlockInteractType[] values() {
        return (ToolBlockInteractType[]) a.clone();
    }

    public static ToolBlockInteractType valueOf(String r1) {
        return (ToolBlockInteractType) a.a(ToolBlockInteractType.class, r1);
    }

    public ToolBlockInteractType(String r1, int r2) {
        super(r1, r2);
    }
}
