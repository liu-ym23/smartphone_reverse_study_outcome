package org.codehaus.stax2.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class a<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f17985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17986b;

    @Deprecated
    public a(T r2) {
        this.f17986b = false;
        this.f17985a = r2;
    }

    public static <T> a<T> a(T r1) {
        return new a(r1);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f17986b;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f17986b == true) goto L7;
        this.f17986b = true;
        return this.f17985a;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can not remove item from SingletonIterator.");
    }
}
