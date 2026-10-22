package com.google.common.cache;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractMap;

/* JADX INFO: loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K r1, V r2, RemovalCause r3) {
        super(r1, r2);
        this.cause = (RemovalCause) ZeusTransformUtils.preCheckCast(n.a(r3), RemovalCause.class, "com.obric.memorydata.plugin");
    }

    public static <K, V> RemovalNotification<K, V> create(K r1, V r2, RemovalCause r3) {
        return new RemovalNotification(r1, r2, r3);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
