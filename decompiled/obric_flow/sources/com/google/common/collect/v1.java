package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9192c;
    public final /* synthetic */ CompactHashMap d;
    public final /* synthetic */ int e;
    public final /* synthetic */ CompactHashMap f;

    public v1(CompactHashMap r5, int r10) {
        this.e = r10;
        this.f = r5;
        this.d = r5;
        this.f9190a = CompactHashMap.access$000(r5);
        this.f9191b = r5.firstEntryIndex();
        this.f9192c = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9191b < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        CompactHashMap r5 = this.d;
        if (CompactHashMap.access$000(r5) != this.f9190a) goto L16;
        if (hasNext() == false) goto L14;
        int r10 = this.f9191b;
        this.f9192c = r10;
        switch(this.e) {
            case 0: goto L10;
            case 1: goto L9;
            default: goto L8;
        };
    L8:
        Object r11 = CompactHashMap.access$800(this.f, r10);
    L11:
        this.f9191b = r5.getSuccessor(this.f9191b);
        return r11;
    L9:
        r11 = new x1(this.f, r10);
        goto L11
    L10:
        r11 = CompactHashMap.access$100(this.f, r10);
        goto L11
    L14:
        throw new NoSuchElementException();
    L16:
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        CompactHashMap r5 = this.d;
        if (CompactHashMap.access$000(r5) != this.f9190a) goto L11;
        if (this.f9192c < 0) goto L7;
        boolean r10 = true;
    L8:
        p7.t(r10);
        this.f9190a += 32;
        r5.remove(CompactHashMap.access$100(r5, this.f9192c));
        this.f9191b = r5.adjustAfterRemove(this.f9191b, this.f9192c);
        this.f9192c = -1;
        return;
    L7:
        r10 = false;
        goto L8
    L11:
        throw new ConcurrentModificationException();
    }
}
