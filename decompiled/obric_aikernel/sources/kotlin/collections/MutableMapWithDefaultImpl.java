package kotlin.collections;

import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n101#1:105,6\n*E\n"})
final class MutableMapWithDefaultImpl<K, V> implements MutableMapWithDefault<K, V> {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final Function1<K, V> f2default;
    private final Map<K, V> map;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableMapWithDefaultImpl(Map<K, V> r10, Function1<? super K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r11, DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
        this.map = r10;
        this.f2default = r11;
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        return getMap().containsKey(r10);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r10) {
        return getMap().containsValue(r10);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object r10) {
        return getMap().equals(r10);
    }

    @Override // java.util.Map
    public V get(Object r10) {
        return getMap().get(r10);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    public Set<K> getKeys() {
        return getMap().keySet();
    }

    @Override // kotlin.collections.MutableMapWithDefault, kotlin.collections.MapWithDefault
    public Map<K, V> getMap() {
        return this.map;
    }

    @Override // kotlin.collections.MapWithDefault
    public V getOrImplicitDefault(K r10) {
        Map<K, V> r11 = getMap();
        V r12 = r11.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        if (r11.containsKey(r10) == false) goto L7;
        return r12;
    L7:
        return this.f2default.invoke(r10);
    }

    public int getSize() {
        return getMap().size();
    }

    public Collection<V> getValues() {
        return getMap().values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K r10, V r11) {
        return getMap().put(r10, r11);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "from");
        getMap().putAll(r10);
    }

    @Override // java.util.Map
    public V remove(Object r10) {
        return getMap().remove(r10);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
