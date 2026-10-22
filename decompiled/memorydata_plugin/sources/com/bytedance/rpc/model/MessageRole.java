package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MessageRole extends Enum<MessageRole> {
    private static final /* synthetic */ MessageRole[] $VALUES = null;

    @SerializedName("2")
    public static final MessageRole Assistant = null;

    @SerializedName("0")
    public static final MessageRole Unset = null;

    @SerializedName("1")
    public static final MessageRole User = null;
    private final int value;

    static {
        MessageRole r0 = new MessageRole("Unset", 0, 0);
        Unset = r0;
        MessageRole r1 = new MessageRole("User", 1, 1);
        User = r1;
        MessageRole r3 = new MessageRole("Assistant", 2, 2);
        Assistant = r3;
        $VALUES = new MessageRole[]{r0, r1, r3};
    }

    private MessageRole(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MessageRole findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Assistant;
    L12:
        return User;
    L14:
        return Unset;
    }

    public static MessageRole valueOf(String r2) {
        return (MessageRole) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageRole.class, r2), MessageRole.class, "com.obric.memorydata.plugin");
    }

    public static MessageRole[] values() {
        return (MessageRole[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageRole[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
