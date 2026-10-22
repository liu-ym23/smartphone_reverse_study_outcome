package kotlin.collections;

import java.util.Set;
import kotlin.SinceKotlin;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMutableSet] */
/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableSet<E> extends java.util.AbstractSet<E> implements Set<E> {
    protected AbstractMutableSet() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E r10);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
