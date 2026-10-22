package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Booleans$LexicographicalComparator extends Enum<Booleans$LexicographicalComparator> implements Comparator<boolean[]> {
    public static final Booleans$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Booleans$LexicographicalComparator[] f9315a = null;

    static {
        Booleans$LexicographicalComparator r5 = new Booleans$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9315a = new Booleans$LexicographicalComparator[]{r5};
    }

    public static Booleans$LexicographicalComparator valueOf(String r5) {
        return (Booleans$LexicographicalComparator) Enum.valueOf(Booleans$LexicographicalComparator.class, r5);
    }

    public static Booleans$LexicographicalComparator[] values() {
        return (Booleans$LexicographicalComparator[]) f9315a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(boolean[] r5, boolean[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Booleans.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(boolean[] r5, boolean[] r10) {
        int r11 = Math.min(r5.length, r10.length);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        boolean r13 = r5[r12];
        if (r13 != r10[r12]) goto L7;
        int r14 = 0;
    L10:
        if (r14 != 0) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return r14;
    L7:
        if (r13 == false) goto L9;
        r14 = 1;
        goto L10
    L9:
        r14 = -1;
        goto L10
    L14:
        return r5.length - r10.length;
    }
}
