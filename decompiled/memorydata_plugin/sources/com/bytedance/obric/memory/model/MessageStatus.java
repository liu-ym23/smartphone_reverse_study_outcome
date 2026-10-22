package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MessageStatus extends Enum<MessageStatus> {
    private static final /* synthetic */ MessageStatus[] $VALUES = null;

    @SerializedName("1")
    public static final MessageStatus Available = null;

    @SerializedName("4")
    public static final MessageStatus Broken = null;

    @SerializedName("2")
    public static final MessageStatus Deleted = null;

    @SerializedName("5")
    public static final MessageStatus Failed = null;

    @SerializedName("7")
    public static final MessageStatus Pending = null;

    @SerializedName("3")
    public static final MessageStatus Replaced = null;

    @SerializedName("6")
    public static final MessageStatus Streaming = null;
    private final int value;

    static {
        MessageStatus r0 = new MessageStatus("Available", 0, 1);
        Available = r0;
        MessageStatus r1 = new MessageStatus("Deleted", 1, 2);
        Deleted = r1;
        MessageStatus r4 = new MessageStatus("Replaced", 2, 3);
        Replaced = r4;
        MessageStatus r6 = new MessageStatus("Broken", 3, 4);
        Broken = r6;
        MessageStatus r8 = new MessageStatus("Failed", 4, 5);
        Failed = r8;
        MessageStatus r10 = new MessageStatus("Streaming", 5, 6);
        Streaming = r10;
        MessageStatus r12 = new MessageStatus("Pending", 6, 7);
        Pending = r12;
        $VALUES = new MessageStatus[]{r0, r1, r4, r6, r8, r10, r12};
    }

    private MessageStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MessageStatus findByValue(int r0) {
        switch(r0) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return Pending;
    L8:
        return Streaming;
    L10:
        return Failed;
    L12:
        return Broken;
    L14:
        return Replaced;
    L16:
        return Deleted;
    L18:
        return Available;
    }

    public static MessageStatus valueOf(String r2) {
        return (MessageStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageStatus.class, r2), MessageStatus.class, "com.obric.memorydata.plugin");
    }

    public static MessageStatus[] values() {
        return (MessageStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
