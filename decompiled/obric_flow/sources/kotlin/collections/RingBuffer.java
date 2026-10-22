package kotlin.collections;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n204#1:208\n204#1:209\n204#1:210\n1#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:208\n175#1:209\n188#1:210\n*E\n"})
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "buffer");
        this.buffer = r5;
        if (r10 < 0) goto L11;
        if (r10 > r5.length) goto L8;
        this.capacity = r5.length;
        this.size = r10;
        return;
    L8:
        StringBuilder r11 = j0.s(r10, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
        r11.append(r5.length);
        throw new IllegalArgumentException(r11.toString().toString());
    L11:
        throw new IllegalArgumentException(j0.g(r10, "ring buffer filled size should not be negative but it is ").toString());
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(RingBuffer r5) {
        return r5.buffer;
    }

    public static final /* synthetic */ int access$getCapacity$p(RingBuffer r5) {
        return r5.capacity;
    }

    public static final /* synthetic */ int access$getStartIndex$p(RingBuffer r5) {
        return r5.startIndex;
    }

    private final int forward(int r5, int r10) {
        return (r5 + r10) % access$getCapacity$p(this);
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T r5) {
        if (isFull() == true) goto L7;
        Object[] r10 = this.buffer;
        int r11 = this.startIndex;
        r10[(size() + r11) % access$getCapacity$p(this)] = r5;
        this.size = size() + 1;
        return;
    L7:
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int r5) {
        int r10 = this.capacity;
        int r11 = RangesKt.coerceAtMost((r10 + (r10 >> 1)) + 1, r5);
        if (this.startIndex != 0) goto L5;
        Object[] r12 = Arrays.copyOf(this.buffer, r11);
    L7:
        return new RingBuffer(r12, size());
    L5:
        r12 = toArray(new Object[r11]);
        goto L7
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r5) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, size());
        return (T) this.buffer[(this.startIndex + r5) % access$getCapacity$p(this)];
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

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public final void removeFirst(int r10) {
        if (r10 < 0) goto L15;
        if (r10 > size()) goto L12;
        if (r10 <= 0) goto L16;
        int r5 = this.startIndex;
        int r11 = (r5 + r10) % access$getCapacity$p(this);
        if (r5 <= r11) goto L9;
        ArraysKt___ArraysJvmKt.fill(this.buffer, null, r5, this.capacity);
        ArraysKt___ArraysJvmKt.fill(this.buffer, null, 0, r11);
    L10:
        this.startIndex = r11;
        this.size = size() - r10;
        return;
    L9:
        ArraysKt___ArraysJvmKt.fill(this.buffer, null, r5, r11);
        goto L10
    L16:
        return;
    L12:
        StringBuilder r12 = j0.s(r10, "n shouldn't be greater than the buffer size: n = ", ", size = ");
        r12.append(size());
        throw new IllegalArgumentException(r12.toString().toString());
    L15:
        throw new IllegalArgumentException(j0.g(r10, "n shouldn't be negative but it is ").toString());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        int r5 = r10.length;
        Object[] r11 = r10;
        if (r5 >= size()) goto L5;
        r11 = (T[]) Arrays.copyOf(r10, size());
    L5:
        int r12 = size();
        int r13 = this.startIndex;
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r15 >= r12) goto L10;
        if (r13 >= this.capacity) goto L10;
        r11[r15] = this.buffer[r13];
        r15 = r15 + 1;
        r13 = r13 + 1;
    L10:
        if (r15 >= r12) goto L13;
        r11[r15] = this.buffer[r14];
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L10
    L13:
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(r12, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public RingBuffer(int r5) {
        this(new Object[r5], 0);
    }
}
