package com.bytedance.android.live.core.cache;

import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface Cache<K, V> {
    void clear();

    void delete(K r1);

    V get(K r1);

    Observable<V> observe(K r1);

    void put(K r1, V r2);
}
