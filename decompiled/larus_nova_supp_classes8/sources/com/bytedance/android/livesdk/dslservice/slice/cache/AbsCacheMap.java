package com.bytedance.android.livesdk.dslservice.slice.cache;

import android.util.LruCache;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class AbsCacheMap<Key, Value> {
    public final Lazy a;

    public final LruCache<Key, Value> b() {
        return (LruCache) this.a.getValue();
    }

    public AbsCacheMap() {
        this.a = LazyKt.lazy(new AbsCacheMap$cacheMap$2(this));
    }

    public final Value a(Key r2) {
        return b().get(r2);
    }
}
