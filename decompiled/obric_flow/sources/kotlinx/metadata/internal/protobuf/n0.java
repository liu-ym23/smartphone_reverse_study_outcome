package kotlinx.metadata.internal.protobuf;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListIterator f19194a;

    public n0(p0 r5, int r10) {
        this.f19194a = r5.f19202a.listIterator(r10);
    }

    @Override // java.util.ListIterator
    public final void add(Object r5) {
        String r10 = (String) r5;
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f19194a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f19194a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f19194a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f19194a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f19194a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f19194a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object r5) {
        String r10 = (String) r5;
        throw new UnsupportedOperationException();
    }
}
