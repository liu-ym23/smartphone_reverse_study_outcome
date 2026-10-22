package com.facebook.cache.common;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleCacheKey implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7579a;

    public SimpleCacheKey(String r5) {
        r5.getClass();
        this.f7579a = r5;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return this.f7579a;
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SimpleCacheKey) == true) goto L8;
        return false;
    L8:
        return this.f7579a.equals(((SimpleCacheKey) r5).f7579a);
    }

    public final int hashCode() {
        return this.f7579a.hashCode();
    }

    public final String toString() {
        return this.f7579a;
    }
}
