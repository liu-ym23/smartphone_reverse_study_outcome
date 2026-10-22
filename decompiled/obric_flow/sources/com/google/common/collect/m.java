package com.google.common.collect;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f9064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9065c;
    public Object d;

    public m(StandardTable r5) {
        this.f9063a = 3;
        this.f9064b = r5.backingMap.entrySet().iterator();
        this.d = Iterators$EmptyModifiableIterator.INSTANCE;
    }

    public void a() {
        u r5 = (u) this.d;
        r5.c();
        if (r5.f9173b != ((Collection) this.f9065c)) goto L6;
        return;
    L6:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f9063a) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L12;
            default: goto L5;
        };
    L12:
        a();
        return this.f9064b.hasNext();
    L5:
        if (this.f9064b.hasNext() == false) goto L7;
    L10:
        return true;
    L7:
        if (((Iterator) this.d).hasNext() == true) goto L10;
        return false;
    L15:
        return this.f9064b.hasNext();
    L17:
        return this.f9064b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f9063a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            default: goto L5;
        };
    L9:
        a();
        return this.f9064b.next();
    L11:
        Map.Entry r5 = (Map.Entry) this.f9064b.next();
        this.f9065c = r5;
        return r5.getKey();
    L13:
        Map.Entry r10 = (Map.Entry) this.f9064b.next();
        this.f9065c = (Collection) r10.getValue();
        return ((n) this.d).d(r10);
    L5:
        if (((Iterator) this.d).hasNext() == true) goto L7;
        Map.Entry r11 = (Map.Entry) this.f9064b.next();
        this.f9065c = r11;
        this.d = ((Map) r11.getValue()).entrySet().iterator();
    L7:
        Objects.requireNonNull((Map.Entry) this.f9065c);
        Map.Entry r12 = (Map.Entry) ((Iterator) this.d).next();
        return new Tables$ImmutableCell(((Map.Entry) this.f9065c).getKey(), r12.getKey(), r12.getValue());
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch(this.f9063a) {
            case 0: goto L17;
            case 1: goto L11;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        ((Iterator) this.d).remove();
        Map.Entry r5 = (Map.Entry) this.f9065c;
        Objects.requireNonNull(r5);
        if (((Map) r5.getValue()).isEmpty() == false) goto L22;
        this.f9064b.remove();
        this.f9065c = null;
        return;
    L22:
        return;
    L8:
        this.f9064b.remove();
        u r10 = (u) this.d;
        AbstractMapBasedMultimap.access$210(r10.e);
        r10.d();
        return;
    L11:
        if (((Map.Entry) this.f9065c) == null) goto L13;
        boolean r11 = true;
    L14:
        com.google.common.base.b0.u(r11, "no calls to next() since the last call to remove()");
        Collection r12 = (Collection) ((Map.Entry) this.f9065c).getValue();
        this.f9064b.remove();
        AbstractMapBasedMultimap.access$220((AbstractMapBasedMultimap) ((o) this.d).e, r12.size());
        r12.clear();
        this.f9065c = null;
        return;
    L13:
        r11 = false;
        goto L14
    L17:
        if (((Collection) this.f9065c) == null) goto L19;
        boolean r13 = true;
    L20:
        com.google.common.base.b0.u(r13, "no calls to next() since the last call to remove()");
        this.f9064b.remove();
        AbstractMapBasedMultimap.access$220(((n) this.d).e, ((Collection) this.f9065c).size());
        ((Collection) this.f9065c).clear();
        this.f9065c = null;
        return;
    L19:
        r13 = false;
        goto L20
    }

    public m(u r5) {
        this.f9063a = 2;
        this.d = r5;
        Collection r10 = r5.f9173b;
        this.f9065c = r10;
        this.f9064b = AbstractMapBasedMultimap.access$100(r10);
    }

    public m(u r5, Iterator r10) {
        this.f9063a = 2;
        this.d = r5;
        this.f9065c = r5.f9173b;
        this.f9064b = r10;
    }

    public m(o r5, Iterator r10) {
        this.f9063a = 1;
        this.d = r5;
        this.f9064b = r10;
    }

    public m(n r5) {
        this.f9063a = 0;
        this.d = r5;
        this.f9064b = r5.d.entrySet().iterator();
    }
}
