package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotStatus extends Enum<BotStatus> {
    private static final /* synthetic */ BotStatus[] $VALUES = null;

    @SerializedName("1")
    public static final BotStatus Deleted = null;

    @SerializedName("0")
    public static final BotStatus Using = null;
    private final int value;

    static {
        BotStatus r0 = new BotStatus("Using", 0, 0);
        Using = r0;
        BotStatus r1 = new BotStatus("Deleted", 1, 1);
        Deleted = r1;
        $VALUES = new BotStatus[]{r0, r1};
    }

    private BotStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotStatus findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Deleted;
    L10:
        return Using;
    }

    public static BotStatus valueOf(String r2) {
        return (BotStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotStatus.class, r2), BotStatus.class, "com.obric.memorydata.plugin");
    }

    public static BotStatus[] values() {
        return (BotStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
