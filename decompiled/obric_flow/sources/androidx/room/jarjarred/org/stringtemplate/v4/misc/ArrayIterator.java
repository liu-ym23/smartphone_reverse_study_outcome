package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class ArrayIterator implements Iterator<Object> {
    protected Object array;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f681i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f682n;

    public ArrayIterator(Object r5) {
        this.f681i = -1;
        this.array = r5;
        this.f682n = Array.getLength(r5);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int r5 = this.f681i + 1;
        int r10 = this.f682n;
        if (r5 >= r10) goto L6;
        if (r10 <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        int r5 = this.f681i + 1;
        this.f681i = r5;
        if (r5 >= this.f682n) goto L7;
        return Array.get(this.array, r5);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
