package com.bytedance.android.live.revenue.platform.container.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/api/CenterServiceType;", "", "PRE_CENTER_SERVICE", "CENTER_SERVICE", "BUSINESS_SERVICE", "ALL_SERVICE", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CenterServiceType extends Enum<CenterServiceType> {
    public static final CenterServiceType ALL_SERVICE = null;
    public static final CenterServiceType BUSINESS_SERVICE = null;
    public static final CenterServiceType CENTER_SERVICE = null;
    public static final CenterServiceType PRE_CENTER_SERVICE = null;
    public static final /* synthetic */ CenterServiceType[] a = null;

    static {
        CenterServiceType r1 = new CenterServiceType("PRE_CENTER_SERVICE", 0);
        PRE_CENTER_SERVICE = r1;
        CenterServiceType r2 = new CenterServiceType("CENTER_SERVICE", 1);
        CENTER_SERVICE = r2;
        CenterServiceType r3 = new CenterServiceType("BUSINESS_SERVICE", 2);
        BUSINESS_SERVICE = r3;
        CenterServiceType r4 = new CenterServiceType("ALL_SERVICE", 3);
        ALL_SERVICE = r4;
        a = new CenterServiceType[]{r1, r2, r3, r4};
    }

    public static CenterServiceType valueOf(String r1) {
        return (CenterServiceType) a.a(CenterServiceType.class, r1);
    }

    public static CenterServiceType[] values() {
        return (CenterServiceType[]) a.clone();
    }

    public CenterServiceType(String r1, int r2) {
        super(r1, r2);
    }
}
