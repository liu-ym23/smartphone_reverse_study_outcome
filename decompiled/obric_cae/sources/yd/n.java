package yd;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements Iterator<Integer> {
    public n() {
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
