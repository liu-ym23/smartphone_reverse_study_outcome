package org.ehcache.impl.internal.concurrent;

import com.bytedance.crash.dumper.ProcInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import sun.misc.Contended;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes7.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements Serializable, org.ehcache.impl.internal.concurrent.a<K, V> {
    private static final int ABASE = 0;
    private static final int ASHIFT = 0;
    private static final long BASECOUNT = 0;
    private static final long CELLSBUSY = 0;
    private static final long CELLVALUE = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    public static final m<?, ?> FAKE_TREE_BIN = null;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU = 0;
    static final int RESERVED = -3;
    private static final int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL = 0;
    private static final long TRANSFERINDEX = 0;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U = null;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient b[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient i<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient i<K, V>[] table;
    private volatile transient int transferIndex;
    private transient ValuesView<K, V> values;

    static abstract class BulkTask<K, V, R> extends CountedCompleter<R> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        int index;
        i<K, V> next;
        k<K, V> spare;
        k<K, V> stack;
        i<K, V>[] tab;

        BulkTask(BulkTask<K, V, ?> r1, int r2, int r3, int r4, i<K, V>[] r5) {
            super(r1);
            this.batch = r2;
            this.baseIndex = r3;
            this.index = r3;
            this.tab = r5;
            if (r5 != null) goto L7;
            int r6 = 0;
        L5:
            this.baseLimit = r6;
        L6:
            this.baseSize = r6;
            return;
        L7:
            if (r1 != null) goto L9;
            r6 = r5.length;
            goto L5
        L9:
            this.baseLimit = r4;
            r6 = r1.baseSize;
            goto L6
        }

        private void pushState(i<K, V>[] r3, int r4, int r5) {
            k<K, V> r0 = this.spare;
            if (r0 == null) goto L5;
            this.spare = r0.d;
        L6:
            r0.c = r3;
            r0.f18084a = r5;
            r0.f18085b = r4;
            r0.d = this.stack;
            this.stack = r0;
            return;
        L5:
            r0 = new k();
            goto L6
        }

        private void recoverState(int r4) {
        L2:
            k<K, V> r0 = this.stack;
            if (r0 == null) goto L7;
            int r1 = this.index;
            int r2 = r0.f18084a;
            int r3 = r1 + r2;
            this.index = r3;
            if (r3 < r4) goto L7;
            this.index = r0.f18085b;
            this.tab = r0.c;
            r0.c = null;
            k<K, V> r5 = r0.d;
            r0.d = this.spare;
            this.stack = r5;
            this.spare = r0;
            r4 = r2;
        L7:
            if (r0 != null) goto L14;
            int r6 = this.index + this.baseSize;
            this.index = r6;
            if (r6 < r4) goto L15;
            int r7 = this.baseIndex + 1;
            this.baseIndex = r7;
            this.index = r7;
            return;
        L15:
            return;
        }

        final i<K, V> advance() {
            i<K, V> r0 = this.next;
            if (r0 == null) goto L5;
            r0 = r0.e;
        L5:
            if (r0 != null) goto L6;
            if (this.baseIndex >= this.baseLimit) goto L34;
            i<K, V>[] r1 = this.tab;
            if (r1 == null) goto L34;
            int r2 = r1.length;
            int r3 = this.index;
            if (r2 <= r3) goto L34;
            if (r3 < 0) goto L34;
            i<K, V> r4 = ConcurrentHashMap.tabAt(r1, r3);
            if (r4 == null) goto L27;
            if (r4.f18083b >= 0) goto L27;
            if (ZeusTransformUtils.instanceOf(r4, e.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r4, m.class) == false) goto L26;
            r0 = ((m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin")).f;
        L29:
            if (this.stack != null) goto L30;
            int r5 = r3 + this.baseSize;
            this.index = r5;
            if (r5 < r2) goto L5;
            int r6 = this.baseIndex + 1;
            this.baseIndex = r6;
            this.index = r6;
            goto L5
        L30:
            recoverState(r2);
            goto L5
        L26:
            r0 = null;
            goto L29
        L22:
            this.tab = ((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin")).f18079a;
            pushState(r1, r3, r2);
            r0 = null;
        L27:
            r0 = r4;
        L34:
            this.next = null;
            return null;
        L6:
            this.next = r0;
            return r0;
        }
    }

    static abstract class CollectionView<K, V, E> implements Serializable, Collection<E> {
        private static final String OOME_MSG = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap<K, V> map;

        CollectionView(ConcurrentHashMap<K, V> r1) {
            this.map = r1;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public abstract boolean contains(Object r1);

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            if (r4 == this) goto L13;
            Iterator<E> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L20;
            E r0 = r5.next();
            if (r0 == null) goto L11;
            if (contains(r0) == true) goto L6;
            return false;
        L11:
            return false;
        L20:
            return true;
        L13:
            return true;
        }

        public ConcurrentHashMap<K, V> getMap() {
            return this.map;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        @Override // java.util.Collection
        public abstract boolean remove(Object r1);

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r5);
            i<K, V>[] r0 = this.map.table;
            boolean r1 = false;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Set.class) == true) goto L8;
        L15:
            Iterator<E> r6 = r5.iterator();
        L17:
            if (r6.hasNext() == false) goto L19;
            r1 = r1 | remove(r6.next());
        L19:
            return r1;
        L8:
            if (r5.size() <= r0.length) goto L15;
            Iterator<E> r3 = iterator();
        L11:
            if (r3.hasNext() == false) goto L19;
            if (r5.contains(r3.next()) == false) goto L11;
            r3.remove();
            r1 = true;
            goto L11
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            boolean r0 = false;
            Iterator<E> r2 = iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            if (r4.contains(r2.next()) == true) goto L4;
            r2.remove();
            r0 = true;
            goto L4
        L8:
            return r0;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long r0 = this.map.mappingCount();
            if (r0 > 2147483639) goto L24;
            int r1 = (int) r0;
            Object[] r2 = new Object[r1];
            int r3 = 0;
            Iterator<E> r7 = iterator();
        L6:
            if (r7.hasNext() == false) goto L19;
            E r4 = r7.next();
            if (r3 != r1) goto L18;
            int r5 = ConcurrentHashMap.MAX_ARRAY_SIZE;
            if (r1 >= ConcurrentHashMap.MAX_ARRAY_SIZE) goto L17;
            if (r1 >= 1073741819) goto L15;
            r5 = ((r1 >>> 1) + 1) + r1;
        L15:
            r2 = Arrays.copyOf(r2, r5);
            r1 = r5;
            goto L18
        L17:
            throw new OutOfMemoryError(OOME_MSG);
        L18:
            r2[r3] = r4;
            r3 = r3 + 1;
            goto L6
        L19:
            if (r3 != r1) goto L22;
            return r2;
        L22:
            return Arrays.copyOf(r2, r3);
        L24:
            throw new OutOfMemoryError(OOME_MSG);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] r8) {
            long r0 = this.map.mappingCount();
            if (r0 > 2147483639) goto L32;
            int r1 = (int) r0;
            if (r8.length < r1) goto L7;
            Object[] r2 = r8;
        L8:
            int r3 = r2.length;
            int r4 = 0;
            Iterator<E> r7 = iterator();
        L10:
            if (r7.hasNext() == false) goto L23;
            E r5 = r7.next();
            if (r4 != r3) goto L22;
            int r6 = ConcurrentHashMap.MAX_ARRAY_SIZE;
            if (r3 >= ConcurrentHashMap.MAX_ARRAY_SIZE) goto L21;
            if (r3 >= 1073741819) goto L19;
            r6 = ((r3 >>> 1) + 1) + r3;
        L19:
            r2 = (T[]) Arrays.copyOf(r2, r6);
            r3 = r6;
            goto L22
        L21:
            throw new OutOfMemoryError(OOME_MSG);
        L22:
            r2[r4] = r5;
            r4 = r4 + 1;
            goto L10
        L23:
            if (r8 != r2) goto L27;
            if (r4 >= r3) goto L27;
            r2[r4] = null;
            return (T[]) r2;
        L27:
            if (r4 != r3) goto L30;
            return (T[]) r2;
        L30:
            return (T[]) Arrays.copyOf(r2, r4);
        L7:
            r2 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r8.getClass().getComponentType(), r1), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
            goto L8
        L32:
            throw new OutOfMemoryError(OOME_MSG);
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append('[');
            Iterator<E> r1 = iterator();
            if (r1.hasNext() == false) goto L12;
        L4:
            Object r2 = r1.next();
            if (r2 != this) goto L7;
            r2 = "(this Collection)";
        L7:
            r0.append(r2);
            if (r1.hasNext() == false) goto L12;
            r0.append(',').append(' ');
        L12:
            return r0.append(']').toString();
        }
    }

    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Serializable, Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMap<K, V> r1) {
            super(r1);
        }

        @Override // java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object r3) {
            return add((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        public boolean add(Map.Entry<K, V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            ConcurrentHashMap<K, V> r2 = this.map;
            Object r0 = r4.getKey();
            if (r2.putVal((K) r0, (V) r4.getValue(), false) != null) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> r5) {
            Iterator r6 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin")).iterator();
            boolean r0 = false;
        L4:
            if (r6.hasNext() == false) goto L8;
            if (add((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")) == false) goto L4;
            r0 = true;
            goto L4
        L8:
            return r0;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L14;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r4.getKey();
            if (r0 == null) goto L14;
            V r2 = this.map.get(r0);
            if (r2 == null) goto L14;
            Object r5 = r4.getValue();
            if (r5 == null) goto L14;
            if (r5 != r2) goto L12;
        L13:
            return true;
        L12:
            if (r5.equals(r2) == true) goto L13;
        L14:
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Set.class) == false) goto L11;
            Set r4 = (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin");
            if (r4 != this) goto L7;
        L10:
            return true;
        L7:
            if (containsAll(r4) == false) goto L11;
            if (r4.containsAll(this) == true) goto L10;
        L11:
            return false;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> r6) {
            Consumer r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r7);
            i<K, V>[] r0 = this.map.table;
            if (r0 == null) goto L8;
            l r1 = new l(r0, r0.length, 0, r0.length);
        L5:
            i<K, V> r2 = r1.b();
            if (r2 == null) goto L10;
            r7.accept(new h(r2.c, r2.d, this.map));
            goto L5
        L10:
            return;
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            i<K, V>[] r4 = this.map.table;
            int r0 = 0;
            if (r4 == null) goto L8;
            l r1 = new l(r4, r4.length, 0, r4.length);
        L5:
            i<K, V> r5 = r1.b();
            if (r5 == null) goto L8;
            r0 = r0 + r5.hashCode();
        L8:
            return r0;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            ConcurrentHashMap<K, V> r5 = this.map;
            i<K, V>[] r1 = r5.table;
            if (r1 != null) goto L5;
            int r6 = 0;
        L6:
            int r4 = r6;
            return new c(r1, r4, 0, r4, r5);
        L5:
            r6 = r1.length;
            goto L6
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L11;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r4.getKey();
            if (r0 == null) goto L11;
            Object r5 = r4.getValue();
            if (r5 == null) goto L11;
            if (this.map.remove(r0, r5) == false) goto L11;
            return true;
        L11:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Map.Entry<K, V>> r3) {
            Predicate<? super Map.Entry<K, V>> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            return this.map.removeEntryIf(r4);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            ConcurrentHashMap<K, V> r7 = this.map;
            long r0 = r7.sumCount();
            i<K, V>[] r9 = r7.table;
            if (r9 != null) goto L5;
            int r2 = 0;
        L6:
            int r4 = r2;
            long r5 = 0;
            if (r0 < 0) goto L11;
            r5 = r0;
        L11:
            return new d(r9, r4, 0, r4, r5, r7);
        L5:
            r2 = r9.length;
            goto L6
        }
    }

    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super Map.Entry<K, V>> action;

        ForEachEntryTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Consumer<? super Map.Entry<K, V>> r8) {
            Consumer<? super Map.Entry<K, V>> r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r8, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.action = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super Map.Entry<K, V>> r7 = this.action;
            if (r7 == null) goto L19;
            int r8 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r8) >>> 1;
            if (r3 <= r8) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachEntryTask(this, r2, r3, r4, this.tab, r7).fork();
        L10:
            i<K, V> r0 = advance();
            if (r0 == null) goto L13;
            r7.accept(r0);
            goto L10
        L13:
            propagateCompletion();
            return;
        }
    }

    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super K> action;

        ForEachKeyTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Consumer<? super K> r8) {
            Consumer<? super K> r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r8, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.action = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super K> r7 = this.action;
            if (r7 == null) goto L19;
            int r8 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r8) >>> 1;
            if (r3 <= r8) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachKeyTask(this, r2, r3, r4, this.tab, r7).fork();
        L10:
            i<K, V> r0 = advance();
            if (r0 == null) goto L13;
            r7.accept(r0.c);
            goto L10
        L13:
            propagateCompletion();
            return;
        }
    }

    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void> {
        final BiConsumer<? super K, ? super V> action;

        ForEachMappingTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, BiConsumer<? super K, ? super V> r8) {
            BiConsumer<? super K, ? super V> r9 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r8, BiConsumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.action = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiConsumer<? super K, ? super V> r7 = this.action;
            if (r7 == null) goto L19;
            int r8 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r8) >>> 1;
            if (r3 <= r8) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachMappingTask(this, r2, r3, r4, this.tab, r7).fork();
        L10:
            i<K, V> r0 = advance();
            if (r0 == null) goto L13;
            r7.accept(r0.c, r0.d);
            goto L10
        L13:
            propagateCompletion();
            return;
        }
    }

    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        ForEachTransformedEntryTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<Map.Entry<K, V>, ? extends U> r8, Consumer<? super U> r9) {
            Function<Map.Entry<K, V>, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            Consumer<? super U> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r9, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.transformer = r10;
            this.action = r11;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<Map.Entry<K, V>, ? extends U> r8 = this.transformer;
            if (r8 == null) goto L27;
            Consumer<? super U> r9 = this.action;
            if (r9 == null) goto L28;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachTransformedEntryTask(this, r2, r3, r4, this.tab, r8, r9).fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L17;
            U r1 = r8.apply(r0);
            if (r1 == null) goto L12;
            r9.accept(r1);
            goto L12
        L17:
            propagateCompletion();
            return;
        L28:
            return;
        }
    }

    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super K, ? extends U> transformer;

        ForEachTransformedKeyTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<? super K, ? extends U> r8, Consumer<? super U> r9) {
            Function<? super K, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            Consumer<? super U> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r9, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.transformer = r10;
            this.action = r11;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super K, ? extends U> r8 = this.transformer;
            if (r8 == null) goto L27;
            Consumer<? super U> r9 = this.action;
            if (r9 == null) goto L28;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachTransformedKeyTask(this, r2, r3, r4, this.tab, r8, r9).fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L17;
            U r1 = r8.apply(r0.c);
            if (r1 == null) goto L12;
            r9.accept(r1);
            goto L12
        L17:
            propagateCompletion();
            return;
        L28:
            return;
        }
    }

    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        ForEachTransformedMappingTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, BiFunction<? super K, ? super V, ? extends U> r8, Consumer<? super U> r9) {
            BiFunction<? super K, ? super V, ? extends U> r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r8, BiFunction.class, "com.obric.memorydata.plugin");
            Consumer<? super U> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r9, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.transformer = r10;
            this.action = r11;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super V, ? extends U> r8 = this.transformer;
            if (r8 == null) goto L27;
            Consumer<? super U> r9 = this.action;
            if (r9 == null) goto L28;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachTransformedMappingTask(this, r2, r3, r4, this.tab, r8, r9).fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L17;
            U r1 = r8.apply(r0.c, r0.d);
            if (r1 == null) goto L12;
            r9.accept(r1);
            goto L12
        L17:
            propagateCompletion();
            return;
        L28:
            return;
        }
    }

    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super V, ? extends U> transformer;

        ForEachTransformedValueTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<? super V, ? extends U> r8, Consumer<? super U> r9) {
            Function<? super V, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            Consumer<? super U> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r9, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.transformer = r10;
            this.action = r11;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super V, ? extends U> r8 = this.transformer;
            if (r8 == null) goto L27;
            Consumer<? super U> r9 = this.action;
            if (r9 == null) goto L28;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachTransformedValueTask(this, r2, r3, r4, this.tab, r8, r9).fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L17;
            U r1 = r8.apply(r0.d);
            if (r1 == null) goto L12;
            r9.accept(r1);
            goto L12
        L17:
            propagateCompletion();
            return;
        L28:
            return;
        }
    }

    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super V> action;

        ForEachValueTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Consumer<? super V> r8) {
            Consumer<? super V> r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r8, Consumer.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.action = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super V> r7 = this.action;
            if (r7 == null) goto L19;
            int r8 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r8) >>> 1;
            if (r3 <= r8) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new ForEachValueTask(this, r2, r3, r4, this.tab, r7).fork();
        L10:
            i<K, V> r0 = advance();
            if (r0 == null) goto L13;
            r7.accept(r0.d);
            goto L10
        L13:
            propagateCompletion();
            return;
        }
    }

    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Serializable, Set<K> {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        KeySetView(ConcurrentHashMap<K, V> r1, V r2) {
            super(r1);
            this.value = r2;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K r3) {
            V r0 = this.value;
            if (r0 == null) goto L10;
            if (this.map.putVal(r3, r0, true) == null) goto L11;
            return false;
        L11:
            return true;
        L10:
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            V r0 = this.value;
            if (r0 == null) goto L12;
            Iterator r8 = r7.iterator();
            boolean r1 = false;
        L6:
            if (r8.hasNext() == false) goto L10;
            if (this.map.putVal((K) r8.next(), r0, true) != null) goto L6;
            r1 = true;
            goto L6
        L10:
            return r1;
        L12:
            throw new UnsupportedOperationException();
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object r1) {
            return this.map.containsKey(r1);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Set.class) == false) goto L11;
            Set r4 = (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin");
            if (r4 != this) goto L7;
        L10:
            return true;
        L7:
            if (containsAll(r4) == false) goto L11;
            if (r4.containsAll(this) == true) goto L10;
        L11:
            return false;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> r5) {
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r6);
            i<K, V>[] r4 = this.map.table;
            if (r4 == null) goto L8;
            l r0 = new l(r4, r4.length, 0, r4.length);
        L5:
            i<K, V> r7 = r0.b();
            if (r7 == null) goto L10;
            r6.accept(r7.c);
            goto L5
        L10:
            return;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMap getMap() {
            return super.getMap();
        }

        public V getMappedValue() {
            return this.value;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Iterator<K> r2 = iterator();
            int r0 = 0;
        L4:
            if (r2.hasNext() == false) goto L6;
            r0 = r0 + r2.next().hashCode();
            goto L4
        L6:
            return r0;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            ConcurrentHashMap<K, V> r5 = this.map;
            i<K, V>[] r1 = r5.table;
            if (r1 != null) goto L5;
            int r6 = 0;
        L6:
            int r4 = r6;
            return new f(r1, r4, 0, r4, r5);
        L5:
            r6 = r1.length;
            goto L6
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean remove(Object r1) {
            if (this.map.remove(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public /* synthetic */ boolean removeAll(Collection r3) {
            return super.removeAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            ConcurrentHashMap<K, V> r9 = this.map;
            long r0 = r9.sumCount();
            i<K, V>[] r3 = r9.table;
            if (r3 != null) goto L5;
            int r10 = 0;
        L6:
            int r6 = r10;
            long r7 = 0;
            if (r0 < 0) goto L11;
            r7 = r0;
        L11:
            return new g(r3, r6, 0, r6, r7);
        L5:
            r10 = r3.length;
            goto L6
        }
    }

    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceEntriesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        MapReduceEntriesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceEntriesTask<K, V, U> r8, Function<Map.Entry<K, V>, ? extends U> r9, BiFunction<? super U, ? super U, ? extends U> r10) {
            Function<Map.Entry<K, V>, ? extends U> r11 = (Function) ZeusTransformUtils.wrapperContextForParams(r9, Function.class, "com.obric.memorydata.plugin");
            BiFunction<? super U, ? super U, ? extends U> r12 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r10, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.reducer = r12;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<Map.Entry<K, V>, ? extends U> r9 = this.transformer;
            if (r9 == null) goto L34;
            BiFunction<? super U, ? super U, ? extends U> r10 = this.reducer;
            if (r10 == null) goto L46;
            int r11 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r11) >>> 1;
            if (r3 <= r11) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceEntriesTask<K, V, U> r12 = new MapReduceEntriesTask(this, r2, r3, r4, this.tab, this.rights, r9, r10);
            this.rights = r12;
            r12.fork();
        L12:
            U r0 = null;
        L13:
            i<K, V> r1 = advance();
            if (r1 == null) goto L21;
            U r5 = r9.apply(r1);
            if (r5 == null) goto L13;
            if (r0 == null) goto L20;
            r5 = r10.apply(r0, r5);
        L20:
            r0 = (U) r5;
            goto L13
        L21:
            this.result = r0;
            CountedCompleter<?> r13 = firstComplete();
        L22:
            if (r13 == null) goto L47;
            MapReduceEntriesTask r6 = (MapReduceEntriesTask) ZeusTransformUtils.preCheckCast(r13, MapReduceEntriesTask.class, "com.obric.memorydata.plugin");
            MapReduceEntriesTask<K, V, U> r7 = r6.rights;
        L24:
            if (r7 == null) goto L33;
            U r8 = r7.result;
            if (r8 == null) goto L32;
            U r14 = r6.result;
            if (r14 == null) goto L31;
            r8 = r10.apply(r14, r8);
        L31:
            r6.result = (U) r8;
        L32:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L24
        L33:
            r13 = r13.nextComplete();
            goto L22
        L47:
            return;
        L46:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        final ToDoubleFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToDoubleTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceEntriesToDoubleTask<K, V> r8, ToDoubleFunction<Map.Entry<K, V>> r9, double r10, DoubleBinaryOperator r12) {
            ToDoubleFunction<Map.Entry<K, V>> r11 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToDoubleFunction.class, "com.obric.memorydata.plugin");
            DoubleBinaryOperator r13 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToDoubleFunction<Map.Entry<K, V>> r12 = this.transformer;
            if (r12 == null) goto L22;
            DoubleBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            double r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceEntriesToDoubleTask<K, V> r8 = new MapReduceEntriesToDoubleTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToDoubleFunction<Map.Entry<K, V>> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsDouble(r14, r16.applyAsDouble(r0));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceEntriesToDoubleTask r5 = (MapReduceEntriesToDoubleTask) ZeusTransformUtils.preCheckCast(r1, MapReduceEntriesToDoubleTask.class, "com.obric.memorydata.plugin");
            MapReduceEntriesToDoubleTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsDouble(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceEntriesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        final ToIntFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToIntTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceEntriesToIntTask<K, V> r8, ToIntFunction<Map.Entry<K, V>> r9, int r10, IntBinaryOperator r11) {
            ToIntFunction<Map.Entry<K, V>> r12 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToIntFunction.class, "com.obric.memorydata.plugin");
            IntBinaryOperator r13 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, IntBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r12;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToIntFunction<Map.Entry<K, V>> r10 = this.transformer;
            if (r10 == null) goto L21;
            IntBinaryOperator r11 = this.reducer;
            if (r11 == null) goto L28;
            int r12 = this.basis;
            int r13 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r13) >>> 1;
            if (r3 <= r13) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceEntriesToIntTask<K, V> r14 = new MapReduceEntriesToIntTask(this, r2, r3, r4, this.tab, this.rights, r10, r12, r11);
            this.rights = r14;
            r14.fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L15;
            r12 = r11.applyAsInt(r12, r10.applyAsInt(r0));
            goto L12
        L15:
            this.result = r12;
            CountedCompleter<?> r15 = firstComplete();
        L16:
            if (r15 == null) goto L29;
            MapReduceEntriesToIntTask r1 = (MapReduceEntriesToIntTask) ZeusTransformUtils.preCheckCast(r15, MapReduceEntriesToIntTask.class, "com.obric.memorydata.plugin");
            MapReduceEntriesToIntTask<K, V> r5 = r1.rights;
        L18:
            if (r5 == null) goto L20;
            r1.result = r11.applyAsInt(r1.result, r5.result);
            r5 = r5.nextRight;
            r1.rights = r5;
            goto L18
        L20:
            r15 = r15.nextComplete();
            goto L16
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceEntriesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        final ToLongFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToLongTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceEntriesToLongTask<K, V> r8, ToLongFunction<Map.Entry<K, V>> r9, long r10, LongBinaryOperator r12) {
            ToLongFunction<Map.Entry<K, V>> r11 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToLongFunction.class, "com.obric.memorydata.plugin");
            LongBinaryOperator r13 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, LongBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToLongFunction<Map.Entry<K, V>> r12 = this.transformer;
            if (r12 == null) goto L22;
            LongBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            long r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceEntriesToLongTask<K, V> r8 = new MapReduceEntriesToLongTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToLongFunction<Map.Entry<K, V>> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsLong(r14, r16.applyAsLong(r0));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceEntriesToLongTask r5 = (MapReduceEntriesToLongTask) ZeusTransformUtils.preCheckCast(r1, MapReduceEntriesToLongTask.class, "com.obric.memorydata.plugin");
            MapReduceEntriesToLongTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsLong(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceKeysTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        final Function<? super K, ? extends U> transformer;

        MapReduceKeysTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceKeysTask<K, V, U> r8, Function<? super K, ? extends U> r9, BiFunction<? super U, ? super U, ? extends U> r10) {
            Function<? super K, ? extends U> r11 = (Function) ZeusTransformUtils.wrapperContextForParams(r9, Function.class, "com.obric.memorydata.plugin");
            BiFunction<? super U, ? super U, ? extends U> r12 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r10, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.reducer = r12;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super K, ? extends U> r9 = this.transformer;
            if (r9 == null) goto L34;
            BiFunction<? super U, ? super U, ? extends U> r10 = this.reducer;
            if (r10 == null) goto L46;
            int r11 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r11) >>> 1;
            if (r3 <= r11) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceKeysTask<K, V, U> r12 = new MapReduceKeysTask(this, r2, r3, r4, this.tab, this.rights, r9, r10);
            this.rights = r12;
            r12.fork();
        L12:
            U r0 = null;
        L13:
            i<K, V> r1 = advance();
            if (r1 == null) goto L21;
            U r5 = r9.apply(r1.c);
            if (r5 == null) goto L13;
            if (r0 == null) goto L20;
            r5 = r10.apply(r0, r5);
        L20:
            r0 = (U) r5;
            goto L13
        L21:
            this.result = r0;
            CountedCompleter<?> r13 = firstComplete();
        L22:
            if (r13 == null) goto L47;
            MapReduceKeysTask r6 = (MapReduceKeysTask) ZeusTransformUtils.preCheckCast(r13, MapReduceKeysTask.class, "com.obric.memorydata.plugin");
            MapReduceKeysTask<K, V, U> r7 = r6.rights;
        L24:
            if (r7 == null) goto L33;
            U r8 = r7.result;
            if (r8 == null) goto L32;
            U r14 = r6.result;
            if (r14 == null) goto L31;
            r8 = r10.apply(r14, r8);
        L31:
            r6.result = (U) r8;
        L32:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L24
        L33:
            r13 = r13.nextComplete();
            goto L22
        L47:
            return;
        L46:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super K> transformer;

        MapReduceKeysToDoubleTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceKeysToDoubleTask<K, V> r8, ToDoubleFunction<? super K> r9, double r10, DoubleBinaryOperator r12) {
            ToDoubleFunction<? super K> r11 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToDoubleFunction.class, "com.obric.memorydata.plugin");
            DoubleBinaryOperator r13 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToDoubleFunction<? super K> r12 = this.transformer;
            if (r12 == null) goto L22;
            DoubleBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            double r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceKeysToDoubleTask<K, V> r8 = new MapReduceKeysToDoubleTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToDoubleFunction<? super K> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsDouble(r14, r16.applyAsDouble(r0.c));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceKeysToDoubleTask r5 = (MapReduceKeysToDoubleTask) ZeusTransformUtils.preCheckCast(r1, MapReduceKeysToDoubleTask.class, "com.obric.memorydata.plugin");
            MapReduceKeysToDoubleTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsDouble(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceKeysToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        final ToIntFunction<? super K> transformer;

        MapReduceKeysToIntTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceKeysToIntTask<K, V> r8, ToIntFunction<? super K> r9, int r10, IntBinaryOperator r11) {
            ToIntFunction<? super K> r12 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToIntFunction.class, "com.obric.memorydata.plugin");
            IntBinaryOperator r13 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, IntBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r12;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToIntFunction<? super K> r10 = this.transformer;
            if (r10 == null) goto L21;
            IntBinaryOperator r11 = this.reducer;
            if (r11 == null) goto L28;
            int r12 = this.basis;
            int r13 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r13) >>> 1;
            if (r3 <= r13) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceKeysToIntTask<K, V> r14 = new MapReduceKeysToIntTask(this, r2, r3, r4, this.tab, this.rights, r10, r12, r11);
            this.rights = r14;
            r14.fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L15;
            r12 = r11.applyAsInt(r12, r10.applyAsInt(r0.c));
            goto L12
        L15:
            this.result = r12;
            CountedCompleter<?> r15 = firstComplete();
        L16:
            if (r15 == null) goto L29;
            MapReduceKeysToIntTask r1 = (MapReduceKeysToIntTask) ZeusTransformUtils.preCheckCast(r15, MapReduceKeysToIntTask.class, "com.obric.memorydata.plugin");
            MapReduceKeysToIntTask<K, V> r5 = r1.rights;
        L18:
            if (r5 == null) goto L20;
            r1.result = r11.applyAsInt(r1.result, r5.result);
            r5 = r5.nextRight;
            r1.rights = r5;
            goto L18
        L20:
            r15 = r15.nextComplete();
            goto L16
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceKeysToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        final ToLongFunction<? super K> transformer;

        MapReduceKeysToLongTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceKeysToLongTask<K, V> r8, ToLongFunction<? super K> r9, long r10, LongBinaryOperator r12) {
            ToLongFunction<? super K> r11 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToLongFunction.class, "com.obric.memorydata.plugin");
            LongBinaryOperator r13 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, LongBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToLongFunction<? super K> r12 = this.transformer;
            if (r12 == null) goto L22;
            LongBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            long r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceKeysToLongTask<K, V> r8 = new MapReduceKeysToLongTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToLongFunction<? super K> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsLong(r14, r16.applyAsLong(r0.c));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceKeysToLongTask r5 = (MapReduceKeysToLongTask) ZeusTransformUtils.preCheckCast(r1, MapReduceKeysToLongTask.class, "com.obric.memorydata.plugin");
            MapReduceKeysToLongTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsLong(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceMappingsTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        MapReduceMappingsTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceMappingsTask<K, V, U> r8, BiFunction<? super K, ? super V, ? extends U> r9, BiFunction<? super U, ? super U, ? extends U> r10) {
            BiFunction<? super K, ? super V, ? extends U> r11 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r9, BiFunction.class, "com.obric.memorydata.plugin");
            BiFunction<? super U, ? super U, ? extends U> r12 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r10, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.reducer = r12;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super V, ? extends U> r9 = this.transformer;
            if (r9 == null) goto L34;
            BiFunction<? super U, ? super U, ? extends U> r10 = this.reducer;
            if (r10 == null) goto L46;
            int r11 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r11) >>> 1;
            if (r3 <= r11) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceMappingsTask<K, V, U> r12 = new MapReduceMappingsTask(this, r2, r3, r4, this.tab, this.rights, r9, r10);
            this.rights = r12;
            r12.fork();
        L12:
            U r0 = null;
        L13:
            i<K, V> r1 = advance();
            if (r1 == null) goto L21;
            U r5 = r9.apply(r1.c, r1.d);
            if (r5 == null) goto L13;
            if (r0 == null) goto L20;
            r5 = r10.apply(r0, r5);
        L20:
            r0 = (U) r5;
            goto L13
        L21:
            this.result = r0;
            CountedCompleter<?> r13 = firstComplete();
        L22:
            if (r13 == null) goto L47;
            MapReduceMappingsTask r6 = (MapReduceMappingsTask) ZeusTransformUtils.preCheckCast(r13, MapReduceMappingsTask.class, "com.obric.memorydata.plugin");
            MapReduceMappingsTask<K, V, U> r7 = r6.rights;
        L24:
            if (r7 == null) goto L33;
            U r8 = r7.result;
            if (r8 == null) goto L32;
            U r14 = r6.result;
            if (r14 == null) goto L31;
            r8 = r10.apply(r14, r8);
        L31:
            r6.result = (U) r8;
        L32:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L24
        L33:
            r13 = r13.nextComplete();
            goto L22
        L47:
            return;
        L46:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        final ToDoubleBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToDoubleTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceMappingsToDoubleTask<K, V> r8, ToDoubleBiFunction<? super K, ? super V> r9, double r10, DoubleBinaryOperator r12) {
            ToDoubleBiFunction<? super K, ? super V> r11 = (ToDoubleBiFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToDoubleBiFunction.class, "com.obric.memorydata.plugin");
            DoubleBinaryOperator r13 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToDoubleBiFunction<? super K, ? super V> r12 = this.transformer;
            if (r12 == null) goto L22;
            DoubleBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            double r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceMappingsToDoubleTask<K, V> r8 = new MapReduceMappingsToDoubleTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToDoubleBiFunction<? super K, ? super V> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsDouble(r14, r16.applyAsDouble(r0.c, r0.d));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceMappingsToDoubleTask r5 = (MapReduceMappingsToDoubleTask) ZeusTransformUtils.preCheckCast(r1, MapReduceMappingsToDoubleTask.class, "com.obric.memorydata.plugin");
            MapReduceMappingsToDoubleTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsDouble(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceMappingsToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        final ToIntBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToIntTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceMappingsToIntTask<K, V> r8, ToIntBiFunction<? super K, ? super V> r9, int r10, IntBinaryOperator r11) {
            ToIntBiFunction<? super K, ? super V> r12 = (ToIntBiFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToIntBiFunction.class, "com.obric.memorydata.plugin");
            IntBinaryOperator r13 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, IntBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r12;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToIntBiFunction<? super K, ? super V> r10 = this.transformer;
            if (r10 == null) goto L21;
            IntBinaryOperator r11 = this.reducer;
            if (r11 == null) goto L28;
            int r12 = this.basis;
            int r13 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r13) >>> 1;
            if (r3 <= r13) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceMappingsToIntTask<K, V> r14 = new MapReduceMappingsToIntTask(this, r2, r3, r4, this.tab, this.rights, r10, r12, r11);
            this.rights = r14;
            r14.fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L15;
            r12 = r11.applyAsInt(r12, r10.applyAsInt(r0.c, r0.d));
            goto L12
        L15:
            this.result = r12;
            CountedCompleter<?> r15 = firstComplete();
        L16:
            if (r15 == null) goto L29;
            MapReduceMappingsToIntTask r1 = (MapReduceMappingsToIntTask) ZeusTransformUtils.preCheckCast(r15, MapReduceMappingsToIntTask.class, "com.obric.memorydata.plugin");
            MapReduceMappingsToIntTask<K, V> r5 = r1.rights;
        L18:
            if (r5 == null) goto L20;
            r1.result = r11.applyAsInt(r1.result, r5.result);
            r5 = r5.nextRight;
            r1.rights = r5;
            goto L18
        L20:
            r15 = r15.nextComplete();
            goto L16
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceMappingsToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        final ToLongBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToLongTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceMappingsToLongTask<K, V> r8, ToLongBiFunction<? super K, ? super V> r9, long r10, LongBinaryOperator r12) {
            ToLongBiFunction<? super K, ? super V> r11 = (ToLongBiFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToLongBiFunction.class, "com.obric.memorydata.plugin");
            LongBinaryOperator r13 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, LongBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToLongBiFunction<? super K, ? super V> r12 = this.transformer;
            if (r12 == null) goto L22;
            LongBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            long r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceMappingsToLongTask<K, V> r8 = new MapReduceMappingsToLongTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToLongBiFunction<? super K, ? super V> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsLong(r14, r16.applyAsLong(r0.c, r0.d));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceMappingsToLongTask r5 = (MapReduceMappingsToLongTask) ZeusTransformUtils.preCheckCast(r1, MapReduceMappingsToLongTask.class, "com.obric.memorydata.plugin");
            MapReduceMappingsToLongTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsLong(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceValuesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        final Function<? super V, ? extends U> transformer;

        MapReduceValuesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceValuesTask<K, V, U> r8, Function<? super V, ? extends U> r9, BiFunction<? super U, ? super U, ? extends U> r10) {
            Function<? super V, ? extends U> r11 = (Function) ZeusTransformUtils.wrapperContextForParams(r9, Function.class, "com.obric.memorydata.plugin");
            BiFunction<? super U, ? super U, ? extends U> r12 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r10, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.reducer = r12;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super V, ? extends U> r9 = this.transformer;
            if (r9 == null) goto L34;
            BiFunction<? super U, ? super U, ? extends U> r10 = this.reducer;
            if (r10 == null) goto L46;
            int r11 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r11) >>> 1;
            if (r3 <= r11) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceValuesTask<K, V, U> r12 = new MapReduceValuesTask(this, r2, r3, r4, this.tab, this.rights, r9, r10);
            this.rights = r12;
            r12.fork();
        L12:
            U r0 = null;
        L13:
            i<K, V> r1 = advance();
            if (r1 == null) goto L21;
            U r5 = r9.apply(r1.d);
            if (r5 == null) goto L13;
            if (r0 == null) goto L20;
            r5 = r10.apply(r0, r5);
        L20:
            r0 = (U) r5;
            goto L13
        L21:
            this.result = r0;
            CountedCompleter<?> r13 = firstComplete();
        L22:
            if (r13 == null) goto L47;
            MapReduceValuesTask r6 = (MapReduceValuesTask) ZeusTransformUtils.preCheckCast(r13, MapReduceValuesTask.class, "com.obric.memorydata.plugin");
            MapReduceValuesTask<K, V, U> r7 = r6.rights;
        L24:
            if (r7 == null) goto L33;
            U r8 = r7.result;
            if (r8 == null) goto L32;
            U r14 = r6.result;
            if (r14 == null) goto L31;
            r8 = r10.apply(r14, r8);
        L31:
            r6.result = (U) r8;
        L32:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L24
        L33:
            r13 = r13.nextComplete();
            goto L22
        L47:
            return;
        L46:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }
    }

    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super V> transformer;

        MapReduceValuesToDoubleTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceValuesToDoubleTask<K, V> r8, ToDoubleFunction<? super V> r9, double r10, DoubleBinaryOperator r12) {
            ToDoubleFunction<? super V> r11 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToDoubleFunction.class, "com.obric.memorydata.plugin");
            DoubleBinaryOperator r13 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToDoubleFunction<? super V> r12 = this.transformer;
            if (r12 == null) goto L22;
            DoubleBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            double r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceValuesToDoubleTask<K, V> r8 = new MapReduceValuesToDoubleTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToDoubleFunction<? super V> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsDouble(r14, r16.applyAsDouble(r0.d));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceValuesToDoubleTask r5 = (MapReduceValuesToDoubleTask) ZeusTransformUtils.preCheckCast(r1, MapReduceValuesToDoubleTask.class, "com.obric.memorydata.plugin");
            MapReduceValuesToDoubleTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsDouble(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceValuesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        final ToIntFunction<? super V> transformer;

        MapReduceValuesToIntTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceValuesToIntTask<K, V> r8, ToIntFunction<? super V> r9, int r10, IntBinaryOperator r11) {
            ToIntFunction<? super V> r12 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToIntFunction.class, "com.obric.memorydata.plugin");
            IntBinaryOperator r13 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, IntBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r12;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToIntFunction<? super V> r10 = this.transformer;
            if (r10 == null) goto L21;
            IntBinaryOperator r11 = this.reducer;
            if (r11 == null) goto L28;
            int r12 = this.basis;
            int r13 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r13) >>> 1;
            if (r3 <= r13) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceValuesToIntTask<K, V> r14 = new MapReduceValuesToIntTask(this, r2, r3, r4, this.tab, this.rights, r10, r12, r11);
            this.rights = r14;
            r14.fork();
        L12:
            i<K, V> r0 = advance();
            if (r0 == null) goto L15;
            r12 = r11.applyAsInt(r12, r10.applyAsInt(r0.d));
            goto L12
        L15:
            this.result = r12;
            CountedCompleter<?> r15 = firstComplete();
        L16:
            if (r15 == null) goto L29;
            MapReduceValuesToIntTask r1 = (MapReduceValuesToIntTask) ZeusTransformUtils.preCheckCast(r15, MapReduceValuesToIntTask.class, "com.obric.memorydata.plugin");
            MapReduceValuesToIntTask<K, V> r5 = r1.rights;
        L18:
            if (r5 == null) goto L20;
            r1.result = r11.applyAsInt(r1.result, r5.result);
            r5 = r5.nextRight;
            r1.rights = r5;
            goto L18
        L20:
            r15 = r15.nextComplete();
            goto L16
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceValuesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        final ToLongFunction<? super V> transformer;

        MapReduceValuesToLongTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, MapReduceValuesToLongTask<K, V> r8, ToLongFunction<? super V> r9, long r10, LongBinaryOperator r12) {
            ToLongFunction<? super V> r11 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r9, ToLongFunction.class, "com.obric.memorydata.plugin");
            LongBinaryOperator r13 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r12, LongBinaryOperator.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.transformer = r11;
            this.basis = r10;
            this.reducer = r13;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToLongFunction<? super V> r12 = this.transformer;
            if (r12 == null) goto L22;
            LongBinaryOperator r13 = this.reducer;
            if (r13 == null) goto L28;
            long r14 = this.basis;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L12;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L12;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            MapReduceValuesToLongTask<K, V> r8 = new MapReduceValuesToLongTask(this, r2, r3, r4, this.tab, this.rights, r12, r14, r13);
            this.rights = r8;
            r8.fork();
            r12 = r12;
            r10 = r10;
        L12:
            ToLongFunction<? super V> r16 = r12;
        L13:
            i<K, V> r0 = advance();
            if (r0 == null) goto L16;
            r14 = r13.applyAsLong(r14, r16.applyAsLong(r0.d));
            goto L13
        L16:
            this.result = r14;
            CountedCompleter<?> r1 = firstComplete();
        L17:
            if (r1 == null) goto L29;
            MapReduceValuesToLongTask r5 = (MapReduceValuesToLongTask) ZeusTransformUtils.preCheckCast(r1, MapReduceValuesToLongTask.class, "com.obric.memorydata.plugin");
            MapReduceValuesToLongTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L21;
            r5.result = r13.applyAsLong(r5.result, r6.result);
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L21:
            r1 = r1.nextComplete();
            goto L17
        L29:
            return;
        L28:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }
    }

    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>> {
        ReduceEntriesTask<K, V> nextRight;
        final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;

        ReduceEntriesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, ReduceEntriesTask<K, V> r8, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> r9) {
            BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r9, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.reducer = r10;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> r8 = this.reducer;
            if (r8 == null) goto L29;
            int r9 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r9) >>> 1;
            if (r3 <= r9) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            ReduceEntriesTask<K, V> r10 = new ReduceEntriesTask(this, r2, r3, r4, this.tab, this.rights, r8);
            this.rights = r10;
            r10.fork();
        L10:
            Map.Entry<K, V> r0 = null;
        L11:
            i<K, V> r1 = advance();
            if (r1 == null) goto L16;
            if (r0 == null) goto L14;
            r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.apply(r0, r1), Map.Entry.class, "com.obric.memorydata.plugin");
            goto L11
        L14:
            r0 = r1;
            goto L11
        L16:
            this.result = r0;
            CountedCompleter<?> r11 = firstComplete();
        L17:
            if (r11 == null) goto L42;
            ReduceEntriesTask r5 = (ReduceEntriesTask) ZeusTransformUtils.preCheckCast(r11, ReduceEntriesTask.class, "com.obric.memorydata.plugin");
            ReduceEntriesTask<K, V> r6 = r5.rights;
        L19:
            if (r6 == null) goto L28;
            Map.Entry<K, V> r7 = r6.result;
            if (r7 == null) goto L27;
            Map.Entry<K, V> r12 = r5.result;
            if (r12 == null) goto L26;
            r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.apply(r12, r7), Map.Entry.class, "com.obric.memorydata.plugin");
        L26:
            r5.result = r7;
        L27:
            r6 = r6.nextRight;
            r5.rights = r6;
            goto L19
        L28:
            r11 = r11.nextComplete();
            goto L17
        L42:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public /* bridge */ /* synthetic */ Object getRawResult() {
            return getRawResult();
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Map.Entry<K, V> getRawResult() {
            return this.result;
        }
    }

    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K> {
        ReduceKeysTask<K, V> nextRight;
        final BiFunction<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;

        ReduceKeysTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, ReduceKeysTask<K, V> r8, BiFunction<? super K, ? super K, ? extends K> r9) {
            BiFunction<? super K, ? super K, ? extends K> r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r9, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.reducer = r10;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super K, ? extends K> r8 = this.reducer;
            if (r8 == null) goto L32;
            int r9 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r9) >>> 1;
            if (r3 <= r9) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            ReduceKeysTask<K, V> r10 = new ReduceKeysTask(this, r2, r3, r4, this.tab, this.rights, r8);
            this.rights = r10;
            r10.fork();
        L10:
            K r0 = null;
        L11:
            i<K, V> r1 = advance();
            if (r1 == null) goto L19;
            K r5 = r1.c;
            if (r0 == null) goto L15;
            if (r5 == null) goto L11;
            r0 = r8.apply(r0, r5);
            goto L11
        L15:
            r0 = r5;
            goto L11
        L19:
            this.result = r0;
            CountedCompleter<?> r11 = firstComplete();
        L20:
            if (r11 == null) goto L47;
            ReduceKeysTask r6 = (ReduceKeysTask) ZeusTransformUtils.preCheckCast(r11, ReduceKeysTask.class, "com.obric.memorydata.plugin");
            ReduceKeysTask<K, V> r7 = r6.rights;
        L22:
            if (r7 == null) goto L31;
            K r12 = r7.result;
            if (r12 == null) goto L30;
            K r13 = r6.result;
            if (r13 == null) goto L29;
            r12 = r8.apply(r13, r12);
        L29:
            r6.result = (K) r12;
        L30:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L22
        L31:
            r11 = r11.nextComplete();
            goto L20
        L47:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final K getRawResult() {
            return this.result;
        }
    }

    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V> {
        ReduceValuesTask<K, V> nextRight;
        final BiFunction<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;

        ReduceValuesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, ReduceValuesTask<K, V> r8, BiFunction<? super V, ? super V, ? extends V> r9) {
            BiFunction<? super V, ? super V, ? extends V> r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r9, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.nextRight = r8;
            this.reducer = r10;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super V, ? super V, ? extends V> r8 = this.reducer;
            if (r8 == null) goto L30;
            int r9 = this.baseIndex;
        L6:
            if (this.batch <= 0) goto L10;
            int r4 = this.baseLimit;
            int r3 = (r4 + r9) >>> 1;
            if (r3 <= r9) goto L10;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            ReduceValuesTask<K, V> r10 = new ReduceValuesTask(this, r2, r3, r4, this.tab, this.rights, r8);
            this.rights = r10;
            r10.fork();
        L10:
            V r0 = null;
        L11:
            i<K, V> r1 = advance();
            if (r1 == null) goto L17;
            V r5 = r1.d;
            if (r0 == null) goto L15;
            r0 = r8.apply(r0, r5);
            goto L11
        L15:
            r0 = r5;
            goto L11
        L17:
            this.result = r0;
            CountedCompleter<?> r11 = firstComplete();
        L18:
            if (r11 == null) goto L43;
            ReduceValuesTask r6 = (ReduceValuesTask) ZeusTransformUtils.preCheckCast(r11, ReduceValuesTask.class, "com.obric.memorydata.plugin");
            ReduceValuesTask<K, V> r7 = r6.rights;
        L20:
            if (r7 == null) goto L29;
            V r12 = r7.result;
            if (r12 == null) goto L28;
            V r13 = r6.result;
            if (r13 == null) goto L27;
            r12 = r8.apply(r13, r12);
        L27:
            r6.result = (V) r12;
        L28:
            r7 = r7.nextRight;
            r6.rights = r7;
            goto L20
        L29:
            r11 = r11.nextComplete();
            goto L18
        L43:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final V getRawResult() {
            return this.result;
        }
    }

    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<Map.Entry<K, V>, ? extends U> searchFunction;

        SearchEntriesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<Map.Entry<K, V>, ? extends U> r8, AtomicReference<U> r9) {
            Function<Map.Entry<K, V>, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.searchFunction = r10;
            this.result = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<Map.Entry<K, V>, ? extends U> r8 = this.searchFunction;
            if (r8 == null) goto L34;
            AtomicReference<U> r9 = this.result;
            if (r9 == null) goto L35;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L16;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L16;
            if (r9.get() != null) goto L13;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new SearchEntriesTask(this, r2, r3, r4, this.tab, r8, r9).fork();
            goto L8
        L13:
            return;
        L16:
            if (r9.get() != null) goto L38;
            i<K, V> r0 = advance();
            if (r0 == null) goto L19;
            U r1 = r8.apply(r0);
            if (r1 == null) goto L16;
            if (r9.compareAndSet(null, r1) == false) goto L37;
            quietlyCompleteRoot();
            return;
        L37:
            return;
        L19:
            propagateCompletion();
            return;
        L38:
            return;
        L35:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super K, ? extends U> searchFunction;

        SearchKeysTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<? super K, ? extends U> r8, AtomicReference<U> r9) {
            Function<? super K, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.searchFunction = r10;
            this.result = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super K, ? extends U> r8 = this.searchFunction;
            if (r8 == null) goto L34;
            AtomicReference<U> r9 = this.result;
            if (r9 == null) goto L35;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L16;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L16;
            if (r9.get() != null) goto L13;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new SearchKeysTask(this, r2, r3, r4, this.tab, r8, r9).fork();
            goto L8
        L13:
            return;
        L16:
            if (r9.get() != null) goto L38;
            i<K, V> r0 = advance();
            if (r0 == null) goto L19;
            U r1 = r8.apply(r0.c);
            if (r1 == null) goto L16;
            if (r9.compareAndSet(null, r1) == false) goto L37;
            quietlyCompleteRoot();
            return;
        L37:
            return;
        L19:
            propagateCompletion();
            return;
        L38:
            return;
        L35:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final BiFunction<? super K, ? super V, ? extends U> searchFunction;

        SearchMappingsTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, BiFunction<? super K, ? super V, ? extends U> r8, AtomicReference<U> r9) {
            BiFunction<? super K, ? super V, ? extends U> r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r8, BiFunction.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.searchFunction = r10;
            this.result = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super V, ? extends U> r8 = this.searchFunction;
            if (r8 == null) goto L34;
            AtomicReference<U> r9 = this.result;
            if (r9 == null) goto L35;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L16;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L16;
            if (r9.get() != null) goto L13;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new SearchMappingsTask(this, r2, r3, r4, this.tab, r8, r9).fork();
            goto L8
        L13:
            return;
        L16:
            if (r9.get() != null) goto L38;
            i<K, V> r0 = advance();
            if (r0 == null) goto L19;
            U r1 = r8.apply(r0.c, r0.d);
            if (r1 == null) goto L16;
            if (r9.compareAndSet(null, r1) == false) goto L37;
            quietlyCompleteRoot();
            return;
        L37:
            return;
        L19:
            propagateCompletion();
            return;
        L38:
            return;
        L35:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super V, ? extends U> searchFunction;

        SearchValuesTask(BulkTask<K, V, ?> r3, int r4, int r5, int r6, i<K, V>[] r7, Function<? super V, ? extends U> r8, AtomicReference<U> r9) {
            Function<? super V, ? extends U> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
            super(r3, r4, r5, r6, r7);
            this.searchFunction = r10;
            this.result = r9;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Function<? super V, ? extends U> r8 = this.searchFunction;
            if (r8 == null) goto L34;
            AtomicReference<U> r9 = this.result;
            if (r9 == null) goto L35;
            int r10 = this.baseIndex;
        L8:
            if (this.batch <= 0) goto L16;
            int r4 = this.baseLimit;
            int r3 = (r4 + r10) >>> 1;
            if (r3 <= r10) goto L16;
            if (r9.get() != null) goto L13;
            addToPendingCount(1);
            int r2 = this.batch >>> 1;
            this.batch = r2;
            this.baseLimit = r3;
            new SearchValuesTask(this, r2, r3, r4, this.tab, r8, r9).fork();
            goto L8
        L13:
            return;
        L16:
            if (r9.get() != null) goto L38;
            i<K, V> r0 = advance();
            if (r0 == null) goto L19;
            U r1 = r8.apply(r0.d);
            if (r1 == null) goto L16;
            if (r9.compareAndSet(null, r1) == false) goto L37;
            quietlyCompleteRoot();
            return;
        L37:
            return;
        L19:
            propagateCompletion();
            return;
        L38:
            return;
        L35:
            return;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }
    }

    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        Segment(float r1) {
            this.loadFactor = r1;
        }
    }

    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Serializable, Collection<V> {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMap<K, V> r1) {
            super(r1);
        }

        @Override // java.util.Collection
        public final boolean add(V r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object r1) {
            return this.map.containsValue(r1);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> r5) {
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r6);
            i<K, V>[] r4 = this.map.table;
            if (r4 == null) goto L8;
            l r0 = new l(r4, r4.length, 0, r4.length);
        L5:
            i<K, V> r7 = r0.b();
            if (r7 == null) goto L10;
            r6.accept(r7.d);
            goto L5
        L10:
            return;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            ConcurrentHashMap<K, V> r5 = this.map;
            i<K, V>[] r1 = r5.table;
            if (r1 != null) goto L5;
            int r6 = 0;
        L6:
            int r4 = r6;
            return new o(r1, r4, 0, r4, r5);
        L5:
            r6 = r1.length;
            goto L6
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean remove(Object r2) {
            if (r2 == null) goto L10;
            Iterator<V> r1 = iterator();
        L5:
            if (r1.hasNext() == false) goto L15;
            if (r2.equals(r1.next()) == false) goto L5;
            r1.remove();
            return true;
        L15:
            return false;
        L10:
            return false;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            boolean r0 = false;
            Iterator<V> r2 = iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            if (r4.contains(r2.next()) == false) goto L4;
            r2.remove();
            r0 = true;
            goto L4
        L8:
            return r0;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super V> r3) {
            Predicate<? super V> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            return this.map.removeValueIf(r4);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            ConcurrentHashMap<K, V> r9 = this.map;
            long r0 = r9.sumCount();
            i<K, V>[] r3 = r9.table;
            if (r3 != null) goto L5;
            int r10 = 0;
        L6:
            int r6 = r10;
            long r7 = 0;
            if (r0 < 0) goto L11;
            r7 = r0;
        L11:
            return new p(r3, r6, 0, r6, r7);
        L5:
            r10 = r3.length;
            goto L6
        }
    }

    static class a<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConcurrentHashMap<K, V> f18074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        i<K, V> f18075b;

        a(i<K, V>[] r1, int r2, int r3, int r4, ConcurrentHashMap<K, V> r5) {
            super(r1, r2, r3, r4);
            this.f18074a = r5;
            b();
        }

        public final boolean hasMoreElements() {
            if (this.d == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean hasNext() {
            if (this.d == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            i<K, V> r0 = this.f18075b;
            if (r0 == null) goto L7;
            this.f18075b = null;
            this.f18074a.replaceNode(r0.c, null, null);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    @Contended
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f18076a;

        b(long r1) {
            this.f18076a = r1;
        }
    }

    static final class c<K, V> extends a<K, V> implements Iterator<Map.Entry<K, V>> {
        c(i<K, V>[] r1, int r2, int r3, int r4, ConcurrentHashMap<K, V> r5) {
            super(r1, r2, r3, r4, r5);
        }

        public final Map.Entry<K, V> a() {
            i<K, V> r0 = this.d;
            if (r0 == null) goto L7;
            K r1 = r0.c;
            V r2 = r0.d;
            this.f18075b = r0;
            b();
            return new h(r1, r2, this.f18074a);
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }
    }

    static final class d<K, V> extends l<K, V> implements Spliterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConcurrentHashMap<K, V> f18077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f18078b;

        d(i<K, V>[] r1, int r2, int r3, int r4, long r5, ConcurrentHashMap<K, V> r7) {
            super(r1, r2, r3, r4);
            this.f18077a = r7;
            this.f18078b = r5;
        }

        public d<K, V> a() {
            int r0 = this.h;
            int r5 = this.i;
            int r4 = (r0 + r5) >>> 1;
            if (r4 > r0) goto L5;
            return null;
        L5:
            i<K, V>[] r3 = this.c;
            int r6 = this.j;
            this.i = r4;
            long r7 = this.f18078b >>> 1;
            this.f18078b = r7;
            return new d(r3, r6, r4, r5, r7, this.f18077a);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f18078b;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> r5) {
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r6);
        L3:
            i<K, V> r0 = b();
            if (r0 == null) goto L6;
            r6.accept(new h(r0.c, r0.d, this.f18077a));
            goto L3
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r5);
            i<K, V> r0 = b();
            if (r0 != null) goto L6;
            return false;
        L6:
            r5.accept(new h(r0.c, r0.d, this.f18077a));
            return true;
        }

        @Override // java.util.Spliterator
        public /* synthetic */ Spliterator trySplit() {
            return a();
        }
    }

    static final class e<K, V> extends i<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<K, V>[] f18079a;

        e(i<K, V>[] r3) {
            super(-1, null, null);
            this.f18079a = r3;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.i
        i<K, V> a(int r5, Object r6) {
        L3:
            i<K, V>[] r4 = this.f18079a;
            if (r6 == null) goto L27;
            if (r4 == null) goto L27;
            int r2 = r4.length;
            if (r2 == 0) goto L27;
            i<K, V> r7 = ConcurrentHashMap.tabAt(r4, (r2 - 1) & r5);
            if (r7 == null) goto L27;
        L11:
            int r3 = r7.f18083b;
            if (r3 != r5) goto L19;
            K r8 = r7.c;
            if (r8 == r6) goto L18;
            if (r8 == null) goto L19;
            if (r6.equals(r8) == false) goto L19;
        L18:
            return r7;
        L19:
            if (r3 < 0) goto L21;
            r7 = r7.e;
            if (r7 != null) goto L11;
        L21:
            if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L24;
            e<K, V> this = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
            goto L3
        L24:
            return r7.a(r5, r6);
        L27:
            return null;
        }
    }

    static final class f<K, V> extends a<K, V> implements Enumeration<K>, Iterator<K> {
        f(i<K, V>[] r1, int r2, int r3, int r4, ConcurrentHashMap<K, V> r5) {
            super(r1, r2, r3, r4, r5);
        }

        @Override // java.util.Iterator
        public final K next() {
            i<K, V> r0 = this.d;
            if (r0 == null) goto L7;
            K r1 = r0.c;
            this.f18075b = r0;
            b();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    static final class g<K, V> extends l<K, V> implements Spliterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f18080a;

        g(i<K, V>[] r1, int r2, int r3, int r4, long r5) {
            super(r1, r2, r3, r4);
            this.f18080a = r5;
        }

        public g<K, V> a() {
            int r0 = this.h;
            int r5 = this.i;
            int r4 = (r0 + r5) >>> 1;
            if (r4 > r0) goto L5;
            return null;
        L5:
            i<K, V>[] r3 = this.c;
            int r6 = this.j;
            this.i = r4;
            long r7 = this.f18080a >>> 1;
            this.f18080a = r7;
            return new g(r3, r6, r4, r5, r7);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f18080a;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
        L3:
            i<K, V> r0 = b();
            if (r0 == null) goto L6;
            r4.accept(r0.c);
            goto L3
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            i<K, V> r2 = b();
            if (r2 != null) goto L6;
            return false;
        L6:
            r4.accept(r2.c);
            return true;
        }

        @Override // java.util.Spliterator
        public /* synthetic */ Spliterator trySplit() {
            return a();
        }
    }

    static final class h<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f18081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f18082b;
        final ConcurrentHashMap<K, V> c;

        h(K r1, V r2, ConcurrentHashMap<K, V> r3) {
            this.f18081a = r1;
            this.f18082b = r2;
            this.c = r3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L17;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r4.getKey();
            if (r0 == null) goto L17;
            Object r5 = r4.getValue();
            if (r5 == null) goto L17;
            K r1 = this.f18081a;
            if (r0 != r1) goto L11;
        L12:
            V r2 = this.f18082b;
            if (r5 != r2) goto L15;
        L16:
            return true;
        L15:
            if (r5.equals(r2) == false) goto L17;
        L11:
            if (r0.equals(r1) == true) goto L12;
        L17:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f18081a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f18082b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r0 = this.f18081a.hashCode();
            return this.f18082b.hashCode() ^ r0;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            Objects.requireNonNull(r3);
            V r0 = this.f18082b;
            this.f18082b = r3;
            this.c.put(this.f18081a, r3);
            return r0;
        }

        public String toString() {
            return org.ehcache.impl.internal.concurrent.b.a(this.f18081a, this.f18082b);
        }
    }

    static class i<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f18083b;
        final K c;
        volatile V d;
        volatile i<K, V> e;

        i(int r1, K r2, V r3) {
            this.f18083b = r1;
            this.c = r2;
            this.d = r3;
        }

        i(int r1, K r2, V r3, i<K, V> r4) {
            this(r1, r2, r3);
            this.e = r4;
        }

        i<K, V> a(int r2, Object r3) {
            if (r3 != null) goto L4;
            return null;
        L4:
            if (this.f18083b != r2) goto L11;
            K r0 = this.c;
            if (r0 == r3) goto L10;
            if (r0 == null) goto L11;
            if (r3.equals(r0) == false) goto L11;
        L10:
            return this;
        L11:
            i<K, V> this = this.e;
            if (this != null) goto L4;
            return null;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L17;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r4.getKey();
            if (r0 == null) goto L17;
            Object r5 = r4.getValue();
            if (r5 == null) goto L17;
            K r1 = this.c;
            if (r0 != r1) goto L11;
        L12:
            V r2 = this.d;
            if (r5 != r2) goto L15;
        L16:
            return true;
        L15:
            if (r5.equals(r2) == false) goto L17;
        L11:
            if (r0.equals(r1) == true) goto L12;
        L17:
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.d;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int r0 = this.c.hashCode();
            return this.d.hashCode() ^ r0;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r1) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return org.ehcache.impl.internal.concurrent.b.a(this.c, this.d);
        }
    }

    static final class j<K, V> extends i<K, V> {
        j() {
            super(-3, null, null);
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.i
        i<K, V> a(int r1, Object r2) {
            return null;
        }
    }

    static final class k<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18085b;
        i<K, V>[] c;
        k<K, V> d;

        k() {
        }
    }

    static class l<K, V> {
        i<K, V>[] c;
        i<K, V> d;
        k<K, V> e;
        k<K, V> f;
        int g;
        int h;
        int i;
        final int j;

        l(i<K, V>[] r1, int r2, int r3, int r4) {
            this.c = r1;
            this.j = r2;
            this.g = r3;
            this.h = r3;
            this.i = r4;
            this.d = null;
        }

        private void a(int r4) {
        L2:
            k<K, V> r0 = this.e;
            if (r0 == null) goto L7;
            int r1 = this.g;
            int r2 = r0.f18084a;
            int r3 = r1 + r2;
            this.g = r3;
            if (r3 < r4) goto L7;
            this.g = r0.f18085b;
            this.c = r0.c;
            r0.c = null;
            k<K, V> r5 = r0.d;
            r0.d = this.f;
            this.e = r5;
            this.f = r0;
            r4 = r2;
        L7:
            if (r0 != null) goto L14;
            int r6 = this.g + this.j;
            this.g = r6;
            if (r6 < r4) goto L15;
            int r7 = this.h + 1;
            this.h = r7;
            this.g = r7;
            return;
        L15:
            return;
        }

        private void a(i<K, V>[] r3, int r4, int r5) {
            k<K, V> r0 = this.f;
            if (r0 == null) goto L5;
            this.f = r0.d;
        L6:
            r0.c = r3;
            r0.f18084a = r5;
            r0.f18085b = r4;
            r0.d = this.e;
            this.e = r0;
            return;
        L5:
            r0 = new k();
            goto L6
        }

        final i<K, V> b() {
            i<K, V> r0 = this.d;
            if (r0 == null) goto L5;
            r0 = r0.e;
        L5:
            if (r0 != null) goto L6;
            if (this.h >= this.i) goto L34;
            i<K, V>[] r1 = this.c;
            if (r1 == null) goto L34;
            int r2 = r1.length;
            int r3 = this.g;
            if (r2 <= r3) goto L34;
            if (r3 < 0) goto L34;
            i<K, V> r4 = ConcurrentHashMap.tabAt(r1, r3);
            if (r4 == null) goto L27;
            if (r4.f18083b >= 0) goto L27;
            if (ZeusTransformUtils.instanceOf(r4, e.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r4, m.class) == false) goto L26;
            r0 = ((m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin")).f;
        L29:
            if (this.e != null) goto L30;
            int r5 = r3 + this.j;
            this.g = r5;
            if (r5 < r2) goto L5;
            int r6 = this.h + 1;
            this.h = r6;
            this.g = r6;
            goto L5
        L30:
            a(r2);
            goto L5
        L26:
            r0 = null;
            goto L29
        L22:
            this.c = ((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin")).f18079a;
            a(r1, r3, r2);
            r0 = null;
        L27:
            r0 = r4;
        L34:
            this.d = null;
            return null;
        L6:
            this.d = r0;
            return r0;
        }
    }

    static final class m<K, V> extends i<K, V> {
        static final /* synthetic */ boolean i = false;
        private static final Unsafe j = null;
        private static final long k = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        n<K, V> f18086a;
        volatile n<K, V> f;
        volatile Thread g;
        volatile int h;

        static {
            i = true;
            Unsafe r0 = org.ehcache.impl.internal.concurrent.b.f18089a;
            j = r0;
            k = r0.objectFieldOffset(m.class.getDeclaredField(com.loc.o.g));     // Catch: ReflectiveOperationException -> L5
            return;
        L5:
            e = move-exception;
            throw new ExceptionInInitializerError(e);
        }

        m(n<K, V> r10) {
            super(-2, null, null);
            this.f = r10;
            n<K, V> r0 = null;
        L3:
            if (r10 == null) goto L32;
            n<K, V> r2 = (n) ZeusTransformUtils.preCheckCast(r10.e, n.class, "com.obric.memorydata.plugin");
            r10.g = null;
            r10.f = null;
            if (r0 != null) goto L8;
            r10.f18087a = null;
            r10.i = false;
        L7:
            r0 = r10;
            r10 = r2;
            goto L3
        L8:
            K r3 = r10.c;
            int r4 = r10.f18083b;
            n<K, V> r5 = r0;
            Class<?> r6 = null;
        L9:
            K r7 = r5.c;
            int r8 = r5.f18083b;
            if (r8 <= r4) goto L12;
            int r9 = -1;
        L21:
            if (r9 > 0) goto L23;
            n<K, V> r11 = r5.f;
        L24:
            if (r11 == null) goto L25;
            r5 = r11;
            goto L9
        L25:
            r10.f18087a = r5;
            if (r9 > 0) goto L28;
            r5.f = r10;
        L29:
            r10 = c(r0, r10);
            goto L7
        L28:
            r5.g = r10;
            goto L29
        L23:
            r11 = r5.g;
            goto L24
        L12:
            if (r8 >= r4) goto L14;
            r9 = 1;
            goto L21
        L14:
            if (r6 != null) goto L17;
            r6 = ConcurrentHashMap.comparableClassFor(r3);
            if (r6 != null) goto L17;
        L19:
            r9 = a(r3, r7);
        L17:
            int r12 = ConcurrentHashMap.compareComparables(r6, r3, r7);
            if (r12 == 0) goto L19;
            r9 = r12;
            goto L21
        L32:
            this.f18086a = r0;
            if (i == false) goto L35;
            return;
        L35:
            if (b(r0) == false) goto L38;
            return;
        L38:
            throw new AssertionError();
        }

        static int a(Object r2, Object r3) {
            if (r2 == null) goto L7;
            if (r3 == null) goto L7;
            int r0 = r2.getClass().getName().compareTo(r3.getClass().getName());
            if (r0 == 0) goto L7;
            return r0;
        L7:
            if (System.identityHashCode(r2) > System.identityHashCode(r3)) goto L9;
            int r4 = -1;
        L11:
            return r4;
        L9:
            r4 = 1;
            goto L11
        }

        static <K, V> n<K, V> a(n<K, V> r3, n<K, V> r4) {
            if (r4 == null) goto L16;
            n<K, V> r0 = r4.g;
            if (r0 == null) goto L16;
            n<K, V> r1 = r0.f;
            r4.g = r1;
            if (r1 == null) goto L8;
            r1.f18087a = r4;
        L8:
            n<K, V> r2 = r4.f18087a;
            r0.f18087a = r2;
            if (r2 != null) goto L12;
            r0.i = false;
            r3 = r0;
        L15:
            r0.f = r4;
            r4.f18087a = r0;
            goto L16
        L12:
            if (r2.f != r4) goto L14;
            r2.f = r0;
            goto L15
        L14:
            r2.g = r0;
        L16:
            return r3;
        }

        private final void a() {
            if (j.compareAndSwapInt(this, k, 0, 1) == true) goto L6;
            c();
            return;
        }

        static <K, V> n<K, V> b(n<K, V> r3, n<K, V> r4) {
            if (r4 == null) goto L16;
            n<K, V> r0 = r4.f;
            if (r0 == null) goto L16;
            n<K, V> r1 = r0.g;
            r4.f = r1;
            if (r1 == null) goto L8;
            r1.f18087a = r4;
        L8:
            n<K, V> r2 = r4.f18087a;
            r0.f18087a = r2;
            if (r2 != null) goto L12;
            r0.i = false;
            r3 = r0;
        L15:
            r0.g = r4;
            r4.f18087a = r0;
            goto L16
        L12:
            if (r2.g != r4) goto L14;
            r2.g = r0;
            goto L15
        L14:
            r2.f = r0;
        L16:
            return r3;
        }

        private final void b() {
            this.h = 0;
        }

        static <K, V> boolean b(n<K, V> r7) {
            n<K, V> r0 = r7.f18087a;
            n<K, V> r1 = r7.f;
            n<K, V> r2 = r7.g;
            n<K, V> r3 = r7.h;
            n r4 = (n) ZeusTransformUtils.preCheckCast(r7.e, n.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
        L7:
            if (r4 != null) goto L9;
        L11:
            if (r0 != null) goto L13;
        L17:
            if (r1 != null) goto L19;
        L23:
            if (r2 == null) goto L30;
            if (r2.f18087a == r7) goto L27;
        L28:
            return false;
        L27:
            if (r2.f18083b < r7.f18083b) goto L28;
        L30:
            if (r7.i == false) goto L38;
            if (r1 == null) goto L38;
            if (r1.i == false) goto L38;
            if (r2 == null) goto L38;
            if (r2.i == false) goto L38;
            return false;
        L38:
            if (r1 != null) goto L40;
        L42:
            if (r2 != null) goto L44;
            return true;
        L44:
            if (b(r2) == true) goto L48;
            return false;
        L48:
            return true;
        L40:
            if (b(r1) == true) goto L42;
            return false;
        L19:
            if (r1.f18087a == r7) goto L21;
        L22:
            return false;
        L21:
            if (r1.f18083b <= r7.f18083b) goto L23;
        L13:
            if (r7 == r0.f) goto L17;
            if (r7 == r0.g) goto L17;
            return false;
        L9:
            if (r4.h == r7) goto L11;
            return false;
        L5:
            if (r3.e == r7) goto L7;
            return false;
        }

        static <K, V> n<K, V> c(n<K, V> r8, n<K, V> r9) {
            r9.i = true;
        L3:
            n<K, V> r1 = r9.f18087a;
            if (r1 == null) goto L5;
            if (r1.i == false) goto L45;
            n<K, V> r3 = r1.f18087a;
            if (r3 == null) goto L45;
            n<K, V> r4 = r3.f;
            if (r1 == r4) goto L14;
            if (r4 == null) goto L35;
            if (r4.i == false) goto L35;
        L33:
            r4.i = false;
            r1.i = false;
            r3.i = true;
            r9 = r3;
        L35:
            if (r9 != r1.f) goto L41;
            r8 = b(r8, r1);
            n<K, V> r10 = r1.f18087a;
            if (r10 != null) goto L39;
            r3 = null;
        L40:
            r1 = r10;
            r9 = r1;
            goto L41
        L39:
            r3 = r10.f18087a;
        L41:
            if (r1 == null) goto L3;
            r1.i = false;
            if (r3 == null) goto L3;
            r3.i = true;
            r8 = a(r8, r3);
            goto L3
        L14:
            r4 = r3.g;
            if (r4 == null) goto L20;
            if (r4.i == true) goto L33;
        L20:
            if (r9 != r1.g) goto L26;
            r8 = a(r8, r1);
            n<K, V> r11 = r1.f18087a;
            if (r11 != null) goto L24;
            r3 = null;
        L25:
            r1 = r11;
            r9 = r1;
            goto L26
        L24:
            r3 = r11.f18087a;
        L26:
            if (r1 == null) goto L3;
            r1.i = false;
            if (r3 == null) goto L3;
            r3.i = true;
            r8 = b(r8, r3);
        L45:
            return r8;
        L5:
            r9.i = false;
            return r9;
        }

        private final void c() {
            boolean r0 = false;
        L3:
            int r5 = this.h;
            if ((r5 & (-3)) == 0) goto L6;
            if ((r5 & 2) == 0) goto L13;
            if (r0 == false) goto L3;
            LockSupport.park(this);
            goto L3
        L13:
            if (j.compareAndSwapInt(this, k, r5, r5 | 2) == false) goto L3;
            r0 = true;
            this.g = Thread.currentThread();
            goto L3
        L6:
            if (j.compareAndSwapInt(this, k, r5, 1) == false) goto L3;
            if (r0 == false) goto L30;
            this.g = null;
            return;
        }

        static <K, V> n<K, V> d(n<K, V> r8, n<K, V> r9) {
        L2:
            if (r9 == null) goto L90;
            if (r9 == r8) goto L90;
            n<K, V> r0 = r9.f18087a;
            if (r0 == null) goto L7;
            if (r9.i == true) goto L11;
            n<K, V> r2 = r0.f;
            n<K, V> r3 = null;
            if (r2 != r9) goto L54;
            r2 = r0.g;
            if (r2 != null) goto L18;
        L23:
            if (r2 == null) goto L62;
            n<K, V> r5 = r2.f;
            n<K, V> r6 = r2.g;
            if (r6 != null) goto L28;
        L29:
            if (r5 == null) goto L53;
            if (r5.i == false) goto L53;
        L33:
            if (r6 != null) goto L35;
        L36:
            if (r5 == null) goto L38;
            r5.i = false;
        L38:
            r2.i = true;
            r8 = b(r8, r2);
            r0 = r9.f18087a;
            if (r0 == null) goto L42;
            r3 = r0.g;
        L42:
            r2 = r3;
        L43:
            if (r2 == null) goto L50;
            if (r0 != null) goto L46;
            boolean r10 = false;
        L47:
            r2.i = r10;
            n<K, V> r11 = r2.g;
            if (r11 == null) goto L50;
            r11.i = false;
            goto L50
        L46:
            r10 = r0.i;
        L50:
            if (r0 == null) goto L52;
            r0.i = false;
            r8 = a(r8, r0);
        L52:
            r9 = r8;
            goto L2
        L35:
            if (r6.i == true) goto L43;
        L53:
            r2.i = true;
            goto L62
        L28:
            if (r6.i == true) goto L33;
        L62:
            r9 = r0;
            goto L2
        L18:
            if (r2.i == false) goto L23;
            r2.i = false;
            r0.i = true;
            r8 = a(r8, r0);
            r0 = r9.f18087a;
            if (r0 != null) goto L22;
            r2 = null;
            goto L23
        L22:
            r2 = r0.g;
            goto L23
        L54:
            if (r2 != null) goto L56;
        L61:
            if (r2 == null) goto L62;
            n<K, V> r7 = r2.f;
            n<K, V> r12 = r2.g;
            if (r7 != null) goto L66;
        L67:
            if (r12 == null) goto L53;
            if (r12.i == false) goto L53;
        L71:
            if (r7 != null) goto L73;
        L74:
            if (r12 == null) goto L76;
            r12.i = false;
        L76:
            r2.i = true;
            r8 = a(r8, r2);
            r0 = r9.f18087a;
            if (r0 == null) goto L80;
            r3 = r0.f;
        L80:
            r2 = r3;
        L81:
            if (r2 == null) goto L88;
            if (r0 != null) goto L84;
            boolean r13 = false;
        L85:
            r2.i = r13;
            n<K, V> r14 = r2.f;
            if (r14 == null) goto L88;
            r14.i = false;
            goto L88
        L84:
            r13 = r0.i;
        L88:
            if (r0 == null) goto L52;
            r0.i = false;
            r8 = b(r8, r0);
            goto L52
        L73:
            if (r7.i == true) goto L81;
        L66:
            if (r7.i == true) goto L71;
        L56:
            if (r2.i == false) goto L61;
            r2.i = false;
            r0.i = true;
            r8 = b(r8, r0);
            r0 = r9.f18087a;
            if (r0 != null) goto L60;
            r2 = null;
            goto L61
        L60:
            r2 = r0.f;
            goto L61
        L11:
            r9.i = false;
            return r8;
        L7:
            r9.i = false;
            return r9;
        L90:
            return r8;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.i
        final i<K, V> a(int r12, Object r13) {
            n<K, V> r0 = null;
            if (r13 == null) goto L37;
            i<K, V> r1 = this.f;
        L5:
            if (r1 == null) goto L37;
            int r6 = this.h;
            if ((r6 & 3) != 0) goto L9;
            Unsafe r8 = j;
            long r9 = k;
            if (r8.compareAndSwapInt(this, r9, r6, r6 + 4) == false) goto L5;
            n<K, V> r3 = this.f18086a;     // Catch: Throwable -> L30
            if (r3 == null) goto L25;
            r0 = r3.a(r12, r13, null);     // Catch: Throwable -> L30
        L25:
            if (r8.getAndAddInt(this, r9, -4) != 6) goto L29;
            Thread r11 = this.g;
            if (r11 == null) goto L29;
            LockSupport.unpark(r11);
        L29:
            return r0;
        L30:
            th = move-exception;
            if (j.getAndAddInt(this, k, -4) != 6) goto L36;
            Thread r14 = this.g;
            if (r14 == null) goto L36;
            LockSupport.unpark(r14);
        L36:
            throw th;
        L9:
            if (r1.f18083b != r12) goto L16;
            K r2 = r1.c;
            if (r2 == r13) goto L15;
            if (r2 == null) goto L16;
            if (r13.equals(r2) == false) goto L16;
        L15:
            return r1;
        L16:
            r1 = r1.e;
        L37:
            return null;
        }

        final n<K, V> a(int r13, K r14, V r15) {
            n<K, V> r0 = this.f18086a;
            boolean r2 = false;
            Class<?> r3 = null;
        L3:
            if (r0 == null) goto L4;
            int r4 = r0.f18083b;
            if (r4 <= r13) goto L9;
            int r5 = -1;
        L8:
            int r10 = r5;
        L35:
            if (r10 > 0) goto L37;
            n<K, V> r6 = r0.f;
        L38:
            if (r6 == null) goto L39;
            r0 = r6;
            goto L3
        L39:
            n<K, V> r7 = this.f;
            n<K, V> r11 = new n(r13, r14, r15, r7, r0);
            this.f = r11;
            if (r7 == null) goto L42;
            r7.h = r11;
        L42:
            if (r10 > 0) goto L44;
            r0.f = r11;
        L46:
            if (r0.i == true) goto L48;
            r11.i = true;
        L52:
            if (i == false) goto L54;
        L58:
            return null;
        L54:
            if (b(this.f18086a) == true) goto L58;
            throw new AssertionError();
        L48:
            a();
            this.f18086a = c(this.f18086a, r11);     // Catch: Throwable -> L59
            b();
        L59:
            th = move-exception;
            b();
            throw th;
        L44:
            r0.g = r11;
            goto L46
        L37:
            r6 = r0.g;
            goto L38
        L9:
            if (r4 >= r13) goto L11;
            r10 = 1;
            goto L35
        L11:
            K r8 = r0.c;
            if (r8 == r14) goto L63;
            if (r8 != null) goto L15;
        L17:
            if (r3 != null) goto L20;
            r3 = ConcurrentHashMap.comparableClassFor(r14);
            if (r3 != null) goto L20;
        L22:
            if (r2 == true) goto L33;
            n<K, V> r9 = r0.f;
            if (r9 == null) goto L27;
            n<K, V> r12 = r9.a(r13, r14, r3);
            if (r12 == null) goto L27;
        L31:
            return r12;
        L27:
            n<K, V> r16 = r0.g;
            if (r16 == null) goto L32;
            r12 = r16.a(r13, r14, r3);
            if (r12 != null) goto L31;
        L32:
            r2 = true;
        L33:
            r5 = a(r14, r8);
        L20:
            int r17 = ConcurrentHashMap.compareComparables(r3, r14, r8);
            if (r17 == 0) goto L22;
            r10 = r17;
            goto L35
        L15:
            if (r14.equals(r8) == false) goto L17;
        L63:
            return r0;
        L4:
            n<K, V> r1 = new n(r13, r14, r15, null, null);
            this.f18086a = r1;
            this.f = r1;
            goto L52
        }

        final boolean a(n<K, V> r10) {
            n<K, V> r0 = (n) ZeusTransformUtils.preCheckCast(r10.e, n.class, "com.obric.memorydata.plugin");
            n<K, V> r1 = r10.h;
            if (r1 != null) goto L5;
            this.f = r0;
        L6:
            if (r0 == null) goto L9;
            r0.h = r1;
        L9:
            if (this.f != null) goto L12;
            this.f18086a = null;
            return true;
        L12:
            n<K, V> r2 = this.f18086a;
            if (r2 != null) goto L15;
        L97:
            return true;
        L15:
            if (r2.g == null) goto L97;
            n<K, V> r3 = r2.f;
            if (r3 == null) goto L97;
            if (r3.f == null) goto L97;
            a();
            n<K, V> r4 = r10.f;     // Catch: Throwable -> L94
            n<K, V> r5 = r10.g;     // Catch: Throwable -> L94
            if (r4 == null) goto L56;
            if (r5 == null) goto L56;
            n<K, V> r6 = r5;
        L26:
            n<K, V> r7 = r6.f;     // Catch: Throwable -> L94
            if (r7 == null) goto L29;
            r6 = r7;
            goto L26
        L29:
            boolean r8 = r6.i;     // Catch: Throwable -> L94
            r6.i = r10.i;     // Catch: Throwable -> L94
            r10.i = r8;     // Catch: Throwable -> L94
            n<K, V> r9 = r6.g;     // Catch: Throwable -> L94
            n<K, V> r11 = r10.f18087a;     // Catch: Throwable -> L94
            if (r6 != r5) goto L32;
            r10.f18087a = r6;     // Catch: Throwable -> L94
            r6.g = r10;     // Catch: Throwable -> L94
        L41:
            r10.f = null;     // Catch: Throwable -> L94
            r10.g = r9;     // Catch: Throwable -> L94
            if (r9 == null) goto L44;
            r9.f18087a = r10;     // Catch: Throwable -> L94
        L44:
            r6.f = r4;     // Catch: Throwable -> L94
            if (r4 == null) goto L47;
            r4.f18087a = r6;     // Catch: Throwable -> L94
        L47:
            r6.f18087a = r11;     // Catch: Throwable -> L94
            if (r11 != null) goto L51;
            r2 = r6;
        L54:
            if (r9 == null) goto L60;
            r4 = r9;
        L61:
            if (r4 == r10) goto L71;
            n<K, V> r12 = r10.f18087a;     // Catch: Throwable -> L94
            r4.f18087a = r12;     // Catch: Throwable -> L94
            if (r12 != null) goto L66;
            r2 = r4;
        L69:
            r10.f18087a = null;     // Catch: Throwable -> L94
            r10.g = null;     // Catch: Throwable -> L94
            r10.f = null;     // Catch: Throwable -> L94
            goto L71
        L66:
            if (r10 != r12.f) goto L68;
            r12.f = r4;     // Catch: Throwable -> L94
            goto L69
        L68:
            r12.g = r4;     // Catch: Throwable -> L94
        L71:
            if (r10.i == true) goto L74;
            r2 = d(r2, r4);     // Catch: Throwable -> L94
        L74:
            this.f18086a = r2;     // Catch: Throwable -> L94
            if (r10 != r4) goto L85;
            n<K, V> r13 = r10.f18087a;     // Catch: Throwable -> L94
            if (r13 == null) goto L85;
            if (r10 != r13.f) goto L82;
            r13.f = null;     // Catch: Throwable -> L94
        L84:
            r10.f18087a = null;     // Catch: Throwable -> L94
            goto L85
        L82:
            if (r10 != r13.g) goto L84;
            r13.g = null;     // Catch: Throwable -> L94
        L85:
            b();
            if (i == false) goto L88;
            return false;
        L88:
            if (b(this.f18086a) == false) goto L91;
            return false;
        L91:
            throw new AssertionError();
        L60:
            r4 = r10;
            goto L61
        L51:
            if (r10 != r11.f) goto L53;
            r11.f = r6;     // Catch: Throwable -> L94
            goto L54
        L53:
            r11.g = r6;     // Catch: Throwable -> L94
            goto L54
        L32:
            n<K, V> r14 = r6.f18087a;     // Catch: Throwable -> L94
            r10.f18087a = r14;     // Catch: Throwable -> L94
            if (r14 != null) goto L35;
        L38:
            r6.g = r5;     // Catch: Throwable -> L94
            if (r5 == null) goto L41;
            r5.f18087a = r6;     // Catch: Throwable -> L94
            goto L41
        L35:
            if (r6 != r14.f) goto L37;
            r14.f = r10;     // Catch: Throwable -> L94
            goto L38
        L37:
            r14.g = r10;     // Catch: Throwable -> L94
        L56:
            if (r4 != null) goto L61;
            if (r5 == null) goto L60;
            r4 = r5;
        L94:
            th = move-exception;
            b();
            throw th;
        L5:
            r1.e = r0;
            goto L6
        }
    }

    static final class n<K, V> extends i<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        n<K, V> f18087a;
        n<K, V> f;
        n<K, V> g;
        n<K, V> h;
        boolean i;

        n(int r1, K r2, V r3, i<K, V> r4, n<K, V> r5) {
            super(r1, r2, r3, r4);
            this.f18087a = r5;
        }

        @Override // org.ehcache.impl.internal.concurrent.ConcurrentHashMap.i
        i<K, V> a(int r2, Object r3) {
            return a(r2, r3, null);
        }

        final n<K, V> a(int r5, Object r6, Class<?> r7) {
            if (r6 == null) goto L32;
        L3:
            n<K, V> r0 = this.f;
            n<K, V> r1 = this.g;
            int r2 = this.f18083b;
            if (r2 > r5) goto L17;
            if (r2 < r5) goto L15;
            K r3 = this.c;
            if (r3 == r6) goto L31;
            if (r3 != null) goto L12;
        L14:
            if (r0 == null) goto L15;
            if (r1 == null) goto L17;
            if (r7 != null) goto L21;
            r7 = ConcurrentHashMap.comparableClassFor(r6);
            if (r7 != null) goto L21;
        L26:
            n<K, V> r4 = r1.a(r5, r6, r7);
            if (r4 == null) goto L17;
            return r4;
        L21:
            int r8 = ConcurrentHashMap.compareComparables(r7, r6, r3);
            if (r8 == 0) goto L26;
            if (r8 < 0) goto L17;
            r0 = r1;
            goto L17
        L12:
            if (r6.equals(r3) == false) goto L14;
        L31:
            return this;
        L15:
            n<K, V> this = r1;
        L29:
            if (this != null) goto L3;
            return null;
        L17:
            this = r0;
            goto L29
        L32:
            return null;
        }
    }

    static final class o<K, V> extends a<K, V> implements Enumeration<V>, Iterator<V> {
        o(i<K, V>[] r1, int r2, int r3, int r4, ConcurrentHashMap<K, V> r5) {
            super(r1, r2, r3, r4, r5);
        }

        @Override // java.util.Iterator
        public final V next() {
            i<K, V> r0 = this.d;
            if (r0 == null) goto L7;
            V r1 = r0.d;
            this.f18075b = r0;
            b();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    static final class p<K, V> extends l<K, V> implements Spliterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f18088a;

        p(i<K, V>[] r1, int r2, int r3, int r4, long r5) {
            super(r1, r2, r3, r4);
            this.f18088a = r5;
        }

        public p<K, V> a() {
            int r0 = this.h;
            int r5 = this.i;
            int r4 = (r0 + r5) >>> 1;
            if (r4 > r0) goto L5;
            return null;
        L5:
            i<K, V>[] r3 = this.c;
            int r6 = this.j;
            this.i = r4;
            long r7 = this.f18088a >>> 1;
            this.f18088a = r7;
            return new p(r3, r6, r4, r5, r7);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4352;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f18088a;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
        L3:
            i<K, V> r0 = b();
            if (r0 == null) goto L6;
            r4.accept(r0.d);
            goto L3
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            i<K, V> r2 = b();
            if (r2 != null) goto L6;
            return false;
        L6:
            r4.accept(r2.d);
            return true;
        }

        @Override // java.util.Spliterator
        public /* synthetic */ Spliterator trySplit() {
            return a();
        }
    }

    static {
        FAKE_TREE_BIN = new m(new n(0, null, null, null, null));
        NCPU = Runtime.getRuntime().availableProcessors();
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};
        Unsafe r1 = org.ehcache.impl.internal.concurrent.b.f18089a;
        U = r1;
        SIZECTL = r1.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));     // Catch: ReflectiveOperationException -> L10
        TRANSFERINDEX = r1.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));     // Catch: ReflectiveOperationException -> L10
        BASECOUNT = r1.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));     // Catch: ReflectiveOperationException -> L10
        CELLSBUSY = r1.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));     // Catch: ReflectiveOperationException -> L10
        CELLVALUE = r1.objectFieldOffset(b.class.getDeclaredField("a"));     // Catch: ReflectiveOperationException -> L10
        ABASE = r1.arrayBaseOffset(i[].class);     // Catch: ReflectiveOperationException -> L10
        int r0 = r1.arrayIndexScale(i[].class);     // Catch: ReflectiveOperationException -> L10
        if (((r0 - 1) & r0) != 0) goto L9;
        ASHIFT = 31 - Integer.numberOfLeadingZeros(r0);     // Catch: ReflectiveOperationException -> L10
        return;
    L9:
        throw new ExceptionInInitializerError("array index scale not a power of two");     // Catch: ReflectiveOperationException -> L10
    L10:
        e = move-exception;
        throw new ExceptionInInitializerError(e);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int r3) {
        this(r3, 0.75f, 1);
    }

    public ConcurrentHashMap(int r2, float r3) {
        this(r2, r3, 1);
    }

    public ConcurrentHashMap(int r5, float r6, int r7) {
        if (r6 <= 0.0f) goto L15;
        if (r5 < 0) goto L15;
        if (r7 <= 0) goto L15;
        if (r5 >= r7) goto L8;
        r5 = r7;
    L8:
        long r8 = (long) (((double) (r5 / r6)) + 1.0d);
        if (r8 < ProcInfo.GB) goto L11;
        int r9 = 1073741824;
    L12:
        this.sizeCtl = r9;
        return;
    L11:
        r9 = tableSizeFor((int) r8);
    L15:
        throw new IllegalArgumentException();
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.sizeCtl = 16;
        putAll(r4);
    }

    private final void addCount(long r12, int r14) {
        b[] r0 = this.counterCells;
        if (r0 != null) goto L6;
        Unsafe r1 = U;
        long r3 = BASECOUNT;
        long r5 = this.baseCount;
        long r9 = r5 + r12;
        if (r1.compareAndSwapLong(this, r3, r5, r9) == false) goto L6;
    L18:
        if (r14 < 0) goto L45;
    L19:
        int r4 = this.sizeCtl;
        if (r9 < r4) goto L60;
        i<K, V>[] r13 = this.table;
        if (r13 == null) goto L61;
        int r15 = r13.length;
        if (r15 >= 1073741824) goto L62;
        int r16 = resizeStamp(r15);
        if (r4 >= 0) goto L42;
        if ((r4 >>> 16) != r16) goto L63;
        if (r4 == (r16 + 1)) goto L64;
        if (r4 == (r16 + 65535)) goto L65;
        i<K, V>[] r17 = this.nextTable;
        if (r17 == null) goto L66;
        if (this.transferIndex <= 0) goto L67;
        if (U.compareAndSwapInt(this, SIZECTL, r4, r4 + 1) == false) goto L44;
        transfer(r13, r17);
    L44:
        r9 = sumCount();
        goto L19
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L42:
        if (U.compareAndSwapInt(this, SIZECTL, r4, (r16 << 16) + 2) == false) goto L44;
        transfer(r13, null);
        goto L44
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L45:
        return;
    L6:
        boolean r2 = true;
        if (r0 == null) goto L46;
        int r6 = r0.length - 1;
        if (r6 < 0) goto L46;
        b r7 = r0[r6 & org.ehcache.impl.internal.concurrent.b.b()];
        if (r7 == null) goto L46;
        Unsafe r8 = U;
        long r10 = CELLVALUE;
        long r11 = r7.f18076a;
        boolean r18 = r8.compareAndSwapLong(r7, r10, r11, r11 + r12);
        if (r18 == true) goto L15;
        r2 = r18;
        goto L46
    L15:
        if (r14 > 1) goto L17;
        return;
    L17:
        r9 = sumCount();
    L46:
        fullAddCount(r12, r2);
    }

    static final <K, V> boolean casTabAt(i<K, V>[] r6, int r7, i<K, V> r8, i<K, V> r9) {
        return U.compareAndSwapObject(r6, (((long) r7) << ASHIFT) + ((long) ABASE), r8, r9);
    }

    static Class<?> comparableClassFor(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, Comparable.class) == false) goto L23;
        Class<?> r8 = r7.getClass();
        if (r8 != String.class) goto L7;
        return r8;
    L7:
        Type[] r0 = r8.getGenericInterfaces();
        if (r0 == null) goto L32;
        int r1 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L33;
        Type r4 = r0[r3];
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L22;
        ParameterizedType r5 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
        if (r5.getRawType() != Comparable.class) goto L22;
        Type[] r6 = r5.getActualTypeArguments();
        if (r6 == null) goto L22;
        if (r6.length != 1) goto L22;
        if (r6[0] != r8) goto L22;
        return r8;
    L22:
        r3 = r3 + 1;
        goto L10
    L33:
        return null;
    L32:
        return null;
    L23:
        return null;
    }

    static int compareComparables(Class<?> r1, Object r2, Object r3) {
        if (r3 != null) goto L4;
    L7:
        return 0;
    L4:
        if (r3.getClass() != r1) goto L7;
        return ((Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r3);
    }

    private final void fullAddCount(long r25, boolean r27) {
        int r0 = org.ehcache.impl.internal.concurrent.b.b();
        if (r0 != 0) goto L5;
        org.ehcache.impl.internal.concurrent.b.c();
        int r1 = org.ehcache.impl.internal.concurrent.b.b();
        boolean r2 = true;
    L6:
        int r14 = r1;
    L7:
        boolean r15 = false;
    L8:
        b[] r7 = this.counterCells;
        if (r7 == null) goto L61;
        int r8 = r7.length;
        if (r8 <= 0) goto L61;
        b r3 = r7[(r8 - 1) & r14];
        if (r3 != null) goto L36;
        if (this.cellsBusy != 0) goto L35;
        b r9 = new b(r25);
        if (this.cellsBusy != 0) goto L35;
        if (U.compareAndSwapInt(this, CELLSBUSY, 0, 1) == false) goto L35;
        b[] r4 = this.counterCells;     // Catch: Throwable -> L32
        if (r4 == null) goto L28;
        int r5 = r4.length;     // Catch: Throwable -> L32
        if (r5 <= 0) goto L28;
        int r6 = (r5 - 1) & r14;     // Catch: Throwable -> L32
        if (r4[r6] != null) goto L28;
        r4[r6] = r9;     // Catch: Throwable -> L32
        boolean r10 = true;
    L29:
        this.cellsBusy = 0;
        if (r10 == false) goto L8;
        return;
    L28:
        r10 = false;
    L32:
        th = move-exception;
        this.cellsBusy = 0;
        throw th;
    L35:
        r15 = false;
    L59:
        r14 = org.ehcache.impl.internal.concurrent.b.a(r14);
        goto L8
    L36:
        if (r2 == true) goto L38;
        r2 = true;
        goto L59
    L38:
        Unsafe r11 = U;
        long r18 = CELLVALUE;
        long r12 = r3.f18076a;
        if (r11.compareAndSwapLong(r3, r18, r12, r12 + r25) == true) goto L107;
        if (this.counterCells != r7) goto L35;
        if (r8 >= NCPU) goto L35;
        if (r15 == true) goto L49;
        r15 = true;
        goto L59
    L49:
        if (this.cellsBusy != 0) goto L59;
        if (r11.compareAndSwapInt(this, CELLSBUSY, 0, 1) == false) goto L59;
    L56:
        th = move-exception;
        this.cellsBusy = 0;
        throw th;
    L53:
        if (this.counterCells != r7) goto L55;
        this.counterCells = (b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r8 << 1), b[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L55:
        this.cellsBusy = 0;
        goto L7
    L107:
        return;
    L61:
        if (this.cellsBusy != 0) goto L77;
        if (this.counterCells != r7) goto L77;
        if (U.compareAndSwapInt(this, CELLSBUSY, 0, 1) == false) goto L77;
    L74:
        th = move-exception;
        this.cellsBusy = 0;
        throw th;
    L67:
        if (this.counterCells != r7) goto L70;
        b[] r13 = new b[2];     // Catch: Throwable -> L74
        r13[r14 & 1] = new b(r25);     // Catch: Throwable -> L74
        this.counterCells = r13;     // Catch: Throwable -> L74
        boolean r16 = true;
    L71:
        this.cellsBusy = 0;
        if (r16 == false) goto L8;
        return;
    L70:
        r16 = false;
    L77:
        Unsafe r17 = U;
        long r19 = BASECOUNT;
        long r20 = this.baseCount;
        if (r17.compareAndSwapLong(this, r19, r20, r20 + r25) == false) goto L8;
        return;
    L5:
        r1 = r0;
        r2 = r27;
        goto L6
    }

    private Map.Entry<K, V> getEvictionCandidateWrap(i<K, V>[] r4, int r5, int r6, K r7, V r8, Comparator<? super V> r9, org.ehcache.config.e<? super K, ? super V> r10) {
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r9, Comparator.class, "com.obric.memorydata.plugin");
        org.ehcache.config.e r12 = (org.ehcache.config.e) ZeusTransformUtils.wrapperContextForParams(r10, org.ehcache.config.e.class, "com.obric.memorydata.plugin");
        l r0 = new l(r4, r4.length, 0, r5);
    L3:
        i<K, V> r13 = r0.b();
        if (r13 == null) goto L25;
        K r14 = r13.c;
        V r15 = r13.d;
        if (r12.a(r14, r15) == true) goto L3;
        if (r7 != null) goto L9;
    L10:
        r8 = r15;
        r7 = r14;
    L11:
        r6 = r6 - 1;
        if (r6 != 0) goto L3;
        int r16 = r0.g;
    L14:
        i<K, V> r17 = r0.b();
        if (r17 == null) goto L24;
        if (r0.g != r16) goto L24;
        K r18 = r17.c;
        V r19 = r17.d;
        if (r12.a(r18, r19) == true) goto L14;
        if (r11.compare(r19, r8) <= 0) goto L14;
        r8 = r19;
        r7 = r18;
    L24:
        return new h(r7, r8, this);
    L9:
        if (r11.compare(r15, r8) <= 0) goto L11;
    L25:
        if (r7 != null) goto L29;
        return null;
    L29:
        return new h(r7, r8, this);
    }

    private final i<K, V>[] initTable() {
    L2:
        i<K, V>[] r0 = this.table;
        if (r0 != null) goto L5;
    L6:
        int r1 = this.sizeCtl;
        if (r1 < 0) goto L8;
        if (U.compareAndSwapInt(this, SIZECTL, r1, -1) == false) goto L2;
        i<K, V>[] r2 = this.table;     // Catch: Throwable -> L22
        if (r2 != null) goto L14;
    L15:
        if (r1 <= 0) goto L17;
        int r3 = r1;
    L18:
        i<K, V>[] r4 = (i[]) ZeusTransformUtils.preCheckCast(new i[r3], i[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        this.table = r4;     // Catch: Throwable -> L22
        r1 = r3 - (r3 >>> 2);
        r2 = r4;
    L20:
        this.sizeCtl = r1;
        return r2;
    L17:
        r3 = 16;
        goto L18
    L14:
        if (r2.length != 0) goto L20;
    L22:
        th = move-exception;
        this.sizeCtl = r1;
        throw th;
    L8:
        Thread.yield();
        goto L2
    L5:
        if (r0.length == 0) goto L6;
        return r0;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView(new ConcurrentHashMap(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int r2) {
        return new KeySetView(new ConcurrentHashMap(r2), Boolean.TRUE);
    }

    private static <K, V> int nodesAt(i<K, V> r4, Collection<Map.Entry<K, V>> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, m.class) == true) goto L5;
        int r0 = 0;
    L7:
        if (r4 == null) goto L9;
        r6.add(new AbstractMap.SimpleImmutableEntry(r4.c, r4.d));
        r0 = r0 + 1;
        r4 = r4.e;
        goto L7
    L9:
        return r0;
    L5:
        return treeNodesAt(((m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.memorydata.plugin")).f18086a, r6);
    }

    private void readObject(ObjectInputStream r26) {
        this.sizeCtl = -1;
        r26.defaultReadObject();
        long r2 = 0;
        long r4 = 0;
        i<K, V> r6 = null;
    L3:
        Object r7 = r26.readObject();
        Object r8 = r26.readObject();
        if (r7 == null) goto L8;
        if (r8 == null) goto L8;
        r4 = r4 + 1;
        r6 = new i(spread(r7.hashCode()), r7, r8, r6);
    L8:
        if (r4 != 0) goto L10;
        this.sizeCtl = 0;
        return;
    L10:
        long r5 = (long) (((double) (r4 / 0.75f)) + 1.0d);
        if (r5 < ProcInfo.GB) goto L13;
        int r9 = 1073741824;
    L14:
        i<K, V>[] r10 = (i[]) ZeusTransformUtils.preCheckCast(new i[r9], i[].class, "com.obric.memorydata.plugin");
        int r11 = r9 - 1;
    L15:
        if (r6 == null) goto L51;
        i<K, V> r12 = r6.e;
        int r13 = r6.f18083b;
        int r14 = r13 & r11;
        i<K, V> r15 = tabAt(r10, r14);
        boolean r16 = true;
        if (r15 == null) goto L48;
        K r1 = r6.c;
        if (r15.f18083b < 0) goto L22;
        i<K, V> r17 = r15;
        int r18 = 0;
    L26:
        if (r17 == null) goto L36;
        if (r17.f18083b != r13) goto L35;
        K r19 = r17.c;
        if (r19 == r1) goto L34;
        if (r19 == null) goto L35;
        if (r1.equals(r19) == false) goto L35;
    L34:
        r16 = false;
    L35:
        r18 = r18 + 1;
        r17 = r17.e;
    L36:
        if (r16 == false) goto L48;
        if (r18 < 8) goto L48;
        r2 = r2 + 1;
        r6.e = r15;
        i<K, V> r3 = r6;
        n<K, V> r20 = null;
        n<K, V> r21 = null;
    L40:
        if (r3 == null) goto L46;
        long r23 = r2;
        n<K, V> r110 = new n(r3.f18083b, r3.c, r3.d, null, null);
        r110.h = r21;
        if (r21 != null) goto L44;
        r20 = r110;
    L45:
        r3 = r3.e;
        r21 = r110;
        r2 = r23;
        goto L40
    L44:
        r21.e = r110;
        goto L45
    L46:
        setTabAt(r10, r14, new m(r20));
    L24:
        r16 = false;
        goto L48
    L22:
        if (((m) ZeusTransformUtils.preCheckCast(r15, m.class, "com.obric.memorydata.plugin")).a(r13, r1, r6.d) != null) goto L24;
        r2 = r2 + 1;
    L48:
        if (r16 == false) goto L50;
        r2 = r2 + 1;
        r6.e = r15;
        setTabAt(r10, r14, r6);
    L50:
        r6 = r12;
        goto L15
    L51:
        this.table = r10;
        this.sizeCtl = r9 - (r9 >>> 2);
        this.baseCount = r2;
        return;
    L13:
        r9 = tableSizeFor((int) r5);
        goto L14
    }

    static final int resizeStamp(int r1) {
        return Integer.numberOfLeadingZeros(r1) | 32768;
    }

    static final <K, V> void setTabAt(i<K, V>[] r5, int r6, i<K, V> r7) {
        U.putObjectVolatile(r5, (((long) r6) << ASHIFT) + ((long) ABASE), r7);
    }

    static final int spread(int r1) {
        int r2 = Integer.rotateLeft(r1, 1);
        return (r2 ^ (r2 >>> 16)) & Integer.MAX_VALUE;
    }

    static final <K, V> i<K, V> tabAt(i<K, V>[] r5, int r6) {
        return (i) ZeusTransformUtils.preCheckCast(U.getObject(r5, (((long) r6) << ASHIFT) + ((long) ABASE)), i.class, "com.obric.memorydata.plugin");
    }

    private static final int tableSizeFor(int r2) {
        int r3 = (-1) >>> Integer.numberOfLeadingZeros(r2 - 1);
        if (r3 < 0) goto L10;
        if (r3 < 1073741824) goto L8;
        return 1073741824;
    L8:
        return 1 + r3;
    L10:
        return 1;
    }

    private final void transfer(i<K, V>[] r31, i<K, V>[] r32) {
        ConcurrentHashMap<K, V> r0 = this;
        i<K, V>[] r7 = r31;
        int r8 = r7.length;
        int r1 = NCPU;
        boolean r9 = true;
        if (r1 <= 1) goto L5;
        int r2 = (r8 >>> 3) / r1;
    L6:
        char r10 = 16;
        if (r2 >= 16) goto L9;
        int r11 = 16;
    L10:
        if (r32 == null) goto L123;
        i<K, V>[] r12 = r32;
    L17:
        int r13 = r12.length;
        e r14 = new e(r12);
        boolean r16 = true;
        int r5 = 0;
        int r6 = 0;
        boolean r17 = false;
    L19:
        if (r16 == true) goto L20;
        int r18 = r5;
        n<K, V> r3 = null;
        i<K, V> r4 = null;
        if (r6 < 0) goto L109;
        if (r6 >= r8) goto L109;
        int r15 = r6 + r8;
        if (r15 >= r13) goto L109;
        i<K, V> r19 = tabAt(r7, r6);
        if (r19 != null) goto L47;
        r16 = casTabAt(r7, r6, null, r14);
        boolean r110 = r9;
    L46:
        e r20 = r14;
    L120:
        r14 = r20;
        r5 = r18;
        r11 = r11;
        r13 = r13;
        r7 = r7;
        r0 = r0;
        r9 = r110;
        r10 = r10;
        goto L19
    L47:
        int r21 = r19.f18083b;
        if (r21 != (-1)) goto L50;
        r16 = r9;
        r110 = r16;
        goto L46
    L50:
        monitor-enter(r19);
        if (tabAt(r7, r6) != r19) goto L102;
        if (r21 < 0) goto L72;
        int r22 = r21 & r8;     // Catch: Throwable -> L106
        i<K, V> r23 = r19.e;     // Catch: Throwable -> L106
        i<K, V> r111 = r19;
    L55:
        if (r23 == null) goto L60;
        int r112 = r23.f18083b & r8;     // Catch: Throwable -> L106
        if (r112 == r22) goto L59;
        r111 = r23;
        r22 = r112;
    L59:
        r23 = r23.e;     // Catch: Throwable -> L106
        goto L55
    L60:
        if (r22 != 0) goto L62;
        i<K, V> r24 = null;
        r4 = r111;
    L63:
        i<K, V> r25 = r19;
    L64:
        if (r25 == r111) goto L70;
        int r113 = r25.f18083b;     // Catch: Throwable -> L106
        K r26 = r25.c;     // Catch: Throwable -> L106
        int r27 = r11;
        V r114 = r25.d;     // Catch: Throwable -> L106
        int r28 = r13;
        if ((r113 & r8) != 0) goto L68;
        r4 = new i(r113, r26, r114, r4);     // Catch: Throwable -> L106
    L69:
        r25 = r25.e;     // Catch: Throwable -> L106
        r11 = r27;
        r13 = r28;
        goto L64
    L68:
        r24 = new i(r113, r26, r114, r24);     // Catch: Throwable -> L106
        goto L69
    L70:
        r11 = r11;
        r13 = r13;
        setTabAt(r12, r6, r4);     // Catch: Throwable -> L106
        setTabAt(r12, r15, r24);     // Catch: Throwable -> L106
        setTabAt(r7, r6, r14);     // Catch: Throwable -> L106
        r7 = r7;
        r20 = r14;
    L71:
        r16 = true;
    L104:
        monitor-exit(r19);     // Catch: Throwable -> L106
        r0 = this;
        r10 = 16;
        r110 = true;
        goto L120
    L62:
        r24 = r111;
        goto L63
    L72:
        r11 = r11;
        r13 = r13;
        if (ZeusTransformUtils.instanceOf(r19, m.class) == false) goto L103;
        m r29 = (m) ZeusTransformUtils.preCheckCast(r19, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L106
        n<K, V> r30 = null;
        n<K, V> r115 = null;
        i<K, V> r116 = r29.f;     // Catch: Throwable -> L106
        int r117 = 0;
        int r118 = 0;
        n<K, V> r33 = null;
    L75:
        if (r116 == null) goto L89;
        m r119 = r29;
        int r34 = r116.f18083b;     // Catch: Throwable -> L106
        e r210 = r14;
        n<K, V> r35 = new n(r34, r116.c, r116.d, null, null);     // Catch: Throwable -> L106
        if ((r34 & r8) != 0) goto L83;
        r35.h = r115;     // Catch: Throwable -> L106
        if (r115 != null) goto L81;
        r3 = r35;
    L82:
        r117 = r117 + 1;     // Catch: Throwable -> L106
        r115 = r35;
    L88:
        r116 = r116.e;     // Catch: Throwable -> L106
        r29 = r119;
        r14 = r210;
        goto L75
    L81:
        r115.e = r35;     // Catch: Throwable -> L106
        goto L82
    L83:
        r35.h = r30;     // Catch: Throwable -> L106
        if (r30 != null) goto L86;
        r33 = r35;
    L87:
        r118 = r118 + 1;     // Catch: Throwable -> L106
        r30 = r35;
        goto L88
    L86:
        r30.e = r35;     // Catch: Throwable -> L106
        goto L87
    L89:
        m r120 = r29;
        e r211 = r14;
        if (r117 > 6) goto L92;
        i r36 = untreeify(r3);     // Catch: Throwable -> L106
    L95:
        if (r118 > 6) goto L97;
        i r37 = untreeify(r33);     // Catch: Throwable -> L106
    L100:
        setTabAt(r12, r6, r36);     // Catch: Throwable -> L106
        setTabAt(r12, r15, r37);     // Catch: Throwable -> L106
        r7 = r31;
        r20 = r211;
        setTabAt(r7, r6, r20);     // Catch: Throwable -> L106
        goto L71
    L97:
        if (r117 == 0) goto L99;
        r37 = new m(r33);     // Catch: Throwable -> L106
        goto L100
    L99:
        r37 = r120;
        goto L100
    L92:
        if (r118 == 0) goto L94;
        r36 = new m(r3);     // Catch: Throwable -> L106
        goto L95
    L94:
        r36 = r120;
    L103:
        r20 = r14;
        goto L104
    L102:
        r11 = r11;
        r13 = r13;
    L106:
        th = move-exception;
        throw th;
    L109:
        r7 = r7;
        r11 = r11;
        r13 = r13;
        r20 = r14;
        r0 = this;
        if (r17 == true) goto L111;
        r110 = true;
        Unsafe r38 = U;
        long r39 = SIZECTL;
        int r121 = r0.sizeCtl;
        int r122 = r6;
        if (r38.compareAndSwapInt(this, r39, r121, r121 - 1) == false) goto L119;
        r10 = 16;
        if ((r121 - 2) != (resizeStamp(r8) << 16)) goto L117;
        r6 = r8;
        r16 = true;
        r17 = true;
        goto L120
    L117:
        return;
    L119:
        r10 = 16;
        r6 = r122;
        goto L120
    L111:
        r0.nextTable = null;
        r0.table = r12;
        r0.sizeCtl = (r8 << 1) - (r8 >>> 1);
        return;
    L20:
        int r40 = r6 - 1;
        if (r40 >= r5) goto L35;
        if (r17 == true) goto L35;
        int r41 = r0.transferIndex;
        if (r41 <= 0) goto L26;
        Unsafe r42 = U;
        long r123 = TRANSFERINDEX;
        if (r41 <= r11) goto L30;
        int r212 = r41 - r11;
    L31:
        int r124 = r5;
        if (r42.compareAndSwapInt(this, r123, r41, r212) == true) goto L33;
        r5 = r124;
        r6 = r40;
        goto L19
    L33:
        r6 = r41 - 1;
        r5 = r212;
    L36:
        r16 = false;
        goto L19
    L30:
        r212 = 0;
        goto L31
    L26:
        r6 = -1;
    L35:
        r5 = r5;
        r6 = r40;
        goto L36
    L123:
        i<K, V>[] r43 = (i[]) ZeusTransformUtils.preCheckCast(new i[r8 << 1], i[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0.nextTable = r43;
        r0.transferIndex = r8;
        r12 = r43;
    L14:
        r0.sizeCtl = Integer.MAX_VALUE;
        return;
    L9:
        r11 = r2;
        goto L10
    L5:
        r2 = r8;
        goto L6
    }

    private static <K, V> int treeNodesAt(n<K, V> r3, Collection<Map.Entry<K, V>> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return 0;
    L6:
        r5.add(new AbstractMap.SimpleImmutableEntry(r3.c, r3.d));
        return (treeNodesAt(r3.f, r5) + 1) + treeNodesAt(r3.g, r5);
    }

    private final void treeifyBin(i<K, V>[] r11, int r12) {
        if (r11 == null) goto L26;
        int r0 = r11.length;
        if (r0 >= 64) goto L6;
        tryPresize(r0 << 1);
        return;
    L6:
        i<K, V> r10 = tabAt(r11, r12);
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.f18083b < 0) goto L34;
        monitor-enter(r10);
    L23:
        th = move-exception;
        throw th;
    L12:
        if (tabAt(r11, r12) != r10) goto L21;
        n<K, V> r1 = null;
        i<K, V> r2 = r10;
        n<K, V> r3 = null;
    L14:
        if (r2 == null) goto L20;
        n<K, V> r9 = new n(r2.f18083b, r2.c, r2.d, null, null);     // Catch: Throwable -> L23
        r9.h = r3;     // Catch: Throwable -> L23
        if (r3 != null) goto L18;
        r1 = r9;
    L19:
        r2 = r2.e;     // Catch: Throwable -> L23
        r3 = r9;
        goto L14
    L18:
        r3.e = r9;     // Catch: Throwable -> L23
        goto L19
    L20:
        setTabAt(r11, r12, new m(r1));     // Catch: Throwable -> L23
    L21:
        monitor-exit(r10);     // Catch: Throwable -> L23
        return;
    L34:
        return;
    }

    private final void tryPresize(int r11) {
        if (r11 < 536870912) goto L5;
        int r12 = 1073741824;
    L6:
        int r7 = this.sizeCtl;
        if (r7 < 0) goto L34;
        i<K, V>[] r8 = this.table;
        if (r8 == null) goto L21;
        int r1 = r8.length;
        if (r1 == 0) goto L21;
        if (r12 <= r7) goto L52;
        if (r1 >= 1073741824) goto L53;
        if (r8 != this.table) goto L6;
        if (U.compareAndSwapInt(this, SIZECTL, r7, (resizeStamp(r1) << 16) + 2) == false) goto L6;
        transfer(r8, null);
        goto L6
    L53:
        return;
    L52:
        return;
    L21:
        if (r7 <= r12) goto L23;
        int r9 = r7;
    L25:
        if (U.compareAndSwapInt(this, SIZECTL, r7, -1) == false) goto L6;
    L31:
        th = move-exception;
        this.sizeCtl = r7;
        throw th;
    L27:
        if (this.table != r8) goto L30;
        this.table = (i[]) ZeusTransformUtils.preCheckCast(new i[r9], i[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r7 = r9 - (r9 >>> 2);
    L30:
        this.sizeCtl = r7;
        goto L6
    L23:
        r9 = r12;
        goto L25
    L34:
        return;
    L5:
        r12 = tableSizeFor((r11 + (r11 >>> 1)) + 1);
        goto L6
    }

    static <K, V> i<K, V> untreeify(i<K, V> r6) {
        i<K, V> r0 = null;
        i<K, V> r1 = null;
    L3:
        if (r6 == null) goto L9;
        i<K, V> r2 = new i(r6.f18083b, r6.c, r6.d);
        if (r1 != null) goto L7;
        r0 = r2;
    L8:
        r6 = r6.e;
        r1 = r2;
        goto L3
    L7:
        r1.e = r2;
        goto L8
    L9:
        return r0;
    }

    private void writeObject(ObjectOutputStream r8) {
        int r3 = 0;
        int r2 = 1;
    L4:
        if (r2 >= 16) goto L6;
        r3 = r3 + 1;
        r2 = r2 << 1;
        goto L4
    L6:
        int r4 = 32 - r3;
        int r5 = r2 - 1;
        Segment[] r1 = (Segment[]) ZeusTransformUtils.preCheckCast(new Segment[16], Segment[].class, "com.obric.memorydata.plugin");
        int r6 = 0;
    L8:
        if (r6 >= r1.length) goto L10;
        r1[r6] = new Segment(0.75f);
        r6 = r6 + 1;
        goto L8
    L10:
        ObjectOutputStream.PutField r7 = r8.putFields();
        r7.put("segments", r1);
        r7.put("segmentShift", r4);
        r7.put("segmentMask", r5);
        r8.writeFields();
        i<K, V>[] r9 = this.table;
        if (r9 == null) goto L16;
        l r10 = new l(r9, r9.length, 0, r9.length);
    L13:
        i<K, V> r11 = r10.b();
        if (r11 == null) goto L16;
        r8.writeObject(r11.c);
        r8.writeObject(r11.d);
    L16:
        r8.writeObject(null);
        r8.writeObject(null);
    }

    final int batchFor(long r5) {
        if (r5 == Long.MAX_VALUE) goto L16;
        long r0 = sumCount();
        if (r0 > 1) goto L7;
        return 0;
    L7:
        if (r0 < r5) goto L21;
        int r4 = ForkJoinPool.getCommonPoolParallelism() << 2;
        if (r5 <= 0) goto L18;
        long r1 = r0 / r5;
        if (r1 < r4) goto L15;
        return r4;
    L15:
        return (int) r1;
    L18:
        return r4;
    L21:
        return 0;
    L16:
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i<K, V>[] r0 = this.table;
        int r4 = 0;
        long r5 = 0;
    L4:
        if (r0 == null) goto L32;
        if (r4 >= r0.length) goto L32;
        i<K, V> r8 = tabAt(r0, r4);
        if (r8 == null) goto L9;
        int r9 = r8.f18083b;
        if (r9 == (-1)) goto L12;
        monitor-enter(r8);
        if (tabAt(r0, r4) == r8) goto L17;
    L26:
        monitor-exit(r8);     // Catch: Throwable -> L28
        goto L4
    L17:
        if (r9 < 0) goto L20;
        i<K, V> r10 = r8;
    L23:
        if (r10 == null) goto L25;
        r5 = r5 - 1;     // Catch: Throwable -> L28
        r10 = r10.e;     // Catch: Throwable -> L28
        goto L23
    L25:
        setTabAt(r0, r4, null);     // Catch: Throwable -> L28
        r4 = r4 + 1;     // Catch: Throwable -> L28
        goto L26
    L20:
        if (ZeusTransformUtils.instanceOf(r8, m.class) == false) goto L22;
        r10 = ((m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.memorydata.plugin")).f;     // Catch: Throwable -> L28
        goto L23
    L22:
        r10 = null;
    L28:
        th = move-exception;
        throw th;
    L12:
        r0 = helpTransfer(r0, r8);
        r4 = 0;
        goto L4
    L9:
        r4 = r4 + 1;
    L32:
        if (r5 == 0) goto L49;
        addCount(r5, -1);
        return;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K r14, BiFunction<? super K, ? super V, ? extends V> r15) {
        BiFunction r16 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L103;
        if (r16 == null) goto L128;
        int r1 = spread(r14.hashCode());
        i<K, V>[] r2 = this.table;
        int r3 = 0;
        V r5 = null;
        int r4 = 0;
    L6:
        if (r2 == null) goto L102;
        int r6 = r2.length;
        if (r6 == 0) goto L102;
        int r7 = (r6 - 1) & r1;
        i<K, V> r8 = tabAt(r2, r7);
        if (r8 == null) goto L12;
        int r9 = r8.f18083b;
        if (r9 == (-1)) goto L33;
        monitor-enter(r8);
    L99:
        th = move-exception;
        throw th;
    L36:
        if (tabAt(r2, r7) != r8) goto L91;
        if (r9 < 0) goto L67;
        i<K, V> r10 = null;
        i<K, V> r11 = r8;
        r3 = 1;
    L40:
        if (r11.f18083b != r1) goto L54;
        K r12 = r11.c;     // Catch: Throwable -> L99
        if (r12 == r14) goto L46;
        if (r12 == null) goto L54;
        if (r14.equals(r12) == false) goto L54;
    L46:
        V r13 = (V) r16.apply(r14, r11.d);
        if (r13 == null) goto L49;
        r11.d = r13;     // Catch: Throwable -> L99
    L64:
        r5 = r13;
        goto L91
    L49:
        i<K, V> r17 = r11.e;     // Catch: Throwable -> L99
        if (r10 == null) goto L52;
        r10.e = r17;     // Catch: Throwable -> L99
    L53:
        r4 = -1;
        goto L64
    L52:
        setTabAt(r2, r7, r17);     // Catch: Throwable -> L99
    L54:
        i<K, V> r18 = r11.e;     // Catch: Throwable -> L99
        if (r18 == null) goto L56;
        r3 = r3 + 1;     // Catch: Throwable -> L99
        r10 = r11;
        r11 = r18;
        goto L40
    L56:
        Object r19 = r16.apply(r14, null);     // Catch: Throwable -> L99
        if (r19 != null) goto L59;
    L63:
        r13 = (V) r19;
        goto L64
    L59:
        if (r11.e != null) goto L62;
        r11.e = new i(r1, r14, r19);     // Catch: Throwable -> L99
        r4 = 1;
        goto L63
    L62:
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L99
    L67:
        if (ZeusTransformUtils.instanceOf(r8, m.class) == false) goto L87;
        m r20 = (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L99
        n<K, V> r21 = r20.f18086a;     // Catch: Throwable -> L99
        if (r21 == null) goto L71;
        n<K, V> r22 = r21.a(r1, r14, null);     // Catch: Throwable -> L99
    L72:
        if (r22 != null) goto L74;
        V r23 = null;
    L75:
        V r24 = (V) r16.apply(r14, r23);
        if (r24 == null) goto L80;
        if (r22 == null) goto L79;
        r22.d = r24;     // Catch: Throwable -> L99
    L85:
        r3 = 1;
        r5 = r24;
        goto L91
    L79:
        r20.a(r1, r14, r24);     // Catch: Throwable -> L99
        r4 = 1;
        goto L85
    L80:
        if (r22 == null) goto L85;
        if (r20.a(r22) == false) goto L84;
        setTabAt(r2, r7, untreeify(r20.f));     // Catch: Throwable -> L99
    L84:
        r4 = -1;
        goto L85
    L74:
        r23 = r22.d;     // Catch: Throwable -> L99
        goto L75
    L71:
        r22 = null;
        goto L72
    L87:
        if (ZeusTransformUtils.instanceOf(r8, j.class) == false) goto L91;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L99
    L91:
        monitor-exit(r8);     // Catch: Throwable -> L99
        if (r3 == 0) goto L6;
        if (r3 < 8) goto L96;
        treeifyBin(r2, r7);
    L96:
        if (r4 == 0) goto L98;
        addCount(r4, r3);
    L98:
        return (V) r5;
    L33:
        r2 = helpTransfer(r2, r8);
        goto L6
    L12:
        j r25 = new j();
        monitor-enter(r25);
    L28:
        th = move-exception;
        throw th;
    L15:
        if (casTabAt(r2, r7, null, r25) == true) goto L107;
    L25:
        monitor-exit(r25);     // Catch: Throwable -> L28
        if (r3 == 0) goto L6;
    L107:
        Object r26 = r16.apply(r14, null);     // Catch: Throwable -> L22
        if (r26 == null) goto L20;
        i r27 = new i(r1, r14, r26);     // Catch: Throwable -> L22
        int r28 = 1;
    L21:
        setTabAt(r2, r7, r27);     // Catch: Throwable -> L28
        r4 = r28;
        r5 = r26;
        r3 = 1;
        goto L25
    L20:
        r28 = r4;
        r27 = null;
    L22:
        th = move-exception;
        setTabAt(r2, r7, null);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L102:
        r2 = initTable();
        goto L6
    L128:
        throw null;
    L103:
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(K r13, Function<? super K, ? extends V> r14) {
        Function r15 = (Function) ZeusTransformUtils.wrapperContextForParams(r14, Function.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L101;
        if (r15 == null) goto L127;
        int r1 = spread(r13.hashCode());
        i<K, V>[] r2 = this.table;
        V r5 = null;
        int r4 = 0;
    L6:
        if (r2 == null) goto L100;
        int r6 = r2.length;
        if (r6 == 0) goto L100;
        int r7 = (r6 - 1) & r1;
        i<K, V> r8 = tabAt(r2, r7);
        boolean r9 = true;
        if (r8 == null) goto L12;
        int r10 = r8.f18083b;
        if (r10 == (-1)) goto L33;
        if (r10 != r1) goto L43;
        K r11 = r8.c;
        if (r11 == r13) goto L40;
        if (r11 == null) goto L43;
        if (r13.equals(r11) == false) goto L43;
    L40:
        V r12 = r8.d;
        if (r12 == null) goto L43;
        return r12;
    L43:
        monitor-enter(r8);
    L97:
        th = move-exception;
        throw th;
    L45:
        if (tabAt(r2, r7) != r8) goto L86;
        if (r10 < 0) goto L70;
        i<K, V> r16 = r8;
        int r17 = 1;
    L49:
        if (r16.f18083b != r1) goto L56;
        K r18 = r16.c;     // Catch: Throwable -> L97
        if (r18 == r13) goto L55;
        if (r18 == null) goto L56;
        if (r13.equals(r18) == false) goto L56;
    L55:
        Object r19 = r16.d;     // Catch: Throwable -> L97
        r9 = false;
    L67:
        int r110 = r17;
        r5 = (V) r19;
        r4 = r110;
    L87:
        monitor-exit(r8);     // Catch: Throwable -> L97
        if (r4 == 0) goto L6;
        if (r4 < 8) goto L92;
        treeifyBin(r2, r7);
    L92:
        if (r9 == true) goto L94;
        return r5;
    L94:
        if (r5 == null) goto L96;
        addCount(1, r4);
    L96:
        return r5;
    L56:
        i<K, V> r20 = r16.e;     // Catch: Throwable -> L97
        if (r20 == null) goto L58;
        r17 = r17 + 1;     // Catch: Throwable -> L97
        r16 = r20;
        goto L49
    L58:
        Object r21 = r15.apply(r13);     // Catch: Throwable -> L97
        if (r21 != null) goto L61;
        r9 = false;
    L66:
        r19 = r21;
        goto L67
    L61:
        if (r16.e != null) goto L64;
        r16.e = new i(r1, r13, r21);     // Catch: Throwable -> L97
        goto L66
    L64:
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L97
    L70:
        if (ZeusTransformUtils.instanceOf(r8, m.class) == false) goto L82;
        r4 = 2;
        m r22 = (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L97
        n<K, V> r23 = r22.f18086a;     // Catch: Throwable -> L97
        if (r23 == null) goto L76;
        n<K, V> r24 = r23.a(r1, r13, null);     // Catch: Throwable -> L97
        if (r24 == null) goto L76;
        r5 = r24.d;     // Catch: Throwable -> L97
    L76:
        Object r25 = r15.apply(r13);     // Catch: Throwable -> L97
        if (r25 == null) goto L79;
        r22.a(r1, r13, r25);     // Catch: Throwable -> L97
    L80:
        r5 = (V) r25;
        goto L87
    L79:
        r9 = false;
        goto L80
    L82:
        if (ZeusTransformUtils.instanceOf(r8, j.class) == false) goto L86;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L97
    L86:
        r9 = false;
        goto L87
    L33:
        r2 = helpTransfer(r2, r8);
        goto L6
    L12:
        j r26 = new j();
        monitor-enter(r26);
    L28:
        th = move-exception;
        throw th;
    L15:
        if (casTabAt(r2, r7, null, r26) == true) goto L105;
    L25:
        monitor-exit(r26);     // Catch: Throwable -> L28
        if (r4 == 0) goto L6;
    L105:
        Object r27 = r15.apply(r13);     // Catch: Throwable -> L22
        if (r27 == null) goto L20;
        i r28 = new i(r1, r13, r27);     // Catch: Throwable -> L22
    L21:
        setTabAt(r2, r7, r28);     // Catch: Throwable -> L28
        r5 = (V) r27;
        r4 = 1;
        goto L25
    L20:
        r28 = null;
    L22:
        th = move-exception;
        setTabAt(r2, r7, null);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L100:
        r2 = initTable();
        goto L6
    L127:
        throw null;
    L101:
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K r14, BiFunction<? super K, ? super V, ? extends V> r15) {
        BiFunction r16 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L66;
        if (r16 == null) goto L84;
        int r1 = spread(r14.hashCode());
        i<K, V>[] r2 = this.table;
        int r3 = 0;
        V r5 = null;
        int r4 = 0;
    L6:
        if (r2 == null) goto L65;
        int r6 = r2.length;
        if (r6 == 0) goto L65;
        int r7 = (r6 - 1) & r1;
        i<K, V> r8 = tabAt(r2, r7);
        if (r8 == null) goto L59;
        int r9 = r8.f18083b;
        if (r9 == (-1)) goto L15;
        monitor-enter(r8);
    L62:
        th = move-exception;
        throw th;
    L18:
        if (tabAt(r2, r7) != r8) goto L57;
        if (r9 < 0) goto L41;
        r4 = 1;
        i<K, V> r10 = null;
        i<K, V> r11 = r8;
    L22:
        if (r11.f18083b != r1) goto L36;
        K r12 = r11.c;     // Catch: Throwable -> L62
        if (r12 == r14) goto L28;
        if (r12 == null) goto L36;
        if (r14.equals(r12) == false) goto L36;
    L28:
        r5 = (V) r16.apply(r14, r11.d);
        if (r5 == null) goto L31;
        r11.d = r5;     // Catch: Throwable -> L62
        goto L57
    L31:
        i<K, V> r13 = r11.e;     // Catch: Throwable -> L62
        if (r10 == null) goto L34;
        r10.e = r13;     // Catch: Throwable -> L62
    L35:
        r3 = -1;
    L34:
        setTabAt(r2, r7, r13);     // Catch: Throwable -> L62
    L36:
        i<K, V> r17 = r11.e;     // Catch: Throwable -> L62
        if (r17 == null) goto L57;
        r4 = r4 + 1;     // Catch: Throwable -> L62
        r10 = r11;
        r11 = r17;
        goto L22
    L41:
        if (ZeusTransformUtils.instanceOf(r8, m.class) == false) goto L53;
        r4 = 2;
        m r18 = (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        n<K, V> r19 = r18.f18086a;     // Catch: Throwable -> L62
        if (r19 == null) goto L57;
        n<K, V> r110 = r19.a(r1, r14, null);     // Catch: Throwable -> L62
        if (r110 == null) goto L57;
        r5 = (V) r16.apply(r14, r110.d);
        if (r5 == null) goto L50;
        r110.d = r5;     // Catch: Throwable -> L62
        goto L57
    L50:
        if (r18.a(r110) == false) goto L35;
        r13 = untreeify(r18.f);     // Catch: Throwable -> L62
        goto L34
    L53:
        if (ZeusTransformUtils.instanceOf(r8, j.class) == false) goto L57;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L62
    L57:
        monitor-exit(r8);     // Catch: Throwable -> L62
        if (r4 == 0) goto L6;
    L15:
        r2 = helpTransfer(r2, r8);
    L59:
        if (r3 == 0) goto L61;
        addCount(r3, r4);
    L61:
        return r5;
    L65:
        r2 = initTable();
        goto L6
    L84:
        throw null;
    L66:
        throw null;
    }

    public boolean contains(Object r1) {
        return containsValue(r1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r1) {
        if (get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r5) {
        Objects.requireNonNull(r5);
        i<K, V>[] r4 = this.table;
        if (r4 == null) goto L14;
        l r1 = new l(r4, r4.length, 0, r4.length);
    L5:
        i<K, V> r6 = r1.b();
        if (r6 == null) goto L14;
        V r7 = r6.d;
        if (r7 == r5) goto L12;
        if (r7 == null) goto L5;
        if (r5.equals(r7) == false) goto L5;
        return true;
    L12:
        return true;
    L14:
        return false;
    }

    public Enumeration<V> elements() {
        i<K, V>[] r1 = this.table;
        if (r1 != null) goto L5;
        int r0 = 0;
    L6:
        int r4 = r0;
        return new o(r1, r4, 0, r4, this);
    L5:
        r0 = r1.length;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> r0 = this.entrySet;
        if (r0 == null) goto L5;
        return r0;
    L5:
        EntrySetView<K, V> r1 = new EntrySetView(this);
        this.entrySet = r1;
        return r1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r6) {
        if (r6 != this) goto L4;
        return true;
    L4:
        if (ZeusTransformUtils.instanceOf(r6, Map.class) == true) goto L6;
        return false;
    L6:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
        i<K, V>[] r0 = this.table;
        if (r0 != null) goto L9;
        int r3 = 0;
    L10:
        l r4 = new l(r0, r3, 0, r3);
    L11:
        i<K, V> r1 = r4.b();
        if (r1 == null) goto L19;
        V r5 = r1.d;
        Object r2 = r7.get(r1.c);
        if (r2 == null) goto L18;
        if (r2 == r5) goto L11;
        if (r2.equals(r5) == true) goto L11;
    L18:
        return false;
    L19:
        Iterator<Map.Entry<K, V>> r8 = r7.entrySet().iterator();
    L21:
        if (r8.hasNext() == false) goto L50;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r10 = r9.getKey();
        if (r10 == null) goto L31;
        Object r11 = r9.getValue();
        if (r11 == null) goto L31;
        V r12 = get(r10);
        if (r12 == null) goto L31;
        if (r11 == r12) goto L21;
        if (r11.equals(r12) == true) goto L21;
    L31:
        return false;
    L50:
        return true;
    L9:
        r3 = r0.length;
        goto L10
    }

    public void forEach(long r8, BiConsumer<? super K, ? super V> r10) {
        BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r10, BiConsumer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        new ForEachMappingTask(null, batchFor(r8), 0, 0, this.table, r6).invoke();
    }

    public <U> void forEach(long r11, BiFunction<? super K, ? super V, ? extends U> r13, Consumer<? super U> r14) {
        BiFunction r8 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r13, BiFunction.class, "com.obric.memorydata.plugin");
        Consumer r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r14, Consumer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        new ForEachTransformedMappingTask(null, batchFor(r11), 0, 0, this.table, r8, r9).invoke();
        return;
    L8:
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        i<K, V>[] r4 = this.table;
        if (r4 == null) goto L8;
        l r0 = new l(r4, r4.length, 0, r4.length);
    L5:
        i<K, V> r7 = r0.b();
        if (r7 == null) goto L10;
        r6.accept(r7.c, r7.d);
        goto L5
    L10:
        return;
    }

    public void forEachEntry(long r8, Consumer<? super Map.Entry<K, V>> r10) {
        Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r10, Consumer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        new ForEachEntryTask(null, batchFor(r8), 0, 0, this.table, r6).invoke();
    }

    public <U> void forEachEntry(long r11, Function<Map.Entry<K, V>, ? extends U> r13, Consumer<? super U> r14) {
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r13, Function.class, "com.obric.memorydata.plugin");
        Consumer r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r14, Consumer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        new ForEachTransformedEntryTask(null, batchFor(r11), 0, 0, this.table, r8, r9).invoke();
        return;
    L8:
        throw null;
    }

    public void forEachKey(long r8, Consumer<? super K> r10) {
        Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r10, Consumer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        new ForEachKeyTask(null, batchFor(r8), 0, 0, this.table, r6).invoke();
    }

    public <U> void forEachKey(long r11, Function<? super K, ? extends U> r13, Consumer<? super U> r14) {
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r13, Function.class, "com.obric.memorydata.plugin");
        Consumer r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r14, Consumer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        new ForEachTransformedKeyTask(null, batchFor(r11), 0, 0, this.table, r8, r9).invoke();
        return;
    L8:
        throw null;
    }

    public void forEachValue(long r8, Consumer<? super V> r10) {
        Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r10, Consumer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        new ForEachValueTask(null, batchFor(r8), 0, 0, this.table, r6).invoke();
    }

    public <U> void forEachValue(long r11, Function<? super V, ? extends U> r13, Consumer<? super U> r14) {
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r13, Function.class, "com.obric.memorydata.plugin");
        Consumer r9 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r14, Consumer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L8;
        new ForEachTransformedValueTask(null, batchFor(r11), 0, 0, this.table, r8, r9).invoke();
        return;
    L8:
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r4) {
        int r0 = spread(r4.hashCode());
        i<K, V>[] r3 = this.table;
        if (r3 == null) goto L33;
        int r2 = r3.length;
        if (r2 <= 0) goto L33;
        i<K, V> r5 = tabAt(r3, (r2 - 1) & r0);
        if (r5 == null) goto L33;
        int r6 = r5.f18083b;
        if (r6 != r0) goto L17;
        K r7 = r5.c;
        if (r7 == r4) goto L16;
        if (r7 == null) goto L22;
        if (r4.equals(r7) == true) goto L16;
    L22:
        r5 = r5.e;
        if (r5 == null) goto L33;
        if (r5.f18083b != r0) goto L22;
        K r8 = r5.c;
        if (r8 == r4) goto L32;
        if (r8 == null) goto L22;
        if (r4.equals(r8) == false) goto L22;
    L32:
        return r5.d;
    L16:
        return r5.d;
    L17:
        if (r6 >= 0) goto L22;
        i<K, V> r9 = r5.a(r0, r4);
        if (r9 != null) goto L21;
        return null;
    L21:
        return r9.d;
    L33:
        return null;
    }

    public Map.Entry<K, V> getEvictionCandidate(Random r11, int r12, Comparator<? super V> r13, org.ehcache.config.e<? super K, ? super V> r14) {
        Comparator<? super V> r8 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r13, Comparator.class, "com.obric.memorydata.plugin");
        org.ehcache.config.e<? super K, ? super V> r9 = (org.ehcache.config.e) ZeusTransformUtils.wrapperContextForParams(r14, org.ehcache.config.e.class, "com.obric.memorydata.plugin");
        i<K, V>[] r3 = this.table;
        if (r3 == null) goto L31;
        if (r12 == 0) goto L31;
        int r15 = r3.length;
        int r4 = r11.nextInt(r15);
        l r16 = new l(r3, r15, r4, r15);
        int r5 = r12;
        K r6 = null;
        V r7 = null;
    L7:
        i<K, V> r17 = r16.b();
        if (r17 == null) goto L30;
        K r18 = r17.c;
        V r19 = r17.d;
        if (r9.a(r18, r19) == true) goto L7;
        if (r6 != null) goto L13;
    L14:
        r7 = r19;
        r6 = r18;
    L15:
        r5 = r5 - 1;
        if (r5 != 0) goto L7;
        int r110 = r16.g;
    L18:
        i<K, V> r111 = r16.b();
        if (r111 == null) goto L28;
        if (r16.g != r110) goto L28;
        K r112 = r111.c;
        V r113 = r111.d;
        if (r9.a(r112, r113) == true) goto L18;
        if (r8.compare(r113, r7) <= 0) goto L18;
        r7 = r113;
        r6 = r112;
    L28:
        return new h(r6, r7, this);
    L13:
        if (r8.compare(r19, r7) <= 0) goto L15;
    L30:
        return getEvictionCandidateWrap(r3, r4, r5, r6, r7, r8, r9);
    L31:
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object r1, V r2) {
        V r0 = get(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        i<K, V>[] r4 = this.table;
        int r0 = 0;
        if (r4 == null) goto L8;
        l r1 = new l(r4, r4.length, 0, r4.length);
    L5:
        i<K, V> r5 = r1.b();
        if (r5 == null) goto L8;
        int r2 = r5.c.hashCode();
        r0 = r0 + (r5.d.hashCode() ^ r2);
    L8:
        return r0;
    }

    final i<K, V>[] helpTransfer(i<K, V>[] r9, i<K, V> r10) {
        if (r9 == null) goto L28;
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L28;
        i<K, V>[] r11 = ((e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.memorydata.plugin")).f18079a;
        if (r11 == null) goto L28;
        int r0 = resizeStamp(r9.length);
    L9:
        if (r11 != this.nextTable) goto L26;
        if (this.table != r9) goto L26;
        int r6 = this.sizeCtl;
        if (r6 >= 0) goto L26;
        if ((r6 >>> 16) != r0) goto L26;
        if (r6 == (r0 + 1)) goto L26;
        if (r6 == (65535 + r0)) goto L26;
        if (this.transferIndex <= 0) goto L26;
        if (U.compareAndSwapInt(this, SIZECTL, r6, r6 + 1) == false) goto L9;
        transfer(r9, r11);
    L26:
        return r11;
    L28:
        return this.table;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (sumCount() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public KeySetView<K, V> keySet() {
        KeySetView<K, V> r0 = this.keySet;
        if (r0 == null) goto L5;
        return r0;
    L5:
        KeySetView<K, V> r1 = new KeySetView(this, null);
        this.keySet = r1;
        return r1;
    }

    public KeySetView<K, V> keySet(V r2) {
        Objects.requireNonNull(r2);
        return new KeySetView(this, r2);
    }

    public Enumeration<K> keys() {
        i<K, V>[] r1 = this.table;
        if (r1 != null) goto L5;
        int r0 = 0;
    L6:
        int r4 = r0;
        return new f(r1, r4, 0, r4, this);
    L5:
        r0 = r1.length;
        goto L6
    }

    public long mappingCount() {
        long r0 = sumCount();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return 0;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V merge(K r18, V r19, BiFunction<? super V, ? super V, ? extends V> r20) {
        V r2 = r19;
        BiFunction r3 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r20, BiFunction.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L81;
        if (r2 == null) goto L102;
        if (r3 == null) goto L103;
        int r5 = spread(r18.hashCode());
        i<K, V>[] r6 = this.table;
        int r7 = 0;
        V r9 = null;
        int r8 = 0;
    L7:
        if (r6 == null) goto L80;
        int r10 = r6.length;
        if (r10 == 0) goto L80;
        int r11 = (r10 - 1) & r5;
        i<K, V> r12 = tabAt(r6, r11);
        int r13 = 1;
        if (r12 == null) goto L14;
        int r14 = r12.f18083b;
        if (r14 == (-1)) goto L18;
        monitor-enter(r12);
    L77:
        th = move-exception;
        throw th;
    L21:
        if (tabAt(r6, r11) != r12) goto L68;
        if (r14 < 0) goto L45;
        i<K, V> r15 = null;
        i<K, V> r16 = r12;
        int r17 = 1;
    L25:
        if (r16.f18083b != r5) goto L39;
        K r110 = r16.c;     // Catch: Throwable -> L77
        if (r110 == r18) goto L31;
        if (r110 == null) goto L39;
        if (r18.equals(r110) == false) goto L39;
    L31:
        V r111 = (V) r3.apply(r16.d, r2);
        if (r111 == null) goto L34;
        r16.d = r111;     // Catch: Throwable -> L77
    L42:
        r7 = r17;
        r9 = r111;
        goto L68
    L34:
        i<K, V> r21 = r16.e;     // Catch: Throwable -> L77
        if (r15 == null) goto L37;
        r15.e = r21;     // Catch: Throwable -> L77
    L38:
        r8 = -1;
        goto L42
    L37:
        setTabAt(r6, r11, r21);     // Catch: Throwable -> L77
    L39:
        i<K, V> r112 = r16.e;     // Catch: Throwable -> L77
        if (r112 == null) goto L41;
        r17 = r17 + 1;     // Catch: Throwable -> L77
        r15 = r16;
        r16 = r112;
        goto L25
    L41:
        r16.e = new i(r5, r18, r2);     // Catch: Throwable -> L77
        r8 = 1;
        r111 = r2;
        goto L42
    L45:
        if (ZeusTransformUtils.instanceOf(r12, m.class) == false) goto L64;
        r7 = 2;
        m r22 = (m) ZeusTransformUtils.preCheckCast(r12, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        n<K, V> r113 = r22.f18086a;     // Catch: Throwable -> L77
        if (r113 != null) goto L49;
        n<K, V> r114 = null;
    L50:
        if (r114 != null) goto L52;
        V r115 = r2;
    L53:
        if (r115 == null) goto L57;
        if (r114 == null) goto L56;
        r114.d = r115;     // Catch: Throwable -> L77
    L62:
        r9 = r115;
        goto L68
    L56:
        r22.a(r5, r18, r115);     // Catch: Throwable -> L77
        r8 = 1;
        goto L62
    L57:
        if (r114 == null) goto L62;
        if (r22.a(r114) == false) goto L61;
        setTabAt(r6, r11, untreeify(r22.f));     // Catch: Throwable -> L77
    L61:
        r8 = -1;
        goto L62
    L52:
        r115 = (V) r3.apply(r114.d, r2);
        goto L53
    L49:
        r114 = r113.a(r5, r18, null);     // Catch: Throwable -> L77
        goto L50
    L64:
        if (ZeusTransformUtils.instanceOf(r12, j.class) == false) goto L68;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L77
    L68:
        monitor-exit(r12);     // Catch: Throwable -> L77
        if (r7 == 0) goto L7;
        if (r7 < 8) goto L73;
        treeifyBin(r6, r11);
    L73:
        r13 = r8;
        r2 = r9;
    L74:
        if (r13 == 0) goto L76;
        addCount(r13, r7);
    L76:
        return r2;
    L18:
        r6 = helpTransfer(r6, r12);
        goto L7
    L14:
        if (casTabAt(r6, r11, null, new i(r5, r18, r2)) == false) goto L7;
    L80:
        r6 = initTable();
        goto L7
    L103:
        throw null;
    L102:
        throw null;
    L81:
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r2, V r3) {
        return putVal(r2, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        tryPresize(r6.size());
        Iterator<Map.Entry<K, V>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        putVal(r0.getKey(), r0.getValue(), false);
        goto L4
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r2, V r3) {
        return putVal(r2, r3, true);
    }

    final V putVal(K r9, V r10, boolean r11) {
        if (r9 == null) goto L73;
        if (r10 == null) goto L95;
        int r1 = spread(r9.hashCode());
        int r2 = 0;
        i<K, V>[] r3 = this.table;
    L6:
        if (r3 == null) goto L72;
        int r4 = r3.length;
        if (r4 == 0) goto L72;
        int r5 = (r4 - 1) & r1;
        i<K, V> r6 = tabAt(r3, r5);
        if (r6 == null) goto L13;
        int r7 = r6.f18083b;
        if (r7 == (-1)) goto L17;
        if (r11 == false) goto L28;
        if (r7 != r1) goto L28;
        K r8 = r6.c;
        if (r8 == r9) goto L25;
        if (r8 == null) goto L28;
        if (r9.equals(r8) == false) goto L28;
    L25:
        V r12 = r6.d;
        if (r12 == null) goto L28;
        return r12;
    L28:
        monitor-enter(r6);
    L69:
        th = move-exception;
        throw th;
    L30:
        if (tabAt(r3, r5) != r6) goto L59;
        if (r7 < 0) goto L48;
        r2 = 1;
        i<K, V> r13 = r6;
    L34:
        if (r13.f18083b != r1) goto L43;
        K r14 = r13.c;     // Catch: Throwable -> L69
        if (r14 == r9) goto L40;
        if (r14 == null) goto L43;
        if (r9.equals(r14) == false) goto L43;
    L40:
        V r15 = r13.d;     // Catch: Throwable -> L69
        if (r11 == true) goto L60;
    L42:
        r13.d = r10;     // Catch: Throwable -> L69
    L60:
        monitor-exit(r6);     // Catch: Throwable -> L69
        if (r2 == 0) goto L6;
        if (r2 < 8) goto L65;
        treeifyBin(r3, r5);
    L65:
        if (r15 == null) goto L67;
        return r15;
    L67:
        addCount(1, r2);
        return null;
    L43:
        i<K, V> r16 = r13.e;     // Catch: Throwable -> L69
        if (r16 == null) goto L45;
        r2 = r2 + 1;     // Catch: Throwable -> L69
        r13 = r16;
        goto L34
    L45:
        r13.e = new i(r1, r9, r10);     // Catch: Throwable -> L69
        goto L59
    L48:
        if (ZeusTransformUtils.instanceOf(r6, m.class) == false) goto L55;
        r2 = 2;
        r13 = ((m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.memorydata.plugin")).a(r1, r9, r10);     // Catch: Throwable -> L69
        if (r13 == null) goto L59;
        r15 = r13.d;     // Catch: Throwable -> L69
        if (r11 == true) goto L60;
    L55:
        if (ZeusTransformUtils.instanceOf(r6, j.class) == false) goto L59;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L69
    L59:
        r15 = null;
        goto L60
    L17:
        r3 = helpTransfer(r3, r6);
        goto L6
    L13:
        if (casTabAt(r3, r5, null, new i(r1, r9, r10)) == false) goto L6;
    L72:
        r3 = initTable();
        goto L6
    L95:
        throw null;
    L73:
        throw null;
    }

    public <U> U reduce(long r12, BiFunction<? super K, ? super V, ? extends U> r14, BiFunction<? super U, ? super U, ? extends U> r15) {
        BiFunction r9 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r14, BiFunction.class, "com.obric.memorydata.plugin");
        BiFunction r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L8;
        return (U) new MapReduceMappingsTask(null, batchFor(r12), 0, 0, this.table, null, r9, r10).invoke();
    L8:
        throw null;
    }

    public <U> U reduceEntries(long r12, Function<Map.Entry<K, V>, ? extends U> r14, BiFunction<? super U, ? super U, ? extends U> r15) {
        Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r14, Function.class, "com.obric.memorydata.plugin");
        BiFunction r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L8;
        return (U) new MapReduceEntriesTask(null, batchFor(r12), 0, 0, this.table, null, r9, r10).invoke();
    L8:
        throw null;
    }

    public Map.Entry<K, V> reduceEntries(long r11, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> r13) {
        BiFunction r9 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r13, BiFunction.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r9);
        return (Map.Entry) ZeusTransformUtils.preCheckCast(new ReduceEntriesTask(null, batchFor(r11), 0, 0, this.table, null, r9).invoke(), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    public double reduceEntriesToDouble(long r14, ToDoubleFunction<Map.Entry<K, V>> r16, double r17, DoubleBinaryOperator r19) {
        ToDoubleFunction r9 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToDoubleFunction.class, "com.obric.memorydata.plugin");
        DoubleBinaryOperator r12 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Double) ZeusTransformUtils.preCheckCast(new MapReduceEntriesToDoubleTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L8:
        throw null;
    }

    public int reduceEntriesToInt(long r13, ToIntFunction<Map.Entry<K, V>> r15, int r16, IntBinaryOperator r17) {
        ToIntFunction r9 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r15, ToIntFunction.class, "com.obric.memorydata.plugin");
        IntBinaryOperator r11 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r17, IntBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r11 == null) goto L8;
        return ((Integer) ZeusTransformUtils.preCheckCast(new MapReduceEntriesToIntTask(null, batchFor(r13), 0, 0, this.table, null, r9, r16, r11).invoke(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        throw null;
    }

    public long reduceEntriesToLong(long r14, ToLongFunction<Map.Entry<K, V>> r16, long r17, LongBinaryOperator r19) {
        ToLongFunction r9 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToLongFunction.class, "com.obric.memorydata.plugin");
        LongBinaryOperator r12 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Long) ZeusTransformUtils.preCheckCast(new MapReduceEntriesToLongTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        throw null;
    }

    public K reduceKeys(long r9, BiFunction<? super K, ? super K, ? extends K> r11) {
        BiFunction r7 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r11, BiFunction.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7);
        return (K) new ReduceKeysTask(null, batchFor(r9), 0, 0, this.table, null, r7).invoke();
    }

    public <U> U reduceKeys(long r12, Function<? super K, ? extends U> r14, BiFunction<? super U, ? super U, ? extends U> r15) {
        Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r14, Function.class, "com.obric.memorydata.plugin");
        BiFunction r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L8;
        return (U) new MapReduceKeysTask(null, batchFor(r12), 0, 0, this.table, null, r9, r10).invoke();
    L8:
        throw null;
    }

    public double reduceKeysToDouble(long r14, ToDoubleFunction<? super K> r16, double r17, DoubleBinaryOperator r19) {
        ToDoubleFunction r9 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToDoubleFunction.class, "com.obric.memorydata.plugin");
        DoubleBinaryOperator r12 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Double) ZeusTransformUtils.preCheckCast(new MapReduceKeysToDoubleTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L8:
        throw null;
    }

    public int reduceKeysToInt(long r13, ToIntFunction<? super K> r15, int r16, IntBinaryOperator r17) {
        ToIntFunction r9 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r15, ToIntFunction.class, "com.obric.memorydata.plugin");
        IntBinaryOperator r11 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r17, IntBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r11 == null) goto L8;
        return ((Integer) ZeusTransformUtils.preCheckCast(new MapReduceKeysToIntTask(null, batchFor(r13), 0, 0, this.table, null, r9, r16, r11).invoke(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        throw null;
    }

    public long reduceKeysToLong(long r14, ToLongFunction<? super K> r16, long r17, LongBinaryOperator r19) {
        ToLongFunction r9 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToLongFunction.class, "com.obric.memorydata.plugin");
        LongBinaryOperator r12 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Long) ZeusTransformUtils.preCheckCast(new MapReduceKeysToLongTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        throw null;
    }

    public double reduceToDouble(long r14, ToDoubleBiFunction<? super K, ? super V> r16, double r17, DoubleBinaryOperator r19) {
        ToDoubleBiFunction r9 = (ToDoubleBiFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToDoubleBiFunction.class, "com.obric.memorydata.plugin");
        DoubleBinaryOperator r12 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Double) ZeusTransformUtils.preCheckCast(new MapReduceMappingsToDoubleTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L8:
        throw null;
    }

    public int reduceToInt(long r13, ToIntBiFunction<? super K, ? super V> r15, int r16, IntBinaryOperator r17) {
        ToIntBiFunction r9 = (ToIntBiFunction) ZeusTransformUtils.wrapperContextForParams(r15, ToIntBiFunction.class, "com.obric.memorydata.plugin");
        IntBinaryOperator r11 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r17, IntBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r11 == null) goto L8;
        return ((Integer) ZeusTransformUtils.preCheckCast(new MapReduceMappingsToIntTask(null, batchFor(r13), 0, 0, this.table, null, r9, r16, r11).invoke(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        throw null;
    }

    public long reduceToLong(long r14, ToLongBiFunction<? super K, ? super V> r16, long r17, LongBinaryOperator r19) {
        ToLongBiFunction r9 = (ToLongBiFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToLongBiFunction.class, "com.obric.memorydata.plugin");
        LongBinaryOperator r12 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Long) ZeusTransformUtils.preCheckCast(new MapReduceMappingsToLongTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        throw null;
    }

    public V reduceValues(long r9, BiFunction<? super V, ? super V, ? extends V> r11) {
        BiFunction r7 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r11, BiFunction.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7);
        return (V) new ReduceValuesTask(null, batchFor(r9), 0, 0, this.table, null, r7).invoke();
    }

    public <U> U reduceValues(long r12, Function<? super V, ? extends U> r14, BiFunction<? super U, ? super U, ? extends U> r15) {
        Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r14, Function.class, "com.obric.memorydata.plugin");
        BiFunction r10 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r15, BiFunction.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L8;
        return (U) new MapReduceValuesTask(null, batchFor(r12), 0, 0, this.table, null, r9, r10).invoke();
    L8:
        throw null;
    }

    public double reduceValuesToDouble(long r14, ToDoubleFunction<? super V> r16, double r17, DoubleBinaryOperator r19) {
        ToDoubleFunction r9 = (ToDoubleFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToDoubleFunction.class, "com.obric.memorydata.plugin");
        DoubleBinaryOperator r12 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Double) ZeusTransformUtils.preCheckCast(new MapReduceValuesToDoubleTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    L8:
        throw null;
    }

    public int reduceValuesToInt(long r13, ToIntFunction<? super V> r15, int r16, IntBinaryOperator r17) {
        ToIntFunction r9 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r15, ToIntFunction.class, "com.obric.memorydata.plugin");
        IntBinaryOperator r11 = (IntBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r17, IntBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r11 == null) goto L8;
        return ((Integer) ZeusTransformUtils.preCheckCast(new MapReduceValuesToIntTask(null, batchFor(r13), 0, 0, this.table, null, r9, r16, r11).invoke(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        throw null;
    }

    public long reduceValuesToLong(long r14, ToLongFunction<? super V> r16, long r17, LongBinaryOperator r19) {
        ToLongFunction r9 = (ToLongFunction) ZeusTransformUtils.wrapperContextForParams(r16, ToLongFunction.class, "com.obric.memorydata.plugin");
        LongBinaryOperator r12 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r19, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r12 == null) goto L8;
        return ((Long) ZeusTransformUtils.preCheckCast(new MapReduceValuesToLongTask(null, batchFor(r14), 0, 0, this.table, null, r9, r17, r12).invoke(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        return replaceNode(r2, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r2, Object r3) {
        Objects.requireNonNull(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (replaceNode(r2, null, r3) == null) goto L7;
        return true;
    }

    public final Collection<Map.Entry<K, V>> removeAllWithHash(int r7) {
        ArrayList r0 = new ArrayList();
        int r8 = spread(r7);
        i<K, V>[] r1 = this.table;
    L3:
        if (r1 == null) goto L23;
        int r2 = r1.length;
        if (r2 == 0) goto L23;
        int r3 = (r2 - 1) & r8;
        i<K, V> r4 = tabAt(r1, r3);
        if (r4 == null) goto L23;
        if (r4.f18083b == (-1)) goto L11;
        int r5 = 0;
        monitor-enter(r4);
        if (tabAt(r1, r3) != r4) goto L17;
        r5 = nodesAt(r4, r0);     // Catch: Throwable -> L20
        setTabAt(r1, r3, null);     // Catch: Throwable -> L20
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L20
        if (r5 <= 0) goto L3;
        int r6 = -r5;
        addCount(r6, r6);
    L20:
        th = move-exception;
        throw th;
    L11:
        r1 = helpTransfer(r1, r4);
    L23:
        return r0;
    }

    boolean removeEntryIf(Predicate<? super Map.Entry<K, V>> r6) {
        Predicate r7 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r6, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7);
        i<K, V>[] r0 = this.table;
        boolean r1 = false;
        if (r0 == null) goto L12;
        l r2 = new l(r0, r0.length, 0, r0.length);
    L5:
        i<K, V> r3 = r2.b();
        if (r3 == null) goto L12;
        K r4 = r3.c;
        V r5 = r3.d;
        if (r7.test(new AbstractMap.SimpleImmutableEntry(r4, r5)) == false) goto L5;
        if (replaceNode(r4, null, r5) == null) goto L5;
        r1 = true;
    L12:
        return r1;
    }

    boolean removeValueIf(Predicate<? super V> r6) {
        Predicate r7 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r6, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7);
        i<K, V>[] r0 = this.table;
        boolean r1 = false;
        if (r0 == null) goto L12;
        l r2 = new l(r0, r0.length, 0, r0.length);
    L5:
        i<K, V> r3 = r2.b();
        if (r3 == null) goto L12;
        K r4 = r3.c;
        V r5 = r3.d;
        if (r7.test(r5) == false) goto L5;
        if (replaceNode(r4, null, r5) == null) goto L5;
        r1 = true;
    L12:
        return r1;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r2, V r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        throw null;
    L6:
        return replaceNode(r2, r3, null);
    L7:
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r1, V r2, V r3) {
        if (r1 == null) goto L11;
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        if (replaceNode(r1, r3, r2) == null) goto L8;
        return true;
    L8:
        return false;
    L11:
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r6) {
        BiFunction r7 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r6, BiFunction.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7);
        i<K, V>[] r0 = this.table;
        if (r0 == null) goto L13;
        l r1 = new l(r0, r0.length, 0, r0.length);
    L5:
        i<K, V> r2 = r1.b();
        if (r2 == null) goto L19;
        Object r3 = r2.d;
        K r4 = r2.c;
    L8:
        Object r5 = r7.apply(r4, r3);
        Objects.requireNonNull(r5);
        if (replaceNode(r4, r5, r3) != null) goto L5;
        r3 = get(r4);
        if (r3 != null) goto L8;
    L19:
        return;
    }

    final V replaceNode(Object r13, V r14, Object r15) {
        int r0 = spread(r13.hashCode());
        i<K, V>[] r1 = this.table;
    L4:
        if (r1 == null) goto L75;
        int r3 = r1.length;
        if (r3 == 0) goto L75;
        int r4 = (r3 - 1) & r0;
        i<K, V> r5 = tabAt(r1, r4);
        if (r5 == null) goto L75;
        int r6 = r5.f18083b;
        if (r6 == (-1)) goto L12;
        boolean r7 = false;
        monitor-enter(r5);
    L72:
        th = move-exception;
        throw th;
    L16:
        if (tabAt(r1, r4) != r5) goto L65;
        if (r6 < 0) goto L44;
        i<K, V> r8 = null;
        i<K, V> r9 = r5;
    L20:
        if (r9.f18083b != r0) goto L38;
        K r10 = r9.c;     // Catch: Throwable -> L72
        if (r10 == r13) goto L26;
        if (r10 == null) goto L38;
        if (r13.equals(r10) == false) goto L38;
    L26:
        V r11 = r9.d;     // Catch: Throwable -> L72
        if (r15 == null) goto L32;
        if (r15 == r11) goto L32;
        if (r11 != null) goto L31;
    L40:
        r11 = null;
    L41:
        r7 = true;
    L66:
        monitor-exit(r5);     // Catch: Throwable -> L72
        if (r7 == false) goto L4;
        if (r11 == null) goto L75;
        if (r14 != null) goto L71;
        addCount(-1, -1);
    L71:
        return r11;
    L31:
        if (r15.equals(r11) == false) goto L40;
    L32:
        if (r14 == null) goto L34;
        r9.d = r14;     // Catch: Throwable -> L72
        goto L41
    L34:
        if (r8 == null) goto L36;
        r8.e = r9.e;     // Catch: Throwable -> L72
        goto L41
    L36:
        i<K, V> r12 = r9.e;     // Catch: Throwable -> L72
    L37:
        setTabAt(r1, r4, r12);     // Catch: Throwable -> L72
    L38:
        i<K, V> r16 = r9.e;     // Catch: Throwable -> L72
        if (r16 == null) goto L40;
        r8 = r9;
        r9 = r16;
        goto L20
    L44:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == false) goto L61;
        m r17 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
        n<K, V> r18 = r17.f18086a;     // Catch: Throwable -> L72
        if (r18 == null) goto L40;
        n<K, V> r19 = r18.a(r0, r13, null);     // Catch: Throwable -> L72
        if (r19 == null) goto L40;
        r11 = r19.d;     // Catch: Throwable -> L72
        if (r15 == null) goto L55;
        if (r15 == r11) goto L55;
        if (r11 == null) goto L40;
        if (r15.equals(r11) == false) goto L40;
    L55:
        if (r14 == null) goto L58;
        r19.d = r14;     // Catch: Throwable -> L72
        goto L41
    L58:
        if (r17.a(r19) == false) goto L41;
        r12 = untreeify(r17.f);     // Catch: Throwable -> L72
        goto L37
    L61:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L65;
        throw new IllegalStateException("Recursive update");     // Catch: Throwable -> L72
    L65:
        r11 = null;
        goto L66
    L12:
        r1 = helpTransfer(r1, r5);
    L75:
        return null;
    }

    public <U> U search(long r9, BiFunction<? super K, ? super V, ? extends U> r11) {
        BiFunction r6 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r11, BiFunction.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        return (U) new SearchMappingsTask(null, batchFor(r9), 0, 0, this.table, r6, new AtomicReference()).invoke();
    }

    public <U> U searchEntries(long r9, Function<Map.Entry<K, V>, ? extends U> r11) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r11, Function.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        return (U) new SearchEntriesTask(null, batchFor(r9), 0, 0, this.table, r6, new AtomicReference()).invoke();
    }

    public <U> U searchKeys(long r9, Function<? super K, ? extends U> r11) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r11, Function.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        return (U) new SearchKeysTask(null, batchFor(r9), 0, 0, this.table, r6, new AtomicReference()).invoke();
    }

    public <U> U searchValues(long r9, Function<? super V, ? extends U> r11) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r11, Function.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6);
        return (U) new SearchValuesTask(null, batchFor(r9), 0, 0, this.table, r6, new AtomicReference()).invoke();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long r0 = sumCount();
        if (r0 >= 0) goto L6;
        return 0;
    L6:
        if (r0 <= 2147483647L) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) r0;
    }

    final long sumCount() {
        b[] r0 = this.counterCells;
        long r1 = this.baseCount;
        if (r0 == null) goto L10;
        int r6 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r6) goto L10;
        b r4 = r0[r3];
        if (r4 == null) goto L9;
        r1 = r1 + r4.f18076a;
    L9:
        r3 = r3 + 1;
    L10:
        return r1;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        i<K, V>[] r0 = this.table;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        l r3 = new l(r0, r2, 0, r2);
        StringBuilder r1 = new StringBuilder();
        r1.append('{');
        i<K, V> r4 = r3.b();
        if (r4 == null) goto L19;
    L8:
        Object r5 = r4.c;
        Object r6 = r4.d;
        if (r5 != this) goto L11;
        r5 = "(this Map)";
    L11:
        r1.append(r5);
        r1.append('=');
        if (r6 != this) goto L14;
        r6 = "(this Map)";
    L14:
        r1.append(r6);
        r4 = r3.b();
        if (r4 == null) goto L19;
        r1.append(',').append(' ');
    L19:
        return r1.append('}').toString();
    L5:
        r2 = r0.length;
        goto L6
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> r0 = this.values;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ValuesView<K, V> r1 = new ValuesView(this);
        this.values = r1;
        return r1;
    }
}
