package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SourceType extends Enum<SourceType> {
    private static final /* synthetic */ SourceType[] $VALUES = null;

    @SerializedName("2")
    public static final SourceType GLASSES_AUDIO = null;

    @SerializedName("1")
    public static final SourceType GLASSES_IMAGE = null;

    @SerializedName("3")
    public static final SourceType PHONE_AUDIO = null;
    private final int value;

    static {
        SourceType r0 = new SourceType("GLASSES_IMAGE", 0, 1);
        GLASSES_IMAGE = r0;
        SourceType r1 = new SourceType("GLASSES_AUDIO", 1, 2);
        GLASSES_AUDIO = r1;
        SourceType r4 = new SourceType("PHONE_AUDIO", 2, 3);
        PHONE_AUDIO = r4;
        $VALUES = new SourceType[]{r0, r1, r4};
    }

    private SourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SourceType findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return PHONE_AUDIO;
    L13:
        return GLASSES_AUDIO;
    L15:
        return GLASSES_IMAGE;
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
