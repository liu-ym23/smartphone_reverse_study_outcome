package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010 \u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0012\u001a\u00020\tH\u0016J?\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J3\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010)JC\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010-J?\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010/J\"\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J=\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J;\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u00107J\b\u0010(\u001a\u00020\tH\u0002J#\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J?\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006<"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPersistentVector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistentVector.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,325:1\n1#2:326\n*E\n"})
public final class PersistentVector<E> extends AbstractPersistentList<E> implements PersistentList<E> {
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;

    public PersistentVector(Object[] r5, Object[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r10, "tail");
        this.root = r5;
        this.tail = r10;
        this.size = r11;
        this.rootShift = r12;
        if (size() <= 32) goto L11;
        if ((size() - UtilsKt.rootSize(size())) > RangesKt.coerceAtMost(r10.length, 32)) goto L7;
        boolean r13 = true;
    L8:
        CommonFunctionsKt.m42assert(r13);
        return;
    L7:
        r13 = false;
        goto L8
    L11:
        throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + size()).toString());
    }

    private final Object[] bufferFor(int r5) {
        if (rootSize() <= r5) goto L5;
        Object[] r10 = this.root;
        int r11 = this.rootShift;
    L7:
        if (r11 <= 0) goto L9;
        Object[] r12 = r10[UtilsKt.indexSegment(r5, r11)];
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r10 = r12;
        r11 = r11 - 5;
        goto L7
    L9:
        return r10;
    L5:
        return this.tail;
    }

    private final Object[] insertIntoRoot(Object[] r11, int r12, int r13, Object r14, ObjectRef r15) {
        int r5 = UtilsKt.indexSegment(r13, r12);
        if (r12 != 0) goto L9;
        if (r5 != 0) goto L6;
        Object[] r10 = new Object[32];
    L7:
        ArraysKt.copyInto(r11, r10, r5 + 1, r5, 31);
        r15.setValue(r11[31]);
        r10[r5] = r14;
        return r10;
    L6:
        r10 = Arrays.copyOf(r11, 32);
        goto L7
    L9:
        Object[] r16 = Arrays.copyOf(r11, 32);
        int r17 = r12 - 5;
        Object r18 = r11[r5];
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r5] = insertIntoRoot((Object[]) r18, r17, r13, r14, r15);
    L10:
        r5 = r5 + 1;
        if (r5 >= 32) goto L15;
        if (r16[r5] == null) goto L15;
        Object r19 = r11[r5];
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r5] = insertIntoRoot((Object[]) r19, r17, 0, r15.getValue(), r15);
    L15:
        return r16;
    }

    private final PersistentVector<E> insertIntoTail(Object[] r10, int r11, Object r12) {
        int r5 = size() - rootSize();
        Object[] r13 = Arrays.copyOf(this.tail, 32);
        if (r5 >= 32) goto L6;
        ArraysKt.copyInto(this.tail, r13, r11 + 1, r11, r5);
        r13[r11] = r12;
        return new PersistentVector(r10, r13, size() + 1, this.rootShift);
    L6:
        Object[] r14 = this.tail;
        Object r15 = r14[31];
        ArraysKt.copyInto(r14, r13, r11 + 1, r11, r5 - 1);
        r13[r11] = r12;
        return pushFilledTail(r10, r13, UtilsKt.presizedBufferWith(r15));
    }

    private final Object[] pullLastBuffer(Object[] r10, int r11, int r12, ObjectRef r13) {
        int r5 = UtilsKt.indexSegment(r12, r11);
        if (r11 != 5) goto L5;
        r13.setValue(r10[r5]);
        Object[] r14 = null;
    L6:
        if (r14 != null) goto L9;
        if (r5 != 0) goto L9;
        return null;
    L9:
        Object[] r15 = Arrays.copyOf(r10, 32);
        r15[r5] = r14;
        return r15;
    L5:
        Object r16 = r10[r5];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r14 = pullLastBuffer((Object[]) r16, r11 - 5, r12, r13);
        goto L6
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] r5, int r10, int r11) {
        if (r11 == 0) goto L4;
        ObjectRef r12 = new ObjectRef(null);
        Object[] r13 = pullLastBuffer(r5, r11, r10 - 1, r12);
        Intrinsics.checkNotNull(r13);
        Object r14 = r12.getValue();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r15 = (Object[]) r14;
        if (r13[1] != null) goto L13;
        Object r16 = r13[0];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new PersistentVector((Object[]) r16, r15, r10, r11 - 5);
    L13:
        return new PersistentVector(r13, r15, r10, r11);
    L4:
        if (r5.length != 33) goto L7;
        r5 = Arrays.copyOf(r5, 32);
    L7:
        return new SmallPersistentVector(r5);
    }

    private final PersistentVector<E> pushFilledTail(Object[] r5, Object[] r10, Object[] r11) {
        int r12 = size() >> 5;
        int r13 = this.rootShift;
        if (r12 <= (1 << r13)) goto L7;
        Object[] r14 = UtilsKt.presizedBufferWith(r5);
        int r15 = this.rootShift + 5;
        return new PersistentVector(pushTail(r14, r15, r10), r11, size() + 1, r15);
    L7:
        return new PersistentVector(pushTail(r5, r13, r10), r11, size() + 1, this.rootShift);
    }

    private final Object[] pushTail(Object[] r5, int r10, Object[] r11) {
        int r12 = UtilsKt.indexSegment(size() - 1, r10);
        if (r5 == null) goto L6;
        Object[] r13 = Arrays.copyOf(r5, 32);
        if (r13 == null) goto L6;
    L8:
        if (r10 != 5) goto L10;
        r13[r12] = r11;
    L11:
        return r13;
    L10:
        r13[r12] = pushTail((Object[]) r13[r12], r10 - 5, r11);
    L6:
        r13 = new Object[32];
        goto L8
    }

    private final Object[] removeFromRootAt(Object[] r10, int r11, int r12, ObjectRef r13) {
        int r5 = UtilsKt.indexSegment(r12, r11);
        int r14 = 31;
        if (r11 != 0) goto L10;
        if (r5 != 0) goto L6;
        Object[] r15 = new Object[32];
    L7:
        ArraysKt.copyInto(r10, r15, r5, r5 + 1, 32);
        r15[31] = r13.getValue();
        r13.setValue(r10[r5]);
        return r15;
    L6:
        r15 = Arrays.copyOf(r10, 32);
        goto L7
    L10:
        if (r10[31] != null) goto L12;
        r14 = UtilsKt.indexSegment(rootSize() - 1, r11);
    L12:
        Object[] r16 = Arrays.copyOf(r10, 32);
        int r17 = r11 - 5;
        int r18 = r5 + 1;
        if (r18 > r14) goto L17;
    L14:
        Object r19 = r16[r14];
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r14] = removeFromRootAt((Object[]) r19, r17, 0, r13);
        if (r14 == r18) goto L17;
        r14 = r14 - 1;
    L17:
        Object r20 = r16[r5];
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r5] = removeFromRootAt((Object[]) r20, r17, r12, r13);
        return r16;
    }

    private final PersistentList<E> removeFromTailAt(Object[] r10, int r11, int r12, int r13) {
        int r5 = size() - r11;
        if (r13 >= r5) goto L5;
        boolean r14 = true;
    L6:
        CommonFunctionsKt.m42assert(r14);
        if (r5 == 1) goto L9;
        Object[] r15 = Arrays.copyOf(this.tail, 32);
        int r16 = r5 - 1;
        if (r13 >= r16) goto L13;
        ArraysKt.copyInto(this.tail, r15, r13, r13 + 1, r5);
    L13:
        r15[r16] = null;
        return new PersistentVector(r10, r15, (r11 + r5) - 1, r12);
    L9:
        return pullLastBufferFromRoot(r10, r11, r12);
    L5:
        r14 = false;
        goto L6
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] r5, int r10, int r11, Object r12) {
        int r13 = UtilsKt.indexSegment(r11, r10);
        Object[] r14 = Arrays.copyOf(r5, 32);
        if (r10 != 0) goto L5;
        r14[r13] = r12;
    L6:
        return r14;
    L5:
        Object r15 = r14[r13];
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r14[r13] = setInRoot((Object[]) r15, r10 - 5, r11, r12);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection add(Object r5) {
        return add(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection.Builder builder() {
        return builder();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int r5) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        return (E) bufferFor(r5)[r5 & 31];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r10) {
        ListImplementation.checkPositionIndex$runtime_release(r10, size());
        return new PersistentVectorIterator(this.root, this.tail, r10, size(), (this.rootShift / 5) + 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection removeAll(Function1 r5) {
        return removeAll(r5);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> removeAt(int r10) {
        ListImplementation.checkElementIndex$runtime_release(r10, size());
        int r5 = rootSize();
        if (r10 < r5) goto L7;
        return removeFromTailAt(this.root, r5, this.rootShift, r10 - r5);
    L7:
        return removeFromTailAt(removeFromRootAt(this.root, this.rootShift, r10, new ObjectRef(this.tail[0])), r5, this.rootShift, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> set(int r5, E r10) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        if (rootSize() > r5) goto L7;
        Object[] r11 = Arrays.copyOf(this.tail, 32);
        r11[r5 & 31] = r10;
        return new PersistentVector(this.root, r11, size(), this.rootShift);
    L7:
        return new PersistentVector(setInRoot(this.root, this.rootShift, r5, r10), this.tail, size(), this.rootShift);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> add(E r5) {
        int r10 = size() - rootSize();
        if (r10 >= 32) goto L6;
        Object[] r11 = Arrays.copyOf(this.tail, 32);
        r11[r10] = r5;
        return new PersistentVector(this.root, r11, size() + 1, this.rootShift);
    L6:
        Object[] r12 = UtilsKt.presizedBufferWith(r5);
        return pushFilledTail(this.root, this.tail, r12);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentList.Builder builder() {
        return builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        PersistentVectorBuilder<E> r10 = builder();
        r10.removeAllWithPredicate(r5);
        return r10.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> add(int r10, E r11) {
        ListImplementation.checkPositionIndex$runtime_release(r10, size());
        if (r10 == size()) goto L5;
        int r5 = rootSize();
        if (r10 >= r5) goto L9;
        ObjectRef r12 = new ObjectRef(null);
        return insertIntoTail(insertIntoRoot(this.root, this.rootShift, r10, r11, r12), 0, r12.getValue());
    L9:
        return insertIntoTail(this.root, r10 - r5, r11);
    L5:
        return add(r11);
    }
}
