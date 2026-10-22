package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ConversationType extends Enum<ConversationType> {
    private static final /* synthetic */ ConversationType[] $VALUES = null;

    @SerializedName("2")
    public static final ConversationType Group = null;

    @SerializedName("1")
    public static final ConversationType Single = null;

    @SerializedName("0")
    public static final ConversationType Unknown = null;
    private final int value;

    static {
        ConversationType r0 = new ConversationType("Unknown", 0, 0);
        Unknown = r0;
        ConversationType r1 = new ConversationType("Single", 1, 1);
        Single = r1;
        ConversationType r3 = new ConversationType("Group", 2, 2);
        Group = r3;
        $VALUES = new ConversationType[]{r0, r1, r3};
    }

    private ConversationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ConversationType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Group;
    L12:
        return Single;
    L14:
        return Unknown;
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
