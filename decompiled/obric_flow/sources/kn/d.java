package kn;

import com.lynx.tasm.common.NullableConcurrentHashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f18690a;

    public d(Set r5) {
        this.f18690a = r5;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object r5) {
        Set r10 = this.f18690a;
        return r10.add((Map.Entry) r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection r5) {
        return this.f18690a.addAll(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f18690a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object r5) {
        if (r5 != null) goto L5;
        r5 = NullableConcurrentHashMap.f10824a;
    L5:
        return this.f18690a.contains(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection r5) {
        return this.f18690a.containsAll(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f18690a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new qm.e(this.f18690a.iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object r5) {
        return this.f18690a.remove(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection r5) {
        return this.f18690a.retainAll(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection r5) {
        return this.f18690a.retainAll(r5);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f18690a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        Object[] r5 = this.f18690a.toArray();
        int r10 = 0;
    L4:
        if (r10 >= r5.length) goto L9;
        if (r5[r10] != NullableConcurrentHashMap.f10824a) goto L8;
        r5[r10] = null;
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r5;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] r5) {
        return this.f18690a.toArray(r5);
    }
}
