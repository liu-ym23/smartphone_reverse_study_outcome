package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f6 extends j6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f8975c;

    public /* synthetic */ f6(MapMakerInternalMap r5, int r10) {
        this.f8974b = r10;
        this.f8975c = r5;
        super(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch(this.f8974b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f8975c.clear();
        return;
    L6:
        this.f8975c.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        switch(this.f8974b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8975c.containsKey(r5);
    L7:
        if ((r5 instanceof Map.Entry) == false) goto L20;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        if (r11 == null) goto L21;
        MapMakerInternalMap r12 = this.f8975c;
        Object r13 = r12.get(r11);
        if (r13 != null) goto L15;
        return false;
    L15:
        if (r12.valueEquivalence().equivalent(r10.getValue(), r13) == false) goto L19;
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
        switch(this.f8974b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8975c.isEmpty();
    L7:
        return this.f8975c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch(this.f8974b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new e6(this.f8975c, 1);
    L7:
        return new e6(this.f8975c, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        switch(this.f8974b) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (this.f8975c.remove(r5) == null) goto L7;
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
        if (this.f8975c.remove(r11, r10.getValue()) == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch(this.f8974b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8975c.size();
    L7:
        return this.f8975c.size();
    }
}
