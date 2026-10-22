package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j6 extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9040a;

    public /* synthetic */ j6(int r5) {
        this.f9040a = r5;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection r5) {
        switch(this.f9040a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.removeAll(r5);
    L7:
        return p7.i0(this, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r5) {
        switch(this.f9040a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        r5.getClass();
        return super.retainAll(r5);
    L5:
        return super.retainAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch(this.f9040a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray();
    L7:
        return MapMakerInternalMap.access$900(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] r5) {
        switch(this.f9040a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toArray(r5);
    L7:
        return MapMakerInternalMap.access$900(this).toArray(r5);
    }
}
