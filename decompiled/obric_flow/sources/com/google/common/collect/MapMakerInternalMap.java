package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.h6;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
class MapMakerInternalMap<K, V, E extends h6, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final y6 UNSET_WEAK_VALUE_REFERENCE = null;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i6 entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final com.google.common.base.p keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    public static abstract class AbstractSerializationProxy<K, V> extends u2 implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final com.google.common.base.p keyEquivalence;
        final Strength keyStrength;
        final com.google.common.base.p valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength r5, Strength r10, com.google.common.base.p r11, com.google.common.base.p r12, int r13, ConcurrentMap<K, V> r14) {
            this.keyStrength = r5;
            this.valueStrength = r10;
            this.keyEquivalence = r11;
            this.valueEquivalence = r12;
            this.concurrencyLevel = r13;
            this.delegate = r14;
        }

        @Override // com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public void readEntries(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        L2:
            Object r10 = r5.readObject();
            if (r10 == null) goto L4;
            Object r11 = r5.readObject();
            this.delegate.put((K) r10, (V) r11);
            goto L2
        }

        public a6 readMapMaker(ObjectInputStream r10) throws IOException {
            int r11 = r10.readInt();
            a6 r5 = new a6();
            boolean r12 = true;
            if (r11 < 0) goto L5;
            boolean r13 = true;
        L6:
            com.google.common.base.b0.i(r13);
            r5.f8891b = r11;
            r5.d(this.keyStrength);
            Strength r14 = this.valueStrength;
            Strength r15 = r5.e;
            if (r15 != null) goto L9;
            boolean r16 = true;
        L10:
            com.google.common.base.b0.s("Value strength was already set to %s", r16, r15);
            r14.getClass();
            r5.e = r14;
            if (r14 == Strength.STRONG) goto L13;
            r5.f8890a = true;
        L13:
            com.google.common.base.p r17 = this.keyEquivalence;
            com.google.common.base.p r18 = r5.f;
            if (r18 != null) goto L16;
            boolean r19 = true;
        L17:
            com.google.common.base.b0.s("key equivalence was already set to %s", r19, r18);
            r17.getClass();
            r5.f = r17;
            r5.f8890a = true;
            int r20 = this.concurrencyLevel;
            int r21 = r5.f8892c;
            if (r21 != (-1)) goto L20;
            boolean r22 = true;
        L21:
            com.google.common.base.b0.q(r21, "concurrency level was already set to %s", r22);
            if (r20 > 0) goto L25;
            r12 = false;
        L25:
            com.google.common.base.b0.i(r12);
            r5.f8892c = r20;
            return r5;
        L20:
            r22 = false;
            goto L21
        L16:
            r19 = false;
            goto L17
        L9:
            r16 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        public void writeMapTo(ObjectOutputStream r5) throws IOException {
            r5.writeInt(this.delegate.size());
            Iterator<Map.Entry<K, V>> r10 = this.delegate.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            Map.Entry<K, V> r11 = r10.next();
            r5.writeObject(r11.getKey());
            r5.writeObject(r11.getValue());
            goto L4
        L6:
            r5.writeObject(null);
        }

        @Override // com.google.common.collect.v2, com.google.common.collect.z2
        public /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.u2, com.google.common.collect.v2, com.google.common.collect.z2
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    public static abstract class Segment<K, V, E extends h6, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount;
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> r5, int r10, int r11) {
            this.readCount = new AtomicInteger();
            this.map = r5;
            this.maxSegmentSize = r11;
            initTable(newEntryArray(r10));
        }

        public static <K, V, E extends h6> boolean isCollected(E r5) {
            if (r5.getValue() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract E castForTesting(h6 r5);

        public void clear() {
            if (this.count == 0) goto L15;
            lock();
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L9
            int r10 = 0;
        L7:
            if (r10 >= r5.length()) goto L11;
            r5.set(r10, null);     // Catch: Throwable -> L9
            r10 = r10 + 1;     // Catch: Throwable -> L9
            goto L7
        L11:
            maybeClearReferenceQueues();     // Catch: Throwable -> L9
            this.readCount.set(0);     // Catch: Throwable -> L9
            this.modCount++;     // Catch: Throwable -> L9
            this.count = 0;     // Catch: Throwable -> L9
            unlock();
            return;
        L9:
            th = move-exception;
            unlock();
            throw th;
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> r5) {
        L3:
            if (r5.poll() != null) goto L3;
        }

        public boolean clearValueForTesting(K r10, int r11, y6 r12) {
            lock();
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L16
            int r13 = (r5.length() - 1) & r11;     // Catch: Throwable -> L16
            E r14 = r5.get(r13);     // Catch: Throwable -> L16
            h6 r15 = r14;
        L5:
            if (r15 == null) goto L22;
            Object r16 = r15.getKey();     // Catch: Throwable -> L16
            if (r15.getHash() != r11) goto L20;
            if (r16 == null) goto L20;
            if (this.map.keyEquivalence.equivalent(r10, r16) == false) goto L20;
            if (((x6) r15).getValueReference() != r12) goto L18;
            r5.set(r13, (E) removeFromChain(r14, r15));     // Catch: Throwable -> L16
            unlock();
            return true;
        L18:
            unlock();
            return false;
        L20:
            r15 = r15.getNext();     // Catch: Throwable -> L16
            goto L5
        L22:
            unlock();
            return false;
        L16:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean containsKey(Object r5, int r10) {
            boolean r11 = false;
            if (this.count == 0) goto L13;
            h6 r12 = getLiveEntry(r5, r10);     // Catch: Throwable -> L9
            if (r12 == null) goto L11;
            if (r12.getValue() == null) goto L11;
            r11 = true;
        L11:
            postReadCleanup();
            return r11;
        L13:
            postReadCleanup();
            return false;
        L9:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        public boolean containsValue(Object r10) {
        L17:
            th = move-exception;
            postReadCleanup();
            throw th;
        L3:
            if (this.count == 0) goto L20;
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L17
            int r11 = r5.length();     // Catch: Throwable -> L17
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L20;
            E r13 = r5.get(r12);     // Catch: Throwable -> L17
        L7:
            if (r13 == null) goto L19;
            V r14 = getLiveValue(r13);     // Catch: Throwable -> L17
            if (r14 != null) goto L12;
        L15:
            r13 = r13.getNext();     // Catch: Throwable -> L17
            goto L7
        L12:
            if (this.map.valueEquivalence().equivalent(r10, r14) == false) goto L15;
            postReadCleanup();
            return true;
        L19:
            r12 = r12 + 1;
        L20:
            postReadCleanup();
            return false;
        }

        public E copyEntry(E r5, E r10) {
            return (E) this.map.entryHelper.a(self(), r5, r10);
        }

        public E copyForTesting(h6 r5, h6 r10) {
            return (E) this.map.entryHelper.a(self(), castForTesting(r5), castForTesting(r10));
        }

        public void drainKeyReferenceQueue(ReferenceQueue<K> r5) {
            int r10 = 0;
        L3:
            Reference<? extends K> r11 = r5.poll();
            if (r11 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r12 = this.map;
            r12.reclaimKey((h6) r11);
            r10 = r10 + 1;
            if (r10 != 16) goto L3;
            return;
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> r5) {
            int r10 = 0;
        L3:
            Reference<? extends V> r11 = r5.poll();
            if (r11 == null) goto L7;
            MapMakerInternalMap<K, V, E, S> r12 = this.map;
            r12.reclaimValue((y6) r11);
            r10 = r10 + 1;
            if (r10 != 16) goto L3;
            return;
        }

        public void expand() {
            AtomicReferenceArray<E> r5 = this.table;
            int r10 = r5.length();
            if (r10 < 1073741824) goto L5;
            return;
        L5:
            int r11 = this.count;
            AtomicReferenceArray<E> r12 = newEntryArray(r10 << 1);
            this.threshold = (r12.length() * 3) / 4;
            int r13 = r12.length() - 1;
            int r14 = 0;
        L6:
            if (r14 >= r10) goto L26;
            E r15 = r5.get(r14);
            if (r15 == null) goto L25;
            h6 r16 = r15.getNext();
            int r17 = r15.getHash() & r13;
            if (r16 != null) goto L12;
            r12.set(r17, r15);
            goto L25
        L12:
            h6 r18 = r15;
        L13:
            if (r16 == null) goto L18;
            int r19 = r16.getHash() & r13;
            if (r19 == r17) goto L17;
            r18 = r16;
            r17 = r19;
        L17:
            r16 = r16.getNext();
            goto L13
        L18:
            r12.set(r17, r18);
        L19:
            if (r15 == r18) goto L25;
            int r20 = r15.getHash() & r13;
            h6 r21 = copyEntry(r15, (h6) r12.get(r20));
            if (r21 == null) goto L23;
            r12.set(r20, r21);
        L24:
            r15 = r15.getNext();
            goto L19
        L23:
            r11 = r11 - 1;
        L25:
            r14 = r14 + 1;
            goto L6
        L26:
            this.table = r12;
            this.count = r11;
        }

        public V get(Object r5, int r10) {
            h6 r11 = getLiveEntry(r5, r10);     // Catch: Throwable -> L10
            if (r11 != null) goto L6;
            postReadCleanup();
            return null;
        L6:
            V r12 = (V) r11.getValue();
            if (r12 != null) goto L12;
            tryDrainReferenceQueues();     // Catch: Throwable -> L10
        L12:
            postReadCleanup();
            return r12;
        L10:
            th = move-exception;
            postReadCleanup();
            throw th;
        }

        public E getEntry(Object r5, int r10) {
            if (this.count == 0) goto L16;
            E r11 = (E) getFirst(r10);
        L5:
            if (r11 == null) goto L23;
            if (r11.getHash() != r10) goto L15;
            Object r12 = r11.getKey();
            if (r12 != null) goto L13;
            tryDrainReferenceQueues();
            goto L15
        L13:
            if (this.map.keyEquivalence.equivalent(r5, r12) == false) goto L15;
            return r11;
        L15:
            r11 = (E) r11.getNext();
            goto L5
        L23:
            return null;
        L16:
            return null;
        }

        public E getFirst(int r5) {
            AtomicReferenceArray<E> r10 = this.table;
            return r10.get(r5 & (r10.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object r5, int r10) {
            return (E) getEntry(r5, r10);
        }

        public V getLiveValue(E r5) {
            if (r5.getKey() != null) goto L6;
            tryDrainReferenceQueues();
            return null;
        L6:
            V r10 = (V) r5.getValue();
            if (r10 != null) goto L10;
            tryDrainReferenceQueues();
            return null;
        L10:
            return r10;
        }

        public V getLiveValueForTesting(h6 r5) {
            return getLiveValue(castForTesting(r5));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public y6 getWeakValueReferenceForTesting(h6 r5) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> r5) {
            int r10 = (r5.length() * 3) / 4;
            this.threshold = r10;
            if (r10 != this.maxSegmentSize) goto L5;
            this.threshold = r10 + 1;
        L5:
            this.table = r5;
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int r5) {
            return new AtomicReferenceArray(r5);
        }

        public E newEntryForTesting(K r5, int r10, h6 r11) {
            return (E) this.map.entryHelper.d(self(), r5, r10, castForTesting(r11));
        }

        public y6 newWeakValueReferenceForTesting(h6 r5, V r10) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
            runCleanup();
            return;
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        public V put(K r10, int r11, V r12, boolean r13) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L6
            int r5 = this.count + 1;     // Catch: Throwable -> L6
            if (r5 <= this.threshold) goto L8;
            expand();     // Catch: Throwable -> L6
            r5 = this.count + 1;     // Catch: Throwable -> L6
        L8:
            AtomicReferenceArray<E> r14 = this.table;     // Catch: Throwable -> L6
            int r15 = (r14.length() - 1) & r11;     // Catch: Throwable -> L6
            E r16 = r14.get(r15);     // Catch: Throwable -> L6
            h6 r17 = r16;
        L10:
            if (r17 == null) goto L28;
            Object r18 = r17.getKey();     // Catch: Throwable -> L6
            if (r17.getHash() != r11) goto L27;
            if (r18 == null) goto L27;
            if (this.map.keyEquivalence.equivalent(r10, r18) == false) goto L27;
            V r19 = (V) r17.getValue();
            if (r19 != null) goto L21;
            this.modCount++;     // Catch: Throwable -> L6
            setValue(r17, r12);     // Catch: Throwable -> L6
            this.count = this.count;     // Catch: Throwable -> L6
            unlock();
            return null;
        L21:
            if (r13 == false) goto L24;
            unlock();
            return r19;
        L24:
            this.modCount++;     // Catch: Throwable -> L6
            setValue(r17, r12);     // Catch: Throwable -> L6
            unlock();
            return r19;
        L27:
            r17 = r17.getNext();     // Catch: Throwable -> L6
            goto L10
        L28:
            this.modCount++;     // Catch: Throwable -> L6
            h6 r20 = this.map.entryHelper.d(self(), r10, r11, r16);     // Catch: Throwable -> L6
            setValue(r20, r12);     // Catch: Throwable -> L6
            r14.set(r15, (E) r20);     // Catch: Throwable -> L6
            this.count = r5;     // Catch: Throwable -> L6
            unlock();
            return null;
        L6:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean reclaimKey(E r5, int r10) {
            lock();
            AtomicReferenceArray<E> r11 = this.table;     // Catch: Throwable -> L9
            int r12 = r10 & (r11.length() - 1);     // Catch: Throwable -> L9
            E r13 = r11.get(r12);     // Catch: Throwable -> L9
            h6 r14 = r13;
        L4:
            if (r14 == null) goto L13;
            if (r14 == r5) goto L6;
            r14 = r14.getNext();     // Catch: Throwable -> L9
            goto L4
        L6:
            this.modCount++;     // Catch: Throwable -> L9
            h6 r15 = removeFromChain(r13, r14);     // Catch: Throwable -> L9
            int r16 = this.count - 1;     // Catch: Throwable -> L9
            r11.set(r12, (E) r15);     // Catch: Throwable -> L9
            this.count = r16;     // Catch: Throwable -> L9
            unlock();
            return true;
        L13:
            unlock();
            return false;
        L9:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean reclaimValue(K r10, int r11, y6 r12) {
            lock();
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L16
            int r13 = (r5.length() - 1) & r11;     // Catch: Throwable -> L16
            E r14 = r5.get(r13);     // Catch: Throwable -> L16
            h6 r15 = r14;
        L5:
            if (r15 == null) goto L22;
            Object r16 = r15.getKey();     // Catch: Throwable -> L16
            if (r15.getHash() != r11) goto L20;
            if (r16 == null) goto L20;
            if (this.map.keyEquivalence.equivalent(r10, r16) == false) goto L20;
            if (((x6) r15).getValueReference() != r12) goto L18;
            this.modCount++;     // Catch: Throwable -> L16
            h6 r17 = removeFromChain(r14, r15);     // Catch: Throwable -> L16
            int r18 = this.count - 1;     // Catch: Throwable -> L16
            r5.set(r13, (E) r17);     // Catch: Throwable -> L16
            this.count = r18;     // Catch: Throwable -> L16
            unlock();
            return true;
        L18:
            unlock();
            return false;
        L20:
            r15 = r15.getNext();     // Catch: Throwable -> L16
            goto L5
        L22:
            unlock();
            return false;
        L16:
            th = move-exception;
            unlock();
            throw th;
        }

        public V remove(Object r10, int r11) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L19
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L19
            int r12 = (r5.length() - 1) & r11;     // Catch: Throwable -> L19
            E r13 = r5.get(r12);     // Catch: Throwable -> L19
            h6 r14 = r13;
        L5:
            if (r14 == null) goto L25;
            Object r15 = r14.getKey();     // Catch: Throwable -> L19
            if (r14.getHash() != r11) goto L23;
            if (r15 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r15) == false) goto L23;
            V r16 = (V) r14.getValue();
            if (r16 == null) goto L15;
        L16:
            this.modCount++;     // Catch: Throwable -> L19
            h6 r17 = removeFromChain(r13, r14);     // Catch: Throwable -> L19
            int r18 = this.count - 1;     // Catch: Throwable -> L19
            r5.set(r12, (E) r17);     // Catch: Throwable -> L19
            this.count = r18;     // Catch: Throwable -> L19
            unlock();
            return r16;
        L15:
            if (isCollected(r14) == true) goto L16;
            unlock();
            return null;
        L23:
            r14 = r14.getNext();     // Catch: Throwable -> L19
            goto L5
        L25:
            unlock();
            return null;
        L19:
            th = move-exception;
            unlock();
            throw th;
        }

        public boolean removeEntryForTesting(E r10) {
            int r5 = r10.getHash();
            AtomicReferenceArray<E> r11 = this.table;
            int r12 = r5 & (r11.length() - 1);
            E r13 = r11.get(r12);
            h6 r14 = r13;
        L3:
            if (r14 == null) goto L8;
            if (r14 == r10) goto L5;
            r14 = r14.getNext();
            goto L3
        L5:
            this.modCount++;
            h6 r15 = removeFromChain(r13, r14);
            int r16 = this.count - 1;
            r11.set(r12, (E) r15);
            this.count = r16;
            return true;
        L8:
            return false;
        }

        public E removeFromChain(E r5, E r10) {
            int r11 = this.count;
            E r12 = (E) r10.getNext();
        L3:
            if (r5 == r10) goto L9;
            h6 r13 = copyEntry(r5, r12);
            if (r13 == null) goto L7;
            r12 = (E) r13;
        L8:
            r5 = (E) r5.getNext();
            goto L3
        L7:
            r11 = r11 - 1;
            goto L8
        L9:
            this.count = r11;
            return r12;
        }

        public E removeFromChainForTesting(h6 r5, h6 r10) {
            return (E) removeFromChain(castForTesting(r5), castForTesting(r10));
        }

        public boolean removeTableEntryForTesting(h6 r5) {
            return removeEntryForTesting(castForTesting(r5));
        }

        public boolean replace(K r10, int r11, V r12, V r13) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L17
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L17
            int r14 = (r5.length() - 1) & r11;     // Catch: Throwable -> L17
            E r15 = r5.get(r14);     // Catch: Throwable -> L17
            h6 r16 = r15;
        L5:
            if (r16 == null) goto L30;
            Object r17 = r16.getKey();     // Catch: Throwable -> L17
            if (r16.getHash() != r11) goto L28;
            if (r17 == null) goto L28;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L28;
            Object r18 = r16.getValue();     // Catch: Throwable -> L17
            if (r18 != null) goto L22;
            if (isCollected(r16) == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            h6 r19 = removeFromChain(r15, r16);     // Catch: Throwable -> L17
            int r110 = this.count - 1;     // Catch: Throwable -> L17
            r5.set(r14, (E) r19);     // Catch: Throwable -> L17
            this.count = r110;     // Catch: Throwable -> L17
        L19:
            unlock();
            return false;
        L22:
            if (this.map.valueEquivalence().equivalent(r12, r18) == false) goto L26;
            this.modCount++;     // Catch: Throwable -> L17
            setValue(r16, r13);     // Catch: Throwable -> L17
            unlock();
            return true;
        L26:
            unlock();
            return false;
        L28:
            r16 = r16.getNext();     // Catch: Throwable -> L17
            goto L5
        L30:
            unlock();
            return false;
        L17:
            th = move-exception;
            unlock();
            throw th;
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
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

        public abstract S self();

        public void setTableEntryForTesting(int r5, h6 r10) {
            this.table.set(r5, (E) castForTesting(r10));
        }

        public void setValue(E r5, V r10) {
            this.map.entryHelper.c(self(), r5, r10);
        }

        public void setValueForTesting(h6 r5, V r10) {
            this.map.entryHelper.c(self(), castForTesting(r5), r10);
        }

        public void setWeakValueReferenceForTesting(h6 r5, y6 r10) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
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

        public boolean remove(Object r10, int r11, Object r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L19
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L19
            int r13 = (r5.length() - 1) & r11;     // Catch: Throwable -> L19
            E r14 = r5.get(r13);     // Catch: Throwable -> L19
            h6 r15 = r14;
        L4:
            boolean r16 = false;
            if (r15 == null) goto L25;
            Object r17 = r15.getKey();     // Catch: Throwable -> L19
            if (r15.getHash() != r11) goto L23;
            if (r17 == null) goto L23;
            if (this.map.keyEquivalence.equivalent(r10, r17) == false) goto L23;
            if (this.map.valueEquivalence().equivalent(r12, r15.getValue()) == false) goto L15;
            r16 = true;
        L16:
            this.modCount++;     // Catch: Throwable -> L19
            h6 r18 = removeFromChain(r14, r15);     // Catch: Throwable -> L19
            int r19 = this.count - 1;     // Catch: Throwable -> L19
            r5.set(r13, (E) r18);     // Catch: Throwable -> L19
            this.count = r19;     // Catch: Throwable -> L19
            unlock();
            return r16;
        L15:
            if (isCollected(r15) == true) goto L16;
            unlock();
            return false;
        L23:
            r15 = r15.getNext();     // Catch: Throwable -> L19
            goto L4
        L25:
            unlock();
            return false;
        L19:
            th = move-exception;
            unlock();
            throw th;
        }

        public V replace(K r10, int r11, V r12) {
            lock();
            preWriteCleanup();     // Catch: Throwable -> L17
            AtomicReferenceArray<E> r5 = this.table;     // Catch: Throwable -> L17
            int r13 = (r5.length() - 1) & r11;     // Catch: Throwable -> L17
            E r14 = r5.get(r13);     // Catch: Throwable -> L17
            h6 r15 = r14;
        L5:
            if (r15 == null) goto L26;
            Object r16 = r15.getKey();     // Catch: Throwable -> L17
            if (r15.getHash() != r11) goto L24;
            if (r16 == null) goto L24;
            if (this.map.keyEquivalence.equivalent(r10, r16) == false) goto L24;
            V r17 = (V) r15.getValue();
            if (r17 == null) goto L14;
            this.modCount++;     // Catch: Throwable -> L17
            setValue(r15, r12);     // Catch: Throwable -> L17
            unlock();
            return r17;
        L14:
            if (isCollected(r15) == false) goto L19;
            this.modCount++;     // Catch: Throwable -> L17
            h6 r18 = removeFromChain(r14, r15);     // Catch: Throwable -> L17
            int r19 = this.count - 1;     // Catch: Throwable -> L17
            r5.set(r13, (E) r18);     // Catch: Throwable -> L17
            this.count = r19;     // Catch: Throwable -> L17
        L19:
            unlock();
            return null;
        L24:
            r15 = r15.getNext();     // Catch: Throwable -> L17
            goto L5
        L26:
            unlock();
            return null;
        L17:
            th = move-exception;
            unlock();
            throw th;
        }
    }

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength r5, Strength r10, com.google.common.base.p r11, com.google.common.base.p r12, int r13, ConcurrentMap<K, V> r14) {
            super(r5, r10, r11, r12, r13, r14);
        }

        private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
            r5.defaultReadObject();
            this.delegate = readMapMaker(r5).c();
            readEntries(r5);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream r5) throws IOException {
            r5.defaultWriteObject();
            writeMapTo(r5);
        }
    }

    public static abstract enum Strength extends Enum<Strength> {
        public static final Strength STRONG = null;
        public static final Strength WEAK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strength[] f8849a = null;

        static {
            final String r5 = "STRONG";
            final int r10 = 0;
            Strength r11 = new AnonymousClass1(r5, r10);
            STRONG = r11;
            final String r12 = "WEAK";
            final int r13 = 1;
            Strength r14 = new AnonymousClass2(r12, r13);
            WEAK = r14;
            f8849a = new Strength[]{r11, r14};
        }

        public Strength(String r5, int r10, b6 r11) {
            super(r5, r10);
        }

        public static Strength valueOf(String r5) {
            return (Strength) Enum.valueOf(Strength.class, r5);
        }

        public static Strength[] values() {
            return (Strength[]) f8849a.clone();
        }

        public abstract com.google.common.base.p defaultEquivalence();
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker$Dummy, l6, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker$Dummy, l6, StrongKeyDummyValueSegment<K>> r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l6 castForTesting(h6 r5) {
            return (l6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n6, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n6, StrongKeyStrongValueSegment<K, V>> r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n6 castForTesting(h6 r5) {
            return (n6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, p6, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, p6, StrongKeyWeakValueSegment<K, V>> r5, int r10, int r11) {
            super(r5, r10, r11);
            this.queueForValues = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$100(StrongKeyWeakValueSegment r5) {
            return r5.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public y6 getWeakValueReferenceForTesting(h6 r5) {
            return castForTesting(r5).d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public y6 newWeakValueReferenceForTesting(h6 r5, V r10) {
            return new z6(this.queueForValues, r10, castForTesting(r5));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h6 r5, y6 r10) {
            p6 r11 = castForTesting(r5);
            y6 r12 = r11.d;
            r11.d = r10;
            r12.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public p6 castForTesting(h6 r5) {
            return (p6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker$Dummy, s6, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker$Dummy, s6, WeakKeyDummyValueSegment<K>> r5, int r10, int r11) {
            super(r5, r10, r11);
            this.queueForKeys = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$200(WeakKeyDummyValueSegment r5) {
            return r5.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s6 castForTesting(h6 r5) {
            return (s6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, u6, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, u6, WeakKeyStrongValueSegment<K, V>> r5, int r10, int r11) {
            super(r5, r10, r11);
            this.queueForKeys = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$300(WeakKeyStrongValueSegment r5) {
            return r5.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u6 castForTesting(h6 r5) {
            return (u6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, w6, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, w6, WeakKeyWeakValueSegment<K, V>> r5, int r10, int r11) {
            super(r5, r10, r11);
            this.queueForKeys = new ReferenceQueue();
            this.queueForValues = new ReferenceQueue();
        }

        public static /* synthetic */ ReferenceQueue access$400(WeakKeyWeakValueSegment r5) {
            return r5.queueForKeys;
        }

        public static /* synthetic */ ReferenceQueue access$500(WeakKeyWeakValueSegment r5) {
            return r5.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ h6 castForTesting(h6 r5) {
            return castForTesting(r5);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public y6 getWeakValueReferenceForTesting(h6 r5) {
            return castForTesting(r5).f9209c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public y6 newWeakValueReferenceForTesting(h6 r5, V r10) {
            return new z6(this.queueForValues, r10, castForTesting(r5));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h6 r5, y6 r10) {
            w6 r11 = castForTesting(r5);
            y6 r12 = r11.f9209c;
            r11.f9209c = r10;
            r12.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public w6 castForTesting(h6 r5) {
            return (w6) r5;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public /* bridge */ /* synthetic */ Segment self() {
            return self();
        }
    }

    static {
        UNSET_WEAK_VALUE_REFERENCE = new b6();
    }

    public MapMakerInternalMap(a6 r10, i6 r11) {
        int r5 = r10.f8892c;
        if (r5 != (-1)) goto L5;
        r5 = 4;
    L5:
        this.concurrencyLevel = Math.min(r5, 65536);
        this.keyEquivalence = (com.google.common.base.p) com.google.common.base.b0.y(r10.f, r10.a().defaultEquivalence());
        this.entryHelper = r11;
        int r12 = r10.f8891b;
        if (r12 != (-1)) goto L8;
        r12 = 16;
    L8:
        int r13 = Math.min(r12, 1073741824);
        int r14 = 1;
        int r15 = 0;
        int r16 = 1;
        int r17 = 0;
    L10:
        if (r16 >= this.concurrencyLevel) goto L12;
        r17 = r17 + 1;
        r16 = r16 << 1;
        goto L10
    L12:
        this.segmentShift = 32 - r17;
        this.segmentMask = r16 - 1;
        this.segments = newSegmentArray(r16);
        int r18 = r13 / r16;
        if ((r16 * r18) >= r13) goto L15;
        r18 = r18 + 1;
    L15:
        if (r14 >= r18) goto L17;
        r14 = r14 << 1;
    L17:
        Segment<K, V, E, S>[] r19 = this.segments;
        if (r15 >= r19.length) goto L20;
        r19[r15] = createSegment(r14, -1);
        r15 = r15 + 1;
        goto L17
    }

    public static ArrayList access$900(Collection r5) {
        ArrayList r10 = new ArrayList(r5.size());
        p7.j(r10, r5.iterator());
        return r10;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h6, ?> create(a6 r5) {
        Strength r10 = r5.a();
        Strength r11 = Strength.STRONG;
        if (r10 != r11) goto L9;
        if (r5.b() != r11) goto L9;
        return new MapMakerInternalMap(r5, m6.f9076a);
    L9:
        if (r5.a() == r11) goto L11;
    L14:
        Strength r12 = r5.a();
        Strength r13 = Strength.WEAK;
        if (r12 != r13) goto L21;
        if (r5.b() != r11) goto L21;
        return new MapMakerInternalMap(r5, t6.f9169a);
    L21:
        if (r5.a() != r13) goto L27;
        if (r5.b() != r13) goto L27;
        return new MapMakerInternalMap(r5, v6.f9197a);
    L27:
        throw new AssertionError();
    L11:
        if (r5.b() != Strength.WEAK) goto L14;
        return new MapMakerInternalMap(r5, o6.f9105a);
    }

    public static <K> MapMakerInternalMap<K, MapMaker$Dummy, ? extends h6, ?> createWithDummyValues(a6 r5) {
        Strength r10 = r5.a();
        Strength r11 = Strength.STRONG;
        if (r10 == r11) goto L5;
    L8:
        Strength r12 = r5.a();
        Strength r13 = Strength.WEAK;
        if (r12 != r13) goto L15;
        if (r5.b() != r11) goto L15;
        return new MapMakerInternalMap(r5, r6.f9149a);
    L15:
        if (r5.b() != r13) goto L19;
        throw new IllegalArgumentException("Map cannot have both weak and dummy values");
    L19:
        throw new AssertionError();
    L5:
        if (r5.b() != r11) goto L8;
        return new MapMakerInternalMap(r5, k6.f9056a);
    }

    public static int rehash(int r5) {
        int r10 = r5 + ((r5 << 15) ^ (-12931));
        int r11 = r10 ^ (r10 >>> 10);
        int r12 = r11 + (r11 << 3);
        int r13 = r12 ^ (r12 >>> 6);
        int r14 = ((r13 << 2) + (r13 << 14)) + r13;
        return (r14 >>> 16) ^ r14;
    }

    public static <K, V, E extends h6> y6 unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Segment<K, V, E, S>[] r5 = this.segments;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].clear();
        r11 = r11 + 1;
        goto L3
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = hash(r5);
        return segmentFor(r10).containsKey(r5, r10);
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
        boolean r5 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        Segment<K, V, E, S>[] r10 = this.segments;
        long r11 = -1;
        int r12 = 0;
    L7:
        if (r12 >= 3) goto L29;
        int r13 = r10.length;
        long r14 = 0;
        ?? r15 = r5;
    L9:
        if (r15 >= r13) goto L25;
        Segment<K, V, E, S> r16 = r10[r15];
        int r18 = r16.count;
        AtomicReferenceArray<E> r19 = r16.table;
        ?? r110 = r5;
    L12:
        if (r110 >= r19.length()) goto L23;
        E r111 = r19.get(r110);
    L14:
        if (r111 == null) goto L22;
        V r112 = r16.getLiveValue(r111);
        if (r112 == null) goto L21;
        if (valueEquivalence().equivalent(r17, r112) == false) goto L21;
        return true;
    L21:
        r111 = r111.getNext();
        goto L14
    L22:
        r110 = r110 + 1;
        goto L12
    L23:
        r14 = r14 + ((long) r16.modCount);
        r5 = false;
        r15 = r15 + 1;
        goto L9
    L25:
        if (r14 == r11) goto L26;
        r12 = r12 + 1;
        r11 = r14;
        r5 = false;
        goto L7
    L26:
        return false;
    L29:
        return r5;
    }

    public E copyEntry(E r5, E r10) {
        return (E) segmentFor(r5.getHash()).copyEntry(r5, r10);
    }

    public Segment<K, V, E, S> createSegment(int r5, int r10) {
        return this.entryHelper.f(this, r5, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> r5 = this.entrySet;
        if (r5 != null) goto L7;
        f6 r10 = new f6(this, 0);
        this.entrySet = r10;
        return r10;
    L7:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = hash(r5);
        return segmentFor(r10).get(r5, r10);
    }

    public E getEntry(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = hash(r5);
        return (E) segmentFor(r10).getEntry(r5, r10);
    }

    public V getLiveValue(E r5) {
        if (r5.getKey() != null) goto L7;
        return null;
    L7:
        return (V) r5.getValue();
    }

    public int hash(Object r5) {
        return rehash(this.keyEquivalence.hash(r5));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] r10 = this.segments;
        long r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        if (r10[r11].count != 0) goto L7;
        r5 = r5 + ((long) r10[r11].modCount);
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r5 == 0) goto L22;
        int r12 = 0;
    L13:
        if (r12 >= r10.length) goto L19;
        if (r10[r12].count != 0) goto L16;
        r5 = r5 - ((long) r10[r12].modCount);
        r12 = r12 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r5 == 0) goto L21;
        return false;
    L21:
        return true;
    L22:
        return true;
    }

    public boolean isLiveForTesting(h6 r5) {
        if (segmentFor(r5.getHash()).getLiveValueForTesting(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> r5 = this.keySet;
        if (r5 != null) goto L7;
        f6 r10 = new f6(this, 1);
        this.keySet = r10;
        return r10;
    L7:
        return r5;
    }

    public Strength keyStrength() {
        return this.entryHelper.e();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int r5) {
        return new Segment[r5];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        r5.getClass();
        r10.getClass();
        int r11 = hash(r5);
        return segmentFor(r11).put(r5, r11, r10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Iterator<Map.Entry<? extends K, ? extends V>> r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r11 = r10.next();
        put(r11.getKey(), r11.getValue());
        goto L4
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r5, V r10) {
        r5.getClass();
        r10.getClass();
        int r11 = hash(r5);
        return segmentFor(r11).put(r5, r11, r10, true);
    }

    public void reclaimKey(E r5) {
        int r10 = r5.getHash();
        segmentFor(r10).reclaimKey(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(y6 r5) {
        h6 r10 = r5.a();
        int r11 = r10.getHash();
        segmentFor(r11).reclaimValue(r10.getKey(), r11, r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = hash(r5);
        return segmentFor(r10).remove(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r5, V r10) {
        r5.getClass();
        r10.getClass();
        int r11 = hash(r5);
        return segmentFor(r11).replace(r5, r11, r10);
    }

    public Segment<K, V, E, S> segmentFor(int r5) {
        Segment<K, V, E, S>[] r10 = this.segments;
        int r11 = r5 >>> this.segmentShift;
        return r10[this.segmentMask & r11];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V, E, S>[] r5 = this.segments;
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L7;
        r10 = r10 + ((long) r5[r11].count);
        r11 = r11 + 1;
        goto L4
    L7:
        return dn.a.U(r10);
    }

    public com.google.common.base.p valueEquivalence() {
        return this.entryHelper.b().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> r5 = this.values;
        if (r5 != null) goto L7;
        q6 r10 = new q6(this, 0);
        this.values = r10;
        return r10;
    L7:
        return r5;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.e(), this.entryHelper.b(), this.keyEquivalence, this.entryHelper.b().defaultEquivalence(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r5, Object r10) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L9;
        int r11 = hash(r5);
        return segmentFor(r11).remove(r5, r11, r10);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r5, V r10, V r11) {
        r5.getClass();
        r11.getClass();
        if (r10 != null) goto L6;
        return false;
    L6:
        int r12 = hash(r5);
        return segmentFor(r12).replace(r5, r12, r10, r11);
    }
}
