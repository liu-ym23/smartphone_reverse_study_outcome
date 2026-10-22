package com.bytedance.android.live.core.tetris.widgets.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/CachePoolModel;", "", "BATCH_POOL_MODEL", "SINGLE_POOL_MODEL", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CachePoolModel extends Enum<CachePoolModel> {
    public static final CachePoolModel BATCH_POOL_MODEL = null;
    public static final CachePoolModel SINGLE_POOL_MODEL = null;
    public static final /* synthetic */ CachePoolModel[] a = null;

    static {
        CachePoolModel r1 = new CachePoolModel("BATCH_POOL_MODEL", 0);
        BATCH_POOL_MODEL = r1;
        CachePoolModel r2 = new CachePoolModel("SINGLE_POOL_MODEL", 1);
        SINGLE_POOL_MODEL = r2;
        a = new CachePoolModel[]{r1, r2};
    }

    public static CachePoolModel valueOf(String r1) {
        return (CachePoolModel) r27.a.a(CachePoolModel.class, r1);
    }

    public static CachePoolModel[] values() {
        return (CachePoolModel[]) a.clone();
    }

    public CachePoolModel(String r1, int r2) {
        super(r1, r2);
    }
}
