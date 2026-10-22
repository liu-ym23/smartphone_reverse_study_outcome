package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum BotSpecies extends Enum<BotSpecies> {
    private static final /* synthetic */ BotSpecies[] $VALUES = null;

    @SerializedName("0")
    public static final BotSpecies Default = null;

    @SerializedName("1")
    public static final BotSpecies Function = null;
    private final int value;

    static {
        BotSpecies r0 = new BotSpecies("Default", 0, 0);
        Default = r0;
        BotSpecies r1 = new BotSpecies("Function", 1, 1);
        Function = r1;
        $VALUES = new BotSpecies[]{r0, r1};
    }

    private BotSpecies(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static BotSpecies findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Function;
    L10:
        return Default;
    }

    public static BotSpecies valueOf(String r2) {
        return (BotSpecies) ZeusTransformUtils.preCheckCast(Enum.valueOf(BotSpecies.class, r2), BotSpecies.class, "com.obric.memorydata.plugin");
    }

    public static BotSpecies[] values() {
        return (BotSpecies[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BotSpecies[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
