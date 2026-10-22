package yd;

import java.util.AbstractList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E> extends AbstractList<E> {
    public a() {
    }

    public abstract int a();

    public abstract E b(int r8);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r8) {
        return b(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
