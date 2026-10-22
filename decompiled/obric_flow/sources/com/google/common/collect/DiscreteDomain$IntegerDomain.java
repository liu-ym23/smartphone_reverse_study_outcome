package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class DiscreteDomain$IntegerDomain extends n2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiscreteDomain$IntegerDomain f8806a = null;
    private static final long serialVersionUID = 0;

    static {
        f8806a = new DiscreteDomain$IntegerDomain();
    }

    public DiscreteDomain$IntegerDomain() {
        super(true);
    }

    public static /* synthetic */ DiscreteDomain$IntegerDomain access$000() {
        return f8806a;
    }

    private Object readResolve() {
        return f8806a;
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ long distance(Comparable r5, Comparable r10) {
        return distance((Integer) r5, (Integer) r10);
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
        return next((Integer) r5);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable offset(Comparable r5, long r10) {
        return offset((Integer) r5, r10);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable previous(Comparable r5) {
        return previous((Integer) r5);
    }

    public String toString() {
        return "DiscreteDomain.integers()";
    }

    public long distance(Integer r5, Integer r10) {
        return ((long) r10.intValue()) - ((long) r5.intValue());
    }

    @Override // com.google.common.collect.n2
    public Integer maxValue() {
        return Integer.MAX_VALUE;
    }

    @Override // com.google.common.collect.n2
    public Integer minValue() {
        return Integer.MIN_VALUE;
    }

    public Integer next(Integer r5) {
        int r10 = r5.intValue();
        if (r10 != Integer.MAX_VALUE) goto L6;
        return null;
    L6:
        return Integer.valueOf(r10 + 1);
    }

    public Integer offset(Integer r5, long r10) {
        p7.r(r10);
        long r11 = r5.longValue() + r10;
        int r12 = (int) r11;
        if (r12 != r11) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.f("Out of range: %s", r11, r13);
        return Integer.valueOf(r12);
    L5:
        r13 = false;
        goto L6
    }

    public Integer previous(Integer r5) {
        int r10 = r5.intValue();
        if (r10 != Integer.MIN_VALUE) goto L6;
        return null;
    L6:
        return Integer.valueOf(r10 - 1);
    }
}
