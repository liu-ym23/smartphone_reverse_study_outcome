package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SourceType extends Enum<SourceType> {
    private static final /* synthetic */ SourceType[] $VALUES = null;

    @SerializedName("4")
    public static final SourceType API = null;

    @SerializedName("5")
    public static final SourceType Aweme = null;

    @SerializedName("1")
    public static final SourceType BotStudioSubmit = null;

    @SerializedName("2")
    public static final SourceType BotStudioWorkflowTest = null;

    @SerializedName("3")
    public static final SourceType Flow = null;
    private final int value;

    static {
        SourceType r0 = new SourceType("BotStudioSubmit", 0, 1);
        BotStudioSubmit = r0;
        SourceType r1 = new SourceType("BotStudioWorkflowTest", 1, 2);
        BotStudioWorkflowTest = r1;
        SourceType r4 = new SourceType("Flow", 2, 3);
        Flow = r4;
        SourceType r6 = new SourceType("API", 3, 4);
        API = r6;
        SourceType r8 = new SourceType("Aweme", 4, 5);
        Aweme = r8;
        $VALUES = new SourceType[]{r0, r1, r4, r6, r8};
    }

    private SourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SourceType findByValue(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return null;
    L15:
        return Aweme;
    L17:
        return API;
    L19:
        return Flow;
    L21:
        return BotStudioWorkflowTest;
    L23:
        return BotStudioSubmit;
    }

    public static SourceType valueOf(String r2) {
        return (SourceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SourceType.class, r2), SourceType.class, "com.obric.memorydata.plugin");
    }

    public static SourceType[] values() {
        return (SourceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SourceType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
