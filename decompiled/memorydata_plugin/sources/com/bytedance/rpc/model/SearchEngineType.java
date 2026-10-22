package com.bytedance.rpc.model;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SearchEngineType extends Enum<SearchEngineType> {
    private static final /* synthetic */ SearchEngineType[] $VALUES = null;

    @SerializedName("2")
    public static final SearchEngineType DouYin = null;

    @SerializedName("1")
    public static final SearchEngineType Google = null;

    @SerializedName("0")
    public static final SearchEngineType Nothing = null;

    @SerializedName("4")
    public static final SearchEngineType TouTiao = null;
    private final int value;

    static {
        SearchEngineType r0 = new SearchEngineType("Nothing", 0, 0);
        Nothing = r0;
        SearchEngineType r1 = new SearchEngineType(LocationInfoConst.GOOGLE, 1, 1);
        Google = r1;
        SearchEngineType r3 = new SearchEngineType("DouYin", 2, 2);
        DouYin = r3;
        SearchEngineType r5 = new SearchEngineType("TouTiao", 3, 4);
        TouTiao = r5;
        $VALUES = new SearchEngineType[]{r0, r1, r3, r5};
    }

    private SearchEngineType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SearchEngineType findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 4) goto L12;
        return null;
    L12:
        return TouTiao;
    L14:
        return DouYin;
    L16:
        return Google;
    L18:
        return Nothing;
    }

    public static SearchEngineType valueOf(String r2) {
        return (SearchEngineType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchEngineType.class, r2), SearchEngineType.class, "com.obric.memorydata.plugin");
    }

    public static SearchEngineType[] values() {
        return (SearchEngineType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchEngineType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
