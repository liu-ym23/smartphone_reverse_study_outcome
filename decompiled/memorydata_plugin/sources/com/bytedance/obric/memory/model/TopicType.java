package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum TopicType extends Enum<TopicType> {
    private static final /* synthetic */ TopicType[] $VALUES = null;

    @SerializedName("2")
    public static final TopicType TopTopic = null;

    @SerializedName("1")
    public static final TopicType Topic = null;
    private final int value;

    static {
        TopicType r0 = new TopicType("Topic", 0, 1);
        Topic = r0;
        TopicType r1 = new TopicType("TopTopic", 1, 2);
        TopTopic = r1;
        $VALUES = new TopicType[]{r0, r1};
    }

    private TopicType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TopicType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return TopTopic;
    L11:
        return Topic;
    }

    public static TopicType valueOf(String r2) {
        return (TopicType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TopicType.class, r2), TopicType.class, "com.obric.memorydata.plugin");
    }

    public static TopicType[] values() {
        return (TopicType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TopicType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
