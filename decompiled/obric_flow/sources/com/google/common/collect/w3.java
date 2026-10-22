package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w3 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ga f9205a;

    public w3(ga r5) {
        this.f9205a = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9205a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f9205a.next()).getKey();
    }
}
