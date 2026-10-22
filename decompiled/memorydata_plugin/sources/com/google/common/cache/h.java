package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
public interface h<K, V> {
    void onRemoval(RemovalNotification<K, V> r1);
}
