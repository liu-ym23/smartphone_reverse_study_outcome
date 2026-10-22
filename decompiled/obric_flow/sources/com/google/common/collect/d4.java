package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class d4 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga f8934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ga f8935b;

    public d4(ImmutableMultimap r5) {
        this.f8934a = r5.map.values().iterator();
        this.f8935b = g5.d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8935b.hasNext() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f8934a.hasNext() == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8935b.hasNext() == true) goto L6;
        this.f8935b = ((ImmutableCollection) this.f8934a.next()).iterator();
    L6:
        return this.f8935b.next();
    }
}
