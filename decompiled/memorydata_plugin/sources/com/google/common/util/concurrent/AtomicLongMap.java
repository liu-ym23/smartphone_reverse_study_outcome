package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final class AtomicLongMap<K> implements Serializable {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    private AtomicLongMap(ConcurrentHashMap<K, Long> r3) {
        this.map = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r2) {
        Map<? extends K, ? extends Long> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        AtomicLongMap<K> r0 = create();
        r0.putAll(r3);
        return r0;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(this.map);
    }

    public static /* synthetic */ long lambda$UBRSyPJ3VlOcJeQkp7RT_cF4kcw(long r0, long r2) {
        return Long.sum(r0, r2);
    }

    static /* synthetic */ long lambda$accumulateAndGet$2(LongBinaryOperator r2, long r3, long r5) {
        return ((LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, LongBinaryOperator.class, "com.obric.memorydata.plugin")).applyAsLong(r5, r3);
    }

    static /* synthetic */ long lambda$getAndAccumulate$3(LongBinaryOperator r2, long r3, long r5) {
        return ((LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, LongBinaryOperator.class, "com.obric.memorydata.plugin")).applyAsLong(r5, r3);
    }

    static /* synthetic */ Long lambda$getAndUpdate$1(AtomicLong r1, LongUnaryOperator r2, Object r3, Long r4) {
        LongUnaryOperator r5 = (LongUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, LongUnaryOperator.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        long r6 = 0;
    L6:
        r1.set(r6);
        return Long.valueOf(r5.applyAsLong(r6));
    L5:
        r6 = r4.longValue();
        goto L6
    }

    static /* synthetic */ long lambda$put$4(long r0, long r2) {
        return r0;
    }

    static /* synthetic */ Long lambda$putIfAbsent$6(AtomicBoolean r4, long r5, Object r7, Long r8) {
        if (r8 != null) goto L4;
    L7:
        r4.set(true);
        return Long.valueOf(r5);
    L4:
        if (r8.longValue() == 0) goto L7;
        return r8;
    }

    static /* synthetic */ boolean lambda$removeAllZeros$5(Long r4) {
        if (r4.longValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ long lambda$uAjrY3NI4r9F1o9CaCMzj_QnUcY(Long r2) {
        return r2.longValue();
    }

    static /* synthetic */ Long lambda$updateAndGet$0(LongUnaryOperator r1, Object r2, Long r3) {
        LongUnaryOperator r4 = (LongUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r1, LongUnaryOperator.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        long r5 = 0;
    L7:
        return Long.valueOf(r4.applyAsLong(r5));
    L5:
        r5 = r3.longValue();
        goto L7
    }

    public long accumulateAndGet(K r3, final long r4, LongBinaryOperator r6) {
        final LongBinaryOperator r7 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r6, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        return updateAndGet(r3, new $$Lambda$AtomicLongMap$sfC6T1t8Vkjg7Ce_FXreqJkl0iA(r7, r4));
    }

    public long addAndGet(K r2, long r3) {
        return accumulateAndGet(r2, r3, $$Lambda$AtomicLongMap$UBRSyPJ3VlOcJeQkp7RT_cF4kcw.INSTANCE);
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r0 = this.asMap;
        if (r0 != null) goto L6;
        Map<K, Long> r1 = createAsMap();
        this.asMap = r1;
        return r1;
    L6:
        return r0;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object r1) {
        return this.map.containsKey(r1);
    }

    public long decrementAndGet(K r3) {
        return addAndGet(r3, -1);
    }

    public long get(K r3) {
        return ((Long) ZeusTransformUtils.preCheckCast(this.map.getOrDefault(r3, 0L), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    public long getAndAccumulate(K r3, final long r4, LongBinaryOperator r6) {
        final LongBinaryOperator r7 = (LongBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r6, LongBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        return getAndUpdate(r3, new $$Lambda$AtomicLongMap$SnMl4Y_nQef6wM6cDV1pASlPVSk(r7, r4));
    }

    public long getAndAdd(K r2, long r3) {
        return getAndAccumulate(r2, r3, $$Lambda$AtomicLongMap$UBRSyPJ3VlOcJeQkp7RT_cF4kcw.INSTANCE);
    }

    public long getAndDecrement(K r3) {
        return getAndAdd(r3, -1);
    }

    public long getAndIncrement(K r3) {
        return getAndAdd(r3, 1);
    }

    public long getAndUpdate(K r3, LongUnaryOperator r4) {
        final LongUnaryOperator r5 = (LongUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, LongUnaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        final AtomicLong r0 = new AtomicLong();
        this.map.compute(r3, new $$Lambda$AtomicLongMap$Uvr36h25polW_deFqqO71iZNYoA(r0, r5));
        return r0.get();
    }

    public long incrementAndGet(K r3) {
        return addAndGet(r3, 1);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(K r2, final long r3) {
        return getAndUpdate(r2, new $$Lambda$AtomicLongMap$ecPez9oktrNi4UZ7FC7yOwakeO8(r3));
    }

    public void putAll(Map<? extends K, ? extends Long> r3) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).forEach(new $$Lambda$KLHD0yp1rABaB64J30uRiMHGGI(this));
    }

    long putIfAbsent(K r3, final long r4) {
        final AtomicBoolean r0 = new AtomicBoolean(false);
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.map.compute(r3, new $$Lambda$AtomicLongMap$yUvexP3eX7vKSI9sCJoq1IC0NMk(r0, r4)), Long.class, "com.obric.memorydata.plugin");
        if (r0.get() == false) goto L6;
        return 0;
    L6:
        return r2.longValue();
    }

    public long remove(K r2) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.map.remove(r2), Long.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.longValue();
    }

    boolean remove(K r1, long r2) {
        return this.map.remove(r1, Long.valueOf(r2));
    }

    public void removeAllZeros() {
        this.map.values().removeIf($$Lambda$AtomicLongMap$EWwULNGrV5tMEv4DDsPUrjlc_ZE.INSTANCE);
    }

    public boolean removeIfZero(K r3) {
        return remove(r3, 0);
    }

    boolean replace(K r4, long r5, long r7) {
        if (r5 != 0) goto L10;
        if (putIfAbsent(r4, r7) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.map.replace(r4, Long.valueOf(r5), Long.valueOf(r7));
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        return this.map.values().stream().mapToLong($$Lambda$AtomicLongMap$uAjrY3NI4r9F1o9CaCMzj_QnUcY.INSTANCE).sum();
    }

    public String toString() {
        return this.map.toString();
    }

    public long updateAndGet(K r3, LongUnaryOperator r4) {
        final LongUnaryOperator r5 = (LongUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, LongUnaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        return ((Long) ZeusTransformUtils.preCheckCast(this.map.compute(r3, new $$Lambda$AtomicLongMap$uCVx350uucyIuk09CZ0EqHFDBM(r5)), Long.class, "com.obric.memorydata.plugin")).longValue();
    }
}
