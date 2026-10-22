package com.bytedance.android.live.core.cache;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a<K, V> {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.cache.a$a, reason: collision with other inner class name */
    public static class C0138a<V> {
        public final List<V> a;

        public C0138a(List r1) {
            this.a = r1;
        }
    }

    int a(K r1, V r2);

    void b(K r1, int r2, V r3);

    V c(K r1, j<V> r2);

    void clear();

    List<V> d(K r1, List<V> r2);

    void delete(K r1, int r2);

    void delete(K r1, V r2);

    void e(K r1);

    V get(K r1, int r2);

    List<V> get(K r1);

    List<V> insert(K r1, int r2, V r3);

    List<V> insert(K r1, int r2, List<V> r3);

    int size(K r1);
}
