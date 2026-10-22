package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class q5 extends AbstractSequentialList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedListMultimap f9133b;

    public q5(LinkedListMultimap r5, Object r10) {
        this.f9133b = r5;
        this.f9132a = r10;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int r5) {
        return new w5(this.f9133b, this.f9132a, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        t5 r5 = (t5) LinkedListMultimap.access$500(this.f9133b).get(this.f9132a);
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.f9168c;
    }
}
