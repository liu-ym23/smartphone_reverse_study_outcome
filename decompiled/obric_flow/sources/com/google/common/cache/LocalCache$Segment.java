package com.google.common.cache;

import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
class LocalCache$Segment<K, V> extends ReentrantLock {
    final Queue<v0> accessQueue;
    volatile int count;
    final ReferenceQueue<K> keyReferenceQueue;
    final q0 map;
    final long maxSegmentWeight;
    int modCount;
    final AtomicInteger readCount;
    final Queue<v0> recencyQueue;
    final b statsCounter;
    volatile AtomicReferenceArray<v0> table;
    int threshold;
    long totalWeight;
    final ReferenceQueue<V> valueReferenceQueue;
    final Queue<v0> writeQueue;

    public LocalCache$Segment(q0 r5, int r10, long r11, b r12) {
        this.readCount = new AtomicInteger();
        this.map = r5;
        this.maxSegmentWeight = r11;
        r12.getClass();
        this.statsCounter = r12;
        initTable(newEntryArray(r10));
        LocalCache$Strength r13 = r5.g;
        LocalCache$Strength r14 = LocalCache$Strength.STRONG;
        if (r13 == r14) goto L5;
        boolean r15 = true;
    L6:
        ReferenceQueue<V> r16 = null;
        if (r15 == false) goto L9;
        ReferenceQueue<K> r17 = new ReferenceQueue();
    L10:
        this.keyReferenceQueue = r17;
        if (r5.f8748h == r14) goto L13;
        r16 = new ReferenceQueue();
    L13:
        this.valueReferenceQueue = r16;
        if (r5.c() == false) goto L16;
    L19:
        Queue<v0> r18 = new ConcurrentLinkedQueue();
    L20:
        this.recencyQueue = r18;
        if (r5.d() == false) goto L23;
        Queue<v0> r19 = new s(1);
    L24:
        this.writeQueue = r19;
        if (r5.c() == false) goto L27;
    L30:
        Queue<v0> r20 = new s(0);
    L31:
        this.accessQueue = r20;
        return;
    L27:
        if (r5.b() == true) goto L30;
        r20 = q0.f8744x;
        goto L31
    L23:
        r19 = q0.f8744x;
        goto L24
    L16:
        if (r5.b() == true) goto L19;
        r18 = q0.f8744x;
        goto L20
    L9:
        r17 = null;
        goto L10
    L5:
        r15 = false;
        goto L6
    }

    public void cleanUp() {
        runLockedCleanup(this.map.f8755o.a());
        runUnlockedCleanup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void clear() {
        if (this.count == 0) goto L32;
        lock();
        preWriteCleanup(this.map.f8755o.a());     // Catch: Throwable -> L18
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L18
        int r10 = 0;
    L7:
        if (r10 >= r5.length()) goto L24;
        v0 r11 = r5.get(r10);     // Catch: Throwable -> L18
    L9:
        if (r11 == null) goto L23;
        if (r11.getValueReference().isActive() == false) goto L22;
        Object r12 = r11.getKey();     // Catch: Throwable -> L18
        Object r13 = r11.getValueReference().get();     // Catch: Throwable -> L18
        if (r12 == null) goto L20;
        if (r13 == null) goto L20;
        RemovalCause r14 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L18
    L21:
        enqueueNotification(r12, r11.getHash(), r13, r11.getValueReference().c(), r14);     // Catch: Throwable -> L18
    L20:
        r14 = RemovalCause.COLLECTED;     // Catch: Throwable -> L18
    L22:
        r11 = r11.getNext();     // Catch: Throwable -> L18
        goto L9
    L23:
        r10 = r10 + 1;     // Catch: Throwable -> L18
        goto L7
    L24:
        int r15 = 0;
    L26:
        if (r15 >= r5.length()) goto L28;
        r5.set(r15, null);     // Catch: Throwable -> L18
        r15 = r15 + 1;     // Catch: Throwable -> L18
        goto L26
    L28:
        clearReferenceQueues();     // Catch: Throwable -> L18
        this.writeQueue.clear();     // Catch: Throwable -> L18
        this.accessQueue.clear();     // Catch: Throwable -> L18
        this.readCount.set(0);     // Catch: Throwable -> L18
        this.modCount++;     // Catch: Throwable -> L18
        this.count = 0;     // Catch: Throwable -> L18
        unlock();
        postWriteCleanup();
        return;
    L18:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public void clearKeyReferenceQueue() {
    L3:
        if (this.keyReferenceQueue.poll() != null) goto L3;
    }

    public void clearReferenceQueues() {
        LocalCache$Strength r5 = this.map.g;
        LocalCache$Strength r10 = LocalCache$Strength.STRONG;
        if (r5 == r10) goto L6;
        clearKeyReferenceQueue();
    L6:
        if (this.map.f8748h == r10) goto L9;
        clearValueReferenceQueue();
        return;
    }

    public void clearValueReferenceQueue() {
    L3:
        if (this.valueReferenceQueue.poll() != null) goto L3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V compute(K r21, int r22, BiFunction<? super K, ? super V, ? extends V> r23) {
        lock();
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L14
        preWriteCleanup(r10);     // Catch: Throwable -> L14
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L14
        int r13 = r22 & (r11.length() - 1);     // Catch: Throwable -> L14
        v0 r14 = r11.get(r13);     // Catch: Throwable -> L14
        v0 r15 = r14;
    L4:
        int r12 = 0;
        if (r15 == null) goto L19;
        Object r5 = r15.getKey();     // Catch: Throwable -> L14
        if (r15.getHash() != r22) goto L18;
        if (r5 == null) goto L18;
        if (this.map.e.equivalent(r21, r5) == false) goto L18;
        g0 r17 = r15.getValueReference();     // Catch: Throwable -> L14
        if (this.map.f(r15, r10) == false) goto L17;
        enqueueNotification(r5, r22, r17.get(), r17.c(), RemovalCause.EXPIRED);     // Catch: Throwable -> L14
    L17:
        this.writeQueue.remove(r15);     // Catch: Throwable -> L14
        this.accessQueue.remove(r15);     // Catch: Throwable -> L14
        int r16 = r12;
        g0 r18 = r17;
    L20:
        t r19 = new t(r18);     // Catch: Throwable -> L14
        if (r15 != null) goto L23;
        r15 = newEntry(r21, r22, r14);     // Catch: Throwable -> L14
        r15.setValueReference(r19);     // Catch: Throwable -> L14
        r11.set(r13, r15);     // Catch: Throwable -> L14
        int r110 = 1;
    L24:
        r19.f8779c.a();     // Catch: Throwable -> L14
        Object r20 = r19.f8777a.f();     // Catch: Throwable -> L14 ExecutionException -> L27
    L60:
        V r24 = r23.apply(r21, r20);     // Catch: Throwable -> L50
        r19.f8778b.l(r24);     // Catch: Throwable -> L14
        if (r24 == null) goto L42;
        if (r18 != null) goto L33;
    L58:
        V r25 = (V) getAndRecordStats(r21, r22, r19, new com.google.common.util.concurrent.u0(r24));
        unlock();
        postWriteCleanup();
        return r25;
    L41:
        throw new AssertionError("impossible; Futures.immediateFuture can't throw");     // Catch: Throwable -> L14
    L33:
        if (r24 != r18.get()) goto L58;
        r19.f8778b.l(r24);     // Catch: Throwable -> L14
        r15.setValueReference(r18);     // Catch: Throwable -> L14
        recordWrite(r15, r12, r10);     // Catch: Throwable -> L14
        unlock();
        postWriteCleanup();
        return r24;
    L42:
        if (r110 == 0) goto L44;
    L49:
        removeLoadingValue(r21, r22, r19);     // Catch: Throwable -> L14
    L47:
        unlock();
        postWriteCleanup();
        return null;
    L44:
        if (r18.d() == true) goto L49;
        removeEntry(r15, r22, RemovalCause.EXPLICIT);     // Catch: Throwable -> L14
        goto L47
    L50:
        th = move-exception;
        r19.f8778b.k(th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L27:
        r20 = null;
        goto L60
    L23:
        r15.setValueReference(r19);     // Catch: Throwable -> L14
        r110 = r16;
    L18:
        r15 = r15.getNext();     // Catch: Throwable -> L14
        goto L4
    L19:
        r12 = 0;
        r18 = null;
        r16 = 1;
    L14:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public boolean containsKey(Object r5, int r10) {
        boolean r11 = false;
        if (this.count == 0) goto L15;
        v0 r12 = getLiveEntry(r5, r10, this.map.f8755o.a());     // Catch: Throwable -> L13
        if (r12 != null) goto L8;
        postReadCleanup();
        return false;
    L8:
        if (r12.getValueReference().get() == null) goto L11;
        r11 = true;
    L11:
        postReadCleanup();
        return r11;
    L15:
        postReadCleanup();
        return false;
    L13:
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
        long r5 = this.map.f8755o.a();     // Catch: Throwable -> L17
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L17
        int r12 = r11.length();     // Catch: Throwable -> L17
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L20;
        v0 r14 = r11.get(r13);     // Catch: Throwable -> L17
    L7:
        if (r14 == null) goto L19;
        V r15 = getLiveValue(r14, r5);     // Catch: Throwable -> L17
        if (r15 != null) goto L12;
    L15:
        r14 = r14.getNext();     // Catch: Throwable -> L17
        goto L7
    L12:
        if (this.map.f.equivalent(r10, r15) == false) goto L15;
        postReadCleanup();
        return true;
    L19:
        r13 = r13 + 1;
    L20:
        postReadCleanup();
        return false;
    }

    public v0 copyEntry(v0 r5, v0 r10) {
        if (r5.getKey() != null) goto L5;
        return null;
    L5:
        g0 r11 = r5.getValueReference();
        Object r12 = r11.get();
        if (r12 == null) goto L8;
    L10:
        v0 r13 = this.map.f8756p.copyEntry(this, r5, r10);
        r13.setValueReference(r11.e(this.valueReferenceQueue, r12, r13));
        return r13;
    L8:
        if (r11.isActive() == false) goto L10;
        return null;
    }

    public void drainKeyReferenceQueue() {
        int r5 = 0;
    L3:
        Reference<? extends K> r10 = this.keyReferenceQueue.poll();
        if (r10 == null) goto L7;
        v0 r11 = (v0) r10;
        q0 r12 = this.map;
        r12.getClass();
        int r13 = r11.getHash();
        r12.i(r13).reclaimKey(r11, r13);
        r5 = r5 + 1;
        if (r5 != 16) goto L3;
        return;
    }

    public void drainRecencyQueue() {
    L2:
        v0 r5 = this.recencyQueue.poll();
        if (r5 == null) goto L7;
        if (this.accessQueue.contains(r5) == false) goto L2;
        this.accessQueue.add(r5);
        goto L2
    }

    public void drainReferenceQueues() {
        LocalCache$Strength r5 = this.map.g;
        LocalCache$Strength r10 = LocalCache$Strength.STRONG;
        if (r5 == r10) goto L6;
        drainKeyReferenceQueue();
    L6:
        if (this.map.f8748h == r10) goto L9;
        drainValueReferenceQueue();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drainValueReferenceQueue() {
        int r5 = 0;
    L3:
        Reference<? extends V> r10 = this.valueReferenceQueue.poll();
        if (r10 == null) goto L7;
        g0 r11 = (g0) r10;
        q0 r12 = this.map;
        r12.getClass();
        v0 r13 = r11.a();
        int r14 = r13.getHash();
        r12.i(r14).reclaimValue(r13.getKey(), r14, r11);
        r5 = r5 + 1;
        if (r5 != 16) goto L3;
        return;
    }

    public void enqueueNotification(K r5, int r10, V r11, int r12, RemovalCause r13) {
        this.totalWeight -= (long) r12;
        if (r13.wasEvicted() == false) goto L6;
        this.statsCounter.c();
    L6:
        if (this.map.f8753m == q0.f8744x) goto L9;
        this.map.f8753m.offer(RemovalNotification.create(r5, r11, r13));
        return;
    }

    public void evictEntries(v0 r5) {
        if (this.map.b() == true) goto L5;
        return;
    L5:
        drainRecencyQueue();
        if (r5.getValueReference().c() <= this.maxSegmentWeight) goto L13;
        if (removeEntry(r5, r5.getHash(), RemovalCause.SIZE) == true) goto L13;
        throw new AssertionError();
    L13:
        if (this.totalWeight <= this.maxSegmentWeight) goto L19;
        v0 r10 = getNextEvictable();
        if (removeEntry(r10, r10.getHash(), RemovalCause.SIZE) == true) goto L13;
        throw new AssertionError();
    }

    public void expand() {
        AtomicReferenceArray<v0> r5 = this.table;
        int r10 = r5.length();
        if (r10 < 1073741824) goto L5;
        return;
    L5:
        int r11 = this.count;
        AtomicReferenceArray<v0> r12 = newEntryArray(r10 << 1);
        this.threshold = (r12.length() * 3) / 4;
        int r13 = r12.length() - 1;
        int r14 = 0;
    L6:
        if (r14 >= r10) goto L26;
        v0 r15 = r5.get(r14);
        if (r15 == null) goto L25;
        v0 r16 = r15.getNext();
        int r17 = r15.getHash() & r13;
        if (r16 != null) goto L12;
        r12.set(r17, r15);
        goto L25
    L12:
        v0 r18 = r15;
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
        v0 r21 = copyEntry(r15, r12.get(r20));
        if (r21 == null) goto L23;
        r12.set(r20, r21);
    L24:
        r15 = r15.getNext();
        goto L19
    L23:
        removeCollectedEntry(r15);
        r11 = r11 - 1;
    L25:
        r14 = r14 + 1;
        goto L6
    L26:
        this.table = r12;
        this.count = r11;
    }

    public void expireEntries(long r5) {
        drainRecencyQueue();
    L3:
        v0 r10 = this.writeQueue.peek();
        if (r10 == null) goto L12;
        if (this.map.f(r10, r5) == false) goto L12;
        if (removeEntry(r10, r10.getHash(), RemovalCause.EXPIRED) == true) goto L3;
        throw new AssertionError();
    L12:
        v0 r11 = this.accessQueue.peek();
        if (r11 == null) goto L21;
        if (this.map.f(r11, r5) == false) goto L31;
        if (removeEntry(r11, r11.getHash(), RemovalCause.EXPIRED) == true) goto L12;
        throw new AssertionError();
    L31:
        return;
    }

    public V get(K r10, int r11, h r12) throws ExecutionException {
        r10.getClass();
        r12.getClass();
    L14:
        e = move-exception;
        Throwable r13 = e.getCause();     // Catch: Throwable -> L12
        if ((r13 instanceof Error) == true) goto L32;
        if ((r13 instanceof RuntimeException) == true) goto L29;
        throw e;     // Catch: Throwable -> L12
    L29:
        throw new UncheckedExecutionException(r13);     // Catch: Throwable -> L12
    L32:
        throw new ExecutionError((Error) r13);     // Catch: Throwable -> L12
    L4:
        if (this.count == 0) goto L21;
        v0 r5 = getEntry(r10, r11);     // Catch: Throwable -> L12 ExecutionException -> L14
        if (r5 == null) goto L21;
        long r14 = this.map.f8755o.a();     // Catch: Throwable -> L12 ExecutionException -> L14
        V r15 = getLiveValue(r5, r14);     // Catch: Throwable -> L12 ExecutionException -> L14
        if (r15 == null) goto L16;
        recordRead(r5, r14);     // Catch: Throwable -> L12 ExecutionException -> L14
        this.statsCounter.a(1);     // Catch: Throwable -> L12 ExecutionException -> L14
        V r16 = scheduleRefresh(r5, r10, r11, r15, r14, r12);     // Catch: Throwable -> L12 ExecutionException -> L14
        postReadCleanup();
        return r16;
    L16:
        g0 r17 = r5.getValueReference();     // Catch: Throwable -> L12 ExecutionException -> L14
        if (r17.d() == false) goto L21;
        V r18 = waitForLoadingValue(r5, r10, r17);     // Catch: Throwable -> L12 ExecutionException -> L14
        postReadCleanup();
        return r18;
    L21:
        V r19 = lockedGetOrLoad(r10, r11, r12);     // Catch: Throwable -> L12 ExecutionException -> L14
        postReadCleanup();
        return r19;
    L12:
        th = move-exception;
        postReadCleanup();
        throw th;
    }

    public V getAndRecordStats(K r10, int r11, y r12, com.google.common.util.concurrent.w0 r13) throws ExecutionException {
        long r5 = 0;
        V r14 = (V) com.google.common.util.concurrent.p0.h(r13);
        if (r14 == null) goto L13;
        b r15 = this.statsCounter;     // Catch: Throwable -> L11
        r12.getClass();     // Catch: Throwable -> L11
        TimeUnit r16 = TimeUnit.NANOSECONDS;     // Catch: Throwable -> L11
        com.google.common.base.d0 r17 = r12.f8779c;     // Catch: Throwable -> L11
        if (r17.f8652a == false) goto L8;
        com.bytedance.sdk.xbridge.cn.auth.g r18 = com.google.common.base.y.f8677a;     // Catch: Throwable -> L11
        long r19 = (System.nanoTime() - r17.f8653b) + 0;     // Catch: Throwable -> L11
    L9:
        r15.e(r16.convert(r19, r16));     // Catch: Throwable -> L11
        storeLoadedValue(r10, r11, r12, r14);     // Catch: Throwable -> L11
        return r14;
    L8:
        r19 = 0;
        goto L9
    L13:
        String r20 = String.valueOf(r10);     // Catch: Throwable -> L11
        StringBuilder r21 = new StringBuilder(r20.length() + 35);     // Catch: Throwable -> L11
        r21.append("CacheLoader returned null for key ");     // Catch: Throwable -> L11
        r21.append(r20);     // Catch: Throwable -> L11
        r21.append(".");     // Catch: Throwable -> L11
        throw new CacheLoader$InvalidCacheLoadException(r21.toString());     // Catch: Throwable -> L11
    L11:
        th = th;
    L17:
        if (r14 != null) goto L22;
        b r110 = this.statsCounter;
        r12.getClass();
        TimeUnit r22 = TimeUnit.NANOSECONDS;
        com.google.common.base.d0 r23 = r12.f8779c;
        if (r23.f8652a == false) goto L21;
        com.bytedance.sdk.xbridge.cn.auth.g r24 = com.google.common.base.y.f8677a;
        r5 = 0 + (System.nanoTime() - r23.f8653b);
    L21:
        r110.d(r22.convert(r5, r22));
        removeLoadingValue(r10, r11, r12);
    L22:
        throw th;
    L15:
        th = th;
        r14 = null;
        goto L17
    }

    public v0 getEntry(Object r5, int r10) {
        v0 r11 = getFirst(r10);
    L3:
        if (r11 == null) goto L14;
        if (r11.getHash() != r10) goto L13;
        Object r12 = r11.getKey();
        if (r12 != null) goto L11;
        tryDrainReferenceQueues();
        goto L13
    L11:
        if (this.map.e.equivalent(r5, r12) == false) goto L13;
        return r11;
    L13:
        r11 = r11.getNext();
        goto L3
    L14:
        return null;
    }

    public v0 getFirst(int r5) {
        AtomicReferenceArray<v0> r10 = this.table;
        return r10.get(r5 & (r10.length() - 1));
    }

    public v0 getLiveEntry(Object r5, int r10, long r11) {
        v0 r12 = getEntry(r5, r10);
        if (r12 != null) goto L6;
        return null;
    L6:
        if (this.map.f(r12, r11) == false) goto L9;
        tryExpireEntries(r11);
        return null;
    L9:
        return r12;
    }

    public V getLiveValue(v0 r5, long r10) {
        if (r5.getKey() != null) goto L6;
        tryDrainReferenceQueues();
        return null;
    L6:
        V r11 = (V) r5.getValueReference().get();
        if (r11 != null) goto L11;
        tryDrainReferenceQueues();
        return null;
    L11:
        if (this.map.f(r5, r10) == false) goto L14;
        tryExpireEntries(r10);
        return null;
    L14:
        return r11;
    }

    public v0 getNextEvictable() {
        Iterator<v0> r5 = this.accessQueue.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        v0 r10 = r5.next();
        if (r10.getValueReference().c() <= 0) goto L4;
        return r10;
    L9:
        throw new AssertionError();
    }

    public void initTable(AtomicReferenceArray<v0> r10) {
        int r5 = (r10.length() * 3) / 4;
        this.threshold = r5;
        if (this.map.f8750j == CacheBuilder$OneWeigher.INSTANCE) goto L6;
    L8:
        this.table = r10;
        return;
    L6:
        if (r5 != this.maxSegmentWeight) goto L8;
        this.threshold = r5 + 1;
        goto L8
    }

    public y insertLoadingValueReference(K r10, int r11, boolean r12) {
        lock();
        long r5 = this.map.f8755o.a();     // Catch: Throwable -> L17
        preWriteCleanup(r5);     // Catch: Throwable -> L17
        AtomicReferenceArray<v0> r13 = this.table;     // Catch: Throwable -> L17
        int r14 = (r13.length() - 1) & r11;     // Catch: Throwable -> L17
        v0 r15 = r13.get(r14);     // Catch: Throwable -> L17
        v0 r16 = r15;
    L5:
        if (r16 == null) goto L25;
        Object r17 = r16.getKey();     // Catch: Throwable -> L17
        if (r16.getHash() != r11) goto L24;
        if (r17 == null) goto L24;
        if (this.map.e.equivalent(r10, r17) == false) goto L24;
        g0 r18 = r16.getValueReference();     // Catch: Throwable -> L17
        if (r18.d() == true) goto L22;
        if (r12 == false) goto L19;
        long r19 = r5 - r16.getWriteTime();     // Catch: Throwable -> L17
        this.map.getClass();     // Catch: Throwable -> L17
        if (r19 < 0) goto L22;
    L19:
        this.modCount++;     // Catch: Throwable -> L17
        y r110 = new y(r18);     // Catch: Throwable -> L17
        r16.setValueReference(r110);     // Catch: Throwable -> L17
        unlock();
        postWriteCleanup();
        return r110;
    L22:
        unlock();
        postWriteCleanup();
        return null;
    L24:
        r16 = r16.getNext();     // Catch: Throwable -> L17
        goto L5
    L25:
        this.modCount++;     // Catch: Throwable -> L17
        y r111 = new y(null);     // Catch: Throwable -> L17
        v0 r112 = newEntry(r10, r11, r15);     // Catch: Throwable -> L17
        r112.setValueReference(r111);     // Catch: Throwable -> L17
        r13.set(r14, r112);     // Catch: Throwable -> L17
        unlock();
        postWriteCleanup();
        return r111;
    L17:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public com.google.common.util.concurrent.w0 loadAsync(K r10, int r11, y r12, h r13) {
        com.google.common.util.concurrent.w0 r14 = r12.g(r10, r13);
        r14.addListener(new a0(this, r10, r11, r12, r14), com.google.common.util.concurrent.p0.d());
        return r14;
    }

    public V loadSync(K r5, int r10, y r11, h r12) throws ExecutionException {
        return getAndRecordStats(r5, r10, r11, r11.g(r5, r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V lockedGetOrLoad(K r18, int r19, h r20) throws ExecutionException {
        lock();
        long r5 = this.map.f8755o.a();     // Catch: Throwable -> L18
        preWriteCleanup(r5);     // Catch: Throwable -> L18
        int r10 = this.count - 1;     // Catch: Throwable -> L18
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L18
        int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L18
        v0 r13 = r11.get(r12);     // Catch: Throwable -> L18
        v0 r14 = r13;
    L4:
        y r15 = null;
        if (r14 == null) goto L28;
        Object r16 = r14.getKey();     // Catch: Throwable -> L18
        if (r14.getHash() != r19) goto L27;
        if (r16 == null) goto L27;
        if (this.map.e.equivalent(r18, r16) == false) goto L27;
        g0 r17 = r14.getValueReference();     // Catch: Throwable -> L18
        if (r17.d() == false) goto L15;
        boolean r21 = false;
    L14:
        g0 r22 = r17;
    L29:
        if (r21 == false) goto L36;
        y r23 = new y(null);     // Catch: Throwable -> L18
        if (r14 != null) goto L34;
        r14 = newEntry(r18, r19, r13);     // Catch: Throwable -> L18
        r14.setValueReference(r23);     // Catch: Throwable -> L18
        r11.set(r12, r14);     // Catch: Throwable -> L18
    L33:
        r15 = r23;
        goto L36
    L34:
        r14.setValueReference(r23);     // Catch: Throwable -> L18
    L36:
        unlock();
        postWriteCleanup();
        if (r21 == false) goto L51;
        monitor-enter(r14);     // Catch: Throwable -> L47
        V r24 = (V) loadSync(r18, r19, r15, r20);
        monitor-exit(r14);     // Catch: Throwable -> L44
        this.statsCounter.b(1);
        return r24;
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        this.statsCounter.b(1);
        throw th;
    L51:
        return (V) waitForLoadingValue(r14, r18, r22);
    L15:
        V r25 = (V) r17.get();
        if (r25 != null) goto L21;
        enqueueNotification(r16, r19, r25, r17.c(), RemovalCause.COLLECTED);     // Catch: Throwable -> L18
    L23:
        this.writeQueue.remove(r14);     // Catch: Throwable -> L18
        this.accessQueue.remove(r14);     // Catch: Throwable -> L18
        this.count = r10;     // Catch: Throwable -> L18
        r21 = true;
        goto L14
    L21:
        if (this.map.f(r14, r5) == false) goto L24;
        enqueueNotification(r16, r19, r25, r17.c(), RemovalCause.EXPIRED);     // Catch: Throwable -> L18
        goto L23
    L24:
        recordLockedRead(r14, r5);     // Catch: Throwable -> L18
        this.statsCounter.a(1);     // Catch: Throwable -> L18
        unlock();
        postWriteCleanup();
        return r25;
    L27:
        r14 = r14.getNext();     // Catch: Throwable -> L18
        goto L4
    L28:
        r21 = true;
        r22 = null;
    L18:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public v0 newEntry(K r5, int r10, v0 r11) {
        LocalCache$EntryFactory r12 = this.map.f8756p;
        r5.getClass();
        return r12.newEntry(this, r5, r10, r11);
    }

    public AtomicReferenceArray<v0> newEntryArray(int r5) {
        return new AtomicReferenceArray(r5);
    }

    public void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 63) != 0) goto L6;
        cleanUp();
        return;
    }

    public void postWriteCleanup() {
        runUnlockedCleanup();
    }

    public void preWriteCleanup(long r5) {
        runLockedCleanup(r5);
    }

    public V put(K r15, int r16, V r17, boolean r18) {
        lock();
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L6
        preWriteCleanup(r10);     // Catch: Throwable -> L6
        if ((this.count + 1) <= this.threshold) goto L8;
        expand();     // Catch: Throwable -> L6
    L8:
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L6
        int r12 = r16 & (r11.length() - 1);     // Catch: Throwable -> L6
        v0 r5 = r11.get(r12);     // Catch: Throwable -> L6
        v0 r13 = r5;
    L10:
        if (r13 == null) goto L31;
        Object r14 = r13.getKey();     // Catch: Throwable -> L6
        if (r13.getHash() != r16) goto L30;
        if (r14 == null) goto L30;
        if (this.map.e.equivalent(r15, r14) == false) goto L30;
        g0 r19 = r13.getValueReference();     // Catch: Throwable -> L6
        V r110 = (V) r19.get();
        if (r110 != null) goto L25;
        this.modCount++;     // Catch: Throwable -> L6
        if (r19.isActive() == false) goto L21;
        enqueueNotification(r15, r16, r110, r19.c(), RemovalCause.COLLECTED);     // Catch: Throwable -> L6
        setValue(r13, r15, r17, r10);     // Catch: Throwable -> L6
        int r20 = this.count;     // Catch: Throwable -> L6
    L22:
        this.count = r20;     // Catch: Throwable -> L6
        evictEntries(r13);     // Catch: Throwable -> L6
    L23:
        unlock();
        postWriteCleanup();
        return null;
    L21:
        setValue(r13, r15, r17, r10);     // Catch: Throwable -> L6
        r20 = this.count + 1;     // Catch: Throwable -> L6
        goto L22
    L25:
        if (r18 == false) goto L29;
        recordLockedRead(r13, r10);     // Catch: Throwable -> L6
    L27:
        unlock();
        postWriteCleanup();
        return r110;
    L29:
        this.modCount++;     // Catch: Throwable -> L6
        enqueueNotification(r15, r16, r110, r19.c(), RemovalCause.REPLACED);     // Catch: Throwable -> L6
        setValue(r13, r15, r17, r10);     // Catch: Throwable -> L6
        evictEntries(r13);     // Catch: Throwable -> L6
    L30:
        r13 = r13.getNext();     // Catch: Throwable -> L6
        goto L10
    L31:
        this.modCount++;     // Catch: Throwable -> L6
        v0 r111 = newEntry(r15, r16, r5);     // Catch: Throwable -> L6
        setValue(r111, r15, r17, r10);     // Catch: Throwable -> L6
        r11.set(r12, r111);     // Catch: Throwable -> L6
        this.count++;     // Catch: Throwable -> L6
        evictEntries(r111);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean reclaimKey(v0 r13, int r14) {
        lock();
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L9
        int r10 = (r5.length() - 1) & r14;     // Catch: Throwable -> L9
        v0 r11 = r5.get(r10);     // Catch: Throwable -> L9
        v0 r12 = r11;
    L4:
        if (r12 == null) goto L13;
        if (r12 == r13) goto L6;
        r12 = r12.getNext();     // Catch: Throwable -> L9
        goto L4
    L6:
        this.modCount++;     // Catch: Throwable -> L9
        v0 r15 = removeValueFromChain(r11, r12, r12.getKey(), r14, r12.getValueReference().get(), r12.getValueReference(), RemovalCause.COLLECTED);     // Catch: Throwable -> L9
        int r16 = this.count - 1;     // Catch: Throwable -> L9
        r5.set(r10, r15);     // Catch: Throwable -> L9
        this.count = r16;     // Catch: Throwable -> L9
        unlock();
        postWriteCleanup();
        return true;
    L13:
        unlock();
        postWriteCleanup();
        return false;
    L9:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean reclaimValue(K r13, int r14, g0 r15) {
        lock();
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L18
        int r10 = (r5.length() - 1) & r14;     // Catch: Throwable -> L18
        v0 r11 = r5.get(r10);     // Catch: Throwable -> L18
        v0 r12 = r11;
    L5:
        if (r12 == null) goto L26;
        Object r16 = r12.getKey();     // Catch: Throwable -> L18
        if (r12.getHash() != r14) goto L24;
        if (r16 == null) goto L24;
        if (this.map.e.equivalent(r13, r16) == false) goto L24;
        if (r12.getValueReference() != r15) goto L20;
        this.modCount++;     // Catch: Throwable -> L18
        v0 r17 = removeValueFromChain(r11, r12, r16, r14, r15.get(), r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L18
        int r18 = this.count - 1;     // Catch: Throwable -> L18
        r5.set(r10, r17);     // Catch: Throwable -> L18
        this.count = r18;     // Catch: Throwable -> L18
        unlock();
        if (isHeldByCurrentThread() == true) goto L17;
        postWriteCleanup();
    L17:
        return true;
    L20:
        unlock();
        if (isHeldByCurrentThread() == true) goto L23;
        postWriteCleanup();
    L23:
        return false;
    L24:
        r12 = r12.getNext();     // Catch: Throwable -> L18
        goto L5
    L26:
        unlock();
        if (isHeldByCurrentThread() == true) goto L29;
        postWriteCleanup();
    L29:
        return false;
    L18:
        th = move-exception;
        unlock();
        if (isHeldByCurrentThread() == true) goto L33;
        postWriteCleanup();
    L33:
        throw th;
    }

    public void recordLockedRead(v0 r5, long r10) {
        if (this.map.c() == false) goto L5;
        r5.setAccessTime(r10);
    L5:
        this.accessQueue.add(r5);
    }

    public void recordRead(v0 r5, long r10) {
        if (this.map.c() == false) goto L5;
        r5.setAccessTime(r10);
    L5:
        this.recencyQueue.add(r5);
    }

    public void recordWrite(v0 r5, int r10, long r11) {
        drainRecencyQueue();
        this.totalWeight += (long) r10;
        if (this.map.c() == false) goto L6;
        r5.setAccessTime(r11);
    L6:
        if (this.map.d() == false) goto L8;
        r5.setWriteTime(r11);
    L8:
        this.accessQueue.add(r5);
        this.writeQueue.add(r5);
    }

    public V refresh(K r5, int r10, h r11, boolean r12) {
        y r13 = insertLoadingValueReference(r5, r10, r12);
        if (r13 != null) goto L5;
        return null;
    L5:
        com.google.common.util.concurrent.w0 r14 = loadAsync(r5, r10, r13, r11);
        if (r14.isDone() == true) goto L11;
    L9:
        return null;
    L11:
        return (V) com.google.common.util.concurrent.p0.h(r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V remove(Object r12, int r13) {
        lock();
        preWriteCleanup(this.map.f8755o.a());     // Catch: Throwable -> L15
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L15
        int r10 = (r5.length() - 1) & r13;     // Catch: Throwable -> L15
        v0 r11 = r5.get(r10);     // Catch: Throwable -> L15
        v0 r14 = r11;
    L5:
        if (r14 == null) goto L23;
        Object r15 = r14.getKey();     // Catch: Throwable -> L15
        if (r14.getHash() != r13) goto L25;
        if (r15 == null) goto L25;
        if (this.map.e.equivalent(r12, r15) == false) goto L25;
        g0 r16 = r14.getValueReference();     // Catch: Throwable -> L15
        V r17 = (V) r16.get();
        if (r17 == null) goto L18;
        RemovalCause r18 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L15
    L14:
        RemovalCause r19 = r18;
        this.modCount++;     // Catch: Throwable -> L15
        v0 r110 = removeValueFromChain(r11, r14, r15, r13, r17, r16, r19);     // Catch: Throwable -> L15
        int r20 = this.count - 1;     // Catch: Throwable -> L15
        r5.set(r10, r110);     // Catch: Throwable -> L15
        this.count = r20;     // Catch: Throwable -> L15
        unlock();
        postWriteCleanup();
        return r17;
    L18:
        if (r16.isActive() == false) goto L23;
        r18 = RemovalCause.COLLECTED;     // Catch: Throwable -> L15
    L25:
        r14 = r14.getNext();     // Catch: Throwable -> L15
    L23:
        unlock();
        postWriteCleanup();
        return null;
    L15:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeCollectedEntry(v0 r10) {
        enqueueNotification(r10.getKey(), r10.getHash(), r10.getValueReference().get(), r10.getValueReference().c(), RemovalCause.COLLECTED);
        this.writeQueue.remove(r10);
        this.accessQueue.remove(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean removeEntry(v0 r13, int r14, RemovalCause r15) {
        AtomicReferenceArray<v0> r5 = this.table;
        int r10 = (r5.length() - 1) & r14;
        v0 r11 = r5.get(r10);
        v0 r12 = r11;
    L3:
        if (r12 == null) goto L8;
        if (r12 == r13) goto L5;
        r12 = r12.getNext();
        goto L3
    L5:
        this.modCount++;
        v0 r16 = removeValueFromChain(r11, r12, r12.getKey(), r14, r12.getValueReference().get(), r12.getValueReference(), r15);
        int r17 = this.count - 1;
        r5.set(r10, r16);
        this.count = r17;
        return true;
    L8:
        return false;
    }

    public v0 removeEntryFromChain(v0 r5, v0 r10) {
        int r11 = this.count;
        v0 r12 = r10.getNext();
    L3:
        if (r5 == r10) goto L9;
        v0 r13 = copyEntry(r5, r12);
        if (r13 == null) goto L7;
        r12 = r13;
    L8:
        r5 = r5.getNext();
        goto L3
    L7:
        removeCollectedEntry(r5);
        r11 = r11 - 1;
        goto L8
    L9:
        this.count = r11;
        return r12;
    }

    public boolean removeLoadingValue(K r10, int r11, y r12) {
        lock();
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L16
        int r13 = (r5.length() - 1) & r11;     // Catch: Throwable -> L16
        v0 r14 = r5.get(r13);     // Catch: Throwable -> L16
        v0 r15 = r14;
    L5:
        if (r15 == null) goto L21;
        Object r16 = r15.getKey();     // Catch: Throwable -> L16
        if (r15.getHash() != r11) goto L23;
        if (r16 == null) goto L23;
        if (this.map.e.equivalent(r10, r16) == false) goto L23;
        if (r15.getValueReference() != r12) goto L21;
        if (r12.f8777a.isActive() == false) goto L18;
        r15.setValueReference(r12.f8777a);     // Catch: Throwable -> L16
    L19:
        unlock();
        postWriteCleanup();
        return true;
    L18:
        r5.set(r13, removeEntryFromChain(r14, r15));     // Catch: Throwable -> L16
    L23:
        r15 = r15.getNext();     // Catch: Throwable -> L16
    L21:
        unlock();
        postWriteCleanup();
        return false;
    L16:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public v0 removeValueFromChain(v0 r10, v0 r11, K r12, int r13, V r14, g0 r15, RemovalCause r16) {
        enqueueNotification(r12, r13, r14, r15.c(), r16);
        this.writeQueue.remove(r11);
        this.accessQueue.remove(r11);
        if (r15.d() == false) goto L7;
        r15.b(null);
        return r10;
    L7:
        return removeEntryFromChain(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean replace(K r18, int r19, V r20, V r21) {
        lock();
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L17
        preWriteCleanup(r10);     // Catch: Throwable -> L17
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L17
        int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L17
        v0 r5 = r11.get(r12);     // Catch: Throwable -> L17
        v0 r13 = r5;
    L5:
        if (r13 == null) goto L19;
        Object r14 = r13.getKey();     // Catch: Throwable -> L17
        if (r13.getHash() != r19) goto L29;
        if (r14 == null) goto L29;
        if (this.map.e.equivalent(r18, r14) == false) goto L29;
        g0 r16 = r13.getValueReference();     // Catch: Throwable -> L17
        Object r15 = r16.get();     // Catch: Throwable -> L17
        if (r15 != null) goto L22;
        if (r16.isActive() == false) goto L19;
        this.modCount++;     // Catch: Throwable -> L17
        v0 r17 = removeValueFromChain(r5, r13, r14, r19, r15, r16, RemovalCause.COLLECTED);     // Catch: Throwable -> L17
        int r22 = this.count - 1;     // Catch: Throwable -> L17
        r11.set(r12, r17);     // Catch: Throwable -> L17
        this.count = r22;     // Catch: Throwable -> L17
        goto L19
    L22:
        if (this.map.f.equivalent(r20, r15) == false) goto L26;
        this.modCount++;     // Catch: Throwable -> L17
        enqueueNotification(r18, r19, r15, r16.c(), RemovalCause.REPLACED);     // Catch: Throwable -> L17
        setValue(r13, r18, r21, r10);     // Catch: Throwable -> L17
        evictEntries(r13);     // Catch: Throwable -> L17
        unlock();
        postWriteCleanup();
        return true;
    L26:
        recordLockedRead(r13, r10);     // Catch: Throwable -> L17
    L29:
        r13 = r13.getNext();     // Catch: Throwable -> L17
    L19:
        unlock();
        postWriteCleanup();
        return false;
    L17:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public void runLockedCleanup(long r5) {
        if (tryLock() == true) goto L10;
        return;
    L10:
        drainReferenceQueues();     // Catch: Throwable -> L6
        expireEntries(r5);     // Catch: Throwable -> L6
        this.readCount.set(0);     // Catch: Throwable -> L6
        unlock();
        return;
    L6:
        th = move-exception;
        unlock();
        throw th;
    }

    public void runUnlockedCleanup() {
        if (isHeldByCurrentThread() == true) goto L11;
        q0 r5 = this.map;
    L5:
        RemovalNotification r10 = (RemovalNotification) r5.f8753m.poll();
        if (r10 == null) goto L18;
        r5.f8754n.onRemoval(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Level r11 = Level.WARNING;
        q0.f8742v.log(r11, "Exception thrown by removal listener", th);
        goto L5
    L18:
        return;
    }

    public V scheduleRefresh(v0 r5, K r10, int r11, V r12, long r13, h r14) {
        this.map.getClass();
        return r12;
    }

    public void setValue(v0 r5, K r10, V r11, long r12) {
        g0 r13 = r5.getValueReference();
        int r14 = this.map.f8750j.weigh(r10, r11);
        if (r14 < 0) goto L5;
        boolean r15 = true;
    L6:
        com.google.common.base.b0.u(r15, "Weights must be non-negative");
        r5.setValueReference(this.map.f8748h.referenceValue(this, r5, r11, r14));
        recordWrite(r5, r14, r12);
        r13.b(r11);
        return;
    L5:
        r15 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean storeLoadedValue(K r16, int r17, y r18, V r19) {
        lock();
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L7
        preWriteCleanup(r10);     // Catch: Throwable -> L7
        int r5 = this.count + 1;     // Catch: Throwable -> L7
        if (r5 <= this.threshold) goto L6;
        expand();     // Catch: Throwable -> L7
        r5 = this.count + 1;     // Catch: Throwable -> L7
    L6:
        int r11 = r5;
        AtomicReferenceArray<v0> r12 = this.table;     // Catch: Throwable -> L7
        int r13 = r17 & (r12.length() - 1);     // Catch: Throwable -> L7
        v0 r14 = r12.get(r13);     // Catch: Throwable -> L7
        v0 r15 = r14;
    L10:
        if (r15 == null) goto L36;
        Object r20 = r15.getKey();     // Catch: Throwable -> L7
        if (r15.getHash() != r17) goto L35;
        if (r20 == null) goto L35;
        if (this.map.e.equivalent(r16, r20) == false) goto L35;
        g0 r21 = r15.getValueReference();     // Catch: Throwable -> L7
        Object r22 = r21.get();     // Catch: Throwable -> L7
        if (r18 == r21) goto L25;
        if (r22 == null) goto L20;
    L22:
        enqueueNotification(r16, r17, r19, 0, RemovalCause.REPLACED);     // Catch: Throwable -> L7
        unlock();
        postWriteCleanup();
        return false;
    L20:
        if (r21 == q0.f8743w) goto L22;
    L25:
        this.modCount++;     // Catch: Throwable -> L7
        if (r18.f8777a.isActive() == false) goto L32;
        if (r22 != null) goto L30;
        RemovalCause r23 = RemovalCause.COLLECTED;     // Catch: Throwable -> L7
    L31:
        enqueueNotification(r16, r17, r22, r18.f8777a.c(), r23);     // Catch: Throwable -> L7
        r11 = r11 - 1;     // Catch: Throwable -> L7
        goto L32
    L30:
        r23 = RemovalCause.REPLACED;     // Catch: Throwable -> L7
    L32:
        setValue(r15, r16, r19, r10);     // Catch: Throwable -> L7
        this.count = r11;     // Catch: Throwable -> L7
        evictEntries(r15);     // Catch: Throwable -> L7
    L33:
        unlock();
        postWriteCleanup();
        return true;
    L35:
        r15 = r15.getNext();     // Catch: Throwable -> L7
        goto L10
    L36:
        this.modCount++;     // Catch: Throwable -> L7
        v0 r110 = newEntry(r16, r17, r14);     // Catch: Throwable -> L7
        setValue(r110, r16, r19, r10);     // Catch: Throwable -> L7
        r12.set(r13, r110);     // Catch: Throwable -> L7
        this.count = r11;     // Catch: Throwable -> L7
        evictEntries(r110);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    public void tryDrainReferenceQueues() {
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

    public void tryExpireEntries(long r5) {
        if (tryLock() == true) goto L10;
        return;
    L10:
        expireEntries(r5);     // Catch: Throwable -> L6
        unlock();
        return;
    L6:
        th = move-exception;
        unlock();
        throw th;
    }

    public V waitForLoadingValue(v0 r5, K r10, g0 r11) throws ExecutionException {
        if (r11.d() == false) goto L17;
        com.google.common.base.b0.s("Recursive load of: %s", !Thread.holdsLock(r5), r10);
        V r12 = (V) r11.f();
        if (r12 == null) goto L12;
        recordRead(r5, this.map.f8755o.a());     // Catch: Throwable -> L10
        this.statsCounter.b(1);
        return r12;
    L12:
        String r13 = String.valueOf(r10);     // Catch: Throwable -> L10
        StringBuilder r14 = new StringBuilder(r13.length() + 35);     // Catch: Throwable -> L10
        r14.append("CacheLoader returned null for key ");     // Catch: Throwable -> L10
        r14.append(r13);     // Catch: Throwable -> L10
        r14.append(".");     // Catch: Throwable -> L10
        throw new CacheLoader$InvalidCacheLoadException(r14.toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.statsCounter.b(1);
        throw th;
    L17:
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object r11, int r12) {
    L13:
        th = move-exception;
        postReadCleanup();
        throw th;
    L3:
        if (this.count == 0) goto L16;
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L13
        v0 r5 = getLiveEntry(r11, r12, r10);     // Catch: Throwable -> L13
        if (r5 != null) goto L8;
        postReadCleanup();
        return null;
    L8:
        Object r13 = r5.getValueReference().get();     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        recordRead(r5, r10);     // Catch: Throwable -> L13
        V r14 = (V) scheduleRefresh(r5, r5.getKey(), r12, r13, r10, this.map.f8758r);
        postReadCleanup();
        return r14;
    L15:
        tryDrainReferenceQueues();     // Catch: Throwable -> L13
    L16:
        postReadCleanup();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean remove(Object r13, int r14, Object r15) {
        lock();
        preWriteCleanup(this.map.f8755o.a());     // Catch: Throwable -> L14
        AtomicReferenceArray<v0> r5 = this.table;     // Catch: Throwable -> L14
        boolean r10 = true;
        int r11 = (r5.length() - 1) & r14;     // Catch: Throwable -> L14
        v0 r12 = r5.get(r11);     // Catch: Throwable -> L14
        v0 r16 = r12;
    L5:
        if (r16 == null) goto L26;
        Object r17 = r16.getKey();     // Catch: Throwable -> L14
        if (r16.getHash() != r14) goto L28;
        if (r17 == null) goto L28;
        if (this.map.e.equivalent(r13, r17) == false) goto L28;
        g0 r18 = r16.getValueReference();     // Catch: Throwable -> L14
        Object r19 = r18.get();     // Catch: Throwable -> L14
        if (this.map.f.equivalent(r15, r19) == false) goto L16;
        RemovalCause r110 = RemovalCause.EXPLICIT;     // Catch: Throwable -> L14
    L20:
        this.modCount++;     // Catch: Throwable -> L14
        v0 r111 = removeValueFromChain(r12, r16, r17, r14, r19, r18, r110);     // Catch: Throwable -> L14
        int r112 = this.count - 1;     // Catch: Throwable -> L14
        r5.set(r11, r111);     // Catch: Throwable -> L14
        this.count = r112;     // Catch: Throwable -> L14
        if (r110 == RemovalCause.EXPLICIT) goto L24;
        r10 = false;
    L24:
        unlock();
        postWriteCleanup();
        return r10;
    L16:
        if (r19 != null) goto L26;
        if (r18.isActive() == false) goto L26;
        r110 = RemovalCause.COLLECTED;     // Catch: Throwable -> L14
    L28:
        r16 = r16.getNext();     // Catch: Throwable -> L14
    L26:
        unlock();
        postWriteCleanup();
        return false;
    L14:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V replace(K r18, int r19, V r20) {
        lock();
        long r10 = this.map.f8755o.a();     // Catch: Throwable -> L17
        preWriteCleanup(r10);     // Catch: Throwable -> L17
        AtomicReferenceArray<v0> r11 = this.table;     // Catch: Throwable -> L17
        int r12 = r19 & (r11.length() - 1);     // Catch: Throwable -> L17
        v0 r5 = r11.get(r12);     // Catch: Throwable -> L17
        v0 r13 = r5;
    L5:
        if (r13 == null) goto L19;
        Object r14 = r13.getKey();     // Catch: Throwable -> L17
        if (r13.getHash() != r19) goto L25;
        if (r14 == null) goto L25;
        if (this.map.e.equivalent(r18, r14) == false) goto L25;
        g0 r15 = r13.getValueReference();     // Catch: Throwable -> L17
        V r16 = (V) r15.get();
        if (r16 == null) goto L14;
        this.modCount++;     // Catch: Throwable -> L17
        enqueueNotification(r18, r19, r16, r15.c(), RemovalCause.REPLACED);     // Catch: Throwable -> L17
        setValue(r13, r18, r20, r10);     // Catch: Throwable -> L17
        evictEntries(r13);     // Catch: Throwable -> L17
        unlock();
        postWriteCleanup();
        return r16;
    L14:
        if (r15.isActive() == false) goto L19;
        this.modCount++;     // Catch: Throwable -> L17
        v0 r17 = removeValueFromChain(r5, r13, r14, r19, r16, r15, RemovalCause.COLLECTED);     // Catch: Throwable -> L17
        int r21 = this.count - 1;     // Catch: Throwable -> L17
        r11.set(r12, r17);     // Catch: Throwable -> L17
        this.count = r21;     // Catch: Throwable -> L17
    L25:
        r13 = r13.getNext();     // Catch: Throwable -> L17
    L19:
        unlock();
        postWriteCleanup();
        return null;
    L17:
        th = move-exception;
        unlock();
        postWriteCleanup();
        throw th;
    }
}
