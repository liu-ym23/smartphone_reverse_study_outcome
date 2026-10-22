package androidx.compose.runtime.collection;

import ai.j0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J+\u0010\u001e\u001a\u00020\u00142\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140 H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0016\u0010%\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0010H\u0016J\u0006\u0010(\u001a\u00020\u0010J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0096\u0002J\u0013\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J \u0010,\u001a\u00020\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100 H\u0086\bø\u0001\u0000J\b\u0010.\u001a\u00020/H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR0\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArraySet;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "()V", "<set-?>", "", "size", "getSize", "()I", "", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "(Ljava/lang/Object;)Z", "addAll", "", "collection", "", "checkIndexBounds", "index", "clear", "contains", "element", "containsAll", "elements", "fastForEach", "block", "Lkotlin/Function1;", "find", "findExactIndex", "midIndex", "valueHash", "get", "(I)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "iterator", "", "remove", "removeValueIf", "predicate", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIdentityArraySet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,389:1\n1726#2,3:390\n*S KotlinDebug\n*F\n+ 1 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n*L\n366#1:390,3\n*E\n"})
public final class IdentityArraySet<T> implements Set<T>, KMappedMarker {
    private int size;
    private Object[] values;

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.IdentityArraySet$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/compose/runtime/collection/IdentityArraySet$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private int index;
        final /* synthetic */ IdentityArraySet<T> this$0;

        public AnonymousClass1(IdentityArraySet<T> r5) {
            this.this$0 = r5;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.this$0.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Object[] r5 = this.this$0.getValues();
            int r10 = this.index;
            this.index = r10 + 1;
            T r11 = (T) r5[r10];
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            return r11;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int r5) {
            this.index = r5;
        }
    }

    public IdentityArraySet() {
        this.values = new Object[16];
    }

    public static final /* synthetic */ void access$setSize$p(IdentityArraySet r5, int r10) {
        r5.size = r10;
    }

    private final void checkIndexBounds(int r5) {
        if (r5 >= 0) goto L4;
    L6:
        StringBuilder r10 = j0.s(r5, "Index ", ", size ");
        r10.append(size());
        throw new IndexOutOfBoundsException(r10.toString());
    L4:
        if (r5 >= size()) goto L6;
    }

    private final int find(Object r10) {
        int r5 = size() - 1;
        int r11 = ActualJvm_jvmKt.identityHashCode(r10);
        Object[] r12 = this.values;
        int r13 = 0;
    L3:
        if (r13 > r5) goto L14;
        int r14 = (r13 + r5) >>> 1;
        Object r15 = r12[r14];
        int r16 = ActualJvm_jvmKt.identityHashCode(r15);
        if (r16 < r11) goto L6;
        if (r16 <= r11) goto L9;
        r5 = r14 - 1;
        goto L3
    L9:
        if (r15 != r10) goto L12;
        return r14;
    L12:
        return findExactIndex(r14, r10, r11);
    L6:
        r13 = r14 + 1;
        goto L3
    L14:
        return -(r13 + 1);
    }

    private final int findExactIndex(int r5, Object r10, int r11) {
        Object[] r12 = this.values;
        int r13 = size();
        int r14 = r5 - 1;
    L4:
        if ((-1) >= r14) goto L12;
        Object r15 = r12[r14];
        if (r15 == r10) goto L7;
        if (ActualJvm_jvmKt.identityHashCode(r15) != r11) goto L12;
        r14 = r14 - 1;
        goto L4
    L7:
        return r14;
    L12:
        r5 = r5 + 1;
        if (r5 >= r13) goto L22;
        Object r16 = r12[r5];
        if (r16 == r10) goto L16;
        if (ActualJvm_jvmKt.identityHashCode(r16) == r11) goto L12;
        return -(r5 + 1);
    L16:
        return r5;
    L22:
        return -(r13 + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        int r5 = size();
        Object[] r11 = this.values;
        if (r5 <= 0) goto L7;
        int r12 = find(r10);
        if (r12 < 0) goto L8;
        return false;
    L8:
        int r13 = -(r12 + 1);
        if (r5 != r11.length) goto L11;
        Object[] r14 = new Object[r11.length * 2];
        ArraysKt.copyInto(r11, r14, r13 + 1, r13, r5);
        ArraysKt.f(r11, r14, 0, r13, 6);
        this.values = r14;
    L12:
        this.values[r13] = r10;
        this.size = size() + 1;
        return true;
    L11:
        ArraysKt.copyInto(r11, r11, r13 + 1, r13, r5);
        goto L12
    L7:
        r12 = -1;
        goto L8
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        ArraysKt.j(this.values, null);
        this.size = 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (find(r5) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
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

    public final void fastForEach(Function1<? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Object[] r10 = getValues();
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Object r13 = r10[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        r5.invoke(r13);
        r12 = r12 + 1;
        goto L3
    }

    public final T get(int r5) {
        checkIndexBounds(r5);
        T r10 = (T) this.values[r5];
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return r10;
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = find(r5);
        Object[] r11 = this.values;
        int r12 = size();
        if (r10 < 0) goto L12;
        int r13 = r12 - 1;
        if (r10 >= r13) goto L10;
        ArraysKt.copyInto(r11, r11, r10, r10 + 1, r12);
    L10:
        r11[r13] = null;
        this.size = size() - 1;
        return true;
    L12:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void removeValueIf(Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        Object[] r5 = getValues();
        int r11 = size();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L10;
        Object r14 = r5[r12];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        if (r10.invoke(r14).booleanValue() == true) goto L9;
        if (r13 == r12) goto L8;
        r5[r13] = r14;
    L8:
        r13 = r13 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        int r15 = r13;
    L11:
        if (r15 >= r11) goto L13;
        r5[r15] = null;
        r15 = r15 + 1;
        goto L11
    L13:
        access$setSize$p(this, r13);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return CollectionsKt.q(this, null, "[", "]", 0, null, C00651.INSTANCE, 25);
    }

    @Override // java.util.Set, java.util.Collection
    public final void addAll(Collection<? extends T> r15) {
        Intrinsics.checkNotNullParameter(r15, "collection");
        if (r15.isEmpty() == false) goto L6;
        return;
    L6:
        if ((r15 instanceof IdentityArraySet) == true) goto L11;
        Iterator<? extends T> r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L72;
        add(r16.next());
        goto L9
    L72:
        return;
    L11:
        Object[] r5 = this.values;
        IdentityArraySet r17 = (IdentityArraySet) r15;
        Object[] r10 = r17.values;
        int r11 = size();
        int r18 = r17.size();
        int r12 = r11 + r18;
        if (this.values.length >= r12) goto L14;
        boolean r13 = true;
    L15:
        if (r11 != 0) goto L17;
    L20:
        boolean r14 = true;
    L21:
        if (r13 == true) goto L24;
        if (r14 == false) goto L24;
        ArraysKt.copyInto(r10, r5, r11, 0, r18);
        this.size = size() + r18;
        return;
    L24:
        if (r13 == false) goto L29;
        if (r11 <= r18) goto L27;
        int r19 = r11 * 2;
    L28:
        Object[] r20 = new Object[r19];
    L30:
        int r21 = r11 - 1;
        int r110 = r18 - 1;
        int r22 = r12 - 1;
    L31:
        if (r21 >= 0) goto L38;
        if (r110 >= 0) goto L38;
        if (r22 < 0) goto L36;
        ArraysKt.copyInto(r20, r20, 0, r22 + 1, r12);
    L36:
        int r111 = r12 - (r22 + 1);
        ArraysKt.fill(r20, null, r111, r12);
        this.values = r20;
        this.size = r111;
        return;
    L38:
        if (r21 < 0) goto L39;
        if (r110 < 0) goto L41;
        Object r23 = r5[r21];
        Object r24 = r10[r110];
        int r112 = ActualJvm_jvmKt.identityHashCode(r23);
        int r113 = ActualJvm_jvmKt.identityHashCode(r24);
        if (r112 > r113) goto L44;
        if (r112 < r113) goto L47;
        if (r23 == r24) goto L49;
        int r25 = r21 - 1;
    L51:
        if (r25 < 0) goto L47;
        int r114 = r25 - 1;
        Object r26 = r5[r25];
        if (ActualJvm_jvmKt.identityHashCode(r26) != r113) goto L47;
        if (r24 == r26) goto L55;
        r25 = r114;
        goto L51
    L55:
        r110 = r110 - 1;
        goto L31
    L49:
        r21 = r21 - 1;
        r110 = r110 - 1;
    L45:
        int r27 = r110;
        Object r115 = r23;
    L57:
        r20[r22] = r115;
        r110 = r27;
        r22 = r22 - 1;
    L47:
        r27 = r110 - 1;
        r115 = r24;
        goto L57
    L44:
        r21 = r21 - 1;
        goto L45
    L41:
        r27 = r110;
        r115 = r5[r21];
        r21 = r21 - 1;
        goto L57
    L39:
        r27 = r110 - 1;
        r115 = r10[r110];
        goto L57
    L27:
        r19 = r18 * 2;
        goto L28
    L29:
        r20 = r5;
        goto L30
    L17:
        if (ActualJvm_jvmKt.identityHashCode(r5[r11 - 1]) < ActualJvm_jvmKt.identityHashCode(r10[0])) goto L20;
        r14 = false;
        goto L21
    L14:
        r13 = false;
        goto L15
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return (T[]) CollectionToArray.toArray(this, r5);
    }
}
