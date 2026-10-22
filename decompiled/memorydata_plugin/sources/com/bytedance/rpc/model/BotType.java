package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotType extends Enum<BotType> {
    private static final /* synthetic */ BotType[] $VALUES = null;

    @SerializedName("1")
    public static final BotType Coco = null;

    @SerializedName("2")
    public static final BotType GuanFang = null;

    @SerializedName("0")
    public static final BotType User = null;
    private final int value;

    static {
        BotType r0 = new BotType("User", 0, 0);
        User = r0;
        BotType r1 = new BotType("Coco", 1, 1);
        Coco = r1;
        BotType r3 = new BotType("GuanFang", 2, 2);
        GuanFang = r3;
        $VALUES = new BotType[]{r0, r1, r3};
    }

    private BotType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return GuanFang;
    L12:
        return Coco;
    L14:
        return User;
    }

    public static BotType valueOf(String r2) {
        return (BotType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotType.class, r2), BotType.class, "com.obric.memorydata.plugin");
    }

    public static BotType[] values() {
        return (BotType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
