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
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableIntArray implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableIntArray f9321b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f9322a;
    private final int[] array;
    private final int end;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        public AsList(ImmutableIntArray r5, d r10) {
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
            int r5 = ImmutableIntArray.access$100(this.parent);
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L22;
            Object r13 = r12.next();
            if ((r13 instanceof Integer) == false) goto L21;
            int r14 = r5 + 1;
            if (ImmutableIntArray.access$000(this.parent)[r5] != ((Integer) r13).intValue()) goto L21;
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
            if ((r5 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Integer) r5).intValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            if ((r5 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Integer) r5).intValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Integer> spliterator() {
            return ImmutableIntArray.access$500(this.parent);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int r5, int r10) {
            return this.parent.subArray(r5, r10).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int r5) {
            return Integer.valueOf(this.parent.get(r5));
        }
    }

    static {
        f9321b = new ImmutableIntArray(new int[0], 0, 0);
    }

    public /* synthetic */ ImmutableIntArray(int[] r5, int r10, int r11, d r12) {
        this(r5, r10, r11);
    }

    public static /* synthetic */ int[] access$000(ImmutableIntArray r5) {
        return r5.array;
    }

    public static /* synthetic */ int access$100(ImmutableIntArray r5) {
        return r5.f9322a;
    }

    public static /* synthetic */ ImmutableIntArray access$200() {
        return f9321b;
    }

    public static Spliterator.OfInt access$500(ImmutableIntArray r5) {
        int[] r10 = r5.array;
        int r11 = r5.end;
        return Spliterators.spliterator(r10, r5.f9322a, r11, 1040);
    }

    public static e builder(int r5) {
        if (r5 < 0) goto L4;
        boolean r10 = true;
    L5:
        b0.d(r5, "Invalid initialCapacity: %s", r10);
        return new e(r5);
    L4:
        r10 = false;
        goto L5
    }

    public static ImmutableIntArray copyOf(int[] r5) {
        if (r5.length != 0) goto L6;
        return f9321b;
    L6:
        return new ImmutableIntArray(Arrays.copyOf(r5, r5.length));
    }

    public static ImmutableIntArray of() {
        return f9321b;
    }

    public List<Integer> asList() {
        return new AsList(this, null);
    }

    public boolean contains(int r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableIntArray) == true) goto L8;
        return false;
    L8:
        ImmutableIntArray r11 = (ImmutableIntArray) r10;
        if (length() == r11.length()) goto L11;
        return false;
    L11:
        int r5 = 0;
    L13:
        if (r5 >= length()) goto L18;
        if (get(r5) != r11.get(r5)) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public void forEach(IntConsumer r5) {
        r5.getClass();
        int r10 = this.f9322a;
    L4:
        if (r10 >= this.end) goto L6;
        r5.accept(this.array[r10]);
        r10 = r10 + 1;
        goto L4
    }

    public int get(int r5) {
        b0.l(r5, length());
        return this.array[this.f9322a + r5];
    }

    public int hashCode() {
        int r5 = 1;
        int r10 = this.f9322a;
    L4:
        if (r10 >= this.end) goto L6;
        r5 = (r5 * 31) + this.array[r10];
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    public int indexOf(int r5) {
        int r10 = this.f9322a;
        int r11 = r10;
    L4:
        if (r11 >= this.end) goto L10;
        if (this.array[r11] == r5) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return r11 - r10;
    L10:
        return -1;
    }

    public boolean isEmpty() {
        if (this.end != this.f9322a) goto L5;
        return true;
    L5:
        return false;
    }

    public int lastIndexOf(int r5) {
        int r10 = this.end;
    L3:
        r10 = r10 - 1;
        int r11 = this.f9322a;
        if (r10 < r11) goto L10;
        if (this.array[r10] != r5) goto L3;
        return r10 - r11;
    L10:
        return -1;
    }

    public int length() {
        return this.end - this.f9322a;
    }

    public Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return f9321b;
    }

    public IntStream stream() {
        return Arrays.stream(this.array, this.f9322a, this.end);
    }

    public ImmutableIntArray subArray(int r5, int r10) {
        b0.p(r5, r10, length());
        if (r5 == r10) goto L7;
        int[] r11 = this.array;
        int r12 = this.f9322a;
        return new ImmutableIntArray(r11, r5 + r12, r12 + r10);
    L7:
        return f9321b;
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.f9322a, this.end);
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r5 = new StringBuilder(length() * 5);
        r5.append('[');
        int[] r10 = this.array;
        int r11 = this.f9322a;
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

    public ImmutableIntArray trimmed() {
        if (this.f9322a > 0) goto L7;
        if (this.end < this.array.length) goto L7;
        return this;
    L7:
        return new ImmutableIntArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableIntArray(int[] r5) {
        this(r5, 0, r5.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> r5) {
        if (r5.isEmpty() == false) goto L6;
        return f9321b;
    L6:
        if ((r5 instanceof Ints$IntArrayAsList) == false) goto L8;
        int[] r10 = ((Ints$IntArrayAsList) r5).toIntArray();
    L13:
        return new ImmutableIntArray(r10);
    L8:
        Object[] r11 = r5.toArray();
        int r12 = r11.length;
        int[] r13 = new int[r12];
        int r14 = 0;
    L9:
        if (r14 >= r12) goto L11;
        Object r15 = r11[r14];
        r15.getClass();
        r13[r14] = ((Number) r15).intValue();
        r14 = r14 + 1;
        goto L9
    L11:
        r10 = r13;
        goto L13
    }

    public static ImmutableIntArray of(int r5) {
        return new ImmutableIntArray(new int[]{r5}, 0, 1);
    }

    public ImmutableIntArray(int[] r5, int r10, int r11) {
        this.array = r5;
        this.f9322a = r10;
        this.end = r11;
    }

    public static e builder() {
        return new e(10);
    }

    public static ImmutableIntArray of(int r5, int r10) {
        return new ImmutableIntArray(new int[]{r5, r10}, 0, 2);
    }

    public static ImmutableIntArray of(int r5, int r10, int r11) {
        return new ImmutableIntArray(new int[]{r5, r10, r11}, 0, 3);
    }

    public static ImmutableIntArray of(int r5, int r10, int r11, int r12) {
        return new ImmutableIntArray(new int[]{r5, r10, r11, r12}, 0, 4);
    }

    public static ImmutableIntArray of(int r5, int r10, int r11, int r12, int r13) {
        return new ImmutableIntArray(new int[]{r5, r10, r11, r12, r13}, 0, 5);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> r5) {
        boolean r10 = r5 instanceof Collection;
        if (r10 == true) goto L5;
        e r11 = builder();
        r11.getClass();
        if (r10 == false) goto L12;
        Collection r12 = (Collection) r5;
        r11.a(r12.size());
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        Integer r14 = (Integer) r13.next();
        int[] r15 = r11.f9336a;
        int r16 = r11.f9337b;
        r11.f9337b = r16 + 1;
        r15[r16] = r14.intValue();
    L16:
        int r17 = r11.f9337b;
        if (r17 != 0) goto L20;
        return access$200();
    L20:
        return new ImmutableIntArray(r11.f9336a, 0, r17, null);
    L12:
        Iterator<Integer> r18 = r5.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        int r19 = r18.next().intValue();
        r11.a(1);
        int[] r20 = r11.f9336a;
        int r21 = r11.f9337b;
        r20[r21] = r19;
        r11.f9337b = r21 + 1;
        goto L14
    L5:
        return copyOf((Collection) r5);
    }

    public static ImmutableIntArray of(int r5, int r10, int r11, int r12, int r13, int r14) {
        return new ImmutableIntArray(new int[]{r5, r10, r11, r12, r13, r14}, 0, 6);
    }

    public static ImmutableIntArray of(int r5, int... r10) {
        if (r10.length > 2147483646) goto L5;
        boolean r11 = true;
    L6:
        b0.g("the total number of elements must fit in an int", r11);
        int r12 = r10.length + 1;
        int[] r13 = new int[r12];
        r13[0] = r5;
        System.arraycopy(r10, 0, r13, 1, r10.length);
        return new ImmutableIntArray(r13, 0, r12);
    L5:
        r11 = false;
        goto L6
    }

    public static ImmutableIntArray copyOf(IntStream r5) {
        int[] r10 = r5.toArray();
        if (r10.length != 0) goto L6;
        return f9321b;
    L6:
        return new ImmutableIntArray(r10, 0, r10.length);
    }
}
