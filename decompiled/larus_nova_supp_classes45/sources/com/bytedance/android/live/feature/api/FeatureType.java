package com.bytedance.android.live.feature.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/feature/api/FeatureType;", "", "", "value", "I", "getValue", "()I", "STATIC", "DYNAMIC", "MONITOR", "DYNAMIC_MONITOR", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeatureType extends Enum<FeatureType> {
    public static final FeatureType DYNAMIC = null;
    public static final FeatureType DYNAMIC_MONITOR = null;
    public static final FeatureType MONITOR = null;
    public static final FeatureType STATIC = null;
    public static final /* synthetic */ FeatureType[] a = null;
    private final int value;

    static {
        FeatureType r1 = new FeatureType("STATIC", 0, 0);
        STATIC = r1;
        FeatureType r2 = new FeatureType("DYNAMIC", 1, 1);
        DYNAMIC = r2;
        FeatureType r3 = new FeatureType("MONITOR", 2, -1);
        MONITOR = r3;
        FeatureType r4 = new FeatureType("DYNAMIC_MONITOR", 3, 2);
        DYNAMIC_MONITOR = r4;
        a = new FeatureType[]{r1, r2, r3, r4};
    }

    public static FeatureType valueOf(String r1) {
        return (FeatureType) a.a(FeatureType.class, r1);
    }

    public static FeatureType[] values() {
        return (FeatureType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FeatureType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
