package com.larus.bmhome.chat.cell;

import com.larus.bmhome.chat.bean.WcbRenderStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/cell/ComponentCellStateType;", "", "<init>", "(Ljava/lang/String;I)V", WcbRenderStatus.DEFAULT, "NEW_TEXT_CELL", "TOP_TEXT_CELL", "MIDDLE_TEXT_CELL", "BOTTOM_TEXT_CELL", "DEEP_THINK_HEADER_TITLE_CELL", "DEEP_THINK_CONTENT_CELL", "DEEP_THINK_REFERENCE_CELL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ComponentCellStateType extends Enum<ComponentCellStateType> {
    public static final ComponentCellStateType BOTTOM_TEXT_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_CONTENT_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_HEADER_TITLE_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_REFERENCE_CELL = null;
    public static final ComponentCellStateType DEFAULT = null;
    public static final ComponentCellStateType MIDDLE_TEXT_CELL = null;
    public static final ComponentCellStateType NEW_TEXT_CELL = null;
    public static final ComponentCellStateType TOP_TEXT_CELL = null;
    public static final /* synthetic */ ComponentCellStateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ComponentCellStateType> getEntries() {
        return b;
    }

    static {
        ComponentCellStateType r0 = new ComponentCellStateType(WcbRenderStatus.DEFAULT, 0);
        DEFAULT = r0;
        ComponentCellStateType r1 = new ComponentCellStateType("NEW_TEXT_CELL", 1);
        NEW_TEXT_CELL = r1;
        ComponentCellStateType r3 = new ComponentCellStateType("TOP_TEXT_CELL", 2);
        TOP_TEXT_CELL = r3;
        ComponentCellStateType r5 = new ComponentCellStateType("MIDDLE_TEXT_CELL", 3);
        MIDDLE_TEXT_CELL = r5;
        ComponentCellStateType r7 = new ComponentCellStateType("BOTTOM_TEXT_CELL", 4);
        BOTTOM_TEXT_CELL = r7;
        ComponentCellStateType r9 = new ComponentCellStateType("DEEP_THINK_HEADER_TITLE_CELL", 5);
        DEEP_THINK_HEADER_TITLE_CELL = r9;
        ComponentCellStateType r11 = new ComponentCellStateType("DEEP_THINK_CONTENT_CELL", 6);
        DEEP_THINK_CONTENT_CELL = r11;
        ComponentCellStateType r13 = new ComponentCellStateType("DEEP_THINK_REFERENCE_CELL", 7);
        DEEP_THINK_REFERENCE_CELL = r13;
        ComponentCellStateType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static ComponentCellStateType[] values() {
        return (ComponentCellStateType[]) a.clone();
    }

    public static ComponentCellStateType valueOf(String r1) {
        return (ComponentCellStateType) a.a(ComponentCellStateType.class, r1);
    }

    public ComponentCellStateType(String r1, int r2) {
        super(r1, r2);
    }
}
