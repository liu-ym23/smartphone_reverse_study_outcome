package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Unexpected interfaces in signature: [java.io.Serializable, kotlin.jvm.internal.markers.KMutableSet] */
/* JADX INFO: loaded from: classes2.dex */
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Set<E> {
    private static final Companion Companion = null;
    private static final SetBuilder Empty = null;
    private final MapBuilder<E, ?> backing;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        Empty = new SetBuilder(MapBuilder.Companion.getEmpty$kotlin_stdlib());
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int r10) {
        this(new MapBuilder(r10));
    }

    public SetBuilder(MapBuilder<E, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "backing");
        this.backing = r10;
    }

    private final Object writeReplace() {
        if (this.backing.isReadOnly$kotlin_stdlib() == false) goto L7;
        return new SerializedCollection(this, 1);
    L7:
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r10) {
        if (this.backing.addKey$kotlin_stdlib(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(r10);
    }

    public final Set<E> build() {
        this.backing.build();
        if (size() <= 0) goto L6;
        return this;
    L6:
        return Empty;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        return this.backing.containsKey(r10);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.backing.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r10) {
        if (this.backing.removeKey$kotlin_stdlib(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(r10);
    }
}
