package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum MessageFetchScene extends Enum<MessageFetchScene> {
    public static final MessageFetchScene FIRST_SCREEN = null;
    public static final MessageFetchScene NEXT_PAGE = null;
    public static final MessageFetchScene PREVIOUS_PAGE = null;
    public static final MessageFetchScene SPECIFIED_POSITION = null;
    public static final /* synthetic */ MessageFetchScene[] a = null;
    private String desc;
    private final int value;

    static {
        MessageFetchScene r0 = new MessageFetchScene("FIRST_SCREEN", 0, 1, "首屏");
        FIRST_SCREEN = r0;
        MessageFetchScene r1 = new MessageFetchScene("SPECIFIED_POSITION", 1, 2, "指定位置");
        SPECIFIED_POSITION = r1;
        MessageFetchScene r2 = new MessageFetchScene("PREVIOUS_PAGE", 2, 3, "上一页");
        PREVIOUS_PAGE = r2;
        MessageFetchScene r5 = new MessageFetchScene("NEXT_PAGE", 3, 4, "下一页");
        NEXT_PAGE = r5;
        a = new MessageFetchScene[]{r0, r1, r2, r5};
    }

    public static MessageFetchScene[] values() {
        return (MessageFetchScene[]) a.clone();
    }

    public String getDesc() {
        return this.desc;
    }

    public int getNumber() {
        return this.value;
    }

    public static MessageFetchScene fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return FIRST_SCREEN;
    L13:
        return NEXT_PAGE;
    L15:
        return PREVIOUS_PAGE;
    L17:
        return SPECIFIED_POSITION;
    L19:
        return FIRST_SCREEN;
    }

    public static MessageFetchScene valueOf(String r1) {
        return (MessageFetchScene) r27.a.a(MessageFetchScene.class, r1);
    }

    public MessageFetchScene(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.desc = r4;
    }
}
