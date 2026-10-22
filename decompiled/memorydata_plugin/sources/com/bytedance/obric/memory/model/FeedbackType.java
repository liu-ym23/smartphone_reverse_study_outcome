package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum FeedbackType extends Enum<FeedbackType> {
    private static final /* synthetic */ FeedbackType[] $VALUES = null;

    @SerializedName("2")
    public static final FeedbackType Dislike = null;

    @SerializedName("1")
    public static final FeedbackType Like = null;
    private final int value;

    static {
        FeedbackType r0 = new FeedbackType("Like", 0, 1);
        Like = r0;
        FeedbackType r1 = new FeedbackType("Dislike", 1, 2);
        Dislike = r1;
        $VALUES = new FeedbackType[]{r0, r1};
    }

    private FeedbackType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static FeedbackType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Dislike;
    L11:
        return Like;
    }

    public static FeedbackType valueOf(String r2) {
        return (FeedbackType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FeedbackType.class, r2), FeedbackType.class, "com.obric.memorydata.plugin");
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FeedbackType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
