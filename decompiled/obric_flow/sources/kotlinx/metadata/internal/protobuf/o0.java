package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f19198a;

    public o0(p0 r5) {
        this.f19198a = r5.f19202a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19198a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f19198a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
