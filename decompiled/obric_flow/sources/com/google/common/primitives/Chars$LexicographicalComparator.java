package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Chars$LexicographicalComparator extends Enum<Chars$LexicographicalComparator> implements Comparator<char[]> {
    public static final Chars$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Chars$LexicographicalComparator[] f9316a = null;

    static {
        Chars$LexicographicalComparator r5 = new Chars$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9316a = new Chars$LexicographicalComparator[]{r5};
    }

    public static Chars$LexicographicalComparator valueOf(String r5) {
        return (Chars$LexicographicalComparator) Enum.valueOf(Chars$LexicographicalComparator.class, r5);
    }

    public static Chars$LexicographicalComparator[] values() {
        return (Chars$LexicographicalComparator[]) f9316a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(char[] r5, char[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Chars.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(char[] r5, char[] r10) {
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
