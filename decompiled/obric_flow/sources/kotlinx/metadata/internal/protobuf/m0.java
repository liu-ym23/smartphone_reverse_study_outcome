package kotlinx.metadata.internal.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f19191a;

    public m0(g0 r5) {
        this.f19191a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        if (contains(r10) == true) goto L5;
        Comparable r11 = (Comparable) r10.getKey();
        Object r12 = r10.getValue();
        this.f19191a.f(r11, r12);
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f19191a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        Object r12 = this.f19191a.get(r11);
        Object r13 = r10.getValue();
        if (r12 == r13) goto L9;
        if (r12 != null) goto L6;
    L8:
        return false;
    L6:
        if (r12.equals(r13) == false) goto L8;
    L9:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new l0(this.f19191a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        Map.Entry r10 = (Map.Entry) r5;
        if (contains(r10) == false) goto L6;
        this.f19191a.remove(r10.getKey());
        return true;
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19191a.size();
    }
}
