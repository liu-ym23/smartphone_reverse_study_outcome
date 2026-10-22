package com.larus.canvas.feature.component.instruction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/InstructionTabEventType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "EVENT_INSTRUCTION_TAB_SELECTED", "EVENT_INSTRUCTION_TAB_UN_SELECTED", "EVENT_DROP_DOWN_BOX_SELECTED", "EVENT_MSG_INSTRUCTION_TAB_CLICK", "EVENT_INSTRUCTION_OPTION_CLICK", "EVENT_SELECTOR_PANEL_STATUS_SELECTED", "EVENT_SELECTOR_PANEL_STATUS_UNSELECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InstructionTabEventType extends Enum<InstructionTabEventType> {
    public static final InstructionTabEventType EVENT_DROP_DOWN_BOX_SELECTED = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_OPTION_CLICK = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_TAB_SELECTED = null;
    public static final InstructionTabEventType EVENT_INSTRUCTION_TAB_UN_SELECTED = null;
    public static final InstructionTabEventType EVENT_MSG_INSTRUCTION_TAB_CLICK = null;
    public static final InstructionTabEventType EVENT_SELECTOR_PANEL_STATUS_SELECTED = null;
    public static final InstructionTabEventType EVENT_SELECTOR_PANEL_STATUS_UNSELECTED = null;
    public static final InstructionTabEventType NONE = null;
    public static final /* synthetic */ InstructionTabEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InstructionTabEventType> getEntries() {
        return b;
    }

    static {
        InstructionTabEventType r0 = new InstructionTabEventType("NONE", 0);
        NONE = r0;
        InstructionTabEventType r1 = new InstructionTabEventType("EVENT_INSTRUCTION_TAB_SELECTED", 1);
        EVENT_INSTRUCTION_TAB_SELECTED = r1;
        InstructionTabEventType r3 = new InstructionTabEventType("EVENT_INSTRUCTION_TAB_UN_SELECTED", 2);
        EVENT_INSTRUCTION_TAB_UN_SELECTED = r3;
        InstructionTabEventType r5 = new InstructionTabEventType("EVENT_DROP_DOWN_BOX_SELECTED", 3);
        EVENT_DROP_DOWN_BOX_SELECTED = r5;
        InstructionTabEventType r7 = new InstructionTabEventType("EVENT_MSG_INSTRUCTION_TAB_CLICK", 4);
        EVENT_MSG_INSTRUCTION_TAB_CLICK = r7;
        InstructionTabEventType r9 = new InstructionTabEventType("EVENT_INSTRUCTION_OPTION_CLICK", 5);
        EVENT_INSTRUCTION_OPTION_CLICK = r9;
        InstructionTabEventType r11 = new InstructionTabEventType("EVENT_SELECTOR_PANEL_STATUS_SELECTED", 6);
        EVENT_SELECTOR_PANEL_STATUS_SELECTED = r11;
        InstructionTabEventType r13 = new InstructionTabEventType("EVENT_SELECTOR_PANEL_STATUS_UNSELECTED", 7);
        EVENT_SELECTOR_PANEL_STATUS_UNSELECTED = r13;
        InstructionTabEventType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static InstructionTabEventType[] values() {
        return (InstructionTabEventType[]) a.clone();
    }

    public static InstructionTabEventType valueOf(String r1) {
        return (InstructionTabEventType) r27.a.a(InstructionTabEventType.class, r1);
    }

    public InstructionTabEventType(String r1, int r2) {
        super(r1, r2);
    }
}
