package com.google.common.collect;

import java.util.AbstractMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class e8 extends g8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f8957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractMap f8958b;

    public e8() {
        this.f8957a = new AtomicInteger(0);
        a6 r5 = new a6();
        int r10 = h8.f9015a;
        r5.d(MapMakerInternalMap.Strength.WEAK);
        this.f8958b = (AbstractMap) r5.c();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentMap] */
    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        if (r5 != r10) goto L6;
        return 0;
    L6:
        if (r5 != null) goto L9;
        return -1;
    L9:
        if (r10 != null) goto L11;
        return 1;
    L11:
        int r11 = System.identityHashCode(r5);
        int r12 = System.identityHashCode(r10);
        if (r11 == r12) goto L17;
        if (r11 >= r12) goto L16;
        return -1;
    L16:
        return 1;
    L17:
        ?? r13 = this.f8958b;
        Integer r14 = (Integer) r13.get(r5);
        AtomicInteger r15 = this.f8957a;
        if (r14 != null) goto L22;
        r14 = Integer.valueOf(r15.getAndIncrement());
        Integer r16 = (Integer) r13.putIfAbsent(r5, r14);
        if (r16 == null) goto L22;
        r14 = r16;
    L22:
        Integer r17 = (Integer) r13.get(r10);
        if (r17 != null) goto L27;
        r17 = Integer.valueOf(r15.getAndIncrement());
        Integer r18 = (Integer) r13.putIfAbsent(r10, r17);
        if (r18 == null) goto L27;
        r17 = r18;
    L27:
        int r19 = r14.compareTo(r17);
        if (r19 == 0) goto L31;
        return r19;
    L31:
        throw new AssertionError();
    }

    public final String toString() {
        return "Ordering.arbitrary()";
    }
}
