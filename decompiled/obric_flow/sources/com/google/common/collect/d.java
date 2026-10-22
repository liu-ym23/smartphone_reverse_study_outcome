package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8932b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f8931a = r10;
        this.f8932b = r5;
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public void clear() {
        switch(this.f8931a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.clear();
        return;
    L6:
        ((AbstractBiMap) this.f8932b).clear();
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.f8931a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.contains(r5);
    L7:
        if (r5 == null) goto L17;
        Set r10 = (Set) this.f8932b;
        r10.getClass();
        boolean r11 = r10.contains(r5);     // Catch: Throwable -> L11
    L12:
        if (r11 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r11 = false;
        goto L12
    L17:
        return false;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public boolean containsAll(Collection r5) {
        switch(this.f8931a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.containsAll(r5);
    L7:
        return standardContainsAll(r5);
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public final Set delegate() {
        switch(this.f8931a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ((MutableClassToInstanceMap) this.f8932b).delegate().entrySet();
    L7:
        return (Set) this.f8932b;
    L9:
        return AbstractBiMap.access$100((AbstractBiMap) this.f8932b).keySet();
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch(this.f8931a) {
            case 0: goto L9;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.iterator();
    L7:
        return new q0(delegate().iterator(), 4);
    L9:
        return new c7(((AbstractBiMap) this.f8932b).entrySet().iterator());
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean remove(Object r5) {
        switch(this.f8931a) {
            case 0: goto L16;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.remove(r5);
    L7:
        if (r5 == null) goto L22;
        Set r10 = (Set) this.f8932b;
        r10.getClass();
        boolean r11 = r10.remove(r5);     // Catch: Throwable -> L11
    L12:
        if (r11 == false) goto L23;
        return true;
    L23:
        return false;
    L11:
        r11 = false;
        goto L12
    L22:
        return false;
    L16:
        if (contains(r5) == true) goto L18;
        return false;
    L18:
        AbstractBiMap.access$200((AbstractBiMap) this.f8932b, r5);
        return true;
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean removeAll(Collection r5) {
        switch(this.f8931a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.removeAll(r5);
    L7:
        return standardRemoveAll(r5);
    L9:
        return standardRemoveAll(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean retainAll(Collection r5) {
        switch(this.f8931a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.retainAll(r5);
    L7:
        return standardRetainAll(r5);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator spliterator() {
        switch(this.f8931a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.spliterator();
    L7:
        return p7.R(delegate().spliterator(), new h(23));
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public Object[] toArray() {
        switch(this.f8931a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray();
    L7:
        return standardToArray();
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] r5) {
        switch(this.f8931a) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray(r5);
    L7:
        return standardToArray(r5);
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.z2
    public Object delegate() {
        switch(this.f8931a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.delegate();
    L7:
        return (Set) this.f8932b;
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public Collection delegate() {
        switch(this.f8931a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.delegate();
    L7:
        return (Set) this.f8932b;
    }
}
