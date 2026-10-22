package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotExeType extends Enum<BotExeType> {
    private static final /* synthetic */ BotExeType[] $VALUES = null;

    @SerializedName("1")
    public static final BotExeType Create = null;

    @SerializedName("3")
    public static final BotExeType Delete = null;

    @SerializedName("2")
    public static final BotExeType Update = null;
    private final int value;

    static {
        BotExeType r0 = new BotExeType("Create", 0, 1);
        Create = r0;
        BotExeType r1 = new BotExeType("Update", 1, 2);
        Update = r1;
        BotExeType r4 = new BotExeType("Delete", 2, 3);
        Delete = r4;
        $VALUES = new BotExeType[]{r0, r1, r4};
    }

    private BotExeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotExeType findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return Delete;
    L13:
        return Update;
    L15:
        return Create;
    }

    public static BotExeType valueOf(String r2) {
        return (BotExeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotExeType.class, r2), BotExeType.class, "com.obric.memorydata.plugin");
    }

    public static BotExeType[] values() {
        return (BotExeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotExeType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
