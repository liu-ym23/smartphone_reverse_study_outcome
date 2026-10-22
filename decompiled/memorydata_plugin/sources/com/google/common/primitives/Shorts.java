package com.google.common.primitives;

import com.google.common.base.Converter;
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
public final class Shorts extends e {

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<short[]> {
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
        public /* synthetic */ int compare(short[] r3, short[] r4) {
            return compare2((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.memorydata.plugin"), (short[]) ZeusTransformUtils.preCheckCast(r4, short[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(short[] r4, short[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = Shorts.a(r4[r0], r5[r0]);
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
            return "Shorts.lexicographicalComparator()";
        }
    }

    private static class ShortArrayAsList extends AbstractList<Short> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        ShortArrayAsList(short[] r3) {
            this(r3, 0, r3.length);
        }

        ShortArrayAsList(short[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Short.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (Shorts.a(this.array, ((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.memorydata.plugin")).shortValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, ShortArrayAsList.class) == false) goto L18;
            ShortArrayAsList r9 = (ShortArrayAsList) ZeusTransformUtils.preCheckCast(r8, ShortArrayAsList.class, "com.obric.memorydata.plugin");
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
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int r2) {
            n.a(r2, size());
            return Short.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Shorts.a(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L8;
            int r5 = Shorts.a(this.array, ((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.memorydata.plugin")).shortValue(), this.start, this.end);
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
            if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L8;
            int r5 = Shorts.b(this.array, ((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.memorydata.plugin")).shortValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.memorydata.plugin"));
        }

        public Short set(int r4, Short r5) {
            n.a(r4, size());
            short[] r0 = this.array;
            int r3 = this.start;
            short r1 = r0[r3 + r4];
            r0[r3 + r4] = ((Short) ZeusTransformUtils.preCheckCast(n.a(r5), Short.class, "com.obric.memorydata.plugin")).shortValue();
            return Short.valueOf(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int r3, int r4) {
            n.a(r3, r4, size());
            if (r3 == r4) goto L5;
            short[] r1 = this.array;
            int r2 = this.start;
            return new ShortArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 6);
            r0.append('[').append(this.array[this.start]);
            int r1 = this.start;
        L3:
            r1 = r1 + 1;
            if (r1 >= this.end) goto L7;
            r0.append(", ").append(this.array[r1]);
            goto L3
        L7:
            return r0.append(']').toString();
        }
    }

    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new ShortConverter();
        }

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doBackward(Short r3) {
            return doBackward2((Short) ZeusTransformUtils.preCheckCast(r3, Short.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Short r1) {
            return r1.toString();
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ Short doForward(String r3) {
            return doForward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Short doForward2(String r1) {
            return Short.decode(r1);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    public static int a(short r0) {
        return r0;
    }

    public static int a(short r0, short r1) {
        return r0 - r1;
    }

    static /* synthetic */ int a(short[] r0, short r1, int r2, int r3) {
        return c(r0, r1, r2, r3);
    }

    static /* synthetic */ int b(short[] r0, short r1, int r2, int r3) {
        return d(r0, r1, r2, r3);
    }

    private static int c(short[] r1, short r2, int r3, int r4) {
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

    private static int d(short[] r1, short r2, int r3, int r4) {
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
