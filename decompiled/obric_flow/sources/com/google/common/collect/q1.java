package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 implements Spliterator, Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Spliterator f9127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Predicate f9128c;

    public q1(Spliterator r5, Predicate r10) {
        this.f9127b = r5;
        this.f9128c = r10;
        this.f9126a = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        this.f9126a = r5;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f9127b.characteristics() & 277;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.f9127b.estimateSize() / 2;
    }

    @Override // java.util.Spliterator
    public final Comparator getComparator() {
        return this.f9127b.getComparator();
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer r5) {
    L3:
        if (this.f9127b.tryAdvance(this) == false) goto L15;
        Object r10 = this.f9126a;     // Catch: Throwable -> L10
        if (this.f9128c.test(r10) == true) goto L7;
        this.f9126a = null;
        goto L3
    L7:
        r5.accept(r10);     // Catch: Throwable -> L10
        this.f9126a = null;
        return true;
    L10:
        th = move-exception;
        this.f9126a = null;
        throw th;
    L15:
        return false;
    }

    @Override // java.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator r5 = this.f9127b.trySplit();
        if (r5 != null) goto L5;
        return null;
    L5:
        Predicate r10 = this.f9128c;
        r10.getClass();
        return new q1(r5, r10);
    }
}
