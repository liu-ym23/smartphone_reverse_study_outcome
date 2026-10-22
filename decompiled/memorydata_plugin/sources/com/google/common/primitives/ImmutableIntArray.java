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
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = null;
    private final int[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableIntArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AsList extends AbstractList<Integer> implements Serializable, RandomAccess {
        private final ImmutableIntArray parent;

        private AsList(ImmutableIntArray r1) {
            this.parent = r1;
        }

        /* synthetic */ AsList(ImmutableIntArray r1, AnonymousClass1 r2) {
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
        public boolean equals(Object r7) {
            if (ZeusTransformUtils.instanceOf(r7, AsList.class) == false) goto L7;
            AsList r8 = (AsList) ZeusTransformUtils.preCheckCast(r7, AsList.class, "com.obric.memorydata.plugin");
            return this.parent.equals(r8.parent);
        L7:
            if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L9;
            return false;
        L9:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
            if (size() == r9.size()) goto L12;
            return false;
        L12:
            int r0 = ImmutableIntArray.access$100(this.parent);
            Iterator r10 = r9.iterator();
        L14:
            if (r10.hasNext() == false) goto L22;
            Object r3 = r10.next();
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L21;
            int r5 = r0 + 1;
            if (ImmutableIntArray.access$000(this.parent)[r0] != ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue()) goto L21;
            r0 = r5;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int r1) {
            return Integer.valueOf(this.parent.get(r1));
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
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Integer.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue());
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
        public List<Integer> subList(int r1, int r2) {
            return this.parent.subArray(r1, r2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f4759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4760b;

        a(int r2) {
            this.f4760b = 0;
            this.f4759a = new int[r2];
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

        private void b(int r3) {
            int r0 = this.f4760b + r3;
            int[] r4 = this.f4759a;
            if (r0 <= r4.length) goto L6;
            this.f4759a = Arrays.copyOf(r4, a(r4.length, r0));
            return;
        }

        public a a(int r4) {
            b(1);
            int[] r1 = this.f4759a;
            int r2 = this.f4760b;
            r1[r2] = r4;
            this.f4760b = r2 + 1;
            return this;
        }

        public a a(Iterable<Integer> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
            Iterator r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            a(((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
            goto L8
        L10:
            return this;
        L5:
            return a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        }

        public a a(Collection<Integer> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            b(r7.size());
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.memorydata.plugin");
            int[] r2 = this.f4759a;
            int r3 = this.f4760b;
            this.f4760b = r3 + 1;
            r2[r3] = r0.intValue();
            goto L4
        L6:
            return this;
        }

        public ImmutableIntArray a() {
            if (this.f4760b != 0) goto L6;
            return ImmutableIntArray.access$200();
        L6:
            return new ImmutableIntArray(this.f4759a, 0, this.f4760b, null);
        }
    }

    static {
        EMPTY = new ImmutableIntArray(new int[0]);
    }

    private ImmutableIntArray(int[] r3) {
        this(r3, 0, r3.length);
    }

    private ImmutableIntArray(int[] r1, int r2, int r3) {
        this.array = r1;
        this.start = r2;
        this.end = r3;
    }

    /* synthetic */ ImmutableIntArray(int[] r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ int[] access$000(ImmutableIntArray r0) {
        return r0.array;
    }

    static /* synthetic */ int access$100(ImmutableIntArray r0) {
        return r0.start;
    }

    static /* synthetic */ ImmutableIntArray access$200() {
        return EMPTY;
    }

    static /* synthetic */ Spliterator.OfInt access$500(ImmutableIntArray r0) {
        return r0.spliterator();
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

    public static ImmutableIntArray copyOf(Iterable<Integer> r2) {
        Iterable<Integer> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L7;
        return copyOf((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
    L7:
        return builder().a(r3).a();
    }

    public static ImmutableIntArray copyOf(Collection<Integer> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(Ints.a(r3));
    }

    public static ImmutableIntArray copyOf(IntStream r2) {
        int[] r3 = ((IntStream) ZeusTransformUtils.wrapperContextForParams(r2, IntStream.class, "com.obric.memorydata.plugin")).toArray();
        if (r3.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(r3);
    }

    public static ImmutableIntArray copyOf(int[] r2) {
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(Arrays.copyOf(r2, r2.length));
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public static ImmutableIntArray of(int r3) {
        return new ImmutableIntArray(new int[]{r3});
    }

    public static ImmutableIntArray of(int r3, int r4) {
        return new ImmutableIntArray(new int[]{r3, r4});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5) {
        return new ImmutableIntArray(new int[]{r3, r4, r5});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6, int r7) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6, r7});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6, int r7, int r8) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6, r7, r8});
    }

    public static ImmutableIntArray of(int r4, int... r5) {
        if (r5.length > 2147483646) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "the total number of elements must fit in an int");
        int[] r1 = new int[r5.length + 1];
        r1[0] = r4;
        System.arraycopy(r5, 0, r1, 1, r5.length);
        return new ImmutableIntArray(r1);
    L5:
        r0 = false;
        goto L6
    }

    private Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Integer> asList() {
        return new AsList(this, null);
    }

    public boolean contains(int r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ImmutableIntArray.class) == true) goto L8;
        return false;
    L8:
        ImmutableIntArray r7 = (ImmutableIntArray) ZeusTransformUtils.preCheckCast(r6, ImmutableIntArray.class, "com.obric.memorydata.plugin");
        if (length() == r7.length()) goto L11;
        return false;
    L11:
        int r0 = 0;
    L13:
        if (r0 >= length()) goto L18;
        if (get(r0) != r7.get(r0)) goto L16;
        r0 = r0 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public void forEach(IntConsumer r3) {
        IntConsumer r4 = (IntConsumer) ZeusTransformUtils.wrapperContextForParams(r3, IntConsumer.class, "com.obric.memorydata.plugin");
        n.a(r4);
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L6;
        r4.accept(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public int get(int r2) {
        n.a(r2, length());
        return this.array[this.start + r2];
    }

    public int hashCode() {
        int r0 = this.start;
        int r1 = 1;
    L4:
        if (r0 >= this.end) goto L6;
        r1 = (r1 * 31) + Ints.a(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public int indexOf(int r3) {
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L10;
        if (this.array[r0] == r3) goto L8;
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

    public int lastIndexOf(int r4) {
        int r0 = this.end;
    L3:
        r0 = r0 - 1;
        int r1 = this.start;
        if (r0 < r1) goto L10;
        if (this.array[r0] != r4) goto L3;
        return r0 - r1;
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

    public IntStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableIntArray subArray(int r3, int r4) {
        n.a(r3, r4, length());
        if (r3 == r4) goto L7;
        int[] r1 = this.array;
        int r2 = this.start;
        return new ImmutableIntArray(r1, r3 + r2, r2 + r4);
    L7:
        return EMPTY;
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableIntArray(toArray());
    }

    Object writeReplace() {
        return trimmed();
    }
}
