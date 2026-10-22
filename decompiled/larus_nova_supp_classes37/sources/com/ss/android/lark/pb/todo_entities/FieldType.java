package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.profile.v2.entity.BaseField;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FieldType extends Enum<FieldType> implements WireEnum {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final ProtoAdapter<FieldType> ADAPTER = null;
    public static final FieldType AGENT_TASK_PROGRESS = null;
    public static final FieldType AGENT_TASK_STATUS = null;
    public static final FieldType ATTACHMENT = null;
    public static final FieldType DATETIME = null;
    public static final FieldType MEMBER = null;
    public static final FieldType MULTI_SELECT = null;
    public static final FieldType NUMBER = null;
    public static final FieldType SINGLE_SELECT = null;
    public static final FieldType SUB_TASK_PROGRESS = null;
    public static final FieldType TASK_ASSIGNEE = null;
    public static final FieldType TASK_COMPLETED_TIME = null;
    public static final FieldType TASK_COMPLETE_STATUS = null;
    public static final FieldType TASK_CONTAINER = null;
    public static final FieldType TASK_DUE_TIME = null;
    public static final FieldType TASK_NUM = null;
    public static final FieldType TASK_POINTS = null;
    public static final FieldType TASK_RELATED_LIST = null;
    public static final FieldType TASK_SECTION = null;
    public static final FieldType TASK_SOURCE = null;
    public static final FieldType TASK_SOURCE_TYPE = null;
    public static final FieldType TASK_START_TIME = null;
    public static final FieldType TASK_TITLE = null;
    public static final FieldType TEXT = null;
    public static final FieldType UNKNOWN_FIELD_TYPE = null;
    private final int value;

    static {
        FieldType r0 = new FieldType("UNKNOWN_FIELD_TYPE", 0, 0);
        UNKNOWN_FIELD_TYPE = r0;
        FieldType r1 = new FieldType("MEMBER", 1, 1);
        MEMBER = r1;
        FieldType r3 = new FieldType("DATETIME", 2, 2);
        DATETIME = r3;
        FieldType r5 = new FieldType("ATTACHMENT", 3, 3);
        ATTACHMENT = r5;
        FieldType r7 = new FieldType("NUMBER", 4, 4);
        NUMBER = r7;
        FieldType r9 = new FieldType("SINGLE_SELECT", 5, 5);
        SINGLE_SELECT = r9;
        FieldType r11 = new FieldType("MULTI_SELECT", 6, 6);
        MULTI_SELECT = r11;
        FieldType r13 = new FieldType("TEXT", 7, 7);
        TEXT = r13;
        FieldType r15 = new FieldType("TASK_TITLE", 8, 100);
        TASK_TITLE = r15;
        FieldType r12 = new FieldType("TASK_DUE_TIME", 9, BaseField.FIELD_TYPE_S_PHONE_NUMBER);
        TASK_DUE_TIME = r12;
        FieldType r10 = new FieldType("TASK_COMPLETED_TIME", 10, BaseField.FIELD_TYPE_S_FRIEND_LINK);
        TASK_COMPLETED_TIME = r10;
        FieldType r8 = new FieldType("SUB_TASK_PROGRESS", 11, 103);
        SUB_TASK_PROGRESS = r8;
        FieldType r6 = new FieldType("TASK_SOURCE", 12, BaseField.FIELD_TYPE_ALIAS_AND_MEMO);
        TASK_SOURCE = r6;
        FieldType r4 = new FieldType("TASK_SOURCE_TYPE", 13, BaseField.FIELD_TYPE_MEMO_DESCRIPTION);
        TASK_SOURCE_TYPE = r4;
        FieldType r2 = new FieldType("TASK_NUM", 14, 106);
        TASK_NUM = r2;
        FieldType r14 = new FieldType("TASK_SECTION", 15, 107);
        TASK_SECTION = r14;
        FieldType r16 = new FieldType("TASK_COMPLETE_STATUS", 16, 108);
        TASK_COMPLETE_STATUS = r16;
        FieldType r17 = new FieldType("TASK_ASSIGNEE", 17, 109);
        TASK_ASSIGNEE = r17;
        FieldType r18 = new FieldType("TASK_RELATED_LIST", 18, 110);
        TASK_RELATED_LIST = r18;
        FieldType r19 = new FieldType("TASK_START_TIME", 19, 111);
        TASK_START_TIME = r19;
        FieldType r20 = new FieldType("TASK_POINTS", 20, 112);
        TASK_POINTS = r20;
        FieldType r21 = new FieldType("TASK_CONTAINER", 21, 113);
        TASK_CONTAINER = r21;
        FieldType r22 = new FieldType("AGENT_TASK_STATUS", 22, 114);
        AGENT_TASK_STATUS = r22;
        FieldType r23 = new FieldType("AGENT_TASK_PROGRESS", 23, 115);
        AGENT_TASK_PROGRESS = r23;
        $VALUES = new FieldType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r12, r10, r8, r6, r4, r2, r14, r16, r17, r18, r19, r20, r21, r22, r23};
        ADAPTER = ProtoAdapter.newEnumAdapter(FieldType.class);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FieldType fromValue(int r0) {
        switch(r0) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 100: goto L37;
            case 101: goto L35;
            case 102: goto L33;
            case 103: goto L31;
            case 104: goto L29;
            case 105: goto L27;
            case 106: goto L25;
            case 107: goto L23;
            case 108: goto L21;
            case 109: goto L19;
            case 110: goto L17;
            case 111: goto L15;
            case 112: goto L13;
            case 113: goto L11;
            case 114: goto L9;
            case 115: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return AGENT_TASK_PROGRESS;
    L9:
        return AGENT_TASK_STATUS;
    L11:
        return TASK_CONTAINER;
    L13:
        return TASK_POINTS;
    L15:
        return TASK_START_TIME;
    L17:
        return TASK_RELATED_LIST;
    L19:
        return TASK_ASSIGNEE;
    L21:
        return TASK_COMPLETE_STATUS;
    L23:
        return TASK_SECTION;
    L25:
        return TASK_NUM;
    L27:
        return TASK_SOURCE_TYPE;
    L29:
        return TASK_SOURCE;
    L31:
        return SUB_TASK_PROGRESS;
    L33:
        return TASK_COMPLETED_TIME;
    L35:
        return TASK_DUE_TIME;
    L37:
        return TASK_TITLE;
    L39:
        return TEXT;
    L41:
        return MULTI_SELECT;
    L43:
        return SINGLE_SELECT;
    L45:
        return NUMBER;
    L47:
        return ATTACHMENT;
    L49:
        return DATETIME;
    L51:
        return MEMBER;
    L53:
        return UNKNOWN_FIELD_TYPE;
    }

    public static FieldType valueOf(String r1) {
        return (FieldType) a.a(FieldType.class, r1);
    }

    private FieldType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
