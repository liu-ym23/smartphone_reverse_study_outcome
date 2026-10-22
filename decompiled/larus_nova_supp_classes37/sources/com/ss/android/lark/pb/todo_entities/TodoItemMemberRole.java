package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TodoItemMemberRole extends Enum<TodoItemMemberRole> implements WireEnum {
    private static final /* synthetic */ TodoItemMemberRole[] $VALUES = null;
    public static final ProtoAdapter<TodoItemMemberRole> ADAPTER = null;
    public static final TodoItemMemberRole INHERIT = null;
    public static final TodoItemMemberRole NONE = null;
    public static final TodoItemMemberRole OWNER = null;
    public static final TodoItemMemberRole READER = null;
    public static final TodoItemMemberRole WRITER = null;
    private final int value;

    static {
        TodoItemMemberRole r0 = new TodoItemMemberRole("NONE", 0, 0);
        NONE = r0;
        TodoItemMemberRole r1 = new TodoItemMemberRole("OWNER", 1, 1);
        OWNER = r1;
        TodoItemMemberRole r3 = new TodoItemMemberRole("WRITER", 2, 2);
        WRITER = r3;
        TodoItemMemberRole r5 = new TodoItemMemberRole("READER", 3, 3);
        READER = r5;
        TodoItemMemberRole r7 = new TodoItemMemberRole("INHERIT", 4, 100);
        INHERIT = r7;
        $VALUES = new TodoItemMemberRole[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoItemMemberRole.class);
    }

    public static TodoItemMemberRole[] values() {
        return (TodoItemMemberRole[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TodoItemMemberRole fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 100) goto L14;
        return null;
    L14:
        return INHERIT;
    L16:
        return READER;
    L18:
        return WRITER;
    L20:
        return OWNER;
    L22:
        return NONE;
    }

    public static TodoItemMemberRole valueOf(String r1) {
        return (TodoItemMemberRole) a.a(TodoItemMemberRole.class, r1);
    }

    private TodoItemMemberRole(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
