package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class SortedLists {

    /* JADX INFO: renamed from: com.google.common.collect.SortedLists$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static abstract enum KeyAbsentBehavior extends Enum<KeyAbsentBehavior> {
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES = null;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX = null;
        public static final KeyAbsentBehavior NEXT_HIGHER = null;
        public static final KeyAbsentBehavior NEXT_LOWER = null;

        private static /* synthetic */ KeyAbsentBehavior[] $values() {
            return new KeyAbsentBehavior[]{NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX};
        }

        static {
            final String r1 = "NEXT_LOWER";
            final int r2 = 0;
            NEXT_LOWER = new AnonymousClass1(r1, r2);
            final String r3 = "NEXT_HIGHER";
            final int r4 = 1;
            NEXT_HIGHER = new AnonymousClass2(r3, r4);
            final String r5 = "INVERTED_INSERTION_INDEX";
            final int r6 = 2;
            INVERTED_INSERTION_INDEX = new AnonymousClass3(r5, r6);
            $VALUES = $values();
        }

        private KeyAbsentBehavior(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ KeyAbsentBehavior(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static KeyAbsentBehavior valueOf(String r2) {
            return (KeyAbsentBehavior) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyAbsentBehavior.class, r2), KeyAbsentBehavior.class, "com.obric.memorydata.plugin");
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyAbsentBehavior[].class, "com.obric.memorydata.plugin");
        }

        abstract int resultIndex(int r1);
    }

    static abstract enum KeyPresentBehavior extends Enum<KeyPresentBehavior> {
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES = null;
        public static final KeyPresentBehavior ANY_PRESENT = null;
        public static final KeyPresentBehavior FIRST_AFTER = null;
        public static final KeyPresentBehavior FIRST_PRESENT = null;
        public static final KeyPresentBehavior LAST_BEFORE = null;
        public static final KeyPresentBehavior LAST_PRESENT = null;

        private static /* synthetic */ KeyPresentBehavior[] $values() {
            return new KeyPresentBehavior[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE};
        }

        static {
            final String r1 = "ANY_PRESENT";
            final int r2 = 0;
            ANY_PRESENT = new AnonymousClass1(r1, r2);
            final String r3 = "LAST_PRESENT";
            final int r4 = 1;
            LAST_PRESENT = new AnonymousClass2(r3, r4);
            final String r5 = "FIRST_PRESENT";
            final int r6 = 2;
            FIRST_PRESENT = new AnonymousClass3(r5, r6);
            final String r7 = "FIRST_AFTER";
            final int r8 = 3;
            FIRST_AFTER = new AnonymousClass4(r7, r8);
            final String r9 = "LAST_BEFORE";
            final int r10 = 4;
            LAST_BEFORE = new AnonymousClass5(r9, r10);
            $VALUES = $values();
        }

        private KeyPresentBehavior(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ KeyPresentBehavior(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static KeyPresentBehavior valueOf(String r2) {
            return (KeyPresentBehavior) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyPresentBehavior.class, r2), KeyPresentBehavior.class, "com.obric.memorydata.plugin");
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyPresentBehavior[].class, "com.obric.memorydata.plugin");
        }

        abstract <E> int resultIndex(Comparator<? super E> r1, E r2, List<? extends E> r3, int r4);
    }

    public static <E, K extends Comparable> int a(List<E> r8, com.google.common.base.g<? super E, K> r9, K r10, KeyPresentBehavior r11, KeyAbsentBehavior r12) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        com.google.common.base.g r3 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r9, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r10, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return a(r2, r3, r4, Ordering.natural(), r11, r12);
    }

    public static <E, K> int a(List<E> r2, com.google.common.base.g<? super E, K> r3, K r4, Comparator<? super K> r5, KeyPresentBehavior r6, KeyAbsentBehavior r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.google.common.base.g r9 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        Comparator r10 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        return a(Lists.a(r8, r9), r4, r10, r6, r7);
    }

    public static <E> int a(List<? extends E> r4, E r5, Comparator<? super E> r6, KeyPresentBehavior r7, KeyAbsentBehavior r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Comparator<? super E> r10 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r10);
        com.google.common.base.n.a(r9);
        com.google.common.base.n.a(r7);
        com.google.common.base.n.a(r8);
        if (ZeusTransformUtils.instanceOf(r9, RandomAccess.class) == true) goto L5;
        r9 = Lists.a(r9);
    L5:
        int r0 = 0;
        int r1 = r9.size() - 1;
    L6:
        if (r0 > r1) goto L15;
        int r2 = (r0 + r1) >>> 1;
        int r3 = r10.compare(r5, (Object) r9.get(r2));
        if (r3 < 0) goto L9;
        if (r3 <= 0) goto L13;
        r0 = r2 + 1;
        goto L6
    L13:
        return r0 + r7.resultIndex(r10, r5, r9.subList(r0, r1 + 1), r2 - r0);
    L9:
        r1 = r2 - 1;
        goto L6
    L15:
        return r8.resultIndex(r0);
    }
}
