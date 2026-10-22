package yd;

import java.util.AbstractSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<E> extends AbstractSet<E> {
    public b() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
