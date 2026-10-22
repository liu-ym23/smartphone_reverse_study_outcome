package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotConversationType extends Enum<BotConversationType> {
    private static final /* synthetic */ BotConversationType[] $VALUES = null;

    @SerializedName("2")
    public static final BotConversationType BOT = null;

    @SerializedName("0")
    public static final BotConversationType BOT_TYPE_UNKNOWN = null;

    @SerializedName("1")
    public static final BotConversationType COCO = null;

    @SerializedName("3")
    public static final BotConversationType COCO_SUB = null;
    private final int value;

    static {
        BotConversationType r0 = new BotConversationType("BOT_TYPE_UNKNOWN", 0, 0);
        BOT_TYPE_UNKNOWN = r0;
        BotConversationType r1 = new BotConversationType("COCO", 1, 1);
        COCO = r1;
        BotConversationType r3 = new BotConversationType("BOT", 2, 2);
        BOT = r3;
        BotConversationType r5 = new BotConversationType("COCO_SUB", 3, 3);
        COCO_SUB = r5;
        $VALUES = new BotConversationType[]{r0, r1, r3, r5};
    }

    private BotConversationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotConversationType findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return COCO_SUB;
    L14:
        return BOT;
    L16:
        return COCO;
    L18:
        return BOT_TYPE_UNKNOWN;
    }

    public static BotConversationType valueOf(String r2) {
        return (BotConversationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotConversationType.class, r2), BotConversationType.class, "com.obric.memorydata.plugin");
    }

    public static BotConversationType[] values() {
        return (BotConversationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotConversationType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
