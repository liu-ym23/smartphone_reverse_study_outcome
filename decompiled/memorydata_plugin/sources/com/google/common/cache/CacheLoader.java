package com.google.common.cache;

import com.google.common.base.n;
import com.google.common.base.r;
import com.google.common.util.concurrent.l;
import com.google.common.util.concurrent.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {

    /* JADX INFO: renamed from: com.google.common.cache.CacheLoader$1, reason: invalid class name */
    class AnonymousClass1 extends CacheLoader<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CacheLoader f4312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f4313b;

        AnonymousClass1(CacheLoader r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.f4312a = r3;
            this.f4313b = r5;
        }

        private static /* synthetic */ Object a(CacheLoader r0, Object r1, Object r2) {
            return r0.reload(r1, r2).get();
        }

        public static /* synthetic */ Object lambda$DDF9FFWnokTLPw01vTfXyUhCJc8(CacheLoader r0, Object r1, Object r2) {
            return a(r0, r1, r2);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K r1) {
            return (V) this.f4312a.load(r1);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> r3) {
            Iterable<? extends K> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            return this.f4312a.loadAll(r4);
        }

        @Override // com.google.common.cache.CacheLoader
        public l<V> reload(final K r3, final V r4) {
            final CacheLoader r0 = this.f4312a;
            m r5 = m.a(new $$Lambda$CacheLoader$1$DDF9FFWnokTLPw01vTfXyUhCJc8(r0, r3, r4));
            this.f4313b.execute(r5);
            return r5;
        }
    }

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.g<K, V> computingFunction;

        public FunctionToCacheLoader(com.google.common.base.g<K, V> r3) {
            this.computingFunction = (com.google.common.base.g) ZeusTransformUtils.preCheckCast(n.a((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin")), com.google.common.base.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K r1) {
            return this.computingFunction.apply((K) n.a(r1));
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String r1) {
            super(r1);
        }
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final r<V> computingSupplier;

        public SupplierToCacheLoader(r<V> r3) {
            this.computingSupplier = (r) ZeusTransformUtils.preCheckCast(n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object r1) {
            n.a(r1);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    public CacheLoader() {
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> r2, Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        n.a(r2);
        n.a(r4);
        return new AnonymousClass1(r2, r4);
    }

    public static <K, V> CacheLoader<K, V> from(com.google.common.base.g<K, V> r2) {
        return new FunctionToCacheLoader((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.g.class, "com.obric.memorydata.plugin"));
    }

    public static <V> CacheLoader<Object, V> from(r<V> r2) {
        return new SupplierToCacheLoader((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"));
    }

    public abstract V load(K r1);

    public Map<K, V> loadAll(Iterable<? extends K> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedLoadingOperationException();
    }

    public l<V> reload(K r1, V r2) {
        n.a(r1);
        n.a(r2);
        return com.google.common.util.concurrent.h.a(load(r1));
    }
}
