package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public final class Longs {

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
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
        public /* synthetic */ int compare(long[] r3, long[] r4) {
            return compare2((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.memorydata.plugin"), (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r6, long[] r7) {
            int r5 = Math.min(r6.length, r7.length);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L9;
            int r1 = Longs.a(r6[r0], r7[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r6.length - r7.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    private static class LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        LongArrayAsList(long[] r3) {
            this(r3, 0, r3.length);
        }

        LongArrayAsList(long[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Long.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (Longs.a(this.array, ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin")).longValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r9) {
            if (r9 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, LongArrayAsList.class) == false) goto L18;
            LongArrayAsList r10 = (LongArrayAsList) ZeusTransformUtils.preCheckCast(r9, LongArrayAsList.class, "com.obric.memorydata.plugin");
            int r0 = size();
            if (r10.size() == r0) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r0) goto L16;
            if (this.array[this.start + r2] != r10.array[r10.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r9);
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r2) {
            n.a(r2, size());
            return Long.valueOf(this.array[this.start + r2]);
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
            r1 = (r1 * 31) + Longs.a(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L8;
            int r6 = Longs.a(this.array, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L8;
            int r6 = Longs.b(this.array, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        public Long set(int r5, Long r6) {
            n.a(r5, size());
            long[] r0 = this.array;
            int r4 = this.start;
            long r1 = r0[r4 + r5];
            r0[r4 + r5] = ((Long) ZeusTransformUtils.preCheckCast(n.a(r6), Long.class, "com.obric.memorydata.plugin")).longValue();
            return Long.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator.OfLong spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Spliterator spliterator() {
            return spliterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r3, int r4) {
            n.a(r3, r4, size());
            if (r3 == r4) goto L5;
            long[] r1 = this.array;
            int r2 = this.start;
            return new LongArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 10);
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

    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new LongConverter();
        }

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doBackward(Long r3) {
            return doBackward2((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Long r1) {
            return r1.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Long doForward2(String r1) {
            return Long.decode(r1);
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ Long doForward(String r3) {
            return doForward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    public static int a(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    public static int a(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    static /* synthetic */ int a(long[] r0, long r1, int r3, int r4) {
        return c(r0, r1, r3, r4);
    }

    public static long a(byte r5, byte r6, byte r7, byte r8, byte r9, byte r10, byte r11, byte r12) {
        long r0 = (((long) r5) & 255) << 56;
        return ((((((((((long) r6) & 255) << 48) | r0) | ((((long) r7) & 255) << 40)) | ((((long) r8) & 255) << 32)) | ((((long) r9) & 255) << 24)) | ((((long) r10) & 255) << 16)) | ((((long) r11) & 255) << 8)) | (((long) r12) & 255);
    }

    public static long[] a(Collection<? extends Number> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, LongArrayAsList.class) == true) goto L5;
        Object[] r8 = r7.toArray();
        int r0 = r8.length;
        long[] r2 = new long[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r2[r3] = ((Number) ZeusTransformUtils.preCheckCast(n.a(r8[r3]), Number.class, "com.obric.memorydata.plugin")).longValue();
        r3 = r3 + 1;
        goto L7
    L9:
        return r2;
    L5:
        return ((LongArrayAsList) ZeusTransformUtils.preCheckCast(r7, LongArrayAsList.class, "com.obric.memorydata.plugin")).toLongArray();
    }

    static /* synthetic */ int b(long[] r0, long r1, int r3, int r4) {
        return d(r0, r1, r3, r4);
    }

    private static int c(long[] r2, long r3, int r5, int r6) {
    L2:
        if (r5 >= r6) goto L7;
        if (r2[r5] == r3) goto L5;
        r5 = r5 + 1;
        goto L2
    L5:
        return r5;
    L7:
        return -1;
    }

    private static int d(long[] r2, long r3, int r5, int r6) {
        int r7 = r6 - 1;
    L3:
        if (r7 < r5) goto L8;
        if (r2[r7] == r3) goto L6;
        r7 = r7 - 1;
        goto L3
    L6:
        return r7;
    L8:
        return -1;
    }
}
