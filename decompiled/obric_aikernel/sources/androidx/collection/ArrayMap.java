package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    @Nullable
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int r10) {
        super(r10);
    }

    public ArrayMap(SimpleArrayMap r10) {
        super(r10);
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new AnonymousClass1(this);
    L6:
        return this.mCollections;
    }

    public boolean containsAll(@NonNull Collection<?> r10) {
        return MapCollections.containsAllHelper(this, r10);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        ensureCapacity(this.mSize + r10.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    public boolean removeAll(@NonNull Collection<?> r10) {
        return MapCollections.removeAllHelper(this, r10);
    }

    public boolean retainAll(@NonNull Collection<?> r10) {
        return MapCollections.retainAllHelper(this, r10);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }
}
