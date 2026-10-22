package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ResourceType extends Enum<ResourceType> {
    private static final /* synthetic */ ResourceType[] $VALUES = null;

    @SerializedName("1")
    public static final ResourceType File = null;

    @SerializedName("2")
    public static final ResourceType Image = null;
    private final int value;

    static {
        ResourceType r0 = new ResourceType("File", 0, 1);
        File = r0;
        ResourceType r1 = new ResourceType("Image", 1, 2);
        Image = r1;
        $VALUES = new ResourceType[]{r0, r1};
    }

    private ResourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ResourceType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Image;
    L11:
        return File;
    }

    public static ResourceType valueOf(String r2) {
        return (ResourceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResourceType.class, r2), ResourceType.class, "com.obric.memorydata.plugin");
    }

    public static ResourceType[] values() {
        return (ResourceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResourceType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
