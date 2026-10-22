package com.larus.canvas.feature.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/canvas/feature/ability/CanvasEditorEventType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "EVENT_CLICK_SEND_BUTTON", "EVENT_FINISH_SPEAK", "EVENT_FINISH_PASTE_AND_SEND", "EVENT_BOTTOM_INSET_UPDATE", "EVENT_INSTRUCTION_RENDER_CHANGE", "EVENT_DROP_DOWN_BOX_SELECTED", "EVENT_MSG_INSTRUCTION_TAB_CLICK", "EVENT_INSTRUCTION_TAB_SELECTED", "EVENT_INSTRUCTION_TAB_UN_SELECTED", "EVENT_INSTRUCTION_OPTION_CLICK", "EVENT_SELECTOR_PANEL_STATUS_CHANGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasEditorEventType extends Enum<CanvasEditorEventType> {
    public static final CanvasEditorEventType EVENT_BOTTOM_INSET_UPDATE = null;
    public static final CanvasEditorEventType EVENT_CLICK_SEND_BUTTON = null;
    public static final CanvasEditorEventType EVENT_DROP_DOWN_BOX_SELECTED = null;
    public static final CanvasEditorEventType EVENT_FINISH_PASTE_AND_SEND = null;
    public static final CanvasEditorEventType EVENT_FINISH_SPEAK = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_OPTION_CLICK = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_RENDER_CHANGE = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_TAB_SELECTED = null;
    public static final CanvasEditorEventType EVENT_INSTRUCTION_TAB_UN_SELECTED = null;
    public static final CanvasEditorEventType EVENT_MSG_INSTRUCTION_TAB_CLICK = null;
    public static final CanvasEditorEventType EVENT_SELECTOR_PANEL_STATUS_CHANGE = null;
    public static final CanvasEditorEventType NONE = null;
    public static final /* synthetic */ CanvasEditorEventType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CanvasEditorEventType> getEntries() {
        return b;
    }

    static {
        CanvasEditorEventType r0 = new CanvasEditorEventType("NONE", 0);
        NONE = r0;
        CanvasEditorEventType r1 = new CanvasEditorEventType("EVENT_CLICK_SEND_BUTTON", 1);
        EVENT_CLICK_SEND_BUTTON = r1;
        CanvasEditorEventType r3 = new CanvasEditorEventType("EVENT_FINISH_SPEAK", 2);
        EVENT_FINISH_SPEAK = r3;
        CanvasEditorEventType r5 = new CanvasEditorEventType("EVENT_FINISH_PASTE_AND_SEND", 3);
        EVENT_FINISH_PASTE_AND_SEND = r5;
        CanvasEditorEventType r7 = new CanvasEditorEventType("EVENT_BOTTOM_INSET_UPDATE", 4);
        EVENT_BOTTOM_INSET_UPDATE = r7;
        CanvasEditorEventType r9 = new CanvasEditorEventType("EVENT_INSTRUCTION_RENDER_CHANGE", 5);
        EVENT_INSTRUCTION_RENDER_CHANGE = r9;
        CanvasEditorEventType r11 = new CanvasEditorEventType("EVENT_DROP_DOWN_BOX_SELECTED", 6);
        EVENT_DROP_DOWN_BOX_SELECTED = r11;
        CanvasEditorEventType r13 = new CanvasEditorEventType("EVENT_MSG_INSTRUCTION_TAB_CLICK", 7);
        EVENT_MSG_INSTRUCTION_TAB_CLICK = r13;
        CanvasEditorEventType r15 = new CanvasEditorEventType("EVENT_INSTRUCTION_TAB_SELECTED", 8);
        EVENT_INSTRUCTION_TAB_SELECTED = r15;
        CanvasEditorEventType r14 = new CanvasEditorEventType("EVENT_INSTRUCTION_TAB_UN_SELECTED", 9);
        EVENT_INSTRUCTION_TAB_UN_SELECTED = r14;
        CanvasEditorEventType r12 = new CanvasEditorEventType("EVENT_INSTRUCTION_OPTION_CLICK", 10);
        EVENT_INSTRUCTION_OPTION_CLICK = r12;
        CanvasEditorEventType r10 = new CanvasEditorEventType("EVENT_SELECTOR_PANEL_STATUS_CHANGE", 11);
        EVENT_SELECTOR_PANEL_STATUS_CHANGE = r10;
        CanvasEditorEventType[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static CanvasEditorEventType[] values() {
        return (CanvasEditorEventType[]) a.clone();
    }

    public static CanvasEditorEventType valueOf(String r1) {
        return (CanvasEditorEventType) a.a(CanvasEditorEventType.class, r1);
    }

    public CanvasEditorEventType(String r1, int r2) {
        super(r1, r2);
    }
}
