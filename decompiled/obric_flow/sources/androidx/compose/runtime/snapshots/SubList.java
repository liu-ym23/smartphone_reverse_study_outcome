package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0012H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00060"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "modification", "offset", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSnapshotStateList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SubList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,457:1\n1726#2,3:458\n1855#2,2:461\n*S KotlinDebug\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SubList\n*L\n311#1:458,3\n320#1:461,2\n*E\n"})
final class SubList<T> implements List<T>, KMutableList {
    private int modification;
    private final int offset;
    private final SnapshotStateList<T> parentList;
    private int size;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SubList$listIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SubList$listIterator$1", "", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements ListIterator<T>, KMutableListIterator {
        final /* synthetic */ Ref.IntRef $current;
        final /* synthetic */ SubList<T> this$0;

        public AnonymousClass1(Ref.IntRef r5, SubList<T> r10) {
            this.$current = r5;
            this.this$0 = r10;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object r5) {
            add(r5);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.$current.element < (this.this$0.size() - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.$current.element < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int r5 = this.$current.element + 1;
            SnapshotStateListKt.access$validateRange(r5, this.this$0.size());
            this.$current.element = r5;
            return this.this$0.get(r5);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.$current.element + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int r5 = this.$current.element;
            SnapshotStateListKt.access$validateRange(r5, this.this$0.size());
            this.$current.element = r5 - 1;
            return this.this$0.get(r5);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.$current.element;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object r5) {
            set(r5);
        }

        @Override // java.util.ListIterator
        public Void add(T r5) {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Void remove() {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        public Void set(T r5) {
            SnapshotStateListKt.access$modificationError();
            throw new KotlinNothingValueException();
        }
    }

    public SubList(SnapshotStateList<T> r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "parentList");
        this.parentList = r5;
        this.offset = r10;
        this.modification = r5.getModification$runtime_release();
        this.size = r11 - r10;
    }

    private final void validateModification() {
        if (this.parentList.getModification$runtime_release() != this.modification) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r5) {
        validateModification();
        this.parentList.add(this.offset + size(), r5);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        validateModification();
        boolean r11 = this.parentList.addAll(r5 + this.offset, r10);
        if (r11 == false) goto L5;
        int r12 = size();
        this.size = r10.size() + r12;
        this.modification = this.parentList.getModification$runtime_release();
    L5:
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() <= 0) goto L6;
        validateModification();
        SnapshotStateList<T> r5 = this.parentList;
        int r10 = this.offset;
        r5.removeRange(r10, size() + r10);
        this.size = 0;
        this.modification = this.parentList.getModification$runtime_release();
        return;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Collection<? extends Object> r10 = r5;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        if (contains(r11.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.List
    public T get(int r5) {
        validateModification();
        SnapshotStateListKt.access$validateRange(r5, size());
        return this.parentList.get(this.offset + r5);
    }

    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object r5) {
        validateModification();
        int r10 = this.offset;
        Iterator<Integer> r11 = RangesKt.until(r10, size() + r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        int r12 = ((IntIterator) r11).nextInt();
        if (Intrinsics.areEqual(r5, this.parentList.get(r12)) == false) goto L4;
        return r12 - this.offset;
    L9:
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r5) {
        validateModification();
        int r10 = this.offset + size();
    L3:
        r10 = r10 - 1;
        if (r10 < this.offset) goto L10;
        if (Intrinsics.areEqual(r5, this.parentList.get(r10)) == false) goto L3;
        return r10 - this.offset;
    L10:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int r5) {
        return removeAt(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Iterator<? extends Object> r10 = r5.iterator();
    L3:
        boolean r11 = false;
    L5:
        if (r10.hasNext() == false) goto L10;
        if (remove(r10.next()) == true) goto L9;
        if (r11 == false) goto L3;
    L9:
        r11 = true;
        goto L5
    L10:
        return r11;
    }

    public T removeAt(int r5) {
        validateModification();
        T r10 = this.parentList.remove(this.offset + r5);
        this.size = size() - 1;
        this.modification = this.parentList.getModification$runtime_release();
        return r10;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        validateModification();
        SnapshotStateList<T> r10 = this.parentList;
        int r11 = this.offset;
        int r12 = r10.retainAllInRange$runtime_release(r5, r11, size() + r11);
        if (r12 <= 0) goto L5;
        this.modification = this.parentList.getModification$runtime_release();
        this.size = size() - r12;
    L5:
        if (r12 <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.util.List
    public T set(int r5, T r10) {
        SnapshotStateListKt.access$validateRange(r5, size());
        validateModification();
        T r11 = this.parentList.set(r5 + this.offset, r10);
        this.modification = this.parentList.getModification$runtime_release();
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int r5, int r10) {
        if (r5 < 0) goto L9;
        if (r5 > r10) goto L9;
        if (r10 > size()) goto L9;
        validateModification();
        SnapshotStateList<T> r11 = this.parentList;
        int r12 = this.offset;
        return new SubList(r11, r5 + r12, r10 + r12);
    L9:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r5) {
        validateModification();
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = r5 - 1;
        return new AnonymousClass1(r10, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r5) {
        int r10 = indexOf(r5);
        if (r10 < 0) goto L5;
        remove(r10);
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return (T[]) CollectionToArray.toArray(this, r5);
    }

    @Override // java.util.List
    public void add(int r5, T r10) {
        validateModification();
        this.parentList.add(this.offset + r5, r10);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return addAll(size(), r5);
    }
}
