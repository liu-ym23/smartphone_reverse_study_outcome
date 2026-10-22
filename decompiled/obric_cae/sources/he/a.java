package he;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f8049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8050b;

    public a(T[] r8) {
        i.f(r8, "array");
        this.f8049a = r8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8050b >= this.f8049a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T[] r8 = this.f8049a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r10 = this.f8050b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f8050b = r10 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r8[r10];
    L4:
        e = move-exception;
        this.f8050b--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
