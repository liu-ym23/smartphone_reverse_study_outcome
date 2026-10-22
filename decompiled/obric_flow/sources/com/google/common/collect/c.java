package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractBiMap f8914c;

    public c(AbstractBiMap r5, int r10) {
        this.f8912a = r10;
        switch(r10) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f8914c = r5;
        this.f8913b = AbstractBiMap.access$100(r5).entrySet();
        return;
    L6:
        this.f8914c = r5;
        this.f8913b = r5.inverse.keySet();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public void clear() {
        switch(this.f8912a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.clear();
        return;
    L6:
        this.f8914c.clear();
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.contains(r5);
    L7:
        if ((r5 instanceof Map.Entry) == true) goto L9;
        return false;
    L9:
        Map.Entry r10 = (Map.Entry) r5;
        r10.getClass();
        e7 r11 = new e7(r10);
        return this.f8913b.contains(r11);
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public boolean containsAll(Collection r5) {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.containsAll(r5);
    L7:
        return standardContainsAll(r5);
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.z2
    public final Object delegate() {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8913b;
    L7:
        return this.f8913b;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new q0(this.f8914c.entrySet().iterator(), 1);
    L7:
        return this.f8914c.entrySetIterator();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean remove(Object r5) {
        switch(this.f8912a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Set r10 = this.f8913b;
        if (r10.contains(r5) == true) goto L9;
    L12:
        return false;
    L9:
        if ((r5 instanceof Map.Entry) == false) goto L12;
        Map.Entry r11 = (Map.Entry) r5;
        AbstractBiMap.access$100(this.f8914c.inverse).remove(r11.getValue());
        r10.remove(r11);
        return true;
    L5:
        return super.remove(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean removeAll(Collection r5) {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.removeAll(r5);
    L7:
        return standardRemoveAll(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public boolean retainAll(Collection r5) {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.retainAll(r5);
    L7:
        return standardRetainAll(r5);
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public final Object[] toArray() {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return standardToArray();
    L7:
        return standardToArray();
    }

    @Override // com.google.common.collect.z2
    public String toString() {
        switch(this.f8912a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return standardToString();
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public final Collection delegate() {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8913b;
    L7:
        return this.f8913b;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r5) {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return standardToArray(r5);
    L7:
        return standardToArray(r5);
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public final Set delegate() {
        switch(this.f8912a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8913b;
    L7:
        return this.f8913b;
    }
}
