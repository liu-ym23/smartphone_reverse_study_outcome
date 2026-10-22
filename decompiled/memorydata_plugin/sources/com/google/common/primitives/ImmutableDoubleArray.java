package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = null;
    private final double[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableDoubleArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AsList extends AbstractList<Double> implements Serializable, RandomAccess {
        private final ImmutableDoubleArray parent;

        private AsList(ImmutableDoubleArray r1) {
            this.parent = r1;
        }

        /* synthetic */ AsList(ImmutableDoubleArray r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r1) {
            if (indexOf(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r9) {
            if (ZeusTransformUtils.instanceOf(r9, AsList.class) == false) goto L7;
            AsList r10 = (AsList) ZeusTransformUtils.preCheckCast(r9, AsList.class, "com.obric.memorydata.plugin");
            return this.parent.equals(r10.parent);
        L7:
            if (ZeusTransformUtils.instanceOf(r9, List.class) == true) goto L9;
            return false;
        L9:
            List r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
            if (size() == r11.size()) goto L12;
            return false;
        L12:
            int r0 = ImmutableDoubleArray.access$100(this.parent);
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L22;
            Object r3 = r12.next();
            if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L21;
            int r5 = r0 + 1;
            if (ImmutableDoubleArray.access$600(ImmutableDoubleArray.access$000(this.parent)[r0], ((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue()) == false) goto L21;
            r0 = r5;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int r1) {
            return Double.valueOf(this.parent.get(r1));
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Double.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Double.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Double> spliterator() {
            return ImmutableDoubleArray.access$500(this.parent);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r1, int r2) {
            return this.parent.subArray(r1, r2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double[] f4757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4758b;

        a(int r2) {
            this.f4758b = 0;
            this.f4757a = new double[r2];
        }

        private static int a(int r1, int r2) {
            if (r2 < 0) goto L10;
            int r3 = (r1 + (r1 >> 1)) + 1;
            if (r3 >= r2) goto L6;
            r3 = Integer.highestOneBit(r2 - 1) << 1;
        L6:
            if (r3 >= 0) goto L11;
            return Integer.MAX_VALUE;
        L11:
            return r3;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        private void a(int r3) {
            int r0 = this.f4758b + r3;
            double[] r4 = this.f4757a;
            if (r0 <= r4.length) goto L6;
            this.f4757a = Arrays.copyOf(r4, a(r4.length, r0));
            return;
        }

        public a a(double r4) {
            a(1);
            double[] r1 = this.f4757a;
            int r2 = this.f4758b;
            r1[r2] = r4;
            this.f4758b = r2 + 1;
            return this;
        }

        public a a(Iterable<Double> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
            Iterator r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            a(((Double) ZeusTransformUtils.preCheckCast(r7.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
            goto L8
        L10:
            return this;
        L5:
            return a((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        }

        public a a(Collection<Double> r7) {
            Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
            a(r8.size());
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            Double r0 = (Double) ZeusTransformUtils.preCheckCast(r9.next(), Double.class, "com.obric.memorydata.plugin");
            double[] r2 = this.f4757a;
            int r3 = this.f4758b;
            this.f4758b = r3 + 1;
            r2[r3] = r0.doubleValue();
            goto L4
        L6:
            return this;
        }

        public ImmutableDoubleArray a() {
            if (this.f4758b != 0) goto L6;
            return ImmutableDoubleArray.access$200();
        L6:
            return new ImmutableDoubleArray(this.f4757a, 0, this.f4758b, null);
        }
    }

    static {
        EMPTY = new ImmutableDoubleArray(new double[0]);
    }

    private ImmutableDoubleArray(double[] r3) {
        this(r3, 0, r3.length);
    }

    private ImmutableDoubleArray(double[] r1, int r2, int r3) {
        this.array = r1;
        this.start = r2;
        this.end = r3;
    }

    /* synthetic */ ImmutableDoubleArray(double[] r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ double[] access$000(ImmutableDoubleArray r0) {
        return r0.array;
    }

    static /* synthetic */ int access$100(ImmutableDoubleArray r0) {
        return r0.start;
    }

    static /* synthetic */ ImmutableDoubleArray access$200() {
        return EMPTY;
    }

    static /* synthetic */ Spliterator.OfDouble access$500(ImmutableDoubleArray r0) {
        return r0.spliterator();
    }

    static /* synthetic */ boolean access$600(double r0, double r2) {
        return areEqual(r0, r2);
    }

    private static boolean areEqual(double r0, double r2) {
        if (Double.doubleToLongBits(r0) != Double.doubleToLongBits(r2)) goto L5;
        return true;
    L5:
        return false;
    }

    public static a builder() {
        return new a(10);
    }

    public static a builder(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        n.a(r0, "Invalid initialCapacity: %s", r2);
        return new a(r2);
    L4:
        r0 = false;
        goto L5
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> r2) {
        Iterable<Double> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L7;
        return copyOf((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
    L7:
        return builder().a(r3).a();
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(Doubles.a(r3));
    }

    public static ImmutableDoubleArray copyOf(DoubleStream r2) {
        double[] r3 = ((DoubleStream) ZeusTransformUtils.wrapperContextForParams(r2, DoubleStream.class, "com.obric.memorydata.plugin")).toArray();
        if (r3.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(r3);
    }

    public static ImmutableDoubleArray copyOf(double[] r2) {
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableDoubleArray(Arrays.copyOf(r2, r2.length));
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double r3) {
        return new ImmutableDoubleArray(new double[]{r3});
    }

    public static ImmutableDoubleArray of(double r3, double r5) {
        return new ImmutableDoubleArray(new double[]{r3, r5});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9, double r11) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9, r11});
    }

    public static ImmutableDoubleArray of(double r3, double r5, double r7, double r9, double r11, double r13) {
        return new ImmutableDoubleArray(new double[]{r3, r5, r7, r9, r11, r13});
    }

    public static ImmutableDoubleArray of(double r4, double... r6) {
        if (r6.length > 2147483646) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "the total number of elements must fit in an int");
        double[] r1 = new double[r6.length + 1];
        r1[0] = r4;
        System.arraycopy(r6, 0, r1, 1, r6.length);
        return new ImmutableDoubleArray(r1);
    L5:
        r0 = false;
        goto L6
    }

    private Spliterator.OfDouble spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Double> asList() {
        return new AsList(this, null);
    }

    public boolean contains(double r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ImmutableDoubleArray.class) == true) goto L8;
        return false;
    L8:
        ImmutableDoubleArray r10 = (ImmutableDoubleArray) ZeusTransformUtils.preCheckCast(r9, ImmutableDoubleArray.class, "com.obric.memorydata.plugin");
        if (length() == r10.length()) goto L11;
        return false;
    L11:
        int r0 = 0;
    L13:
        if (r0 >= length()) goto L18;
        if (areEqual(get(r0), r10.get(r0)) == false) goto L16;
        r0 = r0 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public void forEach(DoubleConsumer r4) {
        DoubleConsumer r5 = (DoubleConsumer) ZeusTransformUtils.wrapperContextForParams(r4, DoubleConsumer.class, "com.obric.memorydata.plugin");
        n.a(r5);
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L6;
        r5.accept(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public double get(int r2) {
        n.a(r2, length());
        return this.array[this.start + r2];
    }

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

    public int indexOf(double r4) {
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L10;
        if (areEqual(this.array[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - this.start;
    L10:
        return -1;
    }

    public boolean isEmpty() {
        if (this.end != this.start) goto L5;
        return true;
    L5:
        return false;
    }

    public int lastIndexOf(double r4) {
        int r0 = this.end;
    L3:
        r0 = r0 - 1;
        if (r0 < this.start) goto L10;
        if (areEqual(this.array[r0], r4) == false) goto L3;
        return r0 - this.start;
    L10:
        return -1;
    }

    public int length() {
        return this.end - this.start;
    }

    Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return EMPTY;
    }

    public DoubleStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableDoubleArray subArray(int r3, int r4) {
        n.a(r3, r4, length());
        if (r3 == r4) goto L7;
        double[] r1 = this.array;
        int r2 = this.start;
        return new ImmutableDoubleArray(r1, r3 + r2, r2 + r4);
    L7:
        return EMPTY;
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder(length() * 5);
        r0.append('[').append(this.array[this.start]);
        int r1 = this.start;
    L7:
        r1 = r1 + 1;
        if (r1 >= this.end) goto L10;
        r0.append(", ").append(this.array[r1]);
        goto L7
    L10:
        r0.append(']');
        return r0.toString();
    }

    public ImmutableDoubleArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableDoubleArray(toArray());
    }

    Object writeReplace() {
        return trimmed();
    }
}
