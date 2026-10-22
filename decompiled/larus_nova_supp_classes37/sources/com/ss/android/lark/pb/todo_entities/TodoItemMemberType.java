package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TodoItemMemberType extends Enum<TodoItemMemberType> implements WireEnum {
    private static final /* synthetic */ TodoItemMemberType[] $VALUES = null;
    public static final ProtoAdapter<TodoItemMemberType> ADAPTER = null;
    public static final TodoItemMemberType APP = null;
    public static final TodoItemMemberType DOCS = null;
    public static final TodoItemMemberType GROUP = null;
    public static final TodoItemMemberType MEEGO = null;
    public static final TodoItemMemberType UNKNOWN_TODO_ITEM_MEMBER_TYPE = null;
    public static final TodoItemMemberType USER = null;
    private final int value;

    static {
        TodoItemMemberType r0 = new TodoItemMemberType("UNKNOWN_TODO_ITEM_MEMBER_TYPE", 0, 0);
        UNKNOWN_TODO_ITEM_MEMBER_TYPE = r0;
        TodoItemMemberType r1 = new TodoItemMemberType("USER", 1, 1);
        USER = r1;
        TodoItemMemberType r3 = new TodoItemMemberType("GROUP", 2, 2);
        GROUP = r3;
        TodoItemMemberType r5 = new TodoItemMemberType("APP", 3, 3);
        APP = r5;
        TodoItemMemberType r7 = new TodoItemMemberType("DOCS", 4, 4);
        DOCS = r7;
        TodoItemMemberType r9 = new TodoItemMemberType("MEEGO", 5, 6);
        MEEGO = r9;
        $VALUES = new TodoItemMemberType[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoItemMemberType.class);
    }

    public static TodoItemMemberType[] values() {
        return (TodoItemMemberType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TodoItemMemberType fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 6) goto L16;
        return null;
    L16:
        return MEEGO;
    L18:
        return DOCS;
    L20:
        return APP;
    L22:
        return GROUP;
    L24:
        return USER;
    L26:
        return UNKNOWN_TODO_ITEM_MEMBER_TYPE;
    }

    public static TodoItemMemberType valueOf(String r1) {
        return (TodoItemMemberType) a.a(TodoItemMemberType.class, r1);
    }

    private TodoItemMemberType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
