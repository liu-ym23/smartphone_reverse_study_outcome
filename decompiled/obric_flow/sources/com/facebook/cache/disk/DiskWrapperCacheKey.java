package com.facebook.cache.disk;

import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DiskWrapperCacheKey implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleCacheKey f7633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7634b;

    public DiskWrapperCacheKey(SimpleCacheKey r5, Map r10) {
        this.f7633a = r5;
        this.f7634b = r10;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return this.f7633a.f7579a;
    }

    public final boolean equals(Object r5) {
        return this.f7633a.equals(r5);
    }

    public final int hashCode() {
        return this.f7633a.f7579a.hashCode();
    }

    public final String toString() {
        return this.f7633a.f7579a;
    }
}
