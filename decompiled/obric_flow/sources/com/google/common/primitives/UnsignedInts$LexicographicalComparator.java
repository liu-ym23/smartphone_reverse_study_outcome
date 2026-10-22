package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum UnsignedInts$LexicographicalComparator extends Enum<UnsignedInts$LexicographicalComparator> implements Comparator<int[]> {
    public static final UnsignedInts$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnsignedInts$LexicographicalComparator[] f9331a = null;

    static {
        UnsignedInts$LexicographicalComparator r5 = new UnsignedInts$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9331a = new UnsignedInts$LexicographicalComparator[]{r5};
    }

    public static UnsignedInts$LexicographicalComparator valueOf(String r5) {
        return (UnsignedInts$LexicographicalComparator) Enum.valueOf(UnsignedInts$LexicographicalComparator.class, r5);
    }

    public static UnsignedInts$LexicographicalComparator[] values() {
        return (UnsignedInts$LexicographicalComparator[]) f9331a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(int[] r5, int[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedInts.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(int[] r5, int[] r10) {
        int r11 = Math.min(r5.length, r10.length);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        int r13 = r5[r12];
        int r14 = r10[r12];
        if (r13 != r14) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        int r15 = r13 ^ Integer.MIN_VALUE;
        int r16 = Integer.MIN_VALUE ^ r14;
        if (r15 >= r16) goto L9;
        return -1;
    L9:
        if (r15 <= r16) goto L18;
        return 1;
    L18:
        return 0;
    L14:
        return r5.length - r10.length;
    }
}
