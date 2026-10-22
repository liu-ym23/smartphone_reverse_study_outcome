package com.bytedance.android.ec.adapter.api.strategy;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/strategy/FeatureType;", "", "STATIC", "DYNAMIC", "MONITOR", "DYNAMIC_MONITOR", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeatureType extends Enum<FeatureType> {
    public static final FeatureType DYNAMIC = null;
    public static final FeatureType DYNAMIC_MONITOR = null;
    public static final FeatureType MONITOR = null;
    public static final FeatureType STATIC = null;
    public static final /* synthetic */ FeatureType[] a = null;

    static {
        FeatureType r1 = new FeatureType("STATIC", 0);
        STATIC = r1;
        FeatureType r10 = new FeatureType("DYNAMIC", 1);
        DYNAMIC = r10;
        FeatureType r11 = new FeatureType("MONITOR", 2);
        MONITOR = r11;
        FeatureType r12 = new FeatureType("DYNAMIC_MONITOR", 3);
        DYNAMIC_MONITOR = r12;
        a = new FeatureType[]{r1, r10, r11, r12};
    }

    public static FeatureType valueOf(String r1) {
        return (FeatureType) a.a(FeatureType.class, r1);
    }

    public static FeatureType[] values() {
        return (FeatureType[]) a.clone();
    }

    public FeatureType(String r1, int r10) {
        super(r1, r10);
    }
}
