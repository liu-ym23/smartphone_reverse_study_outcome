package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f4314a = null;
    static final r<Object, Object> u = null;
    static final Queue<?> v = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f4315b;
    final int c;
    final Segment<K, V>[] d;
    final int e;
    final Equivalence<Object> f;
    final Equivalence<Object> g;
    final Strength h;
    final Strength i;
    final long j;
    final com.google.common.cache.i<K, V> k;
    final long l;
    final long m;
    final long n;
    final Queue<RemovalNotification<K, V>> o;
    final com.google.common.cache.h<K, V> p;
    final com.google.common.base.t q;
    final EntryFactory r;
    final com.google.common.cache.a.b s;
    final CacheLoader<? super K, V> t;
    Set<K> w;
    Collection<V> x;
    Set<Map.Entry<K, V>> y;

    static abstract enum EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES = null;
        static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG = null;
        public static final EntryFactory STRONG_ACCESS = null;
        public static final EntryFactory STRONG_ACCESS_WRITE = null;
        public static final EntryFactory STRONG_WRITE = null;
        public static final EntryFactory WEAK = null;
        public static final EntryFactory WEAK_ACCESS = null;
        public static final EntryFactory WEAK_ACCESS_WRITE = null;
        static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE = null;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = null;

        private static /* synthetic */ EntryFactory[] $values() {
            return new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            EntryFactory r0 = new AnonymousClass1(r1, r2);
            STRONG = r0;
            final String r3 = "STRONG_ACCESS";
            final int r4 = 1;
            EntryFactory r5 = new AnonymousClass2(r3, r4);
            STRONG_ACCESS = r5;
            final String r6 = "STRONG_WRITE";
            final int r7 = 2;
            EntryFactory r8 = new AnonymousClass3(r6, r7);
            STRONG_WRITE = r8;
            final String r9 = "STRONG_ACCESS_WRITE";
            final int r10 = 3;
            EntryFactory r11 = new AnonymousClass4(r9, r10);
            STRONG_ACCESS_WRITE = r11;
            final String r12 = "WEAK";
            final int r13 = 4;
            EntryFactory r14 = new AnonymousClass5(r12, r13);
            WEAK = r14;
            final String r15 = "WEAK_ACCESS";
            final int r16 = 5;
            EntryFactory r17 = new AnonymousClass6(r15, r16);
            WEAK_ACCESS = r17;
            final String r18 = "WEAK_WRITE";
            final int r19 = 6;
            EntryFactory r110 = new AnonymousClass7(r18, r19);
            WEAK_WRITE = r110;
            final String r111 = "WEAK_ACCESS_WRITE";
            final int r112 = 7;
            EntryFactory r113 = new AnonymousClass8(r111, r112);
            WEAK_ACCESS_WRITE = r113;
            $VALUES = $values();
            factories = new EntryFactory[]{r0, r5, r8, r11, r14, r17, r110, r113};
        }

        private EntryFactory(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ EntryFactory(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory getFactory(Strength r2, boolean r3, boolean r4) {
            int r1 = 0;
            if (r2 != Strength.WEAK) goto L5;
            char r5 = 4;
        L6:
            boolean r6 = r5 | (r3 ? 1 : 0);
            if (r4 == false) goto L10;
            r1 = 2;
        L10:
            return factories[(r6 ? 1 : 0) | r1];
        L5:
            r5 = 0;
            goto L6
        }

        public static EntryFactory valueOf(String r2) {
            return (EntryFactory) ZeusTransformUtils.preCheckCast(Enum.valueOf(EntryFactory.class, r2), EntryFactory.class, "com.obric.memorydata.plugin");
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EntryFactory[].class, "com.obric.memorydata.plugin");
        }

        <K, V> void copyAccessEntry(com.google.common.cache.g<K, V> r3, com.google.common.cache.g<K, V> r4) {
            com.google.common.cache.g r2 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            r5.setAccessTime(r2.getAccessTime());
            LocalCache.a(r2.getPreviousInAccessQueue(), r5);
            LocalCache.a(r5, r2.getNextInAccessQueue());
            LocalCache.b(r2);
        }

        <K, V> com.google.common.cache.g<K, V> copyEntry(Segment<K, V> r3, com.google.common.cache.g<K, V> r4, com.google.common.cache.g<K, V> r5, K r6) {
            com.google.common.cache.g r7 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            return newEntry(r3, r6, r7.getHash(), r8);
        }

        <K, V> void copyWriteEntry(com.google.common.cache.g<K, V> r3, com.google.common.cache.g<K, V> r4) {
            com.google.common.cache.g r2 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            r5.setWriteTime(r2.getWriteTime());
            LocalCache.b(r2.getPreviousInWriteQueue(), r5);
            LocalCache.b(r5, r2.getNextInWriteQueue());
            LocalCache.c(r2);
        }

        abstract <K, V> com.google.common.cache.g<K, V> newEntry(Segment<K, V> r1, K r2, int r3, com.google.common.cache.g<K, V> r4);
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements com.google.common.cache.e<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient com.google.common.cache.e<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> r1) {
            super(r1);
        }

        private void readObject(ObjectInputStream r2) {
            r2.defaultReadObject();
            this.autoDelegate = (com.google.common.cache.e<K, V>) recreateCacheBuilder().a(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.e, com.google.common.base.g, java.util.function.Function
        public V apply(K r1) {
            return this.autoDelegate.apply(r1);
        }

        @Override // com.google.common.cache.e
        public V get(K r1) {
            return this.autoDelegate.get(r1);
        }

        @Override // com.google.common.cache.e
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r3) {
            Iterable<? extends K> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            return this.autoDelegate.getAll(r4);
        }

        @Override // com.google.common.cache.e
        public V getUnchecked(K r1) {
            return this.autoDelegate.getUnchecked(r1);
        }

        @Override // com.google.common.cache.e
        public void refresh(K r1) {
            this.autoDelegate.refresh(r1);
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements com.google.common.cache.e<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> r4, CacheLoader<? super K, V> r5) {
            super(new LocalCache(r4, (CacheLoader) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), CacheLoader.class, "com.obric.memorydata.plugin")), null);
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        @Override // com.google.common.cache.e, com.google.common.base.g, java.util.function.Function
        public final V apply(K r1) {
            return getUnchecked(r1);
        }

        @Override // com.google.common.cache.e
        public V get(K r1) {
            return this.localCache.c(r1);
        }

        @Override // com.google.common.cache.e
        public ImmutableMap<K, V> getAll(Iterable<? extends K> r3) {
            Iterable<? extends K> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            return this.localCache.b(r4);
        }

        @Override // com.google.common.cache.e
        public V getUnchecked(K r1) {
            return get(r1);
        L4:
            e = move-exception;
            throw new UncheckedExecutionException(e.getCause());
        }

        @Override // com.google.common.cache.e
        public void refresh(K r1) {
            this.localCache.d(r1);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    static class LocalManualCache<K, V> implements com.google.common.cache.b<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        LocalManualCache(CacheBuilder<? super K, ? super V> r3) {
            this(new LocalCache(r3, null));
        }

        private LocalManualCache(LocalCache<K, V> r1) {
            this.localCache = r1;
        }

        /* synthetic */ LocalManualCache(LocalCache r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        @Override // com.google.common.cache.b
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.b
        public void cleanUp() {
            this.localCache.s();
        }

        @Override // com.google.common.cache.b
        public V get(K r3, Callable<? extends V> r4) {
            final Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r5);
            return this.localCache.a(r3, new AnonymousClass1(this, r5));
        }

        @Override // com.google.common.cache.b
        public ImmutableMap<K, V> getAllPresent(Iterable<?> r3) {
            Iterable<?> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            return this.localCache.a(r4);
        }

        @Override // com.google.common.cache.b
        public V getIfPresent(Object r1) {
            return this.localCache.b(r1);
        }

        @Override // com.google.common.cache.b
        public void invalidate(Object r1) {
            com.google.common.base.n.a(r1);
            this.localCache.remove(r1);
        }

        @Override // com.google.common.cache.b
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.b
        public void invalidateAll(Iterable<?> r3) {
            Iterable<?> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            this.localCache.c(r4);
        }

        @Override // com.google.common.cache.b
        public void put(K r1, V r2) {
            this.localCache.put(r1, r2);
        }

        @Override // com.google.common.cache.b
        public void putAll(Map<? extends K, ? extends V> r3) {
            Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.localCache.putAll(r4);
        }

        @Override // com.google.common.cache.b
        public long size() {
            return this.localCache.t();
        }

        @Override // com.google.common.cache.b
        public com.google.common.cache.c stats() {
            com.google.common.cache.a.C0193a r0 = new com.google.common.cache.a.C0193a();
            r0.a(this.localCache.s);
            Segment<K, V>[] r4 = this.localCache.d;
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0.a(r4[r2].statsCounter);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.b();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }

    static class ManualSerializationProxy<K, V> extends com.google.common.cache.d<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient com.google.common.cache.b<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final com.google.common.cache.h<? super K, ? super V> removalListener;
        final com.google.common.base.t ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final com.google.common.cache.i<K, V> weigher;

        private ManualSerializationProxy(Strength r7, Strength r8, Equivalence<Object> r9, Equivalence<Object> r10, long r11, long r13, long r15, com.google.common.cache.i<K, V> r17, int r18, com.google.common.cache.h<? super K, ? super V> r19, com.google.common.base.t r20, CacheLoader<? super K, V> r21) {
            com.google.common.base.t r1 = r20;
            com.google.common.cache.i<K, V> r2 = (com.google.common.cache.i) ZeusTransformUtils.wrapperContextForParams(r17, com.google.common.cache.i.class, "com.obric.memorydata.plugin");
            com.google.common.cache.h<? super K, ? super V> r3 = (com.google.common.cache.h) ZeusTransformUtils.wrapperContextForParams(r19, com.google.common.cache.h.class, "com.obric.memorydata.plugin");
            this.keyStrength = r7;
            this.valueStrength = r8;
            this.keyEquivalence = r9;
            this.valueEquivalence = r10;
            this.expireAfterWriteNanos = r11;
            this.expireAfterAccessNanos = r13;
            this.maxWeight = r15;
            this.weigher = r2;
            this.concurrencyLevel = r18;
            this.removalListener = r3;
            if (r1 != com.google.common.base.t.b()) goto L5;
        L6:
            r1 = null;
        L7:
            this.ticker = r1;
            this.loader = r21;
            return;
        L5:
            if (r1 != CacheBuilder.d) goto L7;
            goto L6
        }

        ManualSerializationProxy(LocalCache<K, V> r17) {
            this(r17.h, r17.i, r17.f, r17.g, r17.m, r17.l, r17.j, r17.k, r17.e, r17.p, r17.q, r17.t);
        }

        private void readObject(ObjectInputStream r1) {
            r1.defaultReadObject();
            this.delegate = (com.google.common.cache.b<K, V>) recreateCacheBuilder().o();
        }

        private Object readResolve() {
            return this.delegate;
        }

        @Override // com.google.common.cache.d, com.google.common.collect.ac
        public com.google.common.cache.b<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.cache.d, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> r0 = (CacheBuilder<K, V>) CacheBuilder.a().a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.valueEquivalence).a(this.concurrencyLevel).a(this.removalListener);
            r0.e = false;
            long r1 = this.expireAfterWriteNanos;
            if (r1 <= 0) goto L5;
            r0.a(r1, TimeUnit.NANOSECONDS);
        L5:
            long r2 = this.expireAfterAccessNanos;
            if (r2 <= 0) goto L9;
            r0.b(r2, TimeUnit.NANOSECONDS);
        L9:
            if (this.weigher == CacheBuilder.OneWeigher.INSTANCE) goto L13;
            r0.a(this.weigher);
            long r3 = this.maxWeight;
            if (r3 == (-1)) goto L16;
            r0.b(r3);
        L16:
            com.google.common.base.t r6 = this.ticker;
            if (r6 == null) goto L19;
            r0.a(r6);
        L19:
            return r0;
        L13:
            long r4 = this.maxWeight;
            if (r4 == (-1)) goto L16;
            r0.a(r4);
            goto L16
        }
    }

    private static final enum NullEntry extends Enum<NullEntry> implements com.google.common.cache.g<Object, Object> {
        private static final /* synthetic */ NullEntry[] $VALUES = null;
        public static final NullEntry INSTANCE = null;

        private static /* synthetic */ NullEntry[] $values() {
            return new NullEntry[]{INSTANCE};
        }

        static {
            INSTANCE = new NullEntry("INSTANCE", 0);
            $VALUES = $values();
        }

        private NullEntry(String r1, int r2) {
            super(r1, r2);
        }

        public static NullEntry valueOf(String r2) {
            return (NullEntry) ZeusTransformUtils.preCheckCast(Enum.valueOf(NullEntry.class, r2), NullEntry.class, "com.obric.memorydata.plugin");
        }

        public static NullEntry[] values() {
            return (NullEntry[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NullEntry[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public long getAccessTime() {
            return 0;
        }

        @Override // com.google.common.cache.g
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.g
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.g
        public r<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.g
        public long getWriteTime() {
            return 0;
        }

        @Override // com.google.common.cache.g
        public void setAccessTime(long r1) {
        }

        @Override // com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<Object, Object> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<Object, Object> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<Object, Object> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<Object, Object> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public void setValueReference(r<Object, Object> r2) {
            r r1 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.g
        public void setWriteTime(long r1) {
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue<com.google.common.cache.g<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount;
        final Queue<com.google.common.cache.g<K, V>> recencyQueue;
        final com.google.common.cache.a.b statsCounter;
        volatile AtomicReferenceArray<com.google.common.cache.g<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<com.google.common.cache.g<K, V>> writeQueue;

        Segment(LocalCache<K, V> r3, int r4, long r5, com.google.common.cache.a.b r7) {
            com.google.common.cache.a.b r8 = (com.google.common.cache.a.b) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.cache.a.b.class, "com.obric.memorydata.plugin");
            this.readCount = new AtomicInteger();
            this.map = r3;
            this.maxSegmentWeight = r5;
            this.statsCounter = (com.google.common.cache.a.b) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r8), com.google.common.cache.a.b.class, "com.obric.memorydata.plugin");
            initTable(newEntryArray(r4));
            ReferenceQueue<V> r6 = null;
            if (r3.m() == false) goto L5;
            ReferenceQueue<K> r9 = new ReferenceQueue();
        L6:
            this.keyReferenceQueue = r9;
            if (r3.n() == false) goto L9;
            r6 = new ReferenceQueue();
        L9:
            this.valueReferenceQueue = r6;
            if (r3.f() == false) goto L12;
            Queue<com.google.common.cache.g<K, V>> r10 = new ConcurrentLinkedQueue();
        L13:
            this.recencyQueue = r10;
            if (r3.g() == false) goto L16;
            Queue<com.google.common.cache.g<K, V>> r11 = new ab();
        L17:
            this.writeQueue = r11;
            if (r3.f() == false) goto L20;
            Queue<com.google.common.cache.g<K, V>> r12 = new c();
        L21:
            this.accessQueue = r12;
            return;
        L20:
            r12 = LocalCache.q();
            goto L21
        L16:
            r11 = LocalCache.q();
            goto L17
        L12:
            r10 = LocalCache.q();
            goto L13
        L5:
            r9 = null;
            goto L6
        }

        void cleanUp() {
            runLockedCleanup(this.map.q.a());
            runUnlockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void clear() {
            if (this.count == 0) goto L30;
            lock();
            preWriteCleanup(this.map.q.a());     // Catch: Throwable -> L27
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L27
            int r2 = 0;
        L7:
            if (r2 >= r0.length()) goto L21;
            com.google.common.cache.g r3 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r2), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        L9:
            if (r3 == null) goto L20;
            if (r3.getValueReference().d() == false) goto L19;
            Object r6 = r3.getKey();     // Catch: Throwable -> L27
            V r8 = r3.getValueReference().get();     // Catch: Throwable -> L27
            if (r6 == null) goto L17;
            if (r8 == null) goto L17;
            RemovalCause r4 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L27
        L18:
            enqueueNotification(r6, r3.getHash(), r8, r3.getValueReference().a(), r4);     // Catch: Throwable -> L27
        L17:
            r4 = RemovalCause.COLLECTED;     // Catch: Throwable -> L27
        L19:
            r3 = r3.getNext();     // Catch: Throwable -> L27
            goto L9
        L20:
            r2 = r2 + 1;     // Catch: Throwable -> L27
            goto L7
        L21:
            int r5 = 0;
        L23:
            if (r5 >= r0.length()) goto L25;
            r0.set(r5, null);     // Catch: Throwable -> L27
            r5 = r5 + 1;     // Catch: Throwable -> L27
            goto L23
        L25:
            clearReferenceQueues();     // Catch: Throwable -> L27
            this.writeQueue.clear();     // Catch: Throwable -> L27
            this.accessQueue.clear();     // Catch: Throwable -> L27
            this.readCount.set(0);     // Catch: Throwable -> L27
            this.modCount++;     // Catch: Throwable -> L27
            this.count = 0;     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void clearKeyReferenceQueue() {
        L3:
            if (this.keyReferenceQueue.poll() != null) goto L3;
        }

        void clearReferenceQueues() {
            if (this.map.m() == false) goto L6;
            clearKeyReferenceQueue();
        L6:
            if (this.map.n() == false) goto L9;
            clearValueReferenceQueue();
            return;
        }

        void clearValueReferenceQueue() {
        L3:
            if (this.valueReferenceQueue.poll() != null) goto L3;
        }

        V compute(K r21, int r22, BiFunction<? super K, ? super V, ? extends V> r23) {
            BiFunction<? super K, ? super V, ? extends V> r9 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r23, BiFunction.class, "com.obric.memorydata.plugin");
            lock();
            long r10 = this.map.q.a();     // Catch: Throwable -> L44
            preWriteCleanup(r10);     // Catch: Throwable -> L44
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r12 = this.table;     // Catch: Throwable -> L44
            int r14 = r22 & (r12.length() - 1);     // Catch: Throwable -> L44
            com.google.common.cache.g<K, V> r15 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r12.get(r14), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
            com.google.common.cache.g<K, V> r6 = r15;
        L5:
            if (r6 == null) goto L17;
            K r2 = r6.getKey();     // Catch: Throwable -> L44
            if (r6.getHash() != r22) goto L16;
            if (r2 == null) goto L16;
            if (this.map.f.equivalent(r21, r2) == false) goto L16;
            r<K, V> r17 = r6.getValueReference();     // Catch: Throwable -> L44
            if (this.map.b(r6, r10) == false) goto L15;
            enqueueNotification(r2, r22, r17.get(), r17.a(), RemovalCause.EXPIRED);     // Catch: Throwable -> L44
        L15:
            this.writeQueue.remove(r6);     // Catch: Throwable -> L44
            this.accessQueue.remove(r6);     // Catch: Throwable -> L44
            r<K, V> r1 = r17;
            boolean r5 = false;
        L18:
            d r3 = new d(r1);     // Catch: Throwable -> L44
            if (r6 != null) goto L21;
            com.google.common.cache.g<K, V> r7 = newEntry(r21, r22, r15);     // Catch: Throwable -> L44
            r7.setValueReference(r3);     // Catch: Throwable -> L44
            r12.set(r14, r7);     // Catch: Throwable -> L44
            boolean r13 = true;
        L22:
            V r4 = r3.a(r21, r9);     // Catch: Throwable -> L44
            if (r4 == null) goto L35;
            if (r1 != null) goto L26;
        L47:
            V r0 = getAndRecordStats(r21, r22, r3, com.google.common.util.concurrent.h.a(r4));     // Catch: ExecutionException -> L33 Throwable -> L44
            unlock();
            postWriteCleanup();
            return r0;
        L34:
            throw new AssertionError("impossible; Futures.immediateFuture can't throw");     // Catch: Throwable -> L44
        L26:
            if (r4 != r1.get()) goto L47;
            r3.b(r4);     // Catch: Throwable -> L44
            r7.setValueReference(r1);     // Catch: Throwable -> L44
            recordWrite(r7, 0, r10);     // Catch: Throwable -> L44
            unlock();
            postWriteCleanup();
            return r4;
        L35:
            if (r13 == false) goto L37;
        L42:
            removeLoadingValue(r21, r22, r3);     // Catch: Throwable -> L44
        L40:
            unlock();
            postWriteCleanup();
            return null;
        L37:
            if (r1.c() == true) goto L42;
            removeEntry(r7, r22, RemovalCause.EXPLICIT);     // Catch: Throwable -> L44
            goto L40
        L21:
            r6.setValueReference(r3);     // Catch: Throwable -> L44
            r7 = r6;
            r13 = r5;
        L16:
            r6 = r6.getNext();     // Catch: Throwable -> L44
            goto L5
        L17:
            r6 = r6;
            r1 = null;
            r5 = true;
        L44:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean containsKey(Object r5, int r6) {
            boolean r1 = false;
            if (this.count == 0) goto L13;
            com.google.common.cache.g<K, V> r7 = getLiveEntry(r5, r6, this.map.q.a());     // Catch: Throwable -> L15
            if (r7 != null) goto L8;
            postReadCleanup();
            return false;
        L8:
            if (r7.getValueReference().get() == null) goto L11;
            r1 = true;
        L11:
            postReadCleanup();
            return r1;
        L13:
            postReadCleanup();
            return false;
        L15:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsValue(Object r10) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            long r2 = this.map.q.a();     // Catch: Throwable -> L20
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L20
            int r4 = r0.length();     // Catch: Throwable -> L20
            int r5 = 0;
        L5:
            if (r5 >= r4) goto L18;
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r5), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        L7:
            if (r6 == null) goto L17;
            V r7 = getLiveValue(r6, r2);     // Catch: Throwable -> L20
            if (r7 != null) goto L12;
        L15:
            r6 = r6.getNext();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.g.equivalent(r10, r7) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r5 = r5 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        com.google.common.cache.g<K, V> copyEntry(com.google.common.cache.g<K, V> r6, com.google.common.cache.g<K, V> r7) {
            com.google.common.cache.g<K, V> r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r9 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            K r0 = r8.getKey();
            if (r0 != null) goto L5;
            return null;
        L5:
            r<K, V> r2 = r8.getValueReference();
            V r3 = r2.get();
            if (r3 == null) goto L8;
        L10:
            com.google.common.cache.g<K, V> r10 = this.map.r.copyEntry(this, r8, r9, r0);
            r10.setValueReference(r2.a(this.valueReferenceQueue, r3, r10));
            return r10;
        L8:
            if (r2.d() == false) goto L10;
            return null;
        }

        void drainKeyReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends K> r1 = this.keyReferenceQueue.poll();
            if (r1 == null) goto L7;
            com.google.common.cache.g<K, V> r2 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r1, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            this.map.a(r2);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void drainRecencyQueue() {
        L2:
            com.google.common.cache.g<K, V> r0 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(this.recencyQueue.poll(), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            if (this.accessQueue.contains(r0) == false) goto L2;
            this.accessQueue.add(r0);
            goto L2
        }

        void drainReferenceQueues() {
            if (this.map.m() == false) goto L6;
            drainKeyReferenceQueue();
        L6:
            if (this.map.n() == false) goto L9;
            drainValueReferenceQueue();
            return;
        }

        void drainValueReferenceQueue() {
            int r0 = 0;
        L3:
            Reference<? extends V> r1 = this.valueReferenceQueue.poll();
            if (r1 == null) goto L7;
            r<K, V> r2 = (r) ZeusTransformUtils.preCheckCast(r1, r.class, "com.obric.memorydata.plugin");
            this.map.a(r2);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void enqueueNotification(K r5, int r6, V r7, int r8, RemovalCause r9) {
            this.totalWeight -= (long) r8;
            if (r9.wasEvicted() == false) goto L6;
            this.statsCounter.a();
        L6:
            if (this.map.o == LocalCache.v) goto L9;
            this.map.o.offer(RemovalNotification.create(r5, r7, r9));
            return;
        }

        void evictEntries(com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (this.map.a() == true) goto L5;
            return;
        L5:
            drainRecencyQueue();
            if (r6.getValueReference().a() <= this.maxSegmentWeight) goto L13;
            if (removeEntry(r6, r6.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        L13:
            if (this.totalWeight <= this.maxSegmentWeight) goto L19;
            com.google.common.cache.g<K, V> r7 = getNextEvictable();
            if (removeEntry(r7, r7.getHash(), RemovalCause.SIZE) == true) goto L13;
            throw new AssertionError();
        }

        void expand() {
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;
            int r1 = r0.length();
            if (r1 < 1073741824) goto L5;
            return;
        L5:
            int r2 = this.count;
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r3 = newEntryArray(r1 << 1);
            this.threshold = (r3.length() * 3) / 4;
            int r4 = r3.length() - 1;
            int r5 = 0;
        L6:
            if (r5 >= r1) goto L26;
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r5), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L25;
            com.google.common.cache.g<K, V> r7 = r6.getNext();
            int r9 = r6.getHash() & r4;
            if (r7 != null) goto L12;
            r3.set(r9, r6);
            goto L25
        L12:
            com.google.common.cache.g<K, V> r10 = r6;
        L13:
            if (r7 == null) goto L18;
            int r11 = r7.getHash() & r4;
            if (r11 == r9) goto L17;
            r10 = r7;
            r9 = r11;
        L17:
            r7 = r7.getNext();
            goto L13
        L18:
            r3.set(r9, r10);
        L19:
            if (r6 == r10) goto L25;
            int r8 = r6.getHash() & r4;
            com.google.common.cache.g<K, V> r12 = copyEntry(r6, (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r3.get(r8), com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            if (r12 == null) goto L23;
            r3.set(r8, r12);
        L24:
            r6 = r6.getNext();
            goto L19
        L23:
            removeCollectedEntry(r6);
            r2 = r2 - 1;
        L25:
            r5 = r5 + 1;
            goto L6
        L26:
            this.table = r3;
            this.count = r2;
        }

        void expireEntries(long r5) {
            drainRecencyQueue();
        L3:
            com.google.common.cache.g<K, V> r0 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(this.writeQueue.peek(), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L12;
            if (this.map.b(r0, r5) == false) goto L12;
            if (removeEntry(r0, r0.getHash(), RemovalCause.EXPIRED) == true) goto L3;
            throw new AssertionError();
        L12:
            com.google.common.cache.g<K, V> r1 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(this.accessQueue.peek(), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L21;
            if (this.map.b(r1, r5) == false) goto L31;
            if (removeEntry(r1, r1.getHash(), RemovalCause.EXPIRED) == true) goto L12;
            throw new AssertionError();
        L31:
            return;
        }

        V get(Object r11, int r12) {
        L16:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L14;
            long r7 = this.map.q.a();     // Catch: Throwable -> L16
            com.google.common.cache.g<K, V> r3 = getLiveEntry(r11, r12, r7);     // Catch: Throwable -> L16
            if (r3 != null) goto L8;
            postReadCleanup();
            return null;
        L8:
            V r6 = r3.getValueReference().get();     // Catch: Throwable -> L16
            if (r6 == null) goto L13;
            recordRead(r3, r7);     // Catch: Throwable -> L16
            V r13 = scheduleRefresh(r3, r3.getKey(), r12, r6, r7, this.map.t);     // Catch: Throwable -> L16
            postReadCleanup();
            return r13;
        L13:
            tryDrainReferenceQueues();     // Catch: Throwable -> L16
        L14:
            postReadCleanup();
            return null;
        }

        V get(K r10, int r11, CacheLoader<? super K, V> r12) {
            com.google.common.base.n.a(r10);
            com.google.common.base.n.a(r12);
        L22:
            e = move-exception;
            Throwable r13 = e.getCause();     // Catch: Throwable -> L20
            if (ZeusTransformUtils.instanceOf(r13, Error.class) == true) goto L31;
            if (ZeusTransformUtils.instanceOf(r13, RuntimeException.class) == true) goto L28;
            throw e;     // Catch: Throwable -> L20
        L28:
            throw new UncheckedExecutionException(r13);     // Catch: Throwable -> L20
        L31:
            throw new ExecutionError((Error) ZeusTransformUtils.preCheckCast(r13, Error.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        L4:
            if (this.count == 0) goto L17;
            com.google.common.cache.g<K, V> r2 = getEntry(r10, r11);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r2 == null) goto L17;
            long r6 = this.map.q.a();     // Catch: Throwable -> L20 ExecutionException -> L22
            V r5 = getLiveValue(r2, r6);     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r5 == null) goto L12;
            recordRead(r2, r6);     // Catch: Throwable -> L20 ExecutionException -> L22
            this.statsCounter.a(1);     // Catch: Throwable -> L20 ExecutionException -> L22
            V r14 = scheduleRefresh(r2, r10, r11, r5, r6, r12);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r14;
        L12:
            r<K, V> r0 = r2.getValueReference();     // Catch: Throwable -> L20 ExecutionException -> L22
            if (r0.c() == false) goto L17;
            V r15 = waitForLoadingValue(r2, r10, r0);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r15;
        L17:
            V r16 = lockedGetOrLoad(r10, r11, r12);     // Catch: Throwable -> L20 ExecutionException -> L22
            postReadCleanup();
            return r16;
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        V getAndRecordStats(K r4, int r5, j<K, V> r6, com.google.common.util.concurrent.l<V> r7) {
            V r8 = (V) com.google.common.util.concurrent.x.a((com.google.common.util.concurrent.l) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.util.concurrent.l.class, "com.obric.memorydata.plugin"));
            if (r8 == null) goto L12;
            this.statsCounter.a(r6.f());     // Catch: Throwable -> L9
            storeLoadedValue(r4, r5, r6, r8);     // Catch: Throwable -> L9
            if (r8 != null) goto L8;
            this.statsCounter.b(r6.f());
            removeLoadingValue(r4, r5, r6);
        L8:
            return r8;
        L12:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r4 + ".");     // Catch: Throwable -> L9
        L9:
            th = th;
        L15:
            if (r8 != null) goto L17;
            this.statsCounter.b(r6.f());
            removeLoadingValue(r4, r5, r6);
        L17:
            throw th;
        L13:
            th = th;
            r8 = null;
            goto L15
        }

        com.google.common.cache.g<K, V> getEntry(Object r4, int r5) {
            com.google.common.cache.g<K, V> r0 = getFirst(r5);
        L3:
            if (r0 == null) goto L14;
            if (r0.getHash() != r5) goto L13;
            K r1 = r0.getKey();
            if (r1 != null) goto L11;
            tryDrainReferenceQueues();
            goto L13
        L11:
            if (this.map.f.equivalent(r4, r1) == false) goto L13;
            return r0;
        L13:
            r0 = r0.getNext();
            goto L3
        L14:
            return null;
        }

        com.google.common.cache.g<K, V> getFirst(int r2) {
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r1 = this.table;
            return (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r1.get(r2 & (r1.length() - 1)), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        com.google.common.cache.g<K, V> getLiveEntry(Object r2, int r3, long r4) {
            com.google.common.cache.g<K, V> r5 = getEntry(r2, r3);
            if (r5 != null) goto L6;
            return null;
        L6:
            if (this.map.b(r5, r4) == false) goto L9;
            tryExpireEntries(r4);
            return null;
        L9:
            return r5;
        }

        V getLiveValue(com.google.common.cache.g<K, V> r4, long r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r6.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r0 = r6.getValueReference().get();
            if (r0 != null) goto L11;
            tryDrainReferenceQueues();
            return null;
        L11:
            if (this.map.b(r6, r5) == false) goto L14;
            tryExpireEntries(r5);
            return null;
        L14:
            return r0;
        }

        com.google.common.cache.g<K, V> getNextEvictable() {
            Iterator<com.google.common.cache.g<K, V>> r3 = this.accessQueue.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            com.google.common.cache.g<K, V> r0 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r3.next(), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (r0.getValueReference().a() <= 0) goto L4;
            return r0;
        L9:
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<com.google.common.cache.g<K, V>> r6) {
            this.threshold = (r6.length() * 3) / 4;
            if (this.map.b() == true) goto L7;
            int r0 = this.threshold;
            if (r0 != this.maxSegmentWeight) goto L7;
            this.threshold = r0 + 1;
        L7:
            this.table = r6;
        }

        j<K, V> insertLoadingValueReference(K r9, int r10, boolean r11) {
            lock();
            long r0 = this.map.q.a();     // Catch: Throwable -> L25
            preWriteCleanup(r0);     // Catch: Throwable -> L25
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r2 = this.table;     // Catch: Throwable -> L25
            int r3 = (r2.length() - 1) & r10;     // Catch: Throwable -> L25
            com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r2.get(r3), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            com.google.common.cache.g r5 = r4;
        L4:
            if (r5 == null) goto L22;
            Object r6 = r5.getKey();     // Catch: Throwable -> L25
            if (r5.getHash() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.f.equivalent(r9, r6) == false) goto L21;
            r<K, V> r12 = r5.getValueReference();     // Catch: Throwable -> L25
            if (r12.c() == true) goto L19;
            if (r11 == true) goto L14;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            j<K, V> r13 = new j(r12);     // Catch: Throwable -> L25
            r5.setValueReference(r13);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r13;
        L14:
            if ((r0 - r5.getWriteTime()) >= this.map.n) goto L16;
        L19:
            unlock();
            postWriteCleanup();
            return null;
        L21:
            r5 = r5.getNext();     // Catch: Throwable -> L25
            goto L4
        L22:
            this.modCount++;     // Catch: Throwable -> L25
            j<K, V> r14 = new j();     // Catch: Throwable -> L25
            com.google.common.cache.g<K, V> r15 = newEntry(r9, r10, r4);     // Catch: Throwable -> L25
            r15.setValueReference(r14);     // Catch: Throwable -> L25
            r2.set(r3, r15);     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r14;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void lambda$loadAsync$0$LocalCache$Segment(Object r3, int r4, j r5, com.google.common.util.concurrent.l r6) {
            getAndRecordStats(r3, r4, r5, (com.google.common.util.concurrent.l) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.util.concurrent.l.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LocalCache.f4314a.log(Level.WARNING, "Exception thrown during refresh", th);
            r5.a(th);
        }

        com.google.common.util.concurrent.l<V> loadAsync(final K r8, final int r9, final j<K, V> r10, CacheLoader<? super K, V> r11) {
            final com.google.common.util.concurrent.l<V> r12 = r10.a(r8, r11);
            r12.addListener(new $$Lambda$LocalCache$Segment$pligtRTCCHFVFYhpb2zu1_pnmwM(this, r8, r9, r10, r12), com.google.common.util.concurrent.s.a());
            return r12;
        }

        V loadSync(K r1, int r2, j<K, V> r3, CacheLoader<? super K, V> r4) {
            return getAndRecordStats(r1, r2, r3, r3.a(r1, r4));
        }

        V lockedGetOrLoad(K r18, int r19, CacheLoader<? super K, V> r20) {
            lock();
            long r1 = this.map.q.a();     // Catch: Throwable -> L49
            preWriteCleanup(r1);     // Catch: Throwable -> L49
            int r10 = this.count - 1;     // Catch: Throwable -> L49
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r11 = this.table;     // Catch: Throwable -> L49
            int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L49
            com.google.common.cache.g<K, V> r13 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r11.get(r12), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
            com.google.common.cache.g<K, V> r14 = r13;
        L4:
            j<K, V> r15 = null;
            if (r14 == null) goto L27;
            K r3 = r14.getKey();     // Catch: Throwable -> L49
            if (r14.getHash() != r19) goto L26;
            if (r3 == null) goto L26;
            if (this.map.f.equivalent(r18, r3) == false) goto L26;
            r<K, V> r16 = r14.getValueReference();     // Catch: Throwable -> L49
            if (r16.c() == false) goto L15;
            boolean r2 = false;
        L14:
            r<K, V> r4 = r16;
        L28:
            if (r2 == false) goto L33;
            r15 = new j();     // Catch: Throwable -> L49
            if (r14 != null) goto L32;
            r14 = newEntry(r18, r19, r13);     // Catch: Throwable -> L49
            r14.setValueReference(r15);     // Catch: Throwable -> L49
            r11.set(r12, r14);     // Catch: Throwable -> L49
            goto L33
        L32:
            r14.setValueReference(r15);     // Catch: Throwable -> L49
        L33:
            unlock();
            postWriteCleanup();
            if (r2 == false) goto L48;
            monitor-enter(r14);     // Catch: Throwable -> L44
            V r0 = loadSync(r18, r19, r15, r20);     // Catch: Throwable -> L41
            monitor-exit(r14);     // Catch: Throwable -> L41
            this.statsCounter.b(1);
            return r0;
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            this.statsCounter.b(1);
            throw th;
        L48:
            return waitForLoadingValue(r14, r18, r4);
        L15:
            V r5 = r16.get();     // Catch: Throwable -> L49
            if (r5 != null) goto L20;
            int r6 = r16.a();     // Catch: Throwable -> L49
            RemovalCause r7 = RemovalCause.COLLECTED;     // Catch: Throwable -> L49
        L18:
            enqueueNotification(r3, r19, r5, r6, r7);     // Catch: Throwable -> L49
            this.writeQueue.remove(r14);     // Catch: Throwable -> L49
            this.accessQueue.remove(r14);     // Catch: Throwable -> L49
            this.count = r10;     // Catch: Throwable -> L49
            r2 = true;
            goto L14
        L20:
            if (this.map.b(r14, r1) == false) goto L23;
            r6 = r16.a();     // Catch: Throwable -> L49
            r7 = RemovalCause.EXPIRED;     // Catch: Throwable -> L49
            goto L18
        L23:
            recordLockedRead(r14, r1);     // Catch: Throwable -> L49
            this.statsCounter.a(1);     // Catch: Throwable -> L49
            unlock();
            postWriteCleanup();
            return r5;
        L26:
            r14 = r14.getNext();     // Catch: Throwable -> L49
            goto L4
        L27:
            r2 = true;
            r4 = null;
        L49:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        com.google.common.cache.g<K, V> newEntry(K r3, int r4, com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            return this.map.r.newEntry(this, com.google.common.base.n.a(r3), r4, r6);
        }

        AtomicReferenceArray<com.google.common.cache.g<K, V>> newEntryArray(int r1) {
            return new AtomicReferenceArray(r1);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            cleanUp();
            return;
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void preWriteCleanup(long r1) {
            runLockedCleanup(r1);
        }

        V put(K r15, int r16, V r17, boolean r18) {
            lock();
            long r8 = this.map.q.a();     // Catch: Throwable -> L32
            preWriteCleanup(r8);     // Catch: Throwable -> L32
            if ((this.count + 1) <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L32
        L6:
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r10 = this.table;     // Catch: Throwable -> L32
            int r11 = r16 & (r10.length() - 1);     // Catch: Throwable -> L32
            com.google.common.cache.g<K, V> r1 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r10.get(r11), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
            com.google.common.cache.g<K, V> r12 = r1;
        L8:
            if (r12 == null) goto L30;
            K r2 = r12.getKey();     // Catch: Throwable -> L32
            if (r12.getHash() != r16) goto L29;
            if (r2 == null) goto L29;
            if (this.map.f.equivalent(r15, r2) == false) goto L29;
            r<K, V> r3 = r12.getValueReference();     // Catch: Throwable -> L32
            V r13 = r3.get();     // Catch: Throwable -> L32
            if (r13 != null) goto L24;
            this.modCount++;     // Catch: Throwable -> L32
            if (r3.d() == false) goto L19;
            enqueueNotification(r15, r16, r13, r3.a(), RemovalCause.COLLECTED);     // Catch: Throwable -> L32
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L32
            int r0 = this.count;     // Catch: Throwable -> L32
        L20:
            this.count = r0;     // Catch: Throwable -> L32
        L21:
            evictEntries(r12);     // Catch: Throwable -> L32
            unlock();
            postWriteCleanup();
            return null;
        L19:
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L32
            r0 = this.count + 1;     // Catch: Throwable -> L32
            goto L20
        L24:
            if (r18 == false) goto L28;
            recordLockedRead(r12, r8);     // Catch: Throwable -> L32
        L26:
            unlock();
            postWriteCleanup();
            return r13;
        L28:
            this.modCount++;     // Catch: Throwable -> L32
            enqueueNotification(r15, r16, r13, r3.a(), RemovalCause.REPLACED);     // Catch: Throwable -> L32
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L32
            evictEntries(r12);     // Catch: Throwable -> L32
        L29:
            r12 = r12.getNext();     // Catch: Throwable -> L32
            goto L8
        L30:
            this.modCount++;     // Catch: Throwable -> L32
            r12 = newEntry(r15, r16, r1);     // Catch: Throwable -> L32
            setValue(r12, r15, r17, r8);     // Catch: Throwable -> L32
            r10.set(r11, r12);     // Catch: Throwable -> L32
            this.count++;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean reclaimKey(com.google.common.cache.g<K, V> r13, int r14) {
            com.google.common.cache.g<K, V> r15 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r13, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            lock();
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L13
            int r2 = (r0.length() - 1) & r14;     // Catch: Throwable -> L13
            com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r2), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            com.google.common.cache.g<K, V> r6 = r5;
        L4:
            if (r6 == null) goto L11;
            if (r6 == r15) goto L6;
            r6 = r6.getNext();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            com.google.common.cache.g<K, V> r16 = removeValueFromChain(r5, r6, r6.getKey(), r14, r6.getValueReference().get(), r6.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L13
            int r17 = this.count - 1;     // Catch: Throwable -> L13
            r0.set(r2, r16);     // Catch: Throwable -> L13
            this.count = r17;     // Catch: Throwable -> L13
            unlock();
            postWriteCleanup();
            return true;
        L11:
            unlock();
            postWriteCleanup();
            return false;
        L13:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean reclaimValue(K r12, int r13, r<K, V> r14) {
            r<K, V> r8 = (r) ZeusTransformUtils.wrapperContextForParams(r14, r.class, "com.obric.memorydata.plugin");
            lock();
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r15 = this.table;     // Catch: Throwable -> L28
            int r0 = (r15.length() - 1) & r13;     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r3 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r15.get(r0), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L24;
            K r5 = r4.getKey();     // Catch: Throwable -> L28
            if (r4.getHash() != r13) goto L22;
            if (r5 == null) goto L22;
            if (this.map.f.equivalent(r12, r5) == false) goto L22;
            if (r4.getValueReference() != r8) goto L18;
            this.modCount++;     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r16 = removeValueFromChain(r3, r4, r5, r13, r8.get(), r8, RemovalCause.COLLECTED);     // Catch: Throwable -> L28
            int r17 = this.count - 1;     // Catch: Throwable -> L28
            r15.set(r0, r16);     // Catch: Throwable -> L28
            this.count = r17;     // Catch: Throwable -> L28
            unlock();
            if (isHeldByCurrentThread() == true) goto L17;
            postWriteCleanup();
        L17:
            return true;
        L18:
            unlock();
            if (isHeldByCurrentThread() == true) goto L21;
            postWriteCleanup();
        L21:
            return false;
        L22:
            r4 = r4.getNext();     // Catch: Throwable -> L28
            goto L5
        L24:
            unlock();
            if (isHeldByCurrentThread() == true) goto L27;
            postWriteCleanup();
        L27:
            return false;
        L28:
            th = move-exception;
            unlock();
            if (isHeldByCurrentThread() == true) goto L32;
            postWriteCleanup();
        L32:
            throw th;
        }

        void recordLockedRead(com.google.common.cache.g<K, V> r3, long r4) {
            com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (this.map.i() == false) goto L5;
            r5.setAccessTime(r4);
        L5:
            this.accessQueue.add(r5);
        }

        void recordRead(com.google.common.cache.g<K, V> r3, long r4) {
            com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (this.map.i() == false) goto L5;
            r5.setAccessTime(r4);
        L5:
            this.recencyQueue.add(r5);
        }

        void recordWrite(com.google.common.cache.g<K, V> r5, int r6, long r7) {
            com.google.common.cache.g<K, V> r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            drainRecencyQueue();
            this.totalWeight += (long) r6;
            if (this.map.i() == false) goto L6;
            r8.setAccessTime(r7);
        L6:
            if (this.map.h() == false) goto L8;
            r8.setWriteTime(r7);
        L8:
            this.accessQueue.add(r8);
            this.writeQueue.add(r8);
        }

        V refresh(K r2, int r3, CacheLoader<? super K, V> r4, boolean r5) {
            j<K, V> r6 = insertLoadingValueReference(r2, r3, r5);
            if (r6 != null) goto L5;
            return null;
        L5:
            com.google.common.util.concurrent.l<V> r1 = loadAsync(r2, r3, r6, r4);
            if (r1.isDone() == true) goto L11;
        L9:
            return null;
        L11:
            return (V) com.google.common.util.concurrent.x.a(r1);
        }

        V remove(Object r12, int r13) {
            lock();
            preWriteCleanup(this.map.q.a());     // Catch: Throwable -> L25
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r13;     // Catch: Throwable -> L25
            com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r1), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            com.google.common.cache.g<K, V> r5 = r4;
        L5:
            if (r5 == null) goto L21;
            K r6 = r5.getKey();     // Catch: Throwable -> L25
            if (r5.getHash() != r13) goto L23;
            if (r6 == null) goto L23;
            if (this.map.f.equivalent(r12, r6) == false) goto L23;
            r<K, V> r9 = r5.getValueReference();     // Catch: Throwable -> L25
            V r14 = r9.get();     // Catch: Throwable -> L25
            if (r14 == null) goto L16;
            RemovalCause r2 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L25
        L14:
            RemovalCause r10 = r2;
            this.modCount++;     // Catch: Throwable -> L25
            com.google.common.cache.g<K, V> r15 = removeValueFromChain(r4, r5, r6, r13, r14, r9, r10);     // Catch: Throwable -> L25
            int r3 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, r15);     // Catch: Throwable -> L25
            this.count = r3;     // Catch: Throwable -> L25
            unlock();
            postWriteCleanup();
            return r14;
        L16:
            if (r9.d() == false) goto L21;
            r2 = RemovalCause.COLLECTED;     // Catch: Throwable -> L25
        L23:
            r5 = r5.getNext();     // Catch: Throwable -> L25
        L21:
            unlock();
            postWriteCleanup();
            return null;
        L25:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean remove(Object r13, int r14, Object r15) {
            lock();
            preWriteCleanup(this.map.q.a());     // Catch: Throwable -> L28
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L28
            boolean r2 = true;
            int r1 = (r0.length() - 1) & r14;     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r1), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r6 = r5;
        L5:
            if (r6 == null) goto L24;
            K r7 = r6.getKey();     // Catch: Throwable -> L28
            if (r6.getHash() != r14) goto L26;
            if (r7 == null) goto L26;
            if (this.map.f.equivalent(r13, r7) == false) goto L26;
            r<K, V> r10 = r6.getValueReference();     // Catch: Throwable -> L28
            V r9 = r10.get();     // Catch: Throwable -> L28
            if (this.map.g.equivalent(r15, r9) == false) goto L14;
            RemovalCause r16 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L28
        L18:
            this.modCount++;     // Catch: Throwable -> L28
            com.google.common.cache.g<K, V> r17 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r16);     // Catch: Throwable -> L28
            int r18 = this.count - 1;     // Catch: Throwable -> L28
            r0.set(r1, r17);     // Catch: Throwable -> L28
            this.count = r18;     // Catch: Throwable -> L28
            if (r16 == RemovalCause.EXPLICIT) goto L22;
            r2 = false;
        L22:
            unlock();
            postWriteCleanup();
            return r2;
        L14:
            if (r9 != null) goto L24;
            if (r10.d() == false) goto L24;
            r16 = RemovalCause.COLLECTED;     // Catch: Throwable -> L28
        L26:
            r6 = r6.getNext();     // Catch: Throwable -> L28
        L24:
            unlock();
            postWriteCleanup();
            return false;
        L28:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeCollectedEntry(com.google.common.cache.g<K, V> r7) {
            com.google.common.cache.g r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            enqueueNotification(r8.getKey(), r8.getHash(), r8.getValueReference().get(), r8.getValueReference().a(), RemovalCause.COLLECTED);
            this.writeQueue.remove(r8);
            this.accessQueue.remove(r8);
        }

        boolean removeEntry(com.google.common.cache.g<K, V> r13, int r14, RemovalCause r15) {
            com.google.common.cache.g<K, V> r16 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r13, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;
            int r2 = (r0.length() - 1) & r14;
            com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r2), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r6 = r5;
        L3:
            if (r6 == null) goto L8;
            if (r6 == r16) goto L5;
            r6 = r6.getNext();
            goto L3
        L5:
            this.modCount++;
            com.google.common.cache.g<K, V> r17 = removeValueFromChain(r5, r6, r6.getKey(), r14, r6.getValueReference().get(), r6.getValueReference(), r15);
            int r18 = this.count - 1;
            r0.set(r2, r17);
            this.count = r18;
            return true;
        L8:
            return false;
        }

        com.google.common.cache.g<K, V> removeEntryFromChain(com.google.common.cache.g<K, V> r4, com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r7 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            int r0 = this.count;
            com.google.common.cache.g<K, V> r1 = r7.getNext();
        L3:
            if (r6 == r7) goto L9;
            com.google.common.cache.g<K, V> r2 = copyEntry(r6, r1);
            if (r2 == null) goto L7;
            r1 = r2;
        L8:
            r6 = r6.getNext();
            goto L3
        L7:
            removeCollectedEntry(r6);
            r0 = r0 - 1;
            goto L8
        L9:
            this.count = r0;
            return r1;
        }

        boolean removeLoadingValue(K r9, int r10, j<K, V> r11) {
            lock();
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r0 = this.table;     // Catch: Throwable -> L23
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L23
            com.google.common.cache.g<K, V> r3 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r0.get(r1), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
            com.google.common.cache.g<K, V> r4 = r3;
        L5:
            if (r4 == null) goto L19;
            K r6 = r4.getKey();     // Catch: Throwable -> L23
            if (r4.getHash() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.f.equivalent(r9, r6) == false) goto L21;
            if (r4.getValueReference() != r11) goto L19;
            if (r11.d() == false) goto L16;
            r4.setValueReference(r11.g());     // Catch: Throwable -> L23
        L17:
            unlock();
            postWriteCleanup();
            return true;
        L16:
            r0.set(r1, removeEntryFromChain(r3, r4));     // Catch: Throwable -> L23
        L21:
            r4 = r4.getNext();     // Catch: Throwable -> L23
        L19:
            unlock();
            postWriteCleanup();
            return false;
        L23:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        com.google.common.cache.g<K, V> removeValueFromChain(com.google.common.cache.g<K, V> r7, com.google.common.cache.g<K, V> r8, K r9, int r10, V r11, r<K, V> r12, RemovalCause r13) {
            com.google.common.cache.g<K, V> r14 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r15 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r8, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            r r16 = (r) ZeusTransformUtils.wrapperContextForParams(r12, r.class, "com.obric.memorydata.plugin");
            enqueueNotification(r9, r10, r11, r16.a(), r13);
            this.writeQueue.remove(r15);
            this.accessQueue.remove(r15);
            if (r16.c() == false) goto L7;
            r16.a(null);
            return r14;
        L7:
            return removeEntryFromChain(r14, r15);
        }

        V replace(K r18, int r19, V r20) {
            lock();
            long r7 = this.map.q.a();     // Catch: Throwable -> L24
            preWriteCleanup(r7);     // Catch: Throwable -> L24
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r10 = this.table;     // Catch: Throwable -> L24
            int r11 = r19 & (r10.length() - 1);     // Catch: Throwable -> L24
            com.google.common.cache.g<K, V> r2 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r10.get(r11), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            com.google.common.cache.g<K, V> r12 = r2;
        L5:
            if (r12 == null) goto L16;
            K r4 = r12.getKey();     // Catch: Throwable -> L24
            if (r12.getHash() != r19) goto L22;
            if (r4 == null) goto L22;
            if (this.map.f.equivalent(r18, r4) == false) goto L22;
            r<K, V> r15 = r12.getValueReference();     // Catch: Throwable -> L24
            V r16 = r15.get();     // Catch: Throwable -> L24
            if (r16 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L24
            enqueueNotification(r18, r19, r16, r15.a(), RemovalCause.REPLACED);     // Catch: Throwable -> L24
            setValue(r12, r18, r20, r7);     // Catch: Throwable -> L24
            evictEntries(r12);     // Catch: Throwable -> L24
            unlock();
            postWriteCleanup();
            return r16;
        L14:
            if (r15.d() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L24
            com.google.common.cache.g<K, V> r0 = removeValueFromChain(r2, r12, r4, r19, r16, r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L24
            int r1 = this.count - 1;     // Catch: Throwable -> L24
            r10.set(r11, r0);     // Catch: Throwable -> L24
            this.count = r1;     // Catch: Throwable -> L24
        L22:
            r12 = r12.getNext();     // Catch: Throwable -> L24
        L16:
            unlock();
            postWriteCleanup();
            return null;
        L24:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        boolean replace(K r18, int r19, V r20, V r21) {
            lock();
            long r7 = this.map.q.a();     // Catch: Throwable -> L27
            preWriteCleanup(r7);     // Catch: Throwable -> L27
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r10 = this.table;     // Catch: Throwable -> L27
            int r12 = r19 & (r10.length() - 1);     // Catch: Throwable -> L27
            com.google.common.cache.g<K, V> r2 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r10.get(r12), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            com.google.common.cache.g<K, V> r13 = r2;
        L5:
            if (r13 == null) goto L16;
            K r4 = r13.getKey();     // Catch: Throwable -> L27
            if (r13.getHash() != r19) goto L25;
            if (r4 == null) goto L25;
            if (this.map.f.equivalent(r18, r4) == false) goto L25;
            r<K, V> r16 = r13.getValueReference();     // Catch: Throwable -> L27
            V r6 = r16.get();     // Catch: Throwable -> L27
            if (r6 != null) goto L19;
            if (r16.d() == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L27
            com.google.common.cache.g<K, V> r0 = removeValueFromChain(r2, r13, r4, r19, r6, r16, RemovalCause.COLLECTED);     // Catch: Throwable -> L27
            int r1 = this.count - 1;     // Catch: Throwable -> L27
            r10.set(r12, r0);     // Catch: Throwable -> L27
            this.count = r1;     // Catch: Throwable -> L27
            goto L16
        L19:
            if (this.map.g.equivalent(r20, r6) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L27
            enqueueNotification(r18, r19, r6, r16.a(), RemovalCause.REPLACED);     // Catch: Throwable -> L27
            setValue(r13, r18, r21, r7);     // Catch: Throwable -> L27
            evictEntries(r13);     // Catch: Throwable -> L27
            unlock();
            postWriteCleanup();
            return true;
        L23:
            recordLockedRead(r13, r7);     // Catch: Throwable -> L27
        L25:
            r13 = r13.getNext();     // Catch: Throwable -> L27
        L16:
            unlock();
            postWriteCleanup();
            return false;
        L27:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void runLockedCleanup(long r2) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            expireEntries(r2);     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread() == true) goto L6;
            this.map.r();
            return;
        }

        V scheduleRefresh(com.google.common.cache.g<K, V> r3, K r4, int r5, V r6, long r7, CacheLoader<? super K, V> r9) {
            com.google.common.cache.g r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            if (this.map.e() == true) goto L5;
        L11:
            return r6;
        L5:
            if ((r7 - r8.getWriteTime()) <= this.map.n) goto L11;
            if (r8.getValueReference().c() == true) goto L11;
            V r2 = refresh(r4, r5, r9, true);
            if (r2 == null) goto L11;
            return r2;
        }

        void setValue(com.google.common.cache.g<K, V> r4, K r5, V r6, long r7) {
            com.google.common.cache.g<K, V> r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            r<K, V> r0 = r8.getValueReference();
            int r9 = this.map.k.weigh(r5, r6);
            if (r9 < 0) goto L5;
            boolean r1 = true;
        L6:
            com.google.common.base.n.b(r1, "Weights must be non-negative");
            r8.setValueReference(this.map.i.referenceValue(this, r8, r6, r9));
            recordWrite(r8, r9, r7);
            r0.a(r6);
            return;
        L5:
            r1 = false;
            goto L6
        }

        boolean storeLoadedValue(K r16, int r17, j<K, V> r18, V r19) {
            lock();
            long r8 = this.map.q.a();     // Catch: Throwable -> L36
            preWriteCleanup(r8);     // Catch: Throwable -> L36
            int r1 = this.count + 1;     // Catch: Throwable -> L36
            if (r1 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L36
            r1 = this.count + 1;     // Catch: Throwable -> L36
        L6:
            int r11 = r1;
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r12 = this.table;     // Catch: Throwable -> L36
            int r13 = r17 & (r12.length() - 1);     // Catch: Throwable -> L36
            com.google.common.cache.g<K, V> r2 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r12.get(r13), com.google.common.cache.g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
            com.google.common.cache.g<K, V> r14 = r2;
        L7:
            if (r14 == null) goto L34;
            K r3 = r14.getKey();     // Catch: Throwable -> L36
            if (r14.getHash() != r17) goto L33;
            if (r3 == null) goto L33;
            if (this.map.f.equivalent(r16, r3) == false) goto L33;
            r<K, V> r4 = r14.getValueReference();     // Catch: Throwable -> L36
            V r5 = r4.get();     // Catch: Throwable -> L36
            if (r18 == r4) goto L22;
            if (r5 == null) goto L17;
        L19:
            enqueueNotification(r16, r17, r19, 0, RemovalCause.REPLACED);     // Catch: Throwable -> L36
            unlock();
            postWriteCleanup();
            return false;
        L17:
            if (r4 == LocalCache.u) goto L19;
        L22:
            this.modCount++;     // Catch: Throwable -> L36
            if (r18.d() == false) goto L28;
            if (r5 != null) goto L26;
            RemovalCause r6 = RemovalCause.COLLECTED;     // Catch: Throwable -> L36
        L27:
            enqueueNotification(r16, r17, r5, r18.a(), r6);     // Catch: Throwable -> L36
            r11 = r11 - 1;     // Catch: Throwable -> L36
            goto L28
        L26:
            r6 = RemovalCause.REPLACED;     // Catch: Throwable -> L36
        L28:
            setValue(r14, r16, r19, r8);     // Catch: Throwable -> L36
            this.count = r11;     // Catch: Throwable -> L36
        L29:
            evictEntries(r14);     // Catch: Throwable -> L36
            unlock();
            postWriteCleanup();
            return true;
        L33:
            r14 = r14.getNext();     // Catch: Throwable -> L36
            goto L7
        L34:
            this.modCount++;     // Catch: Throwable -> L36
            r14 = newEntry(r16, r17, r2);     // Catch: Throwable -> L36
            setValue(r14, r16, r19, r8);     // Catch: Throwable -> L36
            r12.set(r13, r14);     // Catch: Throwable -> L36
            this.count = r11;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            unlock();
            postWriteCleanup();
            throw th;
        }

        void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            drainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        void tryExpireEntries(long r2) {
            if (tryLock() == true) goto L10;
            return;
        L10:
            expireEntries(r2);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        V waitForLoadingValue(com.google.common.cache.g<K, V> r5, K r6, r<K, V> r7) {
            com.google.common.cache.g<K, V> r8 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            r r9 = (r) ZeusTransformUtils.wrapperContextForParams(r7, r.class, "com.obric.memorydata.plugin");
            if (r9.c() == false) goto L16;
            com.google.common.base.n.b(!Thread.holdsLock(r8), "Recursive load of: %s", r6);
            V r10 = (V) r9.e();
            if (r10 == null) goto L11;
            recordRead(r8, this.map.q.a());     // Catch: Throwable -> L12
            this.statsCounter.b(1);
            return r10;
        L11:
            throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + r6 + ".");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.statsCounter.b(1);
            throw th;
        L16:
            throw new AssertionError();
        }
    }

    static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength SOFT = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        private static /* synthetic */ Strength[] $values() {
            return new Strength[]{STRONG, SOFT, WEAK};
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            STRONG = new AnonymousClass1(r1, r2);
            final String r3 = "SOFT";
            final int r4 = 1;
            SOFT = new AnonymousClass2(r3, r4);
            final String r5 = "WEAK";
            final int r6 = 2;
            WEAK = new AnonymousClass3(r5, r6);
            $VALUES = $values();
        }

        private Strength(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Strength(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Strength valueOf(String r2) {
            return (Strength) ZeusTransformUtils.preCheckCast(Enum.valueOf(Strength.class, r2), Strength.class, "com.obric.memorydata.plugin");
        }

        public static Strength[] values() {
            return (Strength[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Strength[].class, "com.obric.memorydata.plugin");
        }

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> r<K, V> referenceValue(Segment<K, V> r1, com.google.common.cache.g<K, V> r2, V r3, int r4);
    }

    abstract class a<T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalCache f4317a;

        a(LocalCache r1) {
            this.f4317a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4317a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f4317a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4317a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] r1) {
            return (E[]) LocalCache.a(this).toArray(r1);
        }
    }

    static final class aa<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4318b;

        aa(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5, int r6) {
            super(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4318b = r6;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.r
        public int a() {
            return this.f4318b;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5) {
            return new aa(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"), this.f4318b);
        }
    }

    static final class ab<K, V> extends AbstractQueue<com.google.common.cache.g<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.g<K, V> f4319a;

        ab() {
            this.f4319a = new AnonymousClass1(this);
        }

        public com.google.common.cache.g<K, V> a() {
            com.google.common.cache.g<K, V> r0 = this.f4319a.getNextInWriteQueue();
            if (r0 != this.f4319a) goto L6;
            return null;
        L6:
            return r0;
        }

        public boolean a(com.google.common.cache.g<K, V> r3) {
            com.google.common.cache.g r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            LocalCache.b(r4.getPreviousInWriteQueue(), r4.getNextInWriteQueue());
            LocalCache.b(this.f4319a.getPreviousInWriteQueue(), r4);
            LocalCache.b(r4, this.f4319a);
            return true;
        }

        public com.google.common.cache.g<K, V> b() {
            com.google.common.cache.g<K, V> r0 = this.f4319a.getNextInWriteQueue();
            if (r0 != this.f4319a) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.g<K, V> r0 = this.f4319a.getNextInWriteQueue();
        L3:
            com.google.common.cache.g<K, V> r1 = this.f4319a;
            if (r0 == r1) goto L6;
            com.google.common.cache.g<K, V> r2 = r0.getNextInWriteQueue();
            LocalCache.c(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextInWriteQueue(r1);
            com.google.common.cache.g<K, V> r3 = this.f4319a;
            r3.setPreviousInWriteQueue(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r2) {
            if (((com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin")).getNextInWriteQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f4319a.getNextInWriteQueue() != this.f4319a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.g<K, V>> iterator() {
            final com.google.common.cache.g<K, V> r1 = a();
            return new AnonymousClass2(this, r1);
        }

        @Override // java.util.Queue
        public /* synthetic */ boolean offer(Object r3) {
            return a((com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Queue
        public /* synthetic */ Object peek() {
            return a();
        }

        @Override // java.util.Queue
        public /* synthetic */ Object poll() {
            return b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r3 = r1.getPreviousInWriteQueue();
            com.google.common.cache.g<K, V> r0 = r1.getNextInWriteQueue();
            LocalCache.b(r3, r0);
            LocalCache.c(r1);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            com.google.common.cache.g<K, V> r0 = this.f4319a.getNextInWriteQueue();
            int r1 = 0;
        L4:
            if (r0 == this.f4319a) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextInWriteQueue();
            goto L4
        L6:
            return r1;
        }
    }

    final class ac implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f4324b;
        final /* synthetic */ LocalCache c;

        ac(LocalCache r1, K r2, V r3) {
            this.c = r1;
            this.f4323a = r2;
            this.f4324b = r3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L10;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            if (this.f4323a.equals(r5.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f4324b.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4323a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4324b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.f4323a.hashCode();
            return this.f4324b.hashCode() ^ r0;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            V r0 = (V) this.c.put(this.f4323a, r3);
            this.f4324b = r3;
            return r0;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    static abstract class b<K, V> implements com.google.common.cache.g<K, V> {
        b() {
        }

        @Override // com.google.common.cache.g
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public r<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setAccessTime(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setValueReference(r<K, V> r2) {
            r r1 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setWriteTime(long r1) {
            throw new UnsupportedOperationException();
        }
    }

    static final class c<K, V> extends AbstractQueue<com.google.common.cache.g<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.g<K, V> f4325a;

        c() {
            this.f4325a = new AnonymousClass1(this);
        }

        public com.google.common.cache.g<K, V> a() {
            com.google.common.cache.g<K, V> r0 = this.f4325a.getNextInAccessQueue();
            if (r0 != this.f4325a) goto L6;
            return null;
        L6:
            return r0;
        }

        public boolean a(com.google.common.cache.g<K, V> r3) {
            com.google.common.cache.g r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            LocalCache.a(r4.getPreviousInAccessQueue(), r4.getNextInAccessQueue());
            LocalCache.a(this.f4325a.getPreviousInAccessQueue(), r4);
            LocalCache.a(r4, this.f4325a);
            return true;
        }

        public com.google.common.cache.g<K, V> b() {
            com.google.common.cache.g<K, V> r0 = this.f4325a.getNextInAccessQueue();
            if (r0 != this.f4325a) goto L6;
            return null;
        L6:
            remove(r0);
            return r0;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.g<K, V> r0 = this.f4325a.getNextInAccessQueue();
        L3:
            com.google.common.cache.g<K, V> r1 = this.f4325a;
            if (r0 == r1) goto L6;
            com.google.common.cache.g<K, V> r2 = r0.getNextInAccessQueue();
            LocalCache.b(r0);
            r0 = r2;
            goto L3
        L6:
            r1.setNextInAccessQueue(r1);
            com.google.common.cache.g<K, V> r3 = this.f4325a;
            r3.setPreviousInAccessQueue(r3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r2) {
            if (((com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin")).getNextInAccessQueue() == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f4325a.getNextInAccessQueue() != this.f4325a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.g<K, V>> iterator() {
            final com.google.common.cache.g<K, V> r1 = a();
            return new AnonymousClass2(this, r1);
        }

        @Override // java.util.Queue
        public /* synthetic */ boolean offer(Object r3) {
            return a((com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Queue
        public /* synthetic */ Object peek() {
            return a();
        }

        @Override // java.util.Queue
        public /* synthetic */ Object poll() {
            return b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            com.google.common.cache.g<K, V> r3 = r1.getPreviousInAccessQueue();
            com.google.common.cache.g<K, V> r0 = r1.getNextInAccessQueue();
            LocalCache.a(r3, r0);
            LocalCache.b(r1);
            if (r0 == NullEntry.INSTANCE) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            com.google.common.cache.g<K, V> r0 = this.f4325a.getNextInAccessQueue();
            int r1 = 0;
        L4:
            if (r0 == this.f4325a) goto L6;
            r1 = r1 + 1;
            r0 = r0.getNextInAccessQueue();
            goto L4
        L6:
            return r1;
        }
    }

    static class d<K, V> extends j<K, V> {
        d(r<K, V> r3) {
            super((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.cache.LocalCache.j, com.google.common.cache.LocalCache.r
        public boolean c() {
            return false;
        }
    }

    final class e extends LocalCache<K, V>.g<Map.Entry<K, V>> {
        e(LocalCache r1) {
            super(r1);
        }

        public Map.Entry<K, V> a() {
            return e();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }
    }

    final class f extends LocalCache<K, V>.a<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocalCache f4329b;

        f(LocalCache r1) {
            this.f4329b = r1;
            super(r1);
        }

        private static /* synthetic */ boolean a(Predicate r2, Object r3, Object r4) {
            return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin")).test(Maps.a(r3, r4));
        }

        public static /* synthetic */ boolean lambda$myb7n4Tv_p6eytZE1botd4oekDw(Predicate r0, Object r1, Object r2) {
            return a(r0, r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            Object r1 = this.f4329b.get(r0);
            if (r1 != null) goto L11;
            return false;
        L11:
            if (this.f4329b.g.equivalent(r5.getValue(), r1) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(this.f4329b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            if (r0 != null) goto L8;
            return false;
        L8:
            if (this.f4329b.remove(r0, r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Map.Entry<K, V>> r3) {
            final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            return this.f4329b.a(new $$Lambda$LocalCache$f$myb7n4Tv_p6eytZE1botd4oekDw(r4));
        }
    }

    abstract class g<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4331b;
        Segment<K, V> c;
        AtomicReferenceArray<com.google.common.cache.g<K, V>> d;
        com.google.common.cache.g<K, V> e;
        LocalCache<K, V>.ac f;
        LocalCache<K, V>.ac g;
        final /* synthetic */ LocalCache h;

        g(LocalCache r1) {
            this.h = r1;
            this.f4330a = r1.d.length - 1;
            this.f4331b = -1;
            b();
        }

        boolean a(com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            long r0 = this.h.q.a();     // Catch: Throwable -> L10
            K r2 = r6.getKey();     // Catch: Throwable -> L10
            Object r7 = this.h.a(r6, r0);     // Catch: Throwable -> L10
            if (r7 == null) goto L9;
            this.f = new ac(this.h, r2, r7);     // Catch: Throwable -> L10
            boolean r8 = true;
        L7:
            this.c.postReadCleanup();
            return r8;
        L9:
            r8 = false;
        L10:
            th = move-exception;
            this.c.postReadCleanup();
            throw th;
        }

        final void b() {
            this.f = null;
            if (c() == false) goto L6;
            return;
        L6:
            if (d() == false) goto L9;
            return;
        L9:
            if (this.f4330a < 0) goto L14;
            Segment<K, V>[] r0 = this.h.d;
            int r1 = this.f4330a;
            this.f4330a = r1 - 1;
            Segment<K, V> r2 = r0[r1];
            this.c = r2;
            if (r2.count == 0) goto L9;
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r3 = this.c.table;
            this.d = r3;
            this.f4331b = r3.length() - 1;
            if (d() == false) goto L9;
            return;
        }

        boolean c() {
            com.google.common.cache.g<K, V> r0 = this.e;
            if (r0 == null) goto L11;
        L4:
            this.e = r0.getNext();
            com.google.common.cache.g<K, V> r1 = this.e;
            if (r1 == null) goto L15;
            if (a(r1) == true) goto L8;
            r0 = this.e;
            goto L4
        L8:
            return true;
        L15:
            return false;
        L11:
            return false;
        }

        boolean d() {
        L2:
            int r0 = this.f4331b;
            if (r0 < 0) goto L12;
            AtomicReferenceArray<com.google.common.cache.g<K, V>> r1 = this.d;
            this.f4331b = r0 - 1;
            com.google.common.cache.g<K, V> r2 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r1.get(r0), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            this.e = r2;
            if (r2 == null) goto L2;
            if (a(r2) == true) goto L10;
            if (c() == false) goto L2;
            return true;
        L10:
            return true;
        L12:
            return false;
        }

        LocalCache<K, V>.ac e() {
            LocalCache<K, V>.ac r0 = this.f;
            if (r0 == null) goto L7;
            this.g = r0;
            b();
            return this.g;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.g == null) goto L5;
            boolean r0 = true;
        L6:
            com.google.common.base.n.b(r0);
            this.h.remove(this.g.getKey());
            this.g = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    final class h extends LocalCache<K, V>.g<K> {
        h(LocalCache r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return e().getKey();
        }
    }

    final class i extends LocalCache<K, V>.a<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocalCache f4332b;

        i(LocalCache r1) {
            this.f4332b = r1;
            super(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.f4332b.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new h(this.f4332b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.f4332b.remove(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static class j<K, V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile r<K, V> f4333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.util.concurrent.w<V> f4334b;
        final com.google.common.base.p c;

        public j() {
            this(null);
        }

        public j(r<K, V> r3) {
            r<K, V> r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
            this.f4334b = com.google.common.util.concurrent.w.g();
            this.c = com.google.common.base.p.a();
            if (r4 != null) goto L5;
            r4 = LocalCache.o();
        L5:
            this.f4333a = r4;
        }

        private com.google.common.util.concurrent.l<V> b(Throwable r1) {
            return com.google.common.util.concurrent.h.a(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private /* synthetic */ Object c(Object r1) {
            b(r1);
            return r1;
        }

        public static /* synthetic */ Object lambda$ggvxm3iQt9IuASe9JkxzxWy1zIc(j r0, Object r1) {
            return r0.c(r1);
        }

        @Override // com.google.common.cache.LocalCache.r
        public int a() {
            return this.f4333a.a();
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> r1, V r2, com.google.common.cache.g<K, V> r3) {
            com.google.common.cache.g r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            return this;
        }

        public com.google.common.util.concurrent.l<V> a(K r2, CacheLoader<? super K, V> r3) {
            this.c.c();     // Catch: Throwable -> L15
            V r0 = this.f4333a.get();     // Catch: Throwable -> L15
            if (r0 != null) goto L9;
            V r4 = r3.load(r2);     // Catch: Throwable -> L15
            if (b(r4) == false) goto L8;
            return this.f4334b;
        L8:
            return com.google.common.util.concurrent.h.a(r4);
        L9:
            com.google.common.util.concurrent.l<V> r5 = r3.reload(r2, r0);     // Catch: Throwable -> L15
            if (r5 != null) goto L14;
            return com.google.common.util.concurrent.h.a(null);
        L14:
            return com.google.common.util.concurrent.h.a(r5, new $$Lambda$LocalCache$j$ggvxm3iQt9IuASe9JkxzxWy1zIc(this), com.google.common.util.concurrent.s.a());
        L15:
            th = move-exception;
            if (a(th) == false) goto L19;
            com.google.common.util.concurrent.l<V> r1 = this.f4334b;
        L21:
            if (ZeusTransformUtils.instanceOf(th, InterruptedException.class) == false) goto L23;
            Thread.currentThread().interrupt();
        L23:
            return r1;
        L19:
            r1 = b(th);
            goto L21
        }

        public V a(K r3, BiFunction<? super K, ? super V, ? extends V> r4) {
            BiFunction r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
            this.c.c();
            V r0 = this.f4333a.e();     // Catch: ExecutionException -> L5
        L14:
            V r6 = (V) r5.apply(r3, r0);
            b(r6);
            return r6;
        L9:
            th = move-exception;
            a(th);
            throw th;
        L5:
            r0 = null;
            goto L14
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V r1) {
            if (r1 == null) goto L4;
            b(r1);
            return;
        L4:
            this.f4333a = LocalCache.o();
        }

        public boolean a(Throwable r1) {
            return this.f4334b.a(r1);
        }

        @Override // com.google.common.cache.LocalCache.r
        public com.google.common.cache.g<K, V> b() {
            return null;
        }

        public boolean b(V r1) {
            return this.f4334b.a(r1);
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean c() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean d() {
            return this.f4333a.d();
        }

        @Override // com.google.common.cache.LocalCache.r
        public V e() {
            return (V) com.google.common.util.concurrent.x.a(this.f4334b);
        }

        public long f() {
            return this.c.a(TimeUnit.NANOSECONDS);
        }

        public r<K, V> g() {
            return this.f4333a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V get() {
            return this.f4333a.get();
        }
    }

    static class k<K, V> extends SoftReference<V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.g<K, V> f4335a;

        k(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            super(r4, r3);
            this.f4335a = r6;
        }

        @Override // com.google.common.cache.LocalCache.r
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> r2, V r3, com.google.common.cache.g<K, V> r4) {
            return new k(r2, r3, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V r1) {
        }

        @Override // com.google.common.cache.LocalCache.r
        public com.google.common.cache.g<K, V> b() {
            return this.f4335a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V e() {
            return get();
        }
    }

    static final class l<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4337b;
        com.google.common.cache.g<K, V> c;

        l(K r3, int r4, com.google.common.cache.g<K, V> r5) {
            super(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4336a = Long.MAX_VALUE;
            this.f4337b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public long getAccessTime() {
            return this.f4336a;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            return this.f4337b;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setAccessTime(long r1) {
            this.f4336a = r1;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.f4337b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }
    }

    static final class m<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4339b;
        com.google.common.cache.g<K, V> c;
        volatile long d;
        com.google.common.cache.g<K, V> e;
        com.google.common.cache.g<K, V> f;

        m(K r3, int r4, com.google.common.cache.g<K, V> r5) {
            super(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4338a = Long.MAX_VALUE;
            this.f4339b = LocalCache.p();
            this.c = LocalCache.p();
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.p();
            this.f = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public long getAccessTime() {
            return this.f4338a;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            return this.f4339b;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setAccessTime(long r1) {
            this.f4338a = r1;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.f4339b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.e = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.f = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setWriteTime(long r1) {
            this.d = r1;
        }
    }

    static class n<K, V> extends b<K, V> {
        final K g;
        final int h;
        final com.google.common.cache.g<K, V> i;
        volatile r<K, V> j;

        n(K r3, int r4, com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            this.j = LocalCache.o();
            this.g = r3;
            this.h = r4;
            this.i = r6;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public int getHash() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public K getKey() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNext() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public r<K, V> getValueReference() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setValueReference(r<K, V> r3) {
            this.j = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        }
    }

    static class o<K, V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final V f4340a;

        o(V r1) {
            this.f4340a = r1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public int a() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> r1, V r2, com.google.common.cache.g<K, V> r3) {
            com.google.common.cache.g r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            return this;
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V r1) {
        }

        @Override // com.google.common.cache.LocalCache.r
        public com.google.common.cache.g<K, V> b() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.r
        public V get() {
            return this.f4340a;
        }
    }

    static final class p<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4342b;
        com.google.common.cache.g<K, V> c;

        p(K r3, int r4, com.google.common.cache.g<K, V> r5) {
            super(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4341a = Long.MAX_VALUE;
            this.f4342b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            return this.f4342b;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public long getWriteTime() {
            return this.f4341a;
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.f4342b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.b, com.google.common.cache.g
        public void setWriteTime(long r1) {
            this.f4341a = r1;
        }
    }

    final class q extends LocalCache<K, V>.g<V> {
        q(LocalCache r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return e().getValue();
        }
    }

    interface r<K, V> {
        int a();

        r<K, V> a(ReferenceQueue<V> r1, V r2, com.google.common.cache.g<K, V> r3);

        void a(V r1);

        com.google.common.cache.g<K, V> b();

        boolean c();

        boolean d();

        V e();

        V get();
    }

    final class s extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalCache f4343a;

        s(LocalCache r1) {
            this.f4343a = r1;
        }

        private static /* synthetic */ boolean a(Predicate r1, Object r2, Object r3) {
            return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r1, Predicate.class, "com.obric.memorydata.plugin")).test(r3);
        }

        public static /* synthetic */ boolean lambda$MWxhNqS1VfX7Rcubyzubb9Lt8fU(Predicate r0, Object r1, Object r2) {
            return a(r0, r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4343a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.f4343a.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f4343a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new q(this.f4343a);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super V> r3) {
            final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            return this.f4343a.a(new $$Lambda$LocalCache$s$MWxhNqS1VfX7Rcubyzubb9Lt8fU(r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4343a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] r1) {
            return (E[]) LocalCache.a(this).toArray(r1);
        }
    }

    static final class t<K, V> extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4345b;
        com.google.common.cache.g<K, V> c;

        t(ReferenceQueue<K> r3, K r4, int r5, com.google.common.cache.g<K, V> r6) {
            super(r3, r4, r5, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4344a = Long.MAX_VALUE;
            this.f4345b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public long getAccessTime() {
            return this.f4344a;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            return this.f4345b;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setAccessTime(long r1) {
            this.f4344a = r1;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.f4345b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }
    }

    static final class u<K, V> extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4347b;
        com.google.common.cache.g<K, V> c;
        volatile long d;
        com.google.common.cache.g<K, V> e;
        com.google.common.cache.g<K, V> f;

        u(ReferenceQueue<K> r3, K r4, int r5, com.google.common.cache.g<K, V> r6) {
            super(r3, r4, r5, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4346a = Long.MAX_VALUE;
            this.f4347b = LocalCache.p();
            this.c = LocalCache.p();
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.p();
            this.f = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public long getAccessTime() {
            return this.f4346a;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            return this.f4347b;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setAccessTime(long r1) {
            this.f4346a = r1;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.f4347b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.e = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.f = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setWriteTime(long r1) {
            this.d = r1;
        }
    }

    static class v<K, V> extends WeakReference<K> implements com.google.common.cache.g<K, V> {
        final int g;
        final com.google.common.cache.g<K, V> h;
        volatile r<K, V> i;

        v(ReferenceQueue<K> r3, K r4, int r5, com.google.common.cache.g<K, V> r6) {
            com.google.common.cache.g<K, V> r7 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            super(r4, r3);
            this.i = LocalCache.o();
            this.g = r5;
            this.h = r7;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public int getHash() {
            return this.g;
        }

        @Override // com.google.common.cache.g
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNext() {
            return this.h;
        }

        public com.google.common.cache.g<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.g<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public r<K, V> getValueReference() {
            return this.i;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long r1) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r2) {
            com.google.common.cache.g r1 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.g
        public void setValueReference(r<K, V> r3) {
            this.i = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        }

        public void setWriteTime(long r1) {
            throw new UnsupportedOperationException();
        }
    }

    static class w<K, V> extends WeakReference<V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.g<K, V> f4348a;

        w(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5) {
            com.google.common.cache.g<K, V> r6 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
            super(r4, r3);
            this.f4348a = r6;
        }

        public int a() {
            return 1;
        }

        public r<K, V> a(ReferenceQueue<V> r2, V r3, com.google.common.cache.g<K, V> r4) {
            return new w(r2, r3, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.cache.LocalCache.r
        public void a(V r1) {
        }

        @Override // com.google.common.cache.LocalCache.r
        public com.google.common.cache.g<K, V> b() {
            return this.f4348a;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.r
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.r
        public V e() {
            return get();
        }
    }

    static final class x<K, V> extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f4349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.common.cache.g<K, V> f4350b;
        com.google.common.cache.g<K, V> c;

        x(ReferenceQueue<K> r3, K r4, int r5, com.google.common.cache.g<K, V> r6) {
            super(r3, r4, r5, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r6, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4349a = Long.MAX_VALUE;
            this.f4350b = LocalCache.p();
            this.c = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getNextInWriteQueue() {
            return this.f4350b;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public com.google.common.cache.g<K, V> getPreviousInWriteQueue() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public long getWriteTime() {
            return this.f4349a;
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setNextInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.f4350b = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setPreviousInWriteQueue(com.google.common.cache.g<K, V> r3) {
            this.c = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.LocalCache.v, com.google.common.cache.g
        public void setWriteTime(long r1) {
            this.f4349a = r1;
        }
    }

    static final class y<K, V> extends k<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4351b;

        y(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5, int r6) {
            super(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"));
            this.f4351b = r6;
        }

        @Override // com.google.common.cache.LocalCache.k, com.google.common.cache.LocalCache.r
        public int a() {
            return this.f4351b;
        }

        @Override // com.google.common.cache.LocalCache.k, com.google.common.cache.LocalCache.r
        public r<K, V> a(ReferenceQueue<V> r3, V r4, com.google.common.cache.g<K, V> r5) {
            return new y(r3, r4, (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r5, com.google.common.cache.g.class, "com.obric.memorydata.plugin"), this.f4351b);
        }
    }

    static final class z<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4352b;

        z(V r1, int r2) {
            super(r1);
            this.f4352b = r2;
        }

        @Override // com.google.common.cache.LocalCache.o, com.google.common.cache.LocalCache.r
        public int a() {
            return this.f4352b;
        }
    }

    static {
        f4314a = Logger.getLogger(LocalCache.class.getName());
        u = new AnonymousClass1();
        v = new AnonymousClass2();
    }

    LocalCache(CacheBuilder<? super K, ? super V> r12, CacheLoader<? super K, V> r13) {
        this.e = Math.min(r12.e(), 65536);
        Strength r0 = r12.h();
        this.h = r0;
        this.i = r12.i();
        this.f = r12.b();
        this.g = r12.c();
        long r1 = r12.f();
        this.j = r1;
        this.k = (com.google.common.cache.i<K, V>) r12.g();
        this.l = r12.k();
        this.m = r12.j();
        this.n = r12.l();
        CacheBuilder.NullListener r3 = (com.google.common.cache.h<K, V>) r12.m();
        this.p = r3;
        if (r3 != CacheBuilder.NullListener.INSTANCE) goto L5;
        Queue<RemovalNotification<K, V>> r4 = q();
    L6:
        this.o = r4;
        this.q = r12.a(j());
        this.r = EntryFactory.getFactory(r0, l(), k());
        this.s = (com.google.common.cache.a.b) ZeusTransformUtils.preCheckCast(r12.n().get(), com.google.common.cache.a.b.class, "com.obric.memorydata.plugin");
        this.t = r13;
        int r14 = Math.min(r12.d(), 1073741824);
        if (a() == true) goto L9;
    L11:
        int r2 = 0;
        int r5 = 1;
        int r6 = 0;
        int r7 = 1;
    L13:
        if (r7 >= this.e) goto L19;
        if (a() == false) goto L18;
        if ((r7 * 20) > this.j) goto L19;
    L18:
        r6 = r6 + 1;
        r7 = r7 << 1;
    L19:
        this.c = 32 - r6;
        this.f4315b = r7 - 1;
        this.d = c(r7);
        int r8 = r14 / r7;
        if ((r8 * r7) >= r14) goto L22;
        r8 = r8 + 1;
    L22:
        if (r5 >= r8) goto L25;
        r5 = r5 << 1;
        goto L22
    L25:
        if (a() == false) goto L33;
        long r9 = this.j;
        long r10 = r7;
        long r11 = (r9 / r10) + 1;
        long r15 = r9 % r10;
    L27:
        Segment<K, V>[] r16 = this.d;
        if (r2 >= r16.length) goto L36;
        if (r2 != r15) goto L32;
        r11 = r11 - 1;
    L32:
        r16[r2] = a(r5, r11, (com.google.common.cache.a.b) ZeusTransformUtils.preCheckCast(r12.n().get(), com.google.common.cache.a.b.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L27
    L36:
        return;
    L33:
        Segment<K, V>[] r17 = this.d;
        if (r2 >= r17.length) goto L47;
        r17[r2] = a(r5, -1, (com.google.common.cache.a.b) ZeusTransformUtils.preCheckCast(r12.n().get(), com.google.common.cache.a.b.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L33
    L47:
        return;
    L9:
        if (b() == true) goto L11;
        r14 = (int) Math.min(r14, r1);
        goto L11
    L5:
        r4 = new ConcurrentLinkedQueue();
        goto L6
    }

    static int a(int r2) {
        int r3 = r2 + ((r2 << 15) ^ (-12931));
        int r4 = r3 ^ (r3 >>> 10);
        int r5 = r4 + (r4 << 3);
        int r6 = r5 ^ (r5 >>> 6);
        int r7 = r6 + ((r6 << 2) + (r6 << 14));
        return r7 ^ (r7 >>> 16);
    }

    private static /* synthetic */ Object a(Object r1, BiFunction r2, Object r3, Object r4) {
        BiFunction r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return r1;
    L6:
        return r5.apply(r4, r1);
    }

    private static /* synthetic */ Object a(BiFunction r2, Object r3, Object r4) {
        BiFunction r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r2, BiFunction.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return r5.apply(r3, r4);
    }

    private static /* synthetic */ Object a(Function r1, Object r2, Object r3, Object r4) {
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r1, Function.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        return r4;
    L5:
        return r5.apply(r2);
    }

    static /* synthetic */ ArrayList a(Collection r2) {
        return b((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    static <K, V> void a(com.google.common.cache.g<K, V> r2, com.google.common.cache.g<K, V> r3) {
        com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        r4.setNextInAccessQueue(r5);
        r5.setPreviousInAccessQueue(r4);
    }

    private static <E> ArrayList<E> b(Collection<E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        ArrayList<E> r0 = new ArrayList(r3.size());
        Iterators.a(r0, r3.iterator());
        return r0;
    }

    static <K, V> void b(com.google.common.cache.g<K, V> r2) {
        com.google.common.cache.g r3 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        com.google.common.cache.g<K, V> r0 = p();
        r3.setNextInAccessQueue(r0);
        r3.setPreviousInAccessQueue(r0);
    }

    static <K, V> void b(com.google.common.cache.g<K, V> r2, com.google.common.cache.g<K, V> r3) {
        com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        r4.setNextInWriteQueue(r5);
        r5.setPreviousInWriteQueue(r4);
    }

    static <K, V> void c(com.google.common.cache.g<K, V> r2) {
        com.google.common.cache.g r3 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        com.google.common.cache.g<K, V> r0 = p();
        r3.setNextInWriteQueue(r0);
        r3.setPreviousInWriteQueue(r0);
    }

    /* JADX INFO: renamed from: lambda$-ceEhqjNEoLMwKFevjulP1nhvEw, reason: not valid java name */
    public static /* synthetic */ Object m122lambda$ceEhqjNEoLMwKFevjulP1nhvEw(Object r0, BiFunction r1, Object r2, Object r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object lambda$ExsCpHtp0pkXbL9YzyThqUuioPY(Function r0, Object r1, Object r2, Object r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object lambda$gFNHx4kLFLjX16bF1MVZaCnzc_o(BiFunction r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    static <K, V> r<K, V> o() {
        return (r<K, V>) u;
    }

    static <K, V> com.google.common.cache.g<K, V> p() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> q() {
        return (Queue<E>) v;
    }

    int a(Object r1) {
        return a(this.f.hash(r1));
    }

    Segment<K, V> a(int r7, long r8, com.google.common.cache.a.b r10) {
        return new Segment(this, r7, r8, (com.google.common.cache.a.b) ZeusTransformUtils.wrapperContextForParams(r10, com.google.common.cache.a.b.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> a(Iterable<?> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        ImmutableMap.a r0 = ImmutableMap.builder();
        Iterator r8 = r7.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r3 = r8.next();
        V r4 = get(r3);
        if (r4 == null) goto L7;
        r0.b(r3, r4);
        r1 = r1 + 1;
        goto L4
    L7:
        r2 = r2 + 1;
        goto L4
    L9:
        this.s.a(r1);
        this.s.b(r2);
        return r0.d();
    }

    V a(com.google.common.cache.g<K, V> r3, long r4) {
        com.google.common.cache.g<K, V> r5 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        if (r5.getKey() != null) goto L5;
        return null;
    L5:
        V r0 = r5.getValueReference().get();
        if (r0 != null) goto L9;
        return null;
    L9:
        if (b(r5, r4) == false) goto L11;
        return null;
    L11:
        return r0;
    }

    V a(K r2, CacheLoader<? super K, V> r3) {
        int r0 = a(com.google.common.base.n.a(r2));
        return b(r0).get(r2, r0, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Map<K, V> a(Set<? extends K> r8, CacheLoader<? super K, V> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r9);
        com.google.common.base.n.a(r10);
        com.google.common.base.p r0 = com.google.common.base.p.b();
        boolean r2 = true;
        boolean r3 = false;
        Map<? super K, V> r11 = r9.loadAll(r10);     // Catch: Throwable -> L22 Error -> L24 Exception -> L27 RuntimeException -> L30 InterruptedException -> L33 CacheLoader.UnsupportedLoadingOperationException -> L36
        if (r11 == null) goto L20;
        r0.d();
        Iterator<Map.Entry<K, V>> r4 = r11.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r6 = r5.getKey();
        Object r7 = r5.getValue();
        if (r6 == null) goto L13;
        if (r7 == null) goto L13;
        put(r6, r7);
    L13:
        r3 = true;
        goto L7
    L14:
        com.google.common.cache.a.b r12 = this.s;
        if (r3 == true) goto L18;
        r12.a(r0.a(TimeUnit.NANOSECONDS));
        return r11;
    L18:
        r12.b(r0.a(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r9 + " returned null keys or values from loadAll");
    L20:
        this.s.b(r0.a(TimeUnit.NANOSECONDS));
        throw new CacheLoader.InvalidCacheLoadException(r9 + " returned null map from loadAll");
    L22:
        th = th;
        r2 = false;
    L39:
        if (r2 == true) goto L41;
        this.s.b(r0.a(TimeUnit.NANOSECONDS));
    L41:
        throw th;
    L27:
        e = move-exception;
        throw new ExecutionException(e);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L22
        throw new ExecutionException(e);     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        throw new ExecutionError(e);     // Catch: Throwable -> L22
    L36:
        e = move-exception;
        throw e;     // Catch: Throwable -> L38
    L38:
        th = th;
    L30:
        e = move-exception;
        throw new UncheckedExecutionException(e);     // Catch: Throwable -> L22
    }

    void a(r<K, V> r3) {
        r<K, V> r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        com.google.common.cache.g<K, V> r0 = r4.b();
        int r1 = r0.getHash();
        b(r1).reclaimValue(r0.getKey(), r1, r4);
    }

    void a(com.google.common.cache.g<K, V> r3) {
        com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        int r0 = r4.getHash();
        b(r0).reclaimKey(r4, r0);
    }

    boolean a() {
        if (this.j < 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean a(BiPredicate<? super K, ? super V> r6) {
        BiPredicate r7 = (BiPredicate) ZeusTransformUtils.wrapperContextForParams(r6, BiPredicate.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        Iterator<K> r0 = keySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L14;
        K r2 = r0.next();
    L6:
        V r3 = get(r2);
        if (r3 == null) goto L4;
        if (r7.test(r2, r3) == false) goto L4;
        if (remove(r2, r3) == false) goto L6;
        r1 = true;
        goto L4
    L14:
        return r1;
    }

    Segment<K, V> b(int r3) {
        Segment<K, V>[] r0 = this.d;
        int r4 = r3 >>> this.c;
        return r0[this.f4315b & r4];
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> b(Iterable<? extends K> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r8, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = Maps.d();
        LinkedHashSet r1 = Sets.b();
        Iterator r10 = r9.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L31;
        Object r4 = r10.next();
        Object r5 = get(r4);
        if (r0.containsKey(r4) == true) goto L4;
        r0.put(r4, r5);
        if (r5 == null) goto L9;
        r2 = r2 + 1;
        goto L4
    L9:
        r3 = r3 + 1;
        r1.add(r4);
        goto L4
    L31:
    L28:
        th = move-exception;
        this.s.a(r2);
        this.s.b(r3);
        throw th;
    L12:
        if (r1.isEmpty() == false) goto L32;
    L25:
        ImmutableMap<K, V> r11 = ImmutableMap.copyOf(r0);     // Catch: Throwable -> L28
        this.s.a(r2);
        this.s.b(r3);
        return r11;
    L32:
        Map r12 = a(Collections.unmodifiableSet(r1), this.t);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        Iterator r6 = r1.iterator();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
    L15:
        if (r6.hasNext() == false) goto L25;
        Object r7 = r6.next();     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        Object r13 = r12.get(r7);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        if (r13 == null) goto L20;
        r0.put(r7, r13);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
        goto L15
    L20:
        throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + r7);     // Catch: CacheLoader.UnsupportedLoadingOperationException -> L21 Throwable -> L28
    L21:
        Iterator r14 = r1.iterator();     // Catch: Throwable -> L28
    L23:
        if (r14.hasNext() == false) goto L25;
        Object r15 = r14.next();     // Catch: Throwable -> L28
        r3 = r3 - 1;     // Catch: Throwable -> L28
        r0.put(r15, a(r15, this.t));     // Catch: Throwable -> L28
        goto L23
    }

    public V b(Object r3) {
        int r0 = a(com.google.common.base.n.a(r3));
        V r4 = b(r0).get(r3, r0);
        com.google.common.cache.a.b r2 = this.s;
        if (r4 != null) goto L5;
        r2.b(1);
    L6:
        return r4;
    L5:
        r2.a(1);
        goto L6
    }

    boolean b() {
        if (this.k == CacheBuilder.OneWeigher.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    boolean b(com.google.common.cache.g<K, V> r7, long r8) {
        com.google.common.cache.g r9 = (com.google.common.cache.g) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.cache.g.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r9);
        if (d() == false) goto L8;
        if ((r8 - r9.getAccessTime()) < this.l) goto L8;
        return true;
    L8:
        if (c() == true) goto L10;
        return false;
    L10:
        if ((r8 - r9.getWriteTime()) < this.m) goto L14;
        return true;
    L14:
        return false;
    }

    V c(K r2) {
        return a(r2, this.t);
    }

    void c(Iterable<?> r3) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        remove(r4.next());
        goto L4
    }

    boolean c() {
        if (this.m <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    final Segment<K, V>[] c(int r1) {
        return new Segment[r1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V>[] r3 = this.d;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].clear();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K r3, BiFunction<? super K, ? super V, ? extends V> r4) {
        BiFunction<? super K, ? super V, ? extends V> r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r5);
        int r0 = a(r3);
        return b(r0).compute(r3, r0, r5);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(final K r3, Function<? super K, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r5);
        return compute(r3, new $$Lambda$LocalCache$ExsCpHtp0pkXbL9YzyThqUuioPY(r5, r3));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K r3, BiFunction<? super K, ? super V, ? extends V> r4) {
        final BiFunction r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r5);
        return compute(r3, new $$Lambda$LocalCache$gFNHx4kLFLjX16bF1MVZaCnzc_o(r5));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        int r0 = a(r2);
        return b(r0).containsKey(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r19) {
        boolean r2 = false;
        if (r19 != null) goto L5;
        return false;
    L5:
        long r3 = this.q.a();
        Segment<K, V>[] r5 = this.d;
        long r6 = -1;
        int r8 = 0;
    L7:
        if (r8 >= 3) goto L29;
        long r9 = 0;
        int r11 = r5.length;
        ?? r12 = r2;
    L9:
        if (r12 >= r11) goto L24;
        Segment<K, V> r13 = r5[r12];
        int r14 = r13.count;
        AtomicReferenceArray<com.google.common.cache.g<K, V>> r15 = r13.table;
        ?? r16 = r2;
    L12:
        if (r16 >= r15.length()) goto L23;
        Segment<K, V>[] r17 = r5;
        int r18 = r11;
        com.google.common.cache.g<K, V> r4 = (com.google.common.cache.g) ZeusTransformUtils.preCheckCast(r15.get(r16), com.google.common.cache.g.class, "com.obric.memorydata.plugin");
    L14:
        if (r4 == null) goto L22;
        V r7 = r13.getLiveValue(r4, r3);
        if (r7 == null) goto L21;
        if (this.g.equivalent(r19, r7) == false) goto L21;
        return true;
    L21:
        r4 = r4.getNext();
        goto L14
    L22:
        r5 = r17;
        r11 = r18;
        r16 = r16 + 1;
        goto L12
    L23:
        r9 = r9 + ((long) r13.modCount);
        r2 = false;
        r12 = r12 + 1;
        goto L9
    L24:
        Segment<K, V>[] r110 = r5;
        if (r9 == r6) goto L26;
        r8 = r8 + 1;
        r6 = r9;
        r5 = r110;
        r2 = false;
        goto L7
    L26:
        return false;
    L29:
        return r2;
    }

    void d(K r4) {
        int r0 = a(com.google.common.base.n.a(r4));
        b(r0).refresh(r4, r0, this.t, false);
    }

    boolean d() {
        if (this.l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean e() {
        if (this.n <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.y;
        if (r0 != null) goto L7;
        f r1 = new f(this);
        this.y = r1;
        return r1;
    L7:
        return r0;
    }

    boolean f() {
        if (d() == false) goto L5;
    L8:
        return true;
    L5:
        if (a() == true) goto L8;
        return false;
    }

    boolean g() {
        return c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = a(r2);
        return b(r0).get(r2, r0);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object r1, V r2) {
        V r0 = get(r1);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    boolean h() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (e() == true) goto L8;
        return false;
    }

    boolean i() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] r10 = this.d;
        int r0 = r10.length;
        long r5 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        Segment<K, V> r7 = r10[r4];
        if (r7.count != 0) goto L6;
        r5 = r5 + ((long) r7.modCount);
        r4 = r4 + 1;
        goto L3
    L6:
        return false;
    L9:
        if (r5 == 0) goto L20;
        int r1 = r10.length;
        int r8 = 0;
    L11:
        if (r8 >= r1) goto L17;
        Segment<K, V> r9 = r10[r8];
        if (r9.count != 0) goto L14;
        r5 = r5 - ((long) r9.modCount);
        r8 = r8 + 1;
        goto L11
    L14:
        return false;
    L17:
        if (r5 == 0) goto L19;
        return false;
    L19:
        return true;
    L20:
        return true;
    }

    boolean j() {
        if (h() == false) goto L5;
    L8:
        return true;
    L5:
        if (i() == true) goto L8;
        return false;
    }

    boolean k() {
        if (g() == false) goto L5;
    L8:
        return true;
    L5:
        if (h() == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.w;
        if (r0 != null) goto L7;
        i r1 = new i(this);
        this.w = r1;
        return r1;
    L7:
        return r0;
    }

    boolean l() {
        if (f() == false) goto L5;
    L8:
        return true;
    L5:
        if (i() == true) goto L8;
        return false;
    }

    boolean m() {
        if (this.h == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V merge(K r3, final V r4, BiFunction<? super V, ? super V, ? extends V> r5) {
        final BiFunction r6 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r5, BiFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r6);
        return compute(r3, new $$Lambda$LocalCache$ceEhqjNEoLMwKFevjulP1nhvEw(r4, r6));
    }

    boolean n() {
        if (this.i == Strength.STRONG) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r3, V r4) {
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r4);
        int r0 = a(r3);
        return b(r0).put(r3, r0, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r3, V r4) {
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r4);
        int r0 = a(r3);
        return b(r0).put(r3, r0, r4, true);
    }

    void r() {
    L2:
        RemovalNotification<K, V> r0 = (RemovalNotification) ZeusTransformUtils.preCheckCast(this.o.poll(), RemovalNotification.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        this.p.onRemoval(r0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        f4314a.log(Level.WARNING, "Exception thrown by removal listener", th);
        goto L2
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = a(r2);
        return b(r0).remove(r2, r0);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r2, Object r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L9;
        int r0 = a(r2);
        return b(r0).remove(r2, r0, r3);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r2, V r3) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r3);
        int r0 = a(r2);
        return b(r0).replace(r2, r0, r3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r2, V r3, V r4) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r4);
        if (r3 != null) goto L6;
        return false;
    L6:
        int r0 = a(r2);
        return b(r0).replace(r2, r0, r3, r4);
    }

    public void s() {
        Segment<K, V>[] r3 = this.d;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].cleanUp();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.b(t());
    }

    long t() {
        Segment<K, V>[] r6 = this.d;
        int r0 = r6.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + ((long) r6[r3].count);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.x;
        if (r0 != null) goto L7;
        s r1 = new s(this);
        this.x = r1;
        return r1;
    L7:
        return r0;
    }
}
