package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConversationBlacklistScene extends Enum<ConversationBlacklistScene> {
    private static final /* synthetic */ ConversationBlacklistScene[] $VALUES = null;

    @SerializedName("1")
    public static final ConversationBlacklistScene BotRecommendChoiceness = null;

    @SerializedName("2")
    public static final ConversationBlacklistScene BotRecommendDiscovery = null;
    private final int value;

    static {
        ConversationBlacklistScene r0 = new ConversationBlacklistScene("BotRecommendChoiceness", 0, 1);
        BotRecommendChoiceness = r0;
        ConversationBlacklistScene r1 = new ConversationBlacklistScene("BotRecommendDiscovery", 1, 2);
        BotRecommendDiscovery = r1;
        $VALUES = new ConversationBlacklistScene[]{r0, r1};
    }

    private ConversationBlacklistScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ConversationBlacklistScene findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return BotRecommendDiscovery;
    L11:
        return BotRecommendChoiceness;
    }

    public static ConversationBlacklistScene valueOf(String r2) {
        return (ConversationBlacklistScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConversationBlacklistScene.class, r2), ConversationBlacklistScene.class, "com.obric.memorydata.plugin");
    }

    public static ConversationBlacklistScene[] values() {
        return (ConversationBlacklistScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConversationBlacklistScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
