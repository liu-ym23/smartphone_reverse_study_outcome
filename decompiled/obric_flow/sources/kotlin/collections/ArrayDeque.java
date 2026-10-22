package kotlin.collections;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u0000 [*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020\u0017H\u0002J\u0015\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010D\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010G\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010I\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0018\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0014J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0016\u0010O\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010P\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010QJ\u001d\u0010R\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bSJ\u0017\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bU\u0010VJ)\u0010T\u001a\b\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\b\u0001\u0010W2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0\u000bH\u0000¢\u0006\u0004\bU\u0010YJ\u0015\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010VJ'\u0010Z\u001a\b\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\b\u0001\u0010W2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0\u000bH\u0016¢\u0006\u0002\u0010YR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\\"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "positiveMod", "registerModification", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,660:1\n476#1,53:663\n476#1,53:716\n37#2,2:661\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n471#1:663,53\n473#1:716,53\n46#1:661,2\n*E\n"})
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = null;
    private Object[] elementData;
    private int head;
    private int size;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        emptyElementData = new Object[0];
    }

    public ArrayDeque(int r5) {
        if (r5 != 0) goto L5;
        Object[] r10 = emptyElementData;
    L7:
        this.elementData = r10;
        return;
    L5:
        if (r5 <= 0) goto L10;
        r10 = new Object[r5];
        goto L7
    L10:
        throw new IllegalArgumentException(j0.g(r5, "Illegal Capacity: "));
    }

    private final void copyCollectionElements(int r5, Collection<? extends E> r10) {
        Iterator<? extends E> r11 = r10.iterator();
        int r12 = this.elementData.length;
    L3:
        if (r5 >= r12) goto L7;
        if (r11.hasNext() == false) goto L7;
        this.elementData[r5] = r11.next();
        r5 = r5 + 1;
    L7:
        int r13 = this.head;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L12;
        if (r11.hasNext() == false) goto L12;
        this.elementData[r14] = r11.next();
        r14 = r14 + 1;
    L12:
        int r15 = size();
        this.size = r10.size() + r15;
    }

    private final void copyElements(int r5) {
        Object[] r10 = new Object[r5];
        Object[] r11 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r11, r10, 0, this.head, r11.length);
        Object[] r12 = this.elementData;
        int r13 = r12.length;
        int r14 = this.head;
        ArraysKt___ArraysJvmKt.copyInto(r12, r10, r13 - r14, 0, r14);
        this.head = 0;
        this.elementData = r10;
    }

    private final int decremented(int r5) {
        if (r5 != 0) goto L5;
        return ArraysKt___ArraysKt.getLastIndex(this.elementData);
    L5:
        return r5 - 1;
    }

    private final void ensureCapacity(int r5) {
        if (r5 < 0) goto L13;
        Object[] r10 = this.elementData;
        if (r5 > r10.length) goto L7;
        return;
    L7:
        if (r10 != emptyElementData) goto L10;
        this.elementData = new Object[RangesKt.coerceAtLeast(r5, 10)];
        return;
    L10:
        copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(r10.length, r5));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> r12) {
        boolean r5 = false;
        r5 = false;
        int r10 = 0;
        r5 = false;
        if (isEmpty() == false) goto L5;
    L34:
        return r5;
    L5:
        if (this.elementData.length == 0) goto L34;
        int r11 = positiveMod(size() + this.head);
        int r13 = this.head;
        if (r13 >= r11) goto L17;
        int r14 = r13;
    L10:
        if (r13 >= r11) goto L16;
        Object r15 = this.elementData[r13];
        if (r12.invoke(r15).booleanValue() == false) goto L14;
        this.elementData[r14] = r15;
        r14 = r14 + 1;
    L15:
        r13 = r13 + 1;
        goto L10
    L14:
        r5 = true;
        goto L15
    L16:
        ArraysKt___ArraysJvmKt.fill(this.elementData, null, r14, r11);
    L32:
        if (r5 == false) goto L34;
        registerModification();
        this.size = negativeMod(r14 - this.head);
        goto L34
    L17:
        int r16 = this.elementData.length;
        boolean r17 = false;
        int r18 = r13;
    L18:
        if (r13 >= r16) goto L24;
        Object[] r19 = this.elementData;
        Object r20 = r19[r13];
        r19[r13] = null;
        if (r12.invoke(r20).booleanValue() == false) goto L22;
        this.elementData[r18] = r20;
        r18 = r18 + 1;
    L23:
        r13 = r13 + 1;
        goto L18
    L22:
        r17 = true;
        goto L23
    L24:
        r14 = positiveMod(r18);
    L25:
        if (r10 >= r11) goto L31;
        Object[] r21 = this.elementData;
        Object r22 = r21[r10];
        r21[r10] = null;
        if (r12.invoke(r22).booleanValue() == false) goto L29;
        this.elementData[r14] = r22;
        r14 = incremented(r14);
    L30:
        r10 = r10 + 1;
        goto L25
    L29:
        r17 = true;
        goto L30
    L31:
        r5 = r17;
        goto L32
    }

    private final int incremented(int r5) {
        if (r5 != ArraysKt___ArraysKt.getLastIndex(this.elementData)) goto L6;
        return 0;
    L6:
        return r5 + 1;
    }

    @InlineOnly
    private final E internalGet(int r5) {
        return (E) this.elementData[r5];
    }

    @InlineOnly
    private final int internalIndex(int r5) {
        return positiveMod(this.head + r5);
    }

    private final int negativeMod(int r5) {
        if (r5 < 0) goto L4;
        return r5;
    L4:
        return r5 + this.elementData.length;
    }

    private final void nullifyNonEmpty(int r5, int r10) {
        if (r5 >= r10) goto L5;
        ArraysKt___ArraysJvmKt.fill(this.elementData, null, r5, r10);
        return;
    L5:
        Object[] r11 = this.elementData;
        ArraysKt___ArraysJvmKt.fill(r11, null, r5, r11.length);
        ArraysKt___ArraysJvmKt.fill(this.elementData, null, 0, r10);
    }

    private final int positiveMod(int r5) {
        Object[] r10 = this.elementData;
        if (r5 >= r10.length) goto L5;
        return r5;
    L5:
        return r5 - r10.length;
    }

    private final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    private final void removeRangeShiftPreceding(int r10, int r11) {
        int r5 = positiveMod((r10 - 1) + this.head);
        int r12 = positiveMod((r11 - 1) + this.head);
    L3:
        if (r10 <= 0) goto L5;
        int r13 = r5 + 1;
        int r14 = Math.min(r10, Math.min(r13, r12 + 1));
        Object[] r15 = this.elementData;
        int r16 = r12 - r14;
        int r17 = r5 - r14;
        ArraysKt___ArraysJvmKt.copyInto(r15, r15, r16 + 1, r17 + 1, r13);
        r5 = negativeMod(r17);
        r12 = negativeMod(r16);
        r10 = r10 - r14;
        goto L3
    }

    private final void removeRangeShiftSucceeding(int r5, int r10) {
        int r11 = positiveMod(this.head + r10);
        int r12 = positiveMod(this.head + r5);
        int r13 = size();
    L3:
        r13 = r13 - r10;
        if (r13 <= 0) goto L6;
        Object[] r14 = this.elementData;
        r10 = Math.min(r13, Math.min(r14.length - r11, r14.length - r12));
        Object[] r15 = this.elementData;
        int r16 = r11 + r10;
        ArraysKt___ArraysJvmKt.copyInto(r15, r15, r12, r11, r16);
        r11 = positiveMod(r16);
        r12 = positiveMod(r12 + r10);
        goto L3
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        addLast(r5);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        registerModification();
        int r10 = size();
        ensureCapacity(r5.size() + r10);
        int r11 = this.head;
        copyCollectionElements(positiveMod(size() + r11), r5);
        return true;
    }

    public final void addFirst(E r5) {
        registerModification();
        ensureCapacity(size() + 1);
        int r10 = decremented(this.head);
        this.head = r10;
        this.elementData[r10] = r5;
        this.size = size() + 1;
    }

    public final void addLast(E r5) {
        registerModification();
        ensureCapacity(size() + 1);
        Object[] r10 = this.elementData;
        int r11 = this.head;
        r10[positiveMod(size() + r11)] = r5;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (isEmpty() == true) goto L5;
        registerModification();
        int r5 = this.head;
        int r10 = positiveMod(size() + r5);
        nullifyNonEmpty(this.head, r10);
    L5:
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r5) {
        if (indexOf(r5) == (-1)) goto L5;
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
    public E get(int r5) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, size());
        return (E) this.elementData[positiveMod(this.head + r5)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        int r10 = this.head;
        int r11 = positiveMod(size() + r10);
        int r12 = this.head;
        if (r12 >= r11) goto L11;
    L4:
        if (r12 >= r11) goto L32;
        if (Intrinsics.areEqual(r5, this.elementData[r12]) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        int r13 = this.head;
    L9:
        return r12 - r13;
    L32:
        return -1;
    L11:
        if (r12 < r11) goto L24;
        int r14 = this.elementData.length;
    L13:
        if (r12 >= r14) goto L18;
        if (Intrinsics.areEqual(r5, this.elementData[r12]) == true) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        r13 = this.head;
        goto L9
    L18:
        int r15 = 0;
    L19:
        if (r15 >= r11) goto L33;
        if (Intrinsics.areEqual(r5, this.elementData[r15]) == true) goto L22;
        r15 = r15 + 1;
        goto L19
    L22:
        r12 = r15 + this.elementData.length;
        r13 = this.head;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "structure");
        int r10 = this.head;
        int r11 = positiveMod(size() + r10);
        if (isEmpty() == true) goto L8;
        int r12 = this.head;
        if (r12 < r11) goto L8;
        int r13 = r12 - this.elementData.length;
    L9:
        r5.mo2invoke(Integer.valueOf(r13), toArray());
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
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        int r10 = positiveMod(size() + this.head);
        int r11 = this.head;
        if (r11 >= r10) goto L13;
        int r12 = r10 - 1;
        if (r11 <= r12) goto L7;
    L27:
        return -1;
    L7:
        if (Intrinsics.areEqual(r5, this.elementData[r12]) == true) goto L8;
        if (r12 == r11) goto L27;
        r12 = r12 - 1;
        goto L7
    L8:
        int r13 = this.head;
    L10:
        return r12 - r13;
    L13:
        if (r11 <= r10) goto L27;
        int r14 = r10 - 1;
    L15:
        if ((-1) >= r14) goto L20;
        if (Intrinsics.areEqual(r5, this.elementData[r14]) == true) goto L18;
        r14 = r14 - 1;
        goto L15
    L18:
        r12 = r14 + this.elementData.length;
        r13 = this.head;
        goto L10
    L20:
        r12 = ArraysKt___ArraysKt.getLastIndex(this.elementData);
        int r15 = this.head;
        if (r15 > r12) goto L27;
    L23:
        if (Intrinsics.areEqual(r5, this.elementData[r12]) == true) goto L24;
        if (r12 == r15) goto L27;
        r12 = r12 - 1;
        goto L23
    L24:
        r13 = this.head;
        goto L10
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r5) {
        int r10 = indexOf(r5);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        remove(r10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r5 = false;
        r5 = false;
        int r10 = 0;
        r5 = false;
        if (isEmpty() == false) goto L5;
    L34:
        return r5;
    L5:
        if (this.elementData.length == 0) goto L34;
        int r11 = positiveMod(size() + this.head);
        int r13 = this.head;
        if (r13 >= r11) goto L17;
        int r14 = r13;
    L10:
        if (r13 >= r11) goto L16;
        Object r15 = this.elementData[r13];
        if (r12.contains(r15) == true) goto L14;
        this.elementData[r14] = r15;
        r14 = r14 + 1;
    L15:
        r13 = r13 + 1;
        goto L10
    L14:
        r5 = true;
        goto L15
    L16:
        ArraysKt___ArraysJvmKt.fill(this.elementData, null, r14, r11);
    L32:
        if (r5 == false) goto L34;
        registerModification();
        this.size = negativeMod(r14 - this.head);
        goto L34
    L17:
        int r16 = this.elementData.length;
        boolean r17 = false;
        int r18 = r13;
    L18:
        if (r13 >= r16) goto L24;
        Object[] r19 = this.elementData;
        Object r20 = r19[r13];
        r19[r13] = null;
        if (r12.contains(r20) == true) goto L22;
        this.elementData[r18] = r20;
        r18 = r18 + 1;
    L23:
        r13 = r13 + 1;
        goto L18
    L22:
        r17 = true;
        goto L23
    L24:
        r14 = positiveMod(r18);
    L25:
        if (r10 >= r11) goto L31;
        Object[] r21 = this.elementData;
        Object r22 = r21[r10];
        r21[r10] = null;
        if (r12.contains(r22) == true) goto L29;
        this.elementData[r14] = r22;
        r14 = incremented(r14);
    L30:
        r10 = r10 + 1;
        goto L25
    L29:
        r17 = true;
        goto L30
    L31:
        r5 = r17;
        goto L32
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r10, size());
        if (r10 == CollectionsKt__CollectionsKt.getLastIndex(this)) goto L5;
        if (r10 == 0) goto L8;
        registerModification();
        int r5 = positiveMod(this.head + r10);
        E r11 = (E) this.elementData[r5];
        if (r10 >= (size() >> 1)) goto L16;
        int r12 = this.head;
        if (r5 < r12) goto L14;
        Object[] r13 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r13, r13, r12 + 1, r12, r5);
    L15:
        Object[] r14 = this.elementData;
        int r15 = this.head;
        r14[r15] = null;
        this.head = incremented(r15);
    L21:
        this.size = size() - 1;
        return r11;
    L14:
        Object[] r16 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r16, r16, 1, 0, r5);
        Object[] r17 = this.elementData;
        r17[0] = r17[r17.length - 1];
        int r18 = this.head;
        ArraysKt___ArraysJvmKt.copyInto(r17, r17, r18 + 1, r18, r17.length - 1);
        goto L15
    L16:
        int r19 = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
        if (r5 > r19) goto L19;
        Object[] r20 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r20, r20, r5, r5 + 1, r19 + 1);
    L20:
        this.elementData[r19] = null;
        goto L21
    L19:
        Object[] r21 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r21, r21, r5, r5 + 1, r21.length);
        Object[] r22 = this.elementData;
        r22[r22.length - 1] = r22[0];
        ArraysKt___ArraysJvmKt.copyInto(r22, r22, 0, 1, r19 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        registerModification();
        Object[] r5 = this.elementData;
        int r10 = this.head;
        E r11 = (E) r5[r10];
        r5[r10] = null;
        this.head = incremented(r10);
        this.size = size() - 1;
        return r11;
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
        registerModification();
        int r5 = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
        Object[] r10 = this.elementData;
        E r11 = (E) r10[r5];
        r10[r5] = null;
        this.size = size() - 1;
        return r11;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeLast();
    }

    @Override // java.util.AbstractList
    public void removeRange(int r5, int r10) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r5, r10, size());
        int r11 = r10 - r5;
        if (r11 != 0) goto L6;
        return;
    L6:
        if (r11 != size()) goto L10;
        clear();
        return;
    L10:
        if (r11 != 1) goto L13;
        remove(r5);
        return;
    L13:
        registerModification();
        if (r5 >= (size() - r10)) goto L16;
        removeRangeShiftPreceding(r5, r10);
        int r12 = positiveMod(this.head + r11);
        nullifyNonEmpty(this.head, r12);
        this.head = r12;
    L17:
        this.size = size() - r11;
        return;
    L16:
        removeRangeShiftSucceeding(r5, r10);
        int r13 = this.head;
        int r14 = positiveMod(size() + r13);
        nullifyNonEmpty(negativeMod(r14 - r11), r14);
        goto L17
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r5 = false;
        r5 = false;
        int r10 = 0;
        r5 = false;
        if (isEmpty() == false) goto L5;
    L34:
        return r5;
    L5:
        if (this.elementData.length == 0) goto L34;
        int r11 = positiveMod(size() + this.head);
        int r13 = this.head;
        if (r13 >= r11) goto L17;
        int r14 = r13;
    L10:
        if (r13 >= r11) goto L16;
        Object r15 = this.elementData[r13];
        if (r12.contains(r15) == false) goto L14;
        this.elementData[r14] = r15;
        r14 = r14 + 1;
    L15:
        r13 = r13 + 1;
        goto L10
    L14:
        r5 = true;
        goto L15
    L16:
        ArraysKt___ArraysJvmKt.fill(this.elementData, null, r14, r11);
    L32:
        if (r5 == false) goto L34;
        registerModification();
        this.size = negativeMod(r14 - this.head);
        goto L34
    L17:
        int r16 = this.elementData.length;
        boolean r17 = false;
        int r18 = r13;
    L18:
        if (r13 >= r16) goto L24;
        Object[] r19 = this.elementData;
        Object r20 = r19[r13];
        r19[r13] = null;
        if (r12.contains(r20) == false) goto L22;
        this.elementData[r18] = r20;
        r18 = r18 + 1;
    L23:
        r13 = r13 + 1;
        goto L18
    L22:
        r17 = true;
        goto L23
    L24:
        r14 = positiveMod(r18);
    L25:
        if (r10 >= r11) goto L31;
        Object[] r21 = this.elementData;
        Object r22 = r21[r10];
        r21[r10] = null;
        if (r12.contains(r22) == false) goto L29;
        this.elementData[r14] = r22;
        r14 = incremented(r14);
    L30:
        r10 = r10 + 1;
        goto L25
    L29:
        r17 = true;
        goto L30
    L31:
        r5 = r17;
        goto L32
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r5, E r10) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r5, size());
        int r11 = positiveMod(this.head + r5);
        Object[] r12 = this.elementData;
        E r13 = (E) r12[r11];
        r12[r11] = r10;
        return r13;
    }

    public final void testRemoveRange$kotlin_stdlib(int r5, int r10) {
        removeRange(r5, r10);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return (T[]) toArray(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        if (r10.length >= size()) goto L6;
        r10 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(r10, size());
    L6:
        int r5 = this.head;
        int r11 = positiveMod(size() + r5);
        int r12 = this.head;
        if (r12 >= r11) goto L10;
        ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, r10, 0, r12, r11, 2, null);
    L13:
        return (T[]) CollectionsKt__CollectionsJVMKt.terminateCollectionToArray(size(), r10);
    L10:
        if (isEmpty() == true) goto L13;
        Object[] r13 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r13, r10, 0, this.head, r13.length);
        Object[] r14 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r14, r10, r14.length - this.head, 0, r11);
        goto L13
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
        registerModification();
        ensureCapacity(size() + 1);
        int r5 = positiveMod(this.head + r10);
        if (r10 >= ((size() + 1) >> 1)) goto L16;
        int r12 = decremented(r5);
        int r13 = decremented(this.head);
        int r14 = this.head;
        if (r12 < r14) goto L14;
        Object[] r15 = this.elementData;
        r15[r13] = r15[r14];
        ArraysKt___ArraysJvmKt.copyInto(r15, r15, r14, r14 + 1, r12 + 1);
    L15:
        this.elementData[r12] = r11;
        this.head = r13;
    L21:
        this.size = size() + 1;
        return;
    L14:
        Object[] r16 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r16, r16, r14 - 1, r14, r16.length);
        Object[] r17 = this.elementData;
        r17[r17.length - 1] = r17[0];
        ArraysKt___ArraysJvmKt.copyInto(r17, r17, 0, 1, r12 + 1);
        goto L15
    L16:
        int r18 = positiveMod(size() + this.head);
        if (r5 >= r18) goto L19;
        Object[] r19 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r19, r19, r5 + 1, r5, r18);
    L20:
        this.elementData[r5] = r11;
        goto L21
    L19:
        Object[] r20 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r20, r20, 1, 0, r18);
        Object[] r21 = this.elementData;
        r21[0] = r21[r21.length - 1];
        ArraysKt___ArraysJvmKt.copyInto(r21, r21, r5 + 1, r5, r21.length - 1);
        goto L20
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends E> r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r10, size());
        if (r11.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r10 == size()) goto L8;
        registerModification();
        int r5 = size();
        ensureCapacity(r11.size() + r5);
        int r12 = this.head;
        int r13 = positiveMod(size() + r12);
        int r14 = positiveMod(this.head + r10);
        int r15 = r11.size();
        if (r10 >= ((size() + 1) >> 1)) goto L24;
        int r16 = this.head;
        int r17 = r16 - r15;
        if (r14 < r16) goto L19;
        if (r17 < 0) goto L15;
        Object[] r18 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r18, r18, r17, r16, r14);
    L23:
        this.head = r17;
        copyCollectionElements(negativeMod(r14 - r15), r11);
    L38:
        return true;
    L15:
        Object[] r19 = this.elementData;
        r17 = r17 + r19.length;
        int r20 = r14 - r16;
        int r21 = r19.length - r17;
        if (r21 < r20) goto L18;
        ArraysKt___ArraysJvmKt.copyInto(r19, r19, r17, r16, r14);
        goto L23
    L18:
        ArraysKt___ArraysJvmKt.copyInto(r19, r19, r17, r16, r16 + r21);
        Object[] r22 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r22, r22, 0, this.head + r21, r14);
        goto L23
    L19:
        Object[] r23 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r23, r23, r17, r16, r23.length);
        if (r15 < r14) goto L22;
        Object[] r24 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r24, r24, r24.length - r15, 0, r14);
        goto L23
    L22:
        Object[] r25 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r25, r25, r25.length - r15, 0, r15);
        Object[] r26 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r26, r26, 0, r15, r14);
        goto L23
    L24:
        int r27 = r14 + r15;
        if (r14 >= r13) goto L33;
        int r28 = r15 + r13;
        Object[] r29 = this.elementData;
        if (r28 > r29.length) goto L30;
        ArraysKt___ArraysJvmKt.copyInto(r29, r29, r27, r14, r13);
    L37:
        copyCollectionElements(r14, r11);
        goto L38
    L30:
        if (r27 < r29.length) goto L32;
        ArraysKt___ArraysJvmKt.copyInto(r29, r29, r27 - r29.length, r14, r13);
        goto L37
    L32:
        int r30 = r13 - (r28 - r29.length);
        ArraysKt___ArraysJvmKt.copyInto(r29, r29, 0, r30, r13);
        Object[] r31 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r31, r31, r27, r14, r30);
        goto L37
    L33:
        Object[] r32 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r32, r32, r15, 0, r13);
        Object[] r33 = this.elementData;
        if (r27 < r33.length) goto L36;
        ArraysKt___ArraysJvmKt.copyInto(r33, r33, r27 - r33.length, r14, r33.length);
        goto L37
    L36:
        ArraysKt___ArraysJvmKt.copyInto(r33, r33, 0, r33.length - r15, r33.length);
        Object[] r34 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(r34, r34, r27, r14, r34.length - r15);
        goto L37
    L8:
        return addAll(r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Object[] r10 = r5.toArray(new Object[0]);
        this.elementData = r10;
        this.size = r10.length;
        if (r10.length != 0) goto L6;
        this.elementData = emptyElementData;
        return;
    }
}
