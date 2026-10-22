package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z3 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ga f9243a;

    public z3(ga r5) {
        this.f9243a = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9243a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return new y3((Map.Entry) this.f9243a.next());
    }
}
