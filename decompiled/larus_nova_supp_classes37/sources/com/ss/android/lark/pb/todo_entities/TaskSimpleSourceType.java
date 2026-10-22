package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TaskSimpleSourceType extends Enum<TaskSimpleSourceType> implements WireEnum {
    private static final /* synthetic */ TaskSimpleSourceType[] $VALUES = null;
    public static final ProtoAdapter<TaskSimpleSourceType> ADAPTER = null;
    public static final TaskSimpleSourceType ALL_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType DOCX_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType MEEGO_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType MESSENGER_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType OPENAPI_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType OTHER_SOURCE_TYPE = null;
    public static final TaskSimpleSourceType UNKNOWN_SOURCE_TYPE = null;
    private final int value;

    static {
        TaskSimpleSourceType r0 = new TaskSimpleSourceType("UNKNOWN_SOURCE_TYPE", 0, 0);
        UNKNOWN_SOURCE_TYPE = r0;
        TaskSimpleSourceType r1 = new TaskSimpleSourceType("ALL_SOURCE_TYPE", 1, 1);
        ALL_SOURCE_TYPE = r1;
        TaskSimpleSourceType r3 = new TaskSimpleSourceType("MESSENGER_SOURCE_TYPE", 2, 2);
        MESSENGER_SOURCE_TYPE = r3;
        TaskSimpleSourceType r5 = new TaskSimpleSourceType("DOCX_SOURCE_TYPE", 3, 3);
        DOCX_SOURCE_TYPE = r5;
        TaskSimpleSourceType r7 = new TaskSimpleSourceType("OPENAPI_SOURCE_TYPE", 4, 4);
        OPENAPI_SOURCE_TYPE = r7;
        TaskSimpleSourceType r9 = new TaskSimpleSourceType("MEEGO_SOURCE_TYPE", 5, 5);
        MEEGO_SOURCE_TYPE = r9;
        TaskSimpleSourceType r11 = new TaskSimpleSourceType("OTHER_SOURCE_TYPE", 6, 255);
        OTHER_SOURCE_TYPE = r11;
        $VALUES = new TaskSimpleSourceType[]{r0, r1, r3, r5, r7, r9, r11};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskSimpleSourceType.class);
    }

    public static TaskSimpleSourceType[] values() {
        return (TaskSimpleSourceType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskSimpleSourceType fromValue(int r1) {
        if (r1 == 0) goto L30;
        if (r1 == 1) goto L28;
        if (r1 == 2) goto L26;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L22;
        if (r1 == 5) goto L20;
        if (r1 == 255) goto L18;
        return null;
    L18:
        return OTHER_SOURCE_TYPE;
    L20:
        return MEEGO_SOURCE_TYPE;
    L22:
        return OPENAPI_SOURCE_TYPE;
    L24:
        return DOCX_SOURCE_TYPE;
    L26:
        return MESSENGER_SOURCE_TYPE;
    L28:
        return ALL_SOURCE_TYPE;
    L30:
        return UNKNOWN_SOURCE_TYPE;
    }

    public static TaskSimpleSourceType valueOf(String r1) {
        return (TaskSimpleSourceType) a.a(TaskSimpleSourceType.class, r1);
    }

    private TaskSimpleSourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
