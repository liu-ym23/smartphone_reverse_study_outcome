package kotlin.collections.builders;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MapBuilder$ValuesItr<K, V> extends MapBuilder.Itr<K, V> implements Iterator<V>, KMutableIterator {
    @Override // java.util.Iterator
    public V next() {
        checkForComodification$kotlin_stdlib();
        if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) goto L7;
        int r0 = getIndex$kotlin_stdlib();
        setIndex$kotlin_stdlib(r0 + 1);
        setLastIndex$kotlin_stdlib(r0);
        Object[] r1 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
        Intrinsics.checkNotNull(r1);
        V r2 = (V) r1[getLastIndex$kotlin_stdlib()];
        initNext$kotlin_stdlib();
        return r2;
    L7:
        throw new NoSuchElementException();
    }

    public MapBuilder$ValuesItr(MapBuilder<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        super(r2);
    }
}
