package kotlin.collections.builders;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001PBA\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J&\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0016J\u0014\u0010(\u001a\u00020\u00132\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010,H\u0096\u0002J\u0016\u0010-\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0015\u00100\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0013H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000107H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001072\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010:\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0015\u0010;\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010.J\u0015\u0010<\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0016\u0010@\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J.\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u001e\u0010C\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\tH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\t\"\u0004\b\u0002\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\tH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Q"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isReadOnly", "", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ListBuilder$BuilderSubList<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    private E[] backing;
    private int length;
    private final int offset;
    private final ListBuilder$BuilderSubList<E> parent;
    private final ListBuilder<E> root;

    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkForComodification() {
        if (ListBuilder.access$getModCount$p$s-2084097795(this.root) != ((AbstractList) this).modCount) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    private final boolean isReadOnly() {
        return ListBuilder.access$isReadOnly$p(this.root);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final void checkIsMutable() {
        if (isReadOnly() == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object writeReplace() {
        if (isReadOnly() == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    public int getSize() {
        checkForComodification();
        return this.length;
    }

    public int hashCode() {
        checkForComodification();
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
    }

    public boolean isEmpty() {
        checkForComodification();
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Object[] toArray() {
        checkForComodification();
        E[] r0 = this.backing;
        int r1 = this.offset;
        return ArraysKt.copyOfRange(r0, r1, this.length + r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        checkForComodification();
        return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, this);
    }

    public static final /* synthetic */ Object[] access$getBacking$p(ListBuilder$BuilderSubList r0) {
        return r0.backing;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder$BuilderSubList r0) {
        return r0.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ int access$getModCount$p$s1462993667(ListBuilder$BuilderSubList r0) {
        return ((AbstractList) r0).modCount;
    }

    public static final /* synthetic */ int access$getOffset$p(ListBuilder$BuilderSubList r0) {
        return r0.offset;
    }

    public static final /* synthetic */ ListBuilder access$getRoot$p(ListBuilder$BuilderSubList r0) {
        return r0.root;
    }

    private final boolean contentEquals(List<?> r4) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, r4);
    }

    private final E removeAtInternal(int r2) {
        registerModification();
        ListBuilder$BuilderSubList<E> r0 = this.parent;
        if (r0 == null) goto L5;
        E r3 = r0.removeAtInternal(r2);
    L6:
        this.length--;
        return r3;
    L5:
        r3 = (E) ListBuilder.access$removeAtInternal(this.root, r2);
        goto L6
    }

    public boolean add(E r3) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, r3);
        return true;
    }

    public boolean addAll(Collection<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        int r0 = r4.size();
        addAllInternal(this.offset + this.length, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r2) {
        checkForComodification();
        if (r2 != this) goto L5;
    L10:
        return true;
    L5:
        if ((r2 instanceof List) == true) goto L7;
    L9:
        return false;
    L7:
        if (contentEquals((List) r2) == false) goto L9;
        goto L9
    }

    public E get(int r3) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return this.backing[this.offset + r3];
    }

    public int indexOf(Object r4) {
        checkForComodification();
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.backing[this.offset + r0], r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public int lastIndexOf(Object r4) {
        checkForComodification();
        int r0 = this.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (Intrinsics.areEqual(this.backing[this.offset + r0], r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    public ListIterator<E> listIterator(int r3) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        return new Itr(this, r3);
    }

    public boolean remove(Object r1) {
        checkIsMutable();
        checkForComodification();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean removeAll(Collection<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r4, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public E removeAt(int r3) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return removeAtInternal(this.offset + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean retainAll(Collection<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, r4, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        checkForComodification();
        int r0 = r5.length;
        int r1 = this.length;
        if (r0 >= r1) goto L6;
        E[] r2 = this.backing;
        int r3 = this.offset;
        return (T[]) Arrays.copyOfRange(r2, r3, r1 + r3, r5.getClass());
    L6:
        E[] r4 = this.backing;
        int r6 = this.offset;
        ArraysKt.copyInto(r4, r5, 0, r6, r1 + r6);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r5);
    }

    private final void addAtInternal(int r2, E r3) {
        registerModification();
        ListBuilder$BuilderSubList<E> r0 = this.parent;
        if (r0 == null) goto L5;
        r0.addAtInternal(r2, r3);
    L6:
        this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
        this.length++;
        return;
    L5:
        ListBuilder.access$addAtInternal(this.root, r2, r3);
        goto L6
    }

    private final void removeRangeInternal(int r2, int r3) {
        if (r3 <= 0) goto L4;
        registerModification();
    L4:
        ListBuilder$BuilderSubList<E> r0 = this.parent;
        if (r0 == null) goto L7;
        r0.removeRangeInternal(r2, r3);
    L8:
        this.length -= r3;
        return;
    L7:
        ListBuilder.access$removeRangeInternal(this.root, r2, r3);
        goto L8
    }

    public void add(int r3, E r4) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        addAtInternal(this.offset + r3, r4);
    }

    public boolean addAll(int r3, Collection<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        int r0 = r4.size();
        addAllInternal(this.offset + r3, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public E set(int r4, E r5) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r4, this.length);
        E[] r0 = this.backing;
        int r1 = this.offset;
        E r2 = r0[r1 + r4];
        r0[r1 + r4] = r5;
        return r2;
    }

    public List<E> subList(int r9, int r10) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r9, r10, this.length);
        return (List<E>) new ListBuilder$BuilderSubList(this.backing, this.offset + r9, r10 - r9, this, this.root);
    }

    private final void addAllInternal(int r2, Collection<? extends E> r3, int r4) {
        registerModification();
        ListBuilder$BuilderSubList<E> r0 = this.parent;
        if (r0 == null) goto L5;
        r0.addAllInternal(r2, r3, r4);
    L6:
        this.backing = (E[]) ListBuilder.access$getBacking$p(this.root);
        this.length += r4;
        return;
    L5:
        ListBuilder.access$addAllInternal(this.root, r2, r3, r4);
        goto L6
    }

    private final int retainOrRemoveAllInternal(int r2, int r3, Collection<? extends E> r4, boolean r5) {
        ListBuilder$BuilderSubList<E> r0 = this.parent;
        if (r0 == null) goto L5;
        int r6 = r0.retainOrRemoveAllInternal(r2, r3, r4, r5);
    L6:
        if (r6 <= 0) goto L8;
        registerModification();
    L8:
        this.length -= r6;
        return r6;
    L5:
        r6 = ListBuilder.access$retainOrRemoveAllInternal(this.root, r2, r3, r4, r5);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListBuilder$BuilderSubList(E[] r2, int r3, int r4, ListBuilder$BuilderSubList<E> r5, ListBuilder<E> r6) {
        Intrinsics.checkNotNullParameter(r2, "backing");
        Intrinsics.checkNotNullParameter(r6, "root");
        this.backing = r2;
        this.offset = r3;
        this.length = r4;
        this.parent = r5;
        this.root = r6;
        ((AbstractList) this).modCount = ListBuilder.access$getModCount$p$s-2084097795(r6);
    }
}
