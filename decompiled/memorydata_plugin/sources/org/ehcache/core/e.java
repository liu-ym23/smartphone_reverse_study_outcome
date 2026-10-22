package org.ehcache.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;
import org.ehcache.core.spi.store.Store;
import org.ehcache.core.statistics.BulkOps;
import org.ehcache.core.statistics.CacheOperationOutcomes;
import org.ehcache.spi.resilience.StoreAccessException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e<K, V> implements h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final org.slf4j.c f18016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final i f18017b;
    protected final Store<K, V> c;
    protected final org.ehcache.spi.resilience.b<K, V> d;
    protected final g<K, V> e;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.GetOutcome> f;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.GetAllOutcome> g;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.PutOutcome> h;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.PutAllOutcome> i;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.RemoveOutcome> j;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.RemoveAllOutcome> k;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.ConditionalRemoveOutcome> l;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.PutIfAbsentOutcome> m;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.ReplaceOutcome> n;
    protected final org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.ClearOutcome> o;
    protected final Map<BulkOps, LongAdder> p;

    /* JADX INFO: renamed from: org.ehcache.core.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18018a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f18019b = null;
        static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[Store.ReplaceStatus.values().length];
            c = r0;
            r0[Store.ReplaceStatus.HIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            c[Store.ReplaceStatus.MISS_PRESENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L32:
            c[Store.ReplaceStatus.MISS_NOT_PRESENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            int[] r3 = new int[Store.RemoveStatus.values().length];
            f18019b = r3;
            r3[Store.RemoveStatus.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L38:
            f18019b[Store.RemoveStatus.KEY_MISSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L24:
            f18019b[Store.RemoveStatus.KEY_PRESENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L12:
            int[] r2 = new int[Store.PutStatus.values().length];
            f18018a = r2;
            r2[Store.PutStatus.PUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L30:
            f18018a[Store.PutStatus.NOOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    private class a implements Iterator<org.ehcache.a.InterfaceC0893a<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f18020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Store.b<org.ehcache.a.InterfaceC0893a<K, Store.d<V>>> f18021b;
        private org.ehcache.a.InterfaceC0893a<K, Store.d<V>> c;
        private org.ehcache.a.InterfaceC0893a<K, Store.d<V>> d;
        private StoreAccessException e;

        public a(e r1) {
            this.f18020a = r1;
            this.f18021b = r1.c.c();
            b();
        }

        private void b() {
        L16:
        L12:
            e = move-exception;
            this.e = new StoreAccessException(e);
        L14:
            this.d = null;
            return;
        L10:
            e = move-exception;
            this.e = e;
            goto L14
        L4:
            if (this.f18021b.a() == false) goto L8;
            org.ehcache.a.InterfaceC0893a<K, Store.d<V>> r1 = (org.ehcache.a.InterfaceC0893a) ZeusTransformUtils.preCheckCast(this.f18021b.b(), org.ehcache.a.InterfaceC0893a.class, "com.obric.memorydata.plugin");     // Catch: StoreAccessException -> L10 RuntimeException -> L12
            this.d = r1;     // Catch: StoreAccessException -> L10 RuntimeException -> L12
            if (r1 == null) goto L16;
            return;
        L8:
            this.d = null;     // Catch: StoreAccessException -> L10 RuntimeException -> L12
        }

        public org.ehcache.a.InterfaceC0893a<K, V> a() {
            if (hasNext() == false) goto L11;
            this.f18020a.f.a();
            if (this.e != null) goto L8;
            this.f18020a.f.a(CacheOperationOutcomes.GetOutcome.HIT);
            this.c = this.d;
            b();
            return new b(this.c);
        L8:
            this.f18020a.f.a(CacheOperationOutcomes.GetOutcome.FAILURE);
            StoreAccessException r0 = this.e;
            this.e = null;
            return this.f18020a.d.a(r0);
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            this.f18020a.f18017b.c();
            if (this.e == null) goto L5;
        L8:
            return true;
        L5:
            if (this.d != null) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            this.f18020a.f18017b.c();
            org.ehcache.a.InterfaceC0893a<K, Store.d<V>> r0 = this.c;
            if (r0 == null) goto L7;
            this.f18020a.d(r0.a(), ((Store.d) ZeusTransformUtils.preCheckCast(this.c.b(), Store.d.class, "com.obric.memorydata.plugin")).get());
            this.c = null;
            return;
        L7:
            throw new IllegalStateException("No current element");
        }
    }

    private static class b<K, V> implements org.ehcache.a.InterfaceC0893a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.ehcache.a.InterfaceC0893a<K, Store.d<V>> f18022a;

        b(org.ehcache.a.InterfaceC0893a<K, Store.d<V>> r3) {
            this.f18022a = (org.ehcache.a.InterfaceC0893a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.a.InterfaceC0893a.class, "com.obric.memorydata.plugin");
        }

        @Override // org.ehcache.a.InterfaceC0893a
        public K a() {
            return this.f18022a.a();
        }

        @Override // org.ehcache.a.InterfaceC0893a
        public V b() {
            return (V) ((Store.d) ZeusTransformUtils.preCheckCast(this.f18022a.b(), Store.d.class, "com.obric.memorydata.plugin")).get();
        }
    }

    e(g<K, V> r5, Store<K, V> r6, org.ehcache.spi.resilience.b<K, V> r7, org.ehcache.core.b.a<K, V> r8, org.slf4j.c r9, i r10) {
        Store<K, V> r11 = (Store) ZeusTransformUtils.wrapperContextForParams(r6, Store.class, "com.obric.memorydata.plugin");
        org.ehcache.spi.resilience.b<K, V> r12 = (org.ehcache.spi.resilience.b) ZeusTransformUtils.wrapperContextForParams(r7, org.ehcache.spi.resilience.b.class, "com.obric.memorydata.plugin");
        org.ehcache.core.b.a r13 = (org.ehcache.core.b.a) ZeusTransformUtils.wrapperContextForParams(r8, org.ehcache.core.b.a.class, "com.obric.memorydata.plugin");
        org.slf4j.c r14 = (org.slf4j.c) ZeusTransformUtils.wrapperContextForParams(r9, org.slf4j.c.class, "com.obric.memorydata.plugin");
        this.f = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.GetOutcome.class).a("get"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.g = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.GetAllOutcome.class).a("getAll"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.h = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.PutOutcome.class).a("put"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.i = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.PutAllOutcome.class).a("putAll"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.j = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.RemoveOutcome.class).a("remove"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.k = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.RemoveAllOutcome.class).a("removeAll"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.l = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.ConditionalRemoveOutcome.class).a("conditionalRemove"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.m = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.PutIfAbsentOutcome.class).a("putIfAbsent"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.n = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.ReplaceOutcome.class).a("replace"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.o = ((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(((org.ehcache.shadow.org.terracotta.statistics.h.b) ZeusTransformUtils.preCheckCast(org.ehcache.shadow.org.terracotta.statistics.h.a(CacheOperationOutcomes.ClearOutcome.class).a("clear"), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(this), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a(new String[]{"cache"}), org.ehcache.shadow.org.terracotta.statistics.h.b.class, "com.obric.memorydata.plugin")).a();
        this.p = new EnumMap(BulkOps.class);
        this.c = r11;
        r5.a(r11.a());
        org.ehcache.shadow.org.terracotta.statistics.i.a(r11).b(this);
        this.d = r12;
        this.e = r5;
        r5.a(r13.a());
        this.f18016a = r14;
        this.f18017b = r10;
        BulkOps[] r15 = BulkOps.values();
        int r16 = r15.length;
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L5;
        BulkOps r18 = r15[r17];
        this.p.put(r18, new LongAdder());
        r17 = r17 + 1;
        goto L3
    }

    public static void a(Object... r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        c(r3[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public static void c(Object r0) {
        Objects.requireNonNull(r0);
    }

    @Override // org.ehcache.a
    public V a(K r4) {
        this.f.a();
        this.f18017b.c();     // Catch: Throwable -> L13
        c(r4);     // Catch: Throwable -> L13
        Store.d<V> r0 = b(r4);     // Catch: StoreAccessException -> L10 Throwable -> L13
        if (r0 != null) goto L8;
        this.f.a(CacheOperationOutcomes.GetOutcome.MISS);     // Catch: StoreAccessException -> L10 Throwable -> L13
        return null;
    L8:
        this.f.a(CacheOperationOutcomes.GetOutcome.HIT);     // Catch: StoreAccessException -> L10 Throwable -> L13
        return r0.get();
    L10:
        e = move-exception;
        V r5 = this.d.a(r4, e);     // Catch: Throwable -> L13
        this.f.a(CacheOperationOutcomes.GetOutcome.FAILURE);     // Catch: Throwable -> L13
        return r5;
    L13:
        th = move-exception;
        this.f.a(CacheOperationOutcomes.GetOutcome.FAILURE);
        throw th;
    }

    @Override // org.ehcache.a
    public org.ehcache.config.c<K, V> a() {
        return this.e;
    }

    @Override // org.ehcache.a
    public void a(K r5, V r6) {
        this.h.a();
        this.f18017b.c();     // Catch: Throwable -> L16
        a(new Object[]{r5, r6});     // Catch: Throwable -> L16
        int r1 = AnonymousClass1.f18018a[b(r5, r6).ordinal()];     // Catch: StoreAccessException -> L13 Throwable -> L16
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        org.ehcache.shadow.org.terracotta.statistics.a.b<CacheOperationOutcomes.PutOutcome> r0 = this.h;     // Catch: StoreAccessException -> L13 Throwable -> L16
        CacheOperationOutcomes.PutOutcome r2 = CacheOperationOutcomes.PutOutcome.NOOP;     // Catch: StoreAccessException -> L13 Throwable -> L16
    L8:
        r0.a(r2);     // Catch: StoreAccessException -> L13 Throwable -> L16
        return;
    L10:
        throw new AssertionError("Invalid Status.");     // Catch: StoreAccessException -> L13 Throwable -> L16
    L11:
        r0 = this.h;     // Catch: StoreAccessException -> L13 Throwable -> L16
        r2 = CacheOperationOutcomes.PutOutcome.PUT;     // Catch: StoreAccessException -> L13 Throwable -> L16
    L13:
        e = move-exception;
        this.d.a(r5, r6, e);     // Catch: Throwable -> L16
        this.h.a(CacheOperationOutcomes.PutOutcome.FAILURE);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        this.h.a(CacheOperationOutcomes.PutOutcome.FAILURE);
        throw th;
    }

    @Override // org.ehcache.core.h
    public void a(org.ehcache.core.spi.a r3) {
        org.ehcache.core.spi.a r4 = (org.ehcache.core.spi.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.class, "com.obric.memorydata.plugin");
        this.f18017b.a(r4);
    }

    public abstract Store.PutStatus b(K r1, V r2);

    public abstract Store.d<V> b(K r1);

    @Override // org.ehcache.d
    public void b() {
        this.f18017b.d().a();
    }

    public abstract Store.RemoveStatus c(K r1, V r2);

    @Override // org.ehcache.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18017b.e().a();
    }

    public boolean d(K r7, V r8) {
        this.l.a();
        this.f18017b.c();     // Catch: Throwable -> L20
        a(new Object[]{r7, r8});     // Catch: Throwable -> L20
        Store.RemoveStatus r1 = c(r7, r8);     // Catch: StoreAccessException -> L17 Throwable -> L20
        int r4 = AnonymousClass1.f18019b[r1.ordinal()];     // Catch: StoreAccessException -> L17 Throwable -> L20
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L8;
        this.l.a(CacheOperationOutcomes.ConditionalRemoveOutcome.FAILURE_KEY_MISSING);     // Catch: StoreAccessException -> L17 Throwable -> L20
        return false;
    L8:
        if (r4 != 3) goto L12;
        this.l.a(CacheOperationOutcomes.ConditionalRemoveOutcome.FAILURE_KEY_PRESENT);     // Catch: StoreAccessException -> L17 Throwable -> L20
        return false;
    L12:
        throw new AssertionError("Invalid Status: " + r1);     // Catch: StoreAccessException -> L17 Throwable -> L20
    L15:
        this.l.a(CacheOperationOutcomes.ConditionalRemoveOutcome.SUCCESS);     // Catch: StoreAccessException -> L17 Throwable -> L20
        return true;
    L17:
        e = move-exception;
        boolean r9 = this.d.b(r7, r8, e);     // Catch: Throwable -> L20
        this.l.a(CacheOperationOutcomes.ConditionalRemoveOutcome.FAILURE);     // Catch: Throwable -> L20
        return r9;
    L20:
        th = move-exception;
        this.l.a(CacheOperationOutcomes.ConditionalRemoveOutcome.FAILURE);
        throw th;
    }

    @Override // java.lang.Iterable
    public Iterator<org.ehcache.a.InterfaceC0893a<K, V>> iterator() {
        this.f18017b.c();
        return new a(this);
    }
}
