package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0$H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J#\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "bufferOfSize", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "set", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSmallPersistentVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmallPersistentVector.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector\n+ 2 extensions.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/ExtensionsKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,161:1\n41#2:162\n41#2:163\n26#3:164\n*S KotlinDebug\n*F\n+ 1 SmallPersistentVector.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector\n*L\n48#1:162\n91#1:163\n159#1:164\n*E\n"})
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {
    public static final Companion Companion = null;
    private static final SmallPersistentVector EMPTY = null;
    private final Object[] buffer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "", "getEMPTY", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.access$getEMPTY$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new SmallPersistentVector(new Object[0]);
    }

    public SmallPersistentVector(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "buffer");
        this.buffer = r5;
        if (r5.length > 32) goto L5;
        boolean r10 = true;
    L6:
        CommonFunctionsKt.m42assert(r10);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static final /* synthetic */ SmallPersistentVector access$getEMPTY$cp() {
        return EMPTY;
    }

    private final Object[] bufferOfSize(int r5) {
        return new Object[r5];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection add(Object r5) {
        return add(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection addAll(Collection r5) {
        return addAll(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection.Builder builder() {
        return builder();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int r5) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        return (E) this.buffer[r5];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.buffer.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int indexOf(Object r5) {
        return ArraysKt.indexOf(this.buffer, r5);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        return ArraysKt.lastIndexOf(this.buffer, r5);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r5) {
        ListImplementation.checkPositionIndex$runtime_release(r5, size());
        return new BufferIterator(this.buffer, r5, size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection removeAll(Function1 r5) {
        return removeAll(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> removeAt(int r5) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        if (size() == 1) goto L5;
        Object[] r10 = Arrays.copyOf(this.buffer, size() - 1);
        ArraysKt.copyInto(this.buffer, r10, r5, r5 + 1, size());
        return new SmallPersistentVector(r10);
    L5:
        return EMPTY;
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> set(int r5, E r10) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        Object[] r11 = this.buffer;
        Object[] r12 = Arrays.copyOf(r11, r11.length);
        r12[r5] = r10;
        return new SmallPersistentVector(r12);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> add(E r5) {
        if (size() >= 32) goto L6;
        Object[] r10 = Arrays.copyOf(this.buffer, size() + 1);
        r10[size()] = r5;
        return new SmallPersistentVector(r10);
    L6:
        Object[] r11 = UtilsKt.presizedBufferWith(r5);
        return new PersistentVector(this.buffer, r11, size() + 1, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> addAll(Collection<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r10 = size();
        if ((r5.size() + r10) > 32) goto L10;
        Object[] r11 = this.buffer;
        int r12 = size();
        Object[] r13 = Arrays.copyOf(r11, r5.size() + r12);
        int r14 = size();
        Iterator<? extends E> r15 = r5.iterator();
    L6:
        if (r15.hasNext() == false) goto L9;
        r13[r14] = r15.next();
        r14 = r14 + 1;
        goto L6
    L9:
        return new SmallPersistentVector(r13);
    L10:
        PersistentList.Builder<E> r16 = builder();
        r16.addAll(r5);
        return r16.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(Function1<? super E, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "predicate");
        Object[] r5 = this.buffer;
        int r11 = size();
        int r12 = size();
        int r13 = 0;
        boolean r14 = false;
    L3:
        if (r13 >= r12) goto L12;
        Object r15 = this.buffer[r13];
        if (r10.invoke(r15).booleanValue() == false) goto L8;
        if (r14 == true) goto L10;
        Object[] r16 = this.buffer;
        r5 = Arrays.copyOf(r16, r16.length);
        r14 = true;
        r11 = r13;
    L10:
        r13 = r13 + 1;
        goto L3
    L8:
        if (r14 == false) goto L10;
        r5[r11] = r15;
        r11 = r11 + 1;
        goto L10
    L12:
        if (r11 == size()) goto L24;
        if (r11 != 0) goto L17;
        return EMPTY;
    L17:
        return new SmallPersistentVector(ArraysKt.copyOfRange(r5, 0, r11));
    L24:
        return this;
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> add(int r10, E r11) {
        ListImplementation.checkPositionIndex$runtime_release(r10, size());
        if (r10 != size()) goto L7;
        return add(r11);
    L7:
        if (size() >= 32) goto L10;
        Object[] r5 = bufferOfSize(size() + 1);
        ArraysKt.f(this.buffer, r5, 0, r10, 6);
        ArraysKt.copyInto(this.buffer, r5, r10 + 1, r10, size());
        r5[r10] = r11;
        return new SmallPersistentVector(r5);
    L10:
        Object[] r12 = this.buffer;
        Object[] r13 = Arrays.copyOf(r12, r12.length);
        ArraysKt.copyInto(this.buffer, r13, r10 + 1, r10, size() - 1);
        r13[r10] = r11;
        return new PersistentVector(r13, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> addAll(int r5, Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "c");
        ListImplementation.checkPositionIndex$runtime_release(r5, size());
        int r11 = size();
        if ((r10.size() + r11) > 32) goto L10;
        int r12 = size();
        Object[] r13 = bufferOfSize(r10.size() + r12);
        ArraysKt.f(this.buffer, r13, 0, r5, 6);
        ArraysKt.copyInto(this.buffer, r13, r10.size() + r5, r5, size());
        Iterator<? extends E> r14 = r10.iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        r13[r5] = r14.next();
        r5 = r5 + 1;
        goto L6
    L9:
        return new SmallPersistentVector(r13);
    L10:
        PersistentList.Builder<E> r15 = builder();
        r15.addAll(r5, r10);
        return r15.build();
    }
}
