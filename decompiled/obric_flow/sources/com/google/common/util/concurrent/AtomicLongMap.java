package com.google.common.util.concurrent;

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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map f9385a;
    private final ConcurrentHashMap<K, Long> map;

    public AtomicLongMap(ConcurrentHashMap r5) {
        this.map = r5;
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public long accumulateAndGet(K r5, long r10, LongBinaryOperator r11) {
        r11.getClass();
        return updateAndGet(r5, new w(r11, r10, 0));
    }

    public long addAndGet(K r5, long r10) {
        return accumulateAndGet(r5, r10, new v());
    }

    public Map<K, Long> asMap() {
        Map<K, Long> r5 = this.f9385a;
        if (r5 != null) goto L6;
        Map<K, Long> r10 = Collections.unmodifiableMap(this.map);
        this.f9385a = r10;
        return r10;
    L6:
        return r5;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object r5) {
        return this.map.containsKey(r5);
    }

    public long decrementAndGet(K r5) {
        return addAndGet(r5, -1);
    }

    public long get(K r5) {
        return this.map.getOrDefault(r5, 0L).longValue();
    }

    public long getAndAccumulate(K r5, long r10, LongBinaryOperator r11) {
        r11.getClass();
        return getAndUpdate(r5, new w(r11, r10, 1));
    }

    public long getAndAdd(K r5, long r10) {
        return getAndAccumulate(r5, r10, new v());
    }

    public long getAndDecrement(K r5) {
        return getAndAdd(r5, -1);
    }

    public long getAndIncrement(K r5) {
        return getAndAdd(r5, 1);
    }

    public long getAndUpdate(K r5, LongUnaryOperator r10) {
        r10.getClass();
        AtomicLong r11 = new AtomicLong();
        this.map.compute(r5, new com.google.common.cache.l(2, r11, r10));
        return r11.get();
    }

    public long incrementAndGet(K r5) {
        return addAndGet(r5, 1);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(K r5, final long r10) {
        return getAndUpdate(r5, new u(r10));
    }

    public void putAll(Map<? extends K, ? extends Long> r5) {
        r5.forEach(new z(this));
    }

    public long putIfAbsent(K r5, final long r10) {
        final AtomicBoolean r11 = new AtomicBoolean(false);
        Long r12 = this.map.compute(r5, new x(r11, r10));
        if (r11.get() == false) goto L6;
        return 0;
    L6:
        return r12.longValue();
    }

    public long remove(K r5) {
        Long r10 = this.map.remove(r5);
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.longValue();
    }

    public void removeAllZeros() {
        this.map.values().removeIf(new c.o(1));
    }

    public boolean removeIfZero(K r5) {
        return remove(r5, 0);
    }

    public boolean replace(K r5, long r10, long r11) {
        if (r10 != 0) goto L10;
        if (putIfAbsent(r5, r11) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.map.replace(r5, Long.valueOf(r10), Long.valueOf(r11));
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        return this.map.values().stream().mapToLong(new y()).sum();
    }

    public String toString() {
        return this.map.toString();
    }

    public long updateAndGet(K r5, LongUnaryOperator r10) {
        r10.getClass();
        return this.map.compute(r5, new com.google.common.cache.m(r10, 1)).longValue();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> r5) {
        AtomicLongMap<K> r10 = create();
        r10.putAll(r5);
        return r10;
    }

    public boolean remove(K r5, long r10) {
        return this.map.remove(r5, Long.valueOf(r10));
    }
}
