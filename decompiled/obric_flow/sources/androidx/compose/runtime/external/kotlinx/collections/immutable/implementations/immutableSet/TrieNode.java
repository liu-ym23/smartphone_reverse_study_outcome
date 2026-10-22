package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", ExifInterface.LONGITUDE_EAST, "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTrieNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode\n+ 2 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeKt\n+ 3 ForEachOneBit.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ForEachOneBitKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeKt$filterTo$1\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,851:1\n54#2,13:852\n50#2,17:865\n50#2,17:882\n50#2,10:918\n60#2,7:929\n50#2,10:945\n60#2,7:956\n10#3,5:899\n15#3,4:905\n10#3,9:909\n10#3,9:936\n10#3,9:965\n1#4:904\n53#5:928\n53#5:955\n12541#6,2:963\n26#7:974\n*S KotlinDebug\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode\n*L\n297#1:852,13\n324#1:865,17\n347#1:882,17\n594#1:918,10\n594#1:929,7\n701#1:945,10\n701#1:956,7\n423#1:899,5\n423#1:905,4\n525#1:909,9\n621#1:936,9\n717#1:965,9\n594#1:928\n701#1:955\n710#1:963,2\n849#1:974\n*E\n"})
public final class TrieNode<E> {
    public static final Companion Companion = null;
    private static final TrieNode EMPTY = null;
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.access$getEMPTY$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TrieNode(0, new Object[0]);
    }

    public TrieNode(int r5, Object[] r10, MutabilityOwnership r11) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        this.bitmap = r5;
        this.buffer = r10;
        this.ownedBy = r11;
    }

    public static final /* synthetic */ TrieNode access$getEMPTY$cp() {
        return EMPTY;
    }

    private final TrieNode<E> addElementAt(int r5, E r10) {
        int r11 = indexOfCellAt$runtime_release(r5);
        Object[] r12 = TrieNodeKt.access$addElementAtIndex(this.buffer, r11, r10);
        return new TrieNode(this.bitmap | r5, r12);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) goto L5;
        Object[] r5 = this.buffer;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= r10) goto L13;
        Object r13 = r5[r11];
        if ((r13 instanceof TrieNode) == false) goto L11;
        int r14 = ((TrieNode) r13).calculateSize();
    L12:
        r12 = r12 + r14;
        r11 = r11 + 1;
        goto L7
    L11:
        r14 = 1;
        goto L12
    L13:
        return r12;
    L5:
        return this.buffer.length;
    }

    private final TrieNode<E> collisionAdd(E r5) {
        if (collisionContainsElement(r5) == false) goto L6;
        return this;
    L6:
        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r5));
    }

    private final boolean collisionContainsElement(E r5) {
        return ArraysKt.contains(this.buffer, r5);
    }

    private final TrieNode<E> collisionRemove(E r5) {
        int r10 = ArraysKt.indexOf(this.buffer, r5);
        if (r10 != (-1)) goto L5;
        return this;
    L5:
        return collisionRemoveElementAtIndex(r10);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int r5) {
        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, r5));
    }

    private final E elementAtIndex(int r5) {
        return (E) this.buffer[r5];
    }

    private final boolean elementsIdentityEquals(TrieNode<E> r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (this.bitmap == r10.bitmap) goto L8;
        return false;
    L8:
        int r5 = this.buffer.length;
        int r11 = 0;
    L9:
        if (r11 >= r5) goto L14;
        if (this.buffer[r11] != r10.buffer[r11]) goto L12;
        r11 = r11 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }

    private final boolean hasNoCellAt(int r5) {
        if ((this.bitmap & r5) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final TrieNode<E> makeNode(int r11, E r12, int r13, E r14, int r15, MutabilityOwnership r16) {
        if (r15 > 30) goto L5;
        int r10 = TrieNodeKt.indexSegment(r11, r15);
        int r17 = TrieNodeKt.indexSegment(r13, r15);
        if (r10 == r17) goto L15;
        if (r10 >= r17) goto L11;
        Object[] r5 = {r12, r14};
    L13:
        return new TrieNode((1 << r10) | (1 << r17), r5, r16);
    L11:
        r5 = new Object[]{r14, r12};
        goto L13
    L15:
        return new TrieNode(1 << r10, new Object[]{makeNode(r11, r12, r13, r14, r15 + 5, r16)}, r16);
    L5:
        return new TrieNode(0, new Object[]{r12, r14}, r16);
    }

    private final TrieNode<E> makeNodeAtIndex(int r10, int r11, E r12, int r13, MutabilityOwnership r14) {
        E r5 = elementAtIndex(r10);
        if (r5 == null) goto L6;
        int r15 = r5.hashCode();
    L8:
        return makeNode(r15, r5, r11, r12, r13 + 5, r14);
    L6:
        r15 = 0;
        goto L8
    }

    private final TrieNode<E> moveElementToNode(int r10, int r11, E r12, int r13) {
        Object[] r5 = this.buffer;
        Object[] r14 = Arrays.copyOf(r5, r5.length);
        r14[r10] = makeNodeAtIndex(r10, r11, r12, r13, null);
        return new TrieNode(this.bitmap, r14);
    }

    private final TrieNode<E> mutableAddElementAt(int r5, E r10, MutabilityOwnership r11) {
        int r12 = indexOfCellAt$runtime_release(r5);
        if (this.ownedBy != r11) goto L6;
        this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, r12, r10);
        this.bitmap = r5 | this.bitmap;
        return this;
    L6:
        Object[] r13 = TrieNodeKt.access$addElementAtIndex(this.buffer, r12, r10);
        return new TrieNode(this.bitmap | r5, r13, r11);
    }

    private final TrieNode<E> mutableCollisionAdd(E r5, PersistentHashSetBuilder<?> r10) {
        if (collisionContainsElement(r5) == false) goto L5;
        return this;
    L5:
        r10.setSize(r10.size() + 1);
        if (this.ownedBy != r10.getOwnership$runtime_release()) goto L10;
        this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r5);
        return this;
    L10:
        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r5), r10.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> r10, DeltaCounter r11, MutabilityOwnership r12) {
        if (this != r10) goto L5;
        r11.plusAssign(this.buffer.length);
        return this;
    L5:
        Object[] r5 = this.buffer;
        Object[] r13 = Arrays.copyOf(r5, r5.length + r10.buffer.length);
        Object[] r14 = r10.buffer;
        int r15 = this.buffer.length;
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r14.length) goto L20;
        boolean r18 = true;
        if (r17 > r16) goto L11;
        boolean r19 = true;
    L12:
        CommonFunctionsKt.m42assert(r19);
        if (collisionContainsElement(r14[r16]) == true) goto L19;
        r13[r15 + r17] = r14[r16];
        r17 = r17 + 1;
        if ((r15 + r17) <= r13.length) goto L18;
        r18 = false;
    L18:
        CommonFunctionsKt.m42assert(r18);
    L19:
        r16 = r16 + 1;
        goto L7
    L11:
        r19 = false;
        goto L12
    L20:
        int r20 = r17 + this.buffer.length;
        r11.plusAssign(r13.length - r20);
        if (r20 != this.buffer.length) goto L24;
        return this;
    L24:
        if (r20 != r10.buffer.length) goto L27;
        return r10;
    L27:
        if (r20 == r13.length) goto L31;
        r13 = Arrays.copyOf(r13, r20);
    L31:
        if (Intrinsics.areEqual(this.ownedBy, r12) == false) goto L34;
        this.buffer = r13;
        return this;
    L34:
        return new TrieNode(0, r13, r12);
    }

    private final TrieNode<E> mutableCollisionRemove(E r5, PersistentHashSetBuilder<?> r10) {
        int r11 = ArraysKt.indexOf(this.buffer, r5);
        if (r11 == (-1)) goto L6;
        r10.setSize(r10.size() - 1);
        return mutableCollisionRemoveElementAtIndex(r11, r10.getOwnership$runtime_release());
    L6:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRemoveAll(TrieNode<E> r10, DeltaCounter r11, MutabilityOwnership r12) {
        if (this != r10) goto L6;
        r11.plusAssign(this.buffer.length);
        return EMPTY;
    L6:
        if (Intrinsics.areEqual(r12, this.ownedBy) == false) goto L8;
        Object[] r5 = this.buffer;
    L9:
        Object[] r13 = this.buffer;
        int r14 = 0;
        int r15 = 0;
    L10:
        boolean r16 = true;
        if (r14 >= r13.length) goto L23;
        if (r15 > r14) goto L14;
        boolean r17 = true;
    L15:
        CommonFunctionsKt.m42assert(r17);
        if (r10.collisionContainsElement(r13[r14]) == true) goto L22;
        r5[r15] = r13[r14];
        r15 = r15 + 1;
        if (r15 <= r5.length) goto L21;
        r16 = false;
    L21:
        CommonFunctionsKt.m42assert(r16);
    L22:
        r14 = r14 + 1;
        goto L10
    L14:
        r17 = false;
        goto L15
    L23:
        r11.plusAssign(this.buffer.length - r15);
        if (r15 == 0) goto L39;
        if (r15 != 1) goto L29;
        return r5[0];
    L29:
        if (r15 != this.buffer.length) goto L32;
        return this;
    L32:
        if (r15 != r5.length) goto L35;
        return new TrieNode(0, r5, r12);
    L35:
        return new TrieNode(0, Arrays.copyOf(r5, r15), r12);
    L39:
        return EMPTY;
    L8:
        r5 = new Object[this.buffer.length];
        goto L9
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int r5, MutabilityOwnership r10) {
        if (this.ownedBy != r10) goto L7;
        this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, r5);
        return this;
    L7:
        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, r5), r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRetainAll(TrieNode<E> r10, DeltaCounter r11, MutabilityOwnership r12) {
        if (this != r10) goto L6;
        r11.plusAssign(this.buffer.length);
        return this;
    L6:
        if (Intrinsics.areEqual(r12, this.ownedBy) == false) goto L8;
        Object[] r5 = this.buffer;
    L9:
        Object[] r13 = this.buffer;
        int r14 = 0;
        int r15 = 0;
    L10:
        boolean r16 = true;
        if (r14 >= r13.length) goto L23;
        if (r15 > r14) goto L14;
        boolean r17 = true;
    L15:
        CommonFunctionsKt.m42assert(r17);
        if (r10.collisionContainsElement(r13[r14]) == false) goto L22;
        r5[r15] = r13[r14];
        r15 = r15 + 1;
        if (r15 <= r5.length) goto L21;
        r16 = false;
    L21:
        CommonFunctionsKt.m42assert(r16);
    L22:
        r14 = r14 + 1;
        goto L10
    L14:
        r17 = false;
        goto L15
    L23:
        r11.plusAssign(r15);
        if (r15 == 0) goto L42;
        if (r15 != 1) goto L29;
        return r5[0];
    L29:
        if (r15 != this.buffer.length) goto L32;
        return this;
    L32:
        if (r15 != r10.buffer.length) goto L35;
        return r10;
    L35:
        if (r15 != r5.length) goto L38;
        return new TrieNode(0, r5, r12);
    L38:
        return new TrieNode(0, Arrays.copyOf(r5, r15), r12);
    L42:
        return EMPTY;
    L8:
        r5 = new Object[Math.min(this.buffer.length, r10.buffer.length)];
        goto L9
    }

    private final TrieNode<E> mutableMoveElementToNode(int r5, int r10, E r11, int r12, MutabilityOwnership r13) {
        if (this.ownedBy != r13) goto L6;
        this.buffer[r5] = makeNodeAtIndex(r5, r10, r11, r12, r13);
        return this;
    L6:
        Object[] r14 = this.buffer;
        Object[] r15 = Arrays.copyOf(r14, r14.length);
        r15[r5] = makeNodeAtIndex(r5, r10, r11, r12, r13);
        return new TrieNode(this.bitmap, r15, r13);
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int r5, int r10, MutabilityOwnership r11) {
        if (this.ownedBy != r11) goto L7;
        this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, r5);
        this.bitmap ^= r10;
        return this;
    L7:
        return new TrieNode(this.bitmap ^ r10, TrieNodeKt.access$removeCellAtIndex(this.buffer, r5), r11);
    }

    private final TrieNode<E> mutableUpdateNodeAtIndex(int r5, TrieNode<E> r10, MutabilityOwnership r11) {
        Object[] r12 = r10.buffer;
        if (r12.length != 1) goto L12;
        Object r13 = r12[0];
        if ((r13 instanceof TrieNode) == true) goto L12;
        if (this.buffer.length != 1) goto L10;
        r10.bitmap = this.bitmap;
        return r10;
    L10:
        r10 = (TrieNode<E>) r13;
    L12:
        if (this.ownedBy != r11) goto L15;
        this.buffer[r5] = r10;
        return this;
    L15:
        Object[] r14 = this.buffer;
        Object[] r15 = Arrays.copyOf(r14, r14.length);
        r15[r5] = r10;
        return new TrieNode(this.bitmap, r15, r11);
    }

    private final TrieNode<E> nodeAtIndex(int r5) {
        Object r10 = this.buffer[r5];
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) r10;
    }

    private final TrieNode<E> removeCellAtIndex(int r5, int r10) {
        Object[] r11 = TrieNodeKt.access$removeCellAtIndex(this.buffer, r5);
        return new TrieNode(this.bitmap ^ r10, r11);
    }

    private final TrieNode<E> updateNodeAtIndex(int r5, TrieNode<E> r10) {
        Object[] r11 = r10.buffer;
        if (r11.length != 1) goto L11;
        Object r12 = r11[0];
        if ((r12 instanceof TrieNode) == true) goto L11;
        if (this.buffer.length != 1) goto L10;
        r10.bitmap = this.bitmap;
        return r10;
    L10:
        r10 = (TrieNode<E>) r12;
    L11:
        Object[] r13 = this.buffer;
        Object[] r14 = Arrays.copyOf(r13, r13.length);
        r14[r5] = r10;
        return new TrieNode(this.bitmap, r14);
    }

    public final TrieNode<E> add(int r5, E r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasNoCellAt(r12) == true) goto L5;
        int r13 = indexOfCellAt$runtime_release(r12);
        Object r14 = this.buffer[r13];
        if ((r14 instanceof TrieNode) == false) goto L17;
        TrieNode<E> r15 = nodeAtIndex(r13);
        if (r11 != 30) goto L11;
        TrieNode<E> r16 = r15.collisionAdd(r10);
    L12:
        if (r15 != r16) goto L15;
        return this;
    L15:
        return updateNodeAtIndex(r13, r16);
    L11:
        r16 = r15.add(r5, r10, r11 + 5);
        goto L12
    L17:
        if (Intrinsics.areEqual(r10, r14) == false) goto L20;
        return this;
    L20:
        return moveElementToNode(r13, r5, r10, r11);
    L5:
        return addElementAt(r12, r10);
    }

    public final boolean contains(int r5, E r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasNoCellAt(r12) == false) goto L6;
        return false;
    L6:
        int r13 = indexOfCellAt$runtime_release(r12);
        Object r14 = this.buffer[r13];
        if ((r14 instanceof TrieNode) == false) goto L15;
        TrieNode<E> r15 = nodeAtIndex(r13);
        if (r11 != 30) goto L13;
        return r15.collisionContainsElement(r10);
    L13:
        return r15.contains(r5, r10, r11 + 5);
    L15:
        return Intrinsics.areEqual(r10, r14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(TrieNode<E> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "otherNode");
        if (this != r10) goto L6;
        return true;
    L6:
        if (r11 <= 30) goto L14;
        Object[] r12 = r10.buffer;
        int r13 = r12.length;
        int r5 = 0;
    L8:
        if (r5 >= r13) goto L49;
        if (ArraysKt.contains(this.buffer, r12[r5]) == false) goto L13;
        r5 = r5 + 1;
        goto L8
    L13:
        return false;
    L49:
        return true;
    L14:
        int r14 = this.bitmap;
        int r15 = r10.bitmap;
        int r16 = r14 & r15;
        if (r16 == r15) goto L17;
        return false;
    L17:
        if (r16 == 0) goto L38;
        int r17 = Integer.lowestOneBit(r16);
        int r18 = indexOfCellAt$runtime_release(r17);
        int r19 = r10.indexOfCellAt$runtime_release(r17);
        Object r20 = this.buffer[r18];
        Object r21 = r10.buffer[r19];
        boolean r22 = r20 instanceof TrieNode;
        boolean r23 = r21 instanceof TrieNode;
        if (r22 == false) goto L24;
        if (r23 == false) goto L24;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
        if (((TrieNode) r20).containsAll((TrieNode) r21, r11 + 5) == true) goto L37;
        return false;
    L37:
        r16 = r16 ^ r17;
    L24:
        if (r22 == false) goto L32;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
        TrieNode r24 = (TrieNode) r20;
        if (r21 == null) goto L28;
        int r25 = r21.hashCode();
    L30:
        if (r24.contains(r25, r21, r11 + 5) == true) goto L37;
        return false;
    L28:
        r25 = 0;
        goto L30
    L32:
        if (r23 == true) goto L33;
        if (Intrinsics.areEqual(r20, r21) == true) goto L37;
        return false;
    L33:
        return false;
    L38:
        return true;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int r5) {
        return Integer.bitCount(this.bitmap & (r5 - 1));
    }

    public final TrieNode<E> mutableAdd(int r10, E r11, int r12, PersistentHashSetBuilder<?> r13) {
        Intrinsics.checkNotNullParameter(r13, "mutator");
        int r5 = 1 << TrieNodeKt.indexSegment(r10, r12);
        if (hasNoCellAt(r5) == false) goto L6;
        r13.setSize(r13.size() + 1);
        return mutableAddElementAt(r5, r11, r13.getOwnership$runtime_release());
    L6:
        int r14 = indexOfCellAt$runtime_release(r5);
        Object r15 = this.buffer[r14];
        if ((r15 instanceof TrieNode) == false) goto L17;
        TrieNode<E> r16 = nodeAtIndex(r14);
        if (r12 != 30) goto L11;
        TrieNode<E> r17 = r16.mutableCollisionAdd(r11, r13);
    L12:
        if (r16 != r17) goto L15;
        return this;
    L15:
        return mutableUpdateNodeAtIndex(r14, r17, r13.getOwnership$runtime_release());
    L11:
        r17 = r16.mutableAdd(r10, r11, r12 + 5, r13);
        goto L12
    L17:
        if (Intrinsics.areEqual(r11, r15) == false) goto L19;
        return this;
    L19:
        r13.setSize(r13.size() + 1);
        return mutableMoveElementToNode(r14, r10, r11, r12, r13.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TrieNode<E> mutableAddAll(TrieNode<E> r20, int r21, DeltaCounter r22, PersistentHashSetBuilder<?> r23) {
        Intrinsics.checkNotNullParameter(r20, "otherNode");
        Intrinsics.checkNotNullParameter(r22, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(r23, "mutator");
        if (this != r20) goto L7;
        r22.setCount(r22.getCount() + calculateSize());
        return this;
    L7:
        if (r21 > 30) goto L9;
        int r5 = this.bitmap;
        int r10 = r20.bitmap | r5;
        if (r10 == r5) goto L13;
    L15:
        TrieNode<E> r12 = new TrieNode(r10, new Object[Integer.bitCount(r10)], r23.getOwnership$runtime_release());
    L16:
        int r14 = r10;
        int r15 = 0;
    L17:
        if (r14 == 0) goto L60;
        int r11 = Integer.lowestOneBit(r14);
        int r13 = indexOfCellAt$runtime_release(r11);
        int r16 = r20.indexOfCellAt$runtime_release(r11);
        Object[] r17 = r12.buffer;
        if (hasNoCellAt(r11) == false) goto L23;
        Object r18 = r20.buffer[r16];
    L58:
        r17[r15] = r18;
        r15 = r15 + 1;
        r14 = r14 ^ r11;
        goto L17
    L23:
        if (r20.hasNoCellAt(r11) == false) goto L25;
        r18 = this.buffer[r13];
        goto L58
    L25:
        Object r19 = this.buffer[r13];
        Object r24 = r20.buffer[r16];
        boolean r25 = r19 instanceof TrieNode;
        boolean r26 = r24 instanceof TrieNode;
        if (r25 == false) goto L29;
        if (r26 == false) goto L29;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
        r18 = ((TrieNode) r19).mutableAddAll((TrieNode) r24, r21 + 5, r22, r23);
    L29:
        if (r25 == false) goto L39;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
        TrieNode r27 = (TrieNode) r19;
        int r28 = r23.size();
        if (r24 == null) goto L33;
        int r29 = r24.hashCode();
    L34:
        TrieNode r30 = r27.mutableAdd(r29, r24, r21 + 5, r23);
        if (r23.size() != r28) goto L37;
        r22.setCount(r22.getCount() + 1);
    L37:
        Unit r31 = Unit.INSTANCE;
    L38:
        r18 = r30;
        goto L58
    L33:
        r29 = 0;
        goto L34
    L39:
        if (r26 == false) goto L49;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
        TrieNode r32 = (TrieNode) r24;
        int r33 = r23.size();
        if (r19 == null) goto L43;
        int r34 = r19.hashCode();
    L44:
        r30 = r32.mutableAdd(r34, r19, r21 + 5, r23);
        if (r23.size() != r33) goto L47;
        r22.setCount(r22.getCount() + 1);
    L47:
        Unit r35 = Unit.INSTANCE;
        goto L38
    L43:
        r34 = 0;
        goto L44
    L49:
        if (Intrinsics.areEqual(r19, r24) == false) goto L51;
        r22.setCount(r22.getCount() + 1);
        Unit r36 = Unit.INSTANCE;
        r18 = r19;
        goto L58
    L51:
        if (r19 == null) goto L53;
        int r37 = r19.hashCode();
    L54:
        if (r24 == null) goto L56;
        int r38 = r24.hashCode();
    L57:
        r18 = makeNode(r37, r19, r38, r24, r21 + 5, r23.getOwnership$runtime_release());
        goto L58
    L56:
        r38 = 0;
        goto L57
    L53:
        r37 = 0;
        goto L54
    L60:
        if (elementsIdentityEquals(r12) == false) goto L63;
        return this;
    L63:
        if (r20.elementsIdentityEquals(r12) == true) goto L65;
        return r12;
    L65:
        return r20;
    L13:
        if (Intrinsics.areEqual(this.ownedBy, r23.getOwnership$runtime_release()) == false) goto L15;
        r12 = this;
        goto L16
    L9:
        return mutableCollisionAddAll(r20, r22, r23.getOwnership$runtime_release());
    }

    public final TrieNode<E> mutableRemove(int r5, E r10, int r11, PersistentHashSetBuilder<?> r12) {
        Intrinsics.checkNotNullParameter(r12, "mutator");
        int r13 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasNoCellAt(r13) == false) goto L5;
        return this;
    L5:
        int r14 = indexOfCellAt$runtime_release(r13);
        Object r15 = this.buffer[r14];
        if ((r15 instanceof TrieNode) == false) goto L19;
        TrieNode<E> r16 = nodeAtIndex(r14);
        if (r11 != 30) goto L10;
        TrieNode<E> r17 = r16.mutableCollisionRemove(r10, r12);
    L12:
        if (this.ownedBy == r12.getOwnership$runtime_release()) goto L17;
        if (r16 != r17) goto L17;
        return this;
    L17:
        return mutableUpdateNodeAtIndex(r14, r17, r12.getOwnership$runtime_release());
    L10:
        r17 = r16.mutableRemove(r5, r10, r11 + 5, r12);
        goto L12
    L19:
        if (Intrinsics.areEqual(r10, r15) == false) goto L22;
        r12.setSize(r12.size() - 1);
        return mutableRemoveCellAtIndex(r14, r13, r12.getOwnership$runtime_release());
    L22:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRemoveAll(TrieNode<E> r17, int r18, DeltaCounter r19, PersistentHashSetBuilder<?> r20) {
        Intrinsics.checkNotNullParameter(r17, "otherNode");
        Intrinsics.checkNotNullParameter(r19, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(r20, "mutator");
        if (this != r17) goto L7;
        r19.plusAssign(calculateSize());
        return EMPTY;
    L7:
        if (r18 > 30) goto L9;
        int r5 = this.bitmap & r17.bitmap;
        if (r5 != 0) goto L14;
        return this;
    L14:
        if (Intrinsics.areEqual(this.ownedBy, r20.getOwnership$runtime_release()) == false) goto L16;
        TrieNode<E> r10 = this;
    L17:
        int r11 = this.bitmap;
    L18:
        if (r5 == 0) goto L52;
        int r12 = Integer.lowestOneBit(r5);
        int r13 = indexOfCellAt$runtime_release(r12);
        int r14 = r17.indexOfCellAt$runtime_release(r12);
        Object r15 = this.buffer[r13];
        Object r16 = r17.buffer[r14];
        boolean r110 = r15 instanceof TrieNode;
        boolean r111 = r16 instanceof TrieNode;
        if (r110 == false) goto L23;
        if (r111 == false) goto L23;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
        r15 = ((TrieNode) r15).mutableRemoveAll((TrieNode) r16, r18 + 5, r19, r20);
    L49:
        if (r15 != EMPTY) goto L51;
        r11 = r11 ^ r12;
    L51:
        r10.buffer[r13] = r15;
        r5 = r5 ^ r12;
    L23:
        if (r110 == false) goto L37;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
        TrieNode r21 = (TrieNode) r15;
        int r112 = r20.size();
        if (r16 == null) goto L27;
        int r113 = r16.hashCode();
    L28:
        TrieNode r22 = r21.mutableRemove(r113, r16, r18 + 5, r20);
        if (r112 == r20.size()) goto L49;
        r19.plusAssign(1);
        Object[] r114 = r22.buffer;
        if (r114.length != 1) goto L35;
        r15 = r114[0];
        if ((r15 instanceof TrieNode) == false) goto L49;
    L35:
        r15 = r22;
        goto L49
    L27:
        r113 = 0;
        goto L28
    L37:
        if (r111 == false) goto L46;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
        TrieNode r115 = (TrieNode) r16;
        if (r15 == null) goto L41;
        int r23 = r15.hashCode();
    L43:
        if (r115.contains(r23, r15, r18 + 5) == false) goto L49;
        r19.plusAssign(1);
        r15 = EMPTY;
        goto L49
    L41:
        r23 = 0;
        goto L43
    L46:
        if (Intrinsics.areEqual(r15, r16) == false) goto L49;
        r19.plusAssign(1);
        r15 = EMPTY;
        goto L49
    L52:
        int r24 = Integer.bitCount(r11);
        if (r11 != 0) goto L56;
        return EMPTY;
    L56:
        if (r11 != this.bitmap) goto L62;
        if (r10.elementsIdentityEquals(this) == false) goto L90;
        return this;
    L90:
        return r10;
    L62:
        if (r24 != 1) goto L67;
        if (r18 == 0) goto L67;
        Object r25 = r10.buffer[r10.indexOfCellAt$runtime_release(r11)];
        if ((r25 instanceof TrieNode) == true) goto L92;
        return r25;
    L92:
        return new TrieNode(r11, new Object[]{r25}, r20.getOwnership$runtime_release());
    L67:
        Object[] r26 = new Object[r24];
        Object[] r27 = r10.buffer;
        int r28 = 0;
        int r29 = 0;
    L69:
        if (r28 >= r27.length) goto L82;
        if (r29 > r28) goto L72;
        boolean r30 = true;
    L73:
        CommonFunctionsKt.m42assert(r30);
        if (r27[r28] == Companion.getEMPTY$runtime_release()) goto L80;
        r26[r29] = r27[r28];
        r29 = r29 + 1;
        if (r29 > r24) goto L78;
        boolean r31 = true;
    L79:
        CommonFunctionsKt.m42assert(r31);
        goto L80
    L78:
        r31 = false;
    L80:
        r28 = r28 + 1;
        goto L69
    L72:
        r30 = false;
        goto L73
    L82:
        return new TrieNode(r11, r26, r20.getOwnership$runtime_release());
    L16:
        int r32 = this.bitmap;
        Object[] r33 = this.buffer;
        r10 = new TrieNode(r32, Arrays.copyOf(r33, r33.length), r20.getOwnership$runtime_release());
        goto L17
    L9:
        return mutableCollisionRemoveAll(r17, r19, r20.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRetainAll(TrieNode<E> r17, int r18, DeltaCounter r19, PersistentHashSetBuilder<?> r20) {
        TrieNode<E> r5 = r17;
        Intrinsics.checkNotNullParameter(r5, "otherNode");
        Intrinsics.checkNotNullParameter(r19, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(r20, "mutator");
        if (this != r5) goto L7;
        r19.plusAssign(calculateSize());
        return this;
    L7:
        if (r18 > 30) goto L9;
        int r10 = this.bitmap & r5.bitmap;
        if (r10 != 0) goto L15;
        return EMPTY;
    L15:
        if (Intrinsics.areEqual(this.ownedBy, r20.getOwnership$runtime_release()) == true) goto L17;
    L19:
        TrieNode<E> r11 = new TrieNode(r10, new Object[Integer.bitCount(r10)], r20.getOwnership$runtime_release());
    L20:
        int r12 = r10;
        int r13 = 0;
        int r14 = 0;
    L21:
        if (r12 == 0) goto L52;
        int r15 = Integer.lowestOneBit(r12);
        int r16 = indexOfCellAt$runtime_release(r15);
        int r110 = r5.indexOfCellAt$runtime_release(r15);
        Object r111 = this.buffer[r16];
        Object r112 = r5.buffer[r110];
        boolean r113 = r111 instanceof TrieNode;
        boolean r21 = r112 instanceof TrieNode;
        if (r113 == false) goto L26;
        if (r21 == false) goto L26;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
        r111 = ((TrieNode) r111).mutableRetainAll((TrieNode) r112, r18 + 5, r19, r20);
    L49:
        if (r111 == EMPTY) goto L51;
        r13 = r13 | r15;
    L51:
        r11.buffer[r14] = r111;
        r14 = r14 + 1;
        r12 = r12 ^ r15;
    L26:
        if (r113 == false) goto L35;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
        TrieNode r114 = (TrieNode) r111;
        if (r112 == null) goto L30;
        int r22 = r112.hashCode();
    L32:
        if (r114.contains(r22, r112, r18 + 5) == false) goto L34;
        r19.plusAssign(1);
        r111 = r112;
        goto L49
    L34:
        r111 = EMPTY;
        goto L49
    L30:
        r22 = 0;
        goto L32
    L35:
        if (r21 == false) goto L45;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
        TrieNode r115 = (TrieNode) r112;
        if (r111 == null) goto L39;
        int r23 = r111.hashCode();
    L41:
        if (r115.contains(r23, r111, r18 + 5) == false) goto L43;
        r19.plusAssign(1);
        goto L49
    L43:
        r111 = EMPTY;
        goto L49
    L39:
        r23 = 0;
        goto L41
    L45:
        if (Intrinsics.areEqual(r111, r112) == false) goto L47;
        r19.plusAssign(1);
        goto L49
    L47:
        r111 = EMPTY;
        goto L49
    L52:
        int r24 = Integer.bitCount(r13);
        if (r13 == 0) goto L84;
        if (r13 != r10) goto L64;
        if (r11.elementsIdentityEquals(this) == false) goto L60;
        return this;
    L60:
        if (r11.elementsIdentityEquals(r5) == false) goto L92;
    L91:
        return r5;
    L92:
        return r11;
    L64:
        if (r24 != 1) goto L69;
        if (r18 == 0) goto L69;
        Object r25 = r11.buffer[r11.indexOfCellAt$runtime_release(r13)];
        if ((r25 instanceof TrieNode) == false) goto L93;
        r5 = new TrieNode(r13, new Object[]{r25}, r20.getOwnership$runtime_release());
        goto L91
    L93:
        return r25;
    L69:
        Object[] r26 = new Object[r24];
        Object[] r27 = r11.buffer;
        int r28 = 0;
        int r29 = 0;
    L71:
        if (r28 >= r27.length) goto L83;
        if (r29 > r28) goto L74;
        boolean r30 = true;
    L75:
        CommonFunctionsKt.m42assert(r30);
        if (r27[r28] == Companion.getEMPTY$runtime_release()) goto L82;
        r26[r29] = r27[r28];
        r29 = r29 + 1;
        if (r29 > r24) goto L80;
        boolean r31 = true;
    L81:
        CommonFunctionsKt.m42assert(r31);
        goto L82
    L80:
        r31 = false;
    L82:
        r28 = r28 + 1;
        goto L71
    L74:
        r30 = false;
        goto L75
    L83:
        r5 = new TrieNode(r13, r26, r20.getOwnership$runtime_release());
        goto L91
    L84:
        return EMPTY;
    L17:
        if (r10 != this.bitmap) goto L19;
        r11 = this;
        goto L20
    L9:
        return mutableCollisionRetainAll(r5, r19, r20.getOwnership$runtime_release());
    }

    public final TrieNode<E> remove(int r5, E r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasNoCellAt(r12) == false) goto L5;
        return this;
    L5:
        int r13 = indexOfCellAt$runtime_release(r12);
        Object r14 = this.buffer[r13];
        if ((r14 instanceof TrieNode) == false) goto L16;
        TrieNode<E> r15 = nodeAtIndex(r13);
        if (r11 != 30) goto L10;
        TrieNode<E> r16 = r15.collisionRemove(r10);
    L11:
        if (r15 != r16) goto L14;
        return this;
    L14:
        return updateNodeAtIndex(r13, r16);
    L10:
        r16 = r15.remove(r5, r10, r11 + 5);
        goto L11
    L16:
        if (Intrinsics.areEqual(r10, r14) == true) goto L18;
        return this;
    L18:
        return removeCellAtIndex(r13, r12);
    }

    public final void setBitmap(int r5) {
        this.bitmap = r5;
    }

    public final void setBuffer(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.buffer = r5;
    }

    public final void setOwnedBy(MutabilityOwnership r5) {
        this.ownedBy = r5;
    }

    public TrieNode(int r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        this(r5, r10, null);
    }
}
