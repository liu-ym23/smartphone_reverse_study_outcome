package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.4")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,583:1\n467#1,51:586\n467#1,51:637\n37#2,2:584\n26#3:688\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:586,51\n464#1:637,51\n47#1:584,2\n562#1:688\n*E\n"})
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = null;
    private static final int maxArraySize = 2147483639;
    private Object[] elementData;
    private int head;
    private int size;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int r10, int r11) {
            int r12 = r10 + (r10 >> 1);
            if ((r12 - r11) >= 0) goto L5;
            r12 = r11;
        L5:
            int r13 = ArrayDeque.maxArraySize;
            if ((r12 - ArrayDeque.maxArraySize) <= 0) goto L11;
            if (r11 <= ArrayDeque.maxArraySize) goto L10;
            r13 = Integer.MAX_VALUE;
        L10:
            return r13;
        L11:
            return r12;
        }
    }

    static {
        Companion = new Companion(null);
        emptyElementData = new Object[0];
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(int r10) {
        if (r10 != 0) goto L5;
        Object[] r11 = emptyElementData;
    L7:
        this.elementData = r11;
        return;
    L5:
        if (r10 <= 0) goto L10;
        r11 = new Object[r10];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r10);
    }

    public ArrayDeque(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        boolean r11 = false;
        Object[] r12 = r10.toArray(new Object[0]);
        this.elementData = r12;
        this.size = r12.length;
        if (r12.length != 0) goto L5;
        r11 = true;
    L5:
        if (r11 == false) goto L8;
        this.elementData = emptyElementData;
        return;
    }

    private final void copyCollectionElements(int r10, Collection<? extends E> r11) {
        Iterator<? extends E> r12 = r11.iterator();
        int r13 = this.elementData.length;
    L3:
        if (r10 >= r13) goto L7;
        if (r12.hasNext() == false) goto L7;
        this.elementData[r10] = r12.next();
        r10 = r10 + 1;
    L7:
        int r14 = 0;
        int r15 = this.head;
    L8:
        if (r14 >= r15) goto L12;
        if (r12.hasNext() == false) goto L12;
        this.elementData[r14] = r12.next();
        r14 = r14 + 1;
    L12:
        this.size = size() + r11.size();
    }

    private final void copyElements(int r10) {
        Object[] r11 = new Object[r10];
        Object[] r12 = this.elementData;
        ArraysKt.copyInto(r12, r11, 0, this.head, r12.length);
        Object[] r13 = this.elementData;
        int r14 = r13.length;
        int r15 = this.head;
        ArraysKt.copyInto(r13, r11, r14 - r15, 0, r15);
        this.head = 0;
        this.elementData = r11;
    }

    private final int decremented(int r10) {
        if (r10 != 0) goto L5;
        return ArraysKt.getLastIndex(this.elementData);
    L5:
        return r10 - 1;
    }

    private final void ensureCapacity(int r10) {
        if (r10 < 0) goto L13;
        Object[] r11 = this.elementData;
        if (r10 > r11.length) goto L7;
        return;
    L7:
        if (r11 != emptyElementData) goto L10;
        this.elementData = new Object[RangesKt.coerceAtLeast(r10, 10)];
        return;
    L10:
        copyElements(Companion.newCapacity$kotlin_stdlib(r11.length, r10));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean filterInPlace(Function1<? super E, Boolean> r12) {
        boolean r10 = false;
        r10 = false;
        int r11 = 0;
        r10 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r10;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r13 = true;
    L8:
        if (r13 == true) goto L37;
        int r14 = positiveMod(this.head + size());
        int r15 = this.head;
        if (r15 >= r14) goto L20;
        int r16 = r15;
    L13:
        if (r15 >= r14) goto L19;
        Object r17 = this.elementData[r15];
        if (r12.invoke(r17).booleanValue() == false) goto L17;
        this.elementData[r16] = r17;
        r16 = r16 + 1;
    L18:
        r15 = r15 + 1;
        goto L13
    L17:
        r10 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r16, r14);
    L35:
        if (r10 == false) goto L37;
        this.size = negativeMod(r16 - this.head);
        goto L37
    L20:
        int r18 = this.elementData.length;
        boolean r19 = false;
        int r20 = r15;
    L21:
        if (r15 >= r18) goto L27;
        Object[] r21 = this.elementData;
        Object r22 = r21[r15];
        r21[r15] = null;
        if (r12.invoke(r22).booleanValue() == false) goto L25;
        this.elementData[r20] = r22;
        r20 = r20 + 1;
    L26:
        r15 = r15 + 1;
        goto L21
    L25:
        r19 = true;
        goto L26
    L27:
        r16 = positiveMod(r20);
    L28:
        if (r11 >= r14) goto L34;
        Object[] r23 = this.elementData;
        Object r24 = r23[r11];
        r23[r11] = null;
        if (r12.invoke(r24).booleanValue() == false) goto L32;
        this.elementData[r16] = r24;
        r16 = incremented(r16);
    L33:
        r11 = r11 + 1;
        goto L28
    L32:
        r19 = true;
        goto L33
    L34:
        r10 = r19;
        goto L35
    L7:
        r13 = false;
        goto L8
    }

    private final int incremented(int r10) {
        if (r10 != ArraysKt.getLastIndex(this.elementData)) goto L6;
        return 0;
    L6:
        return r10 + 1;
    }

    @InlineOnly
    private final E internalGet(int r10) {
        return (E) this.elementData[r10];
    }

    @InlineOnly
    private final int internalIndex(int r10) {
        return positiveMod(this.head + r10);
    }

    private final int negativeMod(int r10) {
        if (r10 < 0) goto L4;
        return r10;
    L4:
        return r10 + this.elementData.length;
    }

    private final int positiveMod(int r10) {
        Object[] r11 = this.elementData;
        if (r10 >= r11.length) goto L5;
        return r10;
    L5:
        return r10 - r11.length;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, size());
        if (r10 != size()) goto L6;
        addLast(r11);
        return;
    L6:
        if (r10 != 0) goto L9;
        addFirst(r11);
        return;
    L9:
        ensureCapacity(size() + 1);
        int r12 = positiveMod(this.head + r10);
        if (r10 >= ((size() + 1) >> 1)) goto L16;
        int r13 = decremented(r12);
        int r14 = decremented(this.head);
        int r15 = this.head;
        if (r13 < r15) goto L14;
        Object[] r16 = this.elementData;
        r16[r14] = r16[r15];
        ArraysKt.copyInto(r16, r16, r15, r15 + 1, r13 + 1);
    L15:
        this.elementData[r13] = r11;
        this.head = r14;
    L21:
        this.size = size() + 1;
        return;
    L14:
        Object[] r17 = this.elementData;
        ArraysKt.copyInto(r17, r17, r15 - 1, r15, r17.length);
        Object[] r18 = this.elementData;
        r18[r18.length - 1] = r18[0];
        ArraysKt.copyInto(r18, r18, 0, 1, r13 + 1);
        goto L15
    L16:
        int r19 = positiveMod(this.head + size());
        Object[] r20 = this.elementData;
        if (r12 >= r19) goto L19;
        ArraysKt.copyInto(r20, r20, r12 + 1, r12, r19);
    L20:
        this.elementData[r12] = r11;
        goto L21
    L19:
        ArraysKt.copyInto(r20, r20, 1, 0, r19);
        Object[] r21 = this.elementData;
        r21[0] = r21[r21.length - 1];
        ArraysKt.copyInto(r21, r21, r12 + 1, r12, r21.length - 1);
        goto L20
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        addLast(r10);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends E> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, size());
        if (r11.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r10 == size()) goto L8;
        ensureCapacity(size() + r11.size());
        int r12 = positiveMod(this.head + size());
        int r13 = positiveMod(this.head + r10);
        int r14 = r11.size();
        if (r10 >= ((size() + 1) >> 1)) goto L24;
        int r15 = this.head;
        int r16 = r15 - r14;
        if (r13 < r15) goto L19;
        if (r16 < 0) goto L15;
        Object[] r17 = this.elementData;
        ArraysKt.copyInto(r17, r17, r16, r15, r13);
    L23:
        this.head = r16;
        copyCollectionElements(negativeMod(r13 - r14), r11);
    L38:
        return true;
    L15:
        Object[] r18 = this.elementData;
        r16 = r16 + r18.length;
        int r19 = r13 - r15;
        int r20 = r18.length - r16;
        if (r20 < r19) goto L18;
        ArraysKt.copyInto(r18, r18, r16, r15, r13);
        goto L23
    L18:
        ArraysKt.copyInto(r18, r18, r16, r15, r15 + r20);
        Object[] r21 = this.elementData;
        ArraysKt.copyInto(r21, r21, 0, this.head + r20, r13);
        goto L23
    L19:
        Object[] r22 = this.elementData;
        ArraysKt.copyInto(r22, r22, r16, r15, r22.length);
        Object[] r23 = this.elementData;
        if (r14 < r13) goto L22;
        ArraysKt.copyInto(r23, r23, r23.length - r14, 0, r13);
        goto L23
    L22:
        ArraysKt.copyInto(r23, r23, r23.length - r14, 0, r14);
        Object[] r24 = this.elementData;
        ArraysKt.copyInto(r24, r24, 0, r14, r13);
        goto L23
    L24:
        int r25 = r13 + r14;
        if (r13 >= r12) goto L33;
        int r26 = r14 + r12;
        Object[] r27 = this.elementData;
        if (r26 > r27.length) goto L30;
    L28:
        ArraysKt.copyInto(r27, r27, r25, r13, r12);
    L37:
        copyCollectionElements(r13, r11);
        goto L38
    L30:
        if (r25 < r27.length) goto L32;
        r25 = r25 - r27.length;
        goto L28
    L32:
        int r28 = r12 - (r26 - r27.length);
        ArraysKt.copyInto(r27, r27, 0, r28, r12);
        Object[] r29 = this.elementData;
        ArraysKt.copyInto(r29, r29, r25, r13, r28);
        goto L37
    L33:
        Object[] r30 = this.elementData;
        ArraysKt.copyInto(r30, r30, r14, 0, r12);
        Object[] r31 = this.elementData;
        if (r25 < r31.length) goto L36;
        ArraysKt.copyInto(r31, r31, r25 - r31.length, r13, r31.length);
        goto L37
    L36:
        ArraysKt.copyInto(r31, r31, 0, r31.length - r14, r31.length);
        Object[] r32 = this.elementData;
        ArraysKt.copyInto(r32, r32, r25, r13, r32.length - r14);
        goto L37
    L8:
        return addAll(r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        ensureCapacity(size() + r10.size());
        copyCollectionElements(positiveMod(this.head + size()), r10);
        return true;
    }

    public final void addFirst(E r10) {
        ensureCapacity(size() + 1);
        int r11 = decremented(this.head);
        this.head = r11;
        this.elementData[r11] = r10;
        this.size = size() + 1;
    }

    public final void addLast(E r10) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = r10;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r10 = positiveMod(this.head + size());
        int r11 = this.head;
        if (r11 >= r10) goto L6;
        ArraysKt.fill(this.elementData, null, r11, r10);
    L8:
        this.head = 0;
        this.size = 0;
        return;
    L6:
        if ((!isEmpty()) == false) goto L8;
        Object[] r12 = this.elementData;
        ArraysKt.fill(r12, null, this.head, r12.length);
        ArraysKt.fill(this.elementData, null, 0, r10);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r10) {
        if (indexOf(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final E first() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[this.head];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, size());
        return (E) this.elementData[positiveMod(this.head + r10)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        int r11 = positiveMod(this.head + size());
        int r12 = this.head;
        if (r12 >= r11) goto L10;
    L4:
        if (r12 >= r11) goto L31;
        if (Intrinsics.areEqual(r10, this.elementData[r12]) == true) goto L8;
        r12 = r12 + 1;
    L8:
        return r12 - this.head;
    L31:
        return -1;
    L10:
        if (r12 < r11) goto L23;
        int r13 = this.elementData.length;
    L12:
        if (r12 >= r13) goto L17;
        if (Intrinsics.areEqual(r10, this.elementData[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L12
    L17:
        int r14 = 0;
    L18:
        if (r14 >= r11) goto L32;
        if (Intrinsics.areEqual(r10, this.elementData[r14]) == true) goto L21;
        r14 = r14 + 1;
        goto L18
    L21:
        r12 = r14 + this.elementData.length;
        goto L8
    L32:
        return -1;
    L23:
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "structure");
        int r11 = positiveMod(this.head + size());
        if (isEmpty() == true) goto L8;
        int r12 = this.head;
        if (r12 < r11) goto L8;
        int r13 = r12 - this.elementData.length;
    L9:
        r10.invoke(Integer.valueOf(r13), toArray());
        return;
    L8:
        r13 = this.head;
        goto L9
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final E last() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        int r11 = positiveMod(this.head + size());
        int r12 = this.head;
        if (r12 >= r11) goto L12;
        int r13 = r11 - 1;
        if (r12 <= r13) goto L7;
    L26:
        return -1;
    L7:
        if (Intrinsics.areEqual(r10, this.elementData[r13]) == true) goto L9;
        if (r13 == r12) goto L26;
        r13 = r13 - 1;
    L9:
        return r13 - this.head;
    L12:
        if (r12 <= r11) goto L26;
        int r14 = r11 - 1;
    L14:
        if ((-1) >= r14) goto L19;
        if (Intrinsics.areEqual(r10, this.elementData[r14]) == true) goto L17;
        r14 = r14 - 1;
        goto L14
    L17:
        r13 = r14 + this.elementData.length;
        goto L9
    L19:
        r13 = ArraysKt.getLastIndex(this.elementData);
        int r15 = this.head;
        if (r15 > r13) goto L26;
    L22:
        if (Intrinsics.areEqual(r10, this.elementData[r13]) == true) goto L9;
        if (r13 == r15) goto L26;
        r13 = r13 - 1;
        goto L22
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        int r11 = indexOf(r10);
        if (r11 != (-1)) goto L6;
        return false;
    L6:
        remove(r11);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r10 = false;
        r10 = false;
        int r11 = 0;
        r10 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r10;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r13 = true;
    L8:
        if (r13 == true) goto L37;
        int r14 = positiveMod(this.head + size());
        int r15 = this.head;
        if (r15 >= r14) goto L20;
        int r16 = r15;
    L13:
        if (r15 >= r14) goto L19;
        Object r17 = this.elementData[r15];
        if ((!r12.contains(r17)) == false) goto L17;
        this.elementData[r16] = r17;
        r16 = r16 + 1;
    L18:
        r15 = r15 + 1;
        goto L13
    L17:
        r10 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r16, r14);
    L35:
        if (r10 == false) goto L37;
        this.size = negativeMod(r16 - this.head);
        goto L37
    L20:
        int r18 = this.elementData.length;
        boolean r19 = false;
        int r20 = r15;
    L21:
        if (r15 >= r18) goto L27;
        Object[] r21 = this.elementData;
        Object r22 = r21[r15];
        r21[r15] = null;
        if ((!r12.contains(r22)) == false) goto L25;
        this.elementData[r20] = r22;
        r20 = r20 + 1;
    L26:
        r15 = r15 + 1;
        goto L21
    L25:
        r19 = true;
        goto L26
    L27:
        r16 = positiveMod(r20);
    L28:
        if (r11 >= r14) goto L34;
        Object[] r23 = this.elementData;
        Object r24 = r23[r11];
        r23[r11] = null;
        if ((!r12.contains(r24)) == false) goto L32;
        this.elementData[r16] = r24;
        r16 = incremented(r16);
    L33:
        r11 = r11 + 1;
        goto L28
    L32:
        r19 = true;
        goto L33
    L34:
        r10 = r19;
        goto L35
    L7:
        r13 = false;
        goto L8
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, size());
        if (r10 == CollectionsKt.getLastIndex(this)) goto L5;
        if (r10 == 0) goto L8;
        int r11 = positiveMod(this.head + r10);
        E r12 = (E) this.elementData[r11];
        if (r10 >= (size() >> 1)) goto L16;
        int r13 = this.head;
        if (r11 < r13) goto L14;
        Object[] r14 = this.elementData;
        ArraysKt.copyInto(r14, r14, r13 + 1, r13, r11);
    L15:
        Object[] r15 = this.elementData;
        int r16 = this.head;
        r15[r16] = null;
        this.head = incremented(r16);
    L21:
        this.size = size() - 1;
        return r12;
    L14:
        Object[] r17 = this.elementData;
        ArraysKt.copyInto(r17, r17, 1, 0, r11);
        Object[] r18 = this.elementData;
        r18[0] = r18[r18.length - 1];
        int r19 = this.head;
        ArraysKt.copyInto(r18, r18, r19 + 1, r19, r18.length - 1);
        goto L15
    L16:
        int r20 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] r21 = this.elementData;
        if (r11 > r20) goto L19;
        ArraysKt.copyInto(r21, r21, r11, r11 + 1, r20 + 1);
    L20:
        this.elementData[r20] = null;
        goto L21
    L19:
        ArraysKt.copyInto(r21, r21, r11, r11 + 1, r21.length);
        Object[] r22 = this.elementData;
        r22[r22.length - 1] = r22[0];
        ArraysKt.copyInto(r22, r22, 0, 1, r20 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r10 = this.elementData;
        int r11 = this.head;
        E r12 = (E) r10[r11];
        r10[r11] = null;
        this.head = incremented(r11);
        this.size = size() - 1;
        return r12;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty() == true) goto L7;
        int r10 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] r11 = this.elementData;
        E r12 = (E) r11[r10];
        r11[r10] = null;
        this.size = size() - 1;
        return r12;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeLast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r10 = false;
        r10 = false;
        int r11 = 0;
        r10 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r10;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r13 = true;
    L8:
        if (r13 == true) goto L37;
        int r14 = positiveMod(this.head + size());
        int r15 = this.head;
        if (r15 >= r14) goto L20;
        int r16 = r15;
    L13:
        if (r15 >= r14) goto L19;
        Object r17 = this.elementData[r15];
        if (r12.contains(r17) == false) goto L17;
        this.elementData[r16] = r17;
        r16 = r16 + 1;
    L18:
        r15 = r15 + 1;
        goto L13
    L17:
        r10 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r16, r14);
    L35:
        if (r10 == false) goto L37;
        this.size = negativeMod(r16 - this.head);
        goto L37
    L20:
        int r18 = this.elementData.length;
        boolean r19 = false;
        int r20 = r15;
    L21:
        if (r15 >= r18) goto L27;
        Object[] r21 = this.elementData;
        Object r22 = r21[r15];
        r21[r15] = null;
        if (r12.contains(r22) == false) goto L25;
        this.elementData[r20] = r22;
        r20 = r20 + 1;
    L26:
        r15 = r15 + 1;
        goto L21
    L25:
        r19 = true;
        goto L26
    L27:
        r16 = positiveMod(r20);
    L28:
        if (r11 >= r14) goto L34;
        Object[] r23 = this.elementData;
        Object r24 = r23[r11];
        r23[r11] = null;
        if (r12.contains(r24) == false) goto L32;
        this.elementData[r16] = r24;
        r16 = incremented(r16);
    L33:
        r11 = r11 + 1;
        goto L28
    L32:
        r19 = true;
        goto L33
    L34:
        r10 = r19;
        goto L35
    L7:
        r13 = false;
        goto L8
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, size());
        int r12 = positiveMod(this.head + r10);
        Object[] r13 = this.elementData;
        E r14 = (E) r13[r12];
        r13[r12] = r11;
        return r14;
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return (T[]) toArray(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        if (r10.length >= size()) goto L6;
        r10 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(r10, size());
    L6:
        int r11 = positiveMod(this.head + size());
        int r12 = this.head;
        if (r12 >= r11) goto L10;
        ArraysKt.copyInto$default(this.elementData, r10, 0, r12, r11, 2, null);
    L13:
        if (r10.length <= size()) goto L15;
        r10[size()] = null;
    L15:
        return r10;
    L10:
        if ((!isEmpty()) == false) goto L13;
        Object[] r13 = this.elementData;
        ArraysKt.copyInto(r13, r10, 0, this.head, r13.length);
        Object[] r14 = this.elementData;
        ArraysKt.copyInto(r14, r10, r14.length - this.head, 0, r11);
        goto L13
    }
}
