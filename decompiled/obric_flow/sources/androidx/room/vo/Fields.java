package androidx.room.vo;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001HÂ\u0003J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\u0011\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0096\u0003J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\u0011\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0001J\t\u0010 \u001a\u00020\u0013H\u0096\u0001J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0096\u0003J\u0011\u0010#\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0096\u0001J\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%2\u0006\u0010\u001d\u001a\u00020\u000eH\u0096\u0001J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000eH\u0096\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Landroidx/room/vo/Fields;", "", "Landroidx/room/vo/Field;", "field", "(Landroidx/room/vo/Field;)V", "fields", "(Ljava/util/List;)V", "columnNames", "", "getColumnNames$room_compiler", "()Ljava/util/List;", "columnNames$delegate", "Lkotlin/Lazy;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", "elements", "", "copy", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Fields implements List<Field>, KMappedMarker {
    private final Lazy columnNames$delegate;
    private final List<Field> fields;

    /* JADX WARN: Multi-variable type inference failed */
    public Fields() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final List<Field> component1() {
        return this.fields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Fields copy$default(Fields r5, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.fields;
    L6:
        return r5.copy(r10);
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int r5, Field r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r5, Collection<? extends Field> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return this.fields.contains(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return this.fields.containsAll(r5);
    }

    public final Fields copy(List<Field> r5) {
        Intrinsics.checkNotNullParameter(r5, "fields");
        return new Fields(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Fields) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fields, ((Fields) r5).fields) == true) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Field get(int r5) {
        return this.fields.get(r5);
    }

    public final List<String> getColumnNames$room_compiler() {
        return (List) this.columnNames$delegate.getValue();
    }

    public int getSize() {
        return this.fields.size();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.fields.hashCode();
    }

    public int indexOf(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return this.fields.indexOf(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Field> iterator() {
        return this.fields.iterator();
    }

    public int lastIndexOf(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        return this.fields.lastIndexOf(r5);
    }

    @Override // java.util.List
    public ListIterator<Field> listIterator() {
        return this.fields.listIterator();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Field remove(int r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Field> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public Field set2(int r5, Field r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super Field> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Field> subList(int r5, int r10) {
        return this.fields.subList(r5, r10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return "Fields(fields=" + this.fields + ")";
    }

    public Fields(List<Field> r5) {
        Intrinsics.checkNotNullParameter(r5, "fields");
        this.fields = r5;
        this.columnNames$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Fields$columnNames$2(this));
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int r5, Field r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Field> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object r5) {
        if ((r5 instanceof Field) == true) goto L7;
        return false;
    L7:
        return contains((Field) r5);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Field get(int r5) {
        return get(r5);
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object r5) {
        if ((r5 instanceof Field) == true) goto L7;
        return -1;
    L7:
        return indexOf((Field) r5);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object r5) {
        if ((r5 instanceof Field) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Field) r5);
    }

    @Override // java.util.List
    public ListIterator<Field> listIterator(int r5) {
        return this.fields.listIterator(r5);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Field remove(int r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Field set(int r5, Field r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return (T[]) CollectionToArray.toArray(this, r5);
    }

    public boolean add(Field r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Fields(List r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        this(r5);
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Fields(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "field");
        this(CollectionsKt.listOf(r5));
    }
}
