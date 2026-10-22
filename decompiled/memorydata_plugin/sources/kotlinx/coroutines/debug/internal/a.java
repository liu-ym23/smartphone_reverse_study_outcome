package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003()*B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010$J!\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u00002\b\u0010#\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010$J\u0017\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0006\u0010'\u001a\u00020\u001aR\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u001f\u0010\n\u001a\u0018\u0012\u0014\u0012\u00120\fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000bX\u0082\u0004R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "weakRefQueue", "", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "Ljava/lang/ref/ReferenceQueue;", "cleanWeakRef", "", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "clear", "decrementSize", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", EventBody.KEY_VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a<K, V> extends AbstractMutableMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17311b = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReferenceQueue<K> f17312a;
    private volatile /* synthetic */ Object core$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0002\u0010\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00170\u0019J1\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006X\u0082\u0004R\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "load", "Lkotlinx/atomicfu/AtomicInt;", "shift", "threshold", "values", "cleanWeakRef", "", "weakRef", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "hash", "keyValueIterator", "", ExifInterface.LONGITUDE_EAST, "factory", "Lkotlin/Function2;", "putImpl", EventBody.KEY_VALUE, "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "removeCleanedAt", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class C0879a {
        private static final /* synthetic */ AtomicIntegerFieldUpdater g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<K, V> f17313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17314b;
        private final int c;
        private final int d;
        private final /* synthetic */ AtomicReferenceArray e;
        private final /* synthetic */ AtomicReferenceArray f;
        private volatile /* synthetic */ int load$volatile;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00028\u0001X\u0082.¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", ExifInterface.LONGITUDE_EAST, "", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", EventBody.KEY_VALUE, "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private final class C0880a<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a<K, V>.C0879a f17315a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Function2<K, V, E> f17316b;
            private int c;
            private K d;
            private V e;

            public C0880a(C0879a r3, Function2<? super K, ? super V, ? extends E> r4) {
                Function2<K, V, E> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17315a = r3;
                this.f17316b = r5;
                this.c = -1;
                b();
            }

            private final void b() {
            L2:
                int r0 = this.c + 1;
                this.c = r0;
                if (r0 >= C0879a.a(this.f17315a)) goto L23;
                f r1 = (f) ZeusTransformUtils.preCheckCast(C0879a.b(this.f17315a).get(this.c), f.class, "com.obric.memorydata.plugin");
                if (r1 == null) goto L2;
                K r2 = (K) r1.get();
                if (r2 == null) goto L2;
                this.d = r2;
                V r3 = (V) C0879a.c(this.f17315a).get(this.c);
                if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L12;
                r3 = (V) ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).f17334a;
            L12:
                if (r3 == null) goto L2;
                this.e = r3;
                return;
            }

            public Void a() {
                kotlinx.coroutines.debug.internal.b.b();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.c >= C0879a.a(this.f17315a)) goto L5;
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
                if (this.c >= C0879a.a(this.f17315a)) goto L13;
                Function2<K, V, E> r0 = this.f17316b;
                K r1 = this.d;
                if (r1 == true) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("key");
                r1 = (K) Unit.INSTANCE;
            L7:
                V r2 = this.e;
                if (r2 == true) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException(EventBody.KEY_VALUE);
                r2 = (V) Unit.INSTANCE;
            L10:
                E r3 = (E) r0.invoke(r1, r2);
                b();
                return r3;
            L13:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public /* synthetic */ void remove() {
                a();
            }
        }

        static {
            g = AtomicIntegerFieldUpdater.newUpdater(C0879a.class, "load$volatile");
        }

        public C0879a(a r1, int r2) {
            this.f17313a = r1;
            this.f17314b = r2;
            this.c = Integer.numberOfLeadingZeros(r2) + 1;
            this.d = (r2 * 2) / 3;
            this.e = new AtomicReferenceArray(r2);
            this.f = new AtomicReferenceArray(r2);
        }

        private final int a(int r2) {
            return (r2 * (-1640531527)) >>> this.c;
        }

        public static final /* synthetic */ int a(C0879a r0) {
            return r0.f17314b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(C0879a r0, Object r1, Object r2, f r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            return r0.a(r1, r2, r3);
        }

        private final /* synthetic */ AtomicReferenceArray b() {
            return this.e;
        }

        public static final /* synthetic */ AtomicReferenceArray b(C0879a r0) {
            return r0.b();
        }

        private final void b(int r4) {
        L2:
            Object r0 = c().get(r4);
            if (r0 == null) goto L4;
            if (ZeusTransformUtils.instanceOf(r0, g.class) == true) goto L7;
            if (c().compareAndSet(r4, r0, null) == false) goto L2;
            a.a(this.f17313a);
            return;
        L7:
            return;
        }

        private final /* synthetic */ AtomicReferenceArray c() {
            return this.f;
        }

        public static final /* synthetic */ AtomicReferenceArray c(C0879a r0) {
            return r0.c();
        }

        private static final /* synthetic */ AtomicIntegerFieldUpdater d() {
            return g;
        }

        public final V a(K r5) {
            int r0 = a(r5.hashCode());
        L3:
            f r1 = (f) ZeusTransformUtils.preCheckCast(b().get(r0), f.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L5;
            Object r2 = r1.get();
            if (Intrinsics.areEqual(r5, r2) == true) goto L9;
            if (r2 != null) goto L15;
            b(r0);
        L15:
            if (r0 != 0) goto L17;
            r0 = this.f17314b;
        L17:
            r0 = r0 - 1;
            goto L3
        L9:
            V r4 = (V) c().get(r0);
            if (ZeusTransformUtils.instanceOf(r4, g.class) == true) goto L12;
            return r4;
        L12:
            return (V) ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).f17334a;
        L5:
            return null;
        }

        public final Object a(K r6, V r7, f<K> r8) {
            int r0 = a(r6.hashCode());
            boolean r1 = false;
        L3:
            f r2 = (f) ZeusTransformUtils.preCheckCast(b().get(r0), f.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            Object r3 = r2.get();
            if (Intrinsics.areEqual(r6, r3) == true) goto L24;
            if (r3 != null) goto L35;
            b(r0);
        L35:
            if (r0 != 0) goto L37;
            r0 = this.f17314b;
        L37:
            r0 = r0 - 1;
            goto L3
        L24:
            if (r1 == false) goto L26;
            d().decrementAndGet(this);
        L26:
            Object r9 = c().get(r0);
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L29;
            if (c().compareAndSet(r0, r9, r7) == false) goto L26;
            return r9;
        L29:
            return kotlinx.coroutines.debug.internal.b.a();
        L6:
            if (r7 == null) goto L7;
            if (r1 == true) goto L17;
            AtomicIntegerFieldUpdater r4 = d();
        L10:
            int r5 = r4.get(this);
            if (r5 >= this.d) goto L13;
            if (r4.compareAndSet(this, r5, r5 + 1) == false) goto L10;
            r1 = true;
            goto L17
        L13:
            return kotlinx.coroutines.debug.internal.b.a();
        L17:
            if (r8 != null) goto L20;
            r8 = new f(r6, a.b(this.f17313a));
        L20:
            if (b().compareAndSet(r0, null, r8) == true) goto L26;
        L7:
            return null;
        }

        public final <E> Iterator<E> a(Function2<? super K, ? super V, ? extends E> r3) {
            return (Iterator) ZeusTransformUtils.preCheckCast(new C0880a(this, (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin")), Iterator.class, "com.obric.memorydata.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a<K, V>.C0879a a() {
        L2:
            int r0 = Integer.highestOneBit(RangesKt.coerceAtLeast(this.f17313a.size(), 4)) * 4;
            a<K, V>.C0879a r1 = (a<K, V>.C0879a) new C0879a(this.f17313a, r0);
            int r2 = 0;
            int r3 = this.f17314b;
        L3:
            if (r2 >= r3) goto L21;
            f r4 = (f) ZeusTransformUtils.preCheckCast(b().get(r2), f.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            Object r5 = r4.get();
        L8:
            if (r4 == null) goto L11;
            if (r5 != null) goto L11;
            b(r2);
        L11:
            Object r6 = c().get(r2);
            if (ZeusTransformUtils.instanceOf(r6, g.class) == true) goto L13;
            if (c().compareAndSet(r2, r6, kotlinx.coroutines.debug.internal.b.a(r6)) == false) goto L11;
        L16:
            if (r5 == null) goto L20;
            if (r6 == null) goto L20;
            if (r1.a(r5, r6, r4) == kotlinx.coroutines.debug.internal.b.a()) goto L2;
        L20:
            r2 = r2 + 1;
            goto L3
        L13:
            r6 = ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.memorydata.plugin")).f17334a;
            goto L16
        L7:
            r5 = null;
            goto L8
        L21:
            return r1;
        }

        public final void a(f<?> r5) {
            int r0 = a(r5.f17333a);
        L3:
            f<?> r1 = (f) ZeusTransformUtils.preCheckCast(b().get(r0), f.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L5;
            if (r1 == r5) goto L7;
            if (r0 != 0) goto L11;
            r0 = this.f17314b;
        L11:
            r0 = r0 - 1;
            goto L3
        L7:
            b(r0);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", EventBody.KEY_VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class b<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f17317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f17318b;

        public b(K r1, V r2) {
            this.f17317a = r1;
            this.f17318b = r2;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f17317a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f17318b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r1) {
            kotlinx.coroutines.debug.internal.b.b();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class c<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<K, V> f17319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function2<K, V, E> f17320b;

        public c(a r3, Function2<? super K, ? super V, ? extends E> r4) {
            Function2<K, V, E> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.f17319a = r3;
            this.f17320b = r5;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E r1) {
            kotlinx.coroutines.debug.internal.b.b();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return this.f17319a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((C0879a) ZeusTransformUtils.preCheckCast(a.b().get(this.f17319a), C0879a.class, "com.obric.memorydata.plugin")).a(this.f17320b);
        }
    }

    static {
        f17311b = AtomicIntegerFieldUpdater.newUpdater(a.class, "_size$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "core$volatile");
    }

    public a() {
        this(false, 1, null);
    }

    public a(boolean r3) {
        this.core$volatile = new C0879a(this, 16);
        if (r3 == false) goto L5;
        ReferenceQueue<K> r4 = new ReferenceQueue();
    L6:
        this.f17312a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public /* synthetic */ a(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    private final synchronized V a(K r8, V r9) {
        monitor-enter(this);
        C0879a r0 = (C0879a) ZeusTransformUtils.preCheckCast(e().get(this), C0879a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L4:
        V r1 = (V) C0879a.a(r0, r8, r9, null, 4, null);
        if (r1 != kotlinx.coroutines.debug.internal.b.a()) goto L6;
        r0 = r0.a();     // Catch: Throwable -> L10
        e().set(this, r0);     // Catch: Throwable -> L10
        goto L4
    L6:
        monitor-exit(this);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void a(a r0) {
        r0.c();
    }

    private final void a(f<?> r3) {
        ((C0879a) ZeusTransformUtils.preCheckCast(e().get(this), C0879a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static final /* synthetic */ ReferenceQueue b(a r0) {
        return r0.f17312a;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater b() {
        return e();
    }

    private final void c() {
        d().decrementAndGet(this);
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater d() {
        return f17311b;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater e() {
        return c;
    }

    public final void a() {
        if (this.f17312a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
    L13:
        Reference<? extends K> r1 = this.f17312a.remove();     // Catch: InterruptedException -> L9
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L9
        a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin"));     // Catch: InterruptedException -> L9
    L9:
        Thread.currentThread().interrupt();
        return;
    L12:
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> r0 = keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        remove(r0.next());
        goto L4
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return (V) ((C0879a) ZeusTransformUtils.preCheckCast(e().get(this), C0879a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return (Set) ZeusTransformUtils.preCheckCast(new c(this, (Function2) ZeusTransformUtils.preCheckCast(ConcurrentWeakMap$entries$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return (Set) ZeusTransformUtils.preCheckCast(new c(this, (Function2) ZeusTransformUtils.preCheckCast(ConcurrentWeakMap$keys$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return d().get(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r8, V r9) {
        V r0 = (V) C0879a.a((C0879a) ZeusTransformUtils.preCheckCast(e().get(this), C0879a.class, "com.obric.memorydata.plugin"), r8, r9, null, 4, null);
        if (r0 != kotlinx.coroutines.debug.internal.b.a()) goto L5;
        r0 = a(r8, r9);
    L5:
        if (r0 != null) goto L7;
        d().incrementAndGet(this);
    L7:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r9) {
        if (r9 != 0) goto L5;
        return null;
    L5:
        V r1 = (V) C0879a.a((C0879a) ZeusTransformUtils.preCheckCast(e().get(this), C0879a.class, "com.obric.memorydata.plugin"), r9, null, null, 4, null);
        if (r1 != kotlinx.coroutines.debug.internal.b.a()) goto L8;
        r1 = a(r9, null);
    L8:
        if (r1 == null) goto L10;
        d().decrementAndGet(this);
    L10:
        return r1;
    }
}
