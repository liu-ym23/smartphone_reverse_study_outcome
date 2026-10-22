package kotlinx.coroutines.debug.internal;

import com.bytedance.crash.entity.EventBody;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10339g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10340h = null;

    @Volatile
    private volatile int _size;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReferenceQueue<K> f10341c;

    @Volatile
    private volatile Object core;

    private final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f10342g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicReferenceArray f10346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicReferenceArray f10347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ConcurrentWeakMap<K, V> f10348f;

        @Volatile
        private volatile int load;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        @SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        private final class C0223a<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Function2<K, V, E> f10349c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f10350g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private K f10351h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private V f10352i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ ConcurrentWeakMap<K, V>.a f10353j;

            /* JADX WARN: Multi-variable type inference failed */
            public C0223a(a r10, Function2<? super K, ? super V, ? extends E> r11) {
                this.f10353j = r10;
                this.f10349c = r11;
                this.f10350g = -1;
                a();
            }

            private final void a() {
            L2:
                int r10 = this.f10350g + 1;
                this.f10350g = r10;
                if (r10 >= a.a(this.f10353j)) goto L23;
                d r11 = (d) a.b(this.f10353j).get(this.f10350g);
                if (r11 == null) goto L2;
                K r12 = (K) r11.get();
                if (r12 == null) goto L2;
                this.f10351h = r12;
                Object r13 = (V) a.c(this.f10353j).get(this.f10350g);
                if ((r13 instanceof e) == false) goto L12;
                r13 = (V) ((e) r13).f10375a;
            L12:
                if (r13 == null) goto L2;
                this.f10352i = (V) r13;
                return;
            }

            public Void b() {
                kotlinx.coroutines.debug.internal.a.c();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f10350g >= a.a(this.f10353j)) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public E next() {
                if (this.f10350g >= a.a(this.f10353j)) goto L13;
                Function2<K, V, E> r10 = this.f10349c;
                K r11 = this.f10351h;
                if (r11 == true) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("key");
                r11 = (K) Unit.INSTANCE;
            L7:
                V r12 = this.f10352i;
                if (r12 == true) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException(EventBody.KEY_VALUE);
                r12 = (V) Unit.INSTANCE;
            L10:
                E r13 = (E) r10.invoke(r11, r12);
                a();
                return r13;
            L13:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ void remove() {
                b();
            }
        }

        static {
            f10342g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");
        }

        public a(ConcurrentWeakMap r10, int r11) {
            this.f10348f = r10;
            this.f10343a = r11;
            this.f10344b = Integer.numberOfLeadingZeros(r11) + 1;
            this.f10345c = (r11 * 2) / 3;
            this.f10346d = new AtomicReferenceArray(r11);
            this.f10347e = new AtomicReferenceArray(r11);
        }

        public static final /* synthetic */ int a(a r10) {
            return r10.f10343a;
        }

        public static final /* synthetic */ AtomicReferenceArray b(a r10) {
            return r10.f10346d;
        }

        public static final /* synthetic */ AtomicReferenceArray c(a r10) {
            return r10.f10347e;
        }

        private final int f(int r10) {
            return (r10 * (-1640531527)) >>> this.f10344b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object i(a r10, Object r11, Object r12, d r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r13 = null;
        L6:
            return r10.h(r11, r12, r13);
        }

        private final void k(int r10) {
        L2:
            Object r11 = this.f10347e.get(r10);
            if (r11 == null) goto L4;
            if ((r11 instanceof e) == true) goto L7;
            if (this.f10347e.compareAndSet(r10, r11, null) == false) goto L2;
            ConcurrentWeakMap.a(this.f10348f);
            return;
        L7:
            return;
        }

        public final void d(d<?> r10) {
            int r11 = f(r10.f10374a);
        L3:
            d<?> r12 = (d) this.f10346d.get(r11);
            if (r12 == null) goto L5;
            if (r12 == r10) goto L7;
            if (r11 != 0) goto L11;
            r11 = this.f10343a;
        L11:
            r11 = r11 - 1;
            goto L3
        L7:
            k(r11);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V e(K r10) {
            int r11 = f(r10.hashCode());
        L3:
            d r12 = (d) this.f10346d.get(r11);
            if (r12 == null) goto L5;
            T r13 = r12.get();
            if (Intrinsics.areEqual(r10, r13) == true) goto L9;
            if (r13 != 0) goto L15;
            k(r11);
        L15:
            if (r11 != 0) goto L17;
            r11 = this.f10343a;
        L17:
            r11 = r11 - 1;
            goto L3
        L9:
            V r14 = (V) this.f10347e.get(r11);
            if ((r14 instanceof e) == true) goto L12;
            return r14;
        L12:
            return (V) ((e) r14).f10375a;
        L5:
            return null;
        }

        public final <E> Iterator<E> g(Function2<? super K, ? super V, ? extends E> r10) {
            return new C0223a(this, r10);
        }

        public final Object h(K r10, V r11, d<K> r12) {
            int r13 = f(r10.hashCode());
            boolean r14 = false;
        L3:
            d r15 = (d) this.f10346d.get(r13);
            if (r15 == null) goto L6;
            T r16 = r15.get();
            if (Intrinsics.areEqual(r10, r16) == true) goto L24;
            if (r16 != 0) goto L35;
            k(r13);
        L35:
            if (r13 != 0) goto L37;
            r13 = this.f10343a;
        L37:
            r13 = r13 - 1;
            goto L3
        L24:
            if (r14 == false) goto L26;
            f10342g.decrementAndGet(this);
        L26:
            Object r17 = this.f10347e.get(r13);
            if ((r17 instanceof e) == true) goto L29;
            if (this.f10347e.compareAndSet(r13, r17, r11) == false) goto L26;
            return r17;
        L29:
            return kotlinx.coroutines.debug.internal.a.a();
        L6:
            if (r11 == null) goto L7;
            if (r14 == true) goto L17;
            AtomicIntegerFieldUpdater r18 = f10342g;
        L10:
            int r19 = r18.get(this);
            if (r19 >= this.f10345c) goto L13;
            if (r18.compareAndSet(this, r19, r19 + 1) == false) goto L10;
            r14 = true;
            goto L17
        L13:
            return kotlinx.coroutines.debug.internal.a.a();
        L17:
            if (r12 != null) goto L20;
            r12 = new d(r10, ConcurrentWeakMap.c(this.f10348f));
        L20:
            if (this.f10346d.compareAndSet(r13, null, r12) == true) goto L26;
        L7:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.a j() {
        L2:
            int r10 = Integer.highestOneBit(RangesKt.coerceAtLeast(this.f10348f.size(), 4)) * 4;
            ConcurrentWeakMap<K, V>.a r11 = (ConcurrentWeakMap<K, V>.a) new a(this.f10348f, r10);
            int r12 = 0;
            int r13 = this.f10343a;
        L3:
            if (r12 >= r13) goto L21;
            d r14 = (d) this.f10346d.get(r12);
            if (r14 == null) goto L7;
            Object r15 = r14.get();
        L8:
            if (r14 == null) goto L11;
            if (r15 != null) goto L11;
            k(r12);
        L11:
            Object r16 = this.f10347e.get(r12);
            if ((r16 instanceof e) == true) goto L13;
            if (this.f10347e.compareAndSet(r12, r16, kotlinx.coroutines.debug.internal.a.b(r16)) == false) goto L11;
        L16:
            if (r15 == null) goto L20;
            if (r16 == null) goto L20;
            if (r11.h(r15, r16, r14) == kotlinx.coroutines.debug.internal.a.a()) goto L2;
        L20:
            r12 = r12 + 1;
            goto L3
        L13:
            r16 = ((e) r16).f10375a;
            goto L16
        L7:
            r15 = null;
            goto L8
        L21:
            return r11;
        }
    }

    private static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final K f10354c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final V f10355g;

        public b(K r10, V r11) {
            this.f10354c = r10;
            this.f10355g = r11;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f10354c;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f10355g;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }
    }

    private final class c<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function2<K, V, E> f10356c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ConcurrentWeakMap<K, V> f10357g;

        /* JADX WARN: Multi-variable type inference failed */
        public c(ConcurrentWeakMap r10, Function2<? super K, ? super V, ? extends E> r11) {
            this.f10357g = r10;
            this.f10356c = r11;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E r10) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return this.f10357g.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.b().get(this.f10357g)).g(this.f10356c);
        }
    }

    static {
        f10339g = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
        f10340h = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean r10) {
        this.core = new a(this, 16);
        if (r10 == false) goto L5;
        ReferenceQueue<K> r11 = new ReferenceQueue();
    L6:
        this.f10341c = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public /* synthetic */ ConcurrentWeakMap(boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = false;
    L5:
        this(r10);
    }

    public static final /* synthetic */ void a(ConcurrentWeakMap r10) {
        r10.e();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater b() {
        return f10340h;
    }

    public static final /* synthetic */ ReferenceQueue c(ConcurrentWeakMap r10) {
        return r10.f10341c;
    }

    private final void d(d<?> r10) {
        ((a) f10340h.get(this)).d(r10);
    }

    private final void e() {
        f10339g.decrementAndGet(this);
    }

    private final synchronized V f(K r10, V r11) {
        monitor-enter(this);
        a r12 = (a) f10340h.get(this);     // Catch: Throwable -> L10
    L4:
        V r13 = (V) a.i(r12, r10, r11, null, 4, null);
        if (r13 != kotlinx.coroutines.debug.internal.a.a()) goto L6;
        r12 = r12.j();     // Catch: Throwable -> L10
        f10340h.set(this, r12);     // Catch: Throwable -> L10
        goto L4
    L6:
        monitor-exit(this);
        return r13;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> r10 = keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        remove(r10.next());
        goto L4
    }

    public final void g() {
        if (this.f10341c == null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L12;
    L13:
        Reference<? extends K> r11 = this.f10341c.remove();     // Catch: InterruptedException -> L9
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L9
        d((d) r11);     // Catch: InterruptedException -> L9
    L9:
        Thread.currentThread().interrupt();
        return;
    L12:
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return (V) ((a) f10340h.get(this)).e(r10);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new c(this, ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new c(this, ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return f10339g.get(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r10, V r11) {
        V r12 = (V) a.i((a) f10340h.get(this), r10, r11, null, 4, null);
        if (r12 != kotlinx.coroutines.debug.internal.a.a()) goto L5;
        r12 = f(r10, r11);
    L5:
        if (r12 != null) goto L7;
        f10339g.incrementAndGet(this);
    L7:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r10) {
        if (r10 != 0) goto L5;
        return null;
    L5:
        V r11 = (V) a.i((a) f10340h.get(this), r10, null, null, 4, null);
        if (r11 != kotlinx.coroutines.debug.internal.a.a()) goto L8;
        r11 = f(r10, null);
    L8:
        if (r11 == null) goto L10;
        f10339g.decrementAndGet(this);
    L10:
        return r11;
    }
}
