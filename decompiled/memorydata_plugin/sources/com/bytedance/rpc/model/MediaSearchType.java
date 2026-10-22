package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MediaSearchType extends Enum<MediaSearchType> {
    private static final /* synthetic */ MediaSearchType[] $VALUES = null;

    @SerializedName("1")
    public static final MediaSearchType DouYin = null;

    @SerializedName("0")
    public static final MediaSearchType Nothing = null;

    @SerializedName("2")
    public static final MediaSearchType TikTok = null;
    private final int value;

    static {
        MediaSearchType r0 = new MediaSearchType("Nothing", 0, 0);
        Nothing = r0;
        MediaSearchType r1 = new MediaSearchType("DouYin", 1, 1);
        DouYin = r1;
        MediaSearchType r3 = new MediaSearchType("TikTok", 2, 2);
        TikTok = r3;
        $VALUES = new MediaSearchType[]{r0, r1, r3};
    }

    private MediaSearchType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MediaSearchType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return TikTok;
    L12:
        return DouYin;
    L14:
        return Nothing;
    }

    public static MediaSearchType valueOf(String r2) {
        return (MediaSearchType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MediaSearchType.class, r2), MediaSearchType.class, "com.obric.memorydata.plugin");
    }

    public static MediaSearchType[] values() {
        return (MediaSearchType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MediaSearchType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
