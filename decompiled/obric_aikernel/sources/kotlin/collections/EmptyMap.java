package kotlin.collections;

import com.bytedance.crash.entity.EventBody;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
final class EmptyMap implements Map, Serializable, KMappedMarker {
    public static final EmptyMap INSTANCE = null;
    private static final long serialVersionUID = 8246714829545688274L;

    static {
        INSTANCE = new EmptyMap();
    }

    private EmptyMap() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof Void) == true) goto L7;
        return false;
    L7:
        return containsValue((Void) r10);
    }

    public boolean containsValue(Void r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object r10) {
        if ((r10 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Map) r10).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object r10) {
        return get(r10);
    }

    @Override // java.util.Map
    public Void get(Object r10) {
        return null;
    }

    public Set<Map.Entry> getEntries() {
        return EmptySet.INSTANCE;
    }

    public Set<Object> getKeys() {
        return EmptySet.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object r10, Void r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object r10) {
        return remove(r10);
    }

    @Override // java.util.Map
    public Void remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
