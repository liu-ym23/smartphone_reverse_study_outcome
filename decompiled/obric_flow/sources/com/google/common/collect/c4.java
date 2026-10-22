package com.google.common.collect;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c4 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga f8918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ga f8920c;

    public c4(ImmutableMultimap r5) {
        this.f8918a = r5.map.entrySet().iterator();
        this.f8919b = null;
        this.f8920c = g5.d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8920c.hasNext() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f8918a.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8920c.hasNext() == true) goto L5;
        Map.Entry r5 = (Map.Entry) this.f8918a.next();
        this.f8919b = r5.getKey();
        this.f8920c = ((ImmutableCollection) r5.getValue()).iterator();
    L5:
        Object r10 = this.f8919b;
        Objects.requireNonNull(r10);
        return new ImmutableEntry(r10, this.f8920c.next());
    }
}
