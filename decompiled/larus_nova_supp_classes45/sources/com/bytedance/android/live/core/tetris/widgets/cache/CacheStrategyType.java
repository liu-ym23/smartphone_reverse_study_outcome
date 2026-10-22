package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/CacheStrategyType;", "", "NORMAL", "LOW_END_DEVICE", "NO_CACHE", "NONE", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheStrategyType extends Enum<CacheStrategyType> {
    public static final CacheStrategyType LOW_END_DEVICE = null;
    public static final CacheStrategyType NONE = null;
    public static final CacheStrategyType NORMAL = null;
    public static final CacheStrategyType NO_CACHE = null;
    public static final /* synthetic */ CacheStrategyType[] a = null;

    static {
        CacheStrategyType r1 = new CacheStrategyType("NORMAL", 0);
        NORMAL = r1;
        CacheStrategyType r2 = new CacheStrategyType("LOW_END_DEVICE", 1);
        LOW_END_DEVICE = r2;
        CacheStrategyType r3 = new CacheStrategyType("NO_CACHE", 2);
        NO_CACHE = r3;
        CacheStrategyType r4 = new CacheStrategyType("NONE", 3);
        NONE = r4;
        a = new CacheStrategyType[]{r1, r2, r3, r4};
    }

    public static CacheStrategyType valueOf(String r1) {
        return (CacheStrategyType) r27.a.a(CacheStrategyType.class, r1);
    }

    public static CacheStrategyType[] values() {
        return (CacheStrategyType[]) a.clone();
    }

    public CacheStrategyType(String r1, int r2) {
        super(r1, r2);
    }
}
