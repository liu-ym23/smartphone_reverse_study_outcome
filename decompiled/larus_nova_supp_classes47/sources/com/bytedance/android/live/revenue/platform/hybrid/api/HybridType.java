package com.bytedance.android.live.revenue.platform.hybrid.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/api/HybridType;", "", "H5", "LYNX", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum HybridType extends Enum<HybridType> {
    public static final HybridType H5 = null;
    public static final HybridType LYNX = null;
    public static final /* synthetic */ HybridType[] a = null;

    static {
        HybridType r1 = new HybridType("H5", 0);
        H5 = r1;
        HybridType r2 = new HybridType("LYNX", 1);
        LYNX = r2;
        a = new HybridType[]{r1, r2};
    }

    public static HybridType valueOf(String r1) {
        return (HybridType) a.a(HybridType.class, r1);
    }

    public static HybridType[] values() {
        return (HybridType[]) a.clone();
    }

    public HybridType(String r1, int r2) {
        super(r1, r2);
    }
}
