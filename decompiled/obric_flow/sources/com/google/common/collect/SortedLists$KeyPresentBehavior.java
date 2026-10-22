package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract enum SortedLists$KeyPresentBehavior extends Enum<SortedLists$KeyPresentBehavior> {
    public static final SortedLists$KeyPresentBehavior ANY_PRESENT = null;
    public static final SortedLists$KeyPresentBehavior FIRST_AFTER = null;
    public static final SortedLists$KeyPresentBehavior FIRST_PRESENT = null;
    public static final SortedLists$KeyPresentBehavior LAST_BEFORE = null;
    public static final SortedLists$KeyPresentBehavior LAST_PRESENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SortedLists$KeyPresentBehavior[] f8867a = null;

    static {
        final String r5 = "ANY_PRESENT";
        final int r10 = 0;
        SortedLists$KeyPresentBehavior r11 = new AnonymousClass1(r5, r10);
        ANY_PRESENT = r11;
        final String r12 = "LAST_PRESENT";
        final int r13 = 1;
        SortedLists$KeyPresentBehavior r14 = new AnonymousClass2(r12, r13);
        LAST_PRESENT = r14;
        final String r15 = "FIRST_PRESENT";
        final int r16 = 2;
        SortedLists$KeyPresentBehavior r17 = new AnonymousClass3(r15, r16);
        FIRST_PRESENT = r17;
        final String r18 = "FIRST_AFTER";
        final int r19 = 3;
        SortedLists$KeyPresentBehavior r20 = new AnonymousClass4(r18, r19);
        FIRST_AFTER = r20;
        final String r21 = "LAST_BEFORE";
        final int r110 = 4;
        SortedLists$KeyPresentBehavior r22 = new AnonymousClass5(r21, r110);
        LAST_BEFORE = r22;
        f8867a = new SortedLists$KeyPresentBehavior[]{r11, r14, r17, r20, r22};
    }

    public SortedLists$KeyPresentBehavior(String r5, int r10, u8 r11) {
        super(r5, r10);
    }

    public static SortedLists$KeyPresentBehavior valueOf(String r5) {
        return (SortedLists$KeyPresentBehavior) Enum.valueOf(SortedLists$KeyPresentBehavior.class, r5);
    }

    public static SortedLists$KeyPresentBehavior[] values() {
        return (SortedLists$KeyPresentBehavior[]) f8867a.clone();
    }

    public abstract <E> int resultIndex(Comparator<? super E> r5, E r10, List<? extends E> r11, int r12);
}
