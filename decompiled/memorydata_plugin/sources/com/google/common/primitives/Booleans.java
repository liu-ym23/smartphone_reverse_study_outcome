package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Booleans {

    private static class BooleanArrayAsList extends AbstractList<Boolean> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        BooleanArrayAsList(boolean[] r3) {
            this(r3, 0, r3.length);
        }

        BooleanArrayAsList(boolean[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (Booleans.a(this.array, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, BooleanArrayAsList.class) == false) goto L18;
            BooleanArrayAsList r9 = (BooleanArrayAsList) ZeusTransformUtils.preCheckCast(r8, BooleanArrayAsList.class, "com.obric.memorydata.plugin");
            int r0 = size();
            if (r9.size() == r0) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r0) goto L16;
            if (this.array[this.start + r2] != r9.array[r9.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int r2) {
            n.a(r2, size());
            return Boolean.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Booleans.a(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L8;
            int r5 = Booleans.a(this.array, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L8;
            int r5 = Booleans.b(this.array, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        public Boolean set(int r4, Boolean r5) {
            n.a(r4, size());
            boolean[] r0 = this.array;
            int r3 = this.start;
            boolean r1 = r0[r3 + r4];
            r0[r3 + r4] = ((Boolean) ZeusTransformUtils.preCheckCast(n.a(r5), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            return Boolean.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int r3, int r4) {
            n.a(r3, r4, size());
            if (r3 == r4) goto L5;
            boolean[] r1 = this.array;
            int r2 = this.start;
            return new BooleanArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 7);
            if (this.array[this.start] == false) goto L5;
            String r1 = "[true";
        L6:
            r0.append(r1);
            int r2 = this.start;
        L7:
            r2 = r2 + 1;
            if (r2 >= this.end) goto L15;
            if (this.array[r2] == false) goto L12;
            String r3 = ", true";
        L13:
            r0.append(r3);
            goto L7
        L12:
            r3 = ", false";
            goto L13
        L15:
            return r0.append(']').toString();
        L5:
            r1 = "[false";
            goto L6
        }
    }

    private static final enum BooleanComparator extends Enum<BooleanComparator> implements Comparator<Boolean> {
        private static final /* synthetic */ BooleanComparator[] $VALUES = null;
        public static final BooleanComparator FALSE_FIRST = null;
        public static final BooleanComparator TRUE_FIRST = null;
        private final String toString;
        private final int trueValue;

        private static /* synthetic */ BooleanComparator[] $values() {
            return new BooleanComparator[]{TRUE_FIRST, FALSE_FIRST};
        }

        static {
            TRUE_FIRST = new BooleanComparator("TRUE_FIRST", 0, 1, "Booleans.trueFirst()");
            FALSE_FIRST = new BooleanComparator("FALSE_FIRST", 1, -1, "Booleans.falseFirst()");
            $VALUES = $values();
        }

        private BooleanComparator(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.trueValue = r3;
            this.toString = r4;
        }

        public static BooleanComparator valueOf(String r2) {
            return (BooleanComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(BooleanComparator.class, r2), BooleanComparator.class, "com.obric.memorydata.plugin");
        }

        public static BooleanComparator[] values() {
            return (BooleanComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BooleanComparator[].class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Boolean r2, Boolean r3) {
            int r0 = 0;
            if (r2.booleanValue() == false) goto L5;
            int r4 = this.trueValue;
        L7:
            if (r3.booleanValue() == false) goto L10;
            r0 = this.trueValue;
        L10:
            return r0 - r4;
        L5:
            r4 = 0;
            goto L7
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Boolean r3, Boolean r4) {
            return compare2((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin"), (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }
    }

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<boolean[]> {
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
        public /* synthetic */ int compare(boolean[] r3, boolean[] r4) {
            return compare2((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.memorydata.plugin"), (boolean[]) ZeusTransformUtils.preCheckCast(r4, boolean[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(boolean[] r4, boolean[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = Booleans.a(r4[r0], r5[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    public static int a(boolean r0) {
        if (r0 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int a(boolean r0, boolean r1) {
        if (r0 != r1) goto L4;
        return 0;
    L4:
        if (r0 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    static /* synthetic */ int a(boolean[] r0, boolean r1, int r2, int r3) {
        return c(r0, r1, r2, r3);
    }

    static /* synthetic */ int b(boolean[] r0, boolean r1, int r2, int r3) {
        return d(r0, r1, r2, r3);
    }

    private static int c(boolean[] r1, boolean r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L7;
        if (r1[r3] == r2) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return -1;
    }

    private static int d(boolean[] r1, boolean r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L8;
        if (r1[r5] == r2) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }
}
