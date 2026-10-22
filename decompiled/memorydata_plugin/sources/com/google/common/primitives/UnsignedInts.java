package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedInts {

    static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        private static /* synthetic */ LexicographicalComparator[] $values() {
            return new LexicographicalComparator[]{INSTANCE};
        }

        static {
            INSTANCE = new LexicographicalComparator("INSTANCE", 0);
            $VALUES = $values();
        }

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r2) {
            return (LexicographicalComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(LexicographicalComparator.class, r2), LexicographicalComparator.class, "com.obric.memorydata.plugin");
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LexicographicalComparator[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(int[] r3, int[] r4) {
            return compare2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r4, int[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L10;
            if (r4[r0] != r5[r0]) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return UnsignedInts.a(r4[r0], r5[r0]);
        L10:
            return r4.length - r5.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    static int a(int r1) {
        return r1 ^ Integer.MIN_VALUE;
    }

    public static int a(int r0, int r1) {
        return Ints.a(a(r0), a(r1));
    }

    public static int a(String r4, int r5) {
        n.a(r4);
        long r0 = Long.parseLong(r4, r5);
        if ((4294967295L & r0) != r0) goto L7;
        return (int) r0;
    L7:
        throw new NumberFormatException("Input " + r4 + " in base " + r5 + " is not in the range of an unsigned integer");
    }

    public static int b(int r2, int r3) {
        return (int) (b(r2) / b(r3));
    }

    public static long b(int r4) {
        return ((long) r4) & 4294967295L;
    }

    public static int c(int r2, int r3) {
        return (int) (b(r2) % b(r3));
    }

    public static String d(int r4, int r5) {
        return Long.toString(((long) r4) & 4294967295L, r5);
    }
}
