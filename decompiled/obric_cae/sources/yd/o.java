package yd;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o implements Iterator<Long> {
    public o() {
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
