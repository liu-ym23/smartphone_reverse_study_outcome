package com.bytedance.android.live.anchormodelink.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/DynamicCenterGetType;", "", "NONE", "latestSEI", "liveLink", "common_get_data", "linkmic", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicCenterGetType extends Enum<DynamicCenterGetType> {
    public static final DynamicCenterGetType NONE = null;
    public static final /* synthetic */ DynamicCenterGetType[] a = null;
    public static final DynamicCenterGetType common_get_data = null;
    public static final DynamicCenterGetType latestSEI = null;
    public static final DynamicCenterGetType linkmic = null;
    public static final DynamicCenterGetType liveLink = null;

    static {
        DynamicCenterGetType r1 = new DynamicCenterGetType("NONE", 0);
        NONE = r1;
        DynamicCenterGetType r2 = new DynamicCenterGetType("latestSEI", 1);
        latestSEI = r2;
        DynamicCenterGetType r3 = new DynamicCenterGetType("liveLink", 2);
        liveLink = r3;
        DynamicCenterGetType r4 = new DynamicCenterGetType("common_get_data", 3);
        common_get_data = r4;
        DynamicCenterGetType r5 = new DynamicCenterGetType("linkmic", 4);
        linkmic = r5;
        a = new DynamicCenterGetType[]{r1, r2, r3, r4, r5};
    }

    public static DynamicCenterGetType valueOf(String r1) {
        return (DynamicCenterGetType) a.a(DynamicCenterGetType.class, r1);
    }

    public static DynamicCenterGetType[] values() {
        return (DynamicCenterGetType[]) a.clone();
    }

    public DynamicCenterGetType(String r1, int r2) {
        super(r1, r2);
    }
}
