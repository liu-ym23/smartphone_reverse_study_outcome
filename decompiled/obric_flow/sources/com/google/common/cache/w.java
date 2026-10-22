package com.google.common.cache;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f8773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q0 f8775c;

    public w(q0 r5, int r10) {
        this.f8774b = r10;
        this.f8775c = r5;
        this.f8773a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f8773a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        switch(this.f8774b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8775c.containsKey(r5);
    L7:
        if ((r5 instanceof Map.Entry) == false) goto L20;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        if (r11 == null) goto L21;
        q0 r12 = this.f8775c;
        Object r13 = r12.get(r11);
        if (r13 != null) goto L15;
        return false;
    L15:
        if (r12.f.equivalent(r10.getValue(), r13) == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f8773a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch(this.f8774b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new u(this.f8775c, 1);
    L7:
        return new u(this.f8775c, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        switch(this.f8774b) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.f8775c.remove(r5) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        if ((r5 instanceof Map.Entry) == false) goto L21;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        if (r11 != null) goto L15;
        return false;
    L15:
        if (this.f8775c.remove(r11, r10.getValue()) == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate r5) {
        switch(this.f8774b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        r5.getClass();
        v r10 = new v(r5, 0);
        return this.f8775c.h(r10);
    L5:
        return super.removeIf(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f8773a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return q0.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r5) {
        return q0.a(this).toArray(r5);
    }
}
