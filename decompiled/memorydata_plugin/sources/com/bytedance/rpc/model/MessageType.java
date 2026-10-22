package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MessageType extends Enum<MessageType> {
    private static final /* synthetic */ MessageType[] $VALUES = null;

    @SerializedName("2")
    public static final MessageType Answer = null;

    @SerializedName("1")
    public static final MessageType Query = null;

    @SerializedName("11")
    public static final MessageType State = null;

    @SerializedName("4")
    public static final MessageType ToolCall = null;

    @SerializedName("5")
    public static final MessageType ToolResult = null;

    @SerializedName("0")
    public static final MessageType Unset = null;
    private final int value;

    static {
        MessageType r0 = new MessageType("Unset", 0, 0);
        Unset = r0;
        MessageType r1 = new MessageType("Query", 1, 1);
        Query = r1;
        MessageType r3 = new MessageType("Answer", 2, 2);
        Answer = r3;
        MessageType r5 = new MessageType("ToolCall", 3, 4);
        ToolCall = r5;
        MessageType r7 = new MessageType("ToolResult", 4, 5);
        ToolResult = r7;
        MessageType r10 = new MessageType("State", 5, 11);
        State = r10;
        $VALUES = new MessageType[]{r0, r1, r3, r5, r7, r10};
    }

    private MessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MessageType findByValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 4) goto L20;
        if (r1 == 5) goto L18;
        if (r1 == 11) goto L16;
        return null;
    L16:
        return State;
    L18:
        return ToolResult;
    L20:
        return ToolCall;
    L22:
        return Answer;
    L24:
        return Query;
    L26:
        return Unset;
    }

    public static MessageType valueOf(String r2) {
        return (MessageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageType.class, r2), MessageType.class, "com.obric.memorydata.plugin");
    }

    public static MessageType[] values() {
        return (MessageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
