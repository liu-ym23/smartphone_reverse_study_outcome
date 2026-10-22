package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TaskFieldCategory extends Enum<TaskFieldCategory> implements WireEnum {
    private static final /* synthetic */ TaskFieldCategory[] $VALUES = null;
    public static final ProtoAdapter<TaskFieldCategory> ADAPTER = null;
    public static final TaskFieldCategory PERSONAL = null;
    public static final TaskFieldCategory SYSTEM = null;
    public static final TaskFieldCategory TASK_LIST = null;
    public static final TaskFieldCategory TEMPLATE = null;
    public static final TaskFieldCategory UNKNOWN_FIELD_CATEGORY = null;
    private final int value;

    static {
        TaskFieldCategory r0 = new TaskFieldCategory("UNKNOWN_FIELD_CATEGORY", 0, 0);
        UNKNOWN_FIELD_CATEGORY = r0;
        TaskFieldCategory r1 = new TaskFieldCategory("SYSTEM", 1, 1);
        SYSTEM = r1;
        TaskFieldCategory r3 = new TaskFieldCategory("TEMPLATE", 2, 2);
        TEMPLATE = r3;
        TaskFieldCategory r5 = new TaskFieldCategory("TASK_LIST", 3, 3);
        TASK_LIST = r5;
        TaskFieldCategory r7 = new TaskFieldCategory("PERSONAL", 4, 4);
        PERSONAL = r7;
        $VALUES = new TaskFieldCategory[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(TaskFieldCategory.class);
    }

    public static TaskFieldCategory[] values() {
        return (TaskFieldCategory[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskFieldCategory fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return PERSONAL;
    L16:
        return TASK_LIST;
    L18:
        return TEMPLATE;
    L20:
        return SYSTEM;
    L22:
        return UNKNOWN_FIELD_CATEGORY;
    }

    public static TaskFieldCategory valueOf(String r1) {
        return (TaskFieldCategory) a.a(TaskFieldCategory.class, r1);
    }

    private TaskFieldCategory(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
