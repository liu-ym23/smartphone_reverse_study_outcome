package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m3 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashBiMap.BiEntry f9069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashBiMap.BiEntry f9070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9071c;
    public int d;
    public final /* synthetic */ HashBiMap e;

    public m3(HashBiMap r5) {
        this.e = r5;
        this.f9069a = HashBiMap.access$000(r5);
        this.f9070b = null;
        this.f9071c = HashBiMap.access$100(r5);
        this.d = r5.size();
    }

    public abstract Object a(HashBiMap.BiEntry r5);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (HashBiMap.access$100(this.e) != this.f9071c) goto L12;
        if (this.f9069a != null) goto L7;
    L9:
        return false;
    L7:
        if (this.d <= 0) goto L9;
        return true;
    L12:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        HashBiMap.BiEntry r5 = this.f9069a;
        Objects.requireNonNull(r5);
        this.f9069a = r5.nextInKeyInsertionOrder;
        this.f9070b = r5;
        this.d--;
        return a(r5);
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        HashBiMap r5 = this.e;
        if (HashBiMap.access$100(r5) != this.f9071c) goto L11;
        HashBiMap.BiEntry r10 = this.f9070b;
        if (r10 == null) goto L9;
        HashBiMap.access$200(r5, r10);
        this.f9071c = HashBiMap.access$100(r5);
        this.f9070b = null;
        return;
    L9:
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    L11:
        throw new ConcurrentModificationException();
    }
}
