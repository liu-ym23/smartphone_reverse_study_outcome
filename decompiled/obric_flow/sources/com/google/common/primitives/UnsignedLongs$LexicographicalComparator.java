package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum UnsignedLongs$LexicographicalComparator extends Enum<UnsignedLongs$LexicographicalComparator> implements Comparator<long[]> {
    public static final UnsignedLongs$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnsignedLongs$LexicographicalComparator[] f9332a = null;

    static {
        UnsignedLongs$LexicographicalComparator r5 = new UnsignedLongs$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9332a = new UnsignedLongs$LexicographicalComparator[]{r5};
    }

    public static UnsignedLongs$LexicographicalComparator valueOf(String r5) {
        return (UnsignedLongs$LexicographicalComparator) Enum.valueOf(UnsignedLongs$LexicographicalComparator.class, r5);
    }

    public static UnsignedLongs$LexicographicalComparator[] values() {
        return (UnsignedLongs$LexicographicalComparator[]) f9332a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(long[] r5, long[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedLongs.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(long[] r10, long[] r11) {
        int r12 = Math.min(r10.length, r11.length);
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L10;
        long r13 = r10[r5];
        long r14 = r11[r5];
        if (r13 != r14) goto L7;
        r5 = r5 + 1;
        goto L3
    L7:
        return f8.b.l(r13, r14);
    L10:
        return r10.length - r11.length;
    }
}
