package kotlinx.metadata.internal.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.common.base.k f19151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f19152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19153c;

    public d0(f0 r5) {
        com.google.common.base.k r10 = new com.google.common.base.k(r5);
        this.f19151a = r10;
        this.f19152b = new w(r10.a());
        this.f19153c = r5.f19164b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f19153c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f19152b.hasNext() == true) goto L5;
        this.f19152b = new w(this.f19151a.a());
    L5:
        this.f19153c--;
        return Byte.valueOf(this.f19152b.nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
