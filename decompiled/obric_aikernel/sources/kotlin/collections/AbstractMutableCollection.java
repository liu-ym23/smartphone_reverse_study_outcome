package kotlin.collections;

import java.util.Collection;
import kotlin.SinceKotlin;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMutableCollection] */
/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableCollection<E> extends java.util.AbstractCollection<E> implements Collection<E> {
    protected AbstractMutableCollection() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E r10);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
