package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType HashTag = null;
    public static final ActionType Todo = null;
    public static final /* synthetic */ ActionType[] a = null;
    private int value;

    static {
        ActionType r0 = new ActionType("HashTag", 0, 1);
        HashTag = r0;
        ActionType r1 = new ActionType("Todo", 1, 2);
        Todo = r1;
        a = new ActionType[]{r0, r1};
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ActionType forNumber(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Todo;
    L11:
        return HashTag;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) r27.a.a(ActionType.class, r1);
    }

    public static ActionType valueOf(int r0) {
        return forNumber(r0);
    }

    public ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
