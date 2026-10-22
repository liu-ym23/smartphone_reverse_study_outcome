package com.bytedance.rpc.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MessageScene extends Enum<MessageScene> {
    private static final /* synthetic */ MessageScene[] $VALUES = null;
    private final int value;

    static {
        $VALUES = new MessageScene[0];
    }

    private MessageScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MessageScene findByValue(int r0) {
        return null;
    }

    public static MessageScene valueOf(String r2) {
        return (MessageScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageScene.class, r2), MessageScene.class, "com.obric.memorydata.plugin");
    }

    public static MessageScene[] values() {
        return (MessageScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
