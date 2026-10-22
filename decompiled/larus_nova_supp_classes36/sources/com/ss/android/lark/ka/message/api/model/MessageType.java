package com.ss.android.lark.ka.message.api.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum MessageType extends Enum<MessageType> {
    private static final /* synthetic */ MessageType[] $VALUES = null;
    public static final MessageType FILE = null;
    public static final MessageType IMAGE = null;
    public static final MessageType MEDIA = null;

    static {
        MessageType r0 = new MessageType("FILE", 0);
        FILE = r0;
        MessageType r1 = new MessageType("IMAGE", 1);
        IMAGE = r1;
        MessageType r3 = new MessageType("MEDIA", 2);
        MEDIA = r3;
        $VALUES = new MessageType[]{r0, r1, r3};
    }

    public static MessageType[] values() {
        return (MessageType[]) $VALUES.clone();
    }

    public static MessageType valueOf(String r1) {
        return (MessageType) a.a(MessageType.class, r1);
    }

    private MessageType(String r1, int r2) {
        super(r1, r2);
    }
}
