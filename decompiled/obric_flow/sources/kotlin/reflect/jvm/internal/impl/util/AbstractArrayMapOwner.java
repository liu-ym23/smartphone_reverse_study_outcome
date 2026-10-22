package kotlin.reflect.jvm.internal.impl.util;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f18760id;
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(KClass<? extends K> r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
            this.key = r5;
            this.f18760id = r10;
        }

        public final T extractValue(AbstractArrayMapOwner<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "thisRef");
            return r5.getArrayMap().get(this.f18760id);
        }
    }

    public AbstractArrayMapOwner() {
    }

    public abstract ArrayMap<V> getArrayMap();

    public abstract TypeRegistry<K, V> getTypeRegistry();

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

    public abstract void registerComponent(KClass<? extends K> r5, V r10);
}
