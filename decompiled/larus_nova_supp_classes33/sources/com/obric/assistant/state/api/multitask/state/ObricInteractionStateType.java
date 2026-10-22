package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ObricInteractionStateType;", "", "taskId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "INSTRUCTION_PANEL_VISIBLE", "KEYBOARD_VISIBLE", "ATTACHMENT_PANEL_VISIBLE", "BOTTOM_MENU_VISIBLE", "INPUT_TEXT_ACTIVE", "MESSAGE_LIST_SCROLLING", "POPUP_OR_DIALOG_VISIBLE", "ACTION_BAR_SCROLLING", "INPUT_REPLY_VISIBLE", "SECONDARY_MENU_VISIBLE", "MESSAGE_MODIFY_VISIBLE", "MESSAGE_SELECT_MODE_ACTIVE", "TASK_SKILL_PANEL_VISIBLE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInteractionStateType extends Enum<ObricInteractionStateType> {
    public static final ObricInteractionStateType ACTION_BAR_SCROLLING = null;
    public static final ObricInteractionStateType ATTACHMENT_PANEL_VISIBLE = null;
    public static final ObricInteractionStateType BOTTOM_MENU_VISIBLE = null;
    public static final ObricInteractionStateType INPUT_REPLY_VISIBLE = null;
    public static final ObricInteractionStateType INPUT_TEXT_ACTIVE = null;
    public static final ObricInteractionStateType INSTRUCTION_PANEL_VISIBLE = null;
    public static final ObricInteractionStateType KEYBOARD_VISIBLE = null;
    public static final ObricInteractionStateType MESSAGE_LIST_SCROLLING = null;
    public static final ObricInteractionStateType MESSAGE_MODIFY_VISIBLE = null;
    public static final ObricInteractionStateType MESSAGE_SELECT_MODE_ACTIVE = null;
    public static final ObricInteractionStateType POPUP_OR_DIALOG_VISIBLE = null;
    public static final ObricInteractionStateType SECONDARY_MENU_VISIBLE = null;
    public static final ObricInteractionStateType TASK_SKILL_PANEL_VISIBLE = null;
    public static final /* synthetic */ ObricInteractionStateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String taskId;

    public static EnumEntries<ObricInteractionStateType> getEntries() {
        return b;
    }

    static {
        ObricInteractionStateType r0 = new ObricInteractionStateType("INSTRUCTION_PANEL_VISIBLE", 0, "instruction_panel_visible");
        INSTRUCTION_PANEL_VISIBLE = r0;
        ObricInteractionStateType r1 = new ObricInteractionStateType("KEYBOARD_VISIBLE", 1, "keyboard_visible");
        KEYBOARD_VISIBLE = r1;
        ObricInteractionStateType r2 = new ObricInteractionStateType("ATTACHMENT_PANEL_VISIBLE", 2, "attachment_panel_visible");
        ATTACHMENT_PANEL_VISIBLE = r2;
        ObricInteractionStateType r4 = new ObricInteractionStateType("BOTTOM_MENU_VISIBLE", 3, "bottom_menu_visible");
        BOTTOM_MENU_VISIBLE = r4;
        ObricInteractionStateType r6 = new ObricInteractionStateType("INPUT_TEXT_ACTIVE", 4, "input_text_active");
        INPUT_TEXT_ACTIVE = r6;
        ObricInteractionStateType r8 = new ObricInteractionStateType("MESSAGE_LIST_SCROLLING", 5, "message_list_scrolling");
        MESSAGE_LIST_SCROLLING = r8;
        ObricInteractionStateType r10 = new ObricInteractionStateType("POPUP_OR_DIALOG_VISIBLE", 6, "popup_or_dialog_visible");
        POPUP_OR_DIALOG_VISIBLE = r10;
        ObricInteractionStateType r12 = new ObricInteractionStateType("ACTION_BAR_SCROLLING", 7, "action_bar_scrolling");
        ACTION_BAR_SCROLLING = r12;
        ObricInteractionStateType r14 = new ObricInteractionStateType("INPUT_REPLY_VISIBLE", 8, "input_reply_visible");
        INPUT_REPLY_VISIBLE = r14;
        ObricInteractionStateType r13 = new ObricInteractionStateType("SECONDARY_MENU_VISIBLE", 9, "secondary_menu_visible");
        SECONDARY_MENU_VISIBLE = r13;
        ObricInteractionStateType r11 = new ObricInteractionStateType("MESSAGE_MODIFY_VISIBLE", 10, "message_modify_visible");
        MESSAGE_MODIFY_VISIBLE = r11;
        ObricInteractionStateType r9 = new ObricInteractionStateType("MESSAGE_SELECT_MODE_ACTIVE", 11, "message_select_mode_active");
        MESSAGE_SELECT_MODE_ACTIVE = r9;
        ObricInteractionStateType r7 = new ObricInteractionStateType("TASK_SKILL_PANEL_VISIBLE", 12, "task_skill_panel_visible");
        TASK_SKILL_PANEL_VISIBLE = r7;
        ObricInteractionStateType[] r5 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ObricInteractionStateType[] values() {
        return (ObricInteractionStateType[]) a.clone();
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public static ObricInteractionStateType valueOf(String r1) {
        return (ObricInteractionStateType) a.a(ObricInteractionStateType.class, r1);
    }

    public ObricInteractionStateType(String r1, int r2, String r3) {
        super(r1, r2);
        this.taskId = r3;
    }
}
