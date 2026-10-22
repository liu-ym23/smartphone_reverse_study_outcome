package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    private final MapBuilder<K, V> backing;

    public MapBuilderEntries(MapBuilder<K, V> r10) {
        Intrinsics.checkNotNullParameter(r10, "backing");
        this.backing = r10;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        return add((Map.Entry) r10);
    }

    public boolean add(Map.Entry<K, V> r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return this.backing.containsAllEntries$kotlin_stdlib(r10);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return this.backing.containsEntry$kotlin_stdlib(r10);
    }

    public final MapBuilder<K, V> getBacking() {
        return this.backing;
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
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.backing.entriesIterator$kotlin_stdlib();
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public boolean remove(Map.Entry r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return this.backing.removeEntry$kotlin_stdlib(r10);
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
