package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010+J\u001b\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001¢\u0006\u0002\u00100R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00140\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "", "firstKey", "getFirstKey$runtime_release", "()Ljava/lang/Object;", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "getHashMapBuilder$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "keys", "getKeys", "lastKey", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "clear", "", "containsKey", "", STGroup.DICT_KEY, "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    private Object firstKey;
    private final PersistentHashMapBuilder<K, LinkedValue<V>> hashMapBuilder;
    private Object lastKey;
    private PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapBuilder(PersistentOrderedMap<K, V> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        this.map = r5;
        this.firstKey = r5.getFirstKey$runtime_release();
        this.lastKey = this.map.getLastKey$runtime_release();
        this.hashMapBuilder = this.map.getHashMap$runtime_release().builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public PersistentMap<K, V> build() {
        PersistentHashMap<K, LinkedValue<V>> r5 = this.hashMapBuilder.build();
        if (r5 != this.map.getHashMap$runtime_release()) goto L12;
        boolean r10 = false;
        if (this.firstKey != this.map.getFirstKey$runtime_release()) goto L7;
        boolean r11 = true;
    L8:
        CommonFunctionsKt.m42assert(r11);
        if (this.lastKey != this.map.getLastKey$runtime_release()) goto L11;
        r10 = true;
    L11:
        CommonFunctionsKt.m42assert(r10);
        PersistentOrderedMap<K, V> r12 = this.map;
    L13:
        this.map = r12;
        return r12;
    L7:
        r11 = false;
        goto L8
    L12:
        r12 = new PersistentOrderedMap(this.firstKey, this.lastKey, r5);
        goto L13
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain r5 = EndOfChain.INSTANCE;
        this.firstKey = r5;
        this.lastKey = r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r5) {
        return this.hashMapBuilder.containsKey(r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r5) {
        LinkedValue<V> r10 = this.hashMapBuilder.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getValue();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    public final PersistentHashMapBuilder<K, LinkedValue<V>> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection<V> getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public V put(K r5, V r10) {
        LinkedValue<V> r11 = this.hashMapBuilder.get(r5);
        if (r11 == null) goto L10;
        if (r11.getValue() != r10) goto L7;
        return r10;
    L7:
        this.hashMapBuilder.put(r5, r11.withValue(r10));
        return r11.getValue();
    L10:
        if (isEmpty() == false) goto L13;
        this.firstKey = r5;
        this.lastKey = r5;
        this.hashMapBuilder.put(r5, new LinkedValue(r10));
        return null;
    L13:
        Object r12 = this.lastKey;
        LinkedValue<V> r13 = this.hashMapBuilder.get((K) r12);
        Intrinsics.checkNotNull(r13);
        LinkedValue<V> r14 = r13;
        CommonFunctionsKt.m42assert(!r14.getHasNext());
        this.hashMapBuilder.put((K) r12, r14.withNext(r5));
        this.hashMapBuilder.put(r5, new LinkedValue(r10, r12));
        this.lastKey = r5;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r5) {
        LinkedValue<V> r10 = this.hashMapBuilder.remove(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        if (r10.getHasPrevious() == false) goto L9;
        LinkedValue<V> r11 = this.hashMapBuilder.get(r10.getPrevious());
        Intrinsics.checkNotNull(r11);
        PersistentHashMapBuilder<K, LinkedValue<V>> r12 = this.hashMapBuilder;
        Object r13 = r10.getPrevious();
        K r14 = (K) r13;
        r12.put(r14, r11.withNext(r10.getNext()));
    L11:
        if (r10.getHasNext() == false) goto L13;
        LinkedValue<V> r15 = this.hashMapBuilder.get(r10.getNext());
        Intrinsics.checkNotNull(r15);
        PersistentHashMapBuilder<K, LinkedValue<V>> r16 = this.hashMapBuilder;
        Object r17 = r10.getNext();
        K r18 = (K) r17;
        r16.put(r18, r15.withPrevious(r10.getPrevious()));
    L15:
        return r10.getValue();
    L13:
        this.lastKey = r10.getPrevious();
        goto L15
    L9:
        this.firstKey = r10.getNext();
        goto L11
    }

    @Override // java.util.Map
    public final boolean remove(Object r5, Object r10) {
        LinkedValue<V> r11 = this.hashMapBuilder.get(r5);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r11.getValue(), r10) == false) goto L10;
        remove(r5);
        return true;
    L10:
        return false;
    }
}
