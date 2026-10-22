package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Doubles$LexicographicalComparator extends Enum<Doubles$LexicographicalComparator> implements Comparator<double[]> {
    public static final Doubles$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Doubles$LexicographicalComparator[] f9317a = null;

    static {
        Doubles$LexicographicalComparator r5 = new Doubles$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9317a = new Doubles$LexicographicalComparator[]{r5};
    }

    public static Doubles$LexicographicalComparator valueOf(String r5) {
        return (Doubles$LexicographicalComparator) Enum.valueOf(Doubles$LexicographicalComparator.class, r5);
    }

    public static Doubles$LexicographicalComparator[] values() {
        return (Doubles$LexicographicalComparator[]) f9317a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(double[] r5, double[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Doubles.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(double[] r10, double[] r11) {
        int r5 = Math.min(r10.length, r11.length);
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L9;
        int r13 = Double.compare(r10[r12], r11[r12]);
        if (r13 != 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return r10.length - r11.length;
    }
}
