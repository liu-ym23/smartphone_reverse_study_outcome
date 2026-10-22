package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final enum Booleans$BooleanComparator extends Enum<Booleans$BooleanComparator> implements Comparator<Boolean> {
    public static final Booleans$BooleanComparator FALSE_FIRST = null;
    public static final Booleans$BooleanComparator TRUE_FIRST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Booleans$BooleanComparator[] f9314a = null;
    private final String toString;
    private final int trueValue;

    static {
        Booleans$BooleanComparator r5 = new Booleans$BooleanComparator("TRUE_FIRST", 0, 1, "Booleans.trueFirst()");
        TRUE_FIRST = r5;
        Booleans$BooleanComparator r10 = new Booleans$BooleanComparator("FALSE_FIRST", 1, -1, "Booleans.falseFirst()");
        FALSE_FIRST = r10;
        f9314a = new Booleans$BooleanComparator[]{r5, r10};
    }

    public Booleans$BooleanComparator(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.trueValue = r11;
        this.toString = r12;
    }

    public static Booleans$BooleanComparator valueOf(String r5) {
        return (Booleans$BooleanComparator) Enum.valueOf(Booleans$BooleanComparator.class, r5);
    }

    public static Booleans$BooleanComparator[] values() {
        return (Booleans$BooleanComparator[]) f9314a.clone();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Boolean r5, Boolean r10) {
        return compare2(r5, r10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.toString;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Boolean r5, Boolean r10) {
        int r11 = 0;
        if (r5.booleanValue() == false) goto L5;
        int r12 = this.trueValue;
    L7:
        if (r10.booleanValue() == false) goto L10;
        r11 = this.trueValue;
    L10:
        return r11 - r12;
    L5:
        r12 = 0;
        goto L7
    }
}
