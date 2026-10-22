package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
final enum CacheBuilder$NullListener extends Enum<CacheBuilder$NullListener> implements w0 {
    public static final CacheBuilder$NullListener INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheBuilder$NullListener[] f8678a = null;

    static {
        CacheBuilder$NullListener r5 = new CacheBuilder$NullListener("INSTANCE", 0);
        INSTANCE = r5;
        f8678a = new CacheBuilder$NullListener[]{r5};
    }

    public static CacheBuilder$NullListener valueOf(String r5) {
        return (CacheBuilder$NullListener) Enum.valueOf(CacheBuilder$NullListener.class, r5);
    }

    public static CacheBuilder$NullListener[] values() {
        return (CacheBuilder$NullListener[]) f8678a.clone();
    }

    @Override // com.google.common.cache.w0
    public void onRemoval(RemovalNotification<Object, Object> r5) {
    }
}
