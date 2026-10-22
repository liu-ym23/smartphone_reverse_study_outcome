package kotlinx.metadata.internal.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends AbstractList implements v, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f19202a;

    public p0(u r5) {
        this.f19202a = r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final void a(x r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r5) {
        return (String) this.f19202a.get(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final e getByteString(int r5) {
        return this.f19202a.getByteString(r5);
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f19202a.f19208a);
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final p0 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new o0(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int r5) {
        return new n0(this, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19202a.size();
    }
}
