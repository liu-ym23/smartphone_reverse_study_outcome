package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class DiscreteDomain$LongDomain extends n2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiscreteDomain$LongDomain f8807a = null;
    private static final long serialVersionUID = 0;

    static {
        f8807a = new DiscreteDomain$LongDomain();
    }

    public DiscreteDomain$LongDomain() {
        super(true);
    }

    public static /* synthetic */ DiscreteDomain$LongDomain access$200() {
        return f8807a;
    }

    private Object readResolve() {
        return f8807a;
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ long distance(Comparable r5, Comparable r10) {
        return distance((Long) r5, (Long) r10);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable maxValue() {
        return maxValue();
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable minValue() {
        return minValue();
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable next(Comparable r5) {
        return next((Long) r5);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable offset(Comparable r5, long r10) {
        return offset((Long) r5, r10);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable previous(Comparable r5) {
        return previous((Long) r5);
    }

    public String toString() {
        return "DiscreteDomain.longs()";
    }

    public long distance(Long r10, Long r11) {
        long r5 = r11.longValue() - r10.longValue();
        if (r11.longValue() <= r10.longValue()) goto L9;
        if (r5 >= 0) goto L9;
        return Long.MAX_VALUE;
    L9:
        if (r11.longValue() < r10.longValue()) goto L11;
    L14:
        return r5;
    L11:
        if (r5 <= 0) goto L14;
        return Long.MIN_VALUE;
    }

    @Override // com.google.common.collect.n2
    public Long maxValue() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.collect.n2
    public Long minValue() {
        return Long.MIN_VALUE;
    }

    public Long next(Long r5) {
        long r10 = r5.longValue();
        if (r10 != Long.MAX_VALUE) goto L6;
        return null;
    L6:
        return Long.valueOf(r10 + 1);
    }

    public Long offset(Long r5, long r10) {
        p7.r(r10);
        long r11 = r5.longValue() + r10;
        if (r11 >= 0) goto L10;
        if (r5.longValue() >= 0) goto L7;
        boolean r12 = true;
    L8:
        com.google.common.base.b0.g("overflow", r12);
        goto L10
    L7:
        r12 = false;
    L10:
        return Long.valueOf(r11);
    }

    public Long previous(Long r5) {
        long r10 = r5.longValue();
        if (r10 != Long.MIN_VALUE) goto L6;
        return null;
    L6:
        return Long.valueOf(r10 - 1);
    }
}
