package org.ehcache.impl.internal.store.tiering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.ehcache.core.spi.store.b.a;
import org.ehcache.core.spi.store.b.b;
import org.ehcache.spi.resilience.StoreAccessException;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
public class CompoundCachingTier<K, V> implements a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f18095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<K, V> f18096b;
    private final org.ehcache.core.spi.store.b.c<K, V> c;

    static class ComputationException extends RuntimeException {
        private static final long serialVersionUID = 6832417052348277644L;

        public ComputationException(StoreAccessException r1) {
            super(r1);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        public StoreAccessException getStoreAccessException() {
            return (StoreAccessException) ZeusTransformUtils.preCheckCast(getCause(), StoreAccessException.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f18095a = d.a(CompoundCachingTier.class);
    }

    @Override // org.ehcache.core.spi.store.b
    public List<org.ehcache.core.b> a() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.f18096b.a());
        r0.addAll(this.c.a());
        return r0;
    }
}
