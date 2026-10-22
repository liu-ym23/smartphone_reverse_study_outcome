package com.google.common.primitives;

import com.google.common.base.b0;
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

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableDoubleArray implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableDoubleArray f9319b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f9320a;
    private final double[] array;
    private final int end;

    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        public AsList(ImmutableDoubleArray r5, b r10) {
            this.parent = r5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r5) {
            if (indexOf(r5) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r10) {
            if ((r10 instanceof AsList) == false) goto L7;
            return this.parent.equals(((AsList) r10).parent);
        L7:
            if ((r10 instanceof List) == true) goto L9;
            return false;
        L9:
            List r11 = (List) r10;
            if (size() == r11.size()) goto L12;
            return false;
        L12:
            int r5 = ImmutableDoubleArray.access$100(this.parent);
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L22;
            Object r13 = r12.next();
            if ((r13 instanceof Double) == false) goto L21;
            int r14 = r5 + 1;
            if (ImmutableDoubleArray.access$600(ImmutableDoubleArray.access$000(this.parent)[r5], ((Double) r13).doubleValue()) == false) goto L21;
            r5 = r14;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r5) {
            if ((r5 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Double) r5).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            if ((r5 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Double) r5).doubleValue());
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
        public List<Double> subList(int r5, int r10) {
            return this.parent.subArray(r5, r10).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int r5) {
            return Double.valueOf(this.parent.get(r5));
        }
    }

    static {
        f9319b = new ImmutableDoubleArray(new double[0], 0, 0);
    }

    public /* synthetic */ ImmutableDoubleArray(double[] r5, int r10, int r11, b r12) {
        this(r5, r10, r11);
    }

    public static boolean a(double r5, double r10) {
        if (Double.doubleToLongBits(r5) != Double.doubleToLongBits(r10)) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ double[] access$000(ImmutableDoubleArray r5) {
        return r5.array;
    }

    public static /* synthetic */ int access$100(ImmutableDoubleArray r5) {
        return r5.f9320a;
    }

    public static /* synthetic */ ImmutableDoubleArray access$200() {
        return f9319b;
    }

    public static Spliterator.OfDouble access$500(ImmutableDoubleArray r5) {
        double[] r10 = r5.array;
        int r11 = r5.end;
        return Spliterators.spliterator(r10, r5.f9320a, r11, 1040);
    }

    public static /* synthetic */ boolean access$600(double r5, double r10) {
        return a(r5, r10);
    }

    public static c builder(int r5) {
        if (r5 < 0) goto L4;
        boolean r10 = true;
    L5:
        b0.d(r5, "Invalid initialCapacity: %s", r10);
        return new c(r5);
    L4:
        r10 = false;
        goto L5
    }

    public static ImmutableDoubleArray copyOf(double[] r5) {
        if (r5.length != 0) goto L6;
        return f9319b;
    L6:
        return new ImmutableDoubleArray(Arrays.copyOf(r5, r5.length));
    }

    public static ImmutableDoubleArray of() {
        return f9319b;
    }

    public List<Double> asList() {
        return new AsList(this, null);
    }

    public boolean contains(double r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableDoubleArray) == true) goto L8;
        return false;
    L8:
        ImmutableDoubleArray r11 = (ImmutableDoubleArray) r10;
        if (length() == r11.length()) goto L11;
        return false;
    L11:
        int r5 = 0;
    L13:
        if (r5 >= length()) goto L18;
        if (a(get(r5), r11.get(r5)) == false) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public void forEach(DoubleConsumer r5) {
        r5.getClass();
        int r10 = this.f9320a;
    L4:
        if (r10 >= this.end) goto L6;
        r5.accept(this.array[r10]);
        r10 = r10 + 1;
        goto L4
    }

    public double get(int r5) {
        b0.l(r5, length());
        return this.array[this.f9320a + r5];
    }

    public int hashCode() {
        int r5 = this.f9320a;
        int r10 = 1;
    L4:
        if (r5 >= this.end) goto L6;
        double r11 = this.array[r5];
        int r12 = a.f9333b;
        r10 = (r10 * 31) + Double.valueOf(r11).hashCode();
        r5 = r5 + 1;
        goto L4
    L6:
        return r10;
    }

    public int indexOf(double r5) {
        int r10 = this.f9320a;
        int r11 = r10;
    L4:
        if (r11 >= this.end) goto L10;
        if (a(this.array[r11], r5) == true) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return r11 - r10;
    L10:
        return -1;
    }

    public boolean isEmpty() {
        if (this.end != this.f9320a) goto L5;
        return true;
    L5:
        return false;
    }

    public int lastIndexOf(double r5) {
        int r10 = this.end;
    L3:
        r10 = r10 - 1;
        int r11 = this.f9320a;
        if (r10 < r11) goto L10;
        if (a(this.array[r10], r5) == false) goto L3;
        return r10 - r11;
    L10:
        return -1;
    }

    public int length() {
        return this.end - this.f9320a;
    }

    public Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return f9319b;
    }

    public DoubleStream stream() {
        return Arrays.stream(this.array, this.f9320a, this.end);
    }

    public ImmutableDoubleArray subArray(int r5, int r10) {
        b0.p(r5, r10, length());
        if (r5 == r10) goto L7;
        double[] r11 = this.array;
        int r12 = this.f9320a;
        return new ImmutableDoubleArray(r11, r5 + r12, r12 + r10);
    L7:
        return f9319b;
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.f9320a, this.end);
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r5 = new StringBuilder(length() * 5);
        r5.append('[');
        double[] r10 = this.array;
        int r11 = this.f9320a;
        r5.append(r10[r11]);
    L7:
        r11 = r11 + 1;
        if (r11 >= this.end) goto L10;
        r5.append(", ");
        r5.append(this.array[r11]);
        goto L7
    L10:
        r5.append(']');
        return r5.toString();
    }

    public ImmutableDoubleArray trimmed() {
        if (this.f9320a > 0) goto L7;
        if (this.end < this.array.length) goto L7;
        return this;
    L7:
        return new ImmutableDoubleArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableDoubleArray(double[] r5) {
        this(r5, 0, r5.length);
    }

    public static ImmutableDoubleArray of(double r5) {
        return new ImmutableDoubleArray(new double[]{r5}, 0, 1);
    }

    public ImmutableDoubleArray(double[] r5, int r10, int r11) {
        this.array = r5;
        this.f9320a = r10;
        this.end = r11;
    }

    public static c builder() {
        return new c(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> r10) {
        if (r10.isEmpty() == true) goto L15;
        int r5 = a.f9333b;
        if ((r10 instanceof Doubles$DoubleArrayAsList) == false) goto L8;
        double[] r11 = ((Doubles$DoubleArrayAsList) r10).toDoubleArray();
    L13:
        return new ImmutableDoubleArray(r11);
    L8:
        Object[] r12 = r10.toArray();
        int r13 = r12.length;
        double[] r14 = new double[r13];
        int r15 = 0;
    L9:
        if (r15 >= r13) goto L11;
        Object r16 = r12[r15];
        r16.getClass();
        r14[r15] = ((Number) r16).doubleValue();
        r15 = r15 + 1;
        goto L9
    L11:
        r11 = r14;
        goto L13
    L15:
        return f9319b;
    }

    public static ImmutableDoubleArray of(double r5, double r10) {
        return new ImmutableDoubleArray(new double[]{r5, r10}, 0, 2);
    }

    public static ImmutableDoubleArray of(double r5, double r10, double r11) {
        return new ImmutableDoubleArray(new double[]{r5, r10, r11}, 0, 3);
    }

    public static ImmutableDoubleArray of(double r5, double r10, double r11, double r12) {
        return new ImmutableDoubleArray(new double[]{r5, r10, r11, r12}, 0, 4);
    }

    public static ImmutableDoubleArray of(double r5, double r10, double r11, double r12, double r13) {
        return new ImmutableDoubleArray(new double[]{r5, r10, r11, r12, r13}, 0, 5);
    }

    public static ImmutableDoubleArray of(double r5, double r10, double r11, double r12, double r13, double r14) {
        return new ImmutableDoubleArray(new double[]{r5, r10, r11, r12, r13, r14}, 0, 6);
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> r10) {
        boolean r5 = r10 instanceof Collection;
        if (r5 == true) goto L5;
        c r11 = builder();
        r11.getClass();
        if (r5 == false) goto L12;
        Collection r12 = (Collection) r10;
        r11.a(r12.size());
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        Double r14 = (Double) r13.next();
        double[] r15 = r11.f9334a;
        int r16 = r11.f9335b;
        r11.f9335b = r16 + 1;
        r15[r16] = r14.doubleValue();
    L16:
        int r17 = r11.f9335b;
        if (r17 != 0) goto L20;
        return access$200();
    L20:
        return new ImmutableDoubleArray(r11.f9334a, 0, r17, null);
    L12:
        Iterator<Double> r18 = r10.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        double r19 = r18.next().doubleValue();
        r11.a(1);
        double[] r20 = r11.f9334a;
        int r21 = r11.f9335b;
        r20[r21] = r19;
        r11.f9335b = r21 + 1;
        goto L14
    L5:
        return copyOf((Collection) r10);
    }

    public static ImmutableDoubleArray of(double r5, double... r10) {
        if (r10.length > 2147483646) goto L5;
        boolean r11 = true;
    L6:
        b0.g("the total number of elements must fit in an int", r11);
        int r12 = r10.length + 1;
        double[] r13 = new double[r12];
        r13[0] = r5;
        System.arraycopy(r10, 0, r13, 1, r10.length);
        return new ImmutableDoubleArray(r13, 0, r12);
    L5:
        r11 = false;
        goto L6
    }

    public static ImmutableDoubleArray copyOf(DoubleStream r5) {
        double[] r10 = r5.toArray();
        if (r10.length != 0) goto L6;
        return f9319b;
    L6:
        return new ImmutableDoubleArray(r10, 0, r10.length);
    }
}
