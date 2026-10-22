package org.ehcache;

import java.io.Closeable;

/* JADX INFO: loaded from: classes7.dex */
public interface d<K, V> extends Closeable, a<K, V> {
    void b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
