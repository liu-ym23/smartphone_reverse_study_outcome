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
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = null;
    private final long[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableLongArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AsList extends AbstractList<Long> implements Serializable, RandomAccess {
        private final ImmutableLongArray parent;

        private AsList(ImmutableLongArray r1) {
            this.parent = r1;
        }

        /* synthetic */ AsList(ImmutableLongArray r1, AnonymousClass1 r2) {
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
            int r0 = ImmutableLongArray.access$100(this.parent);
            Iterator r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L22;
            Object r3 = r12.next();
            if (ZeusTransformUtils.instanceOf(r3, Long.class) == false) goto L21;
            int r5 = r0 + 1;
            if (ImmutableLongArray.access$000(this.parent)[r0] != ((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue()) goto L21;
            r0 = r5;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r1) {
            return Long.valueOf(this.parent.get(r1));
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
            if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Long> spliterator() {
            return ImmutableLongArray.access$500(this.parent);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r1, int r2) {
            return this.parent.subArray(r1, r2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long[] f4761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4762b;

        a(int r2) {
            this.f4762b = 0;
            this.f4761a = new long[r2];
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
            int r0 = this.f4762b + r3;
            long[] r4 = this.f4761a;
            if (r0 <= r4.length) goto L6;
            this.f4761a = Arrays.copyOf(r4, a(r4.length, r0));
            return;
        }

        public a a(long r4) {
            a(1);
            long[] r1 = this.f4761a;
            int r2 = this.f4762b;
            r1[r2] = r4;
            this.f4762b = r2 + 1;
            return this;
        }

        public a a(Iterable<Long> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
            Iterator r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            a(((Long) ZeusTransformUtils.preCheckCast(r7.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
            goto L8
        L10:
            return this;
        L5:
            return a((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        }

        public a a(Collection<Long> r7) {
            Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
            a(r8.size());
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            Long r0 = (Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin");
            long[] r2 = this.f4761a;
            int r3 = this.f4762b;
            this.f4762b = r3 + 1;
            r2[r3] = r0.longValue();
            goto L4
        L6:
            return this;
        }

        public ImmutableLongArray a() {
            if (this.f4762b != 0) goto L6;
            return ImmutableLongArray.access$200();
        L6:
            return new ImmutableLongArray(this.f4761a, 0, this.f4762b, null);
        }
    }

    static {
        EMPTY = new ImmutableLongArray(new long[0]);
    }

    private ImmutableLongArray(long[] r3) {
        this(r3, 0, r3.length);
    }

    private ImmutableLongArray(long[] r1, int r2, int r3) {
        this.array = r1;
        this.start = r2;
        this.end = r3;
    }

    /* synthetic */ ImmutableLongArray(long[] r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ long[] access$000(ImmutableLongArray r0) {
        return r0.array;
    }

    static /* synthetic */ int access$100(ImmutableLongArray r0) {
        return r0.start;
    }

    static /* synthetic */ ImmutableLongArray access$200() {
        return EMPTY;
    }

    static /* synthetic */ Spliterator.OfLong access$500(ImmutableLongArray r0) {
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

    public static ImmutableLongArray copyOf(Iterable<Long> r2) {
        Iterable<Long> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L7;
        return copyOf((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
    L7:
        return builder().a(r3).a();
    }

    public static ImmutableLongArray copyOf(Collection<Long> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableLongArray(Longs.a(r3));
    }

    public static ImmutableLongArray copyOf(LongStream r2) {
        long[] r3 = ((LongStream) ZeusTransformUtils.wrapperContextForParams(r2, LongStream.class, "com.obric.memorydata.plugin")).toArray();
        if (r3.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableLongArray(r3);
    }

    public static ImmutableLongArray copyOf(long[] r2) {
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableLongArray(Arrays.copyOf(r2, r2.length));
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public static ImmutableLongArray of(long r3) {
        return new ImmutableLongArray(new long[]{r3});
    }

    public static ImmutableLongArray of(long r3, long r5) {
        return new ImmutableLongArray(new long[]{r3, r5});
    }

    public static ImmutableLongArray of(long r3, long r5, long r7) {
        return new ImmutableLongArray(new long[]{r3, r5, r7});
    }

    public static ImmutableLongArray of(long r3, long r5, long r7, long r9) {
        return new ImmutableLongArray(new long[]{r3, r5, r7, r9});
    }

    public static ImmutableLongArray of(long r3, long r5, long r7, long r9, long r11) {
        return new ImmutableLongArray(new long[]{r3, r5, r7, r9, r11});
    }

    public static ImmutableLongArray of(long r3, long r5, long r7, long r9, long r11, long r13) {
        return new ImmutableLongArray(new long[]{r3, r5, r7, r9, r11, r13});
    }

    public static ImmutableLongArray of(long r4, long... r6) {
        if (r6.length > 2147483646) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "the total number of elements must fit in an int");
        long[] r1 = new long[r6.length + 1];
        r1[0] = r4;
        System.arraycopy(r6, 0, r1, 1, r6.length);
        return new ImmutableLongArray(r1);
    L5:
        r0 = false;
        goto L6
    }

    private Spliterator.OfLong spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Long> asList() {
        return new AsList(this, null);
    }

    public boolean contains(long r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ImmutableLongArray.class) == true) goto L8;
        return false;
    L8:
        ImmutableLongArray r10 = (ImmutableLongArray) ZeusTransformUtils.preCheckCast(r9, ImmutableLongArray.class, "com.obric.memorydata.plugin");
        if (length() == r10.length()) goto L11;
        return false;
    L11:
        int r0 = 0;
    L13:
        if (r0 >= length()) goto L18;
        if (get(r0) != r10.get(r0)) goto L16;
        r0 = r0 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public void forEach(LongConsumer r4) {
        LongConsumer r5 = (LongConsumer) ZeusTransformUtils.wrapperContextForParams(r4, LongConsumer.class, "com.obric.memorydata.plugin");
        n.a(r5);
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L6;
        r5.accept(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public long get(int r2) {
        n.a(r2, length());
        return this.array[this.start + r2];
    }

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

    public int indexOf(long r4) {
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L10;
        if (this.array[r0] == r4) goto L8;
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

    public int lastIndexOf(long r5) {
        int r0 = this.end;
    L3:
        r0 = r0 - 1;
        int r1 = this.start;
        if (r0 < r1) goto L10;
        if (this.array[r0] != r5) goto L3;
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

    public LongStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableLongArray subArray(int r3, int r4) {
        n.a(r3, r4, length());
        if (r3 == r4) goto L7;
        long[] r1 = this.array;
        int r2 = this.start;
        return new ImmutableLongArray(r1, r3 + r2, r2 + r4);
    L7:
        return EMPTY;
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableLongArray(toArray());
    }

    Object writeReplace() {
        return trimmed();
    }
}
