package com.google.common.cache;

import java.util.AbstractMap;

/* JADX INFO: loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public RemovalNotification(Object r5, Object r10, RemovalCause r11) {
        super(r5, r10);
        r11.getClass();
        this.cause = r11;
    }

    public static <K, V> RemovalNotification<K, V> create(K r5, V r10, RemovalCause r11) {
        return new RemovalNotification(r5, r10, r11);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
