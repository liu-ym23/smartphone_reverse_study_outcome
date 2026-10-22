package com.obric.memory.datacollect;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum UrlType extends Enum<UrlType> {
    private static final /* synthetic */ UrlType[] $VALUES = null;

    @SerializedName("0")
    public static final UrlType Image = null;
    private final int value;

    static {
        UrlType r0 = new UrlType("Image", 0, 0);
        Image = r0;
        $VALUES = new UrlType[]{r0};
    }

    private UrlType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static UrlType findByValue(int r0) {
        if (r0 == 0) goto L6;
        return null;
    L6:
        return Image;
    }

    public static UrlType valueOf(String r2) {
        return (UrlType) ZeusTransformUtils.preCheckCast(Enum.valueOf(UrlType.class, r2), UrlType.class, "com.obric.memorydata.plugin");
    }

    public static UrlType[] values() {
        return (UrlType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UrlType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
