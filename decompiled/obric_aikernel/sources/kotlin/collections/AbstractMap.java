package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
@SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1747#2,3:154\n1726#2,3:157\n288#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final Companion Companion = null;
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    @SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "e");
            if ((r11 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r12 = (Map.Entry) r11;
            if (Intrinsics.areEqual(r10.getKey(), r12.getKey()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r10.getValue(), r12.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> r10) {
            Intrinsics.checkNotNullParameter(r10, "e");
            Object r11 = r10.getKey();
            int r12 = 0;
            if (r11 == null) goto L5;
            int r13 = r11.hashCode();
        L6:
            Object r14 = r10.getValue();
            if (r14 == null) goto L10;
            r12 = r14.hashCode();
        L10:
            return r13 ^ r12;
        L5:
            r13 = 0;
            goto L6
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> r10) {
            Intrinsics.checkNotNullParameter(r10, "e");
            StringBuilder r11 = new StringBuilder();
            r11.append(r10.getKey());
            r11.append('=');
            r11.append(r10.getValue());
            return r11.toString();
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected AbstractMap() {
    }

    public static final /* synthetic */ String access$toString(AbstractMap r10, Map.Entry r11) {
        return r10.toString(r11);
    }

    private final Map.Entry<K, V> implFindEntry(K r10) {
        Iterator<T> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((Map.Entry) r12).getKey(), r10) == false) goto L4;
    L10:
        return (Map.Entry) r12;
    L8:
        r12 = null;
        goto L10
    }

    private final String toString(Object r10) {
        if (r10 != this) goto L5;
        return "(this Map)";
    L5:
        return String.valueOf(r10);
    }

    private final String toString(Map.Entry<? extends K, ? extends V> r10) {
        return toString(r10.getKey()) + '=' + toString(r10.getValue());
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Object r11 = r10.getKey();
        Object r12 = r10.getValue();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V r13 = get(r11);
        if (Intrinsics.areEqual(r12, r13) == true) goto L8;
        return false;
    L8:
        if (r13 != null) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        if (containsKey(r11) == true) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        if (implFindEntry(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r10) {
        Set<Map.Entry<K, V>> r11 = entrySet();
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((Map.Entry) r12.next()).getValue(), r10) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Map) == true) goto L8;
        return false;
    L8:
        Map r11 = (Map) r10;
        if (size() == r11.size()) goto L11;
        return false;
    L11:
        Set<Map.Entry<K, V>> r12 = r11.entrySet();
        if ((r12 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L27;
        if (containsEntry$kotlin_stdlib((Map.Entry) r13.next()) == true) goto L18;
        return false;
    L27:
        return true;
    L14:
        if (r12.isEmpty() == false) goto L16;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r10) {
        Map.Entry<K, V> r11 = implFindEntry(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getValue();
    }

    public abstract Set getEntries();

    public Set<K> getKeys() {
        if (this._keys != null) goto L5;
        this._keys = new AbstractMap$keys$1(this);
    L5:
        Set<? extends K> r10 = this._keys;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public int getSize() {
        return entrySet().size();
    }

    public Collection<V> getValues() {
        if (this._values != null) goto L5;
        this._values = new C03961(this);
    L5:
        Collection<? extends V> r10 = this._values;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K r10, V r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), ", ", "{", "}", 0, null, new AnonymousClass1(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
