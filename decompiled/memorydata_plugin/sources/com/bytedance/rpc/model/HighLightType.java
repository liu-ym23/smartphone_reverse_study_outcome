package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum HighLightType extends Enum<HighLightType> {
    private static final /* synthetic */ HighLightType[] $VALUES = null;

    @SerializedName("1")
    public static final HighLightType GoogleNLP = null;

    @SerializedName("0")
    public static final HighLightType None = null;

    @SerializedName("2")
    public static final HighLightType ToutiaoWiki = null;
    private final int value;

    static {
        HighLightType r0 = new HighLightType("None", 0, 0);
        None = r0;
        HighLightType r1 = new HighLightType("GoogleNLP", 1, 1);
        GoogleNLP = r1;
        HighLightType r3 = new HighLightType("ToutiaoWiki", 2, 2);
        ToutiaoWiki = r3;
        $VALUES = new HighLightType[]{r0, r1, r3};
    }

    private HighLightType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static HighLightType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return ToutiaoWiki;
    L12:
        return GoogleNLP;
    L14:
        return None;
    }

    public static HighLightType valueOf(String r2) {
        return (HighLightType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HighLightType.class, r2), HighLightType.class, "com.obric.memorydata.plugin");
    }

    public static HighLightType[] values() {
        return (HighLightType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HighLightType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
