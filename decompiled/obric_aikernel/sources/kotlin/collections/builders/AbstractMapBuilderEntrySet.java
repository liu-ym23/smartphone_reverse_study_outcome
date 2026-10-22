package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    public AbstractMapBuilderEntrySet() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r10);
    }

    public final boolean contains(E r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return containsEntry(r10);
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> r10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object r10) {
        if ((r10 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) r10);
    }

    public /* bridge */ boolean remove(Map.Entry<?, ?> r10) {
        return super.remove(r10);
    }
}
