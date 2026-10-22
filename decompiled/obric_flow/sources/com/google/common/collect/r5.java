package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class r5 extends AbstractSequentialList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedListMultimap f9148b;

    public /* synthetic */ r5(LinkedListMultimap r5, int r10) {
        this.f9147a = r10;
        this.f9148b = r5;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.f9147a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        r5.getClass();
        u5 r10 = LinkedListMultimap.access$200(this.f9148b);
    L7:
        if (r10 == null) goto L9;
        r5.accept(r10);
        r10 = r10.f9184c;
        goto L7
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int r5) {
        switch(this.f9147a) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        v5 r10 = new v5(this.f9148b, r5);
        return new z5(r10, r10);
    L7:
        return new v5(this.f9148b, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch(this.f9147a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return LinkedListMultimap.access$800(this.f9148b);
    L7:
        return LinkedListMultimap.access$800(this.f9148b);
    }
}
