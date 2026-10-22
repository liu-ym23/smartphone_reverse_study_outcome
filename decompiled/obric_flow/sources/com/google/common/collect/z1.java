package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9242c;
    public final /* synthetic */ CompactHashSet d;

    public z1(CompactHashSet r5) {
        this.d = r5;
        this.f9240a = CompactHashSet.access$000(r5);
        this.f9241b = r5.firstEntryIndex();
        this.f9242c = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9241b < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        CompactHashSet r5 = this.d;
        if (CompactHashSet.access$000(r5) != this.f9240a) goto L11;
        if (hasNext() == false) goto L9;
        int r10 = this.f9241b;
        this.f9242c = r10;
        Object r11 = CompactHashSet.access$100(r5, r10);
        this.f9241b = r5.getSuccessor(this.f9241b);
        return r11;
    L9:
        throw new NoSuchElementException();
    L11:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        CompactHashSet r5 = this.d;
        if (CompactHashSet.access$000(r5) != this.f9240a) goto L11;
        if (this.f9242c < 0) goto L7;
        boolean r10 = true;
    L8:
        p7.t(r10);
        this.f9240a += 32;
        r5.remove(CompactHashSet.access$100(r5, this.f9242c));
        this.f9241b = r5.adjustAfterRemove(this.f9241b, this.f9242c);
        this.f9242c = -1;
        return;
    L7:
        r10 = false;
        goto L8
    L11:
        throw new ConcurrentModificationException();
    }
}
