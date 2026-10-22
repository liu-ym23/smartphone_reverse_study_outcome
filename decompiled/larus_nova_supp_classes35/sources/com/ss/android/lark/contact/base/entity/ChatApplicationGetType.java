package com.ss.android.lark.contact.base.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ChatApplicationGetType extends Enum<ChatApplicationGetType> {
    public static final ChatApplicationGetType AFTER = null;
    public static final ChatApplicationGetType BEFORE = null;
    public static final /* synthetic */ ChatApplicationGetType[] a = null;
    private int value;

    static {
        ChatApplicationGetType r0 = new ChatApplicationGetType("BEFORE", 0, 1);
        BEFORE = r0;
        ChatApplicationGetType r1 = new ChatApplicationGetType("AFTER", 1, 2);
        AFTER = r1;
        a = new ChatApplicationGetType[]{r0, r1};
    }

    public static ChatApplicationGetType[] values() {
        return (ChatApplicationGetType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChatApplicationGetType forNumber(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return AFTER;
    L11:
        return BEFORE;
    }

    public static ChatApplicationGetType valueOf(String r1) {
        return (ChatApplicationGetType) r27.a.a(ChatApplicationGetType.class, r1);
    }

    public static ChatApplicationGetType valueOf(int r0) {
        return forNumber(r0);
    }

    public ChatApplicationGetType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
