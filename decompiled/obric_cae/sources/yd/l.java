package yd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Map, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14120a = null;

    static {
        f14120a = new l();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r8) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r8) {
        if ((r8 instanceof Void) == true) goto L5;
        return false;
    L5:
        he.i.f((Void) r8, "value");
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return m.f14121a;
    }

    @Override // java.util.Map
    public final boolean equals(Object r8) {
        if ((r8 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Map) r8).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r8) {
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return m.f14121a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object r8, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return k.f14119a;
    }
}
