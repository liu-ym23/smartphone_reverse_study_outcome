package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarExecutionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "BOT_SEND_MSG", "USER_SEND_MSG", "OPEN_BY_SCHEMA", "SWITCH_SYNC", "MSG_TEMPLATE", "COMPLEX_SEARCH", "INSTRUCTION", "RECORD", "MULTI_SUGGEST_ACTION", "SWITCH_STATUS", "GENERATE_PODCAST", "OPEN_CAMERA", "OBRIC_ACTION", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarExecutionType extends Enum<ActionBarExecutionType> {
    public static final ActionBarExecutionType BOT_SEND_MSG = null;
    public static final ActionBarExecutionType COMPLEX_SEARCH = null;
    public static final ActionBarExecutionType GENERATE_PODCAST = null;
    public static final ActionBarExecutionType INSTRUCTION = null;
    public static final ActionBarExecutionType MSG_TEMPLATE = null;
    public static final ActionBarExecutionType MULTI_SUGGEST_ACTION = null;
    public static final ActionBarExecutionType OBRIC_ACTION = null;
    public static final ActionBarExecutionType OPEN_BY_SCHEMA = null;
    public static final ActionBarExecutionType OPEN_CAMERA = null;
    public static final ActionBarExecutionType RECORD = null;
    public static final ActionBarExecutionType SWITCH_STATUS = null;
    public static final ActionBarExecutionType SWITCH_SYNC = null;
    public static final ActionBarExecutionType UNKNOWN = null;
    public static final ActionBarExecutionType USER_SEND_MSG = null;
    public static final /* synthetic */ ActionBarExecutionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ActionBarExecutionType> getEntries() {
        return b;
    }

    static {
        ActionBarExecutionType r0 = new ActionBarExecutionType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ActionBarExecutionType r1 = new ActionBarExecutionType("BOT_SEND_MSG", 1, 1);
        BOT_SEND_MSG = r1;
        ActionBarExecutionType r3 = new ActionBarExecutionType("USER_SEND_MSG", 2, 2);
        USER_SEND_MSG = r3;
        ActionBarExecutionType r5 = new ActionBarExecutionType("OPEN_BY_SCHEMA", 3, 3);
        OPEN_BY_SCHEMA = r5;
        ActionBarExecutionType r7 = new ActionBarExecutionType("SWITCH_SYNC", 4, 4);
        SWITCH_SYNC = r7;
        ActionBarExecutionType r9 = new ActionBarExecutionType("MSG_TEMPLATE", 5, 5);
        MSG_TEMPLATE = r9;
        ActionBarExecutionType r11 = new ActionBarExecutionType("COMPLEX_SEARCH", 6, 6);
        COMPLEX_SEARCH = r11;
        ActionBarExecutionType r13 = new ActionBarExecutionType("INSTRUCTION", 7, 7);
        INSTRUCTION = r13;
        ActionBarExecutionType r15 = new ActionBarExecutionType("RECORD", 8, 8);
        RECORD = r15;
        ActionBarExecutionType r14 = new ActionBarExecutionType("MULTI_SUGGEST_ACTION", 9, 10);
        MULTI_SUGGEST_ACTION = r14;
        ActionBarExecutionType r12 = new ActionBarExecutionType("SWITCH_STATUS", 10, 11);
        SWITCH_STATUS = r12;
        ActionBarExecutionType r10 = new ActionBarExecutionType("GENERATE_PODCAST", 11, 12);
        GENERATE_PODCAST = r10;
        ActionBarExecutionType r8 = new ActionBarExecutionType("OPEN_CAMERA", 12, 13);
        OPEN_CAMERA = r8;
        ActionBarExecutionType r6 = new ActionBarExecutionType("OBRIC_ACTION", 13, 3001);
        OBRIC_ACTION = r6;
        ActionBarExecutionType[] r4 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ActionBarExecutionType[] values() {
        return (ActionBarExecutionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionBarExecutionType valueOf(String r1) {
        return (ActionBarExecutionType) a.a(ActionBarExecutionType.class, r1);
    }

    public ActionBarExecutionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
