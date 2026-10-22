package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(KClass<? extends K> r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            this.key = r10;
            this.id = r11;
        }

        protected final T extractValue(AbstractArrayMapOwner<K, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            return r10.getArrayMap().get(this.id);
        }
    }

    public AbstractArrayMapOwner() {
    }

    protected abstract ArrayMap<V> getArrayMap();

    protected abstract TypeRegistry<K, V> getTypeRegistry();

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

    protected abstract void registerComponent(KClass<? extends K> r10, V r11);
}
