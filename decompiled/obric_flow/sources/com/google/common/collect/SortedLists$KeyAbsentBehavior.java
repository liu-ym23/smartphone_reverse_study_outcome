package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
abstract enum SortedLists$KeyAbsentBehavior extends Enum<SortedLists$KeyAbsentBehavior> {
    public static final SortedLists$KeyAbsentBehavior INVERTED_INSERTION_INDEX = null;
    public static final SortedLists$KeyAbsentBehavior NEXT_HIGHER = null;
    public static final SortedLists$KeyAbsentBehavior NEXT_LOWER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortedLists$KeyAbsentBehavior[] f8866a = null;

    static {
        final String r5 = "NEXT_LOWER";
        final int r10 = 0;
        SortedLists$KeyAbsentBehavior r11 = new AnonymousClass1(r5, r10);
        NEXT_LOWER = r11;
        final String r12 = "NEXT_HIGHER";
        final int r13 = 1;
        SortedLists$KeyAbsentBehavior r14 = new AnonymousClass2(r12, r13);
        NEXT_HIGHER = r14;
        final String r15 = "INVERTED_INSERTION_INDEX";
        final int r16 = 2;
        SortedLists$KeyAbsentBehavior r17 = new AnonymousClass3(r15, r16);
        INVERTED_INSERTION_INDEX = r17;
        f8866a = new SortedLists$KeyAbsentBehavior[]{r11, r14, r17};
    }

    public SortedLists$KeyAbsentBehavior(String r5, int r10, u8 r11) {
        super(r5, r10);
    }

    public static SortedLists$KeyAbsentBehavior valueOf(String r5) {
        return (SortedLists$KeyAbsentBehavior) Enum.valueOf(SortedLists$KeyAbsentBehavior.class, r5);
    }

    public static SortedLists$KeyAbsentBehavior[] values() {
        return (SortedLists$KeyAbsentBehavior[]) f8866a.clone();
    }

    public abstract int resultIndex(int r5);
}
