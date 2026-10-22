package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/CacheLevel;", "", "ACTIVE", "REUSABLE", "PERSISTENT", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheLevel extends Enum<CacheLevel> {
    public static final CacheLevel ACTIVE = null;
    public static final CacheLevel PERSISTENT = null;
    public static final CacheLevel REUSABLE = null;
    public static final /* synthetic */ CacheLevel[] a = null;

    static {
        CacheLevel r1 = new CacheLevel("ACTIVE", 0);
        ACTIVE = r1;
        CacheLevel r2 = new CacheLevel("REUSABLE", 1);
        REUSABLE = r2;
        CacheLevel r3 = new CacheLevel("PERSISTENT", 2);
        PERSISTENT = r3;
        a = new CacheLevel[]{r1, r2, r3};
    }

    public static CacheLevel valueOf(String r1) {
        return (CacheLevel) r27.a.a(CacheLevel.class, r1);
    }

    public static CacheLevel[] values() {
        return (CacheLevel[]) a.clone();
    }

    public CacheLevel(String r1, int r2) {
        super(r1, r2);
    }
}
