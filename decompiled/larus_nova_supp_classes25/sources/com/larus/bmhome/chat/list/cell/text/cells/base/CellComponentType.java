package com.larus.bmhome.chat.list.cell.text.cells.base;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/base/CellComponentType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "DEEP_THINK_TOP_COMPONENT", "DEEP_THINK_REFERENCE_COMPONENT", "DEEP_THINK_CONTENT_COMPONENT", "TOP_CELL_COMPONENT", "MIDDLE_CELL_COMPONENT", "BOTTOM_CELL_COMPONENT", "COMPOSITE_CELL_COMPONENT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CellComponentType extends Enum<CellComponentType> {
    public static final CellComponentType BOTTOM_CELL_COMPONENT = null;
    public static final CellComponentType COMPOSITE_CELL_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_CONTENT_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_REFERENCE_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_TOP_COMPONENT = null;
    public static final CellComponentType MIDDLE_CELL_COMPONENT = null;
    public static final CellComponentType TOP_CELL_COMPONENT = null;
    public static final CellComponentType UNKNOWN = null;
    public static final /* synthetic */ CellComponentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CellComponentType> getEntries() {
        return b;
    }

    static {
        CellComponentType r0 = new CellComponentType("UNKNOWN", 0);
        UNKNOWN = r0;
        CellComponentType r1 = new CellComponentType("DEEP_THINK_TOP_COMPONENT", 1);
        DEEP_THINK_TOP_COMPONENT = r1;
        CellComponentType r3 = new CellComponentType("DEEP_THINK_REFERENCE_COMPONENT", 2);
        DEEP_THINK_REFERENCE_COMPONENT = r3;
        CellComponentType r5 = new CellComponentType("DEEP_THINK_CONTENT_COMPONENT", 3);
        DEEP_THINK_CONTENT_COMPONENT = r5;
        CellComponentType r7 = new CellComponentType("TOP_CELL_COMPONENT", 4);
        TOP_CELL_COMPONENT = r7;
        CellComponentType r9 = new CellComponentType("MIDDLE_CELL_COMPONENT", 5);
        MIDDLE_CELL_COMPONENT = r9;
        CellComponentType r11 = new CellComponentType("BOTTOM_CELL_COMPONENT", 6);
        BOTTOM_CELL_COMPONENT = r11;
        CellComponentType r13 = new CellComponentType("COMPOSITE_CELL_COMPONENT", 7);
        COMPOSITE_CELL_COMPONENT = r13;
        CellComponentType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static CellComponentType[] values() {
        return (CellComponentType[]) a.clone();
    }

    public static CellComponentType valueOf(String r1) {
        return (CellComponentType) r27.a.a(CellComponentType.class, r1);
    }

    public CellComponentType(String r1, int r2) {
        super(r1, r2);
    }
}
