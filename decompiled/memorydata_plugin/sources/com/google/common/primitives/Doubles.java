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
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class Doubles extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f4756a = null;

    private static class DoubleArrayAsList extends AbstractList<Double> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        DoubleArrayAsList(double[] r3) {
            this(r3, 0, r3.length);
        }

        DoubleArrayAsList(double[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Double.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (Doubles.a(this.array, ((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin")).doubleValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r9) {
            if (r9 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, DoubleArrayAsList.class) == false) goto L18;
            DoubleArrayAsList r10 = (DoubleArrayAsList) ZeusTransformUtils.preCheckCast(r9, DoubleArrayAsList.class, "com.obric.memorydata.plugin");
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
        public Double get(int r2) {
            n.a(r2, size());
            return Double.valueOf(this.array[this.start + r2]);
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
            r1 = (r1 * 31) + Doubles.a(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L8;
            int r6 = Doubles.a(this.array, ((Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin")).doubleValue(), this.start, this.end);
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
            if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L8;
            int r6 = Doubles.b(this.array, ((Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin")).doubleValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        public Double set(int r5, Double r6) {
            n.a(r5, size());
            double[] r0 = this.array;
            int r4 = this.start;
            double r1 = r0[r4 + r5];
            r0[r4 + r5] = ((Double) ZeusTransformUtils.preCheckCast(n.a(r6), Double.class, "com.obric.memorydata.plugin")).doubleValue();
            return Double.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator.OfDouble spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Spliterator spliterator() {
            return spliterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r3, int r4) {
            n.a(r3, r4, size());
            if (r3 == r4) goto L5;
            double[] r1 = this.array;
            int r2 = this.start;
            return new DoubleArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 12);
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

    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new DoubleConverter();
        }

        private DoubleConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doBackward(Double r3) {
            return doBackward2((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Double r1) {
            return r1.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Double doForward2(String r1) {
            return Double.valueOf(r1);
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ Double doForward(String r3) {
            return doForward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<double[]> {
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
        public /* synthetic */ int compare(double[] r3, double[] r4) {
            return compare2((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.memorydata.plugin"), (double[]) ZeusTransformUtils.preCheckCast(r4, double[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(double[] r6, double[] r7) {
            int r5 = Math.min(r6.length, r7.length);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L9;
            int r1 = Double.compare(r6[r0], r7[r0]);
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
            return "Doubles.lexicographicalComparator()";
        }
    }

    static {
        f4756a = a();
    }

    public static int a(double r0) {
        return Double.valueOf(r0).hashCode();
    }

    static /* synthetic */ int a(double[] r0, double r1, int r3, int r4) {
        return c(r0, r1, r3, r4);
    }

    private static Pattern a() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", Marker.ANY_NON_NULL_MARKER));
    }

    public static double[] a(Collection<? extends Number> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, DoubleArrayAsList.class) == true) goto L5;
        Object[] r8 = r7.toArray();
        int r0 = r8.length;
        double[] r2 = new double[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r2[r3] = ((Number) ZeusTransformUtils.preCheckCast(n.a(r8[r3]), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        r3 = r3 + 1;
        goto L7
    L9:
        return r2;
    L5:
        return ((DoubleArrayAsList) ZeusTransformUtils.preCheckCast(r7, DoubleArrayAsList.class, "com.obric.memorydata.plugin")).toDoubleArray();
    }

    static /* synthetic */ int b(double[] r0, double r1, int r3, int r4) {
        return d(r0, r1, r3, r4);
    }

    public static boolean b(double r2) {
        if (Double.NEGATIVE_INFINITY < r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 >= Double.POSITIVE_INFINITY) goto L7;
        return true;
    }

    private static int c(double[] r2, double r3, int r5, int r6) {
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

    private static int d(double[] r2, double r3, int r5, int r6) {
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
