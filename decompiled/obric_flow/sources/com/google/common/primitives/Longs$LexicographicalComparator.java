package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Longs$LexicographicalComparator extends Enum<Longs$LexicographicalComparator> implements Comparator<long[]> {
    public static final Longs$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Longs$LexicographicalComparator[] f9326a = null;

    static {
        Longs$LexicographicalComparator r5 = new Longs$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9326a = new Longs$LexicographicalComparator[]{r5};
    }

    public static Longs$LexicographicalComparator valueOf(String r5) {
        return (Longs$LexicographicalComparator) Enum.valueOf(Longs$LexicographicalComparator.class, r5);
    }

    public static Longs$LexicographicalComparator[] values() {
        return (Longs$LexicographicalComparator[]) f9326a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(long[] r5, long[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Longs.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(long[] r10, long[] r11) {
        int r12 = Math.min(r10.length, r11.length);
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L14;
        long r13 = r10[r5];
        long r14 = r11[r5];
        if (r13 >= r14) goto L7;
        int r15 = -1;
    L10:
        if (r15 != 0) goto L11;
        r5 = r5 + 1;
        goto L3
    L11:
        return r15;
    L7:
        if (r13 <= r14) goto L9;
        r15 = 1;
        goto L10
    L9:
        r15 = 0;
        goto L10
    L14:
        return r10.length - r11.length;
    }
}
