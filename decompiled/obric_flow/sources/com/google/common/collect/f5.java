package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class f5 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8973b;

    public f5(Object r5) {
        this.f8973b = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f8972a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8972a == true) goto L7;
        this.f8972a = true;
        return this.f8973b;
    L7:
        throw new NoSuchElementException();
    }
}
