package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class m5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMultimap.ValueEntry f9073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMultimap.ValueEntry f9074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMultimap f9075c;

    public m5(LinkedHashMultimap r5) {
        this.f9075c = r5;
        this.f9073a = LinkedHashMultimap.access$300(r5).getSuccessorInMultimap();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9073a == LinkedHashMultimap.access$300(this.f9075c)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        LinkedHashMultimap.ValueEntry r5 = this.f9073a;
        this.f9074b = r5;
        this.f9073a = r5.getSuccessorInMultimap();
        return r5;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f9074b == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        Object r10 = this.f9074b.getKey();
        Object r11 = this.f9074b.getValue();
        this.f9075c.remove(r10, r11);
        this.f9074b = null;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
