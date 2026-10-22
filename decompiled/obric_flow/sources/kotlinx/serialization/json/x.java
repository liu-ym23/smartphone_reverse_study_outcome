package kotlinx.serialization.json;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@kotlinx.serialization.g(with = z.class)
public final class x extends l implements Map<String, l>, KMappedMarker {
    public static final w Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f19451a;

    static {
        Companion = new w();
    }

    public x(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        this.f19451a = r5;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l compute(String r5, BiFunction<? super String, ? super l, ? extends l> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l computeIfAbsent(String r5, Function<? super String, ? extends l> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l computeIfPresent(String r5, BiFunction<? super String, ? super l, ? extends l> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r5) {
        if ((r5 instanceof String) == true) goto L6;
        return false;
    L6:
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        return this.f19451a.containsKey(r10);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r5) {
        if ((r5 instanceof l) == true) goto L6;
        return false;
    L6:
        l r10 = (l) r5;
        Intrinsics.checkNotNullParameter(r10, "value");
        return this.f19451a.containsValue(r10);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, l>> entrySet() {
        return this.f19451a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object r5) {
        return Intrinsics.areEqual(this.f19451a, r5);
    }

    @Override // java.util.Map
    public final l get(Object r5) {
        if ((r5 instanceof String) == true) goto L6;
        return null;
    L6:
        String r10 = (String) r5;
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        return (l) this.f19451a.get(r10);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f19451a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f19451a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f19451a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l merge(String r5, l r10, BiFunction<? super l, ? super l, ? extends l> r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l put(String r5, l r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends l> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l putIfAbsent(String r5, l r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final l remove(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ l replace(String r5, l r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super l, ? extends l> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f19451a.size();
    }

    public final String toString() {
        return CollectionsKt.q(this.f19451a.entrySet(), ",", "{", "}", 0, null, JsonObject$toString$1.INSTANCE, 24);
    }

    @Override // java.util.Map
    public final Collection<l> values() {
        return this.f19451a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object r5, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String r5, l r10, l r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
