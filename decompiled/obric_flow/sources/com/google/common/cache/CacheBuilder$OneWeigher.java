package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
final enum CacheBuilder$OneWeigher extends Enum<CacheBuilder$OneWeigher> implements z0 {
    public static final CacheBuilder$OneWeigher INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheBuilder$OneWeigher[] f8679a = null;

    static {
        CacheBuilder$OneWeigher r5 = new CacheBuilder$OneWeigher("INSTANCE", 0);
        INSTANCE = r5;
        f8679a = new CacheBuilder$OneWeigher[]{r5};
    }

    public static CacheBuilder$OneWeigher valueOf(String r5) {
        return (CacheBuilder$OneWeigher) Enum.valueOf(CacheBuilder$OneWeigher.class, r5);
    }

    public static CacheBuilder$OneWeigher[] values() {
        return (CacheBuilder$OneWeigher[]) f8679a.clone();
    }

    @Override // com.google.common.cache.z0
    public int weigh(Object r5, Object r10) {
        return 1;
    }
}
