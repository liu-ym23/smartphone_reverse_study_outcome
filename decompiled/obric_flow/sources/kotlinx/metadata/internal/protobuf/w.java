package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f19211c;

    public w(x r5) {
        this.f19211c = r5;
        this.f19209a = 0;
        this.f19210b = r5.f19212b.length;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f19209a >= this.f19210b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        return Byte.valueOf(nextByte());
    }

    public final byte nextByte() {
        byte[] r5 = this.f19211c.f19212b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r10 = this.f19209a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f19209a = r10 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r5[r10];
    L4:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
