package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f8951a;

    public e0(g0 r5) {
        this.f8951a = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f8951a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L6;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        Object r12 = r10.getValue();
        return this.f8951a.containsEntry(r11, r12);
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f8951a.entryIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L6;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        Object r12 = r10.getValue();
        return this.f8951a.remove(r11, r12);
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f8951a.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return this.f8951a.entrySpliterator();
    }
}
