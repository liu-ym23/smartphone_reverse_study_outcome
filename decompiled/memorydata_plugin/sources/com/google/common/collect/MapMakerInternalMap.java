package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.g;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
class MapMakerInternalMap<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final u<Object, Object, c> UNSET_WEAK_VALUE_REFERENCE = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient h<K, V, E, S> entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.w<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength r3, Strength r4, Equivalence<Object> r5, Equivalence<Object> r6, int r7, ConcurrentMap<K, V> r8) {
            ConcurrentMap<K, V> r9 = (ConcurrentMap) ZeusTransformUtils.wrapperContextForParams(r8, ConcurrentMap.class, "com.obric.memorydata.plugin");
            this.keyStrength = r3;
            this.valueStrength = r4;
            this.keyEquivalence = r5;
            this.valueEquivalence = r6;
            this.concurrencyLevel = r7;
            this.delegate = r9;
        }

        @Override // com.google.common.collect.w, com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.w, com.google.common.collect.y, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.w, com.google.common.collect.y, com.google.common.collect.ac
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        void readEntries(ObjectInputStream r4) {
        L2:
            Object r0 = r4.readObject();
            if (r0 == null) goto L4;
            Object r1 = r4.readObject();
            this.delegate.put((K) r0, (V) r1);
            goto L2
        }

        MapMaker readMapMaker(ObjectInputStream r2) {
            int r3 = r2.readInt();
            return new MapMaker().a(r3).a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream r4) {
            r4.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r3 = this.delegate.entrySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r4.writeObject(r0.getKey());
            r4.writeObject(r0.getValue());
            goto L4
        L6:
            r4.writeObject(null);
        }
    }

    static abstract class Segment<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount;
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> r2, int r3) {
            this.readCount = new AtomicInteger();
            this.map = r2;
            initTable(newEntryArray(r3));
        }

        static <K, V, E extends g<K, V, E>> boolean isCollected(E r2) {
            if (((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin")).e() != null) goto L5;
            return true;
        L5:
            return false;
        }

        abstract E castForTesting(g<K, V, ?> r1);

        void clear() {
            if (this.count == 0) goto L14;
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L11
            int r2 = 0;
        L7:
            if (r2 >= r0.length()) goto L9;
            r0.set(r2, null);     // Catch: Throwable -> L11
            r2 = r2 + 1;     // Catch: Throwable -> L11
            goto L7
        L9:
            maybeClearReferenceQueues();     // Catch: Throwable -> L11
            this.readCount.set(0);     // Catch: Throwable -> L11
            this.modCount++;     // Catch: Throwable -> L11
            this.count = 0;     // Catch: Throwable -> L11
            unlock();
            return;
        L11:
            th = move-exception;
            unlock();
            throw th;
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> r1) {
        L3:
            if (r1.poll() != null) goto L3;
        }

        boolean clearValueForTesting(K r10, int r11, u<K, V, ? extends g<K, V, ?>> r12) {
            u<K, V, E> r13 = (u) ZeusTransformUtils.wrapperContextForParams(r12, u.class, "com.obric.memorydata.plugin");
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L22
            int r2 = (r0.length() - 1) & r11;     // Catch: Throwable -> L22
            g r4 = (g) ZeusTransformUtils.preCheckCast(r0.get(r2), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            g r5 = r4;
        L5:
            if (r5 == null) goto L20;
            Object r7 = r5.a();     // Catch: Throwable -> L22
            if (r5.b() != r11) goto L18;
            if (r7 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r10, r7) == false) goto L18;
            if (((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).d() != r13) goto L16;
            r0.set(r2, (E) removeFromChain(r4, r5));     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r5 = r5.c();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean containsKey(Object r3, int r4) {
            boolean r1 = false;
            if (this.count == 0) goto L11;
            g r5 = getLiveEntry(r3, r4);     // Catch: Throwable -> L13
            if (r5 == null) goto L9;
            if (r5.e() == null) goto L9;
            r1 = true;
        L9:
            postReadCleanup();
            return r1;
        L11:
            postReadCleanup();
            return false;
        L13:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        boolean containsValue(Object r8) {
        L20:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L18;
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L20
            int r2 = r0.length();     // Catch: Throwable -> L20
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L18;
            g r4 = (g) ZeusTransformUtils.preCheckCast(r0.get(r3), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        L7:
            if (r4 == null) goto L17;
            V r5 = getLiveValue(r4);     // Catch: Throwable -> L20
            if (r5 != null) goto L12;
        L15:
            r4 = r4.c();     // Catch: Throwable -> L20
            goto L7
        L12:
            if (this.map.valueEquivalence().equivalent(r8, r5) == false) goto L15;
            postReadCleanup();
            return true;
        L17:
            r3 = r3 + 1;
        L18:
            postReadCleanup();
            return false;
        }

        E copyEntry(E r3, E r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            return (E) this.map.entryHelper.a(self(), r5, r6);
        }

        E copyForTesting(g<K, V, ?> r3, g<K, V, ?> r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            g<K, V, ?> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            return (E) this.map.entryHelper.a(self(), castForTesting(r5), castForTesting(r6));
        }

        void drainKeyReferenceQueue(ReferenceQueue<K> r5) {
            int r0 = 0;
        L3:
            Reference<? extends K> r1 = r5.poll();
            if (r1 == null) goto L7;
            g r2 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
            this.map.reclaimKey(r2);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void drainValueReferenceQueue(ReferenceQueue<V> r5) {
            int r0 = 0;
        L3:
            Reference<? extends V> r1 = r5.poll();
            if (r1 == null) goto L7;
            u<K, V, E> r2 = (u) ZeusTransformUtils.preCheckCast(r1, u.class, "com.obric.memorydata.plugin");
            this.map.reclaimValue(r2);
            r0 = r0 + 1;
            if (r0 != 16) goto L3;
            return;
        }

        void expand() {
            AtomicReferenceArray<E> r0 = this.table;
            int r1 = r0.length();
            if (r1 < 1073741824) goto L5;
            return;
        L5:
            int r2 = this.count;
            AtomicReferenceArray<E> r3 = newEntryArray(r1 << 1);
            this.threshold = (r3.length() * 3) / 4;
            int r4 = r3.length() - 1;
            int r5 = 0;
        L6:
            if (r5 >= r1) goto L26;
            g r6 = (g) ZeusTransformUtils.preCheckCast(r0.get(r5), g.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L25;
            g r7 = r6.c();
            int r9 = r6.b() & r4;
            if (r7 != null) goto L12;
            r3.set(r9, r6);
            goto L25
        L12:
            g r10 = r6;
        L13:
            if (r7 == null) goto L18;
            int r11 = r7.b() & r4;
            if (r11 == r9) goto L17;
            r10 = r7;
            r9 = r11;
        L17:
            r7 = r7.c();
            goto L13
        L18:
            r3.set(r9, r10);
        L19:
            if (r6 == r10) goto L25;
            int r8 = r6.b() & r4;
            g r12 = copyEntry(r6, (g) ZeusTransformUtils.preCheckCast(r3.get(r8), g.class, "com.obric.memorydata.plugin"));
            if (r12 == null) goto L23;
            r3.set(r8, r12);
        L24:
            r6 = r6.c();
            goto L19
        L23:
            r2 = r2 - 1;
        L25:
            r5 = r5 + 1;
            goto L6
        L26:
            this.table = r3;
            this.count = r2;
        }

        V get(Object r1, int r2) {
            g r3 = getLiveEntry(r1, r2);     // Catch: Throwable -> L11
            if (r3 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r4 = (V) r3.e();
            if (r4 != null) goto L9;
            tryDrainReferenceQueues();     // Catch: Throwable -> L11
        L9:
            postReadCleanup();
            return r4;
        L11:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        E getEntry(Object r4, int r5) {
            if (this.count == 0) goto L16;
            E r0 = (E) getFirst(r5);
        L5:
            if (r0 == null) goto L23;
            if (r0.b() != r5) goto L15;
            Object r1 = r0.a();
            if (r1 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r4, r1) == false) goto L15;
            return r0;
        L15:
            r0 = (E) r0.c();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        E getFirst(int r2) {
            AtomicReferenceArray<E> r1 = this.table;
            return (E) ZeusTransformUtils.preCheckCast(r1.get(r2 & (r1.length() - 1)), g.class, "com.obric.memorydata.plugin");
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        E getLiveEntry(Object r1, int r2) {
            return (E) getEntry(r1, r2);
        }

        V getLiveValue(E r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            if (r4.a() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r5 = (V) r4.e();
            if (r5 != null) goto L10;
            tryDrainReferenceQueues();
            return null;
        L10:
            return r5;
        }

        V getLiveValueForTesting(g<K, V, ?> r3) {
            return getLiveValue(castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")));
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        u<K, V, E> getWeakValueReferenceForTesting(g<K, V, ?> r2) {
            g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<E> r2) {
            this.threshold = (r2.length() * 3) / 4;
            this.table = r2;
        }

        void maybeClearReferenceQueues() {
        }

        void maybeDrainReferenceQueues() {
        }

        AtomicReferenceArray<E> newEntryArray(int r1) {
            return new AtomicReferenceArray(r1);
        }

        E newEntryForTesting(K r3, int r4, g<K, V, ?> r5) {
            g<K, V, ?> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
            return (E) this.map.entryHelper.a(self(), r3, r4, castForTesting(r6));
        }

        u<K, V, E> newWeakValueReferenceForTesting(g<K, V, ?> r1, V r2) {
            g r0 = (g) ZeusTransformUtils.wrapperContextForParams(r1, g.class, "com.obric.memorydata.plugin");
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        V put(K r9, int r10, V r11, boolean r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            int r0 = this.count + 1;     // Catch: Throwable -> L29
            if (r0 <= this.threshold) goto L6;
            expand();     // Catch: Throwable -> L29
            r0 = this.count + 1;     // Catch: Throwable -> L29
        L6:
            AtomicReferenceArray<E> r1 = this.table;     // Catch: Throwable -> L29
            int r2 = (r1.length() - 1) & r10;     // Catch: Throwable -> L29
            g r3 = (g) ZeusTransformUtils.preCheckCast(r1.get(r2), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            g r4 = r3;
        L8:
            if (r4 == null) goto L26;
            Object r6 = r4.a();     // Catch: Throwable -> L29
            if (r4.b() != r10) goto L25;
            if (r6 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L25;
            V r13 = (V) r4.e();
            if (r13 != null) goto L19;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r11);     // Catch: Throwable -> L29
            this.count = this.count;     // Catch: Throwable -> L29
            unlock();
            return null;
        L19:
            if (r12 == false) goto L22;
            unlock();
            return r13;
        L22:
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r11);     // Catch: Throwable -> L29
            unlock();
            return r13;
        L25:
            r4 = r4.c();     // Catch: Throwable -> L29
            goto L8
        L26:
            this.modCount++;     // Catch: Throwable -> L29
            g r14 = this.map.entryHelper.a(self(), r9, r10, r3);     // Catch: Throwable -> L29
            setValue(r14, r11);     // Catch: Throwable -> L29
            r1.set(r2, (E) r14);     // Catch: Throwable -> L29
            this.count = r0;     // Catch: Throwable -> L29
            unlock();
            return null;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean reclaimKey(E r6, int r7) {
            g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L13
            int r9 = r7 & (r0.length() - 1);     // Catch: Throwable -> L13
            g r1 = (g) ZeusTransformUtils.preCheckCast(r0.get(r9), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            g r2 = r1;
        L4:
            if (r2 == null) goto L11;
            if (r2 == r8) goto L6;
            r2 = r2.c();     // Catch: Throwable -> L13
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L13
            g r10 = removeFromChain(r1, r2);     // Catch: Throwable -> L13
            int r3 = this.count - 1;     // Catch: Throwable -> L13
            r0.set(r9, (E) r10);     // Catch: Throwable -> L13
            this.count = r3;     // Catch: Throwable -> L13
            unlock();
            return true;
        L11:
            unlock();
            return false;
        L13:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean reclaimValue(K r10, int r11, u<K, V, E> r12) {
            u<K, V, E> r13 = (u) ZeusTransformUtils.wrapperContextForParams(r12, u.class, "com.obric.memorydata.plugin");
            lock();
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L22
            int r2 = (r0.length() - 1) & r11;     // Catch: Throwable -> L22
            g r4 = (g) ZeusTransformUtils.preCheckCast(r0.get(r2), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            g r5 = r4;
        L5:
            if (r5 == null) goto L20;
            Object r7 = r5.a();     // Catch: Throwable -> L22
            if (r5.b() != r11) goto L18;
            if (r7 == null) goto L18;
            if (this.map.keyEquivalence.equivalent(r10, r7) == false) goto L18;
            if (((t) ZeusTransformUtils.preCheckCast(r5, t.class, "com.obric.memorydata.plugin")).d() != r13) goto L16;
            this.modCount++;     // Catch: Throwable -> L22
            g r14 = removeFromChain(r4, r5);     // Catch: Throwable -> L22
            int r15 = this.count - 1;     // Catch: Throwable -> L22
            r0.set(r2, (E) r14);     // Catch: Throwable -> L22
            this.count = r15;     // Catch: Throwable -> L22
            unlock();
            return true;
        L16:
            unlock();
            return false;
        L18:
            r5 = r5.c();     // Catch: Throwable -> L22
            goto L5
        L20:
            unlock();
            return false;
        L22:
            th = move-exception;
            unlock();
            throw th;
        }

        V remove(Object r8, int r9) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L25
            g r2 = (g) ZeusTransformUtils.preCheckCast(r0.get(r1), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            g r3 = r2;
        L5:
            if (r3 == null) goto L23;
            Object r5 = r3.a();     // Catch: Throwable -> L25
            if (r3.b() != r9) goto L21;
            if (r5 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r8, r5) == false) goto L21;
            V r10 = (V) r3.e();
            if (r10 == null) goto L15;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            g r11 = removeFromChain(r2, r3);     // Catch: Throwable -> L25
            int r4 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r11);     // Catch: Throwable -> L25
            this.count = r4;     // Catch: Throwable -> L25
            unlock();
            return r10;
        L15:
            if (isCollected(r3) == true) goto L16;
            unlock();
            return null;
        L21:
            r3 = r3.c();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean remove(Object r9, int r10, Object r11) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L25
            g r3 = (g) ZeusTransformUtils.preCheckCast(r0.get(r1), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            g r4 = r3;
        L4:
            boolean r5 = false;
            if (r4 == null) goto L23;
            Object r6 = r4.a();     // Catch: Throwable -> L25
            if (r4.b() != r10) goto L21;
            if (r6 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L21;
            if (this.map.valueEquivalence().equivalent(r11, r4.e()) == false) goto L15;
            r5 = true;
        L16:
            this.modCount++;     // Catch: Throwable -> L25
            g r12 = removeFromChain(r3, r4);     // Catch: Throwable -> L25
            int r13 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r12);     // Catch: Throwable -> L25
            this.count = r13;     // Catch: Throwable -> L25
            unlock();
            return r5;
        L15:
            if (isCollected(r4) == true) goto L16;
            unlock();
            return false;
        L21:
            r4 = r4.c();     // Catch: Throwable -> L25
            goto L4
        L23:
            unlock();
            return false;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean removeEntryForTesting(E r7) {
            g r8 = (g) ZeusTransformUtils.wrapperContextForParams(r7, g.class, "com.obric.memorydata.plugin");
            int r0 = r8.b();
            AtomicReferenceArray<E> r2 = this.table;
            int r1 = r0 & (r2.length() - 1);
            g r3 = (g) ZeusTransformUtils.preCheckCast(r2.get(r1), g.class, "com.obric.memorydata.plugin");
            g r4 = r3;
        L3:
            if (r4 == null) goto L8;
            if (r4 == r8) goto L5;
            r4 = r4.c();
            goto L3
        L5:
            this.modCount++;
            g r9 = removeFromChain(r3, r4);
            int r5 = this.count - 1;
            r2.set(r1, (E) r9);
            this.count = r5;
            return true;
        L8:
            return false;
        }

        E removeFromChain(E r4, E r5) {
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
            int r0 = this.count;
            E r1 = (E) r7.c();
        L3:
            if (r6 == r7) goto L9;
            g r2 = copyEntry(r6, r1);
            if (r2 == null) goto L7;
            r1 = (E) r2;
        L8:
            r6 = r6.c();
            goto L3
        L7:
            r0 = r0 - 1;
            goto L8
        L9:
            this.count = r0;
            return r1;
        }

        E removeFromChainForTesting(g<K, V, ?> r3, g<K, V, ?> r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            g<K, V, ?> r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            return (E) removeFromChain(castForTesting(r5), castForTesting(r6));
        }

        boolean removeTableEntryForTesting(g<K, V, ?> r3) {
            return removeEntryForTesting(castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")));
        }

        V replace(K r8, int r9, V r10) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L25
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L25
            int r1 = (r0.length() - 1) & r9;     // Catch: Throwable -> L25
            g r2 = (g) ZeusTransformUtils.preCheckCast(r0.get(r1), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            g r3 = r2;
        L5:
            if (r3 == null) goto L23;
            Object r5 = r3.a();     // Catch: Throwable -> L25
            if (r3.b() != r9) goto L21;
            if (r5 == null) goto L21;
            if (this.map.keyEquivalence.equivalent(r8, r5) == false) goto L21;
            V r11 = (V) r3.e();
            if (r11 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L25
            setValue(r3, r10);     // Catch: Throwable -> L25
            unlock();
            return r11;
        L14:
            if (isCollected(r3) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L25
            g r12 = removeFromChain(r2, r3);     // Catch: Throwable -> L25
            int r13 = this.count - 1;     // Catch: Throwable -> L25
            r0.set(r1, (E) r12);     // Catch: Throwable -> L25
            this.count = r13;     // Catch: Throwable -> L25
        L16:
            unlock();
            return null;
        L21:
            r3 = r3.c();     // Catch: Throwable -> L25
            goto L5
        L23:
            unlock();
            return null;
        L25:
            th = move-exception;
            unlock();
            throw th;
        }

        boolean replace(K r9, int r10, V r11, V r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L29
            AtomicReferenceArray<E> r0 = this.table;     // Catch: Throwable -> L29
            int r1 = (r0.length() - 1) & r10;     // Catch: Throwable -> L29
            g r3 = (g) ZeusTransformUtils.preCheckCast(r0.get(r1), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            g r4 = r3;
        L5:
            if (r4 == null) goto L27;
            Object r6 = r4.a();     // Catch: Throwable -> L29
            if (r4.b() != r10) goto L25;
            if (r6 == null) goto L25;
            if (this.map.keyEquivalence.equivalent(r9, r6) == false) goto L25;
            Object r13 = r4.e();     // Catch: Throwable -> L29
            if (r13 != null) goto L19;
            if (isCollected(r4) == false) goto L16;
            this.modCount++;     // Catch: Throwable -> L29
            g r14 = removeFromChain(r3, r4);     // Catch: Throwable -> L29
            int r15 = this.count - 1;     // Catch: Throwable -> L29
            r0.set(r1, (E) r14);     // Catch: Throwable -> L29
            this.count = r15;     // Catch: Throwable -> L29
        L16:
            unlock();
            return false;
        L19:
            if (this.map.valueEquivalence().equivalent(r11, r13) == false) goto L23;
            this.modCount++;     // Catch: Throwable -> L29
            setValue(r4, r12);     // Catch: Throwable -> L29
            unlock();
            return true;
        L23:
            unlock();
            return false;
        L25:
            r4 = r4.c();     // Catch: Throwable -> L29
            goto L5
        L27:
            unlock();
            return false;
        L29:
            th = move-exception;
            unlock();
            throw th;
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            this.readCount.set(0);     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        abstract S self();

        void setTableEntryForTesting(int r3, g<K, V, ?> r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.table.set(r3, (E) castForTesting(r5));
        }

        void setValue(E r3, V r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            this.map.entryHelper.a(self(), r5, r4);
        }

        void setValueForTesting(g<K, V, ?> r3, V r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            this.map.entryHelper.a(self(), castForTesting(r5), r4);
        }

        void setWeakValueReferenceForTesting(g<K, V, ?> r2, u<K, V, ? extends g<K, V, ?>> r3) {
            g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock() == true) goto L10;
            return;
        L10:
            maybeDrainReferenceQueues();     // Catch: Throwable -> L6
            unlock();
            return;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength r8, Strength r9, Equivalence<Object> r10, Equivalence<Object> r11, int r12, ConcurrentMap<K, V> r13) {
            super(r8, r9, r10, r11, r12, (ConcurrentMap) ZeusTransformUtils.wrapperContextForParams(r13, ConcurrentMap.class, "com.obric.memorydata.plugin"));
        }

        private void readObject(ObjectInputStream r2) {
            r2.defaultReadObject();
            this.delegate = readMapMaker(r2).g();
            readEntries(r2);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream r1) {
            r1.defaultWriteObject();
            writeMapTo(r1);
        }
    }

    static abstract enum Strength extends Enum<Strength> {
        private static final /* synthetic */ Strength[] $VALUES = null;
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        private static /* synthetic */ Strength[] $values() {
            return new Strength[]{STRONG, WEAK};
        }

        static {
            final String r1 = "STRONG";
            final int r2 = 0;
            STRONG = new AnonymousClass1(r1, r2);
            final String r3 = "WEAK";
            final int r4 = 1;
            WEAK = new AnonymousClass2(r3, r4);
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
    }

    static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, l<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, l<K>, StrongKeyDummyValueSegment<K>> r1, int r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l<K> castForTesting(g<K, MapMaker.Dummy, ?> r2) {
            return (l) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), l.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> r1, int r2) {
            super(r1, r2);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K, V> castForTesting(g<K, V, ?> r2) {
            return (m) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), m.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> r1, int r2) {
            super(r1, r2);
            this.queueForValues = new ReferenceQueue();
        }

        static /* synthetic */ ReferenceQueue access$500(StrongKeyWeakValueSegment r0) {
            return r0.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(g<K, V, ?> r2) {
            return (n) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), n.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u<K, V, n<K, V>> getWeakValueReferenceForTesting(g<K, V, ?> r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")).d();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u<K, V, n<K, V>> newWeakValueReferenceForTesting(g<K, V, ?> r3, V r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            return new v(this.queueForValues, r4, castForTesting(r5));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(g<K, V, ?> r3, u<K, V, ? extends g<K, V, ?>> r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            u r6 = (u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin");
            n<K, V> r2 = castForTesting(r5);
            u r7 = n.a(r2);
            n.a(r2, r6);
            r7.clear();
        }
    }

    static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, q<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, q<K>, WeakKeyDummyValueSegment<K>> r1, int r2) {
            super(r1, r2);
            this.queueForKeys = new ReferenceQueue();
        }

        static /* synthetic */ ReferenceQueue access$800(WeakKeyDummyValueSegment r0) {
            return r0.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public q<K> castForTesting(g<K, MapMaker.Dummy, ?> r2) {
            return (q) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), q.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyStrongValueSegment<K, V>> r1, int r2) {
            super(r1, r2);
            this.queueForKeys = new ReferenceQueue();
        }

        static /* synthetic */ ReferenceQueue access$1200(WeakKeyStrongValueSegment r0) {
            return r0.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K, V> castForTesting(g<K, V, ?> r2) {
            return (r) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), r.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyWeakValueSegment<K, V>> r1, int r2) {
            super(r1, r2);
            this.queueForKeys = new ReferenceQueue();
            this.queueForValues = new ReferenceQueue();
        }

        static /* synthetic */ ReferenceQueue access$1500(WeakKeyWeakValueSegment r0) {
            return r0.queueForValues;
        }

        static /* synthetic */ ReferenceQueue access$1600(WeakKeyWeakValueSegment r0) {
            return r0.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* synthetic */ g castForTesting(g r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(g<K, V, ?> r2) {
            return (s) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), s.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u<K, V, s<K, V>> getWeakValueReferenceForTesting(g<K, V, ?> r3) {
            return castForTesting((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")).d();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u<K, V, s<K, V>> newWeakValueReferenceForTesting(g<K, V, ?> r3, V r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            return new v(this.queueForValues, r4, castForTesting(r5));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* bridge */ /* synthetic */ Segment self() {
            return self();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(g<K, V, ?> r3, u<K, V, ? extends g<K, V, ?>> r4) {
            g<K, V, ?> r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            u r6 = (u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin");
            s<K, V> r2 = castForTesting(r5);
            u r7 = s.a(r2);
            s.a(r2, r6);
            r7.clear();
        }
    }

    static abstract class a<K, V, E extends g<K, V, E>> implements g<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4520b;

        a(K r1, int r2) {
            this.f4519a = r1;
            this.f4520b = r2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final K a() {
            return this.f4519a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final int b() {
            return this.f4520b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public E c() {
            return null;
        }
    }

    static abstract class b<K, V, E extends g<K, V, E>> extends WeakReference<K> implements g<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4521a;

        b(ReferenceQueue<K> r1, K r2, int r3) {
            super(r2, r1);
            this.f4521a = r3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final K a() {
            return (K) get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final int b() {
            return this.f4521a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public E c() {
            return null;
        }
    }

    static final class c implements g<Object, Object, c> {
        private c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public Object a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public int b() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public /* synthetic */ g c() {
            return d();
        }

        public c d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public Object e() {
            throw new AssertionError();
        }
    }

    final class d extends MapMakerInternalMap<K, V, E, S>.f<Map.Entry<K, V>> {
        d(MapMakerInternalMap r1) {
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

    final class e extends k<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapMakerInternalMap f4522a;

        e(MapMakerInternalMap r1) {
            this.f4522a = r1;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4522a.clear();
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
            Object r1 = this.f4522a.get(r0);
            if (r1 != null) goto L11;
            return false;
        L11:
            if (this.f4522a.valueEquivalence().equivalent(r5.getValue(), r1) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f4522a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(this.f4522a);
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
            if (this.f4522a.remove(r0, r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4522a.size();
        }
    }

    abstract class f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4524b;
        Segment<K, V, E, S> c;
        AtomicReferenceArray<E> d;
        E e;
        MapMakerInternalMap<K, V, E, S>.w f;
        MapMakerInternalMap<K, V, E, S>.w g;
        final /* synthetic */ MapMakerInternalMap h;

        f(MapMakerInternalMap r1) {
            this.h = r1;
            this.f4523a = r1.segments.length - 1;
            this.f4524b = -1;
            b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(E r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            Object r0 = r5.a();     // Catch: Throwable -> L10
            Object r6 = this.h.getLiveValue(r5);     // Catch: Throwable -> L10
            if (r6 == null) goto L9;
            this.f = new w(this.h, r0, r6);     // Catch: Throwable -> L10
            boolean r7 = true;
        L7:
            this.c.postReadCleanup();
            return r7;
        L9:
            r7 = false;
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
            if (this.f4523a < 0) goto L14;
            Segment<K, V, E, S>[] r0 = this.h.segments;
            int r1 = this.f4523a;
            this.f4523a = r1 - 1;
            Segment<K, V, E, S> r2 = r0[r1];
            this.c = r2;
            if (r2.count == 0) goto L9;
            AtomicReferenceArray<E> r3 = this.c.table;
            this.d = r3;
            this.f4524b = r3.length() - 1;
            if (d() == false) goto L9;
            return;
        }

        boolean c() {
            E r0 = this.e;
            if (r0 == null) goto L11;
        L4:
            this.e = (E) r0.c();
            E r1 = this.e;
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
            int r0 = this.f4524b;
            if (r0 < 0) goto L12;
            AtomicReferenceArray<E> r1 = this.d;
            this.f4524b = r0 - 1;
            E r2 = (E) ZeusTransformUtils.preCheckCast(r1.get(r0), g.class, "com.obric.memorydata.plugin");
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

        MapMakerInternalMap<K, V, E, S>.w e() {
            MapMakerInternalMap<K, V, E, S>.w r0 = this.f;
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
            com.google.common.collect.o.a(r0);
            this.h.remove(this.g.getKey());
            this.g = null;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    interface g<K, V, E extends g<K, V, E>> {
        K a();

        int b();

        E c();

        V e();
    }

    interface h<K, V, E extends g<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> r1, int r2);

        Strength a();

        E a(S r1, E r2, E r3);

        E a(S r1, K r2, int r3, E r4);

        void a(S r1, E r2, V r3);

        Strength b();
    }

    final class i extends MapMakerInternalMap<K, V, E, S>.f<K> {
        i(MapMakerInternalMap r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public K next() {
            return e().getKey();
        }
    }

    final class j extends k<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapMakerInternalMap f4525a;

        j(MapMakerInternalMap r1) {
            this.f4525a = r1;
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4525a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.f4525a.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f4525a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i(this.f4525a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            if (this.f4525a.remove(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4525a.size();
        }
    }

    private static abstract class k<E> extends AbstractSet<E> {
        private k() {
        }

        /* synthetic */ k(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.access$1800(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) MapMakerInternalMap.access$1800(this).toArray(r1);
        }
    }

    static class l<K> extends a<K, MapMaker.Dummy, l<K>> implements al<K, MapMaker.Dummy, l<K>> {

        static final class a<K> implements h<K, MapMaker.Dummy, l<K>, StrongKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?> f4526a = null;

            static {
                f4526a = new a();
            }

            a() {
            }

            static <K> a<K> c() {
                return (a<K>) f4526a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), (l) ZeusTransformUtils.preCheckCast(r6, l.class, "com.obric.memorydata.plugin"), (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.memorydata.plugin"));
            }

            public l<K> a(StrongKeyDummyValueSegment<K> r2, l<K> r3, l<K> r4) {
                return a(r2, r3.f4519a, r3.f4520b, r4);
            }

            public l<K> a(StrongKeyDummyValueSegment<K> r1, K r2, int r3, l<K> r4) {
                if (r4 != null) goto L5;
                return new l(r2, r3, null);
            L5:
                return new b(r2, r3, r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, MapMaker.Dummy r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((StrongKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), (l) ZeusTransformUtils.preCheckCast(r6, l.class, "com.obric.memorydata.plugin"), (MapMaker.Dummy) ZeusTransformUtils.preCheckCast(r5, MapMaker.Dummy.class, "com.obric.memorydata.plugin"));
            }

            public void a(StrongKeyDummyValueSegment<K> r1, l<K> r2, MapMaker.Dummy r3) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            public StrongKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, l<K>, StrongKeyDummyValueSegment<K>> r1, int r2) {
                return new StrongKeyDummyValueSegment(r1, r2);
            }
        }

        private static final class b<K> extends l<K> {
            private final l<K> c;

            b(K r2, int r3, l<K> r4) {
                super(r2, r3, null);
                this.c = r4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return f();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ Object e() {
                return super.d();
            }

            public l<K> f() {
                return this.c;
            }
        }

        private l(K r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ l(Object r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public final MapMaker.Dummy d() {
            return MapMaker.Dummy.VALUE;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public /* synthetic */ Object e() {
            return d();
        }
    }

    static class m<K, V> extends a<K, V, m<K, V>> implements al<K, V, m<K, V>> {
        private volatile V c;

        static final class a<K, V> implements h<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f4527a = null;

            static {
                f4527a = new a();
            }

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f4527a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.memorydata.plugin"));
            }

            public m<K, V> a(StrongKeyStrongValueSegment<K, V> r3, m<K, V> r4, m<K, V> r5) {
                m<K, V> r2 = a(r3, r4.f4519a, r4.f4520b, r5);
                m.a(r2, m.a(r4));
                return r2;
            }

            public m<K, V> a(StrongKeyStrongValueSegment<K, V> r1, K r2, int r3, m<K, V> r4) {
                if (r4 != null) goto L5;
                return new m(r2, r3, null);
            L5:
                return new b(r2, r3, r4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, Object r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((StrongKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), (m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.memorydata.plugin"), r5);
            }

            public void a(StrongKeyStrongValueSegment<K, V> r1, m<K, V> r2, V r3) {
                m.a(r2, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            public StrongKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, m<K, V>, StrongKeyStrongValueSegment<K, V>> r1, int r2) {
                return new StrongKeyStrongValueSegment(r1, r2);
            }
        }

        private static final class b<K, V> extends m<K, V> {
            private final m<K, V> c;

            b(K r2, int r3, m<K, V> r4) {
                super(r2, r3, null);
                this.c = r4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return d();
            }

            public m<K, V> d() {
                return this.c;
            }
        }

        private m(K r1, int r2) {
            super(r1, r2);
            this.c = null;
        }

        /* synthetic */ m(Object r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ Object a(m r0) {
            return r0.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Object a(m r0, Object r1) {
            r0.c = r1;
            return r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final V e() {
            return this.c;
        }
    }

    static class n<K, V> extends a<K, V, n<K, V>> implements t<K, V, n<K, V>> {
        private volatile u<K, V, n<K, V>> c;

        static final class a<K, V> implements h<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f4528a = null;

            static {
                f4528a = new a();
            }

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f4528a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin"), (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((StrongKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.memorydata.plugin"));
            }

            public n<K, V> a(StrongKeyWeakValueSegment<K, V> r3, n<K, V> r4, n<K, V> r5) {
                if (Segment.isCollected(r4) == false) goto L6;
                return null;
            L6:
                n<K, V> r2 = a(r3, r4.f4519a, r4.f4520b, r5);
                n.a(r2, n.a(r4).a(StrongKeyWeakValueSegment.access$500(r3), r2));
                return r2;
            }

            public n<K, V> a(StrongKeyWeakValueSegment<K, V> r1, K r2, int r3, n<K, V> r4) {
                if (r4 != null) goto L5;
                return new n(r2, r3, null);
            L5:
                return new b(r2, r3, r4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, Object r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((StrongKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, StrongKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin"), r5);
            }

            public void a(StrongKeyWeakValueSegment<K, V> r2, n<K, V> r3, V r4) {
                u r1 = n.a(r3);
                n.a(r3, new v(StrongKeyWeakValueSegment.access$500(r2), r4, r3));
                r1.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.WEAK;
            }

            public StrongKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, n<K, V>, StrongKeyWeakValueSegment<K, V>> r1, int r2) {
                return new StrongKeyWeakValueSegment(r1, r2);
            }
        }

        private static final class b<K, V> extends n<K, V> {
            private final n<K, V> c;

            b(K r2, int r3, n<K, V> r4) {
                super(r2, r3, null);
                this.c = r4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return f();
            }

            public n<K, V> f() {
                return this.c;
            }
        }

        private n(K r1, int r2) {
            super(r1, r2);
            this.c = MapMakerInternalMap.unsetWeakValueReference();
        }

        /* synthetic */ n(Object r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ u a(n r0) {
            return r0.c;
        }

        static /* synthetic */ u a(n r2, u r3) {
            u<K, V, n<K, V>> r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
            r2.c = r4;
            return r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public final u<K, V, n<K, V>> d() {
            return this.c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final V e() {
            return this.c.get();
        }
    }

    final class o extends MapMakerInternalMap<K, V, E, S>.f<V> {
        o(MapMakerInternalMap r1) {
            super(r1);
        }

        @Override // java.util.Iterator
        public V next() {
            return e().getValue();
        }
    }

    final class p extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapMakerInternalMap f4529a;

        p(MapMakerInternalMap r1) {
            this.f4529a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4529a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.f4529a.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f4529a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new o(this.f4529a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4529a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.access$1800(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) MapMakerInternalMap.access$1800(this).toArray(r1);
        }
    }

    static class q<K> extends b<K, MapMaker.Dummy, q<K>> implements al<K, MapMaker.Dummy, q<K>> {

        static final class a<K> implements h<K, MapMaker.Dummy, q<K>, WeakKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?> f4530a = null;

            static {
                f4530a = new a();
            }

            a() {
            }

            static <K> a<K> c() {
                return (a<K>) f4530a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), (q) ZeusTransformUtils.preCheckCast(r6, q.class, "com.obric.memorydata.plugin"), (q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (q) ZeusTransformUtils.preCheckCast(r7, q.class, "com.obric.memorydata.plugin"));
            }

            public q<K> a(WeakKeyDummyValueSegment<K> r2, q<K> r3, q<K> r4) {
                K r0 = r3.a();
                if (r0 != null) goto L7;
                return null;
            L7:
                return a(r2, r0, r3.f4521a, r4);
            }

            public q<K> a(WeakKeyDummyValueSegment<K> r7, K r8, int r9, q<K> r10) {
                if (r10 != null) goto L5;
                return new q(WeakKeyDummyValueSegment.access$800(r7), r8, r9, null);
            L5:
                return new b(WeakKeyDummyValueSegment.access$800(r7), r8, r9, r10, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, MapMaker.Dummy r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((WeakKeyDummyValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyDummyValueSegment.class, "com.obric.memorydata.plugin"), (q) ZeusTransformUtils.preCheckCast(r6, q.class, "com.obric.memorydata.plugin"), (MapMaker.Dummy) ZeusTransformUtils.preCheckCast(r5, MapMaker.Dummy.class, "com.obric.memorydata.plugin"));
            }

            public void a(WeakKeyDummyValueSegment<K> r1, q<K> r2, MapMaker.Dummy r3) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            public WeakKeyDummyValueSegment<K> b(MapMakerInternalMap<K, MapMaker.Dummy, q<K>, WeakKeyDummyValueSegment<K>> r1, int r2) {
                return new WeakKeyDummyValueSegment(r1, r2);
            }
        }

        private static final class b<K> extends q<K> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final q<K> f4531b;

            private b(ReferenceQueue<K> r2, K r3, int r4, q<K> r5) {
                super(r2, r3, r4, null);
                this.f4531b = r5;
            }

            /* synthetic */ b(ReferenceQueue r1, Object r2, int r3, q r4, AnonymousClass1 r5) {
                this(r1, r2, r3, r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return f();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.q, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ Object e() {
                return super.d();
            }

            public q<K> f() {
                return this.f4531b;
            }
        }

        private q(ReferenceQueue<K> r1, K r2, int r3) {
            super(r1, r2, r3);
        }

        /* synthetic */ q(ReferenceQueue r1, Object r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public final MapMaker.Dummy d() {
            return MapMaker.Dummy.VALUE;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public /* synthetic */ Object e() {
            return d();
        }
    }

    static class r<K, V> extends b<K, V, r<K, V>> implements al<K, V, r<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile V f4532b;

        static final class a<K, V> implements h<K, V, r<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f4533a = null;

            static {
                f4533a = new a();
            }

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f4533a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), (r) ZeusTransformUtils.preCheckCast(r6, r.class, "com.obric.memorydata.plugin"), (r) ZeusTransformUtils.preCheckCast(r7, r.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (r) ZeusTransformUtils.preCheckCast(r7, r.class, "com.obric.memorydata.plugin"));
            }

            public r<K, V> a(WeakKeyStrongValueSegment<K, V> r3, r<K, V> r4, r<K, V> r5) {
                K r0 = r4.a();
                if (r0 != null) goto L6;
                return null;
            L6:
                r<K, V> r2 = a(r3, r0, r4.f4521a, r5);
                r.a(r2, r.a(r4));
                return r2;
            }

            public r<K, V> a(WeakKeyStrongValueSegment<K, V> r7, K r8, int r9, r<K, V> r10) {
                if (r10 != null) goto L5;
                return new r(WeakKeyStrongValueSegment.access$1200(r7), r8, r9, null);
            L5:
                return new b(WeakKeyStrongValueSegment.access$1200(r7), r8, r9, r10, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, Object r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((WeakKeyStrongValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyStrongValueSegment.class, "com.obric.memorydata.plugin"), (r) ZeusTransformUtils.preCheckCast(r6, r.class, "com.obric.memorydata.plugin"), r5);
            }

            public void a(WeakKeyStrongValueSegment<K, V> r1, r<K, V> r2, V r3) {
                r.a(r2, r3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.STRONG;
            }

            public WeakKeyStrongValueSegment<K, V> b(MapMakerInternalMap<K, V, r<K, V>, WeakKeyStrongValueSegment<K, V>> r1, int r2) {
                return new WeakKeyStrongValueSegment(r1, r2);
            }
        }

        private static final class b<K, V> extends r<K, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final r<K, V> f4534b;

            private b(ReferenceQueue<K> r2, K r3, int r4, r<K, V> r5) {
                super(r2, r3, r4, null);
                this.f4534b = r5;
            }

            /* synthetic */ b(ReferenceQueue r1, Object r2, int r3, r r4, AnonymousClass1 r5) {
                this(r1, r2, r3, r4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return d();
            }

            public r<K, V> d() {
                return this.f4534b;
            }
        }

        private r(ReferenceQueue<K> r1, K r2, int r3) {
            super(r1, r2, r3);
            this.f4532b = null;
        }

        /* synthetic */ r(ReferenceQueue r1, Object r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ Object a(r r0) {
            return r0.f4532b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Object a(r r0, Object r1) {
            r0.f4532b = r1;
            return r1;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final V e() {
            return this.f4532b;
        }
    }

    static class s<K, V> extends b<K, V, s<K, V>> implements t<K, V, s<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile u<K, V, s<K, V>> f4535b;

        static final class a<K, V> implements h<K, V, s<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f4536a = null;

            static {
                f4536a = new a();
            }

            a() {
            }

            static <K, V> a<K, V> c() {
                return (a<K, V>) f4536a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ Segment a(MapMakerInternalMap r1, int r2) {
                return b(r1, r2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, g r4, g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.preCheckCast(r7, s.class, "com.obric.memorydata.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ g a(Segment r3, Object r4, int r5, g r6) {
                g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
                return a((WeakKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), r4, r5, (s) ZeusTransformUtils.preCheckCast(r7, s.class, "com.obric.memorydata.plugin"));
            }

            public s<K, V> a(WeakKeyWeakValueSegment<K, V> r4, s<K, V> r5, s<K, V> r6) {
                K r0 = r5.a();
                if (r0 != null) goto L6;
                return null;
            L6:
                if (Segment.isCollected(r5) == false) goto L8;
                return null;
            L8:
                s<K, V> r3 = a(r4, r0, r5.f4521a, r6);
                s.a(r3, s.a(r5).a(WeakKeyWeakValueSegment.access$1500(r4), r3));
                return r3;
            }

            public s<K, V> a(WeakKeyWeakValueSegment<K, V> r1, K r2, int r3, s<K, V> r4) {
                if (r4 != null) goto L5;
                return new s(WeakKeyWeakValueSegment.access$1600(r1), r2, r3);
            L5:
                return new b(WeakKeyWeakValueSegment.access$1600(r1), r2, r3, r4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.MapMakerInternalMap.h
            public /* synthetic */ void a(Segment r3, g r4, Object r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
                a((WeakKeyWeakValueSegment) ZeusTransformUtils.preCheckCast(r3, WeakKeyWeakValueSegment.class, "com.obric.memorydata.plugin"), (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.memorydata.plugin"), r5);
            }

            public void a(WeakKeyWeakValueSegment<K, V> r2, s<K, V> r3, V r4) {
                u r1 = s.a(r3);
                s.a(r3, new v(WeakKeyWeakValueSegment.access$1500(r2), r4, r3));
                r1.clear();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.h
            public Strength b() {
                return Strength.WEAK;
            }

            public WeakKeyWeakValueSegment<K, V> b(MapMakerInternalMap<K, V, s<K, V>, WeakKeyWeakValueSegment<K, V>> r1, int r2) {
                return new WeakKeyWeakValueSegment(r1, r2);
            }
        }

        private static final class b<K, V> extends s<K, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final s<K, V> f4537b;

            b(ReferenceQueue<K> r1, K r2, int r3, s<K, V> r4) {
                super(r1, r2, r3);
                this.f4537b = r4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.g
            public /* synthetic */ g c() {
                return f();
            }

            public s<K, V> f() {
                return this.f4537b;
            }
        }

        s(ReferenceQueue<K> r1, K r2, int r3) {
            super(r1, r2, r3);
            this.f4535b = MapMakerInternalMap.unsetWeakValueReference();
        }

        static /* synthetic */ u a(s r0) {
            return r0.f4535b;
        }

        static /* synthetic */ u a(s r2, u r3) {
            u<K, V, s<K, V>> r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
            r2.f4535b = r4;
            return r4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public final u<K, V, s<K, V>> d() {
            return this.f4535b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.g
        public final V e() {
            return this.f4535b.get();
        }
    }

    interface t<K, V, E extends g<K, V, E>> extends g<K, V, E> {
        u<K, V, E> d();
    }

    interface u<K, V, E extends g<K, V, E>> {
        u<K, V, E> a(ReferenceQueue<V> r1, E r2);

        E b();

        void clear();

        V get();
    }

    static final class v<K, V, E extends g<K, V, E>> extends WeakReference<V> implements u<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final E f4538a;

        v(ReferenceQueue<V> r3, V r4, E r5) {
            E r6 = (E) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
            super(r4, r3);
            this.f4538a = r6;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public u<K, V, E> a(ReferenceQueue<V> r3, E r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            return new v(r3, get(), r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public E b() {
            return this.f4538a;
        }
    }

    final class w extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f4540b;
        final /* synthetic */ MapMakerInternalMap c;

        w(MapMakerInternalMap r1, K r2, V r3) {
            this.c = r1;
            this.f4539a = r2;
            this.f4540b = r3;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L10;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            if (this.f4539a.equals(r5.getKey()) == true) goto L7;
            return false;
        L7:
            if (this.f4540b.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f4539a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f4540b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            int r0 = this.f4539a.hashCode();
            return this.f4540b.hashCode() ^ r0;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V r3) {
            V r0 = (V) this.c.put(this.f4539a, r3);
            this.f4540b = r3;
            return r0;
        }
    }

    static {
        UNSET_WEAK_VALUE_REFERENCE = new AnonymousClass1();
    }

    private MapMakerInternalMap(MapMaker r5, h<K, V, E, S> r6) {
        h<K, V, E, S> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.memorydata.plugin");
        this.concurrencyLevel = Math.min(r5.c(), 65536);
        this.keyEquivalence = r5.a();
        this.entryHelper = r7;
        int r8 = Math.min(r5.b(), 1073741824);
        int r9 = 0;
        int r0 = 1;
        int r2 = 0;
        int r1 = 1;
    L4:
        if (r1 >= this.concurrencyLevel) goto L6;
        r2 = r2 + 1;
        r1 = r1 << 1;
        goto L4
    L6:
        this.segmentShift = 32 - r2;
        this.segmentMask = r1 - 1;
        this.segments = newSegmentArray(r1);
        int r3 = r8 / r1;
        if ((r1 * r3) >= r8) goto L9;
        r3 = r3 + 1;
    L9:
        if (r0 >= r3) goto L11;
        r0 = r0 << 1;
    L11:
        Segment<K, V, E, S>[] r10 = this.segments;
        if (r9 >= r10.length) goto L14;
        r10[r9] = createSegment(r0);
        r9 = r9 + 1;
        goto L11
    }

    static /* synthetic */ ArrayList access$1800(Collection r2) {
        return toArrayList((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends g<K, V, ?>, ?> create(MapMaker r2) {
        if (r2.e() != Strength.STRONG) goto L9;
        if (r2.f() != Strength.STRONG) goto L9;
        return new MapMakerInternalMap(r2, m.a.c());
    L9:
        if (r2.e() != Strength.STRONG) goto L15;
        if (r2.f() != Strength.WEAK) goto L15;
        return new MapMakerInternalMap(r2, n.a.c());
    L15:
        if (r2.e() != Strength.WEAK) goto L21;
        if (r2.f() != Strength.STRONG) goto L21;
        return new MapMakerInternalMap(r2, r.a.c());
    L21:
        if (r2.e() != Strength.WEAK) goto L27;
        if (r2.f() != Strength.WEAK) goto L27;
        return new MapMakerInternalMap(r2, s.a.c());
    L27:
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends g<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker r2) {
        if (r2.e() != Strength.STRONG) goto L9;
        if (r2.f() != Strength.STRONG) goto L9;
        return new MapMakerInternalMap(r2, l.a.c());
    L9:
        if (r2.e() != Strength.WEAK) goto L15;
        if (r2.f() != Strength.STRONG) goto L15;
        return new MapMakerInternalMap(r2, q.a.c());
    L15:
        if (r2.f() != Strength.WEAK) goto L19;
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    L19:
        throw new AssertionError();
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    static int rehash(int r2) {
        int r3 = r2 + ((r2 << 15) ^ (-12931));
        int r4 = r3 ^ (r3 >>> 10);
        int r5 = r4 + (r4 << 3);
        int r6 = r5 ^ (r5 >>> 6);
        int r7 = r6 + ((r6 << 2) + (r6 << 14));
        return r7 ^ (r7 >>> 16);
    }

    private static <E> ArrayList<E> toArrayList(Collection<E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        ArrayList<E> r0 = new ArrayList(r3.size());
        Iterators.a(r0, r3.iterator());
        return r0;
    }

    static <K, V, E extends g<K, V, E>> u<K, V, E> unsetWeakValueReference() {
        return (u<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] r3 = this.segments;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].clear();
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).containsKey(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object r17) {
        boolean r1 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        Segment<K, V, E, S>[] r3 = this.segments;
        long r4 = -1;
        int r6 = 0;
    L7:
        if (r6 >= 3) goto L29;
        long r7 = 0;
        int r9 = r3.length;
        ?? r10 = r1;
    L9:
        if (r10 >= r9) goto L25;
        Segment<K, V, E, S> r11 = r3[r10];
        int r12 = r11.count;
        AtomicReferenceArray<E> r13 = r11.table;
        ?? r14 = r1;
    L12:
        if (r14 >= r13.length()) goto L23;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r13.get(r14), g.class, "com.obric.memorydata.plugin");
    L14:
        if (r2 == null) goto L22;
        V r15 = r11.getLiveValue(r2);
        if (r15 == null) goto L21;
        if (valueEquivalence().equivalent(r17, r15) == false) goto L21;
        return true;
    L21:
        r2 = r2.c();
        goto L14
    L22:
        r14 = r14 + 1;
        goto L12
    L23:
        r7 = r7 + ((long) r11.modCount);
        r1 = false;
        r10 = r10 + 1;
        goto L9
    L25:
        if (r7 == r4) goto L26;
        r6 = r6 + 1;
        r4 = r7;
        r1 = false;
        goto L7
    L26:
        return false;
    L29:
        return r1;
    }

    E copyEntry(E r3, E r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        return (E) segmentFor(r5.b()).copyEntry(r5, r6);
    }

    Segment<K, V, E, S> createSegment(int r2) {
        return this.entryHelper.a(this, r2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L7;
        e r1 = new e(this);
        this.entrySet = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).get(r2, r0);
    }

    E getEntry(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return (E) segmentFor(r0).getEntry(r2, r0);
    }

    V getLiveValue(E r2) {
        g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        if (r1.a() != null) goto L7;
        return null;
    L7:
        return (V) r1.e();
    }

    int hash(Object r1) {
        return rehash(this.keyEquivalence.hash(r1));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] r9 = this.segments;
        long r4 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r9.length) goto L10;
        if (r9[r3].count != 0) goto L7;
        r4 = r4 + ((long) r9[r3].modCount);
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r4 == 0) goto L22;
        int r5 = 0;
    L13:
        if (r5 >= r9.length) goto L19;
        if (r9[r5].count != 0) goto L16;
        r4 = r4 - ((long) r9[r5].modCount);
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r4 == 0) goto L21;
        return false;
    L21:
        return true;
    L22:
        return true;
    }

    boolean isLiveForTesting(g<K, V, ?> r3) {
        g<K, V, ?> r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        if (segmentFor(r4.b()).getLiveValueForTesting(r4) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r0 = this.keySet;
        if (r0 != null) goto L7;
        j r1 = new j(this);
        this.keySet = r1;
        return r1;
    L7:
        return r0;
    }

    Strength keyStrength() {
        return this.entryHelper.a();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int r1) {
        return new Segment[r1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r3, V r4) {
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r4);
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, false);
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
        int r0 = hash(r3);
        return segmentFor(r0).put(r3, r0, r4, true);
    }

    void reclaimKey(E r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        int r0 = r4.b();
        segmentFor(r0).reclaimKey(r4, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(u<K, V, E> r3) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        g r0 = r4.b();
        int r1 = r0.b();
        segmentFor(r1).reclaimValue(r0.a(), r1, r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r2, Object r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L9;
        int r0 = hash(r2);
        return segmentFor(r0).remove(r2, r0, r3);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r2, V r3) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r3);
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r2, V r3, V r4) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r4);
        if (r3 != null) goto L6;
        return false;
    L6:
        int r0 = hash(r2);
        return segmentFor(r0).replace(r2, r0, r3, r4);
    }

    Segment<K, V, E, S> segmentFor(int r3) {
        Segment<K, V, E, S>[] r0 = this.segments;
        int r4 = r3 >>> this.segmentShift;
        return r0[this.segmentMask & r4];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V, E, S>[] r5 = this.segments;
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        r0 = r0 + ((long) r5[r2].count);
        r2 = r2 + 1;
        goto L4
    L7:
        return Ints.b(r0);
    }

    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.b().defaultEquivalence();
    }

    Strength valueStrength() {
        return this.entryHelper.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L7;
        p r1 = new p(this);
        this.values = r1;
        return r1;
    L7:
        return r0;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.a(), this.entryHelper.b(), this.keyEquivalence, this.entryHelper.b().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
