package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0096\u0002J\u0015\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010(\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010)\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "<set-?>", "", "modCount", "getModCount$runtime_release", "()I", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "size", "getSize", "setSize", "(I)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "build", "clear", "", "contains", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    private int modCount;
    private TrieNode<E> node;
    private MutabilityOwnership ownership;
    private PersistentHashSet<E> set;
    private int size;

    public PersistentHashSetBuilder(PersistentHashSet<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "set");
        this.set = r5;
        this.ownership = new MutabilityOwnership();
        this.node = this.set.getNode$runtime_release();
        this.size = this.set.size();
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r5) {
        int r10 = size();
        TrieNode<E> r11 = this.node;
        if (r5 == null) goto L5;
        int r12 = r5.hashCode();
    L6:
        this.node = r11.mutableAdd(r12, r5, 0, this);
        if (r10 == size()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if ((r10 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r5 = (PersistentHashSet) r10;
    L6:
        if (r5 == null) goto L8;
    L14:
        if (r5 == null) goto L23;
        DeltaCounter r11 = new DeltaCounter(0, 1, null);
        int r12 = size();
        TrieNode<E> r13 = this.node.mutableAddAll(r5.getNode$runtime_release(), 0, r11, this);
        int r14 = (r10.size() + r12) - r11.getCount();
        if (r12 == r14) goto L19;
        this.node = r13;
        setSize(r14);
    L19:
        if (r12 != size()) goto L21;
        return false;
    L21:
        return true;
    L23:
        return super.addAll(r10);
    L8:
        if ((r10 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r15 = (PersistentHashSetBuilder) r10;
    L11:
        if (r15 == null) goto L13;
        r5 = r15.build();
        goto L14
    L13:
        r5 = null;
        goto L14
    L10:
        r15 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentCollection build() {
        return build();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        TrieNode<E> r5 = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = r5;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        TrieNode<E> r10 = this.node;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L7:
        return r10.contains(r11, r5, 0);
    L5:
        r11 = 0;
        goto L7
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        if ((r5 instanceof PersistentHashSet) == false) goto L7;
        return this.node.containsAll(((PersistentHashSet) r5).getNode$runtime_release(), 0);
    L7:
        if ((r5 instanceof PersistentHashSetBuilder) == false) goto L11;
        return this.node.containsAll(((PersistentHashSetBuilder) r5).node, 0);
    L11:
        return super.containsAll(r5);
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    public final TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r5) {
        int r10 = size();
        TrieNode<E> r11 = this.node;
        if (r5 == null) goto L5;
        int r12 = r5.hashCode();
    L6:
        this.node = r11.mutableRemove(r12, r5, 0, this);
        if (r10 == size()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if ((r10 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r5 = (PersistentHashSet) r10;
    L6:
        if (r5 == null) goto L8;
    L14:
        if (r5 == null) goto L25;
        DeltaCounter r11 = new DeltaCounter(0, 1, null);
        int r12 = size();
        Object r13 = this.node.mutableRemoveAll(r5.getNode$runtime_release(), 0, r11, this);
        int r14 = r12 - r11.getCount();
        if (r14 != 0) goto L18;
        clear();
    L21:
        if (r12 != size()) goto L23;
        return false;
    L23:
        return true;
    L18:
        if (r14 == r12) goto L21;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = (TrieNode) r13;
        setSize(r14);
        goto L21
    L25:
        return super.removeAll(r10);
    L8:
        if ((r10 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r15 = (PersistentHashSetBuilder) r10;
    L11:
        if (r15 == null) goto L13;
        r5 = r15.build();
        goto L14
    L13:
        r5 = null;
        goto L14
    L10:
        r15 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if ((r10 instanceof PersistentHashSet) == false) goto L5;
        PersistentHashSet<E> r5 = (PersistentHashSet) r10;
    L6:
        if (r5 == null) goto L8;
    L14:
        if (r5 == null) goto L25;
        DeltaCounter r11 = new DeltaCounter(0, 1, null);
        int r12 = size();
        Object r13 = this.node.mutableRetainAll(r5.getNode$runtime_release(), 0, r11, this);
        int r14 = r11.getCount();
        if (r14 != 0) goto L18;
        clear();
    L21:
        if (r12 != size()) goto L23;
        return false;
    L23:
        return true;
    L18:
        if (r14 == r12) goto L21;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = (TrieNode) r13;
        setSize(r14);
        goto L21
    L25:
        return super.retainAll(r10);
    L8:
        if ((r10 instanceof PersistentHashSetBuilder) == false) goto L10;
        PersistentHashSetBuilder r15 = (PersistentHashSetBuilder) r10;
    L11:
        if (r15 == null) goto L13;
        r5 = r15.build();
        goto L14
    L13:
        r5 = null;
        goto L14
    L10:
        r15 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    public void setSize(int r5) {
        this.size = r5;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentSet build() {
        return build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentHashSet<E> build() {
        if (this.node != this.set.getNode$runtime_release()) goto L5;
        PersistentHashSet<E> r5 = this.set;
    L6:
        this.set = r5;
        return r5;
    L5:
        this.ownership = new MutabilityOwnership();
        r5 = new PersistentHashSet(this.node, size());
        goto L6
    }
}
