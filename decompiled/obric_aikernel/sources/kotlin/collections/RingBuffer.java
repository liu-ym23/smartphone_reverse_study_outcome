package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n205#1:209\n205#1:210\n205#1:211\n1#2:208\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:209\n176#1:210\n189#1:211\n*E\n"})
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(int r10) {
        this(new Object[r10], 0);
    }

    public RingBuffer(Object[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        this.buffer = r10;
        boolean r12 = true;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L17;
        if (r11 <= r10.length) goto L11;
        r12 = false;
    L11:
        if (r12 == false) goto L15;
        this.capacity = r10.length;
        this.size = r11;
        return;
    L15:
        throw new IllegalArgumentException(("ring buffer filled size: " + r11 + " cannot be larger than the buffer size: " + r10.length).toString());
    L17:
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + r11).toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(RingBuffer r10) {
        return r10.buffer;
    }

    public static final /* synthetic */ int access$getCapacity$p(RingBuffer r10) {
        return r10.capacity;
    }

    public static final /* synthetic */ int access$getStartIndex$p(RingBuffer r10) {
        return r10.startIndex;
    }

    private final int forward(int r10, int r11) {
        return (r10 + r11) % access$getCapacity$p(this);
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T r10) {
        if (isFull() == true) goto L7;
        this.buffer[(this.startIndex + size()) % access$getCapacity$p(this)] = r10;
        this.size = size() + 1;
        return;
    L7:
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int r10) {
        int r11 = this.capacity;
        int r12 = RangesKt.coerceAtMost((r11 + (r11 >> 1)) + 1, r10);
        if (this.startIndex != 0) goto L5;
        Object[] r13 = Arrays.copyOf(this.buffer, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
    L7:
        return new RingBuffer(r13, size());
    L5:
        r13 = toArray(new Object[r12]);
        goto L7
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, size());
        return (T) this.buffer[(this.startIndex + r10) % access$getCapacity$p(this)];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        if (size() != this.capacity) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public final void removeFirst(int r10) {
        boolean r11 = true;
        if (r10 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L22;
        if (r10 <= size()) goto L11;
        r11 = false;
    L11:
        if (r11 == false) goto L20;
        if (r10 <= 0) goto L23;
        int r13 = this.startIndex;
        int r14 = (r13 + r10) % access$getCapacity$p(this);
        if (r13 <= r14) goto L16;
        ArraysKt.fill(this.buffer, null, r13, this.capacity);
        ArraysKt.fill(this.buffer, null, 0, r14);
    L17:
        this.startIndex = r14;
        this.size = size() - r10;
        return;
    L16:
        ArraysKt.fill(this.buffer, null, r13, r14);
        goto L17
    L23:
        return;
    L20:
        throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + r10 + ", size = " + size()).toString());
    L22:
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + r10).toString());
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        if (r10.length >= size()) goto L5;
        r10 = (T[]) Arrays.copyOf(r10, size());
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(this, newSize)");
    L5:
        int r11 = size();
        int r12 = this.startIndex;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L10;
        if (r12 >= this.capacity) goto L10;
        r10[r14] = this.buffer[r12];
        r14 = r14 + 1;
        r12 = r12 + 1;
    L10:
        if (r14 >= r11) goto L13;
        r10[r14] = this.buffer[r13];
        r14 = r14 + 1;
        r13 = r13 + 1;
        goto L10
    L13:
        if (r10.length <= size()) goto L15;
        r10[size()] = null;
    L15:
        return r10;
    }
}
