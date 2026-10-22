package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum SignedBytes$LexicographicalComparator extends Enum<SignedBytes$LexicographicalComparator> implements Comparator<byte[]> {
    public static final SignedBytes$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignedBytes$LexicographicalComparator[] f9328a = null;

    static {
        SignedBytes$LexicographicalComparator r5 = new SignedBytes$LexicographicalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f9328a = new SignedBytes$LexicographicalComparator[]{r5};
    }

    public static SignedBytes$LexicographicalComparator valueOf(String r5) {
        return (SignedBytes$LexicographicalComparator) Enum.valueOf(SignedBytes$LexicographicalComparator.class, r5);
    }

    public static SignedBytes$LexicographicalComparator[] values() {
        return (SignedBytes$LexicographicalComparator[]) f9328a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(byte[] r5, byte[] r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "SignedBytes.lexicographicalComparator()";
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] r5, byte[] r10) {
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
