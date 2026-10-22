package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f9046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Collection f9048c;
    public Iterator d;
    public final /* synthetic */ AbstractMapBasedMultimap e;
    public final /* synthetic */ int f;

    public k(AbstractMapBasedMultimap r5, int r10) {
        this.f = r10;
        this.e = r5;
        this.f9046a = AbstractMapBasedMultimap.access$000(r5).entrySet().iterator();
        this.f9047b = null;
        this.f9048c = null;
        this.d = Iterators$EmptyModifiableIterator.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9046a.hasNext() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.d.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.d.hasNext() == true) goto L5;
        Map.Entry r5 = (Map.Entry) this.f9046a.next();
        this.f9047b = r5.getKey();
        Collection r10 = (Collection) r5.getValue();
        this.f9048c = r10;
        this.d = r10.iterator();
    L5:
        Object r11 = this.f9047b;
        Object r12 = this.d.next();
        switch(this.f) {
            case 0: goto L9;
            default: goto L10;
        };
    L10:
        return r12;
    L9:
        return new ImmutableEntry(r11, r12);
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.d.remove();
        Collection r5 = this.f9048c;
        Objects.requireNonNull(r5);
        if (r5.isEmpty() == false) goto L5;
        this.f9046a.remove();
    L5:
        AbstractMapBasedMultimap.access$210(this.e);
    }
}
