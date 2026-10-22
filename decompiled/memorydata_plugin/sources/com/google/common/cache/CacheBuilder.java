package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.base.r;
import com.google.common.base.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheBuilder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final r<? extends a.b> f4310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final c f4311b = null;
    static final r<a.b> c = null;
    static final t d = null;
    private static final Logger u = null;
    boolean e;
    int f;
    int g;
    long h;
    long i;
    i<? super K, ? super V> j;
    LocalCache.Strength k;
    LocalCache.Strength l;
    long m;
    long n;
    long o;
    Equivalence<Object> p;
    Equivalence<Object> q;
    h<? super K, ? super V> r;
    t s;
    r<? extends a.b> t;

    static final enum NullListener extends Enum<NullListener> implements h<Object, Object> {
        private static final /* synthetic */ NullListener[] $VALUES = null;
        public static final NullListener INSTANCE = null;

        private static /* synthetic */ NullListener[] $values() {
            return new NullListener[]{INSTANCE};
        }

        static {
            INSTANCE = new NullListener("INSTANCE", 0);
            $VALUES = $values();
        }

        private NullListener(String r1, int r2) {
            super(r1, r2);
        }

        public static NullListener valueOf(String r2) {
            return (NullListener) ZeusTransformUtils.preCheckCast(Enum.valueOf(NullListener.class, r2), NullListener.class, "com.obric.memorydata.plugin");
        }

        public static NullListener[] values() {
            return (NullListener[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NullListener[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.h
        public void onRemoval(RemovalNotification<Object, Object> r1) {
        }
    }

    static final enum OneWeigher extends Enum<OneWeigher> implements i<Object, Object> {
        private static final /* synthetic */ OneWeigher[] $VALUES = null;
        public static final OneWeigher INSTANCE = null;

        private static /* synthetic */ OneWeigher[] $values() {
            return new OneWeigher[]{INSTANCE};
        }

        static {
            INSTANCE = new OneWeigher("INSTANCE", 0);
            $VALUES = $values();
        }

        private OneWeigher(String r1, int r2) {
            super(r1, r2);
        }

        public static OneWeigher valueOf(String r2) {
            return (OneWeigher) ZeusTransformUtils.preCheckCast(Enum.valueOf(OneWeigher.class, r2), OneWeigher.class, "com.obric.memorydata.plugin");
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OneWeigher[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.cache.i
        public int weigh(Object r1, Object r2) {
            return 1;
        }
    }

    static {
        f4310a = Suppliers.a(new AnonymousClass1());
        f4311b = new c(0, 0, 0, 0, 0, 0);
        c = $$Lambda$CacheBuilder$dtClhAEkMikrY4B2dtGv5AoRGXQ.INSTANCE;
        d = new AnonymousClass2();
        u = Logger.getLogger(CacheBuilder.class.getName());
    }

    private CacheBuilder() {
        this.e = true;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.t = f4310a;
    }

    public static CacheBuilder<Object, Object> a() {
        return new CacheBuilder();
    }

    public static /* synthetic */ a.b lambda$dtClhAEkMikrY4B2dtGv5AoRGXQ() {
        return r();
    }

    private void p() {
        if (this.o != (-1)) goto L5;
        boolean r4 = true;
    L6:
        n.b(r4, "refreshAfterWrite requires a LoadingCache");
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void q() {
        boolean r1 = true;
        if (this.j != null) goto L11;
        if (this.i == (-1)) goto L8;
        r1 = false;
    L8:
        String r7 = "maximumWeight requires weigher";
    L9:
        n.b(r1, r7);
        return;
    L11:
        if (this.e == false) goto L18;
        if (this.i != (-1)) goto L16;
        r1 = false;
    L16:
        r7 = "weigher requires maximumWeight";
        goto L9
    L18:
        if (this.i != (-1)) goto L22;
        u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        return;
    }

    private static /* synthetic */ a.b r() {
        return new a.C0193a();
    }

    t a(boolean r1) {
        t r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r1 == false) goto L8;
        return t.b();
    L8:
        return d;
    }

    public CacheBuilder<K, V> a(int r6) {
        int r0 = this.g;
        boolean r1 = true;
        if (r0 != (-1)) goto L5;
        boolean r3 = true;
    L6:
        n.b(r3, "concurrency level was already set to %s", r0);
        if (r6 > 0) goto L10;
        r1 = false;
    L10:
        n.a(r1);
        this.g = r6;
        return this;
    L5:
        r3 = false;
        goto L6
    }

    public CacheBuilder<K, V> a(long r9) {
        long r0 = this.h;
        boolean r5 = true;
        if (r0 != (-1)) goto L5;
        boolean r4 = true;
    L6:
        n.b(r4, "maximum size was already set to %s", r0);
        long r1 = this.i;
        if (r1 != (-1)) goto L9;
        boolean r2 = true;
    L10:
        n.b(r2, "maximum weight was already set to %s", r1);
        if (this.j != null) goto L13;
        boolean r3 = true;
    L14:
        n.b(r3, "maximum size can not be combined with weigher");
        if (r9 >= 0) goto L18;
        r5 = false;
    L18:
        n.a(r5, "maximum size must not be negative");
        this.h = r9;
        return this;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public CacheBuilder<K, V> a(long r7, TimeUnit r9) {
        long r0 = this.m;
        boolean r3 = true;
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        n.b(r2, "expireAfterWrite was already set to %s ns", r0);
        if (r7 >= 0) goto L10;
        r3 = false;
    L10:
        n.a(r3, "duration cannot be negative: %s %s", r7, r9);
        this.m = r9.toNanos(r7);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    CacheBuilder<K, V> a(Equivalence<Object> r4) {
        Equivalence<Object> r0 = this.p;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        n.b(r1, "key equivalence was already set to %s", r0);
        this.p = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r4), Equivalence.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r1 = false;
        goto L6
    }

    public CacheBuilder<K, V> a(t r3) {
        if (this.s != null) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        this.s = (t) ZeusTransformUtils.preCheckCast(n.a(r3), t.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    CacheBuilder<K, V> a(LocalCache.Strength r4) {
        LocalCache.Strength r0 = this.k;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        n.b(r1, "Key strength was already set to %s", r0);
        this.k = (LocalCache.Strength) ZeusTransformUtils.preCheckCast(n.a(r4), LocalCache.Strength.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(h<? super K1, ? super V1> r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        if (this.r != null) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        this.r = (h) ZeusTransformUtils.preCheckCast(n.a(r4), h.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(i<? super K1, ? super V1> r9) {
        i r10 = (i) ZeusTransformUtils.wrapperContextForParams(r9, i.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (this.j != null) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        if (this.e == false) goto L13;
        long r4 = this.h;
        if (r4 == (-1)) goto L12;
        r2 = false;
    L12:
        n.b(r2, "weigher can not be combined with maximum size (%s provided)", r4);
    L13:
        this.j = (i) ZeusTransformUtils.preCheckCast(n.a(r10), i.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public <K1 extends K, V1 extends V> e<K1, V1> a(CacheLoader<? super K1, V1> r2) {
        q();
        return new LocalCache.LocalLoadingCache(this, r2);
    }

    Equivalence<Object> b() {
        return (Equivalence) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.p, h().defaultEquivalence()), Equivalence.class, "com.obric.memorydata.plugin");
    }

    public CacheBuilder<K, V> b(long r9) {
        long r0 = this.i;
        boolean r5 = true;
        if (r0 != (-1)) goto L5;
        boolean r4 = true;
    L6:
        n.b(r4, "maximum weight was already set to %s", r0);
        long r1 = this.h;
        if (r1 != (-1)) goto L9;
        boolean r2 = true;
    L10:
        n.b(r2, "maximum size was already set to %s", r1);
        if (r9 >= 0) goto L14;
        r5 = false;
    L14:
        n.a(r5, "maximum weight must not be negative");
        this.i = r9;
        return this;
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public CacheBuilder<K, V> b(long r7, TimeUnit r9) {
        long r0 = this.n;
        boolean r3 = true;
        if (r0 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        n.b(r2, "expireAfterAccess was already set to %s ns", r0);
        if (r7 >= 0) goto L10;
        r3 = false;
    L10:
        n.a(r3, "duration cannot be negative: %s %s", r7, r9);
        this.n = r9.toNanos(r7);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    CacheBuilder<K, V> b(Equivalence<Object> r4) {
        Equivalence<Object> r0 = this.q;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        n.b(r1, "value equivalence was already set to %s", r0);
        this.q = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r4), Equivalence.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r1 = false;
        goto L6
    }

    CacheBuilder<K, V> b(LocalCache.Strength r4) {
        LocalCache.Strength r0 = this.l;
        if (r0 != null) goto L5;
        boolean r1 = true;
    L6:
        n.b(r1, "Value strength was already set to %s", r0);
        this.l = (LocalCache.Strength) ZeusTransformUtils.preCheckCast(n.a(r4), LocalCache.Strength.class, "com.obric.memorydata.plugin");
        return this;
    L5:
        r1 = false;
        goto L6
    }

    Equivalence<Object> c() {
        return (Equivalence) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.q, i().defaultEquivalence()), Equivalence.class, "com.obric.memorydata.plugin");
    }

    int d() {
        int r1 = this.f;
        if (r1 != (-1)) goto L6;
        return 16;
    L6:
        return r1;
    }

    int e() {
        int r1 = this.g;
        if (r1 != (-1)) goto L6;
        return 4;
    L6:
        return r1;
    }

    long f() {
        if (this.m != 0) goto L5;
    L12:
        return 0;
    L5:
        if (this.n == 0) goto L12;
        if (this.j != null) goto L11;
        return this.h;
    L11:
        return this.i;
    }

    <K1 extends K, V1 extends V> i<K1, V1> g() {
        return (i) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.j, OneWeigher.INSTANCE), i.class, "com.obric.memorydata.plugin");
    }

    LocalCache.Strength h() {
        return (LocalCache.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.k, LocalCache.Strength.STRONG), LocalCache.Strength.class, "com.obric.memorydata.plugin");
    }

    LocalCache.Strength i() {
        return (LocalCache.Strength) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.l, LocalCache.Strength.STRONG), LocalCache.Strength.class, "com.obric.memorydata.plugin");
    }

    long j() {
        long r0 = this.m;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    long k() {
        long r0 = this.n;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    long l() {
        long r0 = this.o;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    <K1 extends K, V1 extends V> h<K1, V1> m() {
        return (h) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a(this.r, NullListener.INSTANCE), h.class, "com.obric.memorydata.plugin");
    }

    r<? extends a.b> n() {
        return this.t;
    }

    public <K1 extends K, V1 extends V> b<K1, V1> o() {
        q();
        p();
        return new LocalCache.LocalManualCache(this);
    }

    public String toString() {
        com.google.common.base.i.a r0 = com.google.common.base.i.a(this);
        int r1 = this.f;
        if (r1 == (-1)) goto L5;
        r0.a("initialCapacity", r1);
    L5:
        int r2 = this.g;
        if (r2 == (-1)) goto L8;
        r0.a("concurrencyLevel", r2);
    L8:
        long r3 = this.h;
        if (r3 == (-1)) goto L11;
        r0.a("maximumSize", r3);
    L11:
        long r4 = this.i;
        if (r4 == (-1)) goto L15;
        r0.a("maximumWeight", r4);
    L15:
        if (this.m == (-1)) goto L18;
        r0.a("expireAfterWrite", this.m + "ns");
    L18:
        if (this.n == (-1)) goto L20;
        r0.a("expireAfterAccess", this.n + "ns");
    L20:
        LocalCache.Strength r5 = this.k;
        if (r5 == null) goto L23;
        r0.a("keyStrength", com.google.common.base.a.a(r5.toString()));
    L23:
        LocalCache.Strength r6 = this.l;
        if (r6 == null) goto L27;
        r0.a("valueStrength", com.google.common.base.a.a(r6.toString()));
    L27:
        if (this.p == null) goto L30;
        r0.a("keyEquivalence");
    L30:
        if (this.q == null) goto L33;
        r0.a("valueEquivalence");
    L33:
        if (this.r == null) goto L36;
        r0.a("removalListener");
    L36:
        return r0.toString();
    }
}
