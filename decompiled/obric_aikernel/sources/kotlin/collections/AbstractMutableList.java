package kotlin.collections;

import java.util.List;
import kotlin.SinceKotlin;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMutableList] */
/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements List<E> {
    protected AbstractMutableList() {
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int r10, E r11);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r10) {
        return removeAt(r10);
    }

    public abstract E removeAt(int r10);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int r10, E r11);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
