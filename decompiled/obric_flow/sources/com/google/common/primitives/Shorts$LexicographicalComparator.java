package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Shorts$LexicographicalComparator extends Enum<Shorts$LexicographicalComparator> implements Comparator<short[]> {
    public static final Shorts$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Shorts$LexicographicalComparator[] f9327a = null;

    static {
        Shorts$LexicographicalComparator r5 = new Shorts$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9327a = new Shorts$LexicographicalComparator[]{r5};
    }

    public static Shorts$LexicographicalComparator valueOf(String r5) {
        return (Shorts$LexicographicalComparator) Enum.valueOf(Shorts$LexicographicalComparator.class, r5);
    }

    public static Shorts$LexicographicalComparator[] values() {
        return (Shorts$LexicographicalComparator[]) f9327a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(short[] r5, short[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Shorts.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(short[] r5, short[] r10) {
        int r11 = Math.min(r5.length, r10.length);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = r5[r12] - r10[r12];
        if (r13 != 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return r5.length - r10.length;
    }
}
