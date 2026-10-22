package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Floats$LexicographicalComparator extends Enum<Floats$LexicographicalComparator> implements Comparator<float[]> {
    public static final Floats$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Floats$LexicographicalComparator[] f9318a = null;

    static {
        Floats$LexicographicalComparator r5 = new Floats$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9318a = new Floats$LexicographicalComparator[]{r5};
    }

    public static Floats$LexicographicalComparator valueOf(String r5) {
        return (Floats$LexicographicalComparator) Enum.valueOf(Floats$LexicographicalComparator.class, r5);
    }

    public static Floats$LexicographicalComparator[] values() {
        return (Floats$LexicographicalComparator[]) f9318a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(float[] r5, float[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Floats.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(float[] r5, float[] r10) {
        int r11 = Math.min(r5.length, r10.length);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        int r13 = Float.compare(r5[r12], r10[r12]);
        if (r13 != 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return r5.length - r10.length;
    }
}
