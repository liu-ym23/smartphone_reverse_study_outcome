package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {
    public AbstractArrayMapOwner() {
    }

    public abstract ArrayMap<V> getArrayMap();

    public abstract TypeRegistry<K, V> getTypeRegistry();

    public abstract void registerComponent(String r1, V r2);

    public final boolean isEmpty() {
        if (getArrayMap().getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final void registerComponent(KClass<? extends K> r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "tClass");
        Intrinsics.checkNotNullParameter(r3, "value");
        String r4 = r2.getQualifiedName();
        Intrinsics.checkNotNull(r4);
        registerComponent(r4, r3);
    }
}
