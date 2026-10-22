package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConversationType extends Enum<ConversationType> {
    private static final /* synthetic */ ConversationType[] $VALUES = null;

    @SerializedName("2")
    public static final ConversationType Bot = null;

    @SerializedName("1")
    public static final ConversationType Coco = null;

    @SerializedName("3")
    public static final ConversationType CocoSub = null;
    private final int value;

    static {
        ConversationType r0 = new ConversationType("Coco", 0, 1);
        Coco = r0;
        ConversationType r1 = new ConversationType("Bot", 1, 2);
        Bot = r1;
        ConversationType r4 = new ConversationType("CocoSub", 2, 3);
        CocoSub = r4;
        $VALUES = new ConversationType[]{r0, r1, r4};
    }

    private ConversationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ConversationType findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return CocoSub;
    L13:
        return Bot;
    L15:
        return Coco;
    }

    public static ConversationType valueOf(String r2) {
        return (ConversationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConversationType.class, r2), ConversationType.class, "com.obric.memorydata.plugin");
    }

    public static ConversationType[] values() {
        return (ConversationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConversationType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
